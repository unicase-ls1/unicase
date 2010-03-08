/**
 * <copyright> Copyright (c) 2008-2009 Jonas Helming, Maximilian Koegel. All rights reserved. This program and the
 * accompanying materials are made available under the terms of the Eclipse Public License v1.0 which accompanies this
 * distribution, and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>
 */

package org.unicase.ui.validation.refactoring.rules;

import java.util.Set;

import org.eclipse.emf.validation.AbstractModelConstraint;
import org.eclipse.emf.validation.model.IConstraintStatus;
import org.unicase.metamodel.ModelElement;

/**
 * 
 * @author pfeifferc
 *
 */
public abstract class RefactoringRule {

	/**
	 * @return the model constraint this refactoring rule is responsible for enforcing
	 */
	public abstract AbstractModelConstraint getConstraintResponsibleFor();
	
	/**
	 * @return the description of this refactoring rule
	 * @return
	 */
	public abstract String getDescription();
	
	/**
	 * Applies the refactoring rule to the set of specified set of model elements.
	 * 
	 * @param modelElements the
	 * @param status the
	 * @return yes if it succeeded, no if not
	 */
	public abstract boolean applyRule(Set<ModelElement> modelElements, IConstraintStatus status);
	
}
