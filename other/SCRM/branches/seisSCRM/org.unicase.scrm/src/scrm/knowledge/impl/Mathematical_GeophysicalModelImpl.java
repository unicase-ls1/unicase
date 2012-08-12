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
import scrm.knowledge.Assumption;
import scrm.knowledge.KnowledgePackage;
import scrm.knowledge.KnowledgeSpace;
import scrm.knowledge.Mathematical_GeophysicalModel;
import scrm.knowledge.NumericalMethod;
import scrm.knowledge.ScientificProblem;
import scrm.requirements.dataObject.DataDefinition;
import scrm.requirements.dataObject.DataObjectPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Mathematical Geophysical Model</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link scrm.knowledge.impl.Mathematical_GeophysicalModelImpl#getContainingKnowledgeSpace <em>Containing Knowledge Space</em>}</li>
 *   <li>{@link scrm.knowledge.impl.Mathematical_GeophysicalModelImpl#getRepresentedProblem <em>Represented Problem</em>}</li>
 *   <li>{@link scrm.knowledge.impl.Mathematical_GeophysicalModelImpl#getRefinements <em>Refinements</em>}</li>
 *   <li>{@link scrm.knowledge.impl.Mathematical_GeophysicalModelImpl#getRefinedModel <em>Refined Model</em>}</li>
 *   <li>{@link scrm.knowledge.impl.Mathematical_GeophysicalModelImpl#getUsedInNumericalMethods <em>Used In Numerical Methods</em>}</li>
 *   <li>{@link scrm.knowledge.impl.Mathematical_GeophysicalModelImpl#getDependencies <em>Dependencies</em>}</li>
 *   <li>{@link scrm.knowledge.impl.Mathematical_GeophysicalModelImpl#getInvolvedData <em>Involved Data</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class Mathematical_GeophysicalModelImpl extends SCRMModelElementImpl
		implements Mathematical_GeophysicalModel {
	/**
	 * The cached value of the '{@link #getRepresentedProblem() <em>Represented Problem</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getRepresentedProblem()
	 * @generated
	 * @ordered
	 */
	protected ScientificProblem representedProblem;

	/**
	 * The cached value of the '{@link #getRefinements() <em>Refinements</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getRefinements()
	 * @generated
	 * @ordered
	 */
	protected EList<Mathematical_GeophysicalModel> refinements;

	/**
	 * The cached value of the '{@link #getUsedInNumericalMethods() <em>Used In Numerical Methods</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getUsedInNumericalMethods()
	 * @generated
	 * @ordered
	 */
	protected EList<NumericalMethod> usedInNumericalMethods;

	/**
	 * The cached value of the '{@link #getDependencies() <em>Dependencies</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getDependencies()
	 * @generated
	 * @ordered
	 */
	protected EList<Assumption> dependencies;

	/**
	 * The cached value of the '{@link #getInvolvedData() <em>Involved Data</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getInvolvedData()
	 * @generated
	 * @ordered
	 */
	protected EList<DataDefinition> involvedData;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected Mathematical_GeophysicalModelImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return KnowledgePackage.Literals.MATHEMATICAL_GEOPHYSICAL_MODEL;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public KnowledgeSpace getContainingKnowledgeSpace() {
		if (eContainerFeatureID() != KnowledgePackage.MATHEMATICAL_GEOPHYSICAL_MODEL__CONTAINING_KNOWLEDGE_SPACE)
			return null;
		return (KnowledgeSpace) eContainer();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public KnowledgeSpace basicGetContainingKnowledgeSpace() {
		if (eContainerFeatureID() != KnowledgePackage.MATHEMATICAL_GEOPHYSICAL_MODEL__CONTAINING_KNOWLEDGE_SPACE)
			return null;
		return (KnowledgeSpace) eInternalContainer();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetContainingKnowledgeSpace(
			KnowledgeSpace newContainingKnowledgeSpace, NotificationChain msgs) {
		msgs = eBasicSetContainer(
				(InternalEObject) newContainingKnowledgeSpace,
				KnowledgePackage.MATHEMATICAL_GEOPHYSICAL_MODEL__CONTAINING_KNOWLEDGE_SPACE,
				msgs);
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setContainingKnowledgeSpace(
			KnowledgeSpace newContainingKnowledgeSpace) {
		if (newContainingKnowledgeSpace != eInternalContainer()
				|| (eContainerFeatureID() != KnowledgePackage.MATHEMATICAL_GEOPHYSICAL_MODEL__CONTAINING_KNOWLEDGE_SPACE && newContainingKnowledgeSpace != null)) {
			if (EcoreUtil.isAncestor(this, newContainingKnowledgeSpace))
				throw new IllegalArgumentException(
						"Recursive containment not allowed for " + toString());
			NotificationChain msgs = null;
			if (eInternalContainer() != null)
				msgs = eBasicRemoveFromContainer(msgs);
			if (newContainingKnowledgeSpace != null)
				msgs = ((InternalEObject) newContainingKnowledgeSpace)
						.eInverseAdd(
								this,
								KnowledgePackage.KNOWLEDGE_SPACE__CONTAINED_SCIENTIFIC_KNOWLEDGE,
								KnowledgeSpace.class, msgs);
			msgs = basicSetContainingKnowledgeSpace(
					newContainingKnowledgeSpace, msgs);
			if (msgs != null)
				msgs.dispatch();
		} else if (eNotificationRequired())
			eNotify(new ENotificationImpl(
					this,
					Notification.SET,
					KnowledgePackage.MATHEMATICAL_GEOPHYSICAL_MODEL__CONTAINING_KNOWLEDGE_SPACE,
					newContainingKnowledgeSpace, newContainingKnowledgeSpace));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ScientificProblem getRepresentedProblem() {
		if (representedProblem != null && representedProblem.eIsProxy()) {
			InternalEObject oldRepresentedProblem = (InternalEObject) representedProblem;
			representedProblem = (ScientificProblem) eResolveProxy(oldRepresentedProblem);
			if (representedProblem != oldRepresentedProblem) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(
							this,
							Notification.RESOLVE,
							KnowledgePackage.MATHEMATICAL_GEOPHYSICAL_MODEL__REPRESENTED_PROBLEM,
							oldRepresentedProblem, representedProblem));
			}
		}
		return representedProblem;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ScientificProblem basicGetRepresentedProblem() {
		return representedProblem;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetRepresentedProblem(
			ScientificProblem newRepresentedProblem, NotificationChain msgs) {
		ScientificProblem oldRepresentedProblem = representedProblem;
		representedProblem = newRepresentedProblem;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(
					this,
					Notification.SET,
					KnowledgePackage.MATHEMATICAL_GEOPHYSICAL_MODEL__REPRESENTED_PROBLEM,
					oldRepresentedProblem, newRepresentedProblem);
			if (msgs == null)
				msgs = notification;
			else
				msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setRepresentedProblem(ScientificProblem newRepresentedProblem) {
		if (newRepresentedProblem != representedProblem) {
			NotificationChain msgs = null;
			if (representedProblem != null)
				msgs = ((InternalEObject) representedProblem)
						.eInverseRemove(
								this,
								KnowledgePackage.SCIENTIFIC_PROBLEM__REPRESENTING_MODEL,
								ScientificProblem.class, msgs);
			if (newRepresentedProblem != null)
				msgs = ((InternalEObject) newRepresentedProblem)
						.eInverseAdd(
								this,
								KnowledgePackage.SCIENTIFIC_PROBLEM__REPRESENTING_MODEL,
								ScientificProblem.class, msgs);
			msgs = basicSetRepresentedProblem(newRepresentedProblem, msgs);
			if (msgs != null)
				msgs.dispatch();
		} else if (eNotificationRequired())
			eNotify(new ENotificationImpl(
					this,
					Notification.SET,
					KnowledgePackage.MATHEMATICAL_GEOPHYSICAL_MODEL__REPRESENTED_PROBLEM,
					newRepresentedProblem, newRepresentedProblem));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<Mathematical_GeophysicalModel> getRefinements() {
		if (refinements == null) {
			refinements = new EObjectContainmentWithInverseEList.Resolving<Mathematical_GeophysicalModel>(
					Mathematical_GeophysicalModel.class,
					this,
					KnowledgePackage.MATHEMATICAL_GEOPHYSICAL_MODEL__REFINEMENTS,
					KnowledgePackage.MATHEMATICAL_GEOPHYSICAL_MODEL__REFINED_MODEL);
		}
		return refinements;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Mathematical_GeophysicalModel getRefinedModel() {
		if (eContainerFeatureID() != KnowledgePackage.MATHEMATICAL_GEOPHYSICAL_MODEL__REFINED_MODEL)
			return null;
		return (Mathematical_GeophysicalModel) eContainer();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Mathematical_GeophysicalModel basicGetRefinedModel() {
		if (eContainerFeatureID() != KnowledgePackage.MATHEMATICAL_GEOPHYSICAL_MODEL__REFINED_MODEL)
			return null;
		return (Mathematical_GeophysicalModel) eInternalContainer();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetRefinedModel(
			Mathematical_GeophysicalModel newRefinedModel,
			NotificationChain msgs) {
		msgs = eBasicSetContainer((InternalEObject) newRefinedModel,
				KnowledgePackage.MATHEMATICAL_GEOPHYSICAL_MODEL__REFINED_MODEL,
				msgs);
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setRefinedModel(Mathematical_GeophysicalModel newRefinedModel) {
		if (newRefinedModel != eInternalContainer()
				|| (eContainerFeatureID() != KnowledgePackage.MATHEMATICAL_GEOPHYSICAL_MODEL__REFINED_MODEL && newRefinedModel != null)) {
			if (EcoreUtil.isAncestor(this, newRefinedModel))
				throw new IllegalArgumentException(
						"Recursive containment not allowed for " + toString());
			NotificationChain msgs = null;
			if (eInternalContainer() != null)
				msgs = eBasicRemoveFromContainer(msgs);
			if (newRefinedModel != null)
				msgs = ((InternalEObject) newRefinedModel)
						.eInverseAdd(
								this,
								KnowledgePackage.MATHEMATICAL_GEOPHYSICAL_MODEL__REFINEMENTS,
								Mathematical_GeophysicalModel.class, msgs);
			msgs = basicSetRefinedModel(newRefinedModel, msgs);
			if (msgs != null)
				msgs.dispatch();
		} else if (eNotificationRequired())
			eNotify(new ENotificationImpl(
					this,
					Notification.SET,
					KnowledgePackage.MATHEMATICAL_GEOPHYSICAL_MODEL__REFINED_MODEL,
					newRefinedModel, newRefinedModel));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<NumericalMethod> getUsedInNumericalMethods() {
		if (usedInNumericalMethods == null) {
			usedInNumericalMethods = new EObjectWithInverseResolvingEList<NumericalMethod>(
					NumericalMethod.class,
					this,
					KnowledgePackage.MATHEMATICAL_GEOPHYSICAL_MODEL__USED_IN_NUMERICAL_METHODS,
					KnowledgePackage.NUMERICAL_METHOD__USING_MATHEMATICAL_MODEL);
		}
		return usedInNumericalMethods;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<Assumption> getDependencies() {
		if (dependencies == null) {
			dependencies = new EObjectWithInverseResolvingEList<Assumption>(
					Assumption.class,
					this,
					KnowledgePackage.MATHEMATICAL_GEOPHYSICAL_MODEL__DEPENDENCIES,
					KnowledgePackage.ASSUMPTION__DEPENDING_MODEL);
		}
		return dependencies;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<DataDefinition> getInvolvedData() {
		if (involvedData == null) {
			involvedData = new EObjectWithInverseResolvingEList.ManyInverse<DataDefinition>(
					DataDefinition.class,
					this,
					KnowledgePackage.MATHEMATICAL_GEOPHYSICAL_MODEL__INVOLVED_DATA,
					DataObjectPackage.DATA_DEFINITION__DESCRIBED_MODEL);
		}
		return involvedData;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	@Override
	public NotificationChain eInverseAdd(InternalEObject otherEnd,
			int featureID, NotificationChain msgs) {
		switch (featureID) {
		case KnowledgePackage.MATHEMATICAL_GEOPHYSICAL_MODEL__CONTAINING_KNOWLEDGE_SPACE:
			if (eInternalContainer() != null)
				msgs = eBasicRemoveFromContainer(msgs);
			return basicSetContainingKnowledgeSpace((KnowledgeSpace) otherEnd,
					msgs);
		case KnowledgePackage.MATHEMATICAL_GEOPHYSICAL_MODEL__REPRESENTED_PROBLEM:
			if (representedProblem != null)
				msgs = ((InternalEObject) representedProblem)
						.eInverseRemove(
								this,
								KnowledgePackage.SCIENTIFIC_PROBLEM__REPRESENTING_MODEL,
								ScientificProblem.class, msgs);
			return basicSetRepresentedProblem((ScientificProblem) otherEnd,
					msgs);
		case KnowledgePackage.MATHEMATICAL_GEOPHYSICAL_MODEL__REFINEMENTS:
			return ((InternalEList<InternalEObject>) (InternalEList<?>) getRefinements())
					.basicAdd(otherEnd, msgs);
		case KnowledgePackage.MATHEMATICAL_GEOPHYSICAL_MODEL__REFINED_MODEL:
			if (eInternalContainer() != null)
				msgs = eBasicRemoveFromContainer(msgs);
			return basicSetRefinedModel(
					(Mathematical_GeophysicalModel) otherEnd, msgs);
		case KnowledgePackage.MATHEMATICAL_GEOPHYSICAL_MODEL__USED_IN_NUMERICAL_METHODS:
			return ((InternalEList<InternalEObject>) (InternalEList<?>) getUsedInNumericalMethods())
					.basicAdd(otherEnd, msgs);
		case KnowledgePackage.MATHEMATICAL_GEOPHYSICAL_MODEL__DEPENDENCIES:
			return ((InternalEList<InternalEObject>) (InternalEList<?>) getDependencies())
					.basicAdd(otherEnd, msgs);
		case KnowledgePackage.MATHEMATICAL_GEOPHYSICAL_MODEL__INVOLVED_DATA:
			return ((InternalEList<InternalEObject>) (InternalEList<?>) getInvolvedData())
					.basicAdd(otherEnd, msgs);
		}
		return super.eInverseAdd(otherEnd, featureID, msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd,
			int featureID, NotificationChain msgs) {
		switch (featureID) {
		case KnowledgePackage.MATHEMATICAL_GEOPHYSICAL_MODEL__CONTAINING_KNOWLEDGE_SPACE:
			return basicSetContainingKnowledgeSpace(null, msgs);
		case KnowledgePackage.MATHEMATICAL_GEOPHYSICAL_MODEL__REPRESENTED_PROBLEM:
			return basicSetRepresentedProblem(null, msgs);
		case KnowledgePackage.MATHEMATICAL_GEOPHYSICAL_MODEL__REFINEMENTS:
			return ((InternalEList<?>) getRefinements()).basicRemove(otherEnd,
					msgs);
		case KnowledgePackage.MATHEMATICAL_GEOPHYSICAL_MODEL__REFINED_MODEL:
			return basicSetRefinedModel(null, msgs);
		case KnowledgePackage.MATHEMATICAL_GEOPHYSICAL_MODEL__USED_IN_NUMERICAL_METHODS:
			return ((InternalEList<?>) getUsedInNumericalMethods())
					.basicRemove(otherEnd, msgs);
		case KnowledgePackage.MATHEMATICAL_GEOPHYSICAL_MODEL__DEPENDENCIES:
			return ((InternalEList<?>) getDependencies()).basicRemove(otherEnd,
					msgs);
		case KnowledgePackage.MATHEMATICAL_GEOPHYSICAL_MODEL__INVOLVED_DATA:
			return ((InternalEList<?>) getInvolvedData()).basicRemove(otherEnd,
					msgs);
		}
		return super.eInverseRemove(otherEnd, featureID, msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eBasicRemoveFromContainerFeature(
			NotificationChain msgs) {
		switch (eContainerFeatureID()) {
		case KnowledgePackage.MATHEMATICAL_GEOPHYSICAL_MODEL__CONTAINING_KNOWLEDGE_SPACE:
			return eInternalContainer()
					.eInverseRemove(
							this,
							KnowledgePackage.KNOWLEDGE_SPACE__CONTAINED_SCIENTIFIC_KNOWLEDGE,
							KnowledgeSpace.class, msgs);
		case KnowledgePackage.MATHEMATICAL_GEOPHYSICAL_MODEL__REFINED_MODEL:
			return eInternalContainer()
					.eInverseRemove(
							this,
							KnowledgePackage.MATHEMATICAL_GEOPHYSICAL_MODEL__REFINEMENTS,
							Mathematical_GeophysicalModel.class, msgs);
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
		case KnowledgePackage.MATHEMATICAL_GEOPHYSICAL_MODEL__CONTAINING_KNOWLEDGE_SPACE:
			if (resolve)
				return getContainingKnowledgeSpace();
			return basicGetContainingKnowledgeSpace();
		case KnowledgePackage.MATHEMATICAL_GEOPHYSICAL_MODEL__REPRESENTED_PROBLEM:
			if (resolve)
				return getRepresentedProblem();
			return basicGetRepresentedProblem();
		case KnowledgePackage.MATHEMATICAL_GEOPHYSICAL_MODEL__REFINEMENTS:
			return getRefinements();
		case KnowledgePackage.MATHEMATICAL_GEOPHYSICAL_MODEL__REFINED_MODEL:
			if (resolve)
				return getRefinedModel();
			return basicGetRefinedModel();
		case KnowledgePackage.MATHEMATICAL_GEOPHYSICAL_MODEL__USED_IN_NUMERICAL_METHODS:
			return getUsedInNumericalMethods();
		case KnowledgePackage.MATHEMATICAL_GEOPHYSICAL_MODEL__DEPENDENCIES:
			return getDependencies();
		case KnowledgePackage.MATHEMATICAL_GEOPHYSICAL_MODEL__INVOLVED_DATA:
			return getInvolvedData();
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
		case KnowledgePackage.MATHEMATICAL_GEOPHYSICAL_MODEL__CONTAINING_KNOWLEDGE_SPACE:
			setContainingKnowledgeSpace((KnowledgeSpace) newValue);
			return;
		case KnowledgePackage.MATHEMATICAL_GEOPHYSICAL_MODEL__REPRESENTED_PROBLEM:
			setRepresentedProblem((ScientificProblem) newValue);
			return;
		case KnowledgePackage.MATHEMATICAL_GEOPHYSICAL_MODEL__REFINEMENTS:
			getRefinements().clear();
			getRefinements()
					.addAll((Collection<? extends Mathematical_GeophysicalModel>) newValue);
			return;
		case KnowledgePackage.MATHEMATICAL_GEOPHYSICAL_MODEL__REFINED_MODEL:
			setRefinedModel((Mathematical_GeophysicalModel) newValue);
			return;
		case KnowledgePackage.MATHEMATICAL_GEOPHYSICAL_MODEL__USED_IN_NUMERICAL_METHODS:
			getUsedInNumericalMethods().clear();
			getUsedInNumericalMethods().addAll(
					(Collection<? extends NumericalMethod>) newValue);
			return;
		case KnowledgePackage.MATHEMATICAL_GEOPHYSICAL_MODEL__DEPENDENCIES:
			getDependencies().clear();
			getDependencies().addAll(
					(Collection<? extends Assumption>) newValue);
			return;
		case KnowledgePackage.MATHEMATICAL_GEOPHYSICAL_MODEL__INVOLVED_DATA:
			getInvolvedData().clear();
			getInvolvedData().addAll(
					(Collection<? extends DataDefinition>) newValue);
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
		case KnowledgePackage.MATHEMATICAL_GEOPHYSICAL_MODEL__CONTAINING_KNOWLEDGE_SPACE:
			setContainingKnowledgeSpace((KnowledgeSpace) null);
			return;
		case KnowledgePackage.MATHEMATICAL_GEOPHYSICAL_MODEL__REPRESENTED_PROBLEM:
			setRepresentedProblem((ScientificProblem) null);
			return;
		case KnowledgePackage.MATHEMATICAL_GEOPHYSICAL_MODEL__REFINEMENTS:
			getRefinements().clear();
			return;
		case KnowledgePackage.MATHEMATICAL_GEOPHYSICAL_MODEL__REFINED_MODEL:
			setRefinedModel((Mathematical_GeophysicalModel) null);
			return;
		case KnowledgePackage.MATHEMATICAL_GEOPHYSICAL_MODEL__USED_IN_NUMERICAL_METHODS:
			getUsedInNumericalMethods().clear();
			return;
		case KnowledgePackage.MATHEMATICAL_GEOPHYSICAL_MODEL__DEPENDENCIES:
			getDependencies().clear();
			return;
		case KnowledgePackage.MATHEMATICAL_GEOPHYSICAL_MODEL__INVOLVED_DATA:
			getInvolvedData().clear();
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
		case KnowledgePackage.MATHEMATICAL_GEOPHYSICAL_MODEL__CONTAINING_KNOWLEDGE_SPACE:
			return basicGetContainingKnowledgeSpace() != null;
		case KnowledgePackage.MATHEMATICAL_GEOPHYSICAL_MODEL__REPRESENTED_PROBLEM:
			return representedProblem != null;
		case KnowledgePackage.MATHEMATICAL_GEOPHYSICAL_MODEL__REFINEMENTS:
			return refinements != null && !refinements.isEmpty();
		case KnowledgePackage.MATHEMATICAL_GEOPHYSICAL_MODEL__REFINED_MODEL:
			return basicGetRefinedModel() != null;
		case KnowledgePackage.MATHEMATICAL_GEOPHYSICAL_MODEL__USED_IN_NUMERICAL_METHODS:
			return usedInNumericalMethods != null
					&& !usedInNumericalMethods.isEmpty();
		case KnowledgePackage.MATHEMATICAL_GEOPHYSICAL_MODEL__DEPENDENCIES:
			return dependencies != null && !dependencies.isEmpty();
		case KnowledgePackage.MATHEMATICAL_GEOPHYSICAL_MODEL__INVOLVED_DATA:
			return involvedData != null && !involvedData.isEmpty();
		}
		return super.eIsSet(featureID);
	}

} //Mathematical_GeophysicalModelImpl
