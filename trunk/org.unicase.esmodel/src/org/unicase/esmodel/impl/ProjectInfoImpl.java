/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.unicase.esmodel.impl;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.EObjectImpl;
import org.unicase.esmodel.EsmodelPackage;
import org.unicase.esmodel.ProjectId;
import org.unicase.esmodel.ProjectInfo;
import org.unicase.esmodel.changemanagment.VersionSpec;
import org.unicase.esmodel.changemanagment.PrimaryVersionSpec;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Project Info</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.unicase.esmodel.impl.ProjectInfoImpl#getName <em>Name</em>}</li>
 *   <li>{@link org.unicase.esmodel.impl.ProjectInfoImpl#getDescription <em>Description</em>}</li>
 *   <li>{@link org.unicase.esmodel.impl.ProjectInfoImpl#getProjectId <em>Project Id</em>}</li>
 *   <li>{@link org.unicase.esmodel.impl.ProjectInfoImpl#getVersion <em>Version</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class ProjectInfoImpl extends EObjectImpl implements ProjectInfo {
	/**
	 * The default value of the '{@link #getName() <em>Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getName()
	 * @generated
	 * @ordered
	 */
	protected static final String NAME_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getName() <em>Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getName()
	 * @generated
	 * @ordered
	 */
	protected String name = NAME_EDEFAULT;

	/**
	 * The default value of the '{@link #getDescription() <em>Description</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getDescription()
	 * @generated
	 * @ordered
	 */
	protected static final String DESCRIPTION_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getDescription() <em>Description</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getDescription()
	 * @generated
	 * @ordered
	 */
	protected String description = DESCRIPTION_EDEFAULT;

	/**
	 * The cached value of the '{@link #getProjectId() <em>Project Id</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getProjectId()
	 * @generated
	 * @ordered
	 */
	protected ProjectId projectId;

	/**
	 * The cached value of the '{@link #getVersion() <em>Version</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getVersion()
	 * @generated
	 * @ordered
	 */
	protected VersionSpec version;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected ProjectInfoImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return EsmodelPackage.Literals.PROJECT_INFO;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getName() {
		return name;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setName(String newName) {
		String oldName = name;
		name = newName;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, EsmodelPackage.PROJECT_INFO__NAME, oldName, name));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getDescription() {
		return description;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setDescription(String newDescription) {
		String oldDescription = description;
		description = newDescription;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, EsmodelPackage.PROJECT_INFO__DESCRIPTION, oldDescription, description));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ProjectId getProjectId() {
		if (projectId != null && projectId.eIsProxy()) {
			InternalEObject oldProjectId = (InternalEObject)projectId;
			projectId = (ProjectId)eResolveProxy(oldProjectId);
			if (projectId != oldProjectId) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, EsmodelPackage.PROJECT_INFO__PROJECT_ID, oldProjectId, projectId));
			}
		}
		return projectId;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ProjectId basicGetProjectId() {
		return projectId;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setProjectId(ProjectId newProjectId) {
		ProjectId oldProjectId = projectId;
		projectId = newProjectId;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, EsmodelPackage.PROJECT_INFO__PROJECT_ID, oldProjectId, projectId));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public VersionSpec getVersion() {
		if (version != null && version.eIsProxy()) {
			InternalEObject oldVersion = (InternalEObject)version;
			version = (VersionSpec)eResolveProxy(oldVersion);
			if (version != oldVersion) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, EsmodelPackage.PROJECT_INFO__VERSION, oldVersion, version));
			}
		}
		return version;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public VersionSpec basicGetVersion() {
		return version;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setVersion(VersionSpec newVersion) {
		VersionSpec oldVersion = version;
		version = newVersion;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, EsmodelPackage.PROJECT_INFO__VERSION, oldVersion, version));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case EsmodelPackage.PROJECT_INFO__NAME:
				return getName();
			case EsmodelPackage.PROJECT_INFO__DESCRIPTION:
				return getDescription();
			case EsmodelPackage.PROJECT_INFO__PROJECT_ID:
				if (resolve) return getProjectId();
				return basicGetProjectId();
			case EsmodelPackage.PROJECT_INFO__VERSION:
				if (resolve) return getVersion();
				return basicGetVersion();
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
			case EsmodelPackage.PROJECT_INFO__NAME:
				setName((String)newValue);
				return;
			case EsmodelPackage.PROJECT_INFO__DESCRIPTION:
				setDescription((String)newValue);
				return;
			case EsmodelPackage.PROJECT_INFO__PROJECT_ID:
				setProjectId((ProjectId)newValue);
				return;
			case EsmodelPackage.PROJECT_INFO__VERSION:
				setVersion((VersionSpec)newValue);
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
			case EsmodelPackage.PROJECT_INFO__NAME:
				setName(NAME_EDEFAULT);
				return;
			case EsmodelPackage.PROJECT_INFO__DESCRIPTION:
				setDescription(DESCRIPTION_EDEFAULT);
				return;
			case EsmodelPackage.PROJECT_INFO__PROJECT_ID:
				setProjectId((ProjectId)null);
				return;
			case EsmodelPackage.PROJECT_INFO__VERSION:
				setVersion((VersionSpec)null);
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
			case EsmodelPackage.PROJECT_INFO__NAME:
				return NAME_EDEFAULT == null ? name != null : !NAME_EDEFAULT.equals(name);
			case EsmodelPackage.PROJECT_INFO__DESCRIPTION:
				return DESCRIPTION_EDEFAULT == null ? description != null : !DESCRIPTION_EDEFAULT.equals(description);
			case EsmodelPackage.PROJECT_INFO__PROJECT_ID:
				return projectId != null;
			case EsmodelPackage.PROJECT_INFO__VERSION:
				return version != null;
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
		result.append(" (name: ");
		result.append(name);
		result.append(", description: ");
		result.append(description);
		result.append(')');
		return result.toString();
	}

} //ProjectInfoImpl
