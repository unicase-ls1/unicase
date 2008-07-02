package org.unicase.ui.esbrowser.views.orgunit;

import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.ui.PlatformUI;
import org.unicase.emfstore.esmodel.accesscontrol.ACUser;

public class UserComposite extends Composite {

	
	
	public UserComposite(Composite parent, int style) {
		super(parent, style);
		this.setBackground(PlatformUI.getWorkbench().getDisplay().getSystemColor(SWT.COLOR_BLUE));
		createControls();
	}

	
	private void createControls() {
		
		
	}

	public void updateControls(ACUser user) {
		
		
	}

}
