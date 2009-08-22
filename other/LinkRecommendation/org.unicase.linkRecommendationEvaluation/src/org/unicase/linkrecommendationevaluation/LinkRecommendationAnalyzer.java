/**
 * <copyright> Copyright (c) 2008-2009 Jonas Helming, Maximilian Koegel. All rights reserved. This program and the
 * accompanying materials are made available under the terms of the Eclipse Public License v1.0 which accompanies this
 * distribution, and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>
 */
package org.unicase.linkrecommendationevaluation;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.Map;

import org.eclipse.emf.common.util.BasicEList;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.unicase.analyzer.DataAnalyzer;
import org.unicase.analyzer.ProjectAnalysisData;
import org.unicase.emfstore.esmodel.versioning.ChangePackage;
import org.unicase.emfstore.esmodel.versioning.operations.AbstractOperation;
import org.unicase.emfstore.esmodel.versioning.operations.MultiReferenceOperation;
import org.unicase.emfstore.esmodel.versioning.operations.ReferenceOperation;
import org.unicase.emfstore.esmodel.versioning.operations.SingleReferenceOperation;
import org.unicase.linkrecommendation.linkselection.ConstantThresholdSelection;
import org.unicase.linkrecommendation.linkselection.CutPointSelection;
import org.unicase.linkrecommendation.linkselection.LinkSelectionStrategy;
import org.unicase.linkrecommendation.recommendationStrategies.RecommendationStrategy;
import org.unicase.linkrecommendation.recommendationStrategies.updateableStrategies.ARMStrategy;
import org.unicase.linkrecommendation.recommendationStrategies.updateableStrategies.Updateable;
import org.unicase.model.ModelElement;
import org.unicase.model.ModelElementId;
import org.unicase.model.ModelPackage;
import org.unicase.model.Project;
import org.unicase.model.requirement.RequirementPackage;
import org.unicase.model.task.TaskPackage;

/**
 * This class represents an analyzer made for comparing different versions of link recommendation.
 * 
 * @author Henning Femmer
 */
public class LinkRecommendationAnalyzer implements DataAnalyzer {

	private List<EClass> relevantReferences;
	private List<EClass> relevantBaseClasses;
	private List<EClass> relevantTargetClasses;

	private int[][] suggestedElements;
	private int correctElements;
	private double[][] foundAndRec;
	private int[][] hits;
	private int countSuggestions;
	private int sumPositions;

	private RecommendationStrategy[] recommendationStrategies;
	private LinkSelectionStrategy[] selectionStrategies;

	/**
	 * Defines different states of output.
	 * 
	 * @author Henning Femmer
	 */
	private enum DEBUGMODE {
		ALL, RESULTS, FAILS, APPLY, NOTHING
	}

	private final DEBUGMODE debug = DEBUGMODE.RESULTS;

	private Project clonedProject;

	private final boolean analyseStepByStep = false;

	/**
	 * The constructor.
	 */
	public LinkRecommendationAnalyzer() {
		selectionStrategies = new LinkSelectionStrategy[] { new ConstantThresholdSelection(0.1),
			new ConstantThresholdSelection(0.35), new ConstantThresholdSelection(0.5), new CutPointSelection(5),
			new CutPointSelection(10) };

		// strategies = new RecommendationStrategy[] { new RelatedAssigneesRecommendation() };
		// recommendationStrategies = new RecommendationStrategy[] { new VectorSpaceModelStrategy() };
		recommendationStrategies = new RecommendationStrategy[] { new ARMStrategy() };
		// strategies = new RecommendationStrategy[] { new VectorSpaceModelStrategy(),
		// new SharedReferencesRecommendation(1), new SharedReferencesRecommendation(2),
		// new SharedReferencesRecommendation(3) };
		// strategies = new RecommendationStrategy[] { new LSIStrategy(0.2), new LSIStrategy(0.4), new LSIStrategy(0.6),
		// new LSIStrategy(0.8) };
		// strategies = new RecommendationStrategy[] {
		// new VectorSpaceModelStrategy(),
		// new LSIStrategy(0.9),
		// new RelatedAssigneesRecommendation(),
		// new SharedReferencesRecommendation(2),
		// new ArithmeticMeanCombinationStrategy(new VectorSpaceModelStrategy(), new RelatedAssigneesRecommendation()),
		// new ArithmeticMeanCombinationStrategy(new VectorSpaceModelStrategy(), new SharedReferencesRecommendation(2)),
		// new MaximumCombinationStrategy(new VectorSpaceModelStrategy(), new RelatedAssigneesRecommendation()),
		// new MaximumCombinationStrategy(new VectorSpaceModelStrategy(), new SharedReferencesRecommendation(2)) };

		addRelevants();
	}

