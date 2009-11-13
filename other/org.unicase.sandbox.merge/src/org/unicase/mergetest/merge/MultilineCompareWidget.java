package org.unicase.mergetest.merge;

import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Text;
import org.unicase.emfstore.esmodel.versioning.operations.AbstractOperation;
import org.unicase.mergetest.merge.conflicts.Conflict;

public class MultilineCompareWidget extends Composite {

	public MultilineCompareWidget(Composite parent, Conflict<AbstractOperation,AbstractOperation> conflict) {
		super(parent, SWT.NONE);
		setLayout(new GridLayout(3, true));
		GridData layoutData = new GridData(SWT.FILL, SWT.FILL, true, true);
		layoutData.widthHint=parent.getBounds().width;
		setLayoutData(layoutData);
		
		String firstOption = conflict.getOptions().get(0).getFullOptionLabel();
		String secondOption = conflict.getOptions().get(1).getFullOptionLabel();
		
		createColumn(firstOption,false);
		createColumn(secondOption,false);
		createColumn(firstOption+" "+secondOption,true);
	}

	private void createColumn(String text, boolean editable) {
		Text myAttribute = new Text(this, SWT.MULTI | SWT.WRAP | SWT.FLAT);
		myAttribute.setLayoutData(new GridData(GridData.FILL_BOTH));
		myAttribute.setText(text);
		myAttribute.setEditable(editable);
	}

}
