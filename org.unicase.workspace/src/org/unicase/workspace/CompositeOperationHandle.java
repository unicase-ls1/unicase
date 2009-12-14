/**
 * <copyright> Copyright (c) 2008-2009 Jonas Helming, Maximilian Koegel. All rights reserved. This program and the
 * accompanying materials are made available under the terms of the Eclipse Public License v1.0 which accompanies this
 * distribution, and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>
 */
package org.unicase.workspace;

import java.util.Date;

import org.unicase.emfstore.esmodel.versioning.operations.CompositeOperation;
import org.unicase.emfstore.esmodel.versioning.operations.semantic.SemanticCompositeOperation;
import org.unicase.metamodel.ModelElementId;
import org.unicase.workspace.exceptions.InvalidHandleException;
import org.unicase.workspace.impl.ProjectChangeTracker;

/**
 * A handle to control a composite operation during recording.
 * 
 * @author koegel
 */
public class CompositeOperationHandle {

	private boolean isValid;
	private final CompositeOperation compositeOperation;
	private final ProjectChangeTracker changeTracker;

	/**
	 * Default constructor.
	 * 
	 * @param changeTracker the change tracker this composite is tracked on
	 * @param compositeOperation the composite operation to be handled
	 */
	public CompositeOperationHandle(ProjectChangeTracker changeTracker, CompositeOperation compositeOperation) {
		this.changeTracker = changeTracker;
		this.compositeOperation = compositeOperation;
		isValid = true;
	}

	/**
	 * Returns whether the handle is still valid.
	 * 
	 * @return false if the composite operation is already completed or aborted.
	 */
	public boolean isValid() {
		return isValid;
	}

	/**
	 * Aborts a composite operation. The state before starting the composite operation will be recovered.
	 * 
	 * @throws InvalidHandleException if the handle is invalid
	 */
	public void abort() throws InvalidHandleException {
		checkAndCloseHandle();
		changeTracker.abortCompositeOperation();
	}

	private void checkAndCloseHandle() throws InvalidHandleException {
		if (!isValid) {
			throw new InvalidHandleException();
		}
		isValid = false;
	}

	/**
	 * Completes a composite operation.
	 * 
	 * @param name the name for the operation
	 * @param description the description of the operation
	 * @param modelElementId the id of the model element that is most important for the operation
	 * @throws InvalidHandleException if the handle is invalid
	 */
	public void end(String name, String description, ModelElementId modelElementId) throws InvalidHandleException {
		checkAndCloseHandle();
		compositeOperation.setCompositeName(name);
		compositeOperation.setCompositeDescription(description);
		compositeOperation.setClientDate(new Date());
		compositeOperation.setReversed(false);
		compositeOperation.setModelElementId(modelElementId);
		changeTracker.endCompositeOperation();
	}

	/**
	 * Completes a the given semantic composite operation.
	 * 
	 * @param semanticCompositeOperation a semanticCompositeOperation that was executed and represents the composite
	 * @throws InvalidHandleException if the handle is invalid
	 */
	public void end(SemanticCompositeOperation semanticCompositeOperation) throws InvalidHandleException {
		checkAndCloseHandle();
		semanticCompositeOperation.setClientDate(new Date());
		semanticCompositeOperation.setReversed(false);
		semanticCompositeOperation.getSubOperations().addAll(compositeOperation.getSubOperations());
		changeTracker.endCompositeOperation(semanticCompositeOperation);
	}
}
