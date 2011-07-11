/**
 * <copyright> </copyright> $Id$
 */
package org.unicase.model.urml.feature;

import org.eclipse.emf.common.util.EList;
import org.unicase.model.urml.UrmlModelElement;

/**
 * <!-- begin-user-doc --> A representation of the model object '<em><b>Variation Point Instance</b></em>'. <!--
 * end-user-doc -->
 * <p>
 * The following features are supported:
 * <ul>
 * <li>{@link org.unicase.model.urml.feature.VariationPointInstance#getVariationPoint <em>Variation Point</em>}</li>
 * <li>{@link org.unicase.model.urml.feature.VariationPointInstance#getProducts <em>Products</em>}</li>
 * <li>{@link org.unicase.model.urml.feature.VariationPointInstance#getSelectedFeatures <em>Selected Features</em>}</li>
 * </ul>
 * </p>
 * 
 * @see org.unicase.model.urml.feature.FeaturePackage#getVariationPointInstance()
 * @model
 * @generated
 */
public interface VariationPointInstance extends UrmlModelElement {
	/**
	 * Returns the value of the '<em><b>Variation Point</b></em>' reference. It is bidirectional and its opposite is '
	 * {@link org.unicase.model.urml.feature.VariationPoint#getInstances <em>Instances</em>}'. <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Variation Point</em>' reference isn't clear, there really should be more of a
	 * description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * 
	 * @return the value of the '<em>Variation Point</em>' reference.
	 * @see #setVariationPoint(VariationPoint)
	 * @see org.unicase.model.urml.feature.FeaturePackage#getVariationPointInstance_VariationPoint()
	 * @see org.unicase.model.urml.feature.VariationPoint#getInstances
	 * @model opposite="instances"
	 * @generated
	 */
	VariationPoint getVariationPoint();

	/**
	 * Sets the value of the '{@link org.unicase.model.urml.feature.VariationPointInstance#getVariationPoint
	 * <em>Variation Point</em>}' reference. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @param value the new value of the '<em>Variation Point</em>' reference.
	 * @see #getVariationPoint()
	 * @generated
	 */
	void setVariationPoint(VariationPoint value);

	/**
	 * Returns the value of the '<em><b>Products</b></em>' reference list. The list contents are of type
	 * {@link org.unicase.model.urml.feature.Product}. It is bidirectional and its opposite is '
	 * {@link org.unicase.model.urml.feature.Product#getVariationPointInstances <em>Variation Point Instances</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Products</em>' reference list isn't clear, there really should be more of a
	 * description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * 
	 * @return the value of the '<em>Products</em>' reference list.
	 * @see org.unicase.model.urml.feature.FeaturePackage#getVariationPointInstance_Products()
	 * @see org.unicase.model.urml.feature.Product#getVariationPointInstances
	 * @model opposite="variationPointInstances"
	 * @generated
	 */
	EList<Product> getProducts();

	/**
	 * Returns the value of the '<em><b>Selected Features</b></em>' reference list. The list contents are of type
	 * {@link org.unicase.model.urml.feature.AbstractFeature}. It is bidirectional and its opposite is '
	 * {@link org.unicase.model.urml.feature.AbstractFeature#getVariationPointInstances
	 * <em>Variation Point Instances</em>}'. <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Selected Features</em>' reference list isn't clear, there really should be more of a
	 * description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * 
	 * @return the value of the '<em>Selected Features</em>' reference list.
	 * @see org.unicase.model.urml.feature.FeaturePackage#getVariationPointInstance_SelectedFeatures()
	 * @see org.unicase.model.urml.feature.AbstractFeature#getVariationPointInstances
	 * @model opposite="variationPointInstances"
	 * @generated
	 */
	EList<AbstractFeature> getSelectedFeatures();

} // VariationPointInstance
