/**
 * <copyright> Copyright (c) 2009-2012 Chair of Applied Software Engineering, Technische Universität München (TUM).
* All rights reserved. This program and the accompanying materials are made available under the terms of
* the Eclipse Public License v1.0 which accompanies this distribution,
* and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>
 */
package org.unicase.model.attachment;

import org.eclipse.emf.ecore.EFactory;

/**
 * <!-- begin-user-doc --> The <b>Factory</b> for the model. It provides a create method for each non-abstract class of
 * the model. <!-- end-user-doc -->
 * 
 * @see org.unicase.model.attachment.AttachmentPackage
 * @generated
 */
public interface AttachmentFactory extends EFactory {
	/**
	 * The singleton instance of the factory. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	AttachmentFactory eINSTANCE = org.unicase.model.attachment.impl.AttachmentFactoryImpl.init();

	/**
	 * Returns a new object of class '<em>Url Attachment</em>'. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @return a new object of class '<em>Url Attachment</em>'.
	 * @generated
	 */
	UrlAttachment createUrlAttachment();

	/**
	 * Returns a new object of class '<em>File Attachment</em>'. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @return a new object of class '<em>File Attachment</em>'.
	 * @generated
	 */
	FileAttachment createFileAttachment();

	/**
	 * Returns the package supported by this factory. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @return the package supported by this factory.
	 * @generated
	 */
	AttachmentPackage getAttachmentPackage();

} // AttachmentFactory
