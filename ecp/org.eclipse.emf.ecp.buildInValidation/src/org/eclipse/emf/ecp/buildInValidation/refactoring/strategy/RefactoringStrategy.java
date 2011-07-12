package org.eclipse.emf.ecp.buildInValidation.refactoring.strategy;

import org.eclipse.core.runtime.IStatus;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.swt.widgets.Shell;

/**
 * 
 * @author Carmen Carlan
 * 
 */
public interface RefactoringStrategy {
	/**
	 * This will start the refactoring.
	 * 
	 * @return the result
	 */
	RefactoringResult startRefactoring();

	/**
	 * @param status
	 *            the
	 */
	void setConstraintStatus(IStatus status);

	/**
	 * @return the description
	 */
	String getDescription();

	/**
	 * @return the id
	 */
	String getId();

	/**
	 * @param shell
	 *            the
	 */
	void setShell(Shell shell);

	/**
	 * @return the invalid model element
	 */
	EObject getInvalidModelElement();
}
