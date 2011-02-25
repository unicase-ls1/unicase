package org.unicase.ui.tom.notifications;

import java.util.Set;

public interface MultiTouchNotifier {

	Set<MultiTouchAdapter> getAdapters();
	
	void notifyAdapters(MultiTouchNotification notification);
	
}
