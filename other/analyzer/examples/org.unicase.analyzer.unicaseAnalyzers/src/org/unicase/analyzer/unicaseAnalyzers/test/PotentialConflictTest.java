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
import org.unicase.analyzer.unicaseAnalyzers.PotentialConflictAnalyzer;
import org.unicase.anaylzer.test.AnalyzersTest;
import org.unicase.emfstore.esmodel.ProjectInfo;

/**
 * @author liya
 */
public class PotentialConflictTest extends AnalyzersTest {

	/**
	 * Potential Conflict Analyzer test.
	 */
	public PotentialConflictTest() {
		super();
	}

	/**
	 * Test potential conflict analyzer on DOLLI2.
	 * 
	 * @throws IOException IOException
	 * @throws IteratorException IteratorException
	 */
	@Test
	public void dolli2Test() throws IOException, IteratorException {
		for (ProjectInfo pI : super.getProjectList()) {
			if (pI.getName().contains("DOLLI2")) {
				System.out.println(pI + " " + pI.getProjectId() + " at Version: " + pI.getVersion().getIdentifier());
				long startTime = System.currentTimeMillis();
				int stepLength = 1;

				VersionIterator projectIt = IteratorFactory.eINSTANCE.createVersionIterator();
				CSVExporter exporter = ExportersFactory.eINSTANCE.createCSVExporter();
				exporter.init("Exports/export_test.dat", true);
				projectIt.setProjectId(pI.getProjectId());
				projectIt.setStepLength(stepLength);
				projectIt.setDefault(true);
				projectIt.init(super.getUserSession());
				ArrayList<DataAnalyzer> analyzers = new ArrayList<DataAnalyzer>();
				analyzers.add(new PotentialConflictAnalyzer());
				@SuppressWarnings("unused")
				AnalyzerModelController anacontrol = new AnalyzerModelController(projectIt, analyzers, exporter);

				long endTime = System.currentTimeMillis();
				System.out.println("Total elapsed time in execution is :" + (endTime - startTime));
			}
		}
		assertTrue(true);
	}

}
