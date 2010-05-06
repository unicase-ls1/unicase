/**
 * <copyright> Copyright (c) 2008-2009 Jonas Helming, Maximilian Koegel. All rights reserved. This program and the
 * accompanying materials are made available under the terms of the Eclipse Public License v1.0 which accompanies this
 * distribution, and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>
 */
package org.unicase.metamodel.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.impl.AdapterImpl;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.unicase.metamodel.MetamodelFactory;
import org.unicase.metamodel.MetamodelPackage;
import org.unicase.metamodel.ModelElement;
import org.unicase.metamodel.ModelElementId;
import org.unicase.metamodel.Project;
import org.unicase.metamodel.util.ModelElementChangeListener;
import org.unicase.metamodel.util.ModelUtil;

/**
 * <!-- begin-user-doc --> An implementation of the model object ' <em><b>Element</b></em>'. <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 * <li>{@link org.unicase.metamodel.impl.ModelElementImpl#getCreator <em>Creator</em>}</li>
 * <li>{@link org.unicase.metamodel.impl.ModelElementImpl#getCreationDate <em>Creation Date</em>}</li>
 * </ul>
 * </p>
 * 
 * @generated
 */
public abstract class ModelElementImpl extends IdentifiableElementImpl implements ModelElement {

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.unicase.model.UnicaseModelElement#addModelElementChangeListener(org.unicase.model.util.ModelElementChangeListener)
	 */
	public void addModelElementChangeListener(ModelElementChangeListener listener) {
		if (this.changeListeners.size() == 0) {
			internalChangeListener = new AdapterImpl() {
				/**
				 * {@inheritDoc}
				 */
				@Override
				public void notifyChanged(Notification notification) {
					notifyListenersAboutChange(notification);
				}
			};
			this.eAdapters().add(internalChangeListener);
		}
		this.changeListeners.add(listener);
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.unicase.model.UnicaseModelElement#removeModelElementChangeListener(org.unicase.model.util.ModelElementChangeListener)
	 */
	public void removeModelElementChangeListener(ModelElementChangeListener listener) {
		//if we are notifying listeners at the moment than just add listener for later removal
		if (isNotifying) {
			listenersToBeRemoved.add(listener);
			return;
		}
		
		this.changeListeners.remove(listener);
		if (this.changeListeners.size() < 1 && internalChangeListener != null) {
			this.eAdapters().remove(internalChangeListener);
			internalChangeListener = null;
		}
	}

	private void notifyListenersAboutChange(Notification notification) {
		isNotifying = true;
		for (ModelElementChangeListener listener : changeListeners) {
			try {
				listener.onChange(notification);
			}
			// BEGIN SUPRESS CATCH EXCEPTION
			catch (RuntimeException exception) {
				ModelUtil.logWarning("ModelElementChangeListener threw RuntimeException on Change Notification " + ""
					+ "(exception was caught and forwarded to listener for handling)", exception);
				try {
					listener.onRuntimeExceptionInListener(exception);
				} catch (RuntimeException runtimeException) {
					ModelUtil.logException(
						"Notifying listener about change in a model element failed, UI may not update properly now.",
						runtimeException);
					listenersToBeRemoved.add(listener);
				}
			}
			// END SUPRESS CATCH EXCEPTION
		}
		isNotifying=false;
		for (ModelElementChangeListener listener : listenersToBeRemoved) {
			removeModelElementChangeListener(listener);
		}
		listenersToBeRemoved.clear();
	}

	/**
	 * @see org.unicase.model.UnicaseModelElement#delete()
	 */
	public void delete() {
		Project project = this.getProject();
		if (project == null) {
			throw new IllegalStateException("Model element is not contained in a project, it cannot be deleted.");
		}
		project.deleteModelElement(this);

	}

	/**
	 * @see org.unicase.model.UnicaseModelElement#getAllContainedModelElements()
	 */
	public Set<ModelElement> getAllContainedModelElements() {
		Set<ModelElement> result = new HashSet<ModelElement>();
		for (EObject containee : this.eContents()) {
			if (MetamodelPackage.eINSTANCE.getModelElement().isInstance(containee)) {
				ModelElement containeeModelElement = (ModelElement) containee;
				Set<ModelElement> elements = containeeModelElement.getAllContainedModelElements();
				result.add(containeeModelElement);
				result.addAll(elements);
			}
		}
		return result;
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.unicase.model.UnicaseModelElement#getReferencedModelElements()
	 */
	public Set<ModelElement> getCrossReferencedModelElements() {
		Set<ModelElement> result = new HashSet<ModelElement>();
		for (EObject crossReference : this.eCrossReferences()) {
			if (MetamodelPackage.eINSTANCE.getModelElement().isInstance(crossReference)) {
				result.add((ModelElement) crossReference);
			}
		}
		return result;
	}

	/**
	 * @see org.unicase.model.UnicaseModelElement#getContainedModelElements()
	 */
	public Set<ModelElement> getContainedElements() {
		Set<ModelElement> result = new HashSet<ModelElement>();
		for (EObject containee : this.eContents()) {
			if (MetamodelPackage.eINSTANCE.getModelElement().isInstance(containee)) {
				result.add((ModelElement) containee);
			}
		}
		return result;
	}

	/**
	 * @see org.unicase.model.UnicaseModelElement#getContainerModelElement()
	 */
	public ModelElement getContainerModelElement() {
		EObject container = this.eContainer();
		if (container == null) {
			return null;
		}
		if (MetamodelPackage.eINSTANCE.getModelElement().isInstance(container)) {
			return (ModelElement) container;
		}
		return null;
	}

	/**
	 * @see org.unicase.model.UnicaseModelElement#getLinkedModelElements()
	 */
	public Set<ModelElement> getLinkedModelElements() {
		Set<ModelElement> result = new HashSet<ModelElement>();
		for (EObject referencedEObject : this.eCrossReferences()) {
			if (MetamodelPackage.eINSTANCE.getModelElement().isInstance(referencedEObject)) {
				result.add((ModelElement) referencedEObject);
			}
		}
		return result;
	}

	/**
	 * The default value of the '{@link #getCreator() <em>Creator</em>}' attribute. <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * 
	 * @see #getCreator()
	 * @generated
	 * @ordered
	 */
	protected static final String CREATOR_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getCreator() <em>Creator</em>}' attribute. <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * 
	 * @see #getCreator()
	 * @generated
	 * @ordered
	 */
	protected String creator = CREATOR_EDEFAULT;

	/**
	 * The default value of the '{@link #getCreationDate() <em>Creation Date</em>}' attribute. <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @see #getCreationDate()
	 * @generated
	 * @ordered
	 */
	protected static final Date CREATION_DATE_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getCreationDate() <em>Creation Date</em>}' attribute. <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @see #getCreationDate()
	 * @generated
	 * @ordered
	 */
	protected Date creationDate = CREATION_DATE_EDEFAULT;

