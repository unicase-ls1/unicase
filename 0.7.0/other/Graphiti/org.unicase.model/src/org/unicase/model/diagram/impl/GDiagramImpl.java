/**
 * <copyright> Copyright (c) 2008-2009 Jonas Helming, Maximilian Koegel. All rights reserved. This program and the
 * accompanying materials are made available under the terms of the Eclipse Public License v1.0 which accompanies this
 * distribution, and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>
 */
package org.unicase.model.diagram.impl;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

import org.eclipse.graphiti.mm.pictograms.Diagram;

import org.unicase.model.diagram.DiagramPackage;
import org.unicase.model.diagram.GDiagram;

import org.unicase.model.impl.AttachmentImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>GDiagram</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.unicase.model.diagram.impl.GDiagramImpl#getGraphitiDiagram <em>Graphiti Diagram</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public abstract class GDiagramImpl extends AttachmentImpl implements GDiagram {
	/**
	 * The cached value of the '{@link #getGraphitiDiagram() <em>Graphiti Diagram</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getGraphitiDiagram()
	 * @generated
	 * @ordered
	 */
	protected Diagram graphitiDiagram;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected GDiagramImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return DiagramPackage.Literals.GDIAGRAM;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Diagram getGraphitiDiagram() {
		if (graphitiDiagram != null && graphitiDiagram.eIsProxy()) {
			InternalEObject oldGraphitiDiagram = (InternalEObject) graphitiDiagram;
			graphitiDiagram = (Diagram) eResolveProxy(oldGraphitiDiagram);
			if (graphitiDiagram != oldGraphitiDiagram) {
				InternalEObject newGraphitiDiagram = (InternalEObject) graphitiDiagram;
				NotificationChain msgs = oldGraphitiDiagram.eInverseRemove(this, EOPPOSITE_FEATURE_BASE
					- DiagramPackage.GDIAGRAM__GRAPHITI_DIAGRAM, null, null);
				if (newGraphitiDiagram.eInternalContainer() == null) {
					msgs = newGraphitiDiagram.eInverseAdd(this, EOPPOSITE_FEATURE_BASE
						- DiagramPackage.GDIAGRAM__GRAPHITI_DIAGRAM, null, msgs);
				}
				if (msgs != null)
					msgs.dispatch();
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE,
						DiagramPackage.GDIAGRAM__GRAPHITI_DIAGRAM, oldGraphitiDiagram, graphitiDiagram));
			}
		}
		return graphitiDiagram;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Diagram basicGetGraphitiDiagram() {
		return graphitiDiagram;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetGraphitiDiagram(Diagram newGraphitiDiagram, NotificationChain msgs) {
		Diagram oldGraphitiDiagram = graphitiDiagram;
		graphitiDiagram = newGraphitiDiagram;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET,
				DiagramPackage.GDIAGRAM__GRAPHITI_DIAGRAM, oldGraphitiDiagram, newGraphitiDiagram);
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
	public void setGraphitiDiagram(Diagram newGraphitiDiagram) {
		if (newGraphitiDiagram != graphitiDiagram) {
			NotificationChain msgs = null;
			if (graphitiDiagram != null)
				msgs = ((InternalEObject) graphitiDiagram).eInverseRemove(this, EOPPOSITE_FEATURE_BASE
					- DiagramPackage.GDIAGRAM__GRAPHITI_DIAGRAM, null, msgs);
			if (newGraphitiDiagram != null)
				msgs = ((InternalEObject) newGraphitiDiagram).eInverseAdd(this, EOPPOSITE_FEATURE_BASE
					- DiagramPackage.GDIAGRAM__GRAPHITI_DIAGRAM, null, msgs);
			msgs = basicSetGraphitiDiagram(newGraphitiDiagram, msgs);
			if (msgs != null)
				msgs.dispatch();
		} else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, DiagramPackage.GDIAGRAM__GRAPHITI_DIAGRAM,
				newGraphitiDiagram, newGraphitiDiagram));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
		case DiagramPackage.GDIAGRAM__GRAPHITI_DIAGRAM:
			return basicSetGraphitiDiagram(null, msgs);
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
		case DiagramPackage.GDIAGRAM__GRAPHITI_DIAGRAM:
			if (resolve)
				return getGraphitiDiagram();
			return basicGetGraphitiDiagram();
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
		case DiagramPackage.GDIAGRAM__GRAPHITI_DIAGRAM:
			setGraphitiDiagram((Diagram) newValue);
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
		case DiagramPackage.GDIAGRAM__GRAPHITI_DIAGRAM:
			setGraphitiDiagram((Diagram) null);
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
		case DiagramPackage.GDIAGRAM__GRAPHITI_DIAGRAM:
			return graphitiDiagram != null;
		}
		return super.eIsSet(featureID);
	}

} //GDiagramImpl
