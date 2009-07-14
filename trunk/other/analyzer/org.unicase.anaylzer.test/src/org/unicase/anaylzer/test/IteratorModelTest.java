/**
 * <copyright> Copyright (c) 2008 Jonas Helming, Maximilian Koegel. All rights reserved. This program and the accompanying materials are made available under the terms of the Eclipse Public License v1.0 which accompanies this distribution, and is available at http://www.eclipse.org/legal/epl-v10.html
 * </copyright>
 */

package org.unicase.anaylzer.test;

import static org.junit.Assert.assertTrue;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import org.junit.Test;
import org.unicase.analyzer.ProjectAnalysisData;
import org.unicase.analyzer.exceptions.IteratorException;
import org.unicase.analyzer.exporters.impl.CSVExporter;
import org.unicase.analyzer.iterator.TimeIterator;
import org.unicase.analyzer.iterator.VersionIterator;
import org.unicase.analyzer.iterator.impl.IteratorFactoryImpl;
import org.unicase.emfstore.esmodel.ProjectInfo;
import org.unicase.emfstore.exceptions.EmfStoreException;

/**
 * @author liya
 *
 */
public class IteratorModelTest extends AnalyzersTest {

	/**
	 * Test Default VersionIterator. 
	 * @throws IteratorException IteratorException
	 * @throws EmfStoreException EmfStoreException
	 * @throws IOException 
	 */
    @Test
	public void defaultVersionIteratorTest() throws IteratorException, EmfStoreException, IOException{
		for (ProjectInfo pI : super.getProjectList()) {			
			if (pI.getName().contains("test")) {
				System.out.println(pI + " " + pI.getProjectId() + " at Version: " + pI.getVersion().getIdentifier());
				int stepLength = 1;
				VersionIterator projectIt = IteratorFactoryImpl.eINSTANCE.createVersionIterator();
				CSVExporter exporter = new CSVExporter("Exports/export_test.dat",true);
				projectIt.setProjectId(pI.getProjectId());
				projectIt.setStepLength(stepLength);
				projectIt.setDefault(true);
				projectIt.init(super.getUserSession());
				//projectIt.init(super.getUserSession(), pI.getProjectId(), stepLength);
				int tempIdentifier = 0;
				while (projectIt.hasNext()) {
					ProjectAnalysisData projectData = projectIt.next(); 
					
					 System.out.println("At Version: " + projectData.getPrimaryVersionSpec().getIdentifier());
					 if(projectData.getPrimaryVersionSpec().getIdentifier() != 0){ 
							assertTrue(super.compareChangePackage(pI.getProjectId(), projectData, tempIdentifier, projectData.getPrimaryVersionSpec().getIdentifier(), true));
							List<Object> list = new ArrayList<Object>();
							list.add(projectData.getPrimaryVersionSpec().getIdentifier());
							list.add(projectData.getChangePackages().get(0).getLogMessage().getMessage());
							exporter.writeLine(list);
					}
					 tempIdentifier = projectData.getPrimaryVersionSpec().getIdentifier();
				}
			}
		}
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
				TimeIterator projectIt = IteratorFactoryImpl.eINSTANCE.createTimeIterator();
				projectIt.init(super.getUserSession(), pI.getProjectId(), stepLength, Calendar.MINUTE);
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
	
}
