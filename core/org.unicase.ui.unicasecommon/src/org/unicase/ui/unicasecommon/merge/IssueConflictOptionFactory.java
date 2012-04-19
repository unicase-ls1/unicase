/**
 * <copyright> Copyright (c) 2009-2012 Chair of Applied Software Engineering, Technische Universität München (TUM).
 * All rights reserved. This program and the accompanying materials are made available under the terms of
 * the Eclipse Public License v1.0 which accompanies this distribution,
 * and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>
 */
package org.unicase.ui.unicasecommon.merge;

import org.eclipse.emf.emfstore.client.ui.dialogs.merge.conflict.Conflict;
import org.eclipse.emf.emfstore.client.ui.dialogs.merge.conflict.CustomConflictOption;
import org.eclipse.emf.emfstore.client.ui.dialogs.merge.conflict.CustomConflictOptionFactory;

/**
 * Custom option factory for {@link IssueOption}.
 * 
 * @author wesendon
 */
public class IssueConflictOptionFactory implements CustomConflictOptionFactory {

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.unicase.workspace.ui.dialogs.merge.conflict.CustomConflictOptionFactory#createCustomConflictOption(org.unicase.workspace.ui.dialogs.merge.conflict.Conflict)
	 */
	public CustomConflictOption createCustomConflictOption(Conflict conflict) {
		if (!isApplicableConflict(conflict)) {
			return null;
		}
		IssueOption issueOption = new IssueOption();
		issueOption.setConflict(conflict);
		return issueOption;
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.unicase.workspace.ui.dialogs.merge.conflict.CustomConflictOptionFactory#isApplicableConflict(org.unicase.workspace.ui.dialogs.merge.conflict.Conflict)
	 */
	public boolean isApplicableConflict(Conflict conflict) {
		return true;
	}

}
