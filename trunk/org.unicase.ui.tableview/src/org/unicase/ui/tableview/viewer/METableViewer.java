/**
 * <copyright> Copyright (c) 2008 Jonas Helming, Maximilian Koegel. All rights reserved. This program and the
 * accompanying materials are made available under the terms of the Eclipse Public License v1.0 which accompanies this
 * distribution, and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>
 */
package org.unicase.ui.tableview.viewer;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Map;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.EcorePackage;
import org.eclipse.jface.resource.JFaceResources;
import org.eclipse.jface.viewers.ColumnLabelProvider;
import org.eclipse.jface.viewers.EditingSupport;
import org.eclipse.jface.viewers.TableViewer;
import org.eclipse.jface.viewers.TableViewerColumn;
import org.eclipse.jface.viewers.ViewerComparator;
import org.eclipse.swt.SWT;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.widgets.Composite;
import org.unicase.model.ModelElement;
import org.unicase.model.ModelPackage;
import org.unicase.model.Project;
import org.unicase.model.organization.OrganizationPackage;
import org.unicase.ui.common.TableViewerColumnSorter;
import org.unicase.ui.tableview.labelproviders.AbstractCheckboxColumnLabelProvider;
import org.unicase.ui.tableview.labelproviders.DateColumnLabelProvider;
import org.unicase.ui.tableview.labelproviders.GenericColumnLabelProvider;
import org.unicase.ui.tableview.labelproviders.StatusLabelProvider;
import org.unicase.ui.taskview.METableViewerContentProvider;

/**
 * A tableviewer for modelelements.
 * 
 * @author schneidf
 */
public class METableViewer {

	private TableViewer tableViewer;
	private EClass contentType;
	private METableViewerContentProvider contentProvider;

	/**
	 * Constructor.
	 * 
	 * @param parent parent composite to show METableViewer
	 */
	public METableViewer(Composite parent) {
		tableViewer = new TableViewer(parent, SWT.FULL_SELECTION);
		contentProvider = new METableViewerContentProvider();
		tableViewer.setContentProvider(contentProvider);
		tableViewer.getTable().setLinesVisible(true);
		tableViewer.getTable().setHeaderVisible(true);
	}

	/**
	 * Constructor.
	 * 
	 * @param parent parent
	 * @param meType model element type
	 */
	public METableViewer(Composite parent, EClass meType) {
		tableViewer = new TableViewer(parent, SWT.FULL_SELECTION);
		this.contentType = meType;
		contentProvider = new METableViewerContentProvider();
		contentProvider.setMEType(meType);
		tableViewer.setContentProvider(contentProvider);
		tableViewer.getTable().setLinesVisible(true);
		tableViewer.getTable().setHeaderVisible(true);

	}

	/**
	 * Creates table viewer columns from this set of features.
	 * 
	 * @param features EStructuralFeatures for each of which a TableViewerColumn is created.
	 * @return columns
	 */
	public List<TableViewerColumn> createColumns(Collection<EStructuralFeature> features) {
		List<TableViewerColumn> columns = new ArrayList<TableViewerColumn>();
		for (EStructuralFeature feature : features) {
			if (feature.getEType().equals(EcorePackage.Literals.EDATE)) {
				columns.add(createDateColumn(feature));
			} else if (feature.getEType().equals(EcorePackage.Literals.EBOOLEAN)) {
				columns.add(createBooleanColumn(feature));
			} else if (feature.equals(ModelPackage.Literals.MODEL_ELEMENT__STATE)) {
				columns.add(createStateColumn(feature));
			} else {
				columns.add(createGenericColumn(feature));
			}
		}
		return columns;
	}

	private TableViewerColumn createGenericColumn(EStructuralFeature feature) {

		ColumnLabelProvider provider = new GenericColumnLabelProvider(feature);
		int style, width;
		if (feature.getEType().equals(EcorePackage.Literals.EINT)) {
			style = SWT.CENTER;
			width = 25;
		} else if (feature.getEType().equals(OrganizationPackage.Literals.ORG_UNIT)
			|| feature.getEType().equals(OrganizationPackage.Literals.USER)) {
			style = SWT.CENTER;
			width = 100;
		} else if (feature.equals(ModelPackage.Literals.MODEL_ELEMENT__CREATOR)) {
			style = SWT.CENTER;
			width = 100;
		} else {
			style = SWT.NONE;
			width = 150;
		}
		if (feature.getEType().equals(ModelPackage.Literals.MODEL_ELEMENT__NAME)) {
			width = 270;
		}
		TableViewerColumn genericColumn = createColumn(feature, provider, width, style, true, true);

		return genericColumn;
	}

	private TableViewerColumn createStateColumn(EStructuralFeature feature) {
		TableViewerColumn stateColumn = new TableViewerColumn(tableViewer, SWT.NONE);
		stateColumn.getColumn().setWidth(20);
		stateColumn.setLabelProvider(new StatusLabelProvider());
		stateColumn.getColumn().setText("State");
		return stateColumn;
	}

