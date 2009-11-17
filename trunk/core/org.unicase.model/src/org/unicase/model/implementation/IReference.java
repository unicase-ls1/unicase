/**
 * <copyright> Copyright (c) 2008-2009 Jonas Helming, Maximilian Koegel. All rights reserved. This program and the
 * accompanying materials are made available under the terms of the Eclipse Public License v1.0 which accompanies this
 * distribution, and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>
 */
package org.unicase.model.implementation;

/**
 * <!-- begin-user-doc --> A representation of the model object '<em><b>IReference</b></em>'. <!-- end-user-doc -->
 * <p>
 * The following features are supported:
 * <ul>
 * <li>{@link org.unicase.model.implementation.IReference#getParentClass <em>Parent Class</em>}</li>
 * <li>{@link org.unicase.model.implementation.IReference#getType <em>Type</em>}</li>
 * <li>{@link org.unicase.model.implementation.IReference#isContainment <em>Containment</em>}</li>
 * <li>{@link org.unicase.model.implementation.IReference#getOppositeReference <em>Opposite Reference</em>}</li>
 * </ul>
 * </p>
 * 
 * @see org.unicase.model.implementation.ImplementationPackage#getIReference()
 * @model
 * @generated
 */
public interface IReference extends IFeature {
	/**
	 * Returns the value of the '<em><b>Parent Class</b></em>' container reference. It is bidirectional and its opposite
	 * is '{@link org.unicase.model.implementation.IClass#getOutgoingReferences <em>Outgoing References</em>}'. <!--
	 * begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Parent Class</em>' container reference isn't clear, there really should be more of a
	 * description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * 
	 * @return the value of the '<em>Parent Class</em>' container reference.
	 * @see #setParentClass(IClass)
	 * @see org.unicase.model.implementation.ImplementationPackage#getIReference_ParentClass()
	 * @see org.unicase.model.implementation.IClass#getOutgoingReferences
	 * @model opposite="outgoingReferences" keys="identifier" transient="false"
	 * @generated
	 */
	IClass getParentClass();

	/**
	 * Sets the value of the '{@link org.unicase.model.implementation.IReference#getParentClass <em>Parent Class</em>}'
	 * container reference. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @param value the new value of the '<em>Parent Class</em>' container reference.
	 * @see #getParentClass()
	 * @generated
	 */
	void setParentClass(IClass value);

	/**
	 * Returns the value of the '<em><b>Type</b></em>' reference. It is bidirectional and its opposite is '
	 * {@link org.unicase.model.implementation.IClass#getIncomingReferences <em>Incoming References</em>}'. <!--
	 * begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Type</em>' reference isn't clear, there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * 
	 * @return the value of the '<em>Type</em>' reference.
	 * @see #isSetType()
	 * @see #unsetType()
	 * @see #setType(IClass)
	 * @see org.unicase.model.implementation.ImplementationPackage#getIReference_Type()
	 * @see org.unicase.model.implementation.IClass#getIncomingReferences
	 * @model opposite="incomingReferences" unsettable="true" keys="identifier"
	 * @generated
	 */
	IClass getType();

	/**
	 * Sets the value of the '{@link org.unicase.model.implementation.IReference#getType <em>Type</em>}' reference. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @param value the new value of the '<em>Type</em>' reference.
	 * @see #isSetType()
	 * @see #unsetType()
	 * @see #getType()
	 * @generated
	 */
	void setType(IClass value);

	/**
	 * Unsets the value of the '{@link org.unicase.model.implementation.IReference#getType <em>Type</em>}' reference.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see #isSetType()
	 * @see #getType()
	 * @see #setType(IClass)
	 * @generated
	 */
	void unsetType();

	/**
	 * Returns whether the value of the '{@link org.unicase.model.implementation.IReference#getType <em>Type</em>}'
	 * reference is set. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @return whether the value of the '<em>Type</em>' reference is set.
	 * @see #unsetType()
	 * @see #getType()
	 * @see #setType(IClass)
	 * @generated
	 */
	boolean isSetType();

	/**
	 * Returns the value of the '<em><b>Containment</b></em>' attribute. <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Containment</em>' attribute isn't clear, there really should be more of a description
	 * here...
	 * </p>
	 * <!-- end-user-doc -->
	 * 
	 * @return the value of the '<em>Containment</em>' attribute.
	 * @see #setContainment(boolean)
	 * @see org.unicase.model.implementation.ImplementationPackage#getIReference_Containment()
	 * @model
	 * @generated
	 */
	boolean isContainment();

	/**
	 * Sets the value of the '{@link org.unicase.model.implementation.IReference#isContainment <em>Containment</em>}'
	 * attribute. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @param value the new value of the '<em>Containment</em>' attribute.
	 * @see #isContainment()
	 * @generated
	 */
	void setContainment(boolean value);

	/**
	 * Returns the value of the '<em><b>Opposite Reference</b></em>' reference. <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Opposite Reference</em>' reference isn't clear, there really should be more of a
	 * description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * 
	 * @return the value of the '<em>Opposite Reference</em>' reference.
	 * @see #setOppositeReference(IReference)
	 * @see org.unicase.model.implementation.ImplementationPackage#getIReference_OppositeReference()
	 * @model keys="identifier"
	 * @generated
	 */
	IReference getOppositeReference();

	/**
	 * Sets the value of the '{@link org.unicase.model.implementation.IReference#getOppositeReference
	 * <em>Opposite Reference</em>}' reference. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @param value the new value of the '<em>Opposite Reference</em>' reference.
	 * @see #getOppositeReference()
	 * @generated
	 */
	void setOppositeReference(IReference value);

} // IReference
