/**
 * <copyright> Copyright (c) 2008 Jonas Helming, Maximilian Koegel. All rights reserved. This program and the
 * accompanying materials are made available under the terms of the Eclipse Public License v1.0 which accompanies this
 * distribution, and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>
 */
package org.unicase.ui.tom.commands;

import org.eclipse.draw2d.geometry.Point;
import org.eclipse.emf.common.command.CompoundCommand;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.gef.EditPart;
import org.eclipse.gef.Request;
import org.eclipse.gef.commands.Command;
import org.eclipse.gmf.runtime.common.core.command.CompositeCommand;
import org.eclipse.gmf.runtime.diagram.core.edithelpers.CreateElementRequestAdapter;
import org.eclipse.gmf.runtime.diagram.core.internal.commands.SendToBackCommand;
import org.eclipse.gmf.runtime.diagram.ui.editparts.DiagramEditPart;
import org.eclipse.gmf.runtime.diagram.ui.editparts.GraphicalEditPart;
import org.eclipse.gmf.runtime.diagram.ui.editparts.IGraphicalEditPart;
import org.eclipse.gmf.runtime.diagram.ui.requests.CreateViewAndElementRequest;
import org.eclipse.gmf.runtime.diagram.ui.requests.CreateViewAndElementRequest.ViewAndElementDescriptor;
import org.eclipse.gmf.runtime.emf.type.core.IElementType;
import org.eclipse.gmf.runtime.emf.type.core.IHintedType;
import org.eclipse.gmf.runtime.emf.type.core.requests.CreateElementRequest;
import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.ui.internal.registry.ViewDescriptor;
import org.unicase.ui.common.diagram.util.DynamicViewDescriptorAdapter;

/**
 * @author schroech
 *
 */
public class CreateNodeCommand extends AbstractCommand{
	
	private IElementType elementType;
	private Point point;
	private final GraphicalEditPart targetEditPart;
	private EditPart createdEditPart;
	
	/**
	 * @param diagramEditPart The {@link DiagramEditPart} on which this operation operates
	 * @param point The position where the new editPart is created
	 * @param elementType The {@link IElementType} of the new editPart
	 */
	public CreateNodeCommand(DiagramEditPart diagramEditPart, GraphicalEditPart targetEditPart, Point point, IElementType elementType) {
		super(diagramEditPart);
		
		if (targetEditPart == null) {
			throw new NullPointerException();
		}
		
		this.targetEditPart = targetEditPart;
		this.elementType = elementType;
		setPoint(point);
	}
	
	/** 
	* {@inheritDoc}
	* @see org.unicase.ui.tom.commands.AbstractCommand#createRequest()
	*/
	public Request createRequest() {
		CreateElementRequest createElementRequest = new CreateElementRequest(getElementType());
		CreateElementRequestAdapter createElementRequestAdapter = new CreateElementRequestAdapter(createElementRequest);

		ViewAndElementDescriptor descriptor = new ViewAndElementDescriptor(createElementRequestAdapter,
				org.eclipse.gmf.runtime.notation.Node.class, 
				((IHintedType)getElementType()).getSemanticHint(), 
				((IGraphicalEditPart)getDiagramEditPart()).getDiagramPreferencesHint());
		
		CreateViewAndElementRequest request = new CreateViewAndElementRequest(descriptor);

		request.setSize(null);
		request.setLocation(getPoint());
		
		return request;
	}
	
	/** 
	* {@inheritDoc}
	* @see org.unicase.ui.tom.commands.AbstractCommand#getCommand()
	*/
	public Command getCommand() {
		Command command = getTargetEditPart().getCommand(getRequest());
		return command;
	}

	private EditPart findCreatedEditPart() {
		Request request = getRequest();
		if (request instanceof CreateViewAndElementRequest) {
			ViewAndElementDescriptor descriptor = ((CreateViewAndElementRequest) request).getViewAndElementDescriptor();
			View view = (View) descriptor.getAdapter(View.class);
			EObject element = view.getElement();
			EditPart foundEditPart = targetEditPart.findEditPart(null, element);
			
			return foundEditPart;
		}
		return null;
	}
	
	/**
	 * @param elementType The {@link IElementType} of the new editPart 
	 */
	public void setElementType(IElementType elementType) {
		this.elementType = elementType;
	}


	/**
	 * @return  The {@link IElementType} of the new editPart
	 */
	public IElementType getElementType() {
		return elementType;
	}

	/**
	 * @return The position where the new editPart is created
	 */
	public Point getPoint() {
		return point;
	}

	/**
	 * @param point The position where the new editPart is created
	 */
	public void setPoint(Point point) {
		this.point = point;
	}

	public GraphicalEditPart getTargetEditPart() {
		return targetEditPart;
	}

	public void setCreatedEditPart(EditPart createdEditPart) {
		this.createdEditPart = createdEditPart;
	}

	public EditPart getCreatedEditPart() {
		if (createdEditPart == null) {
			createdEditPart = findCreatedEditPart();
		}
		return createdEditPart;
	}


}
