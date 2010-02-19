/**
 * <copyright> Copyright (c) 2008-2009 Jonas Helming, Maximilian Koegel. All rights reserved. This program and the
 * accompanying materials are made available under the terms of the Eclipse Public License v1.0 which accompanies this
 * distribution, and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>
 */
package org.unicase.analyzer.iterator.impl;

import java.util.Calendar;
import java.util.Date;
import java.util.List;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.unicase.analyzer.exceptions.IteratorException;
import org.unicase.analyzer.iterator.IteratorPackage;
import org.unicase.analyzer.iterator.TimeIterator;
import org.unicase.analyzer.iterator.VersionSpecQuery;
import org.unicase.emfstore.esmodel.ProjectId;
import org.unicase.emfstore.esmodel.versioning.DateVersionSpec;
import org.unicase.emfstore.esmodel.versioning.HistoryInfo;
import org.unicase.emfstore.esmodel.versioning.HistoryQuery;
import org.unicase.emfstore.esmodel.versioning.PrimaryVersionSpec;
import org.unicase.emfstore.esmodel.versioning.VersionSpec;
import org.unicase.emfstore.esmodel.versioning.VersioningFactory;
import org.unicase.emfstore.exceptions.EmfStoreException;
import org.unicase.emfstore.exceptions.InvalidVersionSpecException;
import org.unicase.workspace.Usersession;
import org.unicase.workspace.util.WorkspaceUtil;

/**
 * <!-- begin-user-doc --> An implementation of the model object '<em><b>Time Iterator</b></em>'. <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 * <li>{@link org.unicase.analyzer.iterator.impl.TimeIteratorImpl#getStartDate <em>Start Date</em>}</li>
 * <li>{@link org.unicase.analyzer.iterator.impl.TimeIteratorImpl#getEndDate <em>End Date</em>}</li>
 * <li>{@link org.unicase.analyzer.iterator.impl.TimeIteratorImpl#getStepLengthUnit <em>Step Length Unit</em>}</li>
 * </ul>
 * </p>
 * 
 * @generated
 */
