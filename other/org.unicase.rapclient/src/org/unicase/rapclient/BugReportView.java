package org.unicase.rapclient;

import org.eclipse.emf.transaction.RecordingCommand;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.events.SelectionListener;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Text;
import org.eclipse.ui.part.ViewPart;
import org.unicase.emfstore.esmodel.versioning.LogMessage;
import org.unicase.emfstore.esmodel.versioning.VersioningFactory;
import org.unicase.emfstore.exceptions.EmfStoreException;
import org.unicase.model.bug.BugFactory;
import org.unicase.model.bug.BugReport;
import org.unicase.workspace.CompositeOperationHandle;
import org.unicase.workspace.ProjectSpace;
import org.unicase.workspace.WorkspaceManager;
import org.unicase.workspace.exceptions.InvalidHandleException;
import org.unicase.workspace.exceptions.UnkownProjectException;

public class BugReportView extends ViewPart {
	
	public static final String ID = "org.unicase.rapclient.bugreportview";
	private Composite composite;

	@Override
	public void createPartControl(Composite parent) {
	    GridLayout gridLayout = new GridLayout(2, false);
	    composite = new Composite(parent, SWT.NONE);
	    composite.setLayout(gridLayout);

	    // Name 
	    Label bugNameLabel = new Label(composite, SWT.NONE);
	    bugNameLabel.setText("Name:");
	    final Text bugName = new Text(composite, SWT.NONE);

	    Label bugDescLabel = new Label(composite, SWT.NONE);
	    bugDescLabel.setText("Description:");
	    final Text bugDescField = new Text(composite, SWT.MULTI);

	    Button submitBugButton = new Button(composite, SWT.NONE);
	    submitBugButton.setText("Submit bug");
	    submitBugButton.addSelectionListener(new SelectionListener() {

	    	public void widgetSelected(SelectionEvent e) {				
	    		final BugReport newBugReport = BugFactory.eINSTANCE.createBugReport();
	    		newBugReport.setName(bugName.getText());
	    		newBugReport.setDescription(bugDescField.getText());

	    		TransactionalEditingDomain domain = TransactionalEditingDomain.Registry.INSTANCE
	    		.getEditingDomain("org.unicase.EditingDomain");

	    		domain.getCommandStack().execute(new RecordingCommand(domain) {

	    			@Override
	    			protected void doExecute() {
	    				try {
	    					//Begin composite operation
	    					CompositeOperationHandle operationHandle =
	    						ProxyCommit.getProjectSpace().beginCompositeOperation();
	    				
	    					
	    					ProxyCommit.getProject().addModelElement(newBugReport);

	    					LogMessage msg = VersioningFactory.eINSTANCE.createLogMessage();
	    					msg.setMessage("This is a first test");

	    					ProxyCommit.getProjectSpace().commit(msg);
	    					
	    					operationHandle.end("Add bug report via web", 
	    							"wooooot",
	    							newBugReport.getModelElementId());

	    				} catch (UnkownProjectException e) {
	    					Display.getDefault().asyncExec(new Runnable() {
	    						public void run() {
	    							MessageDialog.openError(
	    									Display.getDefault().getActiveShell(), 
	    									"Project unknown", "The project you've requested is unknown.");
	    						}
	    					});	
	    				} catch (EmfStoreException e) {
	    					Display.getDefault().asyncExec(new Runnable() {
	    						public void run() {
	    							MessageDialog.openError(
	    									Display.getDefault().getActiveShell(), 
	    									"Server unreachable", 
	    									"The server is reachable.");
	    						}
	    					});
						} catch (final InvalidHandleException e2) {
							Display.getDefault().asyncExec(new Runnable() {
	    						public void run() {
	    							MessageDialog.openError(
	    									Display.getDefault().getActiveShell(), 
	    									"Invalid handle", 
	    									"What happene?\n" + e2.getMessage());
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

}
