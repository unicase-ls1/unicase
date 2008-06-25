/**
 * <copyright> Copyright (c) 2008 Jonas Helming, Maximilian Kšgel. All rights reserved. This program and the accompanying materials are made available under the terms of the Eclipse Public License v1.0 which accompanies this distribution, and is available at http://www.eclipse.org/legal/epl-v10.html
 * </copyright>
 *
 * $Id$
 */
package org.unicase.model.impl;

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
import org.eclipse.emf.ecore.util.EObjectWithInverseResolvingEList;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.ecore.util.InternalEList;
import org.unicase.model.Annotation;
import org.unicase.model.ModelElement;
import org.unicase.model.ModelElementId;
import org.unicase.model.ModelFactory;
import org.unicase.model.ModelPackage;
import org.unicase.model.Project;
import org.unicase.model.ReaderInfo;
import org.unicase.model.document.DocumentPackage;
import org.unicase.model.document.LeafSection;
import org.unicase.model.organization.User;
import org.unicase.model.task.MEState;
import org.unicase.model.task.TaskFactory;
import org.unicase.model.task.util.CircularDependencyException;

/**
 * <!-- begin-user-doc --> An implementation of the model object '
 * <em><b>Element</b></em>'. <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.unicase.model.impl.ModelElementImpl#getName <em>Name</em>}</li>
 *   <li>{@link org.unicase.model.impl.ModelElementImpl#getDescription <em>Description</em>}</li>
 *   <li>{@link org.unicase.model.impl.ModelElementImpl#getIdentifier <em>Identifier</em>}</li>
 *   <li>{@link org.unicase.model.impl.ModelElementImpl#getReaderInfos <em>Reader Infos</em>}</li>
 *   <li>{@link org.unicase.model.impl.ModelElementImpl#getAnnotations <em>Annotations</em>}</li>
 *   <li>{@link org.unicase.model.impl.ModelElementImpl#getIncomingDocumentReferences <em>Incoming Document References</em>}</li>
 *   <li>{@link org.unicase.model.impl.ModelElementImpl#getLeafSection <em>Leaf Section</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public abstract class ModelElementImpl extends EObjectImpl implements
		ModelElement {
	/**
	 * The default value of the '{@link #getName() <em>Name</em>}' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @see #getName()
	 * @generated
	 * @ordered
	 */
	protected static final String NAME_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getName() <em>Name</em>}' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @see #getName()
	 * @generated
	 * @ordered
	 */
	protected String name = NAME_EDEFAULT;

	/**
	 * The default value of the '{@link #getDescription() <em>Description</em>}' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @see #getDescription()
	 * @generated
	 * @ordered
	 */
	protected static final String DESCRIPTION_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getDescription() <em>Description</em>}' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @see #getDescription()
	 * @generated
	 * @ordered
	 */
	protected String description = DESCRIPTION_EDEFAULT;

	/**
	 * The cached value of the '{@link #getIdentifier() <em>Identifier</em>}' containment reference.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @see #getIdentifier()
	 * @generated
	 * @ordered
	 */
	protected ModelElementId identifier;

	/**
	 * The cached value of the '{@link #getReaderInfos() <em>Reader Infos</em>}' containment reference list.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @see #getReaderInfos()
	 * @generated
	 * @ordered
	 */
	protected EList<ReaderInfo> readerInfos;

	/**
	 * The cached value of the '{@link #getAnnotations() <em>Annotations</em>}' reference list.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @see #getAnnotations()
	 * @generated
	 * @ordered
	 */
	protected EList<Annotation> annotations;

	/**
	 * The cached value of the '{@link #getIncomingDocumentReferences()
	 * <em>Incoming Document References</em>}' reference list. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see #getIncomingDocumentReferences()
	 * @generated
	 * @ordered
	 */
	protected EList<LeafSection> incomingDocumentReferences;

	private boolean calculatingState;

	// begin of custom code
	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated NOT
	 */
	protected ModelElementImpl() {
		super();
		this.identifier = ModelFactory.eINSTANCE.createModelElementId();
	}

	// end of custom code

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return ModelPackage.Literals.MODEL_ELEMENT;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public String getName() {
		return name;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public void setName(String newName) {
		String oldName = name;
		name = newName;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET,
					ModelPackage.MODEL_ELEMENT__NAME, oldName, name));
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public String getDescription() {
		return description;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public void setDescription(String newDescription) {
		String oldDescription = description;
		description = newDescription;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET,
					ModelPackage.MODEL_ELEMENT__DESCRIPTION, oldDescription,
					description));
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public ModelElementId getIdentifier() {
		return identifier;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetIdentifier(ModelElementId newIdentifier,
			NotificationChain msgs) {
		ModelElementId oldIdentifier = identifier;
		identifier = newIdentifier;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this,
					Notification.SET, ModelPackage.MODEL_ELEMENT__IDENTIFIER,
					oldIdentifier, newIdentifier);
			if (msgs == null)
				msgs = notification;
			else
				msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public void setIdentifier(ModelElementId newIdentifier) {
		if (newIdentifier != identifier) {
			NotificationChain msgs = null;
			if (identifier != null)
				msgs = ((InternalEObject) identifier).eInverseRemove(this,
						EOPPOSITE_FEATURE_BASE
								- ModelPackage.MODEL_ELEMENT__IDENTIFIER, null,
						msgs);
			if (newIdentifier != null)
				msgs = ((InternalEObject) newIdentifier).eInverseAdd(this,
						EOPPOSITE_FEATURE_BASE
								- ModelPackage.MODEL_ELEMENT__IDENTIFIER, null,
						msgs);
			msgs = basicSetIdentifier(newIdentifier, msgs);
			if (msgs != null)
				msgs.dispatch();
		} else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET,
					ModelPackage.MODEL_ELEMENT__IDENTIFIER, newIdentifier,
					newIdentifier));
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EList<ReaderInfo> getReaderInfos() {
		if (readerInfos == null) {
			readerInfos = new EObjectContainmentEList<ReaderInfo>(
					ReaderInfo.class, this,
					ModelPackage.MODEL_ELEMENT__READER_INFOS);
		}
		return readerInfos;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EList<Annotation> getAnnotations() {
		if (annotations == null) {
			annotations = new EObjectWithInverseResolvingEList.ManyInverse<Annotation>(
					Annotation.class, this,
					ModelPackage.MODEL_ELEMENT__ANNOTATIONS,
					ModelPackage.ANNOTATION__ANNOTATED_MODEL_ELEMENTS);
		}
		return annotations;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EList<LeafSection> getIncomingDocumentReferences() {
		if (incomingDocumentReferences == null) {
			incomingDocumentReferences = new EObjectResolvingEList<LeafSection>(
					LeafSection.class, this,
					ModelPackage.MODEL_ELEMENT__INCOMING_DOCUMENT_REFERENCES);
		}
		return incomingDocumentReferences;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public LeafSection getLeafSection() {
		if (eContainerFeatureID != ModelPackage.MODEL_ELEMENT__LEAF_SECTION)
			return null;
		return (LeafSection) eContainer();
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetLeafSection(LeafSection newLeafSection,
			NotificationChain msgs) {
		msgs = eBasicSetContainer((InternalEObject) newLeafSection,
				ModelPackage.MODEL_ELEMENT__LEAF_SECTION, msgs);
		return msgs;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public void setLeafSection(LeafSection newLeafSection) {
		if (newLeafSection != eInternalContainer()
				|| (eContainerFeatureID != ModelPackage.MODEL_ELEMENT__LEAF_SECTION && newLeafSection != null)) {
			if (EcoreUtil.isAncestor(this, newLeafSection))
				throw new IllegalArgumentException(
						"Recursive containment not allowed for " + toString());
			NotificationChain msgs = null;
			if (eInternalContainer() != null)
				msgs = eBasicRemoveFromContainer(msgs);
			if (newLeafSection != null)
				msgs = ((InternalEObject) newLeafSection).eInverseAdd(this,
						DocumentPackage.LEAF_SECTION__MODEL_ELEMENTS,
						LeafSection.class, msgs);
			msgs = basicSetLeafSection(newLeafSection, msgs);
			if (msgs != null)
				msgs.dispatch();
		} else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET,
					ModelPackage.MODEL_ELEMENT__LEAF_SECTION, newLeafSection,
					newLeafSection));
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated NOT
	 */
	public Project getProject() {
		// check if my container is a project
		if (ModelPackage.eINSTANCE.getProject().isInstance(this.eContainer)) {
			return (Project) this.eContainer();
		}
		// check if my container is a model element
		else if (ModelPackage.eINSTANCE.getModelElement().isInstance(
				this.eContainer)) {
			return ((ModelElement) this.eContainer()).getProject();
		} else {
			// FIXME MK
			throw new IllegalStateException(
					"ModelElement is not contained by any project");
		}
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public void addReader(User readerName) {
		// TODO: implement this method
		// Ensure that you remove @generated or mark it @generated NOT
		throw new UnsupportedOperationException();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void getMEState() {
		// TODO: implement this method
		// Ensure that you remove @generated or mark it @generated NOT
		throw new UnsupportedOperationException();
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	@Override
	public NotificationChain eInverseAdd(InternalEObject otherEnd,
			int featureID, NotificationChain msgs) {
		switch (featureID) {
		case ModelPackage.MODEL_ELEMENT__ANNOTATIONS:
			return ((InternalEList<InternalEObject>) (InternalEList<?>) getAnnotations())
					.basicAdd(otherEnd, msgs);
		case ModelPackage.MODEL_ELEMENT__LEAF_SECTION:
			if (eInternalContainer() != null)
				msgs = eBasicRemoveFromContainer(msgs);
			return basicSetLeafSection((LeafSection) otherEnd, msgs);
		}
		return super.eInverseAdd(otherEnd, featureID, msgs);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd,
			int featureID, NotificationChain msgs) {
		switch (featureID) {
		case ModelPackage.MODEL_ELEMENT__IDENTIFIER:
			return basicSetIdentifier(null, msgs);
		case ModelPackage.MODEL_ELEMENT__READER_INFOS:
			return ((InternalEList<?>) getReaderInfos()).basicRemove(otherEnd,
					msgs);
		case ModelPackage.MODEL_ELEMENT__ANNOTATIONS:
			return ((InternalEList<?>) getAnnotations()).basicRemove(otherEnd,
					msgs);
		case ModelPackage.MODEL_ELEMENT__LEAF_SECTION:
			return basicSetLeafSection(null, msgs);
		}
		return super.eInverseRemove(otherEnd, featureID, msgs);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eBasicRemoveFromContainerFeature(
			NotificationChain msgs) {
		switch (eContainerFeatureID) {
		case ModelPackage.MODEL_ELEMENT__LEAF_SECTION:
			return eInternalContainer().eInverseRemove(this,
					DocumentPackage.LEAF_SECTION__MODEL_ELEMENTS,
					LeafSection.class, msgs);
		}
		return super.eBasicRemoveFromContainerFeature(msgs);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
		case ModelPackage.MODEL_ELEMENT__NAME:
			return getName();
		case ModelPackage.MODEL_ELEMENT__DESCRIPTION:
			return getDescription();
		case ModelPackage.MODEL_ELEMENT__IDENTIFIER:
			return getIdentifier();
		case ModelPackage.MODEL_ELEMENT__READER_INFOS:
			return getReaderInfos();
		case ModelPackage.MODEL_ELEMENT__ANNOTATIONS:
			return getAnnotations();
		case ModelPackage.MODEL_ELEMENT__INCOMING_DOCUMENT_REFERENCES:
			return getIncomingDocumentReferences();
		case ModelPackage.MODEL_ELEMENT__LEAF_SECTION:
			return getLeafSection();
		}
		return super.eGet(featureID, resolve, coreType);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	@Override
	public void eSet(int featureID, Object newValue) {
		switch (featureID) {
		case ModelPackage.MODEL_ELEMENT__NAME:
			setName((String) newValue);
			return;
		case ModelPackage.MODEL_ELEMENT__DESCRIPTION:
			setDescription((String) newValue);
			return;
		case ModelPackage.MODEL_ELEMENT__IDENTIFIER:
			setIdentifier((ModelElementId) newValue);
			return;
		case ModelPackage.MODEL_ELEMENT__READER_INFOS:
			getReaderInfos().clear();
			getReaderInfos()
					.addAll((Collection<? extends ReaderInfo>) newValue);
			return;
		case ModelPackage.MODEL_ELEMENT__ANNOTATIONS:
			getAnnotations().clear();
			getAnnotations()
					.addAll((Collection<? extends Annotation>) newValue);
			return;
		case ModelPackage.MODEL_ELEMENT__INCOMING_DOCUMENT_REFERENCES:
			getIncomingDocumentReferences().clear();
			getIncomingDocumentReferences().addAll(
					(Collection<? extends LeafSection>) newValue);
			return;
		case ModelPackage.MODEL_ELEMENT__LEAF_SECTION:
			setLeafSection((LeafSection) newValue);
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
		case ModelPackage.MODEL_ELEMENT__NAME:
			setName(NAME_EDEFAULT);
			return;
		case ModelPackage.MODEL_ELEMENT__DESCRIPTION:
			setDescription(DESCRIPTION_EDEFAULT);
			return;
		case ModelPackage.MODEL_ELEMENT__IDENTIFIER:
			setIdentifier((ModelElementId) null);
			return;
		case ModelPackage.MODEL_ELEMENT__READER_INFOS:
			getReaderInfos().clear();
			return;
		case ModelPackage.MODEL_ELEMENT__ANNOTATIONS:
			getAnnotations().clear();
			return;
		case ModelPackage.MODEL_ELEMENT__INCOMING_DOCUMENT_REFERENCES:
			getIncomingDocumentReferences().clear();
			return;
		case ModelPackage.MODEL_ELEMENT__LEAF_SECTION:
			setLeafSection((LeafSection) null);
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
		case ModelPackage.MODEL_ELEMENT__NAME:
			return NAME_EDEFAULT == null ? name != null : !NAME_EDEFAULT
					.equals(name);
		case ModelPackage.MODEL_ELEMENT__DESCRIPTION:
			return DESCRIPTION_EDEFAULT == null ? description != null
					: !DESCRIPTION_EDEFAULT.equals(description);
		case ModelPackage.MODEL_ELEMENT__IDENTIFIER:
			return identifier != null;
		case ModelPackage.MODEL_ELEMENT__READER_INFOS:
			return readerInfos != null && !readerInfos.isEmpty();
		case ModelPackage.MODEL_ELEMENT__ANNOTATIONS:
			return annotations != null && !annotations.isEmpty();
		case ModelPackage.MODEL_ELEMENT__INCOMING_DOCUMENT_REFERENCES:
			return incomingDocumentReferences != null
					&& !incomingDocumentReferences.isEmpty();
		case ModelPackage.MODEL_ELEMENT__LEAF_SECTION:
			return getLeafSection() != null;
		}
		return super.eIsSet(featureID);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String toString() {
		if (eIsProxy())
			return super.toString();

		StringBuffer result = new StringBuffer(super.toString());
		result.append(" (name: ");
		result.append(name);
		result.append(", description: ");
		result.append(description);
		result.append(')');
		return result.toString();
	}

	/**
	 * Returns true if the other model elements id is identical. False in any
	 * other case.
	 * 
	 * @see java.lang.Object#equals(java.lang.Object)
	 * @generated NOT
	 */
	@Override
	public boolean equals(Object otherObject) {
		if (otherObject instanceof ModelElementImpl) {
			ModelElementImpl otherModelElement = (ModelElementImpl) otherObject;
			return otherModelElement.getIdentifier().equals(
					this.getIdentifier());
		} else {
			return false;
		}
	}

	@Override
	public int hashCode() {
		return this.identifier.hashCode();
	}

} // ModelElementImpl
