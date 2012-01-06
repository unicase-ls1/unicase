/**
 * <copyright> Copyright (c) 2008-2009 Jonas Helming, Maximilian Koegel. All rights reserved. This program and the
 * accompanying materials are made available under the terms of the Eclipse Public License v1.0 which accompanies this
 * distribution, and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>
 */
package org.unicase.ui.urml.stakeholders.navigation;

import java.util.Observable;
import java.util.Observer;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.FillLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Table;
import org.eclipse.swt.widgets.TableColumn;
import org.eclipse.swt.widgets.TableItem;
import org.unicase.model.urml.StakeholderRole;
import org.unicase.ui.urml.stakeholders.Activator;
import org.unicase.ui.urml.stakeholders.config.UrmlSettingsManager;

/**
 * 
 * @author kterzieva
 */
public class ReviewStatusControl extends Composite {

	private Observer countObserver;
	private ReviewCountPublisher countPublisher;
	private Table table;
	private String[] titles = { "Type", "Reviewed", "Total", "%" };

	/**
	 * The construct. 
	 * Sets appropriate observers in order to track changes to the model element status correctly.
	 * Additionally, it creates the table where the metric information is shown.
	 * @param parent the parent composite
	 * @param style the style
	 */
	public ReviewStatusControl(Composite parent, int style) {
		super(parent, style);
		setObservers();
		createTable();
		updateStatus();
	}

	private void createTable() {
		setLayout(new FillLayout());
		table = new Table(this, SWT.NONE);
		table.setHeaderVisible(true);
		table.setLinesVisible(true);

		for (int i = 0; i < titles.length; i++) {
			TableColumn column = new TableColumn(table, SWT.NONE);
			column.setText(titles[i]);
		}
	}

	private void setObservers() {
		countPublisher = UrmlSettingsManager.INSTANCE.getReviewCountPublisher();
		
		countObserver = new Observer() {
			@Override
			public void update(Observable o, Object arg) {
				updateStatus();
			}
		};
		countPublisher.addObserver(countObserver);
		Activator.getRoleChangedPublisher().addObserver(countObserver);
	}

	private void updateStatus() {
		StakeholderRole role = UrmlSettingsManager.INSTANCE.getActiveRole();
		table.removeAll();
		int revCount, totalCount;
		TableItem item;
		if (role != null) {
			for (EClass elementType : role.getReviewSet().keySet()) {
				if (elementType == null) {
					continue;
				}
				item = new TableItem(table, SWT.NONE);
				item.setText(0, elementType.getName());
				revCount = countPublisher.getReviewCount(elementType);
				totalCount = countPublisher.getTotalCount(elementType);
				item.setText(1, "" + revCount);
				item.setText(2, "" + totalCount);
				item.setText(3, (int) (revCount * 100. / totalCount) + "%");
			}
		}
		//if no role is set as active
		item = new TableItem(table, SWT.NONE);
		item.setText(0, "All");
		revCount = countPublisher.getReviewCount();
		totalCount = countPublisher.getTotalCount();
		item.setText(1, "" + revCount);
		item.setText(2, "" + totalCount);
		item.setText(3, (int) (revCount * 100. / totalCount) + "%");

		for (int i = 0; i < titles.length; i++) {
			table.getColumn(i).pack();
		}
	}

	@Override
	public void dispose() {
		super.dispose();
		countPublisher.deleteObserver(countObserver);
		Activator.getRoleChangedPublisher().deleteObserver(countObserver);
	}
}
