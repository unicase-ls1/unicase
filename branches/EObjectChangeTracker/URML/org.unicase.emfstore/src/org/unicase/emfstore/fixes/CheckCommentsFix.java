package org.unicase.emfstore.fixes;

import org.unicase.emfstore.esmodel.versioning.Version;
import org.unicase.emfstore.esmodel.versioning.operations.AbstractOperation;
import org.unicase.model.ModelElement;
import org.unicase.model.Project;
import org.unicase.model.rationale.Comment;

public class CheckCommentsFix extends CheckChanges {

	@Override
	public void callHook(Version version, Project state) {
		// if (version.getProjectState() != null) {
		// EList<Comment> comments = version.getProjectState().getAllModelElementsbyClass(
		// RationalePackage.eINSTANCE.getComment(), new BasicEList<Comment>());
		// int i = 0;
		// for (Comment comment : comments) {
		// i++;
		// }
		// System.out.println("version :" + version(version) + " projectstate " + i);
		// }
		if (version.getChanges() != null) {
			int j = 0;
			for (AbstractOperation operation : version.getChanges().getOperations()) {
				ModelElement modelElement = state.getModelElement(operation.getModelElementId());
				if (modelElement instanceof Comment) {
					j++;
				}
			}
			if (j > 0) {
				System.out.println("version :" + version(version) + " changepackage " + j);
			}
		}
	}

	@Override
	public boolean output() {
		return false;
	}

	@Override
	String getFixName() {
		return "Find comments";
	}

}
