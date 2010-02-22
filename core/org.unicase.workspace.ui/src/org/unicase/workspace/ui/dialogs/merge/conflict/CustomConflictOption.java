/**
 * <copyright> Copyright (c) 2008-2009 Jonas Helming, Maximilian Koegel. All rights reserved. This program and the
 * accompanying materials are made available under the terms of the Eclipse Public License v1.0 which accompanies this
 * distribution, and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>
 */
package org.unicase.workspace.ui.dialogs.merge.conflict;

public abstract class CustomConflictOption extends ConflictOption {

	public CustomConflictOption(String option) {
		super(option, OptionType.Custom);
	}

	public String getOptionPrefix() {
		return null;
	}
}
