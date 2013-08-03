/**
 * <copyright> Copyright (c) 2009-2012 Chair of Applied Software Engineering, Technische Universität München (TUM).
 * All rights reserved. This program and the accompanying materials are made available under the terms of
 * the Eclipse Public License v1.0 which accompanies this distribution,
 * and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>
 */
package org.unicase.leap.papyrus.clazz;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.gmf.runtime.diagram.core.preferences.PreferencesHint;
import org.eclipse.gmf.runtime.diagram.core.services.ViewService;
import org.eclipse.gmf.runtime.diagram.core.util.ViewUtil;
import org.eclipse.gmf.runtime.emf.core.util.EObjectAdapter;
import org.eclipse.gmf.runtime.notation.BasicCompartment;
import org.eclipse.gmf.runtime.notation.DecorationNode;
import org.eclipse.gmf.runtime.notation.Diagram;
import org.eclipse.gmf.runtime.notation.Edge;
import org.eclipse.gmf.runtime.notation.Node;
import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.jface.preference.IPreferenceStore;
import org.eclipse.papyrus.diagram.clazz.edit.parts.AssociationEditPart;
import org.eclipse.papyrus.diagram.clazz.edit.parts.ClassAttributeCompartmentEditPart;
import org.eclipse.papyrus.diagram.clazz.edit.parts.ClassEditPart;
import org.eclipse.papyrus.diagram.clazz.edit.parts.ClassEditPartCN;
import org.eclipse.papyrus.diagram.clazz.edit.parts.ClassOperationCompartmentEditPart;
import org.eclipse.papyrus.diagram.clazz.edit.parts.ContainmentCircleEditPart;
import org.eclipse.papyrus.diagram.clazz.edit.parts.ContainmentSubLinkEditPart;
import org.eclipse.papyrus.diagram.clazz.edit.parts.DependencyEditPart;
import org.eclipse.papyrus.diagram.clazz.edit.parts.GeneralizationEditPart;
import org.eclipse.papyrus.diagram.clazz.edit.parts.OperationForClassEditPart;
import org.eclipse.papyrus.diagram.clazz.edit.parts.PackageEditPart;
import org.eclipse.papyrus.diagram.clazz.edit.parts.PackagePackageableElementCompartmentEditPart;
import org.eclipse.papyrus.diagram.clazz.edit.parts.PropertyForClassEditPart;
import org.eclipse.papyrus.diagram.clazz.part.UMLDiagramEditorPlugin;
import org.eclipse.papyrus.diagram.clazz.providers.UMLElementTypes;
import org.eclipse.papyrus.diagram.common.helper.PreferenceInitializerForElementHelper;
import org.eclipse.papyrus.preferences.utils.PreferenceConstantHelper;
import org.eclipse.swt.graphics.Point;
import org.eclipse.swt.widgets.Control;
import org.eclipse.ui.IEditorPart;
import org.eclipse.uml2.uml.Association;
import org.eclipse.uml2.uml.Classifier;
import org.eclipse.uml2.uml.Dependency;
import org.eclipse.uml2.uml.Feature;
import org.eclipse.uml2.uml.Generalization;
import org.eclipse.uml2.uml.NamedElement;
import org.eclipse.uml2.uml.Operation;
import org.eclipse.uml2.uml.Parameter;
import org.eclipse.uml2.uml.Property;
import org.eclipse.uml2.uml.Type;
import org.eclipse.uml2.uml.UMLFactory;
import org.unicase.leap.action.LeapActionCancelledException;
import org.unicase.leap.action.LeapHelper;
import org.unicase.leap.events.LeapActionEvent;
import org.unicase.leap.papyrus.util.LeapPapyrusConstants;
import org.unicase.papyrus.UMLModel;
import org.unicase.papyrus.uml.diagram.editors.UMLClassDiagramEditor;

import com.leapmotion.leap.Frame;
import com.leapmotion.leap.Pointable;
import com.leapmotion.leap.Vector;

/**
 * This helper class provides manipulation mechanisms for Papyrus class diagrams, making it easy to build up diagram
 * structurs (like design patterns).
 * 
 * @author mharut
 */
public class LeapPapyrusClassDiagramHelper {

