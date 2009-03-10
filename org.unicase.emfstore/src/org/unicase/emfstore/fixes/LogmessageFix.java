package org.unicase.emfstore.fixes;

import java.util.Date;

import org.unicase.emfstore.esmodel.versioning.Version;

public class LogmessageFix extends AbstractFix {

	@Override
	void fix() {
		Version lastVersion = null;
		for (Version version : projectHistory.getVersions()) {

			if (version.getLogMessage() == null) {

				System.out.println("no logmessage in version: " + version.getPrimarySpec().getIdentifier());

				// !!!!!!! Logmessages were still there, but not in the right position in the xml file. !!!!!!!!!!!

				//
				// LogMessage logMessage = VersioningFactory.eINSTANCE.createLogMessage();
				// Date date = getDate(version);
				// if (lastVersion != null && lastVersion.getLogMessage() != null
				// && lastVersion.getLogMessage().getDate() != null) {
				// date = lastVersion.getLogMessage().getDate();
				// date.setDate(date.getDate() + 23);
				// // TODO: get date of changepackage
				// } else {
				// date = new Date();
				// }

				// System.out.println("fixing version: " + version.getPrimarySpec().getIdentifier());
				//
				// logMessage.setDate(date);
				// logMessage.setClientDate(date);
				// logMessage.setAuthor("<automated project fix>");
				// logMessage.setMessage("<automated project fix, date might not be correct.>");
				// version.setLogMessage(logMessage);
				// save(version);
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
