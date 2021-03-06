/*******************************************************************************
 * Copyright (c) 2014 - 2017 fortiss GmbH
 *
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *
 * Contributors:
 *   Alois Zoitl
 *     - initial API and implementation and/or initial documentation
 *******************************************************************************/
package org.eclipse.fordiac.ide.typemanagement;

import java.text.MessageFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Map.Entry;
import java.util.stream.Stream;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IResourceDelta;
import org.eclipse.core.resources.mapping.IResourceChangeDescriptionFactory;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.OperationCanceledException;
import org.eclipse.fordiac.ide.model.Palette.Palette;
import org.eclipse.fordiac.ide.model.Palette.PaletteEntry;
import org.eclipse.fordiac.ide.model.libraryElement.CompositeFBType;
import org.eclipse.fordiac.ide.model.libraryElement.FBNetwork;
import org.eclipse.fordiac.ide.model.libraryElement.FBNetworkElement;
import org.eclipse.fordiac.ide.model.libraryElement.LibraryElement;
import org.eclipse.fordiac.ide.model.libraryElement.ResourceType;
import org.eclipse.fordiac.ide.model.libraryElement.SubAppType;
import org.eclipse.fordiac.ide.model.typelibrary.TypeLibrary;
import org.eclipse.ltk.core.refactoring.Change;
import org.eclipse.ltk.core.refactoring.RefactoringStatus;
import org.eclipse.ltk.core.refactoring.participants.CheckConditionsContext;
import org.eclipse.ltk.core.refactoring.participants.DeleteParticipant;
import org.eclipse.ltk.core.refactoring.participants.ResourceChangeChecker;

public class DeleteFBTypeParticipant extends DeleteParticipant {

	@Override
	protected boolean initialize(Object element) {
		return (element instanceof IFile);
	}

	@Override
	public String getName() {
		return Messages.DeleteFBTypeParticipant_Name;
	}

	@Override
	public RefactoringStatus checkConditions(IProgressMonitor pm, CheckConditionsContext context)
			throws OperationCanceledException {
		ResourceChangeChecker resChecker = context.getChecker(ResourceChangeChecker.class);
		IResourceChangeDescriptionFactory deltaFactory = resChecker.getDeltaFactory();
		IResourceDelta[] affectedChildren = deltaFactory.getDelta().getAffectedChildren();

		return verifyAffectedChildren(affectedChildren);
	}

	private static RefactoringStatus verifyAffectedChildren(IResourceDelta[] affectedChildren) {
		for (IResourceDelta resourceDelta : affectedChildren) {
			if (resourceDelta.getResource() instanceof IFile) {
				Palette palette = TypeLibrary.getTypeLibrary(resourceDelta.getResource().getProject())
						.getBlockTypeLib();

				String typeNameToDelete = TypeLibrary.getTypeNameFromFile((IFile) resourceDelta.getResource());
				List<String> typeNames = checkTypeContainment(palette, typeNameToDelete);

				if (!typeNames.isEmpty()) {
					return RefactoringStatus.createWarningStatus(MessageFormat.format(
							Messages.DeleteFBTypeParticipant_TypeInUseWarning, typeNameToDelete, typeNames.toString()));
				}
			} else {
				return verifyAffectedChildren(resourceDelta.getAffectedChildren());
			}
		}
		return new RefactoringStatus();
	}

	private static List<String> checkTypeContainment(Palette palette, String searchTypeName) {
		List<String> retVal = new ArrayList<>();
		Stream<Entry<String, ? extends PaletteEntry>> stream = Stream.concat(
				Stream.concat(palette.getFbTypes().entrySet().stream(), palette.getSubAppTypes().entrySet().stream()),
				palette.getResourceTypes().entrySet().stream());

		stream.forEach(entry -> {
			FBNetwork network = getNetwork(entry);
			if ((null != network) && (containsElementWithType(searchTypeName, network))) {
				retVal.add(entry.getValue().getLabel());
			}
		});

		return retVal;
	}

	private static FBNetwork getNetwork(Entry<String, ? extends PaletteEntry> entry) {
		FBNetwork network = null;
		LibraryElement type = entry.getValue().getType();

		if (type instanceof CompositeFBType) {
			network = ((CompositeFBType) type).getFBNetwork();
		} else if (type instanceof ResourceType) {
			network = ((ResourceType) type).getFBNetwork();
		} else if (type instanceof SubAppType) {
			network = ((SubAppType) type).getFBNetwork();
		}
		return network;
	}

	private static boolean containsElementWithType(String searchTypeName, FBNetwork network) {
		for (FBNetworkElement element : network.getNetworkElements()) {
			if (searchTypeName.equals(element.getTypeName())) {
				return true;
			}
		}
		return false;
	}

	@Override
	public Change createChange(IProgressMonitor pm) throws CoreException, OperationCanceledException {
		return null;
	}

}
