/**
 * <copyright> Copyright (c) 2009-2012 Chair of Applied Software Engineering, Technische Universit�t M�nchen (TUM).
 * All rights reserved. This program and the accompanying materials are made available under the terms of
 * the Eclipse Public License v1.0 which accompanies this distribution,
 * and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>
 */
package org.unicase.implementation.operations.util;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

import org.eclipse.emf.common.util.BasicDiagnostic;
import org.eclipse.emf.common.util.BasicEList;
import org.eclipse.emf.common.util.Diagnostic;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EModelElement;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EOperation;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.util.EObjectValidator;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.emfstore.internal.common.model.ModelElementId;
import org.eclipse.emf.emfstore.internal.common.model.Project;
import org.eclipse.emf.emfstore.internal.common.model.util.ModelUtil;
import org.eclipse.emf.emfstore.internal.server.model.versioning.operations.semantic.SemanticCompositeOperation;
import org.unicase.implementation.operations.OperationsPackage;

/**
 * Helper class for Operations.
 * 
 * @author herrmi
 */
public final class OperationHelper {

	private OperationHelper() {
		// NOTHING TO DO
	}

	/**
	 * Get a model element of a type V from the given project.
	 * 
	 * @param <V>
	 *            the type of the model element
	 * @param project
	 *            the project
	 * @param id
	 *            the id of the model element
	 * @return the modelelement or null if it is not in the project
	 */
	@SuppressWarnings("unchecked")
	public static <V> V getElement(Project project, ModelElementId id) {
		if (id == null) {
			return null;
		}
		return (V) project.getModelElement(id);
	}

	/**
	 * Get a list of model elements from a certain type from the given project.
	 * 
	 * @param <V>
	 *            the type
	 * @param project
	 *            the project
	 * @param ids
	 *            the list of ids of the model element to retrieve
	 * @return a list of model elements, may contain null if an element is not
	 *         in the project
	 */
	@SuppressWarnings("unchecked")
	public static <V> EList<V> getElements(Project project,
			List<ModelElementId> ids) {
		EList<V> elements = new BasicEList<V>();
		for (ModelElementId id : ids) {
			elements.add((V) getElement(project, id));
		}
		return elements;
	}

	/**
	 * Get the id of a model element.
	 * 
	 * @param element
	 *            the element
	 * @return the id or null if the element is null
	 */
	public static ModelElementId getId(EObject element) {
		if (element == null) {
			return null;
		}

		Project p = ModelUtil.getProject(element);

		if (p == null) {
			return null;
		}

		return p.getModelElementId(element);
	}

	/**
	 * Get the ids of all given model elements.
	 * 
	 * @param elements
	 *            the elements
	 * @return a list of ids
	 */
	public static List<ModelElementId> getIds(List<? extends EObject> elements) {
		List<ModelElementId> ids = new ArrayList<ModelElementId>();
		for (EObject element : elements) {
			ids.add(getId(element));
		}
		return ids;
	}

	/**
	 * Validates a semantic composite operation in the context of a project.
	 * 
	 * @param operation
	 *            the operation
	 * @param project
	 *            the project
	 * @return the validation results
	 */

	public static Diagnostic validate(SemanticCompositeOperation operation,
			Project project) {

		BasicDiagnostic diagnostic = new BasicDiagnostic();

		validateRequiredValues(operation, project, diagnostic);
		validatePossibleValues(operation, project, diagnostic);
		validateConstraints(operation, project, diagnostic);

		return diagnostic;
	}

	private static void validateRequiredValues(
			SemanticCompositeOperation operation, Project project,
			BasicDiagnostic diagnostic) {
		for (EStructuralFeature feature : operation.eClass()
				.getEStructuralFeatures()) {
			if (feature.isRequired() && !operation.eIsSet(feature)) {
				diagnostic.add(new BasicDiagnostic(Diagnostic.ERROR,
						EObjectValidator.DIAGNOSTIC_SOURCE, 0,
						"The parameter '" + feature.getName()
								+ "' must be set.", new Object[0]));
			}
		}
	}

