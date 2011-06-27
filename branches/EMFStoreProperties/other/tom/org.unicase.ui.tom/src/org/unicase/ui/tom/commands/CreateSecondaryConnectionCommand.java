/**
 * <copyright> Copyright (c) 2008-2009 Jonas Helming, Maximilian Koegel. All rights reserved. This program and the
 * accompanying materials are made available under the terms of the Eclipse Public License v1.0 which accompanies this
 * distribution, and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>
 */
package org.unicase.ui.tom.commands;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.gef.requests.CreateRequest;
import org.eclipse.gmf.runtime.diagram.ui.commands.DeferredCreateConnectionViewAndElementCommand;
import org.eclipse.gmf.runtime.diagram.ui.commands.ICommandProxy;
import org.eclipse.gmf.runtime.diagram.ui.editparts.DiagramEditPart;
import org.eclipse.gmf.runtime.diagram.ui.editparts.GraphicalEditPart;
import org.eclipse.gmf.runtime.emf.type.core.IElementType;
import org.eclipse.gmf.runtime.emf.type.core.SpecializationType;
import org.eclipse.gmf.runtime.emf.ui.services.modelingassistant.ModelingAssistantService;

/**
 * @author schroech
 *
 */
public class CreateSecondaryConnectionCommand extends
		CreateDefaultConnectionCommand {

	/**
	 * @author schroech
	 *
	 */
	private class SecondaryElementTypeAdapter implements IAdaptable{

		private IElementType elementType;

		public SecondaryElementTypeAdapter() {

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

		@SuppressWarnings("unchecked")
		public IElementType getElementType() {
			if (elementType == null) {
				if (getSourceAdapter().getAdapter(GraphicalEditPart.class) == null
						|| getTargetAdapter().getAdapter(GraphicalEditPart.class) == null) {
					return null;
				}

				ModelingAssistantService service = ModelingAssistantService.getInstance();

				List relatedConnectionTypes = service.getRelTypesOnSourceAndTarget(getSourceAdapter(),
						getTargetAdapter());

				Set superTypes = new HashSet<IElementType>();
				
				for (Object object : relatedConnectionTypes) {
					if (object instanceof SpecializationType){
						IElementType[] specializedTypes = ((SpecializationType)object).getSpecializedTypes();
						if (specializedTypes.length > 0) {
							IElementType specializedType = specializedTypes[0];
							superTypes.add(specializedType);
						}else{
							superTypes.add(object);
						}
					}else{
						superTypes.add(object);
					}
					
					if (superTypes.size() == 2) {
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
	public CreateSecondaryConnectionCommand(DiagramEditPart diagramEditPart,
			IAdaptable sourceAdapter, IAdaptable targetAdapter) {
		super(diagramEditPart, sourceAdapter, targetAdapter);
	}
	
	/** 
	 * {@inheritDoc}
	 * @see org.unicase.ui.tom.commands.CreateConnectionCommand#getCommand()
	 */
	@Override
	public org.eclipse.gef.commands.Command getCommand(){
		DeferredCreateConnectionViewAndElementCommand deferredCreateConnectionViewAndElementCommand 
		= new DeferredCreateConnectionViewAndElementCommand((CreateRequest) getRequest(),
				new SecondaryElementTypeAdapter(),
				getSourceAdapter(),
				getTargetAdapter(),
				getDiagramEditPart().getViewer());

		return new ICommandProxy(deferredCreateConnectionViewAndElementCommand);
	}

}
