package org.unicase.ui.stem.views.changebrowserview;

import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;
import org.unicase.emfstore.esmodel.versioning.ChangePackage;
import org.unicase.ui.stem.views.ChangesTreeComposite;

public class ChangesComposite extends Composite {

	private ChangePackage input;
	private ChangesTreeComposite changesTree;

	public ChangesComposite(Composite parent, int style) {
		super(parent, style);
		this.setLayout(new GridLayout());
		createTable();
		
	}

	private void createTable() {
		changesTree = new ChangesTreeComposite(this, SWT.BORDER, true);
		changesTree.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true));
		changesTree.setChangePackage(this.input);
		
	}

	public void setInput(ChangePackage changePackage) {
		this.input = changePackage;
		changesTree.setChangePackage(changePackage);
		
	}

}
