/**
 * <copyright> Copyright (c) 2015-2016 Chair of Applied Software Engineering, Technische Universität München (TUM).
 * All rights reserved. This program and the accompanying materials are made available under the terms of
 * the Eclipse Public License v1.0 which accompanies this distribution,
 * and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>
 */
package org.unicase.ui.diagram.classDiagram.edit.commands;

import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

import org.eclipse.draw2d.geometry.Rectangle;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.gef.ConnectionEditPart;
import org.eclipse.gef.EditPart;
import org.eclipse.gef.commands.Command;
import org.eclipse.gef.commands.CompoundCommand;
import org.eclipse.gef.commands.UnexecutableCommand;
import org.eclipse.gmf.runtime.diagram.ui.editparts.DiagramEditPart;
import org.eclipse.gmf.runtime.diagram.ui.editparts.GraphicalEditPart;
import org.eclipse.gmf.runtime.diagram.ui.requests.CreateViewRequest;
import org.eclipse.gmf.runtime.diagram.ui.requests.CreateViewRequest.ViewDescriptor;
import org.unicase.model.classes.Association;
import org.unicase.model.classes.Class;
import org.unicase.model.diagram.MEDiagram;
import org.unicase.ui.diagram.classDiagram.edit.parts.Association2EditPart;
import org.unicase.ui.diagram.classDiagram.edit.parts.Association3EditPart;
import org.unicase.ui.diagram.classDiagram.edit.parts.Association4EditPart;
import org.unicase.ui.diagram.classDiagram.edit.parts.AssociationEditPart;
import org.unicase.ui.diagram.classDiagram.edit.parts.ClassEditPart;
import org.unicase.ui.diagram.classDiagram.part.ShowRelatedElementsController;
import org.unicase.ui.unicasecommon.diagram.commands.CommandFactory;
import org.unicase.ui.unicasecommon.diagram.commands.CreateNodeViewCommandProvider;
import org.unicase.ui.unicasecommon.diagram.util.CommandUtility;
import org.unicase.ui.unicasecommon.diagram.util.EditPartUtility;

/**
 * @author schroech
 */
// TODO: AssociationClassElement migration
public class AddRelatedElementsCommand extends Command {

	private final EditPart editPartToAdd;
	private final Collection<EditPart> editPartsToDelete;
	private final DiagramEditPart diagramEditPart;

	private CompoundCommand cc;

	private Class classToAdd;
	private Class addedClass;

	private Set<Association> associationsToAdd;
	private Set<Association> addedAssociations;

	private Set<EObject> nodesToDelete;
	private Set<EObject> deletedNodes;

	/**
	 * Default constructor.
	 * 
	 * @param editPartToAdd The {@link EditPart} being added to the diagram. Pass null or the hosting
	 *            {@link DiagramEditPart} if you do not want to add any {@link EditPart}s.
	 * @param editPartsToDelete The temporary {@link EditPart}s being deleted. Behaviour when passing non-temporary
	 *            {@link EditPart}s is unspecified. May be null.
	 * @param diagramEditPart The {@link DiagramEditPart} hosting the {@link EditPart}s to add or delete.
	 */
	public AddRelatedElementsCommand(EditPart editPartToAdd, Collection<EditPart> editPartsToDelete,
		DiagramEditPart diagramEditPart) {
		super("Add related element");

		// BEGIN SANITY CHECKS
		if (editPartToAdd == null) {
			throw new IllegalArgumentException();
		}

		if (diagramEditPart == null) {
			throw new IllegalArgumentException();
		}
		// END SANITY CHECKS

		this.editPartToAdd = editPartToAdd;
		this.editPartsToDelete = editPartsToDelete;
		this.diagramEditPart = diagramEditPart;

		cc = new CompoundCommand();

		if (!(editPartToAdd instanceof DiagramEditPart)) {
			CommandFactory.addDeleteFromViewCommands(cc, Collections.singleton(getEditPartToAdd()));
		}

		if (editPartsToDelete != null && editPartsToDelete.size() > 0) {
			CommandFactory.addDeleteFromViewCommands(cc, getEditPartsToDelete());
		}

		addAddCommands(cc, getEditPartToAdd());

		cc = (CompoundCommand) CommandUtility.wrapInToggleCanonicalModeCommands(cc, Collections
			.singleton(getDiagramEditPart()));
	}

