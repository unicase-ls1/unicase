/**
 * <copyright> </copyright> $Id$
 */
package urml.feature;

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc --> A representation of the model object '<em><b>Variation Point</b></em>'. <!-- end-user-doc -->
 * <p>
 * The following features are supported:
 * <ul>
 * <li>{@link urml.feature.VariationPoint#getFeatures <em>Features</em>}</li>
 * <li>{@link urml.feature.VariationPoint#getInstances <em>Instances</em>}</li>
 * <li>{@link urml.feature.VariationPoint#getRules <em>Rules</em>}</li>
 * </ul>
 * </p>
 * 
 * @see urml.feature.FeaturePackage#getVariationPoint()
 * @model
 * @generated
 */
public interface VariationPoint extends AbstractFeature {
	/**
	 * Returns the value of the '<em><b>Features</b></em>' reference list. The list contents are of type
	 * {@link urml.feature.AbstractFeature}. It is bidirectional and its opposite is '
	 * {@link urml.feature.AbstractFeature#getVariationPoints <em>Variation Points</em>}'. <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Features</em>' reference list isn't clear, there really should be more of a
	 * description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * 
	 * @return the value of the '<em>Features</em>' reference list.
	 * @see urml.feature.FeaturePackage#getVariationPoint_Features()
	 * @see urml.feature.AbstractFeature#getVariationPoints
	 * @model opposite="variationPoints" keys="identifier"
	 * @generated
	 */
	EList<AbstractFeature> getFeatures();

	/**
	 * Returns the value of the '<em><b>Instances</b></em>' reference list. The list contents are of type
	 * {@link urml.feature.VariationPointInstance}. It is bidirectional and its opposite is '
	 * {@link urml.feature.VariationPointInstance#getVariationPoint <em>Variation Point</em>}'. <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Instances</em>' reference list isn't clear, there really should be more of a
	 * description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * 
	 * @return the value of the '<em>Instances</em>' reference list.
	 * @see urml.feature.FeaturePackage#getVariationPoint_Instances()
	 * @see urml.feature.VariationPointInstance#getVariationPoint
	 * @model opposite="variationPoint" keys="identifier"
	 * @generated
	 */
	EList<VariationPointInstance> getInstances();

	/**
	 * Returns the value of the '<em><b>Rules</b></em>' containment reference list. The list contents are of type
	 * {@link urml.feature.VariationPointRule}. It is bidirectional and its opposite is '
	 * {@link urml.feature.VariationPointRule#getVariationPoint <em>Variation Point</em>}'. <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Rules</em>' containment reference list isn't clear, there really should be more of a
	 * description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * 
	 * @return the value of the '<em>Rules</em>' containment reference list.
	 * @see urml.feature.FeaturePackage#getVariationPoint_Rules()
	 * @see urml.feature.VariationPointRule#getVariationPoint
	 * @model opposite="variationPoint" containment="true" resolveProxies="true" keys="identifier"
	 * @generated
	 */
	EList<VariationPointRule> getRules();

} // VariationPoint
