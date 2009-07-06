package org.unicase.ui.tom.notifications;

import java.util.ArrayList;
import java.util.List;

public class TouchNotifierImpl implements TouchNotifier {

	private List<TouchAdapter> adapters;
	private boolean deliver = true;

	public TouchNotifierImpl() {
		adapters = new ArrayList<TouchAdapter>();
	}
	
	public List<TouchAdapter> getAdapters() {
		return adapters;
	}

	public void setAdapters(List<TouchAdapter> adapters) {
		this.adapters = adapters;
	}

	public void notifyAdapters(TouchNotification notification) {
		List<TouchAdapter> adapters = getAdapters();
		if (adapters != null && deliver())
		{
			for (TouchAdapter touchAdapter : adapters) {
				touchAdapter.notifyChanged(notification);
			}
		}
	}

	public void setDeliver(boolean deliver) {
		this.deliver = deliver;
	}

	public boolean deliver() {
		return deliver;
	}


}
