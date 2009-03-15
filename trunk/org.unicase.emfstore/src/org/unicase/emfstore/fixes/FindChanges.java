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

					if (result.contains("_sfdU4J-7Ed2Mf6xmMnysAw")) {
						try {
							FileWriter fileWriter = new FileWriter(System.getProperty("user.home")
								+ "/Desktop/changes.txt", true);
							fileWriter.write("version: " + version.getPrimarySpec().getIdentifier()
								+ System.getProperty("line.separator") + System.getProperty("line.separator") + result
								+ "\n");
							fileWriter.close();
						} catch (IOException e) {
							e.printStackTrace();
						}
					}
				}
			}
		}
	}

	@Override
	String getFixName() {
		return "Find changes";
	}

}
