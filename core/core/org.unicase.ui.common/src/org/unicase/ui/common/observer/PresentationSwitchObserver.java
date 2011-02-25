package org.unicase.ui.common.observer;

import org.unicase.util.observer.IObserver;

public interface PresentationSwitchObserver extends IObserver {

	void onPresentationSwitchEvent(String viewID, String presentationID);

}
