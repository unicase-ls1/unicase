package org.unicase.ui.esbrowser.dialogs.admin;

import org.eclipse.jface.dialogs.Dialog;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Shell;
import org.unicase.workspace.AdminBroker;

public class ManageOrgUnitsDialog extends Dialog {

	private AdminBroker adminBroker;
	
	public ManageOrgUnitsDialog(Shell parentShell, AdminBroker adminBroker) {
		
		super(parentShell);
		
		this.setShellStyle(this.getShellStyle() | SWT.RESIZE );
		boolean aa = ((getShellStyle() & SWT.RESIZE) == SWT.RESIZE);
		this.adminBroker = adminBroker;
		
	}
	
	
	@Override
	protected Control createDialogArea(Composite parent) {
		Composite composite = (Composite) super.createDialogArea(parent);
		new OrgUnitManagementGUI(composite, adminBroker);
		return composite;
	}


//	@Override
//	protected Control createContents(Composite parent) {
//		Composite composite = (Composite) super.createContents(parent);
//		new OrgUnitManagementGUI(composite, adminBroker);
//		return parent;
//	}



	protected void cancelPressed() {
		
		super.cancelPressed();
	}

	
	protected void okPressed() {
		
		super.okPressed();
	}

}
