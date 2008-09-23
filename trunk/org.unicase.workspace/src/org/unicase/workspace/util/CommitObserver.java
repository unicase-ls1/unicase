package org.unicase.workspace.util;

import org.unicase.emfstore.esmodel.versioning.ChangePackage;

public interface CommitObserver {
	boolean inspectChanges(ChangePackage changePackage);
}
