/**
 * <copyright> Copyright (c) 2008-2009 Jonas Helming, Maximilian Koegel. All rights reserved. This program and the
 * accompanying materials are made available under the terms of the Eclipse Public License v1.0 which accompanies this
 * distribution, and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>
 */
package org.unicase.ui.tom.commands;

import java.util.List;

import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.draw2d.geometry.Point;
import org.eclipse.gef.EditPart;
import org.eclipse.gef.Request;
import org.eclipse.gef.commands.CompoundCommand;
import org.eclipse.gmf.runtime.diagram.ui.editparts.DiagramEditPart;
import org.eclipse.gmf.runtime.diagram.ui.requests.CreateViewAndElementRequest;
import org.eclipse.gmf.runtime.diagram.ui.requests.CreateViewRequest.ViewDescriptor;
import org.eclipse.gmf.runtime.emf.type.core.IElementType;
import org.unicase.ui.unicasecommon.diagram.util.DynamicEObjectAdapter;
import org.unicase.ui.unicasecommon.diagram.util.DynamicViewDescriptorAdapter;
import org.unicase.ui.unicasecommon.diagram.util.EditPartUtility;

/**
 * @author schroech
 *
 */
public class CreateNodeAndConnectionCommand extends AbstractCommand {

	private final EditPart sourceEditPart;
	private final EditPart targetEditPart;
	private final Point sourcePoint;
	private final Point targetPoint;
	private CreateConnectionCommand connectionCreationCommand;
	private CreateNodeCommand sourceCreationCommand;
	private CreateNodeCommand targetCreationCommand;
	private IElementType connectionElementType;
	private IElementType nodeElementType;

	private CreateNodeAndConnectionCommand(
			DiagramEditPart editor,
			Point sourcePoint,
			Point targetPoint,
			EditPart sourceEditPart,
			EditPart targetEditPart) {
		super(editor);
		
		if (sourcePoint != null
			&& targetPoint != null) {
			throw new IllegalArgumentException("Arguments source point and target point can't both be not null");
		}
		
		if (sourceEditPart == null
				&& targetEditPart == null) {
			throw new IllegalArgumentException("Arguments sourceEditPart and targetEditPart can't both be null");
		}
		
		this.sourcePoint = sourcePoint;
		this.targetPoint = targetPoint;
		this.sourceEditPart = sourceEditPart;
		this.targetEditPart = targetEditPart;
	}

	/**
	 * @param diagramEditPart
	 * The {@link DiagramEditPart} for which the node an connection should be created 
	 * @param sourcePoint
	 * The {@link Point} where the source node should be created
	 * @param targetObject
	 * The target {@link EditPart}
	 */
	public CreateNodeAndConnectionCommand(
			DiagramEditPart diagramEditPart,
			Point sourcePoint, 
			EditPart targetObject) {
		this(diagramEditPart, sourcePoint, null, null, targetObject);
	}

	/**
	 * @param diagramEditPart
	 * The {@link DiagramEditPart} for which the node an connection should be created
	 * @param sourceObject
	 * The source {@link EditPart}
	 * @param targetPoint
	 * The {@link Point} where the target node should be created
	 */
	public CreateNodeAndConnectionCommand(
			DiagramEditPart diagramEditPart,
			EditPart sourceObject,
			Point targetPoint) {
		this(diagramEditPart, null, targetPoint, sourceObject, null);
	}

	/** 
	* {@inheritDoc}
	* @see org.unicase.ui.tom.commands.AbstractCommand#getCommand()
	*/
	public org.eclipse.gef.commands.Command getCommand() {
		CompoundCommand compoundCommand;
		compoundCommand = new CompoundCommand("Create classes and association");

		if (getSourceCreationCommand() != null) {
			compoundCommand.add(getSourceCreationCommand().getCommand());	
		}
		if (getTargetCreationCommand() != null) {
			compoundCommand.add(getTargetCreationCommand().getCommand());	
		}
		if (getConnectionCreationCommand() != null) {
			compoundCommand.add(getConnectionCreationCommand().getCommand());
		}

		return compoundCommand;
	}

	@SuppressWarnings("unchecked")
	private IAdaptable getCreatedObjectAdapter(CreateNodeCommand command){
		Request classRequest = command.getRequest();
		Object newObject = ((CreateViewAndElementRequest)classRequest).getNewObject();

		ViewDescriptor viewDescriptor;
		if (newObject instanceof List) {
			viewDescriptor = (ViewDescriptor) ((List) newObject).get(0);
		}else{
			viewDescriptor = (ViewDescriptor) newObject;
		}

		IAdaptable newObjectAdapter = new DynamicViewDescriptorAdapter(viewDescriptor, getDiagramEditPart());
		return newObjectAdapter;
	}

