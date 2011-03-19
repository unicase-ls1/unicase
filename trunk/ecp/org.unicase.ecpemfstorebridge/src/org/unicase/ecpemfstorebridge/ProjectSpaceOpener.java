package org.unicase.ecpemfstorebridge;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.emfstore.client.ProjectSpace;
import org.unicase.ui.util.ModelElementOpener;

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
