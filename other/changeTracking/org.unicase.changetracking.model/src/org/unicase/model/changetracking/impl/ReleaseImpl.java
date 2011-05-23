/**
 * <copyright> Copyright (c) 2008-2009 Jonas Helming, Maximilian Koegel. All rights reserved. This program and the accompanying materials are made available under the terms of the Eclipse Public License v1.0 which accompanies this distribution, and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>
 * 
 */
package org.unicase.model.changetracking.impl;

import java.util.Date;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

import org.unicase.model.changetracking.ChangetrackingPackage;
import org.unicase.model.changetracking.Release;
import org.unicase.model.changetracking.RepositoryRevision;
import org.unicase.model.changetracking.Stream;

import org.unicase.model.release.impl.AbstractReleaseImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Release</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.unicase.model.changetracking.impl.ReleaseImpl#getStream <em>Stream</em>}</li>
 *   <li>{@link org.unicase.model.changetracking.impl.ReleaseImpl#isBuilt <em>Built</em>}</li>
 *   <li>{@link org.unicase.model.changetracking.impl.ReleaseImpl#getBuiltRevision <em>Built Revision</em>}</li>
 *   <li>{@link org.unicase.model.changetracking.impl.ReleaseImpl#getBuildDate <em>Build Date</em>}</li>
 *   <li>{@link org.unicase.model.changetracking.impl.ReleaseImpl#getSuccessor <em>Successor</em>}</li>
 *   <li>{@link org.unicase.model.changetracking.impl.ReleaseImpl#getPredecessor <em>Predecessor</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class ReleaseImpl extends AbstractReleaseImpl implements Release {
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
	 * The default value of the '{@link #getBuildDate() <em>Build Date</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getBuildDate()
	 * @generated
	 * @ordered
	 */
	protected static final Date BUILD_DATE_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getBuildDate() <em>Build Date</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getBuildDate()
	 * @generated
	 * @ordered
	 */
	protected Date buildDate = BUILD_DATE_EDEFAULT;

	/**
	 * The cached value of the '{@link #getSuccessor() <em>Successor</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSuccessor()
	 * @generated
	 * @ordered
	 */
	protected Release successor;

	/**
	 * The cached value of the '{@link #getPredecessor() <em>Predecessor</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getPredecessor()
	 * @generated
	 * @ordered
	 */
	protected Release predecessor;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected ReleaseImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return ChangetrackingPackage.Literals.RELEASE;
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
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, ChangetrackingPackage.RELEASE__STREAM, oldStream, stream));
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
	public NotificationChain basicSetStream(Stream newStream, NotificationChain msgs) {
		Stream oldStream = stream;
		stream = newStream;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, ChangetrackingPackage.RELEASE__STREAM, oldStream, newStream);
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
				msgs = ((InternalEObject) stream).eInverseRemove(this, ChangetrackingPackage.STREAM__RELEASES, Stream.class, msgs);
			if (newStream != null)
				msgs = ((InternalEObject) newStream).eInverseAdd(this, ChangetrackingPackage.STREAM__RELEASES, Stream.class, msgs);
			msgs = basicSetStream(newStream, msgs);
			if (msgs != null)
				msgs.dispatch();
		} else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ChangetrackingPackage.RELEASE__STREAM, newStream, newStream));
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
			eNotify(new ENotificationImpl(this, Notification.SET, ChangetrackingPackage.RELEASE__BUILT, oldBuilt, built));
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
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, ChangetrackingPackage.RELEASE__BUILT_REVISION, oldBuiltRevision, builtRevision));
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
	public NotificationChain basicSetBuiltRevision(RepositoryRevision newBuiltRevision, NotificationChain msgs) {
		RepositoryRevision oldBuiltRevision = builtRevision;
		builtRevision = newBuiltRevision;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, ChangetrackingPackage.RELEASE__BUILT_REVISION, oldBuiltRevision, newBuiltRevision);
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
				msgs = ((InternalEObject) builtRevision).eInverseRemove(this, ChangetrackingPackage.REPOSITORY_REVISION__BUILT_WITH_RELEASES, RepositoryRevision.class, msgs);
			if (newBuiltRevision != null)
				msgs = ((InternalEObject) newBuiltRevision).eInverseAdd(this, ChangetrackingPackage.REPOSITORY_REVISION__BUILT_WITH_RELEASES, RepositoryRevision.class, msgs);
			msgs = basicSetBuiltRevision(newBuiltRevision, msgs);
			if (msgs != null)
				msgs.dispatch();
		} else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ChangetrackingPackage.RELEASE__BUILT_REVISION, newBuiltRevision, newBuiltRevision));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Date getBuildDate() {
		return buildDate;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setBuildDate(Date newBuildDate) {
		Date oldBuildDate = buildDate;
		buildDate = newBuildDate;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ChangetrackingPackage.RELEASE__BUILD_DATE, oldBuildDate, buildDate));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Release getSuccessor() {
		if (successor != null && successor.eIsProxy()) {
			InternalEObject oldSuccessor = (InternalEObject) successor;
			successor = (Release) eResolveProxy(oldSuccessor);
			if (successor != oldSuccessor) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, ChangetrackingPackage.RELEASE__SUCCESSOR, oldSuccessor, successor));
			}
		}
		return successor;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Release basicGetSuccessor() {
		return successor;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetSuccessor(Release newSuccessor, NotificationChain msgs) {
		Release oldSuccessor = successor;
		successor = newSuccessor;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, ChangetrackingPackage.RELEASE__SUCCESSOR, oldSuccessor, newSuccessor);
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
	public void setSuccessor(Release newSuccessor) {
		if (newSuccessor != successor) {
			NotificationChain msgs = null;
			if (successor != null)
				msgs = ((InternalEObject) successor).eInverseRemove(this, ChangetrackingPackage.RELEASE__PREDECESSOR, Release.class, msgs);
			if (newSuccessor != null)
				msgs = ((InternalEObject) newSuccessor).eInverseAdd(this, ChangetrackingPackage.RELEASE__PREDECESSOR, Release.class, msgs);
			msgs = basicSetSuccessor(newSuccessor, msgs);
			if (msgs != null)
				msgs.dispatch();
		} else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ChangetrackingPackage.RELEASE__SUCCESSOR, newSuccessor, newSuccessor));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Release getPredecessor() {
		if (predecessor != null && predecessor.eIsProxy()) {
			InternalEObject oldPredecessor = (InternalEObject) predecessor;
			predecessor = (Release) eResolveProxy(oldPredecessor);
			if (predecessor != oldPredecessor) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, ChangetrackingPackage.RELEASE__PREDECESSOR, oldPredecessor, predecessor));
			}
		}
		return predecessor;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Release basicGetPredecessor() {
		return predecessor;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetPredecessor(Release newPredecessor, NotificationChain msgs) {
		Release oldPredecessor = predecessor;
		predecessor = newPredecessor;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, ChangetrackingPackage.RELEASE__PREDECESSOR, oldPredecessor, newPredecessor);
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
	public void setPredecessor(Release newPredecessor) {
		if (newPredecessor != predecessor) {
			NotificationChain msgs = null;
			if (predecessor != null)
				msgs = ((InternalEObject) predecessor).eInverseRemove(this, ChangetrackingPackage.RELEASE__SUCCESSOR, Release.class, msgs);
			if (newPredecessor != null)
				msgs = ((InternalEObject) newPredecessor).eInverseAdd(this, ChangetrackingPackage.RELEASE__SUCCESSOR, Release.class, msgs);
			msgs = basicSetPredecessor(newPredecessor, msgs);
			if (msgs != null)
				msgs.dispatch();
		} else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ChangetrackingPackage.RELEASE__PREDECESSOR, newPredecessor, newPredecessor));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseAdd(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
		case ChangetrackingPackage.RELEASE__STREAM:
			if (stream != null)
				msgs = ((InternalEObject) stream).eInverseRemove(this, ChangetrackingPackage.STREAM__RELEASES, Stream.class, msgs);
			return basicSetStream((Stream) otherEnd, msgs);
		case ChangetrackingPackage.RELEASE__BUILT_REVISION:
			if (builtRevision != null)
				msgs = ((InternalEObject) builtRevision).eInverseRemove(this, ChangetrackingPackage.REPOSITORY_REVISION__BUILT_WITH_RELEASES, RepositoryRevision.class, msgs);
			return basicSetBuiltRevision((RepositoryRevision) otherEnd, msgs);
		case ChangetrackingPackage.RELEASE__SUCCESSOR:
			if (successor != null)
				msgs = ((InternalEObject) successor).eInverseRemove(this, ChangetrackingPackage.RELEASE__PREDECESSOR, Release.class, msgs);
			return basicSetSuccessor((Release) otherEnd, msgs);
		case ChangetrackingPackage.RELEASE__PREDECESSOR:
			if (predecessor != null)
				msgs = ((InternalEObject) predecessor).eInverseRemove(this, ChangetrackingPackage.RELEASE__SUCCESSOR, Release.class, msgs);
			return basicSetPredecessor((Release) otherEnd, msgs);
		}
		return super.eInverseAdd(otherEnd, featureID, msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
		case ChangetrackingPackage.RELEASE__STREAM:
			return basicSetStream(null, msgs);
		case ChangetrackingPackage.RELEASE__BUILT_REVISION:
			return basicSetBuiltRevision(null, msgs);
		case ChangetrackingPackage.RELEASE__SUCCESSOR:
			return basicSetSuccessor(null, msgs);
		case ChangetrackingPackage.RELEASE__PREDECESSOR:
			return basicSetPredecessor(null, msgs);
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
		case ChangetrackingPackage.RELEASE__STREAM:
			if (resolve)
				return getStream();
			return basicGetStream();
		case ChangetrackingPackage.RELEASE__BUILT:
			return isBuilt();
		case ChangetrackingPackage.RELEASE__BUILT_REVISION:
			if (resolve)
				return getBuiltRevision();
			return basicGetBuiltRevision();
		case ChangetrackingPackage.RELEASE__BUILD_DATE:
			return getBuildDate();
		case ChangetrackingPackage.RELEASE__SUCCESSOR:
			if (resolve)
				return getSuccessor();
			return basicGetSuccessor();
		case ChangetrackingPackage.RELEASE__PREDECESSOR:
			if (resolve)
				return getPredecessor();
			return basicGetPredecessor();
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
		case ChangetrackingPackage.RELEASE__STREAM:
			setStream((Stream) newValue);
			return;
		case ChangetrackingPackage.RELEASE__BUILT:
			setBuilt((Boolean) newValue);
			return;
		case ChangetrackingPackage.RELEASE__BUILT_REVISION:
			setBuiltRevision((RepositoryRevision) newValue);
			return;
		case ChangetrackingPackage.RELEASE__BUILD_DATE:
			setBuildDate((Date) newValue);
			return;
		case ChangetrackingPackage.RELEASE__SUCCESSOR:
			setSuccessor((Release) newValue);
			return;
		case ChangetrackingPackage.RELEASE__PREDECESSOR:
			setPredecessor((Release) newValue);
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
		case ChangetrackingPackage.RELEASE__STREAM:
			setStream((Stream) null);
			return;
		case ChangetrackingPackage.RELEASE__BUILT:
			setBuilt(BUILT_EDEFAULT);
			return;
		case ChangetrackingPackage.RELEASE__BUILT_REVISION:
			setBuiltRevision((RepositoryRevision) null);
			return;
		case ChangetrackingPackage.RELEASE__BUILD_DATE:
			setBuildDate(BUILD_DATE_EDEFAULT);
			return;
		case ChangetrackingPackage.RELEASE__SUCCESSOR:
			setSuccessor((Release) null);
			return;
		case ChangetrackingPackage.RELEASE__PREDECESSOR:
			setPredecessor((Release) null);
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
		case ChangetrackingPackage.RELEASE__STREAM:
			return stream != null;
		case ChangetrackingPackage.RELEASE__BUILT:
			return built != BUILT_EDEFAULT;
		case ChangetrackingPackage.RELEASE__BUILT_REVISION:
			return builtRevision != null;
		case ChangetrackingPackage.RELEASE__BUILD_DATE:
			return BUILD_DATE_EDEFAULT == null ? buildDate != null : !BUILD_DATE_EDEFAULT.equals(buildDate);
		case ChangetrackingPackage.RELEASE__SUCCESSOR:
			return successor != null;
		case ChangetrackingPackage.RELEASE__PREDECESSOR:
			return predecessor != null;
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
		result.append(", buildDate: ");
		result.append(buildDate);
		result.append(')');
		return result.toString();
	}

} //ReleaseImpl
