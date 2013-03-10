package org.unicase.uiModeling.diagram.edit.policies;

import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.gef.commands.Command;
import org.eclipse.gmf.runtime.diagram.ui.editparts.IGraphicalEditPart;
import org.eclipse.gmf.runtime.emf.commands.core.commands.DuplicateEObjectsCommand;
import org.eclipse.gmf.runtime.emf.type.core.requests.CreateElementRequest;
import org.eclipse.gmf.runtime.emf.type.core.requests.DuplicateElementsRequest;

/**
 * @generated
 */
public class PanelItemSemanticEditPolicy extends
	org.unicase.uiModeling.diagram.edit.policies.UiModelingBaseItemSemanticEditPolicy {

	/**
	 * @generated
	 */
	public PanelItemSemanticEditPolicy() {
		super(org.unicase.uiModeling.diagram.providers.UiModelingElementTypes.Panel_45);
	}

	/**
	 * @generated
	 */
	protected Command getCreateCommand(CreateElementRequest req) {
		if (org.unicase.uiModeling.diagram.providers.UiModelingElementTypes.Window_2003 == req.getElementType()) {
			return getGEFWrapper(new org.unicase.uiModeling.diagram.edit.commands.WindowCreateCommand(req));
		}
		if (org.unicase.uiModeling.diagram.providers.UiModelingElementTypes.Label_2004 == req.getElementType()) {
			return getGEFWrapper(new org.unicase.uiModeling.diagram.edit.commands.LabelCreateCommand(req));
		}
		if (org.unicase.uiModeling.diagram.providers.UiModelingElementTypes.TextField_2005 == req.getElementType()) {
			return getGEFWrapper(new org.unicase.uiModeling.diagram.edit.commands.TextFieldCreateCommand(req));
		}
		if (org.unicase.uiModeling.diagram.providers.UiModelingElementTypes.Button_2006 == req.getElementType()) {
			return getGEFWrapper(new org.unicase.uiModeling.diagram.edit.commands.ButtonCreateCommand(req));
		}
		if (org.unicase.uiModeling.diagram.providers.UiModelingElementTypes.Text_2007 == req.getElementType()) {
			return getGEFWrapper(new org.unicase.uiModeling.diagram.edit.commands.TextCreateCommand(req));
		}
		if (org.unicase.uiModeling.diagram.providers.UiModelingElementTypes.Image_2008 == req.getElementType()) {
			return getGEFWrapper(new org.unicase.uiModeling.diagram.edit.commands.ImageCreateCommand(req));
		}
		if (org.unicase.uiModeling.diagram.providers.UiModelingElementTypes.RadioGroup_2009 == req.getElementType()) {
			return getGEFWrapper(new org.unicase.uiModeling.diagram.edit.commands.RadioGroupCreateCommand(req));
		}
		if (org.unicase.uiModeling.diagram.providers.UiModelingElementTypes.CheckboxGroup_2010 == req.getElementType()) {
			return getGEFWrapper(new org.unicase.uiModeling.diagram.edit.commands.CheckboxGroupCreateCommand(req));
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
