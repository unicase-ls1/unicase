/**
 * <copyright> Copyright (c) 2008 Jonas Helming, Maximilian Koegel. All rights reserved. This program and the
 * accompanying materials are made available under the terms of the Eclipse Public License v1.0 which accompanies this
 * distribution, and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>
 */
package org.unicase.ui.tableview.viewer;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.edit.provider.AdapterFactoryItemDelegator;
import org.eclipse.emf.edit.provider.ComposedAdapterFactory;
import org.eclipse.emf.edit.provider.IItemPropertyDescriptor;
import org.eclipse.jface.viewers.TableViewer;
import org.eclipse.jface.viewers.TableViewerColumn;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.ui.part.ViewPart;
import org.unicase.model.ModelElement;
import org.unicase.model.task.ActionItem;
import org.unicase.model.task.TaskFactory;

/**
 * @author Hodaie This is a prototype implementation of this plug in. This class creates a dummy array of ActionItems to
 *         show them in TableView. I a real scenario this class may be initialized with a ModelElement type, and invoked
 *         from another plug-in (e.g. navigator).
 */
public class TableView extends ViewPart {

	/**
	 * This gives the height of table rows.
	 */
	public static final int ROW_HEIGHT = 20;

	private TableViewer viewer;

	/**
	 * 
	 */
	public TableView() {

	}

	/**
	 * . ({@inheritDoc})
	 */
	@Override
	public void createPartControl(Composite parent) {

		viewer = new TableViewer(parent, SWT.V_SCROLL | SWT.H_SCROLL);
		viewer.setContentProvider(new TableViewContentProvider());

		ActionItem ai = TaskFactory.eINSTANCE.createActionItem();
		setColumns(viewer, ai);
		ActionItem[] ais = createActionItems();
		viewer.setInput(ais);

		// FunctionalRequirement fr =
		// ModelFactory.eINSTANCE.createFunctionalRequirement();
		// setColumns(viewer, fr);
		// FunctionalRequirement[] frs = createFunctionalRequirements();
		// viewer.setInput(frs);

	}

	/**
	 * This method takes a ModelElement and initializes the columns (TableViewer's header row) with names of its simple
	 * attributes. The boolean attributes are shown at last columns.
	 * 
	 * @param table
	 * @param modelElement
	 */
	private void setColumns(final TableViewer table, ModelElement modelElement) {

		AdapterFactoryItemDelegator adapterFactoryItemDelegator = new AdapterFactoryItemDelegator(
			new ComposedAdapterFactory(ComposedAdapterFactory.Descriptor.Registry.INSTANCE));

		List<IItemPropertyDescriptor> propertyDescriptors = adapterFactoryItemDelegator
			.getPropertyDescriptors(modelElement);

		// show non-boolean attributes first
		// and remember a list of boolean attributes
		List<IItemPropertyDescriptor> booleanAttributesPropertyDescriptors = new ArrayList<IItemPropertyDescriptor>();
		for (IItemPropertyDescriptor propertyDescriptor : propertyDescriptors) {
			if (!propertyDescriptor.isMany(modelElement)) {

				if (((EStructuralFeature) propertyDescriptor.getFeature(modelElement)).getEType().getInstanceClass()
					.equals(boolean.class)) {

					booleanAttributesPropertyDescriptors.add(propertyDescriptor);
					continue;
				}

				TableViewerColumn column = new TableViewerColumn(table, SWT.CENTER);
				column.getColumn().setText(propertyDescriptor.getDisplayName(modelElement));
				column.getColumn().setWidth(100);
				column.getColumn().setMoveable(true);
				column.setLabelProvider(new TableViewColumnLabelProvider(propertyDescriptor));

			}
		}
		// now show the boolean attributes at the end
		for (IItemPropertyDescriptor propertyDescriptor : booleanAttributesPropertyDescriptors) {
			TableViewerColumn column = new TableViewerColumn(table, SWT.CENTER);
			column.getColumn().setText(propertyDescriptor.getDisplayName(modelElement));
			column.getColumn().setWidth(100);
			column.getColumn().setMoveable(true);
			column.setLabelProvider(new TableViewBooleanLabelProvider(table, propertyDescriptor));

		}

		table.getTable().setLinesVisible(true);
		table.getTable().setHeaderVisible(true);

	}

	/**
	 * Just for test purpose. This method return a list of dummy ActionItems to be shown in TableView.
	 * 
	 * @see JavaDoc for TableView class.
	 * @return ActionItem[]
	 */
	private ActionItem[] createActionItems() {
		ActionItem[] actionItems = new ActionItem[3];
		for (int i = 0; i < 3; i++) {
			ActionItem ai = TaskFactory.eINSTANCE.createActionItem();
			ai.setName("ai " + i);
			ai.setDescription("ai description " + i);
			ai.setDone((i % 2) == 0);
			actionItems[i] = ai;

		}

		return actionItems;

	}

	/**
	 * . ({@inheritDoc})
	 */
	@Override
	public void setFocus() {
		// TODO Auto-generated method stub

	}

	// /**
	// * Just for Test.
	// * This method return a list of dummy FunctionalRequirements to be
	// * shown in TableView.
	// * @see JavaDoc for TableView class.
	// *
	// * @return FunctionalRequirement[]
	// */
	// FunctionalRequirement[] createFunctionalRequirements() {
	//
	// FunctionalRequirement[] frs = new FunctionalRequirement[3];
	// for (int i = 0; i < 3; i++) {
	// FunctionalRequirement fr = ModelFactory.eINSTANCE
	// .createFunctionalRequirement();
	// fr.setName("fr " + i);
	// fr.setDescription("fr description " + i);
	// fr.setPriority(10);
	// fr.setReviewed(false);
	// frs[i] = fr;
	//
	// }
	//
	// return frs;
	// }

}
