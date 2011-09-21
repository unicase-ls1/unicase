/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.unicase.papyrus.impl;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.common.util.URI;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.ecore.xmi.XMIResource;

import org.eclipse.gmf.runtime.notation.Diagram;
import org.eclipse.gmf.runtime.notation.Edge;
import org.eclipse.gmf.runtime.notation.Node;

import org.eclipse.uml2.uml.internal.impl.ModelImpl;

import org.unicase.metamodel.ModelElementId;
import org.unicase.metamodel.util.ModelUtil;
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
 *   <li>{@link org.unicase.papyrus.impl.UMLModelImpl#getDiagramLayout <em>Diagram Layout</em>}</li>
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
			InternalEObject oldGmfDiagram = (InternalEObject) gmfDiagram;
			gmfDiagram = (Diagram) eResolveProxy(oldGmfDiagram);
			if (gmfDiagram != oldGmfDiagram) {
				InternalEObject newGmfDiagram = (InternalEObject) gmfDiagram;
				NotificationChain msgs = oldGmfDiagram.eInverseRemove(this,
						EOPPOSITE_FEATURE_BASE
								- PapyrusPackage.UML_MODEL__GMF_DIAGRAM, null,
						null);
				if (newGmfDiagram.eInternalContainer() == null) {
					msgs = newGmfDiagram.eInverseAdd(this,
							EOPPOSITE_FEATURE_BASE
									- PapyrusPackage.UML_MODEL__GMF_DIAGRAM,
							null, msgs);
				}
				if (msgs != null)
					msgs.dispatch();
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE,
							PapyrusPackage.UML_MODEL__GMF_DIAGRAM,
							oldGmfDiagram, gmfDiagram));
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
	public NotificationChain basicSetGmfDiagram(Diagram newGmfDiagram,
			NotificationChain msgs) {
		Diagram oldGmfDiagram = gmfDiagram;
		gmfDiagram = newGmfDiagram;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this,
					Notification.SET, PapyrusPackage.UML_MODEL__GMF_DIAGRAM,
					oldGmfDiagram, newGmfDiagram);
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
	public void setGmfDiagram(Diagram newGmfDiagram) {
		if (newGmfDiagram != gmfDiagram) {
			NotificationChain msgs = null;
			if (gmfDiagram != null)
				msgs = ((InternalEObject) gmfDiagram).eInverseRemove(this,
						EOPPOSITE_FEATURE_BASE
								- PapyrusPackage.UML_MODEL__GMF_DIAGRAM, null,
						msgs);
			if (newGmfDiagram != null)
				msgs = ((InternalEObject) newGmfDiagram).eInverseAdd(this,
						EOPPOSITE_FEATURE_BASE
								- PapyrusPackage.UML_MODEL__GMF_DIAGRAM, null,
						msgs);
			msgs = basicSetGmfDiagram(newGmfDiagram, msgs);
			if (msgs != null)
				msgs.dispatch();
		} else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET,
					PapyrusPackage.UML_MODEL__GMF_DIAGRAM, newGmfDiagram,
					newGmfDiagram));
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
		diagramType = newDiagramType == null ? DIAGRAM_TYPE_EDEFAULT
				: newDiagramType;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET,
					PapyrusPackage.UML_MODEL__DIAGRAM_TYPE, oldDiagramType,
					diagramType));
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
			eNotify(new ENotificationImpl(this, Notification.SET,
					PapyrusPackage.UML_MODEL__DIAGRAM_LAYOUT, oldDiagramLayout,
					diagramLayout));
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
			if (resolve)
				return getGmfDiagram();
			return basicGetGmfDiagram();
		case PapyrusPackage.UML_MODEL__DIAGRAM_TYPE:
			return getDiagramType();
		case PapyrusPackage.UML_MODEL__DIAGRAM_LAYOUT:
			return getDiagramLayout();
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
			setGmfDiagram((Diagram) newValue);
			return;
		case PapyrusPackage.UML_MODEL__DIAGRAM_TYPE:
			setDiagramType((UMLDiagramType) newValue);
			return;
		case PapyrusPackage.UML_MODEL__DIAGRAM_LAYOUT:
			setDiagramLayout((String) newValue);
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
			setGmfDiagram((Diagram) null);
			return;
		case PapyrusPackage.UML_MODEL__DIAGRAM_TYPE:
			setDiagramType(DIAGRAM_TYPE_EDEFAULT);
			return;
		case PapyrusPackage.UML_MODEL__DIAGRAM_LAYOUT:
			setDiagramLayout(DIAGRAM_LAYOUT_EDEFAULT);
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
		case PapyrusPackage.UML_MODEL__DIAGRAM_LAYOUT:
			return DIAGRAM_LAYOUT_EDEFAULT == null ? diagramLayout != null
					: !DIAGRAM_LAYOUT_EDEFAULT.equals(diagramLayout);
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
		result.append(" (diagramType: ");
		result.append(diagramType);
		result.append(", diagramLayout: ");
		result.append(diagramLayout);
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
		if (diagram != null) {
			diagram.setName(newName);
		}
	}

	private static final URI VIRTUAL_DIAGRAM_URI = URI
			.createURI("virtual.diagram.uri");
	private static final URI VIRTUAL_DIAGRAM_ELEMENTS_URI = URI
			.createURI("virtual.diagram.elements.uri");

	/*
	 * This method removes nodes and edges that are no longer contained in the model. This can happen if diagram
	 * elements are deleted after a diagram is closed.
	 */
	private void syncDiagramLayout(Diagram gmfDiagram) {
		for (int i = 0; i < gmfDiagram.getPersistedChildren().size(); i++) {
			Node node = (Node) gmfDiagram.getPersistedChildren().get(i);
			if (node.getElement() != null
					&& !getProperContents().contains(node.getElement())) {
				gmfDiagram.getPersistedChildren().remove(node);
				i--;
			}
		}
		for (int i = 0; i < gmfDiagram.getPersistedEdges().size(); i++) {
			Edge edge = (Edge) gmfDiagram.getPersistedEdges().get(i);
			if (edge.getElement() != null
					&& !this.getProperContents().contains(edge.getElement())) {
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
	public void loadDiagramLayout() throws UnsupportedEncodingException,
			IOException {

		// preserve original resource for all involved model elements
		Set<EObject> elements = this.getProperContents();
		Map<EObject, Resource> resourceMap = preserveOldResources(elements);

		// put all involved elements into a virtual resource set
		ResourceSet resourceSet = new ResourceSetImpl();
		Resource diagramResource = resourceSet
				.createResource(VIRTUAL_DIAGRAM_URI);
		Resource elementsResource = resourceSet
				.createResource(VIRTUAL_DIAGRAM_ELEMENTS_URI);
		elementsResource.getContents().addAll(elements);

		String diagramLayout = getDiagramLayout();
		if (diagramLayout == DIAGRAM_LAYOUT_EDEFAULT) {
			return;
		}

		// load diagram
		diagramResource
				.load(new ByteArrayInputStream(diagramLayout.getBytes("UTF-8")),
						null);

		EObject object = diagramResource.getContents().get(0);

		Diagram gmfDiagram = (Diagram) diagramResource.getContents().get(0);
		syncDiagramLayout(gmfDiagram);
		EcoreUtil.resolveAll(gmfDiagram);

		setGmfDiagram(gmfDiagram);

		// restore old resource for all model elements
		restoreOldResources(elements, resourceMap, diagramResource,
				elementsResource);
		gmfDiagram.setElement(this);
	}

	private void restoreOldResources(Set<EObject> elements,
			Map<EObject, Resource> resourceMap, Resource diagramResource,
			Resource elementsResource) {
		diagramResource.getContents().remove(getGmfDiagram());
		elementsResource.getContents().removeAll(elements);
		for (EObject modelElement : resourceMap.keySet()) {
			Resource resource = resourceMap.get(modelElement);
			resource.getContents().add(modelElement);
			if (resource instanceof XMIResource) {
				XMIResource xmiResource = (XMIResource) resource;
				ModelElementId modelElementId = ModelUtil.getProject(
						modelElement).getModelElementId(modelElement);
				xmiResource.setID(modelElement, modelElementId.getId());
			}
		}
	}

	private Map<EObject, Resource> preserveOldResources(Set<EObject> elements) {
		Map<EObject, Resource> resourceMap = new HashMap<EObject, Resource>();
		for (EObject modelElement : elements) {
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
	public void saveDiagramLayout() throws IOException {
		getGmfDiagram().setElement(null);
		// preserve original resource for all involved model elements
		Set<EObject> elements = getProperContents();
		Map<EObject, Resource> resourceMap = preserveOldResources(elements);

		// put all involved elements into a virtual resource set
		ResourceSet resourceSet = new ResourceSetImpl();
		Resource diagramResource = resourceSet
				.createResource(VIRTUAL_DIAGRAM_URI);
		Resource elementsResource = resourceSet
				.createResource(VIRTUAL_DIAGRAM_ELEMENTS_URI);
		elementsResource.getContents().addAll(elements);
		diagramResource.getContents().add(getGmfDiagram());

		// serialize diagram
		ByteArrayOutputStream out = new ByteArrayOutputStream();

		diagramResource.save(out, null);

		restoreOldResources(elements, resourceMap, diagramResource,
				elementsResource);

		getGmfDiagram().setElement(this);

		String layoutString = out.toString();
		// only set diagram layout if it actually changed
		String oldLayout = getDiagramLayout();
		if (oldLayout == null || !oldLayout.equals(layoutString)) {
			setDiagramLayout(layoutString);
		}
	}

	private Set<EObject> getProperContents() {
		Set<EObject> result = new LinkedHashSet<EObject>();
		List<EObject> remainingParents = new LinkedList<EObject>();
		remainingParents.add(this);
		while (!remainingParents.isEmpty()) {
			EObject parent = remainingParents.remove(0);
			for (EObject content : parent.eContents()) {
				if (!(content instanceof Diagram)) {
					result.add(content);
					remainingParents.add(content);
				}
			}
		}
		return result;
	}

} //UMLModelImpl
