package org.unicase.iterationplanner.ui.wizard.input;

import java.util.List;

import org.eclipse.emf.edit.provider.ComposedAdapterFactory;
import org.eclipse.emf.edit.ui.provider.AdapterFactoryLabelProvider;
import org.eclipse.jface.viewers.ColumnLabelProvider;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.viewers.TableViewer;
import org.eclipse.jface.viewers.TableViewerColumn;
import org.eclipse.jface.viewers.TreeViewer;
import org.eclipse.jface.wizard.IWizardPage;
import org.eclipse.swt.SWT;
import org.eclipse.swt.graphics.Color;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Event;
import org.eclipse.swt.widgets.Listener;
import org.unicase.iterationplanner.ui.wizard.PlannerBridge;
import org.unicase.iterationplanner.ui.wizard.ProjectBridge;
import org.unicase.model.task.TaskPackage;
import org.unicase.model.task.WorkItem;
import org.unicase.model.task.WorkPackage;

public class DefineTasksPage extends AbstractInputPage {
	
	private static final String PAGE_TITLE = "Define Tasks";
	private static final String PAGE_DESCRIPTION= "Define tasks page description";

	private TreeViewer srcWorkItemsTreeViewer;
	private TableViewer targetWorkItemsTableViewer;
	
	
	
	public DefineTasksPage(String pageName, ProjectBridge projectBridge, PlannerBridge plannerBridge) {
		super(pageName, projectBridge, plannerBridge);
		setTitle(PAGE_TITLE);
		setDescription(PAGE_DESCRIPTION);
	}


