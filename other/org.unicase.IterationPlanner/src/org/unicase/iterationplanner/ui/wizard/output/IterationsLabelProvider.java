package org.unicase.iterationplanner.ui.wizard.output;

import org.eclipse.emf.common.notify.AdapterFactory;
import org.eclipse.emf.edit.ui.provider.AdapterFactoryLabelProvider;
import org.eclipse.swt.graphics.Image;
import org.unicase.iterationplanner.planner.PlannedTask;

public class IterationsLabelProvider extends AdapterFactoryLabelProvider {

	private int backlogNumber;

	public IterationsLabelProvider(int backlogNumber, AdapterFactory adapterFactory) {
		super(adapterFactory);
		this.backlogNumber = backlogNumber;
	}

	@Override
	public Image getImage(Object object) {
		if(object instanceof PlannedTask){
			return super.getImage(((PlannedTask) object).getTask().getWorkItem());
			
		}
		return super.getImage(object);
	}

	@Override
	public String getText(Object object) {
		if(object instanceof PlannedTask){
			return ((PlannedTask) object).getTask().getWorkItem().getName();
		}
		if(object instanceof Iteration){
			if(((Iteration) object).getIterationNumber() == backlogNumber){
				return "Backlog";
			}
			return "Iteration " + ((Iteration) object).getIterationNumber();
		}
		
		return super.getText(object);
	}
	
	

}
