/**
 * <copyright> Copyright (c) 2008-2009 Jonas Helming, Maximilian Koegel. All rights reserved. This program and the
 * accompanying materials are made available under the terms of the Eclipse Public License v1.0 which accompanies this
 * distribution, and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>
 */
package org.unicase.papyrus.sysml.diagram.editors;

import org.eclipse.emf.common.ui.URIEditorInput;
import org.eclipse.gmf.runtime.diagram.core.preferences.PreferencesHint;
import org.eclipse.gmf.runtime.diagram.ui.actions.ActionIds;
import org.eclipse.papyrus.diagram.clazz.part.DiagramEditorContextMenuProvider;
import org.eclipse.papyrus.diagram.clazz.part.UMLDiagramEditorPlugin;
import org.eclipse.ui.IEditorInput;
import org.eclipse.ui.IFileEditorInput;
import org.unicase.papyrus.sysml.diagram.part.SysMLDiagramEditor;

/**
 * Diagram editor for Papyrus SysML block definition diagrams.
 * 
 * @author mharut
 */
public class SysMLBlockDefinitionDiagramEditor extends SysMLDiagramEditor{

	/**
	 * @generated
	 */
	public static final String ID = "org.unicase.papyrus.sysml.diagram.blockdefinition.SysMLDiagramEditorID"; //$NON-NLS-1$

	/**
	 * @generated
	 */
	public static final String CONTEXT_ID = "org.unicase.papyrus.sysml.diagram.blockdefinition.diagramContext"; //$NON-NLS-1$
	
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
		return "org.eclipse.papyrus.sysml.diagram.blockdefinition";
	}
	
	/**
	 * @generated
	 */
	protected void setDocumentProvider(IEditorInput input) {
		if (input instanceof IFileEditorInput
				|| input instanceof URIEditorInput) {
			setDocumentProvider(new SysMLBlockDefinitionDiagramDocumentProvider());
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

