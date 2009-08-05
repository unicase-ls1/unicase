/**
 * <copyright> Copyright (c) 2008-2009 Jonas Helming, Maximilian Koegel. All rights reserved. This program and the
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
import org.unicase.emfstore.exceptions.EmfStoreException;

/**
 * @author liya
 *
 */
public class IteratorTest extends AnalyzersTest {
	/**
	 * Test Default VersionIterator. 
	 * @throws IteratorException IteratorException
	 * @throws EmfStoreException EmfStoreException
	 */
    @Test
	public void defaultVersionIteratorTest() throws IteratorException, EmfStoreException{
		for (ProjectInfo pI : super.getProjectList()) {			
			if (pI.getName().contains("test")) {
				System.out.println(pI + " " + pI.getProjectId() + " at Version: " + pI.getVersion().getIdentifier());
				int stepLength = 1;
				VersionIterator projectIt;

				projectIt = new VersionIterator(super.getUserSession(), pI.getProjectId(), stepLength);
				int tempIdentifier = 0;
				while (projectIt.hasNext()) {
					ProjectAnalysisData projectData = projectIt.next();
					 System.out.println("At Version: " + projectData.getPrimaryVersionSpec().getIdentifier());
					 if(projectData.getPrimaryVersionSpec().getIdentifier() != 0){ 
							assertTrue(super.compareChangePackage(pI.getProjectId(), projectData, tempIdentifier, projectData.getPrimaryVersionSpec().getIdentifier(), true));
					}
					 tempIdentifier = projectData.getPrimaryVersionSpec().getIdentifier();
				}
			}
		}
		assertTrue(true);
	}		
	
	/**
	 * Test Default TimeIterator. 
	 * @throws IteratorException IteratorException
	 * @throws EmfStoreException EmfStoreException
	 */
	@Test
	public void defaultTimeIteratorTest() throws IteratorException, EmfStoreException{
		for (ProjectInfo pI : super.getProjectList()) {			
			if (pI.getName().contains("test")) {
				System.out.println(pI + " " + pI.getProjectId() + " at Version: " + pI.getVersion().getIdentifier());
				int stepLength = 1;
				TimeIterator projectIt;

				projectIt = new TimeIterator(super.getUserSession(), pI.getProjectId(), stepLength, Calendar.MINUTE);
				int tempIdentifier = 0;
				while (projectIt.hasNext()) {
					ProjectAnalysisData projectData = projectIt.next();
					 System.out.println("At Version: " + projectData.getPrimaryVersionSpec().getIdentifier());
					 if(projectData.getPrimaryVersionSpec().getIdentifier() != 0){ 
							assertTrue(super.compareChangePackage(pI.getProjectId(), projectData, tempIdentifier, projectData.getPrimaryVersionSpec().getIdentifier(), true));
					}
					 tempIdentifier = projectData.getPrimaryVersionSpec().getIdentifier();
				}

			}
		}
	}	
	
	/**
	 * Test VersionIterator with given start and end.
	 * @throws IteratorException IteratorException
	 * @throws EmfStoreException EmfStoreException
	 */
    @Test
	public void outofBoundVersionIteratorTest() throws IteratorException, EmfStoreException{
		for (ProjectInfo pI : super.getProjectList()) {			
			if (pI.getName().contains("test")) {
				System.out.println(pI + " " + pI.getProjectId() + " at Version: " + pI.getVersion().getIdentifier());
				int stepLength = 3;
				int startPoint = 3;
				int endPoint = 6;

				PrimaryVersionSpec start = VersioningFactory.eINSTANCE.createPrimaryVersionSpec();
				start.setIdentifier(startPoint);
				PrimaryVersionSpec end = VersioningFactory.eINSTANCE.createPrimaryVersionSpec();
				end.setIdentifier(endPoint);
				
				VersionSpecQuery versionSpecQuery = new VersionSpecQuery(start, end);
				 VersionIterator projectIt = new VersionIterator(getUserSession(), pI.getProjectId(), stepLength,
				 versionSpecQuery, true, false);
				 int tempIdentifier = startPoint;
				while (projectIt.hasNext()) {
					ProjectAnalysisData projectData = projectIt.next();
					 System.out.println("At Version: " + projectData.getPrimaryVersionSpec().getIdentifier());
					 if(projectData.getPrimaryVersionSpec().getIdentifier() != startPoint){ 
							assertTrue(super.compareChangePackage(pI.getProjectId(), projectData, tempIdentifier, projectData.getPrimaryVersionSpec().getIdentifier(), true));
					}
					tempIdentifier = projectData.getPrimaryVersionSpec().getIdentifier();
				}
			}
		}
	}		
    
