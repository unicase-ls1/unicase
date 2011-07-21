package org.unicase.exportwp.commands;

import org.eclipse.core.commands.AbstractHandler;
import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.commands.ExecutionException;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.handlers.HandlerUtil;
import org.unicase.model.UnicaseModelElement;
import org.unicase.model.impl.UnicaseModelElementImpl;
import org.unicase.workspace.util.UnicaseCommand;

public class ExportWP extends AbstractHandler{

	public Object execute(ExecutionEvent event) throws ExecutionException {
		ISelection sel = HandlerUtil.getCurrentSelection(event);
		if (!(sel instanceof IStructuredSelection)) {
			return null;
		}
		IStructuredSelection ssel = (IStructuredSelection) sel;
		if (ssel.isEmpty()) {
			return null;
		}
		Object o = ssel.getFirstElement();
		if (!(o instanceof UnicaseModelElement)) {
			return null;
		}
		final UnicaseModelElementImpl modelElement = (UnicaseModelElementImpl) o;

		final Shell shell = PlatformUI.getWorkbench().getDisplay().getActiveShell();
		new UnicaseCommand() {
			@Override
			protected void doRun() {
				EportWPDialog dialog;
				dialog = new EportWPDialog(shell,
					modelElement);
				dialog.open();
			}
		}.run();
//		createFile();
		return null;
	}

}