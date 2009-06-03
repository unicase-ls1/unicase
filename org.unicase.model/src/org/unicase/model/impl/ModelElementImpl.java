/**
 * <copyright> Copyright (c) 2008 Jonas Helming, Maximilian Koegel. All rights reserved. This program and the
 * accompanying materials are made available under the terms of the Eclipse Public License v1.0 which accompanies this
 * distribution, and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>
 */
package org.unicase.model.impl;

import java.util.Collection;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.util.EObjectContainmentWithInverseEList;
import org.eclipse.emf.ecore.util.EObjectWithInverseResolvingEList;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.ecore.util.InternalEList;
import org.unicase.model.Annotation;
import org.unicase.model.Attachment;
import org.unicase.model.ModelElement;
import org.unicase.model.ModelElementId;
import org.unicase.model.ModelFactory;
import org.unicase.model.ModelPackage;
import org.unicase.model.Project;
import org.unicase.model.document.DocumentPackage;
import org.unicase.model.document.LeafSection;
import org.unicase.model.profile.ProfilePackage;
import org.unicase.model.profile.StereotypeInstance;
import org.unicase.model.rationale.Comment;
import org.unicase.model.rationale.RationalePackage;
import org.unicase.model.task.util.CircularDependencyException;
import org.unicase.model.task.util.MEState;
import org.unicase.model.task.util.MEStateImpl;

/*
 * <!-- begin-user-doc --> An implementation of the model object ' <em><b>Element</b></em>'. <!-- end-user-doc --> <p>
 * The following features are implemented: <ul> <li>{@link org.unicase.model.impl.ModelElementImpl#getName
 * <em>Name</em>}</li> <li>{@link org.unicase.model.impl.ModelElementImpl#getDescription <em>Description</em>}</li>
 * <li>{@link org.unicase.model.impl.ModelElementImpl#getCreator <em>Creator</em>}</li> <li>{@link
 * org.unicase.model.impl.ModelElementImpl#getCreationDate <em>Creation Date</em>}</li> <li>{@link
 * org.unicase.model.impl.ModelElementImpl#getAnnotations <em>Annotations</em>}</li> <li>{@link
 * org.unicase.model.impl.ModelElementImpl#getAttachments <em>Attachments</em>}</li> <li>{@link
 * org.unicase.model.impl.ModelElementImpl#getIncomingDocumentReferences <em>Incoming Document References</em>}</li>
 * <li>{@link org.unicase.model.impl.ModelElementImpl#getLeafSection <em>Leaf Section</em>}</li> <li>{@link
 * org.unicase.model.impl.ModelElementImpl#getState <em>State</em>}</li> <li>{@link
 * org.unicase.model.impl.ModelElementImpl#getAppliedStereotypeInstances <em>Applied Stereotype Instances</em>}</li>
 * <li>{@link org.unicase.model.impl.ModelElementImpl#getComments <em>Comments</em>}</li> </ul> </p>
 * @generated
 */
public abstract class ModelElementImpl extends IdentifiableElementImpl implements ModelElement {

	/**
	 * @see org.unicase.model.ModelElement#delete()
	 */
	public void delete() {
		Project project = this.getProject();
		if (project == null) {
			throw new IllegalStateException("Model element is not contained in a project, it cannot be deleted.");
		}
		project.deleteModelElement(this);

	}

	/**
	 * @see org.unicase.model.ModelElement#getAllContainedModelElements()
	 */
	public Set<ModelElement> getAllContainedModelElements() {
		Set<ModelElement> result = new HashSet<ModelElement>();
		for (EObject containee : this.eContents()) {
			if (ModelPackage.eINSTANCE.getModelElement().isInstance(containee)) {
				ModelElement containeeModelElement = (ModelElement) containee;
				Set<ModelElement> elements = containeeModelElement.getAllContainedModelElements();
				result.add(containeeModelElement);
				result.addAll(elements);
			}
		}
		return result;
	}

