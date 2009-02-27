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
import org.eclipse.swt.custom.ScrolledComposite;
import org.eclipse.swt.custom.StyleRange;
import org.eclipse.swt.custom.StyledText;
import org.eclipse.swt.graphics.Color;
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

	private Composite client;

	private ScrolledComposite scroller;

	/**
	 * Default constructor.
	 * 
	 * @param parent the parent
	 * @param style the style
	 */
	public WorkPackageTabCategory(Composite parent, int style) {
		super(parent, style);
		GridLayoutFactory.fillDefaults().numColumns(1).spacing(0, 0).applyTo(this);

		Composite titleComposite = new Composite(this, SWT.NONE);
		GridDataFactory.fillDefaults().grab(true, false).applyTo(titleComposite);
		GridLayoutFactory.fillDefaults().numColumns(1).spacing(0, 0).applyTo(titleComposite);
		// titleComposite.setBackground(new Color(getDisplay(), 115, 158, 227)); macos blue
		titleComposite.setBackground(new Color(getDisplay(), 157, 168, 185));
		titleComposite.setBackground(new Color(getDisplay(), 216, 5, 0));
		titleComposite.setBackgroundMode(SWT.INHERIT_FORCE);
		title = new StyledText(titleComposite, SWT.WRAP);
		title.setForeground(new Color(getDisplay(), 255, 255, 255));
		title.setEnabled(false);
		GridDataFactory.fillDefaults().grab(true, false).align(SWT.CENTER, SWT.BEGINNING).applyTo(title);

		scroller = new ScrolledComposite(this, SWT.H_SCROLL | SWT.V_SCROLL | SWT.BORDER);
		GridLayoutFactory.fillDefaults().numColumns(1).spacing(0, 0).applyTo(scroller);
		GridDataFactory.fillDefaults().grab(true, true).applyTo(scroller);
		scroller.setExpandHorizontal(true);
		scroller.setExpandVertical(true);
		scroller.getVerticalBar().setIncrement(20);
		scroller.getHorizontalBar().setIncrement(20);
		scroller.setBackground(new Color(getDisplay(), 0, 205, 205));

		client = new Composite(scroller, SWT.NONE);
		GridLayoutFactory.fillDefaults().numColumns(1).spacing(0, 0).applyTo(client);
		GridDataFactory.fillDefaults().grab(true, true).applyTo(client);

		items = new ArrayList<WorkPackageTabItem>();

		scroller.setContent(client);
	}

	/**
	 * Refreshes this category column.
	 */
	public void refresh() {

		for (Composite c : items) {
			c.dispose();
		}

		if (workPackage == null) {
			throw new IllegalStateException("Cannot operate with a null input!");
		}
		int i = 0;
		for (Object item : contentProvider.getElements(workPackage)) {
			i++;
			WorkPackageTabItem tabItem = new WorkPackageTabItem(client, SWT.NONE, (WorkItem) item, i % 2);
			GridDataFactory.fillDefaults().grab(true, false).align(SWT.FILL, SWT.BEGINNING).applyTo(tabItem);
			items.add(tabItem);
		}

		client.layout(true);
		scroller.setMinSize(client.computeSize(SWT.DEFAULT, SWT.DEFAULT));

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
