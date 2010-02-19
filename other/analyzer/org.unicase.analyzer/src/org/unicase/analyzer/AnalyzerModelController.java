/**
 * <copyright> Copyright (c) 2008-2009 Jonas Helming, Maximilian Koegel. All rights reserved. This program and the
 * accompanying materials are made available under the terms of the Eclipse Public License v1.0 which accompanies this
 * distribution, and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>
 */
package org.unicase.analyzer;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.eclipse.core.runtime.IProgressMonitor;
import org.unicase.analyzer.exporters.Exporter;
import org.unicase.analyzer.iterator.VersionIterator;

/**
 * @author liya
 */
public class AnalyzerModelController {

	private final ArrayList<DataAnalyzer> analyzers;

	private final VersionIterator projectIterator;

	private Exporter exporter;

	private final int flag;

	private IProgressMonitor monitor;

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

		flag = checkAnalyzerTypes(analyzers);
	}

	private int checkAnalyzerTypes(List<DataAnalyzer> analyzers) {

		int flag;
		if (analyzers.get(0) instanceof SimpleDataAnalyzer) {
			flag = 1;
		} else {
			flag = 2;
		}
		int temp = flag;

		for (DataAnalyzer analyzer : analyzers) {

			if (temp != flag) {
				throw new IllegalStateException("Analyzers type are not compatible, please check the chosen analyzers!");
			}
			temp = flag;
			if (analyzer instanceof SimpleDataAnalyzer) {
				flag = 1;
			} else {
				flag = 2;
			}
		}
		if (temp != flag) {
			throw new IllegalStateException("Analyzers type are not compatible, please check the chosen analyzers!");
		}
		return flag;
	}

	/**
	 * Runs the actual analysis and adds the lines to the result.
	 * 
	 * @param exporter Exporter
	 * @throws IOException
	 */
	public void runAnalysis(Exporter exporter) throws IOException {
		writeHeader(exporter);
		switch (flag) {
		case 2:
			List<List<Object>> lines = new ArrayList<List<Object>>();
			ProjectAnalysisData data = AnalyzerFactory.eINSTANCE.createProjectAnalysisData();
			while (projectIterator.hasNext()) {

				data = projectIterator.next();
				monitor.setTaskName("Analyzing...@Version "
					+ ((Integer) (data.getPrimaryVersionSpec().getIdentifier())).toString());

				lines.clear();
				for (DataAnalyzer analyzer : analyzers) {
					lines = analyzer.getValues(data, projectIterator);
					exporter.export(lines);
				}
				monitor.worked(projectIterator.getStepLength());
			}
			return;
		case 1:
			List<Object> line = new ArrayList<Object>();
			while (projectIterator.hasNext()) {
				data = projectIterator.next();
				monitor.setTaskName("Analyzing...@Version "
					+ ((Integer) (data.getPrimaryVersionSpec().getIdentifier())).toString());

				line.clear();
				for (DataAnalyzer analyzer : analyzers) {
					for (Object obj : ((SimpleDataAnalyzer) analyzer).getSimpleValues(data)) {
						line.add(obj);
					}
				}
				exporter.writeLine(line);
				monitor.worked(projectIterator.getStepLength());
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

	public IProgressMonitor getMonitor() {
		return monitor;
	}

	public void setMonitor(IProgressMonitor monitor) {
		this.monitor = monitor;
	}
}
