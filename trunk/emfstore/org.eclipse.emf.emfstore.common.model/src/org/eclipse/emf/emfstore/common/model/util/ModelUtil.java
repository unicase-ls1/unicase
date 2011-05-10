/*******************************************************************************
 * Copyright (c) 2008-2011 Chair for Applied Software Engineering,
 * Technische Universitaet Muenchen.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 ******************************************************************************/
package org.eclipse.emf.emfstore.common.model.util;

import java.io.IOException;
import java.io.StringReader;
import java.io.StringWriter;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IConfigurationElement;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Platform;
import org.eclipse.core.runtime.Status;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.common.util.TreeIterator;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.EcoreFactory;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.ecore.xmi.XMIResource;
import org.eclipse.emf.ecore.xmi.XMLResource;
import org.eclipse.emf.emfstore.common.CommonUtil;
import org.eclipse.emf.emfstore.common.model.AssociationClassElement;
import org.eclipse.emf.emfstore.common.model.ModelElementId;
import org.eclipse.emf.emfstore.common.model.ModelFactory;
import org.eclipse.emf.emfstore.common.model.Project;
import org.eclipse.emf.emfstore.common.model.SingletonIdResolver;
import org.eclipse.emf.emfstore.common.model.impl.ProjectImpl;
import org.xml.sax.InputSource;

/**
 * Utility class for ModelElements.
 * 
 * @author koegel
 */
public final class ModelUtil {

	private static final String ORG_ECLIPSE_EMF_EMFSTORE_COMMON_MODEL = "org.eclipse.emf.emfstore.common.model";

	/**
	 * Text marker for the begin of the plaintext in rich text attributes.
	 */
	public static final String BEGINTEXT_TOKEN = "%BEGINNTEXT%";

	/**
	 * URI used to serialize EObject with the model util.
	 */
	public static final URI VIRTUAL_URI = URI.createURI("virtualUri");

	/**
	 * Contains the canonical names of classes which will be ignored.
	 */
	private static Set<String> ignoredDataTypes;

	/**
	 * Contains all ID resolvers for singleton datatypes.
	 */
	private static Set<SingletonIdResolver> singletonIdResolvers;

	private static HashMap<Object, Object> resourceLoadOptions;

	private static HashMap<Object, Object> resourceSaveOptions;

	/**
	 * Private constructor.
	 */
	private ModelUtil() {
		// nothing to do
	}

	/**
	 * Creates a ModelElementId object from a string.
	 * 
	 * @param id as string
	 * @return id as object
	 */
	public static ModelElementId createModelElementId(String id) {
		ModelElementId modelElementId = ModelFactory.eINSTANCE.createModelElementId();
		modelElementId.setId(id);
		return modelElementId;
	}

