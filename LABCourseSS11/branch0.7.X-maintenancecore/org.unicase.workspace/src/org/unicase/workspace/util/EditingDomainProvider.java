/**
 * <copyright> Copyright (c) 2008-2009 Jonas Helming, Maximilian Koegel. All rights reserved. This program and the
 * accompanying materials are made available under the terms of the Eclipse Public License v1.0 which accompanies this
 * distribution, and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>
 */
package org.unicase.workspace.util;

import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.edit.domain.EditingDomain;

/**
 * Interface for editing domain provider.
 * 
 * @author wesendon
 */
public interface EditingDomainProvider {

	/**
	 * Returns EditingDomain.
	 * 
	 * @param resourceSet resource set
	 * @return domain
	 */
	EditingDomain getEditingDomain(ResourceSet resourceSet);
}
