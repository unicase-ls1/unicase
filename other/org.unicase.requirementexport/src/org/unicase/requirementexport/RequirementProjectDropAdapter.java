package org.unicase.requirementexport;

import java.util.List;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.edit.ui.dnd.LocalTransfer;
import org.eclipse.swt.dnd.DND;
import org.eclipse.swt.dnd.DropTargetAdapter;
import org.eclipse.swt.dnd.DropTargetEvent;
import org.eclipse.swt.dnd.Transfer;
import org.unicase.metamodel.Project;
import org.unicase.model.requirement.FunctionalRequirement;
import org.unicase.model.requirement.NonFunctionalRequirement;
import org.unicase.ui.common.dnd.DragSourcePlaceHolder;
import org.unicase.ui.navigator.TreeView;
import org.unicase.workspace.ProjectSpace;
import org.unicase.workspace.WorkspacePackage;

/**
 * Drop adapter for {@link RequirementExportOperation}.<br>
 * Current state: NOT WORKING!
 * 
 * @author mharut
 */
public class RequirementProjectDropAdapter extends DropTargetAdapter {

	private List<EObject> source;
	private EObject target;
	private EObject dropee;

	public void drop() {
		if (target == null || dropee == null) {
			return;
		}
		Project project = ((ProjectSpace) target).getProject();
		for (EObject dropee : source) {
			if (dropee instanceof FunctionalRequirement) {
				new RequirementExportOperation().copyFunctionalRequirement((FunctionalRequirement) dropee, project);
			} else if (dropee instanceof NonFunctionalRequirement) {
				new RequirementExportOperation().copyNonFunctionalRequirement((NonFunctionalRequirement) dropee,
					project);
			}
		}
	}

	public boolean canDrop() {
		if (target == null || dropee == null) {
			return false;
		}
		if ((dropee instanceof FunctionalRequirement || dropee instanceof NonFunctionalRequirement)
			&& target instanceof ProjectSpace) {
			return true;
		}
		return false;
	}

	public EClass isDropAdapterfor() {
		return WorkspacePackage.eINSTANCE.getProjectSpace();
	}

	private void addToView() {
		// FIXME This doesn't work, as there is already a drop adapter registered!
		// TODO Move to a better location, this is just here so it doesn't get lost
		int dndOperations = DND.DROP_COPY | DND.DROP_MOVE | DND.DROP_LINK;
		Transfer[] transfers = new Transfer[] { LocalTransfer.getInstance() };
		TreeView.getTreeViewer().addDropSupport(dndOperations, transfers, new RequirementProjectDropAdapter());
	}

	@Override
	public void dragOver(DropTargetEvent event) {

		event.detail = DND.DROP_COPY;

		if (extractDnDSourceAndTarget(event)) {
			event.detail = DND.DROP_NONE;
			return;
		}

		if (canDrop()) {
			event.detail = DND.Drop;
		} else {
			event.detail = DND.DROP_COPY;
		}

	}

	@SuppressWarnings("unchecked")
	private boolean extractDnDSourceAndTarget(DropTargetEvent event) {

		List<Object> tempSource = (List<Object>) DragSourcePlaceHolder.getDragSource();
		if (tempSource == null) {
			return false;
		}

		for (Object obj : tempSource) {
			if (!(obj instanceof EObject)) {
				return false;
			}
		}

		source = (List<EObject>) DragSourcePlaceHolder.getDragSource();

		dropee = source.get(0);

		if (event.item == null || event.item.getData() == null || !(event.item.getData() instanceof EObject)) {
			return false;
		}

		dropee = (EObject) event.item.getData();

		return true;
	}

}
