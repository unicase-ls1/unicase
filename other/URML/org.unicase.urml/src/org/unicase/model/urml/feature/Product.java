/**
 * <copyright> </copyright> $Id$
 */
package org.unicase.model.urml.feature;

import org.eclipse.emf.common.util.EList;
import org.unicase.model.urml.UrmlModelElement;

/**
 * <!-- begin-user-doc --> A representation of the model object '<em><b>Product</b></em>'. <!-- end-user-doc -->
 * <p>
 * The following features are supported:
 * <ul>
 * <li>{@link org.unicase.model.urml.feature.Product#getVariationPointInstances <em>Variation Point Instances</em>}</li>
 * <li>{@link org.unicase.model.urml.feature.Product#getFeatures <em>Features</em>}</li>
 * </ul>
 * </p>
 * 
 * @see org.unicase.model.urml.feature.FeaturePackage#getProduct()
 * @model
 * @generated
 */
public interface Product extends UrmlModelElement {
	/**
	 * Returns the value of the '<em><b>Variation Point Instances</b></em>' reference list. The list contents are of
	 * type {@link org.unicase.model.urml.feature.VariationPointInstance}. It is bidirectional and its opposite is '
	 * {@link org.unicase.model.urml.feature.VariationPointInstance#getProducts <em>Products</em>}'. <!-- begin-user-doc
	 * -->
	 * <p>
	 * If the meaning of the '<em>Variation Point Instances</em>' reference list isn't clear, there really should be
	 * more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * 
	 * @return the value of the '<em>Variation Point Instances</em>' reference list.
	 * @see org.unicase.model.urml.feature.FeaturePackage#getProduct_VariationPointInstances()
	 * @see org.unicase.model.urml.feature.VariationPointInstance#getProducts
	 * @model opposite="products"
	 * @generated
	 */
	EList<VariationPointInstance> getVariationPointInstances();

	/**
	 * Returns the value of the '<em><b>Features</b></em>' reference list. The list contents are of type
	 * {@link org.unicase.model.urml.feature.Feature}. It is bidirectional and its opposite is '
	 * {@link org.unicase.model.urml.feature.Feature#getProducts <em>Products</em>}'. <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Features</em>' reference isn't clear, there really should be more of a description
	 * here...
	 * </p>
	 * <!-- end-user-doc -->
	 * 
	 * @return the value of the '<em>Features</em>' reference list.
	 * @see org.unicase.model.urml.feature.FeaturePackage#getProduct_Features()
	 * @see org.unicase.model.urml.feature.Feature#getProducts
	 * @model opposite="products"
	 * @generated
	 */
	EList<Feature> getFeatures();

} // Product
