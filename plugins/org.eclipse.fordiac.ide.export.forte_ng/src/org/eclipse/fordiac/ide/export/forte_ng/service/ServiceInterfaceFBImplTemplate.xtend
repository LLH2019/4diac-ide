/*******************************************************************************
 * Copyright (c) 2019 fortiss GmbH
 *
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *
 * Contributors:
 *   Martin Jobst
 *     - initial API and implementation and/or initial documentation
 *******************************************************************************/
package org.eclipse.fordiac.ide.export.forte_ng.service

import java.nio.file.Path
import org.eclipse.fordiac.ide.export.forte_ng.ForteFBTemplate
import org.eclipse.fordiac.ide.model.libraryElement.ServiceInterfaceFBType
import org.eclipse.xtend.lib.annotations.Accessors

class ServiceInterfaceFBImplTemplate extends ForteFBTemplate {

	@Accessors(PROTECTED_GETTER) ServiceInterfaceFBType type

	new(ServiceInterfaceFBType type, String name, Path prefix) {
		super(name, prefix, "CFunctionBlock")
		this.type = type
	}

	override generate() '''
		«generateHeader»
		
		«generateImplIncludes»
		
		«generateFBDefinition»
		
		«generateFBInterfaceDefinition»
		
		«generateFBInterfaceSpecDefinition»
		
		«generateExecuteEvent»
		
	'''
	
	def protected generateExecuteEvent() '''
		void «FBClassName»::executeEvent(int pa_nEIID) {
		  switch(pa_nEIID) {
		    «FOR event : type.interfaceList.eventInputs»
		    	case scm_nEvent«event.name»ID:
		    	  #error add code for «event.name» event!
		    	  /*
		    	    do not forget to send output event, calling e.g.
		    	      sendOutputEvent(scm_nEventCNFID);
		    	  */
		    	  break;
		    «ENDFOR»
		  }
		}
	'''
}
