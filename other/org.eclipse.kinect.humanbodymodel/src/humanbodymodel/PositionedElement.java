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
 * A representation of the model object '<em><b>Positioned Element</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link humanbodymodel.PositionedElement#getX <em>X</em>}</li>
 *   <li>{@link humanbodymodel.PositionedElement#getY <em>Y</em>}</li>
 *   <li>{@link humanbodymodel.PositionedElement#getZ <em>Z</em>}</li>
 *   <li>{@link humanbodymodel.PositionedElement#getName <em>Name</em>}</li>
 *   <li>{@link humanbodymodel.PositionedElement#getIncomingLinks <em>Incoming Links</em>}</li>
 *   <li>{@link humanbodymodel.PositionedElement#getOutgoingLinks <em>Outgoing Links</em>}</li>
 *   <li>{@link humanbodymodel.PositionedElement#getColor_r <em>Color r</em>}</li>
 *   <li>{@link humanbodymodel.PositionedElement#getColor_g <em>Color g</em>}</li>
 *   <li>{@link humanbodymodel.PositionedElement#getColor_b <em>Color b</em>}</li>
 * </ul>
 * </p>
 *
 * @see humanbodymodel.HumanbodymodelPackage#getPositionedElement()
 * @model
 * @generated
 */
public interface PositionedElement extends EObject {
	/**
	 * Returns the value of the '<em><b>X</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>X</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>X</em>' attribute.
	 * @see #setX(float)
	 * @see humanbodymodel.HumanbodymodelPackage#getPositionedElement_X()
	 * @model
	 * @generated
	 */
	float getX();

	/**
	 * Sets the value of the '{@link humanbodymodel.PositionedElement#getX <em>X</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>X</em>' attribute.
	 * @see #getX()
	 * @generated
	 */
	void setX(float value);

	/**
	 * Returns the value of the '<em><b>Y</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Y</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Y</em>' attribute.
	 * @see #setY(float)
	 * @see humanbodymodel.HumanbodymodelPackage#getPositionedElement_Y()
	 * @model
	 * @generated
	 */
	float getY();

	/**
	 * Sets the value of the '{@link humanbodymodel.PositionedElement#getY <em>Y</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Y</em>' attribute.
	 * @see #getY()
	 * @generated
	 */
	void setY(float value);

	/**
	 * Returns the value of the '<em><b>Z</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Z</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Z</em>' attribute.
	 * @see #setZ(float)
	 * @see humanbodymodel.HumanbodymodelPackage#getPositionedElement_Z()
	 * @model
	 * @generated
	 */
	float getZ();

	/**
	 * Sets the value of the '{@link humanbodymodel.PositionedElement#getZ <em>Z</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Z</em>' attribute.
	 * @see #getZ()
	 * @generated
	 */
	void setZ(float value);

	/**
	 * Returns the value of the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Name</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Name</em>' attribute.
	 * @see #setName(String)
	 * @see humanbodymodel.HumanbodymodelPackage#getPositionedElement_Name()
	 * @model
	 * @generated
	 */
	String getName();

	/**
	 * Sets the value of the '{@link humanbodymodel.PositionedElement#getName <em>Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Name</em>' attribute.
	 * @see #getName()
	 * @generated
	 */
	void setName(String value);

	/**
	 * Returns the value of the '<em><b>Incoming Links</b></em>' reference list.
	 * The list contents are of type {@link humanbodymodel.HumanLink}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Incoming Links</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Incoming Links</em>' reference list.
	 * @see humanbodymodel.HumanbodymodelPackage#getPositionedElement_IncomingLinks()
	 * @model
	 * @generated
	 */
	EList<HumanLink> getIncomingLinks();

	/**
	 * Returns the value of the '<em><b>Outgoing Links</b></em>' reference list.
	 * The list contents are of type {@link humanbodymodel.HumanLink}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Outgoing Links</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Outgoing Links</em>' reference list.
	 * @see humanbodymodel.HumanbodymodelPackage#getPositionedElement_OutgoingLinks()
	 * @model
	 * @generated
	 */
	EList<HumanLink> getOutgoingLinks();

	/**
	 * Returns the value of the '<em><b>Color r</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Color r</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Color r</em>' attribute.
	 * @see #setColor_r(int)
	 * @see humanbodymodel.HumanbodymodelPackage#getPositionedElement_Color_r()
	 * @model
	 * @generated
	 */
	int getColor_r();

	/**
	 * Sets the value of the '{@link humanbodymodel.PositionedElement#getColor_r <em>Color r</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Color r</em>' attribute.
	 * @see #getColor_r()
	 * @generated
	 */
	void setColor_r(int value);

	/**
	 * Returns the value of the '<em><b>Color g</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Color g</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Color g</em>' attribute.
	 * @see #setColor_g(int)
	 * @see humanbodymodel.HumanbodymodelPackage#getPositionedElement_Color_g()
	 * @model
	 * @generated
	 */
	int getColor_g();

	/**
	 * Sets the value of the '{@link humanbodymodel.PositionedElement#getColor_g <em>Color g</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Color g</em>' attribute.
	 * @see #getColor_g()
	 * @generated
	 */
	void setColor_g(int value);

	/**
	 * Returns the value of the '<em><b>Color b</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Color b</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Color b</em>' attribute.
	 * @see #setColor_b(int)
	 * @see humanbodymodel.HumanbodymodelPackage#getPositionedElement_Color_b()
	 * @model
	 * @generated
	 */
	int getColor_b();

	/**
	 * Sets the value of the '{@link humanbodymodel.PositionedElement#getColor_b <em>Color b</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Color b</em>' attribute.
	 * @see #getColor_b()
	 * @generated
	 */
	void setColor_b(int value);

} // PositionedElement
