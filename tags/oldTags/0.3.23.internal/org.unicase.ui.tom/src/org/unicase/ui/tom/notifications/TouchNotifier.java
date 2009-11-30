package org.unicase.ui.tom.notifications;

import java.util.List;

public interface TouchNotifier {

	List<TouchAdapter> getAdapters();
	
	void notifyAdapters(TouchNotification notification);
	
}
