/**
 * <copyright> Copyright (c) 2015-2016 Chair of Applied Software Engineering, Technische Universität München (TUM).
 * All rights reserved. This program and the accompanying materials are made available under the terms of
 * the Eclipse Public License v1.0 which accompanies this distribution,
 * and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>
 */
package org.unicase.ui.diagram.componentDiagram.part;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.transaction.util.TransactionUtil;
import org.eclipse.gef.EditPartViewer;
import org.eclipse.gmf.runtime.common.ui.services.action.contributionitem.ContributionItemService;
import org.eclipse.gmf.runtime.diagram.ui.actions.ActionIds;
import org.eclipse.gmf.runtime.diagram.ui.providers.DiagramContextMenuProvider;
import org.eclipse.jface.action.IMenuManager;
import org.eclipse.ui.IWorkbenchPart;

/**
 * @generated
 */
public class DiagramEditorContextMenuProvider extends
		DiagramContextMenuProvider {

	/**
	 * @generated
	 */
	private IWorkbenchPart part;

	/**
	 * @generated
	 */
	private org.unicase.ui.diagram.componentDiagram.part.DeleteElementAction deleteAction;

	/**
	 * @generated
	 */
	public DiagramEditorContextMenuProvider(IWorkbenchPart part,
			EditPartViewer viewer) {
		super(part, viewer);
		this.part = part;
		deleteAction = new org.unicase.ui.diagram.componentDiagram.part.DeleteElementAction(
				part);
		deleteAction.init();
	}

	/**
	 * @generated
	 */
	public void dispose() {
		if (deleteAction != null) {
			deleteAction.dispose();
			deleteAction = null;
		}
		super.dispose();
	}

	/**
	 * @generated
	 */
	public void buildContextMenu(final IMenuManager menu) {
		getViewer().flush();
		try {
			TransactionUtil.getEditingDomain(
					(EObject) getViewer().getContents().getModel())
					.runExclusive(new Runnable() {

						public void run() {
							ContributionItemService
									.getInstance()
									.contributeToPopupMenu(
											DiagramEditorContextMenuProvider.this,
											part);
							menu.remove(ActionIds.ACTION_DELETE_FROM_MODEL);
							menu.appendToGroup("editGroup", deleteAction);
						}
					});
		} catch (Exception e) {
			org.unicase.ui.diagram.componentDiagram.part.ModelDiagramEditorPlugin
					.getInstance().logError("Error building context menu", e);
		}
	}
}
