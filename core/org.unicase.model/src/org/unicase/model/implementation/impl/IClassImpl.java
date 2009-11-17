/**
 * <copyright> Copyright (c) 2008-2009 Jonas Helming, Maximilian Koegel. All rights reserved. This program and the
 * accompanying materials are made available under the terms of the Eclipse Public License v1.0 which accompanies this
 * distribution, and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>
 */
package org.unicase.model.implementation.impl;

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
import org.unicase.model.classes.ClassesPackage;
import org.unicase.model.impl.UnicaseModelElementImpl;
import org.unicase.model.implementation.IAttribute;
import org.unicase.model.implementation.IClass;
import org.unicase.model.implementation.IPackage;
import org.unicase.model.implementation.IReference;
import org.unicase.model.implementation.ImplementationPackage;

/**
 * <!-- begin-user-doc --> An implementation of the model object '<em><b>IClass</b></em>'. <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 * <li>{@link org.unicase.model.implementation.impl.IClassImpl#getParentPackage <em>Parent Package</em>}</li>
 * <li>{@link org.unicase.model.implementation.impl.IClassImpl#isAbstract <em>Abstract</em>}</li>
 * <li>{@link org.unicase.model.implementation.impl.IClassImpl#getSuperClasses <em>Super Classes</em>}</li>
 * <li>{@link org.unicase.model.implementation.impl.IClassImpl#getSubClasses <em>Sub Classes</em>}</li>
 * <li>{@link org.unicase.model.implementation.impl.IClassImpl#getAttributes <em>Attributes</em>}</li>
 * <li>{@link org.unicase.model.implementation.impl.IClassImpl#getOutgoingReferences <em>Outgoing References</em>}</li>
 * <li>{@link org.unicase.model.implementation.impl.IClassImpl#getIncomingReferences <em>Incoming References</em>}</li>
 * <li>{@link org.unicase.model.implementation.impl.IClassImpl#getAnalysisClasses <em>Analysis Classes</em>}</li>
 * </ul>
 * </p>
 * 
 * @generated
 */
public class IClassImpl extends UnicaseModelElementImpl implements IClass {
	/**
	 * The default value of the '{@link #isAbstract() <em>Abstract</em>}' attribute. <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * 
	 * @see #isAbstract()
	 * @generated
	 * @ordered
	 */
	protected static final boolean ABSTRACT_EDEFAULT = false;

	/**
	 * The cached value of the '{@link #isAbstract() <em>Abstract</em>}' attribute. <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * 
	 * @see #isAbstract()
	 * @generated
	 * @ordered
	 */
	protected boolean abstract_ = ABSTRACT_EDEFAULT;

	/**
	 * The cached value of the '{@link #getSuperClasses() <em>Super Classes</em>}' reference list. <!-- begin-user-doc
	 * --> <!-- end-user-doc -->
	 * 
	 * @see #getSuperClasses()
	 * @generated
	 * @ordered
	 */
	protected EList<IClass> superClasses;

	/**
	 * The cached value of the '{@link #getSubClasses() <em>Sub Classes</em>}' reference list. <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @see #getSubClasses()
	 * @generated
	 * @ordered
	 */
	protected EList<IClass> subClasses;

	/**
	 * The cached value of the '{@link #getAttributes() <em>Attributes</em>}' containment reference list. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see #getAttributes()
	 * @generated
	 * @ordered
	 */
	protected EList<IAttribute> attributes;

	/**
	 * The cached value of the '{@link #getOutgoingReferences() <em>Outgoing References</em>}' containment reference
	 * list. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see #getOutgoingReferences()
	 * @generated
	 * @ordered
	 */
	protected EList<IReference> outgoingReferences;

	/**
	 * The cached value of the '{@link #getIncomingReferences() <em>Incoming References</em>}' reference list. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see #getIncomingReferences()
	 * @generated
	 * @ordered
	 */
	protected EList<IReference> incomingReferences;

