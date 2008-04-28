/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.unicase.model;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Leaf Section</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.unicase.model.LeafSection#getElementType <em>Element Type</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.unicase.model.ModelPackage#getLeafSection()
 * @model
 * @generated
 */
public interface LeafSection extends Section {
	/**
	 * Returns the value of the '<em><b>Element Type</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Element Type</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Element Type</em>' attribute.
	 * @see #setElementType(Class)
	 * @see org.unicase.model.ModelPackage#getLeafSection_ElementType()
	 * @model
	 * @generated
	 */
	Class<? extends ModelElement> getElementType();

	/**
	 * Sets the value of the '{@link org.unicase.model.LeafSection#getElementType <em>Element Type</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Element Type</em>' attribute.
	 * @see #getElementType()
	 * @generated
	 */
	void setElementType(Class<? extends ModelElement> value);

} // LeafSection
