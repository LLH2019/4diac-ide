/*******************************************************************************
 * Copyright (c) 2016 fortiss GmbH
 * 				 2019 Johannes Kepler University Linz
 *
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *
 * Contributors:
 *   Alois Zoitl - initial API and implementation and/or initial documentation
 *   Alois Zoitl - moved getCurrentActiveEditor and openEditor helper functions
 *   			   to EditorUtils
 *******************************************************************************/
package org.eclipse.fordiac.ide.ui.editors;

import org.eclipse.fordiac.ide.ui.UIPlugin;
import org.eclipse.ui.IEditorInput;
import org.eclipse.ui.IEditorPart;
import org.eclipse.ui.IEditorReference;
import org.eclipse.ui.IWorkbenchPage;
import org.eclipse.ui.IWorkbenchWindow;
import org.eclipse.ui.PartInitException;
import org.eclipse.ui.PlatformUI;

public final class EditorUtils {

	public enum EditorKind {
		TYPE_EDITOR, AUTOMATION_SYSTEM_EDITOR, NONE
	}

	public static final EditorAction CloseEditor = (final IEditorPart part) -> PlatformUI.getWorkbench()
			.getActiveWorkbenchWindow().getActivePage().closeEditor(part, false);

	private EditorUtils() {
		throw new AssertionError();
	}

	public static IEditorPart getCurrentActiveEditor() {
		final IWorkbenchWindow window = PlatformUI.getWorkbench().getActiveWorkbenchWindow();
		if (window != null && window.getActivePage() != null) {
			return window.getActivePage().getActiveEditor();
		}
		return null;
	}

	public static IEditorPart openEditor(final IEditorInput input, final String editorId) {
		IEditorPart editor = null;
		final IWorkbenchPage activePage = PlatformUI.getWorkbench().getActiveWorkbenchWindow().getActivePage();
		try {
			editor = activePage.openEditor(input, editorId);
		} catch (final PartInitException e) {
			editor = null;
			UIPlugin.getDefault().logError(e.getMessage(), e);
		}
		return editor;
	}

	public static IEditorPart findEditor(final EditorFilter filter) {
		final IEditorReference[] editorReferences = PlatformUI.getWorkbench().getActiveWorkbenchWindow().getActivePage()
				.getEditorReferences();

		for (final IEditorReference editorReference : editorReferences) {
			final IEditorPart editor = editorReference.getEditor(false);
			if (null != editor && filter.filter(editor)) {
				return editor;
			}
		}
		return null;
	}

	public static void forEachOpenEditorFiltered(final EditorFilter filter, final EditorAction action) {
		final IEditorReference[] editorReferences = PlatformUI.getWorkbench().getActiveWorkbenchWindow().getActivePage()
				.getEditorReferences();

		for (final IEditorReference editorReference : editorReferences) {
			final IEditorPart editor = editorReference.getEditor(false);
			if (null != editor && filter.filter(editor)) {
				action.run(editor);
			}
		}
	}

	public static void closeEditorsFiltered(final EditorFilter filter) {
		forEachOpenEditorFiltered(filter, CloseEditor);
	}

	public static EditorKind getEditorKind() {
		final IEditorPart currentActiveEditor = getCurrentActiveEditor();
		if (currentActiveEditor == null) {
			return EditorKind.NONE;
		}
		final String editorName = currentActiveEditor.getClass().getSimpleName();
		switch (editorName) {
		case "SubAppTypeEditor": //$NON-NLS-1$
		case "FBTypeEditor"://$NON-NLS-1$
			return EditorKind.TYPE_EDITOR;
		case "AutomationSystemEditor"://$NON-NLS-1$
			return EditorKind.AUTOMATION_SYSTEM_EDITOR;
		default:
			return EditorKind.NONE;
		}

	}

}
