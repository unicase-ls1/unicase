package org.unicase.ui.stem.views.dialogs;

import org.eclipse.jface.dialogs.TitleAreaDialog;
import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Shell;
import org.unicase.ui.stem.views.ChangesTreeComposite;

public class MergeDialog extends TitleAreaDialog {

	public  MergeDialog(Shell parentShell) {
		super(parentShell);
		this.setShellStyle(this.getShellStyle() | SWT.RESIZE );
	}

	@Override
	protected void configureShell(Shell newShell) {
		super.configureShell(newShell);
		newShell.setText("Merge");
	}

	@Override
	protected Control createDialogArea(Composite parent) {
		Composite contents = new Composite(parent, SWT.NONE);
		contents.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true));
		contents.setLayout(new GridLayout(5, true));
		
		
		Label lblMyChanges = new Label(contents, SWT.NONE);
		lblMyChanges.setLayoutData(new GridData(SWT.BEGINNING, SWT.CENTER, false,
				false, 2, 1));
		lblMyChanges.setText("My changes: ");
		
		
		Label lblMergedChanges = new Label(contents, SWT.NONE);
		lblMergedChanges.setLayoutData(new GridData(SWT.CENTER, SWT.CENTER, false,
				false));
		lblMergedChanges.setText("Merged changes");
		
		Label lblTheirChanges = new Label(contents, SWT.NONE);
		lblTheirChanges.setLayoutData(new GridData(SWT.END, SWT.CENTER, false,
				false, 2, 1));
		lblTheirChanges.setText("Their changes: ");
		
		ChangesTreeComposite myChangesTree = new ChangesTreeComposite(contents,
				SWT.BORDER, true);
		myChangesTree.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true, 2, 1));
		
		ChangesTreeComposite mergedChangesTree = new ChangesTreeComposite(contents,
				SWT.BORDER, false);
		mergedChangesTree.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true));
		
		ChangesTreeComposite theirChangesTree = new ChangesTreeComposite(contents,
				SWT.BORDER, true);
		theirChangesTree.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true, 2, 1));
		
		
		lblMyChanges.setText("My changes: " + mergedChangesTree.getNumOfChanges());
		lblTheirChanges.setText("Their changes: " + mergedChangesTree.getNumOfChanges());
		
		setTitle("Merge");
		setMessage("Number of merged changes: " + mergedChangesTree.getNumOfChanges());
		
		return contents;
		
	}

	@Override
	protected void okPressed() {
		// TODO Auto-generated method stub
		super.okPressed();
	}

	@Override
	public int open() {
		this.getButton(TitleAreaDialog.OK).setText("Merge");
		return super.open();
	}

}
