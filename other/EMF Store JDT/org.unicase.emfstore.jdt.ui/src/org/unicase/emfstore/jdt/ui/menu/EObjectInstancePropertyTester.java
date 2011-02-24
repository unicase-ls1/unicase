/**
 * <copyright> Copyright (c) 2008-2009 Jonas Helming, Maximilian Koegel. All rights reserved. This program and the
 * accompanying materials are made available under the terms of the Eclipse Public License v1.0 which accompanies this
 * distribution, and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>
 */
package org.unicase.emfstore.jdt.ui.menu;

import org.eclipse.core.expressions.PropertyTester;
import org.eclipse.core.resources.IFile;
import org.unicase.emfstore.jdt.ui.PreferenceManager;

/**
 * A PropertyTester that returns true if the selected file matches to one of the supported file extensions. It
 * identifies if a file can be pushed to an EMFStore or not.
 * 
 * @author Adrian Staudt
 */
public class EObjectInstancePropertyTester extends PropertyTester {

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.core.expressions.IPropertyTester#test(java.lang.Object, java.lang.String, java.lang.Object[],
	 *      java.lang.Object)
	 */
	public boolean test(Object receiver, String property, Object[] args, Object expectedValue) {
		if (receiver instanceof IFile) {
			IFile file = (IFile) receiver;
			String fileExtension = file.getFileExtension();
			return PreferenceManager.isExtensionRegistered(fileExtension);

		}
		return false;
	}
}
