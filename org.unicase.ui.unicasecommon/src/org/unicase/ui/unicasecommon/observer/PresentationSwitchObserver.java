package org.unicase.ui.unicasecommon.observer;

import org.eclipse.emf.emfstore.common.ESObserver;

/**
 * Observer for events when the presentation within a view is switched, e.g. to
 * another tab.
 * 
 */
public interface PresentationSwitchObserver extends ESObserver {

	/**
	 * Called if the presentation is switched.
	 * 
	 * @param viewID
	 *            the ID of the focused view
	 * @param presentationID
	 *            the idea of the activated presentation
	 */
	void onPresentationSwitchEvent(String viewID, String presentationID);

}
