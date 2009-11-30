/**
 * <copyright> Copyright (c) 2008-2009 Jonas Helming, Maximilian Koegel. All rights reserved. This program and the
 * accompanying materials are made available under the terms of the Eclipse Public License v1.0 which accompanies this
 * distribution, and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>
 */
package org.unicase.workspace.ui.views.changes;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.jface.layout.GridDataFactory;
import org.eclipse.jface.layout.GridLayoutFactory;
import org.eclipse.jface.viewers.TreeViewer;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.events.SelectionListener;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.TabFolder;
import org.eclipse.swt.widgets.TabItem;
import org.unicase.emfstore.esmodel.versioning.ChangePackage;
import org.unicase.model.Project;
import org.unicase.workspace.ui.views.scm.SCMContentProvider;
import org.unicase.workspace.ui.views.scm.SCMLabelProvider;
import org.unicase.workspace.util.EventUtil;

/**
 * A composite that contains multiple tabs displaying the operation from a
 * different view - e.g. grouped by model element, or ungrouped.
 * 
 * @author Shterev
 */
public class TabbedChangesComposite extends Composite implements
		ChangesComposite {

	/**
	 * Tab listener.
	 * 
	 * @author Shterev
	 */
	private final class TabSelectionListener implements SelectionListener {
		public void widgetDefaultSelected(SelectionEvent e) {
			//
		}

		public void widgetSelected(SelectionEvent e) {
			String tab = "Unknown view";
			Control control = folder.getSelection()[0].getControl();
			if (control instanceof CompactChangesComposite) {
				tab = "Compact view";
			} else if (control instanceof DetailedChangesComposite) {
				tab = "Detailed view";
			}
			EventUtil.logPresentationSwitchEvent(getClass().getName(), tab);
		}
	}

	private TabFolder folder;
	private List<ChangePackage> changePackages;
	private Composite detailedTabComposite;
	private Composite compactTabComposite;
	private TreeViewer compactTabTreeViewer;
	private TreeViewer detailedTabTreeViewer;

	/**
	 * Default constructor.
	 * 
	 * @param parent
	 *            the composite's parent
	 * @param style
	 *            the style
	 * @param changePackages
	 *            the input of change packages as a list
	 */
	public TabbedChangesComposite(Composite parent, int style,
			List<ChangePackage> changePackages, Project project) {
		super(parent, style);

		setLayout(new GridLayout());
		folder = new TabFolder(this, style);
		GridDataFactory.fillDefaults().align(SWT.FILL, SWT.FILL).grab(true,
				true).applyTo(folder);
		this.changePackages = changePackages;

		// -----------------------Compact -----------------------------
		compactTabComposite = new Composite(folder, SWT.NONE);
		GridLayoutFactory.fillDefaults().applyTo(compactTabComposite);
		compactTabTreeViewer = new TreeViewer(compactTabComposite, SWT.H_SCROLL
				| SWT.V_SCROLL);
		GridDataFactory.fillDefaults().grab(true, true).applyTo(
				compactTabTreeViewer.getControl());

		SCMContentProvider.Compact compactContentProvider = new SCMContentProvider.Compact(
				compactTabTreeViewer, project);
		compactContentProvider.setShowRootNodes(true);
		SCMLabelProvider compactLabelProvider = new SCMLabelProvider(project);
		compactLabelProvider
				.setChangePackageVisualizationHelper(new ChangePackageVisualizationHelper(
						changePackages, project));
		compactContentProvider
				.setChangePackageVisualizationHelper(new ChangePackageVisualizationHelper(
						changePackages, project));
		compactTabTreeViewer.setContentProvider(compactContentProvider);
		compactTabTreeViewer.setLabelProvider(compactLabelProvider);
		compactTabTreeViewer.setInput(changePackages);
		compactTabTreeViewer.expandToLevel(2);

		TabItem meTab = new TabItem(folder, style);
		meTab.setText("Compact");
		meTab.setControl(compactTabComposite);

		// -----------------------Detailed -----------------------------
		detailedTabComposite = new Composite(folder, SWT.NONE);
		GridLayoutFactory.fillDefaults().applyTo(detailedTabComposite);

		detailedTabTreeViewer = new TreeViewer(detailedTabComposite,
				SWT.H_SCROLL | SWT.V_SCROLL);
		GridDataFactory.fillDefaults().grab(true, true).applyTo(
				detailedTabTreeViewer.getControl());

		SCMContentProvider.Detailed detailedContentProvider = new SCMContentProvider.Detailed(
				detailedTabTreeViewer, project);
		detailedContentProvider.setShowRootNodes(true);
		SCMLabelProvider detailedLabelProvider = new SCMLabelProvider(project);
		detailedLabelProvider
				.setChangePackageVisualizationHelper(new ChangePackageVisualizationHelper(
						changePackages, project));
		detailedContentProvider
				.setChangePackageVisualizationHelper(new ChangePackageVisualizationHelper(
						changePackages, project));
		detailedTabTreeViewer.setContentProvider(detailedContentProvider);
		detailedTabTreeViewer.setLabelProvider(detailedLabelProvider);
		detailedTabTreeViewer.setInput(changePackages);
		detailedTabTreeViewer.expandToLevel(2);

		TabItem opTab = new TabItem(folder, style);
		opTab.setText("Detailed");
		opTab.setControl(detailedTabComposite);
		folder.addSelectionListener(new TabSelectionListener());
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
		compactTabTreeViewer.setInput(changes);
		detailedTabTreeViewer.setInput(changes);
	}

	/**
	 * Getter for the tabs.
	 * 
	 * @return the tabs as an ArrayList.
	 */
	public ArrayList<AbstractChangesComposite> getTabs() {
		return new ArrayList<AbstractChangesComposite>();
	}

}
