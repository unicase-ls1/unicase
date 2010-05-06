/**
 * <copyright> Copyright (c) 2008-2009 Jonas Helming, Maximilian Koegel. All rights reserved. This program and the
 * accompanying materials are made available under the terms of the Eclipse Public License v1.0 which accompanies this
 * distribution, and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>
 */
package org.unicase.rap.bugreport;

import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Text;
import org.eclipse.swt.widgets.Combo;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.events.SelectionListener;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.jface.dialogs.MessageDialog;
import org.unicase.emfstore.exceptions.EmfStoreException;
import org.unicase.emfstore.esmodel.versioning.LogMessage;
import org.unicase.emfstore.esmodel.versioning.VersioningFactory;

import org.unicase.metamodel.Project;
import org.unicase.model.bug.Severity;
import org.unicase.model.bug.BugReport;
import org.unicase.model.bug.BugFactory;
import org.unicase.model.task.WorkPackage;
import org.unicase.metamodel.ModelElement;
import org.unicase.metamodel.ModelElementId;
import org.unicase.metamodel.MetamodelFactory;
import org.unicase.rap.config.ConfigEntityStore;
import org.unicase.rap.ui.views.ProjectAwareView;
import org.unicase.workspace.util.UnicaseCommand;
import org.unicase.workspace.CompositeOperationHandle;
import org.unicase.workspace.exceptions.InvalidHandleException;
import org.unicase.rap.bugreport.config.BugReportingConfigEntity;

/**
 * Bug reporting view.
 * 
 * @author Edgar Mueller, Fatih Ulusoy
 */
public class BugReportView extends ProjectAwareView {

	/** The view ID. */
	public static final String ID = "org.unicase.rap.bugreport.BugReportView";
	
