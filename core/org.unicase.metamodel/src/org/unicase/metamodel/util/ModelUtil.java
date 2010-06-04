/**
 * <copyright> Copyright (c) 2008-2009 Jonas Helming, Maximilian Koegel. All rights reserved. This program and the
 * accompanying materials are made available under the terms of the Eclipse Public License v1.0 which accompanies this
 * distribution, and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>
 */
package org.unicase.metamodel.util;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.StringTokenizer;
import java.util.Map.Entry;

import org.eclipse.core.runtime.IConfigurationElement;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Platform;
import org.eclipse.core.runtime.Status;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.EcorePackage;
import org.eclipse.emf.ecore.EPackage.Registry;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.unicase.metamodel.MetamodelFactory;
import org.unicase.metamodel.MetamodelPackage;
import org.unicase.metamodel.ModelElement;
import org.unicase.metamodel.ModelElementId;
import org.unicase.metamodel.Project;

/**
 * Utility class for ModelElements.
 * 
 * @author koegel
 */
public final class ModelUtil {

	/**
	 * Text marker for the begin of the plaintext in rich text attributes.
	 */
	public static final String BEGINTEXT_TOKEN = "%BEGINNTEXT%";

	/**
	 * URI used to serialize EObject with the model util.
	 */
	public static final URI VIRTUAL_URI = URI.createURI("virtualUnicaseUri");

	/**
	 * Private constructor.
	 */
	private ModelUtil() {
		// nothing to do
	}

	/**
	 * Copy a model element and its containment tree. The new model element and all its children have new unique ids.
	 * Cross-referenced elements will not be copied.
	 * 
	 * @param modelElement the model element
	 * @return a copy of the given model element and its containment tree
	 */
	public static ModelElement copy(ModelElement modelElement) {
		ModelElement copy = (ModelElement) EcoreUtil.copy(modelElement);
		// reset id
		ModelElementId modelElementId = MetamodelFactory.eINSTANCE.createModelElementId();
		copy.setIdentifier(modelElementId.getId());
		// reset ids of containment children
		for (ModelElement child : copy.getAllContainedModelElements()) {
			ModelElementId childId = MetamodelFactory.eINSTANCE.createModelElementId();
			child.setIdentifier(childId.getId());
		}
		return copy;
	}

	/**
	 * Creates a ModelElementId object from a string.
	 * 
	 * @param id as string
	 * @return id as object
	 */
	public static ModelElementId createModelElementId(String id) {
		ModelElementId modelElementId = MetamodelFactory.eINSTANCE.createModelElementId();
		modelElementId.setId(id);
		return modelElementId;
	}

	/**
	 * Gives all eClasses which can be contained in a given eClass.
	 * 
	 * @param eClass the EClass
	 * @return all Classes which can be contained
	 */
	public static Set<EClass> getAllEContainments(EClass eClass) {
		List<EReference> containments = eClass.getEAllContainments();
		Set<EClass> eClazz = new HashSet<EClass>();
		for (EReference ref : containments) {
			EClass eReferenceType = ref.getEReferenceType();
			eClazz.addAll(getAllSubEClasses(eReferenceType));
		}
		return eClazz;
	}

	/**
	 * @param newMEInstance {@link ModelElement} the new modelElement instance.
	 * @return EReference the Container
	 * @param parent The EObject to get conatinment references from
	 */
	public static EReference getPossibleContainingReference(final ModelElement newMEInstance, EObject parent) {
		// the value of the 'EAll Containments' reference list.
		List<EReference> eallcontainments = parent.eClass().getEAllContainments();
		EReference reference = null;
		for (EReference containmentitem : eallcontainments) {

			if (containmentitem.getEReferenceType().equals(newMEInstance)) {
				reference = containmentitem;

				break;
			} else if (containmentitem.getEReferenceType().isSuperTypeOf(newMEInstance.eClass())) {

				reference = containmentitem;
				break;
			}
		}
		return reference;
	}

	/**
	 * Compares to projects. Two projects are equal if all model elements are equal.
	 * 
	 * @param projectA the first project
	 * @param projectB the second project
	 * @return true if the projects are equal
	 */
	public static boolean areEqual(Project projectA, Project projectB) {
		String stringA;
		String stringB;
		try {
			stringA = eObjectToString(projectA);
			stringB = eObjectToString(projectB);
		} catch (SerializationException e) {
			return false;
		}
		return stringA.equals(stringB);

	}

