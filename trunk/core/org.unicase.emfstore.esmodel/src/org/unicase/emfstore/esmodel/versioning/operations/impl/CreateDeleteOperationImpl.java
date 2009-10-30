/**
 * <copyright> Copyright (c) 2008-2009 Jonas Helming, Maximilian Koegel. All rights reserved. This program and the
 * accompanying materials are made available under the terms of the Eclipse Public License v1.0 which accompanies this
 * distribution, and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>
 */
package org.unicase.emfstore.esmodel.versioning.operations.impl;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.InternalEList;
import org.unicase.emfstore.esmodel.versioning.operations.AbstractOperation;
import org.unicase.emfstore.esmodel.versioning.operations.CreateDeleteOperation;
import org.unicase.emfstore.esmodel.versioning.operations.OperationsFactory;
import org.unicase.emfstore.esmodel.versioning.operations.OperationsPackage;
import org.unicase.emfstore.esmodel.versioning.operations.ReferenceOperation;
import org.unicase.metamodel.ModelElement;
import org.unicase.metamodel.ModelElementId;
import org.unicase.metamodel.Project;
import org.unicase.metamodel.util.ModelUtil;

/**
 * <!-- begin-user-doc --> An implementation of the model object ' <em><b>Create Delete Operation</b></em>'. <!--
 * end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 * <li>{@link org.unicase.emfstore.esmodel.versioning.operations.impl.CreateDeleteOperationImpl#isDelete <em>Delete
 * </em>}</li>
 * <li>{@link org.unicase.emfstore.esmodel.versioning.operations.impl.CreateDeleteOperationImpl#getModelElement <em>
 * Model Element</em>}</li>
 * <li>{@link org.unicase.emfstore.esmodel.versioning.operations.impl.CreateDeleteOperationImpl#getSubOperations <em>Sub
 * Operations</em>}</li>
 * </ul>
 * </p>
 * 
 * @generated
 */
public class CreateDeleteOperationImpl extends AbstractOperationImpl implements CreateDeleteOperation {

	public void apply(Project project) {
		if (isDelete()) {
			if (!project.contains(getModelElementId())) {
				// silently fail
				return;
			}
			ModelElement localModelElement = project.getModelElement(getModelElementId());
			project.deleteModelElement(localModelElement);
		} else {
			if (project.contains(getModelElementId())) {
				// silently fail
				return;
			}
			project.getModelElements().add(ModelUtil.clone(getModelElement()));
			for (ReferenceOperation operation : getSubOperations()) {
				operation.apply(project);
			}
		}
	}

	@Override
	public boolean canApply(Project project) {
		checkValidity();
		if (isDelete()) {
			return project.contains(getModelElementId());
		} else {
			return !project.contains(getModelElementId());
		}
	}

	private void checkValidity() {
		if (!getModelElementId().equals(getModelElement().getModelElementId())) {
			throw new IllegalStateException("CreateDeleteOperation has different ids in model element and id features!");
		}
	}

	@Override
	public AbstractOperation reverse() {
		checkValidity();
		CreateDeleteOperation createDeleteOperation = OperationsFactory.eINSTANCE.createCreateDeleteOperation();
		super.reverse(createDeleteOperation);
		createDeleteOperation.setDelete(!this.isDelete());
		createDeleteOperation.setModelElement(ModelUtil.clone(this.getModelElement()));
		EList<ReferenceOperation> clonedSubOperations = createDeleteOperation.getSubOperations();
		for (ReferenceOperation operation : getSubOperations()) {
			clonedSubOperations.add(0, (ReferenceOperation) operation.reverse());
		}
		return createDeleteOperation;
	}

	/**
	 * The default value of the '{@link #isDelete() <em>Delete</em>}' attribute. <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * 
	 * @see #isDelete()
	 * @generated
	 * @ordered
	 */
	protected static final boolean DELETE_EDEFAULT = false;

	/**
	 * The cached value of the '{@link #isDelete() <em>Delete</em>}' attribute. <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * 
	 * @see #isDelete()
	 * @generated
	 * @ordered
	 */
	protected boolean delete = DELETE_EDEFAULT;

