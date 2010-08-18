/**
 * <copyright> </copyright> $Id$
 */
package org.unicase.model.urml.feature;

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc --> A representation of the model object '<em><b>Variation Point</b></em>'. <!-- end-user-doc -->
 * <p>
 * The following features are supported:
 * <ul>
 * <li>{@link org.unicase.model.urml.feature.VariationPoint#getOptionalSubFeatures <em>Optional Sub Features</em>}</li>
 * <li>{@link org.unicase.model.urml.feature.VariationPoint#getMultiplicity <em>Multiplicity</em>}</li>
 * <li>{@link org.unicase.model.urml.feature.VariationPoint#getInstances <em>Instances</em>}</li>
 * </ul>
 * </p>
 * 
 * @see org.unicase.model.urml.feature.FeaturePackage#getVariationPoint()
 * @model
 * @generated
 */
public interface VariationPoint extends AbstractFeature {
	/**
	 * Returns the value of the '<em><b>Optional Sub Features</b></em>' containment reference list. The list contents
	 * are of type {@link org.unicase.model.urml.feature.AbstractFeature}. It is bidirectional and its opposite is '
	 * {@link org.unicase.model.urml.feature.AbstractFeature#getOptionalParentVariationPoint
	 * <em>Optional Parent Variation Point</em>}'. <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Optional Sub Features</em>' containment reference list isn't clear, there really
	 * should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * 
	 * @return the value of the '<em>Optional Sub Features</em>' containment reference list.
	 * @see org.unicase.model.urml.feature.FeaturePackage#getVariationPoint_OptionalSubFeatures()
	 * @see org.unicase.model.urml.feature.AbstractFeature#getOptionalParentVariationPoint
	 * @model opposite="optionalParentVariationPoint" containment="true" resolveProxies="true" keys="identifier"
	 * @generated
	 */
	EList<AbstractFeature> getOptionalSubFeatures();

	/**
	 * Returns the value of the '<em><b>Multiplicity</b></em>' attribute. <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Multiplicity</em>' attribute isn't clear, there really should be more of a description
	 * here...
	 * </p>
	 * <!-- end-user-doc -->
	 * 
	 * @return the value of the '<em>Multiplicity</em>' attribute.
	 * @see #setMultiplicity(int)
	 * @see org.unicase.model.urml.feature.FeaturePackage#getVariationPoint_Multiplicity()
	 * @model
	 * @generated
	 */
	int getMultiplicity();

	/**
	 * Sets the value of the '{@link org.unicase.model.urml.feature.VariationPoint#getMultiplicity
	 * <em>Multiplicity</em>}' attribute. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @param value the new value of the '<em>Multiplicity</em>' attribute.
	 * @see #getMultiplicity()
	 * @generated
	 */
	void setMultiplicity(int value);

	/**
	 * Returns the value of the '<em><b>Instances</b></em>' reference list. The list contents are of type
	 * {@link org.unicase.model.urml.feature.VariationPointInstance}. It is bidirectional and its opposite is '
	 * {@link org.unicase.model.urml.feature.VariationPointInstance#getVariationPoint <em>Variation Point</em>}'. <!--
	 * begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Instances</em>' reference list isn't clear, there really should be more of a
	 * description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * 
	 * @return the value of the '<em>Instances</em>' reference list.
	 * @see org.unicase.model.urml.feature.FeaturePackage#getVariationPoint_Instances()
	 * @see org.unicase.model.urml.feature.VariationPointInstance#getVariationPoint
	 * @model opposite="variationPoint" keys="identifier"
	 * @generated
	 */
	EList<VariationPointInstance> getInstances();

} // VariationPoint
