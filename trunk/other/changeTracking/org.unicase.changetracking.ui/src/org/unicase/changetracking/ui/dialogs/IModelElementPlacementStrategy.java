/**
 * <copyright> Copyright (c) 2008-2009 Jonas Helming, Maximilian Koegel. All rights reserved. This program and the
 * accompanying materials are made available under the terms of the Eclipse Public License v1.0 which accompanies this
 * distribution, and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>
 */
package org.unicase.changetracking.ui.dialogs;

import org.unicase.metamodel.Project;
import org.unicase.model.UnicaseModelElement;

/**
 * A placement strategy is an algorithm for placing a newly created model
 * element in a project.
 * 
 * @author jfinis
 * 
 */
public interface IModelElementPlacementStrategy {

	/**
	 * Puts the model element into the project.
	 * 
	 * @param project project in which to put the element
	 * @param modelElement model element to be put into the project.
	 */
	void placeModelElementInProject(Project project, UnicaseModelElement modelElement);

}
