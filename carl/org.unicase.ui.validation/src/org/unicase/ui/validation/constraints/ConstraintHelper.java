/**
 * <copyright> Copyright (c) 2008-2009 Jonas Helming, Maximilian Koegel. All rights reserved. This program and the
 * accompanying materials are made available under the terms of the Eclipse Public License v1.0 which accompanies this
 * distribution, and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>
 */

package org.unicase.ui.validation.constraints;

import org.eclipse.core.runtime.IStatus;
import org.eclipse.swt.graphics.Image;
import org.unicase.ui.validation.Activator;

/**
 * The constraint helper class.
 * 
 * @author pfeifferc
 */
public final class ConstraintHelper {

	private static ConstraintHelper constraintHelper;
	private Image infoIcon;
	private Image warningIcon;
	private Image errorIcon;

	/**
	 * Default constructor.
	 */
	private ConstraintHelper() {
		infoIcon = Activator.getImageDescriptor("icons/info.png").createImage();
		warningIcon = Activator.getImageDescriptor("icons/warning.png").createImage();
		errorIcon = Activator.getImageDescriptor("icons/error.png").createImage();
	}

	/**
	 * @return the singleton instance
	 */
	public static ConstraintHelper getInstance() {
		if (constraintHelper == null) {
			constraintHelper = new ConstraintHelper();
		}
		return constraintHelper;
	}

	/**
	 * Returns the appropriate icon.
	 * 
	 * @param constraintSeverity the
	 * @return the image or null if none
	 */
	public Image getImageForSeverity(int constraintSeverity) {
		if (constraintSeverity == IStatus.INFO) {
			return infoIcon;
		}
		if (constraintSeverity == IStatus.WARNING) {
			return warningIcon;
		}
		if (constraintSeverity == IStatus.ERROR) {
			return errorIcon;
		}
		return null;
	}
}
