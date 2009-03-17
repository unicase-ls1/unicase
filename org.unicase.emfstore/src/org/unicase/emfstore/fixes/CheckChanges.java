package org.unicase.emfstore.fixes;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

import org.eclipse.emf.ecore.util.EcoreUtil;
import org.unicase.emfstore.connection.rmi.SerializationUtil;
import org.unicase.emfstore.esmodel.ProjectHistory;
import org.unicase.emfstore.esmodel.versioning.Version;
import org.unicase.emfstore.exceptions.RMISerializationException;
import org.unicase.model.ModelElement;
import org.unicase.model.Project;
import org.unicase.model.meeting.Meeting;
import org.unicase.model.meeting.MeetingSection;

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
				if (version.getPrimarySpec().getIdentifier() == 78) {

					// specialVersion78(state);
				}
				version.getChanges().apply(state);
				// System.out.println("applying changes in version " + version.getPrimarySpec().getIdentifier());
				if (version.getProjectState() != null) {
					int[] compare = linearCompare(version.getProjectState(), state);
					if (compare[0] == 0) {
						System.out.println("project compare not equal in version "
							+ version.getPrimarySpec().getIdentifier());

						printProjectStates(state, version);

					} else {
						System.out.println("project compare is equal(!) in version "
							+ version.getPrimarySpec().getIdentifier());
					}
					state = (Project) EcoreUtil.copy(version.getProjectState());
				}
			}
		}
	}

	private void printProjectStates(Project state, Version version) {
		try {
			File file = new File(System.getProperty("user.home") + "/Desktop/compare/project_"
				+ version.getPrimarySpec().getIdentifier() + "_generated.txt");
			file.createNewFile();
			FileWriter fileWriter = new FileWriter(file);
			fileWriter.write(SerializationUtil.eObjectToString(state));
			fileWriter.close();
			file = new File(System.getProperty("user.home") + "/Desktop/compare/project_"
				+ version.getPrimarySpec().getIdentifier() + ".txt");
			file.createNewFile();
			fileWriter = new FileWriter(file);
			fileWriter.write(SerializationUtil.eObjectToString(version.getProjectState()));
			fileWriter.close();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (RMISerializationException e) {
			e.printStackTrace();
		}
	}

	private void specialVersion78(Project state) {
		for (ModelElement me : state.getAllModelElements()) {

			if (me instanceof MeetingSection) {
				System.out.println(me.getIdentifier());
			}

			if (me.getIdentifier().equals("_sfdU4J-7Ed2Mf6xmMnysAw")) {
				System.out.println("JAAAAAAAAAAA");
			}
			if (me.getIdentifier().equals("_sfct0J-7Ed2Mf6xmMnysAw")) {
				// System.out.println("_sfct0J-7Ed2Mf6xmMnysAw is in the project");
				Meeting m = (Meeting) me;
				for (MeetingSection ms : m.getSections()) {
					System.out.println(ms);
				}
			}
			// if (me instanceof CompositeMeetingSection) {
			// System.out.println(me);
			// }
		}
		// try {
		// FileWriter fileWriter = new FileWriter(System.getProperty("user.home") + "/Desktop/project_"
		// + version.getPrimarySpec().getIdentifier() + "_generated.txt");
		// fileWriter.write(SerializationUtil.eObjectToString(state));
		// fileWriter.close();
		// } catch (IOException e) {
		// e.printStackTrace();
		// } catch (RMISerializationException e) {
		// e.printStackTrace();
		// }
	}

	@Override
	String getFixName() {
		return "Check changes";
	}

}
