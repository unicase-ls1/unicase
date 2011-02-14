/**
 * <copyright> Copyright (c) 2008-2009 Jonas Helming, Maximilian Koegel. All rights reserved. This program and the
 * accompanying materials are made available under the terms of the Eclipse Public License v1.0 which accompanies this
 * distribution, and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>
 */
package org.unicase.linkrecommendationevaluation.views;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import org.eclipse.emf.common.util.EList;
import org.eclipse.jface.action.Action;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.viewers.TableViewer;
import org.unicase.linkrecommendation.recommendationStrategies.SharedReferencesRecommendation;
import org.unicase.linkrecommendation.recommendationStrategies.VectorSpaceModelStrategy;
import org.unicase.linkrecommendation.recommendationStrategies.combinedStrategies.FactorCombinationStrategy;
import org.unicase.linkrecommendationevaluation.LinkRecommendationAnalyzer;
import org.unicase.metamodel.Project;
import org.unicase.metamodel.recommendation.CutPointSelection;
import org.unicase.metamodel.recommendation.LinkSelectionStrategy;
import org.unicase.metamodel.recommendation.RecommendationStrategy;
import org.unicase.model.ModelPackage;
import org.unicase.model.requirement.RequirementPackage;
import org.unicase.workspace.ProjectSpace;
import org.unicase.workspace.WorkspaceManager;

/**
 * This class represents the actions for evaluation.
 * 
 * @author Henning Femmer
 */
public class StartEvaluationAction extends Action {
	private TableViewer viewer;

	/**
	 * Constructor.
	 * 
	 * @param v the tableView
	 */
	public StartEvaluationAction(TableViewer v) {
		this.viewer = v;
	}

	/**
	 * @see org.eclipse.jface.action.Action#run()
	 */
	@Override
	public void run() {
		ISelection selection = viewer.getSelection();
		Object obj = ((IStructuredSelection) selection).getFirstElement();

		EList<ProjectSpace> all = WorkspaceManager.getInstance().getCurrentWorkspace().getProjectSpaces();

		for (ProjectSpace projectSpace : all) {
			boolean stop = false;
			if (projectSpace.getProjectName().equals(obj)) {
				showMessage("Analyzing " + projectSpace.getProjectName());
				evaluate(projectSpace);
				stop = true;
				break;
			}
			if (stop) {
				break;
			}
		}
	}

