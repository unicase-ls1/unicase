/**
 * <copyright> Copyright (c) 2008-2009 Jonas Helming, Maximilian Koegel. All rights reserved. This program and the
 * accompanying materials are made available under the terms of the Eclipse Public License v1.0 which accompanies this
 * distribution, and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>
 */
package org.unicase.model.document;

import org.unicase.model.UnicaseModelElement;

/**
 * <!-- begin-user-doc --> A representation of the model object ' <em><b>Section</b></em>'. <!-- end-user-doc -->
 * <p>
 * The following features are supported:
 * <ul>
 * <li>{@link org.unicase.model.document.Section#getParent <em>Parent</em>}</li>
 * </ul>
 * </p>
 * 
 * @see org.unicase.model.document.DocumentPackage#getSection()
 * @model interface="true" abstract="true"
 * @generated
 */
public interface Section extends UnicaseModelElement {
	/**
	 * Returns the value of the '<em><b>Parent</b></em>' container reference. It is bidirectional and its opposite is '
	 * {@link org.unicase.model.document.CompositeSection#getSubsections <em>Subsections</em>}'. <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Parent</em>' container reference isn't clear, there really should be more of a
	 * description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * 
	 * @return the value of the '<em>Parent</em>' container reference.
	 * @see #setParent(CompositeSection)
	 * @see org.unicase.model.document.DocumentPackage#getSection_Parent()
	 * @see org.unicase.model.document.CompositeSection#getSubsections
	 * @model opposite="subsections" transient="false"
	 * @generated
	 */
	CompositeSection getParent();

	/**
	 * Sets the value of the '{@link org.unicase.model.document.Section#getParent <em>Parent</em>}' container reference.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @param value the new value of the '<em>Parent</em>' container reference.
	 * @see #getParent()
	 * @generated
	 */
	void setParent(CompositeSection value);

} // Section
