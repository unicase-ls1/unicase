package org.unicase.patch.handlers;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.core.internal.registry.ExtensionRegistry;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IConfigurationElement;
import org.eclipse.core.runtime.Platform;
import org.unicase.patch.adapters.IAbstractAdapter;

@SuppressWarnings("restriction")
public class AdapterFactory {

	private static final String EXTENSION_POINT_ID = "org.unicase.patch.adapter";
	
	private static AdapterFactory instance;
	
	private List<IAbstractAdapter> adapters;
	
	public AdapterFactory() {
		adapters = new ArrayList<IAbstractAdapter>();
	}
	
	public static AdapterFactory getInstance() {
		if (instance == null) { 
			instance = new AdapterFactory();
			instance.initAdapters();
		}
		
		return instance;
	}
	
	private void initAdapters() {
		// CVS adapter always may be added, since it's included in the standard eclipse distribution
		addAdapter(new CVSAdapter());
		
		IConfigurationElement[] config = Platform.getExtensionRegistry()
				.getConfigurationElementsFor(EXTENSION_POINT_ID);
		
		for (IConfigurationElement e : config) {
			Object o;
			try {
				o = e.createExecutableExtension("class");

				if (o instanceof IAbstractAdapter) {
					addAdapter( (IAbstractAdapter) o);
				}
			} catch (CoreException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
	}
	
	public void addAdapter(IAbstractAdapter adapter) {
		if (!adapters.contains(adapter)) {
			adapters.add(adapter);
		}
	}
	
	public void removeAdapter(IAbstractAdapter adapter) {
		adapters.remove(adapter);
	}
	
	public IAbstractAdapter getAdapter(String providerId) {
		for (IAbstractAdapter a : adapters) {
			if (a.isResponsible(providerId)) {
				return a;
			}
		}
		
		return null;
	}
}
