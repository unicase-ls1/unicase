package org.unicase.ui.tom.notifications;

import java.util.ArrayList;
import java.util.List;

public class GestureNotifierImpl implements GestureNotifier{

	private List<GestureAdapter> adapters;
	private boolean deliver;

	public GestureNotifierImpl() {
		adapters = new ArrayList<GestureAdapter>();
		setDeliver(true);
	}
	
	public List<GestureAdapter> getAdapters() {
		return adapters;
	}

	public void setAdapters(List<GestureAdapter> adapters) {
		this.adapters = adapters;
	}

	public void notifyAdapters(GestureNotification notification) {
		List<GestureAdapter> adapters = getAdapters();
		if (adapters != null && deliver())
		{
			for (GestureAdapter gestureAdapter : adapters) {
				gestureAdapter.notifyChanged(notification);
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
