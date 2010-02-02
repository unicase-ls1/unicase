package org.unicase.ui.web.tabs;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

import org.eclipse.core.databinding.observable.Realm;
import org.eclipse.core.databinding.observable.list.WritableList;
import org.eclipse.core.databinding.observable.map.IObservableMap;
import org.eclipse.core.databinding.observable.set.IObservableSet;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.util.BasicEList;
import org.eclipse.emf.databinding.EMFObservables;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.EcorePackage;
import org.eclipse.jface.action.Action;
import org.eclipse.jface.databinding.viewers.ObservableListContentProvider;
import org.eclipse.jface.databinding.viewers.ObservableMapLabelProvider;
import org.eclipse.jface.viewers.ColumnLabelProvider;
import org.eclipse.jface.viewers.DoubleClickEvent;
import org.eclipse.jface.viewers.IDoubleClickListener;
import org.eclipse.jface.viewers.ILabelProvider;
import org.eclipse.jface.viewers.TableViewer;
import org.eclipse.jface.viewers.TableViewerColumn;
import org.eclipse.jface.viewers.ViewerComparator;
import org.eclipse.rwt.widgets.ExternalBrowser;
import org.eclipse.swt.SWT;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.TableItem;
import org.unicase.metamodel.MetamodelPackage;
import org.unicase.metamodel.ModelElement;
import org.unicase.metamodel.Project;
import org.unicase.metamodel.util.ProjectChangeObserver;
import org.unicase.model.ModelPackage;
import org.unicase.model.UnicaseModelElement;
import org.unicase.model.bug.BugReport;
import org.unicase.model.bug.Severity;
import org.unicase.model.change.MergingIssue;
import org.unicase.model.organization.OrgUnit;
import org.unicase.model.organization.OrganizationPackage;
import org.unicase.model.organization.User;
import org.unicase.model.rationale.Issue;
import org.unicase.model.task.ActionItem;
import org.unicase.model.task.Checkable;
import org.unicase.model.task.TaskPackage;
import org.unicase.ui.web.Activator;
import org.unicase.ui.web.labelproviders.DateColumnLabelProvider;
import org.unicase.ui.web.labelproviders.GenericColumnLabelProvider;
import org.unicase.ui.web.labelproviders.StatusLabelProvider;
import org.unicase.ui.web.sorters.TableViewerColumnSorter;
import org.unicase.workspace.ProjectSpace;

public abstract class AbstractListView extends TableViewer implements ProjectChangeObserver {
	
	private static final String WIDTH = "width";
	private static final String FEATURE = "feature";
	
	private boolean isContentCreated;
	
	private ProjectSpace projectSpace;
	private List<TableViewerColumn> columns;
	private ObservableListContentProvider contentProvider;
	
	public AbstractListView(ProjectSpace projectSpace, Composite composite) {
		super(composite, SWT.BORDER);
		this.setProjectSpace(projectSpace);
		init();
	}
	
	protected void init() {
		columns = new ArrayList<TableViewerColumn>();
		setContentProvider(contentProvider);
		getTable().setLinesVisible(true);
		getTable().setHeaderVisible(true);
	}
	
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
		
//		projectObserver.getCurrProject().addProjectChangeObserver(AbstractListView.this);

		setListInput();	
		isContentCreated = true;
	}
	
	public void createLabelProvider(
			IObservableMap[] observeMaps) {

		ObservableMapLabelProvider labelProvider = new ObservableMapLabelProvider(
				observeMaps) {

			public Image getImage(Object element) {
				Image image = null;
				if (element instanceof BugReport) {
					BugReport bugReport = (BugReport) element;
					Severity sev = bugReport.getSeverity();
					switch (sev.getValue()) {
					case Severity.MAJOR_VALUE:
						image = Activator.getImageDescriptor(
								"icons/obj16/Bug_major.png").createImage();
						break;
					case Severity.MINOR_VALUE:
						image = Activator.getImageDescriptor(
								"icons/obj16/Bug_minor.png").createImage();
						break;
					case Severity.FEATURE_VALUE:
						image = Activator.getImageDescriptor(
								"icons/obj16/Bug_feature.png").createImage();
						break;
					case Severity.BLOCKER_VALUE:
						image = Activator.getImageDescriptor(
								"icons/obj16/Bug_bloker.png").createImage();
						break;
					case Severity.TRIVIAL_VALUE:
						image = Activator.getImageDescriptor(
								"icons/obj16/Bug_trivial.png").createImage();
						break;
					default:
						image = Activator.getImageDescriptor(
								"icons/obj16/BugReport.png").createImage();
					}
				} else if (element instanceof MergingIssue) {
					image = Activator.getImageDescriptor(
							"icons/obj16/MergingIssue.gif").createImage();
				} else if (element instanceof Issue) {
					image = Activator.getImageDescriptor(
							"icons/obj16/Issue.gif").createImage();
				} else {
					image = Activator.getImageDescriptor(
							"icons/obj16/ActionItem.png").createImage();
				}

				return image;
			}

		};

		setLabelProvider(labelProvider);
	}
	
	/**
	 * 
	 * @return feature list of this table.
	 */
	public abstract ArrayList<EStructuralFeature> getFeatureList();
	
	public abstract void setListInput();
	
	/**
	 * Hooks a double click action for the table.
	 */
	private void hookDoubleClickAction() {
		final Action doubleClickAction = new Action() {
			@Override
			public void run() {
				setListInput();
				int index = getTable().getSelectionIndex();
				TableItem item = getTable().getItem(index);
				UnicaseModelElement element = (UnicaseModelElement) item.getData();
				String link = createLink(element);
				
				int style = ExternalBrowser.LOCATION_BAR
						| ExternalBrowser.NAVIGATION_BAR
						| ExternalBrowser.STATUS;
				ExternalBrowser.open("someId", link, style);
			}
			
			private String createLink(UnicaseModelElement me) {
				String meName = ((UnicaseModelElement) me).getName().replaceAll(" ", "");
				// Get model element id
				String meId = me.getModelElementId().getId();

				// remove spaces from the project name
				String projectName = getProjectSpace().getProjectName().replaceAll(" ", "");
				String projectId = getProjectSpace().getProjectId().getId();

				String serverUrl = getProjectSpace().getUsersession().getServerInfo().getUrl();
				int serverPort = getProjectSpace().getUsersession().getServerInfo().getPort();

				// Assemble the link
				String link = "unicase://" + serverUrl + ":" + serverPort + "/"
						+ projectName + "%" + projectId + "/" + meName + "%"
						+ meId;
				return link;
			}
			
		};
		addDoubleClickListener(new IDoubleClickListener() {
			public void doubleClick(DoubleClickEvent event) {
				doubleClickAction.run();
			}
		});
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
	
	public void updateInput(Project project, ModelElement modelElement) {
		if (modelElement instanceof Checkable) {
			setListInput();
		}
	}

	public void modelElementAdded(Project project, ModelElement modelElement) {
		// TODO Auto-generated method stub
		
	}

	public void modelElementDeleteCompleted(Project project,
			ModelElement modelElement) {
		// TODO Auto-generated method stub
		
	}

	public void modelElementDeleteStarted(Project project,
			ModelElement modelElement) {
		// TODO Auto-generated method stub
		
	}

	public void notify(Notification notification, Project project,
			ModelElement modelElement) {
		// TODO Auto-generated method stub
		
	}

	private void setProjectSpace(ProjectSpace projectSpace) {
		this.projectSpace = projectSpace;
	}

	public ProjectSpace getProjectSpace() {
		return projectSpace;
	}
	
	public Project getProject() {
		return projectSpace.getProject();
	}
}
