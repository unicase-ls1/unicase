package org.unicase.ui.stem.views.dialogs;

import org.eclipse.jface.dialogs.TitleAreaDialog;
import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Text;
import org.unicase.ui.stem.views.ChangesTreeComposite;

public class CommitDialog extends TitleAreaDialog {

	public CommitDialog(Shell parentShell) {

		super(parentShell);
		this.setShellStyle(this.getShellStyle() | SWT.RESIZE );
		

	}

	
	@Override
	protected Control createDialogArea(Composite parent) {
		Composite contents = new Composite(parent, SWT.NONE);
		contents.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true));
		contents.setLayout(new GridLayout(2, false));
		
		
	
		ChangesTreeComposite changesTree = new ChangesTreeComposite(contents,
				SWT.NONE);
		changesTree.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true, 2, 1));

		Label lblLogMsg = new Label(contents, SWT.NONE);
		lblLogMsg.setLayoutData(new GridData(SWT.BEGINNING, SWT.CENTER, true,
				true, 2, 1));
		lblLogMsg.setText("Log message:");
		
		Text txtLogMsg = new Text(contents, SWT.MULTI | SWT.LEAD | SWT.BORDER);
		txtLogMsg.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, false, 2, 1));
		txtLogMsg.setText("");
		
		setTitle("Commit");
		setMessage("Number of changes: " + changesTree.getNumOfChanges());
		
		return contents;

	}
	
	@Override
	protected void configureShell(Shell newShell) {
		
		super.configureShell(newShell);
		newShell.setText("Commit");
	}


	@Override
	protected void okPressed() {
		// TODO Auto-generated method stub
		super.okPressed();
	}

	
	@Override
	public int open() {
		this.getButton(TitleAreaDialog.OK).setText("Commit");
		return super.open();
	}
	
}





//Label lblUncommitedChanges = new Label(contents, SWT.NONE);
//lblUncommitedChanges.setLayoutData(new GridData(SWT.BEGINNING,
//		SWT.CENTER, true, false));
//lblUncommitedChanges.setText("Uncommited Changes");
//
//Label lblNumOfChanges = new Label(contents, SWT.NONE);
//lblNumOfChanges.setLayoutData(new GridData(SWT.END, SWT.CENTER, false,
//		false));
//lblNumOfChanges.setText("Total number of changes:");
