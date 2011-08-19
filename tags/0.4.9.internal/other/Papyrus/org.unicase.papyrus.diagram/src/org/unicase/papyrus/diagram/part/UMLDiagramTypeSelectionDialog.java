package org.unicase.papyrus.diagram.part;

import org.eclipse.swt.widgets.Shell;
import org.eclipse.ui.dialogs.ElementListSelectionDialog;
import org.unicase.papyrus.UMLDiagramType;

public class UMLDiagramTypeSelectionDialog extends ElementListSelectionDialog {
	
	private static UMLDiagramType[] diagramTypes;
	
	public UMLDiagramTypeSelectionDialog(Shell shell) {
		super(shell, new UMLDiagramTypeLabelProvider());
		setTitle("Choose the type of the diagram.");
		setElements(getDiagramTypes());
	}
	
	private UMLDiagramType[] getDiagramTypes() {
		if(diagramTypes == null) {
			diagramTypes = new UMLDiagramType[] {
					UMLDiagramType.ACTIVITY,
					UMLDiagramType.CLASS,
					UMLDiagramType.COMMUNICATION,
					UMLDiagramType.COMPOSITE,
					UMLDiagramType.SEQUENCE,
					UMLDiagramType.STATE_MACHINE,
					UMLDiagramType.USE_CASE
			};
		}
		return diagramTypes;
	}
	
}
