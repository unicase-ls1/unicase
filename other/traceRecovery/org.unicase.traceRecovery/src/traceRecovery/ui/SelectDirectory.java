/**
 * 
 */
package traceRecovery.ui;

import java.io.File;

import org.eclipse.emf.common.util.BasicEList;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EcorePackage;
import org.eclipse.jface.action.IAction;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.TableViewer;
import org.eclipse.swt.SWT;
import org.eclipse.swt.graphics.Rectangle;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.DirectoryDialog;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Event;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Listener;
import org.eclipse.swt.widgets.Monitor;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Text;
import org.eclipse.ui.IEditorActionDelegate;
import org.eclipse.ui.IEditorPart;
import org.eclipse.ui.IPerspectiveRegistry;
import org.eclipse.ui.ISelectionListener;
import org.eclipse.ui.IViewActionDelegate;
import org.eclipse.ui.IViewPart;
import org.eclipse.ui.IWorkbench;
import org.eclipse.ui.IWorkbenchPart;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.part.ViewPart;
import org.unicase.metamodel.Project;
import org.unicase.model.UnicaseModelElement;
import org.unicase.model.bug.BugReport;
import org.unicase.workspace.ProjectSpace;
import org.unicase.workspace.WorkspaceManager;

/**
 * @author taher
 * 
 */
public class SelectDirectory implements Listener, IViewActionDelegate {

	Button directory;
	Button setDirectory;
	Text directoryString;
	Text indexString;
	Label selectDirectory;
	Label indexDirectory;
	Button setIndexDirectory;
	Shell shell;
	Display display;
	Button ok;
	Button java;
	Button fortran;

	public void run() {
		display = Display.getCurrent();
		init("");

	}
	
	private static Project getActiveProject() {
		final ProjectSpace ps = WorkspaceManager.getInstance()
				.getCurrentWorkspace().getActiveProjectSpace();
		if(ps == null) {
			return null;
		}
		if (ps.getProject() != null) {
			return ps.getProject();
		} else {
			return null;
		}

	}