	/**
	 * Returns the column names.
	 * 
	 * @return List of column names
	 * @see org.unicase.analyzer.DataAnalyzer#getName()
	 */
	public List<String> getName() {
		List<String> names = new ArrayList<String>();
		names.add("#Elements");

		for (int i = 0; i < recommendationStrategies.length; i++) {
			names.add("Avg Position Recommendation" + recommendationStrategies[i].getName());

			for (int j = 0; j < selectionStrategies.length; j++) {
				names.add("Prec.:" + recommendationStrategies[i].getName() + "[" + selectionStrategies[j].getName()
					+ "]" + " ActionItems -> Functional Requirements");
				names.add("Recl.:" + recommendationStrategies[i].getName() + "[" + selectionStrategies[j].getName()
					+ "]" + " ActionItems -> Functional Requirements");
				// names.add("Hits (Threshold = "+d+")");
				// names.add("Suggestion Cases (Threshold = "+d+")");
				// names.add("Percentage Hits (Threshold = "+d+")");
			}
		}

		return names;
	}

	private void addRelevants() {
		// Have one place where you define all relevant reference for the evaluation
		relevantReferences = new ArrayList<EClass>();
		relevantReferences.add(ModelPackage.eINSTANCE.getAnnotation_AnnotatedModelElements().getEReferenceType());

		relevantBaseClasses = new ArrayList<EClass>();
		relevantBaseClasses.add(TaskPackage.eINSTANCE.getActionItem());

		relevantTargetClasses = new ArrayList<EClass>();
		relevantTargetClasses.add(RequirementPackage.eINSTANCE.getFunctionalRequirement());
	}

	/**
	 * This method is the actually analyzing method.
	 * 
	 * @see org.unicase.analyzer.DataAnalyzer#getValue(org.unicase.analyzer.ProjectAnalysisData)
	 * @param data the project data
	 * @return a list of text elements.
	 */
	public List<Object> getValue(ProjectAnalysisData data) {
		// initialize variables
		List<Object> results = new ArrayList<Object>();
		foundAndRec = new double[selectionStrategies.length][recommendationStrategies.length];
		suggestedElements = new int[selectionStrategies.length][recommendationStrategies.length];
		hits = new int[selectionStrategies.length][recommendationStrategies.length];

		for (int j = 0; j < selectionStrategies.length; j++) {
			Arrays.fill(foundAndRec[j], 0);
			Arrays.fill(suggestedElements[j], 0);
			Arrays.fill(hits[j], 0);
		}

		correctElements = 0;
		countSuggestions = 0;
		sumPositions = 0;

		// Analyze the project
		if (analyseStepByStep) {
			analyseStepByStep(data, results);
		} else {
			analyzeEntireProject(data, results);
		}

		// post-analysation calculation e.g. "training"
		for (RecommendationStrategy recStr : recommendationStrategies) {
			if (recStr instanceof Updateable) {
				Updateable str = (Updateable) recStr;
				str.updateStrategyData(data.getChangePackages());
			}
		}

		// Print the results
		results.add(countSuggestions);
		for (int j = 0; j < recommendationStrategies.length; j++) {
			double avgPos = sumPositions / (double) countSuggestions;
			results.add(avgPos);

			for (int i = 0; i < selectionStrategies.length; i++) {
				double precision = 0, recall = 0;
				if (suggestedElements[i][j] != 0) {
					precision = foundAndRec[i][j] / suggestedElements[i][j];
				}
				if (correctElements != 0) {
					recall = foundAndRec[i][j] / correctElements;
				}
				// double hitPercentage = ((double)hits[i])/((double)suggestionCases);

				results.add(precision);
				results.add(recall);
				// results.add(hits[i]);
				// results.add(suggestionCases);
				// results.add(hitPercentage);
			}
		}

		return results;
	}