	@Override
	protected void createSourceControl(Composite parent) {
		parent.setLayout(new GridLayout());
		
		srcWorkItemsTreeViewer = new TreeViewer(parent);
		srcWorkItemsTreeViewer.getControl().setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true));
		
		srcWorkItemsTreeViewer.setLabelProvider(new AdapterFactoryLabelProvider(new ComposedAdapterFactory(ComposedAdapterFactory.Descriptor.Registry.INSTANCE)));
		srcWorkItemsTreeViewer.setContentProvider(new SourceTasksContentProvider(getProejctBridge(), new ComposedAdapterFactory(ComposedAdapterFactory.Descriptor.Registry.INSTANCE)));
		srcWorkItemsTreeViewer.setInput(new Object());
		
	}


	@Override
	protected void createTargetControl(Composite parent) {
		parent.setLayout(new GridLayout());
		
		
		targetWorkItemsTableViewer = new TableViewer(parent, SWT.FULL_SELECTION | SWT.MULTI);
		targetWorkItemsTableViewer.getControl().setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true));
		
		targetWorkItemsTableViewer.setContentProvider(new TasksToPlanContentProvider(new ComposedAdapterFactory(ComposedAdapterFactory.Descriptor.Registry.INSTANCE)));
		
		targetWorkItemsTableViewer.getTable().setHeaderVisible(true);
		final TasksToPlanLabelProvider tasksToPlanLabelProvider = new TasksToPlanLabelProvider(new ComposedAdapterFactory(ComposedAdapterFactory.Descriptor.Registry.INSTANCE));
		TableViewerColumn tclTask = new TableViewerColumn(targetWorkItemsTableViewer, SWT.LEFT);
		tclTask.getColumn().setText("Task");
		tclTask.getColumn().setWidth(100);
		tclTask.setLabelProvider(new ColumnLabelProvider(){
			@Override
			public String getText(Object element) {
				if(element instanceof WorkItem){
					return ((WorkItem)element).getName();
				}
				return super.getText(element);
			}

			@Override
			public Image getImage(Object element) {
				return tasksToPlanLabelProvider.getImage(element);
			}

			@Override
			public Color getBackground(Object element) {
				return tasksToPlanLabelProvider.getBackground(element);
			}
			
			
		});
		
		TableViewerColumn tclPriority = new TableViewerColumn(targetWorkItemsTableViewer, SWT.LEFT);
		tclPriority.getColumn().setText("Priority");
		tclPriority.setLabelProvider(new ColumnLabelProvider(){
			@Override
			public String getText(Object element) {
				if(element instanceof WorkItem){
					return String.valueOf(((WorkItem)element).getPriority());
				}
				return super.getText(element);
			}
			
			@Override
			public Color getBackground(Object element) {
				return tasksToPlanLabelProvider.getBackground(element);
			}
			
			
		});
		tclPriority.setEditingSupport(new IntegerEditingSupport(targetWorkItemsTableViewer, TaskPackage.Literals.WORK_ITEM__PRIORITY));
				
		TableViewerColumn tclEstimate = new TableViewerColumn(targetWorkItemsTableViewer, SWT.LEFT);
		tclEstimate.getColumn().setText("Estimate");
		tclEstimate.setLabelProvider(new ColumnLabelProvider(){
			@Override
			public String getText(Object element) {
				if(element instanceof WorkItem){
					return String.valueOf(((WorkItem)element).getEstimate());
				}
				return super.getText(element);
			}
			
			@Override
			public Color getBackground(Object element) {
				return tasksToPlanLabelProvider.getBackground(element);
			}
			
		});
		tclEstimate.setEditingSupport(new IntegerEditingSupport(targetWorkItemsTableViewer, TaskPackage.Literals.WORK_ITEM__ESTIMATE));
		
		TableViewerColumn tclWorkPackage = new TableViewerColumn(targetWorkItemsTableViewer, SWT.LEFT);
		tclWorkPackage.getColumn().setText("Work Package");
		tclWorkPackage.getColumn().setWidth(100);
		tclWorkPackage.setLabelProvider(new ColumnLabelProvider(){
			@Override
			public String getText(Object element) {
				if(element instanceof WorkItem){
					String value = "";
					WorkPackage containingWorkpackage = ((WorkItem) element).getContainingWorkpackage();
					while(containingWorkpackage != null){
						value = containingWorkpackage.getName() + "/" + value;
						containingWorkpackage = containingWorkpackage.getContainingWorkpackage();
					}
					return value;
				}
				return super.getText(element);
			}
			
			@Override
			public Color getBackground(Object element) {
				return tasksToPlanLabelProvider.getBackground(element);
			}
			
		});
		
		  // Pack the columns
	    for (int i = 0; i < targetWorkItemsTableViewer.getTable().getColumnCount(); i++) {
	      targetWorkItemsTableViewer.getTable().getColumn(i).pack();
	    }
	    targetWorkItemsTableViewer.getTable().setLinesVisible(true);
	    targetWorkItemsTableViewer.getTable().addListener(SWT.MouseUp, new Listener() {
			public void handleEvent(Event event) {
				getWizard().getContainer().updateButtons();
			}
		});
		
		targetWorkItemsTableViewer.setInput(new Object());
		
	}


	@Override
	protected void onAddAllClicked() {
		
	}


	@Override
	protected void onAddClicked() {
		TasksToPlanContentProvider targetContentProvider = (TasksToPlanContentProvider) targetWorkItemsTableViewer.getContentProvider();
		SourceTasksContentProvider srcContentProvider = (SourceTasksContentProvider) srcWorkItemsTreeViewer.getContentProvider();
		
		IStructuredSelection ssel = (IStructuredSelection) srcWorkItemsTreeViewer.getSelection();
		for(Object obj : ssel.toList()){
			WorkItem wi = (WorkItem) obj;
			targetContentProvider.addWorkItem(wi);
			srcContentProvider.removeWorkItem(wi);
		}
		targetWorkItemsTableViewer.refresh();
		srcWorkItemsTreeViewer.refresh();
		getWizard().getContainer().updateButtons();
	}


	@Override
	protected void onRemoveAllClicked() {
		
	}


	@Override
	protected void onRemoveClicked() {
		TasksToPlanContentProvider targetContentProvider = (TasksToPlanContentProvider) targetWorkItemsTableViewer.getContentProvider();
		SourceTasksContentProvider srcContentProvider = (SourceTasksContentProvider) srcWorkItemsTreeViewer.getContentProvider();
		IStructuredSelection ssel = (IStructuredSelection) targetWorkItemsTableViewer.getSelection();
		for(Object obj : ssel.toList()){
			targetContentProvider.removeWorkItem((WorkItem) obj);
			srcContentProvider.addWorkItem((WorkItem) obj);
			
		}	
		targetWorkItemsTableViewer.refresh();
		srcWorkItemsTreeViewer.refresh();
		getWizard().getContainer().updateButtons();
		
	}


	

	@Override
	protected boolean hasExtraControls() {
		return false;
	}


	@Override
	protected String getSourceControlDescription() {
		return "All undone work items in the project: ";
	}


	@Override
	protected String getTargetContorlDescription() {
		return "Tasks to be planned: ";
	}


	@Override
	public boolean isPageComplete() {
		if(isEverythingOk()){
			return true;
		}
		return false;
	}


	private boolean isEverythingOk() {
		List<WorkItem> workItemsToPlan = ((TasksToPlanContentProvider)targetWorkItemsTableViewer.getContentProvider()).getWorkItemsToPlan();
		if (workItemsToPlan.size() == 0){
			return false;
		}
		for(WorkItem wi : workItemsToPlan){
			if(!hasPrioAndEstimateSet(wi)){
				return false;
			}
		}
		return true;
	}


	private boolean hasPrioAndEstimateSet(WorkItem wi) {
		return wi.getEstimate() != 0 && wi.getPriority() != 0;
	}


	private void saveModel() {
		getPlannerBridge().setWorkItems(((TasksToPlanContentProvider)targetWorkItemsTableViewer.getContentProvider()).getWorkItemsToPlan());
	}


	@Override
	public IWizardPage getNextPage() {
		 if (isEverythingOk()){
			saveModel();
			return ((IterationPlanningInputWizard)getWizard()).getDefineAssigneesPage();
		 }  
		 return null;
	}
	
}
