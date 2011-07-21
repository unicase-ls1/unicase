/**
 * 
 */
package org.unicase.ui.tracerecovery;

import org.eclipse.core.resources.IFolder;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IWorkspaceRoot;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.IPath;
import org.eclipse.jdt.core.IJavaProject;
import org.eclipse.jdt.internal.core.CompilationUnit;
import org.eclipse.jdt.internal.core.PackageFragment;
import org.eclipse.jdt.internal.core.PackageFragmentRoot;
import org.eclipse.jface.action.IAction;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.wizard.IWizard;
import org.eclipse.jface.wizard.Wizard;
import org.eclipse.jface.wizard.WizardDialog;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.ui.IViewActionDelegate;
import org.eclipse.ui.IViewPart;
import org.eclipse.ui.IWorkbench;
import org.eclipse.ui.IWorkbenchWindow;
import org.eclipse.ui.PlatformUI;
import org.unicase.metamodel.Project;
import org.unicase.ui.traceRecvoery.pages.RunRecovery;
import org.unicase.ui.traceRecvoery.pages.SearchResult;
import org.unicase.ui.traceRecvoery.pages.SelecDirectory;
import org.unicase.ui.traceRecvoery.pages.SelectDirectoryJava;
import org.unicase.workspace.ProjectSpace;
import org.unicase.workspace.WorkspaceManager;

/**
 * @author taher
 * 
 */
public class TraceRecoveryWizard extends Wizard implements IWizard,
		IViewActionDelegate {

	Project project;
	IPath pat;

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.eclipse.jface.wizard.Wizard#performFinish()
	 */
	@Override
	public boolean performFinish() {
		// TODO Auto-generated method stub
		return false;
	}

	/**
	 * @return the project
	 */
	public Project getProject() {
		return project;
	}

	/**
	 * @param project
	 *            the project to set
	 */
	public void setProject(Project project) {
		this.project = project;
	}

	boolean bol;

	/**
	 * add pages to the wizards
	 */
	@Override
	public void addPages() {
		// if (bol) {
		setWindowTitle("Run Recovery");

		if (producer.equals("unicase")) {
			SelecDirectory dir = new SelecDirectory();
			addPage(dir);
			dir.setProject(getActiveProject());
		} else if (producer == "java") {
			SelectDirectoryJava dir = new SelectDirectoryJava();
			addPage(dir);
			dir.setProject(getActiveProject());
			dir.setLastPath(pat.toPortableString());

		} else if (producer == "fortran") {

		}

		RunRecovery recovery = new RunRecovery();

		SearchResult result = new SearchResult();

		recovery.setP(getActiveProject());
		result.setP(getActiveProject());

		addPage(recovery);
		addPage(result);

		// }else {
		// RunRecovery recovery = new RunRecovery();
		// recovery.setP(getActiveProject());

		// addPage(recovery);
		// }

	}

	public void addPages(boolean bol) {

		this.bol = bol;
		super.getPage("SelectDirectory");

	}

	/**
	 * this will return the chosen Unicase project.
	 * 
	 * @return
	 */
	public static Project getActiveProject() {
		ProjectSpace ps = WorkspaceManager.getInstance().getCurrentWorkspace()
				.getActiveProjectSpace();
		if (ps == null) {
			return null;
		}
		if (ps.getProject() != null) {
			return ps.getProject();
		}
		return null;
	}

	String producer;

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.eclipse.ui.IActionDelegate#run(org.eclipse.jface.action.IAction)
	 */
	@SuppressWarnings("restriction")
	@Override
	public void run(IAction action) {

		TraceRecoveryWizard wizard = new TraceRecoveryWizard();

		Object parent;
		if (action.getId().toLowerCase().equals("unicase")) {
			wizard.producer = "unicase";
		} else if (action.getId().toLowerCase().equals("java")) {

			wizard.producer = "java";

			IWorkbenchWindow window = PlatformUI.getWorkbench()
					.getActiveWorkbenchWindow();

			IStructuredSelection selection = (IStructuredSelection) window
					.getSelectionService().getSelection(
							"org.eclipse.jdt.ui.PackageExplorer");

			parent = selection.getFirstElement();

			parent.getClass();
			boolean havePath = false;
			IPath path = null;
			if (parent instanceof IJavaProject) {

				IJavaProject p = (IJavaProject) parent;
				
				IProject project = p.getProject();
				wizard.pat = project.getLocation();
				havePath = true;
				

			} else if (parent instanceof PackageFragmentRoot) {

				path = ((PackageFragmentRoot) parent).getPath();

				

			} else if (parent instanceof PackageFragment) {
				path = ((PackageFragment) parent).getPath();

			}

			else if (parent instanceof CompilationUnit) {
				path = ((CompilationUnit) parent).getPath();
			}
			
			if(!havePath){
			IWorkspaceRoot root = ResourcesPlugin.getWorkspace().getRoot();
			IFolder folder = root.getFolder(path);
			wizard.pat = folder.getLocation();
			havePath = true;
			}
		} else if (action.getId().toLowerCase().equals("fortran")) {
			wizard.producer = "fortran";

		}

		project = getActiveProject();
		if (project != null) {

			// wizard.addPages();
			Shell shell = getShell();

			bol = true;

			WizardDialog dialog = new WizardDialog(getShell(), wizard);
			dialog.create();

			dialog.open();
		} else {
			MessageDialog
					.open(SWT.ERROR,
							getShell(),
							"No Unicase project choosen",
							"you have not choosen a Unicase Porject to run the recovery on",
							SWT.None);
		}

	}

	public void init(IWorkbench workbench, ISelection selection) {

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * org.eclipse.ui.IActionDelegate#selectionChanged(org.eclipse.jface.action
	 * .IAction, org.eclipse.jface.viewers.ISelection)
	 */
	@Override
	public void selectionChanged(IAction action, ISelection selection) {
		// TODO Auto-generated method stub

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.eclipse.ui.IViewActionDelegate#init(org.eclipse.ui.IViewPart)
	 */
	@Override
	public void init(IViewPart view) {
		// TODO Auto-generated method stub

	}
}
