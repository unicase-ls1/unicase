/**
 * <copyright> Copyright (c) 2008 Jonas Helming, Maximilian Koegel. All rights reserved. This program and the accompanying materials are made available under the terms of the Eclipse Public License v1.0 which accompanies this distribution, and is available at http://www.eclipse.org/legal/epl-v10.html
 * </copyright>
 *
 * $Id$
 */
package org.unicase.ui.taskview;

import java.util.List;

import org.eclipse.emf.common.util.BasicEList;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.edit.provider.AdapterFactoryItemDelegator;
import org.eclipse.emf.edit.provider.ComposedAdapterFactory;
import org.eclipse.emf.edit.provider.IItemPropertyDescriptor;
import org.eclipse.emf.edit.ui.provider.AdapterFactoryContentProvider;
import org.eclipse.jface.viewers.TableViewer;
import org.eclipse.jface.viewers.TableViewerColumn;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.ui.part.ViewPart;
import org.unicase.model.task.ActionItem;
import org.unicase.model.task.TaskFactory;
import org.unicase.model.task.TaskPackage;
import org.unicase.ui.tableview.viewer.TableViewColumnLabelProvider;
import org.unicase.workspace.ProjectSpace;
import org.unicase.workspace.Workspace;
import org.unicase.workspace.WorkspaceManager;

/**
 * A specialized TableView to display FooBars.
 * 
 * @author schneidf
 * 
 */
public class TaskView extends ViewPart {

	private TableViewer viewer;

	@Override
	public void createPartControl(Composite parent) {

		viewer = new TableViewer(parent, SWT.V_SCROLL | SWT.H_SCROLL);

		AdapterFactoryContentProvider contentProvider = new AdapterFactoryContentProvider(
				new CollectionAdapterFactory());

		viewer.setContentProvider(contentProvider);

		createColumns();
		viewer.getTable().setLinesVisible(true);
		viewer.getTable().setHeaderVisible(true);

		EList<ActionItem> inputList = getAllActionItems();
		viewer.setInput(inputList);

	}

	private EList<ActionItem> getAllActionItems() {
		Workspace ws = WorkspaceManager.getInstance().getCurrentWorkspace();

		EList<ProjectSpace> psl = ws.getProjectSpaces();

		EList<ActionItem> inputList = new BasicEList<ActionItem>();
		for (ProjectSpace p : psl) {
			inputList.addAll(p.getProject().getAllModelElementsbyClass(
					TaskPackage.eINSTANCE.getActionItem(),
					new BasicEList<ActionItem>()));
		}
		return inputList;
	}

	private void createColumns() {

		ActionItem template = TaskFactory.eINSTANCE.createActionItem();

		AdapterFactoryItemDelegator adapterFactoryItemDelegator = new AdapterFactoryItemDelegator(
				new ComposedAdapterFactory(
						ComposedAdapterFactory.Descriptor.Registry.INSTANCE));
		List<IItemPropertyDescriptor> descriptors = adapterFactoryItemDelegator
				.getPropertyDescriptors(template);

		// List<IItemPropertyDescriptor> descriptors = ((ActionItemItemProvider)
		// itemProviderAdapterFactory
		// .createActionItemAdapter()).getPropertyDescriptors(template);

		for (IItemPropertyDescriptor currentDescriptor : descriptors) {
			if (!currentDescriptor.isMany(template)) {
				TableViewerColumn currentColumn = new TableViewerColumn(viewer,
						SWT.CENTER);
				currentColumn.getColumn().setText(
						currentDescriptor.getDisplayName(template));
				currentColumn.getColumn().setWidth(100);
				currentColumn.getColumn().setMoveable(true);
				currentColumn
						.setLabelProvider(new TableViewColumnLabelProvider(
								currentDescriptor));
			}
		}

	}

	@Override
	public void setFocus() {
		viewer.setInput(getAllActionItems());
	}

}
