/**
 * 
 */
package org.unicase.analyzer.questionnaire.actions;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Set;

import org.eclipse.jface.action.IAction;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.ui.IEditorPart;
import org.eclipse.ui.IWorkbenchWindow;
import org.eclipse.ui.IWorkbenchWindowActionDelegate;
import org.eclipse.ui.PlatformUI;
import org.unicase.analyzer.questionnaire.wizards.QuestionnaireManager;
import org.unicase.emfstore.esmodel.versioning.ChangePackage;
import org.unicase.model.ModelElement;
import org.unicase.model.ModelElementId;
import org.unicase.model.Project;
import org.unicase.ui.common.util.ActionHelper;
import org.unicase.workspace.Configuration;

/**
 * @author liya
 */
public class MEAction implements IWorkbenchWindowActionDelegate {

	private static final String DIR = Configuration.getWorkspaceDirectory();
	private IEditorPart activeEditor;

	/**
	 * @see org.eclipse.ui.IWorkbenchWindowActionDelegate#dispose()
	 */
	public void dispose() {
		// TODO Auto-generated method stub

	}

	/**
	 * @see org.eclipse.ui.IWorkbenchWindowActionDelegate#init(org.eclipse.ui.IWorkbenchWindow)
	 */
	public void init(IWorkbenchWindow window) {
		// TODO Auto-generated method stub

	}

	/**
	 * @see org.eclipse.ui.IActionDelegate#run(org.eclipse.jface.action.IAction)
	 */
	public void run(IAction action) {
		int version = QuestionnaireManager.getInstance().getVersion();
		int folder = QuestionnaireManager.getInstance().getFolder();

		Project project = QuestionnaireManager.getInstance().getProject();
		ChangePackage changePackage = QuestionnaireManager.getInstance().getChangePackage();
		Set<ModelElementId> ids = changePackage.getAllInvolvedModelElements();
		List<ModelElementId> idList = new ArrayList<ModelElementId>(ids);

		Random rand = new Random();
		ModelElementId id = idList.get(rand.nextInt(idList.size()));

		ModelElement leftME = project.getModelElement(id);

		Project preProject = QuestionnaireManager.getInstance().getPreProject();

		ModelElement rightME = preProject.getModelElement(id);

		if (activeEditor != null) {
			activeEditor.getSite().getPage().closeAllEditors(false);
		}

		boolean left = rand.nextBoolean();
		QuestionnaireManager.getInstance().setLeft(left);
		if (left) {
			ActionHelper.openModelElement(leftME, "HAHA");// after commit
			ActionHelper.openModelElement(rightME, "HAHA");// before commit
		} else {
			ActionHelper.openModelElement(rightME, "HAHA");// before commit
			ActionHelper.openModelElement(leftME, "HAHA");// after commit
		}

		activeEditor = PlatformUI.getWorkbench().getActiveWorkbenchWindow().getActivePage().getActiveEditor();
	}

	/**
	 * @see org.eclipse.ui.IActionDelegate#selectionChanged(org.eclipse.jface.action.IAction,
	 *      org.eclipse.jface.viewers.ISelection)
	 */
	public void selectionChanged(IAction action, ISelection selection) {
		// TODO Auto-generated method stub

	}

}
