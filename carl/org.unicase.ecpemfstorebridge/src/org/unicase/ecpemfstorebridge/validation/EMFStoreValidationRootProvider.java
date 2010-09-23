/**
 * <copyright> Copyright (c) 2008-2009 Jonas Helming, Maximilian Koegel. All rights reserved. This program and the
 * accompanying materials are made available under the terms of the Eclipse Public License v1.0 which accompanies this
 * distribution, and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>
 */
package org.unicase.ecpemfstorebridge.validation;

import org.eclipse.emf.ecore.EObject;
import org.unicase.metamodel.ModelElement;
import org.unicase.metamodel.Project;
import org.unicase.ui.common.validation.providers.ValidationRootProvider;
import org.unicase.workspace.ProjectSpace;
import org.unicase.workspace.WorkspaceManager;

/**
 * @author pfeifferc
 */
public final class EMFStoreValidationRootProvider extends ValidationRootProvider {

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.unicase.ui.common.validation.providers.ValidationRootProvider#getRootFor(org.eclipse.emf.ecore.EObject)
	 */
	@Override
	public EObject getRootFor(EObject eObject) {
		if (eObject instanceof ProjectSpace) {
			return ((ProjectSpace) eObject).getProject();
		}
		if (eObject instanceof Project) {
			return eObject;
		}
		if (eObject instanceof ModelElement) {
			return ((ModelElement) eObject).getProject();
		}
		return WorkspaceManager.getInstance().getCurrentWorkspace().getActiveProjectSpace().getProject();
	}
}
