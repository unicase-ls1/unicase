package org.unicase.papyrus.own;

import java.util.LinkedHashMap;
import java.util.Map;
import org.eclipse.emf.common.ui.URIEditorInput;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.jface.dialogs.Dialog;
import org.eclipse.jface.dialogs.ErrorDialog;
import org.eclipse.jface.viewers.ILabelProvider;
import org.eclipse.jface.viewers.ILabelProviderListener;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.ui.PartInitException;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.dialogs.ElementListSelectionDialog;
import org.unicase.papyrus.UMLModel;
import org.unicase.papyrus.UMLDiagramType;
import org.unicase.ui.common.commands.ECPCommand;
import org.unicase.ui.util.ModelElementOpener;

public class UMLDiagramOpener implements ModelElementOpener {
	
	private static UMLDiagramType[] diagrams;
	
	private static Map<UMLDiagramType, String> diagramTypeToID;

	private static boolean isInitialized;

	public int canOpen(EObject eObject) {
		if(eObject instanceof UMLModel) {
			return 2;
		}
		return DONOTOPEN;
	}

	public void openModelElement(EObject eObject) {
		if(eObject instanceof UMLModel) {
			final UMLModel model = (UMLModel) eObject;
			//TODO: Find a better place to put this!
			if(!isInitialized) {
				model.eResource().eAdapters().add(new UnicaseModelSetQueryAdapter());
				isInitialized = true;
			}
			if(model.getGmfDiagram() == null) {
				initializePackage(model);
			}
			String id = getDiagramTypeToID().get(model.getDiagramType()); 
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
		}
		
	}

	private void initializePackage(final UMLModel model) {
		Shell shell = Display.getCurrent().getActiveShell();
		ILabelProvider provider = new ILabelProvider(){

			public void addListener(ILabelProviderListener listener) {
				// TODO Auto-generated method stub
				
			}

			public void dispose() {
				// TODO Auto-generated method stub
				
			}

			public boolean isLabelProperty(Object element, String property) {
				// TODO Auto-generated method stub
				return false;
			}

			public void removeListener(ILabelProviderListener listener) {
				// TODO Auto-generated method stub
				
			}

			public Image getImage(Object element) {
				// TODO Auto-generated method stub
				return null;
			}

			public String getText(Object element) {
				return ((UMLDiagramType) element).getName();
			}
			
		};
		ElementListSelectionDialog dialog = new ElementListSelectionDialog(shell, provider);
		dialog.setTitle("Choose the type of the diagram.");
		dialog.setElements(getDiagramTypes());
		if(dialog.open() == Dialog.OK) {
			final UMLDiagramType selectedElement = (UMLDiagramType) dialog.getFirstResult();
			new ECPCommand(model) {

				@Override
				protected void doRun() {
					model.setDiagramType(selectedElement);
					model.setName(selectedElement.getName());
				}
				
			}.run(true);
			
		}
	}

	private Map<UMLDiagramType, String> getDiagramTypeToID() {
		if(diagramTypeToID == null) {
			diagramTypeToID = new LinkedHashMap<UMLDiagramType, String>();
			diagramTypeToID.put(UMLDiagramType.ACTIVITY, "org.unicase.papyrus.activity.UMLDiagramEditorID");
			diagramTypeToID.put(UMLDiagramType.CLASS, "org.unicase.papyrus.clazz.UMLDiagramEditorID");
			diagramTypeToID.put(UMLDiagramType.COMMUNICATION, "org.unicase.papyrus.communication.UMLDiagramEditorID");
			diagramTypeToID.put(UMLDiagramType.COMPOSITE, "org.unicase.papyrus.composite.UMLDiagramEditorID");
			diagramTypeToID.put(UMLDiagramType.SEQUENCE, "org.unicase.papyrus.sequence.UMLDiagramEditorID");
			diagramTypeToID.put(UMLDiagramType.STATE_MACHINE, "org.unicase.papyrus.statemachine.UMLDiagramEditorID");
			diagramTypeToID.put(UMLDiagramType.USE_CASE, "org.unicase.papyrus.usecase.UMLDiagramEditorID");
		}
		return diagramTypeToID;
	}

	private static UMLDiagramType[] getDiagramTypes() {
		if(diagrams == null) {
			diagrams = new UMLDiagramType[] {
				UMLDiagramType.ACTIVITY,
				UMLDiagramType.CLASS,
				UMLDiagramType.COMMUNICATION,
				UMLDiagramType.COMPOSITE,
				UMLDiagramType.SEQUENCE,
				UMLDiagramType.STATE_MACHINE,
				UMLDiagramType.USE_CASE
			};
		}
		return diagrams;
	}

}
