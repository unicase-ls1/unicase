/**
 * 
 */
package org.unicase.analyzer.exporter;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

/**
 * @author liya
 *
 */
public class CSVExporter implements Exporter {

	private static String COLUMN_SEPERATOR = ",";

	private boolean OVERWRITE;

	private File targetFile;

	private FileWriter fileWriter;

	/**
	 * This constructor sets the targetFile, in which the data shall be saved.
	 * The OVERWRITE flag is set to false by default.
	 * 
	 * @param targetFile
	 *            the target file
	 * @throws IOException 
	 */
	public CSVExporter(File targetFile) throws IOException {
		this(targetFile, false);
	}

	/**
	 * This constructor sets the targetFile, in which the data shall be saved.
	 * 
	 * @param targetFile
	 *            the target file
	 * @param isOverwrite
	 *            if true, existing files will be overwritten, otherwise it will
	 *            be appended.
	 * @throws IOException 
	 */
	public CSVExporter(File targetFile, boolean isOverwrite) throws IOException {
		this.targetFile = targetFile;
		this.OVERWRITE = isOverwrite;
		
		if(isOverwrite) {
			initFileWriter(true);
			closeFileWriter();
		}
	}
	
	private void initFileWriter() throws IOException {
		initFileWriter(OVERWRITE);
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
	
	/* (non-Javadoc)
	 * @see org.unicase.analyzer.exporter.Exporter#export(java.util.List)
	 */
	@Override
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

	/* (non-Javadoc)
	 * @see org.unicase.analyzer.exporter.Exporter#writeLine(java.util.List)
	 */
	@Override
	public void writeLine(List<Object> columns) throws IOException {
		initFileWriter(false);
		for (Object column : columns) {
			fileWriter.write(getColumnValue(column) + COLUMN_SEPERATOR);
		}
		fileWriter.write(System.getProperty("line.separator"));
		closeFileWriter();

	}

}
