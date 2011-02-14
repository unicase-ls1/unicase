package examplemodel.editor;

import library.Library;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.ui.PartInitException;
import org.eclipse.ui.PlatformUI;
import org.unicase.metamodel.ModelElement;

public class ModelElementOpener implements org.unicase.ui.common.ModelElementOpener {

	public ModelElementOpener() {
		// TODO Auto-generated constructor stub
	}

	public int canOpen(EObject modelElement) {
		if(modelElement instanceof Library){
			return 2;
		}
		return 0;
	}

	public void openModelElement(EObject modelElement) {
		if(modelElement instanceof ModelElement){
			ModelElement me = (ModelElement) modelElement;
		try {
			PlatformUI.getWorkbench().getActiveWorkbenchWindow().getActivePage().openEditor(new ExampleInput(me),
				"library.presentation.LibraryEditorID", true);
		} catch (PartInitException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}}

	}

}
