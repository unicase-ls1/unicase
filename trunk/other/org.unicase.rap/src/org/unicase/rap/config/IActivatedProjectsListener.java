package org.unicase.rap.config;

import java.util.List;

import org.unicase.workspace.ProjectSpace;

public interface IActivatedProjectsListener {

	void activatedProjectsChangd(List<ProjectSpace> projectSpaces);
}
