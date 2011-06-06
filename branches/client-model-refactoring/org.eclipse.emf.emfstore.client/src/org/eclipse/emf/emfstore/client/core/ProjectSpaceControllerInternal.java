package org.eclipse.emf.emfstore.client.core;

import java.util.List;

import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.emfstore.client.changeTracking.CompositeOperationHandle;
import org.eclipse.emf.emfstore.client.changeTracking.OperationManager;
import org.eclipse.emf.emfstore.server.exceptions.EmfStoreException;
import org.eclipse.emf.emfstore.server.model.versioning.VersionSpec;
import org.eclipse.emf.emfstore.server.model.versioning.operations.AbstractOperation;

public interface ProjectSpaceControllerInternal extends ProjectSpaceController {

	/**
	 * Initialize the resources of the project space.
	 * 
	 * @param resourceSet
	 *            the resource set the project space should use
	 */
	void initResources(ResourceSet resourceSet);

	OperationManager getOperationManager();

	void addOperation(AbstractOperation operation);

	/**
	 * Begin a composite operation on the projectSpace.
	 * 
	 * @return a handle to abort or complete the operation
	 */
	CompositeOperationHandle createCompositeOperation();

	/**
	 * Initialize the project space and its resources.
	 */
	void init();

	/**
	 * Undo the last operation of the projectSpace.
	 */
	void undoLastOperation();

	/**
	 * Apply the merge result to the project space. Will revert all previous
	 * change and apply the given result.
	 * 
	 * @param mergeResult
	 *            a list of operations resulting from a merge
	 * @param mergeTargetSpec
	 *            the target spec to merge to
	 * @throws EmfStoreException
	 *             if exception occurs on the server
	 */
	void applyMergeResult(List<AbstractOperation> mergeResult,
			VersionSpec mergeTargetSpec) throws EmfStoreException;

	/**
	 * Will make the projectSpace transient, it will not make its content or
	 * changes persistent. Can only be called before the resources or the
	 * project space have been initialized.
	 */
	void makeTransient();

	/**
	 * Shows whether projectSpace is transient.
	 * 
	 * @return true, if transient.
	 */
	boolean isTransient();

	/**
	 * Transmit the OrgUnitproperties to the server.
	 * 
	 * @generated NOT
	 */
	void transmitProperties();

}