	/**
	 * The factory used to create UML elements.
	 */
	private static final UMLFactory FACTORY = UMLFactory.eINSTANCE;
	/**
	 * The GMF view service used to manipulate GMF elements.
	 */
	private static final ViewService VIEW_SERVICE = ViewService.getInstance();
	/**
	 * The preferences hint used for the view service to perform manipulations on Papyrus class diagrams.
	 */
	private static final PreferencesHint PREFERENCES_HINT = UMLDiagramEditorPlugin.DIAGRAM_PREFERENCES_HINT;
	/**
	 * The leap event this helper is helping to handle.
	 */
	private final LeapActionEvent leapEvent;
	/**
	 * The progress monitor used to display the current progress.
	 */
	private final IProgressMonitor monitor;
	/**
	 * The editor this helper is performing actions on.
	 */
	private final UMLClassDiagramEditor editor;
	/**
	 * A map from GMF nodes to their operation compartments.
	 */
	private final Map<Node, Node> nodeToOpCompartment;
	/**
	 * A map from GMF nodes to their attribute compartments.
	 */
	private final Map<Node, Node> nodeToAttrCompartment;
	/**
	 * A map from GMF nodes to their packageable element compartments.
	 */
	private final Map<Node, Node> nodeToPkgCompartment;
	/**
	 * The weight of the current work used to update the progress monitor.
	 */
	private int workWeight;

	/**
	 * Constructs a new helper for a {@link LeapActionEvent}.
	 * 
	 * @param leapEvent the leap event that needs to be handled
	 * @param monitor the progress monitor used to display current progress
	 */
	public LeapPapyrusClassDiagramHelper(LeapActionEvent leapEvent, IProgressMonitor monitor) {
		this.leapEvent = leapEvent;
		this.monitor = monitor;
		IEditorPart editor = leapEvent.getEditor();
		if (editor instanceof UMLClassDiagramEditor) {
			this.editor = (UMLClassDiagramEditor) editor;
			this.nodeToOpCompartment = new HashMap<Node, Node>();
			this.nodeToAttrCompartment = new HashMap<Node, Node>();
			this.nodeToPkgCompartment = new HashMap<Node, Node>();
		} else {
			throw new IllegalArgumentException("Leap actions for this handler can only be defined for "
				+ UMLClassDiagramEditor.class.getCanonicalName());
		}

	}

	/**
	 * Retrieves the diagram of the editor this helper is performing actions on.
	 * 
	 * @return the GMF diagram of this helper's editor
	 */
	public Diagram getDiagram() {
		return editor.getDiagram();
	}

	/**
	 * Creates a new {@link org.eclipse.uml2.uml.Class Class} node with a certain name.
	 * 
	 * @param name the name of the class
	 * @param isAbstract whether or not the class shall be abstract
	 * @return the new class as a GMF node - the underlying UML class is accessible via {@link Node#getElement()}.
	 * @throws LeapActionCancelledException if the process has been cancelled by the user
	 */
	public Node createClass(String name, boolean isAbstract) throws LeapActionCancelledException {
		if (monitor.isCanceled()) {
			throw new LeapActionCancelledException();
		}
		Diagram diagram = editor.getDiagram();
		UMLModel model = (UMLModel) diagram.getElement();
		org.eclipse.uml2.uml.Class clazz = FACTORY.createClass();
		clazz.setName(name);
		clazz.setIsAbstract(isAbstract);
		model.getPackagedElements().add(clazz);
		Node node = VIEW_SERVICE.createNode(new EObjectAdapter(clazz), diagram,
			Integer.toString(ClassEditPart.VISUAL_ID), ViewUtil.APPEND, true, PREFERENCES_HINT);
		monitor.worked(workWeight);
		return node;
	}

	/**
	 * Creates a new {@link org.eclipse.uml2.uml.Package Package} node with a certain name.
	 * 
	 * @param name the name of the package
	 * @return the new package as a GMF node - the underlying UML package is accessible via {@link Node#getElement()}.
	 * @throws LeapActionCancelledException if the process has been cancelled by the user
	 */
	public Node createPackage(String name) throws LeapActionCancelledException {
		if (monitor.isCanceled()) {
			throw new LeapActionCancelledException();
		}
		Diagram diagram = editor.getDiagram();
		UMLModel model = (UMLModel) diagram.getElement();
		org.eclipse.uml2.uml.Package pkg = FACTORY.createPackage();
		pkg.setName(name);
		model.getPackagedElements().add(pkg);
		Node node = VIEW_SERVICE.createNode(new EObjectAdapter(pkg), diagram,
			Integer.toString(PackageEditPart.VISUAL_ID), ViewUtil.APPEND, true, PREFERENCES_HINT);
		monitor.worked(workWeight);
		return node;
	}

