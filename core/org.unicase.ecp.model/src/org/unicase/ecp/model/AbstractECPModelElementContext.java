/**
 * <copyright> Copyright (c) 2008-2009 Jonas Helming, Maximilian Koegel. All rights reserved. This program and the
 * accompanying materials are made available under the terms of the Eclipse Public License v1.0 which accompanies this
 * distribution, and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>
 */
package org.unicase.ecp.model;

import java.util.HashSet;
import java.util.Set;

import org.eclipse.emf.ecore.EObject;

/**
 * The context of a certain {@link EObject}. 
 * Subclasses shall call modelelementDeleted and contextDeleted.
 * 
 * @author helming
 */
public abstract class AbstractECPModelElementContext implements ECPModelelementContext {

	private Set<ModelElementContextListener> modelElementContextListeners = new HashSet<ModelElementContextListener>();

	/**
	 * Adds a {@link ModelElementContextListener}.
	 * 
	 * @param modelElementContextListener the {@link ModelElementContextListener}
	 */
	public void addModelElementContextListener(ModelElementContextListener modelElementContextListener) {
		modelElementContextListeners.add(modelElementContextListener);
	}

	/**
	 * Removes a {@link ModelElementContextListener}.
	 * 
	 * @param modelElementContextListener the {@link ModelElementContextListener}
	 */
	public void removeModelElementContextListener(ModelElementContextListener modelElementContextListener) {
		modelElementContextListeners.remove(modelElementContextListener);
	}

	/**
	 * Call if the model element is deleted.
	 */
	protected void modelElementDeleted() {
		for (ModelElementContextListener modelElementContextListener : modelElementContextListeners) {
			modelElementContextListener.onModelElementDeleted();
		}
	}
}
