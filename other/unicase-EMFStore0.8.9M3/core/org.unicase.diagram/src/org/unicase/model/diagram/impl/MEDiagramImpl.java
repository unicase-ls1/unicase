/**
 * <copyright> Copyright (c) 2008-2009 Jonas Helming, Maximilian Koegel. All rights reserved. This program and the
 * accompanying materials are made available under the terms of the Eclipse Public License v1.0 which accompanies this
 * distribution, and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>
 */
package org.unicase.model.diagram.impl;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import org.eclipse.core.internal.resources.Project;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.emf.ecore.util.EObjectResolvingEList;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.ecore.util.InternalEList;
import org.eclipse.emf.ecore.xmi.XMIResource;
import org.eclipse.emf.emfstore.common.model.ModelElementId;
import org.eclipse.emf.emfstore.common.model.util.ModelUtil;
import org.eclipse.gmf.runtime.notation.Diagram;
import org.eclipse.gmf.runtime.notation.Edge;
import org.eclipse.gmf.runtime.notation.Node;
import org.unicase.model.UnicaseModelElement;
import org.unicase.model.diagram.DiagramPackage;
import org.unicase.model.diagram.MEDiagram;
import org.unicase.model.diagram.UseCaseDiagram;
import org.unicase.model.document.LeafSection;
import org.unicase.model.impl.AttachmentImpl;

