/**
 * <copyright> Copyright (c) 2008 Jonas Helming, Maximilian Koegel. All rights reserved. This program and the accompanying materials are made available under the terms of the Eclipse Public License v1.0 which accompanies this distribution, and is available at http://www.eclipse.org/legal/epl-v10.html
 * </copyright>
 *
 * $Id$
 */
package org.unicase.model;

import java.util.Date;

/**
 * Class containing the information about the reader activity.
 */
public class ReaderInfo {

	private Date date;
	private String acOrgId;
	
	/**
	 * Getter for the date property.
	 * @return the date.
	 */
	public Date getDate(){
		return date;
	}

	/**
	 * Setter for the date property.
	 * @param value the date
	 */
	public void setDate(Date value){
		date = value;
	}

	/**
	 * Getter for the date property.
	 * @return the AcOrgUnitId
	 */
	public String getReaderId(){
		return acOrgId;
	}
	
	/**
	 * Setter for the reader property.
	 * @param value the AcOrgUnitId
	 */
	public void setReaderId(String value){
		acOrgId = value;
	}

}
