/**
 * <copyright> Copyright (c) 2008 Jonas Helming, Maximilian Koegel. All rights reserved. This program and the accompanying materials are made available under the terms of the Eclipse Public License v1.0 which accompanies this distribution, and is available at http://www.eclipse.org/legal/epl-v10.html
 * </copyright>
 *
 * $Id$
 */

package org.unicase.ui.common.dnd;

import java.util.Arrays;
import java.util.List;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.edit.domain.EditingDomain;
import org.eclipse.emf.transaction.RecordingCommand;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.gmf.runtime.emf.type.core.ClientContextManager;
import org.eclipse.gmf.runtime.emf.type.core.ElementTypeRegistry;
import org.eclipse.gmf.runtime.emf.type.core.IClientContext;
import org.eclipse.gmf.runtime.emf.type.core.IElementType;
import org.eclipse.jface.viewers.Viewer;
import org.eclipse.jface.wizard.WizardDialog;
import org.eclipse.swt.dnd.DND;
import org.eclipse.swt.dnd.DropTargetAdapter;
import org.eclipse.swt.dnd.DropTargetEvent;
import org.eclipse.swt.graphics.Point;
import org.eclipse.swt.graphics.Rectangle;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.TreeItem;
import org.unicase.model.Annotation;
import org.unicase.model.ModelElement;
import org.unicase.model.ModelPackage;
import org.unicase.model.Project;
import org.unicase.model.diagram.DiagramType;
import org.unicase.model.diagram.MEDiagram;
import org.unicase.model.document.CompositeSection;
import org.unicase.model.document.DocumentPackage;
import org.unicase.model.document.LeafSection;
import org.unicase.model.document.Section;
import org.unicase.model.meeting.Meeting;
import org.unicase.model.meeting.WorkItemMeetingSection;
import org.unicase.model.task.ActionItem;
import org.unicase.model.task.TaskFactory;
import org.unicase.model.task.WorkItem;
import org.unicase.model.task.WorkPackage;
import org.unicase.ui.common.commands.ActionHelper;
import org.unicase.ui.common.util.UnicaseUiUtil;
import org.unicase.ui.common.wizards.WorkPackageReviewWizard;
import org.unicase.workspace.ProjectSpace;
import org.unicase.workspace.Usersession;
import org.unicase.workspace.WorkspaceManager;

/**
 * Drop adaptor for viewers. Currently drag and drop for more than one element
 * is not supported.
 * 
 * @author Hodaie
 * 
 */

public class UCDropAdapter extends DropTargetAdapter {

	private EditingDomain domain;
	private Viewer viewer;

	/**
	 * Actually I should be able to get event feedback from event.feedback But
	 * the problem is, the event feedback is correctly set in helper() method,
	 * but in drop() method it is set to 1 (only selection). That's why I save
	 * event feedback at the end of helper() in a variable, and check this
	 * variable in drop() instead of event.feedback
	 */
	private int eventFeedback;

	/**
	 * 
	 * 
	 * Constructor.
	 * 
	 * @param domain
	 *            the EdtingDomain
	 * @param viewer
	 *            the Viewer
	 */
	public UCDropAdapter(EditingDomain domain, Viewer viewer) {
		// super(domain, viewer);
		super();
		this.domain = domain;
		this.viewer = viewer;
	}

	/**
	 * {@inheritDoc}
	 */
	@SuppressWarnings("unchecked")
	@Override
	public void drop(final DropTargetEvent event) {

		// check if drop target and drop source are available
		if (!canDrop(event)) {
			return;
		}

		final List<ModelElement> source = (List<ModelElement>) DragSourcePlaceHolder
				.getDragSource();
		ModelElement dropee = source.get(0);
		final ModelElement target = (ModelElement) event.item.getData();

		if (source.size() > 1) {
			throw new UnsupportedOperationException();
			// dropMany(source, target);
			// return;
		}

		if ((eventFeedback & DND.FEEDBACK_INSERT_AFTER) == DND.FEEDBACK_INSERT_AFTER) {
			dropAfter(target, source);
			return;
		} else if ((eventFeedback & DND.FEEDBACK_INSERT_BEFORE) == DND.FEEDBACK_INSERT_BEFORE) {
			dropBefore(target, source);
			return;
		}

		doSpecialDragCases(event, source, dropee, target);
	}

