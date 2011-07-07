/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package scrm.impl;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.BasicEList;
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

import org.eclipse.gmf.runtime.notation.Diagram;
import scrm.DiagramType;
import org.eclipse.gmf.runtime.notation.Edge;
import org.eclipse.gmf.runtime.notation.Node;
import org.unicase.metamodel.ModelElementId;
import org.unicase.metamodel.util.ModelUtil;

import scrm.SCRMDiagram;
import scrm.SCRMModelElement;
import scrm.SCRMSpace;
import scrm.ScrmPackage;
import scrm.knowledge.KnowledgeSpace;
import scrm.lists.SCRMDiagramNewElementsList;
import scrm.requirements.RequirementSpace;
import scrm.requirements.dataProcess.DataProcessSpace;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>SCRM Diagram</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link scrm.impl.SCRMDiagramImpl#getElements <em>Elements</em>}</li>
 *   <li>{@link scrm.impl.SCRMDiagramImpl#getGmfdiagram <em>Gmfdiagram</em>}</li>
 *   <li>{@link scrm.impl.SCRMDiagramImpl#getNewElements <em>New Elements</em>}</li>
 *   <li>{@link scrm.impl.SCRMDiagramImpl#getDiagramLayout <em>Diagram Layout</em>}</li>
 *   <li>{@link scrm.impl.SCRMDiagramImpl#getDiagramType <em>Diagram Type</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class SCRMDiagramImpl extends SCRMModelElementImpl implements
		SCRMDiagram {

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
	 * The cached value of the '{@link #getGmfdiagram() <em>Gmfdiagram</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getGmfdiagram()
	 * @generated
	 * @ordered
	 */
	protected Diagram gmfdiagram;

	/**
	 * The cached value of the '{@link #getNewElements() <em>New Elements</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getNewElements()
	 * @generated NOT
	 * @ordered
	 */
	protected SCRMDiagramNewElementsList newElements;

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
	 * The default value of the '{@link #getDiagramType() <em>Diagram Type</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getDiagramType()
	 * @generated
	 * @ordered
	 */
	protected static final DiagramType DIAGRAM_TYPE_EDEFAULT = DiagramType.DEFAULT_DIAGRAM;

	/**
	 * The cached value of the '{@link #getDiagramType() <em>Diagram Type</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getDiagramType()
	 * @generated
	 * @ordered
	 */
	protected DiagramType diagramType = DIAGRAM_TYPE_EDEFAULT;

	private EObject newElementContainer;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
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
			elements = new EObjectResolvingEList<SCRMModelElement>(
					SCRMModelElement.class, this,
					ScrmPackage.SCRM_DIAGRAM__ELEMENTS);
		}
		return elements;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public EList<SCRMModelElement> getNewElements() {
		if (newElementContainer == null) {
			newElementContainer = eContainer();
		}
		if (newElements == null) {
			newElements = new SCRMDiagramNewElementsList(getElements(),
					newElementContainer);
		}
		newElements.setContainer(newElementContainer);
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
			eNotify(new ENotificationImpl(this, Notification.SET,
					ScrmPackage.SCRM_DIAGRAM__DIAGRAM_LAYOUT, oldDiagramLayout,
					diagramLayout));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public DiagramType getDiagramType() {
		return diagramType;
	}

	public void setDiagramType(EObject eObject) {
		if (eObject instanceof KnowledgeSpace) {
			setDiagramType(DiagramType.KNOWLEDGE_DIAGRAM);
		} else if (eObject instanceof RequirementSpace) {
			setDiagramType(DiagramType.REQUIREMENTS_DIAGRAM);
		} else if (eObject instanceof DataProcessSpace) {
			setDiagramType(DiagramType.DATA_PROCESS_DIAGRAM);
		} else
			setDiagramType(DIAGRAM_TYPE_EDEFAULT);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setDiagramType(DiagramType newDiagramType) {
		DiagramType oldDiagramType = diagramType;
		diagramType = newDiagramType == null ? DIAGRAM_TYPE_EDEFAULT
				: newDiagramType;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET,
					ScrmPackage.SCRM_DIAGRAM__DIAGRAM_TYPE, oldDiagramType,
					diagramType));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Diagram getGmfdiagram() {
		if (gmfdiagram != null && gmfdiagram.eIsProxy()) {
			InternalEObject oldGmfdiagram = (InternalEObject) gmfdiagram;
			gmfdiagram = (Diagram) eResolveProxy(oldGmfdiagram);
			if (gmfdiagram != oldGmfdiagram) {
				InternalEObject newGmfdiagram = (InternalEObject) gmfdiagram;
				NotificationChain msgs = oldGmfdiagram.eInverseRemove(this,
						EOPPOSITE_FEATURE_BASE
								- ScrmPackage.SCRM_DIAGRAM__GMFDIAGRAM, null,
						null);
				if (newGmfdiagram.eInternalContainer() == null) {
					msgs = newGmfdiagram.eInverseAdd(this,
							EOPPOSITE_FEATURE_BASE
									- ScrmPackage.SCRM_DIAGRAM__GMFDIAGRAM,
							null, msgs);
				}
				if (msgs != null)
					msgs.dispatch();
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE,
							ScrmPackage.SCRM_DIAGRAM__GMFDIAGRAM,
							oldGmfdiagram, gmfdiagram));
			}
		}
		return gmfdiagram;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Diagram basicGetGmfdiagram() {
		return gmfdiagram;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetGmfdiagram(Diagram newGmfdiagram,
			NotificationChain msgs) {
		Diagram oldGmfdiagram = gmfdiagram;
		gmfdiagram = newGmfdiagram;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this,
					Notification.SET, ScrmPackage.SCRM_DIAGRAM__GMFDIAGRAM,
					oldGmfdiagram, newGmfdiagram);
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
	public void setGmfdiagram(Diagram newGmfdiagram) {
		if (newGmfdiagram != gmfdiagram) {
			NotificationChain msgs = null;
			if (gmfdiagram != null)
				msgs = ((InternalEObject) gmfdiagram).eInverseRemove(this,
						EOPPOSITE_FEATURE_BASE
								- ScrmPackage.SCRM_DIAGRAM__GMFDIAGRAM, null,
						msgs);
			if (newGmfdiagram != null)
				msgs = ((InternalEObject) newGmfdiagram).eInverseAdd(this,
						EOPPOSITE_FEATURE_BASE
								- ScrmPackage.SCRM_DIAGRAM__GMFDIAGRAM, null,
						msgs);
			msgs = basicSetGmfdiagram(newGmfdiagram, msgs);
			if (msgs != null)
				msgs.dispatch();
		} else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET,
					ScrmPackage.SCRM_DIAGRAM__GMFDIAGRAM, newGmfdiagram,
					newGmfdiagram));
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
		case ScrmPackage.SCRM_DIAGRAM__GMFDIAGRAM:
			return basicSetGmfdiagram(null, msgs);
		case ScrmPackage.SCRM_DIAGRAM__NEW_ELEMENTS:
			return ((InternalEList<?>) getNewElements()).basicRemove(otherEnd,
					msgs);
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
		case ScrmPackage.SCRM_DIAGRAM__GMFDIAGRAM:
			if (resolve)
				return getGmfdiagram();
			return basicGetGmfdiagram();
		case ScrmPackage.SCRM_DIAGRAM__NEW_ELEMENTS:
			return getNewElements();
		case ScrmPackage.SCRM_DIAGRAM__DIAGRAM_LAYOUT:
			return getDiagramLayout();
		case ScrmPackage.SCRM_DIAGRAM__DIAGRAM_TYPE:
			return getDiagramType();
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
			getElements().addAll(
					(Collection<? extends SCRMModelElement>) newValue);
			return;
		case ScrmPackage.SCRM_DIAGRAM__GMFDIAGRAM:
			setGmfdiagram((Diagram) newValue);
			return;
		case ScrmPackage.SCRM_DIAGRAM__NEW_ELEMENTS:
			getNewElements().clear();
			getNewElements().addAll(
					(Collection<? extends SCRMModelElement>) newValue);
			return;
		case ScrmPackage.SCRM_DIAGRAM__DIAGRAM_LAYOUT:
			setDiagramLayout((String) newValue);
			return;
		case ScrmPackage.SCRM_DIAGRAM__DIAGRAM_TYPE:
			setDiagramType((DiagramType) newValue);
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
		case ScrmPackage.SCRM_DIAGRAM__GMFDIAGRAM:
			setGmfdiagram((Diagram) null);
			return;
		case ScrmPackage.SCRM_DIAGRAM__NEW_ELEMENTS:
			getNewElements().clear();
			return;
		case ScrmPackage.SCRM_DIAGRAM__DIAGRAM_LAYOUT:
			setDiagramLayout(DIAGRAM_LAYOUT_EDEFAULT);
			return;
		case ScrmPackage.SCRM_DIAGRAM__DIAGRAM_TYPE:
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
		case ScrmPackage.SCRM_DIAGRAM__ELEMENTS:
			return elements != null && !elements.isEmpty();
		case ScrmPackage.SCRM_DIAGRAM__GMFDIAGRAM:
			return gmfdiagram != null;
		case ScrmPackage.SCRM_DIAGRAM__NEW_ELEMENTS:
			return newElements != null && !newElements.isEmpty();
		case ScrmPackage.SCRM_DIAGRAM__DIAGRAM_LAYOUT:
			return DIAGRAM_LAYOUT_EDEFAULT == null ? diagramLayout != null
					: !DIAGRAM_LAYOUT_EDEFAULT.equals(diagramLayout);
		case ScrmPackage.SCRM_DIAGRAM__DIAGRAM_TYPE:
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
		if (eIsProxy())
			return super.toString();

		StringBuffer result = new StringBuffer(super.toString());
		result.append(" (diagramLayout: ");
		result.append(diagramLayout);
		result.append(", diagramType: ");
		result.append(diagramType);
		result.append(')');
		return result.toString();
	}

	private static final URI VIRTUAL_DIAGRAM_URI = URI
			.createURI("virtual.diagram.uri");
	private static final URI VIRTUAL_DIAGRAM_ELEMENTS_URI = URI
			.createURI("virtual.diagram.elements.uri");
	private static final URI VIRTUAL_DIAGRAM_SCRMSPACE_URI = URI
			.createURI("virtual.diagram.SCRMSpace.uri");

	private void syncDiagramLayout(Diagram gmfDiagram) {
		for (int i = 0; i < gmfDiagram.getPersistedChildren().size(); i++) {
			Node node = (Node) gmfDiagram.getPersistedChildren().get(i);
			if (node.getElement() != null
					&& !this.getElements().contains(node.getElement())) {
				gmfDiagram.getPersistedChildren().remove(node);
				i--;
			}
		}
		for (int i = 0; i < gmfDiagram.getPersistedEdges().size(); i++) {
			Edge edge = (Edge) gmfDiagram.getPersistedEdges().get(i);
			if (edge.getElement() != null
					&& !this.getElements().contains(edge.getElement())) {
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

	public void loadDiagramLayout() throws DiagramLoadException {

		// preserve original resource for all involved model elements
		EList<SCRMModelElement> elements = this.getElements();
		EList<SCRMModelElement> subElements = getSubElements(elements);
		Map<SCRMModelElement, Resource> resourceMap = preserveOldResources(
				elements, subElements);

		// put all involved elements into a virtual resource set
		ResourceSet resourceSet = new ResourceSetImpl();
		Resource diagramResource = resourceSet
				.createResource(VIRTUAL_DIAGRAM_URI);
		Resource elementsResource = resourceSet
				.createResource(VIRTUAL_DIAGRAM_ELEMENTS_URI);
		Resource SCRMSpaceResource = resourceSet
				.createResource(VIRTUAL_DIAGRAM_SCRMSPACE_URI);
		elementsResource.getContents().addAll(elements);
		SCRMSpaceResource.getContents().addAll(subElements);

		String diagramLayout = getDiagramLayout();
		if (diagramLayout == DIAGRAM_LAYOUT_EDEFAULT) {
			return;
		}

		// load diagram
		try {
			diagramResource.load(
					new ByteArrayInputStream(diagramLayout.getBytes("UTF-8")),
					null);
		} catch (UnsupportedEncodingException e) {
			throw new DiagramLoadException(
					"Diagram string encoding is malformed, load failed.", e);
		} catch (IOException e) {
			throw new DiagramLoadException("Diagram load failed.", e);
		}

		if (diagramResource.getContents().size() < 1) {
			throw new DiagramLoadException(
					"Diagram String does not contain anything, load failed!");
		}
		EObject object = diagramResource.getContents().get(0);
		if (!(object instanceof Diagram)) {
			throw new DiagramLoadException(
					"Diagram String contains unexpected content: first entry is not a diagram");
		}

		Diagram gmfDiagram = (Diagram) diagramResource.getContents().get(0);
		this.syncDiagramLayout(gmfDiagram);
		EcoreUtil.resolveAll(gmfDiagram);

		setGmfdiagram(gmfDiagram);

		// restore old resource for all model elements
		restoreOldResources(elements, subElements, resourceMap,
				diagramResource, elementsResource, SCRMSpaceResource);
		gmfDiagram.setElement(this);
	}

	private EList<SCRMModelElement> getSubElements(
			EList<SCRMModelElement> elements) {
		EList<SCRMModelElement> subElements = new BasicEList<SCRMModelElement>();
		for (SCRMModelElement element : elements) {
			if (element instanceof SCRMSpace) {
				SCRMSpace scrmSpace = (SCRMSpace) element;
				for (Iterator<EObject> iter = scrmSpace.eAllContents(); iter
						.hasNext();) {
					subElements.add((SCRMModelElement) iter.next());
				}
			}
		}
		return subElements;
	}

	private Map<SCRMModelElement, Resource> preserveOldResources(
			EList<SCRMModelElement> elements,
			EList<SCRMModelElement> subElements) {
		Map<SCRMModelElement, Resource> resourceMap = new HashMap<SCRMModelElement, Resource>();
		for (SCRMModelElement modelElement : elements) {
			resourceMap.put(modelElement, modelElement.eResource());
		}
		for (SCRMModelElement subElement : subElements) {
			resourceMap.put(subElement, subElement.eResource());
		}
		return resourceMap;
	}

	private void restoreOldResources(EList<SCRMModelElement> elements,
			EList<SCRMModelElement> subElements,
			Map<SCRMModelElement, Resource> resourceMap,
			Resource diagramResource, Resource elementsResource,
			Resource SCRMSpaceResource) {
		diagramResource.getContents().remove(gmfdiagram);
		elementsResource.getContents().removeAll(elements);
		SCRMSpaceResource.getContents().removeAll(subElements);
		for (SCRMModelElement modelElement : resourceMap.keySet()) {
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

	public void saveDiagramLayout() throws DiagramStoreException {
		getGmfdiagram().setElement(null);
		// preserve original resource for all involved model elements
		EList<SCRMModelElement> elements = this.getElements();
		EList<SCRMModelElement> subElements = getSubElements(elements);
		Map<SCRMModelElement, Resource> resourceMap = preserveOldResources(
				elements, subElements);

		// put all involved elements into a virtual resource set
		ResourceSet resourceSet = new ResourceSetImpl();
		Resource diagramResource = resourceSet
				.createResource(VIRTUAL_DIAGRAM_URI);
		Resource elementsResource = resourceSet
				.createResource(VIRTUAL_DIAGRAM_ELEMENTS_URI);
		Resource SCRMSpaceResource = resourceSet
				.createResource(VIRTUAL_DIAGRAM_SCRMSPACE_URI);
		elementsResource.getContents().addAll(elements);
		SCRMSpaceResource.getContents().addAll(subElements);
		diagramResource.getContents().add(getGmfdiagram());

		// serialize diagram
		ByteArrayOutputStream out = new ByteArrayOutputStream();
		try {
			diagramResource.save(out, null);
		} catch (IOException e) {
			throw new DiagramStoreException("Diagram resource save failed.", e);
		}

		restoreOldResources(subElements, elements, resourceMap,
				diagramResource, elementsResource, SCRMSpaceResource);

		getGmfdiagram().setElement(this);

		String layoutString = out.toString();
		// only set diagram layout if it actually changed
		String oldLayout = getDiagramLayout();
		if (oldLayout == null || !oldLayout.equals(layoutString)) {
			setDiagramLayout(layoutString);
		}
	}

	public void setNewElementContainer(EObject newElementContainer) {
		newElements = null;
		this.newElementContainer = newElementContainer;
	}

} //SCRMDiagramImpl
