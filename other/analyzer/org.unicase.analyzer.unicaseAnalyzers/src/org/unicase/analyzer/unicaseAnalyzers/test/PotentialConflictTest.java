/**
 * <copyright> Copyright (c) 2008-2009 Jonas Helming, Maximilian Koegel. All rights reserved. This program and the
 * accompanying materials are made available under the terms of the Eclipse Public License v1.0 which accompanies this
 * distribution, and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>
 */

package org.unicase.analyzer.unicaseAnalyzers.test;

import static org.junit.Assert.assertTrue;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import org.junit.Test;
import org.unicase.analyzer.AnalyzerModelController;
import org.unicase.analyzer.DataAnalyzer;
import org.unicase.analyzer.exceptions.IteratorException;
import org.unicase.analyzer.exporters.impl.CSVExporter;
import org.unicase.analyzer.iterator.VersionIterator;
import org.unicase.analyzer.iterator.impl.IteratorFactoryImpl;
import org.unicase.analyzer.unicaseanalyzers.PotentialConflictAnalyzer;
import org.unicase.anaylzer.test.AnalyzersTest;
import org.unicase.emfstore.esmodel.ProjectInfo;

/**
 * @author liya
 *
 */
public class PotentialConflictTest extends AnalyzersTest {
	private File export;
	private CSVExporter exporter;
	
	
	/**
	 * Define your export file name here.
	 */
	public PotentialConflictTest() {
		super();
	}
	/**
	 * Test on DOLLI2.
	 * @throws IOException 
	 * @throws IteratorException 
	 */
	@Test
	public void dolli2Test() throws IOException, IteratorException{
		for (ProjectInfo pI : super.getProjectList()) {			
			if (pI.getName().contains("DOLLI2")) {
				System.out.println(pI + " " + pI.getProjectId() + " at Version: " + pI.getVersion().getIdentifier());
				long startTime = System.currentTimeMillis();
				int stepLength = 1;

				VersionIterator projectIt = IteratorFactoryImpl.eINSTANCE.createVersionIterator();
				CSVExporter exporter = new CSVExporter("Exports/export_test.dat",true);
				projectIt.setProjectId(pI.getProjectId());
				projectIt.setStepLength(stepLength);
				projectIt.setDefault(true);
				projectIt.init(super.getUserSession());
				ArrayList<DataAnalyzer> analyzers = new ArrayList<DataAnalyzer>();
				analyzers.add(new PotentialConflictAnalyzer());
				@SuppressWarnings("unused")
				AnalyzerModelController anacontrol = new AnalyzerModelController(projectIt, analyzers, exporter);					

				long endTime = System.currentTimeMillis();
			    System.out.println("Total elapsed time in execution is :"+ (endTime-startTime));
			}
		}
		assertTrue(true);
	}

}
