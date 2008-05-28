/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.unicase.model.document;

import org.eclipse.emf.common.util.EList;
import org.unicase.model.ModelElement;
import org.unicase.model.ModelPackage;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Leaf Section</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.unicase.model.document.LeafSection#getElementClass <em>Element Class</em>}</li>
 *   <li>{@link org.unicase.model.document.LeafSection#getModelElements <em>Model Elements</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.unicase.model.document.DocumentPackage#getLeafSection()
 * @model
 * @generated
 */
public interface LeafSection extends Section {
	/**
	 * Returns the value of the '<em><b>Element Class</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Element Class</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Element Class</em>' attribute.
	 * @see #setElementClass(Class)
	 * @see org.unicase.model.document.DocumentPackage#getLeafSection_ElementClass()
	 * @model
	 * @generated
	 */
	Class<? extends ModelElement> getElementClass();

	/**
	 * Sets the value of the '{@link org.unicase.model.document.LeafSection#getElementClass <em>Element Class</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Element Class</em>' attribute.
	 * @see #getElementClass()
	 * @generated
	 */
	void setElementClass(Class<? extends ModelElement> value);

	/**
	 * Returns the value of the '<em><b>Model Elements</b></em>' containment reference list.
	 * The list contents are of type {@link org.unicase.model.ModelElement}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Model Elements</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Model Elements</em>' containment reference list.
	 * @see org.unicase.model.document.DocumentPackage#getLeafSection_ModelElements()
	 * @model containment="true"
	 * @generated
	 */
	EList<ModelElement> getModelElements();

} // LeafSection
