package org.unicase.ui.esbrowser.views.orgunit;

import org.eclipse.swt.widgets.Composite;
import org.eclipse.ui.part.ViewPart;
import org.unicase.ui.esbrowser.dialogs.admin.OrgUnitManagementGUI;

public class OrgUnitManagementView extends ViewPart {

	private OrgUnitManagementGUI instance = null;
	
	public OrgUnitManagementView() {
	
	}

	@Override
	public void createPartControl(Composite parent) {
		
		//instance = new OrgUnitManagementGUI(parent);

	}

	@Override
	public void setFocus() {
		instance.setFocus();

	}

	@Override
	public void dispose() {
		instance.dispose();
		instance = null;
		super.dispose();
	}

}