	private void addAddCommands(CompoundCommand cc, EditPart selectedEditPart) {
		if (selectedEditPart == null) {
			throw new IllegalArgumentException();
		}

		CompoundCommand addCompound = new CompoundCommand("Add views");

		classToAdd = getClassToAdd(selectedEditPart);
		associationsToAdd = getAssociationsToAdd(classToAdd, selectedEditPart);
		nodesToDelete = (Set<EObject>) EditPartUtility.getElements(editPartsToDelete);
		nodesToDelete.remove(classToAdd);
		nodesToDelete.removeAll(associationsToAdd);

		Rectangle editPartBounds = getEditPartBounds(selectedEditPart);

		if (classToAdd != null) {

			CompoundCommand addElementCompound = new CompoundCommand("Add element");

			CreateNodeViewCommandProvider provider = new CreateNodeViewCommandProvider(getDiagramEditPart(), classToAdd);

			CreateViewRequest request = provider.getRequest();
			request.setLocation(editPartBounds.getLocation());
			request.setSize(editPartBounds.getSize());

			Command createNodeViewCommand = provider.getCommand();

			Command strippedCommand = CommandUtility.stripToggleCanonicalModeCommands(createNodeViewCommand);
			addElementCompound.add(strippedCommand);

			Command createDiagramElementAddCommand = CommandFactory.createDiagramElementAddCommand(classToAdd,
				getDiagramEditPart(), false);
			addElementCompound.add(createDiagramElementAddCommand);

			CommandFactory.addDeleteFromViewCommands(cc, Collections.singleton(selectedEditPart));

			Command wrappedCommand = CommandUtility.wrapInToggleCanonicalModeCommands(addElementCompound, Collections
				.singleton(getDiagramEditPart()));
			addCompound.add(wrappedCommand);
		}

		for (Association association : associationsToAdd) {
			Command createDiagramElementAddCommand = CommandFactory.createDiagramElementAddCommand(association,
				getDiagramEditPart(), false);
			addCompound.add(createDiagramElementAddCommand);
		}

		Command unwrap = addCompound.unwrap();
		if (unwrap != UnexecutableCommand.INSTANCE) {
			cc.add(unwrap);
		}
	}

	private Class getClassToAdd(EditPart selectedEditPart) {
		Class classToAdd = null;
		if (selectedEditPart instanceof ClassEditPart) {
			classToAdd = (Class) EditPartUtility.getElement(selectedEditPart);

		} else if (selectedEditPart instanceof AssociationEditPart || selectedEditPart instanceof Association2EditPart
			|| selectedEditPart instanceof Association3EditPart || selectedEditPart instanceof Association4EditPart) {

			Association associationToAdd = (Association) EditPartUtility.getElement(selectedEditPart);
			Class source = associationToAdd.getSource();
			Class target = associationToAdd.getTarget();
			if (!((MEDiagram) (EditPartUtility.getElement(getDiagramEditPart()))).getElements().contains(source)) {
				classToAdd = source;
			} else if (!((MEDiagram) (EditPartUtility.getElement(getDiagramEditPart()))).getElements().contains(target)) {
				classToAdd = target;
			}

		}
		return classToAdd;
	}

	private Rectangle getEditPartBounds(EditPart selectedEditPart) {
		Rectangle editPartBounds = null;
		if (selectedEditPart instanceof ClassEditPart) {
			editPartBounds = ((GraphicalEditPart) selectedEditPart).getFigure().getBounds();

		} else if (selectedEditPart instanceof AssociationEditPart || selectedEditPart instanceof Association2EditPart
			|| selectedEditPart instanceof Association3EditPart || selectedEditPart instanceof Association4EditPart) {

			Association associationToAdd = (Association) EditPartUtility.getElement(selectedEditPart);
			Class source = associationToAdd.getSource();
			Class target = associationToAdd.getTarget();
			if (!((MEDiagram) (EditPartUtility.getElement(getDiagramEditPart()))).getElements().contains(source)) {
				EditPart sourceEditPart = ((ConnectionEditPart) selectedEditPart).getSource();
				editPartBounds = ((GraphicalEditPart) sourceEditPart).getFigure().getBounds();
			} else if (!((MEDiagram) (EditPartUtility.getElement(getDiagramEditPart()))).getElements().contains(target)) {
				EditPart targetEditPart = ((ConnectionEditPart) selectedEditPart).getTarget();
				editPartBounds = ((GraphicalEditPart) targetEditPart).getFigure().getBounds();
			}
		}

		return editPartBounds;
	}

