/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.unicase.esmodel.impl;

import java.util.Collection;
import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.EObjectImpl;

import org.eclipse.emf.ecore.util.EObjectResolvingEList;
import org.unicase.esmodel.ChangePackage;
import org.unicase.esmodel.EsmodelPackage;
import org.unicase.esmodel.PrimaryVersionSpec;
import org.unicase.esmodel.TagVersionSpec;
import org.unicase.esmodel.Version;

import org.unicase.model.Project;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Version</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.unicase.esmodel.impl.VersionImpl#getProjectState <em>Project State</em>}</li>
 *   <li>{@link org.unicase.esmodel.impl.VersionImpl#getPrimarySpec <em>Primary Spec</em>}</li>
 *   <li>{@link org.unicase.esmodel.impl.VersionImpl#getTagSpecs <em>Tag Specs</em>}</li>
 *   <li>{@link org.unicase.esmodel.impl.VersionImpl#getNextVersion <em>Next Version</em>}</li>
 *   <li>{@link org.unicase.esmodel.impl.VersionImpl#getPreviousVersion <em>Previous Version</em>}</li>
 *   <li>{@link org.unicase.esmodel.impl.VersionImpl#getChanges <em>Changes</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class VersionImpl extends EObjectImpl implements Version {
	/**
	 * The cached value of the '{@link #getProjectState() <em>Project State</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getProjectState()
	 * @generated
	 * @ordered
	 */
	protected Project projectState;
	/**
	 * The cached value of the '{@link #getPrimarySpec() <em>Primary Spec</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getPrimarySpec()
	 * @generated
	 * @ordered
	 */
	protected PrimaryVersionSpec primarySpec;
	/**
	 * The cached value of the '{@link #getTagSpecs() <em>Tag Specs</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getTagSpecs()
	 * @generated
	 * @ordered
	 */
	protected EList<TagVersionSpec> tagSpecs;
	/**
	 * The cached value of the '{@link #getNextVersion() <em>Next Version</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getNextVersion()
	 * @generated
	 * @ordered
	 */
	protected Version nextVersion;
	/**
	 * The cached value of the '{@link #getPreviousVersion() <em>Previous Version</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getPreviousVersion()
	 * @generated
	 * @ordered
	 */
	protected Version previousVersion;
	/**
	 * The cached value of the '{@link #getChanges() <em>Changes</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getChanges()
	 * @generated
	 * @ordered
	 */
	protected ChangePackage changes;
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected VersionImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return EsmodelPackage.Literals.VERSION;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Project getProjectState() {
		if (projectState != null && projectState.eIsProxy()) {
			InternalEObject oldProjectState = (InternalEObject)projectState;
			projectState = (Project)eResolveProxy(oldProjectState);
			if (projectState != oldProjectState) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, EsmodelPackage.VERSION__PROJECT_STATE, oldProjectState, projectState));
			}
		}
		return projectState;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Project basicGetProjectState() {
		return projectState;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setProjectState(Project newProjectState) {
		Project oldProjectState = projectState;
		projectState = newProjectState;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, EsmodelPackage.VERSION__PROJECT_STATE, oldProjectState, projectState));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public PrimaryVersionSpec getPrimarySpec() {
		if (primarySpec != null && primarySpec.eIsProxy()) {
			InternalEObject oldPrimarySpec = (InternalEObject)primarySpec;
			primarySpec = (PrimaryVersionSpec)eResolveProxy(oldPrimarySpec);
			if (primarySpec != oldPrimarySpec) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, EsmodelPackage.VERSION__PRIMARY_SPEC, oldPrimarySpec, primarySpec));
			}
		}
		return primarySpec;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public PrimaryVersionSpec basicGetPrimarySpec() {
		return primarySpec;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setPrimarySpec(PrimaryVersionSpec newPrimarySpec) {
		PrimaryVersionSpec oldPrimarySpec = primarySpec;
		primarySpec = newPrimarySpec;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, EsmodelPackage.VERSION__PRIMARY_SPEC, oldPrimarySpec, primarySpec));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<TagVersionSpec> getTagSpecs() {
		if (tagSpecs == null) {
			tagSpecs = new EObjectResolvingEList<TagVersionSpec>(TagVersionSpec.class, this, EsmodelPackage.VERSION__TAG_SPECS);
		}
		return tagSpecs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Version getNextVersion() {
		if (nextVersion != null && nextVersion.eIsProxy()) {
			InternalEObject oldNextVersion = (InternalEObject)nextVersion;
			nextVersion = (Version)eResolveProxy(oldNextVersion);
			if (nextVersion != oldNextVersion) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, EsmodelPackage.VERSION__NEXT_VERSION, oldNextVersion, nextVersion));
			}
		}
		return nextVersion;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Version basicGetNextVersion() {
		return nextVersion;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setNextVersion(Version newNextVersion) {
		Version oldNextVersion = nextVersion;
		nextVersion = newNextVersion;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, EsmodelPackage.VERSION__NEXT_VERSION, oldNextVersion, nextVersion));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Version getPreviousVersion() {
		if (previousVersion != null && previousVersion.eIsProxy()) {
			InternalEObject oldPreviousVersion = (InternalEObject)previousVersion;
			previousVersion = (Version)eResolveProxy(oldPreviousVersion);
			if (previousVersion != oldPreviousVersion) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, EsmodelPackage.VERSION__PREVIOUS_VERSION, oldPreviousVersion, previousVersion));
			}
		}
		return previousVersion;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Version basicGetPreviousVersion() {
		return previousVersion;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setPreviousVersion(Version newPreviousVersion) {
		Version oldPreviousVersion = previousVersion;
		previousVersion = newPreviousVersion;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, EsmodelPackage.VERSION__PREVIOUS_VERSION, oldPreviousVersion, previousVersion));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ChangePackage getChanges() {
		if (changes != null && changes.eIsProxy()) {
			InternalEObject oldChanges = (InternalEObject)changes;
			changes = (ChangePackage)eResolveProxy(oldChanges);
			if (changes != oldChanges) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, EsmodelPackage.VERSION__CHANGES, oldChanges, changes));
			}
		}
		return changes;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ChangePackage basicGetChanges() {
		return changes;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setChanges(ChangePackage newChanges) {
		ChangePackage oldChanges = changes;
		changes = newChanges;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, EsmodelPackage.VERSION__CHANGES, oldChanges, changes));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case EsmodelPackage.VERSION__PROJECT_STATE:
				if (resolve) return getProjectState();
				return basicGetProjectState();
			case EsmodelPackage.VERSION__PRIMARY_SPEC:
				if (resolve) return getPrimarySpec();
				return basicGetPrimarySpec();
			case EsmodelPackage.VERSION__TAG_SPECS:
				return getTagSpecs();
			case EsmodelPackage.VERSION__NEXT_VERSION:
				if (resolve) return getNextVersion();
				return basicGetNextVersion();
			case EsmodelPackage.VERSION__PREVIOUS_VERSION:
				if (resolve) return getPreviousVersion();
				return basicGetPreviousVersion();
			case EsmodelPackage.VERSION__CHANGES:
				if (resolve) return getChanges();
				return basicGetChanges();
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
			case EsmodelPackage.VERSION__PROJECT_STATE:
				setProjectState((Project)newValue);
				return;
			case EsmodelPackage.VERSION__PRIMARY_SPEC:
				setPrimarySpec((PrimaryVersionSpec)newValue);
				return;
			case EsmodelPackage.VERSION__TAG_SPECS:
				getTagSpecs().clear();
				getTagSpecs().addAll((Collection<? extends TagVersionSpec>)newValue);
				return;
			case EsmodelPackage.VERSION__NEXT_VERSION:
				setNextVersion((Version)newValue);
				return;
			case EsmodelPackage.VERSION__PREVIOUS_VERSION:
				setPreviousVersion((Version)newValue);
				return;
			case EsmodelPackage.VERSION__CHANGES:
				setChanges((ChangePackage)newValue);
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
			case EsmodelPackage.VERSION__PROJECT_STATE:
				setProjectState((Project)null);
				return;
			case EsmodelPackage.VERSION__PRIMARY_SPEC:
				setPrimarySpec((PrimaryVersionSpec)null);
				return;
			case EsmodelPackage.VERSION__TAG_SPECS:
				getTagSpecs().clear();
				return;
			case EsmodelPackage.VERSION__NEXT_VERSION:
				setNextVersion((Version)null);
				return;
			case EsmodelPackage.VERSION__PREVIOUS_VERSION:
				setPreviousVersion((Version)null);
				return;
			case EsmodelPackage.VERSION__CHANGES:
				setChanges((ChangePackage)null);
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
			case EsmodelPackage.VERSION__PROJECT_STATE:
				return projectState != null;
			case EsmodelPackage.VERSION__PRIMARY_SPEC:
				return primarySpec != null;
			case EsmodelPackage.VERSION__TAG_SPECS:
				return tagSpecs != null && !tagSpecs.isEmpty();
			case EsmodelPackage.VERSION__NEXT_VERSION:
				return nextVersion != null;
			case EsmodelPackage.VERSION__PREVIOUS_VERSION:
				return previousVersion != null;
			case EsmodelPackage.VERSION__CHANGES:
				return changes != null;
		}
		return super.eIsSet(featureID);
	}

} //VersionImpl
