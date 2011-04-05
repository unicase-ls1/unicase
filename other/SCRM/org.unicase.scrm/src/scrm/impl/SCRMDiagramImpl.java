/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package scrm.impl;

import java.util.Collection;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.EObjectImpl;

import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.EObjectResolvingEList;
import org.eclipse.emf.ecore.util.InternalEList;

import org.eclipse.gmf.runtime.notation.Diagram;

import scrm.SCRMDiagram;
import scrm.SCRMModelElement;
import scrm.ScrmPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>SCRM Diagram</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link scrm.impl.SCRMDiagramImpl#getElements <em>Elements</em>}</li>
 *   <li>{@link scrm.impl.SCRMDiagramImpl#getNewElements <em>New Elements</em>}</li>
 *   <li>{@link scrm.impl.SCRMDiagramImpl#getDiagramLayout <em>Diagram Layout</em>}</li>
 *   <li>{@link scrm.impl.SCRMDiagramImpl#getGmfdiagram <em>Gmfdiagram</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class SCRMDiagramImpl extends EObjectImpl implements SCRMDiagram {
	/**
	 * The cached value of the '{@link #getElements() <em>Elements</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getElements()
	 * @generated
	 * @ordered
	 */
	protected EList<SCRMModelElement> elements;

	/**
	 * The cached value of the '{@link #getNewElements() <em>New Elements</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getNewElements()
	 * @generated
	 * @ordered
	 */
	protected EList<SCRMModelElement> newElements;

	/**
	 * The default value of the '{@link #getDiagramLayout() <em>Diagram Layout</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getDiagramLayout()
	 * @generated
	 * @ordered
	 */
	protected static final String DIAGRAM_LAYOUT_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getDiagramLayout() <em>Diagram Layout</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getDiagramLayout()
	 * @generated
	 * @ordered
	 */
	protected String diagramLayout = DIAGRAM_LAYOUT_EDEFAULT;

	/**
	 * The cached value of the '{@link #getGmfdiagram() <em>Gmfdiagram</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getGmfdiagram()
	 * @generated
	 * @ordered
	 */
	protected Diagram gmfdiagram;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected SCRMDiagramImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return ScrmPackage.Literals.SCRM_DIAGRAM;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<SCRMModelElement> getElements() {
		if (elements == null) {
			elements = new EObjectResolvingEList<SCRMModelElement>(SCRMModelElement.class, this, ScrmPackage.SCRM_DIAGRAM__ELEMENTS);
		}
		return elements;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<SCRMModelElement> getNewElements() {
		if (newElements == null) {
			newElements = new EObjectContainmentEList<SCRMModelElement>(SCRMModelElement.class, this, ScrmPackage.SCRM_DIAGRAM__NEW_ELEMENTS);
		}
		return newElements;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getDiagramLayout() {
		return diagramLayout;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setDiagramLayout(String newDiagramLayout) {
		String oldDiagramLayout = diagramLayout;
		diagramLayout = newDiagramLayout;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ScrmPackage.SCRM_DIAGRAM__DIAGRAM_LAYOUT, oldDiagramLayout, diagramLayout));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Diagram getGmfdiagram() {
		return gmfdiagram;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetGmfdiagram(Diagram newGmfdiagram, NotificationChain msgs) {
		Diagram oldGmfdiagram = gmfdiagram;
		gmfdiagram = newGmfdiagram;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, ScrmPackage.SCRM_DIAGRAM__GMFDIAGRAM, oldGmfdiagram, newGmfdiagram);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setGmfdiagram(Diagram newGmfdiagram) {
		if (newGmfdiagram != gmfdiagram) {
			NotificationChain msgs = null;
			if (gmfdiagram != null)
				msgs = ((InternalEObject)gmfdiagram).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - ScrmPackage.SCRM_DIAGRAM__GMFDIAGRAM, null, msgs);
			if (newGmfdiagram != null)
				msgs = ((InternalEObject)newGmfdiagram).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - ScrmPackage.SCRM_DIAGRAM__GMFDIAGRAM, null, msgs);
			msgs = basicSetGmfdiagram(newGmfdiagram, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ScrmPackage.SCRM_DIAGRAM__GMFDIAGRAM, newGmfdiagram, newGmfdiagram));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case ScrmPackage.SCRM_DIAGRAM__NEW_ELEMENTS:
				return ((InternalEList<?>)getNewElements()).basicRemove(otherEnd, msgs);
			case ScrmPackage.SCRM_DIAGRAM__GMFDIAGRAM:
				return basicSetGmfdiagram(null, msgs);
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
			case ScrmPackage.SCRM_DIAGRAM__ELEMENTS:
				return getElements();
			case ScrmPackage.SCRM_DIAGRAM__NEW_ELEMENTS:
				return getNewElements();
			case ScrmPackage.SCRM_DIAGRAM__DIAGRAM_LAYOUT:
				return getDiagramLayout();
			case ScrmPackage.SCRM_DIAGRAM__GMFDIAGRAM:
				return getGmfdiagram();
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
			case ScrmPackage.SCRM_DIAGRAM__ELEMENTS:
				getElements().clear();
				getElements().addAll((Collection<? extends SCRMModelElement>)newValue);
				return;
			case ScrmPackage.SCRM_DIAGRAM__NEW_ELEMENTS:
				getNewElements().clear();
				getNewElements().addAll((Collection<? extends SCRMModelElement>)newValue);
				return;
			case ScrmPackage.SCRM_DIAGRAM__DIAGRAM_LAYOUT:
				setDiagramLayout((String)newValue);
				return;
			case ScrmPackage.SCRM_DIAGRAM__GMFDIAGRAM:
				setGmfdiagram((Diagram)newValue);
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
			case ScrmPackage.SCRM_DIAGRAM__ELEMENTS:
				getElements().clear();
				return;
			case ScrmPackage.SCRM_DIAGRAM__NEW_ELEMENTS:
				getNewElements().clear();
				return;
			case ScrmPackage.SCRM_DIAGRAM__DIAGRAM_LAYOUT:
				setDiagramLayout(DIAGRAM_LAYOUT_EDEFAULT);
				return;
			case ScrmPackage.SCRM_DIAGRAM__GMFDIAGRAM:
				setGmfdiagram((Diagram)null);
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
			case ScrmPackage.SCRM_DIAGRAM__ELEMENTS:
				return elements != null && !elements.isEmpty();
			case ScrmPackage.SCRM_DIAGRAM__NEW_ELEMENTS:
				return newElements != null && !newElements.isEmpty();
			case ScrmPackage.SCRM_DIAGRAM__DIAGRAM_LAYOUT:
				return DIAGRAM_LAYOUT_EDEFAULT == null ? diagramLayout != null : !DIAGRAM_LAYOUT_EDEFAULT.equals(diagramLayout);
			case ScrmPackage.SCRM_DIAGRAM__GMFDIAGRAM:
				return gmfdiagram != null;
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
		result.append(" (diagramLayout: ");
		result.append(diagramLayout);
		result.append(')');
		return result.toString();
	}

} //SCRMDiagramImpl