	/**
	 * Test Backward VersionIterator.
	 * @throws IteratorException IteratorException.
	 * @throws EmfStoreException EmfStoreException
	 */
    @Test
	public void backwardIteratorTest() throws IteratorException, EmfStoreException{
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
				 int tempIdentifier = startPoint;
				while (projectIt.hasNext()) {
					ProjectAnalysisData projectData = projectIt.next();
					 System.out.println("At Version: " + projectData.getPrimaryVersionSpec().getIdentifier());
					if(projectData.getPrimaryVersionSpec().getIdentifier() != startPoint){ 
						assertTrue(super.compareChangePackage(pI.getProjectId(), projectData, tempIdentifier, projectData.getPrimaryVersionSpec().getIdentifier(), false));
					}
					tempIdentifier = projectData.getPrimaryVersionSpec().getIdentifier();
				}
			}
		}
	}		
	
	/**
	 * Test Backward VersionIterator till version 0.
	 * @throws IteratorException IteratorException.
	 * @throws EmfStoreException EmfStoreException
	 */
    @Test
	public void backwardTillZeroIteratorTest() throws IteratorException, EmfStoreException{
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
				 int tempIdentifier = startPoint;
				while (projectIt.hasNext()) {
					ProjectAnalysisData projectData = projectIt.next();
					 System.out.println("At Version: " + projectData.getPrimaryVersionSpec().getIdentifier());
					if(projectData.getPrimaryVersionSpec().getIdentifier() != startPoint){ 
						assertTrue(super.compareChangePackage(pI.getProjectId(), projectData, tempIdentifier, projectData.getPrimaryVersionSpec().getIdentifier(), false));
					}
					tempIdentifier = projectData.getPrimaryVersionSpec().getIdentifier();
				}
			}
		}
	}	
	/**
	 * Test backward TimeIterator. 
	 * @throws IteratorException IteratorException
	 * @throws EmfStoreException EmfStoreException
	 */
	@Test
	public void backwardTimeIteratorTest() throws IteratorException, EmfStoreException{
		for (ProjectInfo pI : super.getProjectList()) {			
			if (pI.getName().contains("test")) {
				System.out.println(pI + " " + pI.getProjectId() + " at Version: " + pI.getVersion().getIdentifier());
				int stepLength = 1;
				TimeIterator projectIt;
				int startPoint = 5;
				int endPoint = 1;

				PrimaryVersionSpec start = VersioningFactory.eINSTANCE.createPrimaryVersionSpec();
				start.setIdentifier(startPoint);
				PrimaryVersionSpec end = VersioningFactory.eINSTANCE.createPrimaryVersionSpec();
				end.setIdentifier(endPoint);
				
				VersionSpecQuery versionSpecQuery = new VersionSpecQuery(start, end);

				projectIt = new TimeIterator(super.getUserSession(), pI.getProjectId(), stepLength, Calendar.MINUTE, versionSpecQuery, false, false);
				int tempIdentifier = startPoint;
				while (projectIt.hasNext()) {
					ProjectAnalysisData projectData = projectIt.next();
					 System.out.println("At Version: " + projectData.getPrimaryVersionSpec().getIdentifier());
					 if(projectData.getPrimaryVersionSpec().getIdentifier() != startPoint){ 
						assertTrue(super.compareChangePackage(pI.getProjectId(), projectData, tempIdentifier, projectData.getPrimaryVersionSpec().getIdentifier(), false));
					}
					tempIdentifier = projectData.getPrimaryVersionSpec().getIdentifier(); 
				}

			}
		}
	}	
	
}
