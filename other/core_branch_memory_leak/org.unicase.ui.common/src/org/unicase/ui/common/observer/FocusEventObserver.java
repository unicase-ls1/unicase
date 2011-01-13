package org.unicase.ui.common.observer;

import org.unicase.util.observer.IObserver;

public interface FocusEventObserver extends IObserver {

	void onFocusEvent(String viewId);

}
