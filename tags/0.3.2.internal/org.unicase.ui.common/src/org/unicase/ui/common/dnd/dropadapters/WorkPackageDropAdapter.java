package org.unicase.ui.common.dnd.dropadapters;

import java.util.List;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.jface.viewers.StructuredViewer;
import org.eclipse.swt.dnd.DropTargetEvent;
import org.eclipse.ui.PlatformUI;
import org.unicase.model.Annotation;
import org.unicase.model.ModelElement;
import org.unicase.model.task.ActionItem;
import org.unicase.model.task.TaskFactory;
import org.unicase.model.task.WorkItem;
import org.unicase.model.task.WorkPackage;
import org.unicase.ui.common.commands.ActionHelper;

/**
 * This is the drop adapter for WorkPackages.
 * 
 * @author Hodaie
 */
public class WorkPackageDropAdapter extends MEDropAdapter {

	/**
	 * Constructor.
	 * 
	 * @param domain TransactionalEditingDomain
	 * @param viewer viewer
	 */
	public WorkPackageDropAdapter(TransactionalEditingDomain domain, StructuredViewer viewer) {
		super(domain, viewer);

	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void drop(DropTargetEvent event, ModelElement target, List<ModelElement> source) {

		ModelElement dropee = source.get(0);
		if (dropee instanceof WorkItem) {
			for (ModelElement me : source) {
				if (me instanceof WorkItem) {
					((WorkPackage) target).getContainedWorkItems().add((WorkItem) me);
				}
			}

		} else {
			dropMEOnWorkpackage(target, source);
		}

	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.unicase.ui.common.dnd.dropadapters.MEDropAdapter#dropMove(org.eclipse.emf.ecore.EObject,
	 *      org.unicase.model.ModelElement, java.util.List, boolean)
	 */
	@Override
	public void dropMove(EObject targetContainer, ModelElement target, List<ModelElement> source, boolean after) {
		ModelElement dropee = source.get(0);
		if (dropee instanceof Annotation) {
			super.dropMove(targetContainer, target, source, after);
		} else {
			dropMEOnWorkpackage((ModelElement) targetContainer, source);
		}

	}

	/**
	 * When a ModelElement (which is not a WorkItem) is dropped on a WorkPackage, or one of WorkItems inside this
	 * WorkPackage, then an ActionItem relating the dropped ME is created and added to WorkPackage.
	 * 
	 * @param target
	 * @param source
	 */
	private void dropMEOnWorkpackage(final ModelElement target, final List<ModelElement> source) {

		String viewId = PlatformUI.getWorkbench().getActiveWorkbenchWindow().getActivePage().getActivePart().getSite()
			.getId();
		for (ModelElement me : source) {
			ActionItem ai = TaskFactory.eINSTANCE.createActionItem();
			ai.setName("New Action Item relating " + me.getName());
			ai.getAnnotatedModelElements().add(me);
			((WorkPackage) target).getContainedWorkItems().add(ai);
			ActionHelper.openModelElement(ai, viewId);
		}
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.unicase.ui.common.dnd.dropadapters.MEDropAdapter#canDrop(int, org.eclipse.swt.dnd.DropTargetEvent,
	 *      java.util.List, org.unicase.model.ModelElement, org.unicase.model.ModelElement)
	 */
	@Override
	public boolean canDrop(int eventFeedback, DropTargetEvent event, List<ModelElement> source, ModelElement target,
		ModelElement dropee) {

		return super.canDrop(eventFeedback, event, source, target, dropee);
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.unicase.ui.common.dnd.dropadapters.MEDropAdapter#hasThisContainmentReference(org.eclipse.emf.ecore.EObject,
	 *      org.eclipse.emf.ecore.EClass)
	 */
	@Override
	protected boolean hasThisContainmentReference(EObject target, EClass refType) {
		return true;
	}

}
