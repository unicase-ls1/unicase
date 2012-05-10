/**
 * <copyright> Copyright (c) 2009-2012 Chair of Applied Software Engineering, Technische Universität München (TUM).
 * All rights reserved. This program and the accompanying materials are made available under the terms of
 * the Eclipse Public License v1.0 which accompanies this distribution,
 * and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>
 */
package org.unicase.papyrus.sysml.diagram.part;

import org.eclipse.swt.widgets.Shell;
import org.eclipse.ui.dialogs.ElementListSelectionDialog;
import org.unicase.papyrus.SysMLDiagramType;

/**
 * Dialog which lets the user select a diagram type for Papyrus SysML diagrams.
 * 
 * @author mharut
 */
public class SysMLDiagramTypeSelectionDialog extends ElementListSelectionDialog {

	private static SysMLDiagramType[] diagramTypes;

	/**
	 * Creates a new dialog for a certain shell.
	 * 
	 * @param shell the parent widget
	 */
	public SysMLDiagramTypeSelectionDialog(Shell shell) {
		super(shell, new SysMLDiagramTypeLabelProvider());
		setTitle("Choose the type of the diagram.");
		setElements(getDiagramTypes());
	}

	private SysMLDiagramType[] getDiagramTypes() {
		if (diagramTypes == null) {
			diagramTypes = new SysMLDiagramType[] { SysMLDiagramType.PARAMETRIC, SysMLDiagramType.BLOCK_DEFINITION,
				SysMLDiagramType.REQUIREMENT, SysMLDiagramType.INTERNAL_BLOCK };
		}
		return diagramTypes;
	}

}
