package org.unicase.papyrus.own;

import org.eclipse.emf.common.ui.URIEditorInput;
import org.eclipse.gmf.runtime.diagram.core.preferences.PreferencesHint;
import org.eclipse.gmf.runtime.diagram.ui.actions.ActionIds;
import org.eclipse.papyrus.diagram.communication.part.DiagramEditorContextMenuProvider;
import org.eclipse.papyrus.diagram.communication.part.UMLDiagramEditorPlugin;
import org.eclipse.ui.IEditorInput;
import org.eclipse.ui.IFileEditorInput;

public class UMLCommunicationDiagramEditor extends UMLDiagramEditor {

	/**
	 * @generated
	 */
	public static final String ID = "org.unicase.papyrus.communication.UMLDiagramEditorID"; //$NON-NLS-1$

	/**
	 * @generated
	 */
	public static final String CONTEXT_ID = "org.unicase.papyrus.communication.diagramContext"; //$NON-NLS-1$

	/**
	 * @generated
	 */
	protected String getContextID() {
		return CONTEXT_ID;
	}
	
	/**
	 * @generated
	 */
	protected PreferencesHint getPreferencesHint() {
		return UMLDiagramEditorPlugin.DIAGRAM_PREFERENCES_HINT;
	}
	
	/**
	 * @generated
	 */
	public String getContributorId() {
		return UMLDiagramEditorPlugin.ID;
	}
	
	/**
	 * @generated
	 */
	protected void setDocumentProvider(IEditorInput input) {
		if (input instanceof IFileEditorInput
				|| input instanceof URIEditorInput) {
			setDocumentProvider(UMLDocumentProviderProvider.
					getClassDiagramDocumentProvider());
		} else {
			super.setDocumentProvider(input);
		}
	}
	
	/**
	 * @generated
	 */
	protected void configureGraphicalViewer() {
		super.configureGraphicalViewer();
		DiagramEditorContextMenuProvider provider = new DiagramEditorContextMenuProvider(
				this, getDiagramGraphicalViewer());
		getDiagramGraphicalViewer().setContextMenu(provider);
		getSite().registerContextMenu(ActionIds.DIAGRAM_EDITOR_CONTEXT_MENU,
				provider, getDiagramGraphicalViewer());
	}
	
}
