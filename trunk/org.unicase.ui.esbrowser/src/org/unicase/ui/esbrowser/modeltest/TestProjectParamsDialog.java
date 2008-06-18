package org.unicase.ui.esbrowser.modeltest;

import org.eclipse.jface.dialogs.Dialog;
import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Group;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Text;

public class TestProjectParamsDialog extends Dialog {

	
	Shell shell = null;
	
	private Label lblNumOfEachME;
	private Label lblRandomSeed;
	private Label lblProjectWidth;
	private Label lblProjectDepth;
	
	private Text txtNumOfEachME;
	private Text txtRandomSeed;
	private Text txtProjectWidth;
	private Text txtProjectDepth;
	
	
	public TestProjectParamsDialog(Shell parentShell) {
		super(parentShell);
	
	}



	@Override
	protected Control createDialogArea(Composite parent) {
		
		Composite composite = (Composite) super.createDialogArea(parent);
		createControls(composite);
		return composite;
	}
	
	private void createControls(Composite composite){
		
		shell = composite.getShell(); 
		shell.setText("Input Dialog"); 

		Group group = new Group(composite, SWT.None); 
		group.setText(""); 
		group.setLayoutData(new GridData(GridData.FILL_HORIZONTAL)); 
		group.setLayout(new GridLayout(2, true)); 
		
		lblNumOfEachME = new Label(group, SWT.None); 
		lblNumOfEachME.setText("Number of each ME:"); 
		txtNumOfEachME = new Text(group,SWT.BORDER); 
		txtNumOfEachME.setText("5"); 
		txtNumOfEachME.setLayoutData(new GridData(GridData.FILL_HORIZONTAL)); 

		lblRandomSeed = new Label(group, SWT.None); 
		lblRandomSeed.setText("Random seed:"); 
		txtRandomSeed = new Text(group,SWT.BORDER); 
		txtRandomSeed.setText("1334566732"); 
		txtRandomSeed.setLayoutData(new GridData(GridData.FILL_HORIZONTAL)); 
		
		lblProjectWidth = new Label(group, SWT.None); 
		lblProjectWidth.setText("Project width:"); 
		txtProjectWidth = new Text(group,SWT.BORDER); 
		txtProjectWidth.setText("2"); 
		txtProjectWidth.setLayoutData(new GridData(GridData.FILL_HORIZONTAL)); 
		
		lblProjectDepth = new Label(group, SWT.None); 
		lblProjectDepth.setText("Project depth:"); 
		txtProjectDepth = new Text(group,SWT.BORDER); 
		txtProjectDepth.setText("2"); 
		txtProjectDepth.setLayoutData(new GridData(GridData.FILL_HORIZONTAL)); 
		
		
		group.pack(); 
		composite.pack(); 

		
	}
	
	
	protected void createButtonsForButtonBar(Composite parent) { 
		 
		super.createButtonsForButtonBar(parent); 
	}



	@Override
	protected void okPressed() {
		
		int numOfEachME = Integer.parseInt(txtNumOfEachME.getText()) ;
		int randomSeed = Integer.parseInt(txtRandomSeed.getText()) ;
		int projectWidth = Integer.parseInt(txtProjectWidth.getText()) ;
		int projectDepth = Integer.parseInt(txtProjectDepth.getText()) ;
		
		super.okPressed();
		
		TestProject testProject = new TestProject(numOfEachME, randomSeed, projectWidth, projectDepth);		
		testProject.createProject();
		
		
		
	} 
	
}
