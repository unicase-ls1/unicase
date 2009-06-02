/**
 * <copyright> </copyright> $Id$
 */
package org.unicase.model.meeting.validation;

import org.eclipse.emf.common.util.EList;
import org.unicase.model.rationale.Issue;

/*
 * A sample validator interface for {@link org.unicase.model.meeting.IssueMeetingSection}. This doesn't really do
 * anything, and it's not a real EMF artifact. It was generated by the org.eclipse.emf.examples.generator.validator
 * plug-in to illustrate how EMF's code generator can be extended. This can be disabled with -vmargs
 * -Dorg.eclipse.emf.examples.generator.validator=false.
 */
public interface IssueMeetingSectionValidator {
	boolean validate();

	boolean validateIncludedIssues(EList<Issue> value);
}
