package org.unicase.ui.stem.views;

import java.net.URL;

import org.eclipse.core.runtime.Path;
import org.eclipse.core.runtime.Platform;
import org.eclipse.jface.resource.ImageDescriptor;
import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.ProgressBar;
import org.eclipse.swt.widgets.TabFolder;
import org.eclipse.swt.widgets.TabItem;
import org.eclipse.ui.part.ViewPart;

public class StatusView extends ViewPart {

	@Override
	public void createPartControl(Composite parent) {
		Composite composite = new Composite(parent, SWT.H_SCROLL | SWT.V_SCROLL);
//		composite.get
		GridLayout gridLayout = new GridLayout();
		gridLayout.numColumns=1;
				
		composite.setLayout(gridLayout);
		GridData gridData = new	GridData();
		gridData.horizontalAlignment = GridData.FILL;
		gridData.verticalAlignment=GridData.VERTICAL_ALIGN_BEGINNING;
		gridData.grabExcessVerticalSpace=false;
		gridData.grabExcessHorizontalSpace = true;
		

		ProgressBar pb = new ProgressBar(composite, SWT.HORIZONTAL);
		pb.setLayoutData(gridData);

		pb.setMinimum(0);

		pb.setMaximum(100);
		pb.setSelection(33);

		TabFolder tabFolder = new TabFolder(composite, SWT.TOP);
		gridData.grabExcessVerticalSpace=true;
		gridData.verticalSpan = 9;
		gridData.heightHint = 300;
		gridData.verticalAlignment=GridData.VERTICAL_ALIGN_FILL;
		tabFolder.setLayoutData(gridData);
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
		composite.pack();

	}

	@Override
	public void setFocus() {
		// TODO Auto-generated method stub

	}

}
