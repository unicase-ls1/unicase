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
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Spinner;
import org.unicase.model.emailnotificationgroup.EmailnotificationgroupPackage;
import org.unicase.model.emailnotificationgroup.NotificationGroup;

public class CompositeSendOptions extends Composite {

	private Combo sendOption;

	private Composite aggregated;
	private Combo aggregatedOption;

	private Composite extraControls;
	
	private Composite weekdayOptionComp;
	private Combo weekdayOption;

	private Composite daysSpinnerComp;
	private Spinner daysSpinner;

	CompositeSendOptions(Composite c, String s, final List<NotificationGroup> tempNotificationGroups, NotificationGroup group) {
		super(c, SWT.NONE);
		final int indexofbundle = tempNotificationGroups.indexOf(group);
		GridLayoutFactory.fillDefaults().numColumns(1).applyTo(this);
		GridDataFactory.fillDefaults().align(SWT.FILL, SWT.FILL).grab(false, true).applyTo(
			this);
		this.setBackground(Display.getCurrent().getSystemColor(SWT.COLOR_MAGENTA));

		Label configLabel = new Label(this, SWT.PUSH | SWT.TOP | SWT.WRAP);
		configLabel.setText("Send options for group " + s);
		sendOption = new Combo(this, SWT.DROP_DOWN | SWT.READ_ONLY);
		EList<EEnumLiteral> sendlist = ((EEnum) EmailnotificationgroupPackage.Literals.SEND_SETTINGS).getELiterals();
		for (EEnumLiteral literal : sendlist) {
			sendOption.add(literal.getLiteral());
		}

		aggregated = new Composite(this, SWT.NONE);
		GridLayoutFactory.fillDefaults().numColumns(1).margins(10, 0).applyTo(aggregated);
		// GridDataFactory.fillDefaults().align(SWT.FILL, SWT.TOP).applyTo(aggregated);
		GridDataFactory.fillDefaults().align(SWT.FILL, SWT.FILL).grab(false, true).applyTo(
			aggregated);
		this.setBackground(Display.getCurrent().getSystemColor(SWT.COLOR_DARK_GREEN));
		aggregated.setVisible(false);
		aggregatedOption = new Combo(aggregated, SWT.DROP_DOWN | SWT.READ_ONLY);
		EList<EEnumLiteral> aggreegatedlist = ((EEnum) EmailnotificationgroupPackage.Literals.AGGREGATED_SETTINGS).getELiterals();
		for (EEnumLiteral literal : aggreegatedlist) {
			aggregatedOption.add(literal.getLiteral());
		}
		Label every = new Label(aggregated, SWT.LEFT | SWT.BORDER);
		every.setText("every");
		extraControls = new Composite(aggregated, SWT.NONE);
		GridLayoutFactory.fillDefaults().numColumns(1).equalWidth(false).applyTo(extraControls);
		GridDataFactory.fillDefaults().align(SWT.FILL, SWT.FILL).grab(true, true).span(1, 1).applyTo(
			extraControls);
		extraControls.setBackground(Display.getCurrent().getSystemColor(SWT.COLOR_WHITE));
		
		sendOption.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				if (sendOption.getText().equalsIgnoreCase("aggregated")) {
					aggregated.setVisible(true);
				} else {
					if (weekdayOptionComp != null) {
						weekdayOptionComp.dispose();
					}
					if (daysSpinnerComp != null) {
						daysSpinnerComp.dispose();
					}
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
					disposeDaysSpinnerComp();
				} else if (aggregatedOption.getText().equalsIgnoreCase("days")) {
					createDaysSpinnerComp(indexofbundle, tempNotificationGroups);
					extraControls.layout();
					disposeWeekdayOptionComp();
				} else {
					disposeWeekdayOptionComp();
					disposeDaysSpinnerComp();
				}
			}
		});

		EMFDataBindingContext bindingContext = new EMFDataBindingContext();
		bindingContext.bindValue(SWTObservables.observeSelection(sendOption), EMFObservables.observeValue(tempNotificationGroups
			.get(indexofbundle), EmailnotificationgroupPackage.Literals.NOTIFICATION_GROUP__SEND_OPTION));
		bindingContext.bindValue(SWTObservables.observeSelection(aggregatedOption), EMFObservables.observeValue(
			tempNotificationGroups.get(indexofbundle), EmailnotificationgroupPackage.Literals.NOTIFICATION_GROUP__AGGREGATED_OPTION));
	}

	private Composite createDaysSpinnerComp(int indexofbundle, List<NotificationGroup> tempBundles) {
		disposeWeekdayOptionComp();
		daysSpinnerComp = new Composite(extraControls, SWT.NONE);
		GridLayoutFactory.fillDefaults().numColumns(2).margins(10, 0).applyTo(daysSpinnerComp);
		GridDataFactory.fillDefaults().align(SWT.FILL, SWT.FILL).grab(false, true).applyTo(
			daysSpinnerComp);
		daysSpinner = new Spinner(daysSpinnerComp, SWT.WRAP | SWT.BORDER | SWT.TOP);
		daysSpinner.setMinimum(1);
		daysSpinner.setMaximum(30);
		Label days = new Label(daysSpinnerComp, SWT.LEFT | SWT.BORDER);
		days.setText("days");
		EMFDataBindingContext bindingContext = new EMFDataBindingContext();
		bindingContext.bindValue(SWTObservables.observeSelection(daysSpinner), EMFObservables.observeValue(tempBundles
			.get(indexofbundle), EmailnotificationgroupPackage.Literals.NOTIFICATION_GROUP__DAYS_COUNT));
		return daysSpinnerComp;
	}

	private Composite createWeekdayOptionComp(int indexofbundle, List<NotificationGroup> tempBundles) {
		disposeDaysSpinnerComp();
		weekdayOptionComp = new Composite(extraControls, SWT.NONE);
		GridLayoutFactory.fillDefaults().numColumns(1).margins(10, 0).applyTo(weekdayOptionComp);
		GridDataFactory.fillDefaults().align(SWT.FILL, SWT.FILL).grab(false, true).applyTo(
			weekdayOptionComp);
		weekdayOption = new Combo(weekdayOptionComp, SWT.DROP_DOWN | SWT.READ_ONLY);
		EList<EEnumLiteral> weekdaylist = ((EEnum) EmailnotificationgroupPackage.Literals.WEEKDAYS).getELiterals();
		for (EEnumLiteral literal : weekdaylist) {
			weekdayOption.add(literal.getLiteral());
		}
		EMFDataBindingContext bindingContext = new EMFDataBindingContext();
		bindingContext.bindValue(SWTObservables.observeSelection(weekdayOption), EMFObservables.observeValue(
			tempBundles.get(indexofbundle), EmailnotificationgroupPackage.Literals.NOTIFICATION_GROUP__WEEKDAY_OPTION));
		return weekdayOptionComp;
	}

	private void disposeWeekdayOptionComp(){
		if (weekdayOptionComp != null) {
			weekdayOptionComp.dispose();
		}
	}
	
	private void disposeDaysSpinnerComp(){
		if (daysSpinnerComp != null) {
			daysSpinnerComp.dispose();
		}
	}
	// private void bindValues(List<Bundle> l, int i, Control c) {
	// EMFDataBindingContext bindingContext = new EMFDataBindingContext();
	// IObservableValue uiElement;
	// IObservableValue modelElement;
	//
	// uiElement = SWTObservables.observeSelection(c);
	// modelElement = EMFObservables.observeValue(l.get(i), EmailbundlePackage.Literals.BUNDLE__SEND_OPTION);
	// bindingContext.bindValue(uiElement, modelElement, null, null);
	// }
}
