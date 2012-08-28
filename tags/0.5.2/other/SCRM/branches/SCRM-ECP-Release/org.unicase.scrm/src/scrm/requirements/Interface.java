/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package scrm.requirements;

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Interface</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link scrm.requirements.Interface#getProvidingFeature <em>Providing Feature</em>}</li>
 *   <li>{@link scrm.requirements.Interface#getRequiringFeatures <em>Requiring Features</em>}</li>
 * </ul>
 * </p>
 *
 * @see scrm.requirements.RequirementsPackage#getInterface()
 * @model interface="true" abstract="true"
 * @generated
 */
public interface Interface extends IRequirement {
	/**
	 * Returns the value of the '<em><b>Providing Feature</b></em>' container reference.
	 * It is bidirectional and its opposite is '{@link scrm.requirements.Feature#getProvidedInterfaces <em>Provided Interfaces</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Providing Feature</em>' container reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Providing Feature</em>' container reference.
	 * @see #setProvidingFeature(Feature)
	 * @see scrm.requirements.RequirementsPackage#getInterface_ProvidingFeature()
	 * @see scrm.requirements.Feature#getProvidedInterfaces
	 * @model opposite="providedInterfaces" transient="false"
	 *        annotation="org.eclipse.emf.ecp.editor position='left' priority='15'"
	 * @generated
	 */
	Feature getProvidingFeature();

	/**
	 * Sets the value of the '{@link scrm.requirements.Interface#getProvidingFeature <em>Providing Feature</em>}' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Providing Feature</em>' container reference.
	 * @see #getProvidingFeature()
	 * @generated
	 */
	void setProvidingFeature(Feature value);

	/**
	 * Returns the value of the '<em><b>Requiring Features</b></em>' reference list.
	 * The list contents are of type {@link scrm.requirements.Feature}.
	 * It is bidirectional and its opposite is '{@link scrm.requirements.Feature#getRequiredInterfaces <em>Required Interfaces</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Requiring Features</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Requiring Features</em>' reference list.
	 * @see scrm.requirements.RequirementsPackage#getInterface_RequiringFeatures()
	 * @see scrm.requirements.Feature#getRequiredInterfaces
	 * @model opposite="requiredInterfaces"
	 *        annotation="org.eclipse.emf.ecp.editor position='right' priority='10'"
	 * @generated
	 */
	EList<Feature> getRequiringFeatures();

} // Interface
