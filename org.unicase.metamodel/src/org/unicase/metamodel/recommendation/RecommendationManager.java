/**
 * <copyright> Copyright (c) 2008-2009 Jonas Helming, Maximilian Koegel. All rights reserved. This program and the
 * accompanying materials are made available under the terms of the Eclipse Public License v1.0 which accompanies this
 * distribution, and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>
 */

package org.unicase.metamodel.recommendation;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IConfigurationElement;
import org.eclipse.core.runtime.Platform;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;
import org.unicase.metamodel.util.ModelUtil;

/**
 * This class is used as a singleton for providing link recommendation.
 * 
 * @author Henning Femmer
 */
public class RecommendationManager {

	private static final String BASE_CLASS = "org.unicase.metamodel.ModelElement";

	private static RecommendationManager singleton = new RecommendationManager();
	private List<StrategyExtension> extensions;
	private Map<String, StrategyExtension> general;

	/**
	 * The constructor.
	 */
	public RecommendationManager() {
		extensions = new ArrayList<StrategyExtension>();
		general = new HashMap<String, StrategyExtension>();
		// used for checking doublicates
		Set<String> check = new HashSet<String>();

		IConfigurationElement[] rawExtensions = Platform.getExtensionRegistry().getConfigurationElementsFor(
			"org.unicase.metamodel.recommendationstrategy");

		// System.out.println("exes: "+rawExtensions.length);
		for (IConfigurationElement extension : rawExtensions) {
			try {
				// create a data object which composites all the information of an extension
				StrategyExtension tempStrategy = new StrategyExtension(extension);

				// check for duplicates
				if (check.contains(tempStrategy.getEReferenceName() + tempStrategy.getBaseClassName())) {
					String message = "Two strategies a registred for suggestion of eReference:"
						+ tempStrategy.getEReferenceName()
						+ " with base element type "
						+ tempStrategy.getBaseClassName()
						+ ". "
						+ tempStrategy.getName()
						+ " will not be used. Please use just one strategy per base element type - eReference combination.";
					ModelUtil.logWarning(message, new Exception(message));
				} else {
					// add it to the check
					check.add(tempStrategy.getEReferenceName() + tempStrategy.getBaseClassName());

					// System.out.println(tempStrategy.getEReferenceName() + tempStrategy.getBaseClassName());

					// the generalized elements
					if (tempStrategy.getEReferenceName().equals("ALL")) {
						general.put(tempStrategy.getBaseClassName(), tempStrategy);
					} else {
						extensions.add(tempStrategy);
					}
				}
			} catch (CoreException e) {
				ModelUtil.logException("Exception during reading of recommendation strategies extension point.", e);
			}
		}
	}

	/**
	 * The singleton.
	 * 
	 * @return the singleton
	 */
	public static RecommendationManager getInstance() {
		return singleton;
	}

	/**
	 * Returns a recommendationStrategy to the specified type.
	 * 
	 * @param ref the reference this strategy shall be used with
	 * @param base the model element, for which suggestions will be made
	 * @return a recommendationStrategy to the specified type
	 */
	public RecommendationStrategy getRecommendationStrategy(EReference ref, EObject base) {
		if (base != null && ref != null) {
			String baseClassKey = getFullQualifiedClassName(base.eClass());

			// System.out.println(ref.getName()+" " +getFullQualifiedClassName(base.eClass()));

			// 1. Step: Is there a special recommendation for this reference and base?
			for (StrategyExtension ex : extensions) {
				// System.out.println(ex.getEReferenceName()+" " + ex.getBaseClassName());

				if (ref.getName().equals(ex.getEReferenceName()) && ex.getBaseClassName().equals(baseClassKey)) {
					return ex.getRecommendationStrategy();
				}
			}

			// 2. Step: Check super-type and interfaces for special recommendations
			for (StrategyExtension ex : extensions) {
				for (EClass superType : base.eClass().getEAllSuperTypes()) {
					String key = this.getFullQualifiedClassName(superType);

					// System.out.println(ex.getEReferenceName()+" " + key);
					if (ref.getName().equals(ex.getEReferenceName()) && ex.getBaseClassName().equals(key)) {
						return ex.getRecommendationStrategy();
					}
				}
			}

			// 3. Step: is there a general strategy for this base?
			if (general.containsKey(baseClassKey)) {
				return general.get(baseClassKey).getRecommendationStrategy();
			}

			// 4. Step: is there a general strategy for the super-type or interfaces
			for (EClass superType : base.eClass().getEAllSuperTypes()) {
				String key = this.getFullQualifiedClassName(superType);

				// System.out.println(key);
				if (general.containsKey(key)) {
					return general.get(key).getRecommendationStrategy();
				}
			}

			// 5. Step: is there a general for the model element (the most basic)
			if (general.containsKey(BASE_CLASS)) {
				return general.get(BASE_CLASS).getRecommendationStrategy();
			}
		}
		return null;
	}

