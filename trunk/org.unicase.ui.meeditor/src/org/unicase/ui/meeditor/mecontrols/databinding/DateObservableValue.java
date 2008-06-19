/**
 * <copyright> Copyright (c) 2008 Jonas Helming, Maximilian Kšgel. All rights reserved. This program and the accompanying materials are made available under the terms of the Eclipse Public License v1.0 which accompanies this distribution, and is available at http://www.eclipse.org/legal/epl-v10.html
 * </copyright>
 *
 * $Id$
 */
package org.unicase.ui.meeditor.mecontrols.databinding;

import java.util.Calendar;
import java.util.Date;

import org.eclipse.core.databinding.observable.Diffs;
import org.eclipse.core.databinding.observable.Realm;
import org.eclipse.jface.internal.databinding.provisional.swt.AbstractSWTObservableValue;
import org.eclipse.nebula.widgets.calendarcombo.CalendarCombo;
import org.eclipse.nebula.widgets.calendarcombo.ICalendarListener;

/**
 * Defines the observable value for the date widget.
 * 
 * @author shterev
 * 
 */
@SuppressWarnings("restriction")
public class DateObservableValue extends AbstractSWTObservableValue {

	private CalendarCombo date;
	private boolean updating;
	private Date currentSelection;
	private ICalendarListener listener;

	/**
	 * @param date
	 *            .
	 */
	public DateObservableValue(CalendarCombo date) {
		super(date);
		this.date = date;

		try{
			currentSelection = date.getDate().getTime();
		}catch(NullPointerException e){
			currentSelection = null;
		}
		listener = new ICalendarListener() {

			public void dateChanged(Calendar date) {
				if (!updating) {
					Date newSelection = DateObservableValue.this.date.getDate()
							.getTime();
					notifyIfChanged(currentSelection, newSelection);
					currentSelection = newSelection;
				}
			}

			public void dateRangeChanged(Calendar start, Calendar end) {
				// TODO Auto-generated method stub
			}

			public void popupClosed() {
				// TODO Auto-generated method stub
			}
		};
		date.addCalendarListener(listener);
	}

	/**
	 * {@inheritDoc}
	 */
	public synchronized void dispose() {
		super.dispose();
		if (listener != null && !date.isDisposed()) {
			date.removeCalendarListener(listener);
		}
	}

	/**
	 * @param realm
	 *            .
	 * @param date
	 *            .
	 */
	public DateObservableValue(Realm realm, CalendarCombo date) {
		super(realm, date);
		this.date = date;
	}

	/**
	 * {@inheritDoc}
	 */
	protected Object doGetValue() {
		return date.getDate().getTime();
	}

	/**
	 * {@inheritDoc}
	 */
	public Object getValueType() {
		return Date.class;
	}

	/**
	 * {@inheritDoc}
	 */
	protected void doSetValue(Object value) {
		Date oldValue;
		Date newValue;
		try {
			updating = true;
			newValue = (Date) value;
			if(date.getDate()!=null){
				oldValue = date.getDate().getTime();
				date.setDate(newValue);
				currentSelection = newValue;
				notifyIfChanged(oldValue, newValue);
			}
		} finally {
			updating = false;
		}
	}

	private void notifyIfChanged(Date oldValue, Date newValue) {
		try{
			if (oldValue.compareTo(newValue) != 0) {
				fireValueChange(Diffs.createValueDiff(oldValue, newValue));
			}
		}catch(NullPointerException e){
			
		}
	}
}
