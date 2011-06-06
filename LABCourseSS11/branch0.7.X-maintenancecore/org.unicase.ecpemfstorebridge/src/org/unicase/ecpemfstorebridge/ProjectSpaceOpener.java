package org.unicase.ecpemfstorebridge;

import org.eclipse.emf.ecore.EObject;
import org.unicase.ui.util.ModelElementOpener;
import org.unicase.workspace.ProjectSpace;

public class ProjectSpaceOpener implements ModelElementOpener {

	public int canOpen(EObject modelElement) {
		if (modelElement instanceof ProjectSpace) {
			return 1;
		}
		return DONOTOPEN;
	}

	public void openModelElement(EObject modelElement) {
		// do nothing
	}

}