	/**
	 * @see org.unicase.model.ModelElement#getContainedModelElements()
	 */
	public Set<ModelElement> getContainedElements() {
		Set<ModelElement> result = new HashSet<ModelElement>();
		for (EObject containee : this.eContents()) {
			if (ModelPackage.eINSTANCE.getModelElement().isInstance(containee)) {
				result.add((ModelElement) containee);
			}
		}
		return result;
	}

	/**
	 * @see org.unicase.model.ModelElement#getContainerModelElement()
	 */
	public ModelElement getContainerModelElement() {
		EObject container = this.eContainer();
		if (container == null) {
			return null;
		}
		if (ModelPackage.eINSTANCE.getModelElement().isInstance(container)) {
			return (ModelElement) container;
		}
		return null;
	}

	/**
	 * @see org.unicase.model.ModelElement#getLinkedModelElements()
	 */
	public Set<ModelElement> getLinkedModelElements() {
		Set<ModelElement> result = new HashSet<ModelElement>();
		for (EObject referencedEObject : this.eCrossReferences()) {
			if (ModelPackage.eINSTANCE.getModelElement().isInstance(referencedEObject)) {
				result.add((ModelElement) referencedEObject);
			}
		}
		return result;
	}

	private static final String BEGINNTEXT = "%BEGINNTEXT%";

