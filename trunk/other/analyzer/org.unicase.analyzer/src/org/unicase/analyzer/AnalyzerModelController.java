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

	private int flag;

	/**
	 * The Controller adds the proper analyzers and iterators, then starts the analysis. The result is exported to the
	 * specified exporter.
	 * 
	 * @param projectIterator The iterator to be used.
	 * @param analyzers The list of dataAnalyzers to be used.
	 * @param exporter The exporter to be used.
	 */
	@SuppressWarnings("cast")
	public AnalyzerModelController(VersionIterator projectIterator, ArrayList<DataAnalyzer> analyzers, Exporter exporter) {
		this.projectIterator = projectIterator;
		this.analyzers = analyzers;
		this.setExporter(exporter);

		// flag is used for switching different ways of exporting, depends on different analyzers
		DataAnalyzer analyzer = analyzers.get(0);
		if (analyzer instanceof TwoDDataAnalyzer) {
			this.flag = 2;
		} else if (analyzer instanceof DataAnalyzer) {
			this.flag = 3;
		}

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
		switch (flag) {
		case 2:
			List<List<Object>> lines = new ArrayList<List<Object>>();
			ProjectAnalysisData data = AnalyzerFactory.eINSTANCE.createProjectAnalysisData();
			while (projectIterator.hasNext()) {
				data = projectIterator.next();
				lines.clear();
				for (DataAnalyzer analyzer : analyzers) {
					if (analyzer.isGlobal()) {
						((TwoDDataAnalyzer) analyzer).analyzeData(data, projectIterator);
					} else {
						lines = ((TwoDDataAnalyzer) analyzer).get2DValue(data, projectIterator);
						exporter.export(lines);
					}
				}
			}
			for (DataAnalyzer analyzer : analyzers) {
				if (analyzer.isGlobal()) {
					lines = ((TwoDDataAnalyzer) analyzer).get2DValue(data, projectIterator);
					exporter.export(lines);
				}
			}
			return;
		case 3:
			List<Object> line = new ArrayList<Object>();
			while (projectIterator.hasNext()) {
				data = projectIterator.next();
				line.clear();
				for (DataAnalyzer analyzer : analyzers) {
					for (Object obj : analyzer.getValue(data)) {
						line.add(obj);
					}
				}
				exporter.writeLine(line);
			}
			return;
		default:
			break;
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
			for (String name : analyser.getName()) {
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