	/**
	 * The cached value of the '{@link #getAnalysisClasses() <em>Analysis Classes</em>}' reference list. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see #getAnalysisClasses()
	 * @generated
	 * @ordered
	 */
	protected EList<org.unicase.model.classes.Class> analysisClasses;

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	protected IClassImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return ImplementationPackage.Literals.ICLASS;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public IPackage getParentPackage() {
		if (eContainerFeatureID() != ImplementationPackage.ICLASS__PARENT_PACKAGE)
			return null;
		return (IPackage) eContainer();
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public IPackage basicGetParentPackage() {
		if (eContainerFeatureID() != ImplementationPackage.ICLASS__PARENT_PACKAGE)
			return null;
		return (IPackage) eInternalContainer();
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public NotificationChain basicSetParentPackage(IPackage newParentPackage, NotificationChain msgs) {
		msgs = eBasicSetContainer((InternalEObject) newParentPackage, ImplementationPackage.ICLASS__PARENT_PACKAGE,
			msgs);
		return msgs;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public void setParentPackage(IPackage newParentPackage) {
		if (newParentPackage != eInternalContainer()
			|| (eContainerFeatureID() != ImplementationPackage.ICLASS__PARENT_PACKAGE && newParentPackage != null)) {
			if (EcoreUtil.isAncestor(this, newParentPackage))
				throw new IllegalArgumentException("Recursive containment not allowed for " + toString());
			NotificationChain msgs = null;
			if (eInternalContainer() != null)
				msgs = eBasicRemoveFromContainer(msgs);
			if (newParentPackage != null)
				msgs = ((InternalEObject) newParentPackage).eInverseAdd(this, ImplementationPackage.IPACKAGE__CLASSES,
					IPackage.class, msgs);
			msgs = basicSetParentPackage(newParentPackage, msgs);
			if (msgs != null)
				msgs.dispatch();
		} else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ImplementationPackage.ICLASS__PARENT_PACKAGE,
				newParentPackage, newParentPackage));
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public boolean isAbstract() {
		return abstract_;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public void setAbstract(boolean newAbstract) {
		boolean oldAbstract = abstract_;
		abstract_ = newAbstract;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ImplementationPackage.ICLASS__ABSTRACT, oldAbstract,
				abstract_));
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public EList<IClass> getSuperClasses() {
		if (superClasses == null) {
			superClasses = new EObjectWithInverseResolvingEList.Unsettable.ManyInverse<IClass>(IClass.class, this,
				ImplementationPackage.ICLASS__SUPER_CLASSES, ImplementationPackage.ICLASS__SUB_CLASSES);
		}
		return superClasses;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public void unsetSuperClasses() {
		if (superClasses != null)
			((InternalEList.Unsettable<?>) superClasses).unset();
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public boolean isSetSuperClasses() {
		return superClasses != null && ((InternalEList.Unsettable<?>) superClasses).isSet();
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public EList<IClass> getSubClasses() {
		if (subClasses == null) {
			subClasses = new EObjectWithInverseResolvingEList.ManyInverse<IClass>(IClass.class, this,
				ImplementationPackage.ICLASS__SUB_CLASSES, ImplementationPackage.ICLASS__SUPER_CLASSES);
		}
		return subClasses;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public EList<IAttribute> getAttributes() {
		if (attributes == null) {
			attributes = new EObjectContainmentWithInverseEList<IAttribute>(IAttribute.class, this,
				ImplementationPackage.ICLASS__ATTRIBUTES, ImplementationPackage.IATTRIBUTE__PARENT_CLASS);
		}
		return attributes;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public EList<IReference> getOutgoingReferences() {
		if (outgoingReferences == null) {
			outgoingReferences = new EObjectContainmentWithInverseEList<IReference>(IReference.class, this,
				ImplementationPackage.ICLASS__OUTGOING_REFERENCES, ImplementationPackage.IREFERENCE__PARENT_CLASS);
		}
		return outgoingReferences;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public EList<IReference> getIncomingReferences() {
		if (incomingReferences == null) {
			incomingReferences = new EObjectWithInverseResolvingEList<IReference>(IReference.class, this,
				ImplementationPackage.ICLASS__INCOMING_REFERENCES, ImplementationPackage.IREFERENCE__TYPE);
		}
		return incomingReferences;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public EList<org.unicase.model.classes.Class> getAnalysisClasses() {
		if (analysisClasses == null) {
			analysisClasses = new EObjectWithInverseResolvingEList.ManyInverse<org.unicase.model.classes.Class>(
				org.unicase.model.classes.Class.class, this, ImplementationPackage.ICLASS__ANALYSIS_CLASSES,
				ClassesPackage.CLASS__IMPLEMENTATION_CLASSES);
		}
		return analysisClasses;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	@Override
	public NotificationChain eInverseAdd(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
		case ImplementationPackage.ICLASS__PARENT_PACKAGE:
			if (eInternalContainer() != null)
				msgs = eBasicRemoveFromContainer(msgs);
			return basicSetParentPackage((IPackage) otherEnd, msgs);
		case ImplementationPackage.ICLASS__SUPER_CLASSES:
			return ((InternalEList<InternalEObject>) (InternalEList<?>) getSuperClasses()).basicAdd(otherEnd, msgs);
		case ImplementationPackage.ICLASS__SUB_CLASSES:
			return ((InternalEList<InternalEObject>) (InternalEList<?>) getSubClasses()).basicAdd(otherEnd, msgs);
		case ImplementationPackage.ICLASS__ATTRIBUTES:
			return ((InternalEList<InternalEObject>) (InternalEList<?>) getAttributes()).basicAdd(otherEnd, msgs);
		case ImplementationPackage.ICLASS__OUTGOING_REFERENCES:
			return ((InternalEList<InternalEObject>) (InternalEList<?>) getOutgoingReferences()).basicAdd(otherEnd,
				msgs);
		case ImplementationPackage.ICLASS__INCOMING_REFERENCES:
			return ((InternalEList<InternalEObject>) (InternalEList<?>) getIncomingReferences()).basicAdd(otherEnd,
				msgs);
		case ImplementationPackage.ICLASS__ANALYSIS_CLASSES:
			return ((InternalEList<InternalEObject>) (InternalEList<?>) getAnalysisClasses()).basicAdd(otherEnd, msgs);
		}
		return super.eInverseAdd(otherEnd, featureID, msgs);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
		case ImplementationPackage.ICLASS__PARENT_PACKAGE:
			return basicSetParentPackage(null, msgs);
		case ImplementationPackage.ICLASS__SUPER_CLASSES:
			return ((InternalEList<?>) getSuperClasses()).basicRemove(otherEnd, msgs);
		case ImplementationPackage.ICLASS__SUB_CLASSES:
			return ((InternalEList<?>) getSubClasses()).basicRemove(otherEnd, msgs);
		case ImplementationPackage.ICLASS__ATTRIBUTES:
			return ((InternalEList<?>) getAttributes()).basicRemove(otherEnd, msgs);
		case ImplementationPackage.ICLASS__OUTGOING_REFERENCES:
			return ((InternalEList<?>) getOutgoingReferences()).basicRemove(otherEnd, msgs);
		case ImplementationPackage.ICLASS__INCOMING_REFERENCES:
			return ((InternalEList<?>) getIncomingReferences()).basicRemove(otherEnd, msgs);
		case ImplementationPackage.ICLASS__ANALYSIS_CLASSES:
			return ((InternalEList<?>) getAnalysisClasses()).basicRemove(otherEnd, msgs);
		}
		return super.eInverseRemove(otherEnd, featureID, msgs);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public NotificationChain eBasicRemoveFromContainerFeature(NotificationChain msgs) {
		switch (eContainerFeatureID()) {
		case ImplementationPackage.ICLASS__PARENT_PACKAGE:
			return eInternalContainer().eInverseRemove(this, ImplementationPackage.IPACKAGE__CLASSES, IPackage.class,
				msgs);
		}
		return super.eBasicRemoveFromContainerFeature(msgs);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
		case ImplementationPackage.ICLASS__PARENT_PACKAGE:
			if (resolve)
				return getParentPackage();
			return basicGetParentPackage();
		case ImplementationPackage.ICLASS__ABSTRACT:
			return isAbstract();
		case ImplementationPackage.ICLASS__SUPER_CLASSES:
			return getSuperClasses();
		case ImplementationPackage.ICLASS__SUB_CLASSES:
			return getSubClasses();
		case ImplementationPackage.ICLASS__ATTRIBUTES:
			return getAttributes();
		case ImplementationPackage.ICLASS__OUTGOING_REFERENCES:
			return getOutgoingReferences();
		case ImplementationPackage.ICLASS__INCOMING_REFERENCES:
			return getIncomingReferences();
		case ImplementationPackage.ICLASS__ANALYSIS_CLASSES:
			return getAnalysisClasses();
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
		case ImplementationPackage.ICLASS__PARENT_PACKAGE:
			setParentPackage((IPackage) newValue);
			return;
		case ImplementationPackage.ICLASS__ABSTRACT:
			setAbstract((Boolean) newValue);
			return;
		case ImplementationPackage.ICLASS__SUPER_CLASSES:
			getSuperClasses().clear();
			getSuperClasses().addAll((Collection<? extends IClass>) newValue);
			return;
		case ImplementationPackage.ICLASS__SUB_CLASSES:
			getSubClasses().clear();
			getSubClasses().addAll((Collection<? extends IClass>) newValue);
			return;
		case ImplementationPackage.ICLASS__ATTRIBUTES:
			getAttributes().clear();
			getAttributes().addAll((Collection<? extends IAttribute>) newValue);
			return;
		case ImplementationPackage.ICLASS__OUTGOING_REFERENCES:
			getOutgoingReferences().clear();
			getOutgoingReferences().addAll((Collection<? extends IReference>) newValue);
			return;
		case ImplementationPackage.ICLASS__INCOMING_REFERENCES:
			getIncomingReferences().clear();
			getIncomingReferences().addAll((Collection<? extends IReference>) newValue);
			return;
		case ImplementationPackage.ICLASS__ANALYSIS_CLASSES:
			getAnalysisClasses().clear();
			getAnalysisClasses().addAll((Collection<? extends org.unicase.model.classes.Class>) newValue);
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
		case ImplementationPackage.ICLASS__PARENT_PACKAGE:
			setParentPackage((IPackage) null);
			return;
		case ImplementationPackage.ICLASS__ABSTRACT:
			setAbstract(ABSTRACT_EDEFAULT);
			return;
		case ImplementationPackage.ICLASS__SUPER_CLASSES:
			unsetSuperClasses();
			return;
		case ImplementationPackage.ICLASS__SUB_CLASSES:
			getSubClasses().clear();
			return;
		case ImplementationPackage.ICLASS__ATTRIBUTES:
			getAttributes().clear();
			return;
		case ImplementationPackage.ICLASS__OUTGOING_REFERENCES:
			getOutgoingReferences().clear();
			return;
		case ImplementationPackage.ICLASS__INCOMING_REFERENCES:
			getIncomingReferences().clear();
			return;
		case ImplementationPackage.ICLASS__ANALYSIS_CLASSES:
			getAnalysisClasses().clear();
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
		case ImplementationPackage.ICLASS__PARENT_PACKAGE:
			return basicGetParentPackage() != null;
		case ImplementationPackage.ICLASS__ABSTRACT:
			return abstract_ != ABSTRACT_EDEFAULT;
		case ImplementationPackage.ICLASS__SUPER_CLASSES:
			return isSetSuperClasses();
		case ImplementationPackage.ICLASS__SUB_CLASSES:
			return subClasses != null && !subClasses.isEmpty();
		case ImplementationPackage.ICLASS__ATTRIBUTES:
			return attributes != null && !attributes.isEmpty();
		case ImplementationPackage.ICLASS__OUTGOING_REFERENCES:
			return outgoingReferences != null && !outgoingReferences.isEmpty();
		case ImplementationPackage.ICLASS__INCOMING_REFERENCES:
			return incomingReferences != null && !incomingReferences.isEmpty();
		case ImplementationPackage.ICLASS__ANALYSIS_CLASSES:
			return analysisClasses != null && !analysisClasses.isEmpty();
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
		result.append(" (abstract: ");
		result.append(abstract_);
		result.append(')');
		return result.toString();
	}

} // IClassImpl