	private void evaluate(ProjectSpace projectSpace) {
		Project project = projectSpace.getProject();
		LinkRecommendationAnalyzer an = new LinkRecommendationAnalyzer();
		an.setToUseCaseToFuncReqAnalysis();
		// an.setToFuncRexqToUseCaseAnalysis();
		VectorSpaceModelStrategy vsm = new VectorSpaceModelStrategy();

		// // FIRST standard: ActionItems -> Functional Requirements
		// an.setSelectionStrategies(new LinkSelectionStrategy[] { new ConstantThresholdSelection(0.1),
		// new ConstantThresholdSelection(0.35), new ConstantThresholdSelection(0.5), new CutPointSelection(5),
		// new CutPointSelection(10) });

		an.setSelectionStrategies(new LinkSelectionStrategy[] { new CutPointSelection(10) });
		an.setRecommendationStrategies(new RecommendationStrategy[] { new FactorCombinationStrategy(vsm,
			new SharedReferencesRecommendation(50, RequirementPackage.eINSTANCE.getUseCase_FunctionalRequirements()),
			0.5) });

		// an.setRecommendationStrategies(new RecommendationStrategy[] {
		// new SharedReferencesRecommendation(2, RequirementPackage.eINSTANCE.getFunctionalRequirement_UseCases()),
		// new SharedReferencesRecommendation(3, RequirementPackage.eINSTANCE.getFunctionalRequirement_UseCases()),
		// new SharedReferencesRecommendation(4, RequirementPackage.eINSTANCE.getFunctionalRequirement_UseCases()),
		// new SharedReferencesRecommendation(5, RequirementPackage.eINSTANCE.getFunctionalRequirement_UseCases()), });
		// an.setRecommendationStrategies(new RecommendationStrategy[] {
		// vsm,
		// new FactorCombinationStrategy(vsm, new SharedReferencesRecommendation(true, 50, ModelPackage.eINSTANCE
		// .getAnnotation_AnnotatedModelElements()), 0.5),
		// new FactorCombinationStrategy(vsm, new RelatedAssigneesRecommendation(true), 0.5) });
		// an.setRecommendationStrategies(new RecommendationStrategy[] { vsm,
		// new FactorCombinationStrategy(vsm, new RelatedAssigneesRecommendation(true), 0.1),
		// new FactorCombinationStrategy(vsm, new RelatedAssigneesRecommendation(true), 0.35),
		// new FactorCombinationStrategy(vsm, new RelatedAssigneesRecommendation(true), 0.5),
		// new FactorCombinationStrategy(vsm, new RelatedAssigneesRecommendation(true), 0.75) });
		// new FactorCombinationStrategy(vsm, new SharedReferencesRecommendation(true, 50, ModelPackage.eINSTANCE
		// .getAnnotation_AnnotatedModelElements()), 0.35),
		// new FactorCombinationStrategy(vsm, new SharedReferencesRecommendation(true, 50, ModelPackage.eINSTANCE
		// .getAnnotation_AnnotatedModelElements()), 0.5),
		// new FactorCombinationStrategy(vsm, new SharedReferencesRecommendation(true, 50, ModelPackage.eINSTANCE
		// .getAnnotation_AnnotatedModelElements()), 0.75) });

		// an.setRecommendationStrategies(new RecommendationStrategy[] { vsm, new LSIStrategy(0.9), new
		// LSIStrategy(0.75),
		// new LSIStrategy(0.25) });

		// an.setRecommendationStrategies(new RecommendationStrategy[] {
		// new SharedReferencesRecommendation(1, ModelPackage.eINSTANCE.getAnnotation_AnnotatedModelElements()),
		// new SharedReferencesRecommendation(2, ModelPackage.eINSTANCE.getAnnotation_AnnotatedModelElements()),
		// new SharedReferencesRecommendation(3, ModelPackage.eINSTANCE.getAnnotation_AnnotatedModelElements()) });
		// an.setRecommendationStrategies(new RecommendationStrategy[] {
		// new ArithmeticMeanCombinationStrategy(new VectorSpaceModelStrategy(), new SharedReferencesRecommendation(1,
		// ModelPackage.eINSTANCE.getAnnotation_AnnotatedModelElements())),
		// new ArithmeticMeanCombinationStrategy(new VectorSpaceModelStrategy(), new SharedReferencesRecommendation(3,
		// ModelPackage.eINSTANCE.getAnnotation_AnnotatedModelElements())),
		// new ArithmeticMeanCombinationStrategy(new LSIStrategy(0.9), new SharedReferencesRecommendation(1,
		// RequirementPackage.eINSTANCE.getFunctionalRequirement_UseCases())),
		// new ArithmeticMeanCombinationStrategy(new LSIStrategy(0.9), new SharedReferencesRecommendation(3,
		// ModelPackage.eINSTANCE.getAnnotation_AnnotatedModelElements())) });

		an.initializeVariables();
		List<String> headline = an.getName();
		List<Object> results = new ArrayList<Object>();
		an.analyzeEntireProject(project);
		an.addResults(results);

		String location = "/Users/henning/Documents/workspace/BachelorArbeit/Quellen/Statistics/unicase/Entire Project Scan/";
		String filename = "srr_vsm.csv";

		printToCSVFile(headline, results, location + filename);

		// Now: FR -> UseCase
		an.initializeVariables();
		an.setToFuncReqToUseCaseAnalysis();
		an.setRecommendationStrategies(new RecommendationStrategy[] { new FactorCombinationStrategy(vsm,
			new SharedReferencesRecommendation(50, RequirementPackage.eINSTANCE.getFunctionalRequirement_UseCases()),
			0.5) });
		// an.setToUseCaseToFuncReqAnalysis();
		// an.setToFuncReqToActionItem();

		// an.setRecommendationStrategies(new RecommendationStrategy[] {
		// new MaximumCombinationStrategy(vsm, new SharedReferencesRecommendation(true, 50, ModelPackage.eINSTANCE
		// .getModelElement_Annotations())),
		// new MaximumCombinationStrategy(vsm, new RelatedAssigneesRecommendation(true)) });

		// an.setRecommendationStrategies(new RecommendationStrategy[] {
		// new SharedReferencesRecommendation(true, 10, ModelPackage.eINSTANCE.getModelElement_Annotations()),
		// new SharedReferencesRecommendation(true, 25, ModelPackage.eINSTANCE.getModelElement_Annotations()),
		// new SharedReferencesRecommendation(true, 50, ModelPackage.eINSTANCE.getModelElement_Annotations()),
		// new SharedReferencesRecommendation(true, 75, ModelPackage.eINSTANCE.getModelElement_Annotations()) });

		results = new ArrayList<Object>();
		an.analyzeEntireProject(project);
		an.addResults(results);

		printToCSVFile(headline, results, location + filename);

		// 
		an.initializeVariables();
		an.setToActionItemToFuncReqAnalysis();
		an
			.setRecommendationStrategies(new RecommendationStrategy[] { new FactorCombinationStrategy(vsm,
				new SharedReferencesRecommendation(50, ModelPackage.eINSTANCE.getAnnotation_AnnotatedModelElements()),
				0.5) });

		results = new ArrayList<Object>();
		an.analyzeEntireProject(project);
		an.addResults(results);

		printToCSVFile(headline, results, location + filename);

		System.out.println("Finished.");

		// 
		an.initializeVariables();
		an.setToFuncReqToActionItem();
		an
			.setRecommendationStrategies(new RecommendationStrategy[] { new FactorCombinationStrategy(vsm,
				new SharedReferencesRecommendation(50, ModelPackage.eINSTANCE.getUnicaseModelElement_Annotations()),
				0.5) });

		results = new ArrayList<Object>();
		an.analyzeEntireProject(project);
		an.addResults(results);

		printToCSVFile(headline, results, location + filename);

		System.out.println("Finished.");

	}

	private void printToCSVFile(List<String> headline, List<Object> results, String file) {
		try {
			FileOutputStream fop = new FileOutputStream(file, true);
			PrintWriter wrt = new PrintWriter(fop);
			wrt.println();
			// headlines
			for (String s : headline) {
				wrt.print(s + ",");
			}
			wrt.println();

			// data
			for (Object o : results) {
				wrt.print(o + ",");
			}

			wrt.flush();
			wrt.close();
		} catch (IOException e) {
			System.out.println("Exception: " + e.getLocalizedMessage());
		}
	}

	private void showMessage(String message) {
		MessageDialog.openInformation(viewer.getControl().getShell(), "Evaluation View", message);
	}

}
