/**
 * <copyright> Copyright (c) 2008-2009 Jonas Helming, Maximilian Koegel. All rights reserved. This program and the
 * accompanying materials are made available under the terms of the Eclipse Public License v1.0 which accompanies this
 * distribution, and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>
 */

package org.unicase.linkrecommendation.test;

import org.eclipse.core.runtime.Assert;
import org.junit.Test;
import org.unicase.linkrecommendation.RecUtils;

/**
 * Test für RecUtils.
 * 
 * @author Henning Femmer
 */
public class RecUtilsTest {

	/**
	 * This is a test. Adopted from same source as in method.
	 */
	@Test
	public void testDecamilize() {
		String w1 = "deCamilize";
		String w2 = "DeCamilize";
		String w3 = "UNICASE";
		String w4 = "aTLAAndSomeMore";

		String[] wc1 = RecUtils.decamilize(w1);
		String[] wc2 = RecUtils.decamilize(w2);
		String[] wc3 = RecUtils.decamilize(w3);
		String[] wc4 = RecUtils.decamilize(w4);

		Assert.isTrue(wc1[0].equals("de"));
		Assert.isTrue(wc1[1].equals("Camilize"));
		Assert.isTrue(wc2[0].equals("De"));
		Assert.isTrue(wc2[1].equals("Camilize"));
		Assert.isTrue(wc3[0].equals("UNICASE"));

		Assert.isTrue(wc4[0].equals("a"));
		Assert.isTrue(wc4[1].equals("TLA"));
		Assert.isTrue(wc4[2].equals("And"));
		Assert.isTrue(wc4[3].equals("Some"));
		Assert.isTrue(wc4[4].equals("More"));
	}
}
