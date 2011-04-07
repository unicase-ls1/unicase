package org.unicase.iterationplanner.ui.wizard.input;

import org.eclipse.jface.wizard.WizardPage;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.events.SelectionListener;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Label;
import org.unicase.iterationplanner.ui.wizard.PlannerController;
import org.unicase.iterationplanner.ui.wizard.ProjectController;

public abstract class AbstractInputPage extends WizardPage {

	ProjectController proejctBridge; 
	PlannerController plnnerBridge;
	
	protected AbstractInputPage(String pageName, ProjectController projectBridge, PlannerController plannerBridge) {
		super(pageName);
		this.proejctBridge = projectBridge;
		this.plnnerBridge = plannerBridge;
	}

	public void createControl(Composite parent) {
		Composite container = new Composite(parent, SWT.NULL);

		setControl(container);
		container.setLayout(new GridLayout(3, false));
		
		Composite sourceComposite = new Composite(container, SWT.NONE);
		sourceComposite.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true, 1, 1));
		sourceComposite.setLayout(new GridLayout(1, true));
		
		Label lblSourceDescription = new Label(sourceComposite, SWT.NONE);
		lblSourceDescription.setText(getSourceControlDescription());
		
		Composite sourceControlComposite = new Composite(sourceComposite, SWT.BORDER);
		sourceControlComposite.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true, 1, 1));
		createSourceControl(sourceControlComposite);
		
		Composite buttonsComposite = new Composite(container, SWT.NONE);
		buttonsComposite.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, false, true, 1, 1));
		buttonsComposite.setLayout(new GridLayout(1, true));
		
		Button btnAdd = new Button(buttonsComposite, SWT.CENTER);
		btnAdd.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, false, false, 1, 1));
		btnAdd.setText("Add >");
		btnAdd.addSelectionListener(new SelectionListener() {
			
			public void widgetSelected(SelectionEvent e) {
				onAddClicked();
			}
			public void widgetDefaultSelected(SelectionEvent e) {}
		});
		
		Button btnRemove = new Button(buttonsComposite, SWT.CENTER);
		btnRemove.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, false, false, 1, 1));
		btnRemove.setText("< Remove ");
		btnRemove.addSelectionListener(new SelectionListener() {
			
			public void widgetSelected(SelectionEvent e) {
				onRemoveClicked();
			}
			public void widgetDefaultSelected(SelectionEvent e) {}
		});
		
		
		Button btnAddAll = new Button(buttonsComposite, SWT.CENTER);
		btnAddAll.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, false, false, 1, 1));
		btnAddAll.setText("Add All >>");
		btnAddAll.addSelectionListener(new SelectionListener() {
			
			public void widgetSelected(SelectionEvent e) {
				onAddAllClicked();
			}
			public void widgetDefaultSelected(SelectionEvent e) {}
		});
		
		
		Button btnRemoveAll = new Button(buttonsComposite, SWT.CENTER);
		btnRemoveAll.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, false, false, 1, 1));
		btnRemoveAll.setText("<< Remove All ");
		btnRemoveAll.addSelectionListener(new SelectionListener() {
			
			public void widgetSelected(SelectionEvent e) {
				onRemoveAllClicked();
			}
			public void widgetDefaultSelected(SelectionEvent e) {}
		});
		
		
		Composite targetComposite = new Composite(container, SWT.NONE);
		targetComposite.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true, 1, 1));
		targetComposite.setLayout(new GridLayout(1, false));
		
		Label lblTargetDescription = new Label(targetComposite, SWT.NONE);
		lblTargetDescription.setText(getTargetContorlDescription());
		
		Composite targetControlComposite = new Composite(targetComposite, SWT.BORDER);
		targetControlComposite.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true, 1, 1));
		createTargetControl(targetControlComposite);
		
		if(hasExtraControls()){
			Composite extraControlsComposite = new Composite(container, SWT.NONE);
			extraControlsComposite.setLayoutData(new GridData(SWT.FILL, SWT.TOP, true, false, 3, 1));
			createExtraControls(extraControlsComposite);
		}
	}

	public ProjectController getProejctBridge() {
		return proejctBridge;
	}

	public PlannerController getPlannerBridge() {
		return plnnerBridge;
	}

	protected abstract String getTargetContorlDescription();

	protected abstract String getSourceControlDescription();
	
	protected abstract boolean hasExtraControls();

	/**
	 * subclasses that return hastExtraControls() true, must override this method to implementd 
	 * extra methods.
	 * @param extraControlsComposite
	 */
	protected void createExtraControls(Composite extraControlsComposite){
		 
	}
	
	protected abstract void onRemoveAllClicked();

	protected abstract void onAddAllClicked();

	protected abstract void onRemoveClicked();

	protected abstract void onAddClicked();

	protected abstract void createSourceControl(Composite sourceControlComposite);

	protected abstract void createTargetControl(Composite targetControlComposite);
	
}
