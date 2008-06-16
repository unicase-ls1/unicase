package org.unicase.ui.meeditor.mecontrols.databinding;

import java.util.Calendar;
import java.util.Date;

import org.eclipse.core.databinding.observable.Diffs;
import org.eclipse.core.databinding.observable.Realm;
import org.eclipse.core.runtime.Assert;
import org.eclipse.jface.databinding.swt.ISWTObservableValue;
import org.eclipse.jface.internal.databinding.provisional.swt.AbstractSWTObservableValue;
import org.eclipse.jface.internal.databinding.swt.SWTProperties;
import org.eclipse.jface.internal.databinding.swt.SpinnerObservableValue;
import org.eclipse.jface.util.Util;
import org.eclipse.nebula.widgets.calendarcombo.CalendarCombo;
import org.eclipse.nebula.widgets.calendarcombo.ICalendarListener;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.ModifyEvent;
import org.eclipse.swt.events.ModifyListener;
import org.eclipse.swt.widgets.Event;
import org.eclipse.swt.widgets.Listener;
import org.eclipse.swt.widgets.Spinner;
import org.eclipse.swt.widgets.Text;

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
	private Calendar none;

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

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * org.eclipse.core.databinding.observable.value.AbstractObservableValue
	 * #dispose()
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

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * org.eclipse.core.databinding.observable.value.AbstractObservableValue
	 * #doGetValue()
	 */
	protected Object doGetValue() {
		return date.getDate().getTime();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * org.eclipse.core.databinding.observable.value.IObservableValue#getValueType
	 * ()
	 */
	public Object getValueType() {
		return Date.class;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * org.eclipse.core.databinding.observable.value.AbstractObservableValue
	 * #doSetValue(java.lang.Object)
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
