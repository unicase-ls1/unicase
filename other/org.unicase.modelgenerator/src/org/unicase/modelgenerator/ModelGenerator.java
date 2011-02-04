package org.unicase.modelgenerator;

import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;
import org.unicase.modelgenerator.common.ModelGeneratorConfiguration;
import org.unicase.modelgenerator.common.ModelGeneratorUtil;

/**
 * Class for generating Ecore models, static methods only.
 * Generating a model includes:<br>
 * - creating EObjects from a certain model package<br>
 * - building up a hierarchy starting from a certain root EObject<br>
 * - setting random attributes for every created EObject<br>
 * - setting references between the EObjects
 *
 * @see #generateModel(EPackage, EObject)
 * @see #generateModel(ModelGeneratorConfiguration)
 * @see #generateModel(ModelGeneratorConfiguration, IProgressMonitor)
 */
public class ModelGenerator {

	/**
	 * The configuration containing settings for the generation process.
	 * 
	 * @see ModelGeneratorConfiguration
	 */
	private static ModelGeneratorConfiguration config;
	
	/**
	 * Private constructor.
	 */
	private ModelGenerator() {
		// all methods should be accessed in a static way
	}
	
	/**
	 * Generates EObjects for a certain model indicated by <code>modelPackage</code> and adds them 
	 * as children to <code>rootEObject</code>, setting attributes and references. This method uses
	 * default values for <code>width, depth, seed</code> and <code>ignoreAndLog</code>.<p>
	 * This method call is equivalent to<br>
	 * <code>generateModel(new ModelGeneratorConfiguration(modelPackage, rootEObject))</code>.
	 * 
	 * @param modelPackage the EPackage to create new EObjects from
	 * @param rootEObject the EObject that shall be the root container for all generated EObjects
	 * @return the validated root EObject of the resulting Ecore hierarchy
	 */
	public static EObject generateModel(EPackage modelPackage, EObject rootEObject) {
		return generateModel(new ModelGeneratorConfiguration(modelPackage, rootEObject));
	}
	
	/**
	 * Generates EObjects using the settings specified in <code>config</code>.
	 * 
	 * @param configuration the ModelGeneratorConfiguration to use for generating EObjects
	 * @return the validated root EObject of the resulting Ecore hierarchy
	 * @see ModelGeneratorConfiguration
	 */
	public static EObject generateModel(ModelGeneratorConfiguration configuration) {
		config = configuration;
		ModelGeneratorHelper.init(config);
		EObject rootEObject = generateModel();
		Map<EClass, List<EObject>> allObjectsByEClass = ModelGeneratorUtil.getAllClassesAndObjects(rootEObject);
		for(EClass eClass : allObjectsByEClass.keySet()) {
			for(EObject generatedEObject : allObjectsByEClass.get(eClass)) {
				generateReferences(generatedEObject, allObjectsByEClass);			
			}
		}
		return rootEObject;
	}
	
	/**
	 * Generates EObjects using the settings specified in <code>config</code>, showing
	 * a ProgressBar during the generation process. This also allows to cancel the process.
	 * 
	 * @param configuration the ModelGeneratorConfiguration to use for generating EObjects
	 * @param monitor the progress of the generation process
	 * @return the validated root EObject of the resulting Ecore hierarchy
	 * @see ModelGeneratorConfiguration
	 */
	public static EObject generateModel(ModelGeneratorConfiguration configuration, IProgressMonitor monitor) {
		config = configuration;
		ModelGeneratorHelper.init(config);
		monitor.beginTask("Generation progress", ModelGeneratorHelper.computeAmountOfWork());
		EObject rootEObject = generateModel(monitor);
		Map<EClass, List<EObject>> allObjectsByEClass = ModelGeneratorUtil.getAllClassesAndObjects(rootEObject);
		for(EClass eClass : allObjectsByEClass.keySet()) {
			if(monitor.isCanceled())
				break;
			for(EObject generatedEObject : allObjectsByEClass.get(eClass)) {
				if(monitor.isCanceled())
					break;
				generateReferences(generatedEObject, allObjectsByEClass);		
			}
		}
		monitor.done();
		return rootEObject;
	}
	