	/**
	 * Compares two EObject by checking whether the string representations of the EObjects are equal.
	 * 
	 * @param eobjectA the first EObject
	 * @param eobjectB the second EObject
	 * @return true if the two objects are equal
	 */
	public static boolean areEqual(EObject eobjectA, EObject eobjectB) {
		String stringA;
		String stringB;
		try {
			stringA = eObjectToString(eobjectA);
			stringB = eObjectToString(eobjectB);
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
		return eObjectToString(object, false, false);
	}

	/**
	 * Converts an {@link EObject} to a {@link String}.
	 * 
	 * @param object the {@link EObject}
	 * @param overrideContainmentCheck if true, no containment check is performed
	 * @param overrideHrefCheck checks whether there is a <code>href</code> in the serialized text
	 * @return String representation of the {@link EObject}
	 * @throws SerializationException if a serialization problem occurs
	 */
	public static String eObjectToString(EObject object, boolean overrideContainmentCheck, boolean overrideHrefCheck)
		throws SerializationException {
		if (object == null) {
			return null;
		}

		XMIResource res = (XMIResource) (new ResourceSetImpl()).createResource(VIRTUAL_URI);

		if (!overrideContainmentCheck && !(object instanceof EClass)) {
			if (!CommonUtil.isSelfContained(object)) {
				throw new SerializationException(object);
			}
		}

		if (object instanceof Project) {
			Project project = (Project) object;
			Project copiedProject = (Project) clone(object);

			for (ModelElementId modelElementId : project.getAllModelElementIds()) {
				if (isIgnoredDatatype(project.getModelElement(modelElementId))) {
					continue;
				}
				res.setID(copiedProject.getModelElement(modelElementId), modelElementId.getId());
			}
			res.getContents().add(copiedProject);
		} else {
			EObject copy = EcoreUtil.copy(object);
			res.getContents().add(copy);
		}

		int step = 200;
		int initialSize = step;
		if (object instanceof Project) {
			Project project = (Project) object;
			initialSize = project.getAllModelElements().size() * step;
		}
		StringWriter stringWriter = new StringWriter(initialSize);
		try {
			res.save(stringWriter, getResourceSaveOptions());
		} catch (IOException e) {
			throw new SerializationException(e);
		}
		String result = stringWriter.toString();
		// TODO: EM
		if (!overrideHrefCheck) {
			hrefCheck(result);
		}
		return result;
	}

	private static void hrefCheck(String result) throws SerializationException {
		char[] needle = "href".toCharArray();
		int pointer = 0;
		boolean insideQuotes = false;
		for (char character : result.toCharArray()) {
			if (character == '"') {
				insideQuotes = !insideQuotes;
			}
			if (!insideQuotes && character == needle[pointer]) {
				if (++pointer == needle.length) {
					throw new SerializationException("Serialization failed due to href detection.");
				}
			} else {
				pointer = 0;
			}
		}
	}

	/**
	 * Determines whether the type of an EObject is an ignored one.
	 * 
	 * @param eObject the EObject which is to be checked
	 * @return true, if the EObject will be ignored, false otherwise
	 */
	public static boolean isIgnoredDatatype(EObject eObject) {

		if (ignoredDataTypes == null) {
			ignoredDataTypes = new HashSet<String>();
			IConfigurationElement[] config = Platform.getExtensionRegistry().getConfigurationElementsFor(
				"org.eclipse.emf.emfstore.common.model.ignoredatatype");
			for (IConfigurationElement extension : config) {
				String className = extension.getAttribute("type");
				ignoredDataTypes.add(className);
			}
		}

		return ignoredDataTypes.contains(eObject.eClass().getInstanceClassName());
	}

	/**
	 * Converts a {@link String} to an {@link EObject}. <b>Note</b>: {@link String} must be the result of
	 * {@link ModelUtil#eObjectToString(EObject)}
	 * 
	 * @param object the {@link String} representation of the {@link EObject}
	 * @return the deserialized {@link EObject}
	 * @throws SerializationException if deserialization fails
	 */
	public static EObject stringToEObject(String object) throws SerializationException {
		if (object == null) {
			return null;
		}

		XMIResource res = (XMIResource) (new ResourceSetImpl()).createResource(VIRTUAL_URI);

		try {
			res.load(new InputSource(new StringReader(object)), getResourceLoadOptions());
		} catch (UnsupportedEncodingException e) {
			throw new SerializationException(e);
		} catch (IOException e) {
			throw new SerializationException(e);
		}

		EObject result = res.getContents().get(0);
		if (result instanceof Project) {
			Project project = (Project) result;
			Map<EObject, ModelElementId> eObjectToIdMap = new HashMap<EObject, ModelElementId>();
			Map<ModelElementId, EObject> idToEObjectMap = new HashMap<ModelElementId, EObject>();
			TreeIterator<EObject> it = ((Project) result).eAllContents();
			while (it.hasNext()) {
				EObject me = it.next();
				String id;

				if (ModelUtil.isIgnoredDatatype(me)) {
					// create random ID for generic types, won't get serialized anyway
					id = ModelFactory.eINSTANCE.createModelElementId().getId();
				} else {
					id = res.getID(me);
				}

				if (id == null) {
					throw new SerializationException("Failed to retrieve ID for EObject contained in project: " + me);
				}

				ModelElementId meId = ModelFactory.eINSTANCE.createModelElementId();
				meId.setId(id);
				eObjectToIdMap.put(me, meId);
				idToEObjectMap.put(meId, me);
			}
			project.initCaches(eObjectToIdMap, idToEObjectMap);
		}

		// TODO: added to resolve model element map in a CreateDeleteOp
		// check whether we can generalize this
		EcoreUtil.resolveAll(result);

		res.getContents().remove(result);
		return result;
	}

	/**
	 * Delivers a map of options for loading resources. Especially {@link XMLResource#OPTION_DEFER_IDREF_RESOLUTION}
	 * which speeds up loading due to our id based resources.
	 * 
	 * @return map of options for {@link XMIResource} or {@link XMLResource}.
	 */
	public static Map<Object, Object> getResourceLoadOptions() {
		if (resourceLoadOptions == null) {
			resourceLoadOptions = new HashMap<Object, Object>();
			// options.put(XMLResource.OPTION_CONFIGURATION_CACHE, true)
			resourceLoadOptions.put(XMLResource.OPTION_USE_ENCODED_ATTRIBUTE_STYLE, Boolean.TRUE);
			resourceLoadOptions.put(XMLResource.OPTION_DEFER_IDREF_RESOLUTION, true);
		}
		return resourceLoadOptions;
	}

	/**
	 * Delivers a map of mandatory options for saving resources.
	 * 
	 * @return map of options for {@link XMIResource} or {@link XMLResource}.
	 */
	public static Map<Object, Object> getResourceSaveOptions() {
		if (resourceSaveOptions == null) {
			resourceSaveOptions = new HashMap<Object, Object>();
			resourceSaveOptions.put(XMLResource.OPTION_USE_ENCODED_ATTRIBUTE_STYLE, Boolean.TRUE);
		}
		return resourceSaveOptions;
	}

	private static boolean canHaveInstances(EClass eClass) {
		return !(eClass.isAbstract() || eClass.isInterface());
	}

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
		Set<EClass> meTypes = new HashSet<EClass>();

		for (EObject eObject : ePackage.eContents()) {
			if (eObject instanceof EClass) {
				EClass eClass = (EClass) eObject;
				meTypes.add(eClass);
			} else if (eObject instanceof EPackage) {
				EPackage eSubPackage = (EPackage) eObject;
				meTypes.addAll(getAllMETypes(eSubPackage));
			}
		}

		return meTypes;
	}

