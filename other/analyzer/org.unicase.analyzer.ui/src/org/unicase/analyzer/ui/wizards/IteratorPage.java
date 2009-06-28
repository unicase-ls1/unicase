/**
 * <copyright> Copyright (c) 2008 Jonas Helming, Maximilian Koegel. All rights reserved. This program and the
 * accompanying materials are made available under the terms of the Eclipse Public License v1.0 which accompanies this
 * distribution, and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>
 */

package org.unicase.analyzer.ui.wizards;


import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.jface.wizard.IWizardPage;
import org.eclipse.jface.wizard.WizardPage;
import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Combo;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Event;
import org.eclipse.swt.widgets.Group;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Listener;
import org.eclipse.swt.widgets.Text;
import org.unicase.analyzer.VersionIterator;
import org.unicase.analyzer.exceptions.IteratorException;
import org.unicase.emfstore.esmodel.ProjectId;
import org.unicase.workspace.ProjectSpace;
import org.unicase.workspace.Usersession;
import org.unicase.workspace.WorkspaceManager;

/**
 * @author liya
 *
 */
public class IteratorPage extends WizardPage implements Listener {

	private static final String PAGE_TITLE = "Iterator";
	private static final String[] units = {"Year", "Month", "Day", "Hour", "Minute", "Second"};
	private static String PAGE_DESCRIPTION;
	private boolean canFlipToNextPage;
	
	private VersionIterator iterator;
	
	private Button versionIteratorButton;
	private Button timeIteratorButton;
	private Text stepText;
	private Combo stepUnit;
	private Button defaultButton;
	private Group group;
	private Text startText;
	private Text endText;
	private Button forwardButton;
	private Button backwardButton;
	private Button returnCopyButton;
	private Label stepUnitLabel;

	protected IteratorPage(String pageName) {
		super(pageName);
		PAGE_DESCRIPTION = "Configure your Iterator used for analyzing the project.";
		setTitle(PAGE_TITLE);
		setDescription(PAGE_DESCRIPTION);
		canFlipToNextPage = false;
	}

