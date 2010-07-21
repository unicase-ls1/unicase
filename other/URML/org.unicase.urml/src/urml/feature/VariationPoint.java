/**
 * <copyright> </copyright> $Id$
 */
package urml.feature;

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc --> A representation of the model object '<em><b>Variation Point</b></em>'. <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link urml.feature.VariationPoint#getInstances <em>Instances</em>}</li>
 *   <li>{@link urml.feature.VariationPoint#getRules <em>Rules</em>}</li>
 * </ul>
 * </p>
 *
 * @see urml.feature.FeaturePackage#getVariationPoint()
 * @model
 * @generated
 */
public interface VariationPoint extends AbstractFeature {
	/**
	 * Returns the value of the '<em><b>Instances</b></em>' reference list.
	 * The list contents are of type {@link urml.feature.VariationPointInstance}.
	 * It is bidirectional and its opposite is '{@link urml.feature.VariationPointInstance#getVariationPoint <em>Variation Point</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Instances</em>' reference list isn't clear, there really should be more of a
	 * description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Instances</em>' reference list.
	 * @see urml.feature.FeaturePackage#getVariationPoint_Instances()
	 * @see urml.feature.VariationPointInstance#getVariationPoint
	 * @model opposite="variationPoint" keys="identifier"
	 * @generated
	 */
	EList<VariationPointInstance> getInstances();

	/**
	 * Returns the value of the '<em><b>Rules</b></em>' containment reference.
	 * It is bidirectional and its opposite is '{@link urml.feature.VariationPointRule#getVariationPoint <em>Variation Point</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Rules</em>' containment reference list isn't clear, there really should be more of a
	 * description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Rules</em>' containment reference.
	 * @see #setRules(VariationPointRule)
	 * @see urml.feature.FeaturePackage#getVariationPoint_Rules()
	 * @see urml.feature.VariationPointRule#getVariationPoint
	 * @model opposite="variationPoint" containment="true" resolveProxies="true" keys="identifier"
	 * @generated
	 */
	VariationPointRule getRules();

	/**
	 * Sets the value of the '{@link urml.feature.VariationPoint#getRules <em>Rules</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Rules</em>' containment reference.
	 * @see #getRules()
	 * @generated
	 */
	void setRules(VariationPointRule value);

} // VariationPoint
