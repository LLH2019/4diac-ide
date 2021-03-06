/*******************************************************************************
 * Copyright (c) 2019 fortiss GmbH
 *               2020 Johannes Kepler University
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
 *   Alois Zoitl
 *     - Fix issues in adapter code generation
 *******************************************************************************/
package org.eclipse.fordiac.ide.export.forte_ng.adapter

import java.nio.file.Path
import org.eclipse.fordiac.ide.export.forte_ng.ForteFBTemplate
import org.eclipse.fordiac.ide.model.libraryElement.AdapterFBType
import org.eclipse.xtend.lib.annotations.Accessors

class AdapterFBImplTemplate extends ForteFBTemplate {

	@Accessors(PROTECTED_GETTER) AdapterFBType type

	new(AdapterFBType type, String name, Path prefix) {
		super(name, prefix, "CAdapter")
		this.type = type
	}

	override generate() '''
		«generateHeader»
		
		«generateImplIncludes»
		
		«generateFBDefinition»
		
		«generateFBInterfaceDefinition»
		
		«generateFBInterfaceSpecDefinition»
		
	'''

	override protected generateFBDefinition() '''
		DEFINE_ADAPTER_TYPE(«FBClassName», «type.name.FORTEString»)
	'''
	
	def generateFBInterfaceSpecSocket()
	'''
	const SFBInterfaceSpec «FBClassName»::scm_stFBInterfaceSpecSocket = {
	  «type.interfaceList.eventInputs.size», «IF type.interfaceList.eventInputs.empty»nullptr, nullptr«ELSE»scm_anEventInputNames, scm_anEIWith, scm_anEIWithIndexes«ENDIF»,
	  «type.interfaceList.eventOutputs.size», «IF type.interfaceList.eventOutputs.empty»nullptr, nullptr«ELSE»scm_anEventOutputNames, scm_anEOWith, scm_anEOWithIndexes«ENDIF»,
	  «type.interfaceList.inputVars.size», «IF type.interfaceList.inputVars.empty»nullptr, nullptr«ELSE»scm_anDataInputNames, scm_anDataInputTypeIds«ENDIF»,
	  «type.interfaceList.outputVars.size», «IF type.interfaceList.outputVars.empty»nullptr, nullptr«ELSE»scm_anDataOutputNames, scm_anDataOutputTypeIds«ENDIF»,
	  «type.interfaceList.plugs.size + type.interfaceList.sockets.size», nullptr
	};
	'''
	
	def generateFBInterfaceSpecPlug()
	'''
	const SFBInterfaceSpec «FBClassName»::scm_stFBInterfaceSpecPlug = {
	  «type.interfaceList.eventOutputs.size», «IF type.interfaceList.eventOutputs.empty»nullptr, nullptr«ELSE»scm_anEventOutputNames, scm_anEOWith, scm_anEOWithIndexes«ENDIF»,
	  «type.interfaceList.eventInputs.size», «IF type.interfaceList.eventInputs.empty»nullptr, nullptr«ELSE»scm_anEventInputNames, scm_anEIWith, scm_anEIWithIndexes«ENDIF»,
	  «type.interfaceList.outputVars.size», «IF type.interfaceList.outputVars.empty»nullptr, nullptr«ELSE»scm_anDataOutputNames, scm_anDataOutputTypeIds«ENDIF»,
	  «type.interfaceList.inputVars.size», «IF type.interfaceList.inputVars.empty»nullptr, nullptr«ELSE»scm_anDataInputNames, scm_anDataInputTypeIds«ENDIF»,
	  «type.interfaceList.plugs.size + type.interfaceList.sockets.size», nullptr
	};
	'''

	override protected generateFBInterfaceSpecDefinition()
	'''
	«generateFBInterfaceSpecSocket»

	«generateFBInterfaceSpecPlug»
	'''
}
