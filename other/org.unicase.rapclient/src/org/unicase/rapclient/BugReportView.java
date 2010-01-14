package org.unicase.rapclient;

import java.util.List;

import org.eclipse.emf.transaction.RecordingCommand;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.events.SelectionListener;
import org.eclipse.swt.layout.FormAttachment;
import org.eclipse.swt.layout.FormData;
import org.eclipse.swt.layout.FormLayout;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Combo;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Text;
import org.eclipse.ui.part.ViewPart;
import org.unicase.emfstore.esmodel.versioning.LogMessage;
import org.unicase.emfstore.esmodel.versioning.VersioningFactory;
import org.unicase.metamodel.Project;
import org.unicase.model.bug.BugFactory;
import org.unicase.model.bug.BugReport;
import org.unicase.workspace.CompositeOperationHandle;
import org.unicase.workspace.ProjectSpace;
import org.unicase.workspace.WorkspaceManager;
import org.unicase.workspace.exceptions.InvalidHandleException;

public class BugReportView extends ViewPart {
	
	public static final String ID = "org.unicase.rapclient.bugreportview";
	private Composite composite;
	
	private ProjectSpace currProjectSpace;
	
	// the currently selected project
	private Project currProject;
	

	@Override
	public void createPartControl(Composite parent) {
		GridLayout layout = new GridLayout(2, true);
		
	    composite = new Composite(parent, SWT.NONE);
	    composite.setLayout(layout);
	    
	    // projet label
	    Label projectLabel = new Label(composite, SWT.NONE);
	    projectLabel.setText("Project:");
	    
	    // drop-down combo for project selection
	    final Combo projectCombo = new Combo(composite, SWT.DROP_DOWN);
	    List<ProjectSpace> projects = WorkspaceManager.getInstance().getCurrentWorkspace().getProjectSpaces();
	    String[] projectNames = new String[projects.size()];
	    
	    for (int i = 0; i < projects.size(); i++) {
	    	projectNames[i] = projects.get(i).getProjectName();
	    }
	    
	    projectCombo.setItems(projectNames);
	    projectCombo.addSelectionListener(new ComboListener());
	    GridData gd = new GridData();
	    gd.grabExcessHorizontalSpace = true;
	    projectCombo.setLayoutData(gd);

	    // bugname label 
	    Label bugNameLabel = new Label(composite, SWT.NONE);
	    bugNameLabel.setText("Name:");
	    	    
	    // bugname text field
	    final Text bugNameField = new Text(composite, SWT.BORDER | SWT.NONE);
	    	   
	    // description label
	    Label bugDescLabel = new Label(composite, SWT.NONE);
	    bugDescLabel.setText("Description:");
	    
	    // description text field
	    final Text bugDescField = new Text(composite, SWT.BORDER | SWT.MULTI);
	    
	    // submit button
	    Button submitBugButton = new Button(composite, SWT.NONE);
	    submitBugButton.setText("Submit bug");	    
	    gd = new GridData();
 	    
	    submitBugButton.addSelectionListener(new SelectionListener() {

	    	public void widgetSelected(SelectionEvent e) {
	    	
	    		// TODO: make sure a project has been selected
	    		
	    		final BugReport newBugReport = BugFactory.eINSTANCE.createBugReport();
	    		newBugReport.setName(bugNameField.getText());
	    		newBugReport.setDescription(bugDescField.getText());

	    		TransactionalEditingDomain domain = TransactionalEditingDomain.Registry.INSTANCE
	    			.getEditingDomain("org.unicase.EditingDomain");

	    		domain.getCommandStack().execute(new RecordingCommand(domain) {

	    			@Override
	    			protected void doExecute() {
	    				try {
	    					//Begin composite operation
	    					CompositeOperationHandle operationHandle = currProjectSpace.beginCompositeOperation();
	    						
	    					currProject.addModelElement(newBugReport);

	    					LogMessage msg = VersioningFactory.eINSTANCE.createLogMessage();
	    					msg.setMessage("This is a first test");
	    					
	    					operationHandle.end("Create bug report via web", 
	    							"Created bug report " + newBugReport.getName() + ".",
	    							newBugReport.getModelElementId());
	    					
	    					Display.getDefault().syncExec(new Runnable() {
								
								public void run() {
									MessageDialog.openInformation(
											Display.getDefault().getActiveShell(), 
											"Bug successfully reported!", 
											"You successfully reported a bug :)");
								}
							});

	    				} catch (final InvalidHandleException e2) {
							Display.getDefault().asyncExec(new Runnable() {
	    						public void run() {
	    							MessageDialog.openError(
	    									Display.getDefault().getActiveShell(), 
	    									"Invalid handle", 
	    									"What happened?\n" + e2.getMessage());
	    						}
	    					});
						}
	    			}

	    		});
	    	}

			
			public void widgetDefaultSelected(SelectionEvent e) {
				Display.getDefault().asyncExec(new Runnable() {
					
					public void run() {
						MessageDialog.openError(
								Display.getDefault().getActiveShell(),
								"B", "b");
					}
				});
			}
		});
	}

	@Override
	public void setFocus() {
		// TODO Auto-generated method stub
		
	}
	
	private void setProject(String projectName) {
		// TODO: use more efficient to retrieve project 
		List<ProjectSpace> projectSpaces = WorkspaceManager.getInstance()
			.getCurrentWorkspace().getProjectSpaces();
		
		for (ProjectSpace p : projectSpaces) {
			if (p.getProjectName().equals(projectName)) {
				currProjectSpace = p;
				currProject = p.getProject();
			}
		}
	}
	
	private class ComboListener extends SelectionAdapter {
		@Override
    	public void widgetSelected(final SelectionEvent e) {
			Display.getDefault().asyncExec(new Runnable() {
				
				public void run() {
					Combo cmb = (Combo) e.getSource();
					setProject(cmb.getItem(cmb.getSelectionIndex()));
				}
			});
		}
	}

}
