package org.unicase.documentexport.views;

import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;
import org.unicase.documentexport.documentTemplate.DocumentTemplate;
import org.unicase.documentexport.views.RendererOptionFactory.AttributeOptionFactory;

public class LayoutOptions {
	
	
	public LayoutOptions(Composite parent, DocumentTemplate template) {
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
		factory.buildOptionsFormular(composite, template.layoutOptions);
		
		composite.pack();
		composite.getParent().pack();
	}
	
}
