package org.unicase.ui.common.dnd.dropadapters;

import java.util.List;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.transaction.RecordingCommand;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.swt.dnd.DND;
import org.eclipse.swt.dnd.DropTargetEvent;
import org.unicase.model.ModelElement;
import org.unicase.model.document.Section;
import org.unicase.ui.common.util.UnicaseUiUtil;
import org.unicase.workspace.ProjectSpace;
import org.unicase.workspace.Usersession;
import org.unicase.workspace.WorkspaceManager;

/**
 * This is the super class for all model element specific drop adapters. We can
 * consider this class as if ModelElement was drop target.
 * 
 * @author Hodaie
 * 
 */
public class MEDropAdapter  {

	private TransactionalEditingDomain domain;

	/**
	 * Constructor.
	 * 
	 * @param domain TransactionalEditingDomain
	 */
	public MEDropAdapter(TransactionalEditingDomain domain) {
		this.domain = domain;
	}

	/**
	 * {@inheritDoc}
	 * @param source 
	 * @param target 
	 */

	public void drop(final DropTargetEvent event, final ModelElement target, final List<ModelElement> source) {
		getEditingDomain().getCommandStack().execute(new RecordingCommand(getEditingDomain()){

			@Override
			protected void doExecute() {
				
				dropContainment(event, target, source);
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
	 * This checks if this source can be dropped on this target (taking also the
	 * drop effect into consideration). The most general case is if the target
	 * has the appropriate containment reference for source. Also if all
	 * elements in drop source come from the same level in tree (have the same
	 * container). These cases are handled here. Sub-Classes can override this
	 * method, to implement their own conditions.
	 * 
	 * @param event
	 *            drop target event
	 * @param source
	 *            source collection
	 * @param target
	 *            target model element
	 * @param dropee
	 *            first element of source
	 * @return if this source can be dropped on target
	 */
	public boolean canDrop(DropTargetEvent event, List<ModelElement> source,
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
		
		if (!haveSameEContainer(source)) {
			return false;
		}
		
		if ((event.feedback & DND.FEEDBACK_INSERT_AFTER) == DND.FEEDBACK_INSERT_AFTER
				|| (event.feedback & DND.FEEDBACK_INSERT_BEFORE) == DND.FEEDBACK_INSERT_BEFORE) {
			if (!hasThisContainmentReference(target.eContainer(), dropee
					.eClass())) {
				return false;
			}

		} else if (!hasThisContainmentReference(target, dropee.eClass())) {
			return false;
		}

		
		return true;
	}

	/**
	 * This checks if all elements is drag source collection come from the same
	 * container (level in tree).
	 * 
	 * @param source
	 *            source
	 * @return true or false
	 */
	protected boolean haveSameEContainer(List<ModelElement> source) {
		ModelElement first = source.get(0);
		for (ModelElement me : source) {
			if (!first.eContainer().equals(me.eContainer())) {
				return false;
			}
		}
		return true;
	}

	/**
	 * This checks if target has appropriate containment reference for source.
	 * Sub-Classes should override this.
	 * 
	 * @param target
	 *            target
	 * @param refType
	 *            refType
	 * @return true or false
	 */
	protected boolean hasThisContainmentReference(EObject target,
			EClass refType) {

		boolean result = false;

		for (EReference ref : target.eClass().getEAllContainments()) {

			if (!ref.isContainer()
					&& (ref.getEReferenceType().equals(refType) || ref
							.getEReferenceType().isSuperTypeOf(refType))) {

				result = true;
				break;
			}
		}

		return result;
	}

	
	
	/**
	 * This returns the TransactionalEditingDomain.
	 * @return TransactionalEditingDomain
	 */
	public TransactionalEditingDomain getEditingDomain() {
		return domain;
	}

}