	/**
	 * The default value of the '{@link #getName() <em>Name</em>}' attribute. <!-- begin-user-doc --> <!-- end-user-doc
	 * -->
	 * 
	 * @see #getName()
	 * @generated
	 * @ordered
	 */
	protected static final String NAME_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getName() <em>Name</em>}' attribute. <!-- begin-user-doc --> <!-- end-user-doc
	 * -->
	 * 
	 * @see #getName()
	 * @generated
	 * @ordered
	 */
	protected String name = NAME_EDEFAULT;

	/**
	 * The default value of the '{@link #getDescription() <em>Description</em>}' attribute.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * @see #getDescription()
	 * @generated
	 * @ordered
	 */
	protected static final String DESCRIPTION_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getDescription() <em>Description</em>}' attribute.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * @see #getDescription()
	 * @generated
	 * @ordered
	 */
	protected String description = DESCRIPTION_EDEFAULT;

	/**
	 * The default value of the '{@link #getCreator() <em>Creator</em>}' attribute.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * @see #getCreator()
	 * @generated
	 * @ordered
	 */
	protected static final String CREATOR_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getCreator() <em>Creator</em>}' attribute.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * @see #getCreator()
	 * @generated
	 * @ordered
	 */
	protected String creator = CREATOR_EDEFAULT;

	/**
	 * The default value of the '{@link #getCreationDate() <em>Creation Date</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getCreationDate()
	 * @generated
	 * @ordered
	 */
	protected static final Date CREATION_DATE_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getCreationDate() <em>Creation Date</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getCreationDate()
	 * @generated
	 * @ordered
	 */
	protected Date creationDate = CREATION_DATE_EDEFAULT;

	/**
	 * The cached value of the '{@link #getAnnotations() <em>Annotations</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getAnnotations()
	 * @generated
	 * @ordered
	 */
	protected EList<Annotation> annotations;

	/**
	 * The cached value of the '{@link #getAttachments() <em>Attachments</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getAttachments()
	 * @generated
	 * @ordered
	 */
	protected EList<Attachment> attachments;

	/**
	 * The cached value of the '{@link #getIncomingDocumentReferences() <em>Incoming Document References</em>}' reference list.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @see #getIncomingDocumentReferences()
	 * @generated
	 * @ordered
	 */
	protected EList<LeafSection> incomingDocumentReferences;

	/**
	 * The default value of the '{@link #getState() <em>State</em>}' attribute.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * @see #getState()
	 * @generated
	 * @ordered
	 */
	protected static final String STATE_EDEFAULT = "";

	/**
	 * The cached value of the '{@link #getAppliedStereotypeInstances() <em>Applied Stereotype Instances</em>}' containment reference list.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @see #getAppliedStereotypeInstances()
	 * @generated
	 * @ordered
	 */
	protected EList<StereotypeInstance> appliedStereotypeInstances;

	/**
	 * The cached value of the '{@link #getComments() <em>Comments</em>}' containment reference list. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see #getComments()
	 * @generated
	 * @ordered
	 */
	protected EList<Comment> comments;

	private boolean calculatingState;

	private org.unicase.model.task.util.MEState meState;

	// begin of custom code
	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated NOT
	 */
	protected ModelElementImpl() {
		// MK: Document why this is so.
		super();

		// TODO AS activate this when the models on the server are fixed.
		// name = "new " + eClass().getName();
	}

	// end of custom code

	/**
	 * <!-- begin-user-doc --> .<!-- end-user-doc -->
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
			eNotify(new ENotificationImpl(this, Notification.SET, ModelPackage.MODEL_ELEMENT__NAME, oldName, name));
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
			eNotify(new ENotificationImpl(this, Notification.SET, ModelPackage.MODEL_ELEMENT__DESCRIPTION,
				oldDescription, description));
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public String getCreator() {
		return creator;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public void setCreator(String newCreator) {
		String oldCreator = creator;
		creator = newCreator;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ModelPackage.MODEL_ELEMENT__CREATOR, oldCreator,
				creator));
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public Date getCreationDate() {
		return creationDate;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public void setCreationDate(Date newCreationDate) {
		Date oldCreationDate = creationDate;
		creationDate = newCreationDate;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ModelPackage.MODEL_ELEMENT__CREATION_DATE,
				oldCreationDate, creationDate));
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EList<Annotation> getAnnotations() {
		if (annotations == null) {
			annotations = new EObjectWithInverseResolvingEList.ManyInverse<Annotation>(Annotation.class, this,
				ModelPackage.MODEL_ELEMENT__ANNOTATIONS, ModelPackage.ANNOTATION__ANNOTATED_MODEL_ELEMENTS);
		}
		return annotations;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EList<Attachment> getAttachments() {
		if (attachments == null) {
			attachments = new EObjectWithInverseResolvingEList.ManyInverse<Attachment>(Attachment.class, this,
				ModelPackage.MODEL_ELEMENT__ATTACHMENTS, ModelPackage.ATTACHMENT__REFERRING_MODEL_ELEMENTS);
		}
		return attachments;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EList<LeafSection> getIncomingDocumentReferences() {
		if (incomingDocumentReferences == null) {
			incomingDocumentReferences = new EObjectWithInverseResolvingEList.ManyInverse<LeafSection>(
				LeafSection.class, this, ModelPackage.MODEL_ELEMENT__INCOMING_DOCUMENT_REFERENCES,
				DocumentPackage.LEAF_SECTION__REFERENCED_MODEL_ELEMENTS);
		}
		return incomingDocumentReferences;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public LeafSection getLeafSection() {
		if (eContainerFeatureID() != ModelPackage.MODEL_ELEMENT__LEAF_SECTION)
			return null;
		return (LeafSection) eContainer();
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public LeafSection basicGetLeafSection() {
		if (eContainerFeatureID() != ModelPackage.MODEL_ELEMENT__LEAF_SECTION)
			return null;
		return (LeafSection) eInternalContainer();
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetLeafSection(LeafSection newLeafSection, NotificationChain msgs) {
		msgs = eBasicSetContainer((InternalEObject) newLeafSection, ModelPackage.MODEL_ELEMENT__LEAF_SECTION, msgs);
		return msgs;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public void setLeafSection(LeafSection newLeafSection) {
		if (newLeafSection != eInternalContainer()
			|| (eContainerFeatureID() != ModelPackage.MODEL_ELEMENT__LEAF_SECTION && newLeafSection != null)) {
			if (EcoreUtil.isAncestor(this, newLeafSection))
				throw new IllegalArgumentException("Recursive containment not allowed for " + toString());
			NotificationChain msgs = null;
			if (eInternalContainer() != null)
				msgs = eBasicRemoveFromContainer(msgs);
			if (newLeafSection != null)
				msgs = ((InternalEObject) newLeafSection).eInverseAdd(this,
					DocumentPackage.LEAF_SECTION__MODEL_ELEMENTS, LeafSection.class, msgs);
			msgs = basicSetLeafSection(newLeafSection, msgs);
			if (msgs != null)
				msgs.dispatch();
		} else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ModelPackage.MODEL_ELEMENT__LEAF_SECTION,
				newLeafSection, newLeafSection));
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated NOT
	 * @return The state of the model element
	 */
	public String getState() {
		try {
			return getMEState().getStatus();
		} catch (CircularDependencyException e) {
			// JH: insert proper exception handling
			// e.printStackTrace();
			return MEState.CLOSED;
		}
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EList<StereotypeInstance> getAppliedStereotypeInstances() {
		if (appliedStereotypeInstances == null) {
			appliedStereotypeInstances = new EObjectContainmentWithInverseEList.Resolving<StereotypeInstance>(
				StereotypeInstance.class, this, ModelPackage.MODEL_ELEMENT__APPLIED_STEREOTYPE_INSTANCES,
				ProfilePackage.STEREOTYPE_INSTANCE__MODEL_ELEMENT);
		}
		return appliedStereotypeInstances;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EList<Comment> getComments() {
		if (comments == null) {
			comments = new EObjectContainmentWithInverseEList.Resolving<Comment>(Comment.class, this,
				ModelPackage.MODEL_ELEMENT__COMMENTS, RationalePackage.COMMENT__COMMENTED_ELEMENT);
		}
		return comments;
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
		if (ModelPackage.eINSTANCE.getProject().isInstance(container)) {
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

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @throws CircularDependencyException
	 * @generated NOT
	 */
	public org.unicase.model.task.util.MEState getMEState() throws CircularDependencyException {
		if (meState == null) {
			synchronized (this) {
				if (meState == null) {
					if (calculatingState) {
						throw new CircularDependencyException(this);
					}
					calculatingState = true;
					meState = new MEStateImpl(this);
					calculatingState = false;
				}
			}
		}
		return meState;
	}

	// begin of custom code
	/**
	 * {@inheritDoc}
	 * 
	 * @see org.unicase.model.ModelElement#getModelElementId()
	 */
	public ModelElementId getModelElementId() {
		if (this.identifier == null) {
			throw new IllegalStateException("Model element does not have an identifier");
		}
		ModelElementId modelElementId = ModelFactory.eINSTANCE.createModelElementId();
		modelElementId.setId(this.identifier);
		return modelElementId;
	}

	/**
	 * use WorkspaceUtil.cleanFormatedText() instead.
	 * 
	 * @see org.unciase.workspace.util.WorkspaceUtil#cleanFormatedText() {@inheritDoc}
	 * @see org.unicase.model.ModelElement#getDescriptionPlainText()
	 * @return the plain description text
	 * @generated NOT
	 * @Deprecated
	 */
	public String getDescriptionPlainText() {
		String ret = "";
		String description = getDescription();
		if (description != null && description.length() > 0) {
			String[] split = description.split(BEGINNTEXT);
			if (split.length > 1) {
				ret = split[split.length - 1];
			}
		}
		return ret;
	}

	// end of custom code

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	@Override
	public NotificationChain eInverseAdd(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
		case ModelPackage.MODEL_ELEMENT__ANNOTATIONS:
			return ((InternalEList<InternalEObject>) (InternalEList<?>) getAnnotations()).basicAdd(otherEnd, msgs);
		case ModelPackage.MODEL_ELEMENT__ATTACHMENTS:
			return ((InternalEList<InternalEObject>) (InternalEList<?>) getAttachments()).basicAdd(otherEnd, msgs);
		case ModelPackage.MODEL_ELEMENT__INCOMING_DOCUMENT_REFERENCES:
			return ((InternalEList<InternalEObject>) (InternalEList<?>) getIncomingDocumentReferences()).basicAdd(
				otherEnd, msgs);
		case ModelPackage.MODEL_ELEMENT__LEAF_SECTION:
			if (eInternalContainer() != null)
				msgs = eBasicRemoveFromContainer(msgs);
			return basicSetLeafSection((LeafSection) otherEnd, msgs);
		case ModelPackage.MODEL_ELEMENT__APPLIED_STEREOTYPE_INSTANCES:
			return ((InternalEList<InternalEObject>) (InternalEList<?>) getAppliedStereotypeInstances()).basicAdd(
				otherEnd, msgs);
		case ModelPackage.MODEL_ELEMENT__COMMENTS:
			return ((InternalEList<InternalEObject>) (InternalEList<?>) getComments()).basicAdd(otherEnd, msgs);
		}
		return super.eInverseAdd(otherEnd, featureID, msgs);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
		case ModelPackage.MODEL_ELEMENT__ANNOTATIONS:
			return ((InternalEList<?>) getAnnotations()).basicRemove(otherEnd, msgs);
		case ModelPackage.MODEL_ELEMENT__ATTACHMENTS:
			return ((InternalEList<?>) getAttachments()).basicRemove(otherEnd, msgs);
		case ModelPackage.MODEL_ELEMENT__INCOMING_DOCUMENT_REFERENCES:
			return ((InternalEList<?>) getIncomingDocumentReferences()).basicRemove(otherEnd, msgs);
		case ModelPackage.MODEL_ELEMENT__LEAF_SECTION:
			return basicSetLeafSection(null, msgs);
		case ModelPackage.MODEL_ELEMENT__APPLIED_STEREOTYPE_INSTANCES:
			return ((InternalEList<?>) getAppliedStereotypeInstances()).basicRemove(otherEnd, msgs);
		case ModelPackage.MODEL_ELEMENT__COMMENTS:
			return ((InternalEList<?>) getComments()).basicRemove(otherEnd, msgs);
		}
		return super.eInverseRemove(otherEnd, featureID, msgs);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eBasicRemoveFromContainerFeature(NotificationChain msgs) {
		switch (eContainerFeatureID()) {
		case ModelPackage.MODEL_ELEMENT__LEAF_SECTION:
			return eInternalContainer().eInverseRemove(this, DocumentPackage.LEAF_SECTION__MODEL_ELEMENTS,
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
		case ModelPackage.MODEL_ELEMENT__CREATOR:
			return getCreator();
		case ModelPackage.MODEL_ELEMENT__CREATION_DATE:
			return getCreationDate();
		case ModelPackage.MODEL_ELEMENT__ANNOTATIONS:
			return getAnnotations();
		case ModelPackage.MODEL_ELEMENT__ATTACHMENTS:
			return getAttachments();
		case ModelPackage.MODEL_ELEMENT__INCOMING_DOCUMENT_REFERENCES:
			return getIncomingDocumentReferences();
		case ModelPackage.MODEL_ELEMENT__LEAF_SECTION:
			if (resolve)
				return getLeafSection();
			return basicGetLeafSection();
		case ModelPackage.MODEL_ELEMENT__STATE:
			return getState();
		case ModelPackage.MODEL_ELEMENT__APPLIED_STEREOTYPE_INSTANCES:
			return getAppliedStereotypeInstances();
		case ModelPackage.MODEL_ELEMENT__COMMENTS:
			return getComments();
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
		case ModelPackage.MODEL_ELEMENT__CREATOR:
			setCreator((String) newValue);
			return;
		case ModelPackage.MODEL_ELEMENT__CREATION_DATE:
			setCreationDate((Date) newValue);
			return;
		case ModelPackage.MODEL_ELEMENT__ANNOTATIONS:
			getAnnotations().clear();
			getAnnotations().addAll((Collection<? extends Annotation>) newValue);
			return;
		case ModelPackage.MODEL_ELEMENT__ATTACHMENTS:
			getAttachments().clear();
			getAttachments().addAll((Collection<? extends Attachment>) newValue);
			return;
		case ModelPackage.MODEL_ELEMENT__INCOMING_DOCUMENT_REFERENCES:
			getIncomingDocumentReferences().clear();
			getIncomingDocumentReferences().addAll((Collection<? extends LeafSection>) newValue);
			return;
		case ModelPackage.MODEL_ELEMENT__LEAF_SECTION:
			setLeafSection((LeafSection) newValue);
			return;
		case ModelPackage.MODEL_ELEMENT__APPLIED_STEREOTYPE_INSTANCES:
			getAppliedStereotypeInstances().clear();
			getAppliedStereotypeInstances().addAll((Collection<? extends StereotypeInstance>) newValue);
			return;
		case ModelPackage.MODEL_ELEMENT__COMMENTS:
			getComments().clear();
			getComments().addAll((Collection<? extends Comment>) newValue);
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
		case ModelPackage.MODEL_ELEMENT__CREATOR:
			setCreator(CREATOR_EDEFAULT);
			return;
		case ModelPackage.MODEL_ELEMENT__CREATION_DATE:
			setCreationDate(CREATION_DATE_EDEFAULT);
			return;
		case ModelPackage.MODEL_ELEMENT__ANNOTATIONS:
			getAnnotations().clear();
			return;
		case ModelPackage.MODEL_ELEMENT__ATTACHMENTS:
			getAttachments().clear();
			return;
		case ModelPackage.MODEL_ELEMENT__INCOMING_DOCUMENT_REFERENCES:
			getIncomingDocumentReferences().clear();
			return;
		case ModelPackage.MODEL_ELEMENT__LEAF_SECTION:
			setLeafSection((LeafSection) null);
			return;
		case ModelPackage.MODEL_ELEMENT__APPLIED_STEREOTYPE_INSTANCES:
			getAppliedStereotypeInstances().clear();
			return;
		case ModelPackage.MODEL_ELEMENT__COMMENTS:
			getComments().clear();
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
			return NAME_EDEFAULT == null ? name != null : !NAME_EDEFAULT.equals(name);
		case ModelPackage.MODEL_ELEMENT__DESCRIPTION:
			return DESCRIPTION_EDEFAULT == null ? description != null : !DESCRIPTION_EDEFAULT.equals(description);
		case ModelPackage.MODEL_ELEMENT__CREATOR:
			return CREATOR_EDEFAULT == null ? creator != null : !CREATOR_EDEFAULT.equals(creator);
		case ModelPackage.MODEL_ELEMENT__CREATION_DATE:
			return CREATION_DATE_EDEFAULT == null ? creationDate != null : !CREATION_DATE_EDEFAULT.equals(creationDate);
		case ModelPackage.MODEL_ELEMENT__ANNOTATIONS:
			return annotations != null && !annotations.isEmpty();
		case ModelPackage.MODEL_ELEMENT__ATTACHMENTS:
			return attachments != null && !attachments.isEmpty();
		case ModelPackage.MODEL_ELEMENT__INCOMING_DOCUMENT_REFERENCES:
			return incomingDocumentReferences != null && !incomingDocumentReferences.isEmpty();
		case ModelPackage.MODEL_ELEMENT__LEAF_SECTION:
			return basicGetLeafSection() != null;
		case ModelPackage.MODEL_ELEMENT__STATE:
			return STATE_EDEFAULT == null ? getState() != null : !STATE_EDEFAULT.equals(getState());
		case ModelPackage.MODEL_ELEMENT__APPLIED_STEREOTYPE_INSTANCES:
			return appliedStereotypeInstances != null && !appliedStereotypeInstances.isEmpty();
		case ModelPackage.MODEL_ELEMENT__COMMENTS:
			return comments != null && !comments.isEmpty();
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
		result.append(", creator: ");
		result.append(creator);
		result.append(", creationDate: ");
		result.append(creationDate);
		result.append(')');
		return result.toString();
	}

} // ModelElementImpl
