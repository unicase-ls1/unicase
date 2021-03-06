/**
 * <copyright> Copyright (c) 2008-2009 Jonas Helming, Maximilian Koegel. All rights reserved. This program and the
 * accompanying materials are made available under the terms of the Eclipse Public License v1.0 which accompanies this
 * distribution, and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>
 */
package org.unicase.emailnotifierpreferences.properties;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;

import org.eclipse.jface.layout.GridDataFactory;
import org.eclipse.jface.layout.GridLayoutFactory;
import org.eclipse.jface.viewers.ArrayContentProvider;
import org.eclipse.jface.viewers.CheckStateChangedEvent;
import org.eclipse.jface.viewers.CheckboxTableViewer;
import org.eclipse.jface.viewers.ColumnLabelProvider;
import org.eclipse.jface.viewers.ICheckStateListener;
import org.eclipse.jface.viewers.ISelectionChangedListener;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.viewers.SelectionChangedEvent;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Label;
import org.unicase.model.emailnotificationgroup.NotificationGroup;
import org.unicase.workspace.preferences.DashboardKey;
import org.unicase.workspace.preferences.PropertyKey;

/**
 * A Class for the EMail Notifier Service. The Constructor creates a Composite holding the notification providers for a
 * certain Notification Group.
 * 
 * @author MastaFue
 */
public class CompositeNotificationTypeSelection extends Composite {

	private CheckboxTableViewer notifierTypesList;
	private HashMap<PropertyKey, String[]> providerHints;

	/**
	 * Constructor creates a Composite holding the notification providers that can be selected for a certain
	 * Notification Group.
	 * 
	 * @param c The parent Composite.
	 * @param tempNotificationGroups List holding all the Notification Groups.
	 * @param group The currently selected Notification Group.
	 */
	public CompositeNotificationTypeSelection(Composite c, final List<NotificationGroup> tempNotificationGroups,
		final NotificationGroup group) {
		super(c, SWT.NONE);
		init();
		GridLayoutFactory.fillDefaults().applyTo(this);
		GridDataFactory.fillDefaults().applyTo(this);

		Label selectNotifier = new Label(this, SWT.PUSH | SWT.TOP | SWT.WRAP);
		GridDataFactory.fillDefaults().align(SWT.FILL, SWT.CENTER).hint(150, SWT.DEFAULT).grab(true, false).applyTo(
			selectNotifier);
		selectNotifier.setText("Select notification types:");
		notifierTypesList = CheckboxTableViewer.newCheckList(this, SWT.SINGLE | SWT.V_SCROLL | SWT.H_SCROLL
			| SWT.BORDER);
		GridDataFactory.fillDefaults().align(SWT.FILL, SWT.BEGINNING).applyTo(notifierTypesList.getControl());
		notifierTypesList.setContentProvider(new ArrayContentProvider());
		ArrayList<PropertyKey> providers = new ArrayList<PropertyKey>();
		providers.addAll(providerHints.keySet());
		Collections.sort(providers, new Comparator<PropertyKey>() {
			public int compare(PropertyKey o1, PropertyKey o2) {
				return o1.toString().compareTo(o2.toString());
			}
		});
		notifierTypesList.setInput(providers);

		final Label hint = new Label(this, SWT.WRAP);
		GridDataFactory.fillDefaults().align(SWT.FILL, SWT.CENTER).hint(150, 60).grab(true, false).applyTo(hint);
		hint.setText("Hint: Select an item to view its description");
		notifierTypesList.addSelectionChangedListener(new ISelectionChangedListener() {

			public void selectionChanged(SelectionChangedEvent event) {
				Object object = ((IStructuredSelection) event.getSelection()).getFirstElement();
				if (object instanceof DashboardKey) {
					hint.setText(providerHints.get(object)[1] + "");
				} else {
					hint.setText("Hint: Select an item to view its description");
				}
			}
		});

		notifierTypesList.setLabelProvider(new ColumnLabelProvider() {
			@Override
			public String getText(Object element) {
				if (element instanceof DashboardKey) {
					return providerHints.get(element)[0];
				}
				return super.getText(element);
			}
		});

		notifierTypesList.addCheckStateListener(new ICheckStateListener() {
			public void checkStateChanged(CheckStateChangedEvent event) {
				if (event.getChecked()) {
					tempNotificationGroups.get(tempNotificationGroups.indexOf(group)).getProviders().add(
						event.getElement());
				} else {
					tempNotificationGroups.get(tempNotificationGroups.indexOf(group)).getProviders().remove(
						event.getElement());
				}
			}
		});
	}

	private void init() {
		providerHints = new HashMap<PropertyKey, String[]>();

		providerHints.put(DashboardKey.TASK_PROVIDER, new String[] { "Task notifications",
			"Show notifications for tasks that have been assigned to you." });
		providerHints.put(DashboardKey.TASK_CHANGE_PROVIDER, new String[] { "Task changes notifications",
			"Show notifications for changes on tasks you have been assigned to." });
		providerHints.put(DashboardKey.TASK_TRACE_PROVIDER, new String[] { "Task trace notifications",
			"Shows notifications for elements that are related to your tasks." });
		providerHints.put(DashboardKey.TASK_REVIEW_PROVIDER, new String[] { "Reviewer task notifications",
			"Shows notifications for tasks that you have to review." });
		providerHints.put(DashboardKey.SUBSCRIPTION_PROVIDER, new String[] { "Subscriptions",
			"Allows you to subscribe to arbitrary model elements and receive notifications upon their changes." });
		providerHints.put(DashboardKey.COMMENTS_PROVIDER, new String[] { "Comment notifications",
			"Shows notifications for new comments regarding your tasks or a discussion you participate in." });
	}

	/**
	 * Checks all the notification providers that are given as a parameter to this method.
	 * 
	 * @param array An array holding notification providers that have to be checked.
	 */
	public void setCheckedElements(Object[] array) {
		notifierTypesList.setCheckedElements(array);
	}

}
