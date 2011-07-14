/**
 * <copyright> Copyright (c) 2008-2009 Jonas Helming, Maximilian Koegel. All rights reserved. This program and the
 * accompanying materials are made available under the terms of the Eclipse Public License v1.0 which accompanies this
 * distribution, and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>
 */

package org.unicase.ui.refactoring.templates.dialogs;

import org.unicase.ui.validation.refactoring.RefactoringResult;

/**
 * The refactoring dialog interface.
 * @author pfeifferc
 *
 */
public interface AbstractRefactoringDialog {
	
	/**
	 * @return the refactoring result
	 */
	RefactoringResult getRefactoringResult();
	
	/**
	 * Set the refactoring result.
	 * 
	 * @param refactoringResult the
	 */
	void setRefactoringResult(RefactoringResult refactoringResult);
	
	/**
	 * Opens the dialog.
	 * 
	 * @return the return code
	 */
	int open();
}
