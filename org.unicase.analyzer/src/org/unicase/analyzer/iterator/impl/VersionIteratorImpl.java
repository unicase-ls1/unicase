/**
 * <copyright> Copyright (c) 2008-2009 Jonas Helming, Maximilian Koegel. All rights reserved. This program and the
 * accompanying materials are made available under the terms of the Eclipse Public License v1.0 which accompanies this
 * distribution, and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>
 */
package org.unicase.analyzer.iterator.impl;

import java.util.List;
import java.util.NoSuchElementException;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.EObjectImpl;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.unicase.analyzer.AnalyzerFactory;
import org.unicase.analyzer.ProjectAnalysisData;
import org.unicase.analyzer.exceptions.IteratorException;
import org.unicase.analyzer.iterator.IteratorPackage;
import org.unicase.analyzer.iterator.VersionIterator;
import org.unicase.analyzer.iterator.VersionSpecQuery;
import org.unicase.emfstore.esmodel.ProjectId;
import org.unicase.emfstore.esmodel.versioning.ChangePackage;
import org.unicase.emfstore.esmodel.versioning.PrimaryVersionSpec;
import org.unicase.emfstore.esmodel.versioning.VersionSpec;
import org.unicase.emfstore.esmodel.versioning.VersioningFactory;
import org.unicase.emfstore.exceptions.EmfStoreException;
import org.unicase.emfstore.exceptions.InvalidVersionSpecException;
import org.unicase.metamodel.Project;
import org.unicase.metamodel.util.ModelUtil;
import org.unicase.workspace.Usersession;
import org.unicase.workspace.WorkspaceManager;
import org.unicase.workspace.connectionmanager.ConnectionManager;
import org.unicase.workspace.util.WorkspaceUtil;

/**
 * <!-- begin-user-doc --> An implementation of the model object '<em><b>Version Iterator</b></em>'. <!-- end-user-doc
 * -->
 * <p>
 * The following features are implemented:
 * <ul>
 * <li>{@link org.unicase.analyzer.iterator.impl.VersionIteratorImpl#getStepLength <em>Step Length</em>}</li>
 * <li>{@link org.unicase.analyzer.iterator.impl.VersionIteratorImpl#getProjectId <em>Project Id</em>}</li>
 * <li>{@link org.unicase.analyzer.iterator.impl.VersionIteratorImpl#isForward <em>Forward</em>}</li>
 * <li>{@link org.unicase.analyzer.iterator.impl.VersionIteratorImpl#isReturnProjectDataCopy <em>Return Project Data
 * Copy</em>}</li>
 * <li>{@link org.unicase.analyzer.iterator.impl.VersionIteratorImpl#getVersionSpecQuery <em>Version Spec Query</em>}</li>
 * <li>{@link org.unicase.analyzer.iterator.impl.VersionIteratorImpl#isDefault <em>Default</em>}</li>
 * </ul>
 * </p>
 * 
 * @generated
 */
public class VersionIteratorImpl extends EObjectImpl implements VersionIterator {
	/**
	 * The default value of the '{@link #getStepLength() <em>Step Length</em>}' attribute.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * @see #getStepLength()
	 * @generated
	 * @ordered
	 */
	protected static final int STEP_LENGTH_EDEFAULT = 0;

	/**
	 * The cached value of the '{@link #getStepLength() <em>Step Length</em>}' attribute.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * @see #getStepLength()
	 * @generated
	 * @ordered
	 */
	protected int stepLength = STEP_LENGTH_EDEFAULT;

	/**
	 * The cached value of the '{@link #getProjectId() <em>Project Id</em>}' containment reference.
	 * <!-- begin-user-doc
	 * --> <!-- end-user-doc -->
	 * @see #getProjectId()
	 * @generated
	 * @ordered
	 */
	protected ProjectId projectId;

	/**
	 * The default value of the '{@link #isForward() <em>Forward</em>}' attribute.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * @see #isForward()
	 * @generated
	 * @ordered
	 */
	protected static final boolean FORWARD_EDEFAULT = false;

	/**
	 * The cached value of the '{@link #isForward() <em>Forward</em>}' attribute.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * @see #isForward()
	 * @generated
	 * @ordered
	 */
	protected boolean forward = FORWARD_EDEFAULT;

