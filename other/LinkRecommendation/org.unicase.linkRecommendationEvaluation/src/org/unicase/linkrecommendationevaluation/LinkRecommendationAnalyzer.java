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
import org.unicase.linkrecommendation.recommendationStrategies.VectorSpaceModelStrategy;
import org.unicase.linkrecommendation.recommendationStrategies.updateableStrategies.Updateable;
import org.unicase.metamodel.ModelElement;
import org.unicase.metamodel.ModelElementId;
import org.unicase.metamodel.Project;
import org.unicase.metamodel.recommendation.ConstantThresholdSelection;
import org.unicase.metamodel.recommendation.CutPointSelection;
import org.unicase.metamodel.recommendation.LinkSelectionStrategy;
import org.unicase.metamodel.recommendation.RecommendationStrategy;
import org.unicase.model.ModelPackage;
import org.unicase.model.UnicaseModelElement;
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
	private int countElements;
	private int[][] sumPositions;
	private int[][] countNonZeroSuggestions;

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

	private static final DEBUGMODE DEBUG = DEBUGMODE.RESULTS;

	private Project clonedProject;

	private static final boolean ANALYSE_STEP_BY_STEP = true;

	private static final boolean RAW_DATA_OUTPUT = true;

	/**
	 * The constructor.
	 */
	public LinkRecommendationAnalyzer() {
		selectionStrategies = new LinkSelectionStrategy[] { new ConstantThresholdSelection(0.1),
			new ConstantThresholdSelection(0.35), new ConstantThresholdSelection(0.5), new CutPointSelection(5),
			new CutPointSelection(10) };

		// selectionStrategies = new LinkSelectionStrategy[] {};
		// recommendationStrategies = new RecommendationStrategy[] { new RelatedAssigneesRecommendation() };
		recommendationStrategies = new RecommendationStrategy[] { new VectorSpaceModelStrategy() };
		// recommendationStrategies = new RecommendationStrategy[] { new ARMStrategy() };
		// recommendationStrategies = new RecommendationStrategy[] { new VectorSpaceModelStrategy(),
		// new SharedReferencesRecommendation(1), new SharedReferencesRecommendation(2),
		// new SharedReferencesRecommendation(3) };
		// recommendationStrategies = new RecommendationStrategy[] { new LSIStrategy(0.2), new LSIStrategy(0.4), new
		// LSIStrategy(0.6),
		// new LSIStrategy(0.8) };
		// recommendationStrategies = new RecommendationStrategy[] {
		// new VectorSpaceModelStrategy(),
		// new LSIStrategy(0.9),
		// new RelatedAssigneesRecommendation(),
		// new SharedReferencesRecommendation(2),
		// new ArithmeticMeanCombinationStrategy(new VectorSpaceModelStrategy(), new RelatedAssigneesRecommendation()),
		// new ArithmeticMeanCombinationStrategy(new VectorSpaceModelStrategy(), new SharedReferencesRecommendation(2)),
		// new MaximumCombinationStrategy(new VectorSpaceModelStrategy(), new RelatedAssigneesRecommendation()),
		// new MaximumCombinationStrategy(new VectorSpaceModelStrategy(), new SharedReferencesRecommendation(2)) };

		setToActionItemToFuncReqAnalysis();
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
		names.add("#Correct Elements");

		for (int i = 0; i < recommendationStrategies.length; i++) {

			for (int j = 0; j < selectionStrategies.length; j++) {

				if (RAW_DATA_OUTPUT) {
					names.add("Sum Positions" + recommendationStrategies[i].getName() + "["
						+ selectionStrategies[j].getName() + "]");
					names.add("CorrectAndRecommended:" + recommendationStrategies[i].getName() + "["
						+ selectionStrategies[j].getName() + "]");
					names.add("NumberSuggested:" + recommendationStrategies[i].getName() + "["
						+ selectionStrategies[j].getName() + "]");
				} else {
					names.add("AvgPos:" + recommendationStrategies[i].getName() + "["
						+ selectionStrategies[j].getName() + "]");
					names.add("Prec.:" + recommendationStrategies[i].getName() + "[" + selectionStrategies[j].getName()
						+ "]");
					names.add("Recl.:" + recommendationStrategies[i].getName() + "[" + selectionStrategies[j].getName()
						+ "]");
				}
				// names.add("Hits (Threshold = "+d+")");
				// names.add("Suggestion Cases (Threshold = "+d+")");
				// names.add("Percentage Hits (Threshold = "+d+")");
			}
		}

		return names;
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
		initializeVariables();

		// Analyze the project
		if (ANALYSE_STEP_BY_STEP) {
			analyseStepByStep(data);
		} else {
			analyzeEntireProject(data.getProjectState());
		}

		// post-analysation calculation e.g. "training"
		// updateStrategies(data);

		// Add the results
		addResults(results);

		return results;
	}

	/**
	 * Calculates things like precision etc and adds the results to the given object.
	 * 
	 * @param results the result object
	 */
	public void addResults(List<Object> results) {
		results.add(countElements);
		results.add(correctElements);

		for (int j = 0; j < recommendationStrategies.length; j++) {
			for (int i = 0; i < selectionStrategies.length; i++) {

				if (RAW_DATA_OUTPUT) {
					results.add(sumPositions[i][j]);
					results.add(foundAndRec[i][j]);
					results.add(suggestedElements[i][j]);
				} else {
					double precision = 0, recall = 0;
					double avgPos = 0;

					if (countNonZeroSuggestions[i][j] != 0) {
						avgPos = sumPositions[i][j] / (double) countNonZeroSuggestions[i][j];
					}
					if (suggestedElements[i][j] != 0) {
						precision = foundAndRec[i][j] / suggestedElements[i][j];
					}
					if (correctElements != 0) {
						recall = foundAndRec[i][j] / correctElements;
					}

					results.add(avgPos);
					results.add(precision);
					results.add(recall);

				}

				// double hitPercentage = ((double)hits[i])/((double)suggestionCases);

				// results.add(hits[i]);
				// results.add(suggestionCases);
				// results.add(hitPercentage);
			}
		}
	}

	@SuppressWarnings("unused")
	private void updateStrategies(ProjectAnalysisData data) {
		for (RecommendationStrategy recStr : recommendationStrategies) {
			if (recStr instanceof Updateable) {
				Updateable str = (Updateable) recStr;
				for (ChangePackage cp : data.getChangePackages()) {
					str.updateStrategyData(cp);
				}
			}
		}
	}

	private void updateStrategies(ChangePackage cp) {
		for (RecommendationStrategy recStr : recommendationStrategies) {
			if (recStr instanceof Updateable) {
				Updateable str = (Updateable) recStr;
				str.updateStrategyData(cp);
			}
		}
	}

	/**
	 * Initializes the variables.
	 */
	public void initializeVariables() {
		foundAndRec = new double[selectionStrategies.length][recommendationStrategies.length];
		suggestedElements = new int[selectionStrategies.length][recommendationStrategies.length];
		hits = new int[selectionStrategies.length][recommendationStrategies.length];
		countNonZeroSuggestions = new int[selectionStrategies.length][recommendationStrategies.length];
		sumPositions = new int[selectionStrategies.length][recommendationStrategies.length];

		for (int j = 0; j < selectionStrategies.length; j++) {
			Arrays.fill(foundAndRec[j], 0);
			Arrays.fill(suggestedElements[j], 0);
			Arrays.fill(hits[j], 0);
			Arrays.fill(countNonZeroSuggestions[j], 0);
			Arrays.fill(sumPositions[j], 0);
		}

		correctElements = 0;
		countElements = 0;
	}

	private void analyseStepByStep(ProjectAnalysisData data) {
		// first step? just fetch the data.
		if (clonedProject == null) {
			clonedProject = (Project) EcoreUtil.copy(data.getProjectState());
			return;
		}

		// Check each change.
		for (ChangePackage changePackage : data.getChangePackages()) {
			for (AbstractOperation operation : changePackage.getOperations()) {
				// check for composite operations
				for (AbstractOperation leafOperation : operation.getLeafOperations()) {
					// The modelElement this is all about
					ModelElement base = clonedProject.getModelElement(leafOperation.getModelElementId());
					// Load the reference.
					EReference eReference = getReference(leafOperation, base);
					// The MEs to be guessed
					Collection<ModelElement> correctMEs = getCorrectMEsFromOperation(leafOperation);

					analyseRecommendation(base, eReference, correctMEs);

					// redraw the changes in the project
					// if (operation.canApply(clonedProject)) {
					leafOperation.apply(clonedProject);
					if (DEBUG == DEBUGMODE.APPLY || DEBUG == DEBUGMODE.ALL) {
						System.out.println("Apply: " + leafOperation.getName());
					}
					/*
					 * } else if (debug == DEBUGMODE.APPLY || debug == DEBUGMODE.ALL) {
					 * System.out.println("Can't apply: " + operation.getName()); }
					 */
				}
			}
			// train the strategies
			updateStrategies(changePackage);
		}

		// bring the project on the last state
		clonedProject = (Project) EcoreUtil.copy(data.getProjectState());
	}

	private void analyseRecommendation(ModelElement base, EReference eReference, Collection<ModelElement> correctMEs) {

		if (correctMEs == null || correctMEs.size() <= 0 || base == null || eReference == null
			|| !relevantBaseClasses.contains(base.eClass())
			|| !relevantReferences.contains(eReference.getEReferenceType())) {
			return;
		}

		correctElements += correctMEs.size();

		// the number of suggestions
		countElements++;

		// get the possible elements
		Collection<ModelElement> candidates = getCandidates(base, eReference);

		// make suggestions
		for (int j = 0; j < recommendationStrategies.length; j++) {
			// calculate suggestions
			Map<ModelElement, Double> relevanceMap = recommendationStrategies[j].getMatchingMap(base, candidates);

			// iterate over each filter
			for (int i = 0; i < selectionStrategies.length; i++) {
				// filter which elements are suggested
				Map<ModelElement, Double> suggestionMap = selectionStrategies[i].selectCandidates(relevanceMap);
				// add to statistics
				calcStatistics(base, correctMEs, suggestionMap, i, j);
				// calculate which position element is at
				calcAveragePosition(correctMEs, suggestionMap, i, j);
				// Debug-Output:
				printDebugOutput(base, eReference, correctMEs, j, i, suggestionMap);
			}
		}
	}

	private void printDebugOutput(ModelElement base, EReference eReference, Collection<ModelElement> correctMEs, int j,
		int i, Map<ModelElement, Double> suggestionMap) {
		if (DEBUG == DEBUGMODE.RESULTS || DEBUG == DEBUGMODE.ALL) {
			if (base instanceof UnicaseModelElement) {
				System.out.print("Analyzing: " + ((UnicaseModelElement) base).getName());
			}
			System.out.println(", reference: " + eReference.getName() + " with RecStrategy "
				+ recommendationStrategies[j].getName() + " SelectionStrategy " + selectionStrategies[i].getName());

			for (ModelElement me : correctMEs) {
				if (me instanceof UnicaseModelElement) {
					System.out.println("# " + ((UnicaseModelElement) me).getName());
				}
			}

			for (ModelElement me : suggestionMap.keySet()) {
				if (me instanceof UnicaseModelElement) {
					System.out.println("+ " + ((UnicaseModelElement) me).getName() + " - " + suggestionMap.get(me));
				}
			}
		}
	}

	private void calcAveragePosition(Collection<ModelElement> correctMEs, Map<ModelElement, Double> relevanceMap,
		int selectionIndex, int strategyIndex) {
		Map<ModelElement, Double> posMap = (new CutPointSelection(0)).selectCandidates(relevanceMap);
		ModelElement[] posElements = posMap.keySet().toArray(new ModelElement[0]);
		for (ModelElement correct : correctMEs) {
			int recPos = 0;
			for (int i = 1; i <= posElements.length; i++) {
				if (posElements[i - 1] == correct) {
					recPos = i;
					break;
				}
			}
			if (recPos != 0) {
				sumPositions[selectionIndex][strategyIndex] += recPos;
			} else {
				// if an element is not suggested it gets the value of the next element
				sumPositions[selectionIndex][strategyIndex] += relevanceMap.keySet().size() + 1;
			}
			countNonZeroSuggestions[selectionIndex][strategyIndex]++;
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
	 * Analyzes the entire Project and lists the result in the parameter results.
	 * 
	 * @param project the project
	 */
	public void analyzeEntireProject(Project project) {
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
		Map<ModelElement, Double> suggestionMap, int indexSelection, int indexStrategy) {
		boolean hit = false;
		int sug = getNumberSuggestedElements(suggestionMap);
		suggestedElements[indexSelection][indexStrategy] += sug;

		for (ModelElement el : correctMEs) {
			Double val = suggestionMap.get(el);
			if (val != null) {
				foundAndRec[indexSelection][indexStrategy]++;
				hit = true;
			}
		}

		// determine if suggestions have been met
		if (hit) {
			hits[indexSelection][indexStrategy]++;
		} else if (DEBUG == DEBUGMODE.FAILS || DEBUG == DEBUGMODE.ALL) {
			// debug:
			if (me instanceof UnicaseModelElement) {
				UnicaseModelElement ume = (UnicaseModelElement) me;
				System.out.println("* " + recommendationStrategies[indexStrategy].getName() + " FAILS to connect ME \n"
					+ ume.getName() + ": " + ume.getDescriptionPlainText() + " \n to");
			}

			for (ModelElement correctME : correctMEs) {
				if (correctME instanceof UnicaseModelElement) {
					UnicaseModelElement ume = (UnicaseModelElement) correctME;
					System.out.println("- Name: " + ume.getName() + ": " + ume.getDescriptionPlainText());
				}
			}
		}
	}

	/**
	 * Resets the references and base classes and targetClasses.
	 */
	public void setToActionItemToFuncReqAnalysis() {
		relevantReferences = new ArrayList<EClass>();
		relevantReferences.add(ModelPackage.eINSTANCE.getAnnotation_AnnotatedModelElements().getEReferenceType());

		relevantBaseClasses = new ArrayList<EClass>();
		relevantBaseClasses.add(TaskPackage.eINSTANCE.getActionItem());

		relevantTargetClasses = new ArrayList<EClass>();
		relevantTargetClasses.add(RequirementPackage.eINSTANCE.getFunctionalRequirement());
	}

	/**
	 * Inverted case.
	 */
	public void setToFuncReqToActionItem() {
		relevantReferences = new ArrayList<EClass>();
		relevantReferences.add(ModelPackage.eINSTANCE.getUnicaseModelElement_Annotations().getEReferenceType());

		relevantBaseClasses = new ArrayList<EClass>();
		relevantBaseClasses.add(RequirementPackage.eINSTANCE.getFunctionalRequirement());

		relevantTargetClasses = new ArrayList<EClass>();
		relevantTargetClasses.add(TaskPackage.eINSTANCE.getActionItem());
	}

	/**
	 * Resets the references and base classes and targetClasses.
	 */
	public void setToFuncReqToUseCaseAnalysis() {

		relevantReferences = new ArrayList<EClass>();
		relevantReferences.add(RequirementPackage.eINSTANCE.getFunctionalRequirement_UseCases().getEReferenceType());

		relevantBaseClasses = new ArrayList<EClass>();
		relevantBaseClasses.add(RequirementPackage.eINSTANCE.getFunctionalRequirement());

		relevantTargetClasses = new ArrayList<EClass>();
		relevantTargetClasses.add(RequirementPackage.eINSTANCE.getUseCase());
	}

	/**
	 * Resets the references and base classes and targetClasses.
	 */
	public void setToUseCaseToFuncReqAnalysis() {

		relevantReferences = new ArrayList<EClass>();
		relevantReferences.add(RequirementPackage.eINSTANCE.getUseCase_FunctionalRequirements().getEReferenceType());

		relevantBaseClasses = new ArrayList<EClass>();
		relevantBaseClasses.add(RequirementPackage.eINSTANCE.getUseCase());

		relevantTargetClasses = new ArrayList<EClass>();
		relevantTargetClasses.add(RequirementPackage.eINSTANCE.getFunctionalRequirement());
	}

	private int getNumberSuggestedElements(Map<ModelElement, Double> suggestionMap) {
		return suggestionMap.size();
	}

	/**
	 * @return false
	 */
	public boolean isGlobal() {
		return false;
	}

	/**
	 * Set the relevant references.
	 * 
	 * @param ref the references
	 */
	public void setRelevantReferences(List<EClass> ref) {
		this.relevantReferences = ref;
	}

	/**
	 * Sets the relevant base classes.
	 * 
	 * @param classes the base classes
	 */
	public void setRelevantBaseClasses(List<EClass> classes) {
		this.relevantBaseClasses = classes;
	}

	/**
	 * Sets the relevant target classes.
	 * 
	 * @param classes the target classes
	 */
	public void setRelevantTargetClasses(List<EClass> classes) {
		this.relevantTargetClasses = classes;
	}

	/**
	 * Sets the strategies used for selection.
	 * 
	 * @param strategies the strategies
	 */
	public void setSelectionStrategies(LinkSelectionStrategy[] strategies) {
		this.selectionStrategies = strategies;
	}

	/**
	 * Sets the strategies used for recommendation.
	 * 
	 * @param strategies the strategies
	 */
	public void setRecommendationStrategies(RecommendationStrategy[] strategies) {
		this.recommendationStrategies = strategies;
	}
}