	/**
	 * Creates a new {@link Operation} node with a certain name and adds it to an existing class node.
	 * 
	 * @param operationName the name of the operation
	 * @param isAbstract whether or not the operation shall be abstract
	 * @param node the class node this operation shall be added to
	 * @return the new operation as a GMF node - the underlying UML operation is accessible via
	 *         {@link Node#getElement()}
	 * @throws LeapActionCancelledException if the process has been cancelled by the user
	 */
	public Node addOperation(String operationName, boolean isAbstract, Node node) throws LeapActionCancelledException {
		if (monitor.isCanceled()) {
			throw new LeapActionCancelledException();
		}
		Node compartment = getOperationCompartment(node);
		EObject element = node.getElement();
		Node result;
		if (compartment != null && element instanceof org.eclipse.uml2.uml.Class) {
			Operation operation = FACTORY.createOperation();
			operation.setName(operationName);
			operation.setIsAbstract(isAbstract);
			operation.setClass_((org.eclipse.uml2.uml.Class) element);
			result = VIEW_SERVICE.createNode(new EObjectAdapter(operation), compartment,
				Integer.toString(OperationForClassEditPart.VISUAL_ID), ViewUtil.APPEND, true, PREFERENCES_HINT);
		} else {
			result = null;
		}
		monitor.worked(workWeight);
		return result;
	}

	/**
	 * Creates a new {@link Parameter} with a certain name and type and adds it to an existing operation node.
	 * 
	 * @param parameterName the name of the parameter
	 * @param typeNode the {@link Type} node defining the type of this parameter
	 * @param operationNode the {@link Operation} this parameter shall be added to
	 * @return the new parameter
	 * @throws LeapActionCancelledException if the process has been cancelled by the user
	 */
	public Parameter addParameter(String parameterName, Node typeNode, Node operationNode)
		throws LeapActionCancelledException {
		if (monitor.isCanceled()) {
			throw new LeapActionCancelledException();
		}
		EObject operationElement = operationNode.getElement();
		EObject typeElement = typeNode.getElement();
		Parameter result;
		if (operationElement instanceof Operation && typeElement instanceof Type) {
			result = FACTORY.createParameter();
			result.setName(parameterName);
			result.setType((Type) typeElement);
			((Operation) operationElement).getOwnedParameters().add(result);
		} else {
			result = null;
		}
		monitor.worked(workWeight);
		return result;
	}

	/**
	 * Retrieves the operation compartment of a GMF {@link Node}, if any exists.
	 * 
	 * @param node the node to obtain the compartment for
	 * @return the operation compartment of <code>node</code> if any exists,<br/>
	 *         <code>null</code> otherwise
	 */
	private Node getOperationCompartment(Node node) {
		if (nodeToOpCompartment.containsKey(node)) {
			return nodeToOpCompartment.get(node);
		} else {
			for (Object o : node.getPersistedChildren()) {
				if (o instanceof Node) {
					Node childNode = (Node) o;
					if (node.getType().equals(Integer.toString(ClassOperationCompartmentEditPart.VISUAL_ID))) {
						nodeToOpCompartment.put(node, childNode);
						return childNode;
					}
				}
			}
		}
		return null;
	}

	/**
	 * Creates a new {@link Property} node with a certain name and type and adds it to an existing class node.
	 * 
	 * @param attributeName the name of the attribute
	 * @param type the type of the attribute to add
	 * @param node the class node this attribute shall be added to
	 * @return the new attribute as a GMF node - the underlying UML property is accessible via {@link Node#getElement()}
	 * @throws LeapActionCancelledException if the process has been cancelled by the user
	 */
	public Node addAttribute(String attributeName, Type type, Node node) throws LeapActionCancelledException {
		if (monitor.isCanceled()) {
			throw new LeapActionCancelledException();
		}
		Node compartment = getAttributeCompartment(node);
		EObject element = node.getElement();
		Node result;
		if (compartment != null && element instanceof Classifier) {
			Property attribute = FACTORY.createProperty();
			attribute.setName(attributeName);
			attribute.setType(type);
			result = VIEW_SERVICE.createNode(new EObjectAdapter(attribute), compartment,
				Integer.toString(PropertyForClassEditPart.VISUAL_ID), ViewUtil.APPEND, true, PREFERENCES_HINT);
		} else {
			result = null;
		}
		monitor.worked(workWeight);
		return result;
	}

