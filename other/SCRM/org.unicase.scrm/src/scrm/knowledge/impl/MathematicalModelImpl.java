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
import scrm.knowledge.MathematicalModel;
import scrm.knowledge.NumericalMethod;
import scrm.knowledge.ScientificProblem;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Mathematical Model</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link scrm.knowledge.impl.MathematicalModelImpl#getContainingKnowledgeSpace <em>Containing Knowledge Space</em>}</li>
 *   <li>{@link scrm.knowledge.impl.MathematicalModelImpl#getRepresentedProblem <em>Represented Problem</em>}</li>
 *   <li>{@link scrm.knowledge.impl.MathematicalModelImpl#getRefinements <em>Refinements</em>}</li>
 *   <li>{@link scrm.knowledge.impl.MathematicalModelImpl#getRefinedModel <em>Refined Model</em>}</li>
 *   <li>{@link scrm.knowledge.impl.MathematicalModelImpl#getNumericalMethods <em>Numerical Methods</em>}</li>
 *   <li>{@link scrm.knowledge.impl.MathematicalModelImpl#getDependencies <em>Dependencies</em>}</li>
 *   <li>{@link scrm.knowledge.impl.MathematicalModelImpl#getTheory <em>Theory</em>}</li>
 *   <li>{@link scrm.knowledge.impl.MathematicalModelImpl#getMathematicalExpression <em>Mathematical Expression</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class MathematicalModelImpl extends SCRMModelElementImpl implements
		MathematicalModel {
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
	protected EList<MathematicalModel> refinements;

	/**
	 * The cached value of the '{@link #getNumericalMethods() <em>Numerical Methods</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getNumericalMethods()
	 * @generated
	 * @ordered
	 */
	protected EList<NumericalMethod> numericalMethods;

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
	 * The default value of the '{@link #getTheory() <em>Theory</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getTheory()
	 * @generated
	 * @ordered
	 */
	protected static final String THEORY_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getTheory() <em>Theory</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getTheory()
	 * @generated
	 * @ordered
	 */
	protected String theory = THEORY_EDEFAULT;

	/**
	 * The default value of the '{@link #getMathematicalExpression() <em>Mathematical Expression</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getMathematicalExpression()
	 * @generated
	 * @ordered
	 */
	protected static final String MATHEMATICAL_EXPRESSION_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getMathematicalExpression() <em>Mathematical Expression</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getMathematicalExpression()
	 * @generated
	 * @ordered
	 */
	protected String mathematicalExpression = MATHEMATICAL_EXPRESSION_EDEFAULT;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected MathematicalModelImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return KnowledgePackage.Literals.MATHEMATICAL_MODEL;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public KnowledgeSpace getContainingKnowledgeSpace() {
		if (eContainerFeatureID() != KnowledgePackage.MATHEMATICAL_MODEL__CONTAINING_KNOWLEDGE_SPACE)
			return null;
		return (KnowledgeSpace) eContainer();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public KnowledgeSpace basicGetContainingKnowledgeSpace() {
		if (eContainerFeatureID() != KnowledgePackage.MATHEMATICAL_MODEL__CONTAINING_KNOWLEDGE_SPACE)
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
				KnowledgePackage.MATHEMATICAL_MODEL__CONTAINING_KNOWLEDGE_SPACE,
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
				|| (eContainerFeatureID() != KnowledgePackage.MATHEMATICAL_MODEL__CONTAINING_KNOWLEDGE_SPACE && newContainingKnowledgeSpace != null)) {
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
								KnowledgePackage.KNOWLEDGE_SPACE__CONTAINED_SCIENTIFIC_PROBLEM,
								KnowledgeSpace.class, msgs);
			msgs = basicSetContainingKnowledgeSpace(
					newContainingKnowledgeSpace, msgs);
			if (msgs != null)
				msgs.dispatch();
		} else if (eNotificationRequired())
			eNotify(new ENotificationImpl(
					this,
					Notification.SET,
					KnowledgePackage.MATHEMATICAL_MODEL__CONTAINING_KNOWLEDGE_SPACE,
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
							KnowledgePackage.MATHEMATICAL_MODEL__REPRESENTED_PROBLEM,
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
					KnowledgePackage.MATHEMATICAL_MODEL__REPRESENTED_PROBLEM,
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
					KnowledgePackage.MATHEMATICAL_MODEL__REPRESENTED_PROBLEM,
					newRepresentedProblem, newRepresentedProblem));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<MathematicalModel> getRefinements() {
		if (refinements == null) {
			refinements = new EObjectContainmentWithInverseEList.Resolving<MathematicalModel>(
					MathematicalModel.class, this,
					KnowledgePackage.MATHEMATICAL_MODEL__REFINEMENTS,
					KnowledgePackage.MATHEMATICAL_MODEL__REFINED_MODEL);
		}
		return refinements;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public MathematicalModel getRefinedModel() {
		if (eContainerFeatureID() != KnowledgePackage.MATHEMATICAL_MODEL__REFINED_MODEL)
			return null;
		return (MathematicalModel) eContainer();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public MathematicalModel basicGetRefinedModel() {
		if (eContainerFeatureID() != KnowledgePackage.MATHEMATICAL_MODEL__REFINED_MODEL)
			return null;
		return (MathematicalModel) eInternalContainer();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetRefinedModel(
			MathematicalModel newRefinedModel, NotificationChain msgs) {
		msgs = eBasicSetContainer((InternalEObject) newRefinedModel,
				KnowledgePackage.MATHEMATICAL_MODEL__REFINED_MODEL, msgs);
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setRefinedModel(MathematicalModel newRefinedModel) {
		if (newRefinedModel != eInternalContainer()
				|| (eContainerFeatureID() != KnowledgePackage.MATHEMATICAL_MODEL__REFINED_MODEL && newRefinedModel != null)) {
			if (EcoreUtil.isAncestor(this, newRefinedModel))
				throw new IllegalArgumentException(
						"Recursive containment not allowed for " + toString());
			NotificationChain msgs = null;
			if (eInternalContainer() != null)
				msgs = eBasicRemoveFromContainer(msgs);
			if (newRefinedModel != null)
				msgs = ((InternalEObject) newRefinedModel).eInverseAdd(this,
						KnowledgePackage.MATHEMATICAL_MODEL__REFINEMENTS,
						MathematicalModel.class, msgs);
			msgs = basicSetRefinedModel(newRefinedModel, msgs);
			if (msgs != null)
				msgs.dispatch();
		} else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET,
					KnowledgePackage.MATHEMATICAL_MODEL__REFINED_MODEL,
					newRefinedModel, newRefinedModel));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<NumericalMethod> getNumericalMethods() {
		if (numericalMethods == null) {
			numericalMethods = new EObjectWithInverseResolvingEList<NumericalMethod>(
					NumericalMethod.class, this,
					KnowledgePackage.MATHEMATICAL_MODEL__NUMERICAL_METHODS,
					KnowledgePackage.NUMERICAL_METHOD__MATHEMATICAL_MODEL);
		}
		return numericalMethods;
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
					KnowledgePackage.MATHEMATICAL_MODEL__DEPENDENCIES,
					KnowledgePackage.ASSUMPTION__DEPENDING_MODEL);
		}
		return dependencies;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getTheory() {
		return theory;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setTheory(String newTheory) {
		String oldTheory = theory;
		theory = newTheory;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET,
					KnowledgePackage.MATHEMATICAL_MODEL__THEORY, oldTheory,
					theory));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getMathematicalExpression() {
		return mathematicalExpression;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setMathematicalExpression(String newMathematicalExpression) {
		String oldMathematicalExpression = mathematicalExpression;
		mathematicalExpression = newMathematicalExpression;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(
					this,
					Notification.SET,
					KnowledgePackage.MATHEMATICAL_MODEL__MATHEMATICAL_EXPRESSION,
					oldMathematicalExpression, mathematicalExpression));
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
		case KnowledgePackage.MATHEMATICAL_MODEL__CONTAINING_KNOWLEDGE_SPACE:
			if (eInternalContainer() != null)
				msgs = eBasicRemoveFromContainer(msgs);
			return basicSetContainingKnowledgeSpace((KnowledgeSpace) otherEnd,
					msgs);
		case KnowledgePackage.MATHEMATICAL_MODEL__REPRESENTED_PROBLEM:
			if (representedProblem != null)
				msgs = ((InternalEObject) representedProblem)
						.eInverseRemove(
								this,
								KnowledgePackage.SCIENTIFIC_PROBLEM__REPRESENTING_MODEL,
								ScientificProblem.class, msgs);
			return basicSetRepresentedProblem((ScientificProblem) otherEnd,
					msgs);
		case KnowledgePackage.MATHEMATICAL_MODEL__REFINEMENTS:
			return ((InternalEList<InternalEObject>) (InternalEList<?>) getRefinements())
					.basicAdd(otherEnd, msgs);
		case KnowledgePackage.MATHEMATICAL_MODEL__REFINED_MODEL:
			if (eInternalContainer() != null)
				msgs = eBasicRemoveFromContainer(msgs);
			return basicSetRefinedModel((MathematicalModel) otherEnd, msgs);
		case KnowledgePackage.MATHEMATICAL_MODEL__NUMERICAL_METHODS:
			return ((InternalEList<InternalEObject>) (InternalEList<?>) getNumericalMethods())
					.basicAdd(otherEnd, msgs);
		case KnowledgePackage.MATHEMATICAL_MODEL__DEPENDENCIES:
			return ((InternalEList<InternalEObject>) (InternalEList<?>) getDependencies())
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
		case KnowledgePackage.MATHEMATICAL_MODEL__CONTAINING_KNOWLEDGE_SPACE:
			return basicSetContainingKnowledgeSpace(null, msgs);
		case KnowledgePackage.MATHEMATICAL_MODEL__REPRESENTED_PROBLEM:
			return basicSetRepresentedProblem(null, msgs);
		case KnowledgePackage.MATHEMATICAL_MODEL__REFINEMENTS:
			return ((InternalEList<?>) getRefinements()).basicRemove(otherEnd,
					msgs);
		case KnowledgePackage.MATHEMATICAL_MODEL__REFINED_MODEL:
			return basicSetRefinedModel(null, msgs);
		case KnowledgePackage.MATHEMATICAL_MODEL__NUMERICAL_METHODS:
			return ((InternalEList<?>) getNumericalMethods()).basicRemove(
					otherEnd, msgs);
		case KnowledgePackage.MATHEMATICAL_MODEL__DEPENDENCIES:
			return ((InternalEList<?>) getDependencies()).basicRemove(otherEnd,
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
		case KnowledgePackage.MATHEMATICAL_MODEL__CONTAINING_KNOWLEDGE_SPACE:
			return eInternalContainer()
					.eInverseRemove(
							this,
							KnowledgePackage.KNOWLEDGE_SPACE__CONTAINED_SCIENTIFIC_PROBLEM,
							KnowledgeSpace.class, msgs);
		case KnowledgePackage.MATHEMATICAL_MODEL__REFINED_MODEL:
			return eInternalContainer().eInverseRemove(this,
					KnowledgePackage.MATHEMATICAL_MODEL__REFINEMENTS,
					MathematicalModel.class, msgs);
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
		case KnowledgePackage.MATHEMATICAL_MODEL__CONTAINING_KNOWLEDGE_SPACE:
			if (resolve)
				return getContainingKnowledgeSpace();
			return basicGetContainingKnowledgeSpace();
		case KnowledgePackage.MATHEMATICAL_MODEL__REPRESENTED_PROBLEM:
			if (resolve)
				return getRepresentedProblem();
			return basicGetRepresentedProblem();
		case KnowledgePackage.MATHEMATICAL_MODEL__REFINEMENTS:
			return getRefinements();
		case KnowledgePackage.MATHEMATICAL_MODEL__REFINED_MODEL:
			if (resolve)
				return getRefinedModel();
			return basicGetRefinedModel();
		case KnowledgePackage.MATHEMATICAL_MODEL__NUMERICAL_METHODS:
			return getNumericalMethods();
		case KnowledgePackage.MATHEMATICAL_MODEL__DEPENDENCIES:
			return getDependencies();
		case KnowledgePackage.MATHEMATICAL_MODEL__THEORY:
			return getTheory();
		case KnowledgePackage.MATHEMATICAL_MODEL__MATHEMATICAL_EXPRESSION:
			return getMathematicalExpression();
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
		case KnowledgePackage.MATHEMATICAL_MODEL__CONTAINING_KNOWLEDGE_SPACE:
			setContainingKnowledgeSpace((KnowledgeSpace) newValue);
			return;
		case KnowledgePackage.MATHEMATICAL_MODEL__REPRESENTED_PROBLEM:
			setRepresentedProblem((ScientificProblem) newValue);
			return;
		case KnowledgePackage.MATHEMATICAL_MODEL__REFINEMENTS:
			getRefinements().clear();
			getRefinements().addAll(
					(Collection<? extends MathematicalModel>) newValue);
			return;
		case KnowledgePackage.MATHEMATICAL_MODEL__REFINED_MODEL:
			setRefinedModel((MathematicalModel) newValue);
			return;
		case KnowledgePackage.MATHEMATICAL_MODEL__NUMERICAL_METHODS:
			getNumericalMethods().clear();
			getNumericalMethods().addAll(
					(Collection<? extends NumericalMethod>) newValue);
			return;
		case KnowledgePackage.MATHEMATICAL_MODEL__DEPENDENCIES:
			getDependencies().clear();
			getDependencies().addAll(
					(Collection<? extends Assumption>) newValue);
			return;
		case KnowledgePackage.MATHEMATICAL_MODEL__THEORY:
			setTheory((String) newValue);
			return;
		case KnowledgePackage.MATHEMATICAL_MODEL__MATHEMATICAL_EXPRESSION:
			setMathematicalExpression((String) newValue);
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
		case KnowledgePackage.MATHEMATICAL_MODEL__CONTAINING_KNOWLEDGE_SPACE:
			setContainingKnowledgeSpace((KnowledgeSpace) null);
			return;
		case KnowledgePackage.MATHEMATICAL_MODEL__REPRESENTED_PROBLEM:
			setRepresentedProblem((ScientificProblem) null);
			return;
		case KnowledgePackage.MATHEMATICAL_MODEL__REFINEMENTS:
			getRefinements().clear();
			return;
		case KnowledgePackage.MATHEMATICAL_MODEL__REFINED_MODEL:
			setRefinedModel((MathematicalModel) null);
			return;
		case KnowledgePackage.MATHEMATICAL_MODEL__NUMERICAL_METHODS:
			getNumericalMethods().clear();
			return;
		case KnowledgePackage.MATHEMATICAL_MODEL__DEPENDENCIES:
			getDependencies().clear();
			return;
		case KnowledgePackage.MATHEMATICAL_MODEL__THEORY:
			setTheory(THEORY_EDEFAULT);
			return;
		case KnowledgePackage.MATHEMATICAL_MODEL__MATHEMATICAL_EXPRESSION:
			setMathematicalExpression(MATHEMATICAL_EXPRESSION_EDEFAULT);
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
		case KnowledgePackage.MATHEMATICAL_MODEL__CONTAINING_KNOWLEDGE_SPACE:
			return basicGetContainingKnowledgeSpace() != null;
		case KnowledgePackage.MATHEMATICAL_MODEL__REPRESENTED_PROBLEM:
			return representedProblem != null;
		case KnowledgePackage.MATHEMATICAL_MODEL__REFINEMENTS:
			return refinements != null && !refinements.isEmpty();
		case KnowledgePackage.MATHEMATICAL_MODEL__REFINED_MODEL:
			return basicGetRefinedModel() != null;
		case KnowledgePackage.MATHEMATICAL_MODEL__NUMERICAL_METHODS:
			return numericalMethods != null && !numericalMethods.isEmpty();
		case KnowledgePackage.MATHEMATICAL_MODEL__DEPENDENCIES:
			return dependencies != null && !dependencies.isEmpty();
		case KnowledgePackage.MATHEMATICAL_MODEL__THEORY:
			return THEORY_EDEFAULT == null ? theory != null : !THEORY_EDEFAULT
					.equals(theory);
		case KnowledgePackage.MATHEMATICAL_MODEL__MATHEMATICAL_EXPRESSION:
			return MATHEMATICAL_EXPRESSION_EDEFAULT == null ? mathematicalExpression != null
					: !MATHEMATICAL_EXPRESSION_EDEFAULT
							.equals(mathematicalExpression);
		}
		return super.eIsSet(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String toString() {
		if (eIsProxy())
			return super.toString();

		StringBuffer result = new StringBuffer(super.toString());
		result.append(" (theory: ");
		result.append(theory);
		result.append(", mathematicalExpression: ");
		result.append(mathematicalExpression);
		result.append(')');
		return result.toString();
	}

} //MathematicalModelImpl
