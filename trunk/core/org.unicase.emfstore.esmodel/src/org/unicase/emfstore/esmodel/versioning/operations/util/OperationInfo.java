/**
 * <copyright> Copyright (c) 2008-2009 Jonas Helming, Maximilian Koegel. All rights reserved. This program and the
 * accompanying materials are made available under the terms of the Eclipse Public License v1.0 which accompanies this
 * distribution, and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>
 */
package org.unicase.emfstore.esmodel.versioning.operations.util;

import org.unicase.emfstore.esmodel.versioning.operations.AbstractOperation;
import org.unicase.emfstore.esmodel.versioning.operations.AttributeOperation;
import org.unicase.emfstore.esmodel.versioning.operations.FeatureOperation;
import org.unicase.emfstore.esmodel.versioning.operations.ReferenceOperation;
import org.unicase.model.ModelElementId;

/**
 * Convenience class with methods to ease information about operations.
 * 
 * @author chodnick
 */

public final class OperationInfo {

	private OperationInfo() {

	}

	/**
	 * Tests whether an operation changes a given feature of a given model element.
	 * 
	 * @param op the op to examine
	 * @param id the modelelement to check
	 * @param featureName the feature name to check
	 * @return if the operation changes the given model elements feature
	 */
	public static boolean changesModelElementFeature(FeatureOperation op, ModelElementId id, String featureName) {

		// attribute operation matches only
		// if the op is directly manipulating the attribute feature
		if (op instanceof AttributeOperation) {
			AttributeOperation o = (AttributeOperation) op;
			return o.getModelElementId().equals(id) && featureName.equals(o.getFeatureName());

		}

		// reference operation matches if the op is directly manipulating the model element
		// or if it is manipulated by means of the bidirectional
		if (op instanceof ReferenceOperation) {

			ReferenceOperation o = (ReferenceOperation) op;
			// direct manipulation
			if (o.getFeatureName().equals(featureName) && o.getModelElementId().equals(id)) {
				return true;
			}

			// bidirectional manipulation
			if (o.isBidirectional() && o.getOppositeFeatureName().equals(featureName)
				&& o.getOtherInvolvedModelElements().contains(id)) {
				return true;
			}
		}

		return false;
	}

	/**
	 * Tests whether an operation changes a given model element.
	 * 
	 * @param op the op to examine
	 * @param id the modelelement to check
	 * @return if the operation changes the given model element
	 */
	public static boolean changesModelElement(AbstractOperation op, ModelElementId id) {

		for (ModelElementId m : op.getAllInvolvedModelElements()) {
			if (m.equals(id)) {
				return true;
			}
		}

		return false;

	}

}
