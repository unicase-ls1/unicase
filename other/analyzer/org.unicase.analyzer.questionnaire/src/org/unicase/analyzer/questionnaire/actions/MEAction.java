/**
 * 
 */
package org.unicase.analyzer.questionnaire.actions;

import java.io.IOException;
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
import org.unicase.workspace.ProjectSpace;
import org.unicase.workspace.WorkspaceFactory;
import org.unicase.workspace.util.ResourceHelper;

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
		int user = QuestionnaireManager.getInstance().getUser();

		String projectFileName = DIR + user + "/projectstate-" + version + ".ups";
		String changeFileName = DIR + user + "/changepackage-" + version + ".ucp";

		String preProjectFileName = DIR + user + "/projectstate-" + (version - 1) + ".ups";

		try {
			Project project = ResourceHelper.getElementFromResource(projectFileName, Project.class, 0);
			ProjectSpace projectSpace = WorkspaceFactory.eINSTANCE.createProjectSpace();
			projectSpace.setProject(project);
			ChangePackage changePackage = ResourceHelper.getElementFromResource(changeFileName, ChangePackage.class, 0);
			Set<ModelElementId> ids = changePackage.getAllInvolvedModelElements();
			List<ModelElementId> idList = new ArrayList<ModelElementId>(ids);

			Random rand = new Random();
			ModelElementId id = idList.get(rand.nextInt(idList.size()));

			ModelElement leftME = project.getModelElement(id);

			Project preProject = ResourceHelper.getElementFromResource(preProjectFileName, Project.class, 0);
			ProjectSpace preProjectSpace = WorkspaceFactory.eINSTANCE.createProjectSpace();
			preProjectSpace.setProject(preProject);

			ModelElement rightME = preProject.getModelElement(id);

			if (activeEditor != null) {
				activeEditor.getSite().getPage().closeAllEditors(false);
			}

			boolean left = rand.nextBoolean();
			if (left) {
				ActionHelper.openModelElement(leftME, "HAHA");// after commit
				ActionHelper.openModelElement(rightME, "HAHA");// before commit
			} else {
				ActionHelper.openModelElement(rightME, "HAHA");// before commit
				ActionHelper.openModelElement(leftME, "HAHA");// after commit
			}

			activeEditor = PlatformUI.getWorkbench().getActiveWorkbenchWindow().getActivePage().getActiveEditor();

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	/**
	 * @see org.eclipse.ui.IActionDelegate#selectionChanged(org.eclipse.jface.action.IAction,
	 *      org.eclipse.jface.viewers.ISelection)
	 */
	public void selectionChanged(IAction action, ISelection selection) {
		// TODO Auto-generated method stub

	}

}
