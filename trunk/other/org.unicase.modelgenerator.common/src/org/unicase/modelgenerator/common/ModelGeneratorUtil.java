package org.unicase.modelgenerator.common;

import java.util.LinkedList;
import java.util.Collection;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.Set;
import java.util.Map.Entry;

import org.eclipse.emf.common.util.TreeIterator;
import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.EPackage.Registry;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.EcorePackage;
import org.eclipse.emf.edit.command.AddCommand;
import org.eclipse.emf.edit.command.RemoveCommand;
import org.eclipse.emf.edit.command.SetCommand;
import org.eclipse.emf.edit.domain.AdapterFactoryEditingDomain;
import org.eclipse.emf.edit.domain.EditingDomain;
import org.unicase.modelgenerator.common.attribute.AttributeHandler;
import org.unicase.modelgenerator.common.attribute.IAttributeSetter;

/**
 * Utility class to generate and change Ecore models.
 * All methods should be accessed in a static way,
 * therefore the constructor is not visible.
 */
public final class ModelGeneratorUtil {

	/**
	 * Set of all EClasses that are contained in EPackages that are
	 * currently registered in the EPackage registry.
	 * 
	 * @see #getAllEClasses()
	 */
	private static Set<EClass> allEClasses;
	
	/**
	 * Set of all EPackages that are currently registered in
	 * the EPackage registry.
	 * 
	 *  @see #getAllEPackages()
	 */
	private static Set<EPackage> modelPackages;
	
	
	/**
	 * Set of all EPackages that are currently registered in the 
	 * EPackage registry and not contained in any other package.
	 * 
	 * @see #getAllRootEPackages()
	 */
	private static Set<EPackage> rootModelPackages;
	
	/**
	 * Map that maps EPackages to a set of all their contained EClasses.
	 * 
	 * @see #getAllEClasses(EPackage)
	 */
	private static Map<EPackage, Set<EClass>> packageToModelElementEClasses = new LinkedHashMap<EPackage, Set<EClass>>();
	
	/**
	 * Map that maps EClasses to all possible EClasses that can be contained by them.
	 * 
	 * @see #getAllEContainments(EClass)
	 */
	private static Map<EClass, Set<EClass>> allEContainments = new LinkedHashMap<EClass, Set<EClass>>();

	/**
	 * Map that maps EClasses to their subclasses.
	 * 
	 * @see #getAllSubEClasses(EClass)
	 */
	private static Map<EClass, Set<EClass>> eClassToSubEClasses = new LinkedHashMap<EClass, Set<EClass>>();
	
	/**
	 * Private constructor.
	 */
	private ModelGeneratorUtil() {
		// all methods should be accessed in a static way
	}
	
	/**
	 * Returns the EPackage to the specified <code>nsURI</code>.
	 * 
	 * @param nsURI the NsUri of the EPackage to get
	 * @return the EPackage belonging to <code>nsURI</code>
	 * 
	 * @see Registry#getEPackage(String)
	 */
	public static EPackage getEPackage(String nsURI) { 
		return EPackage.Registry.INSTANCE.getEPackage(nsURI);
	}
	
