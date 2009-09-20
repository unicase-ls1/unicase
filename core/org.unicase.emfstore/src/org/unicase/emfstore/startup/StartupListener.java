package org.unicase.emfstore.startup;

import java.util.List;

import org.unicase.emfstore.esmodel.ProjectHistory;

public interface StartupListener {

	void startedUp(List<ProjectHistory> projects);
}
