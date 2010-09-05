/**
 * <copyright> Copyright (c) 2008-2009 Jonas Helming, Maximilian Koegel. All rights reserved. This program and the
 * accompanying materials are made available under the terms of the Eclipse Public License v1.0 which accompanies this
 * distribution, and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>
 */
package org.unicase.emailnotifierpreferences.properties;

import java.util.List;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.databinding.EMFDataBindingContext;
import org.eclipse.emf.databinding.EMFObservables;
import org.eclipse.emf.ecore.EEnum;
import org.eclipse.emf.ecore.EEnumLiteral;
import org.eclipse.jface.databinding.swt.SWTObservables;
import org.eclipse.jface.layout.GridDataFactory;
import org.eclipse.jface.layout.GridLayoutFactory;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.widgets.Combo;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Spinner;
import org.unicase.model.emailnotificationgroup.AggregatedSettings;
import org.unicase.model.emailnotificationgroup.EmailnotificationgroupPackage;
import org.unicase.model.emailnotificationgroup.NotificationGroup;
import org.unicase.model.emailnotificationgroup.SendSettings;

/**
 * A Class for the EMail Notifier Service. The Constructor creates a Composite holding the send options for a certain
 * Notification Group.
 * 
 * @author fuesescc
 */
public class CompositeSendOptions extends Composite {

	private Combo sendOption;

	private Composite aggregated;
	private Combo aggregatedOption;

	private Composite extraControls;

	private Composite weekdayOptionComp;
	private Combo weekdayOption;

	private Composite daysSpinnerComp;
	private Spinner daysSpinner;

	private EMFDataBindingContext bindingContext;

