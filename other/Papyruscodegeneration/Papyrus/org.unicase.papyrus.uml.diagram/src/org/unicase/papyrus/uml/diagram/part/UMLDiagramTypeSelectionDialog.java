/**
 * <copyright> Copyright (c) 2009-2012 Chair of Applied Software Engineering, Technische Universität München (TUM).
 * All rights reserved. This program and the accompanying materials are made available under the terms of
 * the Eclipse Public License v1.0 which accompanies this distribution,
 * and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>
 */
package org.unicase.papyrus.uml.diagram.part;

import org.eclipse.swt.widgets.Shell;
import org.eclipse.ui.dialogs.ElementListSelectionDialog;
import org.unicase.papyrus.UMLDiagramType;

/**
 * Dialog which lets the user select a diagram type for Papyrus UML diagrams.
 * 
 * @author mharut
 */
public class UMLDiagramTypeSelectionDialog extends ElementListSelectionDialog {

	private static UMLDiagramType[] diagramTypes;

	/**
	 * Creates a new dialog for a certain shell.
	 * 
	 * @param shell the parent widget
	 */
	public UMLDiagramTypeSelectionDialog(Shell shell) {
		super(shell, new UMLDiagramTypeLabelProvider());
		setTitle("Choose the type of the diagram.");
		setElements(getDiagramTypes());
	}

	private UMLDiagramType[] getDiagramTypes() {
		if (diagramTypes == null) {
			diagramTypes = new UMLDiagramType[] { UMLDiagramType.ACTIVITY, UMLDiagramType.CLASS,
				UMLDiagramType.COMMUNICATION, UMLDiagramType.COMPOSITE, UMLDiagramType.SEQUENCE,
				UMLDiagramType.STATE_MACHINE, UMLDiagramType.USE_CASE, UMLDiagramType.PACKAGE };
		}
		return diagramTypes;
	}

}