	/**
	 * Retrieves the attribute compartment of a GMF {@link Node}, if any exists.
	 * 
	 * @param node the node to obtain the compartment for
	 * @return the attribute compartment of <code>node</code> if any exists,<br/>
	 *         <code>null</code> otherwise
	 */
	private Node getAttributeCompartment(Node node) {
		if (nodeToAttrCompartment.containsKey(node)) {
			return nodeToAttrCompartment.get(node);
		} else {
			for (Object o : node.getPersistedChildren()) {
				if (o instanceof BasicCompartment) {
					Node childNode = (Node) o;
					if (childNode.getType().equals(Integer.toString(ClassAttributeCompartmentEditPart.VISUAL_ID))) {
						nodeToOpCompartment.put(node, childNode);
						return childNode;
					}
				}
			}
		}
		return null;
	}

	/**
	 * Adds a class to a package and its node to the packageable element compartment of the package node.
	 * 
	 * @param classNode the node of the class to add to the package
	 * @param packageNode the node of the package to add the class to
	 * @throws LeapActionCancelledException if the user has cancelled the process
	 */
	public void addClassToPackage(Node classNode, Node packageNode) throws LeapActionCancelledException {
		if (monitor.isCanceled()) {
			throw new LeapActionCancelledException();
		}
		Node pkgCompartment = getPackageCompartment(packageNode);
		EObject clsElement = classNode.getElement();
		EObject pkgElement = packageNode.getElement();
		if (pkgCompartment != null && clsElement instanceof org.eclipse.uml2.uml.Class
			&& pkgElement instanceof org.eclipse.uml2.uml.Package) {
			org.eclipse.uml2.uml.Class clazz = (org.eclipse.uml2.uml.Class) clsElement;
			org.eclipse.uml2.uml.Package pkg = (org.eclipse.uml2.uml.Package) pkgElement;
			pkg.getPackagedElements().add(clazz);
			VIEW_SERVICE.createNode(new EObjectAdapter(clazz), pkgCompartment,
				Integer.toString(ClassEditPartCN.VISUAL_ID), ViewUtil.APPEND, true, PREFERENCES_HINT);
			getDiagram().removeChild(classNode);
		}
		monitor.worked(workWeight);
	}

	/**
	 * Retrieves the packageable element compartment of a GMF {@link Node}, if any exists.
	 * 
	 * @param node the node to obtain the compartment for
	 * @return the packageable element compartment of <code>node</code> if any exists,<br/>
	 *         <code>null</code> otherwise
	 */
	private Node getPackageCompartment(Node node) {
		if (nodeToPkgCompartment.containsKey(node)) {
			return nodeToPkgCompartment.get(node);
		}
		for (Object o : node.getPersistedChildren()) {
			if (o instanceof DecorationNode) {
				Node childNode = (Node) o;
				if (childNode.getType()
					.equals(Integer.toString(PackagePackageableElementCompartmentEditPart.VISUAL_ID))) {
					nodeToPkgCompartment.put(node, childNode);
					return childNode;
				}
			}
		}
		return null;
	}

	/**
	 * Transfers an operation from several source nodes to one target node.
	 * 
	 * @param operation the operation to transfer
	 * @param sourceNodes the array of source nodes to transfer the operation from
	 * @param targetNode the target node to transfer the operation to
	 * @throws LeapActionCancelledException if the user cancelled the process
	 */
	public void transferOperation(Operation operation, Node[] sourceNodes, Node targetNode)
		throws LeapActionCancelledException {
		String name = operation.getName();
		boolean isAbstract = operation.isAbstract();
		for (Node node : sourceNodes) {
			org.eclipse.uml2.uml.Class clazz = (org.eclipse.uml2.uml.Class) node.getElement();
			for (Iterator<Feature> it = clazz.getFeatures().iterator(); it.hasNext();) {
				Feature feature = it.next();
				if (feature instanceof Operation) {
					Operation containedOperation = (Operation) feature;
					if (name.equals(containedOperation.getName())) {
						it.remove();
						break;
					}
				}
			}
		}
		addOperation(name, isAbstract, targetNode);
	}

