package org.unicase.ui.web.tabs;

import java.util.Iterator;
import java.util.List;
import java.util.ArrayList;
import java.util.Collection;

import org.eclipse.rwt.widgets.ExternalBrowser;
import org.eclipse.swt.SWT;
import org.eclipse.swt.custom.CTabItem;
import org.eclipse.swt.custom.CTabFolder;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.layout.FillLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.TableItem;
import org.eclipse.jface.action.Action;
import org.eclipse.jface.viewers.ILabelProvider;
import org.eclipse.jface.viewers.DoubleClickEvent;
import org.eclipse.jface.viewers.ColumnLabelProvider;
import org.eclipse.jface.viewers.IDoubleClickListener;
import org.eclipse.jface.viewers.TableViewer;
import org.eclipse.jface.viewers.ViewerComparator;
import org.eclipse.jface.viewers.TableViewerColumn;
import org.eclipse.emf.ecore.EcorePackage;
import org.eclipse.emf.common.util.BasicEList;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.databinding.EMFObservables;
import org.eclipse.core.databinding.observable.Realm;
import org.eclipse.core.databinding.observable.list.WritableList;
import org.eclipse.core.databinding.observable.map.IObservableMap;
import org.eclipse.core.databinding.observable.set.IObservableSet;
import org.eclipse.jface.databinding.viewers.ObservableMapLabelProvider;
import org.eclipse.jface.databinding.viewers.ObservableListContentProvider;

import org.unicase.metamodel.Project;
import org.unicase.metamodel.ModelElement;
import org.unicase.metamodel.MetamodelPackage;
import org.unicase.model.ModelPackage;
import org.unicase.model.rationale.Issue;
import org.unicase.model.task.ActionItem;
import org.unicase.model.task.Checkable;
import org.unicase.model.task.TaskPackage;
import org.unicase.model.UnicaseModelElement;
import org.unicase.model.bug.BugReport;
import org.unicase.model.bug.Severity;
import org.unicase.model.change.MergingIssue;
import org.unicase.model.organization.OrganizationPackage;

import org.unicase.workspace.ProjectSpace;
import org.unicase.ui.web.Activator;
import org.unicase.ui.web.labelproviders.DateColumnLabelProvider;
import org.unicase.ui.web.labelproviders.GenericColumnLabelProvider;
import org.unicase.ui.web.labelproviders.StatusLabelProvider;
import org.unicase.ui.web.sorters.TableViewerColumnSorter;


/**
 * TaskItemsTab shows checkables (work items which can be set to done).
 * 
 * @author Fatih Ulusoy
 */
public class TaskItemsTab extends AbstractTab {

	private static final String WIDTH = "width";
	private static final String FEATURE = "feature";
	
	private CTabItem tabItem;
	private CTabFolder tabFolder;
	private Composite tabComposite;
	
	private boolean isContentCreated;
	
	private TableViewer tableViewer;
	private List<TableViewerColumn> columns;
	private ObservableListContentProvider contentProvider;
	
	/**
	 * Constructor.
	 * 
	 * @param parent
	 */
	public TaskItemsTab(CTabFolder parent) {
		tabFolder = parent;
		tabItem = new CTabItem(tabFolder, SWT.NONE);
		tabItem.setText("Task Items");
	    
		tabComposite = new Composite(tabFolder, SWT.NONE);
		tabComposite.setLayout(new FillLayout());
	    tabItem.setControl(tabComposite);
	    
	    contentProvider = new ObservableListContentProvider();
	    createTableViewer(tabComposite);
	    isContentCreated = false;
	}
	
	private void createTableViewer(Composite parent) {
		columns = new ArrayList<TableViewerColumn>();
		tableViewer = new TableViewer(parent, SWT.BORDER);
		tableViewer.setContentProvider(contentProvider);
		tableViewer.getTable().setLinesVisible(true);
		tableViewer.getTable().setHeaderVisible(true);
		tableViewer.refresh();
	}
	
