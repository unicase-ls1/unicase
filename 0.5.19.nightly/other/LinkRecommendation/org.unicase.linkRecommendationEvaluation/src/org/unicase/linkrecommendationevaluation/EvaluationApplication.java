/**
 * <copyright> Copyright (c) 2008-2009 Jonas Helming, Maximilian Koegel. All rights reserved. This program and the
 * accompanying materials are made available under the terms of the Eclipse Public License v1.0 which accompanies this
 * distribution, and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>
 */
package org.unicase.linkrecommendationevaluation;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import org.eclipse.equinox.app.IApplication;
import org.eclipse.equinox.app.IApplicationContext;
import org.unicase.analyzer.AnalyzerModelController;
import org.unicase.analyzer.DataAnalyzer;
import org.unicase.analyzer.exceptions.IteratorException;
import org.unicase.analyzer.exporters.CSVExporter;
import org.unicase.analyzer.exporters.ExportersFactory;
import org.unicase.analyzer.iterator.IteratorFactory;
import org.unicase.analyzer.iterator.TimeIterator;
import org.unicase.analyzer.iterator.VersionIterator;
import org.unicase.analyzer.unicaseAnalyzers.DateWriter;
import org.unicase.analyzer.unicaseAnalyzers.VersionWriter;
import org.unicase.emfstore.esmodel.ProjectInfo;
import org.unicase.linkrecommendation.recommendationStrategies.SharedReferencesRecommendation;
import org.unicase.linkrecommendation.recommendationStrategies.VectorSpaceModelStrategy;
import org.unicase.linkrecommendation.recommendationStrategies.combinedStrategies.FactorCombinationStrategy;
import org.unicase.linkrecommendation.recommendationStrategies.updateableStrategies.ARMStrategy;
import org.unicase.metamodel.recommendation.ConstantThresholdSelection;
import org.unicase.metamodel.recommendation.CutPointSelection;
import org.unicase.metamodel.recommendation.LinkSelectionStrategy;
import org.unicase.metamodel.recommendation.RecommendationStrategy;
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

	@SuppressWarnings("unused")
	private AnalyzerModelController anacontrol;

	// BEGIN SUPRESS CATCH EXCEPTION
	/**
	 * {@inheritDoc}
	 * 
	 * @throws Exception exception
	 * @see org.eclipse.equinox.app.IApplication#start(org.eclipse.equinox.app.IApplicationContext)
	 */
	public Object start(IApplicationContext context) throws Exception {
		System.out.println("Starting Standard case.");
		SetupHelper setupHelper = new SetupHelper(TestProjectEnum.NONE);
		setupHelper.loginServer();
		Usersession userSession = setupHelper.getUsersession();
		ConnectionManager connectionManager = WorkspaceManager.getInstance().getConnectionManager();

		List<ProjectInfo> projectList = connectionManager.getProjectList(userSession.getSessionId());
		ProjectInfo projectInfo = projectList.get(0);

		VersionIterator projectIt = this.getIterator(userSession, projectInfo);
		CSVExporter exporter = getExporter();

		ArrayList<DataAnalyzer> analyzers = new ArrayList<DataAnalyzer>();
		LinkRecommendationAnalyzer lrAnalyser = new LinkRecommendationAnalyzer();
		lrAnalyser.setToActionItemToFuncReqAnalysis();
		lrAnalyser.setSelectionStrategies(new LinkSelectionStrategy[] { new ConstantThresholdSelection(0.1),
			new ConstantThresholdSelection(0.35), new ConstantThresholdSelection(0.5), new CutPointSelection(5),
			new CutPointSelection(10) });

		lrAnalyser
			.setRecommendationStrategies(new RecommendationStrategy[] {
				new VectorSpaceModelStrategy(),
				new ARMStrategy(),
				new FactorCombinationStrategy(new VectorSpaceModelStrategy(), new SharedReferencesRecommendation(50),
					0.5) });

		analyzers.add(new VersionWriter());
		analyzers.add(new DateWriter());
		analyzers.add(lrAnalyser);

		// first the standard case:
		anacontrol = new AnalyzerModelController(projectIt, analyzers, exporter);

		// // now FuncReq -> UseCase
		System.out.println("Starting next");
		projectIt = getIterator(userSession, projectInfo);
		exporter = getExporter();
		lrAnalyser.setToActionItemToFuncReqAnalysis();
		anacontrol = new AnalyzerModelController(projectIt, analyzers, exporter);

		// now FuncReq -> UseCase
		System.out.println("Starting next");
		projectIt = getIterator(userSession, projectInfo);
		exporter = getExporter();
		lrAnalyser.setToFuncReqToUseCaseAnalysis();
		anacontrol = new AnalyzerModelController(projectIt, analyzers, exporter);

		// now FuncReq -> UseCase
		System.out.println("Starting next");
		projectIt = getIterator(userSession, projectInfo);
		exporter = getExporter();
		lrAnalyser.setToUseCaseToFuncReqAnalysis();
		anacontrol = new AnalyzerModelController(projectIt, analyzers, exporter);

		return null;
	}

	/**
	 * @return
	 * @throws IOException
	 */
	private CSVExporter getExporter() throws IOException {
		CSVExporter exporter = ExportersFactory.eINSTANCE.createCSVExporter();
		String location = "/Users/henning/Documents/workspace/BachelorArbeit/Quellen/Statistics/paper/";
		String filename = "overTime_srr_raw_unicase.csv";
		exporter.init(location + filename, false);
		return exporter;
	}

	/**
	 * @param userSession
	 * @param projectInfo
	 * @return
	 * @throws IteratorException
	 */
	private VersionIterator getIterator(Usersession userSession, ProjectInfo projectInfo) throws IteratorException {
		TimeIterator projectIt;
		projectIt = IteratorFactory.eINSTANCE.createTimeIterator();
		projectIt.setProjectId(projectInfo.getProjectId());
		projectIt.setStepLength(21);
		projectIt.setStepLengthUnit(Calendar.DATE);

		// go through all revisions
		projectIt.setDefault(true);
		projectIt.setForward(true);
		projectIt.init(userSession);
		return projectIt;
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
