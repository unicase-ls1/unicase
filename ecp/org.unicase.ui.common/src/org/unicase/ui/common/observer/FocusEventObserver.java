package org.unicase.ui.common.observer;

import org.eclipse.emf.emfstore.common.observer.IObserver;

public interface FocusEventObserver extends IObserver {

	void onFocusEvent(String viewId);

}
