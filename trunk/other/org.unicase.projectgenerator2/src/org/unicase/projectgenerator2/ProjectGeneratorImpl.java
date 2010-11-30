package org.unicase.projectgenerator2;

import org.eclipse.emf.ecore.EPackage;

public class ProjectGeneratorImpl implements IProjectGenerator {
	EPackage rootPackage;
	long seed;
	long noOfExampleValues;
	long hierachyDepth;
	
	
	/* (non-Javadoc)
	 * @see org.unicase.projectgenerator2.IProjectGenerator#getRootPackage()
	 */
	public EPackage getRootPackage() {
		return rootPackage;
	}
	/* (non-Javadoc)
	 * @see org.unicase.projectgenerator2.IProjectGenerator#setRootPackage(org.eclipse.emf.ecore.EPackage)
	 */
	public void setRootPackage(EPackage rootPackage) {
		this.rootPackage = rootPackage;
	}
	/* (non-Javadoc)
	 * @see org.unicase.projectgenerator2.IProjectGenerator#getSeed()
	 */
	public long getSeed() {
		return seed;
	}
	/* (non-Javadoc)
	 * @see org.unicase.projectgenerator2.IProjectGenerator#setSeed(long)
	 */
	public void setSeed(long seed) {
		this.seed = seed;
	}
	/* (non-Javadoc)
	 * @see org.unicase.projectgenerator2.IProjectGenerator#getNoOfExampleValues()
	 */
	public long getNoOfExampleValues() {
		return noOfExampleValues;
	}
	/* (non-Javadoc)
	 * @see org.unicase.projectgenerator2.IProjectGenerator#setNoOfExampleValues(long)
	 */
	public void setNoOfExampleValues(long noOfExampleValues) {
		this.noOfExampleValues = noOfExampleValues;
	}
	/* (non-Javadoc)
	 * @see org.unicase.projectgenerator2.IProjectGenerator#getHierachyDepth()
	 */
	public long getHierachyDepth() {
		return hierachyDepth;
	}
	/* (non-Javadoc)
	 * @see org.unicase.projectgenerator2.IProjectGenerator#setHierachyDepth(long)
	 */
	public void setHierachyDepth(long hierachyDepth) {
		this.hierachyDepth = hierachyDepth;
	}
	
	/* (non-Javadoc)
	 * @see org.unicase.projectgenerator2.IProjectGenerator#generateValues()
	 */
	public void generateValues() {
		
	}
}
