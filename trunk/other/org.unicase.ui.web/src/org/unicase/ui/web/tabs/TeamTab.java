package org.unicase.ui.web.tabs;

import java.util.List;
import java.util.ArrayList;
import java.util.Collection;

import org.eclipse.swt.SWT;
import org.eclipse.swt.custom.CTabItem;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.custom.CTabFolder;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.emf.ecore.EcorePackage;
import org.eclipse.emf.common.util.BasicEList;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.databinding.EMFObservables;
import org.eclipse.jface.viewers.TableViewer;
import org.eclipse.jface.viewers.ILabelProvider;
import org.eclipse.jface.viewers.ViewerComparator;
import org.eclipse.jface.viewers.TableViewerColumn;
import org.eclipse.jface.viewers.ColumnLabelProvider;
import org.eclipse.core.databinding.observable.Realm;
import org.eclipse.core.databinding.observable.list.WritableList;
import org.eclipse.core.databinding.observable.map.IObservableMap;
import org.eclipse.core.databinding.observable.set.IObservableSet;
import org.eclipse.jface.databinding.viewers.ObservableMapLabelProvider;
import org.eclipse.jface.databinding.viewers.ObservableListContentProvider;

import org.unicase.metamodel.Project;
import org.unicase.model.ModelPackage;
import org.unicase.metamodel.ModelElement;
import org.unicase.model.organization.User;
import org.unicase.model.organization.Group;
import org.unicase.model.organization.OrgUnit;
import org.unicase.metamodel.MetamodelPackage;
import org.unicase.model.organization.OrganizationPackage;

import org.unicase.web.util.ExampleUtil;
import org.unicase.ui.web.sorters.TableViewerColumnSorter;
import org.unicase.ui.web.labelproviders.StatusLabelProvider;
import org.unicase.ui.web.labelproviders.DateColumnLabelProvider;
import org.unicase.ui.web.labelproviders.GenericColumnLabelProvider;

/**
 * 
 * 
 * @author Fatih Ulusoy
 */
public class TeamTab extends AbstractTab {

	private static final String WIDTH = "width";
	private static final String FEATURE = "feature";
	
	private CTabItem tabItem;
	private CTabFolder tabFolder;
	private Composite tabComposite;
	
	private boolean isContentCreated;
	
	private TableViewer tableViewer;
	private List<TableViewerColumn> columns;
	private ObservableListContentProvider contentProvider;
	
	public TeamTab(CTabFolder parent) {
		tabFolder = parent;
		tabItem = new CTabItem(tabFolder, SWT.NONE);
		tabItem.setText("Team Members");
	    
		Composite composite = new Composite(tabFolder, SWT.NONE);
		composite.setLayout(ExampleUtil.createGridLayout(1, false, 10, 20));
		
		tabComposite = new Composite(composite, SWT.NONE);
		tabComposite.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true));
		tabComposite.setLayout(new GridLayout(2, false));
		
	    tabItem.setControl(composite);
	    
	    contentProvider = new ObservableListContentProvider();
	    createTableViewer();
	    isContentCreated = false;
	}
	
	private void createTableViewer() {		
		columns = new ArrayList<TableViewerColumn>();
		tableViewer = new TableViewer(tabComposite, SWT.BORDER);
		tableViewer.setContentProvider(contentProvider);
		tableViewer.getTable().setLinesVisible(true);
		tableViewer.getTable().setHeaderVisible(true);
		GridData tableData = new GridData(SWT.FILL, SWT.FILL, true, true);
		tableData.horizontalSpan = 2;
		tableViewer.getTable().setLayoutData(tableData);
		tableViewer.refresh();
	}
	
	@Override
	public void createTabContent() {
		if(isContentCreated)
			return;
		
		ArrayList<EStructuralFeature> featureList = getFeatureList();
		EStructuralFeature[] featureArray = new EStructuralFeature[featureList.size()]; 
		featureArray = featureList.toArray(featureArray);
		
		IObservableSet knownElements = contentProvider.getKnownElements();
		IObservableMap[] observeMaps = EMFObservables.observeMaps(knownElements, featureArray);
		ObservableMapLabelProvider labelProvider = new ObservableMapLabelProvider(observeMaps);
		
		createColumns(featureList, labelProvider);
		
		getCurrProject().addProjectChangeObserver(TeamTab.this);

		setInput();	
		isContentCreated = true;
	}
	
	private void setInput() {		

		final WritableList oldItems = (WritableList) (tableViewer.getInput());
		
		if (oldItems == null) {
			List<OrgUnit> teamMembers = getTeamMembers();
			WritableList emfList = new WritableList(Realm.getDefault(), teamMembers, User.class);
			tableViewer.setInput(emfList);
		} else {
			final List<OrgUnit> teamMembers = getTeamMembers();
			
			oldItems.getRealm().asyncExec(new Runnable() {
				public void run() {
					// remove all elements
					oldItems.retainAll(new BasicEList<OrgUnit>());
					// adds 
					oldItems.addAll(teamMembers);
				}
			});
		}
		
	}
	
	private List<OrgUnit> getTeamMembers() {
		
		List<Group> groups = null;
		List<OrgUnit> teamMembers = new BasicEList<OrgUnit>();
		
		if (getCurrProject() != null) {
			groups = getCurrProject().getAllModelElementsbyClass(
					OrganizationPackage.eINSTANCE.getGroup(),
					new BasicEList<Group>());
		}
		
		for(Group group : groups) {
			if(group.getName().toLowerCase().contains(getCurrProjectSpace().getProjectName().toLowerCase()))
				teamMembers = group.getOrgUnits();
		}
		
		return teamMembers;
	}
	
	/**
	 * 
	 * @return feature list of this table.
	 */
	private ArrayList<EStructuralFeature> getFeatureList() {
		ArrayList<EStructuralFeature> list = new ArrayList<EStructuralFeature>();
		list.add(OrganizationPackage.Literals.USER__FIRST_NAME);
		list.add(OrganizationPackage.Literals.USER__LAST_NAME);
		list.add(OrganizationPackage.Literals.USER__EMAIL);
	
		return list;
	}
	
	/**
	 * Creates table viewer columns from this set of features.
	 * 
	 * @param features EStructuralFeatures for each of which a TableViewerColumn is created.
	 * @param labelProvider LabelProvider for some columns.
	 * @return columns
	 */
	private List<TableViewerColumn> createColumns(
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
	
	public void updateInput(Project project, ModelElement modelElement) {
		if (modelElement instanceof OrgUnit) {
			setInput();
		}
	}

}
