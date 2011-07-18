/**
 * <copyright> </copyright> $Id$
 */
package org.unicase.model.urml;

import org.eclipse.emf.ecore.EFactory;

/**
 * <!-- begin-user-doc --> The <b>Factory</b> for the model. It provides a create method for each non-abstract class of
 * the model. <!-- end-user-doc -->
 * 
 * @see org.unicase.model.urml.UrmlPackage
 * @generated
 */
public interface UrmlFactory extends EFactory {
	/**
	 * The singleton instance of the factory. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	UrmlFactory eINSTANCE = org.unicase.model.urml.impl.UrmlFactoryImpl.init();

	/**
	 * Returns a new object of class '<em>Stakeholder</em>'. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @return a new object of class '<em>Stakeholder</em>'.
	 * @generated
	 */
	Stakeholder createStakeholder();

	/**
	 * Returns a new object of class '<em>URML Diagram</em>'. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @return a new object of class '<em>URML Diagram</em>'.
	 * @generated
	 */
	URMLDiagram createURMLDiagram();

	/**
	 * Returns the package supported by this factory. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @return the package supported by this factory.
	 * @generated
	 */
	UrmlPackage getUrmlPackage();

} // UrmlFactory
