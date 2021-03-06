/*******************************************************************************
 * Copyright (c) 2019 TU Wien, ACIN
 * 				 2019-2020 Johannes Kepler University Linz
 *
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *
 * Contributors:
 *   Peter Gsellmann - initial API and implementation and/or initial documentation
 *   Alois Zoitl - Changed analysis result to key value pairs
 *   Lisa Sonnleithner - Adjustments to change calculation method to average 
 *   				   - extracted superclass
 *******************************************************************************/

package org.eclipse.fordiac.ide.metrics.handlers;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;

import org.eclipse.core.commands.AbstractHandler;
import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.resources.IFile;
import org.eclipse.fordiac.ide.metrics.Messages;
import org.eclipse.fordiac.ide.metrics.analyzers.AbstractCodeMetricAnalyzer;
import org.eclipse.fordiac.ide.metrics.analyzers.MetricResult;
import org.eclipse.fordiac.ide.model.Palette.FBTypePaletteEntry;
import org.eclipse.fordiac.ide.model.Palette.PaletteEntry;
import org.eclipse.fordiac.ide.model.libraryElement.FBNetwork;
import org.eclipse.fordiac.ide.model.libraryElement.INamedElement;
import org.eclipse.fordiac.ide.model.typelibrary.TypeLibrary;
import org.eclipse.gef.EditPart;
import org.eclipse.jface.dialogs.IDialogConstants;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.jface.layout.GridDataFactory;
import org.eclipse.jface.viewers.ArrayContentProvider;
import org.eclipse.jface.viewers.ColumnWeightData;
import org.eclipse.jface.viewers.ITableLabelProvider;
import org.eclipse.jface.viewers.LabelProvider;
import org.eclipse.jface.viewers.StructuredSelection;
import org.eclipse.jface.viewers.TableLayout;
import org.eclipse.jface.viewers.TableViewer;
import org.eclipse.swt.SWT;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Table;
import org.eclipse.swt.widgets.TableColumn;
import org.eclipse.ui.IWorkbenchWindow;
import org.eclipse.ui.handlers.HandlerUtil;

public abstract class AbstractCodeMetricHandler extends AbstractHandler {
	public static class MetricsResultLabelProvider extends LabelProvider implements ITableLabelProvider {
		private static final DecimalFormat decimalFormat = new DecimalFormat("#0.00"); //$NON-NLS-1$

		@Override
		public Image getColumnImage(Object element, int columnIndex) {
			return null;
		}

		@Override
		public String getColumnText(Object element, int columnIndex) {
			if (element instanceof MetricResult) {
				switch (columnIndex) {
				case 0:
					return ((MetricResult) element).getName();
				case 1:
					return decimalFormat.format(((MetricResult) element).getValue());
				default:
					break;
				}
			}
			return element.toString();
		}

	}

	private static class MetricsResultDialog extends MessageDialog {

		private final List<MetricResult> data;

		public MetricsResultDialog(Shell parent, INamedElement element, final List<MetricResult> data) {
			super(parent, Messages.CalculatedMetricsFor + element.getName(), null, null, INFORMATION, 0,
					IDialogConstants.OK_LABEL);
			this.data = data;
		}

		@Override
		protected Control createMessageArea(Composite composite) {
			final Composite body = (Composite) super.createMessageArea(composite);

			final TableViewer viewer = new TableViewer(body, SWT.BORDER | SWT.V_SCROLL | SWT.H_SCROLL | SWT.MULTI);
			GridDataFactory.fillDefaults().align(SWT.FILL, SWT.BEGINNING).grab(true, false)
					.hint(convertHorizontalDLUsToPixels(IDialogConstants.MINIMUM_MESSAGE_AREA_WIDTH), SWT.DEFAULT)
					.applyTo(viewer.getTable());
			configureTableColumns(viewer.getTable());

			viewer.setContentProvider(new ArrayContentProvider());
			viewer.setLabelProvider(new MetricsResultLabelProvider());
			viewer.setInput(data);

			return body;
		}

		private static void configureTableColumns(Table table) {
			new TableColumn(table, SWT.LEFT).setText(Messages.Metric);
			new TableColumn(table, SWT.RIGHT).setText(Messages.Value);

			TableLayout layout = new TableLayout();
			layout.addColumnData(new ColumnWeightData(65, 100));
			layout.addColumnData(new ColumnWeightData(25, 10));
			table.setLayout(layout);

			table.setLinesVisible(true);
			table.setHeaderVisible(true);
		}
	}

	@Override
	public Object execute(ExecutionEvent event) throws org.eclipse.core.commands.ExecutionException {
		List<MetricResult> result = new ArrayList<>();

		INamedElement selectedElement = getSelectedElement(
				(StructuredSelection) HandlerUtil.getCurrentSelection(event));

		if (null != selectedElement) {
			calculateMetrics(selectedElement, result);
			displayResults(selectedElement, result, HandlerUtil.getActiveWorkbenchWindowChecked(event));
		}
		return null;
	}

	private static INamedElement getSelectedElement(StructuredSelection currentSelection) {
		Object obj = currentSelection.getFirstElement();
		if (obj instanceof EditPart) {
			obj = ((EditPart) obj).getModel();

		}

		if (obj instanceof IFile) {
			return checkSelectedFile((IFile) obj);
		}

		if (obj instanceof FBNetwork) {
			return ((FBNetwork) obj).getApplication();
		}

		return (obj instanceof INamedElement) ? (INamedElement) obj : null;
	}

	private static INamedElement checkSelectedFile(IFile file) {
		PaletteEntry entry = TypeLibrary.getPaletteEntryForFile(file);
		if (entry instanceof FBTypePaletteEntry) {
			return ((FBTypePaletteEntry) entry).getFBType();
		}
		return null;
	}

	private void calculateMetrics(INamedElement element, List<MetricResult> result) {
		List<AbstractCodeMetricAnalyzer> analyzers = getAnalyzers();
		for (AbstractCodeMetricAnalyzer analyzer : analyzers) {
			analyzer.calculateMetrics(element);
			result.addAll(analyzer.getResults());
		}
	}

	private static void displayResults(INamedElement element, List<MetricResult> result,
			IWorkbenchWindow workbenchWindow) {
		MetricsResultDialog resultDialog = new MetricsResultDialog(workbenchWindow.getShell(), element, result);
		resultDialog.open();
	}

	protected abstract List<AbstractCodeMetricAnalyzer> getAnalyzers();

}
