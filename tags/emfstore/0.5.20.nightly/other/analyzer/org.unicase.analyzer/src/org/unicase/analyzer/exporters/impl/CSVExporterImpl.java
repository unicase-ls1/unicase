/**
 * <copyright> Copyright (c) 2008-2009 Jonas Helming, Maximilian Koegel. All rights reserved. This program and the
 * accompanying materials are made available under the terms of the Eclipse Public License v1.0 which accompanies this
 * distribution, and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>
 */
package org.unicase.analyzer.exporters.impl;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

import org.eclipse.emf.ecore.EClass;
import org.unicase.analyzer.exporters.CSVExporter;
import org.unicase.analyzer.exporters.ExportersPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>CSV Exporter</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * </p>
 *
 * @generated
 */
public class CSVExporterImpl extends ExporterImpl implements CSVExporter {
	
	private static final String COLUMN_SEPERATOR = ",";

	private File targetFile;

	private FileWriter fileWriter;
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected CSVExporterImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return ExportersPackage.Literals.CSV_EXPORTER;
	}
	
	/** 
	 * {@inheritDoc}
	 * @see org.unicase.analyzer.exporters.CSVExporter#init()
	 */
	public void init() throws IOException {
		targetFile = new File(getFileName());
		if (isOverwrite()) {
			initFileWriter(true);
			closeFileWriter();
		}
		
	}
	
	/** 
	 * {@inheritDoc}
	 * @see org.unicase.analyzer.exporters.CSVExporter#init(java.lang.String)
	 */
	public void init(String fileName) throws IOException{
		init(fileName, false);
	}
	/** 
	 * {@inheritDoc}
	 * @see org.unicase.analyzer.exporters.CSVExporter#init(java.lang.String, boolean)
	 */
	public void init(String fileName, boolean overwrite) throws IOException{
		setFileName(fileName);
		targetFile = new File(fileName);
		setOverwrite(overwrite);

		if (overwrite) {
			initFileWriter(true);
			closeFileWriter();
		}
	}

	public void export(List<List<Object>> lines) throws IOException {
		initFileWriter();
		for (List<Object> columns : lines) {
			for (Object column : columns) {
				fileWriter.write(getColumnValue(column) + COLUMN_SEPERATOR);
			}
			fileWriter.write(System.getProperty("line.separator"));
		}
		closeFileWriter();		
	}

	public void writeLine(List<Object> columns) throws IOException {
		initFileWriter(false);
		for (Object column : columns) {
			fileWriter.write(getColumnValue(column) + COLUMN_SEPERATOR);
		}
		fileWriter.write(System.getProperty("line.separator"));
		closeFileWriter();		
	}

	private void initFileWriter() throws IOException {
		initFileWriter(isOverwrite());
	}

	private void initFileWriter(boolean overwrite) throws IOException {
		if (!targetFile.exists()) {
			targetFile.createNewFile();
		}
		fileWriter = new FileWriter(targetFile, !overwrite);
	}

	private void closeFileWriter() throws IOException {
		fileWriter.close();
	}

	private String getColumnValue(Object column) {
		return column.toString();
	}


} //CSVExporterImpl