	/** 
	 * {@inheritDoc}
	 * @see org.eclipse.jface.dialogs.IDialogPage#createControl(org.eclipse.swt.widgets.Composite)
	 */
	public void createControl(Composite parent) {
		GridData gd;
		Composite composite = new Composite(parent, SWT.NULL);
		GridLayout gl = new GridLayout();
		int ncol = 4;
		gl.numColumns = ncol;
		composite.setLayout(gl);
		
		Composite internalA = new Composite(composite, SWT.BORDER);
		internalA.setLayout(new GridLayout(2,false));
		gd = new GridData(GridData.FILL_HORIZONTAL);
		gd.horizontalSpan = ncol;
		internalA.setLayoutData(gd);
		
		 versionIteratorButton = new Button(internalA, SWT.RADIO);
		 versionIteratorButton.setText("Version Iterator");
		 versionIteratorButton.setLayoutData(gd);
		 versionIteratorButton.setSelection(false);
		 versionIteratorButton.addListener(SWT.Selection, this);
		 
		 timeIteratorButton = new Button(internalA, SWT.RADIO);
		 timeIteratorButton.setText("Time Iterator");		 
		 timeIteratorButton.setLayoutData(gd);
		 timeIteratorButton.setSelection(false);
		 timeIteratorButton.addListener(SWT.Selection, this);
		 
		 new Label (composite, SWT.NONE).setText("Step Length:");	
		stepText = new Text(composite, SWT.BORDER);
		gd = new GridData(GridData.FILL_HORIZONTAL);
		stepText.setLayoutData(gd);
		stepText.addListener(SWT.KeyUp, this);
		
		stepUnitLabel = new Label (composite, SWT.NONE);
		stepUnitLabel.setText("Step Unit:");
		stepUnit = new Combo(composite, SWT.BORDER | SWT.READ_ONLY);
		stepUnit.setLayoutData(new GridData(GridData.END));
		stepUnit.setItems(units);
		stepUnit.addListener(SWT.Selection, this);
		
		 
		 defaultButton = new Button(composite, SWT.CHECK);
		 defaultButton.setText("Default");
		 gd = new GridData(GridData.FILL_HORIZONTAL);
		 gd.horizontalSpan = ncol;
		 defaultButton.setLayoutData(gd);
		 defaultButton.setSelection(false);
		 defaultButton.addListener(SWT.Selection, this);
		 
		 group = new Group(composite, SWT.BORDER);
		group.setLayout(new GridLayout(2,false));
		gd = new GridData(GridData.FILL_HORIZONTAL);
		gd.horizontalSpan = ncol;
		group.setLayoutData(gd);
		group.setEnabled(false);
		
		new Label (group, SWT.NONE).setText("Start:");	
		startText = new Text(group, SWT.BORDER);
		gd = new GridData(GridData.FILL_HORIZONTAL);
		startText.setLayoutData(gd);
		startText.addListener(SWT.KeyUp, this);
		
		new Label (group, SWT.NONE).setText("End:");	
		endText = new Text(group, SWT.BORDER);
		gd = new GridData(GridData.FILL_HORIZONTAL);
		endText.setLayoutData(gd);
		endText.addListener(SWT.KeyUp, this);
		
		gd = new GridData();
		gd.horizontalAlignment = GridData.BEGINNING;	
		forwardButton = new Button(group, SWT.RADIO);
		forwardButton.setText("Forward");
		forwardButton.setLayoutData(gd);
		forwardButton.setSelection(false); 
		forwardButton.addListener(SWT.Selection, this);
		
		backwardButton = new Button(group, SWT.RADIO);
		backwardButton.setText("Backward");		 
		backwardButton.setLayoutData(new GridData(GridData.END));
		backwardButton.setSelection(false);
		backwardButton.addListener(SWT.Selection, this);
		
		returnCopyButton = new Button(group, SWT.CHECK);
		returnCopyButton.setText("Return the copy of ProjectAnalysisData");
		gd = new GridData(GridData.FILL_HORIZONTAL);
		gd.horizontalSpan = ncol;
		returnCopyButton.setLayoutData(gd);
		returnCopyButton.setSelection(false);
		returnCopyButton.addListener(SWT.Selection, this);
		
		setControl(composite);
		setPageComplete(true);
		
	}
	
	
	@Override
	public boolean canFlipToNextPage() {
		// TODO Auto-generated method stub
//		return super.canFlipToNextPage();
		return true;
	}
	
	@Override
	public IWizardPage getNextPage() {
		if(versionIteratorButton.getSelection()){
			if(defaultButton.getSelection()){
				try {
					ProjectSpace projectSpace = WorkspaceManager.getInstance().getCurrentWorkspace().getActiveProjectSpace();
					Usersession session = projectSpace.getUsersession();
					ProjectId pid = (ProjectId) EcoreUtil.copy(projectSpace.getProjectId());
					VersionIterator iterator = new VersionIterator(session, pid, Integer.valueOf(stepText.getText()));

//					iterator = new VersionIterator(wizard.getSelectedUsersession(), wizard.getSelectedProjectId(), Integer.valueOf(stepText.getText()));
					while(iterator.hasNext()){
						System.out.println("At Version" + iterator.next().getPrimaryVersionSpec());
					}
				} catch (NumberFormatException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (IteratorException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
		return super.getNextPage();
	}

	public void handleEvent(Event event) {
		if(event.widget == versionIteratorButton){
			stepUnitLabel.setEnabled(false);
			stepUnit.setEnabled(false);
		}
		if(event.widget == timeIteratorButton){
			stepUnitLabel.setEnabled(true);
			stepUnit.setEnabled(true);
		}
		if(event.widget == defaultButton){
			group.setEnabled(!defaultButton.getSelection());
			for(Control control : group.getChildren()){
				control.setEnabled(!defaultButton.getSelection());
			}
		}
	}

}
