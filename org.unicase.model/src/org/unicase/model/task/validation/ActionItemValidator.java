/**
 * <copyright> </copyright> $Id$
 */
package org.unicase.model.task.validation;

import org.unicase.model.task.ActivityType;

/*
 * A sample validator interface for {@link org.unicase.model.task.ActionItem}. This doesn't really do anything, and it's
 * not a real EMF artifact. It was generated by the org.eclipse.emf.examples.generator.validator plug-in to illustrate
 * how EMF's code generator can be extended. This can be disabled with -vmargs
 * -Dorg.eclipse.emf.examples.generator.validator=false.
 */
public interface ActionItemValidator {
	boolean validate();

	boolean validateDone(boolean value);

	boolean validateActivity(ActivityType value);
}
