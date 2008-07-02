package org.unicase.ui.esbrowser.views.orgunit;

import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.ui.PlatformUI;
import org.unicase.emfstore.esmodel.accesscontrol.ACGroup;

public class GroupComposite extends Composite {

	public GroupComposite(Composite parent, int style) {
		super(parent, style);
		this.setBackground(PlatformUI.getWorkbench().getDisplay().getSystemColor(SWT.COLOR_RED));
		this.setLayout(new GridLayout());
		createControls();
	}

	
	private void createControls() {
		// TODO Auto-generated method stub
		
	}

	public void updateControls(ACGroup group) {
		
		
	}

}