	private Set<Association> getAssociationsToAdd(Class classToAdd, EditPart selectedEditPart) {
		if (selectedEditPart == null) {
			return Collections.EMPTY_SET;
		}

		Set<Association> allConnectedAssociations = new HashSet<Association>();
		Set<Association> associationsToAdd = new HashSet<Association>();

		if (selectedEditPart instanceof ClassEditPart) {
			allConnectedAssociations.addAll(classToAdd.getOutgoingAssociations());
			allConnectedAssociations.addAll(classToAdd.getIncomingAssociations());

			for (Association association : allConnectedAssociations) {
				Class source = association.getSource();
				Class target = association.getTarget();

				if ((((MEDiagram) EditPartUtility.getElement(getDiagramEditPart())).getElements().contains(source) || source == classToAdd)
					&& ((((MEDiagram) (EditPartUtility.getElement(getDiagramEditPart()))).getElements()
						.contains(target)) || target == classToAdd)) {
					associationsToAdd.add(association);
				}
			}
		} else if (selectedEditPart instanceof AssociationEditPart || selectedEditPart instanceof Association2EditPart
			|| selectedEditPart instanceof Association3EditPart || selectedEditPart instanceof Association4EditPart) {

			Association associationToAdd = (Association) EditPartUtility.getElement(selectedEditPart);
			associationsToAdd.add(associationToAdd);
		}

		return associationsToAdd;
	}

	/**
	 * @see org.eclipse.gef.commands.Command#execute()
	 */
	@Override
	public void execute() {
		ShowRelatedElementsController instance = ShowRelatedElementsController.getInstance(diagramEditPart.getViewer());
		if (!instance.isActive()) {
			return;
		}

		for (EObject object : nodesToDelete) {
			ViewDescriptor remove = instance.getObjectViewDescriptorMap().remove(object);
			if (remove == null) {
				throw new IllegalStateException(
					"Could not delete node from object/viewDescriptor map of ShowRelatedElementsController");
			}
		}

		if (classToAdd != null) {
			ViewDescriptor remove = instance.getObjectViewDescriptorMap().remove(classToAdd);
			if (remove == null) {
				throw new IllegalStateException(
					"Could not delete class from object/viewDescriptor map of ShowRelatedElementsController");
			}
		}

		for (Association addedAssociation : associationsToAdd) {
			instance.getObjectViewDescriptorMap().remove(addedAssociation);
		}

		cc.execute();

		setDeletedNodes(nodesToDelete);
		setAddedClass(classToAdd);
		setAddedAssociations(associationsToAdd);
	}

	/**
	 * @see org.eclipse.gef.commands.Command#canUndo()
	 * @return false
	 */
	@Override
	public boolean canUndo() {
		return false;
	}

	private DiagramEditPart getDiagramEditPart() {
		return diagramEditPart;
	}

	private Collection<EditPart> getEditPartsToDelete() {
		return editPartsToDelete;
	}

	private EditPart getEditPartToAdd() {
		return editPartToAdd;
	}

	private void setAddedClass(Class addedClass) {
		this.addedClass = addedClass;
	}

	/**
	 * @return The {@link Class}es which were added to the diagram by this command. Returns null if called before
	 *         command execution.
	 */
	public Class getAddedClass() {
		return addedClass;
	}

	private void setAddedAssociations(Set<Association> addedAssociations) {
		this.addedAssociations = addedAssociations;
	}

	/**
	 * @return @return The {@link Association}s which were added to the diagram by this command. Returns null if called
	 *         before command execution.
	 */
	public Set<Association> getAddedAssociations() {
		return addedAssociations;
	}

	private void setDeletedNodes(Set<EObject> deletedNodes) {
		this.deletedNodes = deletedNodes;
	}

	/**
	 * @return @return The {@link EObject}s which were deleted from the diagram by this command. Returns null if called
	 *         before command execution.
	 */
	public Set<EObject> getDeletedNodes() {
		return deletedNodes;
	}
}
