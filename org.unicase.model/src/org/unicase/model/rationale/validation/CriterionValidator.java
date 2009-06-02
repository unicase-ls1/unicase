/**
 * <copyright> </copyright> $Id$
 */
package org.unicase.model.rationale.validation;

import org.eclipse.emf.common.util.EList;
import org.unicase.model.rationale.Assessment;

/*
 * A sample validator interface for {@link org.unicase.model.rationale.Criterion}. This doesn't really do anything, and
 * it's not a real EMF artifact. It was generated by the org.eclipse.emf.examples.generator.validator plug-in to
 * illustrate how EMF's code generator can be extended. This can be disabled with -vmargs
 * -Dorg.eclipse.emf.examples.generator.validator=false.
 */
public interface CriterionValidator {
	boolean validate();

	boolean validateAssessments(EList<Assessment> value);
}
