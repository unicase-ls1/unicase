/**
 * <copyright> Copyright (c) 2008-2009 Jonas Helming, Maximilian Koegel. All rights reserved. This program and the
 * accompanying materials are made available under the terms of the Eclipse Public License v1.0 which accompanies this
 * distribution, and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>
 */
package org.unicase.analyzer;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.unicase.analyzer.exporters.Exporter;
import org.unicase.analyzer.iterator.VersionIterator;

/**
 * @author liya
 */
public class AnalyzerModelController {

	private final ArrayList<DataAnalyzer> analyzers;

	private final VersionIterator projectIterator;

	private Exporter exporter;

	/**
	 * The Controller adds the proper analyzers and iterators, then starts the analysis. The result is exported to the
	 * specified exporter.
	 * 
	 * @param projectIterator The iterator to be used.
	 * @param analyzers The list of dataAnalyzers to be used.
	 * @param exporter The exporter to be used.
	 */
	public AnalyzerModelController(VersionIterator projectIterator, ArrayList<DataAnalyzer> analyzers, Exporter exporter) {
		this.projectIterator = projectIterator;
		this.analyzers = analyzers;
		this.setExporter(exporter);

		try {
			runAnalysis(exporter);
		} catch (IOException e) {
		}
		System.out.println("Finished Analysis");
	}

	/**
	 * Runs the actual analysis and adds the lines to the result.
	 * 
	 * @param exporter Exporter
	 * @throws IOException
	 */
	private void runAnalysis(Exporter exporter) throws IOException {
		writeHeader(exporter);
		List<List<Object>> lines = new ArrayList<List<Object>>();
		ProjectAnalysisData data = AnalyzerFactory.eINSTANCE.createProjectAnalysisData();
		while (projectIterator.hasNext()) {
			data = projectIterator.next();
			lines.clear();
			for (DataAnalyzer analyzer : analyzers) {

				lines.addAll(analyzer.getValues(data, projectIterator)) ;
				exporter.export(lines);

			}

		}
	}

	/**
	 * Add the header line containing the names of the analyzers or requiring data in the result exporter.
	 * 
	 * @param exporter Exporter
	 * @throws IOException
	 */
	private void writeHeader(Exporter exporter) throws IOException {
		ArrayList<Object> line = new ArrayList<Object>();
		for (DataAnalyzer analyser : analyzers) {
			for (String name : analyser.getColumnNames()) {
				line.add(name);
			}
		}
		exporter.writeLine(line);
	}

	/**
	 * @param exporter the exporter to set
	 */
	public void setExporter(Exporter exporter) {
		this.exporter = exporter;
	}

	/**
	 * @return the exporter
	 */
	public Exporter getExporter() {
		return exporter;
	}
}