	/**
	 * Transfers an attribute from several source nodes to one target node.
	 * 
	 * @param attribute the attribute to transfer
	 * @param sourceNodes the array of source nodes to transfer the attribute from
	 * @param targetNode the target node to transfer the attribute to
	 * @throws LeapActionCancelledException if the user cancelled the process
	 */
	public void transferAttribute(Property attribute, Node[] sourceNodes, Node targetNode)
		throws LeapActionCancelledException {
		String name = attribute.getName();
		Type type = attribute.getType();
		for (Node node : sourceNodes) {
			org.eclipse.uml2.uml.Class clazz = (org.eclipse.uml2.uml.Class) node.getElement();
			Property sourceAttribute = clazz.getAttribute(name, type);
			clazz.getFeatures().remove(sourceAttribute);
		}
		addAttribute(name, type, targetNode);
	}

	/**
	 * Creates an {@link Association} edge between two GMF nodes. The association is added to the containing package and
	 * has an initial multiplicity of 1 on each end.
	 * 
	 * @param sourceNode the source of the association to create
	 * @param targetNode the target of the association to create
	 * @param name the name of the association
	 * @return a new association as a GMF edge - the underlying UML association can be accessed by
	 *         {@link Edge#getElement()}
	 * @throws LeapActionCancelledException if the process has been cancelled by the user
	 */
	public Edge createAssociation(Node sourceNode, Node targetNode, String name) throws LeapActionCancelledException {
		if (monitor.isCanceled()) {
			throw new LeapActionCancelledException();
		}
		Diagram diagram = editor.getDiagram();
		EObject sourceElement = sourceNode.getElement();
		EObject destinationElement = targetNode.getElement();
		EObject diagramElement = diagram.getElement();
		Edge result;
		if (sourceElement instanceof org.eclipse.uml2.uml.Class
			&& destinationElement instanceof org.eclipse.uml2.uml.Class && diagramElement instanceof UMLModel) {

			org.eclipse.uml2.uml.Class sourceClass = (org.eclipse.uml2.uml.Class) sourceElement;
			org.eclipse.uml2.uml.Class destinationClass = (org.eclipse.uml2.uml.Class) destinationElement;

			Association association = FACTORY.createAssociation();
			association.setPackage((UMLModel) diagramElement);
			association.setName(name);

			Property sourceProperty = FACTORY.createProperty();
			sourceProperty.setType(sourceClass);
			sourceProperty.setOwningAssociation(association);
			sourceProperty.setName(sourceClass.getName().toLowerCase());
			sourceProperty.setLower(1);
			sourceProperty.setUpper(1);

			Property destinationProperty = FACTORY.createProperty();
			sourceClass.getOwnedAttributes().add(destinationProperty);
			destinationProperty.setType(destinationClass);
			destinationProperty.setAssociation(association);
			destinationProperty.setName(destinationClass.getName().toLowerCase());
			destinationProperty.setLower(1);
			destinationProperty.setUpper(1);

			result = VIEW_SERVICE.createEdge(UMLElementTypes.Association_4001, diagram,
				Integer.toString(AssociationEditPart.VISUAL_ID), ViewUtil.APPEND, true, PREFERENCES_HINT);
			if (result != null) {
				result.setElement(association);
				result.setSource(sourceNode);
				result.setTarget(targetNode);
			}
			return result;
		} else {
			result = null;
		}
		monitor.worked(workWeight);
		return result;
	}

	/**
	 * Creates a {@link Dependency} edge between two GMF nodes. The dependency is added to the containing package.
	 * 
	 * @param sourceNode the source of the dependency to create
	 * @param targetNode the target of the dependency to create
	 * @param name the name of the dependency
	 * @return a new dependency as a GMF edge - the underlying UML dependency can be accessed by
	 *         {@link Edge#getElement()}
	 * @throws LeapActionCancelledException if the process has been cancelled by the user
	 */
	public Edge createDependency(Node sourceNode, Node targetNode, String name) throws LeapActionCancelledException {
		if (monitor.isCanceled()) {
			throw new LeapActionCancelledException();
		}
		Diagram diagram = editor.getDiagram();
		EObject sourceElement = sourceNode.getElement();
		EObject destinationElement = targetNode.getElement();
		EObject diagramElement = diagram.getElement();
		Edge result;
		if (sourceElement instanceof NamedElement && destinationElement instanceof NamedElement
			&& diagramElement instanceof UMLModel) {
			Dependency dependency = FACTORY.createDependency();
			((UMLModel) diagramElement).getPackagedElements().add(dependency);
			dependency.setName(name);
			dependency.getClients().add((NamedElement) sourceElement);
			dependency.getSuppliers().add((NamedElement) destinationElement);
			result = VIEW_SERVICE.createEdge(UMLElementTypes.Dependency_4008, diagram,
				Integer.toString(DependencyEditPart.VISUAL_ID), ViewUtil.APPEND, true, PREFERENCES_HINT);
			if (result != null) {
				result.setElement(dependency);
				result.setSource(sourceNode);
				result.setTarget(targetNode);
			}
		} else {
			result = null;
		}
		monitor.worked(workWeight);
		return result;
	}

