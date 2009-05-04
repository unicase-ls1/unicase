/**
 * 
 */
package org.unicase.analyzer;

import java.io.IOException;
import java.util.ArrayList;
import org.unicase.analyzer.dataanalyzer.DataAnalyzer;
import org.unicase.analyzer.dataanalyzer.DetectionAnalyzer;
import org.unicase.analyzer.exporter.Exporter;

/**
 * @author liya
 *
 */
public class AnalyzerController {

	private ArrayList<DataAnalyzer> analyzers;
	
	private VersionIterator projectIterator;
	
	private Exporter exporter;
	
	private boolean exportHere;

	/**
	 * The Controller adds the proper analyzers and iterators, then starts the
	 * analysis. The result is exported to the specified exporter.
	 * 
	 * @param projectIterator The iterator to be used.
	 * @param analyzers The list of dataAnalyzers to be used.
	 * @param exporter The exporter to be used.
	 */
	public AnalyzerController(
			VersionIterator projectIterator, ArrayList<DataAnalyzer> analyzers,
			Exporter exporter) {
		this.projectIterator = projectIterator;
		this.analyzers = analyzers;
		this.exporter = exporter;
		
		//For DetectionAnalyzer, the exporter will be exported from the analyzer itself, 
		//instead of the controller
		for(DataAnalyzer analyzer : analyzers) {
			if(!(analyzer instanceof DetectionAnalyzer)){
				this.exportHere = true;
			}else{
				this.exportHere = false;
			}
		}
			
		try {
			runAnalysis(exporter);
		} catch (IOException e) {
		}
		System.out.println("Finished Analysis");
	}

	/**
	 * Runs the actual analysis and adds the lines to the result.
	 * @param exporter Exporter
	 * @throws IOException 
	 */
	private void runAnalysis(Exporter exporter) throws IOException {
		writeHeader(exporter);
		ArrayList<Object> line = new ArrayList<Object>();
		while(projectIterator.hasNext()) {
			ProjectAnalysisData data = projectIterator.next();
			line.clear();
			for(DataAnalyzer analyzer : analyzers) {
				if(exportHere){
					for(Object obj : analyzer.getValue(data)) {
						line.add(obj);
					}
				}
			}
			if(exportHere){
				exporter.writeLine(line);
			}
			for(DataAnalyzer analyzer : analyzers) {
				if(analyzer instanceof DetectionAnalyzer){
					DetectionAnalyzer detectionAnalyzer = (DetectionAnalyzer)analyzer;
					detectionAnalyzer.analyzeData(data);
				}
			}
		}
		for(DataAnalyzer analyzer : analyzers) {
			if(analyzer instanceof DetectionAnalyzer){
				((DetectionAnalyzer) analyzer).runAnalysis(exporter);
			}
		}
	}

	/**
	 * Add the header line containing the names of the analyzers or requiring data
	 * in the result exporter.
	 * @param exporter Exporter
	 * @throws IOException 
	 */
	private void writeHeader(Exporter exporter) throws IOException {
		ArrayList<Object> line = new ArrayList<Object>();
		for(DataAnalyzer analyser : analyzers) {
			for(String name : analyser.getName()) {
				line.add(name);				
			}
		}
		exporter.writeLine(line);
	}
}
