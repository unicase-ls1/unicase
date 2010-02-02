package org.unicase.patch.adapters;

import org.eclipse.compare.patch.IFilePatch2;
import org.eclipse.compare.patch.IHunk;
import org.eclipse.compare.patch.PatchBuilder;
import org.eclipse.compare.patch.PatchConfiguration;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IWorkspace;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.Path;
import org.eclipse.jface.dialogs.Dialog;
import org.eclipse.jface.viewers.ListViewer;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.events.SelectionListener;
import org.eclipse.swt.graphics.Font;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.FileDialog;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Text;
import org.eclipse.team.core.RepositoryProvider;
import org.unicase.patch.handlers.AdapterFactory;

public class ProjectSelectionDialog extends Dialog {
	
	private static String ECLIPSE_PATCH_HEADER = "### Eclipse Workspace Patch 1.0"; //$NON-NLS-1$
	private static String ECLIPSE_PROJECT_MARKER = "#P "; //$NON-NLS-1$
	private static String EOL = System.getProperty("line.separator");
	
	private Shell parent;
	private ListViewer viewer; 
	// TODO remove these
	private String oldPath;
	private String newPath;
	
	public ProjectSelectionDialog(Shell parent) {
		super(parent);
		this.parent = parent;
	}

	private IProject[] findProjectsInWorkspace() {
		IWorkspace workspace = ResourcesPlugin.getWorkspace();
		IProject[] projects = workspace.getRoot().getProjects();
		for (IProject p : projects) {
			System.out.println(p.getName());
		}
		return projects;
	}
	
//	@Override
//	protected Control createButtonBar(Composite parent) {
//		super.create
//	};
	
	protected Control createDialogArea(Composite parent) {
		// page group
		Composite composite = (Composite) super.createDialogArea(parent);

		composite.setLayout(new GridLayout());
		composite.setLayoutData(new GridData(GridData.FILL_BOTH));

		createProjectNameGroup(composite);
		viewer = new ListViewer(composite);
		viewer.add(findProjectsInWorkspace());
		
		Label lblOldFile = new Label(composite, SWT.NONE);
		lblOldFile.setText("Old file:");
		Label lblNewFile = new Label(composite, SWT.NONE);
		lblNewFile.setText("New file:");
		
		Text txtOldFile = new Text(composite, SWT.NONE);
		Text txtNewFile = new Text(composite, SWT.NONE);
			
		Button btnOldFile = new Button(composite, SWT.NONE);
		btnOldFile.setText("Browse old file");
		btnOldFile.addSelectionListener(new SelectionListener() {
			
			public void widgetSelected(SelectionEvent e) {
				FileDialog fd = new FileDialog(
						Display.getDefault().getActiveShell(),
						SWT.SAVE);
		        fd.setText("Select");
		        String file = fd.open();
//		        file = fd.getFileName();
		        System.out.println("Selected old file: " + file);
		        setOldPath(file);
			}
			
			public void widgetDefaultSelected(SelectionEvent e) {
			}
		});
		
		Button btnNewFile = new Button(composite, SWT.NONE);
		btnNewFile.setText("Browse new file");
		btnNewFile.addSelectionListener(new SelectionListener() {
			
			public void widgetSelected(SelectionEvent e) {
				FileDialog fd = new FileDialog(
						Display.getDefault().getActiveShell(),
						SWT.SAVE);
		        fd.setText("Select");
		        String file = fd.open();
//		        file = fd.getFileName();
		        System.out.println("Selected new file: " + file);
		        setNewPath(file);
			}
			
			public void widgetDefaultSelected(SelectionEvent e) {	
			}
		});
		
		Button btnCompare = new Button(composite, SWT.NONE);
		btnCompare.addSelectionListener(new SelectionListener() {
			
			public void widgetSelected(SelectionEvent e) {
				IFilePatch2 patch = PatchBuilder.createFilePatch(
						new Path(getOldPath()),
						IFilePatch2.DATE_UNKNOWN, 
						new Path(getNewPath()), 
						IFilePatch2.DATE_UNKNOWN, 
						new IHunk[] { });
				System.out.println(patch.getTargetPath(new PatchConfiguration()));
			} 
			
			public void widgetDefaultSelected(SelectionEvent e) {
				
			}
		});
		
		return composite;
	}
	
	@Override
	protected void okPressed() {
		IProject p = (IProject) viewer.getElementAt(viewer.getList().getSelectionIndex());
		RepositoryProvider provider = RepositoryProvider.getProvider(p);
		IAbstractAdapter adapter = AdapterFactory.getInstance().getAdapter(provider.getID());
		
		if (adapter != null) {
			adapter.createPatch(p);
		}
	};
		
	private void createProjectNameGroup(Composite parent) {
		Font font = parent.getFont();
		// project specification group
		Composite projectGroup = new Composite(parent, SWT.NONE);
		GridLayout layout = new GridLayout();
		layout.numColumns = 2;
		projectGroup.setLayout(layout);
		projectGroup.setLayoutData(new GridData(GridData.FILL_HORIZONTAL));

		// new project label
		Label projectLabel = new Label(projectGroup, SWT.NONE);
		projectLabel.setFont(font);
		projectLabel.setText("foo, my dear");
	}

	public void setOldPath(String oldPath) {
		this.oldPath = oldPath;
	}

	public String getOldPath() {
		return oldPath;
	}

	public void setNewPath(String newPath) {
		this.newPath = newPath;
	}

	public String getNewPath() {
		return newPath;
	}
}
