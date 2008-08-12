package org.unicase.ui.stem.views;

import java.net.URL;

import org.eclipse.core.runtime.Path;
import org.eclipse.core.runtime.Platform;
import org.eclipse.jface.resource.ImageDescriptor;
import org.eclipse.swt.SWT;
import org.eclipse.swt.custom.SashForm;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.ProgressBar;
import org.eclipse.swt.widgets.TabFolder;
import org.eclipse.swt.widgets.TabItem;
import org.eclipse.ui.part.ViewPart;

public class StatusView extends ViewPart {

	@Override
	public void createPartControl(Composite parent) {
		SashForm sash = new SashForm(parent, SWT.VERTICAL);
		
		

		GridLayout gridLayout = new GridLayout();
		gridLayout.numColumns=1;
				
//		composite.setLayout(gridLayout);
//		GridData gridData = new	GridData();
//		gridData.horizontalAlignment = GridData.FILL;
//		gridData.verticalAlignment=GridData.VERTICAL_ALIGN_BEGINNING;
//		gridData.grabExcessVerticalSpace=false;
//		gridData.grabExcessHorizontalSpace = true;
		Composite composite = new Composite(sash, SWT.NONE);

		ProgressBar pb = new ProgressBar(composite, SWT.HORIZONTAL);
	
		pb.setMinimum(0);

		pb.setMaximum(100);
		pb.setSelection(33);

		TabFolder tabFolder = new TabFolder(sash, SWT.TOP);
		
	
		URL url = Platform.find(Platform.getBundle("org.unicase.ui.stem"),
				new Path("icons/flatLayout.gif"));
		ImageDescriptor imageDescriptor = ImageDescriptor.createFromURL(url);
		TabItem flatTab = new TabItem(tabFolder, SWT.None);
		flatTab.setText("Flat view");
		flatTab.setImage(imageDescriptor.createImage());
		url = Platform.find(Platform.getBundle("org.unicase.ui.stem"),
				new Path("icons/hierarchicalLayout.gif"));
		imageDescriptor = ImageDescriptor.createFromURL(url);
		TabItem hirachieTab = new TabItem(tabFolder, SWT.None);
		hirachieTab.setText("Hirachical view");
		hirachieTab.setImage(imageDescriptor.createImage());
		
		sash.setWeights(new int[]{20,80});	
		composite.pack();

	}

	@Override
	public void setFocus() {
		// TODO Auto-generated method stub

	}

}
