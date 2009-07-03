/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.unicase.analyzer.exporters;

import org.eclipse.emf.ecore.EFactory;

/**
 * <!-- begin-user-doc -->
 * The <b>Factory</b> for the model.
 * It provides a create method for each non-abstract class of the model.
 * <!-- end-user-doc -->
 * @see org.unicase.analyzer.exporters.ExportersPackage
 * @generated
 */
public interface ExportersFactory extends EFactory {
	/**
	 * The singleton instance of the factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	ExportersFactory eINSTANCE = org.unicase.analyzer.exporters.impl.ExportersFactoryImpl.init();

	/**
	 * Returns a new object of class '<em>Exporter</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Exporter</em>'.
	 * @generated
	 */
	Exporter createExporter();

	/**
	 * Returns the package supported by this factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the package supported by this factory.
	 * @generated
	 */
	ExportersPackage getExportersPackage();

} //ExportersFactory