	/**
	 * The method that actually performs the generation. This can only be
	 * accessed by calling {@link #generateModel(EPackage, EObject)} or
	 * {@link #generateModel(ModelGeneratorConfiguration)}
	 * 
	 * @return the valid root EObject used for generating the model
	 * @see #generateModel(EPackage, EObject)
	 * @see #generateModel(ModelGeneratorConfiguration)
	 */
	private static EObject generateModel() {
		EObject rootEObject = ModelGeneratorHelper.validateRoot(config.getRootEObject());
		List<EObject> remainingObjects = new LinkedList<EObject>();
		remainingObjects.add(rootEObject);
		int currentDepth = 1;
		int remainingElementsInThisDepth = config.getWidth();
		while(!remainingObjects.isEmpty()) {
			EObject nextParentEObject = remainingObjects.remove(0);
			List<EObject> children = generateChildren(nextParentEObject); 
			if(currentDepth < config.getDepth())
				remainingObjects.addAll(children);
			remainingElementsInThisDepth -= config.getWidth();
			if(remainingElementsInThisDepth <= 0) {
				currentDepth++;
				remainingElementsInThisDepth = (int) Math.pow(config.getWidth(), currentDepth);
			}
		}
		return rootEObject;
	}
	
	
	/**
	 * The method that actually performs the generation. This can only be
	 * accessed by calling {@link #generateModel(ModelGeneratorConfiguration, IProgressMonitor)}.
	 * Shows a progress bar during the generation process. This also allows
	 * to cancel the process.
	 * 
	 * @param monitor the progress of the generation process
	 * @return the valid root EObject used for generating the model
	 * @see #generateModel(ModelGeneratorConfiguration, IProgressMonitor)
	 */
	private static EObject generateModel(IProgressMonitor monitor) {
		EObject rootEObject = ModelGeneratorHelper.validateRoot(config.getRootEObject());
		List<EObject> remainingObjects = new LinkedList<EObject>();
		remainingObjects.add(rootEObject);
		int currentDepth = 1;
		int remainingElementsInThisDepth = config.getWidth();
		while(!remainingObjects.isEmpty()) {
			if(monitor.isCanceled()) {
				break;
			}
			EObject nextParentEObject = remainingObjects.remove(0);
			List<EObject> children = generateChildren(nextParentEObject); 
			if(currentDepth < config.getDepth())
				remainingObjects.addAll(children);
			remainingElementsInThisDepth -= config.getWidth();
			if(remainingElementsInThisDepth <= 0) {
				currentDepth++;
				remainingElementsInThisDepth = (int) Math.pow(config.getWidth(), currentDepth);
			}
			monitor.worked(config.getWidth());
		}
		return rootEObject;
	}
	
	/**
	 * Generates children for a certain parent EObject. Generation includes
	 * setting containment references and attributes.
	 * @param parentEObject the EObject to generate children for
	 * @return all generated children as a list
	 */
	private static List<EObject> generateChildren(EObject parentEObject) {
		List<EObject> result = new LinkedList<EObject>();
		int index = ModelGeneratorHelper.getStartingIndex(parentEObject.eClass());
		List<EClass> elementsToCreate = ModelGeneratorHelper.getElementsToCreate(parentEObject.eClass());
		EClass currentChildClass = ModelGeneratorHelper.getNextClassToCreate(elementsToCreate, index);
		int createdChildren = 0;
		while(currentChildClass != null && createdChildren<config.getWidth()) {
			List<EReference> validReferences = ModelGeneratorHelper.getValidContainmentReferences(currentChildClass, parentEObject);
			if(validReferences.isEmpty())
				elementsToCreate.remove(currentChildClass);
			for(EReference reference : validReferences) {
				if(createdChildren>=config.getWidth())
					break;
				EObject newChild = ModelGeneratorHelper.setContainment(parentEObject, currentChildClass, reference);
				createdChildren++;
				if(newChild!=null) {
					result.add(newChild);
				}
			}
			currentChildClass = ModelGeneratorHelper.getNextClassToCreate(elementsToCreate, ++index);
		}
		ModelGeneratorHelper.updateIndex(parentEObject.eClass(), index);
		return result;
	}

	/**
	 * Returns the Exception-Log for the last {@link #generateModel()}-call.
	 * The log is empty if no RuntimeException occurred or <code>ignoreAndLog</code>
	 * was set to <code>false</code> in the last configuration used.
	 * 
	 * @return a set of RuntimeExceptions that occurred during the last generation process
	 */
	public static Set<RuntimeException> getLog() {
		return ModelGeneratorHelper.getExceptionLog();
	}

	/**
	 * Generates references (no containment references) for an EObject.
	 * All valid references are set with EObjects generated during the generation process.
	 * 
	 * @param eObject the EObject to set references for
	 * @param allObjectsByEClass all possible EObjects that can be referenced, mapped to their EClass 
	 * @see ModelGeneratorHelper#setReference(EObject, EClass, EReference, Map)
	 */
	private static void generateReferences(EObject eObject, Map<EClass, List<EObject>> allObjectsByEClass) {
		for(EReference reference : ModelGeneratorUtil.getValidReferences(eObject)) {
			for(EClass nextReferenceClass : ModelGeneratorUtil.getReferenceClasses(reference, allObjectsByEClass.keySet())) {
				if(allObjectsByEClass.containsKey(nextReferenceClass)) {
					ModelGeneratorHelper.setReference(eObject, nextReferenceClass, reference, allObjectsByEClass);
				}
			}
		}
	}
}
