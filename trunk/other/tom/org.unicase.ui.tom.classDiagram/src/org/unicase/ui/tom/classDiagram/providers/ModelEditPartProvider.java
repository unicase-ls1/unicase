package org.unicase.ui.tom.classDiagram.providers;

import java.lang.ref.WeakReference;

import org.eclipse.gef.EditPart;
import org.eclipse.gef.EditPartFactory;
import org.eclipse.gef.EditPartViewer;
import org.eclipse.gmf.runtime.common.core.service.IOperation;
import org.eclipse.gmf.runtime.diagram.ui.editparts.IGraphicalEditPart;
import org.eclipse.gmf.runtime.diagram.ui.services.editpart.AbstractEditPartProvider;
import org.eclipse.gmf.runtime.diagram.ui.services.editpart.CreateGraphicEditPartOperation;
import org.eclipse.gmf.runtime.diagram.ui.services.editpart.IEditPartOperation;
import org.eclipse.gmf.runtime.notation.Diagram;
import org.eclipse.gmf.runtime.notation.View;
import org.unicase.model.classDiagram.part.ModelDiagramEditor;
import org.unicase.ui.tom.TouchController;

/**
 * @generated
 */
public class ModelEditPartProvider extends org.unicase.model.classDiagram.providers.ModelEditPartProvider {

	/**
	 * @generated
	 */
	public ModelEditPartProvider() {
		super();
		setFactory(new org.unicase.ui.tom.classDiagram.edit.parts.ModelEditPartFactory());
	}

}
