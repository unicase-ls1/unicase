/**
 * <copyright> Copyright (c) 2008-2009 Jonas Helming, Maximilian Koegel. All rights reserved. This program and the
 * accompanying materials are made available under the terms of the Eclipse Public License v1.0 which accompanies this
 * distribution, and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>
 */

package org.unicase.anaylzer.test;

import static org.junit.Assert.assertTrue;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import org.junit.Test;
import org.unicase.analyzer.AnalyzerController;
import org.unicase.analyzer.VersionIterator;
import org.unicase.analyzer.dataanalyzer.DataAnalyzer;
import org.unicase.analyzer.dataanalyzer.PotentialConflictAnalyzer;
import org.unicase.analyzer.exceptions.IteratorException;
import org.unicase.analyzer.exporter.CSVExporter;
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
		this.export = new File("Exports/export_conflict.dat");
		try {
			this.exporter = new CSVExporter(export);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	/**
	 * Test on DOLLI2.
	 */
	@Test
	public void dolli2Test(){
		for (ProjectInfo pI : super.getProjectList()) {			
			if (pI.getName().contains("DOLLI2")) {
				System.out.println(pI + " " + pI.getProjectId() + " at Version: " + pI.getVersion().getIdentifier());
				long startTime = System.currentTimeMillis();
				int stepLength = 1;
				try {
					 VersionIterator projectIt = new VersionIterator(getUserSession(), pI.getProjectId(), stepLength);
					ArrayList<DataAnalyzer> analyzers = new ArrayList<DataAnalyzer>();
					analyzers.add(new PotentialConflictAnalyzer());
					@SuppressWarnings("unused")
					AnalyzerController anacontrol = new AnalyzerController(projectIt, analyzers, exporter);					
				} catch (IteratorException e) {
					e.printStackTrace();
				}
				long endTime = System.currentTimeMillis();
			    System.out.println("Total elapsed time in execution is :"+ (endTime-startTime));
			}
		}
		assertTrue(true);
	}

}
