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
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Text;
import org.eclipse.swt.widgets.Tree;
import org.unicase.iterationplanner.planner.IterationPlan;
import org.unicase.iterationplanner.planner.PlannedTask;
import org.unicase.iterationplanner.planner.Planner;

public class EditSelectedIterationPlanPage extends WizardPage {

	private IterationPlan iterationPlan;
	private Planner planner;
	private IterationPlan originalIterationPlan;
	private TreeViewer iterationsTreeViewer;
	private Text txtOverallScore;
	private Text txtTaskPrioScore;
	private Text txtExpertiseScore;
	private Text txtDevLoad;

	protected EditSelectedIterationPlanPage(String pageName, IterationPlan iterationPlan, Planner planner) {
		super(pageName);
		this.originalIterationPlan = iterationPlan;
		this.iterationPlan = iterationPlan.clone();
		this.planner = planner;
		
	}

	public void createControl(Composite parent) {
		Composite container = new Composite(parent, SWT.NULL);

		setControl(container);
		container.setLayout(new GridLayout(1, false));
		
		//check invariants must be turned off, in order to manually change iteration plan.
		iterationPlan.setCheckInvariants(false);
		
		List<Iteration> iterations = createIterations();
		
		iterationsTreeViewer = new TreeViewer(container);
		iterationsTreeViewer.getControl().setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true));
		
		iterationsTreeViewer.setContentProvider(new IterationsContentProvider(iterationPlan.getBacklogNumber(), new ComposedAdapterFactory(ComposedAdapterFactory.Descriptor.Registry.INSTANCE)));
		addColumns(iterationsTreeViewer);
		iterationsTreeViewer.setInput(iterations);
		
		createIndicatorsComposite(container);
		
	}
	
	private void createIndicatorsComposite(Composite container) {
		Composite indicatorsComposite = new Composite(container, SWT.BORDER);
		indicatorsComposite.setLayoutData(new GridData(SWT.FILL, SWT.END, true, false));
		indicatorsComposite.setLayout(new GridLayout(4, true));
		
		Label lblDevLoad = new Label(indicatorsComposite, SWT.NONE);
		lblDevLoad.setLayoutData(new GridData(SWT.BEGINNING, SWT.CENTER, false, false));
		lblDevLoad.setText("Developer Load Score: ");
		
		Label lblExperitseScore = new Label(indicatorsComposite, SWT.NONE);
		lblExperitseScore.setLayoutData(new GridData(SWT.BEGINNING, SWT.CENTER, false, false));
		lblExperitseScore.setText("Expertise Score: ");
		
		Label lblTaskPrioScore = new Label(indicatorsComposite, SWT.NONE);
		lblTaskPrioScore.setLayoutData(new GridData(SWT.BEGINNING, SWT.CENTER, false, false));
		lblTaskPrioScore.setText("Task Priority Score: ");
		
		Label lblOverallScore = new Label(indicatorsComposite, SWT.NONE);
		lblOverallScore.setLayoutData(new GridData(SWT.BEGINNING, SWT.CENTER, false, false));
		lblOverallScore.setText("Overall Score: ");
		
		
		txtDevLoad = new Text(indicatorsComposite, SWT.SINGLE | SWT.LEAD | SWT.BORDER);
		txtDevLoad.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false));
		txtDevLoad.setText(String.valueOf(planner.getEvaluator().evaluateAssigneeLoad(iterationPlan)));
		
		txtExpertiseScore = new Text(indicatorsComposite, SWT.SINGLE | SWT.LEAD | SWT.BORDER);
		txtExpertiseScore.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false));
		txtExpertiseScore.setText(String.valueOf(planner.getEvaluator().evaluateExpertise(iterationPlan)));
		
		txtTaskPrioScore = new Text(indicatorsComposite, SWT.SINGLE | SWT.LEAD | SWT.BORDER);
		txtTaskPrioScore.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false));
		txtTaskPrioScore.setText(String.valueOf(planner.getEvaluator().evaluteTaskPriorities(iterationPlan)));
		
		txtOverallScore = new Text(indicatorsComposite, SWT.SINGLE | SWT.LEAD | SWT.BORDER);
		txtOverallScore.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false));
		txtOverallScore.setText(String.valueOf(planner.getEvaluator().evaluate(iterationPlan)));
		
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
		tclAssignee.setEditingSupport(new TaskAssigneeEditingSupport(viewer, planner, iterationPlan, this));


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

	public void update() {
		iterationsTreeViewer.refresh();
		updateIndicatorsComposite();
		
	}

	private void updateIndicatorsComposite() {
		txtDevLoad.setText(String.valueOf(planner.getEvaluator().evaluateAssigneeLoad(iterationPlan)));
		txtExpertiseScore.setText(String.valueOf(planner.getEvaluator().evaluateExpertise(iterationPlan)));
		txtTaskPrioScore.setText(String.valueOf(planner.getEvaluator().evaluteTaskPriorities(iterationPlan)));
		txtOverallScore.setText(String.valueOf(planner.getEvaluator().evaluate(iterationPlan)));
	}

}
