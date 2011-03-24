package org.unicase.ui.common.observer;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.emfstore.common.observer.IObserver;

public interface StatusViewDropEventObserver extends IObserver {

	void onStatusViewDropEvent(EObject open, EObject dragged, String source, String tab);

}
