/**
 * <copyright> </copyright> $Id$
 */
package urml.feature;

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Variation Point</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link urml.feature.VariationPoint#getVariety <em>Variety</em>}</li>
 *   <li>{@link urml.feature.VariationPoint#getVarietyMultiplicity <em>Variety Multiplicity</em>}</li>
 *   <li>{@link urml.feature.VariationPoint#getInstances <em>Instances</em>}</li>
 * </ul>
 * </p>
 *
 * @see urml.feature.FeaturePackage#getVariationPoint()
 * @model
 * @generated
 */
public interface VariationPoint extends AbstractFeature {
	/**
	 * Returns the value of the '<em><b>Variety</b></em>' reference list.
	 * The list contents are of type {@link urml.feature.AbstractFeature}.
	 * It is bidirectional and its opposite is '{@link urml.feature.AbstractFeature#getVariationPoint <em>Variation Point</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Variety</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Variety</em>' reference list.
	 * @see urml.feature.FeaturePackage#getVariationPoint_Variety()
	 * @see urml.feature.AbstractFeature#getVariationPoint
	 * @model opposite="variationPoint" keys="identifier"
	 * @generated
	 */
	EList<AbstractFeature> getVariety();

	/**
	 * Returns the value of the '<em><b>Variety Multiplicity</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Variety Multiplicity</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Variety Multiplicity</em>' attribute.
	 * @see #setVarietyMultiplicity(int)
	 * @see urml.feature.FeaturePackage#getVariationPoint_VarietyMultiplicity()
	 * @model
	 * @generated
	 */
	int getVarietyMultiplicity();

	/**
	 * Sets the value of the '{@link urml.feature.VariationPoint#getVarietyMultiplicity <em>Variety Multiplicity</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Variety Multiplicity</em>' attribute.
	 * @see #getVarietyMultiplicity()
	 * @generated
	 */
	void setVarietyMultiplicity(int value);

	/**
	 * Returns the value of the '<em><b>Instances</b></em>' reference list.
	 * The list contents are of type {@link urml.feature.VariationPointInstance}.
	 * It is bidirectional and its opposite is '{@link urml.feature.VariationPointInstance#getVariationPoint <em>Variation Point</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Instances</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Instances</em>' reference list.
	 * @see urml.feature.FeaturePackage#getVariationPoint_Instances()
	 * @see urml.feature.VariationPointInstance#getVariationPoint
	 * @model opposite="variationPoint" keys="identifier"
	 * @generated
	 */
	EList<VariationPointInstance> getInstances();

} // VariationPoint
