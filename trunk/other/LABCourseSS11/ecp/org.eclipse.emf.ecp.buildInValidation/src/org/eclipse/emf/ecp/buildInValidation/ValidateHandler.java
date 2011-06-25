package org.eclipse.emf.ecp.buildInValidation;

import java.util.Iterator;

import org.eclipse.core.commands.AbstractHandler;
import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.commands.ExecutionException;
import org.eclipse.emf.common.util.Diagnostic;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.util.Diagnostician;
import org.eclipse.emf.ecp.common.commands.ECPCommand;
import org.eclipse.emf.ecp.common.model.ECPWorkspaceManager;
import org.eclipse.emf.ecp.common.model.NoWorkspaceException;
import org.eclipse.emf.ecp.common.util.DialogHandler;
import org.eclipse.emf.ecp.common.util.UiUtil;
import org.eclipse.ui.IWorkbenchPage;
import org.eclipse.ui.PartInitException;
import org.eclipse.ui.PlatformUI;


/**
 * @author Haunolder
 *
 */
public class ValidateHandler extends AbstractHandler {

	private Diagnostic diagnostic; 
	
	/**
	 * {@inheritDoc}
	 */
	public Object execute(ExecutionEvent event) throws ExecutionException {
		
		
		// the object that is to be validated
		EObject toValidate = UiUtil.getModelElement(event);
		
		try {
			if (ECPWorkspaceManager.getInstance().getWorkSpace().isRootObject(toValidate)) {
				toValidate = ECPWorkspaceManager.getInstance().getWorkSpace().getActiveProject().getRootContainer();
			}
		} catch (NoWorkspaceException e) {
			return null;
		}
	
		// if still null, do nothing, otherwise trigger validation run
		if (toValidate != null) {
			final EObject validate = toValidate;
			new ECPCommand(validate) {
				@Override
				protected void doRun() {
					validateWithoutCommand(validate);
				}
			}.run(false);
		}
		// validation occurred and the validation view is being instantiated 
		IWorkbenchPage page = PlatformUI.getWorkbench().getActiveWorkbenchWindow().getActivePage();
		
		try {
			ValidationView validationView = (ValidationView) page.showView("org.eclipse.emf.ecp.validation.validationView");
			//validationView.updateTable(diagnostic);
		} catch (PartInitException e) {
			DialogHandler.showExceptionDialog(e);
		}
		
		
		return null;
	}
	
	/**
	 * Perform validation run.
	 * 
	 * @param object the
	 */
	public void validateWithoutCommand(EObject object) {
		System.out.println("IM BUILD IN VALIDTE HANDLER");
		 diagnostic = Diagnostician.INSTANCE.validate(object);
		if (diagnostic.getSeverity() == Diagnostic.ERROR || diagnostic.getSeverity() == Diagnostic.WARNING) {
			System.err.println(diagnostic.getMessage());
			System.out.println (diagnostic.getChildren().toString());
			for (Iterator<Diagnostic> i = diagnostic.getChildren().iterator(); i.hasNext();) {
				Diagnostic childDiagnostic = (Diagnostic) i.next();
				switch (childDiagnostic.getSeverity()) {
				case Diagnostic.ERROR:
				case Diagnostic.WARNING:
						System.err.println("\t" + childDiagnostic.getMessage());
				default:
					break;
				}
			}
		}
	}

}
