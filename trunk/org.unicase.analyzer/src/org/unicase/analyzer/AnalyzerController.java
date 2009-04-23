/**
 * 
 */
package org.unicase.analyzer;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import org.unicase.analyzer.dataanalyzer.DataAnalyzer;
import org.unicase.analyzer.dataanalyzer.ModelElementAnalyser;

/**
 * @author liya
 *
 */
public class AnalyzerController {

	private ArrayList<DataAnalyzer> analyzers;
	
	private VersionIterator projectIterator;

	/**
	 * The Controller adds the proper analyzers and starts the
	 * analysis. The result is then written to the specified file.
	 * 
	 * @param projectIterator The iterator to be used.
	 * @param targetFile The file to be written to.
	 */
	public AnalyzerController(
			VersionIterator projectIterator, File targetFile) {
		this.projectIterator = projectIterator;
		analyzers = new ArrayList<DataAnalyzer>();
		initAnalysers(projectIterator);
		try {
			CSVExporter export = new CSVExporter(targetFile,true);
			runAnalysis(export);
		} catch (IOException e) {
		}
		System.out.println("Finished Analysis");
	}

	/**
	 * Adds the analyzers to be run.
	 * 
	 * @param projectIterator The Iterator being used.
	 */
	private void initAnalysers(VersionIterator projectIterator) {
		analyzers.add(new ModelElementAnalyser()); 

	}

	/**
	 * Runs the actual analysis and adds the lines to the result.
	 * @param export 
	 * @throws IOException 
	 */
	private void runAnalysis(CSVExporter export) throws IOException {
		writeHeader(export);
		ArrayList<Object> line = new ArrayList<Object>();
		while(projectIterator.hasNext()) {
			ProjectAnalysisData data = projectIterator.next();
			line.clear();
			line.add(data.getPrimaryVersionSpec().getIdentifier());
			for(DataAnalyzer analyser : analyzers) {
				for(Object obj : analyser.getValue(data)) {
					line.add(obj);
				}
			}
			export.writeLine(line);
		}
	}

	/**
	 * Add a line containing the names of the analyzers as the first
	 * line of the .csv file.
	 * @param export 
	 * @throws IOException 
	 */
	private void writeHeader(CSVExporter export) throws IOException {
		ArrayList<Object> line = new ArrayList<Object>();
		line.add("Version");
		for(DataAnalyzer analyser : analyzers) {
			for(String name : analyser.getName()) {
				line.add(name);				
			}
		}
		export.writeLine(line);
	}
}
