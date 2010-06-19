/**
 * <copyright> Copyright (c) 2008-2009 Jonas Helming, Maximilian Koegel. All rights reserved. This program and the
 * accompanying materials are made available under the terms of the Eclipse Public License v1.0 which accompanies this
 * distribution, and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>
 */
package org.unicase.ui.navigator.workSpaceModel;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.transaction.TransactionalEditingDomain;

/**
 * <!-- begin-user-doc --> A representation of the model object '<em><b>ECP Workspace</b></em>'. <!-- end-user-doc -->
 * 
 * @see org.unicase.ui.navigator.workSpaceModel.WorkSpaceModelPackage#getECPWorkspace()
 * @model abstract="true"
 * @generated
 */
public interface ECPWorkspace extends EObject {
	/**
	 * Returns the transaction editing domain.
	 * 
	 * @return the editing domain
	 */
	public TransactionalEditingDomain getEditingDomain();

	public ECPProject getProject(EObject me);

	public ECPProject getActiveProject();

	public void setActiveModelelement(EObject eobject);

} // ECPWorkspace
