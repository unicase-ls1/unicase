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
import scrm.knowledge.Method;
import scrm.knowledge.Model;
import scrm.knowledge.ScientificProblem;
import scrm.requirements.dataObject.Data;
import scrm.requirements.dataObject.DataObjectPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Model</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link scrm.knowledge.impl.ModelImpl#getRepresentedProblem <em>Represented Problem</em>}</li>
 *   <li>{@link scrm.knowledge.impl.ModelImpl#getRefinements <em>Refinements</em>}</li>
 *   <li>{@link scrm.knowledge.impl.ModelImpl#getRefinedModel <em>Refined Model</em>}</li>
 *   <li>{@link scrm.knowledge.impl.ModelImpl#getUsedInMethods <em>Used In Methods</em>}</li>
 *   <li>{@link scrm.knowledge.impl.ModelImpl#getDependencies <em>Dependencies</em>}</li>
 *   <li>{@link scrm.knowledge.impl.ModelImpl#getInvolvedData <em>Involved Data</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class ModelImpl extends SCRMModelElementImpl implements Model {
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
	protected EList<Model> refinements;

	/**
	 * The cached value of the '{@link #getUsedInMethods() <em>Used In Methods</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getUsedInMethods()
	 * @generated
	 * @ordered
	 */
	protected EList<Method> usedInMethods;

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
	protected EList<Data> involvedData;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected ModelImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return KnowledgePackage.Literals.MODEL;
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
					eNotify(new ENotificationImpl(this, Notification.RESOLVE,
							KnowledgePackage.MODEL__REPRESENTED_PROBLEM,
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
			ENotificationImpl notification = new ENotificationImpl(this,
					Notification.SET,
					KnowledgePackage.MODEL__REPRESENTED_PROBLEM,
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
			eNotify(new ENotificationImpl(this, Notification.SET,
					KnowledgePackage.MODEL__REPRESENTED_PROBLEM,
					newRepresentedProblem, newRepresentedProblem));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<Model> getRefinements() {
		if (refinements == null) {
			refinements = new EObjectContainmentWithInverseEList.Resolving<Model>(
					Model.class, this, KnowledgePackage.MODEL__REFINEMENTS,
					KnowledgePackage.MODEL__REFINED_MODEL);
		}
		return refinements;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Model getRefinedModel() {
		if (eContainerFeatureID() != KnowledgePackage.MODEL__REFINED_MODEL)
			return null;
		return (Model) eContainer();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Model basicGetRefinedModel() {
		if (eContainerFeatureID() != KnowledgePackage.MODEL__REFINED_MODEL)
			return null;
		return (Model) eInternalContainer();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetRefinedModel(Model newRefinedModel,
			NotificationChain msgs) {
		msgs = eBasicSetContainer((InternalEObject) newRefinedModel,
				KnowledgePackage.MODEL__REFINED_MODEL, msgs);
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setRefinedModel(Model newRefinedModel) {
		if (newRefinedModel != eInternalContainer()
				|| (eContainerFeatureID() != KnowledgePackage.MODEL__REFINED_MODEL && newRefinedModel != null)) {
			if (EcoreUtil.isAncestor(this, newRefinedModel))
				throw new IllegalArgumentException(
						"Recursive containment not allowed for " + toString());
			NotificationChain msgs = null;
			if (eInternalContainer() != null)
				msgs = eBasicRemoveFromContainer(msgs);
			if (newRefinedModel != null)
				msgs = ((InternalEObject) newRefinedModel).eInverseAdd(this,
						KnowledgePackage.MODEL__REFINEMENTS, Model.class, msgs);
			msgs = basicSetRefinedModel(newRefinedModel, msgs);
			if (msgs != null)
				msgs.dispatch();
		} else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET,
					KnowledgePackage.MODEL__REFINED_MODEL, newRefinedModel,
					newRefinedModel));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<Method> getUsedInMethods() {
		if (usedInMethods == null) {
			usedInMethods = new EObjectWithInverseResolvingEList<Method>(
					Method.class, this,
					KnowledgePackage.MODEL__USED_IN_METHODS,
					KnowledgePackage.METHOD__USING_MODEL);
		}
		return usedInMethods;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<Assumption> getDependencies() {
		if (dependencies == null) {
			dependencies = new EObjectWithInverseResolvingEList<Assumption>(
					Assumption.class, this,
					KnowledgePackage.MODEL__DEPENDENCIES,
					KnowledgePackage.ASSUMPTION__DEPENDING_MODEL);
		}
		return dependencies;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<Data> getInvolvedData() {
		if (involvedData == null) {
			involvedData = new EObjectWithInverseResolvingEList.ManyInverse<Data>(
					Data.class, this, KnowledgePackage.MODEL__INVOLVED_DATA,
					DataObjectPackage.DATA__DESCRIBED_MODEL);
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
		case KnowledgePackage.MODEL__REPRESENTED_PROBLEM:
			if (representedProblem != null)
				msgs = ((InternalEObject) representedProblem)
						.eInverseRemove(
								this,
								KnowledgePackage.SCIENTIFIC_PROBLEM__REPRESENTING_MODEL,
								ScientificProblem.class, msgs);
			return basicSetRepresentedProblem((ScientificProblem) otherEnd,
					msgs);
		case KnowledgePackage.MODEL__REFINEMENTS:
			return ((InternalEList<InternalEObject>) (InternalEList<?>) getRefinements())
					.basicAdd(otherEnd, msgs);
		case KnowledgePackage.MODEL__REFINED_MODEL:
			if (eInternalContainer() != null)
				msgs = eBasicRemoveFromContainer(msgs);
			return basicSetRefinedModel((Model) otherEnd, msgs);
		case KnowledgePackage.MODEL__USED_IN_METHODS:
			return ((InternalEList<InternalEObject>) (InternalEList<?>) getUsedInMethods())
					.basicAdd(otherEnd, msgs);
		case KnowledgePackage.MODEL__DEPENDENCIES:
			return ((InternalEList<InternalEObject>) (InternalEList<?>) getDependencies())
					.basicAdd(otherEnd, msgs);
		case KnowledgePackage.MODEL__INVOLVED_DATA:
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
		case KnowledgePackage.MODEL__REPRESENTED_PROBLEM:
			return basicSetRepresentedProblem(null, msgs);
		case KnowledgePackage.MODEL__REFINEMENTS:
			return ((InternalEList<?>) getRefinements()).basicRemove(otherEnd,
					msgs);
		case KnowledgePackage.MODEL__REFINED_MODEL:
			return basicSetRefinedModel(null, msgs);
		case KnowledgePackage.MODEL__USED_IN_METHODS:
			return ((InternalEList<?>) getUsedInMethods()).basicRemove(
					otherEnd, msgs);
		case KnowledgePackage.MODEL__DEPENDENCIES:
			return ((InternalEList<?>) getDependencies()).basicRemove(otherEnd,
					msgs);
		case KnowledgePackage.MODEL__INVOLVED_DATA:
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
		case KnowledgePackage.MODEL__REFINED_MODEL:
			return eInternalContainer().eInverseRemove(this,
					KnowledgePackage.MODEL__REFINEMENTS, Model.class, msgs);
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
		case KnowledgePackage.MODEL__REPRESENTED_PROBLEM:
			if (resolve)
				return getRepresentedProblem();
			return basicGetRepresentedProblem();
		case KnowledgePackage.MODEL__REFINEMENTS:
			return getRefinements();
		case KnowledgePackage.MODEL__REFINED_MODEL:
			if (resolve)
				return getRefinedModel();
			return basicGetRefinedModel();
		case KnowledgePackage.MODEL__USED_IN_METHODS:
			return getUsedInMethods();
		case KnowledgePackage.MODEL__DEPENDENCIES:
			return getDependencies();
		case KnowledgePackage.MODEL__INVOLVED_DATA:
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
		case KnowledgePackage.MODEL__REPRESENTED_PROBLEM:
			setRepresentedProblem((ScientificProblem) newValue);
			return;
		case KnowledgePackage.MODEL__REFINEMENTS:
			getRefinements().clear();
			getRefinements().addAll((Collection<? extends Model>) newValue);
			return;
		case KnowledgePackage.MODEL__REFINED_MODEL:
			setRefinedModel((Model) newValue);
			return;
		case KnowledgePackage.MODEL__USED_IN_METHODS:
			getUsedInMethods().clear();
			getUsedInMethods().addAll((Collection<? extends Method>) newValue);
			return;
		case KnowledgePackage.MODEL__DEPENDENCIES:
			getDependencies().clear();
			getDependencies().addAll(
					(Collection<? extends Assumption>) newValue);
			return;
		case KnowledgePackage.MODEL__INVOLVED_DATA:
			getInvolvedData().clear();
			getInvolvedData().addAll((Collection<? extends Data>) newValue);
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
		case KnowledgePackage.MODEL__REPRESENTED_PROBLEM:
			setRepresentedProblem((ScientificProblem) null);
			return;
		case KnowledgePackage.MODEL__REFINEMENTS:
			getRefinements().clear();
			return;
		case KnowledgePackage.MODEL__REFINED_MODEL:
			setRefinedModel((Model) null);
			return;
		case KnowledgePackage.MODEL__USED_IN_METHODS:
			getUsedInMethods().clear();
			return;
		case KnowledgePackage.MODEL__DEPENDENCIES:
			getDependencies().clear();
			return;
		case KnowledgePackage.MODEL__INVOLVED_DATA:
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
		case KnowledgePackage.MODEL__REPRESENTED_PROBLEM:
			return representedProblem != null;
		case KnowledgePackage.MODEL__REFINEMENTS:
			return refinements != null && !refinements.isEmpty();
		case KnowledgePackage.MODEL__REFINED_MODEL:
			return basicGetRefinedModel() != null;
		case KnowledgePackage.MODEL__USED_IN_METHODS:
			return usedInMethods != null && !usedInMethods.isEmpty();
		case KnowledgePackage.MODEL__DEPENDENCIES:
			return dependencies != null && !dependencies.isEmpty();
		case KnowledgePackage.MODEL__INVOLVED_DATA:
			return involvedData != null && !involvedData.isEmpty();
		}
		return super.eIsSet(featureID);
	}

} //ModelImpl
