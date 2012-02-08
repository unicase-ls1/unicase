/**
 * <copyright> Copyright (c) 2008-2009 Jonas Helming, Maximilian Koegel. All rights reserved. This program and the
 * accompanying materials are made available under the terms of the Eclipse Public License v1.0 which accompanies this
 * distribution, and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>
 */
package org.unicase.papyrus.diagram.part;

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
import org.unicase.papyrus.UMLDiagramType;
import org.unicase.papyrus.UMLModel;

/**
 * Opener for Papyrus UML-Diagrams, i.e. model elements of type {@link UMLModel}. Opening a UMLModel will open the
 * corresponding diagram, if the diagram already exists. If the diagram doesn't exist yet, this will show a dialog
 * letting the user choose the diagram type and further initialize the model and open the editor.
 * 
 * @author mharut
 */
public class UMLDiagramOpener implements ModelElementOpener {

	private static Map<UMLDiagramType, String> diagramTypeToEditorID;

	/**
	 * {@inheritDoc}
	 */
	public int canOpen(EObject eObject) {
		if (eObject instanceof UMLModel) {
			return 2;
		}
		return DONOTOPEN;
	}

	/**
	 * {@inheritDoc}
	 */
	public void openModelElement(EObject eObject) {
		if (eObject instanceof UMLModel) {
			final UMLModel model = (UMLModel) eObject;

			if (model.getDiagramType() == UMLDiagramType.NO_DIAGRAM) {
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

	private void initializeModel(final UMLModel model) {
		Shell shell = Display.getCurrent().getActiveShell();
		UMLDiagramTypeSelectionDialog dialog = new UMLDiagramTypeSelectionDialog(shell);
		if (dialog.open() == Dialog.OK) {
			final UMLDiagramType selectedElement = (UMLDiagramType) dialog.getFirstResult();
			new ECPCommand(model) {

				@Override
				protected void doRun() {
					model.setDiagramType(selectedElement);
					model.setName("new " + selectedElement.getName() + " Diagram");
				}

			}.run(true);

		}
	}

	private Map<UMLDiagramType, String> getDiagramTypeToEditorID() {
		if (diagramTypeToEditorID == null) {
			diagramTypeToEditorID = new LinkedHashMap<UMLDiagramType, String>();
			diagramTypeToEditorID.put(UMLDiagramType.ACTIVITY,
				"org.unicase.papyrus.diagram.activity.UMLDiagramEditorID");
			diagramTypeToEditorID.put(UMLDiagramType.CLASS, "org.unicase.papyrus.diagram.clazz.UMLDiagramEditorID");
			diagramTypeToEditorID.put(UMLDiagramType.COMMUNICATION,
				"org.unicase.papyrus.diagram.communication.UMLDiagramEditorID");
			diagramTypeToEditorID.put(UMLDiagramType.COMPOSITE,
				"org.unicase.papyrus.diagram.composite.UMLDiagramEditorID");
			diagramTypeToEditorID.put(UMLDiagramType.SEQUENCE,
				"org.unicase.papyrus.diagram.sequence.UMLDiagramEditorID");
			diagramTypeToEditorID.put(UMLDiagramType.STATE_MACHINE,
				"org.unicase.papyrus.diagram.statemachine.UMLDiagramEditorID");
			diagramTypeToEditorID
				.put(UMLDiagramType.USE_CASE, "org.unicase.papyrus.diagram.usecase.UMLDiagramEditorID");
		}
		return diagramTypeToEditorID;
	}

}