	/**
	 * This will add a new entry to error log view of eclipse.
	 * 
	 * @param message message
	 * @param exception exception
	 * @param statusInt severity. Use one of constants in org.eclipse.core.runtime.Status class.
	 * @throws LoggedException
	 */
	public static void log(String message, Throwable exception, int statusInt) {
		Status status = new Status(statusInt, Platform.getBundle(ORG_ECLIPSE_EMF_EMFSTORE_COMMON_MODEL)
			.getSymbolicName(), statusInt, message, exception);
		Platform.getLog(Platform.getBundle(ORG_ECLIPSE_EMF_EMFSTORE_COMMON_MODEL)).log(status);
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
	 * Log a warning to the platform log. This will NOT create a popup in the ui.
	 * 
	 * @param message the message
	 * @param exception the exception
	 */
	public static void logWarning(String message, Throwable exception) {
		log(message, exception, IStatus.WARNING);
	}

	/**
	 * Log a warning to the platform log. This will NOT create a popup in the ui.
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
		if (eObject instanceof ProjectImpl) {
			return (T) ((ProjectImpl) eObject).copy();
		}
		EObject clone = EcoreUtil.copy(eObject);
		return (T) clone;
	}

	/**
	 * Clone a list of EObjects.
	 * 
	 * @param <T> the EObject sub type the list consists of
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
	 * @param checkConstraints whether to perform additional sanity checks. These checks basically try to enforce that
	 *            a resource contains exactly one object.
	 * @return the object loaded from the resource
	 * @throws IOException if loading the object from the resource fails.
	 */
	@SuppressWarnings("unchecked")
	public static <T extends EObject> T loadEObjectFromResource(EClass eClass, URI resourceURI, boolean checkConstraints)
		throws IOException {
		ResourceSet resourceSet = new ResourceSetImpl();
		Resource resource;

		if (checkConstraints) {
			resource = resourceSet.getResource(resourceURI, false);
		} else {
			resource = resourceSet.getResource(resourceURI, true);
		}

		EList<EObject> contents = resource.getContents();

		if (checkConstraints) {
			if (contents.size() > 1) {
				throw new IOException("Resource containes multiple objects!");
			}
		}

		if (contents.size() < 1) {
			throw new IOException("Resource contains no objects");
		}

		EObject eObject = contents.get(0);

		if (eObject instanceof Project && resource instanceof XMIResource) {
			XMIResource xmiResource = (XMIResource) resource;
			Project project = (Project) eObject;
			Map<EObject, ModelElementId> eObjectToIdMap = new HashMap<EObject, ModelElementId>();
			Map<ModelElementId, EObject> idToEObjectMap = new HashMap<ModelElementId, EObject>();

			TreeIterator<EObject> it = project.eAllContents();
			while (it.hasNext()) {
				EObject obj = it.next();
				ModelElementId objId = ModelFactory.eINSTANCE.createModelElementId();
				String id = xmiResource.getID(obj);
				if (id != null) {
					objId.setId(id);
					eObjectToIdMap.put(obj, objId);
					idToEObjectMap.put(objId, obj);
				}
			}

			project.initCaches(eObjectToIdMap, idToEObjectMap);
		}

		if (!(eClass.isInstance(eObject))) {
			throw new IOException("Resource contains no objects of given class");
		}

		return (T) eObject;
	}

	/**
	 * Save a list of EObjects to the resource with the given URI.
	 * 
	 * @param eObjects the EObjects to be saved
	 * @param resourceURI the URI of the resource, which should be used to save the EObjects
	 * @throws IOException if saving to the resource fails
	 */
	public static void saveEObjectToResource(List<? extends EObject> eObjects, URI resourceURI) throws IOException {
		ResourceSet resourceSet = new ResourceSetImpl();
		Resource resource = resourceSet.createResource(resourceURI);
		EList<EObject> contents = resource.getContents();

		for (EObject eObject : eObjects) {
			contents.add(eObject);
			if (eObject instanceof Project && resource instanceof XMIResource) {
				setXmiIdsOnResource((Project) eObject, (XMIResource) resource);
			}
		}

		contents.addAll(eObjects);
		resource.save(null);
	}

	/**
	 * Set all IDs contained in the project as XMI IDs for the model elements in the project.
	 * 
	 * @param project a project
	 * @param xmiResource the resource that will contain the XMI IDs
	 */
	public static void setXmiIdsOnResource(Project project, XMIResource xmiResource) {
		for (EObject modelElement : project.getAllModelElements()) {
			ModelElementId modelElementId = project.getModelElementId(modelElement);
			xmiResource.setID(modelElement, modelElementId.getId());
		}
	}

	/**
	 * Save an EObject to a resource.
	 * 
	 * @param eObject the object
	 * @param resourceURI the resources URI
	 * @throws IOException if saving to the resource fails.
	 */
	public static void saveEObjectToResource(EObject eObject, URI resourceURI) throws IOException {
		ArrayList<EObject> list = new ArrayList<EObject>();
		list.add(eObject);
		saveEObjectToResource(list, resourceURI);
	}

	/**
	 * Retrieve the current model version number.
	 * 
	 * @return an integer identifing the current model version
	 * @throws MalformedModelVersionException if there is no well formed or defined model version
	 */
	public static int getModelVersionNumber() throws MalformedModelVersionException {
		IConfigurationElement[] rawExtensions = Platform.getExtensionRegistry().getConfigurationElementsFor(
			"org.eclipse.emf.emfstore.common.model.modelversion");
		if (rawExtensions.length != 1) {
			String message = "There is " + rawExtensions.length
				+ " Model Version(s) registered for the given model. Migrator will assume model version 0.";
			logInfo(message);
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
	 * Get Project that contains a model element.
	 * 
	 * @param modelElement the model element
	 * @return the project or null if the element is not contained in a project.
	 */
	public static Project getProject(EObject modelElement) {
		Set<EObject> seenModelElements = new HashSet<EObject>();
		seenModelElements.add(modelElement);
		return (Project) getParent(Project.class, modelElement, seenModelElements);
	}

	/**
	 * Get the EContainer that contains the given model element and whose EContainer is null.
	 * 
	 * @param parent the Class of the parent
	 * @param child the model element whose container should get returned
	 * @return the container
	 */
	public static EObject getParent(Class<? extends EObject> parent, EObject child) {
		Set<EObject> seenModelElements = new HashSet<EObject>();
		seenModelElements.add(child);
		return getParent(parent, child, seenModelElements);
	}

	private static EObject getParent(Class<? extends EObject> parent, EObject child, Set<EObject> seenModelElements) {
		if (child == null) {
			return null;
		}

		if (seenModelElements.contains(child.eContainer())) {
			throw new IllegalStateException("ModelElement is in a containment cycle");
		}

		if (parent.isInstance(child)) {
			return child;
		} else {
			seenModelElements.add(child);
			return getParent(parent, child.eContainer(), seenModelElements);
		}
	}

	/**
	 * Whether a {@link EClass} is a association class. Association classes are not displayed as dedicated elements. A
	 * link from one element to another which goes over an association class is displayed by a dedicated widget. This
	 * widgets allows to trace transparently without seeing the association class.
	 * 
	 * @param eClazz the {@link EClass}
	 * @return if it is an association
	 */
	public static boolean isAssociationClassElement(EClass eClazz) {
		if (eClazz == null || eClazz.isAbstract() || eClazz.getInstanceClass() == null) {
			return false;
		}
		return AssociationClassElement.class.isAssignableFrom(eClazz.getInstanceClass());
	}

	/**
	 * Get all contained elements of a given element.
	 * 
	 * @param modelElement the model element
	 * @param includeTransientContainments true if transient containments should be included in the result
	 * @return a set of contained model elements
	 */
	public static Set<EObject> getAllContainedModelElements(EObject modelElement, boolean includeTransientContainments) {
		return getAllContainedModelElements(modelElement, includeTransientContainments, false);
	}

	/**
	 * Get all contained elements of a given element.
	 * 
	 * @param modelElement the model element
	 * @param includeTransientContainments true if transient containments should be included in the result
	 * @param ignoreSingletonDatatypes whether to ignore singleton datatypes like, for example, EString
	 * @return a set of contained model elements
	 */
	public static Set<EObject> getAllContainedModelElements(EObject modelElement, boolean includeTransientContainments,
		boolean ignoreSingletonDatatypes) {
		Set<EObject> result = new HashSet<EObject>();
		for (EObject containee : modelElement.eContents()) {
			if (!isSingleton(containee) || !containee.eContainingFeature().isTransient()
				|| includeTransientContainments) {
				Set<EObject> elements = getAllContainedModelElements(containee, includeTransientContainments);
				result.add(containee);
				result.addAll(elements);
			}
		}
		return result;
	}

	/**
	 * Get the container of an EObject.
	 * 
	 * @param modelElement the model element
	 * @return the container
	 */
	public static EObject getContainerModelElement(EObject modelElement) {
		EObject container = modelElement.eContainer();
		if (container == null) {
			return null;
		}
		if (EcoreFactory.eINSTANCE.getEcorePackage().getEObject().isInstance(container)) {
			return container;
		}
		return null;
	}

	/**
	 * Get all contained elements of a given element as a list.
	 * 
	 * @param modelElement the model element
	 * @param includeTransientContainments true if transient containments should be included in the result
	 * @return a list of contained model elements
	 */
	public static List<EObject> getAllContainedModelElementsAsList(EObject modelElement,
		boolean includeTransientContainments) {

		TreeIterator<EObject> it = modelElement.eAllContents();

		List<EObject> result = new ArrayList<EObject>();
		while (it.hasNext()) {
			EObject containee = it.next();
			if (containee.eContainingFeature() != null && !containee.eContainingFeature().isTransient()
				|| includeTransientContainments) {
				List<EObject> elements = getAllContainedModelElementsAsList(containee, includeTransientContainments);
				if (!result.contains(containee)) {
					result.add(containee);
				}
				result.addAll(elements);
			}
		}

		return result;
	}

	/**
	 * Removes the the given {@link EObject} and all its contained children from their respective {@link XMIResource}s.
	 * 
	 * @param eObject the {@link EObject} to remove
	 */
	public static void removeModelElementAndChildrenFromResource(EObject eObject) {
		Set<EObject> children = getAllContainedModelElements(eObject, false);
		for (EObject child : children) {
			removeModelElementFromResource(child);
		}
		removeModelElementFromResource(eObject);
	}

	/**
	 * Removes the the given {@link EObject} from its {@link XMIResource}.
	 * 
	 * @param eObject the {@link EObject} to remove
	 */
	private static void removeModelElementFromResource(EObject eObject) {

		Resource resource = eObject.eResource();

		if (resource == null) {
			return;
		}

		if (!(resource instanceof XMIResource)) {
			throw new IllegalArgumentException("EObject's resource is not a XMI resource.");
		}

		XMIResource xmiResource = (XMIResource) resource;
		xmiResource.getContents().remove(eObject);
		xmiResource.setID(eObject, null);

		try {
			xmiResource.save(null);
		} catch (IOException e) {
			throw new RuntimeException("XMI Resource for model element " + eObject + " couldn't be saved");
		}
	}

	/**
	 * Delete all incoming cross references to the given model element from any other model element in the given
	 * project.
	 * 
	 * @param modelElement the model element
	 * @param project the project
	 * @param includeChildren set to true, if incoming cross references to any children of the given element should also
	 *            be deleted
	 * @param includeCrossReferencesFromChildren set to true, if incoming cross references to children from other
	 *            children including the given element should also be removed. These are cross references within the
	 *            containment tree of the given element)
	 */
	public static void deleteIncomingCrossReferencesFromProject(EObject modelElement, Project project,
		boolean includeChildren, boolean includeCrossReferencesFromChildren) {

		Set<EObject> allModelElements = new HashSet<EObject>();
		allModelElements.add(modelElement);
		if (includeChildren) {
			allModelElements.addAll(ModelUtil.getAllContainedModelElements(modelElement, false));
		}

		// delete all non containment cross references from other elements in the project
		for (EObject otherModelElement : ModelUtil.getAllContainedModelElements(project, false)) {
			// check if the element is one of the children and should not loose its cross references
			if (!includeCrossReferencesFromChildren && allModelElements.contains(otherModelElement)) {
				continue;
			}
			for (EObject otherElementOpposite : otherModelElement.eCrossReferences()) {
				// check if the element references any of the target objects
				if (allModelElements.contains(otherElementOpposite)) {
					EList<EReference> references = otherModelElement.eClass().getEAllReferences();
					// cut of the reference
					for (EReference reference : references) {
						if (!reference.isContainment() && !reference.isContainer() && reference.isChangeable()
							&& isCorrespondingReference(modelElement, otherModelElement, reference)) {
							if (reference.isMany()) {
								((EList<?>) otherModelElement.eGet(reference)).remove(modelElement);
							} else {
								otherModelElement.eUnset(reference);
							}
						}
					}
				}
			}
		}
	}

	/**
	 * Check of the two elements are linked by the given reference.
	 * 
	 * @param modelElement first model element
	 * @param otherModelElement second modelelement
	 * @param reference candidate reference feature of first element
	 * @return true if the reference feature links the two elements
	 */
	private static boolean isCorrespondingReference(EObject modelElement, EObject otherModelElement,
		EReference reference) {
		if (reference.isMany()) {
			if (otherModelElement.eGet(reference) == null) {
				return false;
			}
			return ((List<?>) otherModelElement.eGet(reference)).contains(modelElement);
		} else {
			return modelElement.equals(otherModelElement.eGet(reference));
		}
	}

	/**
	 * Delete all outgoing cross references of the given model element.
	 * 
	 * @param modelElement the model element
	 * @param includeChildren set to true, if outgoing cross references of any children of the given element should also
	 *            be deleted
	 * @param includeCrossReferencesToChildren set to true, if outgoing cross references to children (that is within the
	 *            containment tree of the given element) should also be removed.
	 */
	public static void deleteOutgoingCrossReferences(EObject modelElement, boolean includeChildren,
		boolean includeCrossReferencesToChildren) {
		Set<EObject> allModelElements = new HashSet<EObject>();
		allModelElements.add(modelElement);
		if (includeChildren) {
			allModelElements.addAll(ModelUtil.getAllContainedModelElements(modelElement, false));
		}
		for (EObject currentElement : allModelElements) {
			// delete all non containment cross references to other elments
			for (EReference reference : currentElement.eClass().getEAllReferences()) {
				EClassifier eType = reference.getEType();
				// sanity checks
				if (reference.isContainer() || reference.isContainment() || !reference.isChangeable()
					|| (!(eType instanceof EClass))) {
					continue;
				}
				// single references
				if (!reference.isMany()) {
					EObject referencedElement = (EObject) currentElement.eGet(reference);
					if (shouldBeDeleted(includeCrossReferencesToChildren, allModelElements, referencedElement)) {
						currentElement.eUnset(reference);
					}
				}
				// multi references
				else {
					@SuppressWarnings("unchecked")
					List<EObject> referencedElements = (List<EObject>) currentElement.eGet(reference);
					Set<EObject> referencedElementsToRemove = new HashSet<EObject>();
					for (EObject referencedElement : referencedElements) {
						if (shouldBeDeleted(includeCrossReferencesToChildren, allModelElements, referencedElement)) {
							referencedElementsToRemove.add(referencedElement);
						}
					}
					referencedElements.removeAll(referencedElementsToRemove);
				}
			}
		}
	}

	private static boolean shouldBeDeleted(boolean includeCrossReferencesToChildren, Set<EObject> allModelElements,
		EObject referencedElement) {

		if (referencedElement == null) {
			return false;
		}

		return (!ModelUtil.isSingleton(referencedElement) && !ModelUtil.isIgnoredDatatype(referencedElement))
			&& (includeCrossReferencesToChildren || !allModelElements.contains(referencedElement));
	}

	/**
	 * Get the singleton instance for a given model element id.
	 * 
	 * @param singletonId the id
	 * @return the singleton instance
	 * 
	 * @see org.eclipse.emf.emfstore.common.model.SingletonIdResolver#getSingleton(org.eclipse.emf.emfstore.common.model.ModelElementId)
	 */
	public static EObject getSingleton(ModelElementId singletonId) {

		initSingletonIdResolvers();

		for (SingletonIdResolver resolver : singletonIdResolvers) {
			EObject singleton = resolver.getSingleton(singletonId);
			if (singleton != null) {
				return singleton;
			}
		}

		return null;
	}

	/**
	 * Get the singleton id for a singleton instance.
	 * 
	 * @param singleton the singleton
	 * @return the id
	 * 
	 * @see org.eclipse.emf.emfstore.common.model.SingletonIdResolver#getSingletonModelElementId(org.eclipse.emf.ecore.EObject)
	 */
	public static ModelElementId getSingletonModelElementId(EObject singleton) {

		initSingletonIdResolvers();

		for (SingletonIdResolver resolver : singletonIdResolvers) {
			ModelElementId id = resolver.getSingletonModelElementId(singleton);
			if (id != null) {
				return clone(id);
			}
		}

		return null;
	}

	/**
	 * Return whether the given eObject instance is a singelton.
	 * 
	 * @param eObject the instance
	 * @return true if it is a singleton
	 * 
	 * @see org.eclipse.emf.emfstore.common.model.SingletonIdResolver#isSingleton(org.eclipse.emf.ecore.EObject)
	 */
	public static boolean isSingleton(EObject eObject) {

		initSingletonIdResolvers();

		for (SingletonIdResolver resolver : singletonIdResolvers) {
			if (resolver.isSingleton(eObject)) {
				return true;
			}
		}

		return false;
	}

	/**
	 * Initializes all available {@link SingletonIdResolver}.
	 */
	private static void initSingletonIdResolvers() {
		if (singletonIdResolvers == null) {
			// collect singleton ID resolvers
			singletonIdResolvers = new HashSet<SingletonIdResolver>();
			IConfigurationElement[] config = Platform.getExtensionRegistry().getConfigurationElementsFor(
				"org.eclipse.emf.emfstore.common.model.singletonidresolver");

			for (IConfigurationElement extension : config) {
				SingletonIdResolver resolver;
				try {
					resolver = (SingletonIdResolver) extension.createExecutableExtension("class");
					singletonIdResolvers.add(resolver);
				} catch (CoreException e) {
					ModelUtil.logWarning("Couldn't instantiate Singleton ID resolver:" + e.getMessage());
				}
			}
		}
	}
}
