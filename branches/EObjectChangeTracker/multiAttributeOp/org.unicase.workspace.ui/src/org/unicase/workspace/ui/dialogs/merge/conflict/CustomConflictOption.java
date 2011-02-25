/**
 * <copyright> Copyright (c) 2008-2009 Jonas Helming, Maximilian Koegel. All rights reserved. This program and the
 * accompanying materials are made available under the terms of the Eclipse Public License v1.0 which accompanies this
 * distribution, and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>
 */
package org.unicase.workspace.ui.dialogs.merge.conflict;

/**
 * Abstract superclass for custom options.
 * 
 * @author wesendon
 */
public abstract class CustomConflictOption extends ConflictOption {

	/**
	 * Default constructor.
	 * 
	 * @param option
	 *            name of option.
	 */
	public CustomConflictOption(String option) {
		super(option, OptionType.Custom);
	}

	/**
	 * Returns Option prefix.
	 * 
	 * @return text
	 */
	public String getOptionPrefix() {
		return null;
	}
}
