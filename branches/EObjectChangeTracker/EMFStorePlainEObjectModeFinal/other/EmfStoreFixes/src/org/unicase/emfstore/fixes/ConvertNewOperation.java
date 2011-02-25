package org.unicase.emfstore.fixes;

import org.unicase.emfstore.esmodel.versioning.Version;

public class ConvertNewOperation extends AbstractFix {

	@Override
	void fix() {
		for (Version version : projectHistory.getVersions()) {
			if (version.getChanges() != null) {
				save(version.getChanges());
			}
		}
	}

	@Override
	String getFixName() {
		return "Convert new operations";
	}

}
