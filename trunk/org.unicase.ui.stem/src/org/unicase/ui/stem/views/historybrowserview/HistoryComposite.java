package org.unicase.ui.stem.views.historybrowserview;



import org.eclipse.jface.viewers.TableViewer;
import org.eclipse.swt.SWT;
import org.eclipse.swt.graphics.Font;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Group;
import org.eclipse.swt.widgets.Label;

public class HistoryComposite extends Composite {

	TableViewer tableViewer;
	
	public HistoryComposite(Composite parent, int style) {
		super(parent, style);
		this.setLayout(new GridLayout());
		createTable();
		createButtons();
	}

	private void createButtons() {
		Group grpButtons = new Group(this, SWT.NONE);
		grpButtons.setLayoutData(new GridData(SWT.CENTER, SWT.CENTER, false, false));
		grpButtons.setLayout(new GridLayout(10, true));
		
		Label lblFrom = new Label(grpButtons, SWT.NONE);
		lblFrom.setLayoutData(new GridData(SWT.RIGHT, SWT.CENTER, false, false));
		lblFrom.setText("From:");
		lblFrom.setFont(new Font(Display.getDefault(), "Tahoma", 8,SWT.BOLD));
		Label lblFrom2 = new Label(grpButtons, SWT.NONE);
		lblFrom2.setLayoutData(new GridData(SWT.LEFT, SWT.CENTER, false, false, 4, 1 ));
		lblFrom2.setText("here is the selected From version shown ....");
		
		Label lblTo = new Label(grpButtons, SWT.NONE);
		lblTo.setLayoutData(new GridData(SWT.RIGHT, SWT.CENTER, false, false));
		lblTo.setText("To:");
		lblTo.setFont(new Font(Display.getDefault(), "Tahoma", 8, SWT.BOLD));
		Label lblTo2 = new Label(grpButtons, SWT.NONE);
		lblTo2.setLayoutData(new GridData(SWT.LEFT, SWT.CENTER, false, false, 4, 1));
		lblTo2.setText("here is the selected To version shown ....");
		
		
		
		Button btnDiff = new Button(grpButtons, SWT.PUSH);
		GridData gridData1 = new GridData(SWT.RIGHT, SWT.CENTER, false, false, 3, 1);
		gridData1.widthHint = 70;
		btnDiff.setLayoutData(gridData1);
		btnDiff.setText("Diff");
		
		Button btnCreateTag = new Button(grpButtons, SWT.PUSH);
		btnCreateTag.setLayoutData(new GridData(SWT.RIGHT, SWT.CENTER, false, false));
		btnCreateTag.setText("Create Tag");
	
		Button btnUpdate = new Button(grpButtons, SWT.PUSH);
		GridData gridData2 = new GridData(SWT.CENTER, SWT.CENTER, false, false);
		gridData2.widthHint = 70;
		btnUpdate.setLayoutData(gridData2);
		btnUpdate.setText("Update");
		
		Button btnSwitch = new Button(grpButtons, SWT.PUSH);
		GridData gridData3 = new GridData(SWT.CENTER, SWT.CENTER, false, false);
		gridData3.widthHint = 70;
		btnSwitch.setLayoutData(gridData3);
		btnSwitch.setText("Switch");
		
		Button btnRollback = new Button(grpButtons, SWT.PUSH);
		GridData gridData4 = new GridData(SWT.CENTER, SWT.CENTER, false, false);
		gridData4.widthHint = 70;
		btnRollback.setLayoutData(gridData4);
		btnRollback.setText("Rollback");
			
	}

	private void createTable() {
		tableViewer = new TableViewer(this);
		tableViewer.getTable().setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true));
		
	}

}
