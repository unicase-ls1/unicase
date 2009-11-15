package org.unicase.mergetest.merge.ui.widgets;

import org.eclipse.jface.resource.FontRegistry;
import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Link;
import org.eclipse.swt.widgets.Text;
import org.eclipse.ui.forms.widgets.TableWrapData;
import org.eclipse.ui.forms.widgets.TableWrapLayout;
import org.unicase.mergetest.merge.conflict.Conflict;
import org.unicase.mergetest.merge.util.DecisionUtil;

public class MultilineCompareWidget extends Composite {

	public MultilineCompareWidget(Composite parent, Conflict conflict) {
		super(parent, SWT.NONE);
		
		TableWrapData wrapData = new TableWrapData();
		wrapData.grabHorizontal=true;
		wrapData.grabVertical=true;
		setLayoutData(wrapData);
		
		TableWrapLayout layout = new TableWrapLayout();
		layout.numColumns = 3;
		layout.makeColumnsEqualWidth=true;
		layout.topMargin=0;
		layout.bottomMargin=0;
		layout.rightMargin=0;
		layout.leftMargin=0;
		setLayout(layout);
		setBackground(parent.getBackground());
		
		
		String firstOption = conflict.getOptions().get(0).getOptionLabel();
		String secondOption = conflict.getOptions().get(1).getOptionLabel();
		
		createColumn(firstOption,"My Option",false);
		createColumn(secondOption,"Their Option",false);
		createColumn(firstOption+" "+secondOption,"Merge/Edit Option",true);
	}

	private void createColumn(String text, String title, boolean editable) {
		Composite column = new Composite(this, SWT.NONE);
		column.setLayout(new TableWrapLayout());
		column.setBackground(getBackground());
		
		FontRegistry fontRegistry = DecisionUtil.getFontRegistry();
		
		Composite titleComposite = new Composite(column, SWT.NONE);
		titleComposite.setBackground(getBackground());
		titleComposite.setLayout(new GridLayout());
		
		Link titl = new Link(titleComposite, SWT.NONE);
		titl.setText(title);
		titl.setBackground(getBackground());
		titl.setFont(fontRegistry.get("titleLabel"));
		
		Text myAttribute = new Text(column, SWT.MULTI | SWT.WRAP);
		myAttribute.setText(text);
		myAttribute.setBackground(getBackground());
		myAttribute.setEditable(editable);
	}

}