	private void analyseStepByStep(ProjectAnalysisData data, List<Object> results) {
		// first step? just fetch the data.
		if (clonedProject == null) {
			clonedProject = (Project) EcoreUtil.copy(data.getProjectState());
			return;
		}

		EList<ChangePackage> changePackages = data.getChangePackages();
		List<AbstractOperation> operations = new ArrayList<AbstractOperation>();

		// Check each change.
		for (ChangePackage changePackage : changePackages) {
			operations.addAll(changePackage.getOperations());
		}

		for (AbstractOperation operation : operations) {
			// The modelElement this is all about
			ModelElement base = clonedProject.getModelElement(operation.getModelElementId());
			// Load the reference.
			EReference eReference = getReference(operation, base);
			// The MEs to be guessed
			Collection<ModelElement> correctMEs = getCorrectMEsFromOperation(operation);

			analyseRecommendation(base, eReference, correctMEs);

			// redraw the changes in the project
			if (operation.canApply(clonedProject)) {
				operation.apply(clonedProject);
				if (debug == DEBUGMODE.APPLY || debug == DEBUGMODE.ALL) {
					System.out.println("Apply: " + operation.getName());
				}
			} else if (debug == DEBUGMODE.APPLY || debug == DEBUGMODE.ALL) {
				System.out.println("Can't apply: " + operation.getName());
			}
		}
	}

	private void analyseRecommendation(ModelElement base, EReference eReference, Collection<ModelElement> correctMEs) {

		if (correctMEs == null || correctMEs.size() <= 0 || base == null || eReference == null
			|| !relevantBaseClasses.contains(base.eClass())
			|| !relevantReferences.contains(eReference.getEReferenceType())) {
			return;
		}

		correctElements += correctMEs.size();

		// get the possible elements
		Collection<ModelElement> candidates = getCandidates(base, eReference);

		// make suggestions
		for (int j = 0; j < recommendationStrategies.length; j++) {
			// the number of suggestions
			countSuggestions++;
			// calculate suggestions
			Map<ModelElement, Double> relevanceMap = recommendationStrategies[j].getMatchingMap(base, candidates);

			// iterate over each filter
			for (int i = 0; i < selectionStrategies.length; i++) {
				// filter which elements are suggested
				Map<ModelElement, Double> suggestionMap = selectionStrategies[i].selectCandidates(relevanceMap);
				// add to statistics
				calcStatistics(base, correctMEs, suggestionMap, i, j);

				// Debug-Output:
				if (debug == DEBUGMODE.RESULTS || debug == DEBUGMODE.ALL) {
					System.out.print("Analyzing: " + base.getName());
					System.out.println(", reference: " + eReference.getName() + " with RecStrategy "
						+ recommendationStrategies[j].getName() + " SelectionStrategy "
						+ selectionStrategies[i].getName());

					for (ModelElement me : correctMEs) {
						System.out.println("# " + me.getName());
					}

					for (ModelElement me : suggestionMap.keySet()) {
						System.out.println("+ " + me.getName() + " - " + suggestionMap.get(me));
					}
				}
			}
		}
	}

	private Collection<ModelElement> getCorrectMEsFromOperation(AbstractOperation operation) {
		Collection<ModelElement> correctMEs = new ArrayList<ModelElement>();

		// Load the MEs which should be guessed
		if (operation instanceof SingleReferenceOperation) {
			SingleReferenceOperation op = (SingleReferenceOperation) operation;
			ModelElement me = clonedProject.getModelElement(op.getNewValue());

			if (me != null && relevantTargetClasses.contains(me.eClass())) {
				correctMEs.add(me);
			}
		} else if (operation instanceof MultiReferenceOperation) {
			MultiReferenceOperation op = (MultiReferenceOperation) operation;
			for (ModelElementId meID : op.getOtherInvolvedModelElements()) {
				ModelElement me = clonedProject.getModelElement(meID);
				if (me != null && relevantTargetClasses.contains(me.eClass())) {
					correctMEs.add(me);
				}
			}
		}
		return correctMEs;
	}

