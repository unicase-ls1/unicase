/**
 * <copyright> Copyright (c) 2008-2009 Jonas Helming, Maximilian Koegel. All rights reserved. This program and the
 * accompanying materials are made available under the terms of the Eclipse Public License v1.0 which accompanies this
 * distribution, and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>
 */
package org.unicase.changetracking.vcs;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IConfigurationElement;
import org.eclipse.core.runtime.Platform;
import org.unicase.metamodel.util.ModelUtil;

/**
 * The singleton registry class reads the org.unicase.changetracking.vcsadapters
 * extension point to provide a list of available adapter plug-ins.
 * 
 * @author jfinis
 * 
 */
public final class VCSAdapterRegistry {

	/**
	 * The singleton instance.
	 */
	public static final VCSAdapterRegistry INSTANCE = new VCSAdapterRegistry();

	private List<IVCSAdapterProvider> providers = new ArrayList<IVCSAdapterProvider>();
	private List<IVCSAdapterProvider> unmodifiableList = Collections.unmodifiableList(providers);

	private VCSAdapterRegistry() {
		readExtension();
	}

	private void readExtension() {
		IConfigurationElement[] extensions = Platform.getExtensionRegistry().getConfigurationElementsFor("org.unicase.changetracking.vcsadapters");

		for (IConfigurationElement ext : extensions) {
			try {
				IVCSAdapterProvider p = (IVCSAdapterProvider) ext.createExecutableExtension("class");
				providers.add(p);
			} catch (ClassCastException e) {
				ModelUtil.logException(e);
			} catch (CoreException e) {
				ModelUtil.logException(e);
			}
		}
	}

	/**
	 * Retrieves the list of registered adapter providers. (usually one provider
	 * per adapter plug-in).
	 * 
	 * @return list of adapter providers
	 */
	public List<IVCSAdapterProvider> getProviders() {
		return unmodifiableList;
	}

}
