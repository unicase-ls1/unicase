/**
 * <copyright> </copyright> $Id$
 */
package org.unicase.model.urml.feature;

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc --> A representation of the model object '<em><b>Feature</b></em>'. <!-- end-user-doc -->
 * <p>
 * The following features are supported:
 * <ul>
 * <li>{@link org.unicase.model.urml.feature.Feature#getProducts <em>Products</em>}</li>
 * </ul>
 * </p>
 * 
 * @see org.unicase.model.urml.feature.FeaturePackage#getFeature()
 * @model
 * @generated
 */
public interface Feature extends AbstractFeature {

	/**
	 * Returns the value of the '<em><b>Products</b></em>' reference list. The list contents are of type
	 * {@link org.unicase.model.urml.feature.Product}. It is bidirectional and its opposite is '
	 * {@link org.unicase.model.urml.feature.Product#getFeatures <em>Features</em>}'. <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Products</em>' reference isn't clear, there really should be more of a description
	 * here...
	 * </p>
	 * <!-- end-user-doc -->
	 * 
	 * @return the value of the '<em>Products</em>' reference list.
	 * @see org.unicase.model.urml.feature.FeaturePackage#getFeature_Products()
	 * @see org.unicase.model.urml.feature.Product#getFeatures
	 * @model opposite="features"
	 * @generated
	 */
	EList<Product> getProducts();
} // Feature
