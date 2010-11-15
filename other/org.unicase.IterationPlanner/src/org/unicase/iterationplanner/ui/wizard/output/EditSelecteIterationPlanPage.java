package org.unicase.iterationplanner.ui.wizard.output;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.emf.edit.provider.ComposedAdapterFactory;
import org.eclipse.emf.edit.ui.provider.AdapterFactoryLabelProvider;
import org.eclipse.jface.viewers.ColumnLabelProvider;
import org.eclipse.jface.viewers.TreeViewer;
import org.eclipse.jface.viewers.TreeViewerColumn;
import org.eclipse.jface.wizard.WizardPage;
import org.eclipse.swt.SWT;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Tree;
import org.unicase.iterationplanner.planner.IterationPlan;
import org.unicase.iterationplanner.planner.PlannedTask;
import org.unicase.iterationplanner.planner.Planner;

public class EditSelecteIterationPlanPage extends WizardPage {

	private IterationPlan iterationPlan;
	private Planner planner;
	private IterationPlan originalIterationPlan;

	protected EditSelecteIterationPlanPage(String pageName, IterationPlan iterationPlan, Planner planner) {
		super(pageName);
		this.originalIterationPlan = iterationPlan;
		this.iterationPlan = iterationPlan.clone();
		this.planner = planner;
		
	}

	public void createControl(Composite parent) {
		Composite container = new Composite(parent, SWT.NULL);

		setControl(container);
		container.setLayout(new GridLayout(1, false));
		
		iterationPlan.setCheckInvariants(false);
		List<Iteration> iterations = createIterations();
//		PlannedTask plannedTask = iterationPlan.getAllPlannedTasks().toArray(new PlannedTask[iterationPlan.getAllPlannedTasks().size()])[0];
//		List<AssigneeExpertise> potentialAssignees = planner.getTaskPotentialAssigneeListMap().get(plannedTask.getTask());
//		iterationPlan.setAssigneeFor(plannedTask, potentialAssignees.get(0));
//		iterationPlan.setIterationNumberFor(plannedTask, 0);
//		List<Iteration> iterations = createIterations();
//		double score = planner.getEvaluator().evaluate(iterationPlan);
		
		TreeViewer iterationsTreeViewer = new TreeViewer(container);
		iterationsTreeViewer.getControl().setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true));
		
		iterationsTreeViewer.setContentProvider(new IterationsContentProvider(iterationPlan.getBacklogNumber(), new ComposedAdapterFactory(ComposedAdapterFactory.Descriptor.Registry.INSTANCE)));
		addColumns(iterationsTreeViewer);
		iterationsTreeViewer.setInput(iterations);
		
	}
	
	private void addColumns(TreeViewer viewer) {
		final AdapterFactoryLabelProvider adapterFactoryLabelProvider = new AdapterFactoryLabelProvider(new ComposedAdapterFactory(ComposedAdapterFactory.Descriptor.Registry.INSTANCE));
		Tree tree = viewer.getTree();
		tree.setHeaderVisible(true);

		TreeViewerColumn tclTask = new TreeViewerColumn(viewer, SWT.NONE);
		tclTask.getColumn().setText("Task");
		tclTask.getColumn().setWidth(300);
		tclTask.setLabelProvider(new ColumnLabelProvider(){

			@Override
			public String getText(Object element) {
				if(element instanceof PlannedTask){
					return ((PlannedTask) element).getTask().getWorkItem().getName();
				}
				if(element instanceof Iteration){
					if(((Iteration) element).getIterationNumber() == iterationPlan.getBacklogNumber()){
						return "Backlog";
					}
					return "Iteration " + ((Iteration) element).getIterationNumber();
				}
				
				return "";
			}

			@Override
			public Image getImage(Object element) {
				if(element instanceof PlannedTask){
					return adapterFactoryLabelProvider.getImage(((PlannedTask) element).getTask().getWorkItem());
					
				}
				return super.getImage(element);
			}
		});
		
		TreeViewerColumn tclAssignee = new TreeViewerColumn(viewer, SWT.NONE);
		tclAssignee.getColumn().setText("Assignee");
		tclAssignee.getColumn().setWidth(200);
		tclAssignee.setLabelProvider(new ColumnLabelProvider(){

			@Override
			public String getText(Object element) {
				if(element instanceof PlannedTask){
					return ((PlannedTask) element).getAssigneeExpertise().getAssignee().getOrgUnit().getName() + " (expertise: " + ((PlannedTask) element).getAssigneeExpertise().getExpertise() + ")";
				}
				return "";
			}

			@Override
			public Image getImage(Object element) {
				if(element instanceof PlannedTask){
					return adapterFactoryLabelProvider.getImage(((PlannedTask) element).getAssigneeExpertise().getAssignee().getOrgUnit());
					
				}
				return super.getImage(element);
			}
			
		});
		tclAssignee.setEditingSupport(new TaskAssigneeEditingSupport(viewer, planner, iterationPlan));


	}

	private List<Iteration> createIterations() {
		List<Iteration> result = new ArrayList<Iteration>();
		int numOfIterations = iterationPlan.getNumOfIterations();
		//consider backlog, hence + 1
		for(int i = 0; i < numOfIterations + 1; i++){
			if(i == numOfIterations){
				Iteration backlog = new Iteration(i, iterationPlan.getAllPlannedTasksForIteration(iterationPlan.getBacklogNumber()));
				result.add(backlog);
			}else{
				Iteration iteration = new Iteration(i, iterationPlan.getAllPlannedTasksForIteration(i));
				result.add(iteration);
			}
		}
		
		return result;
	}

}
