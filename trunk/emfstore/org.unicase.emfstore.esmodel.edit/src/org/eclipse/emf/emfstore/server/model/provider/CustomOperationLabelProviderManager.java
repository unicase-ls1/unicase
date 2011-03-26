/**
 * <copyright> Copyright (c) 2008-2009 Jonas Helming, Maximilian Koegel. All rights reserved. This program and the
 * accompanying materials are made available under the terms of the Eclipse Public License v1.0 which accompanies this
 * distribution, and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>
 */
package org.eclipse.emf.emfstore.server.model.provider;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IConfigurationElement;
import org.eclipse.core.runtime.Platform;
import org.unicase.emfstore.esmodel.versioning.operations.AbstractOperation;
import org.unicase.metamodel.util.ModelUtil;

/**
 * Class for managing customLabelProvider for specified operations.
 * 
 * @author Michael Kagel
 */
public class CustomOperationLabelProviderManager {

	private static List<AbstractOperationCustomLabelProvider> list;

	/**
	 * Constructor.
	 */
	public CustomOperationLabelProviderManager() {
		if (list == null) {
			initExtensions();
		}
	}

	/**
	 * Provides a customLabelProvider for a specified operation.
	 * 
	 * @param operation for which the method should provide a customLabelProvider.
	 * @return The customLabelProvider for the given operation or null if there is no customLabelProvider.
	 */
	public AbstractOperationCustomLabelProvider getCustomLabelProvider(AbstractOperation operation) {

		AbstractOperationCustomLabelProvider highestVisualizer = null;

		int highestNumber = 0;
		int currentRenderState = 0;

		for (AbstractOperationCustomLabelProvider changePackageVisualizer : list) {
			currentRenderState = changePackageVisualizer.canRender(operation);
			// Take the highest provider
			if (currentRenderState > highestNumber) {
				highestNumber = currentRenderState;
				highestVisualizer = changePackageVisualizer;
			}
		}

		return highestVisualizer;
	}

	private void initExtensions() {
		IConfigurationElement[] attributecontrols = Platform.getExtensionRegistry().getConfigurationElementsFor(
			"org.unicase.emfstore.esmodel.edit.customOperationLabelProvider");
		list = new ArrayList<AbstractOperationCustomLabelProvider>();
		for (IConfigurationElement extension : attributecontrols) {
			try {
				AbstractOperationCustomLabelProvider provider = (AbstractOperationCustomLabelProvider) extension
					.createExecutableExtension("class");
				list.add(provider);
			} catch (CoreException exception) {
				ModelUtil.logException("Exception occured while initializing custom label provider extensions!",
					exception);
			}
		}
	}
}
