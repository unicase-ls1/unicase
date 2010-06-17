/**
 * <copyright> Copyright (c) 2008-2009 Jonas Helming, Maximilian Koegel. All rights reserved. This program and the
 * accompanying materials are made available under the terms of the Eclipse Public License v1.0 which accompanies this
 * distribution, and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>
 */
package org.unicase.ui.common;

import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

import org.eclipse.emf.common.util.BasicEList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.edit.domain.EditingDomain;

/**
 * The context of a certain {@link ModelElement}. Subclasses shall call modelelementDeleted and contextDeleted.
 * 
 * @author helming
 */
public abstract class ModelElementContext {

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

	/**
	 * Call if the context gets deleted.
	 */
	protected void contextDeleted() {
		for (ModelElementContextListener modelElementContextListener : modelElementContextListeners) {
			modelElementContextListener.onContextDeleted();
		}
	}

	/**
	 * Returns the {@link EditingDomain} for the model element.
	 * 
	 * @return the {@link EditingDomain}
	 */
	public abstract EditingDomain getEditingDomain();

	/**
	 * Returns all {@link ModelElement} in the context, which are of a certain type.
	 * 
	 * @param clazz the type
	 * @param basicEList the list to be filled
	 * @return a {@link Collection} of {@link ModelElement}
	 */
	public abstract Collection<EObject> getAllModelElementsbyClass(EClass clazz, BasicEList<EObject> basicEList);

	/**
	 * Returns all {@link ModelElement} in the context.
	 * 
	 * @return a {@link Collection} of {@link ModelElement}
	 */
	public abstract Collection<EObject> getAllModelElements();

	/**
	 * Whether a {@link ModelElement} is a no domain element. Non Domain Elements which are not root nodes of the model
	 * and do not exist on their own The Have the following characteristic behaviour: The dont appear in the openME
	 * dialog, They are deleted if the last link to them is deleted, They are not shown in the new element wizard, They
	 * are not shown in the METyselection dialog (Table View)
	 * 
	 * @param eObject the {@link ModelElement}
	 * @return if it is non domain
	 */
	public abstract boolean isNonDomainElement(EObject eObject);

	/**
	 * Returns the {@link MetaModelElementContext}.
	 * 
	 * @return the {@link MetaModelElementContext}.
	 */
	public abstract MetaModelElementContext getMetaModelElementContext();

	/**
	 * If a {@link ModelElement} is contained in this context and can be therefore referenced by the
	 * {@link ModelElement} defining the context.
	 * 
	 * @param eObject the {@link ModelElement}
	 * @return if the {@link EObject} is contained in the context
	 */
	public abstract boolean contains(EObject eObject);
	
	/**
	 * Called if the context is not used anymore. Use for cleanup.
	 */
	public abstract void dispose();

}
