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

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.eclipse.emf.common.util.EList;
import org.eclipse.fordiac.ide.model.libraryElement.FB;
import org.eclipse.fordiac.ide.model.libraryElement.FBNetwork;
import org.eclipse.fordiac.ide.model.libraryElement.FBNetworkElement;
import org.eclipse.fordiac.ide.model.libraryElement.VarDeclaration;

public class IEC61131FBDSequence {

	private FBNetwork network;

	List<FBActivation> activatedFBs = new ArrayList<>();

	public IEC61131FBDSequence(FBNetwork network) {
		this.network = network;
	}

	private EList<FBNetworkElement> getNetworkElements() {
		return network.getNetworkElements();
	}

	public List<FBActivation> getActivatedFBs() {
		return activatedFBs;
	}

	public void calculateSequence() {
		List<FBActivation> waitingFBs = getNetworkElements().stream().map(e -> new FBActivation((FB) e))
				.collect(Collectors.toList());
		while (!waitingFBs.isEmpty()) {
			List<FBActivation> readyFBs = waitingFBs.stream().filter(FBActivation::isFBReady)
					.collect(Collectors.toList());
			activatedFBs.addAll(readyFBs);

			// Check for new activated Inputs on the waiting FBs
			for (FBActivation readyFB : readyFBs) {
				for (FBActivation fbActivation : waitingFBs) {
					fbActivation.checkForInput(readyFB.getFunctionBlock());
				}
			}
			if (readyFBs.isEmpty()) { // check for feedback as this is the last resort
				// Filter on already activated FBs
				List<FB> activeFBs = activatedFBs.stream().map(FBActivation::getFunctionBlock)
						.collect(Collectors.toList());
				List<VarDeclaration> outVars = new ArrayList<>();
				activeFBs.forEach(fb -> outVars.addAll(fb.getInterface().getOutputVars()));
				List<FB> fbsWithActivatedIns = new ArrayList<>();
				outVars.forEach(e -> e.getOutputConnections()
						.forEach(f -> fbsWithActivatedIns.add((FB) f.getDestinationElement())));

				// Get successors from active FBs
				List<FBActivation> fbActivationsWithActivatedIns = waitingFBs.stream()
						.filter(e -> fbsWithActivatedIns.contains(e.getFunctionBlock())).collect(Collectors.toList());

				for (FBActivation fbActivation : fbActivationsWithActivatedIns) {

					for (FBActivation feedbackFB : waitingFBs) {
						if (fbActivation != feedbackFB) {
							fbActivation.checkForInput(feedbackFB.getFunctionBlock());
						}
					}
				}

				if (waitingFBs.stream().noneMatch(FBActivation::isFBReady)) {
					// As a last resort check free (no previous activated FB) loops
					for (FBActivation fbActivation : waitingFBs) {

						for (FBActivation feedbackFB : waitingFBs) {
							if (fbActivation != feedbackFB) {
								fbActivation.checkForInput(feedbackFB.getFunctionBlock());
							}
						}
					}
				}

			}

			waitingFBs.removeIf(readyFBs::contains);
		}

	}

}
