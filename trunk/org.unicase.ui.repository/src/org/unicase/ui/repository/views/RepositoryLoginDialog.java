package org.unicase.ui.repository.views;

import org.eclipse.jface.dialogs.Dialog;
import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Text;

/**
 * Class for the login dialog.
 * 
 * @author shterev
 */
public class RepositoryLoginDialog extends Dialog {

	private Text username;
	private Text password;

	/**
	 * Default constructor.
	 * @param parent the parent shell
	 * @param invoker the invoker view
	 */
	public RepositoryLoginDialog(Shell parent, RepositoryView invoker) {
		super(parent);
	}

	/**
	 * Default method for initializing the UI.
	 * @param parent the parent Composite
	 */
	public void createControl(Composite parent) {

		GridData gd;
		Composite composite = new Composite(parent, SWT.NULL);

		GridLayout gl = new GridLayout();
		int ncol = 2;
		gl.numColumns = ncol;
		composite.setLayout(gl);

		new Label(composite, SWT.NONE).setText("Username:");
		username = new Text(composite, SWT.BORDER);
		gd = new GridData(GridData.FILL_HORIZONTAL);
		gd.horizontalSpan = ncol - 1;
		username.setLayoutData(gd);

		new Label(composite, SWT.NONE).setText("Password:");
		password = new Text(composite, SWT.BORDER);
		gd = new GridData(GridData.FILL_HORIZONTAL);
		gd.horizontalSpan = ncol - 1;
		password.setLayoutData(gd);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	protected void okPressed() {
		// result.removeAll(result);
		// int length = rightTable.getItems().length;
		// for(int i=0;i<length;i++){
		// result.add((EObject)rightViewer.getElementAt(i));
		// };
		// super.okPressed();
	}

}
