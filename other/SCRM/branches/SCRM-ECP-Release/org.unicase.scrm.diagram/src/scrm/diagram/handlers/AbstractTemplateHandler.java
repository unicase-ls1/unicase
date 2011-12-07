package scrm.diagram.handlers;

import org.eclipse.core.commands.AbstractHandler;
import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.commands.ExecutionException;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.ui.handlers.HandlerUtil;

import scrm.diagram.common.TemplateManager;

public abstract class AbstractTemplateHandler extends AbstractHandler {
	
	private static final String[] templateFileExtensions = new String[] {"*.*"};

	protected <T> T getInstanceOfClass(ExecutionEvent event, Class<T> clazz) {
		Object selectedElement = getSelectedElement(event);
		if(clazz.isInstance(selectedElement)) {
			return clazz.cast(selectedElement);
		}
		return null;
	}
	
	/**
	 * Obtains a SCRMDiagram by checking if one was selected. If no SCRMDiagram was
	 * selected, checks if the active editor is actually a diagram editor.
	 * If so, the Diagrams container, which is a SCRMDiagram, is returned.
	 * If none of the above holds, throws an IllegalArgumentException, as this
	 * Handler was falsely called. 
	 * 
	 * @param event an event containing all the information about the current 
	 * state of the application
	 * @return the properly obtained SCRMDiagram
	 * @throws ExecutionException if an exception occurred during the execution
	 */
	protected Object getSelectedElement(ExecutionEvent event) {
		
		ISelection selection = HandlerUtil.getCurrentSelection(event);
		
		// check if a SCRMDiagram was selected		
		IStructuredSelection ssel;
		if (selection != null && selection instanceof IStructuredSelection) {
			ssel = (IStructuredSelection) selection;
			if (!ssel.isEmpty()) {
				return ssel.getFirstElement();
			}
		}
		
		throw new IllegalArgumentException("Selection is invalid!");
	}
	
	protected String[] getTemplateFileExtensions() {
		return templateFileExtensions;
	}
	
	protected abstract TemplateManager getTemplateManager();
	
}