	public void init(String path) {
		Monitor primary = display.getPrimaryMonitor();
		Rectangle bound = primary.getBounds();
		Shell s = display.getActiveShell();

		IWorkbench workbench = PlatformUI.getWorkbench();
		workbench.getPerspectiveRegistry();
		
		
		
		
//		TableViewer viewr = new TableViewer(s);
//		
//		
//		getSite().setSelectionProvider(viewr);
//		
//		getSite().getWorkbenchWindow().getSelectionService().addSelectionListener(listener);
		
		Project p = getActiveProject();
		
		EList<EObject> e = p.getAllModelElementsbyClass(EcorePackage.Literals.EOBJECT,new BasicEList<EObject>());
		
		EList<EObject> ee = new BasicEList<EObject>();
		if(e!=null){
		for(EObject me : (EList<EObject>)e){
			if(me instanceof BugReport){
				ee.add(me);
			}
		}
		
		System.out.println(ee.size()+ " this is the value of the model element in this project");
		
		}
		shell = new Shell(display);
		shell.setText("select a Project Directory");

		shell.setLayout(new GridLayout(4, false));

		Label chooseCodeType = new Label(shell, SWT.NONE);
		chooseCodeType.setText("Choose Language:");

		new Label(shell, SWT.NONE);

		java = new Button(shell, SWT.RADIO);
		java.setText("Java");

		fortran = new Button(shell, SWT.RADIO);
		fortran.setText("Fortran");

		Label code = new Label(shell, SWT.NONE);
		code.setText("Code Directory: ");

		directoryString = new Text(shell, SWT.BORDER);
		directoryString.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true,
				false, 2, 1));

		directory = new Button(shell, SWT.NONE);
		directory.addListener(SWT.Selection, this);
		directory.setLayoutData(new GridData(SWT.LEFT, SWT.FILL, false, false,
				0, 1));
		directory.setText("Browse...");

		Label index = new Label(shell, SWT.NONE);
		index.setText("Index Directory: ");

		indexString = new Text(shell, SWT.BORDER);
		indexString.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, false,
				2, 1));

		setIndexDirectory = new Button(shell, SWT.NONE);
		setIndexDirectory.addListener(SWT.Selection, this);
		setIndexDirectory.setLayoutData(new GridData(SWT.LEFT, SWT.FILL, false,
				false, 0, 1));
		setIndexDirectory.setText("Browse...");

		new Label(shell, SWT.NONE);
		new Label(shell, SWT.NONE);
		new Label(shell, SWT.NONE);
		// new Label(shell, SWT.NONE);

		setDirectory = new Button(shell, SWT.NONE);
		GridData gd_btnNext = new GridData(SWT.RIGHT, SWT.CENTER, false, false,
				1, 1);
		gd_btnNext.widthHint = 63;
		setDirectory.setLayoutData(gd_btnNext);
		setDirectory.addListener(SWT.Selection, this);
		setDirectory.setText("Next");

		shell.setBounds(300, 200, (bound.width - 300) / 2,
				(bound.height - 200) / 2);
		shell.open();

		while (!shell.isDisposed()) {
			if (!display.readAndDispatch())
				display.sleep();
		}
	}

	// public static void main(String[] args) {
	//
	// }

	private String lastPath;
	private String lastIndexPath;

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * org.eclipse.swt.widgets.Listener#handleEvent(org.eclipse.swt.widgets.
	 * Event)
	 */

	Shell sh;

	public void handleEvent(Event event) {
		if (event.widget == directory) {

			DirectoryDialog dir = new DirectoryDialog(shell);
			String path = dir.open();
			// directoryString = new StyledText(shell, SWT.NONE);
			directoryString.setText(path);
			// directoryString.setSize(500, 100);
			// DirectoryDialog dialog = new DirectoryDialog(shell);

		} else if (event.widget == setIndexDirectory) {
			DirectoryDialog dir = new DirectoryDialog(shell);
			String path = dir.open();
			indexString.setText(path);
		}

		else if (event.widget == setDirectory) {

			System.out.println("the next button was clicked");

			File file = new File(directoryString.getText());
			File f = new File(indexString.getText());
			lastPath = directoryString.getText();
			lastIndexPath = indexString.getText();
			if (!file.exists()) {

				MessageDialog
						.open(SWT.ERROR,
								shell,
								"wrong path",
								"You entered a wrong CODE path please enter a correct path",
								SWT.None);
				// sh = new Shell(display);
				// sh.setLayout(new GridLayout());
				// Label text = new Label(sh, SWT.None);
				// text.setText("the entered path is not correct plz enter another path");
				// ok = new Button(sh, SWT.PUSH);
				// ok.setText("OK");
				// ok.addListener(SWT.Selection, this);

				// shell.dispose();
				//
				// sh.open();

				// while (!sh.isDisposed()) {
				// if (!display.readAndDispatch())
				// display.sleep();
				// }
				// display.dispose();
			} else if (!f.exists()) {

				MessageDialog
						.open(SWT.ERROR,
								shell,
								"wrong path",
								"You entered a wrong INDEX path please enter a correct path",
								SWT.None);

			} else {

				System.out
						.println("this will start the check from the java and fortran is choosen");
				if (!(java.getSelection() || fortran.getSelection())) {
					MessageDialog.open(SWT.ERROR, shell,
							"Programing Language not choosen",
							"You must choose a programing language", SWT.None);

				} else {

					String language = "";
					if (java.getSelection()) {
						language = "java";
					} else {
						language = "fortran";
					}

					shell.dispose();

					new RunRecovery().run(lastPath,lastIndexPath, language);
				}
			}
		}

		// TODO Auto-generated method stub

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.eclipse.ui.IActionDelegate#run(org.eclipse.jface.action.IAction)
	 */
	public void run(IAction action) {
		SelectDirectory dir = new SelectDirectory();
		dir.run();
		// TODO Auto-generated method stub

	}

	
	/*
	 * (non-Javadoc)
	 * 
	 * @see org.eclipse.ui.IViewActionDelegate#init(org.eclipse.ui.IViewPart)
	 */
	public void init(IViewPart view) {

		// TODO Auto-generated method stub

	}

	/* (non-Javadoc)
	 * @see org.eclipse.ui.IActionDelegate#selectionChanged(org.eclipse.jface.action.IAction, org.eclipse.jface.viewers.ISelection)
	 */
	public void selectionChanged(IAction action, ISelection selection) {
		// TODO Auto-generated method stub
		
	}

	

}
