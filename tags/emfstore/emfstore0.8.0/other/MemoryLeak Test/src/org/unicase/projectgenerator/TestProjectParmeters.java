/**
 * <copyright> Copyright (c) 2008-2009 Jonas Helming, Maximilian Koegel. All rights reserved. This program and the
 * accompanying materials are made available under the terms of the Eclipse Public License v1.0 which accompanies this
 * distribution, and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>
 */
package org.unicase.projectgenerator;

import java.util.Calendar;

/**
 * A class containing parameters require to create a random test project.
 * 
 * @author Hodaie
 */
public class TestProjectParmeters {

	private int numOfEachME = 5;
	private long randomSeed = Calendar.getInstance().getTimeInMillis();
	private int projWidth = 3;
	private int projDepth = 2;
	private int maxNumOfManyRefs = 3;
	private int maxNumOfMEsInLeafSection = 10;

	/**
	 * Constructor.
	 */
	public TestProjectParmeters() {
		super();
	}

	/**
	 * Constructor.
	 * 
	 * @param numOfEachME numOfEachME
	 * @param randomSeed randomSeed
	 * @param projWidth projWidth
	 * @param projDepth projDepth
	 * @param maxNumOfManyRefs maxNumOfManyRefs
	 * @param maxNumOfMEsInLeafSection maxNumOfMEsInLeafSection
	 */

	public TestProjectParmeters(int numOfEachME, long randomSeed, int projWidth, int projDepth, int maxNumOfManyRefs,
		int maxNumOfMEsInLeafSection) {

		this.numOfEachME = numOfEachME;
		this.randomSeed = randomSeed;
		this.projWidth = projWidth;
		this.projDepth = projDepth;
		this.maxNumOfManyRefs = maxNumOfManyRefs;
		this.maxNumOfMEsInLeafSection = maxNumOfMEsInLeafSection;

	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public String toString() {

		StringBuilder sb = new StringBuilder("Project parameters: ");

		sb.append("numOfEachME: " + numOfEachME + ";");
		sb.append("randomSeed: " + randomSeed + ";");
		sb.append("projWidth: " + projWidth + ";");
		sb.append("projDepth: " + projDepth + ";");
		sb.append("maxNumOfManyRefs: " + maxNumOfManyRefs + ";");
		sb.append("maxNumOfMEsInLeafSection: " + maxNumOfMEsInLeafSection + ";");

		return sb.toString();
	}

	/**
	 * @param maxNumOfManyRefs the maxNumOfManyRefs to set
	 */
	public void setMaxNumOfManyRefs(int maxNumOfManyRefs) {
		this.maxNumOfManyRefs = maxNumOfManyRefs;
	}

	/**
	 * @return the maxNumOfManyRefs
	 */
	public int getMaxNumOfManyRefs() {
		return maxNumOfManyRefs;
	}

	/**
	 * @param randomSeed the randomSeed to set
	 */
	public void setRandomSeed(long randomSeed) {
		this.randomSeed = randomSeed;
	}

	/**
	 * @return the randomSeed
	 */
	public long getRandomSeed() {
		return randomSeed;
	}

	/**
	 * @param projWidth the projWidth to set
	 */
	public void setProjWidth(int projWidth) {
		this.projWidth = projWidth;
	}

	/**
	 * @return the projWidth
	 */
	public int getProjWidth() {
		return projWidth;
	}

	/**
	 * @param projDepth the projDepth to set
	 */
	public void setPorjDepth(int projDepth) {
		this.projDepth = projDepth;
	}

	/**
	 * @return the projDepth
	 */
	public int getProjDepth() {
		return projDepth;
	}

	/**
	 * @param maxNumOfMEsInLeafSection the maxNumOfMEsInLeafSection to set
	 */
	public void setMaxNumOfMEsInLeafSection(int maxNumOfMEsInLeafSection) {
		this.maxNumOfMEsInLeafSection = maxNumOfMEsInLeafSection;
	}

	/**
	 * @return the maxNumOfMEsInLeafSection
	 */
	public int getMaxNumOfMEsInLeafSection() {
		return maxNumOfMEsInLeafSection;
	}

	/**
	 * @param numOfEachME the numOfEachME to set
	 */
	public void setNumOfEachME(int numOfEachME) {
		this.numOfEachME = numOfEachME;
	}

	/**
	 * @return numOfEachME
	 */
	public int getNumOfEachME() {
		return numOfEachME;
	}

}
