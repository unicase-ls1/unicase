package org.unicase.papyrus.custom.part;

import org.eclipse.gmf.runtime.diagram.ui.resources.editor.document.AbstractDocumentProvider;
import org.eclipse.ui.IEditorInput;
import org.unicase.papyrus.custom.editors.UMLActivityDiagramDocumentProvider;
import org.unicase.papyrus.custom.editors.UMLClassDiagramDocumentProvider;
import org.unicase.papyrus.custom.editors.UMLStateMachineDiagramDocumentProvider;
import org.unicase.papyrus.custom.editors.UMLUseCaseDiagramDocumentProvider;

public class UMLDocumentProviderProvider {
	
	private static UMLDocumentProvider activityDocumentProvider;
	
	private static UMLDocumentProvider clazzDocumentProvider;
	
	private static UMLDocumentProvider statemachineDocumentProvider;
	
	private static UMLDocumentProvider usecaseDocumentProvider;
	
	public static AbstractDocumentProvider getActivityDiagramDocumentProvider() {
		if(activityDocumentProvider == null) {
			activityDocumentProvider = new UMLActivityDiagramDocumentProvider();
		}
		return activityDocumentProvider;
	}

	public static AbstractDocumentProvider getClassDiagramDocumentProvider() {
		if(clazzDocumentProvider == null) {
			clazzDocumentProvider = new UMLClassDiagramDocumentProvider();
		}
		return clazzDocumentProvider;
	}
	
	public static AbstractDocumentProvider getStateMachineDiagramDocumentProvider() {
		if(statemachineDocumentProvider == null) {
			statemachineDocumentProvider = new UMLStateMachineDiagramDocumentProvider();
		}
		return statemachineDocumentProvider;
	}

	public static AbstractDocumentProvider getUseCaseDiagramDocumentProvider() {
		if(usecaseDocumentProvider == null) {
			usecaseDocumentProvider = new UMLUseCaseDiagramDocumentProvider();
		}
		return usecaseDocumentProvider;
	}
}
