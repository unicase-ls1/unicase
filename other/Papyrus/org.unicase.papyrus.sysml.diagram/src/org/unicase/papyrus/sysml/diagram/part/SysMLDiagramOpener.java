package org.unicase.papyrus.sysml.diagram.part;

import java.io.IOException;
import java.util.LinkedHashMap;
import java.util.Map;
import org.eclipse.emf.common.ui.URIEditorInput;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.jface.dialogs.Dialog;
import org.eclipse.jface.dialogs.ErrorDialog;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.ui.PartInitException;
import org.eclipse.ui.PlatformUI;
import org.unicase.papyrus.SysMLDiagramType;
import org.unicase.papyrus.SysMLModel;
import org.unicase.papyrus.SysMLDiagramType;
import org.unicase.ui.common.commands.ECPCommand;
import org.unicase.ui.util.ModelElementOpener;
import org.unicase.workspace.util.UnicaseCommand;

public class SysMLDiagramOpener implements ModelElementOpener {
	
	private static Map<SysMLDiagramType, String> diagramTypeToEditorID;
	
	public int canOpen(EObject eObject) {
		if(eObject instanceof SysMLModel) {
			return 5;
		}
		return DONOTOPEN;
	}

	public void openModelElement(EObject eObject) {
		if(eObject instanceof SysMLModel) {
			final SysMLModel model = (SysMLModel) eObject;
			if(model.getDiagramType() == SysMLDiagramType.NO_DIAGRAM) {
				initializeModel(model);
			}
			String id = getDiagramTypeToEditorID().get(model.getDiagramType()); 
			if(id == null) {
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
//			
//			new UnicaseCommand() {
//				
//				
//				@Override
//				protected void doRun() {
//					try {
//						model.saveDiagramLayout();
//					} catch (IOException e) {
//						// TODO Auto-generated catch block
//						e.printStackTrace();
//					}
//				}
//				
//			}.run(true);
//			
		}
		
	}

	private void initializeModel(final SysMLModel model) {
		final Shell shell = Display.getCurrent().getActiveShell();
		SysMLDiagramTypeSelectionDialog dialog = new SysMLDiagramTypeSelectionDialog(shell);
		if(dialog.open() == Dialog.OK) {
			final SysMLDiagramType selectedElement = (SysMLDiagramType) dialog.getFirstResult();
			new ECPCommand(model) {

				@Override
				protected void doRun() {
					if(selectedElement != SysMLDiagramType.PARAMETRIC) {
						MessageDialog.openInformation(shell, "Diagram Type not supported yet",
								"The diagram type you have selected is not supported yet. Please choose another one.");
						openModelElement(model);
						return;
					}
					model.setDiagramType(selectedElement);
					model.setName("new " + selectedElement.getName() + " Diagram");
				}
				
			}.run(true);
			
		}
	}

	private Map<SysMLDiagramType, String> getDiagramTypeToEditorID() {
		if(diagramTypeToEditorID == null) {
			diagramTypeToEditorID = new LinkedHashMap<SysMLDiagramType, String>();
			diagramTypeToEditorID.put(SysMLDiagramType.PARAMETRIC, "org.unicase.papyrus.sysml.diagram.parametric.SysMLDiagramEditorID");
			diagramTypeToEditorID.put(SysMLDiagramType.BLOCK_DEFINITION, "org.unicase.papyrus.sysml.diagram.blockdefinition.SysMLDiagramEditorID");
			diagramTypeToEditorID.put(SysMLDiagramType.REQUIREMENT, "org.unicase.papyrus.sysml.diagram.requirement.SysMLDiagramEditorID");
			diagramTypeToEditorID.put(SysMLDiagramType.INTERNAL_BLOCK, "org.unicase.papyrus.sysml.diagram.internalblock.SysMLDiagramEditorID");
		}
		return diagramTypeToEditorID;
	}

}
