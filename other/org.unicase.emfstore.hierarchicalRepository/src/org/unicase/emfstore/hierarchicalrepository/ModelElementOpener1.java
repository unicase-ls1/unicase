package org.unicase.emfstore.hierarchicalrepository;

import library.Writer;

import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.ui.PlatformUI;
import org.unicase.metamodel.ModelElement;
import org.unicase.ui.common.ModelElementOpener;

public class ModelElementOpener1 implements ModelElementOpener {

	public ModelElementOpener1() {
		// TODO Auto-generated constructor stub
	}

	public int canOpen(ModelElement modelElement) {
		if (modelElement instanceof Writer) {
			Writer writer = (Writer) modelElement;
			if (writer.getName().equals("Test")) {
				return 1;
			}
		}
		return 0;
	}

	public void openModelElement(ModelElement modelElement) {
		MessageDialog.openInformation(PlatformUI.getWorkbench()
				.getActiveWorkbenchWindow().getShell(), null, "Opening model element");

	}

}
