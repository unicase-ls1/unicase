package org.unicase.ui.unicasecommon.application;

import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.ui.IElementFactory;
import org.eclipse.ui.IMemento;
import org.eclipse.ui.IPersistableElement;
import org.eclipse.ui.model.IWorkbenchAdapter;

public class NavigatorRoot implements IAdaptable, IPersistableElement, IElementFactory {

	public NavigatorRoot() {
	}

	public void saveState(IMemento memento) {
	}

	public IAdaptable createElement(IMemento memento) {
		return ResourcesPlugin.getWorkspace().getRoot();

	}

	public String getFactoryId() {
		return this.getClass().getCanonicalName();
	}

	public <T> T getAdapter(Class<T> adapter) {
		if (adapter == IPersistableElement.class) {
			return (T) this;
		}
		if (adapter == IWorkbenchAdapter.class) {
			return ResourcesPlugin.getWorkspace().getRoot().getAdapter(adapter);
		}
		return null;
	}

}