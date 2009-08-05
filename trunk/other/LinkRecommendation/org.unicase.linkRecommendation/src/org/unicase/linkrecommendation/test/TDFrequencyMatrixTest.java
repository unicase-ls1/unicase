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

	private TDFrequencyMatrix ma;

	/**
	 * Before every test.
	 */
	@Before
	public void setUp() {
		ma = new TDFrequencyMatrix(new String[] { "Human machine interface for computer applications",
			"A survey of user opinion of computer. system response time", "The EPS user interface management system",
			"System and human system engineering testing of EPS", "The generation of random, binary and ordered trees",
			"The intersection graph of paths in trees", "  Graph minors: A survey." });
		ma.createTDFMatrix();
	}

	/**
	 * An Example from the interwebs.
	 */
	@Test
	public void testBasicFunctionality() {
		System.out.println(ma.toString());
	}

	/**
	 * Testing the normalization.
	 */
	@Test
	public void testNormalization() {
		System.out.println("Normalisation:");
		ma.normalizeDocuments();
		System.out.println(ma.toString());

		double[][] matrix = ma.getMatrix();

		for (int col = 0; col < matrix[0].length; col++) {
			double sum = 0;

			for (int row = 0; row < matrix.length; row++) {
				sum += matrix[row][col];
			}

			double epsilon = 0.000001;
			Assert.assertTrue("After normalizing sums of cols must be 1", (sum - 1) < epsilon);
		}
	}
}