	/**
	 * Converts an EObject to a String.
	 * 
	 * @param object the eObject
	 * @return String representation of the EObject
	 * @throws SerializationException if a serialization problem occurs
	 */
	public static String eObjectToString(EObject object) throws SerializationException {
		return eObjectToString(object, false);
	}

	/**
	 * Converts an EObject to a String.
	 * 
	 * @param object the eObject
	 * @param overrideContainmentCheck if true, no containment check
	 * @return String representation of the EObject
	 * @throws SerializationException if a serialization problem occurs
	 */
	public static String eObjectToString(EObject object, boolean overrideContainmentCheck)
		throws SerializationException {
		if (object == null) {
			return null;
		}

		Resource res = (new ResourceSetImpl()).createResource(VIRTUAL_URI);
		ByteArrayOutputStream out = new ByteArrayOutputStream();

		if (!overrideContainmentCheck && !(object instanceof EClass)) {
			if (!isSelfContained(object)) {
				throw new SerializationException(object);
			}
		}

		EObject copy = EcoreUtil.copy(object);

		res.getContents().add(copy);

		try {
			res.save(out, null);
		} catch (IOException e) {
			throw new SerializationException(e);
		}
		return out.toString();
	}

	@SuppressWarnings("unchecked")
	private static Set<EObject> getNonTransientContents(EObject object) {
		Set<EObject> result = new HashSet<EObject>();
		if (object == null) {
			return result;
		}
		for (EReference containmentReference : object.eClass().getEAllContainments()) {
			if (!containmentReference.isTransient()) {
				Object contentObject = object.eGet(containmentReference, true);
				if (containmentReference.isMany()) {
					EList<? extends EObject> contentList = (EList<? extends EObject>) contentObject;
					for (EObject content : contentList) {
						result.add(content);
						result.addAll(getNonTransientContents(content));
					}
				} else {
					EObject content = (EObject) contentObject;
					if (content == null) {
						continue;
					}
					result.add(content);
					result.addAll(getNonTransientContents(content));
				}
			}
		}
		return result;
	}

	@SuppressWarnings("unchecked")
	private static Set<EObject> getNonTransientCrossReferences(EObject object) {
		Set<EObject> result = new HashSet<EObject>();
		if (object == null) {
			return result;
		}
		for (EReference reference : object.eClass().getEAllReferences()) {
			if (!reference.isTransient()) {
				Object referenceObject = object.eGet(reference, true);
				if (reference.isMany()) {
					EList<? extends EObject> referencesList = (EList<? extends EObject>) referenceObject;
					result.addAll(referencesList);
				} else {
					EObject crossReference = (EObject) referenceObject;
					if (crossReference == null) {
						continue;
					}
					result.add(crossReference);
				}
			}
		}
		return result;
	}

	/**
	 * Check an Eobject and its containment tree whether it is selfcontained. A containment tree is self contained if it
	 * does not have references to eobjects outside the tree.
	 * 
	 * @param object the eObject
	 * @return true if it is selfcontained
	 */
	public static boolean isSelfContained(EObject object) {
		return isSelfContained(object, false);
	}

	/**
	 * Check an Eobject and its containment tree whether it is selfcontained. A containment tree is self contained if it
	 * does not have references to eobjects outside the tree.
	 * 
	 * @param object the eObject
	 * @param ignoreContainer true if references of object to its container should be ignored in the check.
	 * @return true if it is selfcontained
	 */
	public static boolean isSelfContained(EObject object, boolean ignoreContainer) {
		Set<EObject> allChildEObjects = getNonTransientContents(object);
		Set<EObject> allEObjects = new HashSet<EObject>(allChildEObjects);
		allEObjects.add(object);

		Set<EObject> nonTransientCrossReferences = getNonTransientCrossReferences(object);
		if (ignoreContainer && object.eContainer() != null) {
			nonTransientCrossReferences.remove(object.eContainer());
		}
		if (!allEObjects.containsAll(nonTransientCrossReferences)) {
			return false;
		}

		// check if only cross references to known elements exist
		for (EObject content : allChildEObjects) {
			if (!allEObjects.containsAll(getNonTransientCrossReferences(content))) {
				return false;
			}
		}
		return true;
	}

