/**
 * <copyright> Copyright (c) 2008-2009 Jonas Helming, Maximilian Koegel. All rights reserved. This program and the
 * accompanying materials are made available under the terms of the Eclipse Public License v1.0 which accompanies this
 * distribution, and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>
 */
package org.unicase.analyzer.impl;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.impl.EFactoryImpl;
import org.eclipse.emf.ecore.plugin.EcorePlugin;
import org.unicase.analyzer.AnalyzerConfiguration;
import org.unicase.analyzer.AnalyzerFactory;
import org.unicase.analyzer.AnalyzerPackage;
import org.unicase.analyzer.ProjectAnalysisData;

/**
 * <!-- begin-user-doc --> An implementation of the model <b>Factory</b>. <!-- end-user-doc -->
 * 
 * @generated
 */
public class AnalyzerFactoryImpl extends EFactoryImpl implements AnalyzerFactory {
	/**
	 * Creates the default factory implementation. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public static AnalyzerFactory init() {
		try {
			AnalyzerFactory theAnalyzerFactory = (AnalyzerFactory) EPackage.Registry.INSTANCE
				.getEFactory("http://unicase.org/analyzer");
			if (theAnalyzerFactory != null) {
				return theAnalyzerFactory;
			}
		} catch (Exception exception) {
			EcorePlugin.INSTANCE.log(exception);
		}
		return new AnalyzerFactoryImpl();
	}

	/**
	 * Creates an instance of the factory. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public AnalyzerFactoryImpl() {
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
		case AnalyzerPackage.PROJECT_ANALYSIS_DATA:
			return createProjectAnalysisData();
		case AnalyzerPackage.ANALYZER_CONFIGURATION:
			return createAnalyzerConfiguration();
		default:
			throw new IllegalArgumentException("The class '" + eClass.getName() + "' is not a valid classifier");
		}
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public ProjectAnalysisData createProjectAnalysisData() {
		ProjectAnalysisDataImpl projectAnalysisData = new ProjectAnalysisDataImpl();
		return projectAnalysisData;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public AnalyzerConfiguration createAnalyzerConfiguration() {
		AnalyzerConfigurationImpl analyzerConfiguration = new AnalyzerConfigurationImpl();
		return analyzerConfiguration;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public AnalyzerPackage getAnalyzerPackage() {
		return (AnalyzerPackage) getEPackage();
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @deprecated
	 * @generated
	 */
	@Deprecated
	public static AnalyzerPackage getPackage() {
		return AnalyzerPackage.eINSTANCE;
	}

} // AnalyzerFactoryImpl