	private TableViewerColumn createBooleanColumn(final EStructuralFeature feature) {

		ColumnLabelProvider provider = new AbstractCheckboxColumnLabelProvider() {

			@Override
			public Image getImage(Object element) {
				Image image = null;
				if (!(element instanceof EObject)) {
					return null;
				}
				Object obj = ((EObject) element).eGet(feature);
				if (!(obj instanceof Boolean)) {
					return null;
				}
				boolean featureValue = (Boolean) obj;
				if (featureValue) {
					image = JFaceResources.getImage(CHECKED);
				} else {
					image = JFaceResources.getImage(UNCHECK);
				}
				return image;
			}

		};

		TableViewerColumn booleanColumn = createColumn(feature, provider, 25, SWT.NONE, false, false);
		booleanColumn.getColumn().setText("");
		return booleanColumn;
	}

	private TableViewerColumn createColumn(EStructuralFeature feature, ColumnLabelProvider labelProvider, int width,
		int style, boolean resizeable, boolean setSorter) {
		TableViewerColumn column = new TableViewerColumn(tableViewer, style);

		column.getColumn().setText(feature.getName());
		column.getColumn().setWidth(width);

		column.getColumn().setMoveable(true);
		column.getColumn().setResizable(resizeable);

		column.setLabelProvider(labelProvider);
		if (setSorter) {
			ViewerComparator comp = new TableViewerColumnSorter(tableViewer, column, labelProvider);
			column.getViewer().setComparator(comp);
		}

		return column;
	}

	private TableViewerColumn createDateColumn(EStructuralFeature feature) {

		ColumnLabelProvider provider = new DateColumnLabelProvider(feature);
		TableViewerColumn dateColumn = createColumn(feature, provider, 150, SWT.CENTER, true, true);

		return dateColumn;
	}

	/**
	 * Creates for each EStructuralFeature of this model element type.
	 * 
	 * @param meEClass model element type
	 */
	public void createColumns(EClass meEClass) {
		// arraylist<feat> features;
		// for(item porperty descriptor : propertyDescriptors(meEClass)){
		// features.add(propDesc);
		// }
		// createColumns(features);
	}

	/**
	 * Creates columns with editing support.
	 * 
	 * @param features features.
	 * @return columns
	 */
	public List<TableViewerColumn> createColumnsWithEditingSupport(Map<EStructuralFeature, EditingSupport> features) {
		List<TableViewerColumn> columns = new ArrayList<TableViewerColumn>();
		for (EStructuralFeature feature : features.keySet()) {
			if (feature.getEType().equals(EcorePackage.Literals.EDATE)) {
				TableViewerColumn column = createDateColumn(feature);
				column.setEditingSupport(features.get(feature));
				columns.add(column);
			} else if (feature.getEType().equals(EcorePackage.Literals.EBOOLEAN)) {
				TableViewerColumn column = createBooleanColumn(feature);
				column.setEditingSupport(features.get(feature));
				columns.add(column);
			} else if (feature.getEType().equals(ModelPackage.Literals.MODEL_ELEMENT__STATE)) {
				TableViewerColumn column = createStateColumn(feature);
				column.setEditingSupport(features.get(feature));
				columns.add(column);
			} else {
				TableViewerColumn column = createGenericColumn(feature);
				column.setEditingSupport(features.get(feature));
				columns.add(column);
			}
		}
		return columns;

	}

	/**
	 * Sets input to METableViewer. The input is a project along with a model element type. METableViwer shows all MEs
	 * of that type.
	 * 
	 * @param project project
	 * @param meType model element type to be shown in METableViwer
	 */
	public void setInput(Project project, EClass meType) {
		this.contentType = meType;
		contentProvider.setMEType(contentType);
		tableViewer.setInput(project);
		tableViewer.refresh();
	}

	/**
	 * set input.
	 * 
	 * @param project project
	 */
	public void setInput(Project project) {
		if (contentType == null) {
			contentType = ModelPackage.eINSTANCE.getModelElement();
		}
		contentProvider.setMEType(contentType);
		tableViewer.setInput(project);
		tableViewer.refresh();
	}

	/**
	 * set input.
	 * 
	 * @param elements elemnts
	 */
	public void setInpu(Collection<? extends ModelElement> elements) {
		tableViewer.setInput(elements);
		tableViewer.refresh();
	}

	/**
	 * @return the tableViewer
	 */
	public TableViewer getTableViewer() {
		return tableViewer;
	}

	/**
	 * @param contentType the contentType to set
	 */
	public void setContentType(EClass contentType) {
		this.contentType = contentType;
	}

	/**
	 * @return the contentType
	 */
	public EClass getContentType() {
		return contentType;
	}

}