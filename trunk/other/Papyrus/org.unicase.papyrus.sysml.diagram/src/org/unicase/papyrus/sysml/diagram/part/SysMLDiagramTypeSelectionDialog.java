package org.unicase.papyrus.sysml.diagram.part;

import org.eclipse.swt.widgets.Shell;
import org.eclipse.ui.dialogs.ElementListSelectionDialog;
import org.unicase.papyrus.SysMLDiagramType;

public class SysMLDiagramTypeSelectionDialog extends ElementListSelectionDialog {
	
	private static SysMLDiagramType[] diagramTypes;
	
	public SysMLDiagramTypeSelectionDialog(Shell shell) {
		super(shell, new SysMLDiagramTypeLabelProvider());
		setTitle("Choose the type of the diagram.");
		setElements(getDiagramTypes());
	}
	
	private SysMLDiagramType[] getDiagramTypes() {
		if(diagramTypes == null) {
			diagramTypes = new SysMLDiagramType[] {
					SysMLDiagramType.PARAMETRIC,
					SysMLDiagramType.BLOCK_DEFINITION,
					SysMLDiagramType.REQUIREMENT,
					SysMLDiagramType.INTERNAL_BLOCK
			};
		}
		return diagramTypes;
	}
	
}
