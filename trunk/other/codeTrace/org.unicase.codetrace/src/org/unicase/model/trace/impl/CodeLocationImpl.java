/**
 * <copyright> Copyright (c) 2008-2009 Jonas Helming, Maximilian Koegel. All rights reserved. This program and the
 * accompanying materials are made available under the terms of the Eclipse Public License v1.0 which accompanies this
 * distribution, and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>
 */
package org.unicase.model.trace.impl;

import java.util.Collection;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.InternalEList;
import org.unicase.model.impl.AttachmentImpl;
import org.unicase.model.trace.CodeLocation;
import org.unicase.model.trace.LineHash;
import org.unicase.model.trace.TracePackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Code Location</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.unicase.model.trace.impl.CodeLocationImpl#getLineContent <em>Line Content</em>}</li>
 *   <li>{@link org.unicase.model.trace.impl.CodeLocationImpl#getProjectName <em>Project Name</em>}</li>
 *   <li>{@link org.unicase.model.trace.impl.CodeLocationImpl#getPathInProject <em>Path In Project</em>}</li>
 *   <li>{@link org.unicase.model.trace.impl.CodeLocationImpl#getLinesBefore <em>Lines Before</em>}</li>
 *   <li>{@link org.unicase.model.trace.impl.CodeLocationImpl#getLinesAfter <em>Lines After</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class CodeLocationImpl extends AttachmentImpl implements CodeLocation {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final String copyright = "<copyright> Copyright (c) 2008-2009 Jonas Helming, Maximilian Koegel. All rights reserved. This program and the accompanying materials are made available under the terms of the Eclipse Public License v1.0 which accompanies this distribution, and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>\r";

	/**
	 * The default value of the '{@link #getLineContent() <em>Line Content</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getLineContent()
	 * @generated
	 * @ordered
	 */
	protected static final String LINE_CONTENT_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getLineContent() <em>Line Content</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getLineContent()
	 * @generated
	 * @ordered
	 */
	protected String lineContent = LINE_CONTENT_EDEFAULT;

	/**
	 * The default value of the '{@link #getProjectName() <em>Project Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getProjectName()
	 * @generated
	 * @ordered
	 */
	protected static final String PROJECT_NAME_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getProjectName() <em>Project Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getProjectName()
	 * @generated
	 * @ordered
	 */
	protected String projectName = PROJECT_NAME_EDEFAULT;

	/**
	 * The default value of the '{@link #getPathInProject() <em>Path In Project</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getPathInProject()
	 * @generated
	 * @ordered
	 */
	protected static final String PATH_IN_PROJECT_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getPathInProject() <em>Path In Project</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getPathInProject()
	 * @generated
	 * @ordered
	 */
	protected String pathInProject = PATH_IN_PROJECT_EDEFAULT;

	/**
	 * The cached value of the '{@link #getLinesBefore() <em>Lines Before</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getLinesBefore()
	 * @generated
	 * @ordered
	 */
	protected EList<LineHash> linesBefore;

	/**
	 * The cached value of the '{@link #getLinesAfter() <em>Lines After</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getLinesAfter()
	 * @generated
	 * @ordered
	 */
	protected EList<LineHash> linesAfter;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected CodeLocationImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	
	protected EClass eStaticClass() {
		return TracePackage.Literals.CODE_LOCATION;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getLineContent() {
		return lineContent;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setLineContent(String newLineContent) {
		String oldLineContent = lineContent;
		lineContent = newLineContent;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET,
					TracePackage.CODE_LOCATION__LINE_CONTENT, oldLineContent,
					lineContent));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getProjectName() {
		return projectName;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setProjectName(String newProjectName) {
		String oldProjectName = projectName;
		projectName = newProjectName;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET,
					TracePackage.CODE_LOCATION__PROJECT_NAME, oldProjectName,
					projectName));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getPathInProject() {
		return pathInProject;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setPathInProject(String newPathInProject) {
		String oldPathInProject = pathInProject;
		pathInProject = newPathInProject;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET,
					TracePackage.CODE_LOCATION__PATH_IN_PROJECT,
					oldPathInProject, pathInProject));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<LineHash> getLinesBefore() {
		if (linesBefore == null) {
			linesBefore = new EObjectContainmentEList.Resolving<LineHash>(
					LineHash.class, this,
					TracePackage.CODE_LOCATION__LINES_BEFORE);
		}
		return linesBefore;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<LineHash> getLinesAfter() {
		if (linesAfter == null) {
			linesAfter = new EObjectContainmentEList.Resolving<LineHash>(
					LineHash.class, this,
					TracePackage.CODE_LOCATION__LINES_AFTER);
		}
		return linesAfter;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	
	public NotificationChain eInverseRemove(InternalEObject otherEnd,
			int featureID, NotificationChain msgs) {
		switch (featureID) {
		case TracePackage.CODE_LOCATION__LINES_BEFORE:
			return ((InternalEList<?>) getLinesBefore()).basicRemove(otherEnd,
					msgs);
		case TracePackage.CODE_LOCATION__LINES_AFTER:
			return ((InternalEList<?>) getLinesAfter()).basicRemove(otherEnd,
					msgs);
		}
		return super.eInverseRemove(otherEnd, featureID, msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
		case TracePackage.CODE_LOCATION__LINE_CONTENT:
			return getLineContent();
		case TracePackage.CODE_LOCATION__PROJECT_NAME:
			return getProjectName();
		case TracePackage.CODE_LOCATION__PATH_IN_PROJECT:
			return getPathInProject();
		case TracePackage.CODE_LOCATION__LINES_BEFORE:
			return getLinesBefore();
		case TracePackage.CODE_LOCATION__LINES_AFTER:
			return getLinesAfter();
		}
		return super.eGet(featureID, resolve, coreType);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	
	public void eSet(int featureID, Object newValue) {
		switch (featureID) {
		case TracePackage.CODE_LOCATION__LINE_CONTENT:
			setLineContent((String) newValue);
			return;
		case TracePackage.CODE_LOCATION__PROJECT_NAME:
			setProjectName((String) newValue);
			return;
		case TracePackage.CODE_LOCATION__PATH_IN_PROJECT:
			setPathInProject((String) newValue);
			return;
		case TracePackage.CODE_LOCATION__LINES_BEFORE:
			getLinesBefore().clear();
			getLinesBefore().addAll((Collection<? extends LineHash>) newValue);
			return;
		case TracePackage.CODE_LOCATION__LINES_AFTER:
			getLinesAfter().clear();
			getLinesAfter().addAll((Collection<? extends LineHash>) newValue);
			return;
		}
		super.eSet(featureID, newValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	
	public void eUnset(int featureID) {
		switch (featureID) {
		case TracePackage.CODE_LOCATION__LINE_CONTENT:
			setLineContent(LINE_CONTENT_EDEFAULT);
			return;
		case TracePackage.CODE_LOCATION__PROJECT_NAME:
			setProjectName(PROJECT_NAME_EDEFAULT);
			return;
		case TracePackage.CODE_LOCATION__PATH_IN_PROJECT:
			setPathInProject(PATH_IN_PROJECT_EDEFAULT);
			return;
		case TracePackage.CODE_LOCATION__LINES_BEFORE:
			getLinesBefore().clear();
			return;
		case TracePackage.CODE_LOCATION__LINES_AFTER:
			getLinesAfter().clear();
			return;
		}
		super.eUnset(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	
	public boolean eIsSet(int featureID) {
		switch (featureID) {
		case TracePackage.CODE_LOCATION__LINE_CONTENT:
			return LINE_CONTENT_EDEFAULT == null ? lineContent != null
					: !LINE_CONTENT_EDEFAULT.equals(lineContent);
		case TracePackage.CODE_LOCATION__PROJECT_NAME:
			return PROJECT_NAME_EDEFAULT == null ? projectName != null
					: !PROJECT_NAME_EDEFAULT.equals(projectName);
		case TracePackage.CODE_LOCATION__PATH_IN_PROJECT:
			return PATH_IN_PROJECT_EDEFAULT == null ? pathInProject != null
					: !PATH_IN_PROJECT_EDEFAULT.equals(pathInProject);
		case TracePackage.CODE_LOCATION__LINES_BEFORE:
			return linesBefore != null && !linesBefore.isEmpty();
		case TracePackage.CODE_LOCATION__LINES_AFTER:
			return linesAfter != null && !linesAfter.isEmpty();
		}
		return super.eIsSet(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	
	public String toString() {
		if (eIsProxy())
			return super.toString();

		StringBuffer result = new StringBuffer(super.toString());
		result.append(" (lineContent: ");
		result.append(lineContent);
		result.append(", projectName: ");
		result.append(projectName);
		result.append(", pathInProject: ");
		result.append(pathInProject);
		result.append(')');
		return result.toString();
	}

} //CodeLocationImpl
