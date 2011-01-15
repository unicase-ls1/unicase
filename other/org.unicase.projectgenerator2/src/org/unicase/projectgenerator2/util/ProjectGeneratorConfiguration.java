package org.unicase.projectgenerator2.util;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;

public class ProjectGeneratorConfiguration {
	private EPackage modelPackage;
	private EObject rootObject;
	private long seed;
	private int width = 3;
	private int depth = 3;
	private boolean ignoreAndLog = false;
	
	public ProjectGeneratorConfiguration(EPackage modelPackage, EObject rootObject) {
		this.modelPackage = modelPackage;
		this.rootObject = rootObject;
		seed = System.currentTimeMillis();
	}
	
	public ProjectGeneratorConfiguration(EPackage modelPackage, EObject rootObject, int width, int depth) {
		this.modelPackage = modelPackage;
		this.rootObject = rootObject;
		this.depth = depth;
		this.width = width;
		seed = System.currentTimeMillis();
	}
		
	public ProjectGeneratorConfiguration(EPackage modelPackage, EObject rootObject, long seed, int width, int depth,
		boolean ignoreAndLog) {
		super();
		this.modelPackage = modelPackage;
		this.rootObject = rootObject;
		this.width = width;
		this.depth = depth;
		this.seed = seed;
		this.ignoreAndLog = ignoreAndLog;
	}

	public int getWidth() {
		return width;
	}
	
	public void setWidth(int width) {
		this.width = width;
	}
	
	public int getDepth() {
		return depth;
	}
	
	public void setDepth(int depth) {
		this.depth = depth;
	}
	
	public EObject getRootObject() {
		return rootObject;
	}
	
	public void setRootObject(EObject rootObject) {
		this.rootObject = rootObject;
	}
	
	public void setModelPackage(EPackage modelPackage) {
		this.modelPackage = modelPackage;
	}
	
	public EPackage getModelPackage() {
		return modelPackage;
	}
	
	public void setSeed(long seed) {
		this.seed = seed;
	}
	
	public long getSeed() {
		return seed;
	}

	public void setIgnoreAndLog(boolean ignoreAndLog) {
		this.ignoreAndLog = ignoreAndLog;
	}

	public boolean getIgnoreAndLog() {
		return ignoreAndLog;
	}
}