	private List<ModelElementChangeListener> changeListeners;

	private AdapterImpl internalChangeListener;

	private boolean isNotifying;

	private Set<ModelElementChangeListener> listenersToBeRemoved;

	// begin of custom code
	/**
	 * Constructor.
	 * 
	 * @generated NOT
	 */
	protected ModelElementImpl() {
		super();
		changeListeners = new ArrayList<ModelElementChangeListener>();
		isNotifying=false;
		listenersToBeRemoved = new HashSet<ModelElementChangeListener>();
	}

	// end of custom code

	/**
	 * <!-- begin-user-doc --> .<!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return MetamodelPackage.Literals.MODEL_ELEMENT;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public String getCreator() {
		return creator;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public void setCreator(String newCreator) {
		String oldCreator = creator;
		creator = newCreator;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, MetamodelPackage.MODEL_ELEMENT__CREATOR, oldCreator,
				creator));
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public Date getCreationDate() {
		return creationDate;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public void setCreationDate(Date newCreationDate) {
		Date oldCreationDate = creationDate;
		creationDate = newCreationDate;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, MetamodelPackage.MODEL_ELEMENT__CREATION_DATE,
				oldCreationDate, creationDate));
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
		case MetamodelPackage.MODEL_ELEMENT__CREATOR:
			return getCreator();
		case MetamodelPackage.MODEL_ELEMENT__CREATION_DATE:
			return getCreationDate();
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
		case MetamodelPackage.MODEL_ELEMENT__CREATOR:
			setCreator((String) newValue);
			return;
		case MetamodelPackage.MODEL_ELEMENT__CREATION_DATE:
			setCreationDate((Date) newValue);
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
		case MetamodelPackage.MODEL_ELEMENT__CREATOR:
			setCreator(CREATOR_EDEFAULT);
			return;
		case MetamodelPackage.MODEL_ELEMENT__CREATION_DATE:
			setCreationDate(CREATION_DATE_EDEFAULT);
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
		case MetamodelPackage.MODEL_ELEMENT__CREATOR:
			return CREATOR_EDEFAULT == null ? creator != null : !CREATOR_EDEFAULT.equals(creator);
		case MetamodelPackage.MODEL_ELEMENT__CREATION_DATE:
			return CREATION_DATE_EDEFAULT == null ? creationDate != null : !CREATION_DATE_EDEFAULT.equals(creationDate);
		}
		return super.eIsSet(featureID);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->.
	 * 
	 * @generated NOT
	 * @return the project in which the modelelement is contained or null if it not in any project.
	 */
	public Project getProject() {

		Set<ModelElement> seenModelElements = new HashSet<ModelElement>();
		seenModelElements.add(this);
		return getProject(seenModelElements);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->.
	 * 
	 * @generated NOT
	 * @return the project in which the modelelement is contained or null if it not in any project.
	 */
	private Project getProject(Set<ModelElement> seenModelElements) {

		EObject container = this.eContainer();

		if (container == null) {
			return null;
		}

		if (seenModelElements.contains(container)) {
			throw new IllegalStateException("ModelElement is in a containment cycle");
		}
		// check if my container is a project
		if (MetamodelPackage.eINSTANCE.getProject().isInstance(container)) {
			return (Project) container;
		}
		// check if my container is a model element
		else if (container instanceof ModelElementImpl) {
			// seenModelElements.add(this);
			seenModelElements.add((ModelElement) container);
			return ((ModelElementImpl) container).getProject(seenModelElements);
		} else {
			throw new IllegalStateException("ModelElement is not contained by any project");
		}
	}

	// begin of custom code
	/**
	 * {@inheritDoc}
	 * 
	 * @see org.unicase.model.UnicaseModelElement#getModelElementId()
	 */
	public ModelElementId getModelElementId() {
		if (this.identifier == null) {
			throw new IllegalStateException("Model element does not have an identifier");
		}
		ModelElementId modelElementId = MetamodelFactory.eINSTANCE.createModelElementId();
		modelElementId.setId(this.identifier);
		return modelElementId;
	}

	// end of custom code

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
		result.append(" (creator: ");
		result.append(creator);
		result.append(", creationDate: ");
		result.append(creationDate);
		result.append(')');
		return result.toString();
	}

} // ModelElementImpl
