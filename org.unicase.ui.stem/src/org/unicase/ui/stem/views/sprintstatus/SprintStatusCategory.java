/**
 * <copyright> Copyright (c) 2015-2016 Chair of Applied Software Engineering, Technische Universität München (TUM).
 * All rights reserved. This program and the accompanying materials are made available under the terms of
 * the Eclipse Public License v1.0 which accompanies this distribution,
 * and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>
 */
package org.unicase.ui.stem.views.sprintstatus;

import java.util.ArrayList;

import org.eclipse.emf.ecore.EReference;
import org.eclipse.jface.layout.GridDataFactory;
import org.eclipse.jface.layout.GridLayoutFactory;
import org.eclipse.jface.resource.JFaceResources;
import org.eclipse.swt.SWT;
import org.eclipse.swt.custom.ScrolledComposite;
import org.eclipse.swt.custom.StyleRange;
import org.eclipse.swt.custom.StyledText;
import org.eclipse.swt.graphics.Color;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Label;
import org.unicase.model.organization.OrgUnit;
import org.unicase.model.task.WorkItem;
import org.unicase.model.task.WorkPackage;

/**
 * @author Shterev
 */
public class SprintStatusCategory extends Composite {

	/**
	 * Separator to group the work items by assignees.
	 * 
	 * @author Shterev
	 */
	private class SprintCategorySeparator extends Composite {

		private Label label;

		public SprintCategorySeparator(Composite parent, int style) {
			super(parent, style);
			GridLayoutFactory.fillDefaults().numColumns(1).spacing(0, 0).applyTo(this);
			GridDataFactory.fillDefaults().grab(true, false).applyTo(this);
			label = new Label(this, SWT.WRAP);
			GridDataFactory.fillDefaults().grab(true, false).applyTo(label);
			label.setForeground(getDisplay().getSystemColor(SWT.COLOR_WHITE));
			label.setBackground(new Color(getDisplay(), 217, 160, 53));
			label.setBackground(new Color(getDisplay(), 130, 130, 130));
			label.setBackground(new Color(getDisplay(), 189, 98, 53));

			Composite line = new Composite(this, SWT.NONE);
			GridDataFactory.fillDefaults().hint(2, 2).grab(true, false).applyTo(line);
			line.setBackground(getDisplay().getSystemColor(SWT.COLOR_RED));
			line.setBackground(new Color(getDisplay(), 125, 55, 29));
		}

		public void setLabel(String text) {
			this.label.setText("  " + text);
		}

	}

	private SprintStatusContentProvider contentProvider;

	private WorkPackage workPackage;

	private ArrayList<SprintStatusItem> items;

	private StyledText title;

	private Composite client;

	private ScrolledComposite scroller;

	private boolean showGroups;

	/**
	 * Default constructor.
	 * 
	 * @param parent the parent
	 * @param style the style
	 */
	public SprintStatusCategory(Composite parent, int style) {
		super(parent, style);
		GridLayoutFactory.fillDefaults().numColumns(1).spacing(0, 0).applyTo(this);

		Composite titleComposite = new Composite(this, SWT.NONE);
		GridDataFactory.fillDefaults().grab(true, false).applyTo(titleComposite);
		GridLayoutFactory.fillDefaults().numColumns(1).spacing(0, 0).applyTo(titleComposite);
		// titleComposite.setBackground(new Color(getDisplay(), 115, 158, 227)); macos blue
		titleComposite.setBackground(new Color(getDisplay(), 186, 4, 0));
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

		createClient();

		items = new ArrayList<SprintStatusItem>();
	}

	private void createClient() {
		if (client != null) {
			client.dispose();
		}
		client = new Composite(scroller, SWT.NONE);
		GridLayoutFactory.fillDefaults().numColumns(1).spacing(0, 5).applyTo(client);
		GridDataFactory.fillDefaults().grab(true, true).applyTo(client);
		// client.setBackground(new Color(getDisplay(), 130, 130, 130));
		// client.setBackground(new Color(getDisplay(), 255, 255, 255));
		scroller.setContent(client);
	}

	/**
	 * Refreshes this category column.
	 */
	public void refresh() {

		createClient();

		if (workPackage == null) {
			return;
		}
		int i = 0;

		OrgUnit prevUser = null;
		for (Object item : contentProvider.getElements(workPackage)) {
			WorkItem workItem = (WorkItem) item;
			EReference userReference = contentProvider.getUserReference();
			if (userReference != null) {
				OrgUnit user = (OrgUnit) workItem.eGet(userReference);
				// TODO AS: replace with a proper data structure
				if (user == null && prevUser != null && showGroups) {
					SprintCategorySeparator separator = new SprintCategorySeparator(client, SWT.NONE);
					separator.setLabel("Unassigned");
				} else if (user != null && !user.equals(prevUser) && showGroups) {
					SprintCategorySeparator separator = new SprintCategorySeparator(client, SWT.NONE);
					separator.setLabel(user.getName());
				}
				prevUser = user;
			}
			i++;
			SprintStatusItem tabItem = new SprintStatusItem(client, SWT.NONE, workItem, i % 2);
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
	public void setContentProvider(SprintStatusContentProvider provider) {
		this.contentProvider = provider;
		title.setText(provider.getKey());
		StyleRange st = new StyleRange();
		st.start = 0;
		st.length = title.getText().length();
		st.font = JFaceResources.getBannerFont();
		title.setStyleRange(st);
	}

	/**
	 * @return the {@link SprintStatusContentProvider}
	 */
	public SprintStatusContentProvider getContentProvider() {
		return this.contentProvider;
	}

	/**
	 * Turns the group captions on/off.
	 * 
	 * @param showGroups the visibility
	 */
	public void setShowGroups(boolean showGroups) {
		this.showGroups = showGroups;
	}
}
