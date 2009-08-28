/**
 * <copyright> Copyright (c) 2008-2009 Jonas Helming, Maximilian Koegel. All rights reserved. This program and the
 * accompanying materials are made available under the terms of the Eclipse Public License v1.0 which accompanies this
 * distribution, and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>
 */
package org.unicase.linkrecommendationevaluation;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import org.eclipse.equinox.app.IApplication;
import org.eclipse.equinox.app.IApplicationContext;
import org.unicase.analyzer.AnalyzerModelController;
import org.unicase.analyzer.DataAnalyzer;
import org.unicase.analyzer.exporters.CSVExporter;
import org.unicase.analyzer.exporters.ExportersFactory;
import org.unicase.analyzer.iterator.IteratorFactory;
import org.unicase.analyzer.iterator.TimeIterator;
import org.unicase.analyzer.unicaseAnalyzers.DateWriter;
import org.unicase.analyzer.unicaseAnalyzers.VersionWriter;
import org.unicase.emfstore.esmodel.ProjectInfo;
import org.unicase.workspace.Usersession;
import org.unicase.workspace.WorkspaceManager;
import org.unicase.workspace.connectionmanager.ConnectionManager;
import org.unicase.workspace.test.SetupHelper;
import org.unicase.workspace.test.TestProjectEnum;

/**
 * Application used for directly starting the evaluation.
 * 
 * @author Henning Femmer
 */
public class EvaluationApplication implements IApplication {

	// BEGIN SUPRESS CATCH EXCEPTION
	/**
	 * {@inheritDoc}
	 * 
	 * @throws Exception exception
	 * @see org.eclipse.equinox.app.IApplication#start(org.eclipse.equinox.app.IApplicationContext)
	 */
	public Object start(IApplicationContext context) throws Exception {
		System.out.println("Starting app.");
		SetupHelper setupHelper = new SetupHelper(TestProjectEnum.NONE);
		setupHelper.loginServer();
		Usersession userSession = setupHelper.getUsersession();
		ConnectionManager connectionManager = WorkspaceManager.getInstance().getConnectionManager();

		List<ProjectInfo> projectList = connectionManager.getProjectList(userSession.getSessionId());
		ProjectInfo projectInfo = projectList.get(0);

		int stepLength = 1;
		TimeIterator projectIt = IteratorFactory.eINSTANCE.createTimeIterator();
		CSVExporter exporter = ExportersFactory.eINSTANCE.createCSVExporter();

		String location = "/Users/henning/Documents/workspace/BachelorArbeit/Quellen/Statistics/unicase/First Tries/";
		String filename = "automated.csv";
		exporter.init(location + filename, true);
		projectIt.setProjectId(projectInfo.getProjectId());
		projectIt.setStepLength(stepLength);
		projectIt.setStepLengthUnit(Calendar.DATE);

		// go through all revisions
		projectIt.setDefault(true);
		projectIt.setForward(true);
		projectIt.init(userSession);

		ArrayList<DataAnalyzer> analyzers = new ArrayList<DataAnalyzer>();
		analyzers.add(new DateWriter());
		analyzers.add(new VersionWriter());
		analyzers.add(new LinkRecommendationAnalyzer());

		// analyzers.add(new LinkRecommendationAnalyzer());
		@SuppressWarnings("unused")
		AnalyzerModelController anacontrol = new AnalyzerModelController(projectIt, analyzers, exporter);

		return null;
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.equinox.app.IApplication#start(org.eclipse.equinox.app.IApplicationContext)
	 */
	public void stop() {
		// TODO Auto-generated method stub

	}

}
