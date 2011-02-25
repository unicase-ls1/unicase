package org.unicase.ui.meeditor;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.ui.IEditorInput;

public interface ECPEditorInput extends IEditorInput {
	public ModelElementContext getModelElementContext();

	public EObject getModelElement();
}
