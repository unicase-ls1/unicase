/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package humanbodymodel;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Human Container</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link humanbodymodel.HumanContainer#getElements <em>Elements</em>}</li>
 *   <li>{@link humanbodymodel.HumanContainer#getLinks <em>Links</em>}</li>
 * </ul>
 * </p>
 *
 * @see humanbodymodel.HumanbodymodelPackage#getHumanContainer()
 * @model
 * @generated
 */
public interface HumanContainer extends EObject {
	/**
	 * Returns the value of the '<em><b>Elements</b></em>' containment reference list.
	 * The list contents are of type {@link humanbodymodel.PositionedElement}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Elements</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Elements</em>' containment reference list.
	 * @see humanbodymodel.HumanbodymodelPackage#getHumanContainer_Elements()
	 * @model containment="true"
	 * @generated
	 */
	EList<PositionedElement> getElements();

	/**
	 * Returns the value of the '<em><b>Links</b></em>' reference list.
	 * The list contents are of type {@link humanbodymodel.HumanLink}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Links</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Links</em>' reference list.
	 * @see humanbodymodel.HumanbodymodelPackage#getHumanContainer_Links()
	 * @model
	 * @generated
	 */
	EList<HumanLink> getLinks();

} // HumanContainer
