/*******************************************************************************
 * Copyright (c) 2020 Johannes Kepler University Linz
 * 
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 * 
 * Contributors:
 *   Alois Zoitl - initial API and implementation and/or initial documentation
 *******************************************************************************/
package org.eclipse.fordiac.ide.export.forte_ng.struct

import java.nio.file.Path
import org.eclipse.fordiac.ide.export.forte_ng.ForteLibraryElementTemplate
import org.eclipse.fordiac.ide.model.data.StructuredType
import org.eclipse.xtend.lib.annotations.Accessors

abstract class StructBaseTemplate extends ForteLibraryElementTemplate {

	@Accessors(PROTECTED_GETTER) StructuredType type

	override protected getExportPrefix() ''''''  //currently we don't want to have prefixes for structs members

	new(StructuredType type, String name, Path prefix) {
		super(name, prefix)
		this.type = type
	}

	def protected getStructClassName() '''CIEC_«type.name»'''
	
	def static structuredTypeFileName(StructuredType type) '''forte_«type.name.toLowerCase»'''

}