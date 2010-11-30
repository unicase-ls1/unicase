package org.unicase.projectgenerator2;

import org.eclipse.emf.ecore.EPackage;

public interface IProjectGenerator {

	public abstract EPackage getRootPackage();

	public abstract void setRootPackage(EPackage rootPackage);

	public abstract long getSeed();

	public abstract void setSeed(long seed);

	public abstract long getNoOfExampleValues();

	public abstract void setNoOfExampleValues(long noOfExampleValues);

	public abstract long getHierachyDepth();

	public abstract void setHierachyDepth(long hierachyDepth);

	public abstract void generateValues();

}