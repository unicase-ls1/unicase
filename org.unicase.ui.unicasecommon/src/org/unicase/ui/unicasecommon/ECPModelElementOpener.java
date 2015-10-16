package org.unicase.ui.unicasecommon;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecp.core.ECPProject;
import org.eclipse.emf.ecp.editor.e3.MEEditorInput;
import org.eclipse.emf.ecp.explorereditorbridge.internal.Activator;
import org.eclipse.emf.ecp.explorereditorbridge.internal.EditorContext;
import org.eclipse.ui.PartInitException;
import org.eclipse.ui.PlatformUI;

@SuppressWarnings("restriction")

public class ECPModelElementOpener implements org.eclipse.emf.ecp.ui.util.ECPModelElementOpener {
	private static final String ECP_EDITOR_ID = "org.eclipse.emf.ecp.editor"; //$NON-NLS-1$

	public ECPModelElementOpener() {
	}

	public void openModelElement(Object modelElement, ECPProject ecpProject) {
		final MEEditorInput input = new MEEditorInput(new EditorContext((EObject) modelElement, ecpProject));
		try {
			PlatformUI.getWorkbench().getActiveWorkbenchWindow().getActivePage().openEditor(input, ECP_EDITOR_ID, true);
		} catch (final PartInitException e) {
			Activator.logException(e);
		}
	}

	public int canOpen(EObject modelElement) {
		return 5;
	}
}
