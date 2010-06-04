/**
 * <copyright> Copyright (c) 2008-2009 Jonas Helming, Maximilian Koegel. All rights reserved. This program and the
 * accompanying materials are made available under the terms of the Eclipse Public License v1.0 which accompanies this
 * distribution, and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>
 * 
 *
 * $Id$
 */
package org.unicase.model.emailbundle.impl;

import java.util.Collection;
import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

import org.eclipse.emf.ecore.impl.EObjectImpl;
import org.eclipse.emf.ecore.util.EDataTypeUniqueEList;
import org.unicase.model.emailbundle.Bundle;
import org.unicase.model.emailbundle.EmailbundlePackage;

import org.unicase.model.impl.UnicaseModelElementImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Bundle</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.unicase.model.emailbundle.impl.BundleImpl#getBundleName <em>Bundle Name</em>}</li>
 *   <li>{@link org.unicase.model.emailbundle.impl.BundleImpl#isCommentProvider <em>Comment Provider</em>}</li>
 *   <li>{@link org.unicase.model.emailbundle.impl.BundleImpl#isSubscriptionsProvider <em>Subscriptions Provider</em>}</li>
 *   <li>{@link org.unicase.model.emailbundle.impl.BundleImpl#isTaskChangeProvider <em>Task Change Provider</em>}</li>
 *   <li>{@link org.unicase.model.emailbundle.impl.BundleImpl#isTaskProvider <em>Task Provider</em>}</li>
 *   <li>{@link org.unicase.model.emailbundle.impl.BundleImpl#isTaskReviewProvider <em>Task Review Provider</em>}</li>
 *   <li>{@link org.unicase.model.emailbundle.impl.BundleImpl#isTaskTraceProvider <em>Task Trace Provider</em>}</li>
 *   <li>{@link org.unicase.model.emailbundle.impl.BundleImpl#isImmediately <em>Immediately</em>}</li>
 *   <li>{@link org.unicase.model.emailbundle.impl.BundleImpl#isAggregated <em>Aggregated</em>}</li>
 *   <li>{@link org.unicase.model.emailbundle.impl.BundleImpl#isDays <em>Days</em>}</li>
 *   <li>{@link org.unicase.model.emailbundle.impl.BundleImpl#getDaysCount <em>Days Count</em>}</li>
 *   <li>{@link org.unicase.model.emailbundle.impl.BundleImpl#isWeekday <em>Weekday</em>}</li>
 *   <li>{@link org.unicase.model.emailbundle.impl.BundleImpl#getWeekdayIndex <em>Weekday Index</em>}</li>
 *   <li>{@link org.unicase.model.emailbundle.impl.BundleImpl#getProviders <em>Providers</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class BundleImpl extends EObjectImpl implements Bundle {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final String copyright = "<copyright> Copyright (c) 2008-2009 Jonas Helming, Maximilian Koegel. All rights reserved. This program and the\naccompanying materials are made available under the terms of the Eclipse Public License v1.0 which accompanies this\ndistribution, and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>\n";

	/**
	 * The default value of the '{@link #getBundleName() <em>Bundle Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getBundleName()
	 * @generated
	 * @ordered
	 */
	protected static final String BUNDLE_NAME_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getBundleName() <em>Bundle Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getBundleName()
	 * @generated
	 * @ordered
	 */
	protected String bundleName = BUNDLE_NAME_EDEFAULT;

	/**
	 * The default value of the '{@link #isCommentProvider() <em>Comment Provider</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isCommentProvider()
	 * @generated
	 * @ordered
	 */
	protected static final boolean COMMENT_PROVIDER_EDEFAULT = false;

	/**
	 * The cached value of the '{@link #isCommentProvider() <em>Comment Provider</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isCommentProvider()
	 * @generated
	 * @ordered
	 */
	protected boolean commentProvider = COMMENT_PROVIDER_EDEFAULT;

	/**
	 * The default value of the '{@link #isSubscriptionsProvider() <em>Subscriptions Provider</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isSubscriptionsProvider()
	 * @generated
	 * @ordered
	 */
	protected static final boolean SUBSCRIPTIONS_PROVIDER_EDEFAULT = false;

	/**
	 * The cached value of the '{@link #isSubscriptionsProvider() <em>Subscriptions Provider</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isSubscriptionsProvider()
	 * @generated
	 * @ordered
	 */
	protected boolean subscriptionsProvider = SUBSCRIPTIONS_PROVIDER_EDEFAULT;

	/**
	 * The default value of the '{@link #isTaskChangeProvider() <em>Task Change Provider</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isTaskChangeProvider()
	 * @generated
	 * @ordered
	 */
	protected static final boolean TASK_CHANGE_PROVIDER_EDEFAULT = false;

	/**
	 * The cached value of the '{@link #isTaskChangeProvider() <em>Task Change Provider</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isTaskChangeProvider()
	 * @generated
	 * @ordered
	 */
	protected boolean taskChangeProvider = TASK_CHANGE_PROVIDER_EDEFAULT;

	/**
	 * The default value of the '{@link #isTaskProvider() <em>Task Provider</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isTaskProvider()
	 * @generated
	 * @ordered
	 */
	protected static final boolean TASK_PROVIDER_EDEFAULT = false;

	/**
	 * The cached value of the '{@link #isTaskProvider() <em>Task Provider</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isTaskProvider()
	 * @generated
	 * @ordered
	 */
	protected boolean taskProvider = TASK_PROVIDER_EDEFAULT;

	/**
	 * The default value of the '{@link #isTaskReviewProvider() <em>Task Review Provider</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isTaskReviewProvider()
	 * @generated
	 * @ordered
	 */
	protected static final boolean TASK_REVIEW_PROVIDER_EDEFAULT = false;

	/**
	 * The cached value of the '{@link #isTaskReviewProvider() <em>Task Review Provider</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isTaskReviewProvider()
	 * @generated
	 * @ordered
	 */
	protected boolean taskReviewProvider = TASK_REVIEW_PROVIDER_EDEFAULT;

	/**
	 * The default value of the '{@link #isTaskTraceProvider() <em>Task Trace Provider</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isTaskTraceProvider()
	 * @generated
	 * @ordered
	 */
	protected static final boolean TASK_TRACE_PROVIDER_EDEFAULT = false;

	/**
	 * The cached value of the '{@link #isTaskTraceProvider() <em>Task Trace Provider</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isTaskTraceProvider()
	 * @generated
	 * @ordered
	 */
	protected boolean taskTraceProvider = TASK_TRACE_PROVIDER_EDEFAULT;

	/**
	 * The default value of the '{@link #isImmediately() <em>Immediately</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isImmediately()
	 * @generated
	 * @ordered
	 */
	protected static final boolean IMMEDIATELY_EDEFAULT = false;

	/**
	 * The cached value of the '{@link #isImmediately() <em>Immediately</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isImmediately()
	 * @generated
	 * @ordered
	 */
	protected boolean immediately = IMMEDIATELY_EDEFAULT;

	/**
	 * The default value of the '{@link #isAggregated() <em>Aggregated</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isAggregated()
	 * @generated
	 * @ordered
	 */
	protected static final boolean AGGREGATED_EDEFAULT = false;

	/**
	 * The cached value of the '{@link #isAggregated() <em>Aggregated</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isAggregated()
	 * @generated
	 * @ordered
	 */
	protected boolean aggregated = AGGREGATED_EDEFAULT;

	/**
	 * The default value of the '{@link #isDays() <em>Days</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isDays()
	 * @generated
	 * @ordered
	 */
	protected static final boolean DAYS_EDEFAULT = false;

	/**
	 * The cached value of the '{@link #isDays() <em>Days</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isDays()
	 * @generated
	 * @ordered
	 */
	protected boolean days = DAYS_EDEFAULT;

	/**
	 * The default value of the '{@link #getDaysCount() <em>Days Count</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getDaysCount()
	 * @generated
	 * @ordered
	 */
	protected static final int DAYS_COUNT_EDEFAULT = 0;

	/**
	 * The cached value of the '{@link #getDaysCount() <em>Days Count</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getDaysCount()
	 * @generated
	 * @ordered
	 */
	protected int daysCount = DAYS_COUNT_EDEFAULT;

	/**
	 * The default value of the '{@link #isWeekday() <em>Weekday</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isWeekday()
	 * @generated
	 * @ordered
	 */
	protected static final boolean WEEKDAY_EDEFAULT = false;

	/**
	 * The cached value of the '{@link #isWeekday() <em>Weekday</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isWeekday()
	 * @generated
	 * @ordered
	 */
	protected boolean weekday = WEEKDAY_EDEFAULT;

	/**
	 * The default value of the '{@link #getWeekdayIndex() <em>Weekday Index</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getWeekdayIndex()
	 * @generated
	 * @ordered
	 */
	protected static final int WEEKDAY_INDEX_EDEFAULT = 0;

	/**
	 * The cached value of the '{@link #getWeekdayIndex() <em>Weekday Index</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getWeekdayIndex()
	 * @generated
	 * @ordered
	 */
	protected int weekdayIndex = WEEKDAY_INDEX_EDEFAULT;

	/**
	 * The cached value of the '{@link #getProviders() <em>Providers</em>}' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getProviders()
	 * @generated
	 * @ordered
	 */
	protected EList<Object> providers;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected BundleImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return EmailbundlePackage.Literals.BUNDLE;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getBundleName() {
		return bundleName;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setBundleName(String newBundleName) {
		String oldBundleName = bundleName;
		bundleName = newBundleName;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, EmailbundlePackage.BUNDLE__BUNDLE_NAME, oldBundleName, bundleName));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isCommentProvider() {
		return commentProvider;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setCommentProvider(boolean newCommentProvider) {
		boolean oldCommentProvider = commentProvider;
		commentProvider = newCommentProvider;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, EmailbundlePackage.BUNDLE__COMMENT_PROVIDER, oldCommentProvider, commentProvider));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isSubscriptionsProvider() {
		return subscriptionsProvider;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setSubscriptionsProvider(boolean newSubscriptionsProvider) {
		boolean oldSubscriptionsProvider = subscriptionsProvider;
		subscriptionsProvider = newSubscriptionsProvider;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, EmailbundlePackage.BUNDLE__SUBSCRIPTIONS_PROVIDER, oldSubscriptionsProvider, subscriptionsProvider));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isTaskChangeProvider() {
		return taskChangeProvider;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setTaskChangeProvider(boolean newTaskChangeProvider) {
		boolean oldTaskChangeProvider = taskChangeProvider;
		taskChangeProvider = newTaskChangeProvider;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, EmailbundlePackage.BUNDLE__TASK_CHANGE_PROVIDER, oldTaskChangeProvider, taskChangeProvider));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isTaskProvider() {
		return taskProvider;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setTaskProvider(boolean newTaskProvider) {
		boolean oldTaskProvider = taskProvider;
		taskProvider = newTaskProvider;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, EmailbundlePackage.BUNDLE__TASK_PROVIDER, oldTaskProvider, taskProvider));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isTaskReviewProvider() {
		return taskReviewProvider;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setTaskReviewProvider(boolean newTaskReviewProvider) {
		boolean oldTaskReviewProvider = taskReviewProvider;
		taskReviewProvider = newTaskReviewProvider;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, EmailbundlePackage.BUNDLE__TASK_REVIEW_PROVIDER, oldTaskReviewProvider, taskReviewProvider));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isTaskTraceProvider() {
		return taskTraceProvider;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setTaskTraceProvider(boolean newTaskTraceProvider) {
		boolean oldTaskTraceProvider = taskTraceProvider;
		taskTraceProvider = newTaskTraceProvider;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, EmailbundlePackage.BUNDLE__TASK_TRACE_PROVIDER, oldTaskTraceProvider, taskTraceProvider));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isImmediately() {
		return immediately;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setImmediately(boolean newImmediately) {
		boolean oldImmediately = immediately;
		immediately = newImmediately;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, EmailbundlePackage.BUNDLE__IMMEDIATELY, oldImmediately, immediately));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isAggregated() {
		return aggregated;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setAggregated(boolean newAggregated) {
		boolean oldAggregated = aggregated;
		aggregated = newAggregated;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, EmailbundlePackage.BUNDLE__AGGREGATED, oldAggregated, aggregated));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isDays() {
		return days;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setDays(boolean newDays) {
		boolean oldDays = days;
		days = newDays;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, EmailbundlePackage.BUNDLE__DAYS, oldDays, days));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public int getDaysCount() {
		return daysCount;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setDaysCount(int newDaysCount) {
		int oldDaysCount = daysCount;
		daysCount = newDaysCount;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, EmailbundlePackage.BUNDLE__DAYS_COUNT, oldDaysCount, daysCount));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isWeekday() {
		return weekday;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setWeekday(boolean newWeekday) {
		boolean oldWeekday = weekday;
		weekday = newWeekday;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, EmailbundlePackage.BUNDLE__WEEKDAY, oldWeekday, weekday));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public int getWeekdayIndex() {
		return weekdayIndex;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setWeekdayIndex(int newWeekdayIndex) {
		int oldWeekdayIndex = weekdayIndex;
		weekdayIndex = newWeekdayIndex;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, EmailbundlePackage.BUNDLE__WEEKDAY_INDEX, oldWeekdayIndex, weekdayIndex));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<Object> getProviders() {
		if (providers == null) {
			providers = new EDataTypeUniqueEList<Object>(Object.class, this, EmailbundlePackage.BUNDLE__PROVIDERS);
		}
		return providers;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case EmailbundlePackage.BUNDLE__BUNDLE_NAME:
				return getBundleName();
			case EmailbundlePackage.BUNDLE__COMMENT_PROVIDER:
				return isCommentProvider();
			case EmailbundlePackage.BUNDLE__SUBSCRIPTIONS_PROVIDER:
				return isSubscriptionsProvider();
			case EmailbundlePackage.BUNDLE__TASK_CHANGE_PROVIDER:
				return isTaskChangeProvider();
			case EmailbundlePackage.BUNDLE__TASK_PROVIDER:
				return isTaskProvider();
			case EmailbundlePackage.BUNDLE__TASK_REVIEW_PROVIDER:
				return isTaskReviewProvider();
			case EmailbundlePackage.BUNDLE__TASK_TRACE_PROVIDER:
				return isTaskTraceProvider();
			case EmailbundlePackage.BUNDLE__IMMEDIATELY:
				return isImmediately();
			case EmailbundlePackage.BUNDLE__AGGREGATED:
				return isAggregated();
			case EmailbundlePackage.BUNDLE__DAYS:
				return isDays();
			case EmailbundlePackage.BUNDLE__DAYS_COUNT:
				return getDaysCount();
			case EmailbundlePackage.BUNDLE__WEEKDAY:
				return isWeekday();
			case EmailbundlePackage.BUNDLE__WEEKDAY_INDEX:
				return getWeekdayIndex();
			case EmailbundlePackage.BUNDLE__PROVIDERS:
				return getProviders();
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
			case EmailbundlePackage.BUNDLE__BUNDLE_NAME:
				setBundleName((String)newValue);
				return;
			case EmailbundlePackage.BUNDLE__COMMENT_PROVIDER:
				setCommentProvider((Boolean)newValue);
				return;
			case EmailbundlePackage.BUNDLE__SUBSCRIPTIONS_PROVIDER:
				setSubscriptionsProvider((Boolean)newValue);
				return;
			case EmailbundlePackage.BUNDLE__TASK_CHANGE_PROVIDER:
				setTaskChangeProvider((Boolean)newValue);
				return;
			case EmailbundlePackage.BUNDLE__TASK_PROVIDER:
				setTaskProvider((Boolean)newValue);
				return;
			case EmailbundlePackage.BUNDLE__TASK_REVIEW_PROVIDER:
				setTaskReviewProvider((Boolean)newValue);
				return;
			case EmailbundlePackage.BUNDLE__TASK_TRACE_PROVIDER:
				setTaskTraceProvider((Boolean)newValue);
				return;
			case EmailbundlePackage.BUNDLE__IMMEDIATELY:
				setImmediately((Boolean)newValue);
				return;
			case EmailbundlePackage.BUNDLE__AGGREGATED:
				setAggregated((Boolean)newValue);
				return;
			case EmailbundlePackage.BUNDLE__DAYS:
				setDays((Boolean)newValue);
				return;
			case EmailbundlePackage.BUNDLE__DAYS_COUNT:
				setDaysCount((Integer)newValue);
				return;
			case EmailbundlePackage.BUNDLE__WEEKDAY:
				setWeekday((Boolean)newValue);
				return;
			case EmailbundlePackage.BUNDLE__WEEKDAY_INDEX:
				setWeekdayIndex((Integer)newValue);
				return;
			case EmailbundlePackage.BUNDLE__PROVIDERS:
				getProviders().clear();
				getProviders().addAll((Collection<? extends Object>)newValue);
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
			case EmailbundlePackage.BUNDLE__BUNDLE_NAME:
				setBundleName(BUNDLE_NAME_EDEFAULT);
				return;
			case EmailbundlePackage.BUNDLE__COMMENT_PROVIDER:
				setCommentProvider(COMMENT_PROVIDER_EDEFAULT);
				return;
			case EmailbundlePackage.BUNDLE__SUBSCRIPTIONS_PROVIDER:
				setSubscriptionsProvider(SUBSCRIPTIONS_PROVIDER_EDEFAULT);
				return;
			case EmailbundlePackage.BUNDLE__TASK_CHANGE_PROVIDER:
				setTaskChangeProvider(TASK_CHANGE_PROVIDER_EDEFAULT);
				return;
			case EmailbundlePackage.BUNDLE__TASK_PROVIDER:
				setTaskProvider(TASK_PROVIDER_EDEFAULT);
				return;
			case EmailbundlePackage.BUNDLE__TASK_REVIEW_PROVIDER:
				setTaskReviewProvider(TASK_REVIEW_PROVIDER_EDEFAULT);
				return;
			case EmailbundlePackage.BUNDLE__TASK_TRACE_PROVIDER:
				setTaskTraceProvider(TASK_TRACE_PROVIDER_EDEFAULT);
				return;
			case EmailbundlePackage.BUNDLE__IMMEDIATELY:
				setImmediately(IMMEDIATELY_EDEFAULT);
				return;
			case EmailbundlePackage.BUNDLE__AGGREGATED:
				setAggregated(AGGREGATED_EDEFAULT);
				return;
			case EmailbundlePackage.BUNDLE__DAYS:
				setDays(DAYS_EDEFAULT);
				return;
			case EmailbundlePackage.BUNDLE__DAYS_COUNT:
				setDaysCount(DAYS_COUNT_EDEFAULT);
				return;
			case EmailbundlePackage.BUNDLE__WEEKDAY:
				setWeekday(WEEKDAY_EDEFAULT);
				return;
			case EmailbundlePackage.BUNDLE__WEEKDAY_INDEX:
				setWeekdayIndex(WEEKDAY_INDEX_EDEFAULT);
				return;
			case EmailbundlePackage.BUNDLE__PROVIDERS:
				getProviders().clear();
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
			case EmailbundlePackage.BUNDLE__BUNDLE_NAME:
				return BUNDLE_NAME_EDEFAULT == null ? bundleName != null : !BUNDLE_NAME_EDEFAULT.equals(bundleName);
			case EmailbundlePackage.BUNDLE__COMMENT_PROVIDER:
				return commentProvider != COMMENT_PROVIDER_EDEFAULT;
			case EmailbundlePackage.BUNDLE__SUBSCRIPTIONS_PROVIDER:
				return subscriptionsProvider != SUBSCRIPTIONS_PROVIDER_EDEFAULT;
			case EmailbundlePackage.BUNDLE__TASK_CHANGE_PROVIDER:
				return taskChangeProvider != TASK_CHANGE_PROVIDER_EDEFAULT;
			case EmailbundlePackage.BUNDLE__TASK_PROVIDER:
				return taskProvider != TASK_PROVIDER_EDEFAULT;
			case EmailbundlePackage.BUNDLE__TASK_REVIEW_PROVIDER:
				return taskReviewProvider != TASK_REVIEW_PROVIDER_EDEFAULT;
			case EmailbundlePackage.BUNDLE__TASK_TRACE_PROVIDER:
				return taskTraceProvider != TASK_TRACE_PROVIDER_EDEFAULT;
			case EmailbundlePackage.BUNDLE__IMMEDIATELY:
				return immediately != IMMEDIATELY_EDEFAULT;
			case EmailbundlePackage.BUNDLE__AGGREGATED:
				return aggregated != AGGREGATED_EDEFAULT;
			case EmailbundlePackage.BUNDLE__DAYS:
				return days != DAYS_EDEFAULT;
			case EmailbundlePackage.BUNDLE__DAYS_COUNT:
				return daysCount != DAYS_COUNT_EDEFAULT;
			case EmailbundlePackage.BUNDLE__WEEKDAY:
				return weekday != WEEKDAY_EDEFAULT;
			case EmailbundlePackage.BUNDLE__WEEKDAY_INDEX:
				return weekdayIndex != WEEKDAY_INDEX_EDEFAULT;
			case EmailbundlePackage.BUNDLE__PROVIDERS:
				return providers != null && !providers.isEmpty();
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
		result.append(" (BundleName: ");
		result.append(bundleName);
		result.append(", CommentProvider: ");
		result.append(commentProvider);
		result.append(", SubscriptionsProvider: ");
		result.append(subscriptionsProvider);
		result.append(", TaskChangeProvider: ");
		result.append(taskChangeProvider);
		result.append(", TaskProvider: ");
		result.append(taskProvider);
		result.append(", TaskReviewProvider: ");
		result.append(taskReviewProvider);
		result.append(", TaskTraceProvider: ");
		result.append(taskTraceProvider);
		result.append(", Immediately: ");
		result.append(immediately);
		result.append(", Aggregated: ");
		result.append(aggregated);
		result.append(", Days: ");
		result.append(days);
		result.append(", DaysCount: ");
		result.append(daysCount);
		result.append(", Weekday: ");
		result.append(weekday);
		result.append(", WeekdayIndex: ");
		result.append(weekdayIndex);
		result.append(", Providers: ");
		result.append(providers);
		result.append(')');
		return result.toString();
	}

} //BundleImpl
