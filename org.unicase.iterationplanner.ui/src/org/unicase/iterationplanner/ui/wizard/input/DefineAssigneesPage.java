package org.unicase.iterationplanner.ui.wizard.input;

import java.util.List;

import org.eclipse.emf.edit.provider.ComposedAdapterFactory;
import org.eclipse.emf.edit.ui.provider.AdapterFactoryLabelProvider;
import org.eclipse.jface.viewers.ColumnLabelProvider;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.viewers.TableViewer;
import org.eclipse.jface.viewers.TableViewerColumn;
import org.eclipse.jface.viewers.TreeViewer;
import org.eclipse.jface.wizard.IWizardPage;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.ModifyEvent;
import org.eclipse.swt.events.ModifyListener;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.events.SelectionListener;
import org.eclipse.swt.graphics.Color;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Event;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Listener;
import org.eclipse.swt.widgets.Spinner;
import org.unicase.iterationplanner.ui.wizard.PlannerController;
import org.unicase.iterationplanner.ui.wizard.ProjectController;
import org.unicase.model.organization.OrgUnit;

public class DefineAssigneesPage extends AbstractInputPage {

	private static final String PAGE_TITLE = "Define Assignees";
	private static final String PAGE_DESCRIPTION= "Define Assignees page description";
	private static final String ITERATION_NUMBER = "iteration_number";
	private TreeViewer srcOrgUnitTreeViewer;
	private TableViewer usersToPlanTableViewer;
	private Spinner spnrNumOfIterations;
	private Spinner spnrDefaultAvailability;
	private UsersToPlanContentProvier usersToPlanContentProvier;
	private UsersToPlanLabelProvider usersToPlanLabelProvider;
	private int defaultAvailability = 20;
	

	public DefineAssigneesPage(String pageName, ProjectController projectBridge, PlannerController plannerBridge) {
		super(pageName, projectBridge, plannerBridge);
		setTitle(PAGE_TITLE);
		setDescription(PAGE_DESCRIPTION);
		
	}

