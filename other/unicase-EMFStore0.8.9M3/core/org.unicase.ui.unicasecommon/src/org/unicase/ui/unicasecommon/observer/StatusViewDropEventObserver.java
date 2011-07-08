package org.unicase.ui.unicasecommon.observer;

import org.eclipse.emf.ecore.EObject;

public interface StatusViewDropEventObserver extends org.eclipse.emf.emfstore.common.observer.IObserver {

	void onStatusViewDropEvent(EObject open, EObject dragged, String source, String tab);

}
