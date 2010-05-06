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
import org.junit.Test;
import org.unicase.linkrecommendation.TDFrequencyMatrix;

import Jama.Matrix;
import Jama.SingularValueDecomposition;

/**
 * This is to test LSI.
 * 
 * @author Henning Femmer
 */
public class LSITest {
	private String[] docs = new String[] { "Human interface for computer",
		"A survey of user of computer system response time", "The EPS user interface system",
		"System and human system of EPS", " of user response time to", "The of, trees", "The graph of in trees",
		"Graph minors: of trees and ", "Graph minors: A survey" };

	private TDFrequencyMatrix ma;

	/**
	 * An Example from the interwebs.
	 */
	@Test
	public void testBasicFunctionality() {
		double[][] vals = new double[][] { { 1.0, 1.0, 1.0, 1.0, 1.0 },
			{ 0.0, 0.7578582801241234, 0.8705505614977934, 0.9440875104854797, 1.0 },
			{ 0.0, 0.5743491727526943, 0.7578582801241234, 0.8913012274546708, 1.0 },
			{ 0.0, 0.4352752672614163, 0.6597539444834084, 0.841466353313137, 1.0 },
			{ 0.0, 0.3298769722417042, 0.5743491727526943, 0.7944178780622027, 1.0 }, { 0.0, 0.25, 0.5, 0.75, 1.0 } };
		Matrix x = new Matrix(vals);
		SingularValueDecomposition svd = new SingularValueDecomposition(x);
		Matrix s = svd.getS();

		double eps = 0.001;
		Assert.assertTrue(Math.abs(s.get(0, 0) - 4.0143) <= eps);
		Assert.assertTrue(Math.abs(s.get(1, 1) - 0.9803) <= eps);
		Assert.assertTrue(Math.abs(s.get(2, 2) - 0.3522) <= eps);
		Assert.assertTrue(Math.abs(s.get(3, 3) - 0.0209) <= eps);
		Assert.assertTrue(Math.abs(s.get(4, 4) - 0.0004) <= eps);

	}

	/**
	 * Testing LSI with Deerwester example.
	 */
	@Test
	public void testLSITransformation() {
		ma = new TDFrequencyMatrix(docs, true);
		ma.createTDFMatrix();
		System.out.println(ma.toString());
		ma.transformLSI(0.3);
		// Print debugs compare with deerwester results
	}

	/**
	 * Returns if two matrizes return the same values.
	 * 
	 * @param a matrix a
	 * @param b matrix b
	 * @return true or false
	 */
	public boolean isEqual(Matrix a, Matrix b) {
		if (a.getRowDimension() != b.getRowDimension() || a.getColumnDimension() != b.getColumnDimension()) {
			return false;
		}

		for (int row = 0; row < a.getRowDimension(); row++) {
			for (int col = 0; col < a.getColumnDimension(); col++) {
				if (a.get(row, col) != b.get(row, col)) {
					return false;
				}
			}
		}
		return true;
	}
}
