package org.unicase.ui.tom.notifications;

import java.util.Set;

public interface TouchNotifier {

	Set<TouchAdapter> getAdapters();
	
	void notifyAdapters(TouchNotification notification);
	
}
