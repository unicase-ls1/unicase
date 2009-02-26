/**
 * <copyright> Copyright (c) 2008 Jonas Helming, Maximilian Koegel. All rights reserved. This program and the
 * accompanying materials are made available under the terms of the Eclipse Public License v1.0 which accompanies this
 * distribution, and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>
 */
package org.unicase.ui.stem.views.statusview;

import java.util.ArrayList;

import org.eclipse.jface.layout.GridDataFactory;
import org.eclipse.jface.layout.GridLayoutFactory;
import org.eclipse.jface.resource.JFaceResources;
import org.eclipse.swt.SWT;
import org.eclipse.swt.custom.StyleRange;
import org.eclipse.swt.custom.StyledText;
import org.eclipse.swt.widgets.Composite;
import org.unicase.model.task.WorkItem;
import org.unicase.model.task.WorkPackage;

/**
 * @author Shterev
 */
public class WorkPackageTabCategory extends Composite {

	private WorkPackageTabContentProvider contentProvider;

	private WorkPackage workPackage;

	private ArrayList<WorkPackageTabItem> items;

	private StyledText title;

	/**
	 * Default constructor.
	 * 
	 * @param parent the parent
	 * @param style the style
	 */
	public WorkPackageTabCategory(Composite parent, int style) {
		super(parent, style);
		GridLayoutFactory.fillDefaults().numColumns(1).spacing(0, 5).applyTo(this);
		title = new StyledText(this, SWT.WRAP);
		title.setEnabled(false);
		GridDataFactory.fillDefaults().grab(true, false).align(SWT.CENTER, SWT.BEGINNING).applyTo(title);
		items = new ArrayList<WorkPackageTabItem>();
	}

	private void refresh() {

		for (Composite c : items) {
			c.dispose();
		}

		if (workPackage == null) {
			throw new IllegalStateException("Cannot operate with a null input!");
		}
		int i = 0;
		for (Object item : contentProvider.getElements(workPackage)) {
			i++;
			WorkPackageTabItem tabItem = new WorkPackageTabItem(this, SWT.NONE, (WorkItem) item, i % 2);
			GridDataFactory.fillDefaults().grab(true, false).align(SWT.FILL, SWT.BEGINNING).applyTo(tabItem);
			items.add(tabItem);
		}

	}

	/**
	 * Sets the input for this view.
	 * 
	 * @param workPackage the input as a workpackage
	 */
	public void setInput(WorkPackage workPackage) {
		this.workPackage = workPackage;
		refresh();
	}

	/**
	 * Sets the content provider for this view.
	 * 
	 * @param provider the provider.
	 */
	public void setContentProvider(WorkPackageTabContentProvider provider) {
		this.contentProvider = provider;
		title.setText(provider.getKey());
		StyleRange st = new StyleRange();
		st.start = 0;
		st.length = title.getText().length();
		st.font = JFaceResources.getBannerFont();
		title.setStyleRange(st);
	}
}