	/**
	 * Converts a String to an EObject. Note: String must be the result of
	 * {@link SerializationUtil#eObjectToString(EObject)}
	 * 
	 * @param object the String representation of the EObject
	 * @return the deserialized EObject
	 * @throws SerializationException if deserialization fails
	 */
	public static EObject stringToEObject(String object) throws SerializationException {
		if (object == null) {
			return null;
		}
		Resource res = (new ResourceSetImpl()).createResource(VIRTUAL_URI);
		try {
			res.load(new ByteArrayInputStream(object.getBytes("UTF-8")), null);
		} catch (UnsupportedEncodingException e) {
			throw new SerializationException(e);
		} catch (IOException e) {
			throw new SerializationException(e);
		}

		EObject result = res.getContents().get(0);
		res.getContents().remove(result);
		return result;
	}

	/**
	 * Returns all non-abstract, non-interface subclasses of the given input class in the given package. In other words
	 * returns all classes that have direct instances.
	 * 
	 * @param clazz the eClass, must be a subtype of ModelElement
	 * @return a set of EClasses IMPORTANT: Will throw an IllegalArgumentException if given EClass is not a subtype of
	 *         ModelElement
	 */
	public static Set<EClass> getSubclasses(EClass clazz) {
		return getSubclasses(clazz, false);
	}

	/**
	 * Returns all subclasses of the given input class in the given package.
	 * 
	 * @param clazz the eClass, must be a subtype of ModelElement
	 * @param includeAbstractClassesAndInterfaces true if interfaces and abstract classes should be included in the
	 *            result
	 * @return a set of EClasses IMPORTANT: Will throw an IllegalArgumentException if given EClass is not a subtype of
	 *         ModelElement
	 */
	public static Set<EClass> getSubclasses(EClass clazz, boolean includeAbstractClassesAndInterfaces) {
		// sanity checks
		EClass modelELementEClass = MetamodelPackage.eINSTANCE.getModelElement();
		if (!modelELementEClass.isSuperTypeOf(clazz)) {
			throw new IllegalStateException("Given EClass \"" + clazz.getName()
				+ "\" is not a subtype of EClass ModelElement");
		}

		Set<EClass> ret = new HashSet<EClass>();
		for (EPackage ePackage : getAllModelPackages()) {
			getSubclasses(clazz, ret, ePackage, includeAbstractClassesAndInterfaces);
		}
		return ret;
	}

	private static void getSubclasses(EClass clazz, Set<EClass> ret, EPackage ePackage,
		boolean includeAbstractClassesAndInterfaces) {

		for (EClassifier classifier : ePackage.getEClassifiers()) {
			if (EcorePackage.eINSTANCE.getEClass().isInstance(classifier)) {
				EClass subClass = (EClass) classifier;
				if (clazz.isSuperTypeOf(subClass)
					&& (includeAbstractClassesAndInterfaces || canHaveInstances(subClass))) {
					ret.add(subClass);
				}
			}
		}
		for (EPackage subPackage : ePackage.getESubpackages()) {
			getSubclasses(clazz, ret, subPackage, includeAbstractClassesAndInterfaces);
		}
	}

	private static boolean canHaveInstances(EClass eClass) {
		return !(eClass.isAbstract() || eClass.isInterface());
	}

	/**
	 * Retrieve all EPackages that are model packages for unicase starting with the unicase model prefix as defined in
	 * {@link MetamodelPackage}.
	 * 
	 * @return a set of EPackages
	 */
	public static Set<EPackage> getAllModelPackages() {
		Set<EPackage> result = new HashSet<EPackage>();
		Registry registry = EPackage.Registry.INSTANCE;

		for (Entry<String, Object> entry : registry.entrySet()) {
			if (entry.getKey().startsWith(MetamodelPackage.MODEL_URL_PREFIX)) {
				try {
					EPackage model = EPackage.Registry.INSTANCE.getEPackage(entry.getKey());
					result.add(model);
				}
				// BEGIN SUPRESS CATCH EXCEPTION
				catch (RuntimeException exception) {
					// END SUPRESS CATCH EXCEPTION
					logException("Failed to load model package " + entry.getKey(), exception);
				}
			}
		}
		return result;
	}

	private static Set<EClass> modelElementEClasses;

	/**
	 * Retrieve all EClasses from the Ecore package registry that are subclasses of the given EClass. Does not include
	 * abstract classes or interfaces.
	 * 
	 * @param eClass the superClass of the subClasses to retrieve
	 * @return a set of EClasses
	 */
	public static Set<EClass> getAllSubEClasses(EClass eClass) {
		Set<EClass> allEClasses = getAllModelElementEClasses();
		Set<EClass> result = new HashSet<EClass>();
		for (EClass subClass : allEClasses) {
			if (eClass.isSuperTypeOf(subClass) && (!subClass.isAbstract()) && (!subClass.isInterface())) {
				result.add(subClass);
			}
		}
		return result;
	}

