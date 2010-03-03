package org.unicase.ui.unicasecommon.dnd.dropadapters;

import java.util.Arrays;
import java.util.List;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.swt.dnd.DND;
import org.eclipse.swt.dnd.DropTargetEvent;
import org.unicase.metamodel.MetamodelPackage;
import org.unicase.metamodel.ModelElement;
import org.unicase.model.Annotation;
import org.unicase.model.UnicaseModelElement;
import org.unicase.model.document.Section;
import org.unicase.ui.common.dnd.MEDropAdapter;
import org.unicase.ui.common.util.UiUtil;
import org.unicase.workspace.ProjectSpace;
import org.unicase.workspace.Usersession;
import org.unicase.workspace.WorkspaceManager;

public class UCDropAdapter extends MEDropAdapter {

	@Override
	public void drop(DropTargetEvent event, ModelElement target, List<ModelElement> source) {
		if (source.get(0) instanceof Annotation && target instanceof UnicaseModelElement) {
			annotateME(source, (UnicaseModelElement) target);
		} else {
			super.drop(event, target, source);
		}
	}

	private void annotateME(List<ModelElement> source, final UnicaseModelElement target) {
		Annotation[] arr = source.toArray(new Annotation[source.size()]);
		List<Annotation> newAnnotations = Arrays.asList(arr);
		target.getAnnotations().addAll(newAnnotations);
	}

	@Override
	public boolean canDrop(int eventFeedback, DropTargetEvent event, List<ModelElement> source, ModelElement target,
		ModelElement dropee) {
		ProjectSpace projectSpace = WorkspaceManager.getProjectSpace(target);
		Usersession userSession = projectSpace.getUsersession();
		if (dropee instanceof Section && !UiUtil.isProjectAdmin(userSession, projectSpace)) {
			event.detail = DND.DROP_NONE;
			return false;
		}

		if ((eventFeedback & DND.FEEDBACK_INSERT_AFTER) == DND.FEEDBACK_INSERT_AFTER
			|| (eventFeedback & DND.FEEDBACK_INSERT_BEFORE) == DND.FEEDBACK_INSERT_BEFORE) {
			if (!hasThisContainmentReference(target.eContainer(), dropee.eClass())) {
				return false;
			}
		} else if (!(dropee instanceof Annotation) && !hasThisContainmentReference(target, dropee.eClass())) {
			return false;
		}
		return super.canDrop(eventFeedback, event, source, target, dropee);
	}

	@Override
	public EClass isDropAdapterfor() {
		return MetamodelPackage.eINSTANCE.getModelElement();
	}

}