	@SuppressWarnings("unchecked")
	private static void validatePossibleValues(
			SemanticCompositeOperation operation, Project project,
			BasicDiagnostic diagnostic) {
		for (EReference reference : operation.eClass().getEReferences()) {
			EOperation method = OperationHelper.getPossibleOperation(reference);
			if (method != null) {
				List possibleValues = getPossibleValues(operation, reference,
						project);
				if (reference.isMany()) {
					List value = getElements(project,
							(List<ModelElementId>) operation.eGet(reference));
					for (Object v : value) {
						if (!possibleValues.contains(v)) {
							diagnostic.add(new BasicDiagnostic(
									Diagnostic.ERROR,
									EObjectValidator.DIAGNOSTIC_SOURCE, 0,
									"The value of parameter '"
											+ reference.getName()
											+ "' is not allowed.",
									new Object[0]));
							break;
						}
					}
				} else {
					Object value = getElement(project,
							(ModelElementId) operation.eGet(reference));
					if (value != null && !possibleValues.contains(value)) {
						diagnostic.add(new BasicDiagnostic(Diagnostic.ERROR,
								EObjectValidator.DIAGNOSTIC_SOURCE, 0,
								"The value of parameter '"
										+ reference.getName()
										+ "' is not allowed.", new Object[0]));
					}
				}
			}
		}
	}

	private static void validateConstraints(
			SemanticCompositeOperation operation, Project project,
			BasicDiagnostic diagnostic) {
		for (EOperation method : operation.eClass().getEOperations()) {
			if (method.getName().startsWith("validate")) {
				try {
					boolean result = invokeOperation(operation, method, project);
					if (!result) {
						String annotation = getAnnotation(method, "description");
						diagnostic.add(new BasicDiagnostic(Diagnostic.ERROR,
								EObjectValidator.DIAGNOSTIC_SOURCE, 0,
								annotation, new Object[0]));
					}
				} catch (OperationInvocationException e) {
					// ignore
				}
			}
		}
	}

	/**
	 * Get all possible values for a given feature of an operation in the conext
	 * of a project.
	 * 
	 * @param operation
	 *            the operation
	 * @param reference
	 *            the feature
	 * @param project
	 *            the project
	 * @return a list of possible values
	 */
	@SuppressWarnings("unchecked")
	public static List getPossibleValues(SemanticCompositeOperation operation,
			EReference reference, Project project) {
		EOperation method = OperationHelper.getPossibleOperation(reference);
		if (method != null) {
			try {
				return OperationHelper.invokeOperation(operation, method,
						project);
			} catch (OperationInvocationException e) {
				// ignore
			}
		}
		EClass type = OperationHelper.getType(reference);
		return project.getModelElementsByClass(type, new BasicEList());
	}

	private static EClass getType(EReference reference) {
		String name = "get" + firstUpper(reference.getName());
		EOperation operation = getOperation(reference.getEContainingClass(),
				name);
		if (operation == null) {
			return null;
		}
		return (EClass) operation.getEType();
	}

	private static EOperation getPossibleOperation(EReference reference) {
		String name = "getPossible" + firstUpper(reference.getName());
		EOperation operation = getOperation(reference.getEContainingClass(),
				name);
		return operation;
	}

	private static EOperation getOperation(EClass c, String name) {
		for (EOperation operation : c.getEOperations()) {
			if (name.equals(operation.getName())) {
				return operation;
			}
		}
		return null;
	}

	@SuppressWarnings("unchecked")
	private static <V> V invokeOperation(EObject element, EOperation operation,
			Object... parameters) throws OperationInvocationException {
		Class[] parameterTypes = new Class[parameters.length];
		for (int i = 0, n = parameters.length; i < n; i++) {
			parameterTypes[i] = parameters[i].getClass();
		}
		Method method;
		try {
			method = element.getClass().getMethod(operation.getName(),
					Project.class);
			Object result = method.invoke(element, parameters);
			return (V) result;
		} catch (SecurityException e) {
			throw new OperationInvocationException(element, operation, e);
		} catch (NoSuchMethodException e) {
			throw new OperationInvocationException(element, operation, e);
		} catch (IllegalArgumentException e) {
			throw new OperationInvocationException(element, operation, e);
		} catch (IllegalAccessException e) {
			throw new OperationInvocationException(element, operation, e);
		} catch (InvocationTargetException e) {
			throw new OperationInvocationException(element, operation, e);
		}
	}

	private static String firstUpper(String name) {
		return name.substring(0, 1).toUpperCase() + name.substring(1);
	}

	/**
	 * Get the annotation for an operation from the ecore.
	 * 
	 * @param operation
	 *            the operation
	 * @param key
	 *            the annotation key
	 * @return the annotation content
	 */
	public static String getAnnotation(SemanticCompositeOperation operation,
			String key) {
		return getAnnotation(operation.eClass(), key);
	}

	private static String getAnnotation(EModelElement element, String key) {
		return EcoreUtil.getAnnotation(element, OperationsPackage.eNS_URI, key);
	}

	/**
	 * Make the first char lowercase.
	 * 
	 * @param name
	 *            the input string
	 * @return a transformed string
	 */
	public static String firstLower(String name) {
		return name.substring(0, 1).toLowerCase() + name.substring(1);
	}

}
