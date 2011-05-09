package org.unicase.changetracking.vcs;

import org.unicase.model.changetracking.RepositoryLocation;

public interface NameValidator {

	public String cleanName(String name);

	public String isNewTagNameValid(String text, RepositoryLocation repoLoc);
}
