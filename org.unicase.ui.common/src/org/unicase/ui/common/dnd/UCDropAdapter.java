/**
 * <copyright> Copyright (c) 2008 Jonas Helming, Maximilian Koegel. All rights reserved. This program and the accompanying materials are made available under the terms of the Eclipse Public License v1.0 which accompanies this distribution, and is available at http://www.eclipse.org/legal/epl-v10.html
 * </copyright>
 *
 * $Id$
 */

package org.unicase.ui.common.dnd;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.edit.domain.EditingDomain;
import org.eclipse.emf.edit.ui.dnd.EditingDomainViewerDropAdapter;
import org.eclipse.emf.transaction.RecordingCommand;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.gmf.runtime.emf.type.core.ClientContextManager;
import org.eclipse.gmf.runtime.emf.type.core.ElementTypeRegistry;
import org.eclipse.gmf.runtime.emf.type.core.IClientContext;
import org.eclipse.gmf.runtime.emf.type.core.IElementType;
import org.eclipse.jface.viewers.Viewer;
import org.eclipse.swt.dnd.DND;
import org.eclipse.swt.dnd.DropTargetEvent;
import org.unicase.model.Annotation;
import org.unicase.model.ModelElement;
import org.unicase.model.ModelPackage;
import org.unicase.model.diagram.DiagramType;
import org.unicase.model.diagram.MEDiagram;
import org.unicase.model.document.Section;
import org.unicase.model.organization.User;
import org.unicase.model.task.ActionItem;
import org.unicase.model.task.TaskFactory;
import org.unicase.model.task.WorkPackage;
import org.unicase.ui.common.commands.ActionHelper;

/**
 * . Drop adaptor for viewers.
 * 
 * @author Hodaie
 * 
 */
public class UCDropAdapter extends EditingDomainViewerDropAdapter {

	/**
	 * .
	 * 
	 * Constructor
	 * 
	 * @param domain
	 *            the EdtingDomain
	 * @param viewer
	 *            the Viewer
	 */
	public UCDropAdapter(EditingDomain domain, Viewer viewer) {
		super(domain, viewer);
	}

	/**
	 * . {@inheritDoc}
	 */
	@Override
	public void drop(final DropTargetEvent event) {
		final ModelElement target = (ModelElement) event.item.getData();
		@SuppressWarnings("unchecked")
		final Collection<ModelElement> dragSource = (Collection<ModelElement>) getDragSource(event);
		EObject dropee = (EObject) dragSource.toArray()[0];

		if (target instanceof WorkPackage && !(dropee instanceof Annotation)) {
			// create an ActionItem for each droppe
			// add the AI to target
			domain.getCommandStack().execute(
					new RecordingCommand((TransactionalEditingDomain) domain) {
						@Override
						protected void doExecute() {
							for (ModelElement me : dragSource) {
								ActionItem ai = TaskFactory.eINSTANCE
										.createActionItem();
								ai.setName("New Action Item relating "
										+ me.getName());
								ai.getAnnotatedModelElements().add(me);
								((WorkPackage) target).getContainedWorkItems()
										.add(ai);
							}
						}
					});

		} else if (target.eContainer() instanceof WorkPackage
				&& !(dropee instanceof Annotation)) {
			// create an ActionItem for each droppe
			// add the AI to target.eContainer
			domain.getCommandStack().execute(
					new RecordingCommand((TransactionalEditingDomain) domain) {
						@Override
						protected void doExecute() {
							for (ModelElement me : dragSource) {
								ActionItem ai = TaskFactory.eINSTANCE
										.createActionItem();
								ai.setName("New Action Item relating "
										+ me.getName());
								ai.getAnnotatedModelElements().add(me);
								((WorkPackage) target.eContainer())
										.getContainedWorkItems().add(ai);
							}
						}
					});

		} else if ((dropee instanceof Annotation)
				&& !(target instanceof Section || target instanceof WorkPackage || target
						.eContainer() instanceof WorkPackage)) {
			Annotation[] arr = dragSource.toArray(new Annotation[dragSource
					.size()]);
			final List<Annotation> newAnnotations = Arrays.asList(arr);
			domain.getCommandStack().execute(
					new RecordingCommand((TransactionalEditingDomain) domain) {
						@Override
						protected void doExecute() {
							((ModelElement) event.item.getData())
									.getAnnotations().addAll(newAnnotations);
						}
					});
		} else if (target instanceof MEDiagram) {			
			super.drop(event);
			MEDiagram diagram = (MEDiagram) target;
			ActionHelper.openModelElement(diagram);
			
		} else {
			super.drop(event);
		}
	}

	private boolean isElementOfDiagram(MEDiagram diagram, EObject dropee) {
		if(dropee instanceof MEDiagram){
			return false;
		}
		DiagramType type = diagram.getType();
		String clientContextID = "ModelClientContext";
		if(type == DiagramType.USECASE_DIAGRAM) {
			clientContextID = "UseCaseClientContext";			
		}
		else if(type == DiagramType.COMPONENT_DIAGRAM) {
			clientContextID = "ComponentClientContext";			
		}
		IClientContext cc = ClientContextManager.getInstance().getClientContext(clientContextID);
		if(cc == null){
			return false;
		}
		IElementType[] containedTypes = ElementTypeRegistry.getInstance().getElementTypes(cc);
		IElementType dropeeType = ElementTypeRegistry.getInstance().getElementType(dropee,cc);
		boolean contains=false;
		for(int i=0; i<containedTypes.length; i++){
			contains |= containedTypes[i].equals(dropeeType);			
		}
		return contains;
	}

	/**
	 * This method is called the same way for each of the
	 * DropTargetListener methods, except for leave
	 * and drop. If the source is available early, it creates or revalidates the
	 * {@link DragAndDropCommand}, and updates the event's detail (operation)
	 * and feedback (drag under effect), appropriately.
	 * 
	 * @param event
	 *            the DropTargetEvent
	 */
	@Override
	protected void helper(DropTargetEvent event) {

		super.helper(event);
		if (getDragSource(event) == null) {
			return;
		}

		if (event.item == null || event.item.getClass() == null
				|| !(event.item.getData() instanceof ModelElement)) {
			return;
		}		
		ModelElement target = (ModelElement) event.item.getData();
		if (getDragSource(event).contains(target) || getDragSource(event)==target) {
			event.detail = DND.DROP_NONE;
			return;
		}
		EObject eObject = (EObject) getDragSource(event).toArray()[0];
		EClass annotation = ModelPackage.eINSTANCE.getAnnotation();
		if (annotation.isSuperTypeOf(eObject.eClass())) {
			event.detail = event.detail | DND.DROP_COPY;
		}
		if (eObject instanceof User) {

		}
		if(target instanceof MEDiagram) {
			if(!isElementOfDiagram((MEDiagram) target, eObject) ||
					((MEDiagram)target).getElements().contains(eObject)) {
				event.detail = DND.DROP_NONE;
			} else{
				event.detail = event.detail | DND.DROP_COPY;
			}
		}
		if (target instanceof WorkPackage
				|| target.eContainer() instanceof WorkPackage) {
			event.detail = event.detail | DND.DROP_COPY;
		}

	}
}
