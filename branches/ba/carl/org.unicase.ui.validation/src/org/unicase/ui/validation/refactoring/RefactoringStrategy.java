/**
 * <copyright> Copyright (c) 2008-2009 Jonas Helming, Maximilian Koegel. All rights reserved. This program and the
 * accompanying materials are made available under the terms of the Eclipse Public License v1.0 which accompanies this
 * distribution, and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>
 */

package org.unicase.ui.validation.refactoring;

import java.util.Set;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.validation.model.IConstraintStatus;
import org.eclipse.swt.widgets.Shell;

/**
 * @author pfeifferc
 */
public interface RefactoringStrategy {

	/**
	 * Start the refactoring.
	 * 
	 * @return result {@link RefactoringResult}
	 */
	RefactoringResult startRefactoring();

	/**
	 * Set shell.
	 * 
	 * @param shell {@link Shell}
	 */
	void setShell(Shell shell);

	/**
	 * @return shell
	 */
	Shell getShell();

	/**
	 * Set invalid {@link EObject}.
	 * 
	 * @param eObject the invalid {@link EObject}
	 */
	void setInvalidEObject(EObject eObject);

	/**
	 * @return getInvalidEObject
	 */
	EObject getInvalidEObject();

	/**
	 * @return getConstraintStatus
	 */
	Set<IConstraintStatus> getConstraintStati();

	/**
	 * @param constraintStati {@link IConstraintStatus}
	 */
	void setConstraintStati(Set<IConstraintStatus> constraintStati);

	/**
	 * @param name the
	 */
	void setName(String name);

	/**
	 * @return the name
	 */
	String getName();

	/**
	 * @param description the
	 */
	void setDescription(String description);

	/**
	 * @return getDescription
	 */
	String getDescription();

	/**
	 * @param id the
	 */
	void setId(String id);

	/**
	 * @return getId
	 */
	String getId();
}