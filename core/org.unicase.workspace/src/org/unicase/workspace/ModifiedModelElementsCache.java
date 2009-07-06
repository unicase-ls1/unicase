/**
 * <copyright> Copyright (c) 2008 Jonas Helming, Maximilian Koegel. All rights reserved. This program and the
 * accompanying materials are made available under the terms of the Eclipse Public License v1.0 which accompanies this
 * distribution, and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>
 */
package org.unicase.workspace;

import org.unicase.emfstore.esmodel.versioning.ChangePackage;
import org.unicase.emfstore.esmodel.versioning.PrimaryVersionSpec;
import org.unicase.emfstore.esmodel.versioning.operations.AbstractOperation;
import org.unicase.model.ModelElementId;
import org.unicase.workspace.observers.CommitObserver;
import org.unicase.workspace.observers.ModifiedModelElementsCachListener;
import org.unicase.workspace.observers.OperationListener;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * Caches all modified elements.
 * 
 * @author hodaie
 */
public class ModifiedModelElementsCache implements OperationListener, CommitObserver {

	private Map<ModelElementId, List<AbstractOperation>> modifiedMEs;
	private List<ModifiedModelElementsCachListener> modifiedMEsCacheListeners;

	/**
	 * Constructor.
	 */
	public ModifiedModelElementsCache() {
		modifiedMEs = new HashMap<ModelElementId, List<AbstractOperation>>();
		modifiedMEsCacheListeners = new ArrayList<ModifiedModelElementsCachListener>();
	}

	/**
	 * If this model element has been modified.
	 * 
	 * @param meId model element id
	 * @return If this model element has been modified.
	 */
	public boolean isDirty(ModelElementId meId) {

		return modifiedMEs.containsKey(meId);
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.unicase.workspace.observers.OperationListener#operationExecuted(org.unicase.emfstore.esmodel.versioning.operations.AbstractOperation)
	 */
	public void operationExecuted(AbstractOperation operation) {
		int oldCacheSize = modifiedMEs.size();
		// add to cache
		Set<ModelElementId> involvedMEs = operation.getAllInvolvedModelElements();
		for (ModelElementId meId : involvedMEs) {
			if (!modifiedMEs.containsKey(meId)) {
				List<AbstractOperation> ops = new ArrayList<AbstractOperation>();
				ops.add(operation);
				modifiedMEs.put(meId, ops);
			} else {
				modifiedMEs.get(meId).add(operation);
			}

		}

		if (modifiedMEs.size() != oldCacheSize) {
			fireCacheUpdated();
		}

	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.unicase.workspace.observers.OperationListener#operationUnDone(org.unicase.emfstore.esmodel.versioning.operations.AbstractOperation)
	 */
	public void operationUnDone(AbstractOperation operation) {
		int oldCacheSize = modifiedMEs.size();
		// remove from cache
		Set<ModelElementId> involvedMEs = operation.getAllInvolvedModelElements();
		for (ModelElementId meId : involvedMEs) {
			if (modifiedMEs.containsKey(meId)) {
				modifiedMEs.get(meId).remove(operation);
				if (modifiedMEs.get(meId).size() == 0) {
					modifiedMEs.remove(meId);

				}
			}
		}

		if (modifiedMEs.size() != oldCacheSize) {
			fireCacheUpdated();
		}

	}

	private void fireCacheUpdated() {
		for (ModifiedModelElementsCachListener cacheListener : modifiedMEsCacheListeners) {
			cacheListener.modifiedModelElementsCacheUpdated();
		}

	}

	/**
	 * Adds a new listener which will be notified when modified model elements cache is changed.
	 * 
	 * @param listener modified model elements cache listner
	 */
	public void addModifiedModelElementsCacheListener(ModifiedModelElementsCachListener listener) {
		this.modifiedMEsCacheListeners.add(listener);
	}

	/**
	 * Removes the modified model elements cache listener.
	 * 
	 * @param listener modified model elements cache listener
	 */
	public void removeModifiedModelElementsCacheListener(ModifiedModelElementsCachListener listener) {
		this.modifiedMEsCacheListeners.remove(listener);
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.unicase.workspace.observers.CommitObserver#commitCompleted(org.unicase.workspace.ProjectSpace,
	 *      org.unicase.emfstore.esmodel.versioning.PrimaryVersionSpec)
	 */
	public void commitCompleted(ProjectSpace projectSpace, PrimaryVersionSpec newRevision) {
		modifiedMEs.clear();
		fireCacheUpdated();
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.unicase.workspace.observers.CommitObserver#inspectChanges(org.unicase.workspace.ProjectSpace,
	 *      org.unicase.emfstore.esmodel.versioning.ChangePackage)
	 */
	public boolean inspectChanges(ProjectSpace projectSpace, ChangePackage changePackage) {
		return true;
	}

}
