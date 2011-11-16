/*******************************************************************************
 * Copyright (c) 2008-2011 Chair for Applied Software Engineering, Technische Universitaet Muenchen. All rights
 * reserved. This program and the accompanying materials are made available under the terms of the Eclipse Public
 * License v1.0 which accompanies this distribution, and is available at http://www.eclipse.org/legal/epl-v10.html
 * Contributors:
 ******************************************************************************/
package org.eclipse.emf.ecp.navigator;

import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IConfigurationElement;
import org.eclipse.core.runtime.Platform;
import org.eclipse.emf.edit.provider.ComposedAdapterFactory;
import org.eclipse.emf.edit.ui.provider.AdapterFactoryLabelProvider;
import org.eclipse.jface.viewers.DecoratingLabelProvider;
import org.eclipse.jface.viewers.IBaseLabelProvider;
import org.eclipse.jface.viewers.ILabelProvider;
import org.eclipse.ui.IDecoratorManager;
import org.eclipse.ui.PlatformUI;

/**
 * Composed Label provider with all registered label providers.
 * 
 * @author helming
 * @author emueller
 */
public class TreeLabelProvider { 
	
	private ILabelProvider defaultLabelProvider;
	private IBaseLabelProvider replacedLabelProvider;

	/**
	 * Default constructor.
	 */
	public TreeLabelProvider() {
		defaultLabelProvider = new DecoratingLabelProvider(new AdapterFactoryLabelProvider(new ComposedAdapterFactory(ComposedAdapterFactory.Descriptor.Registry.INSTANCE)),
			PlatformUI.getWorkbench().getDecoratorManager().getLabelDecorator());
		replaceLabelProvider();
	}

	private void replaceLabelProvider() {

		IConfigurationElement[] confs = Platform.getExtensionRegistry().getConfigurationElementsFor(
				"org.eclipse.emf.ecp.navigator.replaceLabelProvider");
		
		if (confs.length > 1) {
			Exception exception = new IllegalStateException("Two or more ReplaceLabel Providers registered");
			Activator.getDefault().logException(exception.getMessage(), exception);
		} else if (confs.length == 1) {
			IConfigurationElement element = confs[0];
			
			try {
				replacedLabelProvider = (IBaseLabelProvider) element.createExecutableExtension("class");
			} catch (CoreException e) {
				Activator.getDefault().logException(e.getMessage(), e);
			}
		}
	}

	/**
	 * Returns the {@link ILabelProvider}.  If the default label provider has been replaced, that one 
	 * will be returned.  If more than one label providers have been registered to replace the default
	 * label provider the first one will be returned.
	 * @return the label provider to be used by the {@link TreeView}
	 */
	public IBaseLabelProvider getLabelProvider() {
		if (replacedLabelProvider != null) {
			return replacedLabelProvider;
		}
		
		return defaultLabelProvider;
	}
}
