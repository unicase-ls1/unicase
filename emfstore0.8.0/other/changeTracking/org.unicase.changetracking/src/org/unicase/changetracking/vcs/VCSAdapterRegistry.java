package org.unicase.changetracking.vcs;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IConfigurationElement;
import org.eclipse.core.runtime.Platform;
import org.unicase.metamodel.util.ModelUtil;

public final class VCSAdapterRegistry {
	
	public static final VCSAdapterRegistry INSTANCE = new VCSAdapterRegistry();
	
	private List<VCSAdapterProvider> providers = new ArrayList<VCSAdapterProvider>();
	private List<VCSAdapterProvider> unmodifiableList = Collections.unmodifiableList(providers);

	private VCSAdapterRegistry(){
		readExtension();
	}
	
	private void readExtension(){
		IConfigurationElement[] extensions = Platform.getExtensionRegistry().getConfigurationElementsFor(
		"org.unicase.changetracking.vcsadapters");
		
		for(IConfigurationElement ext : extensions){
			try {
				VCSAdapterProvider p = (VCSAdapterProvider) ext.createExecutableExtension("adapterProvider");
				providers.add(p);
			} catch (ClassCastException e){
				ModelUtil.logException(e);
			} catch (CoreException e) {
				ModelUtil.logException(e);
			}
		}
	}

	public List<VCSAdapterProvider> getProviders() {
		return unmodifiableList;
	}
	
	
}
