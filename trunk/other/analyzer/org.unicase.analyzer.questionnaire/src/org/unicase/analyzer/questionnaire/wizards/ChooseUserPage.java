/**
 * <copyright> Copyright (c) 2008 Jonas Helming, Maximilian Koegel. All rights reserved. This program and the accompanying materials are made available under the terms of the Eclipse Public License v1.0 which accompanies this distribution, and is available at http://www.eclipse.org/legal/epl-v10.html
 * </copyright>
 */

package org.unicase.analyzer.questionnaire.wizards;

import java.io.IOException;

import org.eclipse.jface.wizard.IWizardPage;
import org.eclipse.jface.wizard.WizardPage;
import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Event;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Listener;
import org.eclipse.swt.widgets.Text;
import org.eclipse.ui.IWorkbenchPage;
import org.eclipse.ui.PartInitException;
import org.eclipse.ui.PlatformUI;
import org.unicase.emfstore.esmodel.versioning.ChangePackage;
import org.unicase.model.Project;
import org.unicase.workspace.Configuration;
import org.unicase.workspace.ui.views.CompareView;
import org.unicase.workspace.util.ResourceHelper;


/**
 * @author liya
 *
 */
public class ChooseUserPage extends WizardPage implements Listener {

	private static final String DIR = Configuration.getWorkspaceDirectory();
	private static final String PAGE_TITLE = "User";
	private static final String PAGE_DESCRIPTION = "Please give your user number";
	private Text userNumber;

	protected ChooseUserPage(String pageName) {
		super(pageName);
		setTitle(PAGE_TITLE);
		setDescription(PAGE_DESCRIPTION);
	}

	/** 
	 * {@inheritDoc}
	 * @see org.eclipse.swt.widgets.Listener#handleEvent(org.eclipse.swt.widgets.Event)
	 */
	public void handleEvent(Event event) {
		if(event.widget == userNumber){
			setPageComplete(true);
		}
		getWizard().getContainer().updateButtons();
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

	    new Label (composite, SWT.NONE).setText("User Number:");	
		userNumber = new Text(composite, SWT.BORDER);
		gd = new GridData(GridData.FILL_HORIZONTAL);
		userNumber.setLayoutData(gd);
		userNumber.setFocus();
		userNumber.addListener(SWT.FocusOut, this);
		
		setControl(composite);
		setPageComplete(false);

	}
	
	@Override
	public IWizardPage getNextPage() {
		
//		ResourceSet resourceSet = ((QuestionnaireWizard) getWizard()).getResourceSet();
//		URI fileURI = URI.createFileURI(DIR + "/" + userNumber.getText() + "VersionInfo.info");
//		Resource resource = resourceSet.getResource(fileURI, true);
//		Map<Integer, Integer> map = (Map<Integer, Integer>) resource.getContents().get(0);
//		((QuestionnaireWizard) getWizard()).setCommitMap(map);
		
		
		String projectFileName = DIR + "/" + userNumber.getText() + "/projectstate-4.ups";
		String changeFileName = DIR + "/" + userNumber.getText() + "/changepackage-5.ucp";
		try {
			Project project = ResourceHelper.getElementFromResource(projectFileName, Project.class, 0);
			ChangePackage changePackage = ResourceHelper.getElementFromResource(changeFileName, ChangePackage.class, 0);

			 IWorkbenchPage page = PlatformUI.getWorkbench().getActiveWorkbenchWindow().getActivePage();
			 String viewId = "org.unicase.workspace.ui.views.CompareView";
			 CompareView compareView = null;
			 
			 compareView = (CompareView) page.showView(viewId);
			 
			 if (compareView != null) {
			 compareView.setInput(project, changePackage);
			 }
		} catch (IOException e) {
			e.printStackTrace();
		} catch (PartInitException e) {

			e.printStackTrace();
		}		
		getWizard().getContainer().getShell().setActive();
		return super.getNextPage();
	}

}