	/**
	 * Creates a {@link Generalization} edge between two GMF {@link Classifier} nodes.
	 * 
	 * @param generalNode the general classifier of the generalization
	 * @param specificNode the specific classifier of the generalization
	 * @return a new generalization as a GMF edge - the underlying UML generalization can be accessed by
	 *         {@link Edge#getElement()}
	 * @throws LeapActionCancelledException if the process has been cancelled by the user
	 */
	public Edge createGeneralization(Node generalNode, Node specificNode) throws LeapActionCancelledException {
		if (monitor.isCanceled()) {
			throw new LeapActionCancelledException();
		}
		EObject generalElement = generalNode.getElement();
		EObject specificElement = specificNode.getElement();
		Edge result;
		if (generalElement instanceof Classifier && specificElement instanceof Classifier) {
			Generalization generalization = FACTORY.createGeneralization();
			generalization.setGeneral((Classifier) generalElement);
			generalization.setSpecific((Classifier) specificElement);
			result = VIEW_SERVICE.createEdge(UMLElementTypes.Generalization_4002, editor.getDiagram(),
				Integer.toString(GeneralizationEditPart.VISUAL_ID), ViewUtil.APPEND, true, PREFERENCES_HINT);
			if (result != null) {
				result.setElement(generalization);
				result.setSource(specificNode);
				result.setTarget(generalNode);
			}
		} else {
			result = null;
		}
		monitor.worked(workWeight);
		return result;
	}

	/**
	 * Creates a {@link Containment} edge between two GMF {@link Classifier} nodes. This will first create a GMF
	 * containment node to the container, and afterwards an edge between the containment node and the containee.
	 * 
	 * @param containerNode the node of the container of the containment
	 * @param containeeNode the node of the containee of the containment
	 * @return a new containment as a GMF edge
	 * @throws LeapActionCancelledException if the process has been cancelled by the user
	 */
	public Edge createContainment(Node containerNode, Node containeeNode) throws LeapActionCancelledException {
		if (monitor.isCanceled()) {
			throw new LeapActionCancelledException();
		}
		Node containmentNode = VIEW_SERVICE.createNode(null, containerNode,
			Integer.toString(ContainmentCircleEditPart.VISUAL_ID), ViewUtil.APPEND, true, PREFERENCES_HINT);
		Edge edge = VIEW_SERVICE.createEdge(UMLElementTypes.Link_4022, editor.getDiagram(),
			Integer.toString(ContainmentSubLinkEditPart.VISUAL_ID), ViewUtil.APPEND, true, PREFERENCES_HINT);
		if (edge != null) {
			edge.setSource(containmentNode);
			edge.setTarget(containeeNode);
		}
		monitor.worked(workWeight);
		return edge;
	}

