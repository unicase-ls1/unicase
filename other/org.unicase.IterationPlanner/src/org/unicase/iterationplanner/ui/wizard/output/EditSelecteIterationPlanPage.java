package org.unicase.iterationplanner.ui.wizard.output;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.emf.edit.provider.ComposedAdapterFactory;
import org.eclipse.jface.viewers.TreeViewer;
import org.eclipse.jface.wizard.WizardPage;
import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;
import org.unicase.iterationplanner.planner.IterationPlan;

public class EditSelecteIterationPlanPage extends WizardPage {

	private IterationPlan iterationPlan;

	protected EditSelecteIterationPlanPage(String pageName, IterationPlan iterationPlan) {
		super(pageName);
		this.iterationPlan = iterationPlan;
		
	}

	public void createControl(Composite parent) {
		Composite container = new Composite(parent, SWT.NULL);

		setControl(container);
		container.setLayout(new GridLayout(1, false));
		
		List<Iteration> iterations = createIterations();
		
		TreeViewer iterationsTreeViewer = new TreeViewer(container);
		iterationsTreeViewer.getControl().setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true));
		
		iterationsTreeViewer.setLabelProvider(new IterationsLabelProvider(iterationPlan.getBacklogNumber(), new ComposedAdapterFactory(ComposedAdapterFactory.Descriptor.Registry.INSTANCE)));
		iterationsTreeViewer.setContentProvider(new IterationsContentProvider(iterationPlan.getBacklogNumber(), new ComposedAdapterFactory(ComposedAdapterFactory.Descriptor.Registry.INSTANCE)));
		iterationsTreeViewer.setInput(iterations);
		
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
