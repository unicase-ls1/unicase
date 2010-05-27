package org.unicase.ui.meeditor;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.impl.AdapterImpl;
import org.eclipse.emf.ecore.EObject;

public class ModelElementChangeListener extends AdapterImpl {

	public ModelElementChangeListener(EObject modelelement) {
		modelelement.eAdapters().add(this);
	}

	/**
	 * Handle changes to the model element.
	 * 
	 * @param notification the EMF notification, providing details on the change
	 */
	void onChange(Notification notification) {
	}

	/**
	 * Handle a runtime exception that occured in this listeners methods. NOTE: runtime exceptions of this method will
	 * be logged and silently dropped.
	 * 
	 * @param exception the exception
	 */
	void onRuntimeExceptionInListener(RuntimeException exception) {
	}

	@Override
	public void notifyChanged(Notification notification) {
		onChange(notification);

	}

}
