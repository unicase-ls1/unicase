package org.unicase.rap.bugreport;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.transaction.RecordingCommand;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.events.SelectionListener;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Combo;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Group;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Text;
import org.unicase.emfstore.esmodel.versioning.LogMessage;
import org.unicase.emfstore.esmodel.versioning.VersioningFactory;
import org.unicase.emfstore.exceptions.EmfStoreException;
import org.unicase.metamodel.ModelElement;
import org.unicase.metamodel.Project;
import org.unicase.model.bug.BugFactory;
import org.unicase.model.bug.BugReport;
import org.unicase.model.bug.Severity;
import org.unicase.rap.ui.views.ProjectAwareView;
import org.unicase.workspace.CompositeOperationHandle;
import org.unicase.workspace.ProjectSpace;
import org.unicase.workspace.exceptions.InvalidHandleException;

/**
 * 
 * @author Edgar Mueller
 * @author Fatih Ulusoy
 */
public class BugReportView extends ProjectAwareView {

	public static final String ID = "org.unicase.rap.bugreport.BugReportView";
	
	public BugReportView() {

	}

	@Override
	public String getId() {
		return ID;
	}


	@Override
	public void createPartControl(Composite parent) {
		GridData gridData = new GridData(SWT.FILL, SWT.TOP, true, false);	
//		gridData.
		
		GridLayout gridLayout = new GridLayout();
		gridLayout.numColumns = 2;
		parent.setLayout(gridLayout);

		// group widget
		Group group = new Group(parent, SWT.NONE);
		group.setText("Bug reporting");
		group.setLayoutData(gridData);
		group.setLayoutData(new GridData(SWT.FILL, SWT.TOP, true, false));

		Composite formComp = new Composite(group, SWT.NONE);
		formComp.setLayout(new GridLayout(2, false));
		
		new Label(formComp, SWT.NONE).setText("Name:");
		final Text bugNameText = new Text(formComp, SWT.SINGLE | SWT.BORDER);
		gridData = new GridData(SWT.FILL, SWT.TOP, true, false);
		gridData.minimumWidth = 250;
		bugNameText.setLayoutData(gridData);

		new Label(formComp, SWT.NONE).setText("Description:");
		int wrapStyle = SWT.MULTI | SWT.WRAP | SWT.V_SCROLL | SWT.BORDER;
		final Text bugDescriptionText = new Text(formComp, wrapStyle);
		gridData = new GridData(SWT.FILL, SWT.TOP, true, false);
	    GridData wrapTextData = new GridData( SWT.FILL, SWT.FILL, true, true );
	    wrapTextData.minimumHeight = 100;
		bugDescriptionText.setLayoutData( wrapTextData );

		// TODO: will be severity
		new Label(formComp, SWT.NONE).setText("Severity:");
		final Combo classCombo = new Combo(formComp, SWT.READ_ONLY | SWT.BORDER);

		Object[] classes = Severity.VALUES.toArray();
		String[] severity = new String[classes.length];
		
		for (int i = 0; i < classes.length; i++) {
			severity[i] = classes[i].toString();
		}
		
		classCombo.setItems(severity);
		gridData = new GridData( SWT.FILL, SWT.TOP, true, false );
		classCombo.setLayoutData( gridData );
		classCombo.select( 0 );

	    // submit button
	    Button submitBugButton = new Button(formComp, SWT.NONE);
	    submitBugButton.setText("Submit bug");	    
		gridData = new GridData(SWT.FILL, SWT.TOP, true, false);
		submitBugButton.setLayoutData(gridData);
		
		final Label messageLabel = new Label(formComp, SWT.FILL);
		messageLabel.setForeground(Display.getDefault().getSystemColor(SWT.COLOR_RED | SWT.BOLD));
		messageLabel.setText("");
		gridData = new GridData(SWT.FILL, SWT.TOP, true, false);
		messageLabel.setLayoutData(gridData);
		
	    submitBugButton.addSelectionListener(new SelectionListener() {

	    	public void widgetSelected(SelectionEvent e) {

	    		final BugReport newBugReport = BugFactory.eINSTANCE.createBugReport();
	    		newBugReport.setName(bugNameText.getText());
	    		newBugReport.setDescription(bugDescriptionText.getText());

	    		final Display myDisplay = Display.getDefault();
	    		
				TransactionalEditingDomain domain = TransactionalEditingDomain.Registry.INSTANCE
						.getEditingDomain("org.unicase.EditingDomain");

	    		domain.getCommandStack().execute(new RecordingCommand(domain) {

	    			@Override
	    			protected void doExecute() {
	    				try {
	    					//Begin composite operation
	    					ProjectSpace p = getProjectSpace();
	    					CompositeOperationHandle operationHandle = p.beginCompositeOperation();

	    					getProject().addModelElement(newBugReport);

	    					LogMessage msg = VersioningFactory.eINSTANCE.createLogMessage();
	    					msg.setMessage("This is a first test");
	    					
	    					operationHandle.end("Create bug report via web", 
	    							"Created bug report " + newBugReport.getName() + ".",
	    							newBugReport.getModelElementId());
	    					
	    					getProjectSpace().commit(msg);
	    					
	    					messageLabel.setText("Your bug has been successfully reported!");
	    					messageLabel.setVisible(true);
	    					bugNameText.setText("");
	    					bugDescriptionText.setText("");
	    					
	    					// TODO : find out, why all widget is disposed.	
	    					
//	    					myDisplay.syncExec(new Runnable() {
//	    						public void run() {
//	    							MessageDialog.openInformation(
//	    									myDisplay.getActiveShell(), 
//	    									"Bug successfully reported!",
//	    							"You successfully reported a bug :)");
//	    						}
//	    					});
	    				} catch (final InvalidHandleException e2) {
//	    					Display.getDefault().asyncExec(new Runnable() {
//	    						public void run() {
//	    							MessageDialog.openError(
//	    									Display.getDefault().getActiveShell(), 
//	    									"Invalid handle", 
//	    									"What happened?\n" + e2.getMessage());
//	    						}
//	    					});
	    					messageLabel.setText("Something wrong! Bug was not reported.");
	    					messageLabel.setVisible(true);
	    				} catch (final EmfStoreException e) {
//	    					Display.getDefault().asyncExec(new Runnable() {
//	    						public void run() {
//	    							MessageDialog.openError(
//	    									Display.getDefault().getActiveShell(), 
//	    									"Server unreachable", 
//	    									"Server currently unreachable.\n" +
//	    									"Please try to commit later.\n" + e.getMessage());
//	    						}
//	    					});
	    					messageLabel.setText("Something wrong! Bug was not reported.");
	    					messageLabel.setVisible(true);
						}
	    			}

	    		});
	    	}

	    	public void widgetDefaultSelected(SelectionEvent e) {
//	    		Display.getDefault().asyncExec(new Runnable() {
//
//	    			public void run() {
//	    				MessageDialog.openError(
//	    						Display.getDefault().getActiveShell(),
//	    						"B", "b");
//	    			}
//	    		});
				messageLabel.setText("Something wrong!");
				messageLabel.setVisible(true);
	    	}
	    });
	}


	@Override
	public void setFocus() {
		
	}


	public void modelElementAdded(Project project, ModelElement modelElement) {
		
	}


	public void modelElementDeleteCompleted(Project project,
			ModelElement modelElement) {
		
	}


	public void modelElementDeleteStarted(Project project,
			ModelElement modelElement) {
		
	}


	public void notify(Notification notification, Project project,
			ModelElement modelElement) {
		
	}
}


