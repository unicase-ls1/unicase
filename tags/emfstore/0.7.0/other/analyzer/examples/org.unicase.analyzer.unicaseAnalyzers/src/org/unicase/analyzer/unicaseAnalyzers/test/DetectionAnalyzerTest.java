/**
 * <copyright> Copyright (c) 2008-2009 Jonas Helming, Maximilian Koegel. All rights reserved. This program and the
 * accompanying materials are made available under the terms of the Eclipse Public License v1.0 which accompanies this
 * distribution, and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>
 */

package org.unicase.analyzer.unicaseAnalyzers.test;

import static org.junit.Assert.assertTrue;

import java.io.IOException;
import java.util.ArrayList;

import org.junit.Test;
import org.unicase.analyzer.AnalyzerModelController;
import org.unicase.analyzer.DataAnalyzer;
import org.unicase.analyzer.exceptions.IteratorException;
import org.unicase.analyzer.exporters.CSVExporter;
import org.unicase.analyzer.exporters.ExportersFactory;
import org.unicase.analyzer.iterator.IteratorFactory;
import org.unicase.analyzer.iterator.VersionIterator;
import org.unicase.analyzer.unicaseAnalyzers.DetectionAnalyzer;
import org.unicase.anaylzer.test.AnalyzersTest;
import org.unicase.emfstore.esmodel.ProjectInfo;

/**
 * @author liya
 */
public class DetectionAnalyzerTest extends AnalyzersTest {

	/**
	 * 
	 */
	public DetectionAnalyzerTest() {
		super();
	}

	/**
	 * DetectionAnalyzer for SEE project 01, FR Attributes.
	 * 
	 * @throws IOException IOException
	 * @throws IteratorException IteratorException
	 */
	@Test
	public void see01Test() throws IOException, IteratorException {
		for (ProjectInfo pI : super.getProjectList()) {
			if (pI.getName().contains("multi")) {
				System.out.println(pI + " " + pI.getProjectId() + " at Version: " + pI.getVersion().getIdentifier());
				int stepLength = 1;

				VersionIterator projectIt = IteratorFactory.eINSTANCE.createVersionIterator();
				CSVExporter exporter = ExportersFactory.eINSTANCE.createCSVExporter();
				exporter.init("Exports/export_test.dat", true);
				projectIt.setProjectId(pI.getProjectId());
				projectIt.setStepLength(stepLength);
				projectIt.setDefault(true);
				projectIt.init(super.getUserSession());
				ArrayList<DataAnalyzer> analyzers = new ArrayList<DataAnalyzer>();
				analyzers.add(new DetectionAnalyzer("Dish type", projectIt));
				@SuppressWarnings("unused")
				AnalyzerModelController anacontrol = new AnalyzerModelController(projectIt, analyzers, exporter);

			}
		}
		assertTrue(true);
	}

	/**
	 * DetectionAnalyzer for SEE project 02, FR Attributes.
	 * 
	 * @throws IOException IOException
	 * @throws IteratorException IteratorException
	 */
	@Test
	public void see02Test() throws IOException, IteratorException {
		for (ProjectInfo pI : super.getProjectList()) {
			if (pI.getName().contains("-02")) {
				System.out.println(pI + " " + pI.getProjectId() + " at Version: " + pI.getVersion().getIdentifier());
				int stepLength = 1;

				VersionIterator projectIt = IteratorFactory.eINSTANCE.createVersionIterator();
				CSVExporter exporter = ExportersFactory.eINSTANCE.createCSVExporter();
				exporter.init("Exports/export_test.dat", true);
				projectIt.setProjectId(pI.getProjectId());
				projectIt.setStepLength(stepLength);
				projectIt.setDefault(true);
				projectIt.init(super.getUserSession());
				ArrayList<DataAnalyzer> analyzers = new ArrayList<DataAnalyzer>();
				analyzers.add(new DetectionAnalyzer("Attributes", projectIt));
				@SuppressWarnings("unused")
				AnalyzerModelController anacontrol = new AnalyzerModelController(projectIt, analyzers, exporter);

			}
		}
		assertTrue(true);
	}
}
