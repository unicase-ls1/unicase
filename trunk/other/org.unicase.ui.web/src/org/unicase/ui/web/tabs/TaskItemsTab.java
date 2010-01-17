package org.unicase.ui.web.tabs;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.eclipse.core.databinding.observable.Realm;
import org.eclipse.core.databinding.observable.list.WritableList;
import org.eclipse.core.databinding.observable.map.IObservableMap;
import org.eclipse.core.databinding.observable.set.IObservableSet;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.impl.AdapterImpl;
import org.eclipse.emf.common.util.BasicEList;
import org.eclipse.emf.databinding.EMFObservables;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.jface.databinding.viewers.ObservableListContentProvider;
import org.eclipse.jface.databinding.viewers.ObservableMapLabelProvider;
import org.eclipse.jface.viewers.TableViewer;
import org.eclipse.jface.viewers.TableViewerColumn;
import org.eclipse.rwt.RWT;
import org.eclipse.swt.SWT;
import org.eclipse.swt.custom.CTabFolder;
import org.eclipse.swt.custom.CTabItem;
import org.eclipse.swt.layout.FillLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Table;
import org.unicase.metamodel.MetamodelPackage;
import org.unicase.metamodel.ModelElement;
import org.unicase.metamodel.Project;
import org.unicase.metamodel.util.ProjectChangeObserver;
import org.unicase.model.ModelPackage;
import org.unicase.model.UnicaseModelElement;
import org.unicase.model.task.Checkable;
import org.unicase.model.task.TaskPackage;
import org.unicase.workspace.ProjectSpace;
import org.unicase.workspace.Workspace;
import org.unicase.workspace.WorkspaceManager;

public class TaskItemsTab implements AbstractTab {

	private boolean isContentCreated;
	private final CTabFolder tabFolder;
	private final CTabItem tabItem;
	
	private TableViewer viewer;
	private Workspace workspace;
	private Project activeProject;
	private AdapterImpl workspaceListenerAdapter;
	private MyProjectListener projListener;
	
	/**
	 * 
	 * @param parent
	 */
	public TaskItemsTab(CTabFolder parent) {
		tabFolder = parent;
		isContentCreated = false;
	    tabItem = new CTabItem( tabFolder, SWT.NONE );
	    tabItem.setText("Task Items");	    
	}
	
	public void createContent() {
		if (!isContentCreated) {
		    Composite com = new Composite(tabFolder, SWT.NONE);
		    createTabContent(com);
		    tabItem.setControl(com);
			isContentCreated = true;
		}
	}
	
