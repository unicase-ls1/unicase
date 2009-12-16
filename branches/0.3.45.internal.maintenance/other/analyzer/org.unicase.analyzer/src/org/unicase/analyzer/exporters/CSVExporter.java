/**
 * <copyright> Copyright (c) 2008-2009 Jonas Helming, Maximilian Koegel. All rights reserved. This program and the
 * accompanying materials are made available under the terms of the Eclipse Public License v1.0 which accompanies this
 * distribution, and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>
 */
package org.unicase.analyzer.exporters;

import java.io.IOException;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>CSV Exporter</b></em>'.
 * <!-- end-user-doc -->
 *
 *
 * @see org.unicase.analyzer.exporters.ExportersPackage#getCSVExporter()
 * @model
 * @generated
 */
public interface CSVExporter extends Exporter {
	
	/**
	 * Initialize the CSVExporter.
	 * Call before any other methods.
	 * 
	 * @param fileName the name of target file
	 * @throws IOException @see {@link IOException}
	 */
	public void init() throws IOException;
	
	/**
	 * Initialize the CSVExporter, set the targetFile, in which the data shall be saved. The overwrite is set to false by default.
	 * Call before any other methods.
	 * 
	 * @param fileName the name of target file
	 * @throws IOException @see {@link IOException}
	 */
	public void init(String fileName) throws IOException;
	
	/**
	 * Initialize the CSVExporter, set the targetFile, in which the data shall be saved.
	 * Call before any other methods.
	 * 
	 * @param fileName the name of target file
	 * @param overwrite if true, existing files will be overwritten, otherwise it will be appended.
	 * @throws IOException @see {@link IOException}
	 */
	public void init(String fileName, boolean overwrite) throws IOException;
	
	
} // CSVExporter
