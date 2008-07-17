package org.unicase.ui.taskview;

import org.eclipse.jface.viewers.TableViewer;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.ui.part.ViewPart;

public class TaskView extends ViewPart {

	private TableViewer viewer;

	public TaskView() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public void createPartControl(Composite parent) {
		viewer = new TableViewer(parent, SWT.V_SCROLL | SWT.H_SCROLL);
		

	}

	@Override
	public void setFocus() {
		// TODO Auto-generated method stub

	}

}
