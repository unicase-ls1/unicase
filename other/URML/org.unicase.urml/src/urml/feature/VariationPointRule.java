/**
 * <copyright> </copyright> $Id$
 */
package urml.feature;

import org.unicase.model.urml.UrmlModelElement;

/**
 * <!-- begin-user-doc --> A representation of the model object '<em><b>Variation Point Rule</b></em>'. <!--
 * end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link urml.feature.VariationPointRule#getVariationPoint <em>Variation Point</em>}</li>
 * </ul>
 * </p>
 *
 * @see urml.feature.FeaturePackage#getVariationPointRule()
 * @model abstract="true"
 * @generated
 */
public interface VariationPointRule extends UrmlModelElement {
	/**
	 * Returns the value of the '<em><b>Variation Point</b></em>' container reference.
	 * It is bidirectional and its opposite is '{@link urml.feature.VariationPoint#getRules <em>Rules</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Variation Point</em>' container reference isn't clear, there really should be more of
	 * a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Variation Point</em>' container reference.
	 * @see #setVariationPoint(VariationPoint)
	 * @see urml.feature.FeaturePackage#getVariationPointRule_VariationPoint()
	 * @see urml.feature.VariationPoint#getRules
	 * @model opposite="rules" keys="identifier" transient="false"
	 * @generated
	 */
	VariationPoint getVariationPoint();

	/**
	 * Sets the value of the '{@link urml.feature.VariationPointRule#getVariationPoint <em>Variation Point</em>}' container reference.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @param value the new value of the '<em>Variation Point</em>' container reference.
	 * @see #getVariationPoint()
	 * @generated
	 */
	void setVariationPoint(VariationPoint value);

} // VariationPointRule
