package org.unicase.ui.navigator.commands;

import org.eclipse.jface.action.Action;
import org.eclipse.jface.viewers.StructuredSelection;
import org.eclipse.jface.viewers.TreeViewer;
import org.eclipse.ui.IEditorInput;
import org.eclipse.ui.IEditorPart;
import org.eclipse.ui.PlatformUI;
import org.unicase.model.ModelElement;

/**
 * This action shows location of currently open model element in navigator tree.
 * 
 * @author Hodaie
 */
public class LinkWithEditorAction extends Action {

	private static final String MEEDITOR_ID = "org.unicase.ui.meeditor";
	private TreeViewer treeViewer;

	/**
	 * Constructor.
	 * 
	 * @param treeViewer tree viewer
	 */
	public LinkWithEditorAction(TreeViewer treeViewer) {
		super();
		this.treeViewer = treeViewer;
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.jface.action.Action#run()
	 */
	@Override
	public void run() {

		ModelElement me = null;

		IEditorPart activeEditor = PlatformUI.getWorkbench().getActiveWorkbenchWindow().getActivePage()
			.getActiveEditor();

		String partId = "";
		if (activeEditor != null) {
			partId = activeEditor.getSite().getId();
		}

		if (partId.equals(MEEDITOR_ID)) {
			// extract model element from editor input
			IEditorInput editorInput = activeEditor.getEditorInput();
			Object obj = editorInput.getAdapter(ModelElement.class);

			if (obj instanceof ModelElement) {
				me = (ModelElement) obj;
			}

		}

		if (me == null) {
			return;
		}

		treeViewer.setSelection(new StructuredSelection(me), true);

	}

}
