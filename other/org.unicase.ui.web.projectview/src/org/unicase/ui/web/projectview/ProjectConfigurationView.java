package org.unicase.ui.web.projectview;

import org.eclipse.jface.resource.JFaceResources;
import org.eclipse.jface.window.Window;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.events.SelectionListener;
import org.eclipse.swt.graphics.Font;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Text;
import org.eclipse.ui.part.ViewPart;
import org.unicase.workspace.ProjectSpace;
import org.unicase.workspace.Workspace;

/**
 * 
 */
public class ProjectConfigurationView extends ViewPart {

	private ProjectsTableViewer projectsTableViewer;
	public static final String ID = "org.unicase.ui.web.projectview.ProjectConfigurationView";
	
	public ProjectConfigurationView() {
		
	}
	
	public void createPartControl(Composite parent) {

		projectsTableViewer = new ProjectsTableViewer(parent);
		projectsTableViewer.refreshView();
		getSite().setSelectionProvider(projectsTableViewer);
				
		Composite top = new Composite(parent, SWT.BORDER);
		GridLayout layout = new GridLayout();
		layout.marginHeight = 0;
		layout.marginWidth = 0;
		top.setLayout(layout);
		
		
		// top banner
		Composite banner = new Composite(top, SWT.NONE);
		banner.setLayoutData(new GridData(GridData.HORIZONTAL_ALIGN_FILL, GridData.VERTICAL_ALIGN_BEGINNING, true, false));
		layout = new GridLayout();
		layout.marginHeight = 5;
		layout.marginWidth = 10;
		layout.numColumns = 2;
		banner.setLayout(layout);
		
		// setup bold font
		Font boldFont = JFaceResources.getFontRegistry().getBold(JFaceResources.DEFAULT_FONT);    
		
		Label l = new Label(banner, SWT.WRAP);
		l.setText("Cryptic element:");
		l.setFont(boldFont);
		Text tfCrypticElement = new Text(banner, SWT.BORDER);
		//tf.

		l = new Label(banner, SWT.WRAP);
		l.setText("Team list visible:");
		l.setFont(boldFont);
		Button cbTeamListVisisble = new Button(banner, SWT.CHECK); 
		
		l = new Label(banner, SWT.WRAP);
		l.setText("Work item list visible:");
		l.setFont(boldFont);
		Button cbWorkItemListVisisble = new Button(banner, SWT.CHECK); 
		
		l = new Label(banner, SWT.WRAP);
		l.setText("Bug container:");
		Button btSelectBugContainer = new Button(banner, SWT.BORDER);
		btSelectBugContainer.setText("Select bug container");
		btSelectBugContainer.addSelectionListener(new SelectionListener() {
			
			public void widgetSelected(SelectionEvent e) {
				int selectedIndex = projectsTableViewer.getTable().getSelectionIndex();
				ProjectSpace p = (ProjectSpace) projectsTableViewer.getTable().getItem(selectedIndex).getData();
				foo(p);
			}
			
			public void widgetDefaultSelected(SelectionEvent e) {
				
			}
		});
//    
//		final Link link = new Link(banner, SWT.NONE);
//		link.setText("<a>nicole@mail.org</a>");
//		link.addSelectionListener(new SelectionAdapter() {    
//			public void widgetSelected(SelectionEvent e) {
//				MessageDialog.openInformation(getSite().getShell(), "Not Implemented", "Imagine the address book or a new message being created now.");
//			}    
//		});
//    
//		l = new Label(banner, SWT.WRAP);
//		l.setText("Date:");
//		l.setFont(boldFont);
//		l = new Label(banner, SWT.WRAP);
//		l.setText("10:34 am");
	}
	
	private void foo(final ProjectSpace pSpace) {
		Display.getDefault().syncExec(new Runnable() {
			
			public void run() {
				SelectWorkPackageDialog dlg = new SelectWorkPackageDialog(pSpace, "Select work package used as bug container");
				
				if (dlg.open() == Window.OK) {
					Workspace workspace = (Workspace) dlg.getFirstResult();
				}
			
			}
		});		
	}
	
	public void setFocus() {
	}
}