	/**
	 * Retrieve all EClasses from the Ecore package registry that are model element subclasses.
	 * 
	 * @return a set of EClasses
	 */
	public static Set<EClass> getAllModelElementEClasses() {
		if (modelElementEClasses != null) {
			return new HashSet<EClass>(modelElementEClasses);
		}
		Set<EClass> result = new HashSet<EClass>();
		Registry registry = EPackage.Registry.INSTANCE;

		for (Entry<String, Object> entry : new HashSet<Entry<String, Object>>(registry.entrySet())) {
			try {
				EPackage ePackage = EPackage.Registry.INSTANCE.getEPackage(entry.getKey());
				result.addAll(getAllModelElementEClasses(ePackage));			}
			// BEGIN SUPRESS CATCH EXCEPTION
			catch (RuntimeException exception) {
				// END SUPRESS CATCH EXCEPTION
				logException("Failed to load model package " + entry.getKey(), exception);
			}

		}
		modelElementEClasses = result;
		return result;
	}

	/**
	 * Retrieve all EClasses from the Ecore package that are model element subclasses.
	 * 
	 * @param ePackage the package to get the classes from
	 * @return a set of EClasses
	 */
	private static Set<EClass> getAllModelElementEClasses(EPackage ePackage) {
		Set<EClass> result = new HashSet<EClass>();
		for (EPackage subPackage : ePackage.getESubpackages()) {
			result.addAll(getAllModelElementEClasses(subPackage));
		}
		for (EClassifier classifier : ePackage.getEClassifiers()) {
			if (classifier instanceof EClass) {
				EClass subEClass = (EClass) classifier;
				if (MetamodelPackage.eINSTANCE.getModelElement().isSuperTypeOf(subEClass)) {
					result.add(subEClass);
				}
			}
		}
		return result;
	}

	// /**
	// * @param clazz the input super class
	// * @return Returns all non-abstract, non-interface subclasses of the given input. Looks in whole graph starting
	// from
	// * the root package - i.e. ModelPackage.
	// */
	// public static ArrayList<EClass> getSubclasses(EClass clazz) {
	// return getSubclasses(clazz, MetamodelPackage.eINSTANCE);
	// }

	/**
	 * Recursively goes through model and create a list of all non-Abstract classes.
	 * 
	 * @param ePackage the package to start with.
	 * @return list of all non-Abstract model element classes in starting package and its sub-packages
	 */
	public static Set<EClass> getNonAbstractMETypes(EPackage ePackage) {

		Set<EClass> nonAbstractMETypes = new HashSet<EClass>();
		Set<EClass> allMETypes = getAllMETypes(ePackage);

		Iterator<EClass> iterator = allMETypes.iterator();
		while (iterator.hasNext()) {
			EClass eClass = iterator.next();
			if (canHaveInstances(eClass)) {
				nonAbstractMETypes.add(eClass);
			}
		}

		return nonAbstractMETypes;

	}

	/**
	 * Recursively goes through package and returns a list of all EClasses inheriting ModelElement (abstract classes and
	 * interfaces are also include).
	 * 
	 * @param ePackage starting package
	 * @return a list of all EClasses inheriting ModelElement (inclusive abstract classes and interfaces) in starting
	 *         package and all its sub-packages.
	 */
	public static Set<EClass> getAllMETypes(EPackage ePackage) {
		EClass modelElementEClass = MetamodelPackage.eINSTANCE.getModelElement();
		Set<EClass> meTypes = new HashSet<EClass>();

		for (EObject eObject : ePackage.eContents()) {
			if (eObject instanceof EClass) {
				EClass eClass = (EClass) eObject;
				if (modelElementEClass.isSuperTypeOf(eClass)) {
					meTypes.add(eClass);
				}
			} else if (eObject instanceof EPackage) {
				EPackage eSubPackage = (EPackage) eObject;
				meTypes.addAll(getAllMETypes(eSubPackage));
			}
		}

		return meTypes;
	}

	/**
	 * FU!
	 * 
	 * @param collection fu!
	 * @param modelElement fu!
	 * @return fu!
	 */
	public static boolean listContains(Collection<? extends ModelElement> collection, ModelElement modelElement) {
		for (ModelElement me : collection) {
			if (me.getIdentifier().equals(modelElement.getIdentifier()) || me == modelElement) {
				return true;
			}
		}
		return false;
	}

