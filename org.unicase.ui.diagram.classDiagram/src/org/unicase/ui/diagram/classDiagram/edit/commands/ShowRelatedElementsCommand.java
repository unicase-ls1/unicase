/**
 * <copyright> Copyright (c) 2015-2016 Chair of Applied Software Engineering, Technische Universität München (TUM).
 * All rights reserved. This program and the accompanying materials are made available under the terms of
 * the Eclipse Public License v1.0 which accompanies this distribution,
 * and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>
 */
package org.unicase.ui.diagram.classDiagram.edit.commands;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.gef.ConnectionEditPart;
import org.eclipse.gef.EditPart;
import org.eclipse.gef.commands.Command;
import org.eclipse.gef.commands.CompoundCommand;
import org.eclipse.gmf.runtime.diagram.ui.editparts.DiagramEditPart;
import org.eclipse.gmf.runtime.diagram.ui.editparts.GraphicalEditPart;
import org.eclipse.gmf.runtime.diagram.ui.editparts.ShapeEditPart;
import org.eclipse.gmf.runtime.diagram.ui.requests.ShowRelatedElementsRequest;
import org.eclipse.gmf.runtime.diagram.ui.requests.CreateViewRequest.ViewDescriptor;
import org.eclipse.gmf.runtime.notation.Edge;
import org.eclipse.gmf.runtime.notation.View;
import org.unicase.model.classes.Association;
import org.unicase.model.classes.Class;
import org.unicase.model.classes.impl.ClassImpl;
import org.unicase.model.diagram.MEDiagram;
import org.unicase.ui.diagram.classDiagram.edit.parts.ClassEditPart;
import org.unicase.ui.diagram.classDiagram.part.ShowRelatedElementsController;
import org.unicase.ui.unicasecommon.diagram.commands.CommandFactory;
import org.unicase.ui.unicasecommon.diagram.commands.CreateConnectionViewCommandProvider;
import org.unicase.ui.unicasecommon.diagram.commands.CreateNodeViewCommandProvider;
import org.unicase.ui.unicasecommon.diagram.requests.ShowRelatedElementsModeRequest;
import org.unicase.ui.unicasecommon.diagram.util.EditPartUtility;
import org.unicase.ui.unicasecommon.diagram.util.ViewAdapter;

/**
 * @author schroech
 */
// TODO: AssociationClassElement migration
public class ShowRelatedElementsCommand extends Command {

	private final Map<EObject, ViewDescriptor> objectViewDescriptorMap = new HashMap<EObject, ViewDescriptor>();
	private DiagramEditPart diagramEditPart;
	private boolean enableMode;

	private final CompoundCommand cc = new CompoundCommand();

	/**
	 * Default constructor.
	 * 
	 * @param request The {@link ShowRelatedElementsRequest} triggering this command. May not be null.
	 */
	public ShowRelatedElementsCommand(ShowRelatedElementsRequest request) {
		super("Show related elements");

		// BEGIN SANITY CHECKS
		if (request == null) {
			throw new IllegalArgumentException();
		}

		Object selectedShape = null;
		List selectedShapes = request.getSelectedShapes();
		if (selectedShapes.size() == 0) {
			throw new IllegalArgumentException();
		}

		selectedShape = selectedShapes.get(0);
		if (!(selectedShape instanceof ClassEditPart)) {
			throw new IllegalArgumentException();
		}

		ClassEditPart primaryClassEditPart = (ClassEditPart) selectedShape;
		EObject element = EditPartUtility.getElement(primaryClassEditPart);
		if (!(element instanceof ClassImpl)) {
			throw new IllegalArgumentException();
		}

		DiagramEditPart diagramEditPart = EditPartUtility.getDiagramEditPart(primaryClassEditPart);
		if (diagramEditPart == null) {
			throw new IllegalArgumentException();
		}
		// END SANITY CHECKS

		if (request instanceof ShowRelatedElementsModeRequest) {
			enableMode = ((ShowRelatedElementsModeRequest) request).isEnable();
		}

		setDiagramEditPart(diagramEditPart);

		Collection<Class> invisibleRelatedClasses = getInvisibleRelatedClasses(primaryClassEditPart);
		Collection<Association> invisibleRelatedAssociations = getInvisibleRelatedAssociations(primaryClassEditPart,
			invisibleRelatedClasses);

		createClassCreationCommands(invisibleRelatedClasses);
		createAssociationCreateCommands(invisibleRelatedAssociations);

		Collection<ViewDescriptor> viewDescriptors = getObjectViewDescriptorMap().values();
		List<ViewDescriptor> nodeViewDescriptorsToArrange = new ArrayList<ViewDescriptor>();
		List<ViewDescriptor> connectionViewDescriptorsToArrange = new ArrayList<ViewDescriptor>();

		ViewDescriptor viewDescriptor = CommandFactory.createViewDescriptorForNode(element);
		viewDescriptor.setView(primaryClassEditPart.getNotationView());
		nodeViewDescriptorsToArrange.add(viewDescriptor);

		for (ViewDescriptor currentViewDescriptor : viewDescriptors) {
			if (currentViewDescriptor.getViewKind().equals(Edge.class)) {
				connectionViewDescriptorsToArrange.add(currentViewDescriptor);
			} else {
				nodeViewDescriptorsToArrange.add(currentViewDescriptor);
			}
		}

		CommandFactory.addArrangeCommand(cc, nodeViewDescriptorsToArrange, getDiagramEditPart());
		CommandFactory.addArrangeCommand(cc, connectionViewDescriptorsToArrange, getDiagramEditPart());

	}

