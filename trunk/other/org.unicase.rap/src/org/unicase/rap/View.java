package org.unicase.rap;

import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Text;
import org.eclipse.ui.part.ViewPart;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.events.SelectionListener;
import org.eclipse.jface.dialogs.MessageDialog;


public class View extends ViewPart {

	public static final String ID = "org.unicase.rap.View";
	
	@Override
	public void createPartControl(Composite parent) {
		
		Composite top = new Composite(parent, SWT.NONE);
		top.setLayout(new GridLayout(1, false));
		


	}

	@Override
	public void setFocus() {
		// TODO Auto-generated method stub

	}

}

