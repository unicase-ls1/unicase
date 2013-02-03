package org.unicase.wireframe.diagram.edit.policies;

import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.gef.commands.Command;
import org.eclipse.gmf.runtime.diagram.ui.editparts.IGraphicalEditPart;
import org.eclipse.gmf.runtime.emf.commands.core.commands.DuplicateEObjectsCommand;
import org.eclipse.gmf.runtime.emf.type.core.requests.CreateElementRequest;
import org.eclipse.gmf.runtime.emf.type.core.requests.DuplicateElementsRequest;
import org.unicase.wireframe.diagram.edit.commands.ButtonCreateCommand;
import org.unicase.wireframe.diagram.edit.commands.ImageCreateCommand;
import org.unicase.wireframe.diagram.edit.commands.LabelCreateCommand;
import org.unicase.wireframe.diagram.edit.commands.TextCreateCommand;
import org.unicase.wireframe.diagram.edit.commands.TextFieldCreateCommand;
import org.unicase.wireframe.diagram.edit.commands.WindowCreateCommand;
import org.unicase.wireframe.diagram.providers.WireframeElementTypes;

/**
 * @generated
 */
public class PanelItemSemanticEditPolicy extends WireframeBaseItemSemanticEditPolicy {

	/**
	 * @generated
	 */
	public PanelItemSemanticEditPolicy() {
		super(WireframeElementTypes.Panel_45);
	}

	/**
	 * @generated
	 */
	protected Command getCreateCommand(CreateElementRequest req) {
		if (WireframeElementTypes.Window_2003 == req.getElementType()) {
			return getGEFWrapper(new WindowCreateCommand(req));
		}
		if (WireframeElementTypes.Label_2004 == req.getElementType()) {
			return getGEFWrapper(new LabelCreateCommand(req));
		}
		if (WireframeElementTypes.TextField_2005 == req.getElementType()) {
			return getGEFWrapper(new TextFieldCreateCommand(req));
		}
		if (WireframeElementTypes.Button_2006 == req.getElementType()) {
			return getGEFWrapper(new ButtonCreateCommand(req));
		}
		if (WireframeElementTypes.Text_2007 == req.getElementType()) {
			return getGEFWrapper(new TextCreateCommand(req));
		}
		if (WireframeElementTypes.Image_2008 == req.getElementType()) {
			return getGEFWrapper(new ImageCreateCommand(req));
		}
		return super.getCreateCommand(req);
	}

	/**
	 * @generated
	 */
	protected Command getDuplicateCommand(DuplicateElementsRequest req) {
		TransactionalEditingDomain editingDomain = ((IGraphicalEditPart) getHost()).getEditingDomain();
		return getGEFWrapper(new DuplicateAnythingCommand(editingDomain, req));
	}

	/**
	 * @generated
	 */
	private static class DuplicateAnythingCommand extends DuplicateEObjectsCommand {

		/**
		 * @generated
		 */
		public DuplicateAnythingCommand(TransactionalEditingDomain editingDomain, DuplicateElementsRequest req) {
			super(editingDomain, req.getLabel(), req.getElementsToBeDuplicated(), req.getAllDuplicatedElementsMap());
		}

	}

}
