/**
 * <copyright> </copyright> $Id$
 */
package org.unicase.model.urml;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.unicase.model.UnicaseModelElement;

/**
 * <!-- begin-user-doc --> A representation of the model object '<em><b>Model Element</b></em>'. <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.unicase.model.urml.UrmlModelElement#getAssociations <em>Associations</em>}</li>
 *   <li>{@link org.unicase.model.urml.UrmlModelElement#isReviewed <em>Reviewed</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.unicase.model.urml.UrmlPackage#getUrmlModelElement()
 * @model abstract="true"
 * @generated
 */
public interface UrmlModelElement extends UnicaseModelElement {

	/**
	 * Returns the value of the '<em><b>Associations</b></em>' reference list.
	 * The list contents are of type {@link org.unicase.model.urml.UrmlModelElement}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Associations</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Associations</em>' reference list.
	 * @see org.unicase.model.urml.UrmlPackage#getUrmlModelElement_Associations()
	 * @model
	 * @generated
	 */
	EList<UrmlModelElement> getAssociations();

	/**
	 * Returns the value of the '<em><b>Reviewed</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Reviewed</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Reviewed</em>' attribute.
	 * @see #setReviewed(boolean)
	 * @see org.unicase.model.urml.UrmlPackage#getUrmlModelElement_Reviewed()
	 * @model
	 * @generated
	 */
	boolean isReviewed();

	/**
	 * Sets the value of the '{@link org.unicase.model.urml.UrmlModelElement#isReviewed <em>Reviewed</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Reviewed</em>' attribute.
	 * @see #isReviewed()
	 * @generated
	 */
	void setReviewed(boolean value);
} // UrmlModelElement
