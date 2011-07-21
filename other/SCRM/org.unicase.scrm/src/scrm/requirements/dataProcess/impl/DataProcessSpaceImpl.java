/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package scrm.requirements.dataProcess.impl;

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

import scrm.SCRMDiagram;
import scrm.SCRMModelElement;
import scrm.ScrmPackage;
import scrm.impl.SCRMModelElementImpl;
import scrm.knowledge.KnowledgePackage;
import scrm.knowledge.NumericalMethod;
import scrm.lists.SCRMSpaceContainedModelElementsList;
import scrm.requirements.DataDefinition;
import scrm.requirements.DataFlow;
import scrm.requirements.Feature;
import scrm.requirements.IRequirement;
import scrm.requirements.Requirement;
import scrm.requirements.RequirementSpace;
import scrm.requirements.RequirementsPackage;
import scrm.requirements.dataProcess.Process;
import scrm.requirements.dataProcess.DataProcessPackage;
import scrm.requirements.dataProcess.DataProcessSpace;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Space</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link scrm.requirements.dataProcess.impl.DataProcessSpaceImpl#getRepresentingDiagram <em>Representing Diagram</em>}</li>
 *   <li>{@link scrm.requirements.dataProcess.impl.DataProcessSpaceImpl#getContainingRequirementSpace <em>Containing Requirement Space</em>}</li>
 *   <li>{@link scrm.requirements.dataProcess.impl.DataProcessSpaceImpl#getRefinements <em>Refinements</em>}</li>
 *   <li>{@link scrm.requirements.dataProcess.impl.DataProcessSpaceImpl#getRefinedRequirement <em>Refined Requirement</em>}</li>
 *   <li>{@link scrm.requirements.dataProcess.impl.DataProcessSpaceImpl#getSpecifiedFeature <em>Specified Feature</em>}</li>
 *   <li>{@link scrm.requirements.dataProcess.impl.DataProcessSpaceImpl#getDefiningData <em>Defining Data</em>}</li>
 *   <li>{@link scrm.requirements.dataProcess.impl.DataProcessSpaceImpl#getRealizedMethod <em>Realized Method</em>}</li>
 *   <li>{@link scrm.requirements.dataProcess.impl.DataProcessSpaceImpl#getDataFlow <em>Data Flow</em>}</li>
 *   <li>{@link scrm.requirements.dataProcess.impl.DataProcessSpaceImpl#getPredecessor <em>Predecessor</em>}</li>
 *   <li>{@link scrm.requirements.dataProcess.impl.DataProcessSpaceImpl#getSuccessor <em>Successor</em>}</li>
 *   <li>{@link scrm.requirements.dataProcess.impl.DataProcessSpaceImpl#getContainingDataProcessSpace <em>Containing Data Process Space</em>}</li>
 *   <li>{@link scrm.requirements.dataProcess.impl.DataProcessSpaceImpl#getContainedDataProcessSteps <em>Contained Data Process Steps</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class DataProcessSpaceImpl extends SCRMModelElementImpl implements
		DataProcessSpace {
	/**
	 * The cached value of the '{@link #getRepresentingDiagram() <em>Representing Diagram</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getRepresentingDiagram()
	 * @generated
	 * @ordered
	 */
	protected SCRMDiagram representingDiagram;

	/**
	 * The cached value of the '{@link #getRefinements() <em>Refinements</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getRefinements()
	 * @generated
	 * @ordered
	 */
	protected EList<Requirement> refinements;

	/**
	 * The cached value of the '{@link #getDefiningData() <em>Defining Data</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getDefiningData()
	 * @generated
	 * @ordered
	 */
	protected EList<DataDefinition> definingData;

	/**
	 * The cached value of the '{@link #getRealizedMethod() <em>Realized Method</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getRealizedMethod()
	 * @generated
	 * @ordered
	 */
	protected NumericalMethod realizedMethod;

	/**
	 * The cached value of the '{@link #getDataFlow() <em>Data Flow</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getDataFlow()
	 * @generated
	 * @ordered
	 */
	protected DataFlow dataFlow;

	/**
	 * The cached value of the '{@link #getPredecessor() <em>Predecessor</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getPredecessor()
	 * @generated
	 * @ordered
	 */
	protected scrm.requirements.dataProcess.Process predecessor;

	/**
	 * The cached value of the '{@link #getSuccessor() <em>Successor</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSuccessor()
	 * @generated
	 * @ordered
	 */
	protected scrm.requirements.dataProcess.Process successor;

	/**
	 * The cached value of the '{@link #getContainedDataProcessSteps() <em>Contained Data Process Steps</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getContainedDataProcessSteps()
	 * @generated NOT
	 * @ordered
	 */
	protected SCRMSpaceContainedModelElementsList<SCRMModelElement> containedDataProcessSteps;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected DataProcessSpaceImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return DataProcessPackage.Literals.DATA_PROCESS_SPACE;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public SCRMSpaceContainedModelElementsList<SCRMModelElement> getContainedDataProcessSteps() {
		if (containedDataProcessSteps == null) {
			containedDataProcessSteps = new SCRMSpaceContainedModelElementsList<SCRMModelElement>(
					Process.class,
					this,
					DataProcessPackage.DATA_PROCESS_SPACE__CONTAINED_DATA_PROCESS_STEPS,
					DataProcessPackage.PROCESS__CONTAINING_DATA_PROCESS_SPACE);
			containedDataProcessSteps.setDiagram(getRepresentingDiagram());
		}
		return containedDataProcessSteps;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public SCRMDiagram getRepresentingDiagram() {
		if (representingDiagram != null && representingDiagram.eIsProxy()) {
			InternalEObject oldRepresentingDiagram = (InternalEObject) representingDiagram;
			representingDiagram = (SCRMDiagram) eResolveProxy(oldRepresentingDiagram);
			if (representingDiagram != oldRepresentingDiagram) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(
							this,
							Notification.RESOLVE,
							DataProcessPackage.DATA_PROCESS_SPACE__REPRESENTING_DIAGRAM,
							oldRepresentingDiagram, representingDiagram));
			}
		}
		return representingDiagram;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public SCRMDiagram basicGetRepresentingDiagram() {
		return representingDiagram;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetRepresentingDiagram(
			SCRMDiagram newRepresentingDiagram, NotificationChain msgs) {
		SCRMDiagram oldRepresentingDiagram = representingDiagram;
		representingDiagram = newRepresentingDiagram;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(
					this,
					Notification.SET,
					DataProcessPackage.DATA_PROCESS_SPACE__REPRESENTING_DIAGRAM,
					oldRepresentingDiagram, newRepresentingDiagram);
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
	 * @generated NOT
	 */
	public void setRepresentingDiagram(SCRMDiagram newRepresentingDiagram) {
		if (newRepresentingDiagram != representingDiagram) {
			getContainedDataProcessSteps().setDiagram(newRepresentingDiagram);
			NotificationChain msgs = null;
			if (representingDiagram != null)
				msgs = ((InternalEObject) representingDiagram).eInverseRemove(
						this, ScrmPackage.SCRM_DIAGRAM__REPRESENTED_SPACE,
						SCRMDiagram.class, msgs);
			if (newRepresentingDiagram != null)
				msgs = ((InternalEObject) newRepresentingDiagram).eInverseAdd(
						this, ScrmPackage.SCRM_DIAGRAM__REPRESENTED_SPACE,
						SCRMDiagram.class, msgs);
			msgs = basicSetRepresentingDiagram(newRepresentingDiagram, msgs);
			if (msgs != null)
				msgs.dispatch();
		} else if (eNotificationRequired())
			eNotify(new ENotificationImpl(
					this,
					Notification.SET,
					DataProcessPackage.DATA_PROCESS_SPACE__REPRESENTING_DIAGRAM,
					newRepresentingDiagram, newRepresentingDiagram));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public EList<SCRMModelElement> getContainedModelElements() {
		return getContainedDataProcessSteps();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public RequirementSpace getContainingRequirementSpace() {
		if (eContainerFeatureID() != DataProcessPackage.DATA_PROCESS_SPACE__CONTAINING_REQUIREMENT_SPACE)
			return null;
		return (RequirementSpace) eContainer();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public RequirementSpace basicGetContainingRequirementSpace() {
		if (eContainerFeatureID() != DataProcessPackage.DATA_PROCESS_SPACE__CONTAINING_REQUIREMENT_SPACE)
			return null;
		return (RequirementSpace) eInternalContainer();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetContainingRequirementSpace(
			RequirementSpace newContainingRequirementSpace,
			NotificationChain msgs) {
		msgs = eBasicSetContainer(
				(InternalEObject) newContainingRequirementSpace,
				DataProcessPackage.DATA_PROCESS_SPACE__CONTAINING_REQUIREMENT_SPACE,
				msgs);
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setContainingRequirementSpace(
			RequirementSpace newContainingRequirementSpace) {
		if (newContainingRequirementSpace != eInternalContainer()
				|| (eContainerFeatureID() != DataProcessPackage.DATA_PROCESS_SPACE__CONTAINING_REQUIREMENT_SPACE && newContainingRequirementSpace != null)) {
			if (EcoreUtil.isAncestor(this, newContainingRequirementSpace))
				throw new IllegalArgumentException(
						"Recursive containment not allowed for " + toString());
			NotificationChain msgs = null;
			if (eInternalContainer() != null)
				msgs = eBasicRemoveFromContainer(msgs);
			if (newContainingRequirementSpace != null)
				msgs = ((InternalEObject) newContainingRequirementSpace)
						.eInverseAdd(
								this,
								RequirementsPackage.REQUIREMENT_SPACE__CONTAINED_INFORMATIONOF_REQUIREMENTS,
								RequirementSpace.class, msgs);
			msgs = basicSetContainingRequirementSpace(
					newContainingRequirementSpace, msgs);
			if (msgs != null)
				msgs.dispatch();
		} else if (eNotificationRequired())
			eNotify(new ENotificationImpl(
					this,
					Notification.SET,
					DataProcessPackage.DATA_PROCESS_SPACE__CONTAINING_REQUIREMENT_SPACE,
					newContainingRequirementSpace,
					newContainingRequirementSpace));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<Requirement> getRefinements() {
		if (refinements == null) {
			refinements = new EObjectContainmentWithInverseEList.Resolving<Requirement>(
					Requirement.class, this,
					DataProcessPackage.DATA_PROCESS_SPACE__REFINEMENTS,
					RequirementsPackage.REQUIREMENT__REFINED_REQUIREMENT);
		}
		return refinements;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Requirement getRefinedRequirement() {
		if (eContainerFeatureID() != DataProcessPackage.DATA_PROCESS_SPACE__REFINED_REQUIREMENT)
			return null;
		return (Requirement) eContainer();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Requirement basicGetRefinedRequirement() {
		if (eContainerFeatureID() != DataProcessPackage.DATA_PROCESS_SPACE__REFINED_REQUIREMENT)
			return null;
		return (Requirement) eInternalContainer();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetRefinedRequirement(
			Requirement newRefinedRequirement, NotificationChain msgs) {
		msgs = eBasicSetContainer((InternalEObject) newRefinedRequirement,
				DataProcessPackage.DATA_PROCESS_SPACE__REFINED_REQUIREMENT,
				msgs);
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setRefinedRequirement(Requirement newRefinedRequirement) {
		if (newRefinedRequirement != eInternalContainer()
				|| (eContainerFeatureID() != DataProcessPackage.DATA_PROCESS_SPACE__REFINED_REQUIREMENT && newRefinedRequirement != null)) {
			if (EcoreUtil.isAncestor(this, newRefinedRequirement))
				throw new IllegalArgumentException(
						"Recursive containment not allowed for " + toString());
			NotificationChain msgs = null;
			if (eInternalContainer() != null)
				msgs = eBasicRemoveFromContainer(msgs);
			if (newRefinedRequirement != null)
				msgs = ((InternalEObject) newRefinedRequirement).eInverseAdd(
						this, RequirementsPackage.REQUIREMENT__REFINEMENTS,
						Requirement.class, msgs);
			msgs = basicSetRefinedRequirement(newRefinedRequirement, msgs);
			if (msgs != null)
				msgs.dispatch();
		} else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET,
					DataProcessPackage.DATA_PROCESS_SPACE__REFINED_REQUIREMENT,
					newRefinedRequirement, newRefinedRequirement));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Feature getSpecifiedFeature() {
		if (eContainerFeatureID() != DataProcessPackage.DATA_PROCESS_SPACE__SPECIFIED_FEATURE)
			return null;
		return (Feature) eContainer();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Feature basicGetSpecifiedFeature() {
		if (eContainerFeatureID() != DataProcessPackage.DATA_PROCESS_SPACE__SPECIFIED_FEATURE)
			return null;
		return (Feature) eInternalContainer();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetSpecifiedFeature(
			Feature newSpecifiedFeature, NotificationChain msgs) {
		msgs = eBasicSetContainer((InternalEObject) newSpecifiedFeature,
				DataProcessPackage.DATA_PROCESS_SPACE__SPECIFIED_FEATURE, msgs);
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setSpecifiedFeature(Feature newSpecifiedFeature) {
		if (newSpecifiedFeature != eInternalContainer()
				|| (eContainerFeatureID() != DataProcessPackage.DATA_PROCESS_SPACE__SPECIFIED_FEATURE && newSpecifiedFeature != null)) {
			if (EcoreUtil.isAncestor(this, newSpecifiedFeature))
				throw new IllegalArgumentException(
						"Recursive containment not allowed for " + toString());
			NotificationChain msgs = null;
			if (eInternalContainer() != null)
				msgs = eBasicRemoveFromContainer(msgs);
			if (newSpecifiedFeature != null)
				msgs = ((InternalEObject) newSpecifiedFeature).eInverseAdd(
						this,
						RequirementsPackage.FEATURE__DETAILED_REQUIREMENTS,
						Feature.class, msgs);
			msgs = basicSetSpecifiedFeature(newSpecifiedFeature, msgs);
			if (msgs != null)
				msgs.dispatch();
		} else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET,
					DataProcessPackage.DATA_PROCESS_SPACE__SPECIFIED_FEATURE,
					newSpecifiedFeature, newSpecifiedFeature));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<DataDefinition> getDefiningData() {
		if (definingData == null) {
			definingData = new EObjectWithInverseResolvingEList<DataDefinition>(
					DataDefinition.class, this,
					DataProcessPackage.DATA_PROCESS_SPACE__DEFINING_DATA,
					RequirementsPackage.DATA_DEFINITION__DEFINED_REQUIREMENT);
		}
		return definingData;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NumericalMethod getRealizedMethod() {
		if (realizedMethod != null && realizedMethod.eIsProxy()) {
			InternalEObject oldRealizedMethod = (InternalEObject) realizedMethod;
			realizedMethod = (NumericalMethod) eResolveProxy(oldRealizedMethod);
			if (realizedMethod != oldRealizedMethod) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(
							this,
							Notification.RESOLVE,
							DataProcessPackage.DATA_PROCESS_SPACE__REALIZED_METHOD,
							oldRealizedMethod, realizedMethod));
			}
		}
		return realizedMethod;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NumericalMethod basicGetRealizedMethod() {
		return realizedMethod;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetRealizedMethod(
			NumericalMethod newRealizedMethod, NotificationChain msgs) {
		NumericalMethod oldRealizedMethod = realizedMethod;
		realizedMethod = newRealizedMethod;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this,
					Notification.SET,
					DataProcessPackage.DATA_PROCESS_SPACE__REALIZED_METHOD,
					oldRealizedMethod, newRealizedMethod);
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
	public void setRealizedMethod(NumericalMethod newRealizedMethod) {
		if (newRealizedMethod != realizedMethod) {
			NotificationChain msgs = null;
			if (realizedMethod != null)
				msgs = ((InternalEObject) realizedMethod)
						.eInverseRemove(
								this,
								KnowledgePackage.NUMERICAL_METHOD__REALIZING_REQUIREMENT,
								NumericalMethod.class, msgs);
			if (newRealizedMethod != null)
				msgs = ((InternalEObject) newRealizedMethod)
						.eInverseAdd(
								this,
								KnowledgePackage.NUMERICAL_METHOD__REALIZING_REQUIREMENT,
								NumericalMethod.class, msgs);
			msgs = basicSetRealizedMethod(newRealizedMethod, msgs);
			if (msgs != null)
				msgs.dispatch();
		} else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET,
					DataProcessPackage.DATA_PROCESS_SPACE__REALIZED_METHOD,
					newRealizedMethod, newRealizedMethod));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public DataFlow getDataFlow() {
		if (dataFlow != null && dataFlow.eIsProxy()) {
			InternalEObject oldDataFlow = (InternalEObject) dataFlow;
			dataFlow = (DataFlow) eResolveProxy(oldDataFlow);
			if (dataFlow != oldDataFlow) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE,
							DataProcessPackage.DATA_PROCESS_SPACE__DATA_FLOW,
							oldDataFlow, dataFlow));
			}
		}
		return dataFlow;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public DataFlow basicGetDataFlow() {
		return dataFlow;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetDataFlow(DataFlow newDataFlow,
			NotificationChain msgs) {
		DataFlow oldDataFlow = dataFlow;
		dataFlow = newDataFlow;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this,
					Notification.SET,
					DataProcessPackage.DATA_PROCESS_SPACE__DATA_FLOW,
					oldDataFlow, newDataFlow);
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
	public void setDataFlow(DataFlow newDataFlow) {
		if (newDataFlow != dataFlow) {
			NotificationChain msgs = null;
			if (dataFlow != null)
				msgs = ((InternalEObject) dataFlow).eInverseRemove(this,
						RequirementsPackage.DATA_FLOW__SPECIFIED_PROCESS,
						DataFlow.class, msgs);
			if (newDataFlow != null)
				msgs = ((InternalEObject) newDataFlow).eInverseAdd(this,
						RequirementsPackage.DATA_FLOW__SPECIFIED_PROCESS,
						DataFlow.class, msgs);
			msgs = basicSetDataFlow(newDataFlow, msgs);
			if (msgs != null)
				msgs.dispatch();
		} else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET,
					DataProcessPackage.DATA_PROCESS_SPACE__DATA_FLOW,
					newDataFlow, newDataFlow));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public scrm.requirements.dataProcess.Process getPredecessor() {
		if (predecessor != null && predecessor.eIsProxy()) {
			InternalEObject oldPredecessor = (InternalEObject) predecessor;
			predecessor = (scrm.requirements.dataProcess.Process) eResolveProxy(oldPredecessor);
			if (predecessor != oldPredecessor) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE,
							DataProcessPackage.DATA_PROCESS_SPACE__PREDECESSOR,
							oldPredecessor, predecessor));
			}
		}
		return predecessor;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public scrm.requirements.dataProcess.Process basicGetPredecessor() {
		return predecessor;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetPredecessor(
			scrm.requirements.dataProcess.Process newPredecessor,
			NotificationChain msgs) {
		scrm.requirements.dataProcess.Process oldPredecessor = predecessor;
		predecessor = newPredecessor;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this,
					Notification.SET,
					DataProcessPackage.DATA_PROCESS_SPACE__PREDECESSOR,
					oldPredecessor, newPredecessor);
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
	public void setPredecessor(
			scrm.requirements.dataProcess.Process newPredecessor) {
		if (newPredecessor != predecessor) {
			NotificationChain msgs = null;
			if (predecessor != null)
				msgs = ((InternalEObject) predecessor).eInverseRemove(this,
						DataProcessPackage.PROCESS__SUCCESSOR,
						scrm.requirements.dataProcess.Process.class, msgs);
			if (newPredecessor != null)
				msgs = ((InternalEObject) newPredecessor).eInverseAdd(this,
						DataProcessPackage.PROCESS__SUCCESSOR,
						scrm.requirements.dataProcess.Process.class, msgs);
			msgs = basicSetPredecessor(newPredecessor, msgs);
			if (msgs != null)
				msgs.dispatch();
		} else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET,
					DataProcessPackage.DATA_PROCESS_SPACE__PREDECESSOR,
					newPredecessor, newPredecessor));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public scrm.requirements.dataProcess.Process getSuccessor() {
		if (successor != null && successor.eIsProxy()) {
			InternalEObject oldSuccessor = (InternalEObject) successor;
			successor = (scrm.requirements.dataProcess.Process) eResolveProxy(oldSuccessor);
			if (successor != oldSuccessor) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE,
							DataProcessPackage.DATA_PROCESS_SPACE__SUCCESSOR,
							oldSuccessor, successor));
			}
		}
		return successor;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public scrm.requirements.dataProcess.Process basicGetSuccessor() {
		return successor;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetSuccessor(
			scrm.requirements.dataProcess.Process newSuccessor,
			NotificationChain msgs) {
		scrm.requirements.dataProcess.Process oldSuccessor = successor;
		successor = newSuccessor;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this,
					Notification.SET,
					DataProcessPackage.DATA_PROCESS_SPACE__SUCCESSOR,
					oldSuccessor, newSuccessor);
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
	public void setSuccessor(scrm.requirements.dataProcess.Process newSuccessor) {
		if (newSuccessor != successor) {
			NotificationChain msgs = null;
			if (successor != null)
				msgs = ((InternalEObject) successor).eInverseRemove(this,
						DataProcessPackage.PROCESS__PREDECESSOR,
						scrm.requirements.dataProcess.Process.class, msgs);
			if (newSuccessor != null)
				msgs = ((InternalEObject) newSuccessor).eInverseAdd(this,
						DataProcessPackage.PROCESS__PREDECESSOR,
						scrm.requirements.dataProcess.Process.class, msgs);
			msgs = basicSetSuccessor(newSuccessor, msgs);
			if (msgs != null)
				msgs.dispatch();
		} else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET,
					DataProcessPackage.DATA_PROCESS_SPACE__SUCCESSOR,
					newSuccessor, newSuccessor));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public DataProcessSpace getContainingDataProcessSpace() {
		if (eContainerFeatureID() != DataProcessPackage.DATA_PROCESS_SPACE__CONTAINING_DATA_PROCESS_SPACE)
			return null;
		return (DataProcessSpace) eContainer();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public DataProcessSpace basicGetContainingDataProcessSpace() {
		if (eContainerFeatureID() != DataProcessPackage.DATA_PROCESS_SPACE__CONTAINING_DATA_PROCESS_SPACE)
			return null;
		return (DataProcessSpace) eInternalContainer();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetContainingDataProcessSpace(
			DataProcessSpace newContainingDataProcessSpace,
			NotificationChain msgs) {
		msgs = eBasicSetContainer(
				(InternalEObject) newContainingDataProcessSpace,
				DataProcessPackage.DATA_PROCESS_SPACE__CONTAINING_DATA_PROCESS_SPACE,
				msgs);
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setContainingDataProcessSpace(
			DataProcessSpace newContainingDataProcessSpace) {
		if (newContainingDataProcessSpace != eInternalContainer()
				|| (eContainerFeatureID() != DataProcessPackage.DATA_PROCESS_SPACE__CONTAINING_DATA_PROCESS_SPACE && newContainingDataProcessSpace != null)) {
			if (EcoreUtil.isAncestor(this, newContainingDataProcessSpace))
				throw new IllegalArgumentException(
						"Recursive containment not allowed for " + toString());
			NotificationChain msgs = null;
			if (eInternalContainer() != null)
				msgs = eBasicRemoveFromContainer(msgs);
			if (newContainingDataProcessSpace != null)
				msgs = ((InternalEObject) newContainingDataProcessSpace)
						.eInverseAdd(
								this,
								DataProcessPackage.DATA_PROCESS_SPACE__CONTAINED_DATA_PROCESS_STEPS,
								DataProcessSpace.class, msgs);
			msgs = basicSetContainingDataProcessSpace(
					newContainingDataProcessSpace, msgs);
			if (msgs != null)
				msgs.dispatch();
		} else if (eNotificationRequired())
			eNotify(new ENotificationImpl(
					this,
					Notification.SET,
					DataProcessPackage.DATA_PROCESS_SPACE__CONTAINING_DATA_PROCESS_SPACE,
					newContainingDataProcessSpace,
					newContainingDataProcessSpace));
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
		case DataProcessPackage.DATA_PROCESS_SPACE__REPRESENTING_DIAGRAM:
			if (representingDiagram != null)
				msgs = ((InternalEObject) representingDiagram).eInverseRemove(
						this, ScrmPackage.SCRM_DIAGRAM__REPRESENTED_SPACE,
						SCRMDiagram.class, msgs);
			return basicSetRepresentingDiagram((SCRMDiagram) otherEnd, msgs);
		case DataProcessPackage.DATA_PROCESS_SPACE__CONTAINING_REQUIREMENT_SPACE:
			if (eInternalContainer() != null)
				msgs = eBasicRemoveFromContainer(msgs);
			return basicSetContainingRequirementSpace(
					(RequirementSpace) otherEnd, msgs);
		case DataProcessPackage.DATA_PROCESS_SPACE__REFINEMENTS:
			return ((InternalEList<InternalEObject>) (InternalEList<?>) getRefinements())
					.basicAdd(otherEnd, msgs);
		case DataProcessPackage.DATA_PROCESS_SPACE__REFINED_REQUIREMENT:
			if (eInternalContainer() != null)
				msgs = eBasicRemoveFromContainer(msgs);
			return basicSetRefinedRequirement((Requirement) otherEnd, msgs);
		case DataProcessPackage.DATA_PROCESS_SPACE__SPECIFIED_FEATURE:
			if (eInternalContainer() != null)
				msgs = eBasicRemoveFromContainer(msgs);
			return basicSetSpecifiedFeature((Feature) otherEnd, msgs);
		case DataProcessPackage.DATA_PROCESS_SPACE__DEFINING_DATA:
			return ((InternalEList<InternalEObject>) (InternalEList<?>) getDefiningData())
					.basicAdd(otherEnd, msgs);
		case DataProcessPackage.DATA_PROCESS_SPACE__REALIZED_METHOD:
			if (realizedMethod != null)
				msgs = ((InternalEObject) realizedMethod)
						.eInverseRemove(
								this,
								KnowledgePackage.NUMERICAL_METHOD__REALIZING_REQUIREMENT,
								NumericalMethod.class, msgs);
			return basicSetRealizedMethod((NumericalMethod) otherEnd, msgs);
		case DataProcessPackage.DATA_PROCESS_SPACE__DATA_FLOW:
			if (dataFlow != null)
				msgs = ((InternalEObject) dataFlow).eInverseRemove(this,
						RequirementsPackage.DATA_FLOW__SPECIFIED_PROCESS,
						DataFlow.class, msgs);
			return basicSetDataFlow((DataFlow) otherEnd, msgs);
		case DataProcessPackage.DATA_PROCESS_SPACE__PREDECESSOR:
			if (predecessor != null)
				msgs = ((InternalEObject) predecessor).eInverseRemove(this,
						DataProcessPackage.PROCESS__SUCCESSOR,
						scrm.requirements.dataProcess.Process.class, msgs);
			return basicSetPredecessor(
					(scrm.requirements.dataProcess.Process) otherEnd, msgs);
		case DataProcessPackage.DATA_PROCESS_SPACE__SUCCESSOR:
			if (successor != null)
				msgs = ((InternalEObject) successor).eInverseRemove(this,
						DataProcessPackage.PROCESS__PREDECESSOR,
						scrm.requirements.dataProcess.Process.class, msgs);
			return basicSetSuccessor(
					(scrm.requirements.dataProcess.Process) otherEnd, msgs);
		case DataProcessPackage.DATA_PROCESS_SPACE__CONTAINING_DATA_PROCESS_SPACE:
			if (eInternalContainer() != null)
				msgs = eBasicRemoveFromContainer(msgs);
			return basicSetContainingDataProcessSpace(
					(DataProcessSpace) otherEnd, msgs);
		case DataProcessPackage.DATA_PROCESS_SPACE__CONTAINED_DATA_PROCESS_STEPS:
			return ((InternalEList<InternalEObject>) (InternalEList<?>) getContainedDataProcessSteps())
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
		case DataProcessPackage.DATA_PROCESS_SPACE__REPRESENTING_DIAGRAM:
			return basicSetRepresentingDiagram(null, msgs);
		case DataProcessPackage.DATA_PROCESS_SPACE__CONTAINING_REQUIREMENT_SPACE:
			return basicSetContainingRequirementSpace(null, msgs);
		case DataProcessPackage.DATA_PROCESS_SPACE__REFINEMENTS:
			return ((InternalEList<?>) getRefinements()).basicRemove(otherEnd,
					msgs);
		case DataProcessPackage.DATA_PROCESS_SPACE__REFINED_REQUIREMENT:
			return basicSetRefinedRequirement(null, msgs);
		case DataProcessPackage.DATA_PROCESS_SPACE__SPECIFIED_FEATURE:
			return basicSetSpecifiedFeature(null, msgs);
		case DataProcessPackage.DATA_PROCESS_SPACE__DEFINING_DATA:
			return ((InternalEList<?>) getDefiningData()).basicRemove(otherEnd,
					msgs);
		case DataProcessPackage.DATA_PROCESS_SPACE__REALIZED_METHOD:
			return basicSetRealizedMethod(null, msgs);
		case DataProcessPackage.DATA_PROCESS_SPACE__DATA_FLOW:
			return basicSetDataFlow(null, msgs);
		case DataProcessPackage.DATA_PROCESS_SPACE__PREDECESSOR:
			return basicSetPredecessor(null, msgs);
		case DataProcessPackage.DATA_PROCESS_SPACE__SUCCESSOR:
			return basicSetSuccessor(null, msgs);
		case DataProcessPackage.DATA_PROCESS_SPACE__CONTAINING_DATA_PROCESS_SPACE:
			return basicSetContainingDataProcessSpace(null, msgs);
		case DataProcessPackage.DATA_PROCESS_SPACE__CONTAINED_DATA_PROCESS_STEPS:
			return ((InternalEList<?>) getContainedDataProcessSteps())
					.basicRemove(otherEnd, msgs);
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
		case DataProcessPackage.DATA_PROCESS_SPACE__CONTAINING_REQUIREMENT_SPACE:
			return eInternalContainer()
					.eInverseRemove(
							this,
							RequirementsPackage.REQUIREMENT_SPACE__CONTAINED_INFORMATIONOF_REQUIREMENTS,
							RequirementSpace.class, msgs);
		case DataProcessPackage.DATA_PROCESS_SPACE__REFINED_REQUIREMENT:
			return eInternalContainer().eInverseRemove(this,
					RequirementsPackage.REQUIREMENT__REFINEMENTS,
					Requirement.class, msgs);
		case DataProcessPackage.DATA_PROCESS_SPACE__SPECIFIED_FEATURE:
			return eInternalContainer().eInverseRemove(this,
					RequirementsPackage.FEATURE__DETAILED_REQUIREMENTS,
					Feature.class, msgs);
		case DataProcessPackage.DATA_PROCESS_SPACE__CONTAINING_DATA_PROCESS_SPACE:
			return eInternalContainer()
					.eInverseRemove(
							this,
							DataProcessPackage.DATA_PROCESS_SPACE__CONTAINED_DATA_PROCESS_STEPS,
							DataProcessSpace.class, msgs);
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
		case DataProcessPackage.DATA_PROCESS_SPACE__REPRESENTING_DIAGRAM:
			if (resolve)
				return getRepresentingDiagram();
			return basicGetRepresentingDiagram();
		case DataProcessPackage.DATA_PROCESS_SPACE__CONTAINING_REQUIREMENT_SPACE:
			if (resolve)
				return getContainingRequirementSpace();
			return basicGetContainingRequirementSpace();
		case DataProcessPackage.DATA_PROCESS_SPACE__REFINEMENTS:
			return getRefinements();
		case DataProcessPackage.DATA_PROCESS_SPACE__REFINED_REQUIREMENT:
			if (resolve)
				return getRefinedRequirement();
			return basicGetRefinedRequirement();
		case DataProcessPackage.DATA_PROCESS_SPACE__SPECIFIED_FEATURE:
			if (resolve)
				return getSpecifiedFeature();
			return basicGetSpecifiedFeature();
		case DataProcessPackage.DATA_PROCESS_SPACE__DEFINING_DATA:
			return getDefiningData();
		case DataProcessPackage.DATA_PROCESS_SPACE__REALIZED_METHOD:
			if (resolve)
				return getRealizedMethod();
			return basicGetRealizedMethod();
		case DataProcessPackage.DATA_PROCESS_SPACE__DATA_FLOW:
			if (resolve)
				return getDataFlow();
			return basicGetDataFlow();
		case DataProcessPackage.DATA_PROCESS_SPACE__PREDECESSOR:
			if (resolve)
				return getPredecessor();
			return basicGetPredecessor();
		case DataProcessPackage.DATA_PROCESS_SPACE__SUCCESSOR:
			if (resolve)
				return getSuccessor();
			return basicGetSuccessor();
		case DataProcessPackage.DATA_PROCESS_SPACE__CONTAINING_DATA_PROCESS_SPACE:
			if (resolve)
				return getContainingDataProcessSpace();
			return basicGetContainingDataProcessSpace();
		case DataProcessPackage.DATA_PROCESS_SPACE__CONTAINED_DATA_PROCESS_STEPS:
			return getContainedDataProcessSteps();
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
		case DataProcessPackage.DATA_PROCESS_SPACE__REPRESENTING_DIAGRAM:
			setRepresentingDiagram((SCRMDiagram) newValue);
			return;
		case DataProcessPackage.DATA_PROCESS_SPACE__CONTAINING_REQUIREMENT_SPACE:
			setContainingRequirementSpace((RequirementSpace) newValue);
			return;
		case DataProcessPackage.DATA_PROCESS_SPACE__REFINEMENTS:
			getRefinements().clear();
			getRefinements().addAll(
					(Collection<? extends Requirement>) newValue);
			return;
		case DataProcessPackage.DATA_PROCESS_SPACE__REFINED_REQUIREMENT:
			setRefinedRequirement((Requirement) newValue);
			return;
		case DataProcessPackage.DATA_PROCESS_SPACE__SPECIFIED_FEATURE:
			setSpecifiedFeature((Feature) newValue);
			return;
		case DataProcessPackage.DATA_PROCESS_SPACE__DEFINING_DATA:
			getDefiningData().clear();
			getDefiningData().addAll(
					(Collection<? extends DataDefinition>) newValue);
			return;
		case DataProcessPackage.DATA_PROCESS_SPACE__REALIZED_METHOD:
			setRealizedMethod((NumericalMethod) newValue);
			return;
		case DataProcessPackage.DATA_PROCESS_SPACE__DATA_FLOW:
			setDataFlow((DataFlow) newValue);
			return;
		case DataProcessPackage.DATA_PROCESS_SPACE__PREDECESSOR:
			setPredecessor((scrm.requirements.dataProcess.Process) newValue);
			return;
		case DataProcessPackage.DATA_PROCESS_SPACE__SUCCESSOR:
			setSuccessor((scrm.requirements.dataProcess.Process) newValue);
			return;
		case DataProcessPackage.DATA_PROCESS_SPACE__CONTAINING_DATA_PROCESS_SPACE:
			setContainingDataProcessSpace((DataProcessSpace) newValue);
			return;
		case DataProcessPackage.DATA_PROCESS_SPACE__CONTAINED_DATA_PROCESS_STEPS:
			getContainedDataProcessSteps().clear();
			getContainedDataProcessSteps()
					.addAll((Collection<? extends scrm.requirements.dataProcess.Process>) newValue);
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
		case DataProcessPackage.DATA_PROCESS_SPACE__REPRESENTING_DIAGRAM:
			setRepresentingDiagram((SCRMDiagram) null);
			return;
		case DataProcessPackage.DATA_PROCESS_SPACE__CONTAINING_REQUIREMENT_SPACE:
			setContainingRequirementSpace((RequirementSpace) null);
			return;
		case DataProcessPackage.DATA_PROCESS_SPACE__REFINEMENTS:
			getRefinements().clear();
			return;
		case DataProcessPackage.DATA_PROCESS_SPACE__REFINED_REQUIREMENT:
			setRefinedRequirement((Requirement) null);
			return;
		case DataProcessPackage.DATA_PROCESS_SPACE__SPECIFIED_FEATURE:
			setSpecifiedFeature((Feature) null);
			return;
		case DataProcessPackage.DATA_PROCESS_SPACE__DEFINING_DATA:
			getDefiningData().clear();
			return;
		case DataProcessPackage.DATA_PROCESS_SPACE__REALIZED_METHOD:
			setRealizedMethod((NumericalMethod) null);
			return;
		case DataProcessPackage.DATA_PROCESS_SPACE__DATA_FLOW:
			setDataFlow((DataFlow) null);
			return;
		case DataProcessPackage.DATA_PROCESS_SPACE__PREDECESSOR:
			setPredecessor((scrm.requirements.dataProcess.Process) null);
			return;
		case DataProcessPackage.DATA_PROCESS_SPACE__SUCCESSOR:
			setSuccessor((scrm.requirements.dataProcess.Process) null);
			return;
		case DataProcessPackage.DATA_PROCESS_SPACE__CONTAINING_DATA_PROCESS_SPACE:
			setContainingDataProcessSpace((DataProcessSpace) null);
			return;
		case DataProcessPackage.DATA_PROCESS_SPACE__CONTAINED_DATA_PROCESS_STEPS:
			getContainedDataProcessSteps().clear();
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
		case DataProcessPackage.DATA_PROCESS_SPACE__REPRESENTING_DIAGRAM:
			return representingDiagram != null;
		case DataProcessPackage.DATA_PROCESS_SPACE__CONTAINING_REQUIREMENT_SPACE:
			return basicGetContainingRequirementSpace() != null;
		case DataProcessPackage.DATA_PROCESS_SPACE__REFINEMENTS:
			return refinements != null && !refinements.isEmpty();
		case DataProcessPackage.DATA_PROCESS_SPACE__REFINED_REQUIREMENT:
			return basicGetRefinedRequirement() != null;
		case DataProcessPackage.DATA_PROCESS_SPACE__SPECIFIED_FEATURE:
			return basicGetSpecifiedFeature() != null;
		case DataProcessPackage.DATA_PROCESS_SPACE__DEFINING_DATA:
			return definingData != null && !definingData.isEmpty();
		case DataProcessPackage.DATA_PROCESS_SPACE__REALIZED_METHOD:
			return realizedMethod != null;
		case DataProcessPackage.DATA_PROCESS_SPACE__DATA_FLOW:
			return dataFlow != null;
		case DataProcessPackage.DATA_PROCESS_SPACE__PREDECESSOR:
			return predecessor != null;
		case DataProcessPackage.DATA_PROCESS_SPACE__SUCCESSOR:
			return successor != null;
		case DataProcessPackage.DATA_PROCESS_SPACE__CONTAINING_DATA_PROCESS_SPACE:
			return basicGetContainingDataProcessSpace() != null;
		case DataProcessPackage.DATA_PROCESS_SPACE__CONTAINED_DATA_PROCESS_STEPS:
			return containedDataProcessSteps != null
					&& !containedDataProcessSteps.isEmpty();
		}
		return super.eIsSet(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public int eBaseStructuralFeatureID(int derivedFeatureID, Class<?> baseClass) {
		if (baseClass == IRequirement.class) {
			switch (derivedFeatureID) {
			case DataProcessPackage.DATA_PROCESS_SPACE__CONTAINING_REQUIREMENT_SPACE:
				return RequirementsPackage.IREQUIREMENT__CONTAINING_REQUIREMENT_SPACE;
			default:
				return -1;
			}
		}
		if (baseClass == Requirement.class) {
			switch (derivedFeatureID) {
			case DataProcessPackage.DATA_PROCESS_SPACE__REFINEMENTS:
				return RequirementsPackage.REQUIREMENT__REFINEMENTS;
			case DataProcessPackage.DATA_PROCESS_SPACE__REFINED_REQUIREMENT:
				return RequirementsPackage.REQUIREMENT__REFINED_REQUIREMENT;
			case DataProcessPackage.DATA_PROCESS_SPACE__SPECIFIED_FEATURE:
				return RequirementsPackage.REQUIREMENT__SPECIFIED_FEATURE;
			case DataProcessPackage.DATA_PROCESS_SPACE__DEFINING_DATA:
				return RequirementsPackage.REQUIREMENT__DEFINING_DATA;
			case DataProcessPackage.DATA_PROCESS_SPACE__REALIZED_METHOD:
				return RequirementsPackage.REQUIREMENT__REALIZED_METHOD;
			default:
				return -1;
			}
		}
		if (baseClass == scrm.requirements.dataProcess.Process.class) {
			switch (derivedFeatureID) {
			case DataProcessPackage.DATA_PROCESS_SPACE__DATA_FLOW:
				return DataProcessPackage.PROCESS__DATA_FLOW;
			case DataProcessPackage.DATA_PROCESS_SPACE__PREDECESSOR:
				return DataProcessPackage.PROCESS__PREDECESSOR;
			case DataProcessPackage.DATA_PROCESS_SPACE__SUCCESSOR:
				return DataProcessPackage.PROCESS__SUCCESSOR;
			case DataProcessPackage.DATA_PROCESS_SPACE__CONTAINING_DATA_PROCESS_SPACE:
				return DataProcessPackage.PROCESS__CONTAINING_DATA_PROCESS_SPACE;
			default:
				return -1;
			}
		}
		return super.eBaseStructuralFeatureID(derivedFeatureID, baseClass);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public int eDerivedStructuralFeatureID(int baseFeatureID, Class<?> baseClass) {
		if (baseClass == IRequirement.class) {
			switch (baseFeatureID) {
			case RequirementsPackage.IREQUIREMENT__CONTAINING_REQUIREMENT_SPACE:
				return DataProcessPackage.DATA_PROCESS_SPACE__CONTAINING_REQUIREMENT_SPACE;
			default:
				return -1;
			}
		}
		if (baseClass == Requirement.class) {
			switch (baseFeatureID) {
			case RequirementsPackage.REQUIREMENT__REFINEMENTS:
				return DataProcessPackage.DATA_PROCESS_SPACE__REFINEMENTS;
			case RequirementsPackage.REQUIREMENT__REFINED_REQUIREMENT:
				return DataProcessPackage.DATA_PROCESS_SPACE__REFINED_REQUIREMENT;
			case RequirementsPackage.REQUIREMENT__SPECIFIED_FEATURE:
				return DataProcessPackage.DATA_PROCESS_SPACE__SPECIFIED_FEATURE;
			case RequirementsPackage.REQUIREMENT__DEFINING_DATA:
				return DataProcessPackage.DATA_PROCESS_SPACE__DEFINING_DATA;
			case RequirementsPackage.REQUIREMENT__REALIZED_METHOD:
				return DataProcessPackage.DATA_PROCESS_SPACE__REALIZED_METHOD;
			default:
				return -1;
			}
		}
		if (baseClass == scrm.requirements.dataProcess.Process.class) {
			switch (baseFeatureID) {
			case DataProcessPackage.PROCESS__DATA_FLOW:
				return DataProcessPackage.DATA_PROCESS_SPACE__DATA_FLOW;
			case DataProcessPackage.PROCESS__PREDECESSOR:
				return DataProcessPackage.DATA_PROCESS_SPACE__PREDECESSOR;
			case DataProcessPackage.PROCESS__SUCCESSOR:
				return DataProcessPackage.DATA_PROCESS_SPACE__SUCCESSOR;
			case DataProcessPackage.PROCESS__CONTAINING_DATA_PROCESS_SPACE:
				return DataProcessPackage.DATA_PROCESS_SPACE__CONTAINING_DATA_PROCESS_SPACE;
			default:
				return -1;
			}
		}
		return super.eDerivedStructuralFeatureID(baseFeatureID, baseClass);
	}

} //DataProcessSpaceImpl
