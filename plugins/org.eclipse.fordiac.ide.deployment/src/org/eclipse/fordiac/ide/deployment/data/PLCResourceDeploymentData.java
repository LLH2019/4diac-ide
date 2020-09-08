/*******************************************************************************
 * Copyright (c) 2020 TU Wien/ACIN
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *
 * Contributors:
 *   Martin Melik Merkumians - initial API and implementation and/or initial documentation
 *******************************************************************************/

package org.eclipse.fordiac.ide.deployment.data;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Deque;
import java.util.List;
import java.util.stream.Collectors;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IFolder;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.fordiac.ide.model.dataimport.ProgramImporter;
import org.eclipse.fordiac.ide.model.iec61131.Program;
import org.eclipse.fordiac.ide.model.libraryElement.FBNetwork;
import org.eclipse.fordiac.ide.model.libraryElement.Resource;
import org.eclipse.fordiac.ide.model.libraryElement.SubApp;
import org.eclipse.fordiac.ide.model.typelibrary.TypeLibraryTags;

public class PLCResourceDeploymentData extends ResourceDeploymentData {

	public PLCResourceDeploymentData(Resource res) {
		super(res);
		// TODO Auto-generated constructor stub
	}

	private static List<IFile> collectProjectIFiles(IProject project) {
		List<IFile> files = new ArrayList<>();
		Deque<IResource> candidates = new ArrayDeque<>();

		try {
			candidates.addAll(Arrays.asList(project.members()));
			while (!candidates.isEmpty()) {
				IResource candidate = candidates.pop();
				if ((candidate instanceof IFile) && (TypeLibraryTags.PROGRAM_TYPE_FILE_ENDING
						.equalsIgnoreCase(((IFile) candidate).getFileExtension()))) {
					files.add((IFile) candidate);
				}
				if (candidate instanceof IFolder) {
					candidates.addAll(Arrays.asList(((IFolder) candidate).members()));
				}
			}
		} catch (CoreException e1) {
			e1.printStackTrace();
		}

		return files;
	}

	@Override
	protected void addFBNetworkElements(Deque<SubApp> subAppHierarchy, FBNetwork fbNetwork, String prefix) {

		IProject project = res.getAutomationSystem().getSystemFile().getProject();

		List<IFile> programFiles = collectProjectIFiles(project);

		String typeName = fbNetwork.getNetworkElements().get(0).getTypeName();

		IFile programTypeFile = programFiles.stream().filter(file -> file.getName().contains(typeName))
				.collect(Collectors.toList()).get(0);

		ProgramImporter importer = new ProgramImporter(programTypeFile);
		importer.loadElement();
		Program program = importer.getElement();

		IEC61131FBDSequence sequence = new IEC61131FBDSequence(program.getFbNetwork());
		sequence.calculateSequence();
		List<FBActivation> orderedFBList = sequence.getActivatedFBs();
		orderedFBList.forEach(activationFB -> fbs.add(new FBDeploymentData(prefix, activationFB.getFunctionBlock())));

		addEventConnections(subAppHierarchy, fbNetwork, prefix);
		addDataConnections(subAppHierarchy, fbNetwork, prefix);
		addAdapterConnections(subAppHierarchy, fbNetwork, prefix);
	}

}
