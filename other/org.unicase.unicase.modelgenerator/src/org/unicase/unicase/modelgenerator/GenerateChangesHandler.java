package org.unicase.unicase.modelgenerator;

import org.eclipse.core.commands.AbstractHandler;
import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.commands.ExecutionException;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.ui.handlers.HandlerUtil;
import org.unicase.metamodel.Project;
import org.unicase.modelchanger.ModelChanger;
import org.unicase.modelgenerator.common.ModelGeneratorConfiguration;
import org.unicase.modelgenerator.common.ModelGeneratorUtil;
import org.unicase.workspace.ProjectSpace;
import org.unicase.workspace.WorkspaceManager;
import org.unicase.workspace.util.UnicaseCommand;

public class GenerateChangesHandler extends AbstractHandler {

	public Object execute(ExecutionEvent event) throws ExecutionException {
		
		final String modelKey = "http://unicase.org/model";
		
		ISelection selection = HandlerUtil.getCurrentSelection(event);
		final IStructuredSelection strucSel = (IStructuredSelection)selection;
		final ProjectSpace ps = (ProjectSpace) strucSel.getFirstElement();
		
		
		new UnicaseCommand() {
			@Override
			protected void doRun() {
				final EPackage pckge = ModelGeneratorUtil.getEPackage(modelKey);
				ModelGeneratorConfiguration config = new ModelGeneratorConfiguration(pckge, ps.getProject(), 5, 2);
				ModelChanger.generateChanges(config);
			}
		}.run(false);

		return null;
	}
}
