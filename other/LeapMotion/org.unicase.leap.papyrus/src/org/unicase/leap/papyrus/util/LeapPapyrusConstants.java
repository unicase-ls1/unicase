/**
 * <copyright> Copyright (c) 2009-2012 Chair of Applied Software Engineering, Technische Universität München (TUM).
 * All rights reserved. This program and the accompanying materials are made available under the terms of
 * the Eclipse Public License v1.0 which accompanies this distribution,
 * and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>
 */
package org.unicase.leap.papyrus.util;

import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.gmf.runtime.notation.NotationPackage;

/**
 * This class defines constants which can are used by this plug-in to manipulate Papyrus diagrams.
 * 
 * @author mharut
 */
public final class LeapPapyrusConstants {

	/**
	 * The GMF notation package used to retrieve {@link EStructuralFeature} constants.
	 */
	private static final NotationPackage NOTATION = NotationPackage.eINSTANCE;

	/**
	 * The feature used to specify the x-coordinate of a {@link org.eclipse.gmf.runtime.notation.View View}'s location.
	 */
	public static final EStructuralFeature LOCATION_X = NOTATION.getLocation_X();
	/**
	 * The feature used to specify the y-coordinate of a {@link org.eclipse.gmf.runtime.notation.View View}'s location.
	 */
	public static final EStructuralFeature LOCATION_Y = NOTATION.getLocation_Y();
	/**
	 * The feature used to specify the height of a {@link org.eclipse.gmf.runtime.notation.View View}.
	 */
	public static final EStructuralFeature SIZE_HEIGHT = NOTATION.getSize_Height();
	/**
	 * The feature used to specify the width of a {@link org.eclipse.gmf.runtime.notation.View View}.
	 */
	public static final EStructuralFeature SIZE_WIDTH = NOTATION.getSize_Width();

	/**
	 * Private constructor - all constants should be accessed statically.
	 */
	private LeapPapyrusConstants() {
		// nothing to do
	}

}
