/**
 * <copyright> Copyright (c) 2008-2009 Jonas Helming, Maximilian Koegel. All rights reserved. This program and the
 * accompanying materials are made available under the terms of the Eclipse Public License v1.0 which accompanies this
 * distribution, and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>
 */
package org.unicase.emfstore.jdt;

import org.eclipse.emf.common.command.CommandStack;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.ui.plugin.AbstractUIPlugin;
import org.osgi.framework.BundleContext;
import org.unicase.emfstore.jdt.emf.resource.EMFStoreResourceFactoryRegistry;
import org.unicase.workspace.WorkspaceManager;

/**
 * The activator class controls the plug-in life cycle.
 * 
 * @author Adrian Staudt
 */
public class Activator extends AbstractUIPlugin {

	/**
	 * The plug-in ID.
	 */
	public static final String PLUGIN_ID = "org.unicase.emfstore.jdt"; //$NON-NLS-1$

	/**
	 * The shared instance.
	 */
	private static Activator plugin;

	/**
	 * The constructor.
	 */
	public Activator() {
	}

	/*
	 * (non-Javadoc)
	 * @see org.eclipse.ui.plugin.AbstractUIPlugin#start(org.osgi.framework.BundleContext)
	 */
	// BEGIN SUPRESS CATCH EXCEPTION
	@Override
	public void start(BundleContext context) throws Exception {
		// END SUPRESS CATCH EXCEPTION
		super.start(context);
		plugin = this;

		// replace supported ResourceFactories with EMF Store adapted ones
		EMFStoreResourceFactoryRegistry.replaceSupportedFactories();

		// Save changes from CommandStack to local resources
		TransactionalEditingDomain unicaseEditingDomain = WorkspaceManager.getInstance().getCurrentWorkspace()
			.getEditingDomain();
		CommandStack commandStack = unicaseEditingDomain.getCommandStack();
		commandStack.addCommandStackListener(new UnicaseCommandStackListener());
	}

	/*
	 * (non-Javadoc)
	 * @see org.eclipse.ui.plugin.AbstractUIPlugin#stop(org.osgi.framework.BundleContext)
	 */
	// BEGIN SUPRESS CATCH EXCEPTION
	@Override
	public void stop(BundleContext context) throws Exception {
		// END SUPRESS CATCH EXCEPTION
		plugin = null;
		super.stop(context);
	}

	/**
	 * Returns the shared instance.
	 * 
	 * @return the shared instance
	 */
	public static Activator getDefault() {
		return plugin;
	}

}