package org.unicase.emfstore.fixes;

import java.util.Date;

import org.unicase.emfstore.esmodel.versioning.LogMessage;
import org.unicase.emfstore.esmodel.versioning.Version;
import org.unicase.emfstore.esmodel.versioning.VersioningFactory;

public class LogmessageFix extends AbstractFix {

	@Override
	void fix() {
		Version lastVersion = null;
		for (Version version : projectHistory.getVersions()) {

			if (version.getLogMessage() == null) {

				System.out.println("no logmessage in version: " + version.getPrimarySpec().getIdentifier());

				// !!!!!!! Logmessages were still there, but not in the right position in the xml file. !!!!!!!!!!!
				// broken logmessages were 55,56,57,334 with 334 copy wasnt enough, but after rewriting the file and
				// then copying the old logmessage helped.

				if (version.getPrimarySpec().getIdentifier() == 334) {
					LogMessage logMessage = VersioningFactory.eINSTANCE.createLogMessage();

					// System.out.println("fixing version: " + version.getPrimarySpec().getIdentifier());
					//
					Date date = new Date();
					logMessage.setDate(date);
					logMessage.setClientDate(date);
					logMessage.setAuthor("<automated project fix>");
					logMessage.setMessage("<automated project fix, date might not be correct.>");
					version.setLogMessage(logMessage);
					save(version);
				}
			}

			lastVersion = version;
		}
	}

	private Date getDate(Version version) {
		if (version.getChanges() == null) {
			return new Date();
		}

		version.getChanges();
		return null;
	}

	@Override
	String getFixName() {
		return "LogMessage fix";
	}

}