	/**
	 * 
	 * @param parent
	 */
	private void createTabContent(Composite parent) {
		HttpServletRequest request = RWT.getRequest();
		String var1 = request.getParameter("startup");
		System.out.println(var1);
		
		parent.setLayout( new FillLayout() );
		
		viewer = new TableViewer(parent,  SWT.MULTI | SWT.H_SCROLL
				| SWT.V_SCROLL | SWT.FULL_SELECTION);
		
		createColumns();
		projListener = new MyProjectListener();
		workspace = WorkspaceManager.getInstance().getCurrentWorkspace();
		workspaceListenerAdapter = new AdapterImpl() {

			@Override
			public void notifyChanged(Notification msg) {
				// if ((msg.getFeatureID(Workspace.class)) == WorkspacePackage.WORKSPACE__ACTIVE_PROJECT_SPACE) {
					ProjectSpace activeProjectSpace = workspace.getProjectSpaces().get(0);
					if (activeProjectSpace != null) {
						activeProject = activeProjectSpace.getProject();
						activeProject.addProjectChangeObserver(projListener);
						
						List<? extends UnicaseModelElement> taskItems = activeProject.getAllModelElementsbyClass(
								TaskPackage.eINSTANCE.getCheckable(), new BasicEList<UnicaseModelElement>());
						WritableList emfList = new WritableList(Realm.getDefault(), taskItems, UnicaseModelElement.class);
						viewer.setInput(emfList);
					} else {
						activeProject = null;
						
						viewer.setInput(activeProject);
					}

				//}
				super.notifyChanged(msg);
			}
		};
		workspace.eAdapters().add(workspaceListenerAdapter);
		
		if (workspace.getProjectSpaces() != null) {
			activeProject = workspace.getProjectSpaces().get(0).getProject();
			activeProject.addProjectChangeObserver(projListener);
		}		
		
//		Layout layout = new GridLayout(2, false);
//		parent(layout);
//		
//		Button button1 = new Button(parent, SWT.PUSH);
//		button1.setText("Write model");
//		button1.addSelectionListener(new SelectionAdapter() {
//
//			@Override
//			public void widgetSelected(SelectionEvent e) {
//				UpdateProjectHandler handler = new UpdateProjectHandler();
//				try {
//					handler.run(workspace.getProjectSpaces().get(0));
//				} catch (EmfStoreException e1) {
//					// TODO Auto-generated catch block
//					e1.printStackTrace();
//				}
//				
//			}
//		});
		
		List<? extends UnicaseModelElement> taskItems = activeProject.getAllModelElementsbyClass(
				TaskPackage.eINSTANCE.getCheckable(), new BasicEList<UnicaseModelElement>());
		
		
		// The content provider is responsible to handle add and
		// remove notification for the 
		ObservableListContentProvider provider = new ObservableListContentProvider();
		viewer.setContentProvider(provider);

		// The label provider in turn handles the attributes of model elements. 
		// The EStructuralFeature[] defines which fields get shown in the TableViewer columns.
		IObservableSet knownElements = provider.getKnownElements();
		
		IObservableMap[] observeMaps = EMFObservables.
			observeMaps(knownElements, new EStructuralFeature[] {
					TaskPackage.Literals.WORK_ITEM__RESOLVED,
					ModelPackage.Literals.UNICASE_MODEL_ELEMENT__STATE,
					ModelPackage.Literals.UNICASE_MODEL_ELEMENT__NAME,
					MetamodelPackage.Literals.MODEL_ELEMENT__CREATION_DATE,
					MetamodelPackage.Literals.MODEL_ELEMENT__CREATOR,
					TaskPackage.Literals.WORK_ITEM__DUE_DATE,
					TaskPackage.Literals.WORK_ITEM__PRIORITY
					} );
		
		
		ObservableMapLabelProvider labelProvider = new ObservableMapLabelProvider(observeMaps);
		viewer.setLabelProvider(labelProvider);

		// first experiment: I tried to get all items in the project. But, it doesn't work.
		// observeList returns only top level leaf sections.
//		viewer.setInput(EMFObservables.observeList(Realm.getDefault(), project,
//				MetamodelPackage.Literals.PROJECT__MODEL_ELEMENTS));
		
		WritableList emfList = new WritableList(Realm.getDefault(), taskItems, UnicaseModelElement.class);
		viewer.setInput(emfList);
	}
		
	
	private class MyProjectListener implements ProjectChangeObserver {

		public void notify(Notification notification, Project project,
				ModelElement modelElement) {
			// TODO Auto-generated method stub
			
		}

		public void modelElementAdded(Project project, ModelElement modelElement) {
			if (modelElement instanceof Checkable) {
				viewer.refresh();
			}
		}

		public void modelElementDeleteStarted(Project project,
				ModelElement modelElement) {
			// TODO Auto-generated method stub
			
		}

		public void modelElementDeleteCompleted(Project project,
				ModelElement modelElement) {
			// TODO Auto-generated method stub
			
		}
		
		
		
	}
	

	private void createColumns(){
		
		String[] titles = { "Open/Res.", "State", "Name", "Creation Date",
				"Creator", "Due Date", "Priority" };
		int[] bounds = { 50, 50, 100, 170, 50, 170, 20 };

		for (int i = 0; i < titles.length; i++) {
			TableViewerColumn column = new TableViewerColumn(viewer, SWT.NONE);
			column.getColumn().setText(titles[i]);
			column.getColumn().setWidth(bounds[i]);
			column.getColumn().setResizable(true);
			column.getColumn().setMoveable(true);
		}
		Table table = viewer.getTable();
		table.setHeaderVisible(true);
		table.setLinesVisible(true);
		
	}

}
