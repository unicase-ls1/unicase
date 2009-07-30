/**
 * <copyright> Copyright (c) 2008 Jonas Helming, Maximilian Koegel. All rights reserved. This program and the
 * accompanying materials are made available under the terms of the Eclipse Public License v1.0 which accompanies this
 * distribution, and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>
 */
package org.unicase.linkrecommendation.matchingStrategies;

import java.util.Arrays;
import java.util.TreeSet;

import org.eclipse.emf.ecore.EObject;
import org.unicase.model.ModelElement;

/**
 * This method checks if singular words of an elment are shared within name or description.
 * 
 * @deprecated
 * @author Henning Femmer
 */
@Deprecated
public class FastKeywordMatcher implements MEMatcher {

	private static String[] IGNORE_WORDS = new String[] { "of", "on", "and", "or", "the", "this", "them", "not", "is",
		"a", "we", "should", "be", "are", "he", "his", "in" };
	private static char[] IGNORE_CHARS = new char[] { '.', '!', ':', '?', '"', '(', ')', '-', ';' };

	/**
	 * This method matches relevace between two elements on an scale [0..1].
	 * 
	 * @param m1 first element
	 * @param m2 second element
	 * @return a double in [0..1]
	 */
	public double getMatchingValue(ModelElement m1, ModelElement m2) {
		String[] words = getWords(m1);

		System.out.println(Arrays.toString(words));
		int[] matchVector = getMatchVector(words, m2);

		int sum = 0;
		for (int i = 0; i < words.length; i++) {
			sum += matchVector[i];
		}
		// TODO:use cos
		return sum;
	}

	private int[] getMatchVector(String[] targetWords, ModelElement m2) {
		int[] vector = new int[targetWords.length];

		String[] words2 = getWords(m2);
		for (int i = 0; i < vector.length; i++) {
			vector[i] = 0;
			for (String w2 : words2) {
				if (targetWords[i].equals(w2)) {
					vector[i]++;
				}
			}
		}
		return vector;
	}

	/**
	 * This method extracts the words from a modelElement by searching name, description and (not yet) parent
	 * description.
	 * 
	 * @param m1 the model element
	 * @return
	 */
	private String[] getWords(ModelElement m1) {
		String text = m1.getName();

		EObject container = m1.eContainer();
		if (container instanceof ModelElement) {
			ModelElement parent = (ModelElement) container;
			text += " " + parent.getName();
			System.out.println("Name: " + parent.getName());
		}

		String desc = m1.getDescriptionPlainText();
		if (desc != "null") {
			text += " " + desc;
		}

		text.toLowerCase();

		for (char c : IGNORE_CHARS) {
			text = text.replace(c, ' ');
		}
		String[] result = text.split(" ");

		return removeUnwantedWords(result);
	}

	private static String[] removeUnwantedWords(String[] words) {
		TreeSet<String> set = new TreeSet<String>();
		for (String word : words) {
			if (!contains(IGNORE_WORDS, word)) {
				set.add(word);
			}
		}

		return set.toArray(new String[0]);
	}

	private static boolean contains(String[] elements, String word) {
		for (String w : elements) {
			if (w.equals(word)) {
				return true;
			}
		}

		return false;
	}
}
