/**
 * <copyright> Copyright (c) 2008 Jonas Helming, Maximilian Koegel. All rights reserved. This program and the
 * accompanying materials are made available under the terms of the Eclipse Public License v1.0 which accompanies this
 * distribution, and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>
 */
package org.unicase.anaylzer.test;

import static org.junit.Assert.assertTrue;

import java.util.Calendar;

import org.junit.Test;
import org.unicase.analyzer.ProjectAnalysisData;
import org.unicase.analyzer.TimeIterator;
import org.unicase.analyzer.VersionIterator;
import org.unicase.analyzer.VersionSpecQuery;
import org.unicase.analyzer.exceptions.IteratorException;
import org.unicase.emfstore.esmodel.ProjectInfo;
import org.unicase.emfstore.esmodel.versioning.PrimaryVersionSpec;
import org.unicase.emfstore.esmodel.versioning.VersioningFactory;

/**
 * @author liya
 *
 */
public class IteratorTest extends AnalyzersTest {
	/**
	 * Test Default VersionIterator. 
	 */
    @Test
	public void defaultVersionIteratorTest(){
		for (ProjectInfo pI : super.getProjectList()) {			
			if (pI.getName().contains("DOLLI")) {
				System.out.println(pI + " " + pI.getProjectId() + " at Version: " + pI.getVersion().getIdentifier());
				int stepLength = 30;
				VersionIterator projectIt;
				try {
					projectIt = new VersionIterator(super.getUserSession(), pI.getProjectId(), stepLength);
					while (projectIt.hasNext()) {
						ProjectAnalysisData projectData = projectIt.next();
						 System.out.println("At Version: " + projectData.getPrimaryVersionSpec().getIdentifier());
					}
				} catch (IteratorException e) {
					e.printStackTrace();
				}
			}
		}
		assertTrue(true);
	}		
	
	/**
	 * Test Default TimeIterator. 
	 */
	@Test
	public void defaultTimeIteratorTest(){
		for (ProjectInfo pI : super.getProjectList()) {			
			if (pI.getName().contains("-01")) {
				System.out.println(pI + " " + pI.getProjectId() + " at Version: " + pI.getVersion().getIdentifier());
				int stepLength = 2;
				TimeIterator projectIt;
				try {
					projectIt = new TimeIterator(super.getUserSession(), pI.getProjectId(), stepLength, Calendar.DATE);
					while (projectIt.hasNext()) {
						ProjectAnalysisData projectData = projectIt.next();
						 System.out.println("At Version: " + projectData.getPrimaryVersionSpec().getIdentifier());
					}
				} catch (IteratorException e) {
					e.printStackTrace();
				}
			}
		}
		assertTrue(true);
	}	
	
	/**
	 * Test VersionIterator with given start and end.
	 */
    @Test
	public void versionIteratorTest(){
		for (ProjectInfo pI : super.getProjectList()) {			
			if (pI.getName().contains("-01")) {
				System.out.println(pI + " " + pI.getProjectId() + " at Version: " + pI.getVersion().getIdentifier());
				int stepLength = 3;
				
				try {
					PrimaryVersionSpec start = VersioningFactory.eINSTANCE.createPrimaryVersionSpec();
					start.setIdentifier(3);
					PrimaryVersionSpec end = VersioningFactory.eINSTANCE.createPrimaryVersionSpec();
					end.setIdentifier(24);
					
					VersionSpecQuery versionSpecQuery = new VersionSpecQuery(start, end);
					 VersionIterator projectIt = new VersionIterator(getUserSession(), pI.getProjectId(), stepLength,
					 versionSpecQuery, true, false);
					while (projectIt.hasNext()) {
						ProjectAnalysisData projectData = projectIt.next();
						 System.out.println("At Version: " + projectData.getPrimaryVersionSpec().getIdentifier());
					}
				} catch (IteratorException e) {
					e.printStackTrace();
				}
			}
		}
		assertTrue(true);
	}		
	
}
