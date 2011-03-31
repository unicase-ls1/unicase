/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package scrm.knowledge.impl;

import java.util.Collection;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

import org.eclipse.emf.ecore.util.EObjectContainmentWithInverseEList;
import org.eclipse.emf.ecore.util.EObjectWithInverseResolvingEList;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.ecore.util.InternalEList;

import scrm.impl.SCRMModelElementImpl;

import scrm.knowledge.KnowledgePackage;
import scrm.knowledge.KnowledgeSpace;
import scrm.knowledge.ScientificKnowledge;

import scrm.requirements.IRequirement;
import scrm.requirements.RequirementsPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Space</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link scrm.knowledge.impl.KnowledgeSpaceImpl#getContainingKnowledgeSpace <em>Containing Knowledge Space</em>}</li>
 *   <li>{@link scrm.knowledge.impl.KnowledgeSpaceImpl#getContainedScientificProblem <em>Contained Scientific Problem</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class KnowledgeSpaceImpl extends SCRMModelElementImpl implements KnowledgeSpace {
	/**
	 * The cached value of the '{@link #getContainedScientificProblem() <em>Contained Scientific Problem</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getContainedScientificProblem()
	 * @generated
	 * @ordered
	 */
	protected EList<ScientificKnowledge> containedScientificProblem;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected KnowledgeSpaceImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return KnowledgePackage.Literals.KNOWLEDGE_SPACE;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public KnowledgeSpace getContainingKnowledgeSpace() {
		if (eContainerFeatureID() != KnowledgePackage.KNOWLEDGE_SPACE__CONTAINING_KNOWLEDGE_SPACE) return null;
		return (KnowledgeSpace)eContainer();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetContainingKnowledgeSpace(KnowledgeSpace newContainingKnowledgeSpace, NotificationChain msgs) {
		msgs = eBasicSetContainer((InternalEObject)newContainingKnowledgeSpace, KnowledgePackage.KNOWLEDGE_SPACE__CONTAINING_KNOWLEDGE_SPACE, msgs);
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setContainingKnowledgeSpace(KnowledgeSpace newContainingKnowledgeSpace) {
		if (newContainingKnowledgeSpace != eInternalContainer() || (eContainerFeatureID() != KnowledgePackage.KNOWLEDGE_SPACE__CONTAINING_KNOWLEDGE_SPACE && newContainingKnowledgeSpace != null)) {
			if (EcoreUtil.isAncestor(this, newContainingKnowledgeSpace))
				throw new IllegalArgumentException("Recursive containment not allowed for " + toString());
			NotificationChain msgs = null;
			if (eInternalContainer() != null)
				msgs = eBasicRemoveFromContainer(msgs);
			if (newContainingKnowledgeSpace != null)
				msgs = ((InternalEObject)newContainingKnowledgeSpace).eInverseAdd(this, KnowledgePackage.KNOWLEDGE_SPACE__CONTAINED_SCIENTIFIC_PROBLEM, KnowledgeSpace.class, msgs);
			msgs = basicSetContainingKnowledgeSpace(newContainingKnowledgeSpace, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, KnowledgePackage.KNOWLEDGE_SPACE__CONTAINING_KNOWLEDGE_SPACE, newContainingKnowledgeSpace, newContainingKnowledgeSpace));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<ScientificKnowledge> getContainedScientificProblem() {
		if (containedScientificProblem == null) {
			containedScientificProblem = new EObjectContainmentWithInverseEList<ScientificKnowledge>(ScientificKnowledge.class, this, KnowledgePackage.KNOWLEDGE_SPACE__CONTAINED_SCIENTIFIC_PROBLEM, KnowledgePackage.SCIENTIFIC_KNOWLEDGE__CONTAINING_KNOWLEDGE_SPACE);
		}
		return containedScientificProblem;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	@Override
	public NotificationChain eInverseAdd(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case KnowledgePackage.KNOWLEDGE_SPACE__CONTAINING_KNOWLEDGE_SPACE:
				if (eInternalContainer() != null)
					msgs = eBasicRemoveFromContainer(msgs);
				return basicSetContainingKnowledgeSpace((KnowledgeSpace)otherEnd, msgs);
			case KnowledgePackage.KNOWLEDGE_SPACE__CONTAINED_SCIENTIFIC_PROBLEM:
				return ((InternalEList<InternalEObject>)(InternalEList<?>)getContainedScientificProblem()).basicAdd(otherEnd, msgs);
		}
		return super.eInverseAdd(otherEnd, featureID, msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case KnowledgePackage.KNOWLEDGE_SPACE__CONTAINING_KNOWLEDGE_SPACE:
				return basicSetContainingKnowledgeSpace(null, msgs);
			case KnowledgePackage.KNOWLEDGE_SPACE__CONTAINED_SCIENTIFIC_PROBLEM:
				return ((InternalEList<?>)getContainedScientificProblem()).basicRemove(otherEnd, msgs);
		}
		return super.eInverseRemove(otherEnd, featureID, msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eBasicRemoveFromContainerFeature(NotificationChain msgs) {
		switch (eContainerFeatureID()) {
			case KnowledgePackage.KNOWLEDGE_SPACE__CONTAINING_KNOWLEDGE_SPACE:
				return eInternalContainer().eInverseRemove(this, KnowledgePackage.KNOWLEDGE_SPACE__CONTAINED_SCIENTIFIC_PROBLEM, KnowledgeSpace.class, msgs);
		}
		return super.eBasicRemoveFromContainerFeature(msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case KnowledgePackage.KNOWLEDGE_SPACE__CONTAINING_KNOWLEDGE_SPACE:
				return getContainingKnowledgeSpace();
			case KnowledgePackage.KNOWLEDGE_SPACE__CONTAINED_SCIENTIFIC_PROBLEM:
				return getContainedScientificProblem();
		}
		return super.eGet(featureID, resolve, coreType);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	@Override
	public void eSet(int featureID, Object newValue) {
		switch (featureID) {
			case KnowledgePackage.KNOWLEDGE_SPACE__CONTAINING_KNOWLEDGE_SPACE:
				setContainingKnowledgeSpace((KnowledgeSpace)newValue);
				return;
			case KnowledgePackage.KNOWLEDGE_SPACE__CONTAINED_SCIENTIFIC_PROBLEM:
				getContainedScientificProblem().clear();
				getContainedScientificProblem().addAll((Collection<? extends ScientificKnowledge>)newValue);
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
			case KnowledgePackage.KNOWLEDGE_SPACE__CONTAINING_KNOWLEDGE_SPACE:
				setContainingKnowledgeSpace((KnowledgeSpace)null);
				return;
			case KnowledgePackage.KNOWLEDGE_SPACE__CONTAINED_SCIENTIFIC_PROBLEM:
				getContainedScientificProblem().clear();
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
			case KnowledgePackage.KNOWLEDGE_SPACE__CONTAINING_KNOWLEDGE_SPACE:
				return getContainingKnowledgeSpace() != null;
			case KnowledgePackage.KNOWLEDGE_SPACE__CONTAINED_SCIENTIFIC_PROBLEM:
				return containedScientificProblem != null && !containedScientificProblem.isEmpty();
		}
		return super.eIsSet(featureID);
	}

} //KnowledgeSpaceImpl
