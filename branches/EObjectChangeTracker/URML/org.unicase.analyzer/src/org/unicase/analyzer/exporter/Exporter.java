/**
 * 
 */
package org.unicase.analyzer.exporter;

import java.io.IOException;
import java.util.List;

/**
 * @author liya
 *
 */
public interface Exporter {
	
	/**
	 *  Write 2 dimensional object data into the targetFile, first column by column,
	 *  then line by line
	 * @param lines 2 dimensional object data, each line including columns, 
	 * i.e. inner list are columns, outer list are lines
	 * @throws IOException
	 * 
	 */
	void export(List<List<Object>> lines) throws IOException;
	
	/**
	 * Write a line of object data into targetFile, column by column
	 * 
	 * @param columns columns of a line
	 * @throws IOException
	 */
	void writeLine(List<Object> columns) throws IOException;
	
}
