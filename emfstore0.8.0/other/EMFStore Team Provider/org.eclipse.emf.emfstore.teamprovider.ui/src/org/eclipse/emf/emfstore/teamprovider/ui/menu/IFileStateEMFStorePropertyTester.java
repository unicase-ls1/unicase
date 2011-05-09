/*******************************************************************************
 * Copyright (c) 2008-2011 Chair for Applied Software Engineering, Technische Universitaet Muenchen.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 ******************************************************************************/
package org.eclipse.emf.emfstore.teamprovider.ui.menu;

import org.eclipse.core.expressions.PropertyTester;
import org.eclipse.core.resources.IFile;
import org.eclipse.emf.emfstore.teamprovider.configuration.ConfigurationManager;
import org.eclipse.emf.emfstore.teamprovider.configuration.EMFStoreTeamProviderConfiguration;
import org.eclipse.emf.emfstore.teamprovider.configuration.Entry;
import org.eclipse.emf.emfstore.teamprovider.exception.EntryNotFoundException;
import org.eclipse.emf.emfstore.teamprovider.exception.NoEMFStoreTeamProviderConfigurationException;

/**
 * A PropertyTester that identifies if a selected file is already pushed to an EMF Store.
 * 
 * @author Adrian Staudt
 */
public class IFileStateEMFStorePropertyTester extends PropertyTester {

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.core.expressions.IPropertyTester#test(java.lang.Object, java.lang.String, java.lang.Object[],
	 *      java.lang.Object)
	 */
	public boolean test(Object receiver, String property, Object[] args, Object expectedValue) {
		if (receiver instanceof IFile && expectedValue instanceof String) {
			IFile file = (IFile) receiver;
			String state = (String) expectedValue;

			boolean isPushed = isPushed(file);
			if (state.equals("canPush") && isPushed) {
				return false;
			} else if (state.equals("canPush") && !isPushed) {
				return true;
			}
			if (state.equals("canReject") && !isPushed) {
				return false;
			} else if (state.equals("canReject") && isPushed) {
				return true;
			}
		}

		return false;
	}

	/**
	 * Proofs if the file is pushed.
	 * 
	 * @param file the file that should be checked
	 * @return true if the file is marked as pushed, otherwise false
	 */
	private boolean isPushed(IFile file) {
		try {
			EMFStoreTeamProviderConfiguration emfStoreJDTConfiguration = ConfigurationManager
				.getConfiguration(file.getProject());
			Entry entry = ConfigurationManager.getEntry(emfStoreJDTConfiguration, file);
			return !entry.isMarkedForDeletion();

		} catch (NoEMFStoreTeamProviderConfigurationException e) {
			return false;

		} catch (EntryNotFoundException e) {
			return false;
		}
	}

}
