/**
 * <copyright> Copyright (c) 2009-2012 Chair of Applied Software Engineering, Technische Universität München (TUM).
 * All rights reserved. This program and the accompanying materials are made available under the terms of
 * the Eclipse Public License v1.0 which accompanies this distribution,
 * and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>
 */
package org.unicase.ui.tableview.viewer;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.EcorePackage;
import org.eclipse.jface.action.Action;
import org.eclipse.jface.resource.JFaceResources;
import org.eclipse.jface.viewers.ArrayContentProvider;
import org.eclipse.jface.viewers.ColumnLabelProvider;
import org.eclipse.jface.viewers.DoubleClickEvent;
import org.eclipse.jface.viewers.EditingSupport;
import org.eclipse.jface.viewers.IDoubleClickListener;
import org.eclipse.jface.viewers.LabelProvider;
import org.eclipse.jface.viewers.TableViewer;
import org.eclipse.jface.viewers.TableViewerColumn;
import org.eclipse.jface.viewers.ViewerComparator;
import org.eclipse.jface.viewers.ViewerFilter;
import org.eclipse.jface.window.Window;
import org.eclipse.swt.SWT;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.ui.dialogs.ListSelectionDialog;
import org.unicase.metamodel.Project;
import org.unicase.model.ModelPackage;
import org.unicase.model.UnicaseModelElement;
import org.unicase.model.organization.OrganizationPackage;
import org.unicase.ui.common.TableViewerColumnSorter;
import org.unicase.ui.tableview.labelproviders.AbstractCheckboxColumnLabelProvider;
import org.unicase.ui.tableview.labelproviders.DateColumnLabelProvider;
import org.unicase.ui.tableview.labelproviders.GenericColumnLabelProvider;
import org.unicase.ui.tableview.labelproviders.StatusLabelProvider;

/**
 * A table viewer for model elements. Note that JFace TableViewer is not intended to be inherited. Therefore this is a
 * wrapper around a JFace TableViewer plus some utility methods to create columns.
 * 
 * @author Zardosht Hodaie
 */
public class METableViewer {

	private static final String WIDTH = "width";
	private static final String FEATURE = "feature";
	private TableViewer tableViewer;
	private EClass contentType;
	private METableViewerContentProvider contentProvider;

	private List<TableViewerColumn> columns;

	/**
	 * Constructor.
	 * 
	 * @param parent parent composite to show METableViewer
	 */
	public METableViewer(Composite parent) {
		contentProvider = new METableViewerContentProvider();
		createTableViewer(parent);

	}

	private void createTableViewer(Composite parent) {
		columns = new ArrayList<TableViewerColumn>();
		tableViewer = new TableViewer(parent, SWT.VIRTUAL | SWT.FULL_SELECTION);
		tableViewer.setContentProvider(contentProvider);
		tableViewer.getTable().setLinesVisible(true);
		tableViewer.getTable().setHeaderVisible(true);
	}

	/**
	 * Constructor. Model element type is used by content provider to filter elements of that type in project. You can
	 * thereafter create columns using createColumsn(meType) or by feeding a list of features to
	 * createColumns(featureList).
	 * 
	 * @param parent parent
	 * @param meType model element type which is to be shown in table viewer
	 */
	public METableViewer(Composite parent, EClass meType) {
		this.contentType = meType;
		contentProvider = new METableViewerContentProvider();
		contentProvider.setMEType(meType);
		createTableViewer(parent);

	}

	private TableViewerColumn createGenericColumn(EStructuralFeature feature) {

		ColumnLabelProvider provider = new GenericColumnLabelProvider(feature);
		int style, width;

		if (feature.getEType().equals(EcorePackage.Literals.EINT)) {
			style = SWT.CENTER;
			width = 50;
		} else if (feature.getEType().equals(OrganizationPackage.Literals.ORG_UNIT)
			|| feature.getEType().equals(OrganizationPackage.Literals.USER)) {
			style = SWT.CENTER;
			width = 100;
		} else if (feature.equals(ModelPackage.Literals.UNICASE_MODEL_ELEMENT__CREATOR)) {
			style = SWT.CENTER;
			width = 100;
		}

		else if (feature.equals(ModelPackage.Literals.UNICASE_MODEL_ELEMENT__NAME)) {
			width = 300;
			style = SWT.NONE;
		}

		else {
			style = SWT.CENTER;
			width = 150;
		}

		TableViewerColumn genericColumn = createColumn(feature, provider, width, style, true, true);

		return genericColumn;
	}