	/**
	 * The constructor.
	 */
	public BugReportView() {

	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public String getId() {
		return ID;
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.ui.part.WorkbenchPart#createPartControl(Composite)
	 */
	@Override
	public void createPartControl(Composite parent) {

		GridLayout gridLayout = new GridLayout();
		gridLayout.numColumns = 2;
		parent.setLayout(gridLayout);

		GridData gridData = new GridData();
		gridData.grabExcessHorizontalSpace = true;
		gridData.grabExcessVerticalSpace = true;
		gridData.horizontalAlignment = SWT.FILL;
		parent.setLayoutData(gridData);

		Composite formComp = new Composite(parent, SWT.NONE);
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
		GridData wrapTextData = new GridData(SWT.FILL, SWT.FILL, true, true);
		wrapTextData.minimumHeight = 100;
		bugDescriptionText.setLayoutData(wrapTextData);

		new Label(formComp, SWT.NONE).setText("Severity:");
		final Combo severityCombo = createSeverityCombo(formComp);

		// submit button
		Button submitBugButton = new Button(formComp, SWT.NONE);
		submitBugButton.setText("Submit Bug");
		gridData = new GridData(SWT.FILL, SWT.TOP, true, false);
		submitBugButton.setLayoutData(gridData);

		final Label messageLabel = new Label(formComp, SWT.FILL);
		messageLabel.setForeground(Display.getDefault().getSystemColor(SWT.COLOR_RED | SWT.BOLD));
		messageLabel.setText("");
		gridData = new GridData(SWT.FILL, SWT.TOP, true, false);
		messageLabel.setLayoutData(gridData);
		
	    submitBugButton.addSelectionListener(new SelectionListener() {

	    	public void widgetSelected(SelectionEvent e) {

				final BugReport newBugReport = createBugReport(bugNameText.getText(), bugDescriptionText.getText(),
					Severity.getByName(severityCombo.getItem(severityCombo.getSelectionIndex()))); 
	    		
				final WorkPackage container = getBugContainer();
				
				new UnicaseCommand() {
					@Override
					protected void doRun() {
	    				try {
	    					CompositeOperationHandle operationHandle = getProjectSpace().beginCompositeOperation();
	    					
	    					getProject().addModelElement(newBugReport);
	    					newBugReport.setContainingWorkpackage(container);

	    					LogMessage msg = VersioningFactory.eINSTANCE.createLogMessage();
	    					msg.setMessage("This is a first test");
	    					
							operationHandle.end("Create bug report via web", "Created bug report "
								+ newBugReport.getName() + ".", newBugReport.getModelElementId());
	    					
	    					getProjectSpace().commit(msg);
	    					
	    					messageLabel.setText("Your bug has been successfully reported!");
	    					messageLabel.setVisible(true);
	    					bugNameText.setText("");
	    					bugDescriptionText.setText("");
	    					
	    					// TODO : find out, why all widget is disposed.	
							Display.getDefault().asyncExec(new Runnable() {
								public void run() {
									MessageDialog.openInformation(Display.getDefault().getActiveShell(),
										"Bug successfully reported!", "You successfully reported a bug :)");
								}
							});
						} catch (final InvalidHandleException e2) {
							Display.getDefault().asyncExec(new Runnable() {
								public void run() {
									MessageDialog.openError(Display.getDefault().getActiveShell(), "Invalid handle",
										"What happened?\n" + e2.getMessage());
								}
							});
							messageLabel.setText("Something wrong! Bug was not reported.");
							messageLabel.setVisible(true);
						} catch (final EmfStoreException e) {
							Display.getDefault().asyncExec(new Runnable() {
								public void run() {
									MessageDialog.openError(Display.getDefault().getActiveShell(),
										"Server unreachable", "Server currently unreachable.\n"
											+ "Please try to commit later.\n" + e.getMessage());
								}
							});
							messageLabel.setText("Something wrong! Bug was not reported.");
							messageLabel.setVisible(true);
						}
					}
				}.run();
				
	    	}

	    	public void widgetDefaultSelected(SelectionEvent e) {
				Display.getDefault().asyncExec(new Runnable() {
					public void run() {
						MessageDialog.openError(Display.getDefault().getActiveShell(), "B", "b");
					}
				});
				messageLabel.setText("Something wrong!");
				messageLabel.setVisible(true);
	    	}
	    	
	    });
	    
	}
	
	private WorkPackage getBugContainer() {
		
		BugReportingConfigEntity configEntity = new BugReportingConfigEntity(getProjectSpace());
		ConfigEntityStore.loadConfigEntity(configEntity, configEntity.eClass());
		
		ModelElementId id = MetamodelFactory.eINSTANCE.createModelElementId();
		id.setId(configEntity.getBugContainerName());
		
		ModelElement elm = getProject().getModelElement(id);
		WorkPackage container = (WorkPackage) elm;
		return container;
	}
	
	private BugReport createBugReport(String name, String description, Severity severity) {
		
		BugReport newBugReport = BugFactory.eINSTANCE.createBugReport();
		newBugReport.setName(name);
		newBugReport.setDescription(description);
		newBugReport.setSeverity(severity);
		
		return newBugReport;
	}
	
	private Combo createSeverityCombo(Composite formComposite) {
		
		final Combo severityCombo = new Combo(formComposite, SWT.READ_ONLY | SWT.BORDER);
		Object[] classes = Severity.VALUES.toArray();
		String[] severity = new String[classes.length];

		for (int i = 0; i < classes.length; i++) {
			severity[i] = classes[i].toString();
		}

		severityCombo.setItems(severity);
		GridData gridData = new GridData(SWT.FILL, SWT.TOP, true, false);
		severityCombo.setLayoutData(gridData);
		severityCombo.select(0);
		return severityCombo;
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.ui.part.WorkbenchPart#setFocus()
	 */
	@Override
	public void setFocus() {
		
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.unicase.metamodel.util.ProjectChangeObserver#modelElementAdded(Project, ModelElement)
	 */
	public void modelElementAdded(Project project, ModelElement modelElement) {
		
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.unicase.metamodel.util.ProjectChangeObserver#modelElementDeleteCompleted(Project, ModelElement)
	 */
	public void modelElementDeleteCompleted(Project project,
			ModelElement modelElement) {
		
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.unicase.metamodel.util.ProjectChangeObserver#modelElementDeleteStarted(Project, ModelElement)
	 */
	public void modelElementDeleteStarted(Project project,
			ModelElement modelElement) {
		
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.unicase.metamodel.util.ProjectChangeObserver#notify(Notification, Project, ModelElement)
	 */
	public void notify(Notification notification, Project project,
			ModelElement modelElement) {
		
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.unicase.metamodel.util.ProjectChangeObserver#projectDeleted(Project)
	 */
	public void projectDeleted(Project project) {
		
	}
	
}