	/**
	 * @return An IAdaptable corresponding to the kind of object created. 
	 */
	protected IAdaptable getTargetAdapter() {
		if (getTargetEditPart() != null) {
			DynamicEObjectAdapter existingObjectAdapter = new DynamicEObjectAdapter(
					EditPartUtility.getElement(getTargetEditPart()),
					getDiagramEditPart());
			return existingObjectAdapter;
		}else{
			if (getTargetCreationCommand() != null) {
				return getCreatedObjectAdapter(getTargetCreationCommand());
			}
		}
		return null;
	}

	/**
	 * @return The connection creation command
	 */
	protected CreateConnectionCommand getConnectionCreationCommand() {
		if (connectionCreationCommand == null) {
			if (getConnectionElementType() != null) {
				connectionCreationCommand = new CreateConnectionCommand(
						getDiagramEditPart(),
						getSourceAdapter(), 
						getTargetAdapter(), 
						connectionElementType);
			}
		}
		return connectionCreationCommand;
	}

	/**
	 * @return The source node creation command
	 */
	protected CreateNodeCommand getSourceCreationCommand(){
		if (sourceCreationCommand == null) {
			if (getSourceEditPart() == null) {

				if (getNodeElementType() == null) {
					sourceCreationCommand = new CreateDefaultNodeCommand(
							getDiagramEditPart(), 
							getDiagramEditPart(),
							sourcePoint);	
				}else{
					sourceCreationCommand = new CreateNodeCommand(
							getDiagramEditPart(),
							getDiagramEditPart(),
							sourcePoint, 
							getNodeElementType());
				}	
			}
		}
		return sourceCreationCommand;
	}

	/**
	 * @return The target node creation command
	 */
	protected CreateNodeCommand getTargetCreationCommand(){
		if (targetCreationCommand == null) {
			if (getTargetEditPart() == null) {
				if (getNodeElementType() == null) {
					targetCreationCommand = new CreateDefaultNodeCommand(
							getDiagramEditPart(),
							getDiagramEditPart(),
							targetPoint);	
				}else{
					targetCreationCommand = new CreateNodeCommand(
							getDiagramEditPart(), 
							getDiagramEditPart(),
							targetPoint,
							getNodeElementType());
				}
			}
		}
		return targetCreationCommand;
	}

	/**
	 * @return An IAdaptable corresponding to the kind of source created. 
	 */
	protected IAdaptable getSourceAdapter() {
		if (getSourceEditPart() != null) {
			DynamicEObjectAdapter existingObjectAdapter = new DynamicEObjectAdapter(
					EditPartUtility.getElement(getSourceEditPart()),
					getDiagramEditPart());
			return existingObjectAdapter;
		}else{
			if (getSourceCreationCommand() != null) {
				return getCreatedObjectAdapter(getSourceCreationCommand());
			}
		}
		return null;
	}


	/** 
	* {@inheritDoc}
	* @see org.unicase.ui.tom.operations.Operation#finish()
	*/
	public void execute() {
		org.eclipse.gef.commands.Command command = getCommand();
		getDiagramEditPart().getDiagramEditDomain().getDiagramCommandStack().execute(command);
	}

	/**
	 * @return The target {@link EditPart} if such exists, null otherwise
	 */
	public EditPart getTargetEditPart() {
		return targetEditPart;
	}

	/**
	 * @return The source {@link EditPart} if such exists, null otherwise
	 */
	public EditPart getSourceEditPart() {
		return sourceEditPart;
	}

	/**
	 * @return The position where the source {@link EditPart} will be created of it does not exist yet
	 */
	public Point getSourcePoint() {
		return sourcePoint;
	}

	/**
	 * @return The position where the target {@link EditPart} will be created of it does not exist yet
	 */
	public Point getTargetPoint() {
		return targetPoint;
	}

	/**
	 * @param connectionElementType The {@link IElementType} of the new connectin
	 */
	public void setConnectionElementType(IElementType connectionElementType) {
		this.connectionElementType = connectionElementType;
	}

	
	/**
	 * @return The {@link IElementType} of the new connection
	 */
	public IElementType getConnectionElementType() {
		return connectionElementType;
	}

	
	/**
	 * @param nodeElementType The {@link IElementType} of the new node
	 */
	public void setNodeElementType(IElementType nodeElementType) {
		this.nodeElementType = nodeElementType;
	}

	/**
	 * @return The {@link IElementType} of the new node
	 */
	public IElementType getNodeElementType() {
		return nodeElementType;
	}

	/** 
	* {@inheritDoc}
	* @see org.unicase.ui.tom.commands.AbstractCommand#createRequest()
	*/
	@Override
	protected Request createRequest() {
		// Do nothing, this command does not require any requests
		return null;
	}


	/**
	 * @param connectionCreationCommand The connection creation command
	 */
	public void setConnectionCreationCommand(CreateConnectionCommand connectionCreationCommand) {
		this.connectionCreationCommand = connectionCreationCommand;
	}
}