	private TableViewerColumn createStateColumn(EStructuralFeature feature) {
		ColumnLabelProvider labelProvider = new StatusLabelProvider();
		TableViewerColumn stateColumn = createColumn(feature, labelProvider, 35, SWT.CENTER, true, false);
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

	/**
	 * all column creation methods should use this method first.
	 * 
	 * @param feature
	 * @param labelProvider
	 * @param width
	 * @param style
	 * @param resizeable
	 * @param setSorter
	 * @return
	 */
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
		column.getColumn().setData(WIDTH, new Integer(width));
		column.getColumn().setData(FEATURE, feature.getName());
		return column;
	}

	private TableViewerColumn createDateColumn(EStructuralFeature feature) {

		ColumnLabelProvider provider = new DateColumnLabelProvider(feature);
		TableViewerColumn dateColumn = createColumn(feature, provider, 150, SWT.CENTER, true, true);

		return dateColumn;
	}

	/**
	 * Creates a table viewer column for each EStructuralFeature of this model element type. Columns have no editing
	 * support.
	 * 
	 * @param meEClass model element type
	 * @param initialColumns list of feature names to be shown initially. If null, only name is shown.
	 * @param showManyReferences if references with multiplicity many should be shown. if yes, then only the first
	 *            element of referenced objects is shown.
	 */
	public void createColumns(EClass meEClass, Collection<String> initialColumns, boolean showManyReferences) {

		if (initialColumns == null) {
			initialColumns = new ArrayList<String>();
			initialColumns.add(ModelPackage.Literals.UNICASE_MODEL_ELEMENT__NAME.getName());
		}
		tableViewer.getTable().setRedraw(false);
		removeAllColumns();
		List<EStructuralFeature> featuresToShow = new ArrayList<EStructuralFeature>();
		if (!showManyReferences) {
			for (EStructuralFeature feature : meEClass.getEAllStructuralFeatures()) {
				if (!(feature instanceof EReference && ((EReference) feature).isMany())) {
					featuresToShow.add(feature);
				}
			}
		}
		createColumns(featuresToShow);
		hideAllColumns();
		showColumns(initialColumns);
		tableViewer.getTable().setRedraw(true);
		tableViewer.getTable().redraw();

	}

	/**
	 * shows only columns corresponding to these features.
	 * 
	 * @param columnsToShow feature names
	 */
	public void showColumns(Collection<String> columnsToShow) {
		if (columnsToShow.equals(Collections.emptyList())) {
			return;
		}
		for (TableViewerColumn column : columns) {
			if (columnsToShow.contains(column.getColumn().getData(FEATURE))) {
				if (column.getColumn().getWidth() == 0) {
					showColumn(column);
				}
			} else {
				hideColumn(column);
			}
		}
		tableViewer.refresh();
	}

	private void showColumn(TableViewerColumn column) {
		// show column (set its width to its getData(WIDTH))
		Integer width = (Integer) column.getColumn().getData(WIDTH);
		column.getColumn().setWidth(width.intValue());
	}

	/**
	 * hides columns corresponding to these features.
	 * 
	 * @param featureNames feature names
	 */
	public void hideColumns(Collection<String> featureNames) {
		for (TableViewerColumn column : columns) {
			if (featureNames.contains(column.getColumn().getData(FEATURE))) {
				if (column.getColumn().getWidth() > 0) {
					hideColumn(column);
				}
			}
		}
	}

	private void hideColumn(TableViewerColumn column) {
		// hide column. save its current width in setData(WIDTH, currentWidth) and set its width to 0
		if (column.getColumn().getWidth() == 0) {
			return;
		}
		Integer currentWidth = column.getColumn().getWidth();
		column.getColumn().setData(WIDTH, currentWidth);
		column.getColumn().setWidth(0);
	}

	private void hideAllColumns() {
		for (TableViewerColumn column : columns) {
			hideColumn(column);
		}
	}

	/**
	 * removes and disposes columns corresponding to these features.
	 * 
	 * @param featureNames feature names
	 */
	public void removeColumns(Collection<String> featureNames) {
		for (TableViewerColumn column : columns) {
			if (featureNames.contains(column.getColumn().getData(FEATURE))) {
				column.getColumn().dispose();
			}
		}
	}

	/**
	 * removes and disposes all columns.
	 */
	public void removeAllColumns() {
		Iterator<TableViewerColumn> iter = columns.iterator();
		while (iter.hasNext()) {
			TableViewerColumn column = iter.next();
			column.getColumn().dispose();
			iter.remove();
		}
		// for (int i = 0; i < columns.size(); i++) {
		// columns.remove(column);
		// column.getColumn().dispose();
		// }
	}

