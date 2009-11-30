package org.unicase.emfstore.fixes;

import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.eclipse.emf.common.util.BasicEList;
import org.eclipse.emf.common.util.EList;
import org.unicase.emfstore.connection.rmi.SerializationUtil;
import org.unicase.emfstore.esmodel.versioning.Version;
import org.unicase.emfstore.esmodel.versioning.operations.AbstractOperation;
import org.unicase.emfstore.esmodel.versioning.operations.MultiReferenceMoveOperation;
import org.unicase.emfstore.esmodel.versioning.operations.MultiReferenceOperation;
import org.unicase.emfstore.esmodel.versioning.operations.SingleReferenceOperation;
import org.unicase.emfstore.exceptions.RMISerializationException;
import org.unicase.model.ModelElement;
import org.unicase.model.ModelElementId;
import org.unicase.model.Project;
import org.unicase.model.rationale.Comment;
import org.unicase.model.rationale.RationalePackage;

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
			List<AbstractOperation> deleteList = new ArrayList<AbstractOperation>();
			for (AbstractOperation operation : version.getChanges().getOperations()) {
				if (isComment(state, operation.getModelElementId())) {
					deleteList.add(operation);
				} else if (operation instanceof SingleReferenceOperation) {
					if (isComment(state, ((SingleReferenceOperation) operation).getNewValue())) {
						((SingleReferenceOperation) operation).setNewValue(null);
						deleteList.add(operation);
					} else if (isComment(state, ((SingleReferenceOperation) operation).getOldValue())) {
						((SingleReferenceOperation) operation).setOldValue(null);
						deleteList.add(operation);
					}
				} else if (operation instanceof MultiReferenceMoveOperation) {
					if (isComment(state, ((MultiReferenceMoveOperation) operation).getReferencedModelElementId())) {
						deleteList.add(operation);
					}
				} else if (operation instanceof MultiReferenceOperation) {
					List<ModelElementId> meIds = new ArrayList<ModelElementId>();
					for (ModelElementId meId : ((MultiReferenceOperation) operation).getReferencedModelElements()) {
						if (isComment(state, meId)) {
							meIds.add(meId);
						}
					}
					for (ModelElementId meId : meIds) {
						((MultiReferenceOperation) operation).getReferencedModelElements().remove(meId);
					}
				}
			}

			for (AbstractOperation delete : deleteList) {
				version.getChanges().getOperations().remove(delete);
			}
			save(version.getChanges());
		}
		Project project = version.getProjectState();
		if (project != null) {
			EList<Comment> comments = project.getAllModelElementsbyClass(RationalePackage.eINSTANCE.getComment(),
				new BasicEList<Comment>());
			for (Comment comment : comments) {
				try {
					printToFile(version, SerializationUtil.eObjectToString(comment));
				} catch (RMISerializationException e1) {
					e1.printStackTrace();
				}
				if (comment.getProject() == null) {
					System.out.println("no project for comment in version: " + version(version));
				}
				try {
					project.deleteModelElement(comment);
				} catch (IllegalArgumentException e) {
					e.printStackTrace();
				}
			}
			save(project);
		}
	}

	private boolean isComment(Project state, ModelElementId meId) {
		ModelElement modelElement = state.getModelElement(meId);
		return modelElement instanceof Comment;
	}

	@Override
	public boolean output() {
		return false;
	}

	@Override
	String getFixName() {
		return "Find comments";
	}

	private void printToFile(Version version, String result) {
		try {
			FileWriter fileWriter = new FileWriter(System.getProperty("user.home") + "/Desktop/comments/"
				+ projectHistory.getProjectId().getId() + ".txt", true);
			fileWriter.write("version: " + version(version) + System.getProperty("line.separator")
				+ System.getProperty("line.separator") + result + System.getProperty("line.separator"));
			fileWriter.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
