package org.unicase.emailnotifierpreferences.properties;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;

import org.eclipse.jface.layout.GridDataFactory;
import org.eclipse.jface.viewers.ArrayContentProvider;
import org.eclipse.jface.viewers.CheckStateChangedEvent;
import org.eclipse.jface.viewers.CheckboxTableViewer;
import org.eclipse.jface.viewers.ColumnLabelProvider;
import org.eclipse.jface.viewers.ICheckStateListener;
import org.eclipse.jface.viewers.ISelectionChangedListener;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.viewers.SelectionChangedEvent;
import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Label;
import org.unicase.model.emailbundle.Bundle;
import org.unicase.workspace.preferences.PropertyKey;

public class CompositeNotificationTypeSelection extends Composite {
	
	private CheckboxTableViewer notifierTypesList;
	private HashMap<PropertyKey, String[]> providerHints;

	public CompositeNotificationTypeSelection(Composite c, String s, final List<Bundle> tempBundles, final Bundle bndl) {
		super(c, SWT.NONE);
		init();
		GridLayout compositeBundleLayout = new GridLayout(1, false);
		// compositeBundle.setLayoutData(layoutTop);
		this.setLayout(compositeBundleLayout);

		Label selectNotifier = new Label(this, SWT.PUSH | SWT.TOP | SWT.WRAP);
		GridDataFactory.fillDefaults().align(SWT.FILL, SWT.CENTER).hint(150, SWT.DEFAULT).grab(true, false).applyTo(
			selectNotifier);
		selectNotifier.setText("Select notification types for group: " + s);
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
				if (object instanceof EMailNotifierKey) {
					hint.setText(providerHints.get(object)[1] + "");
					// compositeBundle.getLayout();
				}
			}
		});

		notifierTypesList.setLabelProvider(new ColumnLabelProvider() {
			@Override
			public String getText(Object element) {
				if (element instanceof EMailNotifierKey) {
					return providerHints.get(element)[0];
				}
				return super.getText(element);
			}
		});

		notifierTypesList.addCheckStateListener(new ICheckStateListener() {
			public void checkStateChanged(CheckStateChangedEvent event) {
				if (event.getChecked()) {
					tempBundles.get(tempBundles.indexOf(bndl)).getProviders().add(event.getElement());
				} else {
					tempBundles.get(tempBundles.indexOf(bndl)).getProviders().remove(event.getElement());
				}
			}
		});
	}

	private void init() {
		providerHints = new HashMap<PropertyKey, String[]>();

		providerHints.put(EMailNotifierKey.TASK_PROVIDER, new String[] { "Task notifications",
			"Show notifications for tasks that have been assigned to you." });
		providerHints.put(EMailNotifierKey.TASK_CHANGE_PROVIDER, new String[] { "Task changes notifications",
			"Show notifications for changes on tasks you have been assigned to." });
		providerHints.put(EMailNotifierKey.TASK_TRACE_PROVIDER, new String[] { "Task trace notifications",
			"Shows notifications for elements that are related to your tasks." });
		providerHints.put(EMailNotifierKey.TASK_REVIEW_PROVIDER, new String[] { "Reviewer task notifications",
			"Shows notifications for tasks that you have to review." });
		providerHints.put(EMailNotifierKey.SUBSCRIPTION_PROVIDER, new String[] { "Subscriptions",
			"Allows you to subscribe to arbitrary model elements and receive notifications upon their changes." });
		providerHints.put(EMailNotifierKey.COMMENTS_PROVIDER, new String[] { "Comment notifications",
			"Shows notifications for new comments regarding your tasks or a discussion you participate in." });		
	}

	public void setCheckedElements(Object[] array) {
		notifierTypesList.setCheckedElements(array);
	}



}
