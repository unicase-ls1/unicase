package org.unicase.papyrus.own;

import java.util.Collection;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.Map;
import java.util.Set;

import org.eclipse.emf.common.ui.URIEditorInput;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.jface.dialogs.Dialog;
import org.eclipse.jface.dialogs.ErrorDialog;
import org.eclipse.ui.PartInitException;
import org.eclipse.ui.PlatformUI;
import org.eclipse.uml2.uml.Activity;
import org.eclipse.uml2.uml.StateMachine;
import org.eclipse.uml2.uml.UMLFactory;
import org.eclipse.uml2.uml.UseCase;
import org.eclipse.uml2.uml.Class;
import org.unicase.papyrus.UML2Package;
import org.unicase.papyrus.UMLDiagramType;
import org.unicase.ui.common.commands.ECPCommand;
import org.unicase.ui.common.dialogs.ModelElementSelectionDialog;
import org.unicase.ui.util.ModelElementOpener;

public class UMLPackageOpener implements ModelElementOpener {
	
	private static Set<EObject> diagrams;
	
	private static Map<UMLDiagramType, String> diagramTypeToID;

	private static boolean isInitialized;

	public int canOpen(EObject eObject) {
		if(eObject instanceof UML2Package) {
			return 2;
		}
		return DONOTOPEN;
	}

	public void openModelElement(EObject eObject) {
		if(eObject instanceof UML2Package) {
			final UML2Package pckge = (UML2Package) eObject;
			//TODO: Find a better place to put this!
			if(!isInitialized) {
				pckge.eResource().eAdapters().add(new UnicaseModelSetQueryAdapter());
				isInitialized = true;
			}
			if(pckge.getGmfDiagram() == null) {
				initializePackage(pckge);
			}
			String id = getDiagramTypeToID().get(pckge.getDiagramType()); 
			if(id == null) {
				return;
			}
			URI uri = EcoreUtil.getURI(pckge);
			URIEditorInput input = new URIEditorInput(uri, pckge.getName());
			try {
				PlatformUI.getWorkbench().getActiveWorkbenchWindow().getActivePage().openEditor(input, id, true);
			} catch (PartInitException e) {
				ErrorDialog.openError(PlatformUI.getWorkbench().getActiveWorkbenchWindow().getShell(), "Error",
						e.getMessage(), e.getStatus());
			}
		}
		
	}

	private void initializePackage(final UML2Package pckge) {
		ModelElementSelectionDialog dialog = new ModelElementSelectionDialog(){};
		dialog.setTitle("Choose the type of the diagram.");
		dialog.setModelElements(getDiagrams());
		if(dialog.open() == Dialog.OK) {
			final EObject selectedElement = (EObject) dialog.getFirstResult();
			new ECPCommand(pckge) {

				@Override
				protected void doRun() {
					pckge.setDiagramType(UMLDiagramType.getDiagramType(selectedElement));
					pckge.setName(selectedElement.eClass().getName());
				}
				
			}.run(true);
			
		}
	}

	private Map<UMLDiagramType, String> getDiagramTypeToID() {
		if(diagramTypeToID == null) {
			diagramTypeToID = new LinkedHashMap<UMLDiagramType, String>();
			diagramTypeToID.put(UMLDiagramType.ACTIVITY, "org.unicase.papyrus.activity.UMLDiagramEditorID");
			diagramTypeToID.put(UMLDiagramType.CLASS, "org.unicase.papyrus.clazz.UMLDiagramEditorID");
			diagramTypeToID.put(UMLDiagramType.STATE_MACHINE, "org.unicase.papyrus.statemachine.UMLDiagramEditorID");
			diagramTypeToID.put(UMLDiagramType.USE_CASE, "org.unicase.papyrus.usecase.UMLDiagramEditorID");
		}
		return diagramTypeToID;
	}

	private static Collection<EObject> getDiagrams() {
		if(diagrams == null) {
			diagrams = new LinkedHashSet<EObject>();
			diagrams.add(UMLFactory.eINSTANCE.createActivity());
			diagrams.add(UMLFactory.eINSTANCE.createClass());
			diagrams.add(UMLFactory.eINSTANCE.createStateMachine());
			diagrams.add(UMLFactory.eINSTANCE.createUseCase());
		}
		return diagrams;
	}

}
