/**
 * <copyright> Copyright (c) 2008 Jonas Helming, Maximilian Koegel. All rights reserved. This program and the
 * accompanying materials are made available under the terms of the Eclipse Public License v1.0 which accompanies this
 * distribution, and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>
 */
package org.unicase.workspace.edit.views.changes;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.jface.layout.GridDataFactory;
import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.TabFolder;
import org.eclipse.swt.widgets.TabItem;
import org.unicase.emfstore.esmodel.versioning.ChangePackage;

/**
 * A composite that contains multiple tabs displaying the operation from a different view - e.g. grouped by model
 * element, or ungrouped.
 * 
 * @author Shterev
 */
public class TabbedChangesComposite extends Composite implements ChangesComposite {

	private TabFolder folder;
	private List<ChangePackage> changePackages;
	private DetailedChangesComposite detailedTab;
	private CompactChangesComposite compactTab;
	private ArrayList<AbstractChangesComposite> tabs;

	/**
	 * Default constructor.
	 * 
	 * @param parent the composite's parent
	 * @param style the style
	 * @param changePackages the input of change packages as a list
	 */
	public TabbedChangesComposite(Composite parent, int style, List<ChangePackage> changePackages) {
		super(parent, style);

		setLayout(new GridLayout());
		tabs = new ArrayList<AbstractChangesComposite>();
		folder = new TabFolder(this, style);
		GridDataFactory.fillDefaults().align(SWT.FILL, SWT.FILL).grab(true, true).applyTo(folder);
		this.changePackages = changePackages;
		compactTab = new CompactChangesComposite(folder, SWT.NONE, AbstractChangesComposite.HORIZONTAL, changePackages);
		tabs.add(compactTab);
		compactTab.getTreeViewer().expandAll();
		TabItem meTab = new TabItem(folder, style);
		meTab.setText("Compact");
		meTab.setControl(compactTab);

		detailedTab = new DetailedChangesComposite(folder, SWT.NONE, AbstractChangesComposite.HORIZONTAL,
			changePackages);
		tabs.add(detailedTab);
		detailedTab.getTreeViewer().expandAll();
		TabItem opTab = new TabItem(folder, style);
		opTab.setText("Detailed");
		opTab.setControl(detailedTab);

	}

	/**
	 * {@inheritDoc}
	 */
	public List<ChangePackage> getChangePackages() {
		return changePackages;
	}

	/**
	 * {@inheritDoc}
	 */
	public void setInput(List<ChangePackage> changes) {
		this.changePackages = changes;
		compactTab.setInput(changes);
		detailedTab.setInput(changes);
	}

	/**
	 * Getter for the tabs.
	 * 
	 * @return the tabs as an ArrayList.
	 */
	public ArrayList<AbstractChangesComposite> getTabs() {
		return tabs;
	}

}
