package org.unicase.docExport.views;

import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;
import org.unicase.docExport.editors.AttributeOptionFactory;
import org.unicase.docExport.exportModel.Template;

/**
 * 
 * @author Sebastian Höcht
 *
 */
public class LayoutOptionsTab {
	
	/**
	 * 
	 * @param parent the SWT parent where this formular shall be added
	 * @param template the template which has the layoutOptions
	 */
	public LayoutOptionsTab(Composite parent, Template template) {
		Composite composite = new Composite(parent, SWT.NONE);
		GridLayout gLayout2 = new GridLayout();
		gLayout2.numColumns = 2;
//		gLayout2.makeColumnsEqualWidth = true;
		composite.setLayout(gLayout2);
		GridData gdata2 = new GridData(GridData.FILL_HORIZONTAL);
		gdata2.grabExcessHorizontalSpace = true;
		gdata2.grabExcessVerticalSpace = true;
		composite.setLayoutData(gdata2);
		
		AttributeOptionFactory factory = new AttributeOptionFactory();
		factory.buildOptionsFormular(composite, template.getLayoutOptions());
		
		composite.pack();
		composite.getParent().pack();
	}
	
}
