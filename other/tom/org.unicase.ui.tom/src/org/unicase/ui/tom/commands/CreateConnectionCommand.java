/**
 * <copyright> Copyright (c) 2008-2009 Jonas Helming, Maximilian Koegel. All rights reserved. This program and the
 * accompanying materials are made available under the terms of the Eclipse Public License v1.0 which accompanies this
 * distribution, and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>
 */
package org.unicase.ui.tom.commands;

import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.gef.Request;
import org.eclipse.gmf.runtime.diagram.ui.commands.DeferredCreateConnectionViewAndElementCommand;
import org.eclipse.gmf.runtime.diagram.ui.commands.ICommandProxy;
import org.eclipse.gmf.runtime.diagram.ui.editparts.DiagramEditPart;
import org.eclipse.gmf.runtime.diagram.ui.editparts.IGraphicalEditPart;
import org.eclipse.gmf.runtime.diagram.ui.requests.CreateConnectionViewAndElementRequest;
import org.eclipse.gmf.runtime.emf.type.core.IElementType;
import org.eclipse.gmf.runtime.emf.type.core.IHintedType;

/**
 * @author schroech
 *
 */
public class CreateConnectionCommand extends AbstractCommand {

	private IElementType elementType;
	private final IAdaptable sourceAdapter;
	private final IAdaptable targetAdapter;
	
	/**
	 * Default constructor.
	 * 
	 * @param diagramEditPart The {@link DiagramEditPart} on which this operation operates
	 * @param sourceAdapter An {@link IAdaptable} adapting to the source model element
	 * @param targetAdapter An {@link IAdaptable} adapting to the target model element
	 * @param elementType The {@link IElementType} of connection being created, may be null
	 */
	CreateConnectionCommand(DiagramEditPart diagramEditPart, 
			IAdaptable sourceAdapter, 
			IAdaptable targetAdapter,
			IElementType elementType) {
		super(diagramEditPart);
		
		if (sourceAdapter == null) {
			throw new NullPointerException();
		}
		
		if (targetAdapter == null) {
			throw new NullPointerException();
		}
		
		this.sourceAdapter = sourceAdapter;
		this.targetAdapter = targetAdapter;
		this.elementType = elementType;
	}

	/** 
	* {@inheritDoc}
	* @see org.unicase.ui.tom.commands.AbstractCommand#createRequest()
	*/
	public Request createRequest() {		
		CreateConnectionViewAndElementRequest newRequest 
		= new CreateConnectionViewAndElementRequest(
				getElementType(),
				((IHintedType) getElementType()).getSemanticHint(),
				((IGraphicalEditPart)getDiagramEditPart()).getDiagramPreferencesHint());

		return newRequest;
	}
	

	/** 
	* {@inheritDoc}
	* @see org.unicase.ui.tom.commands.AbstractCommand#getCommand()
	*/
	public org.eclipse.gef.commands.Command getCommand(){
		DeferredCreateConnectionViewAndElementCommand deferredCreateConnectionViewAndElementCommand 
		= new DeferredCreateConnectionViewAndElementCommand(
				(CreateConnectionViewAndElementRequest) getRequest(), 
				getSourceAdapter(), 
				getTargetAdapter(), 
				getDiagramEditPart().getViewer());

		return new ICommandProxy(deferredCreateConnectionViewAndElementCommand);
	}
	

	/**
	 * @param elementType The element type which this command should create
	 */
	public void setElementType(IElementType elementType) {
		this.elementType = elementType;
	}

	/**
	 * @return The element type which this command should create
	 */
	public IElementType getElementType() {
		return elementType;
	}

	/**
	 * @return An {@link IAdaptable} adapting to the source model element 
	 */
	public IAdaptable getSourceAdapter() {
		return sourceAdapter;
	}

	/**
	 * @return An {@link IAdaptable} adapting to the target model element
	 */
	public IAdaptable getTargetAdapter() {
		return targetAdapter;
	}

}
