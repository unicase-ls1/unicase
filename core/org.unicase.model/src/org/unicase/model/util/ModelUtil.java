/**
 * <copyright> Copyright (c) 2008 Jonas Helming, Maximilian Koegel. All rights reserved. This program and the
 * accompanying materials are made available under the terms of the Eclipse Public License v1.0 which accompanies this
 * distribution, and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>
 */
package org.unicase.model.util;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Platform;
import org.eclipse.core.runtime.Status;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.unicase.model.ModelElement;
import org.unicase.model.ModelElementId;
import org.unicase.model.ModelFactory;
import org.unicase.model.ModelPackage;
import org.unicase.model.Project;

/**
 * Utility class for ModelElements.
 * 
 * @author koegel
 */
public final class ModelUtil {

	private static final URI VIRTUAL_URI = URI.createURI("virtualUnicaseUri");

	/**
	 * Private constructor.
	 */
	private ModelUtil() {
		// nothing to do
	}

	/**
	 * Clone the model element. The model element id will be the same in the clone.
	 * 
	 * @param modelElement the model element to clone
	 * @return a clone
	 */
	public static ModelElement clone(ModelElement modelElement) {
		EObject copy = EcoreUtil.copy(modelElement);
		return (ModelElement) copy;
	}

	/**
	 * Copy a model element. The new model element has a new unique id.
	 * 
	 * @param modelElement the model element
	 * @return a copy of the given model element
	 */
	public static ModelElement copy(ModelElement modelElement) {
		ModelElement copy = (ModelElement) EcoreUtil.copy(modelElement);
		// reset id
		ModelElementId modelElementId = ModelFactory.eINSTANCE.createModelElementId();
		copy.setIdentifier(modelElementId.getId());
		// FIXME what about the containment tree is it copied, do we have to change ids too?
		return copy;
	}

	/**
	 * Clone a project. Clones all model elements in the project.
	 * 
	 * @param project the project
	 * @return a clone of the project.
	 */
	public static Project clone(Project project) {
		EObject copy = EcoreUtil.copy(project);
		return (Project) copy;
	}

	/**
	 * Clone the model element id.
	 * 
	 * @param modelElementId the model element id to clone
	 * @return a clone
	 */
	public static ModelElementId clone(ModelElementId modelElementId) {
		EObject copy = EcoreUtil.copy(modelElementId);
		return (ModelElementId) copy;
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
		if (object == null) {
			return null;
		}

		Resource res = (new ResourceSetImpl()).createResource(VIRTUAL_URI);
		ByteArrayOutputStream out = new ByteArrayOutputStream();

		checkIfSelfContained(object);

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

	private static void checkIfSelfContained(EObject object) throws SerializationException {
		// TODO: Should we allow eClass at all?
		if (object instanceof EClass) {
			return;
		}
		Set<EObject> allEObjects = getNonTransientContents(object);
		allEObjects.add(object);
		// check if only cross references to known elements exist
		for (EObject content : allEObjects) {
			if (!allEObjects.containsAll(getNonTransientCrossReferences(content))) {
				throw new SerializationException(new IllegalStateException("Content is not self contained!"));
			}
		}
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
	 * @param clazz the input class
	 * @param ePackage the input package
	 * @return Returns all non-abstract, non-interface subclasses of the given input in the given package.
	 */
	public static ArrayList<EClass> getSubclasses(EClass clazz, EPackage ePackage) {
		ArrayList<EClass> ret = new ArrayList<EClass>();

		if (clazz.isAbstract() || clazz.isInterface()) {
			for (EObject eObject : ePackage.eContents()) {
				if (eObject instanceof EClass && !eObject.equals(ModelPackage.eINSTANCE.getProject())) {
					EClass eClass = (EClass) eObject;
					if (clazz.isSuperTypeOf(eClass) && !(eClass.isAbstract() || eClass.isInterface())) {
						ret.add(eClass);
					}
				} else if (eObject instanceof EPackage) {
					EPackage eSubPackage = (EPackage) eObject;
					ret.addAll(getSubclasses(clazz, eSubPackage));
				}
			}
		} else {
			ret.add(clazz);
		}
		return ret;
	}

	/**
	 * @param clazz the input super class
	 * @return Returns all non-abstract, non-interface subclasses of the given input. Looks in whole graph starting from
	 *         the root package - i.e. ModelPackage.
	 */
	public static ArrayList<EClass> getSubclasses(EClass clazz) {
		return getSubclasses(clazz, ModelPackage.eINSTANCE);
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
			if (!(eClass.isAbstract() || eClass.isInterface())) {
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
		EClass modelElementEClass = ModelPackage.eINSTANCE.getModelElement();
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
	public static void log(String message, Exception exception, int statusInt) {
		Status status = new Status(statusInt, Platform.getBundle("org.unicase.model").getSymbolicName(), statusInt,
			message, exception);
		Platform.getLog(Platform.getBundle("org.unicase.model")).log(status);
	}

	/**
	 * Log an exception to the platform log. This will create a popup in the ui.
	 * 
	 * @param message the message
	 * @param exception the exception
	 */
	public static void logException(String message, Exception exception) {
		log(message, exception, IStatus.ERROR);
	}

	/**
	 * Log an exception to the platform log. This will create a popup in the ui.
	 * 
	 * @param message the message
	 * @param exception the exception
	 */
	public static void logWarning(String message, Exception exception) {
		log(message, exception, IStatus.WARNING);
	}
}
