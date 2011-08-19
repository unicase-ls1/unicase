/**
 * <copyright> Copyright (c) 2008-2009 Jonas Helming, Maximilian Koegel. All rights reserved. This program and the
 * accompanying materials are made available under the terms of the Eclipse Public License v1.0 which accompanies this
 * distribution, and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>
 */
package org.unicase.linkrecommendation;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;
import java.util.Vector;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.unicase.model.UnicaseModelElement;
import org.unicase.model.requirement.Step;
import org.unicase.model.requirement.UseCase;

/**
 * This class offers a couple of useful methods for word extraction etc.
 * 
 * @author henning
 */
public class RecUtils {

	private static final String[] STOPWORDS = new String[] { " ", "null", "to", "yet", "will", "which", "within",
		"without", "how", "if", "it", "has", "have", "about", "also", "an", "at", "by", "for", "of", "on", "and", "or",
		"the", "this", "them", "not", "is", "a", "we", "should", "be", "are", "he", "his", "in", "e", "g", "i", "e",
		"there", "their", "from" };
	private static final char[] STOPCHARS = new char[] { '.', ',', '!', ':', '?', '\'', '"', '(', ')', '-', ';', '0',
		'1', '2', '3', '4', '5', '6', '7', '8', '9' };

	private static final Map<String, String> STEMMAP = new LinkedHashMap<String, String>();

	private static final boolean TRIPPLE_NAME = true;

	// initialization
	static {
		STEMMAP.put("sses", "ss");// e.g. possesses -> possess
		STEMMAP.put("ied", "y");// e.g. identified -> identify
		STEMMAP.put("ed", "");// walked -> walk
		STEMMAP.put("s", "");// walks -> walk, keyboards-> keyboard
		STEMMAP.put("ies", "y"); // identifies -> identify
		STEMMAP.put("ing", ""); // meeting -> meet
		STEMMAP.put("ings", ""); // meetings -> meet
		STEMMAP.put("ion", ""); // encryption -> encrypt
		STEMMAP.put("ment", ""); // astonishment -> astonish

		// ly, ally
		// er : shopper, shopping -> shop
	}

	/**
	 * Prevents calls from subclasses.
	 */
	protected RecUtils() {
		throw new UnsupportedOperationException();
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

	/**
	 * Returns all words of the text as StringArrays.
	 * 
	 * @param text the text
	 * @param stemming determines if stemming (replacing s or ed at the end eg.) should be applied
	 * @return the words
	 */
	public static ArrayList<String> getFilteredWords(String text, boolean stemming) {
		if (text == null) {
			return new ArrayList<String>();
		}

		for (char c : STOPCHARS) {
			text = text.replace(c, ' ');
		}

		String[] tempResult = text.split(" ");
		ArrayList<String> result = new ArrayList<String>(tempResult.length);

		// remove empty elements
		for (int i = 0; i < tempResult.length; i++) {
			if (!tempResult[i].equals("") && !contains(STOPWORDS, tempResult[i].toLowerCase())) {
				if (stemming) {
					String[] words = decamilize(tempResult[i]);
					for (String word : words) {
						String myWord = word.toLowerCase();
						myWord = stemmWord(myWord);
						result.add(myWord);
					}
				} else {
					result.add(tempResult[i]);
				}
			}
		}
		return result;
	}

	/**
	 * This method takes a String and seperates camelcase words. e.g. CamelCase -> Camel, Case -> camelCase-> camel
	 * Case. Adapted from http://www.malethan.com/article/humanise_camel_case_in_java.html
	 * 
	 * @param word the string
	 * @return an array with the seperated words
	 */
	public static String[] decamilize(String word) {
		Pattern pattern = Pattern.compile("([A-Z]|[a-z])[a-z]*");

		Vector<String> tokens = new Vector<String>();
		Matcher matcher = pattern.matcher(word);
		String acronym = "";
		while (matcher.find()) {
			String found = matcher.group();
			if (found.matches("^[A-Z]$")) {
				acronym += found;
			} else {
				if (acronym.length() > 0) {
					// we have an acronym to add before we continue
					tokens.add(acronym);
					acronym = "";
				}
				tokens.add(found);
			}
		}
		if (acronym.length() > 0) {
			tokens.add(acronym);
		}
		if (tokens.size() > 0) {
			return tokens.toArray(new String[0]);
		}

		return new String[] { word };
	}

	private static String stemmWord(String word) {
		Set<String> ends = STEMMAP.keySet();
		if (word.length() < 4) {
			return word;
		}

		for (String ending : ends) {
			if (word.endsWith(ending)) {
				// replace the ending with what comes along
				return word.substring(0, word.length() - ending.length()) + STEMMAP.get(ending);
			}
		}
		return word;
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
	 * Which texts are how used for analysis.
	 * 
	 * @param me the model elment
	 * @return the text
	 */
	public static String getMEsText(UnicaseModelElement me) {
		String text = "";
		if (TRIPPLE_NAME) {
			text = me.getName() + " " + me.getName() + " " + me.getName() + " " + me.getDescriptionPlainText();
		} else {
			text = me.getName() + " " + me.getDescriptionPlainText();
		}

		if (me instanceof UseCase) {
			UseCase uc = (UseCase) me;
			for (Step step : uc.getUseCaseSteps()) {
				text += " " + step.getName() + " " + step.getDescriptionPlainText();
			}
		}

		return text;
	}
}
