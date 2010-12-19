package org.unicase.projectgenerator2;

import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import java.util.Map.Entry;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.emf.ecore.EFactory;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EPackage.Registry;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.EcorePackage;

public class ProjectGeneratorUtil {

	private static Set<EClass> modelElementEClasses;

	/*
	 * Searching for EClass with elementName as name in EPackage recursively.
	 * Returns null if Eclass is not found.
	 */
	public static EClass getModelElementEClasses(EPackage ePackage, String elementName) {
		EClass result = null;
		if(ePackage == null) return result;
		
		for(EClassifier classifier : ePackage.getEClassifiers()) {
			if(classifier instanceof EClass) {
				if (classifier.getName().equals(elementName)) return (EClass) classifier; 
			}
		}
		
		for(EPackage subPackage : ePackage.getESubpackages()) {
			result = getModelElementEClasses(subPackage, elementName);
			if (result != null) return result;
		}
		
		return result;
	}
	
	public static EPackage getModelPackage(String nsURI) {
		 return EPackage.Registry.INSTANCE.getEPackage(nsURI);
	}
	
	public static Set<EPackage> getAllModelPackages() {
		Set<EPackage> result = new LinkedHashSet<EPackage>();
		Registry registry = EPackage.Registry.INSTANCE;

		for (Entry<String, Object> entry : registry.entrySet()) {
			try {
				System.out.println(entry.getKey());
				EPackage model = EPackage.Registry.INSTANCE.getEPackage(entry.getKey());
				result.add(model);
			}
			// BEGIN SUPRESS CATCH EXCEPTION
			catch (RuntimeException exception) {
				// END SUPRESS CATCH EXCEPTION
				//logException("Failed to load model package " + entry.getKey(), exception);
			}
		}
		return result;
	}
	
	
	
	public static Set<EPackage> getAllRootModelPackages() {
		Set<EPackage> result = new LinkedHashSet<EPackage>();
		Registry registry = EPackage.Registry.INSTANCE;

		for (Entry<String, Object> entry : registry.entrySet()) {
			try {
				EPackage model = EPackage.Registry.INSTANCE.getEPackage(entry.getKey());
				if (model.getESuperPackage() == null) result.add(model);
			}
			// BEGIN SUPRESS CATCH EXCEPTION
			catch (RuntimeException exception) {
				// END SUPRESS CATCH EXCEPTION
				//logException("Failed to load model package " + entry.getKey(), exception);
			}
		}
		return result;
	}
	
	/**
	 * Retrieve all EClasses that are model element subclasses from a package 
	 * 
	 * @param ePackage the package to get model element subclasses from
	 * @return a set of model element subclasses in the given package
	 */
	public static Set<EClass> getAllModelElementEClasses(EPackage ePackage) {
		Set<EClass> result = new LinkedHashSet<EClass>();
		if(ePackage == null)
			return result;
		for(EPackage subPackage : ePackage.getESubpackages()) {
			result.addAll(getAllModelElementEClasses(subPackage));
		}
		for(EClassifier classifier : ePackage.getEClassifiers()) {
			if(classifier instanceof EClass)
				result.add((EClass) classifier);
		}
		return result;
	}
	
	/**
	 * Retrieve all EClasses that are model element subclasses
	 * 
	 * @return a set of all model element subclasses
	 */
	public static Set<EClass> getAllModelElementEClasses() {
		if (modelElementEClasses != null) {
			return new LinkedHashSet<EClass>(modelElementEClasses);
		}
		Set<EClass> result = new LinkedHashSet<EClass>();
		Registry registry = EPackage.Registry.INSTANCE;

		for (Entry<String, Object> entry : new LinkedHashSet<Entry<String, Object>>(registry.entrySet())) {
			try {
				EPackage ePackage = EPackage.Registry.INSTANCE.getEPackage(entry.getKey());
				result.addAll(getAllModelElementEClasses(ePackage));
			}
			// BEGIN SUPRESS CATCH EXCEPTION
			catch (RuntimeException exception) {
				// END SUPRESS CATCH EXCEPTION
				// logException("Failed to load model package " + entry.getKey(), exception);
			}

		}
		modelElementEClasses = result;
		return result;
	}
	
	/**
	 * @param eClass the class to get the containable elements for
	 * @return all classes that can be contained in eClass
	 */
	public static Set<EClass> getAllEContainments(EClass eClass) {
		Set<EClass> result = new LinkedHashSet<EClass>();
		for(EReference reference : eClass.getEAllContainments()) {
			EClass referenceType = reference.getEReferenceType();
			result.addAll(getAllSubEClasses(referenceType));
		}
		return result;
	}
	
	/**
	 * Get all subclasses of an EClass (no abstract classes or interfaces)
	 * 
	 * @param eClass the superclass of the subclasses to retrieve
	 * @return all subclasses of the given EClass
	 */
	public static Set<EClass> getAllSubEClasses(EClass eClass) {
		Set<EClass> allEClasses = getAllModelElementEClasses();
		if(EcorePackage.eINSTANCE.getEObject().equals(eClass))
			return allEClasses;
		Set<EClass> result = new LinkedHashSet<EClass>();
		for (EClass subClass : allEClasses) {
			if (eClass.isSuperTypeOf(subClass) && (!subClass.isAbstract()) && (!subClass.isInterface())) {
				result.add(subClass);
			}
		}
		return result;
	}
	
	/**
	 * @param newObject the new object
	 * @param parent the object to get containment references from
	 * @return EReference the Container
	 */
	public static EReference getPossibleContainingReference(EObject newObject, EObject parent) {
		List<EReference> allReferences = parent.eClass().getEAllContainments();
		EReference resultReference = null;
		for(EReference reference : allReferences) {
			EClass referenceType = reference.getEReferenceType();
			if(referenceType.equals(newObject.eClass())) {
				resultReference = reference;
				break;
			} else if (referenceType.equals(EcorePackage.eINSTANCE.getEObject())
				|| referenceType.isSuperTypeOf(newObject.eClass())) {
				resultReference = reference;
				break;
			}
		}
		return resultReference;
	}
	
	/**
	 * @param newObject the new object
	 * @param parent the object to get containment references from
	 * @return all possible containers as a set
	 */
	public static Set<EReference> getAllPossibleContainingReferences(EObject newObject, EObject parent) {
		List<EReference> allReferences = parent.eClass().getEAllContainments();
		Set<EReference> result = new LinkedHashSet<EReference>();
		for(EReference reference : allReferences) {
			EClass referenceType = reference.getEReferenceType();
			if(referenceType.equals(newObject.eClass())) {
				result.add(reference);
			} else if (referenceType.equals(EcorePackage.eINSTANCE.getEObject())
				|| referenceType.isSuperTypeOf(newObject.eClass())) {
				result.add(reference);
			}
		}
		return result;
	}

	/**
	 * @param eClass the class to get the attributes for
	 * @return all available attributes for the class
	 */
	public static Set<EAttribute> getEAttributes(EClass eClass) {
		Set<EAttribute> result = new LinkedHashSet<EAttribute>();
		for(EAttribute attribute : eClass.getEAllAttributes()) {
			result.add(attribute);
		}
		return result;
	}
	
	/**
	 * @param eClass the class to get the Factory for
	 * @return the EFactory-instance for the class
	 */
	public static EFactory getEFactory(EClass eClass) {
		return eClass.getEPackage().getEFactoryInstance();	
	}
	
	/**
	 * @return the root EObject
	 */
	public static EObject createEObject(EClass clazz) {
		return clazz.getEPackage().getEFactoryInstance().create(clazz);
	}
	
}
