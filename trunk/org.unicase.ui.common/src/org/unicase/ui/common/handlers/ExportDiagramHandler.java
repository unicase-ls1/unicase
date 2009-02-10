/**
 * <copyright> Copyright (c) 2008 Jonas Helming, Maximilian Koegel. All rights reserved. This program and the
 * accompanying materials are made available under the terms of the Eclipse Public License v1.0 which accompanies this
 * distribution, and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>
 */
package org.unicase.ui.common.handlers;

import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.Path;
import org.eclipse.gmf.runtime.diagram.core.preferences.PreferencesHint;
import org.eclipse.gmf.runtime.diagram.ui.image.ImageFileFormat;
import org.eclipse.gmf.runtime.diagram.ui.render.util.CopyToImageUtil;
import org.eclipse.gmf.runtime.diagram.ui.resources.editor.parts.DiagramDocumentEditor;
import org.eclipse.jface.action.Action;
import org.eclipse.ui.IEditorPart;
import org.eclipse.ui.PlatformUI;
import org.unicase.ui.common.exceptions.DialogHandler;

/**
 * . This a handler exports the diagram as an image
 * 
 * @author denglerm
 */
public class ExportDiagramHandler extends Action {

	/**
	 * . {@inheritDoc}
	 */
	@Override
	public void run() {
		CopyToImageUtil util = new CopyToImageUtil();
		IEditorPart iep = PlatformUI.getWorkbench().getActiveWorkbenchWindow().getActivePage().getActiveEditor();
		DiagramDocumentEditor dde = (DiagramDocumentEditor) iep;
		try{
		util.copyToImage(
			dde.getDiagram(),
			new Path("test"),
			ImageFileFormat.PDF,
			null,
			PreferencesHint.USE_DEFAULTS);
		}
		catch(CoreException e)
		{
			DialogHandler.showExceptionDialog(e);
		}
	}

}