	/**
	 * show show/hide columns dialog.
	 * 
	 * @return list of columns to be shown
	 */
	public List<String> displayShowHideColumnsDialog() {
		List<String> columnFeatureNames = new ArrayList<String>();
		for (TableViewerColumn column : columns) {
			columnFeatureNames.add((String) column.getColumn().getData(FEATURE));
		}
		ListSelectionDialog showHideColumnsDialog = new ListSelectionDialog(tableViewer.getTable().getShell(),
			columnFeatureNames, new ArrayContentProvider(), new LabelProvider(), "Select columns to be shown:");
		showHideColumnsDialog.setTitle("Show/Hide columns");
		showHideColumnsDialog.setInitialSelections(getVisibleColumns().toArray());
		Object[] resultArray = new Object[0];
		if (showHideColumnsDialog.open() == Window.OK) {
			resultArray = showHideColumnsDialog.getResult();
		}

		List<String> result = new ArrayList<String>();
		for (int i = 0; i < resultArray.length; i++) {
			result.add((String) resultArray[i]);
		}

		return result;
	}

	/**
	 * sets the action that runs upon doble click on elements.
	 * 
	 * @param doubleClickAction double click action
	 */
	public void setDoubleClickAction(final Action doubleClickAction) {
		tableViewer.addDoubleClickListener(new IDoubleClickListener() {
			public void doubleClick(DoubleClickEvent event) {
				doubleClickAction.run();
			}
		});
	}

	/**
	 * Returns feature names of visible columns. You can use it to add new columns to visible columns.
	 * 
	 * @return feature names of visible columns.
	 */
	public List<String> getVisibleColumns() {
		List<String> visibleColumns = new ArrayList<String>();
		for (TableViewerColumn column : columns) {
			if (column.getColumn().getWidth() > 0) {
				visibleColumns.add((String) column.getColumn().getData(FEATURE));
			}
		}
		return visibleColumns;
	}

	/**
	 * Adds a new TabelViewer column at given index.
	 * 
	 * @param index index
	 * @param text header text
	 * @param width width
	 * @param style style (e.g. SWT.CENTER)
	 * @param setSorter if this column can be sorted
	 * @param labelProvider label provider
	 * @param editingSupport editing support
	 */
	public void addCustomColumn(int index, String text, int width, int style, boolean setSorter,
		ColumnLabelProvider labelProvider, EditingSupport editingSupport) {
		TableViewerColumn customColumn = new TableViewerColumn(tableViewer, style, index);
		customColumn.getColumn().setWidth(width);
		customColumn.getColumn().setData(WIDTH, new Integer(width));
		if (text == null || text.equals("")) {
			customColumn.getColumn().setData(FEATURE, "Column " + index);
		} else {
			customColumn.getColumn().setData(FEATURE, text);
		}
		customColumn.getColumn().setText(text);
		customColumn.setEditingSupport(editingSupport);
		if (setSorter) {
			ViewerComparator comp = new TableViewerColumnSorter(tableViewer, customColumn, labelProvider);
			customColumn.getViewer().setComparator(comp);
		}
		customColumn.setLabelProvider(labelProvider);
		columns.add(index, customColumn);
	}

	/**
	 * Creates table viewer columns from this set of features.
	 * 
	 * @param features EStructuralFeatures for each of which a TableViewerColumn is created.
	 * @return columns
	 */
	public List<TableViewerColumn> createColumns(Collection<EStructuralFeature> features) {
		columns = new ArrayList<TableViewerColumn>();
		for (EStructuralFeature feature : features) {
			if (feature.getEType().equals(EcorePackage.Literals.EDATE)) {
				columns.add(createDateColumn(feature));
			} else if (feature.getEType().equals(EcorePackage.Literals.EBOOLEAN)) {
				columns.add(createBooleanColumn(feature));
			} else if (feature.equals(ModelPackage.Literals.UNICASE_MODEL_ELEMENT__STATE)) {
				columns.add(createStateColumn(feature));
			} else {
				columns.add(createGenericColumn(feature));
			}
		}
		return columns;
	}

