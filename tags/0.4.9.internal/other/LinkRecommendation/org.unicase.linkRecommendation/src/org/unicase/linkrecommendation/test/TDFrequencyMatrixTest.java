/**
 * <copyright> Copyright (c) 2008-2009 Jonas Helming, Maximilian Koegel. All rights reserved. This program and the
 * accompanying materials are made available under the terms of the Eclipse Public License v1.0 which accompanies this
 * distribution, and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>
 */

/**
 * Test for TDFrequencyMatrix.
 */
package org.unicase.linkrecommendation.test;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.unicase.linkrecommendation.TDFrequencyMatrix;

/**
 * This is a Test for the TDFrequencyMatrix class.
 * 
 * @author Henning Femmer
 */
public class TDFrequencyMatrixTest {

	private String[] docs = new String[] { "Human' machine interface for computer application systems",
		"A survey of user opinions of computer systems response time", "The EPS user interface management system",
		"System and human systems, engineering testing of EPS",
		"The generation of random, binaries and ordered trees in systems",
		"The intersection graph of (paths) in trees and their systems", "  Graph minors: A survey of systems." };
	private TDFrequencyMatrix ma;

	/**
	 * Before every test.
	 */
	@Before
	public void setUp() {
	}

	/**
	 * An Example from the interwebs.
	 */
	@Test
	public void testBasicFunctionality() {
		System.out.println("Pure Frequency:" + docs.length);
		ma = new TDFrequencyMatrix(docs, false);
		ma.createTDFMatrix();
		System.out.println(ma.toString());
		System.out.println(ma + "\nDocumente:" + docs.length);

		System.out.println("Stemmed Frequency:" + docs.length);
		ma = new TDFrequencyMatrix(docs, true);
		ma.createTDFMatrix();
		System.out.println(ma.toString());
		System.out.println(ma + "\nDocumente:" + docs.length);
	}

	/**
	 * Testing the normalization.
	 */
	@Test
	public void testNormalization() {

		System.out.println("Normalisation:" + docs.length);

		ma = new TDFrequencyMatrix(docs, false);
		ma.createTDFMatrix();
		ma.normalizeDocuments();

		System.out.println(ma.toString());
		System.out.println(ma + "\nDocumente:" + docs.length);

		double[][] matrix = ma.getMatrix();
		for (int col = 0; col < matrix[0].length; col++) {
			double epsilon = 0.000001;
			Assert.assertTrue("After normalizing sums of cols must be 1, but was " + ma.sumDocument(col), ma
				.sumDocument(col) - 1 < epsilon);
		}
	}

	/**
	 * Test IDF.
	 */
	@Test
	public void testTransformIDF() {
		System.out.println("Transform IDF:" + docs.length);
		ma = new TDFrequencyMatrix(docs, false);
		ma.createTDFMatrix();
		ma.normalizeDocuments();
		ma.transformIDF();
		System.out.println(ma + "\nDocumente:" + docs.length);

		System.out.println("Transform IDF (stemmed):" + docs.length);
		ma = new TDFrequencyMatrix(docs, true);
		ma.createTDFMatrix();
		ma.normalizeDocuments();
		ma.transformIDF();
		System.out.println(ma + "\nDocumente:" + docs.length);
	}

	/**
	 * Test stemming.
	 */
	@Test
	public void testStemming() {
		System.out.println("Transform IDF (stemmed):" + docs.length);
		ma = new TDFrequencyMatrix(docs, true);
		ma.createTDFMatrix();
		System.out.println(ma + "\nDocumente:" + docs.length);
	}

	/**
	 * This test the LSI transformation.
	 */
	@Test
	public void testTransformLSI() {

		System.out.println("Transform LSI (stemmed):" + docs.length);
		ma = new TDFrequencyMatrix(docs, true);
		ma.createTDFMatrix();
		ma.transformLSI(0.2);
		System.out.println(ma);

	}
}
