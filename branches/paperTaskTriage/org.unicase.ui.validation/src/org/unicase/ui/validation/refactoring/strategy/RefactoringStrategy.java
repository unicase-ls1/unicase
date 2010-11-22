/**
 * <copyright> Copyright (c) 2008-2009 Jonas Helming, Maximilian Koegel. All rights reserved. This program and the
 * accompanying materials are made available under the terms of the Eclipse Public License v1.0 which accompanies this
 * distribution, and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>
 */

package org.unicase.ui.validation.refactoring.strategy;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.validation.model.IConstraintStatus;
import org.eclipse.swt.widgets.Shell;

/**
 * @author pfeifferc
 */
public interface RefactoringStrategy {

	/**
	 * This will start the refactoring.
	 * 
	 * @return the result
	 */
	RefactoringResult startRefactoring();

	/**
	 * @param status the
	 */
	void setConstraintStatus(IConstraintStatus status);

	/**
	 * @return the description
	 */
	String getDescription();

	/**
	 * @return the id
	 */
	String getId();

	/**
	 * @param shell the
	 */
	void setShell(Shell shell);

	/**
	 * @return the invalid model element
	 */
	EObject getInvalidModelElement();
}