	/**
	 * Retrieves all GMF {@link Node}s that are focussed by {@link Pointable}s tracked by the leap motion sensor. A node
	 * is considered focussed if at least one pointable is pointing within its shape.
	 * 
	 * @return the list of GMF nodes that are being focussed with the leap motion sensor
	 */
	public List<Node> getFocussedNodes() {
		List<Node> result = new LinkedList<Node>();
		Frame frame = leapEvent.getFrame();
		LeapHelper helper = leapEvent.getHelper();
		helper.setMainPointable(-1);

		if (frame != null && helper != null) {

			// retrieve all locations the pointables are pointing at
			List<Point> focussedLocations = new ArrayList<Point>(frame.pointables().count());
			Control editorControl = editor.getGraphicalViewer().getControl();
			for (Pointable pointable : frame.pointables()) {
				Vector leapPosition = helper.getTip(pointable);
				Vector screenPosition = helper.convert(leapPosition, pointable);
				Point location = editorControl.toControl((int) screenPosition.getX(), (int) screenPosition.getY());
				focussedLocations.add(location);
			}

			// check for every of the diagram's children, if one of the pointables is pointing at it
			for (Object o : editor.getDiagram().getPersistedChildren()) {
				if (o instanceof Node) {
					Node node = (Node) o;
					Integer x = (Integer) ViewUtil.getStructuralFeatureValue(node, LeapPapyrusConstants.LOCATION_X);
					Integer y = (Integer) ViewUtil.getStructuralFeatureValue(node, LeapPapyrusConstants.LOCATION_Y);
					Integer height = (Integer) ViewUtil.getStructuralFeatureValue(node,
						LeapPapyrusConstants.SIZE_HEIGHT);
					Integer width = (Integer) ViewUtil.getStructuralFeatureValue(node, LeapPapyrusConstants.SIZE_WIDTH);
					if (width < 0) {
						width = getIntConstant(node, PreferenceConstantHelper.WIDTH);
					}
					if (height < 0) {
						height = getIntConstant(node, PreferenceConstantHelper.HEIGHT);
					}
					for (Point focussedLocation : focussedLocations) {
						if (focussedLocation.x > x && focussedLocation.x < (x + width) && focussedLocation.y > y
							&& focussedLocation.y < (y + height)) {
							result.add(node);
							break;
						}
					}
				}
			}
		}
		return result;
	}

	/**
	 * Retrieves the value of a default papyrus integer constant for a certain node and the key of the constant.
	 * 
	 * @param node the node to retrieve the constant for
	 * @param preferenceConstantKey the key of the constant to retrieve
	 * @return the value of the integer constant specified for the node and the constant's key
	 */
	private Integer getIntConstant(Node node, int preferenceConstantKey) {
		String prefElementId = node.getElement().eClass().getName();
		IPreferenceStore store = UMLDiagramEditorPlugin.getInstance().getPreferenceStore();
		String preferenceConstant = PreferenceInitializerForElementHelper.getpreferenceKey(node, prefElementId,
			preferenceConstantKey);
		return store.getInt(preferenceConstant);
	}

	/**
	 * Sets the location of a GMF {@link View}. If <code>convert</code> is set to true, this will convert absolute
	 * coordinates into coordinates relative to the editor.
	 * 
	 * @param view the GMF view to set the location for
	 * @param x the x-coordinate of the new location
	 * @param y the y-coordinate of the new location
	 * @param convert flag to indicate whether or not to convert absolute coordinates to relative ones
	 * @throws LeapActionCancelledException if the process has been cancelled by the user
	 */
	public void setLocation(View view, int x, int y, boolean convert) throws LeapActionCancelledException {
		if (monitor.isCanceled()) {
			throw new LeapActionCancelledException();
		}
		if (convert) {
			Point location = editor.getGraphicalViewer().getControl().toControl(x, y);
			ViewUtil.setStructuralFeatureValue(view, LeapPapyrusConstants.LOCATION_X, location.x);
			ViewUtil.setStructuralFeatureValue(view, LeapPapyrusConstants.LOCATION_Y, location.y);
		} else {
			ViewUtil.setStructuralFeatureValue(view, LeapPapyrusConstants.LOCATION_X, x);
			ViewUtil.setStructuralFeatureValue(view, LeapPapyrusConstants.LOCATION_Y, y);
		}
		monitor.worked(workWeight);
	}

	/**
	 * Retrieves the location of a GMF {@link View} within its containing diagram.
	 * 
	 * @param view the view to get the location for
	 * @return the location of the view as a {@link Point}
	 */
	public Point getLocation(View view) {
		Integer x = (Integer) ViewUtil.getStructuralFeatureValue(view, LeapPapyrusConstants.LOCATION_X);
		Integer y = (Integer) ViewUtil.getStructuralFeatureValue(view, LeapPapyrusConstants.LOCATION_Y);
		return new Point(x, y);
	}

	/**
	 * Sets the current work weight for this helper. The work weight is used to update the progress monitor.
	 * 
	 * @param workWeight the new value for the work weight
	 * @see IProgressMonitor#worked(int)
	 */
	public void setWorkWeight(int workWeight) {
		this.workWeight = workWeight;
	}

}
