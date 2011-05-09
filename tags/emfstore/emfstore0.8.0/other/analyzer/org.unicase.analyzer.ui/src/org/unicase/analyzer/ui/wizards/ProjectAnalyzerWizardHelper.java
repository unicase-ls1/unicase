/**
 * <copyright> Copyright (c) 2008-2009 Jonas Helming, Maximilian Koegel. All rights reserved. This program and the
 * accompanying materials are made available under the terms of the Eclipse Public License v1.0 which accompanies this
 * distribution, and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>
 */
package org.unicase.analyzer.ui.wizards;

import org.eclipse.swt.widgets.Text;

/**
 * Helper for ProjectAnalyzerWizard.
 * 
 * @author liya
 */
public final class ProjectAnalyzerWizardHelper {

	/**
	 * sdsfd.
	 */
	private ProjectAnalyzerWizardHelper() {
	}

	/**
	 * @param t Text
	 * @return true is the Text is not empty
	 */
	public static boolean isTextNonEmpty(Text t) {
		String s = t.getText();
		if ((s != null) && (s.trim().length() > 0)) {
			return true;
		}
		return false;
	}

}
