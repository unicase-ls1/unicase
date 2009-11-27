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
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EOperation;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.util.EObjectValidator;
import org.unicase.emfstore.esmodel.versioning.operations.semantic.SemanticCompositeOperation;
import org.unicase.metamodel.ModelElement;
import org.unicase.metamodel.ModelElementId;
import org.unicase.metamodel.Project;

public class OperationHelper {

	public static <V> V getElement(Project project, ModelElementId id) {
		if (id == null) {
			return null;
		}
		return (V) project.getModelElement(id);
	}

	public static <V> EList<V> getElements(Project project,
			List<ModelElementId> ids) {
		EList<V> elements = new BasicEList<V>();
		for (ModelElementId id : ids) {
			elements.add((V) getElement(project, id));
		}
		return elements;
	}

	public static ModelElementId getId(ModelElement element) {
		if (element == null) {
			return null;
		}
		return element.getModelElementId();
	}

	public static List<ModelElementId> getIds(
			List<? extends ModelElement> elements) {
		List<ModelElementId> ids = new ArrayList<ModelElementId>();
		for (ModelElement element : elements) {
			ids.add(getId(element));
		}
		return ids;
	}

	public static Diagnostic validate(
			SemanticCompositeOperation operation,
			Project project) {
		
		BasicDiagnostic diagnostic = new BasicDiagnostic();
		EObjectValidator.INSTANCE.validate_EveryDefaultConstraint(operation, diagnostic, null);
		
		for (EReference reference : operation.eClass().getEReferences()) {
			EOperation method = OperationHelper.getPossibleOperation(reference);
			if (method != null) {
				List possibleValues = getPossibleValues(operation, reference,
						project);
				if (reference.isMany()) {
					List value = getElements(project, (List<ModelElementId>) operation.eGet(reference));
					for(Object v : value) {
						if(!possibleValues.contains(v)) {
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

		return diagnostic;
	}

	public static List getPossibleValues(SemanticCompositeOperation operation,
			EStructuralFeature feature, Project project) {
		EOperation method = OperationHelper.getPossibleOperation(feature);
		if (method != null) {
			try {
				return OperationHelper.invokeOperation(operation, method, project);
			} catch (SecurityException e) {
				// ignore
			} catch (NoSuchMethodException e) {
				// ignore
			} catch (IllegalArgumentException e) {
				// ignore
			} catch (IllegalAccessException e) {
				// ignore
			} catch (InvocationTargetException e) {
				// ignore
			}
		}
		EClass type = OperationHelper.getType(feature);
		return project.getAllModelElementsbyClass(type, new BasicEList());
	}

	private static EClass getType(EStructuralFeature feature) {
		String name = "get" + firstUpper(feature.getName());
		EOperation operation = getOperation(feature.getEContainingClass(),
				name);
		if (operation == null) {
			return null;
		}
		return (EClass) operation.getEType();
	}

	private static EOperation getPossibleOperation(EStructuralFeature feature) {
		String name = "getPossible" + firstUpper(feature.getName());
		EOperation operation = getOperation(feature.getEContainingClass(),
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

	private static <V> V invokeOperation(EObject element, EOperation operation,
			Object... parameters) throws SecurityException,
			NoSuchMethodException, IllegalArgumentException,
			IllegalAccessException, InvocationTargetException {
		Class[] parameterTypes = new Class[parameters.length];
		for (int i = 0, n = parameters.length; i < n; i++) {
			parameterTypes[i] = parameters[i].getClass();
		}
		Method method = operation.getClass().getMethod(operation.getName(),
				Project.class);
		Object result = method.invoke(element, parameters);
		return (V) result;
	}

	private static String firstUpper(String name) {
		return name.substring(0, 1).toUpperCase() + name.substring(1);
	}
}
