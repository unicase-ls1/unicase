package org.unicase.iterationplanner.ui.wizard.input;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.emf.edit.provider.ComposedAdapterFactory;
import org.eclipse.emf.edit.ui.provider.AdapterFactoryLabelProvider;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.viewers.TreeViewer;
import org.eclipse.jface.wizard.IWizardPage;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.events.SelectionListener;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.unicase.iterationplanner.ui.wizard.PlannerBridge;
import org.unicase.iterationplanner.ui.wizard.ProjectBridge;
import org.unicase.model.requirement.FunctionalRequirement;

public class DefineRequirementsPage extends AbstractInputPage {

	private static final String PAGE_TITLE = "Define Requirements";
	private static final String PAGE_DESCRIPTION= "define requirements page description";

	private TreeViewer srcReqsTreeViewer;
	private TreeViewer targetReqsTreeViewer;
	
	
	public DefineRequirementsPage(String pageName, ProjectBridge projectBridge, PlannerBridge plannerBridge) {
		super(pageName, projectBridge, plannerBridge);
		setTitle(PAGE_TITLE);
		setDescription(PAGE_DESCRIPTION);
	}


	@Override
	protected void createSourceControl(Composite parent) {
		parent.setLayout(new GridLayout());
		
		srcReqsTreeViewer = new TreeViewer(parent);
		srcReqsTreeViewer.getControl().setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true));
		
		srcReqsTreeViewer.setLabelProvider(new AdapterFactoryLabelProvider(new ComposedAdapterFactory(ComposedAdapterFactory.Descriptor.Registry.INSTANCE)));
		srcReqsTreeViewer.setContentProvider(new RequirementsContentProvider(new ComposedAdapterFactory(ComposedAdapterFactory.Descriptor.Registry.INSTANCE)));
		 List<FunctionalRequirement> topLevelRequirements = getProejctBridge().getTopLevelRequirements();
		srcReqsTreeViewer.setInput(topLevelRequirements);
	}


	@Override
	protected void createTargetControl(Composite parent) {
		parent.setLayout(new GridLayout());
		
		targetReqsTreeViewer = new TreeViewer(parent);
		targetReqsTreeViewer.getControl().setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true));
		
		targetReqsTreeViewer.setLabelProvider(new AdapterFactoryLabelProvider(new ComposedAdapterFactory(ComposedAdapterFactory.Descriptor.Registry.INSTANCE)));
		targetReqsTreeViewer.setContentProvider(new RequirementsContentProvider(new ComposedAdapterFactory(ComposedAdapterFactory.Descriptor.Registry.INSTANCE)));
		
		List<FunctionalRequirement> targetReqs = new ArrayList<FunctionalRequirement>();
		targetReqsTreeViewer.setInput(targetReqs);
	}


	@Override
	protected void onAddAllClicked() {
//		List<FunctionalRequirement> allSrcReqs = ((RequirementsContentProvider)srcReqsTreeViewer.getContentProvider()).getReqs();
//		StructuredSelection structuredSelection = new StructuredSelection(allSrcReqs);
//		srcReqsTreeViewer.setSelection(structuredSelection);
//		onAddClicked();
	
	}


	@Override
	protected void onAddClicked() {
		RequirementsContentProvider targetContentProvider = (RequirementsContentProvider) targetReqsTreeViewer.getContentProvider();
		RequirementsContentProvider srcContentProvider = (RequirementsContentProvider) srcReqsTreeViewer.getContentProvider();
		
		IStructuredSelection ssel = (IStructuredSelection) srcReqsTreeViewer.getSelection();
		for(Object obj : ssel.toList()){
			FunctionalRequirement fr = (FunctionalRequirement) obj;
			targetContentProvider.addReq(fr);
			srcContentProvider.removeReq(fr);
		}
		targetReqsTreeViewer.refresh();
		srcReqsTreeViewer.refresh();
		getWizard().getContainer().updateButtons();
	}



	@Override
	protected void onRemoveAllClicked() {
//		List<FunctionalRequirement> allTargetReqs = ((RequirementsContentProvider)targetReqsTreeViewer.getContentProvider()).getReqs();
//		StructuredSelection structuredSelection = new StructuredSelection(allTargetReqs);
//		targetReqsTreeViewer.setSelection(structuredSelection);
//		onRemoveClicked();
	}


	@Override
	protected void onRemoveClicked() {
		RequirementsContentProvider targetContentProvider = (RequirementsContentProvider) targetReqsTreeViewer.getContentProvider();
		RequirementsContentProvider srcContentProvider = (RequirementsContentProvider) srcReqsTreeViewer.getContentProvider();
		IStructuredSelection ssel = (IStructuredSelection) targetReqsTreeViewer.getSelection();
		for(Object obj : ssel.toList()){
			targetContentProvider.removeReq((FunctionalRequirement) obj);
			srcContentProvider.addReq((FunctionalRequirement) obj);
			
		}	
		targetReqsTreeViewer.refresh();
		srcReqsTreeViewer.refresh();
		getWizard().getContainer().updateButtons();
	}




	@Override
	protected boolean hasExtraControls() {
		return true;
	}
	
	


	@Override
	protected void createExtraControls(Composite extraControlsComposite) {
		extraControlsComposite.setLayout(new GridLayout(1, false));
		
		final Button chkSaveSession = new Button(extraControlsComposite, SWT.CHECK);
		chkSaveSession.setLayoutData(new GridData(SWT.BEGINNING, SWT.CENTER, false, false));
		chkSaveSession.setText("Save session ");
		chkSaveSession.setSelection(true);
		
		chkSaveSession.addSelectionListener(new SelectionListener() {
			
			public void widgetSelected(SelectionEvent e) {
				((IterationPlanningInputWizard)getWizard()).setSaveSession(chkSaveSession.getSelection());
			}
			
			public void widgetDefaultSelected(SelectionEvent e) {	}
		});
		
		final Button btnLoadSession = new Button(extraControlsComposite, SWT.PUSH);
		btnLoadSession.setLayoutData(new GridData(SWT.BEGINNING, SWT.CENTER, false, false));
		btnLoadSession.setText("Load previous session");
		btnLoadSession.setSelection(true);
		
		btnLoadSession.addSelectionListener(new SelectionListener() {
			
			public void widgetSelected(SelectionEvent e) {
				((IterationPlanningInputWizard)getWizard()).loadPreviousSession();
			}
			
			public void widgetDefaultSelected(SelectionEvent e) {	}
		});
		
		
		
		
	}


	@Override
	protected String getSourceControlDescription() {
		return "All requirements in the project: ";
	}


	@Override
	protected String getTargetContorlDescription() {
		return "Requirements to be planned: ";
	}


	@Override
	public boolean isPageComplete() {
		if(isEverythingOk()){
			return true;
		}
		return false;
	}


	private boolean isEverythingOk() {
		return true;
	}


	private void saveModel() {
		getPlannerBridge().setRequirements(((RequirementsContentProvider)targetReqsTreeViewer.getContentProvider()).getReqs());
	}


	@Override
	public IWizardPage getNextPage() {
		 if (isEverythingOk()){
			saveModel();
			IterationPlanningInputWizard wizard = (IterationPlanningInputWizard)getWizard();
			wizard.saveRequirements(((RequirementsContentProvider) targetReqsTreeViewer.getContentProvider()).getReqs());
			return wizard.getDefineTasksPage();
		 }  
		 return null;
	}

	

	

}
