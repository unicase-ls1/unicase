package org.unicase.ui.web.tabs;

import java.util.List;
import java.util.ArrayList;
import java.util.Collection;

import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.emf.ecore.EcorePackage;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.jface.viewers.TableViewer;
import org.eclipse.jface.viewers.ILabelProvider;
import org.eclipse.jface.viewers.ViewerComparator;
import org.eclipse.jface.viewers.TableViewerColumn;
import org.eclipse.jface.viewers.ColumnLabelProvider;

import org.unicase.metamodel.Project;
import org.unicase.model.ModelPackage;
import org.unicase.workspace.ProjectSpace;
import org.unicase.metamodel.ModelElement;
import org.unicase.metamodel.MetamodelPackage;
import org.unicase.metamodel.util.ProjectChangeObserver;
import org.unicase.model.organization.OrganizationPackage;
import org.unicase.ui.web.sorters.TableViewerColumnSorter;
import org.unicase.ui.web.labelproviders.StatusLabelProvider;
import org.unicase.ui.web.labelproviders.DateColumnLabelProvider;
import org.unicase.ui.web.labelproviders.GenericColumnLabelProvider;

/**
 * 
 * @author Edgar Müller
 * @author Fatih Ulusoy
 */
public abstract class AbstractListView extends TableViewer implements ProjectChangeObserver {
	
	private final String WIDTH = "width";
	private final String FEATURE = "feature";
	
	private ProjectSpace projectSpace;
	
	private List<TableViewerColumn> columns;
	
	/**
	 * 
	 * @param projectSpace
	 * @param composite
	 */
	public AbstractListView(ProjectSpace projectSpace, Composite composite) {
		super(composite, SWT.BORDER);
		this.projectSpace = projectSpace;
		init();
	}
	
	/**
	 * 
	 */
	protected void init() {
		columns = new ArrayList<TableViewerColumn>();
		getTable().setLinesVisible(true);
		getTable().setHeaderVisible(true);
		getProject().addProjectChangeObserver(this);
	}
	
	/**
	 * 
	 * @return feature list of this table.
	 */
	public abstract ArrayList<EStructuralFeature> getFeatureList();
	
	/**
	 * 
	 */
	public abstract void setListInput();

	/**
	 * 
	 * @param project
	 * @param modelElement
	 */
	public abstract void updateListInput(Project project, ModelElement modelElement);

	
	public ProjectSpace getProjectSpace() {
		return projectSpace;
	}
	
	public Project getProject() {
		return projectSpace.getProject();
	}
	
	/**
	 * Creates table viewer columns from this set of features.
	 * 
	 * @param features
	 *            EStructuralFeatures for each of which a TableViewerColumn is
	 *            created.
	 * @param labelProvider
	 *            LabelProvider for some columns.
	 * @return columns
	 */
	public List<TableViewerColumn> createColumns(
			Collection<EStructuralFeature> features,
			ILabelProvider labelProvider) {
		
		columns = new ArrayList<TableViewerColumn>();
		
		for (EStructuralFeature feature : features) {
			if (feature.getEType().equals(EcorePackage.Literals.EDATE)) {
				columns.add(createDateColumn(feature));
			} else if (feature.getEType().equals(EcorePackage.Literals.EBOOLEAN)) {
				columns.add(createGenericColumn(labelProvider,feature));
			} else if (feature.equals(ModelPackage.Literals.UNICASE_MODEL_ELEMENT__STATE)) {
				columns.add(createStateColumn(feature));
			} else {
				columns.add(createGenericColumn(labelProvider,feature));
			}
		}
		
		return columns;
	}
	
	
	/**
	 * Creates a column.
	 * 
	 * @param labelProvider LabelProvider for column.
	 * @param feature EStructuralFeatures for a TableViewerColumn is created.
	 * @return
	 */
	private TableViewerColumn createGenericColumn(ILabelProvider labelProvider,
			EStructuralFeature feature) {

		int style, width;
		ColumnLabelProvider provider = new GenericColumnLabelProvider(labelProvider, feature);
		
		if (feature.getEType().equals(EcorePackage.Literals.EINT)) {
			style = SWT.CENTER;
			width = 50;
		} else if (feature.getEType().equals(OrganizationPackage.Literals.ORG_UNIT)
			|| feature.getEType().equals(OrganizationPackage.Literals.USER)) {
			style = SWT.CENTER;
			width = 100;
		} else if (feature.getEType().equals(EcorePackage.Literals.EBOOLEAN)) {
			width = 50;
			style = SWT.NONE;
		} else if (feature.equals(MetamodelPackage.Literals.MODEL_ELEMENT__CREATOR)) {
			style = SWT.CENTER;
			width = 100;
		} else if (feature.equals(ModelPackage.Literals.UNICASE_MODEL_ELEMENT__NAME)) {
			width = 300;
			style = SWT.NONE;
		}  else {
			style = SWT.CENTER;
			width = 150;
		}

		TableViewerColumn genericColumn = createColumn(feature, provider, width, style, true, true);
		return genericColumn;
	}
	
	/**
	 * Creates column for state feature.
	 * 
	 * @param feature
	 * @return
	 */
	private TableViewerColumn createStateColumn(EStructuralFeature feature) {
		ColumnLabelProvider labelProvider = new StatusLabelProvider();
		TableViewerColumn stateColumn = createColumn(feature, labelProvider, 35, SWT.CENTER, true, false);
		return stateColumn;
	}
	
	/**
	 * Creates column for date feature.
	 * 
	 * @param feature
	 * @return
	 */
	private TableViewerColumn createDateColumn(EStructuralFeature feature) {
		ColumnLabelProvider provider = new DateColumnLabelProvider(feature);
		TableViewerColumn dateColumn = createColumn(feature, provider, 150, SWT.CENTER, true, true);
		return dateColumn;
	}
	
	/**
	 * All column creation methods should use this method first.
	 * 
	 * @param feature
	 * @param labelProvider
	 * @param width
	 * @param style
	 * @param resizeable
	 * @param setSorter
	 * @return
	 */
	private TableViewerColumn createColumn(EStructuralFeature feature,
			ColumnLabelProvider labelProvider, int width, int style,
			boolean resizeable, boolean setSorter) {
		
		TableViewerColumn column = new TableViewerColumn(this, style);
		
		column.getColumn().setText(feature.getName());
		column.getColumn().setWidth(width);

		column.getColumn().setMoveable(true);
		column.getColumn().setResizable(resizeable);

		column.setLabelProvider(labelProvider);
		if (setSorter) {
			ViewerComparator comp = new TableViewerColumnSorter(this, column, labelProvider);
			column.getViewer().setComparator(comp);
		}
		column.getColumn().setData(WIDTH, new Integer(width));
		column.getColumn().setData(FEATURE, feature.getName());
		return column;
	}
	


	public void modelElementAdded(Project project, ModelElement modelElement) {
		updateListInput(project, modelElement);
	}

	public void modelElementDeleteCompleted(Project project,
			ModelElement modelElement) {
		updateListInput(project, modelElement);
	}

	public void modelElementDeleteStarted(Project project,
			ModelElement modelElement) {
		updateListInput(project, modelElement);
	}

	public void notify(Notification notification, Project project,
			ModelElement modelElement) {
		updateListInput(project, modelElement);
	}

}


