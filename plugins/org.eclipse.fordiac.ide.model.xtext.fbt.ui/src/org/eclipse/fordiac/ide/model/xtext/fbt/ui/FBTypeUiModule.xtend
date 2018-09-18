/*
 * generated by Xtext 2.11.0
 */
package org.eclipse.fordiac.ide.model.xtext.fbt.ui

import org.eclipse.xtend.lib.annotations.FinalFieldsConstructor
import org.eclipse.xtext.ui.editor.model.ResourceForIEditorInputFactory
import org.eclipse.xtext.ui.shared.Access
import org.eclipse.xtext.ui.resource.SimpleResourceSetProvider

/**
 * Use this class to register components to be used within the Eclipse IDE.
 */
@FinalFieldsConstructor
class FBTypeUiModule extends AbstractFBTypeUiModule {

	override provideIAllContainersState() { return Access::getWorkspaceProjectsState() }

	override bindIResourceForEditorInputFactory() { return ResourceForIEditorInputFactory }
	
	override bindIResourceSetProvider() {
    	return SimpleResourceSetProvider;
	}

}