/**
 * <!-- begin-user-doc --> An implementation of the model object ' <em><b>ME Diagram</b></em>'. <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.unicase.model.diagram.impl.MEDiagramImpl#getElements <em>Elements</em>}</li>
 *   <li>{@link org.unicase.model.diagram.impl.MEDiagramImpl#getGmfdiagram <em>Gmfdiagram</em>}</li>
 *   <li>{@link org.unicase.model.diagram.impl.MEDiagramImpl#getNewElements <em>New Elements</em>}</li>
 *   <li>{@link org.unicase.model.diagram.impl.MEDiagramImpl#getDiagramLayout <em>Diagram Layout</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public abstract class MEDiagramImpl extends AttachmentImpl implements MEDiagram {
	/**
	 * 
	 */
	private static final long serialVersionUID = -1316169257375326716L;

	/**
	 * The cached value of the '{@link #getElements() <em>Elements</em>}' reference list.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * @see #getElements()
	 * @generated
	 * @ordered
	 */
	protected EList<UnicaseModelElement> elements;

	/**
	 * The cached value of the '{@link #getGmfdiagram() <em>Gmfdiagram</em>}' containment reference.
	 * <!-- begin-user-doc
	 * --> <!-- end-user-doc -->
	 * @see #getGmfdiagram()
	 * @generated
	 * @ordered
	 */
	protected Diagram gmfdiagram;

	/**
	 * The cached value of the '{@link #getNewElements() <em>New Elements</em>}' containment reference list. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see #getNewElements()
	 * @generated
	 * @ordered
	 */
	protected EList<UnicaseModelElement> newElements;

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
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	protected MEDiagramImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return DiagramPackage.Literals.ME_DIAGRAM;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EList<UnicaseModelElement> getElements() {
		if (elements == null) {
			elements = new EObjectResolvingEList<UnicaseModelElement>(UnicaseModelElement.class, this,
				DiagramPackage.ME_DIAGRAM__ELEMENTS);
		}
		return elements;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public Diagram getGmfdiagram() {
		return gmfdiagram;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetGmfdiagram(Diagram newGmfdiagram, NotificationChain msgs) {
		Diagram oldGmfdiagram = gmfdiagram;
		gmfdiagram = newGmfdiagram;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET,
				DiagramPackage.ME_DIAGRAM__GMFDIAGRAM, oldGmfdiagram, newGmfdiagram);
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
	public void setGmfdiagram(Diagram newGmfdiagram) {
		if (newGmfdiagram != gmfdiagram) {
			NotificationChain msgs = null;
			if (gmfdiagram != null)
				msgs = ((InternalEObject) gmfdiagram).eInverseRemove(this, EOPPOSITE_FEATURE_BASE
					- DiagramPackage.ME_DIAGRAM__GMFDIAGRAM, null, msgs);
			if (newGmfdiagram != null)
				msgs = ((InternalEObject) newGmfdiagram).eInverseAdd(this, EOPPOSITE_FEATURE_BASE
					- DiagramPackage.ME_DIAGRAM__GMFDIAGRAM, null, msgs);
			msgs = basicSetGmfdiagram(newGmfdiagram, msgs);
			if (msgs != null)
				msgs.dispatch();
		} else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, DiagramPackage.ME_DIAGRAM__GMFDIAGRAM, newGmfdiagram,
				newGmfdiagram));
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @return A DiagramNewEelementsList
	 * @generated NOT
	 */
	public EList<UnicaseModelElement> getNewElements() {

		// JH: remove this line
		// this line is needed in order to avoid exception when
		// initializing Teneo. Otherwise getProjects() throws an exception
		// because eContainer is null. Returning null in this case shouldn't be
		// a problem because getNewElements() is transient anyway.
		if (eContainer() == null) {
			return null;
		}

		// MD: Should we cache this instance?
		LeafSection leafSection = getLeafSection();
		if (leafSection == null) {
			Project project = (Project) getProject();
			if (project == null) {
				return null;
			}
			return new DiagramNewElementsList(getElements(), (org.eclipse.emf.emfstore.common.model.Project) project);
		} else {
			return new DiagramNewElementsList(getElements(), leafSection);
		}
	}

	/**
	 * <!-- begin-user-doc --> .<!-- end-user-doc -->
	 * 
	 * @generated NOT
	 * @return the type
	 */
	public String getType() {
		// TODO: implement this method
		// Ensure that you remove @generated or mark it @generated NOT
		throw new UnsupportedOperationException(
			"getType is not implemented. Must be implmented in any subtype of MEDiagram");
	}

	/**
	 * <!-- begin-user-doc --> .<!-- end-user-doc -->
	 * @generated
	 */

	public String getDiagramLayout() {
		return diagramLayout;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public void setDiagramLayout(String newDiagramLayout) {
		String oldDiagramLayout = diagramLayout;
		diagramLayout = newDiagramLayout;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, DiagramPackage.ME_DIAGRAM__DIAGRAM_LAYOUT,
				oldDiagramLayout, diagramLayout));
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
		case DiagramPackage.ME_DIAGRAM__GMFDIAGRAM:
			return basicSetGmfdiagram(null, msgs);
		case DiagramPackage.ME_DIAGRAM__NEW_ELEMENTS:
			return ((InternalEList<?>) getNewElements()).basicRemove(otherEnd, msgs);
		}
		return super.eInverseRemove(otherEnd, featureID, msgs);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
		case DiagramPackage.ME_DIAGRAM__ELEMENTS:
			return getElements();
		case DiagramPackage.ME_DIAGRAM__GMFDIAGRAM:
			return getGmfdiagram();
		case DiagramPackage.ME_DIAGRAM__NEW_ELEMENTS:
			return getNewElements();
		case DiagramPackage.ME_DIAGRAM__DIAGRAM_LAYOUT:
			return getDiagramLayout();
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
		case DiagramPackage.ME_DIAGRAM__ELEMENTS:
			getElements().clear();
			getElements().addAll((Collection<? extends UnicaseModelElement>) newValue);
			return;
		case DiagramPackage.ME_DIAGRAM__GMFDIAGRAM:
			setGmfdiagram((Diagram) newValue);
			return;
		case DiagramPackage.ME_DIAGRAM__NEW_ELEMENTS:
			getNewElements().clear();
			getNewElements().addAll((Collection<? extends UnicaseModelElement>) newValue);
			return;
		case DiagramPackage.ME_DIAGRAM__DIAGRAM_LAYOUT:
			setDiagramLayout((String) newValue);
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
		case DiagramPackage.ME_DIAGRAM__ELEMENTS:
			getElements().clear();
			return;
		case DiagramPackage.ME_DIAGRAM__GMFDIAGRAM:
			setGmfdiagram((Diagram) null);
			return;
		case DiagramPackage.ME_DIAGRAM__NEW_ELEMENTS:
			getNewElements().clear();
			return;
		case DiagramPackage.ME_DIAGRAM__DIAGRAM_LAYOUT:
			setDiagramLayout(DIAGRAM_LAYOUT_EDEFAULT);
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
		case DiagramPackage.ME_DIAGRAM__ELEMENTS:
			return elements != null && !elements.isEmpty();
		case DiagramPackage.ME_DIAGRAM__GMFDIAGRAM:
			return gmfdiagram != null;
		case DiagramPackage.ME_DIAGRAM__NEW_ELEMENTS:
			return newElements != null && !newElements.isEmpty();
		case DiagramPackage.ME_DIAGRAM__DIAGRAM_LAYOUT:
			return DIAGRAM_LAYOUT_EDEFAULT == null ? diagramLayout != null : !DIAGRAM_LAYOUT_EDEFAULT
				.equals(diagramLayout);
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
		result.append(" (diagramLayout: ");
		result.append(diagramLayout);
		result.append(')');
		return result.toString();
	}

	private static final URI VIRTUAL_DIAGRAM_URI = URI.createURI("virtual.diagram.uri");
	private static final URI VIRTUAL_DIAGRAM_ELEMENTS_URI = URI.createURI("virtual.diagram.elements.uri");

	/*
	 * This method removes nodes and edges that are no longer contained in the model. This can happen if diagram
	 * elements are deleted after a diagram is closed.
	 */
	private void syncDiagramLayout(Diagram gmfDiagram) {
		for (int i = 0; i < gmfDiagram.getPersistedChildren().size(); i++) {
			Node node = (Node) gmfDiagram.getPersistedChildren().get(i);
			if (node.getElement() != null && !this.getElements().contains(node.getElement())) {
				gmfDiagram.getPersistedChildren().remove(node);
				i--;
			}
		}
		for (int i = 0; i < gmfDiagram.getPersistedEdges().size(); i++) {
			Edge edge = (Edge) gmfDiagram.getPersistedEdges().get(i);
			if (edge.getElement() != null && !this.getElements().contains(edge.getElement())) {
				gmfDiagram.getPersistedEdges().remove(edge);
				if (edge.getSource() != null) {
					edge.getSource().getSourceEdges().remove(edge);
				}
				if (edge.getTarget() != null) {
					edge.getTarget().getTargetEdges().remove(edge);
				}
				i--;
			}
		}
	}

	/**
	 * Load a gmf diagram from a String.
	 * 
	 * @throws DiagramLoadException if load fails
	 * @generated NOT
	 */
	public void loadDiagramLayout() throws DiagramLoadException {

		// preserve original resource for all involved model elements
		EList<UnicaseModelElement> elements = this.getElements();
		Map<UnicaseModelElement, Resource> resourceMap = preserveOldResources(elements);

		// put all involved elements into a virtual resource set
		ResourceSet resourceSet = new ResourceSetImpl();
		Resource diagramResource = resourceSet.createResource(VIRTUAL_DIAGRAM_URI);
		Resource elementsResource = resourceSet.createResource(VIRTUAL_DIAGRAM_ELEMENTS_URI);
		elementsResource.getContents().addAll(elements);

		String diagramLayout = getDiagramLayout();
		if (diagramLayout == DIAGRAM_LAYOUT_EDEFAULT) {
			return;
		}

		/*
		 * Visual ID's of UseCase diagram were different in the past, e.g. UseCase had ID 1001, now it's 2001. For this
		 * reason: Check for the old and incompatible layout information and convert it.
		 */
		if (this.getClass().equals(UseCaseDiagram.class)) {
			if (this.diagramLayout.contains("type=\"1001\"") || this.diagramLayout.contains("type=\"1002\"")) {
				this.diagramLayout = this.convertUsecaseLayout(this.diagramLayout);
			}
		}
		// load diagram
		try {
			diagramResource.load(new ByteArrayInputStream(diagramLayout.getBytes("UTF-8")), null);
		} catch (UnsupportedEncodingException e) {
			throw new DiagramLoadException("Diagram string encoding is malformed, load failed.", e);
		} catch (IOException e) {
			throw new DiagramLoadException("Diagram load failed.", e);
		}

		if (diagramResource.getContents().size() < 1) {
			throw new DiagramLoadException("Diagram String does not contain anything, load failed!");
		}
		EObject object = diagramResource.getContents().get(0);
		if (!(object instanceof Diagram)) {
			throw new DiagramLoadException("Diagram String contains unexpected content: first entry is not a diagram");
		}

		Diagram gmfDiagram = (Diagram) diagramResource.getContents().get(0);
		this.syncDiagramLayout(gmfDiagram);
		EcoreUtil.resolveAll(gmfDiagram);

		setGmfdiagram(gmfDiagram);

		// restore old resource for all model elements
		restoreOldResources(elements, resourceMap, diagramResource, elementsResource);
		gmfDiagram.setElement(this);
	}

	/*
	 * Visual ID's of UseCase diagram were different in the past, e.g. UseCase had ID 1001, now it's 2001. This method
	 * converts the old layout information.
	 */
	private String convertUsecaseLayout(String string) {
		// The order of the replace sequence is important.
		string = string.replace("children type=\"1001\"", "children type=\"2001\"");
		string = string.replace("children type=\"4002\"", "children type=\"5002\"");
		string = string.replace("children type=\"3002\"", "children type=\"4002\"");
		string = string.replace("children type=\"4001\"", "children type=\"5001\"");
		string = string.replace("children type=\"3001\"", "children type=\"4001\"");
		string = string.replace("children type=\"4006\"", "children type=\"6004\"");
		string = string.replace("children type=\"4005\"", "children type=\"6003\"");
		string = string.replace("children type=\"4004\"", "children type=\"6002\"");
		string = string.replace("children type=\"4003\"", "children type=\"6001\"");
		string = string.replace("children type=\"1002\"", "children type=\"2002\"");
		string = string.replace("children type=\"3004\"", "children type=\"4004\"");
		string = string.replace("children type=\"3003\"", "children type=\"4003\"");
		return string;
	}

	private void restoreOldResources(EList<UnicaseModelElement> elements,
		Map<UnicaseModelElement, Resource> resourceMap, Resource diagramResource, Resource elementsResource) {
		diagramResource.getContents().remove(gmfdiagram);
		elementsResource.getContents().removeAll(elements);
		for (UnicaseModelElement modelElement : resourceMap.keySet()) {
			Resource resource = resourceMap.get(modelElement);
			resource.getContents().add(modelElement);
			if (resource instanceof XMIResource) {
				XMIResource xmiResource = (XMIResource) resource;
				ModelElementId modelElementId = ModelUtil.getProject(modelElement).getModelElementId(modelElement);
				xmiResource.setID(modelElement, modelElementId.getId());
			}
		}
	}

	private Map<UnicaseModelElement, Resource> preserveOldResources(EList<UnicaseModelElement> elements) {
		Map<UnicaseModelElement, Resource> resourceMap = new HashMap<UnicaseModelElement, Resource>();
		for (UnicaseModelElement modelElement : elements) {
			resourceMap.put(modelElement, modelElement.eResource());
		}
		return resourceMap;
	}

	/**
	 * Save gmf diagram to a String.
	 * 
	 * @throws DiagramStoreException if saving to a string fails
	 * @generated NOT
	 */
	public void saveDiagramLayout() throws DiagramStoreException {
		getGmfdiagram().setElement(null);
		// preserve original resource for all involved model elements
		EList<UnicaseModelElement> elements = this.getElements();
		Map<UnicaseModelElement, Resource> resourceMap = preserveOldResources(elements);

		// put all involved elements into a virtual resource set
		ResourceSet resourceSet = new ResourceSetImpl();
		Resource diagramResource = resourceSet.createResource(VIRTUAL_DIAGRAM_URI);
		Resource elementsResource = resourceSet.createResource(VIRTUAL_DIAGRAM_ELEMENTS_URI);
		elementsResource.getContents().addAll(elements);
		diagramResource.getContents().add(getGmfdiagram());

		// serialize diagram
		ByteArrayOutputStream out = new ByteArrayOutputStream();
		try {
			diagramResource.save(out, null);
		} catch (IOException e) {
			throw new DiagramStoreException("Diagram resource save failed.", e);
		}

		restoreOldResources(elements, resourceMap, diagramResource, elementsResource);

		getGmfdiagram().setElement(this);

		String layoutString = out.toString();
		// only set diagram layout if it actually changed
		String oldLayout = getDiagramLayout();
		if (oldLayout == null || !oldLayout.equals(layoutString)) {
			setDiagramLayout(layoutString);
		}
	}

} // MEDiagramImpl
