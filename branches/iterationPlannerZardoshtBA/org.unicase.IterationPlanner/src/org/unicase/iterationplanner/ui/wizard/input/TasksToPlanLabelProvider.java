package org.unicase.iterationplanner.ui.wizard.input;

import org.eclipse.emf.common.notify.AdapterFactory;
import org.eclipse.emf.edit.ui.provider.AdapterFactoryLabelProvider;
import org.eclipse.swt.SWT;
import org.eclipse.swt.graphics.Color;
import org.eclipse.swt.widgets.Display;
import org.unicase.model.task.WorkItem;

public class TasksToPlanLabelProvider extends AdapterFactoryLabelProvider {

	public TasksToPlanLabelProvider(AdapterFactory adapterFactory) {
		super(adapterFactory);
	}


	@Override
	public Color getBackground(Object object) {
		WorkItem wi = (WorkItem) object;
		if(wi.getEstimate() == 0){
			return Display.getCurrent().getSystemColor(SWT.COLOR_RED);
		}
		if(wi.getPriority() == 0) {
			return Display.getCurrent().getSystemColor(SWT.COLOR_RED);
		}
		return super.getBackground(object);
	}

	


}
