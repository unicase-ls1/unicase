/**
 * <copyright> Copyright (c) 2008-2009 Jonas Helming, Maximilian Koegel. All rights reserved. This program and the
 * accompanying materials are made available under the terms of the Eclipse Public License v1.0 which accompanies this
 * distribution, and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>
 */
package org.unicase.ecp.model.workSpaceModel.impl;

import java.util.ArrayList;
import java.util.Collection;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.common.util.BasicEList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.EObjectImpl;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.unicase.ecp.model.ModelElementContextListener;
import org.unicase.ecp.model.workSpaceModel.ECPProject;
import org.unicase.ecp.model.workSpaceModel.ECPProjectListener;
import org.unicase.ecp.model.workSpaceModel.ECPWorkspace;
import org.unicase.ecp.model.workSpaceModel.WorkSpaceModelPackage;

/**
 * <!-- begin-user-doc --> An implementation of the model object '<em><b>ECP Project</b></em>'. <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.unicase.ecp.model.workSpaceModel.impl.ECPProjectImpl#getWorkspace <em>Workspace</em>}</li>
 *   <li>{@link org.unicase.ecp.model.workSpaceModel.impl.ECPProjectImpl#getRootObject <em>Root Object</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public abstract class ECPProjectImpl extends EObjectImpl implements ECPProject {
	
	/**
	 * {@inheritDoc}
	 */
	public EObject getRootContainer() {
		//default implementation returns root object
		return getRootObject();
	}

	/**
	 * The cached value of the '{@link #getRootObject() <em>Root Object</em>}' reference.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * @see #getRootObject()
	 * @generated
	 * @ordered
	 */
	protected EObject rootObject;
	private ArrayList<ECPProjectListener> listeners = new ArrayList<ECPProjectListener>();
	private ArrayList<ModelElementContextListener> contextListeners = new ArrayList<ModelElementContextListener>();

	public void addECPProjectListener(ECPProjectListener listener) {
		listeners.add(listener);
	}

	/**
	 * {@inheritDoc}
	 */
	public void removeECPProjectListener(ECPProjectListener listener) {
		listeners.remove(listener);
	}

	/**
	 * {@inheritDoc}
	 */
	public void modelelementDeleted(EObject eobject) {
		for (ECPProjectListener listener : listeners) {
			listener.modelelementDeleted(eobject);
		}
		for (ModelElementContextListener listener : contextListeners) {
			listener.onModelElementDeleted(eobject);
		}
	}

	/**
	 * {@inheritDoc}
	 */
	public void projectDeleted() {
		for (ECPProjectListener listener : listeners) {
			listener.projectDeleted();
		}

		for (ModelElementContextListener listener : contextListeners) {
			listener.onContextDeleted();
		}
	}

	/**
	 * {@inheritDoc}
	 */
	public void projectChanged() {
		for (ECPProjectListener listener : listeners) {
			listener.projectChanged();
		}
	}
	
	/**
	 * {@inheritDoc}
	 */
	public void addModelElementContextListener(ModelElementContextListener modelElementContextListener) { 
		contextListeners.add(modelElementContextListener);
	}
	
	/**
	 * {@inheritDoc}
	 */
	public void removeModelElementContextListener(ModelElementContextListener modelElementContextListener) {
		contextListeners.remove(modelElementContextListener);
	}

	/**
	 * {@inheritDoc}
	 */
	public Collection<EObject> getAllModelElementsbyClass(EClass clazz, boolean association) {
		Collection<EObject> ret = new BasicEList<EObject>();
		
		for (EObject element : getAllModelElements()) {
			if ( (element.eClass() == clazz || clazz.isInstance(element)) && 
					(association || !getMetaModelElementContext().isAssociationClassElement(element))) {
				ret.add(element);
			}
		}

		return ret;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	protected ECPProjectImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return WorkSpaceModelPackage.Literals.ECP_PROJECT;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public ECPWorkspace getWorkspace() {
		if (eContainerFeatureID() != WorkSpaceModelPackage.ECP_PROJECT__WORKSPACE) return null;
		return (ECPWorkspace)eContainer();
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetWorkspace(ECPWorkspace newWorkspace, NotificationChain msgs) {
		msgs = eBasicSetContainer((InternalEObject)newWorkspace, WorkSpaceModelPackage.ECP_PROJECT__WORKSPACE, msgs);
		return msgs;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public void setWorkspace(ECPWorkspace newWorkspace) {
		if (newWorkspace != eInternalContainer() || (eContainerFeatureID() != WorkSpaceModelPackage.ECP_PROJECT__WORKSPACE && newWorkspace != null)) {
			if (EcoreUtil.isAncestor(this, newWorkspace))
				throw new IllegalArgumentException("Recursive containment not allowed for " + toString());
			NotificationChain msgs = null;
			if (eInternalContainer() != null)
				msgs = eBasicRemoveFromContainer(msgs);
			if (newWorkspace != null)
				msgs = ((InternalEObject)newWorkspace).eInverseAdd(this, WorkSpaceModelPackage.ECP_WORKSPACE__PROJECTS, ECPWorkspace.class, msgs);
			msgs = basicSetWorkspace(newWorkspace, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, WorkSpaceModelPackage.ECP_PROJECT__WORKSPACE, newWorkspace, newWorkspace));
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EObject getRootObject() {
		if (rootObject != null && rootObject.eIsProxy()) {
			InternalEObject oldRootObject = (InternalEObject)rootObject;
			rootObject = eResolveProxy(oldRootObject);
			if (rootObject != oldRootObject) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, WorkSpaceModelPackage.ECP_PROJECT__ROOT_OBJECT, oldRootObject, rootObject));
			}
		}
		return rootObject;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EObject basicGetRootObject() {
		return rootObject;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public void setRootObject(EObject newRootObject) {
		EObject oldRootObject = rootObject;
		rootObject = newRootObject;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, WorkSpaceModelPackage.ECP_PROJECT__ROOT_OBJECT, oldRootObject, rootObject));
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseAdd(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case WorkSpaceModelPackage.ECP_PROJECT__WORKSPACE:
				if (eInternalContainer() != null)
					msgs = eBasicRemoveFromContainer(msgs);
				return basicSetWorkspace((ECPWorkspace)otherEnd, msgs);
		}
		return super.eInverseAdd(otherEnd, featureID, msgs);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case WorkSpaceModelPackage.ECP_PROJECT__WORKSPACE:
				return basicSetWorkspace(null, msgs);
		}
		return super.eInverseRemove(otherEnd, featureID, msgs);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eBasicRemoveFromContainerFeature(NotificationChain msgs) {
		switch (eContainerFeatureID()) {
			case WorkSpaceModelPackage.ECP_PROJECT__WORKSPACE:
				return eInternalContainer().eInverseRemove(this, WorkSpaceModelPackage.ECP_WORKSPACE__PROJECTS, ECPWorkspace.class, msgs);
		}
		return super.eBasicRemoveFromContainerFeature(msgs);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case WorkSpaceModelPackage.ECP_PROJECT__WORKSPACE:
				return getWorkspace();
			case WorkSpaceModelPackage.ECP_PROJECT__ROOT_OBJECT:
				if (resolve) return getRootObject();
				return basicGetRootObject();
		}
		return super.eGet(featureID, resolve, coreType);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void eSet(int featureID, Object newValue) {
		switch (featureID) {
			case WorkSpaceModelPackage.ECP_PROJECT__WORKSPACE:
				setWorkspace((ECPWorkspace)newValue);
				return;
			case WorkSpaceModelPackage.ECP_PROJECT__ROOT_OBJECT:
				setRootObject((EObject)newValue);
				return;
		}
		super.eSet(featureID, newValue);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void eUnset(int featureID) {
		switch (featureID) {
			case WorkSpaceModelPackage.ECP_PROJECT__WORKSPACE:
				setWorkspace((ECPWorkspace)null);
				return;
			case WorkSpaceModelPackage.ECP_PROJECT__ROOT_OBJECT:
				setRootObject((EObject)null);
				return;
		}
		super.eUnset(featureID);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean eIsSet(int featureID) {
		switch (featureID) {
			case WorkSpaceModelPackage.ECP_PROJECT__WORKSPACE:
				return getWorkspace() != null;
			case WorkSpaceModelPackage.ECP_PROJECT__ROOT_OBJECT:
				return rootObject != null;
		}
		return super.eIsSet(featureID);
	}

} // ECPProjectImpl