	/**
	 * This will add a new entry to error log view of eclipse.
	 * 
	 * @param message message
	 * @param exception exception
	 * @param statusInt severity. Use one of constants in org.eclipse.core.runtime.Status class.
	 */
	public static void log(String message, Throwable exception, int statusInt) {
		Status status = new Status(statusInt, Platform.getBundle("org.unicase.metamodel").getSymbolicName(), statusInt,
			message, exception);
		Platform.getLog(Platform.getBundle("org.unicase.metamodel")).log(status);
	}

	/**
	 * Log an exception to the platform log. This will create a popup in the ui.
	 * 
	 * @param message the message
	 * @param exception the exception
	 */
	public static void logException(String message, Throwable exception) {
		log(message, exception, IStatus.ERROR);
	}

	/**
	 * Log an exception to the platform log. This will create a popup in the ui.
	 * 
	 * @param exception the exception
	 */
	public static void logException(Throwable exception) {
		logException(exception.getMessage(), exception);
	}

	/**
	 * Log an exception to the platform log. This will create a popup in the ui.
	 * 
	 * @param message the message
	 * @param exception the exception
	 */
	public static void logWarning(String message, Throwable exception) {
		log(message, exception, IStatus.WARNING);
	}

	/**
	 * Log an exception to the platform log. This will create a popup in the ui.
	 * 
	 * @param message the message
	 */
	public static void logWarning(String message) {
		log(message, null, IStatus.WARNING);
	}

	/**
	 * Log an exception to the platform log. This will create a popup in the ui.
	 * 
	 * @param message the message
	 */
	public static void logInfo(String message) {
		log(message, null, IStatus.INFO);
	}

	/**
	 * Clone any EObject.
	 * 
	 * @param <T> the Eobject sub type
	 * @param eObject the Eobject instance
	 * @return a clone of the Eobject instance
	 */
	@SuppressWarnings("unchecked")
	public static <T extends EObject> T clone(T eObject) {
		EObject clone = EcoreUtil.copy(eObject);
		return (T) clone;
	}

	/**
	 * Clone a list of EObjects.
	 * 
	 * @param <T> the Eobject sub type the list consists of
	 * @param list the list instance
	 * @return a clone of the list and its contents instance
	 */
	@SuppressWarnings("unchecked")
	public static <T extends EObject> List<T> clone(List<T> list) {
		ArrayList<T> result = new ArrayList<T>();
		for (EObject eObject : list) {
			T clone = (T) EcoreUtil.copy(eObject);
			result.add(clone);
		}
		return result;
	}

	/**
	 * Retrieve the plain text from a richt text string.
	 * 
	 * @param richText richt text string
	 * @return plain text string
	 */
	public static String getPlainTextFromRichText(String richText) {
		return richText;
	}

	/**
	 * Converts the rich text string as generated by the MERichTextContol to HTML.
	 * 
	 * @param richText the input string
	 * @return the converted HTML text
	 */
	public static String getHTMLFromRichText(String richText) {
		if (richText == null) {
			return "";
		}
		String[] split = richText.split("%BEGINNTEXT%");

		if (split.length == 1) {
			return "";
		} else {
			List<Integer> bulletedLines = new ArrayList<Integer>();
			try {
				StringTokenizer stringTokenizer = new StringTokenizer(split[0], ",");
				while (stringTokenizer.hasMoreElements()) {
					String nextElement = (String) stringTokenizer.nextElement();
					if (nextElement.equals(";")) {
						break;
					} else {
						bulletedLines.add(Integer.parseInt(nextElement));
					}
				}
				// BEGIN SUPRESS CATCH EXCEPTION
			} catch (RuntimeException e) {
				logException("An exception occured during String conversion from HTML!", e);
				return "";
			}
			// END SUPRESS CATCH EXCEPTION

			String text = split[1];

			try {

				// normalize line feeds
				text.replaceAll("\n\r", "\n");
				text.replaceAll("\r\n", "\n");
				text.replaceAll("\r", "\n");

				String[] lines = text.split("\n");
				StringBuilder newString = new StringBuilder();

				for (int i = 0; i < lines.length; i++) {
					if (bulletedLines.contains(i)) {
						newString.append("\n<ul>");
						newString.append("<li>");
						newString.append(lines[i]);
						newString.append("</li>");
						newString.append("</ul>");
					} else {
						newString.append(lines[i]);
						newString.append("<br/>\n");
					}
				}
				String newDesc = newString.toString();
				return newDesc;
				// BEGIN SUPRESS CATCH EXCEPTION
			} catch (RuntimeException e) {
				// END SUPRESS CATCH EXCEPTION
				logException("An exception occured during String conversion from HTML!", e);
				return text;
			}
		}
	}

