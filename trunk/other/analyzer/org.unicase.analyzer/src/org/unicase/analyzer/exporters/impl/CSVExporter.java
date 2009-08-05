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

/**
 * @author liya
 */
public class CSVExporter extends ExporterImpl {

	private static final String COLUMN_SEPERATOR = ",";

	private File targetFile;

	private FileWriter fileWriter;

	/**
	 * This constructor sets the targetFile, in which the data shall be saved. The overwrite is set to false by default.
	 * 
	 * @param fileName the name of target file
	 * @throws IOException @see {@link IOException}
	 */
	public CSVExporter(String fileName) throws IOException {
		this(fileName, false);
	}

	/**
	 * This constructor sets the targetFile, in which the data shall be saved.
	 * 
	 * @param fileName the name of target file
	 * @param overwrite if true, existing files will be overwritten, otherwise it will be appended.
	 * @throws IOException @see {@link IOException}
	 */
	public CSVExporter(String fileName, boolean overwrite) throws IOException {
		super();
		setFileName(fileName);
		targetFile = new File(fileName);
		setOverwrite(overwrite);

		if (overwrite) {
			initFileWriter(true);
			closeFileWriter();
		}
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

	/**
	 * @see org.unicase.analyzer.exporters.Exporter#export(java.util.List)
	 * @param lines 2D List
	 * @throws IOException @see {@link IOException}
	 */
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

	/**
	 * @see org.unicase.analyzer.exporters.Exporter#writeLine(java.util.List)
	 * @param columns columns
	 * @throws IOException @see {@link IOException}
	 */
	public void writeLine(List<Object> columns) throws IOException {
		initFileWriter(false);
		for (Object column : columns) {
			fileWriter.write(getColumnValue(column) + COLUMN_SEPERATOR);
		}
		fileWriter.write(System.getProperty("line.separator"));
		closeFileWriter();

	}

}
