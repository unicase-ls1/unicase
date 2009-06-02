/**
 * <copyright> </copyright> $Id$
 */
package org.unicase.model.rationale.validation;

import org.eclipse.emf.common.util.EList;
import org.unicase.model.ModelElement;
import org.unicase.model.organization.OrgUnit;

/*
 * A sample validator interface for {@link org.unicase.model.rationale.Comment}. This doesn't really do anything, and
 * it's not a real EMF artifact. It was generated by the org.eclipse.emf.examples.generator.validator plug-in to
 * illustrate how EMF's code generator can be extended. This can be disabled with -vmargs
 * -Dorg.eclipse.emf.examples.generator.validator=false.
 */
public interface CommentValidator {
	boolean validate();

	boolean validateSender(OrgUnit value);

	boolean validateRecipients(EList<OrgUnit> value);

	boolean validateCommentedElement(ModelElement value);
}
