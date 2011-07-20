/**
 * <copyright> Copyright (c) 2008-2009 Jonas Helming, Maximilian Koegel. All rights reserved. This program and the
 * accompanying materials are made available under the terms of the Eclipse Public License v1.0 which accompanies this
 * distribution, and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>
 */
package org.unicase.ui.tom.commands;

import org.eclipse.draw2d.geometry.Point;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.gef.EditPart;
import org.eclipse.gef.Request;
import org.eclipse.gef.commands.Command;
import org.eclipse.gmf.runtime.diagram.core.edithelpers.CreateElementRequestAdapter;
import org.eclipse.gmf.runtime.diagram.ui.editparts.DiagramEditPart;
import org.eclipse.gmf.runtime.diagram.ui.editparts.GraphicalEditPart;
import org.eclipse.gmf.runtime.diagram.ui.editparts.IGraphicalEditPart;
import org.eclipse.gmf.runtime.diagram.ui.requests.CreateViewAndElementRequest;
import org.eclipse.gmf.runtime.diagram.ui.requests.CreateViewAndElementRequest.ViewAndElementDescriptor;
import org.eclipse.gmf.runtime.emf.type.core.IElementType;
import org.eclipse.gmf.runtime.emf.type.core.IHintedType;
import org.eclipse.gmf.runtime.emf.type.core.requests.CreateElementRequest;
import org.eclipse.gmf.runtime.notation.View;

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
	 * @param targetEditPart The target edit part, used for the creation of subnodes
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
	@Override
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
	@Override
	public Command getCommand() {
		Command command = getTargetEditPart().getCommand(getRequest());
		return command;
	}

	private EditPart findCreatedEditPart() {
		Request request = getRequest();
		if (request instanceof CreateViewAndElementRequest) {
			ViewAndElementDescriptor descriptor = ((CreateViewAndElementRequest) request).getViewAndElementDescriptor();
			View view = (View) descriptor.getAdapter(View.class);
			if (view == null) {
				return null;
			}
			EObject element = view.getElement();
			if (element == null) {
				return null;
			}
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

	/**
	 * @return The target edit part
	 */
	public GraphicalEditPart getTargetEditPart() {
		return targetEditPart;
	}

	/**
	 * @param createdEditPart The created edit part
	 */
	public void setCreatedEditPart(EditPart createdEditPart) {
		this.createdEditPart = createdEditPart;
	}

	/**
	 * @return The created edit part
	 */
	public EditPart getCreatedEditPart() {
		if (createdEditPart == null) {
			createdEditPart = findCreatedEditPart();
		}
		return createdEditPart;
	}


}
