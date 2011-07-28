/**
 * 
 */
package org.unicase.ui.tracerecovery;

import org.eclipse.cdt.internal.core.model.CProject;
import org.eclipse.cdt.internal.core.model.SourceRoot;
import org.eclipse.cdt.internal.core.model.TranslationUnit;
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
import org.eclipse.swt.graphics.Point;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.ui.IViewActionDelegate;
import org.eclipse.ui.IViewPart;
import org.eclipse.ui.IWorkbench;
import org.eclipse.ui.IWorkbenchWindow;
import org.eclipse.ui.PlatformUI;
import org.unicase.metamodel.Project;
import org.unicase.ui.traceRecovery.searchResult.SearchResult;
import org.unicase.ui.traceRecvoery.pages.RunRecovery;
import org.unicase.ui.traceRecvoery.pages.SelecDirectory;
import org.unicase.workspace.ProjectSpace;
import org.unicase.workspace.WorkspaceManager;

import traceRecovery.Directory;
import traceRecovery.TraceRecoveryFactory;

/**
 * @author taher
 * 
 */
public class TraceRecoveryWizard extends Wizard implements IWizard,
		IViewActionDelegate {

	Project project;
	IPath pat;
	RunRecovery recovery;

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.eclipse.jface.wizard.Wizard#performFinish()
	 */
	@Override
	public boolean performFinish() {
		this.dispose();
		this.recovery.finish();
		return true;
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
	SelecDirectory dir;

	
	
	/**
	 * add pages to the wizards
	 */
	@Override
	public void addPages() {
		// if (bol) {
		setWindowTitle("Run Recovery");
		dir = new SelecDirectory();
		dir.setProject(getActiveProject());
		addPage(dir);

		if (producer == "java") {

			dir.setLastPath(pat.toPortableString());
			// dir.getDirectoryString().setText(pat.toPortableString());
			// dir.getDirectoryString().setEnabled(false);
			// dir.getDirectory().setEnabled(false);

		} else if (producer == "fortran") {

		}

		recovery = new RunRecovery();

		

		recovery.setP(getActiveProject());

		addPage(recovery);


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

	public boolean canFinish(){
		if(recovery.canFinish()){
			return true;
		} else {
			return false;
		}
	}
	
	
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
		boolean havePath = false;
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

			if (!havePath) {
				IWorkspaceRoot root = ResourcesPlugin.getWorkspace().getRoot();
				IFolder folder = root.getFolder(path);
				wizard.pat = folder.getLocation();
				havePath = true;
			}
		} else if (action.getId().toLowerCase().equals("fortran")) {
			wizard.producer = "fortran";
			IWorkbenchWindow window = PlatformUI.getWorkbench()
					.getActiveWorkbenchWindow();

			IStructuredSelection selection = (IStructuredSelection) window
					.getSelectionService().getSelection(
							"org.eclipse.photran.ui.FortranView");

			parent = selection.getFirstElement();
			IPath path = null;
			if(parent instanceof CProject){
				CProject project = (CProject) parent;
				IProject p = project.getProject();
				wizard.pat = p.getLocation();
				havePath = true;
				
				
			}else if(parent instanceof SourceRoot){
				path = ((SourceRoot) parent).getPath();
			}else if(parent instanceof TranslationUnit){
				path = ((TranslationUnit) parent).getPath();
				
			}
			
			if(!havePath){
			IWorkspaceRoot root = ResourcesPlugin.getWorkspace().getRoot();
			IFolder folder = root.getFolder(path);
			wizard.pat = folder.getLocation();
			}
			
			
			

		}

		project = getActiveProject();
		if (project != null) {

			// wizard.addPages();
			Shell shell = getShell();

			bol = true;

			WizardDialog dialog = new WizardDialog(getShell(), wizard);
			dialog.create();

			if (wizard.producer == "fortran") {
				wizard.dir.getFortran().setSelection(true);
				wizard.dir.setPageComplete(false);
				wizard.dir.getJava().setEnabled(false);
				wizard.dir.getFortran().setEnabled(false);
			}else if (wizard.producer == "java"){
				wizard.dir.getJava().setSelection(true);
				wizard.dir.setPageComplete(false);
				wizard.dir.getJava().setEnabled(false);
				wizard.dir.getFortran().setEnabled(false);
			}
			if (wizard.producer == "java" || wizard.producer == "fortran") {
				wizard.dir.getDirectoryString().setText(
						wizard.pat.toPortableString());
				wizard.dir.getDirectoryString().setEnabled(false);
				wizard.dir.getDirectory().setEnabled(false);
//				wizard.dir.getJava().setSelection(true);
				
				
			} 
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
