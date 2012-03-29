/**
 * <copyright> Copyright (c) 2009-2012 Chair of Applied Software Engineering, Technische Universität München (TUM).
* All rights reserved. This program and the accompanying materials are made available under the terms of
* the Eclipse Public License v1.0 which accompanies this distribution,
* and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>
 */
package org.unicase.ui.diagram.activityDiagram.part;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.gmf.runtime.diagram.ui.editparts.DiagramEditPart;
import org.eclipse.gmf.runtime.diagram.ui.resources.editor.parts.DiagramDocumentEditor;
import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.ui.IEditorPart;
import org.eclipse.ui.PlatformUI;
import org.unicase.model.diagram.MEDiagram;
import org.unicase.ui.unicasecommon.diagram.util.EditPartUtility;

/**
 * @author schroech, denglerm
 */
public class DiagramTypeTester extends org.unicase.ui.unicasecommon.diagram.part.DiagramTypeTester {

	/**
	 * @see org.eclipse.core.expressions.IPropertyTester#test(java.lang.Object, java.lang.String, java.lang.Object[],
	 *      java.lang.Object)
	 * @param receiver The EObject to test
	 * @param property The "type" property
	 * @param args Additional arguments ignored by this tester
	 * @param expectedValue the expected value of the property. Can be any literal value defined in DiagramType
	 * @return Returns <code>true</code> if receiver can appear on a component diagram.
	 */
	@Override
	public boolean test(Object receiver, String property, Object[] args, Object expectedValue) {
		if (receiver instanceof MEDiagram) {
			return super.test(receiver, property, args, expectedValue);
		}
		View view = null;
		IEditorPart iep = PlatformUI.getWorkbench().getActiveWorkbenchWindow().getActivePage().getActiveEditor();
		if (iep instanceof DiagramDocumentEditor) {
			DiagramDocumentEditor dde = (DiagramDocumentEditor) iep;
			DiagramEditPart editPart = dde.getDiagramEditPart();
			view = EditPartUtility.getView(editPart);
		}
		if (ModelVisualIDRegistry.getNodeVisualID(view, (EObject) receiver) != -1) {
			return true;
		}
		return false;
	}
}
