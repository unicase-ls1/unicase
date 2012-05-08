/**
 * <copyright> Copyright (c) 2009-2012 Chair of Applied Software Engineering, Technische Universität München (TUM).
 * All rights reserved. This program and the accompanying materials are made available under the terms of
 * the Eclipse Public License v1.0 which accompanies this distribution,
 * and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>
 */
package org.unicase.implementation.operations.util;

import java.util.List;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.emfstore.common.model.IdentifiableElement;
import org.eclipse.emf.emfstore.server.model.versioning.operations.AbstractOperation;
import org.eclipse.emf.emfstore.server.model.versioning.operations.CompositeOperation;
import org.eclipse.emf.emfstore.server.model.versioning.operations.semantic.SemanticCompositeOperation;
import org.unicase.implementation.operations.ExtractClassOperation;
import org.unicase.implementation.operations.ExtractSuperClassOperation;
import org.unicase.implementation.operations.InlineClassOperation;
import org.unicase.implementation.operations.InlineSuperClassOperation;
import org.unicase.implementation.operations.OperationsPackage;
import org.unicase.implementation.operations.PartitionAssociationOperation;
import org.unicase.implementation.operations.PullUpOperation;
import org.unicase.implementation.operations.PushDownOperation;

/**
 * <!-- begin-user-doc --> The <b>Switch</b> for the model's inheritance hierarchy. It supports the call
 * {@link #doSwitch(EObject) doSwitch(object)} to invoke the <code>caseXXX</code> method for each class of the model,
 * starting with the actual class of the object and proceeding up the inheritance hierarchy until a non-null result is
 * returned, which is the result of the switch. <!-- end-user-doc -->
 * @see org.unicase.implementation.operations.OperationsPackage
 * @generated
 */
public class OperationsSwitch<T> {
	/**
	 * The cached model package
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	protected static OperationsPackage modelPackage;

	/**
	 * Creates an instance of the switch.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public OperationsSwitch() {
		if (modelPackage == null) {
			modelPackage = OperationsPackage.eINSTANCE;
		}
	}

	/**
	 * Calls <code>caseXXX</code> for each class of the model until one returns a non null result; it yields that result.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @return the first non-null result returned by a <code>caseXXX</code> call.
	 * @generated
	 */
	public T doSwitch(EObject theEObject) {
		return doSwitch(theEObject.eClass(), theEObject);
	}

	/**
	 * Calls <code>caseXXX</code> for each class of the model until one returns a non null result; it yields that result.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @return the first non-null result returned by a <code>caseXXX</code> call.
	 * @generated
	 */
	protected T doSwitch(EClass theEClass, EObject theEObject) {
		if (theEClass.eContainer() == modelPackage) {
			return doSwitch(theEClass.getClassifierID(), theEObject);
		}
		else {
			List<EClass> eSuperTypes = theEClass.getESuperTypes();
			return
				eSuperTypes.isEmpty() ?
					defaultCase(theEObject) :
					doSwitch(eSuperTypes.get(0), theEObject);
		}
	}

