package org.unicase.ui.navigator;

import java.util.Collection;

import org.unicase.workspace.ProjectSpace;

public interface ProjectSpaceContentProvider {
	public boolean hasChildren(ProjectSpace projectSpace);

	public Collection<?> getChildren(ProjectSpace projectSpace);
}
