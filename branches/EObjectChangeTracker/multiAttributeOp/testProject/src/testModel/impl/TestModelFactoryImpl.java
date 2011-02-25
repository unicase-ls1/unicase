/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package testModel.impl;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.impl.EFactoryImpl;
import org.eclipse.emf.ecore.plugin.EcorePlugin;

import testModel.TestElement;
import testModel.TestModelFactory;
import testModel.TestModelPackage;

/**
 * <!-- begin-user-doc --> An implementation of the model <b>Factory</b>. <!--
 * end-user-doc -->
 * 
 * @generated
 */
public class TestModelFactoryImpl extends EFactoryImpl implements
		TestModelFactory {
	/**
	 * Creates the default factory implementation. <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * 
	 * @generated
	 */
	public static TestModelFactory init() {
		try {
			TestModelFactory theTestModelFactory = (TestModelFactory) EPackage.Registry.INSTANCE
					.getEFactory("http://test.model/");
			if (theTestModelFactory != null) {
				return theTestModelFactory;
			}
		} catch (Exception exception) {
			EcorePlugin.INSTANCE.log(exception);
		}
		return new TestModelFactoryImpl();
	}

	/**
	 * Creates an instance of the factory. <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * 
	 * @generated
	 */
	public TestModelFactoryImpl() {
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
		case TestModelPackage.TEST_ELEMENT:
			return createTestElement();
		default:
			throw new IllegalArgumentException("The class '" + eClass.getName()
					+ "' is not a valid classifier");
		}
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public TestElement createTestElement() {
		TestElementImpl testElement = new TestElementImpl();
		return testElement;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public TestModelPackage getTestModelPackage() {
		return (TestModelPackage) getEPackage();
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @deprecated
	 * @generated
	 */
	@Deprecated
	public static TestModelPackage getPackage() {
		return TestModelPackage.eINSTANCE;
	}

} // TestModelFactoryImpl
