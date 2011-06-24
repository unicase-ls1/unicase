/**
 * 
 */
package traceRecovery.ui;

import java.io.File;

import org.eclipse.core.resources.IFolder;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IWorkspaceRoot;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.IPath;
import org.eclipse.jdt.core.IJavaProject;
import org.eclipse.jdt.core.IPackageFragmentRoot;
import org.eclipse.jdt.internal.core.JavaProject;
import org.eclipse.jface.action.IAction;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.swt.SWT;
import org.eclipse.swt.graphics.Rectangle;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.DirectoryDialog;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Event;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Listener;
import org.eclipse.swt.widgets.Monitor;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Text;
import org.eclipse.ui.IViewActionDelegate;
import org.eclipse.ui.IViewPart;
import org.eclipse.ui.IWorkbenchWindow;
import org.eclipse.ui.PlatformUI;

/**
 * @author taher
 *
 */
public class SelectLuceneDirectoryJava implements Listener, IViewActionDelegate{

	Display display;
	Shell shell;
	Text dir;
	Button browse;
	Button next;
	String lastPath;
	String codePath;
	/* (non-Javadoc)
	 * @see org.eclipse.ui.IActionDelegate#run(org.eclipse.jface.action.IAction)
	 */
	public void run(IAction action) {
		SelectLuceneDirectoryJava lucDir = new SelectLuceneDirectoryJava();
		lucDir.run();
		
		
	}
	
	
	public void run(){
		display = Display.getCurrent();
		init();
	}

	
	public void init(){
		Monitor primary = display.getPrimaryMonitor();
		Rectangle bound = primary.getBounds();
		
		shell = new Shell(display);
		shell.setText("Choose Directory to Place the Indexed File");
		shell.setLayout(new GridLayout(4, false));
		
		IWorkbenchWindow window =
		    PlatformUI.getWorkbench().getActiveWorkbenchWindow();
		ISelection selection = window.getSelectionService().getSelection("org.eclipse.jdt.ui.PackageExplorer");
		
		IStructuredSelection structured = (IStructuredSelection) selection;
		
		
//		System.out.println(structured.getFirstElement().getClass());
		
//		IPackageFragmentRoot project = (IPackageFragmentRoot) structured.getFirstElement();
		
		IPackageFragmentRoot pak = chooseProject(structured);
		
//		IPath pat = project.get;
		
//		IJavaProject project = (IJavaProject) structured.getFirstElement();
		
//		IPath path = project.get;
		
		IPath pat = pak.getPath();
		IWorkspaceRoot root = ResourcesPlugin.getWorkspace().getRoot();
		IFolder folder = root.getFolder(pat);
		
		
		IPath path = folder.getLocation();
		
		System.out.println("this is the path of the src file " + path.toPortableString());
		
		codePath = path.toPortableString();
		
		Label chooseDir = new Label(shell, SWT.None);
		chooseDir.setText("choose a dir");
		
		dir = new Text(shell, SWT.None);
		dir.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, false,
				2, 1));
		browse = new Button(shell, SWT.NONE);
		browse.setText("browse...");
		browse.addListener(SWT.Selection, this);
		
		new Label(shell, SWT.None);
		new Label(shell, SWT.None);
		new Label(shell, SWT.None);

		
		next = new Button(shell, SWT.NONE);
		GridData gd_btnNext = new GridData(SWT.RIGHT, SWT.CENTER, false, false,
				1, 1);
		
		next.setLayoutData(gd_btnNext);
		next.addListener(SWT.Selection, this);
		next.setText("Next");
		
		shell.setBounds(300, 100, (bound.width - 300) / 2,
				(bound.height - 100) / 2);
		
		shell.open();
		
		while (!shell.isDisposed()) {
			if (!display.readAndDispatch())
				display.sleep();
		}
		
		
	}
	
	public IPackageFragmentRoot chooseProject(IStructuredSelection selection){
		try{
		IPackageFragmentRoot packa = (IPackageFragmentRoot) selection.getFirstElement();
		
		return packa;
		}catch(Exception e){
//			chooseProject(selection);
			
			MessageDialog
			.open(SWT.ERROR,
					shell,
					"wrong folder",
					"choose a correct src folder",
					SWT.None);
			
			
			
			return null;
			
		}
	}
	
	/* (non-Javadoc)
	 * @see org.eclipse.ui.IActionDelegate#selectionChanged(org.eclipse.jface.action.IAction, org.eclipse.jface.viewers.ISelection)
	 */
	public void selectionChanged(IAction action, ISelection selection) {
		// TODO Auto-generated method stub
		
	}

	/* (non-Javadoc)
	 * @see org.eclipse.ui.IViewActionDelegate#init(org.eclipse.ui.IViewPart)
	 */
	public void init(IViewPart view) {
		// TODO Auto-generated method stub
		
	}

	/* (non-Javadoc)
	 * @see org.eclipse.swt.widgets.Listener#handleEvent(org.eclipse.swt.widgets.Event)
	 */
	public void handleEvent(Event event) {
		String path = "";
		if(event.widget == browse){
			DirectoryDialog dialog = new DirectoryDialog(shell);
			path = dialog.open();
			dir.setText(path);
		} else if(event.widget == next){
			File file = new File(dir.getText());
			lastPath = dir.getText();
			
			if(!file.exists()){
				MessageDialog
				.open(SWT.ERROR,
						shell,
						"wrong path",
						"You entered a wrong INDEX path please enter a correct path",
						SWT.None);
			}
			
			
			shell.close();
			new RunRecovery().run(codePath, lastPath, "java");
			
			
		}
		
	}

}