	/**
	 * Create a flat clone of the list, the list if cloned but ot its content.
	 * 
	 * @param <T> the list type parameter
	 * @param originalList the original list
	 * @return a flat copy
	 */
	public static <T extends EObject> List<T> flatCloneList(List<T> originalList) {
		List<T> clonedList = new ArrayList<T>(originalList.size());
		for (T element : originalList) {
			clonedList.add(element);
		}
		return clonedList;
	}

	/**
	 * Load an EObject from a resource, the resource is supposed to contain only one root object of the given EClass
	 * type. Type T must match EClass type.
	 * 
	 * @param <T> Type of the EObject
	 * @param eClass the EClass of the EObject
	 * @param resourceURI the resources URI
	 * @return the object loaded from the resource
	 * @throws IOException if loading the object from the resource fails.
	 */
	@SuppressWarnings("unchecked")
	public static <T extends EObject> T loadEObjectFromResource(EClass eClass, URI resourceURI) throws IOException {
		ResourceSet resourceSet = new ResourceSetImpl();
		Resource resource = resourceSet.getResource(resourceURI, false);
		EList<EObject> contents = resource.getContents();
		if (contents.size() > 1) {
			throw new IOException("Resource containes multiple objects!");
		}
		if (contents.size() < 1) {
			throw new IOException("Resource contains no objects");
		}
		EObject eObject = contents.get(0);
		if (!(eClass.isInstance(eObject))) {
			throw new IOException("Resource contains no objects of given class");
		}
		return (T) eObject;
	}

	/**
	 * @param eObjects fjd
	 * @param resourceURI dj
	 * @throws IOException dj
	 */
	public static void saveObjectToResource(List<? extends EObject> eObjects, URI resourceURI) throws IOException {
		ResourceSet resourceSet = new ResourceSetImpl();
		Resource resource = resourceSet.createResource(resourceURI);
		EList<EObject> contents = resource.getContents();
		contents.addAll(eObjects);
		resource.save(null);
	}

	/**
	 * Save an Eobject to a resource.
	 * 
	 * @param eObject the object
	 * @param resourceURI the resources URI
	 * @throws IOException if saving to the resource fails.
	 */
	public static void saveObjectToResource(EObject eObject, URI resourceURI) throws IOException {
		ArrayList<EObject> list = new ArrayList<EObject>();
		list.add(eObject);
		saveObjectToResource(list, resourceURI);
	}

	/**
	 * Retrieve the current model version number.
	 * 
	 * @return an integer identifing the current model version
	 * @throws MalformedModelVersionException if there is no well formed or defined model version
	 */
	public static int getModelVersionNumber() throws MalformedModelVersionException {
		IConfigurationElement[] rawExtensions = Platform.getExtensionRegistry().getConfigurationElementsFor(
			"org.unicase.metamodel.modelversion");
		if (rawExtensions.length != 1) {
			String message = "There is " + rawExtensions.length
				+ " Model Version(s) registered for the given model. Migrator will assume model version 0.";
			logWarning(message, new MalformedModelVersionException(message));
			return 0;
		}
		IConfigurationElement extension = rawExtensions[0];
		String string = extension.getAttribute("versionIdentifier");
		try {
			int version = Integer.parseInt(string);
			return version;
		} catch (NumberFormatException e) {
			throw new MalformedModelVersionException("Version identifier was malformed, it must be an integer: "
				+ string);
		}
	}
	
	/**
	 * Reassign the IDs of the given element an its children. This is a dangerous operation, do NOT apply on elements that are contained in a project!.
	 * 
	 * @param modelElement the element
	 */
	public static void reassignModelElementIds(ModelElement modelElement) {
		Set<ModelElement> copiedElements = modelElement.getAllContainedModelElements();
		copiedElements.add(modelElement);
		for (ModelElement element : copiedElements) {
			//turn off notification for id change			
			boolean eDeliver = element.eDeliver();
			element.eSetDeliver(false);
			//change id
			element.setIdentifier(MetamodelFactory.eINSTANCE.createModelElementId().getId());
			//set edeliver to previous state
			element.eSetDeliver(eDeliver);
		}
	}
}