	/**
	 * Creates columns with editing support.
	 * 
	 * @param featureEditingSupportPairs features.
	 * @return columns
	 */
	public List<TableViewerColumn> createColumnsWithEditingSupport(
		List<FeatureEditignSupportPair<EStructuralFeature, EditingSupport>> featureEditingSupportPairs) {
		columns = new ArrayList<TableViewerColumn>();
		for (FeatureEditignSupportPair<EStructuralFeature, EditingSupport> featureEditingSuportPair : featureEditingSupportPairs) {
			EStructuralFeature feature = featureEditingSuportPair.getFeature();
			EditingSupport editingSupport = featureEditingSuportPair.getEditingSupport();
			if (feature.getEType().equals(EcorePackage.Literals.EDATE)) {
				TableViewerColumn column = createDateColumn(feature);
				column.setEditingSupport(editingSupport);
				columns.add(column);
			} else if (feature.getEType().equals(EcorePackage.Literals.EBOOLEAN)) {
				TableViewerColumn column = createBooleanColumn(feature);
				column.setEditingSupport(editingSupport);
				columns.add(column);
			} else if (feature.equals(ModelPackage.Literals.UNICASE_MODEL_ELEMENT__STATE)) {
				TableViewerColumn column = createStateColumn(feature);
				column.setEditingSupport(editingSupport);
				columns.add(column);
			} else {
				TableViewerColumn column = createGenericColumn(feature);
				column.setEditingSupport(editingSupport);
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
		if (!contentType.getName().equals(meType.getName())) {
			tableViewer.setInput(Collections.emptyList());
			tableViewer.refresh();
			this.contentType = meType;
			createColumns(meType, null, false);
			contentProvider.setMEType(contentType);
			if (project != null) {
				tableViewer.setInput(project);
			}
		} else {
			tableViewer.refresh();
		}

	}

	/**
	 * set input. if content type is null then all model elements are shown.
	 * 
	 * @param project project
	 */
	public void setInput(Project project) {
		if (project == null) {
			tableViewer.setInput(Collections.emptyList());
		} else {
			tableViewer.setInput(project);
		}
		// if (contentType == null) {
		// contentType = ModelPackage.eINSTANCE.getModelElement();
		// }
		// contentProvider.setMEType(contentType);
	}

	/**
	 * set direct input.
	 * 
	 * @param elements elemnts
	 */
	public void setInput(Collection<? extends UnicaseModelElement> elements) {
		tableViewer.setInput(elements);
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

	/**
	 * @return the columns
	 */
	public List<TableViewerColumn> getColumns() {
		return columns;
	}

	/**
	 * adds a filter to table viewer.
	 * 
	 * @param filter filter
	 */
	public void addFilter(ViewerFilter filter) {
		if (filter != null) {
			if (hasFilter(filter)) {
				refresh();
			} else {
				tableViewer.addFilter(filter);
			}
		}
	}

	/**
	 * removes a filter from viewer.
	 * 
	 * @param filter filter
	 */
	public void removeFilter(ViewerFilter filter) {
		if (filter != null) {
			tableViewer.removeFilter(filter);
		}

	}

	/**
	 * if viewer has this filter.
	 * 
	 * @param filter filter
	 * @return boolean
	 */
	private boolean hasFilter(ViewerFilter filter) {
		for (int i = 0; i < tableViewer.getFilters().length; i++) {
			if (tableViewer.getFilters()[i] == filter) {
				return true;
			}
		}
		return false;
	}

	/**
	 * refreshes the underlying table viewer.
	 */
	public void refresh() {
		tableViewer.refresh();
	}

	/**
	 * This class represents a pair of EStructuralFeature and its corresponding EditingSupport. This is used to create
	 * METableViewer columns from a list of features and their editing supports.
	 * 
	 * @author zardosht
	 * @param <K> a type extending {@link EStructuralFeature}
	 * @param <V> a tpye extending {@link EditingSupport}
	 */
	public static class FeatureEditignSupportPair<K extends EStructuralFeature, V extends EditingSupport> {

		private K feature;
		private V editingSupport;

		/**
		 * Constructor.
		 * 
		 * @param feature feature
		 * @param editingSupport editing support
		 */
		public FeatureEditignSupportPair(K feature, V editingSupport) {
			this.feature = feature;
			this.editingSupport = editingSupport;
		}

		/**
		 * returns the structural feature.
		 * 
		 * @see java.util.Map.Entry#getKey()
		 * @return structural feature
		 */
		public K getFeature() {

			return feature;
		}

		/**
		 * returns editing support.
		 * 
		 * @see java.util.Map.Entry#getValue()
		 * @return editing support
		 */
		public V getEditingSupport() {
			return editingSupport;
		}

	}
}
