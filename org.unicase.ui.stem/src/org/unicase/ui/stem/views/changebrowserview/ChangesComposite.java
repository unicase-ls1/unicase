package org.unicase.ui.stem.views.changebrowserview;

import org.eclipse.jface.viewers.TableViewer;
import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;

public class ChangesComposite extends Composite {

	private TableViewer tableViewer;

	public ChangesComposite(Composite parent, int style) {
		super(parent, style);
		this.setLayout(new GridLayout());
		createTable();
		
	}

	private void createTable() {
		tableViewer = new TableViewer(this);
		tableViewer.getTable().setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true));
		
	}

}
