package org.unicase.emfstore.fixes;

import java.io.FileWriter;
import java.io.IOException;

import org.eclipse.emf.ecore.util.EcoreUtil;
import org.unicase.emfstore.connection.rmi.SerializationUtil;
import org.unicase.emfstore.esmodel.ProjectHistory;
import org.unicase.emfstore.esmodel.versioning.Version;
import org.unicase.emfstore.exceptions.RMISerializationException;
import org.unicase.model.Project;

public class CheckChanges extends AbstractFix {

	@Override
	void fix() {
		ProjectHistory history = (ProjectHistory) EcoreUtil.copy(projectHistory);

		Project state = null;
		for (Version version : history.getVersions()) {
			if (version.getProjectState() != null && state == null) {
				System.out.println("loading initial projectstate in version "
					+ version.getPrimarySpec().getIdentifier());
				state = (Project) EcoreUtil.copy(version.getProjectState());
			} else {
				version.getChanges().apply(state);
				// System.out.println("applying changes in version " + version.getPrimarySpec().getIdentifier());
				if (version.getProjectState() != null) {
					int[] compare = linearCompare(version.getProjectState(), state);
					if (compare[0] == 0) {
						System.out.println("project compare not equal in version "
							+ version.getPrimarySpec().getIdentifier());

						try {
							FileWriter fileWriter = new FileWriter(System.getProperty("user.home")
								+ "/Desktop/project_" + version.getPrimarySpec().getIdentifier() + "_generated.txt");
							fileWriter.write(SerializationUtil.eObjectToString(state));
							fileWriter.close();
							fileWriter = new FileWriter(System.getProperty("user.home") + "/Desktop/project_"
								+ version.getPrimarySpec().getIdentifier() + ".txt");
							fileWriter.write(SerializationUtil.eObjectToString(version.getProjectState()));
							fileWriter.close();
						} catch (IOException e) {
							e.printStackTrace();
						} catch (RMISerializationException e) {
							e.printStackTrace();
						}
					} else {
						System.out.println("project compare is equal(!) in version "
							+ version.getPrimarySpec().getIdentifier());
					}
					state = (Project) EcoreUtil.copy(version.getProjectState());
				}
			}
		}
	}

	@Override
	String getFixName() {
		return "Check changes";
	}

}
