package org.unicase.workspace.ui.views.changes;

import org.eclipse.swt.graphics.Image;
import org.unicase.emfstore.esmodel.versioning.operations.AbstractOperation;

public interface ChangePackageVisualizer {
	public String getDescription(AbstractOperation operation);

	public Image getImage(AbstractOperation operation);

	public int canRender(AbstractOperation operation);
}
