package org.unicase.ui.web;

import java.util.List;

import org.eclipse.core.databinding.observable.Realm;
import org.eclipse.core.databinding.observable.list.WritableList;
import org.eclipse.core.databinding.observable.map.IObservableMap;
import org.eclipse.core.databinding.observable.set.IObservableSet;
import org.eclipse.emf.common.util.BasicEList;
import org.eclipse.emf.databinding.EMFObservables;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.jface.databinding.viewers.ObservableListContentProvider;
import org.eclipse.jface.databinding.viewers.ObservableMapLabelProvider;
import org.eclipse.jface.viewers.TableViewer;
import org.eclipse.jface.viewers.TableViewerColumn;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Table;
import org.eclipse.ui.part.ViewPart;
import org.unicase.metamodel.MetamodelPackage;
import org.unicase.model.ModelPackage;
import org.unicase.metamodel.Project;
import org.unicase.model.UnicaseModelElement;
import org.unicase.model.task.ActionItem;
import org.unicase.model.task.TaskPackage;
import org.unicase.model.task.WorkItem;
import org.unicase.model.task.impl.ActionItemImpl;
import org.unicase.workspace.ProjectSpace;
import org.unicase.workspace.Workspace;
import org.unicase.workspace.WorkspaceManager;
import org.unicase.workspace.WorkspacePackage;

public class TableView extends ViewPart {

	public static final String ID = "org.unicase.ui.web.TableView";
	
	private TableViewer viewer;
	
	@Override
	public void createPartControl(Composite parent) {
		
		viewer = new TableViewer(parent,  SWT.MULTI | SWT.H_SCROLL
				| SWT.V_SCROLL | SWT.FULL_SELECTION);
	
		createColumns();
		
		Workspace workspace = WorkspaceManager.getInstance().getCurrentWorkspace();
		Project project = workspace.getProjectSpaces().get(0).getProject();
		
		List<? extends UnicaseModelElement> taskItems = project.getAllModelElementsbyClass(
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
	
	@Override
	public void setFocus() {
		viewer.getControl().setFocus();
	}

}

