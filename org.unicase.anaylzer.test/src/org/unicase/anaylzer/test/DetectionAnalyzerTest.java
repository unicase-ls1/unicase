/**
 * <copyright> Copyright (c) 2008 Jonas Helming, Maximilian Koegel. All rights reserved. This program and the accompanying materials are made available under the terms of the Eclipse Public License v1.0 which accompanies this distribution, and is available at http://www.eclipse.org/legal/epl-v10.html
 * </copyright>
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
import org.unicase.analyzer.dataanalyzer.DetectionAnalyzer;
import org.unicase.analyzer.exceptions.IteratorException;
import org.unicase.analyzer.exporter.CSVExporter;
import org.unicase.emfstore.esmodel.ProjectInfo;
import org.unicase.emfstore.esmodel.versioning.PrimaryVersionSpec;
import org.unicase.emfstore.esmodel.versioning.VersioningFactory;

/**
 * @author liya
 *
 */
public class DetectionAnalyzerTest extends AnalyzersTest {

	private File export;
	private CSVExporter exporter;
	
	
	/**
	 * Define your export file name here
	 */
	public DetectionAnalyzerTest() {
		super();
		this.export = new File("Exports/export_SEE_test.dat");
		try {
			this.exporter = new CSVExporter(export);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}


	/**
	 * DetectionAnalyzer for SEE project 01, FR Attributes
	 */
	@Test
	public void test1(){
		for (ProjectInfo pI : super.getProjectList()) {			
			if (pI.getName().contains("-01")) {
				System.out.println(pI + " " + pI.getProjectId() + " at Version: " + pI.getVersion().getIdentifier());
				int stepLength = 1;
				try {
					PrimaryVersionSpec start = VersioningFactory.eINSTANCE.createPrimaryVersionSpec();
					start.setIdentifier(16);
					PrimaryVersionSpec end = VersioningFactory.eINSTANCE.createPrimaryVersionSpec();
					end.setIdentifier(25);

					 VersionIterator projectIt = new VersionIterator(getUserSession(), pI.getProjectId(), stepLength,
					 start,
					 end, true, false);
					ArrayList<DataAnalyzer> analyzers = new ArrayList<DataAnalyzer>();
					analyzers.add(new DetectionAnalyzer("Attributes", projectIt));
					@SuppressWarnings("unused")
					AnalyzerController anacontrol = new AnalyzerController(projectIt, analyzers, exporter);					
				} catch (IteratorException e) {
					e.printStackTrace();
				}
			}
		}
		assertTrue(true);
	}
	
	
	/**
	 * DetectionAnalyzer for SEE project 02, FR Attributes
	 */
	@Test
	public void test2(){
		for (ProjectInfo pI : super.getProjectList()) {			
			if (pI.getName().contains("-02")) {
				System.out.println(pI + " " + pI.getProjectId() + " at Version: " + pI.getVersion().getIdentifier());
				int stepLength = 1;
				try {
					PrimaryVersionSpec start = VersioningFactory.eINSTANCE.createPrimaryVersionSpec();
					start.setIdentifier(22);
					PrimaryVersionSpec end = VersioningFactory.eINSTANCE.createPrimaryVersionSpec();
					end.setIdentifier(49);

					 VersionIterator projectIt = new VersionIterator(getUserSession(), pI.getProjectId(), stepLength,
					 start,
					 end, true, false);
					ArrayList<DataAnalyzer> analyzers = new ArrayList<DataAnalyzer>();
					analyzers.add(new DetectionAnalyzer("Attributes", projectIt));
					@SuppressWarnings("unused")
					AnalyzerController anacontrol = new AnalyzerController(projectIt, analyzers, exporter);					
				} catch (IteratorException e) {
					e.printStackTrace();
				}
			}
		}
		assertTrue(true);
	}
}
