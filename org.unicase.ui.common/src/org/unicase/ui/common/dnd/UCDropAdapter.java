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
import org.eclipse.emf.edit.command.DragAndDropCommand;
import org.eclipse.emf.edit.domain.EditingDomain;
import org.eclipse.emf.edit.ui.dnd.EditingDomainViewerDropAdapter;
import org.eclipse.emf.transaction.RecordingCommand;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.jface.viewers.Viewer;
import org.eclipse.swt.dnd.DND;
import org.eclipse.swt.dnd.DropTargetEvent;
import org.unicase.model.Annotation;
import org.unicase.model.ModelElement;
import org.unicase.model.ModelPackage;
import org.unicase.model.task.ActionItem;
import org.unicase.model.task.TaskFactory;
import org.unicase.model.task.TaskPackage;
import org.unicase.model.task.WorkPackage;

/**
 * . Drop adaptor for navigator's tree viewer
 * 
 * @author Hodaie
 * 
 */
public class UCDropAdapter extends EditingDomainViewerDropAdapter {

	public UCDropAdapter(EditingDomain domain, Viewer viewer) {
		super(domain, viewer);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void drop(final DropTargetEvent event) {
		final ModelElement target = (ModelElement) event.item.getData();
		final Collection<ModelElement> dragSource = (Collection<ModelElement>) getDragSource(event);
		EObject dropee = (EObject) dragSource.toArray()[0];
		EClass annotation = ModelPackage.eINSTANCE.getAnnotation();
		if (annotation.isSuperTypeOf(dropee.eClass())) {
			Annotation[] arr = dragSource.toArray(new Annotation[dragSource
					.size()]);
			final List<Annotation> newAnnotations = Arrays.asList(arr);
			domain.getCommandStack().execute(
					new RecordingCommand((TransactionalEditingDomain) domain) {
						protected void doExecute() {
							((ModelElement) event.item.getData())
									.getAnnotations().addAll(newAnnotations);
						}
					});
		} else if (target instanceof WorkPackage) {
			// create an ActionItem for each droppe
			// add the AI to target
			domain.getCommandStack().execute(
					new RecordingCommand((TransactionalEditingDomain) domain) {
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

		} else if (target.eContainer() instanceof WorkPackage) {
			// create an ActionItem for each droppe
			// add the AI to target.eContainer
			domain.getCommandStack().execute(
					new RecordingCommand((TransactionalEditingDomain) domain) {
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

		} else {
			super.drop(event);
		}
		// viewer.refresh();

	}

	/**
	 * This method is called the same way for each of the
	 * {@link org.eclipse.swt.dnd.DropTargetListener} methods, except for leave
	 * and drop. If the source is available early, it creates or revalidates the
	 * {@link DragAndDropCommand}, and updates the event's detail (operation)
	 * and feedback (drag under effect), appropriately.
	 */
	@Override
	protected void helper(DropTargetEvent event) {

		super.helper(event);
		ModelElement target = (ModelElement) event.item.getData();
		if (getDragSource(event).contains(target)) {
			event.detail = DND.DROP_NONE;
			return;
		}
		EObject eObject = (EObject) getDragSource(event).toArray()[0];
		EClass annotation = ModelPackage.eINSTANCE.getAnnotation();
		if (annotation.isSuperTypeOf(eObject.eClass())) {
			event.detail = event.detail | DND.DROP_COPY;
		}

		if (target instanceof WorkPackage
				|| target.eContainer() instanceof WorkPackage) {
			event.detail = event.detail | DND.DROP_COPY;
		}

	}
}

// /**
// * . Constructor
// *
// * @param domain
// * EditingDomain
// * @param viewer
// * Viewer
// */
// public UCDropAdapter(EditingDomain domain, Viewer viewer) {
// super(domain, viewer);
//
// }
//
// /**
// * . {@inheritDoc}
// */
// @Override
// public void dragEnter(DropTargetEvent event) {
// // TODO Auto-generated method stub
// super.dragEnter(event);
//
// }
//
// /**
// * . {@inheritDoc}
// */
// @Override
// public void dragOver(DropTargetEvent event) {
// super.dragOver(event);
// //((TreeItem)event.item).getParent().setToolTipText(((ModelElement)event
// // .item.getData()).getName());
// if (event.detail == DragAndDropCommand.FEEDBACK_INSERT_AFTER
// || event.detail == DragAndDropCommand.FEEDBACK_INSERT_BEFORE) {
// // PlatformUI.getWorkbench().getDisplay().beep();
// }
//
// if (event.item.getData() instanceof LeafSection) {
// Collection<?> dragSource = getDragSource(event);
// // for(Object obj : dragSource){
// // if(obj instanceof Section){
// // ZH: Test under MAC
// // event.detail= DND.DROP_NONE;
// // break;
// // }
// // }
// }
//
// if (!(event.item.getData() instanceof Section)) {
// // event.detail= DND.DROP_NONE;
// }
// }
//
// /**
// * . {@inheritDoc}
// *
// */
// @Override
// public void drop(DropTargetEvent event) {
//
// // Object obj = event.data;
// // event.data return a TreeSelection containing
// // the MEs which are draged. (DragSource)
//
// Widget item = event.item;
// final Object target = item.getData();
// final Collection<?> dragSource = getDragSource(event);
// if (target instanceof LeafSection) {
//
// dropOnLeafSection(dragSource, ((LeafSection) target));
//
// } else if (target instanceof CompositeSection) {
//
// dropOnCompositeSection(dragSource, (CompositeSection) target);
//
// } else if (event.detail == DND.DROP_COPY) { // target is a ME but not a
// // Section
//
// dropOnME(dragSource, (ModelElement) target);
//
// } else if (event.detail == DragAndDropCommand.FEEDBACK_INSERT_AFTER) {
// moveAfter(dragSource, (ModelElement) target);
// } else if (event.detail == DragAndDropCommand.FEEDBACK_INSERT_BEFORE) {
// moveBefore(dragSource, (ModelElement) target);
// }
//
// }
//
// private void moveBefore(final Collection<?> dragSource, final ModelElement
// target) {
// final EStructuralFeature feature = target.eContainingFeature();
// List<Object> list2 = new ArrayList<Object>();
// list2.addAll((Collection<?>) target.eContainer().eGet(feature));
// if (list2.containsAll(dragSource)) {
//		
// }
// if (feature.isMany()) {
// domain.getCommandStack().execute(
// new RecordingCommand((TransactionalEditingDomain) domain) {
// protected void doExecute() {
// List<Object> list = new ArrayList<Object>();
// list.addAll((Collection<?>) target.eContainer().eGet(feature));
// int index = list.indexOf(target);
// if (list.containsAll(dragSource)) {
// list.removeAll(dragSource);
// list.addAll(index , dragSource);
// target.eContainer().eSet(feature, list);
// }
// viewer.refresh();
// }
// });
// }
//
//
// }
//
// private void moveAfter(final Collection<?> dragSource,
// final ModelElement target) {
//
// final EStructuralFeature feature = target.eContainingFeature();
// if (feature.isMany()) {
// domain.getCommandStack().execute(
// new RecordingCommand((TransactionalEditingDomain) domain) {
// protected void doExecute() {
// List<Object> list = new ArrayList<Object>();
// list.addAll((Collection<?>) target.eGet(feature));
// int index = list.indexOf(target);
// if (list.containsAll(dragSource)) {
// list.removeAll(dragSource);
// list.addAll(index , dragSource);
// }
// }
// });
// }
//
// }
//
// private void dropOnME(final Collection<?> dragSource,
// final ModelElement target) {
//
// EObject dropee = (EObject) dragSource.toArray()[0];
// EClass dropeeEClass = dropee.eClass();
// for (final EReference ref : target.eClass().getEAllContainments()) {
//
// if (ref.getEReferenceType().equals(dropeeEClass)) {
// domain.getCommandStack().execute(
// new RecordingCommand(
// (TransactionalEditingDomain) domain) {
// protected void doExecute() {
// if (dragSource.contains(target)) {
// return;
// }
//
// if (target.eIsSet(ref) && ref.isMany()) {
//
// List<Object> list = new ArrayList<Object>();
// list.addAll((Collection<?>) target
// .eGet(ref));
// for (Iterator<?> i = dragSource.iterator(); i
// .hasNext();) {
// list.add((Object) i.next());
// }
// target.eSet(ref, list);
//
// } else if (ref.isMany()) {
// target.eSet(ref, dragSource);
// } else {
// target.eSet(ref, dragSource.toArray()[0]);
// }
//
// }
// });
// }
// }
//
// EClass annotation = ModelPackage.eINSTANCE.getAnnotation();
// if (annotation.isSuperTypeOf(dropeeEClass)) {
// Annotation[] arr = dragSource.toArray(new Annotation[dragSource
// .size()]);
// final List<Annotation> newAnnotations = Arrays.asList(arr);
// domain.getCommandStack().execute(
// new RecordingCommand((TransactionalEditingDomain) domain) {
// protected void doExecute() {
// target.getAnnotations().addAll(newAnnotations);
// }
// });
//
// }
//
// }
//
// private void dropOnCompositeSection(final Collection<?> dragSource,
// final CompositeSection compositeSection) {
//
// domain.getCommandStack().execute(
// new RecordingCommand((TransactionalEditingDomain) domain) {
// protected void doExecute() {
// for (Object object : dragSource) {
// if (object instanceof Section) {
// addSectionToCompositeSection((Section) object,
// compositeSection);
// }
// }
// }
// });
//
// }
//
// private void dropOnLeafSection(final Collection<?> dragSource,
// final LeafSection leafSection) {
//
// domain.getCommandStack().execute(
// new RecordingCommand((TransactionalEditingDomain) domain) {
// protected void doExecute() {
// for (Object object : dragSource) {
// if (object instanceof ModelElement) {
// addMEtoLeafSection((ModelElement) object,
// leafSection);
// }
// }
// }
// });
//
// }
//
// private void addSectionToCompositeSection(Section section,
// CompositeSection compositeSection) {
// if (section.equals(compositeSection)) {
// return;
// }
// compositeSection.getSubsections().add(section);
// this.viewer.refresh();
//
// }
//
// private void addMEtoLeafSection(ModelElement me, LeafSection leafSection) {
// if (me instanceof Section) {
// return;
// }
// leafSection.getModelElements().add(me);
//
// // domain.getCommandStack().undo();
// this.viewer.refresh();
//
// }

// super.helper(event);
// ModelElement target = (ModelElement)event.item.getData();
// if(getDragSource(event).contains(target)){
// event.detail = DND.DROP_NONE;
// return;
// }
// EObject eObject = (EObject) getDragSource(event).toArray()[0];
// Set<EClass> references = new HashSet<EClass>();
// for(EReference ref :
// ((ModelElement)event.item.getData()).eClass().getEAllReferences()){
// references.add(ref.getEReferenceType());
// }
//
// Set<EClass> incomming = new HashSet<EClass>();
// incomming.add(eObject.eClass());
// for(EClass superType : eObject.eClass().getEAllSuperTypes()){
// incomming.add(superType);
// }
// references.retainAll(incomming);
// if(!references.isEmpty()){
// // event.detail = event.detail | DND.DROP_COPY;
// DragAndDropFeedback dragAndDropFeedback = (DragAndDropFeedback)command;
// event.detail = dragAndDropFeedback.getOperation() | DND.DROP_COPY;
// event.feedback = dragAndDropFeedback.getFeedback() | getAutoFeedback() |
// dragAndDropFeedback.FEEDBACK_SELECT;
// // event.feedback = event.feedback | DND.FEEDBACK_SELECT;// |
// DND.FEEDBACK_INSERT_BEFORE;
// // event.feedback = event.feedback | DND.FEEDBACK_SELECT |
// DND.FEEDBACK_INSERT_AFTER | DND.FEEDBACK_INSERT_BEFORE;
// }
//
// //EClass annotation = ModelPackage.eINSTANCE.getAnnotation();
// //if (annotation.isSuperTypeOf(eObject.eClass())) {
// //// originalOperation = DND.DROP_COPY;
// // event.detail = DND.DROP_COPY;
// //}