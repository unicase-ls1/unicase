package org.unicase.ui.tom.notifications;

import java.util.List;

public interface GestureNotifier {

	List<GestureAdapter> getAdapters();
	
	void notifyAdapters(GestureNotification notification);
	
}
