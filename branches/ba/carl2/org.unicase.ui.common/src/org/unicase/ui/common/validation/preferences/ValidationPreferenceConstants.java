/**
 * <copyright> Copyright (c) 2008-2009 Jonas Helming, Maximilian Koegel. All rights reserved. This program and the
 * accompanying materials are made available under the terms of the Eclipse Public License v1.0 which accompanies this
 * distribution, and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>
 */

package org.unicase.ui.common.validation.preferences;

/**
 * Validation preference constants.
 * 
 * @author pfeifferc
 */
public final class ValidationPreferenceConstants {

	/**
	 * Default constructor.
	 */
	private ValidationPreferenceConstants() {
		// nothing to do here
	}

	/**
	 * Is validation enabled.
	 */
	public static final String VALIDATION_ENABLED = "org.unicase.validation.enabled";

	/**
	 * Is live validation enabled.
	 */
	public static final String LIVE_VALIDATION_ENABLED = "org.unicase.validation.live.enabled";

	/**
	 * Flat or recursive view mode.
	 */
	public static final String VALIDATION_VIEW_FLAT = "org.unicase.validation.view.mode";

	/**
	 * The constraint prefix for preference purposes.
	 */
	public static final String VALIDATION_CONSTRAINT_PREFIX = "org.unicase.validation.constraint.";

	/**
	 * The constraint prefix for preference purposes.
	 */
	public static final String VALIDATION_OCL_CONSTRAINT_PREFIX = "org.unicase.validation.constraint.ocl.";

	/**
	 * CSV OCL constraints.
	 */
	public static final String VALIDATION_OCL_CONSTRAINT_IDS = "org.unicase.validation.constraint.ocl.ids";
}
