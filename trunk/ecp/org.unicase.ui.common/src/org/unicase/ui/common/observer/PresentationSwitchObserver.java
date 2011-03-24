package org.unicase.ui.common.observer;

import org.eclipse.emf.emfstore.common.observer.IObserver;

public interface PresentationSwitchObserver extends IObserver {

	void onPresentationSwitchEvent(String viewID, String presentationID);

}
