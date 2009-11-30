package org.unicase.emfstore.fixes;

import org.unicase.emfstore.esmodel.versioning.Version;

public class VersionConnectionFix extends AbstractFix {

	@Override
	void fix() throws Exception {
		Version lastVersion = null;
		int i = 0;
		for (Version version : projectHistory.getVersions()) {
			if (lastVersion == null) {
				lastVersion = version;
			} else {
				lastVersion.setNextVersion(version);
				version.setPreviousVersion(lastVersion);
				save(version);
				save(lastVersion);
				lastVersion = version;
			}
			System.out.print(".");
			if ((i++) % 50 == 0)
				System.out.println("!");
		}

	}

	@Override
	String getFixName() {
		return "version connection fix";
	}

}
