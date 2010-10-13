/**
 * <copyright> Copyright (c) 2008-2009 Jonas Helming, Maximilian Koegel. All rights reserved. This program and the
 * accompanying materials are made available under the terms of the Eclipse Public License v1.0 which accompanies this
 * distribution, and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>
 */
package org.unicase.workspace.ui.dialogs.merge.ui.widgets;

import java.util.ArrayList;
import java.util.Observable;
import java.util.Observer;

import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.TabFolder;
import org.eclipse.swt.widgets.TabItem;
import org.eclipse.ui.forms.widgets.TableWrapLayout;
import org.unicase.workspace.ui.dialogs.merge.conflict.Conflict;
import org.unicase.workspace.ui.dialogs.merge.conflict.ConflictOption;
import org.unicase.workspace.ui.dialogs.merge.conflict.options.MergeTextOption;
import org.unicase.workspace.ui.dialogs.merge.ui.DecisionBox;
import org.unicase.workspace.ui.dialogs.merge.ui.components.DetailsComponent;

/**
 * Is used to display longer conflicting text and to merge them.
 * 
 * @author wesendon
 */
// TODO RAP
public class MergeTextWidget implements Observer {

	private final DecisionBox decisionBox;
	private ArrayList<ConflictOption> options;
	private TabFolder tabFolder;
	private final DetailsComponent detailsComponent;

	/**
	 * Default constructor.
	 * 
	 * @param decisionBox container
	 * @param detailsComponent details component
	 */
	public MergeTextWidget(DecisionBox decisionBox, DetailsComponent detailsComponent) {
		this.decisionBox = decisionBox;
		this.detailsComponent = detailsComponent;
		options = new ArrayList<ConflictOption>();
		decisionBox.getConflict().addObserver(this);
	}

	/**
	 * Add involved ConflictOptions.
	 * 
	 * @param option option
	 */
	public void addOption(ConflictOption option) {
		options.add(option);
	}

	/**
	 * Called by container in order to build gui.
	 * 
	 * @param parent container
	 */
	public void createContent(Composite parent) {
		tabFolder = new TabFolder(parent, SWT.NONE);
		tabFolder.setBackground(parent.getBackground());
		tabFolder.setLayout(new TableWrapLayout());

		for (ConflictOption option : options) {
			createTab(tabFolder, option);
		}
	}

	private void createTab(TabFolder tabFolder, ConflictOption option) {
		TabItem tab = new TabItem(tabFolder, SWT.NONE);
		tab.setText(getTitle(option));
		// text.setTopMargin(5);
		// text.setLeftMargin(5);
		// text.setRightMargin(5);

	}

	private boolean isEditable(ConflictOption option) {
		return option instanceof MergeTextOption;
	}

	private String getTitle(ConflictOption option) {
		switch (option.getType()) {
		case MyOperation:
			return "My Version";
		case TheirOperation:
			return "Version from Repository";
		case Custom:
		case MergeText:
			return option.getOptionLabel();
		default:
			return "";
		}
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see java.util.Observer#update(java.util.Observable, java.lang.Object)
	 */
	public void update(Observable o, Object arg) {
		Conflict conflict = decisionBox.getConflict();
		if (conflict != null && conflict == o) {
			ConflictOption solution = conflict.getSolution();
			if (solution instanceof MergeTextOption) {
				for (int i = 0; i < options.size(); i++) {
					if (options.get(i) == solution) {
						detailsComponent.setExpanded(true);
						tabFolder.setSelection(i);
					}
				}
			}
		}
	}
}
