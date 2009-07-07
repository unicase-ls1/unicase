/**
 * <copyright> Copyright (c) 2008 Jonas Helming, Maximilian Koegel. All rights reserved. This program and the
 * accompanying materials are made available under the terms of the Eclipse Public License v1.0 which accompanies this
 * distribution, and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>
 */
package org.unicase.workspace;

import java.util.Date;

import org.unicase.emfstore.esmodel.versioning.operations.CompositeOperation;
import org.unicase.model.ModelElementId;
import org.unicase.workspace.exceptions.InvalidHandleException;
import org.unicase.workspace.impl.ProjectSpaceImpl;

/**
 * A handle to control a composite operation during recording.
 * 
 * @author koegel
 */
public class CompositeOperationHandle {

	private boolean isValid;
	private final ProjectSpaceImpl projectSpace;
	private final CompositeOperation compositeOperation;

	/**
	 * Default constructor.
	 * 
	 * @param projectSpace the project space
	 * @param compositeOperation the composite operation to be handled
	 */
	public CompositeOperationHandle(ProjectSpaceImpl projectSpace, CompositeOperation compositeOperation) {
		this.projectSpace = projectSpace;
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
		projectSpace.abortCompositeOperation();
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
		projectSpace.endCompositeOperation();
	}
}
