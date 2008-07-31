package org.unicase.ui.esbrowser.dialogs.admin;

import org.eclipse.jface.dialogs.Dialog;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Shell;
import org.unicase.workspace.AdminBroker;

public class ManageOrgUnitsDialog extends Dialog {

	private AdminBroker adminBroker;
	
	public ManageOrgUnitsDialog(Shell parentShell, AdminBroker adminBroker) {
		
		super(parentShell);
		this.adminBroker = adminBroker;
	}
	
	
	@Override
	protected Control createContents(Composite parent) {
		
		OrgUnitManagementGUI.createInstance(parent);
		OrgUnitManagementGUI.getInstance().setAdminBroker(adminBroker);
		return parent;
	}



	protected void cancelPressed() {
		
		super.cancelPressed();
	}

	
	protected void okPressed() {
		
		super.okPressed();
	}

}
