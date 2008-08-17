package org.unicase.ui.stem.views.iterationplanningview;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.edit.provider.ComposedAdapterFactory;
import org.eclipse.emf.edit.ui.provider.AdapterFactoryLabelProvider;
import org.eclipse.jface.viewers.ColumnLabelProvider;
import org.eclipse.swt.graphics.Image;
import org.unicase.model.bug.BugReport;
import org.unicase.model.task.ActionItem;

public class AssignedToLabelProvider extends ColumnLabelProvider {

	private AdapterFactoryLabelProvider adapterFactoryLabelProvider;

	@Override
	public Image getImage(Object element) {
		EObject assignedTo = getAssignedTo(element);
		if (assignedTo==null){
			return null;
		}
		return adapterFactoryLabelProvider.getImage(assignedTo);
	}

	private EObject getAssignedTo(Object element) {
		if(element instanceof BugReport){
			return ((BugReport) element).getAssignedTo();
		}
		if(element instanceof ActionItem){
			ActionItem ai = (ActionItem) element;
			if (ai.getAssignedTo().size()>0){
				return ai.getAssignedTo().get(0);
				//JH: return only first?
			}
		}
		return null;
	}

	@Override
	public String getText(Object element) {
		EObject assignedTo = getAssignedTo(element);
		if (assignedTo==null){
			return "N/A";
		}
		return adapterFactoryLabelProvider.getText(assignedTo);
	}
	
	

	public AssignedToLabelProvider() {
		super();
		adapterFactoryLabelProvider = new AdapterFactoryLabelProvider(new ComposedAdapterFactory(ComposedAdapterFactory.Descriptor.Registry.INSTANCE));
	}

	
}
