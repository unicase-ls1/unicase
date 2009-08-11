/**
 * <copyright> Copyright (c) 2008 Jonas Helming, Maximilian Koegel. All rights reserved. This program and the
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

import org.eclipse.emf.common.notify.Adapter;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.util.BasicEList;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.common.util.TreeIterator;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.resource.Resource;
import org.unicase.analyzer.DataAnalyzer;
import org.unicase.analyzer.ProjectAnalysisData;
import org.unicase.linkrecommendation.recommendationStrategies.LSIStrategy;
import org.unicase.linkrecommendation.recommendationStrategies.RecommendationStrategy;
import org.unicase.linkrecommendation.recommendationStrategies.VectorSpaceModelStrategy;
import org.unicase.model.ModelElement;
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
	private int suggestionCases;

	private RecommendationStrategy[] strategies;

	/**
	 * The constructor.
	 */
	public LinkRecommendationAnalyzer() {
		thresholds = new Double[] { 0.1, 0.2, 0.35, 0.5, 0.7 };
		strategies = new RecommendationStrategy[] { new VectorSpaceModelStrategy(), new LSIStrategy() };
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

		// TODO: ONLY CHANGED ELEMENTS!
		// EList<ChangePackage> changePackages = data.getChangePackages();
		// List<AbstractOperation> operations = new ArrayList<AbstractOperation>();
		//		
		// Check each change.
		// for(ChangePackage changePackage: changePackages){
		// operations.addAll(changePackage.getOperations());
		// }

		// for(AbstractOperation operation: operations){
		// if(operation instanceof SingleReferenceOperation){
		// SingleReferenceOperation op = (SingleReferenceOperation) operation;
		// EReference eReference;
		// ModelElement base;
		// ModelElement correctTarget;
		//				
		//				
		// }
		// }

		analyzeEntireProject(data, results);

		return results;
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

		foundAndRec = new double[thresholds.length][strategies.length];
		suggestedElements = new int[thresholds.length][strategies.length];
		hits = new int[thresholds.length][strategies.length];

		for (int j = 0; j < strategies.length; j++) {
			Arrays.fill(foundAndRec[j], 0);
			Arrays.fill(suggestedElements[j], 0);
			Arrays.fill(hits[j], 0);
		}

		correctElements = 0;
		suggestionCases = 0;

		for (ModelElement modelElement : allModelElements) {
			// only check specified base classes
			EClass eClass = modelElement.eClass();
			if (!relevantBaseClasses.contains(eClass)) {
				continue;
			}

			List<EReference> refs = modelElement.eClass().getEAllReferences();

			for (EReference eReference : refs) {
				// only check specified references
				if (!relevantReferences.contains(eReference.getEReferenceType())) {
					continue;
				}

				// find the proper candidates
				Collection<ModelElement> correctMEs = getCorrectMEs(modelElement, eReference);
				correctElements += correctMEs.size();
				// stop if nothing to count
				if (correctMEs.size() == 0) {
					continue;
				}

				// get the possible elements
				Collection<ModelElement> candidates = getCandidates(modelElement, eReference);

				// make suggestions
				for (int j = 0; j < strategies.length; j++) {
					Map<ModelElement, Double> relevanceMap = strategies[j].getMatchingMap(modelElement, candidates);

					// add to statistics
					suggestionCases++;
					for (int i = 0; i < thresholds.length; i++) {
						calcStatistics(correctMEs, relevanceMap, i, j);
					}

					// Debug-Output:
					System.out.print("Analyzing: " + modelElement.getName());
					System.out.println(", reference: " + eReference.getName());
					for (ModelElement me : correctMEs) {
						System.out.println("# Name: " + me.getName());
					}
					for (int i = 0; i < thresholds.length; i++) {
						printSuggestedElements(relevanceMap, thresholds[i]);
					}
				}
			}
		}

		for (int j = 0; j < strategies.length; j++) {
			for (int i = 0; i < thresholds.length; i++) {
				double precision = foundAndRec[i][j] / suggestedElements[i][j];
				double recall = foundAndRec[i][j] / correctElements;
				// double hitPercentage = ((double)hits[i])/((double)suggestionCases);

				results.add(precision);
				results.add(recall);
				// results.add(hits[i]);
				// results.add(suggestionCases);
				// results.add(hitPercentage);
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

	private Collection<ModelElement> getCorrectMEs(ModelElement modelElement, EReference eReference) {
		List<ModelElement> correctMEs = new ArrayList<ModelElement>();

		Object existing = modelElement.eGet(eReference);
		List<ModelElement> allCorrectMEs = new ArrayList<ModelElement>();

		if (existing instanceof EList) {
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

	private void calcStatistics(Collection<ModelElement> correctMEs, Map<ModelElement, Double> relevanceMap,
		int indexThreshold, int indexStrategy) {
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

	public TreeIterator<EObject> eAllContents() {
		// TODO Auto-generated method stub
		return null;
	}

	public EClass eClass() {
		// TODO Auto-generated method stub
		return null;
	}

	public EObject eContainer() {
		// TODO Auto-generated method stub
		return null;
	}

	public EStructuralFeature eContainingFeature() {
		// TODO Auto-generated method stub
		return null;
	}

	public EReference eContainmentFeature() {
		// TODO Auto-generated method stub
		return null;
	}

	public EList<EObject> eContents() {
		// TODO Auto-generated method stub
		return null;
	}

	public EList<EObject> eCrossReferences() {
		// TODO Auto-generated method stub
		return null;
	}

	public Object eGet(EStructuralFeature feature) {
		// TODO Auto-generated method stub
		return null;
	}

	public Object eGet(EStructuralFeature feature, boolean resolve) {
		// TODO Auto-generated method stub
		return null;
	}

	public boolean eIsProxy() {
		// TODO Auto-generated method stub
		return false;
	}

	public boolean eIsSet(EStructuralFeature feature) {
		// TODO Auto-generated method stub
		return false;
	}

	public Resource eResource() {
		// TODO Auto-generated method stub
		return null;
	}

	public void eSet(EStructuralFeature feature, Object newValue) {
		// TODO Auto-generated method stub

	}

	public void eUnset(EStructuralFeature feature) {
		// TODO Auto-generated method stub

	}

	public EList<Adapter> eAdapters() {
		// TODO Auto-generated method stub
		return null;
	}

	public boolean eDeliver() {
		// TODO Auto-generated method stub
		return false;
	}

	public void eNotify(Notification notification) {
		// TODO Auto-generated method stub

	}

	public void eSetDeliver(boolean deliver) {
		// TODO Auto-generated method stub

	}

	public boolean isExportOnce() {
		// TODO Auto-generated method stub
		return false;
	}
}
