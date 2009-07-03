/**
 * <copyright> Copyright (c) 2008 Jonas Helming, Maximilian Koegel. All rights reserved. This program and the
 * accompanying materials are made available under the terms of the Eclipse Public License v1.0 which accompanies this
 * distribution, and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>
 */
package org.unicase.workspace;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.unicase.emfstore.esmodel.versioning.operations.AbstractOperation;
import org.unicase.model.ModelElementId;
import org.unicase.workspace.observers.OperationListener;

/**
 * @author hodaie
 */
public class ModifiedModelElementsCache implements OperationListener {

	private Map<ModelElementId, List<AbstractOperation>> modifiedMEs = new HashMap<ModelElementId, List<AbstractOperation>>();

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

	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.unicase.workspace.observers.OperationListener#operationUnDone(org.unicase.emfstore.esmodel.versioning.operations.AbstractOperation)
	 */
	public void operationUnDone(AbstractOperation operation) {
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

	}

}
