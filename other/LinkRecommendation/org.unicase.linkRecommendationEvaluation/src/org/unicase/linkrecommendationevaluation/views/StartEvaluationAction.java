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
import org.eclipse.emf.ecore.EClass;
import org.eclipse.jface.action.Action;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.viewers.TableViewer;
import org.unicase.linkrecommendation.linkselection.ConstantThresholdSelection;
import org.unicase.linkrecommendation.linkselection.CutPointSelection;
import org.unicase.linkrecommendation.linkselection.LinkSelectionStrategy;
import org.unicase.linkrecommendation.recommendationStrategies.LSIStrategy;
import org.unicase.linkrecommendation.recommendationStrategies.RecommendationStrategy;
import org.unicase.linkrecommendation.recommendationStrategies.VectorSpaceModelStrategy;
import org.unicase.linkrecommendationevaluation.LinkRecommendationAnalyzer;
import org.unicase.model.Project;
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
	private String[] elements;

	/**
	 * Constructor.
	 * 
	 * @param v the tableView
	 * @param el the possible elements in the tv
	 */
	public StartEvaluationAction(TableViewer v, String[] el) {
		this.viewer = v;
		this.elements = el;
	}

	/**
	 * @see org.eclipse.jface.action.Action#run()
	 */
	@Override
	public void run() {
		ISelection selection = viewer.getSelection();
		Object obj = ((IStructuredSelection) selection).getFirstElement();

		if (obj == elements[0]) {
			EList<ProjectSpace> all = WorkspaceManager.getInstance().getCurrentWorkspace().getProjectSpaces();

			for (ProjectSpace projectSpace : all) {
				boolean stop = false;
				for (String s : elements) {
					if (projectSpace.getProjectName().equals(s)) {
						showMessage("Analyzing " + projectSpace.getProjectName());
						evaluate(projectSpace.getProject());
						stop = true;
						break;
					}
				}
				if (stop) {
					break;
				}
			}
		} else {
			showMessage("Double-click detected on " + obj.toString());
		}
	}

	private void evaluate(Project project) {
		LinkRecommendationAnalyzer an = new LinkRecommendationAnalyzer();

		// FIRST standard: ActionItems -> Functional Requirements
		an.setSelectionStrategies(new LinkSelectionStrategy[] { new ConstantThresholdSelection(0.1),
			new ConstantThresholdSelection(0.35), new ConstantThresholdSelection(0.5), new CutPointSelection(5),
			new CutPointSelection(10) });

		an.setRecommendationStrategies(new RecommendationStrategy[] { new VectorSpaceModelStrategy(),
			new LSIStrategy(0.5), new LSIStrategy(0.9) });

		an.initializeVariables();
		List<String> headline = an.getName();
		List<Object> results = new ArrayList<Object>();
		an.analyzeEntireProject(project, results);
		an.addResults(results);

		String location = "/Users/henning/Documents/workspace/BachelorArbeit/Quellen/Statistics/Entire Project Scan/";
		String filename = "LSI_VSM.csv";

		printToCSVFile(headline, results, location, filename);

		// Now: FR -> UseCase
		an.initializeVariables();

		ArrayList<EClass> relevantBaseClasses = new ArrayList<EClass>();
		relevantBaseClasses.add(RequirementPackage.eINSTANCE.getFunctionalRequirement());
		an.setRelevantBaseClasses(relevantBaseClasses);

		ArrayList<EClass> relevantTargetClasses = new ArrayList<EClass>();
		relevantBaseClasses.add(RequirementPackage.eINSTANCE.getUseCase());
		an.setRelevantTargetClasses(relevantTargetClasses);

		results = new ArrayList<Object>();
		an.analyzeEntireProject(project, results);
		an.addResults(results);

		printToCSVFile(headline, results, location, filename);

		System.out.println("Finished.");
	}

	private void printToCSVFile(List<String> headline, List<Object> results, String location, String filename) {
		try {
			FileOutputStream fop = new FileOutputStream(location + filename, true);
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
