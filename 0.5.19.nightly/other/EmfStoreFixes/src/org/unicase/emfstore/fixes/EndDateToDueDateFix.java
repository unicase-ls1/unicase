package org.unicase.emfstore.fixes;

import org.unicase.emfstore.esmodel.versioning.Version;
import org.unicase.emfstore.esmodel.versioning.operations.AbstractOperation;
import org.unicase.emfstore.esmodel.versioning.operations.AttributeOperation;

public class EndDateToDueDateFix extends AbstractFix {

	@Override
	void fix() {
		for (Version version : projectHistory.getVersions()) {
			if (version.getChanges() == null) {
				System.out.println("No changes in version " + version.getPrimarySpec().getIdentifier());
				continue;
			}
			for (AbstractOperation operation : version.getChanges().getOperations()) {
				if (operation instanceof AttributeOperation) {
					AttributeOperation attributeOperation = (AttributeOperation) operation;
					if (attributeOperation.getFeatureName().equals("endDate")) {
						System.out.println("fixing " + attributeOperation.getName() + " in version "
							+ version.getPrimarySpec().getIdentifier() + "endDate -> dueDate");
						attributeOperation.setFeatureName("dueDate");
					}
				}
			}
			save(version);
		}

	}

	@Override
	String getFixName() {
		return "EndDate to DueDate fix";
	}
}
