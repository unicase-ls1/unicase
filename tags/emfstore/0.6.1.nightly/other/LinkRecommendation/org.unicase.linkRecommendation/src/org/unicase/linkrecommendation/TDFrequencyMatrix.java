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

import Jama.Matrix;
import Jama.SingularValueDecomposition;

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
	 * @param stemming determines if stemming (replacing s or ed at the end eg.) should be applied
	 * @param docs the docs
	 */
	public TDFrequencyMatrix(String[] docs, boolean stemming) {
		this();
		for (String doc : docs) {
			this.addWordsToDictionaries(doc, stemming);
		}
		createDictionaryIndices();
	}

	/**
	 * This methods counts the number of words for each document and thus normalizes each doc.
	 */
	public void normalizeDocuments() {
		// this is possible as all rows have same width;
		for (int col = 0; col < tfMatrix[0].length; col++) {
			double numWords = sumDocument(col);
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
		for (int row = 0; row < tfMatrix.length; row++) {

			double docFrequency = documentFrequency(row);
			double factor = Math.log((tfMatrix[row].length) / docFrequency);

			for (int col = 0; col < tfMatrix[0].length; col++) {
				tfMatrix[row][col] *= factor;
			}
		}
	}

	/**
	 * Uses SVD to reduce the number of elements in the matrix.
	 * 
	 * @param factorK the factor by which the dimensionality is reduced, e.g. 0.3
	 */
	public void transformLSI(double factorK) {

		Matrix myMatrix = new Matrix(tfMatrix);

		SingularValueDecomposition svd = myMatrix.svd();
		// tfMatrix = USV^T
		// U : Eigenvalues of AA^T: left Eigenvectors
		// S : Singular Values of A
		// V : Eigenvalues od A^TA: right Eigenvalues
		Matrix termMatrix = svd.getU();
		Matrix singularValues = svd.getS();
		Matrix documentMatrixT = svd.getV().transpose();

		// DEBUG:
		// System.out.println("My Matrix");
		// printMatrix(myMatrix);
		// System.out.println("Term Matrix");
		// this.printMatrix(termMatrix);
		// System.out.println("Singulars:");
		// this.printMatrix(singularValues);
		// System.out.println("documentMatrix:");
		// this.printMatrix(documentMatrixT);

		// TODO: find a proper value for k
		int k = (int) Math.round(myMatrix.getColumnDimension() * factorK);
		// (int) Math.floor(Math.sqrt(myMatrix.getColumnDimension()));
		Matrix termReduced = termMatrix.getMatrix(0, termMatrix.getRowDimension() - 1, 0, k - 1);
		Matrix singularReduced = singularValues.getMatrix(0, k - 1, 0, k - 1);
		Matrix documentReduced = documentMatrixT.getMatrix(0, k - 1, 0, documentMatrixT.getColumnDimension() - 1);

		// DEBUG:
		// System.out.println("Term Matrix");
		// this.printMatrix(termReduced);
		// System.out.println("Singulars:");
		// this.printMatrix(singularReduced);
		// System.out.println("documentMatrix:");
		// this.printMatrix(documentReduced);

		// int bla1 = sReduced.getColumnDimension();
		// int bla2 = vReduced.getRowDimension();

		Matrix result = (termReduced.times(singularReduced)).times(documentReduced);
		// DEBUG:
		// printMatrix(result);

		// save it, normalize it
		tfMatrix = result.getArray();
		this.normalizeDocuments();
	}

	private int documentFrequency(int index) {
		int df = 0;

		for (int col = 0; col < tfMatrix[0].length; col++) {
			if (tfMatrix[index][col] != 0) {
				df++;
			}
		}

		return df;
	}

	/**
	 * Counts the words.
	 */
	public void createTDFMatrix() {
		if (wordIndices == null || wordIndices.size() == 0) {
			this.createDictionaryIndices();
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
	 * @param stemming determines if stemming (replacing s or ed at the end eg.) should be applied
	 * @return returns the internal index of this document
	 */
	public int addWordsToDictionaries(String text, boolean stemming) {
		objectIndices.put(text, objectCount);
		objectCount++;

		ArrayList<String> tempWords = RecUtils.getFilteredWords(text, stemming);
		words.add(tempWords);
		wordDictionary.addAll(tempWords);

		return objectCount - 1;
	}

	/**
	 * Adds the words to the dictionaries. Stemming is applied.
	 * 
	 * @param text the text containing the words
	 * @return returns the internal index of this document
	 */
	public int addWordsToDictionaries(String text) {
		return addWordsToDictionaries(text, true);
	}

	/**
	 * Creates internal indices for each word in dictionary.
	 */
	private void createDictionaryIndices() {
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
	 * Return the cosinus between two documents. This is in fact a measurement for similarity.
	 * 
	 * @param i1 index for the first vector
	 * @param i2 index for the second vector
	 * @return the cosine
	 */
	public double cos(int i1, int i2) {
		double dot = dotProduct(i1, i2);

		double w1 = lengthDocumentVector(i1);
		double w2 = lengthDocumentVector(i2);
		double result = dot / (w1 * w2);
		return result;
	}

	/**
	 * Sums up all values of a document.
	 * 
	 * @param col which document should be used.
	 * @return the sum
	 */
	public double sumDocument(int col) {
		double sum = 0;

		for (int row = 0; row < tfMatrix.length; row++) {
			sum += tfMatrix[row][col];
		}
		return sum;
	}

	/**
	 * Returns the 2-norm of the vector of a document.
	 * 
	 * @param col an integer declaring the index of the document to be calculated.
	 * @return the norm
	 */
	public double lengthDocumentVector(int col) {
		double sum = 0;

		for (int row = 0; row < tfMatrix.length; row++) {
			sum += tfMatrix[row][col] * tfMatrix[row][col];
		}
		return Math.sqrt(sum);
	}

	/**
	 * @see java.lang.Object#toString()
	 * @return a string
	 */
	@Override
	public String toString() {
		NumberFormat n = NumberFormat.getInstance();
		n.setMaximumFractionDigits(2);

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
	 * Prints a matrix.
	 * 
	 * @param m the matrix
	 */
	public void printMatrix(Matrix m) {
		NumberFormat n = NumberFormat.getInstance();
		n.setMaximumFractionDigits(2);

		String s = "";
		for (int row = 0; row < m.getRowDimension(); row++) {
			for (int col = 0; col < m.getColumnDimension(); col++) {
				s += n.format(m.get(row, col)) + "\t";
			}
			s += "\n";
		}
		System.out.println(s);
	}
}
