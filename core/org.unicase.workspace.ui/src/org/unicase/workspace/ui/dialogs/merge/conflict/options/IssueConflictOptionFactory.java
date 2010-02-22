/**
 * <copyright> Copyright (c) 2008-2009 Jonas Helming, Maximilian Koegel. All rights reserved. This program and the
 * accompanying materials are made available under the terms of the Eclipse Public License v1.0 which accompanies this
 * distribution, and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>
 */
package org.unicase.workspace.ui.dialogs.merge.conflict.options;

import org.unicase.workspace.ui.dialogs.merge.conflict.Conflict;
import org.unicase.workspace.ui.dialogs.merge.conflict.CustomConflictOption;
import org.unicase.workspace.ui.dialogs.merge.conflict.CustomConflictOptionFactory;

public class IssueConflictOptionFactory implements CustomConflictOptionFactory {

	public CustomConflictOption createCustomConflictOption(Conflict conflict) {
		if (!isApplicableConflict(conflict)) {
			return null;
		}
		IssueOption issueOption = new IssueOption();
		issueOption.setConflict(conflict);
		return issueOption;
	}

	public boolean isApplicableConflict(Conflict conflict) {
		return true;
	}

}
