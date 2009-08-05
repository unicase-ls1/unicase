/**
 * <copyright> Copyright (c) 2008-2009 Jonas Helming, Maximilian Koegel. All rights reserved. This program and the
 * accompanying materials are made available under the terms of the Eclipse Public License v1.0 which accompanies this
 * distribution, and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>
 */
package org.unicase.anaylzer.test;

import static org.junit.Assert.assertTrue;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.StringTokenizer;

import org.junit.Test;
import org.unicase.analyzer.AnalyzerController;
import org.unicase.analyzer.VersionIterator;
import org.unicase.analyzer.dataanalyzer.CommitUpdateReadEventAnalyzer;
import org.unicase.analyzer.dataanalyzer.DataAnalyzer;
import org.unicase.analyzer.exceptions.IteratorException;
import org.unicase.analyzer.exporter.CSVExporter;
import org.unicase.emfstore.esmodel.ProjectInfo;
import org.unicase.model.ModelElementId;
import org.unicase.model.Project;

/**
 * @author liya
 *
 */
public class CommitReadEventAnalyzerTest extends AnalyzersTest {
	private File export;
	private CSVExporter exporter;
	
	
	/**
	 * Define your export file name here.
	 * @throws IOException when exporter could not 
	 */
	public CommitReadEventAnalyzerTest() throws IOException {
		super();
		this.export = new File("Exports/export_commit.dat");
		this.exporter = new CSVExporter(export);
		 
	}


	/**
	 * CommitReadEventAnalyzer for multiUserTest project.
	 * @throws IOException fail to write to the exporter file
	 * @throws IteratorException fail to run iterator on the project
	 */
	@Test
	public void multiUserTest() throws IOException, IteratorException{
		for (ProjectInfo pI : super.getProjectList()) {			
			if (pI.getName().contains("multi")) {
				System.out.println(pI + " " + pI.getProjectId() + " at Version: " + pI.getVersion().getIdentifier());
				int stepLength = 1;

				VersionIterator projectIt = new VersionIterator(getUserSession(), pI.getProjectId(), stepLength);
				ArrayList<DataAnalyzer> analyzers = new ArrayList<DataAnalyzer>();
				analyzers.add(new CommitUpdateReadEventAnalyzer());
				@SuppressWarnings("unused")
				AnalyzerController anacontrol = new AnalyzerController(projectIt, analyzers, exporter);
				String [][] elements = readExport(100, 7);
				assertTrue(compareTruth(elements, projectIt.getCurrentState()));

			}
		}
		
	}
	
	private String [][] readExport(int rowNum, int colNum) throws IOException{
		String [][] elements = new String [rowNum][colNum];
		 
		File file = new File("Exports/export_commit.dat");
	 
		BufferedReader bufRdr  = new BufferedReader(new FileReader(file));

		String line = null;
		int row = 0;
		int col = 0;
	 
		//read each line of text file
		while((line = bufRdr.readLine()) != null && row<rowNum)
		{	
			StringTokenizer st = new StringTokenizer(line,",");
			while (st.hasMoreTokens())
			{
				//get next token and store it in the array
				elements[row][col] = st.nextToken();
				col++;
			}
			col = 0;
			row++;
		}return elements;
	}
	
	private boolean compareTruth(String [][] elements, Project project){
		if(elements[1][1].equals("super")){
			//super assigned all the tasks to others and did not read at the beginning
			return false;
		}else if(elements[1][1].equals("sugar")){
			for(int i=1; i<100&&elements[i][0]!=null; i++){
				if(elements[i][1].equals("sugar")){
					for(int j=0; j<project.getAllModelElements().size(); j++){
						ModelElementId meId = project.getAllModelElements().get(j).getModelElementId();
						if(elements[i][0].contains(meId.getId())){
							//sugar only read "Check needed material"
							return project.getModelElement(meId).getName().equals("Check needed material");
						}
					}					
				}
			}
		}
		return false;
	}
	
}
