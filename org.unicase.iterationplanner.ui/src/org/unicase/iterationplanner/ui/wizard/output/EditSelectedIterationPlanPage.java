package org.unicase.iterationplanner.ui.wizard.output;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

import org.eclipse.emf.edit.provider.ComposedAdapterFactory;
import org.eclipse.emf.edit.ui.dnd.LocalTransfer;
import org.eclipse.emf.edit.ui.provider.AdapterFactoryLabelProvider;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.jface.viewers.ColumnLabelProvider;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.viewers.TreeViewer;
import org.eclipse.jface.viewers.TreeViewerColumn;
import org.eclipse.jface.viewers.ViewerComparator;
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
import org.unicase.iterationplanner.assigneerecommender.Assignee;
import org.unicase.iterationplanner.assigneerecommender.Task;
import org.unicase.iterationplanner.planner.AbstractPlanner;
import org.unicase.iterationplanner.planner.IIterationPlan;
import org.unicase.iterationplanner.planner.IPlannedTask;

public class EditSelectedIterationPlanPage extends WizardPage {

	private IIterationPlan iterationPlan;
	private AbstractPlanner planner;
	private IIterationPlan originalIterationPlan;
	private TreeViewer iterationsTreeViewer;
	private Text txtOverallScore;
	private Text txtTaskPrioScore;
	private Text txtExpertiseScore;
	private Text txtDevLoad;
	private IPlannedTask dragSource;
	private List<Iteration> iterations;
	
	private Stack<AbstractChangeIterationPlanCommand> commandStack = new Stack<AbstractChangeIterationPlanCommand>();
	public Stack<AbstractChangeIterationPlanCommand> getCommandStack() {
		return commandStack;
	}

	private Stack<AbstractChangeIterationPlanCommand> undoneCommandStack = new Stack<AbstractChangeIterationPlanCommand>();

	protected EditSelectedIterationPlanPage(String pageName, IIterationPlan iterationPlan, AbstractPlanner planner) {
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
		
		iterationsTreeViewer = new TreeViewer(container, SWT.FULL_SELECTION);
		iterationsTreeViewer.getControl().setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true));
		
		iterationsTreeViewer.setContentProvider(new IterationsContentProvider(iterationPlan.getBacklogNumber(), new ComposedAdapterFactory(ComposedAdapterFactory.Descriptor.Registry.INSTANCE)));
		addColumns(iterationsTreeViewer);
		int ops = DND.DROP_MOVE;
		Transfer[] transfers = new Transfer[] { LocalTransfer.getInstance()};
		iterationsTreeViewer.addDragSupport(ops, transfers, new DragSourceListener() {
			
			public void dragStart(DragSourceEvent event) {
				IStructuredSelection ssel = (IStructuredSelection) iterationsTreeViewer.getSelection();
				if(ssel.getFirstElement() instanceof IPlannedTask){
					dragSource = (IPlannedTask)ssel.getFirstElement();
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
				int oldIterationNumber = dragSource.getIterationNumber();
				Iteration oldIteration = iterations.get(oldIterationNumber);
				int newIterationNumber = 0;
				Iteration newIteration = null;
				if(event.item.getData() instanceof Iteration){
					newIteration = (Iteration)event.item.getData();
					newIterationNumber = newIteration.getIterationNumber();
					if(oldIterationNumber != newIterationNumber){
						oldIteration.getPlannedTasks().remove(dragSource);
						newIteration.getPlannedTasks().add(dragSource);
						iterationPlan.setIterationNumberFor(dragSource, newIterationNumber);
						
					}
				}
				if(event.item.getData() instanceof IPlannedTask){
					IPlannedTask pt = (IPlannedTask)event.item.getData();
					newIterationNumber = pt.getIterationNumber();
					newIteration = iterations.get(newIterationNumber);
					if(oldIterationNumber != newIterationNumber){
						oldIteration.getPlannedTasks().remove(dragSource);
						newIteration.getPlannedTasks().add(dragSource);
						iterationPlan.setIterationNumberFor(dragSource, newIterationNumber);
					}
				}
				commandStack.push(new ChangeIterationCommand(dragSource, newIterationNumber, oldIterationNumber, newIteration, oldIteration, iterationPlan));
				update();
			}
			
			public void dragOver(DropTargetEvent event) {
				event.feedback |= DND.FEEDBACK_SCROLL;
			}
			
			public void dragOperationChanged(DropTargetEvent event) {
				
			}
			
			public void dragLeave(DropTargetEvent event) {
				
			}
			
			public void dragEnter(DropTargetEvent event) {
				
			}
		});
		
		iterationsTreeViewer.setComparator(new ViewerComparator());
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
				boolean yes = MessageDialog.openQuestion(getShell(), "Reset Iteration Plan", "Are you sure you want to reset your changes? This cannot be undone.");
				if(yes){
					iterationPlan = originalIterationPlan.clone();
					iterations = createIterations();
					iterationsTreeViewer.setInput(iterations);
					commandStack.empty();
					undoneCommandStack.empty();
					update();
				}
			}
			
			public void widgetDefaultSelected(SelectionEvent e) {
				
			}
		});
		
		org.eclipse.swt.widgets.Button btnUndo = new org.eclipse.swt.widgets.Button(indicatorsComposite, SWT.PUSH);
		btnUndo.setLayoutData(new GridData(SWT.BEGINNING, SWT.CENTER, false, false));
		btnUndo.setText("Undo");
		btnUndo.addSelectionListener(new SelectionListener() {
			
			public void widgetSelected(SelectionEvent e) {
				AbstractChangeIterationPlanCommand lastCommand = commandStack.pop();
				lastCommand.undo();
				undoneCommandStack.push(lastCommand);
				update();
			}
			
			public void widgetDefaultSelected(SelectionEvent e) {
				
			}
		});
		
		org.eclipse.swt.widgets.Button btnRedo = new org.eclipse.swt.widgets.Button(indicatorsComposite, SWT.PUSH);
		btnRedo.setLayoutData(new GridData(SWT.BEGINNING, SWT.CENTER, false, false));
		btnRedo.setText("Redo");
		btnRedo.addSelectionListener(new SelectionListener() {
			
			

			public void widgetSelected(SelectionEvent e) {
				AbstractChangeIterationPlanCommand lastUndoneCommand = undoneCommandStack.pop();
				lastUndoneCommand.redo();
				commandStack.push(lastUndoneCommand);
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
				if(element instanceof IPlannedTask){
					IPlannedTask pt = (IPlannedTask) element;
					String name = pt.getTask().getName();
					String result = "";
					int priority = pt.getTask().getPriority();
					int estimate = pt.getTask().getEstimate();
					if(name.length() > 100){
						result = String.format("%.100s... (priority: %d, estimate: %d)", name, priority, estimate);
					}else{
						result = String.format("%s (priority: %d, estimate: %d)", name, priority, estimate);
					}
					return result;
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
				if(element instanceof IPlannedTask){
					return adapterFactoryLabelProvider.getImage(((Task)((IPlannedTask) element).getTask()).getWorkItem());
					
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
				if(element instanceof IPlannedTask){
					double expertise = ((IPlannedTask) element).getAssigneeExpertise().getExpertise();
					return String.format("%s (expertise: %1.3f)", ((IPlannedTask) element).getAssigneeExpertise().getAssignee().getName(),  expertise);
				}
				return "";
			}

			@Override
			public Image getImage(Object element) {
				if(element instanceof IPlannedTask){
					return adapterFactoryLabelProvider.getImage(((Assignee)((IPlannedTask) element).getAssigneeExpertise().getAssignee()).getOrgUnit());
					
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
