package org.unicase.modelgenerator;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.unicase.modelgenerator.util.ModelGeneratorConfiguration;

public interface IModelGenerator {

	public abstract void generateModel(EPackage modelPackage, EObject rootObject);
	
	public abstract void generateModel(ModelGeneratorConfiguration config);

}