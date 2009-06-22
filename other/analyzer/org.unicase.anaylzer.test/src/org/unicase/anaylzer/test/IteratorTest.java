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
	 * @throws IteratorException IteratorException
	 */
    @Test
	public void defaultVersionIteratorTest() throws IteratorException{
		for (ProjectInfo pI : super.getProjectList()) {			
			if (pI.getName().contains("01")) {
				System.out.println(pI + " " + pI.getProjectId() + " at Version: " + pI.getVersion().getIdentifier());
				int stepLength = 30;
				VersionIterator projectIt;

				projectIt = new VersionIterator(super.getUserSession(), pI.getProjectId(), stepLength);
				while (projectIt.hasNext()) {
					ProjectAnalysisData projectData = projectIt.next();
					 System.out.println("At Version: " + projectData.getPrimaryVersionSpec().getIdentifier());
				}
			}
		}
		assertTrue(true);
	}		
	
	/**
	 * Test Default TimeIterator. 
	 * @throws IteratorException IteratorException
	 */
	@Test
	public void defaultTimeIteratorTest() throws IteratorException{
		for (ProjectInfo pI : super.getProjectList()) {			
			if (pI.getName().contains("-01")) {
				System.out.println(pI + " " + pI.getProjectId() + " at Version: " + pI.getVersion().getIdentifier());
				int stepLength = 2;
				TimeIterator projectIt;

				projectIt = new TimeIterator(super.getUserSession(), pI.getProjectId(), stepLength, Calendar.DATE);
				while (projectIt.hasNext()) {
					ProjectAnalysisData projectData = projectIt.next();
					 System.out.println("At Version: " + projectData.getPrimaryVersionSpec().getIdentifier());
				}

			}
		}
		assertTrue(true);
	}	
	
	/**
	 * Test VersionIterator with given start and end.
	 * @throws IteratorException IteratorException
	 */
    @Test
	public void versionIteratorTest() throws IteratorException{
		for (ProjectInfo pI : super.getProjectList()) {			
			if (pI.getName().contains("-01")) {
				System.out.println(pI + " " + pI.getProjectId() + " at Version: " + pI.getVersion().getIdentifier());
				int stepLength = 3;
				

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
			}
		}
		assertTrue(true);
	}		
    
	/**
	 * Test Backward VersionIterator.
	 * @throws IteratorException IteratorException.
	 */
    @Test
	public void backwardIteratorTest() throws IteratorException{
		for (ProjectInfo pI : super.getProjectList()) {			
			if (pI.getName().contains("test")) {
				System.out.println(pI + " " + pI.getProjectId() + " at Version: " + pI.getVersion().getIdentifier());
				int stepLength = 1;
				int startPoint = 5;
				int endPoint = 3;

				PrimaryVersionSpec start = VersioningFactory.eINSTANCE.createPrimaryVersionSpec();
				start.setIdentifier(startPoint);
				PrimaryVersionSpec end = VersioningFactory.eINSTANCE.createPrimaryVersionSpec();
				end.setIdentifier(endPoint);
				
				VersionSpecQuery versionSpecQuery = new VersionSpecQuery(start, end);
				 VersionIterator projectIt = new VersionIterator(getUserSession(), pI.getProjectId(), stepLength,
				 versionSpecQuery, false, false);
				while (projectIt.hasNext()) {
					ProjectAnalysisData projectData = projectIt.next();
					 System.out.println("At Version: " + projectData.getPrimaryVersionSpec().getIdentifier());
					if(projectData.getPrimaryVersionSpec().getIdentifier() != startPoint){ 
						assertTrue(super.compareChangePackage(pI.getProjectId(), projectData, projectData.getPrimaryVersionSpec().getIdentifier()+stepLength, projectData.getPrimaryVersionSpec().getIdentifier(), false));
					}
				}
			}
		}
	}		
	
	/**
	 * Test Backward VersionIterator till version 0.
	 * @throws IteratorException IteratorException.
	 */
    @Test
	public void backwardTillZeroIteratorTest() throws IteratorException{
		for (ProjectInfo pI : super.getProjectList()) {			
			if (pI.getName().contains("test")) {
				System.out.println(pI + " " + pI.getProjectId() + " at Version: " + pI.getVersion().getIdentifier());
				int stepLength = 1;
				int startPoint = 5;
				int endPoint = 0;

				PrimaryVersionSpec start = VersioningFactory.eINSTANCE.createPrimaryVersionSpec();
				start.setIdentifier(startPoint);
				PrimaryVersionSpec end = VersioningFactory.eINSTANCE.createPrimaryVersionSpec();
				end.setIdentifier(endPoint);
				
				VersionSpecQuery versionSpecQuery = new VersionSpecQuery(start, end);
				 VersionIterator projectIt = new VersionIterator(getUserSession(), pI.getProjectId(), stepLength,
				 versionSpecQuery, false, false);
				while (projectIt.hasNext()) {
					ProjectAnalysisData projectData = projectIt.next();
					 System.out.println("At Version: " + projectData.getPrimaryVersionSpec().getIdentifier());
					if(projectData.getPrimaryVersionSpec().getIdentifier() != startPoint){ 
						assertTrue(super.compareChangePackage(pI.getProjectId(), projectData, projectData.getPrimaryVersionSpec().getIdentifier()+stepLength, projectData.getPrimaryVersionSpec().getIdentifier(), false));
					}
				}
			}
		}
	}		
}
