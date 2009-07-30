/**
 * <copyright> Copyright (c) 2008 Jonas Helming, Maximilian Koegel. All rights reserved. This program and the
 * accompanying materials are made available under the terms of the Eclipse Public License v1.0 which accompanies this
 * distribution, and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>
 */
package org.unicase.analyzer.exporter;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

/**
 * @author liya
 */
public class CSVExporter implements Exporter {

	private static final String COLUMN_SEPERATOR = ",";

	private boolean isOVERWRITE;

	private File targetFile;

	private FileWriter fileWriter;

	/**
	 * This constructor sets the targetFile, in which the data shall be saved. The OVERWRITE flag is set to false by
	 * default.
	 * 
	 * @param targetFile the target file
	 * @throws IOException @see {@link IOException}
	 */
	public CSVExporter(File targetFile) throws IOException {
		this(targetFile, false);
	}

	/**
	 * This constructor sets the targetFile, in which the data shall be saved.
	 * 
	 * @param targetFile the target file
	 * @param isOverwrite if true, existing files will be overwritten, otherwise it will be appended.
	 * @throws IOException @see {@link IOException}
	 */
	public CSVExporter(File targetFile, boolean isOverwrite) throws IOException {
		this.targetFile = targetFile;
		this.isOVERWRITE = isOverwrite;

		if (isOverwrite) {
			initFileWriter(true);
			closeFileWriter();
		}
	}

	private void initFileWriter() throws IOException {
		initFileWriter(isOVERWRITE);
	}

	private void initFileWriter(boolean isOverwrite) throws IOException {
		if (!targetFile.exists()) {
			targetFile.createNewFile();
		}
		fileWriter = new FileWriter(targetFile, !isOverwrite);
	}

	private void closeFileWriter() throws IOException {
		fileWriter.close();
	}

	private String getColumnValue(Object column) {
		return column.toString();
	}

	/**
	 * @see org.unicase.analyzer.exporter.Exporter#export(java.util.List)
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
	 * @see org.unicase.analyzer.exporter.Exporter#writeLine(java.util.List)
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