	/**
	 * The default value of the '{@link #isReturnProjectDataCopy() <em>Return Project Data Copy</em>}' attribute. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see #isReturnProjectDataCopy()
	 * @generated
	 * @ordered
	 */
	protected static final boolean RETURN_PROJECT_DATA_COPY_EDEFAULT = false;

	/**
	 * The cached value of the '{@link #isReturnProjectDataCopy() <em>Return Project Data Copy</em>}' attribute. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see #isReturnProjectDataCopy()
	 * @generated
	 * @ordered
	 */
	protected boolean returnProjectDataCopy = RETURN_PROJECT_DATA_COPY_EDEFAULT;

	/**
	 * The cached value of the '{@link #getVersionSpecQuery() <em>Version Spec Query</em>}' containment reference. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see #getVersionSpecQuery()
	 * @generated
	 * @ordered
	 */
	protected VersionSpecQuery versionSpecQuery;

	/**
	 * The default value of the '{@link #isDefault() <em>Default</em>}' attribute.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * @see #isDefault()
	 * @generated
	 * @ordered
	 */
	protected static final boolean DEFAULT_EDEFAULT = false;

	/**
	 * The cached value of the '{@link #isDefault() <em>Default</em>}' attribute.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * @see #isDefault()
	 * @generated
	 * @ordered
	 */
	protected boolean default_ = DEFAULT_EDEFAULT;

	private Usersession usersession;

	private ConnectionManager connectionManager;

	private PrimaryVersionSpec start;

	private PrimaryVersionSpec end;

	private Project currentState;

	private PrimaryVersionSpec nextSpec;

	private PrimaryVersionSpec sourceSpec;

	/**
	 * @return the nextSpec
	 */
	public PrimaryVersionSpec getNextSpec() {
		return nextSpec;
	}

