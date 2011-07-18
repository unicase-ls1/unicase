/**
 * <copyright> </copyright> $Id$
 */
package org.unicase.model.urml.feature.impl;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.impl.EFactoryImpl;
import org.eclipse.emf.ecore.plugin.EcorePlugin;
import org.unicase.model.urml.feature.Feature;
import org.unicase.model.urml.feature.FeatureFactory;
import org.unicase.model.urml.feature.FeaturePackage;
import org.unicase.model.urml.feature.Product;
import org.unicase.model.urml.feature.VariationPoint;
import org.unicase.model.urml.feature.VariationPointInstance;

/**
 * <!-- begin-user-doc --> An implementation of the model <b>Factory</b>. <!-- end-user-doc -->
 * 
 * @generated
 */
public class FeatureFactoryImpl extends EFactoryImpl implements FeatureFactory {
	/**
	 * Creates the default factory implementation. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public static FeatureFactory init() {
		try {
			FeatureFactory theFeatureFactory = (FeatureFactory) EPackage.Registry.INSTANCE
				.getEFactory("http://unicase.org/model/urml/feature");
			if (theFeatureFactory != null) {
				return theFeatureFactory;
			}
		} catch (Exception exception) {
			EcorePlugin.INSTANCE.log(exception);
		}
		return new FeatureFactoryImpl();
	}

	/**
	 * Creates an instance of the factory. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public FeatureFactoryImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public EObject create(EClass eClass) {
		switch (eClass.getClassifierID()) {
		case FeaturePackage.FEATURE:
			return createFeature();
		case FeaturePackage.VARIATION_POINT:
			return createVariationPoint();
		case FeaturePackage.VARIATION_POINT_INSTANCE:
			return createVariationPointInstance();
		case FeaturePackage.PRODUCT:
			return createProduct();
		default:
			throw new IllegalArgumentException("The class '" + eClass.getName() + "' is not a valid classifier");
		}
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public Feature createFeature() {
		FeatureImpl feature = new FeatureImpl();
		return feature;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public VariationPoint createVariationPoint() {
		VariationPointImpl variationPoint = new VariationPointImpl();
		return variationPoint;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public VariationPointInstance createVariationPointInstance() {
		VariationPointInstanceImpl variationPointInstance = new VariationPointInstanceImpl();
		return variationPointInstance;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public Product createProduct() {
		ProductImpl product = new ProductImpl();
		return product;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public FeaturePackage getFeaturePackage() {
		return (FeaturePackage) getEPackage();
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @deprecated
	 * @generated
	 */
	@Deprecated
	public static FeaturePackage getPackage() {
		return FeaturePackage.eINSTANCE;
	}

} // FeatureFactoryImpl
