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
import java.util.Set;

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
import org.unicase.linkrecommendation.recommendationStrategies.RecommendationStrategy;
import org.unicase.linkrecommendation.recommendationStrategies.RelatedAssigneesRecommendation;
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

	private Double[] thresholds;
	private int[][] suggestedElements;
	private int correctElements;
	private double[][] foundAndRec;
	private int[][] hits;
	private int countSuggestions;
	private int step;

	private RecommendationStrategy[] strategies;

	/**
	 * Defines different states of output.
	 * 
	 * @author Henning Femmer
	 */
	private enum DEBUGMODE {
		ALL, RESULTS, FAILS, APPLY, NOTHING
	}

	private final DEBUGMODE debug = DEBUGMODE.NOTHING;

	private Project clonedProject;

	private final boolean analyseStepByStep = true;

	/**
	 * The constructor.
	 */
	public LinkRecommendationAnalyzer() {
		step = 0;

		thresholds = new Double[] { 0.1, 0.35, 0.7 };
		// thresholds = new Double[] { 0.35 };

		strategies = new RecommendationStrategy[] { new RelatedAssigneesRecommendation() };
		// strategies = new RecommendationStrategy[] { new VectorSpaceModelStrategy() };
		// strategies = new RecommendationStrategy[] { new VectorSpaceModelStrategy(),
		// new SharedReferencesRecommendation(1), new SharedReferencesRecommendation(2),
		// new SharedReferencesRecommendation(3) };
		// strategies = new RecommendationStrategy[] { new LSIStrategy(0.2), new LSIStrategy(0.4), new LSIStrategy(0.6),
		// new LSIStrategy(0.8) };
		// strategies = new RecommendationStrategy[] { new VectorSpaceModelStrategy(), new LSIStrategy(0.9),
		// new RelatedAssigneesRecommendation(), new SharedReferencesRecommendation(2) };

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
		names.add("Step");
		names.add("#Elements");

		for (int i = 0; i < strategies.length; i++) {
			for (int j = 0; j < thresholds.length; j++) {
				names.add("Prec.:" + strategies[i].getName() + " T=" + thresholds[j]
					+ " ActionItems -> Functional Requirements");
				names.add("Recl.:" + strategies[i].getName() + " T=" + thresholds[j]
					+ " ActionItems -> Functional Requirements");
				// names.add("Hits (Threshold = "+d+")");
				// names.add("Suggestion Cases (Threshold = "+d+")");
				// names.add("Percentage Hits (Threshold = "+d+")");
			}
		}

		// names.add("Approach1RecallLinkTypeB");
		// Build based on relevant links and approaches
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

		List<Object> results = new ArrayList<Object>();
		results.add(step);
		step++;

		initializeVariables();

		if (analyseStepByStep) {
			analyseStepByStep(data, results);
		} else {
			analyzeEntireProject(data, results);
		}

		results.add(countSuggestions);
		for (int j = 0; j < strategies.length; j++) {
			for (int i = 0; i < thresholds.length; i++) {
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
		for (int j = 0; j < strategies.length; j++) {
			Map<ModelElement, Double> relevanceMap = strategies[j].getMatchingMap(base, candidates);

			// add to statistics
			countSuggestions++;
			for (int i = 0; i < thresholds.length; i++) {
				calcStatistics(base, correctMEs, relevanceMap, i, j);
			}

			// Debug-Output:
			if (debug == DEBUGMODE.RESULTS || debug == DEBUGMODE.ALL) {
				printDebugOutput(base, eReference, correctMEs, relevanceMap);
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

		initializeVariables();

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

	private void printDebugOutput(ModelElement modelElement, EReference eReference,
		Collection<ModelElement> correctMEs, Map<ModelElement, Double> relevanceMap) {
		System.out.print("Analyzing: " + modelElement.getName());
		System.out.println(", reference: " + eReference.getName());
		for (ModelElement me : correctMEs) {
			System.out.println("# Name: " + me.getName());
		}
		for (int i = 0; i < thresholds.length; i++) {
			printSuggestedElements(relevanceMap, thresholds[i]);
		}
	}

	private void initializeVariables() {
		foundAndRec = new double[thresholds.length][strategies.length];
		suggestedElements = new int[thresholds.length][strategies.length];
		hits = new int[thresholds.length][strategies.length];

		for (int j = 0; j < thresholds.length; j++) {
			Arrays.fill(foundAndRec[j], 0);
			Arrays.fill(suggestedElements[j], 0);
			Arrays.fill(hits[j], 0);
		}

		correctElements = 0;
		countSuggestions = 0;
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
		Map<ModelElement, Double> relevanceMap, int indexThreshold, int indexStrategy) {
		boolean hit = false;
		int sug = getNumberSuggestedElements(relevanceMap, thresholds[indexThreshold]);
		suggestedElements[indexThreshold][indexStrategy] += sug;

		for (ModelElement el : correctMEs) {
			Double val = relevanceMap.get(el);
			if (val != null && val >= thresholds[indexThreshold]) {
				foundAndRec[indexThreshold][indexStrategy]++;
				hit = true;
			}
		}

		// determine if suggestions have been met
		if (hit) {
			hits[indexThreshold][indexStrategy]++;
		} else if ((debug == DEBUGMODE.FAILS || debug == DEBUGMODE.ALL) && indexThreshold == 0) {
			// debug:
			System.out.println("* " + strategies[indexStrategy].getName() + " FAILS to connect ME \n" + me.getName()
				+ ": " + me.getDescriptionPlainText() + " \n to");

			for (ModelElement correctME : correctMEs) {
				System.out.println("- Name: " + correctME.getName() + ": " + correctME.getDescriptionPlainText());
			}
		}
	}

	/**
	 * @param relevanceMap
	 * @return
	 */
	private int getNumberSuggestedElements(Map<ModelElement, Double> relevanceMap, double threshold) {
		int relevanceMapSuggestedNumbers = 0;
		for (Double val : relevanceMap.values()) {
			if (val > threshold) {
				relevanceMapSuggestedNumbers++;
			}
		}
		return relevanceMapSuggestedNumbers;
	}

	private void printSuggestedElements(Map<ModelElement, Double> relevanceMap, double threshold) {
		Set<ModelElement> mes = relevanceMap.keySet();

		for (ModelElement me : mes) {
			if (relevanceMap.get(me) > threshold) {
				System.out.println("+ " + me.getName() + " - " + relevanceMap.get(me));
			}
		}
	}

	/**
	 * @return false
	 */
	public boolean isExportOnce() {
		return false;
	}
}
