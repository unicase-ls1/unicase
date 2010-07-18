/**
 * <copyright> </copyright> $Id$
 */
package urml.feature.impl;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.impl.EFactoryImpl;
import org.eclipse.emf.ecore.plugin.EcorePlugin;

import urml.feature.Feature;
import urml.feature.FeatureFactory;
import urml.feature.FeaturePackage;
import urml.feature.ManyOutManyRule;
import urml.feature.OneOutManyRule;
import urml.feature.Product;
import urml.feature.VariationPoint;
import urml.feature.VariationPointInstance;

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
		case FeaturePackage.ONE_OUT_MANY_RULE:
			return createOneOutManyRule();
		case FeaturePackage.MANY_OUT_MANY_RULE:
			return createManyOutManyRule();
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
	public OneOutManyRule createOneOutManyRule() {
		OneOutManyRuleImpl oneOutManyRule = new OneOutManyRuleImpl();
		return oneOutManyRule;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public ManyOutManyRule createManyOutManyRule() {
		ManyOutManyRuleImpl manyOutManyRule = new ManyOutManyRuleImpl();
		return manyOutManyRule;
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
