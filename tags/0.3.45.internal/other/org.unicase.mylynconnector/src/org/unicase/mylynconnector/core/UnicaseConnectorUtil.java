package org.unicase.mylynconnector.core;

import org.eclipse.emf.transaction.TransactionalEditingDomain;

public class UnicaseConnectorUtil {

	public static String convertMeIdToTaskId(String taskId) {
		return (taskId != null) ? taskId.replaceAll("-", "@") : null;
	}

	public static String convertTaskIdToMeId(String taskId) {
		return (taskId != null) ? taskId.replaceAll("@", "-") : null;
	}

	public static TransactionalEditingDomain getDomain() {
		return TransactionalEditingDomain.Registry.INSTANCE
				.getEditingDomain("org.unicase.EditingDomain");
	}
}
