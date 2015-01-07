/**
 * <copyright> Copyright (c) 2009-2012 Chair of Applied Software Engineering, Technische Universit�t M�nchen (TUM).
 * All rights reserved. This program and the accompanying materials are made available under the terms of
 * the Eclipse Public License v1.0 which accompanies this distribution,
 * and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>
 */
package org.unicase.docExport.exportModel.renderers.options;

/**
 * <!-- begin-user-doc --> A representation of the model object '<em><b>Reference Attribute Option</b></em>'. <!--
 * end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.unicase.docExport.exportModel.renderers.options.ReferenceAttributeOption#isContained <em>Contained</em>}</li>
 *   <li>{@link org.unicase.docExport.exportModel.renderers.options.ReferenceAttributeOption#getReferenceOption <em>Reference Option</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.unicase.docExport.exportModel.renderers.options.OptionsPackage#getReferenceAttributeOption()
 * @model abstract="true"
 * @generated
 */
public interface ReferenceAttributeOption extends AttributeOption {
	/**
	 * Returns the value of the '<em><b>Contained</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Contained</em>' attribute isn't clear, there really should be more of a description
	 * here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Contained</em>' attribute.
	 * @see #setContained(boolean)
	 * @see org.unicase.docExport.exportModel.renderers.options.OptionsPackage#getReferenceAttributeOption_Contained()
	 * @model
	 * @generated
	 */
	boolean isContained();

	/**
	 * Sets the value of the '{@link org.unicase.docExport.exportModel.renderers.options.ReferenceAttributeOption#isContained <em>Contained</em>}' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @param value the new value of the '<em>Contained</em>' attribute.
	 * @see #isContained()
	 * @generated
	 */
	void setContained(boolean value);

	/**
	 * Returns the value of the '<em><b>Reference Option</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Reference Option</em>' containment reference isn't clear, there really should be more
	 * of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Reference Option</em>' containment reference.
	 * @see #setReferenceOption(ReferenceOption)
	 * @see org.unicase.docExport.exportModel.renderers.options.OptionsPackage#getReferenceAttributeOption_ReferenceOption()
	 * @model containment="true"
	 * @generated
	 */
	ReferenceOption getReferenceOption();

	/**
	 * Sets the value of the '{@link org.unicase.docExport.exportModel.renderers.options.ReferenceAttributeOption#getReferenceOption <em>Reference Option</em>}' containment reference.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @param value the new value of the '<em>Reference Option</em>' containment reference.
	 * @see #getReferenceOption()
	 * @generated
	 */
	void setReferenceOption(ReferenceOption value);

} // ReferenceAttributeOption
