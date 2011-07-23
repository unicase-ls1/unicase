package org.unicase.exportbb.commands;

import org.eclipse.core.commands.AbstractHandler;
import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.commands.ExecutionException;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.MessageBox;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.handlers.HandlerUtil;
import org.unicase.model.UnicaseModelElement;
import org.unicase.model.impl.UnicaseModelElementImpl;
import org.unicase.model.meeting.Meeting;
import org.unicase.workspace.util.UnicaseCommand;

/**
 * @author Carmen Carlan
 *
 */
public class ExportBBCode extends AbstractHandler {

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
		if (((Meeting)modelElement).getEndtime() == null){
			MessageBox messageBox = new MessageBox(shell, SWT.CANCEL | SWT.ICON_ERROR | SWT.CENTER);
			messageBox.setMessage("The meeting could not be exported. Please insert the end time.");
			messageBox.setText("Warning!");
			messageBox.open();
		}
		else 
		new UnicaseCommand() {
			@Override
			protected void doRun() {
				ExportDialog dialog;
				dialog = new ExportDialog(shell,
					modelElement);
				dialog.open();	
			}
		}.run();
		return null;
	}
}
