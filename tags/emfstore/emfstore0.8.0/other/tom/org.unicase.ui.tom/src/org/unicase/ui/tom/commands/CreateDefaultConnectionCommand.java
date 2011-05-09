/**
 * <copyright> Copyright (c) 2008-2009 Jonas Helming, Maximilian Koegel. All rights reserved. This program and the
 * accompanying materials are made available under the terms of the Eclipse Public License v1.0 which accompanies this
 * distribution, and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>
 */
package org.unicase.ui.tom.commands;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.gef.Request;
import org.eclipse.gef.requests.CreateRequest;
import org.eclipse.gmf.runtime.diagram.ui.commands.DeferredCreateConnectionViewAndElementCommand;
import org.eclipse.gmf.runtime.diagram.ui.commands.ICommandProxy;
import org.eclipse.gmf.runtime.diagram.ui.editparts.DiagramEditPart;
import org.eclipse.gmf.runtime.diagram.ui.editparts.GraphicalEditPart;
import org.eclipse.gmf.runtime.diagram.ui.editparts.IGraphicalEditPart;
import org.eclipse.gmf.runtime.diagram.ui.requests.CreateUnspecifiedTypeConnectionRequest;
import org.eclipse.gmf.runtime.emf.type.core.IElementType;
import org.eclipse.gmf.runtime.emf.ui.services.modelingassistant.ModelingAssistantService;

/**
 * @author schroech
 *
 */
public class CreateDefaultConnectionCommand extends CreateConnectionCommand {

	/**
	 * @author schroech
	 *
	 */
	private class DefaultElementTypeAdapter implements IAdaptable{

		private IElementType elementType;

		public DefaultElementTypeAdapter() {

		}

		public Object getAdapter(Class adapter) {
			if (adapter.isInstance(getElementType())) {
				return getElementType();
			}

			if (adapter.isInstance(this)) {
				return this;
			}

			return null;
		}

		public IElementType getElementType() {
			if (elementType == null) {
				if (getSourceAdapter().getAdapter(GraphicalEditPart.class) == null
						|| getTargetAdapter().getAdapter(GraphicalEditPart.class) == null) {
					return null;
				}

				ModelingAssistantService service = ModelingAssistantService.getInstance();

				List relatedConnectionTypes = service.getRelTypesOnSourceAndTarget(getSourceAdapter(),
						getTargetAdapter());

				for (Object object : relatedConnectionTypes) {
					if (object instanceof IElementType) {
						elementType = (IElementType) object;
						break;
					}
				}

				if (elementType == null) {
					throw new IllegalStateException("No ElementType registered for connection between input arguments sourceEditPart and targetEditPart");
				}
			}

			return elementType;
		}
	}

	/**
	 * @param diagramEditPart The {@link DiagramEditPart} on which this operation operates
	 * @param sourceAdapter An {@link IAdaptable} adapting to the source model element
	 * @param targetAdapter An {@link IAdaptable} adapting to the target model element
	 */
	public CreateDefaultConnectionCommand(DiagramEditPart diagramEditPart,
			IAdaptable sourceAdapter, IAdaptable targetAdapter) {
		super(diagramEditPart, sourceAdapter, targetAdapter, null);
	}

	/** 
	 * {@inheritDoc}
	 * @see org.unicase.ui.tom.commands.CreateConnectionCommand#createRequest()
	 */
	@Override
	public Request createRequest() {
		CreateUnspecifiedTypeConnectionRequest newRequest = 
			new CreateUnspecifiedTypeConnectionRequest(
					getPossibleElementTypes(), 
					false, 
					((IGraphicalEditPart)getDiagramEditPart()).getDiagramPreferencesHint());

		return newRequest;
	}

	/** 
	 * {@inheritDoc}
	 * @see org.unicase.ui.tom.commands.CreateConnectionCommand#getCommand()
	 */
	@Override
	public org.eclipse.gef.commands.Command getCommand(){
		DeferredCreateConnectionViewAndElementCommand deferredCreateConnectionViewAndElementCommand 
		= new DeferredCreateConnectionViewAndElementCommand((CreateRequest) getRequest(),
				new DefaultElementTypeAdapter(),
				getSourceAdapter(),
				getTargetAdapter(),
				getDiagramEditPart().getViewer());

		return new ICommandProxy(deferredCreateConnectionViewAndElementCommand);
	}

	/**
	 * @return The {@link IElementType}s that may be created on the source and target.
	 */
	@SuppressWarnings("unchecked")
	List<IElementType> getPossibleElementTypes(){
		List<IElementType> possibleElementTypes = new ArrayList<IElementType>();

		ModelingAssistantService service = ModelingAssistantService.getInstance();

		if(getSourceAdapter().getAdapter(GraphicalEditPart.class) != null) {
			possibleElementTypes.addAll(service.getRelTypesOnSource(getSourceAdapter()));
		}else if (getTargetAdapter().getAdapter(GraphicalEditPart.class) != null) {
			possibleElementTypes.addAll(service.getRelTypesOnTarget(getTargetAdapter()));
		}

		return possibleElementTypes;
	}
}