	/**
	 * @param base
	 * @return
	 */
	private String getFullQualifiedClassName(EClass eClass) {
		String baseClassName = eClass.getName();
		String basePackageName = eClass.getEPackage().getNsPrefix();
		String baseClassKey = basePackageName + "." + baseClassName;
		return baseClassKey;
	}

	/**
	 * Calculates the relevance of all elements to the base and returns these values.
	 * 
	 * @param base the element which is going to be the reference.
	 * @param elements all elements to be mapped
	 * @param ref the eReference this is used with
	 * @param selStrategy a LinkSelectionStrategy like CutPointSelection etc, null for no selection filtering
	 * @return a map modelElement -> double value reference. The higher the better. Value should be in (0..1]
	 */
	public Map<EObject, Double> getMatchMap(final EObject base, EReference ref, final Collection<EObject> elements,
		LinkSelectionStrategy selStrategy) {

		try {

			if (base == null || ref == null || elements == null || elements.size() == 0) {
				return new HashMap<EObject, Double>();
			}

			RecommendationStrategy recStrategy = getRecommendationStrategy(ref, base);

			if (recStrategy != null) {
				System.out.println("Strategy " + recStrategy.getName() + " for " + ref.getName() + " and "
					+ elements.size() + " elements.");

				Map<EObject, Double> rec = recStrategy.getMatchingMap(base, elements);

				if (selStrategy != null) {
					rec = selStrategy.selectCandidates(rec);
				}

				return rec;
			}
		}
		// BEGIN SUPRESS CATCH EXCEPTION
		catch (RuntimeException e) {
			ModelUtil.logException("Exception during recommendation.", e);
		}
		// END SUPRESS CATCH EXCEPTION

		return new HashMap<EObject, Double>();
	}

	/**
	 * This class is used for internal storage of information for the extensions provided.
	 * 
	 * @author Henning Femmer
	 */
	private class StrategyExtension {

		private String name;
		private String eReferenceName;
		private RecommendationStrategy strategy;
		private String baseClassName;

		StrategyExtension(IConfigurationElement extension) throws CoreException {
			this.name = extension.getAttribute("name");
			this.eReferenceName = extension.getAttribute("eReferenceName");
			this.strategy = (RecommendationStrategy) extension.createExecutableExtension("strategyClass");
			this.baseClassName = extension.getAttribute("baseElementClass");
		}

		/**
		 * the name.
		 * 
		 * @return the name
		 */
		public String getName() {
			return name;
		}

		/**
		 * the ereference name.
		 * 
		 * @return eReferenceName
		 */
		public String getEReferenceName() {
			return eReferenceName;
		}

		/**
		 * The RecommendationStrategy.
		 * 
		 * @return recommendationStrategy
		 */
		public RecommendationStrategy getRecommendationStrategy() {
			return strategy;
		}

		/**
		 * the base class.
		 * 
		 * @return the base class
		 */
		public String getBaseClassName() {
			return baseClassName;
		}
	}
}