	private EReference getReference(AbstractOperation operation, ModelElement me) {
		if (me == null || operation == null) {
			return null;
		}

		if (operation instanceof ReferenceOperation) {
			String featureName = ((ReferenceOperation) operation).getFeatureName();
			if (featureName == null) {
				return null;
			}

			for (EReference ref : me.eClass().getEAllReferences()) {
				String name = ref.getName();

				if (name != null && name.equals(featureName)) {
					return ref;
				}
			}
		}

		return null;
	}

	/**
	 * Analyzes the entire Project and lists the result in the parameter results. take care: refs is empty...
	 * 
	 * @param data the project
	 * @param results results are printed into this list
	 */
	private void analyzeEntireProject(ProjectAnalysisData data, List<Object> results) {
		Project project = data.getProjectState();
		EList<ModelElement> allModelElements = project.getAllModelElements();

		for (ModelElement modelElement : allModelElements) {
			// only check specified base classes
			EClass eClass = modelElement.eClass();
			if (!relevantBaseClasses.contains(eClass)) {
				continue;
			}

			List<EReference> refs = modelElement.eClass().getEAllReferences();

			for (EReference eReference : refs) {
				// find the proper candidates
				Collection<ModelElement> correctMEs = getCorrectMEs(modelElement, eReference);
				analyseRecommendation(modelElement, eReference, correctMEs);
			}
		}

	}

	private Collection<ModelElement> getCandidates(ModelElement modelElement, EReference eReference) {
		EClass clazz = eReference.getEReferenceType();
		Collection<ModelElement> allCandidates = modelElement.getProject().getAllModelElementsbyClass(clazz,
			new BasicEList<ModelElement>());
		Collection<ModelElement> candidates = new ArrayList<ModelElement>();

		// remove candidates we don't want to check
		// TODO: update: maybe do this after recommendation for better results?
		for (ModelElement me : allCandidates) {
			if (relevantTargetClasses.contains(me.eClass())) {
				candidates.add(me);
			}
		}
		return candidates;
	}

	@SuppressWarnings("unchecked")
	private Collection<ModelElement> getCorrectMEs(ModelElement modelElement, EReference eReference) {
		List<ModelElement> correctMEs = new ArrayList<ModelElement>();

		Object existing = modelElement.eGet(eReference);
		List<ModelElement> allCorrectMEs = new ArrayList<ModelElement>();

		if (existing instanceof EList<?>) {
			EList<ModelElement> eList = (EList<ModelElement>) existing;
			allCorrectMEs.addAll(eList);
		} else if (existing instanceof EObject) {
			ModelElement eObject = (ModelElement) existing;
			allCorrectMEs.add(eObject);
		}

		// remove elements we don't want to check
		for (ModelElement me : allCorrectMEs) {
			if (relevantTargetClasses.contains(me.eClass())) {
				correctMEs.add(me);
			}
		}

		return correctMEs;
	}

	private void calcStatistics(ModelElement me, Collection<ModelElement> correctMEs,
		Map<ModelElement, Double> relevanceMap, int indexSelection, int indexStrategy) {
		boolean hit = false;
		int sug = getNumberSuggestedElements(relevanceMap);
		suggestedElements[indexSelection][indexStrategy] += sug;

		for (ModelElement el : correctMEs) {
			Double val = relevanceMap.get(el);
			if (val != null) {
				foundAndRec[indexSelection][indexStrategy]++;
				hit = true;
			}
		}

		// determine if suggestions have been met
		if (hit) {
			hits[indexSelection][indexStrategy]++;
		} else if ((debug == DEBUGMODE.FAILS || debug == DEBUGMODE.ALL) && indexSelection == 0) {
			// debug:
			System.out.println("* " + recommendationStrategies[indexStrategy].getName() + " FAILS to connect ME \n"
				+ me.getName() + ": " + me.getDescriptionPlainText() + " \n to");

			for (ModelElement correctME : correctMEs) {
				System.out.println("- Name: " + correctME.getName() + ": " + correctME.getDescriptionPlainText());
			}
		}
	}

	/**
	 * @param relevanceMap
	 * @return
	 */
	private int getNumberSuggestedElements(Map<ModelElement, Double> relevanceMap) {
		return relevanceMap.size();
	}

	/**
	 * @return false
	 */
	public boolean isExportOnce() {
		return false;
	}
}