	/**
	 * Calls <code>caseXXX</code> for each class of the model until one returns a non null result; it yields that result.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @return the first non-null result returned by a <code>caseXXX</code> call.
	 * @generated
	 */
	protected T doSwitch(int classifierID, EObject theEObject) {
		switch (classifierID) {
			case OperationsPackage.EXTRACT_SUPER_CLASS_OPERATION: {
				ExtractSuperClassOperation extractSuperClassOperation = (ExtractSuperClassOperation)theEObject;
				T result = caseExtractSuperClassOperation(extractSuperClassOperation);
				if (result == null) result = caseSemanticCompositeOperation(extractSuperClassOperation);
				if (result == null) result = caseCompositeOperation(extractSuperClassOperation);
				if (result == null) result = caseAbstractOperation(extractSuperClassOperation);
				if (result == null) result = caseIdentifiableElement(extractSuperClassOperation);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case OperationsPackage.INLINE_SUPER_CLASS_OPERATION: {
				InlineSuperClassOperation inlineSuperClassOperation = (InlineSuperClassOperation)theEObject;
				T result = caseInlineSuperClassOperation(inlineSuperClassOperation);
				if (result == null) result = caseSemanticCompositeOperation(inlineSuperClassOperation);
				if (result == null) result = caseCompositeOperation(inlineSuperClassOperation);
				if (result == null) result = caseAbstractOperation(inlineSuperClassOperation);
				if (result == null) result = caseIdentifiableElement(inlineSuperClassOperation);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case OperationsPackage.EXTRACT_CLASS_OPERATION: {
				ExtractClassOperation extractClassOperation = (ExtractClassOperation)theEObject;
				T result = caseExtractClassOperation(extractClassOperation);
				if (result == null) result = caseSemanticCompositeOperation(extractClassOperation);
				if (result == null) result = caseCompositeOperation(extractClassOperation);
				if (result == null) result = caseAbstractOperation(extractClassOperation);
				if (result == null) result = caseIdentifiableElement(extractClassOperation);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case OperationsPackage.INLINE_CLASS_OPERATION: {
				InlineClassOperation inlineClassOperation = (InlineClassOperation)theEObject;
				T result = caseInlineClassOperation(inlineClassOperation);
				if (result == null) result = caseSemanticCompositeOperation(inlineClassOperation);
				if (result == null) result = caseCompositeOperation(inlineClassOperation);
				if (result == null) result = caseAbstractOperation(inlineClassOperation);
				if (result == null) result = caseIdentifiableElement(inlineClassOperation);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case OperationsPackage.PARTITION_ASSOCIATION_OPERATION: {
				PartitionAssociationOperation partitionAssociationOperation = (PartitionAssociationOperation)theEObject;
				T result = casePartitionAssociationOperation(partitionAssociationOperation);
				if (result == null) result = caseSemanticCompositeOperation(partitionAssociationOperation);
				if (result == null) result = caseCompositeOperation(partitionAssociationOperation);
				if (result == null) result = caseAbstractOperation(partitionAssociationOperation);
				if (result == null) result = caseIdentifiableElement(partitionAssociationOperation);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case OperationsPackage.PUSH_DOWN_OPERATION: {
				PushDownOperation pushDownOperation = (PushDownOperation)theEObject;
				T result = casePushDownOperation(pushDownOperation);
				if (result == null) result = caseSemanticCompositeOperation(pushDownOperation);
				if (result == null) result = caseCompositeOperation(pushDownOperation);
				if (result == null) result = caseAbstractOperation(pushDownOperation);
				if (result == null) result = caseIdentifiableElement(pushDownOperation);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case OperationsPackage.PULL_UP_OPERATION: {
				PullUpOperation pullUpOperation = (PullUpOperation)theEObject;
				T result = casePullUpOperation(pullUpOperation);
				if (result == null) result = caseSemanticCompositeOperation(pullUpOperation);
				if (result == null) result = caseCompositeOperation(pullUpOperation);
				if (result == null) result = caseAbstractOperation(pullUpOperation);
				if (result == null) result = caseIdentifiableElement(pullUpOperation);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			default: return defaultCase(theEObject);
		}
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Extract Super Class Operation</em>'. <!--
	 * begin-user-doc --> This implementation returns null; returning a non-null result will terminate the switch. <!--
	 * end-user-doc -->
	 * 
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Extract Super Class Operation</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseExtractSuperClassOperation(ExtractSuperClassOperation object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Inline Super Class Operation</em>'. <!--
	 * begin-user-doc --> This implementation returns null; returning a non-null result will terminate the switch. <!--
	 * end-user-doc -->
	 * 
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Inline Super Class Operation</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseInlineSuperClassOperation(InlineSuperClassOperation object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Inline Class Operation</em>'. <!--
	 * begin-user-doc --> This implementation returns null; returning a non-null result will terminate the switch. <!--
	 * end-user-doc -->
	 * 
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Inline Class Operation</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseInlineClassOperation(InlineClassOperation object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Extract Class Operation</em>'. <!--
	 * begin-user-doc --> This implementation returns null; returning a non-null result will terminate the switch. <!--
	 * end-user-doc -->
	 * 
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Extract Class Operation</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseExtractClassOperation(ExtractClassOperation object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Partition Association Operation</em>'. <!--
	 * begin-user-doc --> This implementation returns null; returning a non-null result will terminate the switch. <!--
	 * end-user-doc -->
	 * 
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Partition Association Operation</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T casePartitionAssociationOperation(PartitionAssociationOperation object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Push Down Operation</em>'. <!--
	 * begin-user-doc --> This implementation returns null; returning a non-null result will terminate the switch. <!--
	 * end-user-doc -->
	 * 
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Push Down Operation</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T casePushDownOperation(PushDownOperation object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Pull Up Operation</em>'. <!-- begin-user-doc
	 * --> This implementation returns null; returning a non-null result will terminate the switch. <!-- end-user-doc
	 * -->
	 * 
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Pull Up Operation</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T casePullUpOperation(PullUpOperation object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Identifiable Element</em>'. <!--
	 * begin-user-doc --> This implementation returns null; returning a non-null result will terminate the switch. <!--
	 * end-user-doc -->
	 * 
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Identifiable Element</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseIdentifiableElement(IdentifiableElement object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Abstract Operation</em>'. <!--
	 * begin-user-doc --> This implementation returns null; returning a non-null result will terminate the switch. <!--
	 * end-user-doc -->
	 * 
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Abstract Operation</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseAbstractOperation(AbstractOperation object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Composite Operation</em>'. <!--
	 * begin-user-doc --> This implementation returns null; returning a non-null result will terminate the switch. <!--
	 * end-user-doc -->
	 * 
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Composite Operation</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseCompositeOperation(CompositeOperation object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Composite Operation</em>'. <!--
	 * begin-user-doc --> This implementation returns null; returning a non-null result will terminate the switch. <!--
	 * end-user-doc -->
	 * 
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Composite Operation</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseSemanticCompositeOperation(SemanticCompositeOperation object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>EObject</em>'.
	 * <!-- begin-user-doc --> This
	 * implementation returns null; returning a non-null result will terminate the switch, but this is the last case
	 * anyway. <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>EObject</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject)
	 * @generated
	 */
	public T defaultCase(EObject object) {
		return null;
	}

} // OperationsSwitch