	/**
	 * Constructor creates a Composite for the send options for a certain Notification Group.
	 * 
	 * @param c The parent Composite.
	 * @param tempNotificationGroups List holding all the Notification Groups.
	 * @param group The currently selected Notification Group.
	 */
	public CompositeSendOptions(Composite c, final List<NotificationGroup> tempNotificationGroups,
		NotificationGroup group) {
		super(c, SWT.NONE);
		final int indexofbundle = tempNotificationGroups.indexOf(group);
		GridLayoutFactory.fillDefaults().applyTo(this);
		GridDataFactory.fillDefaults().grab(false, true).hint(210, SWT.DEFAULT).applyTo(this);

		Label configLabel = new Label(this, SWT.PUSH | SWT.TOP | SWT.WRAP);
		GridDataFactory.fillDefaults().hint(150, SWT.DEFAULT).grab(true, false).applyTo(configLabel);
		configLabel.setText("Set send options:");
		sendOption = new Combo(this, SWT.DROP_DOWN | SWT.READ_ONLY);
		EList<EEnumLiteral> sendlist = ((EEnum) EmailnotificationgroupPackage.Literals.SEND_SETTINGS).getELiterals();
		for (EEnumLiteral literal : sendlist) {
			sendOption.add(literal.getLiteral());
		}

		aggregated = new Composite(this, SWT.NONE);
		GridLayoutFactory.fillDefaults().margins(10, 0).applyTo(aggregated);
		GridDataFactory.fillDefaults().grab(false, true).applyTo(aggregated);

		aggregated.setVisible(false);
		if (group.getSendOption().getValue() == SendSettings.AGGREGATED.getValue()) {
			aggregated.setVisible(true);
		}

		aggregatedOption = new Combo(aggregated, SWT.DROP_DOWN | SWT.READ_ONLY);
		EList<EEnumLiteral> aggreegatedlist = ((EEnum) EmailnotificationgroupPackage.Literals.AGGREGATED_SETTINGS)
			.getELiterals();
		for (EEnumLiteral literal : aggreegatedlist) {
			aggregatedOption.add(literal.getLiteral());
		}
		extraControls = new Composite(aggregated, SWT.NONE);
		GridLayoutFactory.fillDefaults().applyTo(extraControls);
		GridDataFactory.fillDefaults().align(SWT.FILL, SWT.BEGINNING).grab(true, false).applyTo(extraControls);

		sendOption.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				if (sendOption.getText().equalsIgnoreCase("aggregated")) {
					aggregated.setVisible(true);
					aggregatedOption.select(0);
					disposeWeekdayOptionComp();
					disposeDaysSpinnerComp();
				} else {
					disposeWeekdayOptionComp();
					disposeDaysSpinnerComp();
					aggregated.setVisible(false);
				}
			}
		});
		aggregatedOption.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				if (aggregatedOption.getText().equalsIgnoreCase("weekday")) {
					createWeekdayOptionComp(indexofbundle, tempNotificationGroups);
					extraControls.layout();
				} else if (aggregatedOption.getText().equalsIgnoreCase("days")) {
					createDaysSpinnerComp(indexofbundle, tempNotificationGroups);
					extraControls.layout();
				} else {
					disposeWeekdayOptionComp();
					disposeDaysSpinnerComp();
				}
			}
		});

		bindingContext = new EMFDataBindingContext();
		bindingContext.bindValue(SWTObservables.observeSelection(sendOption), EMFObservables.observeValue(
			tempNotificationGroups.get(indexofbundle),
			EmailnotificationgroupPackage.Literals.NOTIFICATION_GROUP__SEND_OPTION));
		bindingContext.bindValue(SWTObservables.observeSelection(aggregatedOption), EMFObservables.observeValue(
			tempNotificationGroups.get(indexofbundle),
			EmailnotificationgroupPackage.Literals.NOTIFICATION_GROUP__AGGREGATED_OPTION));

		if (group.getAggregatedOption().getValue() == AggregatedSettings.DAYS.getValue()) {
			createDaysSpinnerComp(indexofbundle, tempNotificationGroups);
			extraControls.layout();
		} else if (group.getAggregatedOption().getValue() == AggregatedSettings.WEEKDAY.getValue()) {
			createWeekdayOptionComp(indexofbundle, tempNotificationGroups);
			extraControls.layout();
		}
	}

	private Composite createDaysSpinnerComp(int indexofbundle, List<NotificationGroup> tempBundles) {
		disposeWeekdayOptionComp();
		disposeDaysSpinnerComp();
		daysSpinnerComp = new Composite(extraControls, SWT.NONE);
		GridLayoutFactory.fillDefaults().numColumns(3).applyTo(daysSpinnerComp);
		GridDataFactory.fillDefaults().grab(false, true).applyTo(daysSpinnerComp);
		Label every = new Label(daysSpinnerComp, SWT.LEFT | SWT.BORDER);
		every.setText("every");
		daysSpinner = new Spinner(daysSpinnerComp, SWT.WRAP | SWT.BORDER | SWT.TOP);
		daysSpinner.setMinimum(1);
		daysSpinner.setMaximum(30);
		Label days = new Label(daysSpinnerComp, SWT.LEFT | SWT.BORDER);
		days.setText("days");
		bindingContext.bindValue(SWTObservables.observeSelection(daysSpinner), EMFObservables.observeValue(tempBundles
			.get(indexofbundle), EmailnotificationgroupPackage.Literals.NOTIFICATION_GROUP__DAYS_COUNT));
		daysSpinner.setSelection(1);
		tempBundles.get(indexofbundle).setDaysCount(1);
		return daysSpinnerComp;
	}

	private Composite createWeekdayOptionComp(int indexofbundle, List<NotificationGroup> tempBundles) {
		disposeDaysSpinnerComp();
		disposeWeekdayOptionComp();
		weekdayOptionComp = new Composite(extraControls, SWT.NONE);
		GridLayoutFactory.fillDefaults().numColumns(2).applyTo(weekdayOptionComp);
		GridDataFactory.fillDefaults().grab(false, true).applyTo(weekdayOptionComp);
		Label every = new Label(weekdayOptionComp, SWT.LEFT | SWT.BORDER);
		every.setText("every");
		weekdayOption = new Combo(weekdayOptionComp, SWT.DROP_DOWN | SWT.READ_ONLY);
		EList<EEnumLiteral> weekdaylist = ((EEnum) EmailnotificationgroupPackage.Literals.WEEKDAYS).getELiterals();
		for (EEnumLiteral literal : weekdaylist) {
			weekdayOption.add(literal.getLiteral());
		}
		weekdayOption.select(0);
		bindingContext.bindValue(SWTObservables.observeSelection(weekdayOption), EMFObservables.observeValue(
			tempBundles.get(indexofbundle), EmailnotificationgroupPackage.Literals.NOTIFICATION_GROUP__WEEKDAY_OPTION));
		return weekdayOptionComp;
	}

	private void disposeWeekdayOptionComp() {
		if (weekdayOptionComp != null) {
			weekdayOptionComp.dispose();
		}
	}

	private void disposeDaysSpinnerComp() {
		if (daysSpinnerComp != null) {
			daysSpinnerComp.dispose();
		}
	}
}
