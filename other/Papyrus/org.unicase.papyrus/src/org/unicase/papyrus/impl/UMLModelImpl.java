/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.unicase.papyrus.impl;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

import org.eclipse.gmf.runtime.notation.Diagram;

import org.eclipse.uml2.uml.internal.impl.ModelImpl;

import org.unicase.papyrus.PapyrusPackage;
import org.unicase.papyrus.UMLDiagramType;
import org.unicase.papyrus.UMLModel;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>UML Model</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.unicase.papyrus.impl.UMLModelImpl#getGmfDiagram <em>Gmf Diagram</em>}</li>
 *   <li>{@link org.unicase.papyrus.impl.UMLModelImpl#getDiagramType <em>Diagram Type</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class UMLModelImpl extends ModelImpl implements UMLModel {
	/**
	 * The cached value of the '{@link #getGmfDiagram() <em>Gmf Diagram</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getGmfDiagram()
	 * @generated
	 * @ordered
	 */
	protected Diagram gmfDiagram;

	/**
	 * The default value of the '{@link #getDiagramType() <em>Diagram Type</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getDiagramType()
	 * @generated
	 * @ordered
	 */
	protected static final UMLDiagramType DIAGRAM_TYPE_EDEFAULT = UMLDiagramType.NO_DIAGRAM;

	/**
	 * The cached value of the '{@link #getDiagramType() <em>Diagram Type</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getDiagramType()
	 * @generated
	 * @ordered
	 */
	protected UMLDiagramType diagramType = DIAGRAM_TYPE_EDEFAULT;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	protected UMLModelImpl() {
		super();
		setName("new UML Diagram");
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return PapyrusPackage.Literals.UML_MODEL;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Diagram getGmfDiagram() {
		if (gmfDiagram != null && gmfDiagram.eIsProxy()) {
			InternalEObject oldGmfDiagram = (InternalEObject)gmfDiagram;
			gmfDiagram = (Diagram)eResolveProxy(oldGmfDiagram);
			if (gmfDiagram != oldGmfDiagram) {
				InternalEObject newGmfDiagram = (InternalEObject)gmfDiagram;
				NotificationChain msgs = oldGmfDiagram.eInverseRemove(this, EOPPOSITE_FEATURE_BASE - PapyrusPackage.UML_MODEL__GMF_DIAGRAM, null, null);
				if (newGmfDiagram.eInternalContainer() == null) {
					msgs = newGmfDiagram.eInverseAdd(this, EOPPOSITE_FEATURE_BASE - PapyrusPackage.UML_MODEL__GMF_DIAGRAM, null, msgs);
				}
				if (msgs != null) msgs.dispatch();
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, PapyrusPackage.UML_MODEL__GMF_DIAGRAM, oldGmfDiagram, gmfDiagram));
			}
		}
		return gmfDiagram;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Diagram basicGetGmfDiagram() {
		return gmfDiagram;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetGmfDiagram(Diagram newGmfDiagram, NotificationChain msgs) {
		Diagram oldGmfDiagram = gmfDiagram;
		gmfDiagram = newGmfDiagram;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, PapyrusPackage.UML_MODEL__GMF_DIAGRAM, oldGmfDiagram, newGmfDiagram);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setGmfDiagram(Diagram newGmfDiagram) {
		if (newGmfDiagram != gmfDiagram) {
			NotificationChain msgs = null;
			if (gmfDiagram != null)
				msgs = ((InternalEObject)gmfDiagram).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - PapyrusPackage.UML_MODEL__GMF_DIAGRAM, null, msgs);
			if (newGmfDiagram != null)
				msgs = ((InternalEObject)newGmfDiagram).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - PapyrusPackage.UML_MODEL__GMF_DIAGRAM, null, msgs);
			msgs = basicSetGmfDiagram(newGmfDiagram, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, PapyrusPackage.UML_MODEL__GMF_DIAGRAM, newGmfDiagram, newGmfDiagram));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public UMLDiagramType getDiagramType() {
		return diagramType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setDiagramType(UMLDiagramType newDiagramType) {
		UMLDiagramType oldDiagramType = diagramType;
		diagramType = newDiagramType == null ? DIAGRAM_TYPE_EDEFAULT : newDiagramType;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, PapyrusPackage.UML_MODEL__DIAGRAM_TYPE, oldDiagramType, diagramType));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case PapyrusPackage.UML_MODEL__GMF_DIAGRAM:
				return basicSetGmfDiagram(null, msgs);
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
			case PapyrusPackage.UML_MODEL__GMF_DIAGRAM:
				if (resolve) return getGmfDiagram();
				return basicGetGmfDiagram();
			case PapyrusPackage.UML_MODEL__DIAGRAM_TYPE:
				return getDiagramType();
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
			case PapyrusPackage.UML_MODEL__GMF_DIAGRAM:
				setGmfDiagram((Diagram)newValue);
				return;
			case PapyrusPackage.UML_MODEL__DIAGRAM_TYPE:
				setDiagramType((UMLDiagramType)newValue);
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
			case PapyrusPackage.UML_MODEL__GMF_DIAGRAM:
				setGmfDiagram((Diagram)null);
				return;
			case PapyrusPackage.UML_MODEL__DIAGRAM_TYPE:
				setDiagramType(DIAGRAM_TYPE_EDEFAULT);
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
			case PapyrusPackage.UML_MODEL__GMF_DIAGRAM:
				return gmfDiagram != null;
			case PapyrusPackage.UML_MODEL__DIAGRAM_TYPE:
				return diagramType != DIAGRAM_TYPE_EDEFAULT;
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
		result.append(" (diagramType: ");
		result.append(diagramType);
		result.append(')');
		return result.toString();
	}
	
	/** 
	 * {@inheritDoc}
	 * @generated NOT
	 */
	@Override
	public void setName(String newName) {
		super.setName(newName);
		Diagram diagram = getGmfDiagram();
		if(diagram != null) {
			diagram.setName(newName);
		}
	}

} //UMLModelImpl
