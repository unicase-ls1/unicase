package org.unicase.docExport.commands;

import org.eclipse.core.commands.AbstractHandler;
import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.commands.ExecutionException;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.handlers.HandlerUtil;
import org.unicase.docExport.exceptions.TemplateSaveException;
import org.unicase.docExport.exportModel.renderers.defaultRenderers.DefaultRenderersFactory;
import org.unicase.model.ModelElement;
import org.unicase.model.impl.ModelElementImpl;
import org.unicase.workspace.util.WorkspaceUtil;



/**
 * 
 * @author Sebastian Höcht
 *
 */
public class ExportDocument extends AbstractHandler {

	/**
	 * {@inheritDoc}
	 */
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
		if (!(o instanceof ModelElement)) {
			return null;
		}
		
		ModelElementImpl modelElement = (ModelElementImpl) o;
		
	    Shell shell = PlatformUI.getWorkbench().getDisplay().getActiveShell();
	    
		try {
			ExportDialog dialog = new ExportDialog(
					shell, 
					DefaultRenderersFactory.eINSTANCE.createDefaultDocumentRenderer(),
					modelElement
				);
			dialog.open();
		} catch (TemplateSaveException e) {
			WorkspaceUtil.log(
					"Couln't load/create any template.",
					e,
					IStatus.ERROR
				);
		}

		return null;
		
	}
}
