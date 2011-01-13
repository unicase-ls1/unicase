package org.unicase.projectgenerator2;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.unicase.projectgenerator2.util.ProjectGeneratorConfiguration;

public interface IProjectGenerator {

	public abstract void generateModel(EPackage modelPackage, EObject rootObject);
	
	public abstract void generateModel(ProjectGeneratorConfiguration config);

}