/**
 * <copyright> Copyright (c) 2008-2009 Jonas Helming, Maximilian Koegel. All rights reserved. This program and the
 * accompanying materials are made available under the terms of the Eclipse Public License v1.0 which accompanies this
 * distribution, and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>
 */
package org.unicase.analyzer;

import java.util.List;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc --> A representation of the model object '<em><b>Data Analyzer</b></em>'. <!-- end-user-doc -->
 * 
 * @see org.unicase.analyzer.AnalyzerPackage#getDataAnalyzer()
 * @model interface="true" abstract="true"
 * @generated
 */
public interface DataAnalyzer extends EObject {
	/**
	 * Returns the specified values of the given ProjectAnalysisData.
	 * 
	 * @param data ProjectAnalysisData
	 * @return values per column
	 */
	List<Object> getValue(ProjectAnalysisData data);

	/**
	 * Returns the names of the columns.
	 * 
	 * @return the names of the columns
	 */
	List<String> getName();

	/**
	 * @return true if just export once
	 */
	boolean isExportOnce();
} // DataAnalyzer
