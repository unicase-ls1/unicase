/**
 * <copyright> Copyright (c) 2008-2009 Jonas Helming, Maximilian Koegel. All rights reserved. This program and the
 * accompanying materials are made available under the terms of the Eclipse Public License v1.0 which accompanies this
 * distribution, and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>
 */
package org.unicase.analyzer.exporters;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EPackage;

/**
 * <!-- begin-user-doc --> The <b>Package</b> for the model. It contains accessors for the meta objects to represent
 * <ul>
 * <li>each class,</li>
 * <li>each feature of each class,</li>
 * <li>each enum,</li>
 * <li>and each data type</li>
 * </ul>
 * <!-- end-user-doc -->
 * @see org.unicase.analyzer.exporters.ExportersFactory
 * @model kind="package"
 * @generated
 */
public interface ExportersPackage extends EPackage {
	/**
	 * The package name.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	String eNAME = "exporters";

	/**
	 * The package namespace URI.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_URI = "http://unicase.org/analyzer/exporters";

	/**
	 * The package namespace name.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_PREFIX = "org.unicase.analyzer.exporters";

	/**
	 * The singleton instance of the package.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	ExportersPackage eINSTANCE = org.unicase.analyzer.exporters.impl.ExportersPackageImpl.init();

	/**
	 * The meta object id for the '{@link org.unicase.analyzer.exporters.impl.ExporterImpl <em>Exporter</em>}' class.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @see org.unicase.analyzer.exporters.impl.ExporterImpl
	 * @see org.unicase.analyzer.exporters.impl.ExportersPackageImpl#getExporter()
	 * @generated
	 */
	int EXPORTER = 0;

	/**
	 * The feature id for the '<em><b>File Name</b></em>' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EXPORTER__FILE_NAME = 0;

	/**
	 * The feature id for the '<em><b>Overwrite</b></em>' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EXPORTER__OVERWRITE = 1;

	/**
	 * The number of structural features of the '<em>Exporter</em>' class.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EXPORTER_FEATURE_COUNT = 2;

	/**
	 * The meta object id for the '{@link org.unicase.analyzer.exporters.impl.CSVExporterImpl <em>CSV Exporter</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.unicase.analyzer.exporters.impl.CSVExporterImpl
	 * @see org.unicase.analyzer.exporters.impl.ExportersPackageImpl#getCSVExporter()
	 * @generated
	 */
	int CSV_EXPORTER = 1;

	/**
	 * The feature id for the '<em><b>File Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CSV_EXPORTER__FILE_NAME = EXPORTER__FILE_NAME;

	/**
	 * The feature id for the '<em><b>Overwrite</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CSV_EXPORTER__OVERWRITE = EXPORTER__OVERWRITE;

	/**
	 * The number of structural features of the '<em>CSV Exporter</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CSV_EXPORTER_FEATURE_COUNT = EXPORTER_FEATURE_COUNT + 0;

	/**
	 * Returns the meta object for class '{@link org.unicase.analyzer.exporters.Exporter <em>Exporter</em>}'. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @return the meta object for class '<em>Exporter</em>'.
	 * @see org.unicase.analyzer.exporters.Exporter
	 * @generated
	 */
	EClass getExporter();

	/**
	 * Returns the meta object for the attribute '{@link org.unicase.analyzer.exporters.Exporter#getFileName <em>File Name</em>}'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>File Name</em>'.
	 * @see org.unicase.analyzer.exporters.Exporter#getFileName()
	 * @see #getExporter()
	 * @generated
	 */
	EAttribute getExporter_FileName();

	/**
	 * Returns the meta object for the attribute '{@link org.unicase.analyzer.exporters.Exporter#isOverwrite <em>Overwrite</em>}'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Overwrite</em>'.
	 * @see org.unicase.analyzer.exporters.Exporter#isOverwrite()
	 * @see #getExporter()
	 * @generated
	 */
	EAttribute getExporter_Overwrite();

	/**
	 * Returns the meta object for class '{@link org.unicase.analyzer.exporters.CSVExporter <em>CSV Exporter</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>CSV Exporter</em>'.
	 * @see org.unicase.analyzer.exporters.CSVExporter
	 * @generated
	 */
	EClass getCSVExporter();

	/**
	 * Returns the factory that creates the instances of the model.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @return the factory that creates the instances of the model.
	 * @generated
	 */
	ExportersFactory getExportersFactory();

	/**
	 * <!-- begin-user-doc --> Defines literals for the meta objects that represent
	 * <ul>
	 * <li>each class,</li>
	 * <li>each feature of each class,</li>
	 * <li>each enum,</li>
	 * <li>and each data type</li>
	 * </ul>
	 * <!-- end-user-doc -->
	 * @generated
	 */
	interface Literals {
		/**
		 * The meta object literal for the '{@link org.unicase.analyzer.exporters.impl.ExporterImpl <em>Exporter</em>}' class.
		 * <!-- begin-user-doc --> <!-- end-user-doc -->
		 * @see org.unicase.analyzer.exporters.impl.ExporterImpl
		 * @see org.unicase.analyzer.exporters.impl.ExportersPackageImpl#getExporter()
		 * @generated
		 */
		EClass EXPORTER = eINSTANCE.getExporter();

		/**
		 * The meta object literal for the '<em><b>File Name</b></em>' attribute feature.
		 * <!-- begin-user-doc --> <!--
		 * end-user-doc -->
		 * @generated
		 */
		EAttribute EXPORTER__FILE_NAME = eINSTANCE.getExporter_FileName();

		/**
		 * The meta object literal for the '<em><b>Overwrite</b></em>' attribute feature.
		 * <!-- begin-user-doc --> <!--
		 * end-user-doc -->
		 * @generated
		 */
		EAttribute EXPORTER__OVERWRITE = eINSTANCE.getExporter_Overwrite();

		/**
		 * The meta object literal for the '{@link org.unicase.analyzer.exporters.impl.CSVExporterImpl <em>CSV Exporter</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.unicase.analyzer.exporters.impl.CSVExporterImpl
		 * @see org.unicase.analyzer.exporters.impl.ExportersPackageImpl#getCSVExporter()
		 * @generated
		 */
		EClass CSV_EXPORTER = eINSTANCE.getCSVExporter();

	}

} // ExportersPackage
