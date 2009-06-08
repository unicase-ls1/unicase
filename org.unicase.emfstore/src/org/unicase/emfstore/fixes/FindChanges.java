package org.unicase.emfstore.fixes;

import java.io.FileWriter;
import java.io.IOException;

import org.unicase.emfstore.esmodel.versioning.Version;
import org.unicase.emfstore.esmodel.versioning.operations.AbstractOperation;

public class FindChanges extends AbstractFix {

	@Override
	void fix() {
		for (Version version : projectHistory.getVersions()) {
			if (version.getChanges() != null) {
				for (AbstractOperation ao : version.getChanges().getOperations()) {
					String result = serializeOperation(ao);

					// if (between(version, 450, 500)) {
					// System.out.println("checking version: " + version.getPrimarySpec().getIdentifier());
					// if (ao instanceof CreateDeleteOperation && ((CreateDeleteOperation) ao).isDelete() == true) {
					// ModelElement modelElement = projectHistory.getVersions().get(450).getProjectState()
					// .getModelElement(ao.getModelElementId());
					// if (modelElement != null) {
					// for (ModelElement containedME : modelElement.getAllContainedModelElements()) {
					// if (containedME.getIdentifier().equals("_6WUNgMrdEd2FLcQLgl5R9Q")) {
					// printToFile(version, result);
					// }
					// }
					// }
					// }
					// }

					if (/* between(version, 500, 550) && */result.contains("_gfwuIB3-Ed6apaYdF8CI-A")) {
						printToFile(version, result);
					}
					// if (ao instanceof CreateDeleteOperation) {
					// ModelElement modelElement = ((CreateDeleteOperation) ao).getModelElement();
					// if (modelElement instanceof Meeting && ((Meeting) modelElement).getSections().size() != 0) {
					// printToFile(version, result);
					// }
					// }
				}
			}
		}
	}

	private void printToFile(Version version, String result) {
		try {
			System.out.println("printing to file from version " + version.getPrimarySpec().getIdentifier());
			FileWriter fileWriter = new FileWriter(System.getProperty("user.home") + "/Desktop/changes.txt", true);
			fileWriter.write("version: " + version(version) + System.getProperty("line.separator")
				+ System.getProperty("line.separator") + result + System.getProperty("line.separator"));
			fileWriter.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	@Override
	String getFixName() {
		return "Find changes";
	}

}
