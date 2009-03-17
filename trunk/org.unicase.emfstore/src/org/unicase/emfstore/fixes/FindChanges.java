package org.unicase.emfstore.fixes;

import java.io.FileWriter;
import java.io.IOException;

import org.unicase.emfstore.connection.rmi.SerializationUtil;
import org.unicase.emfstore.esmodel.versioning.Version;
import org.unicase.emfstore.esmodel.versioning.operations.AbstractOperation;
import org.unicase.emfstore.exceptions.RMISerializationException;

public class FindChanges extends AbstractFix {

	@Override
	void fix() {
		for (Version version : projectHistory.getVersions()) {
			if (version.getChanges() != null) {
				for (AbstractOperation ao : version.getChanges().getOperations()) {
					String result = "";
					try {
						result = SerializationUtil.eObjectToString(ao);
					} catch (RMISerializationException e) {
						e.printStackTrace();
					}

					if (result.contains("_hLQMsKOgEd2xnr7_LdISjQ")) {
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
			FileWriter fileWriter = new FileWriter(System.getProperty("user.home") + "/Desktop/changes.txt", true);
			fileWriter.write("version: " + version.getPrimarySpec().getIdentifier()
				+ System.getProperty("line.separator") + System.getProperty("line.separator") + result
				+ System.getProperty("line.separator"));
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
