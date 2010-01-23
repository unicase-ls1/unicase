package org.unicase.ui.web.tabs;

import org.eclipse.emf.transaction.RecordingCommand;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.swt.SWT;
import org.eclipse.swt.custom.CTabFolder;
import org.eclipse.swt.custom.CTabItem;
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
import org.unicase.model.bug.BugFactory;
import org.unicase.model.bug.BugReport;
import org.unicase.model.bug.Severity;
import org.unicase.web.util.ExampleUtil;
import org.unicase.workspace.CompositeOperationHandle;
import org.unicase.workspace.ProjectSpace;
import org.unicase.workspace.exceptions.InvalidHandleException;

public class BugReportTab extends AbstractTab {

	private final CTabFolder tabFolder;
	private final CTabItem tabItem;
	
	public BugReportTab(CTabFolder parent) {
		tabFolder = parent;
	    tabItem = new CTabItem( tabFolder, SWT.NONE );
	    tabItem.setText("Bug Reporting...");
	}
	
	
	public void createTabContent() {
		    Composite com = new Composite(tabFolder, SWT.NONE);
		    createTabContent(com);
		    tabItem.setControl(com);
	}
	
	/**
	 * 
	 * @param parent
	 */
	private void createTabContent(Composite composite) {
		composite.setLayout( ExampleUtil.createGridLayout( 1, false, 10, 20 ) );
			    
		// group widget
		GridData gridData;
		Group group = new Group(composite, SWT.NONE);
		group.setText("Bug reporting");
		group.setLayout(ExampleUtil.createGridLayout( 1, false, 10, 20 ));
		group.setLayoutData(new GridData(SWT.FILL, SWT.TOP, true, false));

		Composite formComp = new Composite( group, SWT.NONE );
		formComp.setLayout( new GridLayout( 2, false ) );

		new Label(formComp, SWT.NONE).setText("Name:");
		final Text bugNameText = new Text(formComp, SWT.SINGLE | SWT.BORDER);
		gridData = new GridData( SWT.FILL, SWT.TOP, true, false );
		gridData.minimumWidth = 250;
		bugNameText.setLayoutData(gridData);

		new Label(formComp, SWT.NONE).setText("Description:");
		final Text bugDescriptionText = new Text(formComp, SWT.MULTI | SWT.BORDER);
		gridData = new GridData(SWT.FILL, SWT.TOP, true, false);
		bugDescriptionText.setLayoutData( gridData );

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
	    
	    submitBugButton.addSelectionListener(new SelectionListener() {

	    	public void widgetSelected(SelectionEvent e) {

	    		final BugReport newBugReport = BugFactory.eINSTANCE.createBugReport();
	    		newBugReport.setName(bugNameText.getText());
	    		newBugReport.setDescription(bugDescriptionText.getText());

	    		TransactionalEditingDomain domain = TransactionalEditingDomain.Registry.INSTANCE
	    		.	getEditingDomain("org.unicase.EditingDomain");

	    		domain.getCommandStack().execute(new RecordingCommand(domain) {

	    			@Override
	    			protected void doExecute() {
	    				try {
	    					//Begin composite operation
	    					ProjectSpace p = getCurrProjectSpace();
	    					CompositeOperationHandle operationHandle = p.beginCompositeOperation();

	    					getCurrProject().addModelElement(newBugReport);

	    					LogMessage msg = VersioningFactory.eINSTANCE.createLogMessage();
	    					msg.setMessage("This is a first test");
	    					
	    					operationHandle.end("Create bug report via web", 
	    							"Created bug report " + newBugReport.getName() + ".",
	    							newBugReport.getModelElementId());
	    					
	    					getCurrProjectSpace().commit(msg);
	    					
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
	    				} catch (final EmfStoreException e) {
	    					Display.getDefault().asyncExec(new Runnable() {
	    						public void run() {
	    							MessageDialog.openError(
	    									Display.getDefault().getActiveShell(), 
	    									"Server unreachable", 
	    									"Server currently unreachable.\n" +
	    									"Please try to commit later.\n" + e.getMessage());
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
}
