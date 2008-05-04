/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.unicase.workspace.impl;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.change.ChangeDescription;
import org.eclipse.emf.ecore.change.impl.ChangeFactoryImpl;
import org.eclipse.emf.ecore.change.impl.ChangePackageImpl;
import org.eclipse.emf.ecore.change.util.ChangeRecorder;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.EObjectImpl;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.unicase.esmodel.changemanagment.ChangePackage;
import org.unicase.esmodel.changemanagment.PrimaryVersionSpec;
import org.unicase.esmodel.changemanagment.VersionSpec;
import org.unicase.esmodel.changemanagment.impl.ChangemanagmentFactoryImpl;
import org.unicase.esmodel.impl.EsmodelFactoryImpl;
import org.unicase.model.Project;
import org.unicase.workspace.ProjectSpace;
import org.unicase.workspace.Usersession;
import org.unicase.workspace.WorkspacePackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Project Container</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.unicase.workspace.impl.ProjectSpaceImpl#getProject <em>Project</em>}</li>
 *   <li>{@link org.unicase.workspace.impl.ProjectSpaceImpl#getBaseVersion <em>Base Version</em>}</li>
 *   <li>{@link org.unicase.workspace.impl.ProjectSpaceImpl#getLocalChanges <em>Local Changes</em>}</li>
 *   <li>{@link org.unicase.workspace.impl.ProjectSpaceImpl#getUsersession <em>Usersession</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class ProjectSpaceImpl extends EObjectImpl implements ProjectSpace {
	
	/**
	 * @generated NOT
	 */
	private ChangeRecorder changeRecorder;
	
	/**
	 * The cached value of the '{@link #getProject() <em>Project</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getProject()
	 * @generated
	 * @ordered
	 */
	protected Project project;

	/**
	 * The cached value of the '{@link #getBaseVersion() <em>Base Version</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getBaseVersion()
	 * @generated
	 * @ordered
	 */
	protected PrimaryVersionSpec baseVersion;

	/**
	 * The cached value of the '{@link #getLocalChanges() <em>Local Changes</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getLocalChanges()
	 * @generated
	 * @ordered
	 */
	protected ChangePackage localChanges;

	/**
	 * The cached value of the '{@link #getUsersession() <em>Usersession</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getUsersession()
	 * @generated
	 * @ordered
	 */
	protected Usersession usersession;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected ProjectSpaceImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return WorkspacePackage.Literals.PROJECT_SPACE;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Project getProject() {
		if (project != null && project.eIsProxy()) {
			InternalEObject oldProject = (InternalEObject)project;
			project = (Project)eResolveProxy(oldProject);
			if (project != oldProject) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, WorkspacePackage.PROJECT_SPACE__PROJECT, oldProject, project));
			}
		}
		return project;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Project basicGetProject() {
		return project;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setProjectGen(Project newProject) {
		Project oldProject = project;
		project = newProject;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, WorkspacePackage.PROJECT_SPACE__PROJECT, oldProject, project));
	}
	
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public void setProject(Project newProject) {
		setProjectGen(newProject);
		this.changeRecorder=new ChangeRecorder(project);
	}
	
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public PrimaryVersionSpec getBaseVersion() {
		if (baseVersion != null && baseVersion.eIsProxy()) {
			InternalEObject oldBaseVersion = (InternalEObject)baseVersion;
			baseVersion = (PrimaryVersionSpec)eResolveProxy(oldBaseVersion);
			if (baseVersion != oldBaseVersion) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, WorkspacePackage.PROJECT_SPACE__BASE_VERSION, oldBaseVersion, baseVersion));
			}
		}
		return baseVersion;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public PrimaryVersionSpec basicGetBaseVersion() {
		return baseVersion;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setBaseVersion(PrimaryVersionSpec newBaseVersion) {
		PrimaryVersionSpec oldBaseVersion = baseVersion;
		baseVersion = newBaseVersion;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, WorkspacePackage.PROJECT_SPACE__BASE_VERSION, oldBaseVersion, baseVersion));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ChangePackage getLocalChanges() {
		if (localChanges != null && localChanges.eIsProxy()) {
			InternalEObject oldLocalChanges = (InternalEObject)localChanges;
			localChanges = (ChangePackage)eResolveProxy(oldLocalChanges);
			if (localChanges != oldLocalChanges) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, WorkspacePackage.PROJECT_SPACE__LOCAL_CHANGES, oldLocalChanges, localChanges));
			}
		}
		return localChanges;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ChangePackage basicGetLocalChanges() {
		return localChanges;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setLocalChanges(ChangePackage newLocalChanges) {
		ChangePackage oldLocalChanges = localChanges;
		localChanges = newLocalChanges;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, WorkspacePackage.PROJECT_SPACE__LOCAL_CHANGES, oldLocalChanges, localChanges));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Usersession getUsersession() {
		if (usersession != null && usersession.eIsProxy()) {
			InternalEObject oldUsersession = (InternalEObject)usersession;
			usersession = (Usersession)eResolveProxy(oldUsersession);
			if (usersession != oldUsersession) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, WorkspacePackage.PROJECT_SPACE__USERSESSION, oldUsersession, usersession));
			}
		}
		return usersession;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Usersession basicGetUsersession() {
		return usersession;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setUsersession(Usersession newUsersession) {
		Usersession oldUsersession = usersession;
		usersession = newUsersession;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, WorkspacePackage.PROJECT_SPACE__USERSESSION, oldUsersession, usersession));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public PrimaryVersionSpec commit() {
		// TODO: implement this method
		// Ensure that you remove @generated or mark it @generated NOT
		throw new UnsupportedOperationException();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void update() {
		// TODO: implement this method
		// Ensure that you remove @generated or mark it @generated NOT
		throw new UnsupportedOperationException();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void update(VersionSpec version) {
		// TODO: implement this method
		// Ensure that you remove @generated or mark it @generated NOT
		throw new UnsupportedOperationException();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void revert() {
		// TODO: implement this method
		// Ensure that you remove @generated or mark it @generated NOT
		throw new UnsupportedOperationException();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public void save() {
		ChangeDescription changeDescription = this.changeRecorder.endRecording();
		ChangeDescription backwardChangeDescription= (ChangeDescription)EcoreUtil.copy(changeDescription);
		changeDescription.applyAndReverse();
		ChangeDescription forwardChangeDescription=changeDescription;
		ChangePackage changePackage = ChangemanagmentFactoryImpl.eINSTANCE.createChangePackage();
		changePackage.setBackwardDelta(backwardChangeDescription);
		changePackage.setFowardDelta(forwardChangeDescription);
		this.setLocalChanges(changePackage);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case WorkspacePackage.PROJECT_SPACE__PROJECT:
				if (resolve) return getProject();
				return basicGetProject();
			case WorkspacePackage.PROJECT_SPACE__BASE_VERSION:
				if (resolve) return getBaseVersion();
				return basicGetBaseVersion();
			case WorkspacePackage.PROJECT_SPACE__LOCAL_CHANGES:
				if (resolve) return getLocalChanges();
				return basicGetLocalChanges();
			case WorkspacePackage.PROJECT_SPACE__USERSESSION:
				if (resolve) return getUsersession();
				return basicGetUsersession();
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
			case WorkspacePackage.PROJECT_SPACE__PROJECT:
				setProject((Project)newValue);
				return;
			case WorkspacePackage.PROJECT_SPACE__BASE_VERSION:
				setBaseVersion((PrimaryVersionSpec)newValue);
				return;
			case WorkspacePackage.PROJECT_SPACE__LOCAL_CHANGES:
				setLocalChanges((ChangePackage)newValue);
				return;
			case WorkspacePackage.PROJECT_SPACE__USERSESSION:
				setUsersession((Usersession)newValue);
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
			case WorkspacePackage.PROJECT_SPACE__PROJECT:
				setProject((Project)null);
				return;
			case WorkspacePackage.PROJECT_SPACE__BASE_VERSION:
				setBaseVersion((PrimaryVersionSpec)null);
				return;
			case WorkspacePackage.PROJECT_SPACE__LOCAL_CHANGES:
				setLocalChanges((ChangePackage)null);
				return;
			case WorkspacePackage.PROJECT_SPACE__USERSESSION:
				setUsersession((Usersession)null);
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
			case WorkspacePackage.PROJECT_SPACE__PROJECT:
				return project != null;
			case WorkspacePackage.PROJECT_SPACE__BASE_VERSION:
				return baseVersion != null;
			case WorkspacePackage.PROJECT_SPACE__LOCAL_CHANGES:
				return localChanges != null;
			case WorkspacePackage.PROJECT_SPACE__USERSESSION:
				return usersession != null;
		}
		return super.eIsSet(featureID);
	}

} //ProjectContainerImpl
