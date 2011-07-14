/**
 * <copyright> </copyright> $Id$
 */
package org.unicase.model.urml.feature;

import org.eclipse.emf.ecore.EFactory;

/**
 * <!-- begin-user-doc --> The <b>Factory</b> for the model. It provides a create method for each non-abstract class of
 * the model. <!-- end-user-doc -->
 * 
 * @see org.unicase.model.urml.feature.FeaturePackage
 * @generated
 */
public interface FeatureFactory extends EFactory {
	/**
	 * The singleton instance of the factory. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	FeatureFactory eINSTANCE = org.unicase.model.urml.feature.impl.FeatureFactoryImpl.init();

	/**
	 * Returns a new object of class '<em>Feature</em>'. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @return a new object of class '<em>Feature</em>'.
	 * @generated
	 */
	Feature createFeature();

	/**
	 * Returns a new object of class '<em>Variation Point</em>'. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @return a new object of class '<em>Variation Point</em>'.
	 * @generated
	 */
	VariationPoint createVariationPoint();

	/**
	 * Returns a new object of class '<em>Variation Point Instance</em>'. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @return a new object of class '<em>Variation Point Instance</em>'.
	 * @generated
	 */
	VariationPointInstance createVariationPointInstance();

	/**
	 * Returns a new object of class '<em>Product</em>'. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @return a new object of class '<em>Product</em>'.
	 * @generated
	 */
	Product createProduct();

	/**
	 * Returns the package supported by this factory. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @return the package supported by this factory.
	 * @generated
	 */
	FeaturePackage getFeaturePackage();

} // FeatureFactory