	@Override
	protected void createSourceControl(Composite parent) {

		parent.setLayout(new GridLayout());
		
		srcOrgUnitTreeViewer = new TreeViewer(parent);
		srcOrgUnitTreeViewer.getControl().setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true));
		
		srcOrgUnitTreeViewer.setLabelProvider(new AdapterFactoryLabelProvider(new ComposedAdapterFactory(ComposedAdapterFactory.Descriptor.Registry.INSTANCE)));
		srcOrgUnitTreeViewer.setContentProvider(new SourceOrgUnitsContentProvider(getProejctBridge(), new ComposedAdapterFactory(ComposedAdapterFactory.Descriptor.Registry.INSTANCE)));
		srcOrgUnitTreeViewer.setInput(new Object());
		
		
	}

	@Override
	protected void createTargetControl(Composite parent) {
		parent.setLayout(new GridLayout());
		
		usersToPlanTableViewer = new TableViewer(parent, SWT.FULL_SELECTION | SWT.MULTI);
		usersToPlanTableViewer.getControl().setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true));
		
		usersToPlanContentProvier = new UsersToPlanContentProvier(new ComposedAdapterFactory(ComposedAdapterFactory.Descriptor.Registry.INSTANCE));
		usersToPlanTableViewer.setContentProvider(usersToPlanContentProvier);
		
		usersToPlanTableViewer.getTable().setHeaderVisible(true);
		usersToPlanLabelProvider = new UsersToPlanLabelProvider(new ComposedAdapterFactory(ComposedAdapterFactory.Descriptor.Registry.INSTANCE));
		TableViewerColumn tclAssignee = new TableViewerColumn(usersToPlanTableViewer, SWT.LEFT);
		tclAssignee.getColumn().setText("Assignee");
		tclAssignee.getColumn().setWidth(100);
		tclAssignee.setLabelProvider(new ColumnLabelProvider(){
			@Override
			public String getText(Object element) {
				if(element instanceof UserAvailability){
					return ((UserAvailability)element).getUser().getName();
				}
				return super.getText(element);
			}

			@Override
			public Image getImage(Object element) {
				return usersToPlanLabelProvider.getImage(element);
			}

			@Override
			public Color getBackground(Object element) {
				return usersToPlanLabelProvider.getBackground(element);
			}
			
		});
		
		addIterationColumn(0);
		
		// Pack the columns
	    for (int i = 0; i < usersToPlanTableViewer.getTable().getColumnCount(); i++) {
	      usersToPlanTableViewer.getTable().getColumn(i).pack();
	    }
	    usersToPlanTableViewer.getTable().setLinesVisible(true);
	    usersToPlanTableViewer.getTable().addListener(SWT.MouseUp, new Listener() {
			public void handleEvent(Event event) {
				getWizard().getContainer().updateButtons();
			}
		});
		
		usersToPlanTableViewer.setInput(new Object());
	}

	
	private void addIterationColumn(int iterNumber){
			final TableViewerColumn tclIterationAvailability = new TableViewerColumn(usersToPlanTableViewer, SWT.LEFT);
			tclIterationAvailability.getColumn().setText("Iteration " + (iterNumber + 1));
			tclIterationAvailability.getColumn().setWidth(100);
			tclIterationAvailability.getColumn().setData(ITERATION_NUMBER, iterNumber);
			
			tclIterationAvailability.setLabelProvider(new ColumnLabelProvider(){
				@Override
				public String getText(Object element) {
					if(element instanceof UserAvailability){
						return String.valueOf(((UserAvailability)element).getAvailability((Integer)tclIterationAvailability.getColumn().getData(ITERATION_NUMBER)));
					}
					return super.getText(element);
				}
				
				@Override
				public Color getBackground(Object element) {
					return usersToPlanLabelProvider.getBackground(element);
				}
				
			});
			tclIterationAvailability.setEditingSupport(new UserAvailabilityEditingSupport(usersToPlanTableViewer, iterNumber));
			
	}
	
	@Override
	protected void onAddAllClicked() {
		
	}

	@Override
	protected void onAddClicked() {
		UsersToPlanContentProvier targetContentProvider = (UsersToPlanContentProvier) usersToPlanTableViewer.getContentProvider();
		SourceOrgUnitsContentProvider srcContentProvider = (SourceOrgUnitsContentProvider) srcOrgUnitTreeViewer.getContentProvider();
		
		IStructuredSelection ssel = (IStructuredSelection) srcOrgUnitTreeViewer.getSelection();
		for(Object obj : ssel.toList()){
			OrgUnit ou = (OrgUnit) obj;
			targetContentProvider.addOrgUnit(ou, getDefaultAvailability());
			srcContentProvider.removeOrgUnit(ou);
		}
		usersToPlanTableViewer.refresh();
		srcOrgUnitTreeViewer.refresh();
		getWizard().getContainer().updateButtons();
	}

	private int getDefaultAvailability() {
		return defaultAvailability; 
	}

	@Override
	protected void onRemoveAllClicked() {
		
	}

	@Override
	protected void onRemoveClicked() {
		UsersToPlanContentProvier targetContentProvider = (UsersToPlanContentProvier) usersToPlanTableViewer.getContentProvider();
		SourceOrgUnitsContentProvider srcContentProvider = (SourceOrgUnitsContentProvider) srcOrgUnitTreeViewer.getContentProvider();
		
		IStructuredSelection ssel = (IStructuredSelection) usersToPlanTableViewer.getSelection();
		for(Object obj : ssel.toList()){
			UserAvailability ua = (UserAvailability) obj;
			targetContentProvider.removeUserAvailability(ua);
			srcContentProvider.addUser(ua.getUser());
		}
		usersToPlanTableViewer.refresh();
		srcOrgUnitTreeViewer.refresh();
		getWizard().getContainer().updateButtons();
	}

	
	@Override
	protected void createExtraControls(Composite extraControlsComposite) {
		extraControlsComposite.setLayout(new GridLayout(3, false));
		
		Label lblNumOfIterations = new Label(extraControlsComposite, SWT.NONE);
		lblNumOfIterations.setLayoutData(new GridData(SWT.BEGINNING, SWT.TOP, false, false));
		lblNumOfIterations.setText("Number of Iterations: ");
		
		spnrNumOfIterations = new Spinner(extraControlsComposite, SWT.BORDER);
		spnrNumOfIterations.setLayoutData(new GridData(SWT.BEGINNING, SWT.CENTER, false, false));
		spnrNumOfIterations.setMaximum(5);
		spnrNumOfIterations.setMinimum(1);
		spnrNumOfIterations.setIncrement(1);
		spnrNumOfIterations.addModifyListener(new ModifyListener() {
			public void modifyText(ModifyEvent e) {
				getPlannerBridge().setNumOfIteations(Integer.valueOf(spnrNumOfIterations.getText()));
				int numOfIteations = getPlannerBridge().getNumOfIteations();
				int currentNumOfIterations = usersToPlanTableViewer.getTable().getColumnCount() - 1;
				if(numOfIteations > currentNumOfIterations){
					for(int i = currentNumOfIterations; i < numOfIteations; i++){
						//add iteration
						usersToPlanContentProvier.addIteration(defaultAvailability);
						//add column
						addIterationColumn(i);
					}
				}else {
					for(int i = numOfIteations; i < currentNumOfIterations; i++){
						// remove column
						usersToPlanTableViewer.getTable().getColumns()[i + 1].dispose();
						// remove iteration
						usersToPlanContentProvier.removeIteration();
					}
				}
				usersToPlanTableViewer.refresh();
				getWizard().getContainer().updateButtons();
			}
		});
		
		Label label = new Label(extraControlsComposite, SWT.NONE);
		label.setLayoutData(new GridData(SWT.BEGINNING, SWT.CENTER, false, false));
		label.setText("");
		
		
		
		Label lblDefaultAvailability = new Label(extraControlsComposite, SWT.NONE);
		lblDefaultAvailability.setLayoutData(new GridData(SWT.BEGINNING, SWT.CENTER, false, false));
		lblDefaultAvailability.setText("Set the default availability during iterations for all assignees: ");
		
		spnrDefaultAvailability = new Spinner(extraControlsComposite, SWT.BORDER);
		spnrDefaultAvailability.setLayoutData(new GridData(SWT.BEGINNING, SWT.CENTER, false, false));
		spnrDefaultAvailability.setMaximum(1000);
		spnrDefaultAvailability.setMinimum(defaultAvailability); //init = 20
		spnrDefaultAvailability.setIncrement(1);
		spnrDefaultAvailability.addModifyListener(new ModifyListener() {
			
			public void modifyText(ModifyEvent e) {
				defaultAvailability = Integer.parseInt(spnrDefaultAvailability.getText());
			}
		});
		
		Button btnApplyToAll = new Button(extraControlsComposite, SWT.PUSH);
		btnApplyToAll.setLayoutData(new GridData(SWT.BEGINNING, SWT.CENTER, false, false));
		btnApplyToAll.setText("Apply to All");
		btnApplyToAll.addSelectionListener(new SelectionListener() {
			
			public void widgetSelected(SelectionEvent e) {
				usersToPlanContentProvier.setAvailabilityForAll(defaultAvailability);
				usersToPlanTableViewer.refresh();
				getWizard().getContainer().updateButtons();
			}
			
			public void widgetDefaultSelected(SelectionEvent e) {
			}
		});
		
		
		
	}


	@Override
	protected boolean hasExtraControls() {
		return true;
	}

	@Override
	protected String getSourceControlDescription() {
		return "All users/groups in the project: ";
	}

	@Override
	protected String getTargetContorlDescription() {
		return "Assignees for iteration planning: ";
	}

	@Override
	public boolean isPageComplete() {
		if(isEverythingOk()){
			return true;
		}
		return false;
	}


	private boolean isEverythingOk() {
		List<UserAvailability> userAvailabilities = ((UsersToPlanContentProvier)usersToPlanTableViewer.getContentProvider()).getUserAvailabilities();
		if (userAvailabilities.size() == 0){
			return false;
		}
		for(UserAvailability ua : userAvailabilities){
			if(ua.hasUndifinedAvailability()){
				return false;
			}
		}
		return true;
	}


	private void saveModel() {
		getPlannerBridge().setAssignees(((UsersToPlanContentProvier)usersToPlanTableViewer.getContentProvider()).getUserAvailabilities());
		getPlannerBridge().setNumOfIteations(Integer.valueOf(spnrNumOfIterations.getText()));
	}


	@Override
	public IWizardPage getNextPage() {
		 if (isEverythingOk()){
			saveModel();
		//	return ((IterationPlanningInputWizard)getWizard()).getDefinePlannerParametersPage();
		 }  
		 return null;
	}




	
	
}
