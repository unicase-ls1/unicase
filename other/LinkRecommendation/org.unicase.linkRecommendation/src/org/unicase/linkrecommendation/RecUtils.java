/**
 * <copyright> Copyright (c) 2008-2009 Jonas Helming, Maximilian Koegel. All rights reserved. This program and the
 * accompanying materials are made available under the terms of the Eclipse Public License v1.0 which accompanies this
 * distribution, and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>
 */
package org.unicase.linkrecommendation;

import java.util.ArrayList;
import java.util.Collection;

import org.eclipse.emf.ecore.EObject;
import org.unicase.model.ModelElement;

/**
 * This class offers a couple of useful methods for word extraction etc.
 * 
 * @author henning
 */
public abstract class RecUtils {

	private static String[] iSTOPWORDS = new String[] { " ", "for", "of", "on", "and", "or", "the", "this", "them",
		"not", "is", "a", "we", "should", "be", "are", "he", "his", "in" };
	private static char[] iSTOPCHARS = new char[] { '.', '!', ':', '?', '"', '(', ')', '-', ';' };

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

	/**
	 * Returns all words of the text as StringArrays.
	 * 
	 * @param text the text
	 * @return the words
	 */
	public static ArrayList<String> getFilteredWords(String text) {
		if (text == null) {
			return new ArrayList<String>();
		}

		text = text.toLowerCase();

		for (char c : iSTOPCHARS) {
			text = text.replace(c, ' ');
		}

		String[] tempResult = text.split(" ");
		ArrayList<String> result = new ArrayList<String>(tempResult.length);

		// remove empty elements
		for (int i = 0; i < tempResult.length; i++) {
			if (!tempResult[i].equals("") && !contains(iSTOPWORDS, tempResult[i])) {
				result.add(tempResult[i]);
			}
		}
		return result;
	}

	/**
	 * This method returns important text elements of a modelelement.
	 * 
	 * @param m1 ModelElement
	 * @param includeParent checks if parents name should be included as well
	 * @return name and parents name
	 */
	public static String getPrimaryText(ModelElement m1, boolean includeParent) {
		String text = m1.getName();

		if (includeParent) {
			EObject container = m1.eContainer();
			if (container instanceof ModelElement) {
				ModelElement parent = (ModelElement) container;
				text += " " + parent.getName();
			}
		}
		return text;
	}

	/**
	 * At the moment this just loads the description.
	 * 
	 * @param me the ModelElement
	 * @return the description if any, "" otherwise
	 */
	public static String getSecondaryText(ModelElement me) {
		String desc = me.getDescriptionPlainText();
		if (desc.equals("null")) {
			desc = "";
		}
		return desc;
	}

	/**
	 * Returns if the word is included in the elements list.
	 * 
	 * @param elements the elements
	 * @param word the word
	 * @return a bool indicating if it is included or not
	 */
	public static boolean contains(String[] elements, String word) {
		for (String w : elements) {
			if (w.equals(word)) {
				return true;
			}
		}

		return false;
	}

	/**
	 * Adds all element of the array to the collection.
	 * 
	 * @param col the collection
	 * @param array the array of Strings
	 */
	public static void addStringsToCollection(Collection<String> col, String[] array) {
		for (String s : array) {
			col.add(s);
		}
	}

}
