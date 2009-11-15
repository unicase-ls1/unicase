package org.unicase.mergetest.merge.ui.widgets;

import org.eclipse.jface.resource.FontRegistry;
import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Link;
import org.eclipse.swt.widgets.Text;
import org.eclipse.ui.forms.widgets.TableWrapLayout;
import org.unicase.mergetest.merge.conflict.ConflictOption;
import org.unicase.mergetest.merge.util.DecisionConfig;
import org.unicase.mergetest.merge.util.DecisionUtil;

public class MultilineWidget extends Composite {

	public MultilineWidget(Composite parent, ConflictOption option) {
		super(parent, SWT.NONE);
		setLayout(new TableWrapLayout());
		setBackground(parent.getBackground());

		Composite column = new Composite(this, SWT.NONE);
		column.setLayout(new TableWrapLayout());
		column.setBackground(getBackground());

		FontRegistry fontRegistry = DecisionUtil.getFontRegistry();

		Composite titleComposite = new Composite(column, SWT.NONE);
		titleComposite.setBackground(getBackground());
		titleComposite.setLayout(new GridLayout());

		String title = "";
		switch (option.getType()) {
		case MyOperation:
			title = "My Change";
			break;
		case TheirOperation:
			title = "Change on Repository";
			break;
		case Custom:
			title = option.getOptionLabel();
			break;
		}

		Link titl = new Link(titleComposite, SWT.NONE);
		titl.setText(title);
		titl.setBackground(getBackground());
		titl.setFont(fontRegistry.get("titleLabel"));

		Text myAttribute = new Text(column, SWT.MULTI | SWT.WRAP);
		myAttribute.setText(option.getFullOptionLabel());
		myAttribute.setBackground(getBackground());
		myAttribute.setEditable(option.getDetailProvider().endsWith(DecisionConfig.EDITABLE));
	}

}