	public void createTabContent() {
		if(isContentCreated)
			return;
		
		ArrayList<EStructuralFeature> featureList = getFeatureList();
		EStructuralFeature[] featureArray = new EStructuralFeature[featureList.size()]; 
		featureArray = featureList.toArray(featureArray);		
		
		IObservableSet knownElements = contentProvider.getKnownElements();
		IObservableMap[] observeMaps = EMFObservables.observeMaps(knownElements, featureArray);
		
		ObservableMapLabelProvider labelProvider = createLabelProvider(observeMaps);
		
		createColumns(featureList,labelProvider);
		
		getCurrProject().addProjectChangeObserver(TaskItemsTab.this);
		
		hookDoubleClickAction();
		setInput();	
		isContentCreated = true;		
	}
	
	private void setInput() {	
		final List<? extends Checkable> taskItems = getCurrProject()
				.getAllModelElementsbyClass(
						TaskPackage.eINSTANCE.getCheckable(),
						new BasicEList<Checkable>());
		
		for (Iterator<? extends Checkable> iterator = taskItems.iterator(); iterator.hasNext();) {
			Checkable item = iterator.next();
			if (item instanceof ActionItem) {
				if (((ActionItem) item).isDone()) {
					iterator.remove();
				}
			} else if (item instanceof BugReport) {
				if (((BugReport) item).isDone()) {
					iterator.remove();
				}
			} else if (item instanceof Issue) {
				if (((Issue) item).getSolution() != null) {
					iterator.remove();
				}
			}
		}
		
		
		final WritableList list = (WritableList) (tableViewer.getInput());
		if (list == null) {
			// the case of first time of input setting to table
			WritableList emfList = new WritableList(Realm.getDefault(),
					taskItems, UnicaseModelElement.class);
			tableViewer.setInput(emfList);
		} else {
			list.getRealm().asyncExec(new Runnable() {

				public void run() {
					// remove all elements
					list.retainAll(new BasicEList<UnicaseModelElement>());
					// adds new task items
					list.addAll(taskItems);
				}
			});
		}
	}
	
	private ObservableMapLabelProvider createLabelProvider(
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

		return labelProvider;
	}
	
	/**
	 * 
	 * @return feature list of this table.
	 */
	private ArrayList<EStructuralFeature> getFeatureList() {
		ArrayList<EStructuralFeature> list = new ArrayList<EStructuralFeature>();
		list.add(ModelPackage.Literals.UNICASE_MODEL_ELEMENT__STATE);
		list.add(ModelPackage.Literals.UNICASE_MODEL_ELEMENT__NAME);
		list.add(TaskPackage.Literals.WORK_ITEM__ASSIGNEE);
		list.add(MetamodelPackage.Literals.MODEL_ELEMENT__CREATION_DATE);
		list.add(MetamodelPackage.Literals.MODEL_ELEMENT__CREATOR);
		list.add(TaskPackage.Literals.WORK_ITEM__CONTAINING_WORKPACKAGE);
		list.add(TaskPackage.Literals.WORK_ITEM__DUE_DATE);
		list.add(TaskPackage.Literals.WORK_ITEM__PRIORITY);
	
		return list;
	}
		
	/**
	 * Hooks a double click action for the table.
	 */
	private void hookDoubleClickAction() {
		final Action doubleClickAction = new Action() {
			@Override
			public void run() {
				setInput();
				int index = tableViewer.getTable().getSelectionIndex();
				TableItem item = tableViewer.getTable().getItem(index);
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

				final ProjectSpace ps = getCurrProjectSpace();

				// remove spaces from the project name
				String projectName = ps.getProjectName().replaceAll(" ", "");
				String projectId = ps.getProjectId().getId();

				String serverUrl = ps.getUsersession().getServerInfo().getUrl();
				int serverPort = ps.getUsersession().getServerInfo().getPort();

				// Assemble the link
				String link = "unicase://" + serverUrl + ":" + serverPort + "/"
						+ projectName + "%" + projectId + "/" + meName + "%"
						+ meId;
				return link;
			}
			
		};
		tableViewer.addDoubleClickListener(new IDoubleClickListener() {
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
		if (modelElement instanceof Checkable) {
			setInput();
		}
	}

}