	private void createAssociationCreateCommands(Collection<Association> invisibleRelatedAssociations) {
		for (Association currentAssociation : invisibleRelatedAssociations) {
			CreateConnectionViewCommandProvider provider = new CreateConnectionViewCommandProvider(
				getDiagramEditPart(), currentAssociation, getViewAdapter(currentAssociation.getSource()),
				getViewAdapter(currentAssociation.getTarget()));

			ViewDescriptor viewDescriptor = provider.getViewDescriptor();
			getObjectViewDescriptorMap().put(currentAssociation, viewDescriptor);

			Command command = provider.getCommand();
			cc.add(command);

			Command createColorCommand = CommandFactory.createColorizeCommand(currentAssociation, getDiagramEditPart());
			cc.add(createColorCommand);
		}
	}

	private void createClassCreationCommands(Collection<Class> invisibleRelatedClasses) {
		for (Class currentClass : invisibleRelatedClasses) {
			CreateNodeViewCommandProvider provider = new CreateNodeViewCommandProvider(getDiagramEditPart(),
				currentClass);

			ViewDescriptor viewDescriptor = provider.getViewDescriptor();
			getObjectViewDescriptorMap().put(currentClass, viewDescriptor);

			Command command = provider.getCommand();

			cc.add(command);

			Command createColorCommand = CommandFactory.createColorizeCommand(currentClass, getDiagramEditPart());
			cc.add(createColorCommand);
		}
	}

	/**
	 * @see org.eclipse.gef.commands.Command#execute()
	 */
	@Override
	public void execute() {
		ShowRelatedElementsController instance = ShowRelatedElementsController.getInstance(getDiagramEditPart()
			.getViewer());

		if (instance.isActive()) {
			instance.setModeEnabled(enableMode);
			return;
		}

		instance.getObjectViewDescriptorMap().putAll(getObjectViewDescriptorMap());

		cc.execute();

		instance.setActive(true);

	}

	/**
	 * ShowRelatedElementsCommand are currently not undoable because ot it's "mode" based architecture.
	 * 
	 * @see org.eclipse.gef.commands.Command#canUndo()
	 * @return false
	 */
	@Override
	public boolean canUndo() {
		return false;
	}

	private static Collection<Association> getAllRelatedAssociations(org.unicase.model.classes.Class theClass) {
		Set<Association> allRelatedAssociations = new HashSet<Association>();

		EList<Association> incomingAssociations = theClass.getIncomingAssociations();
		EList<Association> outgoingAssociations = theClass.getOutgoingAssociations();

		allRelatedAssociations.addAll(incomingAssociations);
		allRelatedAssociations.addAll(outgoingAssociations);

		return allRelatedAssociations;
	}

	private static Collection<org.unicase.model.classes.Class> getAllRelatedClasses(
		org.unicase.model.classes.Class theClass) {
		Set<org.unicase.model.classes.Class> allRelatedClasses = new HashSet<org.unicase.model.classes.Class>();

		EList<Association> incomingAssociations = theClass.getIncomingAssociations();
		EList<Association> outgoingAssociations = theClass.getOutgoingAssociations();

		for (Association association : outgoingAssociations) {
			org.unicase.model.classes.Class target = association.getTarget();
			if (target != null && target != theClass) {
				allRelatedClasses.add(target);
			}
		}
		for (Association association : incomingAssociations) {
			org.unicase.model.classes.Class source = association.getSource();
			if (source != null && source != theClass) {
				allRelatedClasses.add(source);
			}
		}

		return allRelatedClasses;
	}

	private static Collection<Association> getInvisibleRelatedAssociations(ClassEditPart classEditPart,
		Collection<Class> invisibleRelatedClasses) {
		EObject element = EditPartUtility.getElement(classEditPart);
		if (!(element instanceof org.unicase.model.classes.Class)) {
			return Collections.EMPTY_LIST;
		}

		Set<Association> invisibleRelatedAssociations = new HashSet<Association>();

		Collection<ConnectionEditPart> connectedConnectionEditParts = getConnectedConnectionEditParts(classEditPart);
		Collection<Association> visibleRelatedAssociations = EditPartUtility.getElements(connectedConnectionEditParts,
			Association.class);

		Collection<Association> allRelatedAssociations = getAllRelatedAssociations((org.unicase.model.classes.Class) element);

		invisibleRelatedAssociations.addAll(allRelatedAssociations);
		invisibleRelatedAssociations.removeAll(visibleRelatedAssociations);

		for (Class invisibleClass : invisibleRelatedClasses) {
			EList<Association> outgoingAssociations = invisibleClass.getOutgoingAssociations();
			EList<Association> incomingAssociations = invisibleClass.getIncomingAssociations();

			for (Association association : outgoingAssociations) {
				Class target = association.getTarget();

				if (((MEDiagram) EditPartUtility.getElement(EditPartUtility.getDiagramEditPart(classEditPart)))
					.getElements().contains(target)) {
					invisibleRelatedAssociations.add(association);
				}
			}

			for (Association association : incomingAssociations) {
				Class source = association.getSource();

				if (((MEDiagram) EditPartUtility.getElement(EditPartUtility.getDiagramEditPart(classEditPart)))
					.getElements().contains(source)) {
					invisibleRelatedAssociations.add(association);
				}
			}
		}

		return invisibleRelatedAssociations;
	}