	private void doSpecialDragCases(final DropTargetEvent event,
			final List<ModelElement> source, ModelElement dropee,
			final ModelElement target) {
		if (target instanceof WorkPackage && !(dropee instanceof Annotation)) {
			// create an ActionItem for each dropee
			// add the AI to target
			dropMEOnWorkpackage(target, source);

		} else if (target instanceof WorkItemMeetingSection
				&& dropee instanceof WorkItem) {

			dropWorkItemOnMeetingSection((WorkItemMeetingSection) target,
					source);

		} else if (target instanceof Meeting && dropee instanceof WorkPackage){
			dropWorkPackageOnMeeting((Meeting) target, (WorkPackage) dropee);
		} else if ((dropee instanceof Annotation)
				&& !(target instanceof Section || target instanceof WorkPackage || target
						.eContainer() instanceof WorkPackage)) {
			// when an annotation is dropped on a model element, which is not a
			// Section, WorkPackage or contained in a WorkPackage.
			Annotation[] arr = source.toArray(new Annotation[source.size()]);
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
			final MEDiagram diagram = (MEDiagram) target;
			domain.getCommandStack().execute(
					new RecordingCommand((TransactionalEditingDomain) domain) {
						@Override
						protected void doExecute() {
							diagram.getElements().addAll(source);
						}
					});
			
			ActionHelper.openModelElement(diagram, this.getClass().getName());

		} else {
			domain.getCommandStack().execute(
					new RecordingCommand((TransactionalEditingDomain) domain) {
						@Override
						protected void doExecute() {
							dropContainment(event, target, source);
						}

					});

		}
	}

	private void dropWorkPackageOnMeeting(Meeting meeting, WorkPackage workPackage) {
		WorkPackageReviewWizard wizard = new WorkPackageReviewWizard();
		wizard.init(meeting, workPackage.getContainedWorkItems());
		WizardDialog dialog = new WizardDialog(Display.getCurrent().getActiveShell(), wizard);
		wizard.setWindowTitle("Workpackage review wizard.");
		dialog.create();
		dialog.open();
	}

	private void dropWorkItemOnMeetingSection(
			final WorkItemMeetingSection target, final List<ModelElement> source) {

		domain.getCommandStack().execute(
				new RecordingCommand((TransactionalEditingDomain) domain) {
					@Override
					protected void doExecute() {
						for (ModelElement me : source) {
							if (me instanceof WorkItem) {
								target.getIncludedWorkItems()
										.add((WorkItem) me);
							}
						}

					}
				});

	}

