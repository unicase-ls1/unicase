package org.unicase.projectgenerator2.util;

import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.Map.Entry;

import org.eclipse.emf.common.util.TreeIterator;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EPackage.Registry;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.EcorePackage;

public final class ProjectGeneratorUtil {

	private static Set<EClass> modelElementEClasses;
	private static Set<EPackage> modelPackages;
	private static Set<EPackage> rootModelPackages;
	private static Map<EPackage, Set<EClass>> packageModelElementEClasses = new LinkedHashMap<EPackage, Set<EClass>>();
	private static Map<EClass, Set<EClass>> allEContainments = new LinkedHashMap<EClass, Set<EClass>>();
	private static Map<EClass, Set<EClass>> subEClasses = new LinkedHashMap<EClass, Set<EClass>>();	
	
	private ProjectGeneratorUtil() {
		
	}

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
		if(modelPackages != null) {
			return modelPackages;
		}
		modelPackages = new LinkedHashSet<EPackage>();
		Registry registry = EPackage.Registry.INSTANCE;

		for (Entry<String, Object> entry : registry.entrySet()) {
			try {
				System.out.println(entry.getKey());
				EPackage model = EPackage.Registry.INSTANCE.getEPackage(entry.getKey());
				modelPackages.add(model);
			}
			// BEGIN SUPRESS CATCH EXCEPTION
			catch (RuntimeException exception) {
				// END SUPRESS CATCH EXCEPTION
				//logException("Failed to load model package " + entry.getKey(), exception);
			}
		}
		return modelPackages;
	}
	
	
	
	public static Set<EPackage> getAllRootModelPackages() {
		if(rootModelPackages != null) {
			return rootModelPackages;
		}
		rootModelPackages = new LinkedHashSet<EPackage>();
		Registry registry = EPackage.Registry.INSTANCE;

		for (Entry<String, Object> entry : registry.entrySet()) {
			try {
				EPackage model = EPackage.Registry.INSTANCE.getEPackage(entry.getKey());
				if (model.getESuperPackage() == null) rootModelPackages.add(model);
			}
			// BEGIN SUPRESS CATCH EXCEPTION
			catch (RuntimeException exception) {
				// END SUPRESS CATCH EXCEPTION
				//logException("Failed to load model package " + entry.getKey(), exception);
			}
		}
		return rootModelPackages;
	}
	
	/**
	 * Retrieve all EClasses that are model element subclasses from a package 
	 * 
	 * @param ePackage the package to get model element subclasses from
	 * @return a set of model element subclasses in the given package
	 */
	public static Set<EClass> getAllModelElementEClasses(EPackage ePackage) {
		if(packageModelElementEClasses.containsKey(ePackage)) {
			return packageModelElementEClasses.get(ePackage);
		}
		if(ePackage == null) {
			packageModelElementEClasses.put(ePackage, new LinkedHashSet<EClass>());
			return packageModelElementEClasses.get(ePackage);	
		}
		Set<EClass> result = new LinkedHashSet<EClass>();
		for(EPackage subPackage : ePackage.getESubpackages()) {
			result.addAll(getAllModelElementEClasses(subPackage));
		}
		for(EClassifier classifier : ePackage.getEClassifiers()) {
			if(classifier instanceof EClass)
				result.add((EClass) classifier);
		}
		packageModelElementEClasses.put(ePackage, result);
		return result;
	}
	
	/**
	 * Retrieve all EClasses that are model element subclasses
	 * 
	 * @return a set of all model element subclasses
	 */
	public static Set<EClass> getAllModelElementEClasses() {
		if (modelElementEClasses != null) {
			return modelElementEClasses;
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
		if(allEContainments.containsKey(eClass)) {
			return allEContainments.get(eClass);
		}
		if(eClass == null) {
			allEContainments.put(eClass, new LinkedHashSet<EClass>());
			return allEContainments.get(eClass);
		}
		Set<EClass> result = new LinkedHashSet<EClass>();
		for(EReference reference : eClass.getEAllContainments()) {
			EClass referenceType = reference.getEReferenceType();
			result.addAll(getAllSubEClasses(referenceType));
		}
		allEContainments.put(eClass, result);
		return result;
	}
	
	/**
	 * Get all subclasses of an EClass (no abstract classes or interfaces)
	 * 
	 * @param eClass the superclass of the subclasses to retrieve
	 * @return all subclasses of the given EClass
	 */
	public static Set<EClass> getAllSubEClasses(EClass eClass) {
		if(subEClasses.containsKey(eClass)) {
			return subEClasses.get(eClass);
		}
		if(eClass == null) {
			subEClasses.put(eClass, new LinkedHashSet<EClass>());
			return subEClasses.get(eClass);
		}
		Set<EClass> allEClasses = getAllModelElementEClasses();
		if(EcorePackage.eINSTANCE.getEObject().equals(eClass))
			return allEClasses;
		Set<EClass> result = new LinkedHashSet<EClass>();
		for (EClass subClass : allEClasses) {
			if (eClass.isSuperTypeOf(subClass) && (!subClass.isAbstract()) && (!subClass.isInterface())) {
				result.add(subClass);
			}
		}
		subEClasses.put(eClass, result);
		return result;
	}
	
	/**
	 * Returns all containing references where parentClass is the container and
	 * childClass the containment.
	 * 
	 * @param childClass the child class which shall be contained
	 * @param parentClass the class to get containment references from
	 * @return all possible container-references as a set
	 */
	public static Set<EReference> getAllPossibleContainingReferences(EClass childClass, EClass parentClass) {
		List<EReference> allReferences = parentClass.getEAllContainments();
		Set<EReference> result = new LinkedHashSet<EReference>();
		for(EReference reference : allReferences) {
			EClass referenceType = reference.getEReferenceType();
			if(referenceType == null)
				continue;
			if(referenceType.equals(childClass)) {
				result.add(reference);
			} else if (referenceType.equals(EcorePackage.eINSTANCE.getEObject())
				|| referenceType.isSuperTypeOf(childClass)) {
				result.add(reference);
			}
		}
		return result;
	}
	
	public static Map<EClass, Set<EObject>>getAllGeneratedClassesAndObjects(EObject rootObject) {
		Map<EClass, Set<EObject>> result = new LinkedHashMap<EClass, Set<EObject>>();
		TreeIterator<EObject> allContents = rootObject.eAllContents();
		while(allContents.hasNext()) {
			EObject eObject = allContents.next();
			if(result.containsKey(eObject.eClass()))
				result.get(eObject.eClass()).add(eObject);
			else {
				Set<EObject> newSet = new LinkedHashSet<EObject>();
				newSet.add(eObject);
				result.put(eObject.eClass(), newSet);
			}
		}
		return result;
	}
}
