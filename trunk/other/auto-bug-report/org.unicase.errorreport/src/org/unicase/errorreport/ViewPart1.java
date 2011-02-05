package org.unicase.errorreport;

import org.eclipse.swt.widgets.Composite;
import org.eclipse.ui.part.ViewPart;

public class ViewPart1 extends ViewPart {

	public ViewPart1() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public void createPartControl(Composite parent) {
		throw new NullPointerException("test exception for error report from view.");
	}

	@Override
	public void setFocus() {
		// TODO Auto-generated method stub

	}

}
