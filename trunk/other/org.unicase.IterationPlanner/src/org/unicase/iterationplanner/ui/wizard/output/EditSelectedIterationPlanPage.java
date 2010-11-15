package org.unicase.iterationplanner.ui.wizard.output;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.emf.edit.provider.ComposedAdapterFactory;
import org.eclipse.emf.edit.ui.dnd.LocalTransfer;
import org.eclipse.emf.edit.ui.provider.AdapterFactoryLabelProvider;
import org.eclipse.jface.viewers.ColumnLabelProvider;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.viewers.TreeViewer;
import org.eclipse.jface.viewers.TreeViewerColumn;
import org.eclipse.jface.wizard.WizardPage;
import org.eclipse.swt.SWT;
import org.eclipse.swt.dnd.DND;
import org.eclipse.swt.dnd.DragSourceEvent;
import org.eclipse.swt.dnd.DragSourceListener;
import org.eclipse.swt.dnd.DropTargetEvent;
import org.eclipse.swt.dnd.DropTargetListener;
import org.eclipse.swt.dnd.Transfer;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.events.SelectionListener;
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
	private PlannedTask dragSource;
	private List<Iteration> iterations;

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
		
		iterations = createIterations();
		
		iterationsTreeViewer = new TreeViewer(container);
		iterationsTreeViewer.getControl().setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true));
		
		iterationsTreeViewer.setContentProvider(new IterationsContentProvider(iterationPlan.getBacklogNumber(), new ComposedAdapterFactory(ComposedAdapterFactory.Descriptor.Registry.INSTANCE)));
		addColumns(iterationsTreeViewer);
		int ops = DND.DROP_MOVE;
		Transfer[] transfers = new Transfer[] { LocalTransfer.getInstance()};
		iterationsTreeViewer.addDragSupport(ops, transfers, new DragSourceListener() {
			
			public void dragStart(DragSourceEvent event) {
				IStructuredSelection ssel = (IStructuredSelection) iterationsTreeViewer.getSelection();
				if(ssel.getFirstElement() instanceof PlannedTask){
					dragSource = (PlannedTask)ssel.getFirstElement();
				}
			}
			
			public void dragSetData(DragSourceEvent event) {
			}
			
			public void dragFinished(DragSourceEvent event) {
			}
		});
		
		iterationsTreeViewer.addDropSupport(ops, transfers, new DropTargetListener() {
			
			public void dropAccept(DropTargetEvent event) {
			}
			
			public void drop(DropTargetEvent event) {
				if(event.item.getData() instanceof Iteration){
					Iteration targetIter = (Iteration)event.item.getData();
					if(dragSource.getIterationNumber() != targetIter.getIterationNumber()){
						iterations.get(dragSource.getIterationNumber()).getPlannedTasks().remove(dragSource);
						targetIter.getPlannedTasks().add(dragSource);
						iterationPlan.setIterationNumberFor(dragSource, targetIter.getIterationNumber());
						
					}
				}
				if(event.item.getData() instanceof PlannedTask){
					PlannedTask pt = (PlannedTask)event.item.getData();
					int targetIterationNumber = pt.getIterationNumber();
					if(dragSource.getIterationNumber() != targetIterationNumber){
						iterations.get(dragSource.getIterationNumber()).getPlannedTasks().remove(dragSource);
						iterations.get(targetIterationNumber).getPlannedTasks().add(dragSource);
						iterationPlan.setIterationNumberFor(dragSource, targetIterationNumber);
					}
				}
				update();
			}
			
			public void dragOver(DropTargetEvent event) {
				
			}
			
			public void dragOperationChanged(DropTargetEvent event) {
				
			}
			
			public void dragLeave(DropTargetEvent event) {
				
			}
			
			public void dragEnter(DropTargetEvent event) {
				
			}
		});

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
		
		org.eclipse.swt.widgets.Button btnReset = new org.eclipse.swt.widgets.Button(indicatorsComposite, SWT.PUSH);
		btnReset.setLayoutData(new GridData(SWT.BEGINNING, SWT.CENTER, false, false));
		btnReset.setText("reset plan");
		btnReset.addSelectionListener(new SelectionListener() {
			
			public void widgetSelected(SelectionEvent e) {
				iterationPlan = originalIterationPlan.clone();
				iterations = createIterations();
				iterationsTreeViewer.setInput(iterations);
				update();
			}
			
			public void widgetDefaultSelected(SelectionEvent e) {
				
			}
		});
		
		
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
					PlannedTask pt = (PlannedTask) element;
					return pt.getTask().getWorkItem().getName() + " (priority: " + pt.getTask().getPriority() + ", estimate: " + pt.getTask().getEstimate() + ")";
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
