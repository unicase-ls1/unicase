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
import org.unicase.model.document.CompositeSection;
import org.unicase.model.document.DocumentFactory;
import org.unicase.model.document.LeafSection;
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

	
	public static final String DRAG_SOURCE_KEY = "dragSource";
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
		
		final List<ModelElement> source = (List<ModelElement>) viewer.getData(DRAG_SOURCE_KEY);
		if(source == null){
			return;
		}
		ModelElement dropee = source.get(0);
		
		if (event.item == null || event.item.getClass() == null
				|| !(event.item.getData() instanceof ModelElement)) {
			return;
		}
		final ModelElement target = (ModelElement) event.item.getData();
		
		
		if (target instanceof WorkPackage && !(dropee instanceof Annotation)) {
			// create an ActionItem for each droppe
			// add the AI to target
			domain.getCommandStack().execute(
					new RecordingCommand((TransactionalEditingDomain) domain) {
						@Override
						protected void doExecute() {
							for (ModelElement me : source) {
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
							for (ModelElement me : source) {
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
			Annotation[] arr = source.toArray(new Annotation[source
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
		if (dropee instanceof MEDiagram) {
			return false;
		}
		DiagramType type = diagram.getType();
		String clientContextID = "ModelClientContext";
		if (type == DiagramType.USECASE_DIAGRAM) {
			clientContextID = "UseCaseClientContext";
		} else if (type == DiagramType.COMPONENT_DIAGRAM) {
			clientContextID = "ComponentClientContext";
		}
		IClientContext cc = ClientContextManager.getInstance()
				.getClientContext(clientContextID);
		if (cc == null) {
			return false;
		}
		IElementType[] containedTypes = ElementTypeRegistry.getInstance()
				.getElementTypes(cc);
		IElementType dropeeType = ElementTypeRegistry.getInstance()
				.getElementType(dropee, cc);
		boolean contains = false;
		for (int i = 0; i < containedTypes.length; i++) {
			contains |= containedTypes[i].equals(dropeeType);
		}
		return contains;
	}

	/**
	 * This method is called the same way for each of the DropTargetListener
	 * methods, except for leave and drop. If the source is available early, it
	 * creates or revalidates the DragAndDropCommand, and updates the event's
	 * detail (operation) and feedback (drag under effect), appropriately.
	 * 
	 * @param event
	 *            the DropTargetEvent
	 */
	@Override
	protected void helper(DropTargetEvent event) {

		super.helper(event);
		
		List<ModelElement> source = (List<ModelElement>) viewer.getData(DRAG_SOURCE_KEY);
		
		if (source == null) {
			return;
		}
		ModelElement dropee = source.get(0);
		
		if (event.item == null || event.item.getClass() == null
				|| !(event.item.getData() instanceof ModelElement)) {
			return;
		}
		ModelElement target = (ModelElement) event.item.getData();
		
		
		if (target.eContents().contains(dropee)
				|| target.equals(dropee) ) {
			event.detail = DND.DROP_NONE;
			return;
		}
		if (target instanceof CompositeSection) {
			if (!(dropee instanceof LeafSection)) {
				event.detail = DND.DROP_NONE;
				return;
			}
	
		}
		if (target instanceof LeafSection) {
			LeafSection leafSection = (LeafSection) target;
			if(leafSection.getModelElements().contains(dropee)){
				event.detail = DND.DROP_NONE;
				return;
			}
		}

		EClass annotation = ModelPackage.eINSTANCE.getAnnotation();
		if (annotation.isSuperTypeOf(dropee.eClass())) {
			event.detail = event.detail | DND.DROP_COPY;
		}
		
		if (target instanceof MEDiagram) {
			if (!isElementOfDiagram((MEDiagram) target, dropee)
					|| ((MEDiagram) target).getElements().contains(dropee)) {
				event.detail = DND.DROP_NONE;
			} else {
				event.detail = event.detail | DND.DROP_COPY;
			}
		}
		if (target instanceof WorkPackage
				|| target.eContainer() instanceof WorkPackage) {
			event.detail = event.detail | DND.DROP_COPY;
		}

	}
}





































///**
// * <copyright> Copyright (c) 2008 Jonas Helming, Maximilian Koegel. All rights reserved. This program and the accompanying materials are made available under the terms of the Eclipse Public License v1.0 which accompanies this distribution, and is available at http://www.eclipse.org/legal/epl-v10.html
// * </copyright>
// *
// * $Id$
// */
//
//package org.unicase.ui.common.dnd;
//
//import java.util.Arrays;
//import java.util.List;
//
//import org.eclipse.emf.common.util.EList;
//import org.eclipse.emf.ecore.EClass;
//import org.eclipse.emf.ecore.EObject;
//import org.eclipse.emf.ecore.EReference;
//import org.eclipse.emf.edit.domain.EditingDomain;
//import org.eclipse.emf.edit.ui.dnd.EditingDomainViewerDropAdapter;
//import org.eclipse.emf.transaction.RecordingCommand;
//import org.eclipse.emf.transaction.TransactionalEditingDomain;
//import org.eclipse.gmf.runtime.emf.type.core.ClientContextManager;
//import org.eclipse.gmf.runtime.emf.type.core.ElementTypeRegistry;
//import org.eclipse.gmf.runtime.emf.type.core.IClientContext;
//import org.eclipse.gmf.runtime.emf.type.core.IElementType;
//import org.eclipse.jface.viewers.Viewer;
//import org.eclipse.swt.dnd.DND;
//import org.eclipse.swt.dnd.DropTargetEvent;
//import org.unicase.model.Annotation;
//import org.unicase.model.ModelElement;
//import org.unicase.model.ModelPackage;
//import org.unicase.model.diagram.DiagramType;
//import org.unicase.model.diagram.MEDiagram;
//import org.unicase.model.document.CompositeSection;
//import org.unicase.model.document.LeafSection;
//import org.unicase.model.document.Section;
//import org.unicase.model.task.ActionItem;
//import org.unicase.model.task.TaskFactory;
//import org.unicase.model.task.WorkPackage;
//import org.unicase.ui.common.commands.ActionHelper;
//
///**
// * Drop adaptor for viewers.
// * 
// * @author Hodaie
// * 
// */
//
//
//
//public class UCDropAdapter extends EditingDomainViewerDropAdapter {
//	public static final String DRAG_SOURCE_KEY = "dragSource";
//	
//	/**
//	 * 
//	 * 
//	 * Constructor.
//	 * 
//	 * @param domain
//	 *            the EdtingDomain
//	 * @param viewer
//	 *            the Viewer
//	 */
//	public UCDropAdapter(EditingDomain domain, Viewer viewer) {
//		super(domain, viewer);
//	}
//	
//	/**
//	 * {@inheritDoc}
//	 */
//	@SuppressWarnings("unchecked")
//	@Override
//	public void drop(final DropTargetEvent event) {
//		
//		final List<ModelElement> source = (List<ModelElement>) viewer.getData(DRAG_SOURCE_KEY);
//		if(source == null){
//			return;
//		}
//		ModelElement dropee = source.get(0);
//		
//		if (event.item == null || event.item.getClass() == null
//				|| !(event.item.getData() instanceof ModelElement)) {
//			return;
//		}
//		final ModelElement target = (ModelElement) event.item.getData();
//		
////		if(source.size() > 0){
////			dropMany(source, target);
////			return;
////		}
//			
//		
//		if (target instanceof WorkPackage && !(dropee instanceof Annotation)) {
//			// create an ActionItem for each droppe
//			// add the AI to target
//			domain.getCommandStack().execute(
//					new RecordingCommand((TransactionalEditingDomain) domain) {
//						@Override
//						protected void doExecute() {
//							for (ModelElement me : source) {
//								ActionItem ai = TaskFactory.eINSTANCE
//										.createActionItem();
//								ai.setName("New Action Item relating "
//										+ me.getName());
//								ai.getAnnotatedModelElements().add(me);
//								((WorkPackage) target).getContainedWorkItems()
//										.add(ai);
//							}
//						}
//					});
//	
//		} else if (target.eContainer() instanceof WorkPackage
//				&& !(dropee instanceof Annotation)) {
//			//when a model element is dropped on an item in a workpackage 
//			
//			// create an ActionItem for each droppe
//			// add the AI to target.eContainer
//			domain.getCommandStack().execute(
//					new RecordingCommand((TransactionalEditingDomain) domain) {
//						@Override
//						protected void doExecute() {
//							for (ModelElement me : source) {
//								ActionItem ai = TaskFactory.eINSTANCE
//										.createActionItem();
//								ai.setName("New Action Item relating "
//										+ me.getName());
//								ai.getAnnotatedModelElements().add(me);
//								((WorkPackage) target.eContainer())
//										.getContainedWorkItems().add(ai);
//							}
//						}
//					});
//	
//		} else if ((dropee instanceof Annotation)
//				&& !(target instanceof Section || target instanceof WorkPackage || target
//						.eContainer() instanceof WorkPackage)) {
//			//when an annotation is dropped on a model element, which is not a Section, 
//			//WorkPackage or contained in a WorkPackage.
//			
//			Annotation[] arr = source.toArray(new Annotation[source
//					.size()]);
//			final List<Annotation> newAnnotations = Arrays.asList(arr);
//			domain.getCommandStack().execute(
//					new RecordingCommand((TransactionalEditingDomain) domain) {
//						@Override
//						protected void doExecute() {
//							((ModelElement) event.item.getData())
//									.getAnnotations().addAll(newAnnotations);
//						}
//					});
//		} else if (target instanceof MEDiagram) {
//			super.drop(event);
//			MEDiagram diagram = (MEDiagram) target;
//			ActionHelper.openModelElement(diagram);
//	
//		} else {
//			 super.drop(event);
//		}
//	}
//	
////	private void dropMany(final List<ModelElement> source, final ModelElement target) {
////		ModelElement dropee = source.get(0);
////		final List<EReference> targetReferences = target.eClass().getEAllReferences();
////		boolean hasThisReference = false;
////		EReference tmpReference = null;
////		for(EReference ref : targetReferences){
////			if(ref.getEReferenceType().equals(dropee.eClass()) && ref.isContainment()){
////				hasThisReference = true;
////				tmpReference = ref;
////				break;
////			}
////		}
////		
////		if(!hasThisReference){
////			return;
////		}
////		final EReference thisReference = tmpReference;
////		domain.getCommandStack().execute(
////				new RecordingCommand((TransactionalEditingDomain) domain) {
////					@Override
////					protected void doExecute() {
////						Object object = target.eGet(thisReference);
////						EList<EObject> eList = (EList<EObject>) object;
////						eList.addAll(source);
////					}
////				});
////	}
//
//	private boolean isElementOfDiagram(MEDiagram diagram, EObject dropee) {
//		if (dropee instanceof MEDiagram) {
//			return false;
//		}
//		DiagramType type = diagram.getType();
//		String clientContextID = "ModelClientContext";
//		if (type == DiagramType.USECASE_DIAGRAM) {
//			clientContextID = "UseCaseClientContext";
//		} else if (type == DiagramType.COMPONENT_DIAGRAM) {
//			clientContextID = "ComponentClientContext";
//		}
//		IClientContext cc = ClientContextManager.getInstance()
//				.getClientContext(clientContextID);
//		if (cc == null) {
//			return false;
//		}
//		IElementType[] containedTypes = ElementTypeRegistry.getInstance()
//				.getElementTypes(cc);
//		IElementType dropeeType = ElementTypeRegistry.getInstance()
//				.getElementType(dropee, cc);
//		boolean contains = false;
//		for (int i = 0; i < containedTypes.length; i++) {
//			contains |= containedTypes[i].equals(dropeeType);
//		}
//		return contains;
//	}
//	
//	/**
//	 * This method is called the same way for each of the DropTargetListener
//	 * methods, except for leave and drop. If the source is available early, it
//	 * creates or revalidates the DragAndDropCommand, and updates the event's
//	 * detail (operation) and feedback (drag under effect), appropriately.
//	 * 
//	 * @param event
//	 *            the DropTargetEvent
//	 */
//	@SuppressWarnings("unchecked")
//	@Override
//	protected void helper(DropTargetEvent event) {
//	
//		super.helper(event);
//		List<ModelElement> source = (List<ModelElement>) viewer.getData(DRAG_SOURCE_KEY);
//		
//		if (source == null) {
//			return;
//		}
//		ModelElement dropee = source.get(0);
//		
//		if (event.item == null || event.item.getClass() == null
//				|| !(event.item.getData() instanceof ModelElement)) {
//			return;
//		}
//		ModelElement target = (ModelElement) event.item.getData();
//		
//		
//		if (target.eContents().contains(dropee)
//				|| target.equals(dropee) ) {
//			event.detail = DND.DROP_NONE;
//			return;
//		}
//		if (target instanceof CompositeSection) {
//			if (!(dropee instanceof LeafSection)) {
//				event.detail = DND.DROP_NONE;
//				return;
//			}
//	
//		}
//		
////		if(!haveSameEContainer(source)){
////			event.detail = DND.DROP_NONE;
////			return;
////		}
//	
//		EClass annotation = ModelPackage.eINSTANCE.getAnnotation();
//		if (annotation.isSuperTypeOf(dropee.eClass())) {
//			event.detail = event.detail | DND.DROP_COPY;
//		}
//	
//		if (target instanceof MEDiagram) {
//			if (!isElementOfDiagram((MEDiagram) target, dropee)
//					|| ((MEDiagram) target).getElements().contains(dropee)) {
//				event.detail = DND.DROP_NONE;
//			} else {
//				event.detail = event.detail | DND.DROP_COPY;
//			}
//		}
//		if (target instanceof WorkPackage
//				|| target.eContainer() instanceof WorkPackage) {
//			event.detail = event.detail | DND.DROP_COPY;
//		}
//	
//	}
//	
//	private boolean haveSameEContainer(List<ModelElement> source) {
//		ModelElement first = source.get(0);
//		for(ModelElement me : source){
//			if(!first.eContainer().equals(me.eContainer())){
//				return false;
//			}
//		}
//		return true;
//	}
//
//
//
//
//
//
//}
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
////
////package org.unicase.ui.common.dnd;
////
////import java.util.ArrayList;
////import java.util.Collection;
////import java.util.List;
////
////import org.eclipse.emf.common.command.Command;
////import org.eclipse.emf.edit.command.DragAndDropCommand;
////import org.eclipse.emf.edit.command.DragAndDropFeedback;
////import org.eclipse.emf.edit.domain.EditingDomain;
////import org.eclipse.jface.viewers.Viewer;
////import org.eclipse.swt.SWT;
////import org.eclipse.swt.dnd.DND;
////import org.eclipse.swt.dnd.DropTargetAdapter;
////import org.eclipse.swt.dnd.DropTargetEvent;
////import org.eclipse.swt.graphics.Point;
////import org.eclipse.swt.graphics.Rectangle;
////import org.eclipse.swt.widgets.Control;
////import org.eclipse.swt.widgets.Item;
////import org.eclipse.swt.widgets.TableItem;
////import org.eclipse.swt.widgets.TreeItem;
////import org.eclipse.swt.widgets.Widget;
////import org.unicase.model.ModelElement;
////
////
////
////
////
////
/////**
////	 * This implementation of a drop target listener is designed to turn a drag and drop
////	 * operation into a {@link Command} based on the model objects of an
////	 * {@link EditingDomain} and created by {@link DragAndDropCommand#create}. It is
////	 * designed to do early data transfer so the the enablement and feedback of the
////	 * drag and drop interaction can intimately depend on the state of the model objects
////	 * involved.  On some platforms, however, early data transfer is not available, so this
////	 * feedback cannot be provided.
////	 * <p>
////	 * The base implementation of this class should be sufficient for most applications.
////	 * Any change in behaviour is typically accomplished by overriding 
////	 * {@link org.eclipse.emf.edit.provider.ItemProviderAdapter}.createDragAndDropCommand
////	 * to return a derived implementation of {@link DragAndDropCommand}.
////	 * This is how one these adapters is typically hooked up:
////	 * <pre>
////	 *   viewer.addDropSupport
////	 *     (DND.DROP_COPY | DND.DROP_MOVE | DND.DROP_LINK,
////	 *      new Transfer [] { LocalTransfer.getInstance() },
////	 *      EditingDomainViewerDropAdapter(viewer));
////	 * </pre>
////	 * <p>
////	 * This implementation prefers to use a {@link LocalTransfer}, 
////	 * which short-circuits the transfer process for simple transfers within the workbench,
////	 * the method {@link #getDragSource} can be overridden to change the behaviour.
////	 * The implementation also only handles an {@link IStructuredSelection},
////	 * but the method {@link #extractDragSource} can be overridden to change the behaviour.
////	 * <p>
////	 * SWT's {@link DND#FEEDBACK_SCROLL auto-scroll} and {@link DND#FEEDBACK_EXPAND auto-expand}
////	 * (hover) are enabled by default.  The method {@link #getAutoFeedback} can be overridden
////	 * to change this behaviour.
////	 */
////public class UCDropAdapter extends DropTargetAdapter {
////
////	public static final String DRAG_SOURCE_KEY = "dragSource";
////
////	
////	/**
////	   * This indicates whether the current platform is motif, which needs
////	   * special treatment, since it cannot do early data transfer, but doesn't
////	   * cleanly return null either.
////	   */
////	  protected final static boolean IS_MOTIF = "motif".equals(SWT.getPlatform());
////
////	  /**
////	   * This is the viewer for which this is a drop target listener.
////	   */
////	  protected Viewer viewer;
////
////	  /**
////	   * This is the domain in which drag and drop commands will be executed.
////	   */
////	  protected EditingDomain domain;
////
////	  /**
////	   * This is the collection of source objects being dragged.
////	   */
////	  protected List<ModelElement> source;
////
////	  /**
////	   * This is the command created during dragging which provides the feedback and will carry out the action upon completion.
////	   */
////	  protected Command command;
////	 
////	  /**
////	   * This records the object for which the {@link #command} was created.
////	   */
////	  protected Object commandTarget;
////
////	  /**
////	   * This keeps track of the original operation that the user requested, before
////	   * we started changing the event.detail. We always try to create the command
////	   * using this.
////	   */
////	  protected int originalOperation;
////
////	  /**
////	   * This keeps track of the information used to create {@link #command}, but
////	   * does not need to be disposed.  This allows us to dispose of the command
////	   * in dragLeave, and then, if we need to execute it, recreate it in drop.
////	   */
////	  protected DragAndDropCommandInformation dragAndDropCommandInformation;
////
////	  /**
////	   * This creates an instance with the given domain and viewer.
////	   */
////	  public UCDropAdapter(EditingDomain domain, Viewer viewer)
////	  {
////	    this.viewer = viewer;
////	    this.domain = domain;
////	  }
////
////	  /**
////	   * This is called when the mouse first enters or starts dragging in the viewer.
////	   */
////	  @Override
////	  public void dragEnter(DropTargetEvent event)
////	  {
////	    // Remember the requested operation.
////	    originalOperation = event.detail;
////
////	    helper(event);
////	  }
////
////	  /**
////	   * This is called when the mouse leaves or stops dragging in the viewer,
////	   * whether the operation was aborted or is about to do a dropAccept and drop.
////	   * The event argument is uninitialized, so it is impossible to distinguish
////	   * between the two cases.  So, we do the clean-up now and recreate the
////	   * command later, if necessary.
////	   */
////	  @Override
////	  public void dragLeave(DropTargetEvent event)
////	  {
////	    // Clean up the command if there is one.  If we need it again in drop,
////	    // we'll recreate it from dragAndDropCommandInformation.
////	    //
////	    if (command != null)
////	    {
////	      command.dispose();
////	      command = null;
////	      commandTarget = null;
////	    }
////
////	    // Clear the source data.  We won't need this again, since, if it was
////	    // available, it's already in the command.
////	    //
////	    source = null;
////	  }
////
////	  /**
////	   * This is called when the operation has changed in some way, typically because the user changes keyboard modifiers.
////	   */
////	  @Override
////	  public void dragOperationChanged(DropTargetEvent event)
////	  {
////	    // Remember the requested operation.
////	    originalOperation = event.detail;
////
////	    helper(event);
////	  }
////
////	  /**
////	   * This is called repeatedly, as the mouse moves over the viewer.
////	   */
////	  @Override
////	  public void dragOver(DropTargetEvent event) 
////	  {
////	    helper(event);
////	  }
////
////	  /**
////	   * This is called when the mouse is released over the viewer to initiate a
////	   * drop, between dragLeave and drop.
////	   */
////	  @Override
////	  public void dropAccept(DropTargetEvent event) 
////	  {
////	    helper(event);
////	  }
////
////	  /**
////	   * This is called to indicate that the drop action should be invoked.
////	   */
////	  @Override
////	  public void drop(DropTargetEvent event)
////	  {
////	    // A command was created if the source was available early, and the
////	    // information used to create it was cached...
////	    //
////	    if (dragAndDropCommandInformation != null)
////	    {
////	      // Recreate the command.
////	      //
////	      command = dragAndDropCommandInformation.createCommand();
////	    }
////	    else
////	    {
////	      // Otherwise, the source should be available now as event.data, and we
////	      // can create the command.
////	      //
////	     // source = extractDragSource(event.data);
////	      source = (List<ModelElement>) viewer.getData(DRAG_SOURCE_KEY);
////	      Object target = extractDropTarget(event.item);
////	      command = DragAndDropCommand.create(domain, target, getLocation(event), event.operations, originalOperation, source);
////	    }
////
////	    // If the command can execute...
////	    //
////	    if (command.canExecute())
////	    {
////	      // Execute it.
////	      //
////	      domain.getCommandStack().execute(command);
////	    }
////	    else
////	    {
////	      // Otherwise, let's call the whole thing off.
////	      //
////	      event.detail = DND.DROP_NONE;
////	      command.dispose();
////	    }
////
////	    // Clean up the state.
////	    //
////	    command = null;
////	    commandTarget = null;
////	    source = null;
////	  }
////
////	  /**
////	   * This method is called the same way for each of the
////	   * {@link org.eclipse.swt.dnd.DropTargetListener} methods, except for leave
////	   * and drop.  If the source is available early, it creates or revalidates
////	   * the {@link DragAndDropCommand}, and updates the event's detail (operation)
////	   * and feedback (drag under effect), appropriately.
////	   */
////	  protected void helper(DropTargetEvent event)
////	  {
////	    // If we can't do anything else, we'll provide the default select feedback
////	    // and enable auto-scroll and auto-expand effects.
////	    event.feedback = DND.FEEDBACK_SELECT | getAutoFeedback();
////
////	    // If we don't already have it, try to get the source early. We can't give
////	    // feedback if it's not available yet (this is platform-dependent).
////	    //
//////	    if (source == null)
//////	    {
//////	      source = getDragSource(event);
//////	      if (source == null) return;
//////	    }
////	    //HACK: I extract drag source from viewer. It is set in UCDragAdapter.dragStart() event.
////	    source = (List<ModelElement>) viewer.getData(DRAG_SOURCE_KEY);
////		
////		if (source == null) {
////			return;
////		}
////	    
////
////	    // Get the target object from the item widget and the mouse location in it.
////	    //
////	    Object target = extractDropTarget(event.item);
////	    float location = getLocation(event);
////
////	    // Determine if we can create a valid command at the current location.
////	    //
////	    boolean valid = false;
////
////	    // If we don't have a previous cached command...
////	    //
////	    if (command == null)
////	    {
////	      // We'll need to keep track of the information we use to create the
////	      // command, so that we can recreate it in drop.
////	      dragAndDropCommandInformation = new DragAndDropCommandInformation(domain, target, location, event.operations, originalOperation, source);
////
////	      // Remember the target; create the command and test if it is executable.
////	      //
////	      commandTarget = target;
////	      command = dragAndDropCommandInformation.createCommand();
////	      valid = command.canExecute();
////	    }
////	    else
////	    {
////	      // Check if the cached command can provide DND feedback/revalidation.
////	      //
////	      if (target == commandTarget && command instanceof DragAndDropFeedback)
////	      {
////	        // If so, revalidate the command.
////	        //
////	        valid = ((DragAndDropFeedback)command).validate(target, location, event.operations, originalOperation, source);
////
////	        // Keep track of any changes to the command information.
////	        dragAndDropCommandInformation = new DragAndDropCommandInformation(domain, target, location, event.operations, originalOperation, source);
////	      }
////	      else
////	      {
////	        // If not, dispose the current command and create a new one.
////	        //
////	        dragAndDropCommandInformation = new DragAndDropCommandInformation(domain, target, location, event.operations, originalOperation, source);
////	        commandTarget = target;
////	        command.dispose();
////	        command = dragAndDropCommandInformation.createCommand();
////	        valid = command.canExecute();
////	      }
////	    }
////
////	    // If this command can provide detailed drag and drop feedback...
////	    //
////	    if (command instanceof DragAndDropFeedback)
////	    {
////	      // Use it for the operation and drag under effect.
////	      //
////	      DragAndDropFeedback dragAndDropFeedback = (DragAndDropFeedback)command;
////	      event.detail = dragAndDropFeedback.getOperation();
////	      event.feedback = dragAndDropFeedback.getFeedback() | getAutoFeedback();
////	    }
////	    else if (!valid)
////	    {
////	      // There is no executable command, so we'd better nix the whole deal.
////	      //
////	      event.detail = DND.DROP_NONE;
////	    }
////	  }
////
////	  /**
////	   * This returns the bitwise OR'ed flags for desired auto-feedback effects.
////	   * Drag under effect DND constants are always OR'ed with this to enable them.
////	   * This implementation enables {@link DND#FEEDBACK_SCROLL auto-scroll} and
////	   * {@link DND#FEEDBACK_EXPAND auto-expand} (hover).
////	   */
////	  protected int getAutoFeedback()
////	  {
////	    return DND.FEEDBACK_SCROLL | DND.FEEDBACK_EXPAND;
////	  }
////
////	  /** 
////	   * This attempts to extract the drag source from the event early, i.e.,
////	   * before the drop method. This implementation tries to use a
////	   * {@link org.eclipse.emf.edit.ui.dnd.LocalTransfer}. If the data is not yet
////	   * available (e.g. on platforms other than win32), it just returns null.
////	   */
//////	  protected Collection<?> getDragSource(DropTargetEvent event)
//////	  {
//////	    // Check whether the current data type can be transfered locally.
//////	    //
//////	    LocalTransfer localTransfer = LocalTransfer.getInstance();
//////	    if (!localTransfer.isSupportedType(event.currentDataType))
//////	    {
//////	      // Iterate over the data types to see if there is a data type that supports a local transfer.
//////	      //
//////	      TransferData [] dataTypes = event.dataTypes;
//////	      for (int i = 0; i < dataTypes.length; ++i)
//////	      {
//////	        TransferData transferData = dataTypes[i];
//////
//////	        // If the local transfer supports this data type, switch to that data type
//////	        //
//////	        if (localTransfer.isSupportedType(transferData))
//////	        {
//////	          event.currentDataType = transferData;
//////	        }
//////	      }
//////
//////	      return null;
//////	    }
//////	    else
//////	    {
//////	      // Motif kludge: we would get something random instead of null.
//////	      //
//////	      if (IS_MOTIF) return null;
//////
//////	      // Transfer the data and, if non-null, extract it.
//////	      //
//////	      Object object = localTransfer.nativeToJava(event.currentDataType);
//////	      return object == null ? null : extractDragSource(object);
//////	    }
//////	  }
////
////	  /**
////	   * This extracts a collection of dragged source objects from the given object retrieved from the transfer agent.
////	   * This default implementation converts a structured selection into a collection of elements.
////	   */
//////	  protected Collection<?> extractDragSource(Object object)
//////	  {
//////	    // Transfer the data and convert the structured selection to a collection of objects.
//////	    //
//////	    if (object instanceof IStructuredSelection)
//////	    {
//////	      List<?> list = ((IStructuredSelection)object).toList();
//////	      return list;
//////	    }
//////	    else
//////	    {
//////	      return Collections.EMPTY_LIST;
//////	    }
//////	  }
////
////	  /**
////	   * This extracts an object from the given item widget, providing the special
////	   * support required by an 
////	   * {@link org.eclipse.emf.common.ui.viewer.ExtendedTableTreeViewer.ExtendedTableTreeItem}.
////	   */
////	  @SuppressWarnings("deprecation")
////	  protected Object extractDropTarget(Widget item)
////	  {
////	    if (item == null) return null;
////	    return item.getData(org.eclipse.emf.common.ui.viewer.ExtendedTableTreeViewer.ITEM_ID) instanceof Item ?
////	      ((Item)item.getData(org.eclipse.emf.common.ui.viewer.ExtendedTableTreeViewer.ITEM_ID)).getData() :
////	      item.getData();
////	  }
////
////
////	  /**
////	   * This returns the location of the mouse in the vertical direction, relative
////	   * to the item widget, from 0 (top) to 1 (bottom).
////	   */
////	  protected float getLocation(DropTargetEvent event) 
////	  {
////	    if (event.item instanceof TreeItem)
////	    {
////	      TreeItem treeItem = (TreeItem)event.item;
////	      Control control = treeItem.getParent();
////	      Point point = control.toControl(new Point(event.x, event.y));
////	      Rectangle bounds = treeItem.getBounds();
////	      return (float)(point.y - bounds.y) / (float)bounds.height;
////	    }
////	    else if (event.item instanceof TableItem)
////	    {
////	      TableItem tableItem = (TableItem)event.item;
////	      Control control = tableItem.getParent();
////	      Point point = control.toControl(new Point(event.x, event.y));
////	      Rectangle bounds = tableItem.getBounds(0);
////	      return (float)(point.y - bounds.y) / (float)bounds.height;
////	    }
////	    else
////	    {
////	      return 0.0F;
////	    }
////	  }
////	  
////	  /**
////	   * This holds all of the information used to create a
////	   * {@link DragAndDropCommand}, but does not need to be disposed.
////	   */
////	  protected static class DragAndDropCommandInformation
////	  {
////	    protected EditingDomain domain;
////	    protected Object target;
////	    protected float location;
////	    protected int operations;
////	    protected int operation;
////	    protected Collection<?> source;
////	    public DragAndDropCommandInformation
////	      (EditingDomain domain, Object target, float location, int operations, int operation, Collection<?> source)
////	    {
////	      this.domain = domain;
////	      this.target = target;
////	      this.location = location;
////	      this.operations = operations;
////	      this.operation = operation;
////	      this.source = new ArrayList<Object>(source);
////	    }
////
////	    public Command createCommand()
////	    {
////	      return DragAndDropCommand.create(domain, target, location, operations, operation, source);
////	    }
////	  }
////}
////
////
////
////
////
