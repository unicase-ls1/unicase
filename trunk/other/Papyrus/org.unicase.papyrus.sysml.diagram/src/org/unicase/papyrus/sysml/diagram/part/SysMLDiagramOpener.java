/**
 * <copyright> Copyright (c) 2008-2009 Jonas Helming, Maximilian Koegel. All rights reserved. This program and the
 * accompanying materials are made available under the terms of the Eclipse Public License v1.0 which accompanies this
 * distribution, and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>
 */
package org.unicase.papyrus.sysml.diagram.part;

import java.util.LinkedHashMap;
import java.util.Map;

import org.eclipse.emf.common.ui.URIEditorInput;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.ecp.common.commands.ECPCommand;
import org.eclipse.emf.ecp.common.util.ModelElementOpener;
import org.eclipse.jface.dialogs.Dialog;
import org.eclipse.jface.dialogs.ErrorDialog;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.ui.PartInitException;
import org.eclipse.ui.PlatformUI;
import org.unicase.papyrus.SysMLDiagramType;
import org.unicase.papyrus.SysMLModel;

/**
 * Opener for Papyrus SysML-Diagrams, i.e. model elements of type {@link SysMLModel}. Opening a SysMLModel will open the
 * corresponding diagram, if the diagram already exists. If the diagram doesn't exist yet, this will show a dialog
 * letting the user choose the diagram type and further initialize the model and open the editor.
 * 
 * @author mharut
 */
public class SysMLDiagramOpener implements ModelElementOpener {

	private static Map<SysMLDiagramType, String> diagramTypeToEditorID;

	/**
	 * {@inheritDoc}
	 */
	public int canOpen(EObject eObject) {
		if (eObject instanceof SysMLModel) {
			return 2;
		}
		return DONOTOPEN;
	}

	/**
	 * {@inheritDoc}
	 */
	public void openModelElement(EObject eObject) {
		if (eObject instanceof SysMLModel) {
			final SysMLModel model = (SysMLModel) eObject;
			if (model.getDiagramType() == SysMLDiagramType.NO_DIAGRAM) {
				initializeModel(model);
			}
			String id = getDiagramTypeToEditorID().get(model.getDiagramType());
			if (id == null) {
				return;
			}
			URI uri = EcoreUtil.getURI(model);
			URIEditorInput input = new URIEditorInput(uri, model.getName());
			try {
				PlatformUI.getWorkbench().getActiveWorkbenchWindow().getActivePage().openEditor(input, id, true);
			} catch (PartInitException e) {
				ErrorDialog.openError(PlatformUI.getWorkbench().getActiveWorkbenchWindow().getShell(), "Error",
					e.getMessage(), e.getStatus());
			}

		}

	}

	private void initializeModel(final SysMLModel model) {
		final Shell shell = Display.getCurrent().getActiveShell();
		SysMLDiagramTypeSelectionDialog dialog = new SysMLDiagramTypeSelectionDialog(shell);
		if (dialog.open() == Dialog.OK) {
			final SysMLDiagramType selectedElement = (SysMLDiagramType) dialog.getFirstResult();
			new ECPCommand(model) {

				@Override
				protected void doRun() {
					model.setDiagramType(selectedElement);
					model.setName("new " + selectedElement.getName() + " Diagram");
				}

			}.run(true);

		}
	}

	private Map<SysMLDiagramType, String> getDiagramTypeToEditorID() {
		if (diagramTypeToEditorID == null) {
			diagramTypeToEditorID = new LinkedHashMap<SysMLDiagramType, String>();
			diagramTypeToEditorID.put(SysMLDiagramType.PARAMETRIC,
				"org.unicase.papyrus.sysml.diagram.parametric.SysMLDiagramEditorID");
			diagramTypeToEditorID.put(SysMLDiagramType.BLOCK_DEFINITION,
				"org.unicase.papyrus.sysml.diagram.blockdefinition.SysMLDiagramEditorID");
			diagramTypeToEditorID.put(SysMLDiagramType.REQUIREMENT,
				"org.unicase.papyrus.sysml.diagram.requirement.SysMLDiagramEditorID");
			diagramTypeToEditorID.put(SysMLDiagramType.INTERNAL_BLOCK,
				"org.unicase.papyrus.sysml.diagram.internalblock.SysMLDiagramEditorID");
		}
		return diagramTypeToEditorID;
	}

}
