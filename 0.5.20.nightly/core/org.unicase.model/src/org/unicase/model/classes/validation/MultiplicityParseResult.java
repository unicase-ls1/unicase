/**
 * <copyright> Copyright (c) 2008-2009 Jonas Helming, Maximilian Koegel. All rights reserved. This program and the
 * accompanying materials are made available under the terms of the Eclipse Public License v1.0 which accompanies this
 * distribution, and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>
 */
package org.unicase.model.classes.validation;

/**
 * Represents the result of parsing an integer.
 * 
 * @author koegel
 */
public class MultiplicityParseResult {

	private int minimumMultiplicity;

	/**
	 * @return the minimumMultiplicity
	 */
	public int getMinimumMultiplicity() {
		return minimumMultiplicity;
	}

	/**
	 * @return the maximumMultiplicity
	 */
	public int getMaximumMultiplicity() {
		return maximumMultiplicity;
	}

	private int maximumMultiplicity;
	private boolean successfullyParsed;

	/**
	 * Constructor.
	 * 
	 * @param minimumMultiplicity the minimum multiplicity
	 * @param maximumMultiplicity the maximum multiplicity
	 * @param isSuccessfullyParsed true if the result was parsed successfully
	 */
	public MultiplicityParseResult(int minimumMultiplicity, int maximumMultiplicity, boolean isSuccessfullyParsed) {
		this.minimumMultiplicity = minimumMultiplicity;
		this.maximumMultiplicity = maximumMultiplicity;
		this.successfullyParsed = isSuccessfullyParsed;
	}

	/**
	 * True if the result was successfully parsed from the input or is just a default fall-back value.
	 * 
	 * @return the successfullyParsed
	 */
	public boolean isSuccessfullyParsed() {
		return successfullyParsed;
	}

}
