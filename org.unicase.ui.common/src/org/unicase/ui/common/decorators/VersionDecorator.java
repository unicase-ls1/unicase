package org.unicase.ui.common.decorators;



import java.util.ArrayList;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.impl.AdapterImpl;
import org.eclipse.jface.viewers.IDecoration;
import org.eclipse.jface.viewers.ILabelProviderListener;
import org.eclipse.jface.viewers.ILightweightLabelDecorator;
import org.eclipse.jface.viewers.LabelProviderChangedEvent;
import org.unicase.workspace.ProjectSpace;


public class VersionDecorator extends AdapterImpl implements ILightweightLabelDecorator {

	private ArrayList<ILabelProviderListener> listeners = new ArrayList<ILabelProviderListener>();
	ProjectSpace element = null;

	public void decorate(Object element, IDecoration decoration) {
		if (element instanceof ProjectSpace) {
			ProjectSpace projectSpace = (ProjectSpace) element;
			StringBuilder stringBuilder = new StringBuilder();
			if (projectSpace.getBaseVersion() != null) {
				stringBuilder.append("@");
				stringBuilder.append(projectSpace.getBaseVersion()
						.getIdentifier());
			} else {
				stringBuilder.append("(Not shared)");
			}
			String string = stringBuilder.toString();
			decoration.addSuffix(string);
		}
		if(this.element==null){
			this.element=(ProjectSpace) element;
			this.element.eAdapters().add(this);
		}
	}

	public void addListener(ILabelProviderListener listener) {
		listeners.add(listener);
	}

	public void dispose() {
		listeners.removeAll(listeners);
		
	}

	public boolean isLabelProperty(Object element, String property) {
		// TODO Auto-generated method stub
		return false;
	}

	public void removeListener(ILabelProviderListener listener) {
		listeners.remove(listener);
	}

	public void decorationChanged(){
		LabelProviderChangedEvent event = new LabelProviderChangedEvent(this,element);
		for(ILabelProviderListener listener: listeners){
			listener.labelProviderChanged(event);
		}
	}

	@Override
	public void notifyChanged(Notification msg) {
		decorationChanged();
	}
	


}
