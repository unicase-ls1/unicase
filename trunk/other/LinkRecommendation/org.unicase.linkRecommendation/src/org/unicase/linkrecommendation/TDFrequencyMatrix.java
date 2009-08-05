/**
 * <copyright> Copyright (c) 2008-2009 Jonas Helming, Maximilian Koegel. All rights reserved. This program and the
 * accompanying materials are made available under the terms of the Eclipse Public License v1.0 which accompanies this
 * distribution, and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>
 */
package org.unicase.linkrecommendation;

import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.TreeMap;
import java.util.TreeSet;

/**
 * This class represenst a Term to Document Frequency Matrix.
 * 
 * @author Henning Femmer
 */
public class TDFrequencyMatrix {
	// zeile, spalte
	private double[][] tfMatrix;
	private TreeMap<String, Integer> wordIndices;
	// which objects are represented
	private TreeMap<String, Integer> objectIndices;
	private int objectCount;

	private ArrayList<ArrayList<String>> words;
	private TreeSet<String> wordDictionary;

	/**
	 * The constructor.
	 */
	public TDFrequencyMatrix() {
		tfMatrix = new double[0][0];
		wordIndices = new TreeMap<String, Integer>();
		objectIndices = new TreeMap<String, Integer>();
		objectCount = 0;

		words = new ArrayList<ArrayList<String>>();
		wordDictionary = new TreeSet<String>();
	}

	/**
	 * The constructor using documents as strings.
	 * 
	 * @param docs the docs
	 */
	public TDFrequencyMatrix(String[] docs) {
		this();
		for (String doc : docs) {
			this.addWordsToDictionaries(doc);
		}
		createIndices();
	}

	/**
	 * This methods counts the number of words for each document and thus normalizes each doc.
	 */
	public void normalizeDocuments() {
		// this is possible as all rows have same width;
		for (int col = 0; col < tfMatrix[0].length; col++) {
			int numWords = words.get(col).size();
			if (numWords != 0) {
				for (int row = 0; row < tfMatrix.length; row++) {
					tfMatrix[row][col] /= numWords;
				}
			}
		}
	}

	/**
	 * Multiplies each element with it's inverse document frequency.
	 */
	public void transformIDF() {
		for (int col = 0; col < tfMatrix[0].length; col++) {
			int numWords = words.get(col).size();
			if (numWords != 0) {
				for (int row = 0; row < tfMatrix.length; row++) {
					tfMatrix[row][col] /= numWords;
				}
			}
		}
	}

	/**
	 * Counts the words.
	 */
	public void createTDFMatrix() {
		if (wordIndices == null || wordIndices.size() == 0) {
			this.createIndices();
		}

		tfMatrix = new double[wordDictionary.size()][words.size()];

		// each document
		int docNumber = 0;
		for (ArrayList<String> doc : words) {
			// every word
			for (String word : doc) {
				tfMatrix[wordIndices.get(word)][docNumber]++;
			}
			docNumber++;
		}
	}

	/**
	 * Adds the words to the dictionaries.
	 * 
	 * @param text the text containing the words
	 */
	public void addWordsToDictionaries(String text) {
		objectIndices.put(text, objectCount);
		objectCount++;

		ArrayList<String> tempWords = RecUtils.getFilteredWords(text);
		wordDictionary.addAll(tempWords);
		words.add(tempWords);
	}

	/**
	 * Creates internal indices for each word in dictionary.
	 */
	public void createIndices() {
		wordIndices = new TreeMap<String, Integer>();
		int number = 0;
		for (String word : wordDictionary) {
			wordIndices.put(word, number);
			number++;
		}
	}

	/**
	 * Returns the cos, the dot-product of the vectors with the specified index. As matrix is normalized this is farely
	 * easy.
	 * 
	 * @param i1 the first document's index
	 * @param i2 the second document's index
	 * @return the dot product
	 */
	public double dotProduct(int i1, int i2) {
		double dot = 0;
		for (int row = 0; row < tfMatrix.length; row++) {
			dot += tfMatrix[row][i1] * tfMatrix[row][i2];
		}
		return dot;
	}

	/**
	 * @see java.lang.Object#toString()
	 * @return a string
	 */
	@Override
	public String toString() {
		NumberFormat n = NumberFormat.getInstance();
		n.setMaximumFractionDigits(4);

		String text = "Matrix\n";
		Object[] words = wordDictionary.toArray();

		for (int row = 0; row < tfMatrix.length; row++) {
			text += words[row] + "\t";
			if (words[row].toString().length() < 8) {
				text += "\t";
			}

			for (int col = 0; col < tfMatrix[0].length; col++) {
				text += n.format(tfMatrix[row][col]) + "\t";
			}
			text += "\n";
		}

		return text;
	}

	/**
	 * the matrix.
	 * 
	 * @return the matrix
	 */
	public double[][] getMatrix() {
		return tfMatrix;
	}

	/**
	 * Returns a documents index.
	 * 
	 * @param doc the document
	 * @return the index
	 */
	public int getDocumentIndex(String doc) {
		return objectIndices.get(doc);
	}
}
