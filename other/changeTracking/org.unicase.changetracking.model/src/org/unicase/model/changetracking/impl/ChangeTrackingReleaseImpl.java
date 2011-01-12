/**
 * <copyright> Copyright (c) 2008-2009 Jonas Helming, Maximilian Koegel. All rights reserved. This program and the accompanying materials are made available under the terms of the Eclipse Public License v1.0 which accompanies this distribution, and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>
 * 
 *
 * $Id$
 */
package org.unicase.model.changetracking.impl;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

import org.unicase.model.changetracking.ChangeTrackingRelease;
import org.unicase.model.changetracking.ChangetrackingPackage;
import org.unicase.model.changetracking.RepositoryRevision;
import org.unicase.model.changetracking.Stream;

import org.unicase.model.release.impl.ReleaseImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Change Tracking Release</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.unicase.model.changetracking.impl.ChangeTrackingReleaseImpl#getStream <em>Stream</em>}</li>
 *   <li>{@link org.unicase.model.changetracking.impl.ChangeTrackingReleaseImpl#isBuilt <em>Built</em>}</li>
 *   <li>{@link org.unicase.model.changetracking.impl.ChangeTrackingReleaseImpl#getBuiltRevision <em>Built Revision</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class ChangeTrackingReleaseImpl extends ReleaseImpl implements
		ChangeTrackingRelease {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final String copyright = "<copyright> Copyright (c) 2008-2009 Jonas Helming, Maximilian Koegel. All rights reserved. This program and the accompanying materials are made available under the terms of the Eclipse Public License v1.0 which accompanies this distribution, and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>\r";

	/**
	 * The cached value of the '{@link #getStream() <em>Stream</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getStream()
	 * @generated
	 * @ordered
	 */
	protected Stream stream;

	/**
	 * The default value of the '{@link #isBuilt() <em>Built</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isBuilt()
	 * @generated
	 * @ordered
	 */
	protected static final boolean BUILT_EDEFAULT = false;

	/**
	 * The cached value of the '{@link #isBuilt() <em>Built</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isBuilt()
	 * @generated
	 * @ordered
	 */
	protected boolean built = BUILT_EDEFAULT;

	/**
	 * The cached value of the '{@link #getBuiltRevision() <em>Built Revision</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getBuiltRevision()
	 * @generated
	 * @ordered
	 */
	protected RepositoryRevision builtRevision;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected ChangeTrackingReleaseImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return ChangetrackingPackage.Literals.CHANGE_TRACKING_RELEASE;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Stream getStream() {
		if (stream != null && stream.eIsProxy()) {
			InternalEObject oldStream = (InternalEObject) stream;
			stream = (Stream) eResolveProxy(oldStream);
			if (stream != oldStream) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(
							this,
							Notification.RESOLVE,
							ChangetrackingPackage.CHANGE_TRACKING_RELEASE__STREAM,
							oldStream, stream));
			}
		}
		return stream;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Stream basicGetStream() {
		return stream;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetStream(Stream newStream,
			NotificationChain msgs) {
		Stream oldStream = stream;
		stream = newStream;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this,
					Notification.SET,
					ChangetrackingPackage.CHANGE_TRACKING_RELEASE__STREAM,
					oldStream, newStream);
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
	public void setStream(Stream newStream) {
		if (newStream != stream) {
			NotificationChain msgs = null;
			if (stream != null)
				msgs = ((InternalEObject) stream).eInverseRemove(this,
						ChangetrackingPackage.STREAM__RELEASES, Stream.class,
						msgs);
			if (newStream != null)
				msgs = ((InternalEObject) newStream).eInverseAdd(this,
						ChangetrackingPackage.STREAM__RELEASES, Stream.class,
						msgs);
			msgs = basicSetStream(newStream, msgs);
			if (msgs != null)
				msgs.dispatch();
		} else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET,
					ChangetrackingPackage.CHANGE_TRACKING_RELEASE__STREAM,
					newStream, newStream));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isBuilt() {
		return built;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setBuilt(boolean newBuilt) {
		boolean oldBuilt = built;
		built = newBuilt;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET,
					ChangetrackingPackage.CHANGE_TRACKING_RELEASE__BUILT,
					oldBuilt, built));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public RepositoryRevision getBuiltRevision() {
		if (builtRevision != null && builtRevision.eIsProxy()) {
			InternalEObject oldBuiltRevision = (InternalEObject) builtRevision;
			builtRevision = (RepositoryRevision) eResolveProxy(oldBuiltRevision);
			if (builtRevision != oldBuiltRevision) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(
							this,
							Notification.RESOLVE,
							ChangetrackingPackage.CHANGE_TRACKING_RELEASE__BUILT_REVISION,
							oldBuiltRevision, builtRevision));
			}
		}
		return builtRevision;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public RepositoryRevision basicGetBuiltRevision() {
		return builtRevision;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetBuiltRevision(
			RepositoryRevision newBuiltRevision, NotificationChain msgs) {
		RepositoryRevision oldBuiltRevision = builtRevision;
		builtRevision = newBuiltRevision;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(
					this,
					Notification.SET,
					ChangetrackingPackage.CHANGE_TRACKING_RELEASE__BUILT_REVISION,
					oldBuiltRevision, newBuiltRevision);
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
	public void setBuiltRevision(RepositoryRevision newBuiltRevision) {
		if (newBuiltRevision != builtRevision) {
			NotificationChain msgs = null;
			if (builtRevision != null)
				msgs = ((InternalEObject) builtRevision)
						.eInverseRemove(
								this,
								ChangetrackingPackage.REPOSITORY_REVISION__BUILT_WITH_RELEASES,
								RepositoryRevision.class, msgs);
			if (newBuiltRevision != null)
				msgs = ((InternalEObject) newBuiltRevision)
						.eInverseAdd(
								this,
								ChangetrackingPackage.REPOSITORY_REVISION__BUILT_WITH_RELEASES,
								RepositoryRevision.class, msgs);
			msgs = basicSetBuiltRevision(newBuiltRevision, msgs);
			if (msgs != null)
				msgs.dispatch();
		} else if (eNotificationRequired())
			eNotify(new ENotificationImpl(
					this,
					Notification.SET,
					ChangetrackingPackage.CHANGE_TRACKING_RELEASE__BUILT_REVISION,
					newBuiltRevision, newBuiltRevision));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseAdd(InternalEObject otherEnd,
			int featureID, NotificationChain msgs) {
		switch (featureID) {
		case ChangetrackingPackage.CHANGE_TRACKING_RELEASE__STREAM:
			if (stream != null)
				msgs = ((InternalEObject) stream).eInverseRemove(this,
						ChangetrackingPackage.STREAM__RELEASES, Stream.class,
						msgs);
			return basicSetStream((Stream) otherEnd, msgs);
		case ChangetrackingPackage.CHANGE_TRACKING_RELEASE__BUILT_REVISION:
			if (builtRevision != null)
				msgs = ((InternalEObject) builtRevision)
						.eInverseRemove(
								this,
								ChangetrackingPackage.REPOSITORY_REVISION__BUILT_WITH_RELEASES,
								RepositoryRevision.class, msgs);
			return basicSetBuiltRevision((RepositoryRevision) otherEnd, msgs);
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
		case ChangetrackingPackage.CHANGE_TRACKING_RELEASE__STREAM:
			return basicSetStream(null, msgs);
		case ChangetrackingPackage.CHANGE_TRACKING_RELEASE__BUILT_REVISION:
			return basicSetBuiltRevision(null, msgs);
		}
		return super.eInverseRemove(otherEnd, featureID, msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
		case ChangetrackingPackage.CHANGE_TRACKING_RELEASE__STREAM:
			if (resolve)
				return getStream();
			return basicGetStream();
		case ChangetrackingPackage.CHANGE_TRACKING_RELEASE__BUILT:
			return isBuilt();
		case ChangetrackingPackage.CHANGE_TRACKING_RELEASE__BUILT_REVISION:
			if (resolve)
				return getBuiltRevision();
			return basicGetBuiltRevision();
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
		case ChangetrackingPackage.CHANGE_TRACKING_RELEASE__STREAM:
			setStream((Stream) newValue);
			return;
		case ChangetrackingPackage.CHANGE_TRACKING_RELEASE__BUILT:
			setBuilt((Boolean) newValue);
			return;
		case ChangetrackingPackage.CHANGE_TRACKING_RELEASE__BUILT_REVISION:
			setBuiltRevision((RepositoryRevision) newValue);
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
		case ChangetrackingPackage.CHANGE_TRACKING_RELEASE__STREAM:
			setStream((Stream) null);
			return;
		case ChangetrackingPackage.CHANGE_TRACKING_RELEASE__BUILT:
			setBuilt(BUILT_EDEFAULT);
			return;
		case ChangetrackingPackage.CHANGE_TRACKING_RELEASE__BUILT_REVISION:
			setBuiltRevision((RepositoryRevision) null);
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
		case ChangetrackingPackage.CHANGE_TRACKING_RELEASE__STREAM:
			return stream != null;
		case ChangetrackingPackage.CHANGE_TRACKING_RELEASE__BUILT:
			return built != BUILT_EDEFAULT;
		case ChangetrackingPackage.CHANGE_TRACKING_RELEASE__BUILT_REVISION:
			return builtRevision != null;
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
		if (eIsProxy())
			return super.toString();

		StringBuffer result = new StringBuffer(super.toString());
		result.append(" (built: ");
		result.append(built);
		result.append(')');
		return result.toString();
	}

} //ChangeTrackingReleaseImpl
