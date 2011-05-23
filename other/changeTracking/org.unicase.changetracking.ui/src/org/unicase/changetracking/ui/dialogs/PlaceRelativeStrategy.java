/**
 * <copyright> Copyright (c) 2008-2009 Jonas Helming, Maximilian Koegel. All rights reserved. This program and the
 * accompanying materials are made available under the terms of the Eclipse Public License v1.0 which accompanies this
 * distribution, and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>
 */
package org.unicase.changetracking.ui.dialogs;

import org.unicase.changetracking.common.ChangeTrackingUtil;
import org.unicase.metamodel.Project;
import org.unicase.model.UnicaseModelElement;

/**
 * This model element placement strategy places the newly created element
 * relative to another one (called target element). The target element is
 * specified in the constructor.
 * 
 * "Relative to" means that the model element tree is walked up starting from
 * the target element. Once a model element, in which the new model element can
 * reside, is found, the new model element is put in there.
 * 
 * The placement is wrapped in a unicase command.
 * 
 * @author jfinis
 * 
 */
public class PlaceRelativeStrategy implements IModelElementPlacementStrategy {

	private UnicaseModelElement relativeTo;

	/**
	 * Default constructor.
	 * 
	 * @param relativeTo Target model element
	 */
	public PlaceRelativeStrategy(UnicaseModelElement relativeTo) {
		this.relativeTo = relativeTo;
	}

	/**
	 * Places the new element relative to the target element. Placement is
	 * wrapped in a unicase command.
	 * 
	 * {@inheritDoc}
	 */
	public void placeModelElementInProject(final Project project, final UnicaseModelElement modelElement) {
		ChangeTrackingUtil.addToProjectRelative(modelElement, relativeTo, true);
	}

}
