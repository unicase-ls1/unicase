/*******************************************************************************
 * Copyright (c) 2008-2011 Chair for Applied Software Engineering,
 * Technische Universitaet Muenchen.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 ******************************************************************************/
package org.eclipse.emf.emfstore.server.model.versioning.operations.util;

import org.eclipse.emf.emfstore.server.model.versioning.operations.AbstractOperation;
import org.eclipse.emf.emfstore.server.model.versioning.operations.AttributeOperation;
import org.eclipse.emf.emfstore.server.model.versioning.operations.CompositeOperation;
import org.eclipse.emf.emfstore.server.model.versioning.operations.CreateDeleteOperation;
import org.eclipse.emf.emfstore.server.model.versioning.operations.DiagramLayoutOperation;
import org.eclipse.emf.emfstore.server.model.versioning.operations.MultiAttributeMoveOperation;
import org.eclipse.emf.emfstore.server.model.versioning.operations.MultiAttributeOperation;
import org.eclipse.emf.emfstore.server.model.versioning.operations.MultiAttributeSetOperation;
import org.eclipse.emf.emfstore.server.model.versioning.operations.MultiReferenceMoveOperation;
import org.eclipse.emf.emfstore.server.model.versioning.operations.MultiReferenceOperation;
import org.eclipse.emf.emfstore.server.model.versioning.operations.MultiReferenceSetOperation;
import org.eclipse.emf.emfstore.server.model.versioning.operations.SingleReferenceOperation;

/**
 * Util method for change operations.
 * 
 * @author wesendon
 */
public final class OperationUtil {

	/**
	 * Default constructor.
	 */
	private OperationUtil() {
	}

	/**
	 * Checks whether given operation is a composite operation.
	 * 
	 * @param operation operation
	 * @return true if correct
	 */
	public static boolean isComposite(AbstractOperation operation) {
		return operation instanceof CompositeOperation && ((CompositeOperation) operation).getMainOperation() == null;
	}

	/**
	 * Checks whether given operation is a reference operation.
	 * 
	 * @param operation operation
	 * @return true if correct
	 */
	public static boolean isReference(AbstractOperation operation) {
		return isSingleRef(operation) || isMultiRef(operation) || isCompositeRef(operation);
	}

	/**
	 * Checks whether given operation is a reference composite.
	 * 
	 * @param operation operation
	 * @return true if correct
	 */
	public static boolean isCompositeRef(AbstractOperation operation) {
		return operation instanceof CompositeOperation && ((CompositeOperation) operation).getMainOperation() != null;
	}

	/**
	 * Checks whether given operation is singleref operation .
	 * 
	 * @param operation operation
	 * @return true if correct
	 */
	public static boolean isSingleRef(AbstractOperation operation) {
		return operation instanceof SingleReferenceOperation;
	}

	/**
	 * Checks whether given operation is a multiref operation .
	 * 
	 * @param operation operation
	 * @return true if correct
	 */
	public static boolean isMultiRef(AbstractOperation operation) {
		return operation instanceof MultiReferenceOperation;
	}

	/**
	 * Checks whether given operation is a multiref set operation .
	 * 
	 * @param operation operation
	 * @return true if correct
	 */
	public static boolean isMultiRefSet(AbstractOperation operation) {
		return operation instanceof MultiReferenceSetOperation;
	}

	/**
	 * Checks whether given operation is multimove operation.
	 * 
	 * @param operation operation
	 * @return true if correct
	 */
	public static boolean isMultiMoveRef(AbstractOperation operation) {
		return operation instanceof MultiReferenceMoveOperation;
	}

	/**
	 * Checks whether given operation is attribute operation.
	 * 
	 * @param operation operation
	 * @return true if correct
	 */
	public static boolean isAttribute(AbstractOperation operation) {
		return operation instanceof AttributeOperation;
	}

	/**
	 * Checks whether given operation is multi attribute operation.
	 * 
	 * @param operation operation
	 * @return true if correct
	 */
	public static boolean isMultiAtt(AbstractOperation operation) {
		return operation instanceof MultiAttributeOperation;
	}

	/**
	 * Checks whether given operation is multi attribute set operation.
	 * 
	 * @param operation operation
	 * @return true if correct
	 */
	public static boolean isMultiAttSet(AbstractOperation operation) {
		return operation instanceof MultiAttributeSetOperation;
	}

	/**
	 * Checks whether given operation is multi attribute move operation.
	 * 
	 * @param operation operation
	 * @return true if correct
	 */
	public static boolean isMultiAttMove(AbstractOperation operation) {
		return operation instanceof MultiAttributeMoveOperation;
	}

	/**
	 * Checks whether given operation is diagram operation.
	 * 
	 * @param operation operation
	 * @return true if correct
	 */
	public static boolean isDiagramLayout(AbstractOperation operation) {
		return operation instanceof DiagramLayoutOperation;
	}

	/**
	 * Checks whether given operation is a creating operation.
	 * 
	 * @param operation operation
	 * @return true if correct
	 */
	public static boolean isCreate(AbstractOperation operation) {
		return isCreateDelete(operation) && !((CreateDeleteOperation) operation).isDelete();
	}

	/**
	 * Checks whether given operation is a deleting operation.
	 * 
	 * @param operation operation
	 * @return true if correct
	 */
	public static boolean isDelete(AbstractOperation operation) {
		return isCreateDelete(operation) && ((CreateDeleteOperation) operation).isDelete();
	}

	/**
	 * Checks whether given operation is a createDelete operation.
	 * 
	 * @param operation operation
	 * @return true if correct
	 */
	public static boolean isCreateDelete(AbstractOperation operation) {
		return operation instanceof CreateDeleteOperation;
	}

}
