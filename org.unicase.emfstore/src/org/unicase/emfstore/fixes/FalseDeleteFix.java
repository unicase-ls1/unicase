package org.unicase.emfstore.fixes;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

import org.unicase.emfstore.esmodel.versioning.Version;
import org.unicase.emfstore.esmodel.versioning.operations.AbstractOperation;
import org.unicase.emfstore.esmodel.versioning.operations.CreateDeleteOperation;
import org.unicase.model.Project;

public class FalseDeleteFix extends AbstractFix {

	@Override
	void fix() {
		HashSet<String> deletedMEs = new HashSet<String>();
		for (Version version : projectHistory.getVersions()) {
			if (version.getChanges() == null) {
				System.out.println("No changes in version " + version.getPrimarySpec().getIdentifier());
				continue;
			}
			List<AbstractOperation> deleteList = new ArrayList<AbstractOperation>();
			for (AbstractOperation operation : version.getChanges().getOperations()) {
				if (operation instanceof CreateDeleteOperation) {
					CreateDeleteOperation deleteOperation = (CreateDeleteOperation) operation;
					if (deleteOperation.isDelete()) {
						if (!deletedMEs.add(deleteOperation.getModelElementId().getId())) {
							System.out.println("False delete (id: " + deleteOperation.getModelElementId().getId()
								+ ") in version " + version.getPrimarySpec().getIdentifier());
							deleteList.add(deleteOperation);
						}
					}
				}
			}
			for (AbstractOperation ao : deleteList) {
				version.getChanges().getOperations().remove(ao);
			}
			save(version);
		}
	}

	private Project getNextProject(Version version) {
		Version result = null;
		for (Version ver : super.getVersionsWithProjectState()) {
			if (ver.getPreviousVersion().getPrimarySpec().getIdentifier() > version.getPrimarySpec().getIdentifier()) {
				result = ver;
				break;
			}
		}
		return result.getProjectState();
	}

	@Override
	String getFixName() {
		return "False delete fix";
	}

}