public class TimeIteratorImpl extends VersionIteratorImpl implements TimeIterator {
	/**
	 * The default value of the '{@link #getStartDate() <em>Start Date</em>}' attribute. <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * 
	 * @see #getStartDate()
	 * @generated
	 * @ordered
	 */
	protected static final Date START_DATE_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getStartDate() <em>Start Date</em>}' attribute. <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * 
	 * @see #getStartDate()
	 * @generated
	 * @ordered
	 */
	protected Date startDate = START_DATE_EDEFAULT;

	/**
	 * The default value of the '{@link #getEndDate() <em>End Date</em>}' attribute. <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * 
	 * @see #getEndDate()
	 * @generated
	 * @ordered
	 */
	protected static final Date END_DATE_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getEndDate() <em>End Date</em>}' attribute. <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * 
	 * @see #getEndDate()
	 * @generated
	 * @ordered
	 */
	protected Date endDate = END_DATE_EDEFAULT;

	/**
	 * The default value of the '{@link #getStepLengthUnit() <em>Step Length Unit</em>}' attribute. <!-- begin-user-doc
	 * --> <!-- end-user-doc -->
	 * 
	 * @see #getStepLengthUnit()
	 * @generated
	 * @ordered
	 */
	protected static final int STEP_LENGTH_UNIT_EDEFAULT = 1;

	/**
	 * The cached value of the '{@link #getStepLengthUnit() <em>Step Length Unit</em>}' attribute. <!-- begin-user-doc
	 * --> <!-- end-user-doc -->
	 * 
	 * @see #getStepLengthUnit()
	 * @generated
	 * @ordered
	 */
	protected int stepLengthUnit = STEP_LENGTH_UNIT_EDEFAULT;

	private DateVersionSpec dateSpec;

	private DateVersionSpec endDateSpec;

	private DateVersionSpec startDataSpec;

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	protected TimeIteratorImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return IteratorPackage.Literals.TIME_ITERATOR;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public Date getStartDate() {
		return startDate;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public void setStartDate(Date newStartDate) {
		Date oldStartDate = startDate;
		startDate = newStartDate;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, IteratorPackage.TIME_ITERATOR__START_DATE,
				oldStartDate, startDate));
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public Date getEndDate() {
		return endDate;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public void setEndDate(Date newEndDate) {
		Date oldEndDate = endDate;
		endDate = newEndDate;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, IteratorPackage.TIME_ITERATOR__END_DATE, oldEndDate,
				endDate));
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public int getStepLengthUnit() {
		return stepLengthUnit;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public void setStepLengthUnit(int newStepLengthUnit) {
		int oldStepLengthUnit = stepLengthUnit;
		stepLengthUnit = newStepLengthUnit;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, IteratorPackage.TIME_ITERATOR__STEP_LENGTH_UNIT,
				oldStepLengthUnit, stepLengthUnit));
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
		case IteratorPackage.TIME_ITERATOR__START_DATE:
			return getStartDate();
		case IteratorPackage.TIME_ITERATOR__END_DATE:
			return getEndDate();
		case IteratorPackage.TIME_ITERATOR__STEP_LENGTH_UNIT:
			return getStepLengthUnit();
		}
		return super.eGet(featureID, resolve, coreType);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public void eSet(int featureID, Object newValue) {
		switch (featureID) {
		case IteratorPackage.TIME_ITERATOR__START_DATE:
			setStartDate((Date) newValue);
			return;
		case IteratorPackage.TIME_ITERATOR__END_DATE:
			setEndDate((Date) newValue);
			return;
		case IteratorPackage.TIME_ITERATOR__STEP_LENGTH_UNIT:
			setStepLengthUnit((Integer) newValue);
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
		case IteratorPackage.TIME_ITERATOR__START_DATE:
			setStartDate(START_DATE_EDEFAULT);
			return;
		case IteratorPackage.TIME_ITERATOR__END_DATE:
			setEndDate(END_DATE_EDEFAULT);
			return;
		case IteratorPackage.TIME_ITERATOR__STEP_LENGTH_UNIT:
			setStepLengthUnit(STEP_LENGTH_UNIT_EDEFAULT);
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
		case IteratorPackage.TIME_ITERATOR__START_DATE:
			return START_DATE_EDEFAULT == null ? startDate != null : !START_DATE_EDEFAULT.equals(startDate);
		case IteratorPackage.TIME_ITERATOR__END_DATE:
			return END_DATE_EDEFAULT == null ? endDate != null : !END_DATE_EDEFAULT.equals(endDate);
		case IteratorPackage.TIME_ITERATOR__STEP_LENGTH_UNIT:
			return stepLengthUnit != STEP_LENGTH_UNIT_EDEFAULT;
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
		result.append(" (startDate: ");
		result.append(startDate);
		result.append(", endDate: ");
		result.append(endDate);
		result.append(", stepLengthUnit: ");
		result.append(stepLengthUnit);
		result.append(')');
		return result.toString();
	}

	@Override
	protected void updateSpecifier(PrimaryVersionSpec specifier, int stepLength, boolean isForward) {

		if (dateSpec != null) {
			Calendar calendar = Calendar.getInstance();
			calendar.setTime(dateSpec.getDate());

			if (isForward) {
				calendar.add(stepLengthUnit, stepLength);
			} else {
				calendar.add(stepLengthUnit, -stepLength);
			}
			dateSpec.setDate(calendar.getTime());
			try {
				PrimaryVersionSpec temp = this.getConnectionManager().resolveVersionSpec(
					getUsersession().getSessionId(), getProjectId(), dateSpec);
				specifier.setIdentifier(temp.getIdentifier());
			} catch (EmfStoreException e) {
				WorkspaceUtil.logException("Couldn't be resolved", e);
			}
		}
	}

	public void init(Usersession usersession, ProjectId projectId, int stepLength, int stepLengthUnit,
		VersionSpecQuery versionSpecQuery, boolean isForward, boolean returnProjectDataCopy) throws IteratorException {

		setForward(isForward);
		setProjectId(projectId);
		setReturnProjectDataCopy(returnProjectDataCopy);
		setStepLength(stepLengthUnit);
		setStepLengthUnit(stepLengthUnit);
		setVersionSpecQuery(versionSpecQuery);

		this.init(usersession);

	}

	private void defaultSet() {
		VersionSpecQuery versionSpecQuery = IteratorFactoryImpl.eINSTANCE.createVersionSpecQuery();
		versionSpecQuery.setStartVersion(VersioningFactory.eINSTANCE.createPrimaryVersionSpec());
		versionSpecQuery.setEndVersion(VersioningFactory.eINSTANCE.createHeadVersionSpec());
		setVersionSpecQuery(versionSpecQuery);
		setReturnProjectDataCopy(true);

		setForward(true);
	}

	public void init(Usersession usersession, ProjectId projectId, int stepLength, int stepLengthUnit)
		throws IteratorException {

		setProjectId(projectId);
		setStepLength(stepLength);
		setStepLengthUnit(stepLengthUnit);

		defaultSet();

		this.init(usersession);
	}

	@Override
	public void init(Usersession usersession) throws IteratorException {
		super.init(usersession);
		VersionSpec start = getVersionSpecQuery().getStartVersion();
		VersionSpec end = getVersionSpecQuery().getEndVersion();

		this.dateSpec = VersioningFactory.eINSTANCE.createDateVersionSpec();
		this.startDataSpec = VersioningFactory.eINSTANCE.createDateVersionSpec();
		this.endDateSpec = VersioningFactory.eINSTANCE.createDateVersionSpec();

		if (start instanceof DateVersionSpec && end instanceof DateVersionSpec) {
			this.dateSpec = (DateVersionSpec) start;
			this.startDataSpec = (DateVersionSpec) start;
			this.endDateSpec = (DateVersionSpec) end;
		} else {
			HistoryQuery historyQuery = VersioningFactory.eINSTANCE.createHistoryQuery();
			historyQuery.setSource(this.getStart());
			historyQuery.setTarget(this.getEnd());
			List<HistoryInfo> projectHistory = null;
			try {
				projectHistory = this.getConnectionManager().getHistoryInfo(usersession.getSessionId(), projectId,
					historyQuery);
			} catch (InvalidVersionSpecException e) {
				throw new IteratorException("Could not get the history info.", e);
			} catch (EmfStoreException e) {
				throw new IteratorException("Cannot connect to server.", e);
			}
			setStartDate(projectHistory.get(projectHistory.size() - 1).getLogMessage().getDate());
			if (getStartDate() == null) {
				setStartDate(projectHistory.get(projectHistory.size() - 1).getLogMessage().getClientDate());
			}
			setEndDate(projectHistory.get(0).getLogMessage().getDate());
			if (getEndDate() == null) {
				setEndDate(projectHistory.get(0).getLogMessage().getClientDate());
			}
			this.dateSpec.setDate(getStartDate());
			this.endDateSpec.setDate(getEndDate());
		}

		updateSpecifier(getSourceSpec(), stepLength, !isForward());

		if (isForward()) {
			if (getSourceSpec().compareTo(this.getStart()) < 0) {
				getSourceSpec().setIdentifier(this.getStart().getIdentifier());
			}
		} else {
			if (getSourceSpec().compareTo(this.getEnd()) > 0) {
				getSourceSpec().setIdentifier(this.getEnd().getIdentifier());
			}
		}
	}

	@Override
	public boolean hasNext() {
		if (super.hasNext()) {
			if (isForward()) {
				return dateSpec.getDate().before(endDateSpec.getDate());
			} else {
				return dateSpec.getDate().after(endDateSpec.getDate());
			}
		} else {
			return false;
		}
	}

	/**
	 * @return the endDateSpec
	 */
	public DateVersionSpec getEndDateSpec() {
		return endDateSpec;
	}

	/**
	 * @param endDateSpec the endDateSpec to set
	 */
	public void setEndDateSpec(DateVersionSpec endDateSpec) {
		this.endDateSpec = endDateSpec;
	}

	/**
	 * @return the startDataSpec
	 */
	public DateVersionSpec getStartDataSpec() {
		return startDataSpec;
	}

	/**
	 * @param startDataSpec the startDataSpec to set
	 */
	public void setStartDataSpec(DateVersionSpec startDataSpec) {
		this.startDataSpec = startDataSpec;
	}

	@Override
	public int getTotalSteps() {

		try {
			PrimaryVersionSpec start = this.getConnectionManager().resolveVersionSpec(getUsersession().getSessionId(),
				getProjectId(), startDataSpec);
			PrimaryVersionSpec end = this.getConnectionManager().resolveVersionSpec(getUsersession().getSessionId(),
				getProjectId(), endDateSpec);

			return end.getIdentifier() - start.getIdentifier();
		} catch (EmfStoreException e) {
			WorkspaceUtil.logException("Can not resolve the version spec", e);
		}
		return 0;

	}

} // TimeIteratorImpl