	/**
	 * Looks up all EPackages that are registered in the registry
	 * and returns them as a Set.
	 * 
	 * @return all registered EPackages as a Set
	 * @see Registry
	 */
	public static Set<EPackage> getAllEPackages() {
		if(modelPackages != null) {
			return modelPackages;
		}
		modelPackages = new LinkedHashSet<EPackage>();
		Registry registry = EPackage.Registry.INSTANCE;

		for (Entry<String, Object> entry : registry.entrySet()) {
			try {
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
	
	public static Set<EPackage> getAllRootEPackages() {
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
	 * Retrieve all EClasses that are contained in <code>ePackage</code>. 
	 * 
	 * @param ePackage the package to get contained EClasses from
	 * @return a set of EClasses contained in <code>ePackage</code>
	 */
	public static Set<EClass> getAllEClasses(EPackage ePackage) {
		if(packageToModelElementEClasses.containsKey(ePackage)) {
			return packageToModelElementEClasses.get(ePackage);
		}
		if(ePackage == null) {
			packageToModelElementEClasses.put(ePackage, new LinkedHashSet<EClass>());
			return packageToModelElementEClasses.get(ePackage);	
		}
		Set<EClass> result = new LinkedHashSet<EClass>();
		for(EPackage subPackage : ePackage.getESubpackages()) {
			result.addAll(getAllEClasses(subPackage));
		}
		for(EClassifier classifier : ePackage.getEClassifiers()) {
			if(classifier instanceof EClass)
				result.add((EClass) classifier);
		}
		packageToModelElementEClasses.put(ePackage, result);
		return result;
	}
	
	/**
	 * Iterates over all registered EPackages to retrieve
	 * all available EClasses and returns them as a Set.
	 * 
	 * @return a set of all EClasses that are contained
	 * in registered EPackages
	 * 
	 * @see Registry
	 */
	public static Set<EClass> getAllEClasses() {
		if (allEClasses != null) {
			return allEClasses;
		}
		Set<EClass> result = new LinkedHashSet<EClass>();
		Registry registry = EPackage.Registry.INSTANCE;

		for (Entry<String, Object> entry : new LinkedHashSet<Entry<String, Object>>(registry.entrySet())) {
			try {
				EPackage ePackage = EPackage.Registry.INSTANCE.getEPackage(entry.getKey());
				result.addAll(getAllEClasses(ePackage));
			}
			// BEGIN SUPRESS CATCH EXCEPTION
			catch (RuntimeException exception) {
				// END SUPRESS CATCH EXCEPTION
				// logException("Failed to load model package " + entry.getKey(), exception);
			}

		}
		allEClasses = result;
		return result;
	}
	
	/**
	 * Returns all possible EClasses, excluding abstract classes and interfaces,
	 * that can be contained in <code>eClass</code>.
	 * 
	 * @param eClass the EClass to get containable EClasses for
	 * @return a set of all EClasses that can be contained in <code>eClass</code>
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
			if(!referenceType.isInterface() && !referenceType.isAbstract())
				result.add(referenceType);
			result.addAll(getAllSubEClasses(referenceType));
		}
		allEContainments.put(eClass, result);
		return result;
	}
	
	/**
	 * Returns all subclasses of an EClass, excluding abstract classes
	 * and interfaces.
	 * 
	 * @param eClass the EClass to get subclasses for
	 * @return all subclasses of <code>eClass</code>
	 */
	public static Set<EClass> getAllSubEClasses(EClass eClass) {
		if(eClassToSubEClasses.containsKey(eClass)) {
			return eClassToSubEClasses.get(eClass);
		}
		if(eClass == null) {
			eClassToSubEClasses.put(eClass, new LinkedHashSet<EClass>());
			return eClassToSubEClasses.get(eClass);
		}
		Set<EClass> allEClasses = getAllEClasses();
		if(EcorePackage.eINSTANCE.getEObject().equals(eClass))
			return allEClasses;
		Set<EClass> result = new LinkedHashSet<EClass>();
		for (EClass subClass : allEClasses) {
			if (eClass.isSuperTypeOf(subClass) && (!subClass.isAbstract()) && (!subClass.isInterface())) {
				result.add(subClass);
			}
		}
		eClassToSubEClasses.put(eClass, result);
		return result;
	}
	
	/**
	 * Returns all containing references where <code>parentClass</code> is 
	 * the container and <code>childClass</code> the containment.
	 * 
	 * @param childClass the EClass which shall be contained
	 * @param parentClass the EClass to get containment references from
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
	
	/**
	 * Returns all direct and indirect contents of <code>rootObject</code> as a map.
	 * All EObjects that appear in these contents are mapped to their corresponding
	 * EClass.
	 *  
	 * @param rootObject the EObject to get contents for
	 * @return all contents as a map from EClass to lists of EObjects
	 */
	public static Map<EClass, List<EObject>> getAllClassesAndObjects(EObject rootObject) {
		Map<EClass, List<EObject>> result = new LinkedHashMap<EClass, List<EObject>>();
		TreeIterator<EObject> allContents = rootObject.eAllContents();
		while(allContents.hasNext()) {
			EObject eObject = allContents.next();
			if(result.containsKey(eObject.eClass()))
				result.get(eObject.eClass()).add(eObject);
			else {
				List<EObject> newSet = new LinkedList<EObject>();
				newSet.add(eObject);
				result.put(eObject.eClass(), newSet);
			}
		}
		return result;
	}
	
	/**
	 * Returns all valid references for an EObject. This excludes container/containment references.
	 * A reference is valid if it is neither derived nor volatile and if it is changeable and
	 * either many-valued or not already set.
	 * 
	 * @param eObject the EObject to get references for
	 * @return all valid references as a list
	 */
	public static List<EReference> getValidReferences(EObject eObject) {
		List<EReference> result = new LinkedList<EReference>();
		for(EReference reference : eObject.eClass().getEAllReferences()) {
			if(!reference.isContainer() && !reference.isContainment() && reference.isChangeable() && !reference.isVolatile() && !reference.isDerived() && (reference.isMany() || !eObject.eIsSet(reference))) {
				result.add(reference);
			}
		}
		return result;
	}
	
	/**
	 * Handles <code>exception</code>, meaning it is thrown if <code>ignoreAndLog</code>
	 * is <code>false</code>. Otherwise <code>exception</code> is ignored and added to
	 * <code>exceptionLog</code>.
	 * 
	 * @param exception the exception to handle
	 * @param exceptionLog the current log of exceptions
	 * @param ignoreAndLog should exceptions be ignored and added to <code>exceptionLog</code>?
	 * @throws RuntimeException only if <code>ignoreAndLog</code> is <code>false</code>
	 */
	private static void handle(RuntimeException exception, Set<RuntimeException> exceptionLog,
		boolean ignoreAndLog) throws RuntimeException {
		if(ignoreAndLog)
			exceptionLog.add(exception);
		else
			throw exception;
	}
	
	/**
	 * Sets a feature between <code>parentEObject</code> and <code>newObject</code>
	 * using a SetCommand. Exceptions are caught if <code>ignoreAndLog</code> is
	 * true, otherwise a RuntimeException might be thrown if the command fails.  
	 * 
	 * @param parentEObject the EObject for which <code>feature</code> shall be set
	 * @param feature the EStructuralFeature that shall be set
	 * @param newObject the Object that shall be set as a feature in <code>parentEObject</code>
	 * @param exceptionLog the current log of exceptions
	 * @param ignoreAndLog should exceptions be ignored and added to <code>exceptionLog</code>??
	 * @return <code>newObject</code> if the <code>SetCommand</code> was performed successful
	 * or <code>null</code> if it failed
	 * @throws RuntimeException only if <code>ignoreAndLog</code> is <code>false</code>
	 * @see SetCommand
	 */
	public static EObject setPerCommand(EObject parentEObject, EStructuralFeature feature, Object newObject,
		Set<RuntimeException> exceptionLog, boolean ignoreAndLog) throws RuntimeException {
		EditingDomain domain = AdapterFactoryEditingDomain.getEditingDomainFor(parentEObject);
		try {
			new SetCommand(domain, parentEObject, feature, newObject).doExecute();
			if(newObject instanceof EObject)
				return (EObject) newObject;
			else return null;
		} catch(RuntimeException e){
			handle(e, exceptionLog, ignoreAndLog);
			return null;
		}
	}

	/**
	 * Adds <code>newObject</code> to the many-valued feature of 
	 * <code>parentEObject</code> using an AddCommand. 
	 * Exceptions are caught if <code>ignoreAndLog</code> is
	 * true, otherwise a RuntimeException might be thrown if the command fails.  
	 * 
	 * @param parentEObject the EObject to which <code>newObject</code> shall be added
	 * @param feature the EStructuralFeature that <code>newObject</code> shall be added to
	 * @param newObject the Object that shall be added to <code>feature</code>
	 * @param exceptionLog the current log of exceptions
	 * @param ignoreAndLog should exceptions be ignored and added to <code>exceptionLog</code>?
	 * @return <code>newObject</code> if the <code>AddCommand</code> was performed successful
	 * or <code>null</code> if it failed
	 * @throws RuntimeException only if <code>ignoreAndLog</code> is <code>false</code>
	 * @see AddCommand#AddCommand(EditingDomain, EObject, EStructuralFeature, Object)
	 */
	public static EObject addPerCommand(EObject parentEObject, EStructuralFeature feature, Object newObject,
		Set<RuntimeException> exceptionLog, boolean ignoreAndLog) throws RuntimeException {
		EditingDomain domain = AdapterFactoryEditingDomain.getEditingDomainFor(parentEObject);
		try {
			new AddCommand(domain, parentEObject, feature, newObject).doExecute();
			if(newObject instanceof EObject)
				return (EObject) newObject;
			else return null;
		} catch(RuntimeException e){
			handle(e, exceptionLog, ignoreAndLog);
			return null;
		}
	}
	
	/**
	 * Adds all <code>objects</code> to the many-valued feature of 
	 * <code>parentEObject</code> using an AddCommand. 
	 * Exceptions are caught if <code>ignoreAndLog</code> is
	 * true, otherwise a RuntimeException might be thrown if the command fails.  
	 * 
	 * @param parentEObject the EObject to which <code>objects</code> shall be added
	 * @param feature the EReference that <code>newEObject</code> shall be added to
	 * @param objects collection of objects that shall be added to <code>feature</code>
	 * @param exceptionLog the current log of exceptions
	 * @param ignoreAndLog should exceptions be ignored and added to <code>exceptionLog</code>?
	 * @throws RuntimeException only if <code>ignoreAndLog</code> is <code>false</code>
	 */
	public static void addPerCommand(EObject parentEObject, EStructuralFeature feature, Collection<?> objects,
		Set<RuntimeException> exceptionLog, boolean ignoreAndLog) throws RuntimeException {
		EditingDomain domain = AdapterFactoryEditingDomain.getEditingDomainFor(parentEObject);
		try {
			new AddCommand(domain, parentEObject, feature, objects).doExecute();
		} catch(RuntimeException e) {
			handle(e, exceptionLog, ignoreAndLog);
		}
	}
	
	/**
	 * Removes <code>objects</code> from a feature of <code>parentEObject</code>
	 * using a RemoveCommand. Exceptions are caught if <code>ignoreAndLog</code> is
	 * true, otherwise a RuntimeException might be thrown if the command fails.  
	 * 
	 * @param parentEObject the EObject to remove <code>objects</code> from
	 * @param feature the EStructuralFeature <code>object</code> shall be removed from
	 * @param objects collection of Objects that shall be removed
	 * @param exceptionLog the current log of exceptions
	 * @param ignoreAndLog should exceptions be ignored and added to <code>exceptionLog</code>?
	 * @throws RuntimeException only if <code>ignoreAndLog</code> is <code>false</code>
	 * @see RemoveCommand
	 */
	public static void removePerCommand(EObject parentEObject, EStructuralFeature feature, Collection<?> objects,
		Set<RuntimeException> exceptionLog, boolean ignoreAndLog) throws RuntimeException {
		EditingDomain domain = AdapterFactoryEditingDomain.getEditingDomainFor(parentEObject);
		try {
			new RemoveCommand(domain, parentEObject, feature, objects).doExecute();
		} catch(RuntimeException e){
			handle(e, exceptionLog, ignoreAndLog);
		}
	}
	
	/**
	 * Retrieves all EClasses that can possibly be referenced by <code>reference</code>
	 * from <code>allEClasses</code> and returns them as a list.
	 * 
	 * @param reference the EReference to get EClasses for
	 * @param allEClasses set of all possible EClasses
	 * @return list of all EClasses that can be referenced by <code>reference</code>
	 */
	public static List<EClass> getReferenceClasses(EReference reference, Set<EClass> allEClasses) {
		List<EClass> result = new LinkedList<EClass>();
		EClass referenceType = reference.getEReferenceType();
		result.add(referenceType);
		if(referenceType.equals(EcorePackage.eINSTANCE.getEObject())) {
			result.addAll(allEClasses);
			return result;
		}
		for(EClass eClass : allEClasses) {
			if(referenceType.isSuperTypeOf(eClass)) {
				result.add(eClass);
			}
		}
		return result;
	}
	
	/**
	 * Sets or adds to a reference for an EObject with any generated instance
	 * of <code>referenceClass</code> using SetCommand/AddCommand. If the reference is 
	 * not required, <code>random</code> decides whether the reference is set or how 
	 * many EObjects are added to it.
	 *  
	 * @param eObject the EObject to set the reference for
	 * @param referenceClass the EClass all referenced EObject shall be instances of
	 * @param reference the reference to set
	 * @param random the Random-object that randomizes EObjects and their amount
	 * @param exceptionLog the current log of exceptions
	 * @param ignoreAndLog should exceptions be ignored and added to <code>exceptionLog</code>?
	 * @param allEObjects all existing EObjects mapped to their EClass
	 * 
	 * @see #addPerCommand(EObject, EStructuralFeature, Collection, Set, boolean)
	 * @see #addPerCommand(EObject, EStructuralFeature, Object, Set, boolean)
	 * @see #setPerCommand(EObject, EStructuralFeature, Object, Set, boolean)
	 */
	public static void setReference(EObject eObject, EClass referenceClass, EReference reference,
		Random random, Set<RuntimeException> exceptionLog, boolean ignoreAndLog, Map<EClass, List<EObject>> allEObjects) {
		List<EObject> possibleReferenceObjects = allEObjects.get(referenceClass); 
		Collections.shuffle(possibleReferenceObjects, random);
		if(!possibleReferenceObjects.isEmpty()) {
			int index = 0;
			if(reference.isMany()) {
				int maxObjects = random.nextInt(3);
				if(reference.isRequired()) maxObjects++;
				for(int i = 0; i < maxObjects; i++) {
					ModelGeneratorUtil.addPerCommand(eObject, reference, possibleReferenceObjects.get(index),
						exceptionLog, ignoreAndLog);
					if(++index==possibleReferenceObjects.size()) break;
				}
			} else if (reference.isRequired() || random.nextBoolean()){
				ModelGeneratorUtil.setPerCommand(eObject, reference, possibleReferenceObjects.get(index),
					exceptionLog, ignoreAndLog);
			}
		}
	}

	/**
	 * Sets all possible attributes of known types to random values using {@link IAttributeSetter}
	 * and SetCommands/AddCommands.
	 * 
	 * @param eObject the EObject to set attributes for
	 * @param attrHandler the AttributeHandler that grants access to the AttributeSetters
	 * @param exceptionLog the current log of exceptions
	 * @param ignoreAndLog should exceptions be ignored and added to <code>exceptionLog</code>?
	 * @see IAttributeSetter
	 * @see AttributeHandler
	 * @see #addPerCommand(EObject, EStructuralFeature, Collection, Set, boolean)
	 * @see #addPerCommand(EObject, EStructuralFeature, Object, Set, boolean)
	 * @see #setPerCommand(EObject, EStructuralFeature, Object, Set, boolean)
	 */
	public static void setEObjectAttributes(EObject eObject, AttributeHandler attrHandler,
		Set<RuntimeException> exceptionLog, boolean ignoreAndLog) {
		Map<EClassifier, IAttributeSetter<?>> attributeSetters = attrHandler.getAttributeSetters();
		
		for(EAttribute attribute : eObject.eClass().getEAllAttributes()) {
			EClassifier attributeType = attribute.getEType();
			
			if(!attribute.isChangeable() || attribute.isDerived() || attribute.isVolatile())
				continue;
			if (attributeSetters.containsKey(attributeType)) {
				if (attribute.isMany()) {
					addPerCommand(eObject, attribute,
						attributeSetters.get(attributeType).createNewAttributes(), exceptionLog, ignoreAndLog);
				}
				else {
					setPerCommand(eObject, attribute,
						attributeSetters.get(attributeType).createNewAttribute(), exceptionLog, ignoreAndLog);
				}
			}				
		}
	}
}