	private static Collection<org.unicase.model.classes.Class> getInvisibleRelatedClasses(ClassEditPart classEditPart) {
		Set<org.unicase.model.classes.Class> invisibleRelatedClasses = new HashSet<org.unicase.model.classes.Class>();

		DiagramEditPart diagramEditPart = EditPartUtility.getDiagramEditPart(classEditPart);
		if (diagramEditPart == null) {
			return Collections.EMPTY_LIST;
		}

		Collection<ShapeEditPart> connectedShapeEditParts = getConnectedShapeEditParts(classEditPart);
		Collection<Class> visibleConnectedClasses = EditPartUtility.getElements(connectedShapeEditParts,
			org.unicase.model.classes.Class.class);

		EObject element = EditPartUtility.getElement(classEditPart);
		if (!(element instanceof org.unicase.model.classes.Class)) {
			return Collections.EMPTY_LIST;
		}

		Collection<Class> allRelatedClasses = null;
		allRelatedClasses = getAllRelatedClasses((org.unicase.model.classes.Class) element);

		invisibleRelatedClasses.addAll(allRelatedClasses);
		invisibleRelatedClasses.removeAll(visibleConnectedClasses);

		List<org.unicase.model.classes.Class> visibleRelatedClasses = new ArrayList<Class>();
		for (Class invisibleRelatedClass : invisibleRelatedClasses) {
			EditPart findEditPart = diagramEditPart.findEditPart(null, invisibleRelatedClass);
			if (findEditPart != null) {
				visibleRelatedClasses.add(invisibleRelatedClass);
			}
		}

		invisibleRelatedClasses.removeAll(visibleRelatedClasses);

		return invisibleRelatedClasses;
	}

	private static Collection<ConnectionEditPart> getConnectedConnectionEditParts(ClassEditPart classEditPart) {
		Set<ConnectionEditPart> connectedConnectionEditParts = new HashSet<ConnectionEditPart>();

		List sourceConnections = classEditPart.getSourceConnections();
		List targetConnections = classEditPart.getTargetConnections();

		for (Object object : targetConnections) {
			if (object instanceof ConnectionEditPart) {
				connectedConnectionEditParts.add((ConnectionEditPart) object);
			}
		}

		for (Object object : sourceConnections) {
			if (object instanceof ConnectionEditPart) {
				connectedConnectionEditParts.add((ConnectionEditPart) object);
			}
		}

		return connectedConnectionEditParts;
	}

	private static Collection<ShapeEditPart> getConnectedShapeEditParts(ShapeEditPart editPart) {
		Set<ShapeEditPart> connectedShapeEditParts = new HashSet<ShapeEditPart>();

		List sourceConnections = editPart.getSourceConnections();
		List targetConnections = editPart.getTargetConnections();

		for (Object object : targetConnections) {
			if (object instanceof ConnectionEditPart) {
				EditPart target = ((ConnectionEditPart) object).getTarget();
				if (target instanceof GraphicalEditPart) {
					connectedShapeEditParts.add((ShapeEditPart) target);
				}
			}
		}

		for (Object object : sourceConnections) {
			if (object instanceof ConnectionEditPart) {
				EditPart source = ((ConnectionEditPart) object).getSource();
				if (source instanceof GraphicalEditPart) {
					connectedShapeEditParts.add((ShapeEditPart) source);
				}
			}
		}

		return connectedShapeEditParts;
	}

	private IAdaptable getViewAdapter(EObject object) {
		IAdaptable viewAdapter;
		viewAdapter = getObjectViewDescriptorMap().get(object);

		if (viewAdapter == null) {
			EditPart editPart = getDiagramEditPart().findEditPart(null, object);
			if (editPart == null) {
				return null;
			}
			View view = EditPartUtility.getView(editPart);
			viewAdapter = new ViewAdapter(view);
		}

		return viewAdapter;
	}

	private Map<EObject, ViewDescriptor> getObjectViewDescriptorMap() {
		return objectViewDescriptorMap;
	}

	private void setDiagramEditPart(DiagramEditPart diagramEditPart) {
		this.diagramEditPart = diagramEditPart;
	}

	private DiagramEditPart getDiagramEditPart() {
		return diagramEditPart;
	}
}
