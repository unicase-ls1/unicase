package org.unicase.papyrus.diagram.editors;

import org.eclipse.emf.common.ui.URIEditorInput;
import org.eclipse.gmf.runtime.diagram.core.preferences.PreferencesHint;
import org.eclipse.gmf.runtime.diagram.ui.actions.ActionIds;
import org.eclipse.papyrus.diagram.statemachine.part.DiagramEditorContextMenuProvider;
import org.eclipse.papyrus.diagram.statemachine.part.UMLDiagramEditorPlugin;
import org.eclipse.ui.IEditorInput;
import org.eclipse.ui.IFileEditorInput;
import org.unicase.papyrus.diagram.part.UMLDiagramEditor;

public class UMLStateMachineDiagramEditor extends UMLDiagramEditor {

	/**
	 * @generated
	 */
	public static final String ID = "org.unicase.papyrus.diagram.statemachine.UMLDiagramEditorID"; //$NON-NLS-1$

	/**
	 * @generated
	 */
	public static final String CONTEXT_ID = "org.unicase.papyrus.diagram.statemachine.diagramContext"; //$NON-NLS-1$

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
			setDocumentProvider(new UMLStateMachineDiagramDocumentProvider());
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
