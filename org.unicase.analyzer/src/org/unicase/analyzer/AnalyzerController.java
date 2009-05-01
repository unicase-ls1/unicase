/**
 * 
 */
package org.unicase.analyzer;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.unicase.analyzer.dataanalyzer.DataAnalyzer;
import org.unicase.analyzer.dataanalyzer.ModelElementAnalyzer;
import org.unicase.analyzer.exporter.CSVExporter;
import org.unicase.analyzer.exporter.Exporter;

/**
 * @author liya
 *
 */
public class AnalyzerController {

	private ArrayList<DataAnalyzer> analyzers;
	
	private VersionIterator projectIterator;
	
	private Exporter exporter;

	/**
	 * The Controller adds the proper analyzers and starts the
	 * analysis. The result is then written to the specified file.
	 * 
	 * @param projectIterator The iterator to be used.
	 * @param targetFile The file to be written to.
	 */
	public AnalyzerController(
			VersionIterator projectIterator, ArrayList<DataAnalyzer> analyzers,
			Exporter exporter) {
		this.projectIterator = projectIterator;
		this.analyzers = analyzers;
		this.exporter = exporter;
		try {
			runAnalysis(exporter);
		} catch (IOException e) {
		}
		System.out.println("Finished Analysis");
	}

	/**
	 * Runs the actual analysis and adds the lines to the result.
	 * @param export 
	 * @throws IOException 
	 */
	private void runAnalysis(Exporter export) throws IOException {
		writeHeader(export);
		ArrayList<Object> line = new ArrayList<Object>();
		while(projectIterator.hasNext()) {
			ProjectAnalysisData data = projectIterator.next();
			line.clear();
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
	private void writeHeader(Exporter export) throws IOException {
		ArrayList<Object> line = new ArrayList<Object>();
		for(DataAnalyzer analyser : analyzers) {
			for(String name : analyser.getName()) {
				line.add(name);				
			}
		}
		export.writeLine(line);
	}
}
