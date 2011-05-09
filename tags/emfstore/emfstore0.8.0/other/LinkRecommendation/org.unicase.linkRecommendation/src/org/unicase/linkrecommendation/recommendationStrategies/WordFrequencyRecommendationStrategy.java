/**
 * <copyright> Copyright (c) 2008-2009 Jonas Helming, Maximilian Koegel. All rights reserved. This program and the
 * accompanying materials are made available under the terms of the Eclipse Public License v1.0 which accompanies this
 * distribution, and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>
 */
package org.unicase.linkrecommendation.recommendationStrategies;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeSet;

import org.eclipse.emf.ecore.EObject;
import org.unicase.metamodel.ModelElement;
import org.unicase.model.UnicaseModelElement;

/**
 * @author Henning Femmer
 * @deprecated
 */
@Deprecated
public class WordFrequencyRecommendationStrategy extends AbstractRecommendationStrategy {

	private static String[] iIGNOREWORDS = new String[] { "of", "on", "and", "or", "the", "this", "them", "not", "is",
		"a", "we", "should", "be", "are", "he", "his", "in" };
	private static char[] iIGNORECHARS = new char[] { '.', '!', ':', '?', '"', '(', ')', '-', ';' };

	/**
	 * Contructor.
	 */
	public WordFrequencyRecommendationStrategy() {
		super(0);
	}

	/**
	 * Is this strategy possible?
	 * 
	 * @param base the base
	 * @param rec the recommendation
	 * @return true or false
	 */
	public boolean isRecommendationPossible(ModelElement base, ModelElement rec) {
		if (base == rec) {
			return false;
		}
		if (base.getContainerModelElement() == rec) {
			return false;
		}

		return true;
	}

	/**
	 * This method matches the UnicaseModelElements by comparing different text elements.
	 * 
	 * @param base The UnicaseModelElement which is compared to the rest
	 * @param elements The potential elements linked to the base
	 * @return a Map (UnicaseModelElement,Double)
	 */
	@Override
	public Map<ModelElement, Double> getMatchingMap(ModelElement base, Collection<ModelElement> elements) {
		HashMap<ModelElement, Double> hm = new HashMap<ModelElement, Double>(elements.size());

		// get target primary texts
		String targetPrimaryWordsRaw = getPrimaryText((UnicaseModelElement) base, true);
		// get target secondary texts
		String targetSecondaryWordsRaw = getSecondaryText((UnicaseModelElement) base);

		// read words, sort, remove unwanted.
		String[] targetWords = createFilteredSet(targetPrimaryWordsRaw + " " + targetSecondaryWordsRaw);

		for (ModelElement me : elements) {
			// just valid elments are recommended
			if (!isRecommendationPossible(base, me)) {
				continue;
			}

			// get MEs primary words
			String[] mPrimary = getWords(getPrimaryText((UnicaseModelElement) me, false));
			// get MEs secondary words
			String[] mSecondary = getWords(getSecondaryText((UnicaseModelElement) me));

			// get term frequency vectors
			double[] tfPrimary = getTermFrequencyVector(targetWords, mPrimary);
			double[] tfSecondary = getTermFrequencyVector(targetWords, mSecondary);

			// get metric
			double metric = getMetric(tfPrimary, tfSecondary);
			if (metric > getThreshold()) {
				hm.put(me, metric);
			}
		}
		return hm;
	}

	/**
	 * Calculates a double value from two given vectors prefering the first.
	 * 
	 * @param t1 "better" vector
	 * @param t2 normal vector
	 * @return the sum of all elements of both vectors, first vector with factor 3
	 */
	public static double getMetric(double[] t1, double[] t2) {
		double sum1 = 0;
		double sum2 = 0;

		for (double d : t1) {
			sum1 += d * 3; // empower words1
		}

		for (double d : t2) {
			sum2 += d;
		}

		return (sum1 + sum2);
	}

	/**
	 * Calculates how often elements of the target words appear in the document vector.
	 * 
	 * @param targetWords the target words
	 * @param document the document as an array of words
	 * @return a vector enumeration the frequency in the order of the array target words
	 */
	public static double[] getTermFrequencyVector(String[] targetWords, String[] document) {
		double[] vector = new double[targetWords.length];
		for (int i = 0; i < targetWords.length; i++) {
			int count = 0;
			String targetWord = targetWords[i];
			for (String word : document) {
				if (word.equals(targetWord)) {
					count++;
				}
			}

			vector[i] = count;
		}
		return vector;
	}

	private static String[] getWords(String text) {
		if (text == null) {
			return new String[0];
		}

		text.toLowerCase();

		for (char c : iIGNORECHARS) {
			text = text.replace(c, ' ');
		}
		return text.split(" ");
	}

	private static String[] createFilteredSet(String text) {
		String[] words = getWords(text);

		TreeSet<String> set = new TreeSet<String>();
		for (String word : words) {
			if (!contains(iIGNOREWORDS, word)) {
				set.add(word);
			}
		}

		return set.toArray(new String[0]);
	}

	/**
	 * This method returns important text elements of a UnicaseModelElement.
	 * 
	 * @param m1 UnicaseModelElement
	 * @param includeParent checks if parents name should be included as well
	 * @return name and parents name
	 */
	public static String getPrimaryText(UnicaseModelElement m1, boolean includeParent) {
		String text = m1.getName();

		if (includeParent) {
			EObject container = m1.eContainer();
			if (container instanceof UnicaseModelElement) {
				UnicaseModelElement parent = (UnicaseModelElement) container;
				text += " " + parent.getName();
			}
		}
		return text;
	}

	/**
	 * At the moment this just loads the description.
	 * 
	 * @param base the UnicaseModelElement
	 * @return the description if any, "" otherwise
	 */
	public static String getSecondaryText(UnicaseModelElement base) {
		String desc = base.getDescriptionPlainText();
		if (desc == "null") {
			desc = "";
		}
		return desc;
	}

	private static boolean contains(String[] elements, String word) {
		for (String w : elements) {
			if (w.equals(word)) {
				return true;
			}
		}

		return false;
	}

	/**
	 * Returns the name of this strategy for output reasons.
	 * 
	 * @return the name
	 */
	public String getName() {
		return "Word Frequency Recommendation";
	}
}
