/**
 * <copyright> Copyright (c) 2008-2009 Jonas Helming, Maximilian Koegel. All rights reserved. This program and the
 * accompanying materials are made available under the terms of the Eclipse Public License v1.0 which accompanies this
 * distribution, and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>
 */

package org.unicase.ui.urml.stakeholders.config;

import java.util.ArrayList;

import org.eclipse.emf.common.util.BasicEList;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.common.util.EMap;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.jface.viewers.CellEditor;
import org.eclipse.jface.viewers.CheckboxCellEditor;
import org.eclipse.jface.viewers.EditingSupport;
import org.eclipse.jface.viewers.TableViewer;
import org.eclipse.jface.viewers.TableViewerColumn;
import org.eclipse.swt.SWT;
import org.unicase.workspace.util.UnicaseCommand;

/**
 * Supports the editing of table cell content within the phase configuration view.
 * 
 * @author kterzieva
 */
public class PhaseConfigurationEditingSupport extends EditingSupport {

	private final TableViewer viewer;
	private EClass columnClass;
	private PhaseConfigurationView rulesView;

	 /**
	  * The construct.
	  * @param rulesView the development phase configuration view, which can be edited
	  * @param viewer the table viewer
	  * @param columnClass the type of the column element
	  * @param sortedElementNames list with the sorted model element names
	  * @param viewerColumn the column viewer
	  */
	public PhaseConfigurationEditingSupport(PhaseConfigurationView rulesView,
			TableViewer viewer, EClass columnClass,
			ArrayList<EClass> sortedElementNames, TableViewerColumn viewerColumn) {
		super(viewer);
		this.viewer = viewer;
		this.columnClass = columnClass;
		this.rulesView = rulesView;
	}

	@Override
	protected CellEditor getCellEditor(Object element) {
		return new CheckboxCellEditor(null, SWT.CHECK | SWT.READ_ONLY);
	}

	@Override
	protected boolean canEdit(Object element) {
		return true;
	}

	@Override
	protected Object getValue(Object element) {
		return false;
	}

	@Override
	protected void setValue(final Object element, Object value) {
		if (UrmlSettingsManager.INSTANCE.getActivePhase() == null) {
			MessageDialog
					.openWarning(viewer.getControl().getShell(),
							"No development phase active",
							"You must set a development phase as active before you can edit it.");
			return;
		}
		if (!rulesView.hasStaticAssociation(columnClass, (EClass) element)
				&& !rulesView.hasStaticAssociation((EClass) element,
						columnClass)) {
			new UnicaseCommand() {

				@Override
				protected void doRun() {
					EMap<EClass, EList<EClass>> allowedAss = UrmlSettingsManager.INSTANCE
							.getActivePhase().getAllowedAssociations();
					EList<EClass> valueList = allowedAss.get((EClass) element);
					if (valueList == null) {
						valueList = new BasicEList<EClass>();
						valueList.add(columnClass);
						allowedAss.put((EClass) element, valueList);
						valueList = allowedAss.get((EClass) element);
					} else {
						if (!valueList.contains(columnClass)) {
							valueList.add(columnClass);
						} else {
							valueList.remove(columnClass);
						}
					}
				}

			}.run();
			viewer.update(element, null);	
		}
	}
}