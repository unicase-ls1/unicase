package org.unicase.ui.stem.views;

import java.awt.Button;
import java.awt.dnd.DropTarget;

import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.ui.part.ViewPart;

public class StatusView extends ViewPart {

	@Override
	public void createPartControl(Composite parent) {
		Composite composite = new Composite(parent, SWT.H_SCROLL | SWT.V_SCROLL);
//		DropTarget dropTarget = new DropTarget(parent, new StatusViewDropAdapter());

	}

	@Override
	public void setFocus() {
		// TODO Auto-generated method stub

	}

}