	/**
	 * The cached value of the '{@link #getModelElement() <em>Model Element</em>}' containment reference. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see #getModelElement()
	 * @generated
	 * @ordered
	 */
	protected ModelElement modelElement;

	/**
	 * The cached value of the '{@link #getSubOperations() <em>Sub Operations</em>}' containment reference list. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see #getSubOperations()
	 * @generated
	 * @ordered
	 */
	protected EList<ReferenceOperation> subOperations;

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	protected CreateDeleteOperationImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return OperationsPackage.Literals.CREATE_DELETE_OPERATION;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public boolean isDelete() {
		return delete;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public void setDelete(boolean newDelete) {
		boolean oldDelete = delete;
		delete = newDelete;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, OperationsPackage.CREATE_DELETE_OPERATION__DELETE,
				oldDelete, delete));
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public ModelElement getModelElement() {
		if (modelElement != null && modelElement.eIsProxy()) {
			InternalEObject oldModelElement = (InternalEObject) modelElement;
			modelElement = (ModelElement) eResolveProxy(oldModelElement);
			if (modelElement != oldModelElement) {
				InternalEObject newModelElement = (InternalEObject) modelElement;
				NotificationChain msgs = oldModelElement.eInverseRemove(this, EOPPOSITE_FEATURE_BASE
					- OperationsPackage.CREATE_DELETE_OPERATION__MODEL_ELEMENT, null, null);
				if (newModelElement.eInternalContainer() == null) {
					msgs = newModelElement.eInverseAdd(this, EOPPOSITE_FEATURE_BASE
						- OperationsPackage.CREATE_DELETE_OPERATION__MODEL_ELEMENT, null, msgs);
				}
				if (msgs != null)
					msgs.dispatch();
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE,
						OperationsPackage.CREATE_DELETE_OPERATION__MODEL_ELEMENT, oldModelElement, modelElement));
			}
		}
		return modelElement;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public ModelElement basicGetModelElement() {
		return modelElement;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public NotificationChain basicSetModelElement(ModelElement newModelElement, NotificationChain msgs) {
		ModelElement oldModelElement = modelElement;
		modelElement = newModelElement;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET,
				OperationsPackage.CREATE_DELETE_OPERATION__MODEL_ELEMENT, oldModelElement, newModelElement);
			if (msgs == null)
				msgs = notification;
			else
				msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public void setModelElement(ModelElement newModelElement) {
		if (newModelElement != modelElement) {
			NotificationChain msgs = null;
			if (modelElement != null)
				msgs = ((InternalEObject) modelElement).eInverseRemove(this, EOPPOSITE_FEATURE_BASE
					- OperationsPackage.CREATE_DELETE_OPERATION__MODEL_ELEMENT, null, msgs);
			if (newModelElement != null)
				msgs = ((InternalEObject) newModelElement).eInverseAdd(this, EOPPOSITE_FEATURE_BASE
					- OperationsPackage.CREATE_DELETE_OPERATION__MODEL_ELEMENT, null, msgs);
			msgs = basicSetModelElement(newModelElement, msgs);
			if (msgs != null)
				msgs.dispatch();
		} else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET,
				OperationsPackage.CREATE_DELETE_OPERATION__MODEL_ELEMENT, newModelElement, newModelElement));
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public EList<ReferenceOperation> getSubOperations() {
		if (subOperations == null) {
			subOperations = new EObjectContainmentEList.Resolving<ReferenceOperation>(ReferenceOperation.class, this,
				OperationsPackage.CREATE_DELETE_OPERATION__SUB_OPERATIONS);
		}
		return subOperations;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
		case OperationsPackage.CREATE_DELETE_OPERATION__MODEL_ELEMENT:
			return basicSetModelElement(null, msgs);
		case OperationsPackage.CREATE_DELETE_OPERATION__SUB_OPERATIONS:
			return ((InternalEList<?>) getSubOperations()).basicRemove(otherEnd, msgs);
		}
		return super.eInverseRemove(otherEnd, featureID, msgs);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
		case OperationsPackage.CREATE_DELETE_OPERATION__DELETE:
			return isDelete();
		case OperationsPackage.CREATE_DELETE_OPERATION__MODEL_ELEMENT:
			if (resolve)
				return getModelElement();
			return basicGetModelElement();
		case OperationsPackage.CREATE_DELETE_OPERATION__SUB_OPERATIONS:
			return getSubOperations();
		}
		return super.eGet(featureID, resolve, coreType);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	@Override
	public void eSet(int featureID, Object newValue) {
		switch (featureID) {
		case OperationsPackage.CREATE_DELETE_OPERATION__DELETE:
			setDelete((Boolean) newValue);
			return;
		case OperationsPackage.CREATE_DELETE_OPERATION__MODEL_ELEMENT:
			setModelElement((ModelElement) newValue);
			return;
		case OperationsPackage.CREATE_DELETE_OPERATION__SUB_OPERATIONS:
			getSubOperations().clear();
			getSubOperations().addAll((Collection<? extends ReferenceOperation>) newValue);
			return;
		}
		super.eSet(featureID, newValue);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public void eUnset(int featureID) {
		switch (featureID) {
		case OperationsPackage.CREATE_DELETE_OPERATION__DELETE:
			setDelete(DELETE_EDEFAULT);
			return;
		case OperationsPackage.CREATE_DELETE_OPERATION__MODEL_ELEMENT:
			setModelElement((ModelElement) null);
			return;
		case OperationsPackage.CREATE_DELETE_OPERATION__SUB_OPERATIONS:
			getSubOperations().clear();
			return;
		}
		super.eUnset(featureID);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public boolean eIsSet(int featureID) {
		switch (featureID) {
		case OperationsPackage.CREATE_DELETE_OPERATION__DELETE:
			return delete != DELETE_EDEFAULT;
		case OperationsPackage.CREATE_DELETE_OPERATION__MODEL_ELEMENT:
			return modelElement != null;
		case OperationsPackage.CREATE_DELETE_OPERATION__SUB_OPERATIONS:
			return subOperations != null && !subOperations.isEmpty();
		}
		return super.eIsSet(featureID);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public String toString() {
		if (eIsProxy())
			return super.toString();

		StringBuffer result = new StringBuffer(super.toString());
		result.append(" (delete: ");
		result.append(delete);
		result.append(')');
		return result.toString();
	}

	@Override
	public String getDescription() {
		StringBuilder stringBuilder = new StringBuilder();
		if (isDelete()) {
			stringBuilder.append("Deleted  ");
		} else {
			stringBuilder.append("Created ");
		}
		stringBuilder.append(getModelElement().eClass().getName());
		stringBuilder.append(" ");
		stringBuilder.append(getModelElement().getIdentifier());
		// stringBuilder.append(".");
		return stringBuilder.toString();
	}

	@Override
	public String getName() {
		StringBuilder stringBuilder = new StringBuilder();
		if (isDelete()) {
			stringBuilder.append("Deleted  ");
			stringBuilder.append(getModelElement().eClass().getName());
			stringBuilder.append(" \"");
			stringBuilder.append(getModelElement().getIdentifier());
			stringBuilder.append("\"");
		} else {
			stringBuilder.append("Created ");
			stringBuilder.append(getModelElement().eClass().getName());
		}
		return stringBuilder.toString();
	}

	/**
	 * @see org.unicase.emfstore.esmodel.versioning.operations.impl.AbstractOperationImpl#getOtherInvolvedModelElements()
	 */
	@Override
	public Set<ModelElementId> getOtherInvolvedModelElements() {
		Set<ModelElementId> result = new HashSet<ModelElementId>();
		for (ModelElement modelElement : getModelElement().getAllContainedModelElements()) {
			result.add(modelElement.getModelElementId());
		}
		for (ReferenceOperation operation : getSubOperations()) {
			result.addAll(operation.getAllInvolvedModelElements());
		}
		return result;
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.unicase.emfstore.esmodel.versioning.operations.AbstractOperation#getLeafOperations()
	 */
	public List<AbstractOperation> getLeafOperations() {
		List<AbstractOperation> result = new ArrayList<AbstractOperation>(getSubOperations().size() + 1);
		CreateDeleteOperation createDeleteClone = ModelUtil.clone(this);
		createDeleteClone.getSubOperations().clear();
		result.add(createDeleteClone);
		result.addAll(getSubOperations());
		return result;
	}

} // CreateDeleteOperationImpl
