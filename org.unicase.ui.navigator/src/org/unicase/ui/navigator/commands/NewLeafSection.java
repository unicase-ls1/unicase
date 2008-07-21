package org.unicase.ui.navigator.commands;

import org.eclipse.core.commands.AbstractHandler;
import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.commands.ExecutionException;
import org.eclipse.emf.transaction.RecordingCommand;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.ui.handlers.HandlerUtil;
import org.unicase.model.document.CompositeSection;
import org.unicase.model.document.DocumentFactory;
import org.unicase.model.document.LeafSection;
import org.unicase.workspace.WorkspaceManager;

public class NewLeafSection extends AbstractHandler {

	public Object execute(ExecutionEvent event) throws ExecutionException {
		// JH: put this in Helper
		ISelection sel = HandlerUtil.getCurrentSelection(event);
		if (!(sel instanceof IStructuredSelection)) {
			return null;
		}
		IStructuredSelection ssel = (IStructuredSelection) sel;
		if (ssel.isEmpty()) {
			return null;
		}

		Object o = ssel.getFirstElement();
		if (!(o instanceof CompositeSection)) {
			return null;
		}
		final CompositeSection compositeSection = (CompositeSection) o;

		final LeafSection createLeafSection = DocumentFactory.eINSTANCE
				.createLeafSection();
		
		createLeafSection.setName("new leaf section");

		TransactionalEditingDomain domain = WorkspaceManager.getInstance()
				.getCurrentWorkspace().getEditingDomain();
		domain.getCommandStack().execute(new RecordingCommand(domain) {

			@Override
			protected void doExecute() {
				compositeSection.getSubsections().add(createLeafSection);
			}
		});
		
		ActionHelper.openModelElement(createLeafSection);

		return null;
	}

}
