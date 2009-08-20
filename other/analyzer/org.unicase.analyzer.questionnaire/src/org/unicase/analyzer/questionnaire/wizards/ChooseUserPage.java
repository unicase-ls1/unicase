/**
 * <copyright> Copyright (c) 2008 Jonas Helming, Maximilian Koegel. All rights reserved. This program and the accompanying materials are made available under the terms of the Eclipse Public License v1.0 which accompanies this distribution, and is available at http://www.eclipse.org/legal/epl-v10.html
 * </copyright>
 */

package org.unicase.analyzer.questionnaire.wizards;

import java.io.IOException;

import org.eclipse.compare.CompareUI;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.compare.diff.metamodel.ComparisonSnapshot;
import org.eclipse.emf.compare.diff.metamodel.DiffModel;
import org.eclipse.emf.compare.ui.editor.ModelCompareEditorInput;
import org.eclipse.emf.compare.util.ModelUtils;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.jface.wizard.IWizardPage;
import org.eclipse.jface.wizard.WizardPage;
import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
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
	private Text commitNumber;
	private Button operationBased;
	private Button stateBased;

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
		if(isTextNonEmpty(userNumber)&& isTextNonEmpty(commitNumber) && (operationBased.getSelection()||stateBased.getSelection())){
			setPageComplete(true);
		}
		getWizard().getContainer().updateButtons();
	}
	
	private static boolean isTextNonEmpty(Text t)
	{
		String s = t.getText();
		if ((s!=null) && (s.trim().length() >0)) {
			return true;
		}
		return false;
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
		
		 new Label (composite, SWT.NONE).setText("Commit Number:");	
		commitNumber = new Text(composite, SWT.BORDER);
		gd = new GridData(GridData.FILL_HORIZONTAL);
		commitNumber.setLayoutData(gd);
		commitNumber.setFocus();
		commitNumber.addListener(SWT.FocusOut, this);
		
		operationBased = new Button(composite, SWT.RADIO);
		operationBased.setText("Operation Based");
		operationBased.setLayoutData(gd);
		operationBased.addListener(SWT.Selection, this);
		
		stateBased = new Button(composite, SWT.RADIO);
		stateBased.setText("State Based");
		stateBased.setLayoutData(gd);
		stateBased.addListener(SWT.Selection, this);
		
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
		
		
		if(operationBased.getSelection()){
		
			String projectFileName = DIR + userNumber.getText() + "/projectstate-" + (Integer.valueOf(commitNumber.getText())-1) + ".ups";
			String changeFileName = DIR + userNumber.getText() + "/changepackage-" + commitNumber.getText() + ".ucp";
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
		}else{
			String diffFileName = DIR  + userNumber.getText() + "/" + "diffModel" + commitNumber.getText() + ".emfdiff";
			
			ResourceSet resourceSet = new ResourceSetImpl();
			Resource resource = resourceSet.getResource(URI.createFileURI(diffFileName), true);
			EList<EObject> directContents = resource.getContents();
			DiffModel diff = (DiffModel) directContents.get(0);			
			
			
			try {
				EObject loadedSnapshot = ModelUtils.load(URI.createFileURI(diffFileName), resourceSet);
				if (loadedSnapshot instanceof ComparisonSnapshot) {
					CompareUI.openCompareEditorOnPage(new ModelCompareEditorInput((ComparisonSnapshot) loadedSnapshot),
						PlatformUI.getWorkbench().getActiveWorkbenchWindow().getActivePage());
				}
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
				
		}
		return super.getNextPage();
	}

}
