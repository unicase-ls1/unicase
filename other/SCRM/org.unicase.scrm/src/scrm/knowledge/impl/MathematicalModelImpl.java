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
import scrm.knowledge.MathematicalModel;
import scrm.knowledge.NumericalMethod;
import scrm.knowledge.ScientificProblem;

import scrm.requirements.IRequirement;
import scrm.requirements.RequirementsPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Mathematical Model</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link scrm.knowledge.impl.MathematicalModelImpl#getRequirements <em>Requirements</em>}</li>
 *   <li>{@link scrm.knowledge.impl.MathematicalModelImpl#getRepresentedProblem <em>Represented Problem</em>}</li>
 *   <li>{@link scrm.knowledge.impl.MathematicalModelImpl#getRefinements <em>Refinements</em>}</li>
 *   <li>{@link scrm.knowledge.impl.MathematicalModelImpl#getRefinedModel <em>Refined Model</em>}</li>
 *   <li>{@link scrm.knowledge.impl.MathematicalModelImpl#getSubMathematicalModels <em>Sub Mathematical Models</em>}</li>
 *   <li>{@link scrm.knowledge.impl.MathematicalModelImpl#getSuperMathematicalModel <em>Super Mathematical Model</em>}</li>
 *   <li>{@link scrm.knowledge.impl.MathematicalModelImpl#getNumericalMethods <em>Numerical Methods</em>}</li>
 *   <li>{@link scrm.knowledge.impl.MathematicalModelImpl#getDependencies <em>Dependencies</em>}</li>
 *   <li>{@link scrm.knowledge.impl.MathematicalModelImpl#getTheory <em>Theory</em>}</li>
 *   <li>{@link scrm.knowledge.impl.MathematicalModelImpl#getMathematicalExpression <em>Mathematical Expression</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class MathematicalModelImpl extends SCRMModelElementImpl implements MathematicalModel {
	/**
	 * The cached value of the '{@link #getRequirements() <em>Requirements</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getRequirements()
	 * @generated
	 * @ordered
	 */
	protected EList<IRequirement> requirements;

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
	 * The cached value of the '{@link #getSubMathematicalModels() <em>Sub Mathematical Models</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSubMathematicalModels()
	 * @generated
	 * @ordered
	 */
	protected EList<MathematicalModel> subMathematicalModels;

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
	 * The cached value of the '{@link #getDependencies() <em>Dependencies</em>}' containment reference list.
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
	public EList<IRequirement> getRequirements() {
		if (requirements == null) {
			requirements = new EObjectContainmentWithInverseEList<IRequirement>(IRequirement.class, this, KnowledgePackage.MATHEMATICAL_MODEL__REQUIREMENTS, RequirementsPackage.IREQUIREMENT__USED_KNOWLEDGE);
		}
		return requirements;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ScientificProblem getRepresentedProblem() {
		if (eContainerFeatureID() != KnowledgePackage.MATHEMATICAL_MODEL__REPRESENTED_PROBLEM) return null;
		return (ScientificProblem)eContainer();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetRepresentedProblem(ScientificProblem newRepresentedProblem, NotificationChain msgs) {
		msgs = eBasicSetContainer((InternalEObject)newRepresentedProblem, KnowledgePackage.MATHEMATICAL_MODEL__REPRESENTED_PROBLEM, msgs);
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setRepresentedProblem(ScientificProblem newRepresentedProblem) {
		if (newRepresentedProblem != eInternalContainer() || (eContainerFeatureID() != KnowledgePackage.MATHEMATICAL_MODEL__REPRESENTED_PROBLEM && newRepresentedProblem != null)) {
			if (EcoreUtil.isAncestor(this, newRepresentedProblem))
				throw new IllegalArgumentException("Recursive containment not allowed for " + toString());
			NotificationChain msgs = null;
			if (eInternalContainer() != null)
				msgs = eBasicRemoveFromContainer(msgs);
			if (newRepresentedProblem != null)
				msgs = ((InternalEObject)newRepresentedProblem).eInverseAdd(this, KnowledgePackage.SCIENTIFIC_PROBLEM__REPRESENTING_MODEL, ScientificProblem.class, msgs);
			msgs = basicSetRepresentedProblem(newRepresentedProblem, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, KnowledgePackage.MATHEMATICAL_MODEL__REPRESENTED_PROBLEM, newRepresentedProblem, newRepresentedProblem));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<MathematicalModel> getRefinements() {
		if (refinements == null) {
			refinements = new EObjectContainmentWithInverseEList<MathematicalModel>(MathematicalModel.class, this, KnowledgePackage.MATHEMATICAL_MODEL__REFINEMENTS, KnowledgePackage.MATHEMATICAL_MODEL__REFINED_MODEL);
		}
		return refinements;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public MathematicalModel getRefinedModel() {
		if (eContainerFeatureID() != KnowledgePackage.MATHEMATICAL_MODEL__REFINED_MODEL) return null;
		return (MathematicalModel)eContainer();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetRefinedModel(MathematicalModel newRefinedModel, NotificationChain msgs) {
		msgs = eBasicSetContainer((InternalEObject)newRefinedModel, KnowledgePackage.MATHEMATICAL_MODEL__REFINED_MODEL, msgs);
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setRefinedModel(MathematicalModel newRefinedModel) {
		if (newRefinedModel != eInternalContainer() || (eContainerFeatureID() != KnowledgePackage.MATHEMATICAL_MODEL__REFINED_MODEL && newRefinedModel != null)) {
			if (EcoreUtil.isAncestor(this, newRefinedModel))
				throw new IllegalArgumentException("Recursive containment not allowed for " + toString());
			NotificationChain msgs = null;
			if (eInternalContainer() != null)
				msgs = eBasicRemoveFromContainer(msgs);
			if (newRefinedModel != null)
				msgs = ((InternalEObject)newRefinedModel).eInverseAdd(this, KnowledgePackage.MATHEMATICAL_MODEL__REFINEMENTS, MathematicalModel.class, msgs);
			msgs = basicSetRefinedModel(newRefinedModel, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, KnowledgePackage.MATHEMATICAL_MODEL__REFINED_MODEL, newRefinedModel, newRefinedModel));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<MathematicalModel> getSubMathematicalModels() {
		if (subMathematicalModels == null) {
			subMathematicalModels = new EObjectContainmentWithInverseEList<MathematicalModel>(MathematicalModel.class, this, KnowledgePackage.MATHEMATICAL_MODEL__SUB_MATHEMATICAL_MODELS, KnowledgePackage.MATHEMATICAL_MODEL__SUPER_MATHEMATICAL_MODEL);
		}
		return subMathematicalModels;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public MathematicalModel getSuperMathematicalModel() {
		if (eContainerFeatureID() != KnowledgePackage.MATHEMATICAL_MODEL__SUPER_MATHEMATICAL_MODEL) return null;
		return (MathematicalModel)eContainer();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetSuperMathematicalModel(MathematicalModel newSuperMathematicalModel, NotificationChain msgs) {
		msgs = eBasicSetContainer((InternalEObject)newSuperMathematicalModel, KnowledgePackage.MATHEMATICAL_MODEL__SUPER_MATHEMATICAL_MODEL, msgs);
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setSuperMathematicalModel(MathematicalModel newSuperMathematicalModel) {
		if (newSuperMathematicalModel != eInternalContainer() || (eContainerFeatureID() != KnowledgePackage.MATHEMATICAL_MODEL__SUPER_MATHEMATICAL_MODEL && newSuperMathematicalModel != null)) {
			if (EcoreUtil.isAncestor(this, newSuperMathematicalModel))
				throw new IllegalArgumentException("Recursive containment not allowed for " + toString());
			NotificationChain msgs = null;
			if (eInternalContainer() != null)
				msgs = eBasicRemoveFromContainer(msgs);
			if (newSuperMathematicalModel != null)
				msgs = ((InternalEObject)newSuperMathematicalModel).eInverseAdd(this, KnowledgePackage.MATHEMATICAL_MODEL__SUB_MATHEMATICAL_MODELS, MathematicalModel.class, msgs);
			msgs = basicSetSuperMathematicalModel(newSuperMathematicalModel, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, KnowledgePackage.MATHEMATICAL_MODEL__SUPER_MATHEMATICAL_MODEL, newSuperMathematicalModel, newSuperMathematicalModel));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<NumericalMethod> getNumericalMethods() {
		if (numericalMethods == null) {
			numericalMethods = new EObjectWithInverseResolvingEList<NumericalMethod>(NumericalMethod.class, this, KnowledgePackage.MATHEMATICAL_MODEL__NUMERICAL_METHODS, KnowledgePackage.NUMERICAL_METHOD__MATHEMATICAL_MODEL);
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
			dependencies = new EObjectContainmentWithInverseEList<Assumption>(Assumption.class, this, KnowledgePackage.MATHEMATICAL_MODEL__DEPENDENCIES, KnowledgePackage.ASSUMPTION__DEPENDING_MODEL);
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
			eNotify(new ENotificationImpl(this, Notification.SET, KnowledgePackage.MATHEMATICAL_MODEL__THEORY, oldTheory, theory));
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
			eNotify(new ENotificationImpl(this, Notification.SET, KnowledgePackage.MATHEMATICAL_MODEL__MATHEMATICAL_EXPRESSION, oldMathematicalExpression, mathematicalExpression));
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
			case KnowledgePackage.MATHEMATICAL_MODEL__REQUIREMENTS:
				return ((InternalEList<InternalEObject>)(InternalEList<?>)getRequirements()).basicAdd(otherEnd, msgs);
			case KnowledgePackage.MATHEMATICAL_MODEL__REPRESENTED_PROBLEM:
				if (eInternalContainer() != null)
					msgs = eBasicRemoveFromContainer(msgs);
				return basicSetRepresentedProblem((ScientificProblem)otherEnd, msgs);
			case KnowledgePackage.MATHEMATICAL_MODEL__REFINEMENTS:
				return ((InternalEList<InternalEObject>)(InternalEList<?>)getRefinements()).basicAdd(otherEnd, msgs);
			case KnowledgePackage.MATHEMATICAL_MODEL__REFINED_MODEL:
				if (eInternalContainer() != null)
					msgs = eBasicRemoveFromContainer(msgs);
				return basicSetRefinedModel((MathematicalModel)otherEnd, msgs);
			case KnowledgePackage.MATHEMATICAL_MODEL__SUB_MATHEMATICAL_MODELS:
				return ((InternalEList<InternalEObject>)(InternalEList<?>)getSubMathematicalModels()).basicAdd(otherEnd, msgs);
			case KnowledgePackage.MATHEMATICAL_MODEL__SUPER_MATHEMATICAL_MODEL:
				if (eInternalContainer() != null)
					msgs = eBasicRemoveFromContainer(msgs);
				return basicSetSuperMathematicalModel((MathematicalModel)otherEnd, msgs);
			case KnowledgePackage.MATHEMATICAL_MODEL__NUMERICAL_METHODS:
				return ((InternalEList<InternalEObject>)(InternalEList<?>)getNumericalMethods()).basicAdd(otherEnd, msgs);
			case KnowledgePackage.MATHEMATICAL_MODEL__DEPENDENCIES:
				return ((InternalEList<InternalEObject>)(InternalEList<?>)getDependencies()).basicAdd(otherEnd, msgs);
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
			case KnowledgePackage.MATHEMATICAL_MODEL__REQUIREMENTS:
				return ((InternalEList<?>)getRequirements()).basicRemove(otherEnd, msgs);
			case KnowledgePackage.MATHEMATICAL_MODEL__REPRESENTED_PROBLEM:
				return basicSetRepresentedProblem(null, msgs);
			case KnowledgePackage.MATHEMATICAL_MODEL__REFINEMENTS:
				return ((InternalEList<?>)getRefinements()).basicRemove(otherEnd, msgs);
			case KnowledgePackage.MATHEMATICAL_MODEL__REFINED_MODEL:
				return basicSetRefinedModel(null, msgs);
			case KnowledgePackage.MATHEMATICAL_MODEL__SUB_MATHEMATICAL_MODELS:
				return ((InternalEList<?>)getSubMathematicalModels()).basicRemove(otherEnd, msgs);
			case KnowledgePackage.MATHEMATICAL_MODEL__SUPER_MATHEMATICAL_MODEL:
				return basicSetSuperMathematicalModel(null, msgs);
			case KnowledgePackage.MATHEMATICAL_MODEL__NUMERICAL_METHODS:
				return ((InternalEList<?>)getNumericalMethods()).basicRemove(otherEnd, msgs);
			case KnowledgePackage.MATHEMATICAL_MODEL__DEPENDENCIES:
				return ((InternalEList<?>)getDependencies()).basicRemove(otherEnd, msgs);
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
			case KnowledgePackage.MATHEMATICAL_MODEL__REPRESENTED_PROBLEM:
				return eInternalContainer().eInverseRemove(this, KnowledgePackage.SCIENTIFIC_PROBLEM__REPRESENTING_MODEL, ScientificProblem.class, msgs);
			case KnowledgePackage.MATHEMATICAL_MODEL__REFINED_MODEL:
				return eInternalContainer().eInverseRemove(this, KnowledgePackage.MATHEMATICAL_MODEL__REFINEMENTS, MathematicalModel.class, msgs);
			case KnowledgePackage.MATHEMATICAL_MODEL__SUPER_MATHEMATICAL_MODEL:
				return eInternalContainer().eInverseRemove(this, KnowledgePackage.MATHEMATICAL_MODEL__SUB_MATHEMATICAL_MODELS, MathematicalModel.class, msgs);
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
			case KnowledgePackage.MATHEMATICAL_MODEL__REQUIREMENTS:
				return getRequirements();
			case KnowledgePackage.MATHEMATICAL_MODEL__REPRESENTED_PROBLEM:
				return getRepresentedProblem();
			case KnowledgePackage.MATHEMATICAL_MODEL__REFINEMENTS:
				return getRefinements();
			case KnowledgePackage.MATHEMATICAL_MODEL__REFINED_MODEL:
				return getRefinedModel();
			case KnowledgePackage.MATHEMATICAL_MODEL__SUB_MATHEMATICAL_MODELS:
				return getSubMathematicalModels();
			case KnowledgePackage.MATHEMATICAL_MODEL__SUPER_MATHEMATICAL_MODEL:
				return getSuperMathematicalModel();
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
			case KnowledgePackage.MATHEMATICAL_MODEL__REQUIREMENTS:
				getRequirements().clear();
				getRequirements().addAll((Collection<? extends IRequirement>)newValue);
				return;
			case KnowledgePackage.MATHEMATICAL_MODEL__REPRESENTED_PROBLEM:
				setRepresentedProblem((ScientificProblem)newValue);
				return;
			case KnowledgePackage.MATHEMATICAL_MODEL__REFINEMENTS:
				getRefinements().clear();
				getRefinements().addAll((Collection<? extends MathematicalModel>)newValue);
				return;
			case KnowledgePackage.MATHEMATICAL_MODEL__REFINED_MODEL:
				setRefinedModel((MathematicalModel)newValue);
				return;
			case KnowledgePackage.MATHEMATICAL_MODEL__SUB_MATHEMATICAL_MODELS:
				getSubMathematicalModels().clear();
				getSubMathematicalModels().addAll((Collection<? extends MathematicalModel>)newValue);
				return;
			case KnowledgePackage.MATHEMATICAL_MODEL__SUPER_MATHEMATICAL_MODEL:
				setSuperMathematicalModel((MathematicalModel)newValue);
				return;
			case KnowledgePackage.MATHEMATICAL_MODEL__NUMERICAL_METHODS:
				getNumericalMethods().clear();
				getNumericalMethods().addAll((Collection<? extends NumericalMethod>)newValue);
				return;
			case KnowledgePackage.MATHEMATICAL_MODEL__DEPENDENCIES:
				getDependencies().clear();
				getDependencies().addAll((Collection<? extends Assumption>)newValue);
				return;
			case KnowledgePackage.MATHEMATICAL_MODEL__THEORY:
				setTheory((String)newValue);
				return;
			case KnowledgePackage.MATHEMATICAL_MODEL__MATHEMATICAL_EXPRESSION:
				setMathematicalExpression((String)newValue);
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
			case KnowledgePackage.MATHEMATICAL_MODEL__REQUIREMENTS:
				getRequirements().clear();
				return;
			case KnowledgePackage.MATHEMATICAL_MODEL__REPRESENTED_PROBLEM:
				setRepresentedProblem((ScientificProblem)null);
				return;
			case KnowledgePackage.MATHEMATICAL_MODEL__REFINEMENTS:
				getRefinements().clear();
				return;
			case KnowledgePackage.MATHEMATICAL_MODEL__REFINED_MODEL:
				setRefinedModel((MathematicalModel)null);
				return;
			case KnowledgePackage.MATHEMATICAL_MODEL__SUB_MATHEMATICAL_MODELS:
				getSubMathematicalModels().clear();
				return;
			case KnowledgePackage.MATHEMATICAL_MODEL__SUPER_MATHEMATICAL_MODEL:
				setSuperMathematicalModel((MathematicalModel)null);
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
			case KnowledgePackage.MATHEMATICAL_MODEL__REQUIREMENTS:
				return requirements != null && !requirements.isEmpty();
			case KnowledgePackage.MATHEMATICAL_MODEL__REPRESENTED_PROBLEM:
				return getRepresentedProblem() != null;
			case KnowledgePackage.MATHEMATICAL_MODEL__REFINEMENTS:
				return refinements != null && !refinements.isEmpty();
			case KnowledgePackage.MATHEMATICAL_MODEL__REFINED_MODEL:
				return getRefinedModel() != null;
			case KnowledgePackage.MATHEMATICAL_MODEL__SUB_MATHEMATICAL_MODELS:
				return subMathematicalModels != null && !subMathematicalModels.isEmpty();
			case KnowledgePackage.MATHEMATICAL_MODEL__SUPER_MATHEMATICAL_MODEL:
				return getSuperMathematicalModel() != null;
			case KnowledgePackage.MATHEMATICAL_MODEL__NUMERICAL_METHODS:
				return numericalMethods != null && !numericalMethods.isEmpty();
			case KnowledgePackage.MATHEMATICAL_MODEL__DEPENDENCIES:
				return dependencies != null && !dependencies.isEmpty();
			case KnowledgePackage.MATHEMATICAL_MODEL__THEORY:
				return THEORY_EDEFAULT == null ? theory != null : !THEORY_EDEFAULT.equals(theory);
			case KnowledgePackage.MATHEMATICAL_MODEL__MATHEMATICAL_EXPRESSION:
				return MATHEMATICAL_EXPRESSION_EDEFAULT == null ? mathematicalExpression != null : !MATHEMATICAL_EXPRESSION_EDEFAULT.equals(mathematicalExpression);
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
		if (eIsProxy()) return super.toString();

		StringBuffer result = new StringBuffer(super.toString());
		result.append(" (theory: ");
		result.append(theory);
		result.append(", mathematicalExpression: ");
		result.append(mathematicalExpression);
		result.append(')');
		return result.toString();
	}

} //MathematicalModelImpl