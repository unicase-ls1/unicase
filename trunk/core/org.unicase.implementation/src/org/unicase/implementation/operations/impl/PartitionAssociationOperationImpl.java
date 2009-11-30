/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.unicase.implementation.operations.impl;

import java.util.List;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.unicase.emfstore.esmodel.versioning.operations.semantic.impl.SemanticCompositeOperationImpl;
import org.unicase.implementation.operations.OperationsPackage;
import org.unicase.implementation.operations.PartitionAssociationOperation;
import org.unicase.implementation.operations.util.OperationHelper;
import org.unicase.metamodel.ModelElementId;
import org.unicase.metamodel.Project;
import org.unicase.model.classes.Association;
import org.unicase.model.classes.Class;
import org.unicase.model.classes.ClassesFactory;
import org.unicase.model.classes.InstantiationType;
import org.unicase.model.classes.validation.ImplementationValidationHelper;
import org.unicase.model.classes.validation.MultiplicityParseResult;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Partition Association Operation</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.unicase.implementation.operations.impl.PartitionAssociationOperationImpl#getAssociation <em>Association</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class PartitionAssociationOperationImpl extends SemanticCompositeOperationImpl implements PartitionAssociationOperation {
	/**
	 * The cached value of the '{@link #getAssociation() <em>Association</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getAssociation()
	 * @generated
	 * @ordered
	 */
	protected ModelElementId association;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected PartitionAssociationOperationImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return OperationsPackage.Literals.PARTITION_ASSOCIATION_OPERATION;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ModelElementId getAssociation() {
		return association;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetAssociation(ModelElementId newAssociation, NotificationChain msgs) {
		ModelElementId oldAssociation = association;
		association = newAssociation;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, OperationsPackage.PARTITION_ASSOCIATION_OPERATION__ASSOCIATION, oldAssociation, newAssociation);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setAssociation(ModelElementId newAssociation) {
		if (newAssociation != association) {
			NotificationChain msgs = null;
			if (association != null)
				msgs = ((InternalEObject)association).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - OperationsPackage.PARTITION_ASSOCIATION_OPERATION__ASSOCIATION, null, msgs);
			if (newAssociation != null)
				msgs = ((InternalEObject)newAssociation).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - OperationsPackage.PARTITION_ASSOCIATION_OPERATION__ASSOCIATION, null, msgs);
			msgs = basicSetAssociation(newAssociation, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, OperationsPackage.PARTITION_ASSOCIATION_OPERATION__ASSOCIATION, newAssociation, newAssociation));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Association getAssociation(Project project) {
		return OperationHelper.getElement(project, getAssociation());
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated NOT
	 */
	public boolean validateAssociationTarget(Project project) {
		Association association = getAssociation(project);

		Class target = association.getTarget();
		return target.getInstantiationType() == InstantiationType.ABSTRACT
			|| target.getInstantiationType() == InstantiationType.INTERFACE;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated NOT
	 */
	public boolean validateAssociationMultiplicity(Project project) {
		Association association = getAssociation(project);

		MultiplicityParseResult targetMultiplicity = ImplementationValidationHelper.parseMultiplicity(association
			.getTargetMultiplicity());

		return targetMultiplicity.getMaximumMultiplicity() == -1;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case OperationsPackage.PARTITION_ASSOCIATION_OPERATION__ASSOCIATION:
				return basicSetAssociation(null, msgs);
		}
		return super.eInverseRemove(otherEnd, featureID, msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case OperationsPackage.PARTITION_ASSOCIATION_OPERATION__ASSOCIATION:
				return getAssociation();
		}
		return super.eGet(featureID, resolve, coreType);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void eSet(int featureID, Object newValue) {
		switch (featureID) {
			case OperationsPackage.PARTITION_ASSOCIATION_OPERATION__ASSOCIATION:
				setAssociation((ModelElementId)newValue);
				return;
		}
		super.eSet(featureID, newValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void eUnset(int featureID) {
		switch (featureID) {
			case OperationsPackage.PARTITION_ASSOCIATION_OPERATION__ASSOCIATION:
				setAssociation((ModelElementId)null);
				return;
		}
		super.eUnset(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean eIsSet(int featureID) {
		switch (featureID) {
			case OperationsPackage.PARTITION_ASSOCIATION_OPERATION__ASSOCIATION:
				return association != null;
		}
		return super.eIsSet(featureID);
	}

	public void semanticApply(Project project) {
		Association association = getAssociation(project);		
		Class target = association.getTarget();
		
		for(Class subClass : target.getSubClasses()) {
			String name = subClass.getName().substring(0, 1).toLowerCase() + subClass.getName().substring(1);
			Association subAssociation = ClassesFactory.eINSTANCE.createAssociation();
			((List) association.eContainer().eGet(association.eContainmentFeature())).add(subAssociation);

			subAssociation.setType(association.getType());

			subAssociation.setTarget(subClass);
			subAssociation.setTargetRole(name);
			subAssociation.setTargetMultiplicity(association.getTargetMultiplicity());

			subAssociation.setSource(association.getSource());
			subAssociation.setSourceRole(association.getSourceRole());
			subAssociation.setSourceMultiplicity(association.getSourceMultiplicity());
		}
		                 	
		association.delete();
	}

} //PartitionAssociationOperationImpl
