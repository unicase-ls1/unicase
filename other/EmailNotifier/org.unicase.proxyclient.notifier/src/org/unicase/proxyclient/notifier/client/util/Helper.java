/**
 * <copyright> Copyright (c) 2008-2009 Jonas Helming, Maximilian Koegel. All rights reserved. This program and the
 * accompanying materials are made available under the terms of the Eclipse Public License v1.0 which accompanies this
 * distribution, and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>
 */

package org.unicase.proxyclient.notifier.client.util;

import java.util.Calendar;
import java.util.Date;

import org.unicase.model.emailnotificationgroup.Weekdays;

/**
 * Helper class for the NotifierProxyClient.
 * 
 * @author staudta
 */
public final class Helper {
	
	private Helper() { }
	
	/**
	 * Adds days to an already instantiated date.
	 * 
	 * @param date start date
	 * @param days amount of days that should be added
	 * @return Date 
	 */
	public static Date addDays(Date date, int days) {
		Calendar calendar = Calendar.getInstance();
		calendar.setTime( date );
		calendar.add(Calendar.DATE, days);  // number of days to add
		
		return calendar.getTime();
	}
	
	/**
	 * Calculates the next date for the specified weekday from the input date.
	 * 
	 * @param date start date for calculation
	 * @param weekday the expected weekday
	 * @return Date
	 */
	public static Date nextWeekday(Date date, Weekdays weekday) {
		Calendar calendar = Calendar.getInstance();
		calendar.setTime( date );
		
		int calendarDayOfWeekIndex = weekday.getValue() +1;
		if( weekday == Weekdays.SUNDAY ) {
			calendarDayOfWeekIndex = 1;
		}
		
		int dayOfWeek = calendar.get( Calendar.DAY_OF_WEEK );
		if( dayOfWeek == calendarDayOfWeekIndex ) {
			return date;
		}
		return nextWeekday( addDays(date, 1) , weekday);
	}
	
}