	/**
	 * When a ModelElement (which is not a WorkItem) is dropped on a
	 * WorkPackage, or one of WorkItems inside this WorkPackage, then an
	 * ActionItem relating the dropped ME is created and added to WorkPackage.
	 * 
	 * @param target
	 * @param source
	 */
	private void dropMEOnWorkpackage(final ModelElement target,
			final List<ModelElement> source) {

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
							((WorkPackage) target).getContainedWorkItems().add(
									ai);
						}
					}
				});
	}

	/**
	 * Drop containment.
	 * 
	 * @param event
	 * @param target
	 * @param source
	 */
	@SuppressWarnings("unchecked")
	private void dropContainment(DropTargetEvent event, ModelElement target,
			List<ModelElement> source) {

		EReference theRef = getSourceRefForThisTarget(target, source);
		if (theRef == null) {
			return;
		}

		Object object = target.eGet(theRef);
		EList<EObject> eList = (EList<EObject>) object;
		eList.addAll(source);

	}

	/**
	 * Returns the EReference in target, which corresponds to EClass of source.
	 * 
	 * @param target
	 *            target
	 * @param source
	 *            source
	 * @return the EReference of target
	 */
	private EReference getSourceRefForThisTarget(ModelElement target,
			List<ModelElement> source) {
		// EReference theRef = null;
		List<EReference> refs = target.eClass().getEAllReferences();
		for (EReference ref : refs) {
			if (!ref.isContainment()) {
				continue;
			}
			// checking for source reference type is based only on first element
			// of
			// drag source. We suppose that elements with different types are
			// not allowed to
			// be drag and dropped.
			if (ref.getEReferenceType().equals(source.get(0).eClass())
					|| ref.getEReferenceType().isSuperTypeOf(
							source.get(0).eClass())) {
				return ref;
			}
		}
		return null;
	}

	/**
	 * drop after.
	 * 
	 * @param target
	 * @param source
	 */
	private void dropAfter(final ModelElement target,
			final List<ModelElement> source) {

		ModelElement dropee = source.get(0);
		if (target.eContainer() instanceof WorkPackage
				&& !(dropee instanceof Annotation)) {
			dropMEOnWorkpackage((ModelElement) target.eContainer(), source);
			return;
		}

		domain.getCommandStack().execute(
				new RecordingCommand((TransactionalEditingDomain) domain) {

					@Override
					protected void doExecute() {
						doDropAfter(target, source);

					}

				});

	}

	/**
	 * drop before.
	 * 
	 * @param target
	 *            target
	 * @param source
	 *            souerce
	 */
	private void dropBefore(final ModelElement target,
			final List<ModelElement> source) {

		ModelElement dropee = source.get(0);
		if (target.eContainer() instanceof WorkPackage
				&& !(dropee instanceof Annotation)) {
			dropMEOnWorkpackage((ModelElement) target.eContainer(), source);
			return;
		}

		domain.getCommandStack().execute(
				new RecordingCommand((TransactionalEditingDomain) domain) {

					@Override
					protected void doExecute() {
						doDropBefore(target, source);

					}

				});

	}

	/**
	 * do drop after.
	 * 
	 * @param target
	 * @param source
	 */
	@SuppressWarnings("unchecked")
	private void doDropAfter(final ModelElement target,
			final List<ModelElement> source) {

		if(target instanceof CompositeSection && source.get(0) instanceof CompositeSection && target.eContainer() instanceof Project){
			moveFirstLevelCompSection(target, source, true);
		}
		
		int targetIndex = getTargetIndex(target, source);
		if (targetIndex == -1) {
			return;
		}

		EReference theRef = getTargetContainerRef(target, source);
		if (theRef == null) {
			return;
		}

		Object object = target.eContainer().eGet(theRef);
		EList<EObject> eList = (EList<EObject>) object;
		targetIndex = eList.indexOf(target);
		if (haveSameEContainer(target, source.get(0))) {
			// if we are moving some children within the same parent
			for (int i = source.size() - 1; i >= 0; i--) {
				eList.move(targetIndex, source.get(i));
			}

		} else {
			// if we are moving some children from another parent here.
			eList.addAll(targetIndex, source);
		}
	}

	

	/**
	 * do drop before.
	 * 
	 * @param target
	 *            target
	 * @param source
	 *            source
	 */
	@SuppressWarnings("unchecked")
	private void doDropBefore(final ModelElement target,
			final List<ModelElement> source) {
		
		if(target instanceof CompositeSection && source.get(0) instanceof CompositeSection && target.eContainer() instanceof Project){
			moveFirstLevelCompSection(target, source, false);
		}
		
		int targetIndex = getTargetIndex(target, source);
		if (targetIndex == -1) {
			return;
		}

		EReference theRef = getTargetContainerRef(target, source);
		if (theRef == null) {
			return;
		}

		Object object = target.eContainer().eGet(theRef);
		EList<EObject> eList = (EList<EObject>) object;
		targetIndex = eList.indexOf(target);
		if (targetIndex == 0) {
			if (haveSameEContainer(target, source.get(0))) {
				for (int i = source.size() - 1; i >= 0; i--) {
					eList.move(0, source.get(i));
				}

			} else {
				eList.addAll(0, source);
			}
		} else {
			if (haveSameEContainer(target, source.get(0))) {
				for (int i = source.size() - 1; i >= 0; i--) {
					eList.move(targetIndex, source.get(i));
				}

			} else {
				eList.addAll(targetIndex, source);
			}
		}
	}
	
	
	private void moveFirstLevelCompSection(ModelElement target,
			List<ModelElement> source, boolean after) {
		
		Project project = (Project)target.eContainer();
		EList<ModelElement> modelElements = project.getModelElements();
		int targetIndex = modelElements.indexOf(target);
		if(after){
			modelElements.addAll(targetIndex + 1, source);
		}else{
			modelElements.addAll(targetIndex, source);
			//modelElements.addAll(targetIndex == 0? 0 : targetIndex - 1, source);
			
		}
		
		viewer.refresh();
		
//		List<CompositeSection> firstLevelCompoSections = new ArrayList<CompositeSection>();
//		for(CompositeSection compSection : project.getAllModelElementsbyClass(DocumentPackage.eINSTANCE.getCompositeSection(), new BasicEList<CompositeSection>())){
//			if(compSection.eContainer() instanceof Project){
//				firstLevelCompoSections.add(compSection);
//			}
//		}
		
	}

	/**
	 * This returns the EReference of container of the target, matching type of
	 * source.
	 * 
	 * @param target
	 *            drop target
	 * @param source
	 *            drag source
	 * @return
	 */
	private EReference getTargetContainerRef(ModelElement target,
			List<ModelElement> source) {

		EObject container = target.eContainer();
		// EReference theRef = null;
		List<EReference> refs = container.eClass().getEAllReferences();
		for (EReference ref : refs) {
			if (!ref.isContainment()) {
				continue;
			}
			// checking for source reference type is based only on first element
			// of
			// drag source. We suppose that elements with different types are
			// not allowed to
			// be drag and dropped.
			if (ref.getEReferenceType().equals(source.get(0).eClass())
					|| ref.getEReferenceType().isSuperTypeOf(
							source.get(0).eClass())) {
				return ref;
			}
		}
		return null;

	}

	/**
	 * 
	 * This returns the position of a drop target within its container.
	 * 
	 * @param target
	 *            drop target
	 * @param source
	 *            drag source
	 * @return
	 */
	@SuppressWarnings("unchecked")
	private int getTargetIndex(ModelElement target, List<ModelElement> source) {
		int targetIndex = -1;
		EObject container = target.eContainer();
		EReference theRef = null;
		List<EReference> refs = container.eClass().getEAllContainments();

		for (EReference ref : refs) {
			if (ref.getEReferenceType().equals(source.get(0).eClass())
					|| ref.getEReferenceType().isSuperTypeOf(
							source.get(0).eClass())) {
				theRef = ref;
				break;
			}
		}

		if (theRef == null) {
			return -1;
		}

		Object object = container.eGet(theRef);
		EList<EObject> eList = (EList<EObject>) object;
		targetIndex = eList.indexOf(target);
		return targetIndex;
	}

	/**
	 * Currently not supported.
	 * 
	 * @param source
	 *            drag source
	 * @param target
	 *            drop target
	 */
	@SuppressWarnings("unused")
	private void dropMany(final List<ModelElement> source,
			final ModelElement target) {

		ModelElement dropee = source.get(0);
		final List<EReference> targetReferences = target.eClass()
				.getEAllReferences();
		boolean hasThisReference = false;
		EReference tmpReference = null;
		for (EReference ref : targetReferences) {
			if (ref.getEReferenceType().equals(dropee.eClass())
					&& ref.isContainment()) {
				hasThisReference = true;
				tmpReference = ref;
				break;
			}
		}

		if (!hasThisReference) {
			return;
		}

		final EReference thisReference = tmpReference;
		domain.getCommandStack().execute(
				new RecordingCommand((TransactionalEditingDomain) domain) {
					@SuppressWarnings("unchecked")
					@Override
					protected void doExecute() {
						Object object = target.eGet(thisReference);
						EList<EObject> eList = (EList<EObject>) object;
						eList.addAll(source);
					}
				});
	}

	/**
	 * 
	 * 
	 * @param diagram
	 * @param dropee
	 * @return
	 */
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
	@SuppressWarnings("unchecked")
	protected void helper(DropTargetEvent event) {

		event.detail = DND.DROP_COPY;
		setInitialEventFeedback(event);

		// check if we have a drop target and drop source
		if (!canDrop(event)) {
			event.detail = DND.DROP_NONE;
			return;
		}

		// extract drop target and drop source
		ModelElement target = (ModelElement) event.item.getData();
		List<ModelElement> source = (List<ModelElement>) DragSourcePlaceHolder
				.getDragSource();
		ModelElement dropee = source.get(0);

		// check if a drop can occur for this target and source
		if (!canDrop(event, source, target, dropee)) {
			return;
		}

		// check if target has any containment matching source
		if (!hasThisContainmentReference(target, dropee.eClass())) {
			event.detail = DND.DROP_NONE;
		}

		// you can drop an annotation on any ME
		EClass annotation = ModelPackage.eINSTANCE.getAnnotation();
		if (annotation.isSuperTypeOf(dropee.eClass())) {
			event.detail = event.detail | DND.DROP_COPY;
		}

		// I don't know much about diagrams
		if (target instanceof MEDiagram) {
			if (!isElementOfDiagram((MEDiagram) target, dropee)
					|| ((MEDiagram) target).getElements().contains(dropee)) {
				event.detail = DND.DROP_NONE;
			} else {
				event.detail = event.detail | DND.DROP_COPY;
			}
		}

		// On a WorkPackage you can drop anything. If the dropee is not a
		// WorkItem, a WorkItem will be created for it and added to WorkPackage.
		if (target instanceof WorkPackage) {
			event.detail = event.detail | DND.DROP_COPY;
		}

		// see comment of eventFeedback field
		eventFeedback = event.feedback;

	}

	/**
	 * This checks if drag and drop is allowed.
	 * 
	 * @param event
	 * @param source
	 * @param target
	 * @param dropee
	 * @return
	 */
	private boolean canDrop(DropTargetEvent event, List<ModelElement> source,
			ModelElement target, ModelElement dropee) {

		// a container is not allowed to contain the same element twice
		if (target.eContents().contains(dropee)) {
			if (!((event.feedback & DND.FEEDBACK_INSERT_AFTER) == DND.FEEDBACK_INSERT_AFTER || (event.feedback & DND.FEEDBACK_INSERT_BEFORE) == DND.FEEDBACK_INSERT_BEFORE)) {
				event.detail = DND.DROP_NONE;
				return false;
			}

		}

		// do not drop an element on itself
		if (target == dropee) {
			event.detail = DND.DROP_NONE;
			return false;
		}

		// a composite section should only contain sections
		// do not drop anything else on it
		if (target instanceof CompositeSection) {
			if (!(dropee instanceof Section)) {
				event.detail = DND.DROP_NONE;
				return false;
			}

		}

		// check if the collection of selected elements to be dropped come
		// all from the same level
		if (!haveSameEContainer(source)) {
			event.detail = DND.DROP_NONE;
			return false;
		}

		// do not drop an element on one of its children. this leads to circular
		// reference
		// in containment hierarchy and the element and all of its children get
		// lost
		// (this creates an island)
		if (EcoreUtil.isAncestor(dropee, target)) {
			event.detail = DND.DROP_NONE;
			return false;
		}

		ProjectSpace projectSpace = WorkspaceManager.getProjectSpace(target);
		Usersession userSession = projectSpace.getUsersession();
		if (dropee instanceof Section
				&& !UnicaseUiUtil.isProjectAdmin(userSession, projectSpace)) {
			event.detail = DND.DROP_NONE;
			return false;
		}

		return true;
	}

	/**
	 * Returns if target has a containment of type refType.
	 * 
	 * @param target
	 *            target
	 * @param refType
	 *            reference type to check for its existence in target
	 * @return if target has such a reference type
	 */
	private boolean hasThisContainmentReference(ModelElement target,
			EClass refType) {

		// I think a better (faster) implementation could use a map. <<target,
		// refType>, boolean>

		boolean result = false;
		List<EReference> targetReferences = null;

		if ((eventFeedback & DND.FEEDBACK_INSERT_AFTER) == DND.FEEDBACK_INSERT_AFTER
				|| (eventFeedback & DND.FEEDBACK_INSERT_BEFORE) == DND.FEEDBACK_INSERT_BEFORE) {
			targetReferences = target.eContainer().eClass().getEAllReferences();
		} else {
			targetReferences = target.eClass().getEAllReferences();
		}

		for (EReference ref : targetReferences) {

			if (ref.isContainment()
					&& (ref.getEReferenceType().equals(refType) || ref
							.getEReferenceType().isSuperTypeOf(refType))) {

				// consider LeafSection.modelElements() reference
				// A Composite- or LeafSection is not allowed to be dropped on a
				// LeafSection.
				if (target instanceof LeafSection
						&& DocumentPackage.eINSTANCE.getSection()
								.isSuperTypeOf(refType)) {
					continue;
				}
				result = true;
				break;
			}
		}

		if ((eventFeedback & DND.FEEDBACK_INSERT_AFTER) == DND.FEEDBACK_INSERT_AFTER
				|| (eventFeedback & DND.FEEDBACK_INSERT_BEFORE) == DND.FEEDBACK_INSERT_BEFORE) {
			// Trying to move a WorkItem inside its own WorkPackage
			if (target.eContainer() instanceof WorkPackage) {
				result = true;
			}
			// to move LeafSections inside a CompositeSection
			if (target.eContainer() instanceof CompositeSection) {
				result = true;
				if (!(refType instanceof Section)) {
					result = false;
				}
			}

		}

		return result;
	}

	/**
	 * This checks drop target and drop source to be not Null.
	 * 
	 * @param event
	 *            DropTargetEvent
	 * @return
	 */
	@SuppressWarnings("unchecked")
	private boolean canDrop(DropTargetEvent event) {
		boolean result = true;
		final List<ModelElement> source = (List<ModelElement>) DragSourcePlaceHolder
				.getDragSource();
		if (source == null) {
			result = false;
		}

		// take care that you cannot drop anything on project (project is not a
		// ModelElement)
		if (event.item == null || event.item.getData() == null
				|| !(event.item.getData() instanceof ModelElement)) {
			result = false;
		}

		// check if source and target are in the same project
		ModelElement dropee = source.get(0);
		if (event.item != null && event.item.getData() != null && event.item.getData() instanceof ModelElement) {
			ModelElement target = (ModelElement) event.item.getData();
			if (!target.getProject().equals(dropee.getProject())) {
				result = false;
			}
		}

		return result;
	}

	/**
	 * This sets the initial event feedback, and is also responsible for showing
	 * INSERT_AFTER and INSERT_BEFORE feedbacks according to mouse cursor
	 * position.
	 * 
	 * @param event
	 */
	private void setInitialEventFeedback(DropTargetEvent event) {
		event.feedback = DND.FEEDBACK_SELECT;

		if (event.item != null) {
			Rectangle rect = ((TreeItem) event.item).getBounds();
			Point pt = viewer.getControl().toControl(event.x, event.y);
			if (pt.y < rect.y + 5) {
				event.feedback = DND.FEEDBACK_INSERT_BEFORE;
			}
			if (pt.y > rect.y + rect.height - 5) {
				event.feedback = DND.FEEDBACK_INSERT_AFTER;
			}

		}
		event.feedback |= DND.FEEDBACK_SCROLL | DND.FEEDBACK_EXPAND;
	}

	/**
	 * @param event
	 *            event
	 */
	@Override
	public void dragOver(DropTargetEvent event) {

		helper(event);

	}

	/**
	 * This checks if all elements is drag source collection come from the same
	 * container (level in tree).
	 * 
	 * @param source
	 * @return
	 */
	private boolean haveSameEContainer(List<ModelElement> source) {
		ModelElement first = source.get(0);
		for (ModelElement me : source) {
			if (!first.eContainer().equals(me.eContainer())) {
				return false;
			}
		}
		return true;
	}

	/**
	 * 
	 * @param target
	 *            target
	 * @param dropee
	 *            dropee
	 * @return boolean
	 */
	protected boolean haveSameEContainer(ModelElement target,
			ModelElement dropee) {

		return target.eContainer().equals(dropee.eContainer());
	}

}
