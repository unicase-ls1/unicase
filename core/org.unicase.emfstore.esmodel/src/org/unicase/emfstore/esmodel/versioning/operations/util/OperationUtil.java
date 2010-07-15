/**
 * <copyright> Copyright (c) 2008-2009 Jonas Helming, Maximilian Koegel. All rights reserved. This program and the
 * accompanying materials are made available under the terms of the Eclipse Public License v1.0 which accompanies this
 * distribution, and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>
 */
package org.unicase.emfstore.esmodel.versioning.operations.util;

import org.unicase.emfstore.esmodel.versioning.operations.AbstractOperation;
import org.unicase.emfstore.esmodel.versioning.operations.AttributeOperation;
import org.unicase.emfstore.esmodel.versioning.operations.CompositeOperation;
import org.unicase.emfstore.esmodel.versioning.operations.CreateDeleteOperation;
import org.unicase.emfstore.esmodel.versioning.operations.DiagramLayoutOperation;
import org.unicase.emfstore.esmodel.versioning.operations.MultiReferenceMoveOperation;
import org.unicase.emfstore.esmodel.versioning.operations.MultiReferenceOperation;
import org.unicase.emfstore.esmodel.versioning.operations.SingleReferenceOperation;

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
	 * Checks whether given operation is a composite op.
	 * 
	 * @param operation operation
	 * @return true if correct
	 */
	public static boolean isComposite(AbstractOperation operation) {
		return operation instanceof CompositeOperation && ((CompositeOperation) operation).getMainOperation() == null;
	}

	/**
	 * Checks whether given operation is a reference op.
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
	 * Checks whether given operation is singleref op .
	 * 
	 * @param operation operation
	 * @return true if correct
	 */
	public static boolean isSingleRef(AbstractOperation operation) {
		return operation instanceof SingleReferenceOperation;
	}

	/**
	 * Checks whether given operation is a multiref op .
	 * 
	 * @param operation operation
	 * @return true if correct
	 */
	public static boolean isMultiRef(AbstractOperation operation) {
		return operation instanceof MultiReferenceOperation;
	}

	/**
	 * Checks whether given operation is multimove op.
	 * 
	 * @param operation operation
	 * @return true if correct
	 */
	public static boolean isMultiMoveRef(AbstractOperation operation) {
		return operation instanceof MultiReferenceMoveOperation;
	}

	/**
	 * Checks whether given operation is attribute op.
	 * 
	 * @param operation operation
	 * @return true if correct
	 */
	public static boolean isAttribute(AbstractOperation operation) {
		return operation instanceof AttributeOperation;
	}

	/**
	 * Checks whether given operation is diagram op.
	 * 
	 * @param operation operation
	 * @return true if correct
	 */
	public static boolean isDiagramLayout(AbstractOperation operation) {
		return operation instanceof DiagramLayoutOperation;
	}

	/**
	 * Checks whether given operation is a creating op.
	 * 
	 * @param operation operation
	 * @return true if correct
	 */
	public static boolean isCreate(AbstractOperation operation) {
		return isCreateDelete(operation) && !((CreateDeleteOperation) operation).isDelete();
	}

	/**
	 * Checks whether given operation is a deleting op.
	 * 
	 * @param operation operation
	 * @return true if correct
	 */
	public static boolean isDelete(AbstractOperation operation) {
		return isCreateDelete(operation) && ((CreateDeleteOperation) operation).isDelete();
	}

	/**
	 * Checks whether given operation is a createDelete op.
	 * 
	 * @param operation operation
	 * @return true if correct
	 */
	public static boolean isCreateDelete(AbstractOperation operation) {
		return operation instanceof CreateDeleteOperation;
	}

}