	/**
	 * @return the sourceSpec
	 */
	public PrimaryVersionSpec getSourceSpec() {
		return sourceSpec;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	protected VersionIteratorImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return IteratorPackage.Literals.VERSION_ITERATOR;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public int getStepLength() {
		return stepLength;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public void setStepLength(int newStepLength) {
		int oldStepLength = stepLength;
		stepLength = newStepLength;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, IteratorPackage.VERSION_ITERATOR__STEP_LENGTH, oldStepLength, stepLength));
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public ProjectId getProjectId() {
		return projectId;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetProjectId(ProjectId newProjectId, NotificationChain msgs) {
		ProjectId oldProjectId = projectId;
		projectId = newProjectId;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, IteratorPackage.VERSION_ITERATOR__PROJECT_ID, oldProjectId, newProjectId);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public void setProjectId(ProjectId newProjectId) {
		if (newProjectId != projectId) {
			NotificationChain msgs = null;
			if (projectId != null)
				msgs = ((InternalEObject)projectId).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - IteratorPackage.VERSION_ITERATOR__PROJECT_ID, null, msgs);
			if (newProjectId != null)
				msgs = ((InternalEObject)newProjectId).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - IteratorPackage.VERSION_ITERATOR__PROJECT_ID, null, msgs);
			msgs = basicSetProjectId(newProjectId, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, IteratorPackage.VERSION_ITERATOR__PROJECT_ID, newProjectId, newProjectId));
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isForward() {
		return forward;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public void setForward(boolean newForward) {
		boolean oldForward = forward;
		forward = newForward;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, IteratorPackage.VERSION_ITERATOR__FORWARD, oldForward, forward));
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isReturnProjectDataCopy() {
		return returnProjectDataCopy;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public void setReturnProjectDataCopy(boolean newReturnProjectDataCopy) {
		boolean oldReturnProjectDataCopy = returnProjectDataCopy;
		returnProjectDataCopy = newReturnProjectDataCopy;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, IteratorPackage.VERSION_ITERATOR__RETURN_PROJECT_DATA_COPY, oldReturnProjectDataCopy, returnProjectDataCopy));
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public VersionSpecQuery getVersionSpecQuery() {
		return versionSpecQuery;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetVersionSpecQuery(VersionSpecQuery newVersionSpecQuery, NotificationChain msgs) {
		VersionSpecQuery oldVersionSpecQuery = versionSpecQuery;
		versionSpecQuery = newVersionSpecQuery;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, IteratorPackage.VERSION_ITERATOR__VERSION_SPEC_QUERY, oldVersionSpecQuery, newVersionSpecQuery);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public void setVersionSpecQuery(VersionSpecQuery newVersionSpecQuery) {
		if (newVersionSpecQuery != versionSpecQuery) {
			NotificationChain msgs = null;
			if (versionSpecQuery != null)
				msgs = ((InternalEObject)versionSpecQuery).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - IteratorPackage.VERSION_ITERATOR__VERSION_SPEC_QUERY, null, msgs);
			if (newVersionSpecQuery != null)
				msgs = ((InternalEObject)newVersionSpecQuery).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - IteratorPackage.VERSION_ITERATOR__VERSION_SPEC_QUERY, null, msgs);
			msgs = basicSetVersionSpecQuery(newVersionSpecQuery, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, IteratorPackage.VERSION_ITERATOR__VERSION_SPEC_QUERY, newVersionSpecQuery, newVersionSpecQuery));
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isDefault() {
		return default_;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public void setDefault(boolean newDefault) {
		boolean oldDefault = default_;
		default_ = newDefault;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, IteratorPackage.VERSION_ITERATOR__DEFAULT, oldDefault, default_));
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case IteratorPackage.VERSION_ITERATOR__PROJECT_ID:
				return basicSetProjectId(null, msgs);
			case IteratorPackage.VERSION_ITERATOR__VERSION_SPEC_QUERY:
				return basicSetVersionSpecQuery(null, msgs);
		}
		return super.eInverseRemove(otherEnd, featureID, msgs);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case IteratorPackage.VERSION_ITERATOR__STEP_LENGTH:
				return getStepLength();
			case IteratorPackage.VERSION_ITERATOR__PROJECT_ID:
				return getProjectId();
			case IteratorPackage.VERSION_ITERATOR__FORWARD:
				return isForward();
			case IteratorPackage.VERSION_ITERATOR__RETURN_PROJECT_DATA_COPY:
				return isReturnProjectDataCopy();
			case IteratorPackage.VERSION_ITERATOR__VERSION_SPEC_QUERY:
				return getVersionSpecQuery();
			case IteratorPackage.VERSION_ITERATOR__DEFAULT:
				return isDefault();
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
			case IteratorPackage.VERSION_ITERATOR__STEP_LENGTH:
				setStepLength((Integer)newValue);
				return;
			case IteratorPackage.VERSION_ITERATOR__PROJECT_ID:
				setProjectId((ProjectId)newValue);
				return;
			case IteratorPackage.VERSION_ITERATOR__FORWARD:
				setForward((Boolean)newValue);
				return;
			case IteratorPackage.VERSION_ITERATOR__RETURN_PROJECT_DATA_COPY:
				setReturnProjectDataCopy((Boolean)newValue);
				return;
			case IteratorPackage.VERSION_ITERATOR__VERSION_SPEC_QUERY:
				setVersionSpecQuery((VersionSpecQuery)newValue);
				return;
			case IteratorPackage.VERSION_ITERATOR__DEFAULT:
				setDefault((Boolean)newValue);
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
			case IteratorPackage.VERSION_ITERATOR__STEP_LENGTH:
				setStepLength(STEP_LENGTH_EDEFAULT);
				return;
			case IteratorPackage.VERSION_ITERATOR__PROJECT_ID:
				setProjectId((ProjectId)null);
				return;
			case IteratorPackage.VERSION_ITERATOR__FORWARD:
				setForward(FORWARD_EDEFAULT);
				return;
			case IteratorPackage.VERSION_ITERATOR__RETURN_PROJECT_DATA_COPY:
				setReturnProjectDataCopy(RETURN_PROJECT_DATA_COPY_EDEFAULT);
				return;
			case IteratorPackage.VERSION_ITERATOR__VERSION_SPEC_QUERY:
				setVersionSpecQuery((VersionSpecQuery)null);
				return;
			case IteratorPackage.VERSION_ITERATOR__DEFAULT:
				setDefault(DEFAULT_EDEFAULT);
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
			case IteratorPackage.VERSION_ITERATOR__STEP_LENGTH:
				return stepLength != STEP_LENGTH_EDEFAULT;
			case IteratorPackage.VERSION_ITERATOR__PROJECT_ID:
				return projectId != null;
			case IteratorPackage.VERSION_ITERATOR__FORWARD:
				return forward != FORWARD_EDEFAULT;
			case IteratorPackage.VERSION_ITERATOR__RETURN_PROJECT_DATA_COPY:
				return returnProjectDataCopy != RETURN_PROJECT_DATA_COPY_EDEFAULT;
			case IteratorPackage.VERSION_ITERATOR__VERSION_SPEC_QUERY:
				return versionSpecQuery != null;
			case IteratorPackage.VERSION_ITERATOR__DEFAULT:
				return default_ != DEFAULT_EDEFAULT;
		}
		return super.eIsSet(featureID);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String toString() {
		if (eIsProxy()) return super.toString();

		StringBuffer result = new StringBuffer(super.toString());
		result.append(" (stepLength: ");
		result.append(stepLength);
		result.append(", forward: ");
		result.append(forward);
		result.append(", returnProjectDataCopy: ");
		result.append(returnProjectDataCopy);
		result.append(", default: ");
		result.append(default_);
		result.append(')');
		return result.toString();
	}

	public boolean hasNext() {
		if (isForward()) {
			return nextSpec.compareTo(end) <= 0;
		} else {
			return nextSpec.compareTo(end) >= 0;
		}
	}

	public void init(Usersession usersession, ProjectId projectId, int stepLength) throws IteratorException {

		setProjectId(projectId);
		setStepLength(stepLength);

		defaultSet();

		this.init(usersession);

	}

	public void init(Usersession usersession, ProjectId projectId, int stepLength, VersionSpecQuery versionSpecQuery,
		boolean isForward, boolean returnProjectDataCopy) throws IteratorException {

		setProjectId(projectId);
		setStepLength(stepLength);
		setReturnProjectDataCopy(returnProjectDataCopy);

		setForward(isForward);

		this.init(usersession);

	}

	/**
	 * Updates the PrimaryVersionSpec.
	 * 
	 * @param specifier {@link PrimaryVersionSpec}
	 * @param stepLength int
	 * @param isForward boolean
	 */
	protected void updateSpecifier(PrimaryVersionSpec specifier, int stepLength, boolean isForward) {
		int currentIdentifier = specifier.getIdentifier();
		if (isForward) {
			specifier.setIdentifier(currentIdentifier + stepLength);
		} else {
			specifier.setIdentifier(currentIdentifier - stepLength);

		}
	}

	public ProjectAnalysisData next() {

		ProjectAnalysisData projectdata = AnalyzerFactory.eINSTANCE.createProjectAnalysisData();

		if (!hasNext()) {
			throw new NoSuchElementException("There is no more Versions.");
		}

		if ((sourceSpec.getIdentifier() != nextSpec.getIdentifier())
			&& (nextSpec.getIdentifier() != start.getIdentifier())) {
			List<ChangePackage> changes;
			List<ChangePackage> backwardChanges;
			try {
				changes = connectionManager.getChanges(usersession.getSessionId(), projectId, sourceSpec, nextSpec);

			} catch (EmfStoreException e) {
				String message = "Could not get changes from server";
				WorkspaceUtil.logException(message, e);
				throw new NoSuchElementException(message + ":\n" + e);
			}

			List<ChangePackage> changePackages = projectdata.getChangePackages();

			for (ChangePackage changePackage : changes) {

				if (isForward()) {
					changePackage.apply(currentState, true);
					changePackages.add(changePackage);
				} else {
					changePackage.reverse().apply(currentState, true);
					// changePackages.add(changePackage);
				}
			}
			if (!isForward()) {

				PrimaryVersionSpec tempSourceSpec = (PrimaryVersionSpec) EcoreUtil.copy(sourceSpec);
				tempSourceSpec.setIdentifier(tempSourceSpec.getIdentifier() - 1);
				PrimaryVersionSpec tempNextSpec = (PrimaryVersionSpec) EcoreUtil.copy(nextSpec);
				if (tempNextSpec.getIdentifier() > 0) {
					tempNextSpec.setIdentifier(tempNextSpec.getIdentifier() - 1);
				} else {
					tempNextSpec.setIdentifier(0);
				}
				try {
					backwardChanges = connectionManager.getChanges(usersession.getSessionId(), projectId,
						tempSourceSpec, tempNextSpec);
				} catch (EmfStoreException e) {
					String message = "Could not get changes from server";
					WorkspaceUtil.logException(message, e);
					throw new NoSuchElementException(message + ":\n" + e);
				}
				for (ChangePackage backwardChangePackage : backwardChanges) {
					changePackages.add(backwardChangePackage);
				}
			}
		}
		PrimaryVersionSpec nextSpecCopy = (PrimaryVersionSpec) EcoreUtil.copy(nextSpec);
		projectdata.setPrimaryVersionSpec(nextSpecCopy);

		ProjectId projectIdCopy = (ProjectId) EcoreUtil.copy(projectId);
		projectdata.setProjectId(projectIdCopy);

		projectdata.setProjectState(currentState);

		// increase counter
		sourceSpec.setIdentifier(nextSpec.getIdentifier());

		updateSpecifier(nextSpec, stepLength, isForward());

		if (returnProjectDataCopy) {
			return (ProjectAnalysisData) EcoreUtil.copy(projectdata);
		} else {
			return projectdata;
		}
	}

	public void remove() {
		throw new UnsupportedOperationException();
	}

	private void defaultSet() {

		VersionSpecQuery versionSpecQuery = IteratorFactoryImpl.eINSTANCE.createVersionSpecQuery();
		versionSpecQuery.setStartVersion(VersioningFactory.eINSTANCE.createPrimaryVersionSpec());
		versionSpecQuery.setEndVersion(VersioningFactory.eINSTANCE.createHeadVersionSpec());
		setVersionSpecQuery(versionSpecQuery);
		setReturnProjectDataCopy(true);
		setForward(true);
	}

	public void init(Usersession usersession) throws IteratorException {

		this.usersession = usersession;
		this.connectionManager = WorkspaceManager.getInstance().getConnectionManager();

		// default iterator will start from reversion 0 till the HEAD
		if (isDefault()) {
			defaultSet();
		}
		VersionSpec start = versionSpecQuery.getStartVersion();
		VersionSpec end = versionSpecQuery.getEndVersion();

		try {
			this.start = this.connectionManager.resolveVersionSpec(usersession.getSessionId(), projectId, start);
			this.end = this.connectionManager.resolveVersionSpec(usersession.getSessionId(), projectId, end);
			this.currentState = this.connectionManager.getProject(usersession.getSessionId(), projectId, this.start);
		} catch (InvalidVersionSpecException e) {
			throw new IteratorException("Could not resolve start or end version.", e);
		} catch (EmfStoreException e) {
			throw new IteratorException("Cannot connect to server.", e);
		}

		// sanity checks
		if (isForward()) {
			if (this.start.compareTo(this.end) >= 0) {
				throw new IteratorException("Start must be before end if foward is set to true!");
			}
		} else {
			if (this.start.compareTo(this.end) <= 0) {
				throw new IteratorException("Start must be after end if foward is set to false!");
			}
		}

		this.nextSpec = ModelUtil.clone(this.start);
		this.sourceSpec = ModelUtil.clone(this.start);

		updateSpecifier(sourceSpec, stepLength, !isForward());

		if (isForward()) {
			if (sourceSpec.compareTo(this.start) < 0) {
				sourceSpec.setIdentifier(this.start.getIdentifier());
			}
		} else {
			if (sourceSpec.compareTo(this.end) > 0) {
				sourceSpec.setIdentifier(this.end.getIdentifier());
			}
		}

	}

	/**
	 * @return the start
	 */
	public PrimaryVersionSpec getStart() {
		return start;
	}

	/**
	 * @return the end
	 */
	public PrimaryVersionSpec getEnd() {
		return end;
	}

	public ConnectionManager getConnectionManager() {
		return connectionManager;
	}

	public Usersession getUsersession() {
		return usersession;
	}

} // VersionIteratorImpl
