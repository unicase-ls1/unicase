/**
 * <copyright> Copyright (c) 2008-2009 Jonas Helming, Maximilian Koegel. All rights reserved. This program and the
 * accompanying materials are made available under the terms of the Eclipse Public License v1.0 which accompanies this
 * distribution, and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>
 */
package org.unicase.workspace.ui.views;

import java.util.Calendar;
import java.util.Date;
import java.util.List;

import org.eclipse.emf.ecore.EClass;
import org.unicase.model.ModelElement;
import org.unicase.model.organization.User;

/**
 * . This is just a test class to test the Query tab of AbstractSCMView. SCMViews (history browser and change browser)
 * know a Query class which based on it show corresponding contents. The properties of Query class are set using Query
 * tab of a SCMView.
 * 
 * @author Hodaie
 */
@Deprecated
public class Query {

	/**
	 * Enum for the type of query range. VERSION NUM
	 */
	public enum QueryRangeType {
		/**
		 * a range of versions.
		 */
		VERSION,
		/**
		 * a range of by a number of days.
		 */
		NUMOFDAYS,
		/**
		 * a range by dates.
		 */
		DATE
	};

	private QueryRangeType queryRangeType;

	// -1 will be interpreted as not set
	private int startVersion = -1;
	private int endVersion = -1;

	private int numOfDays;

	private Date startDate;
	private Date endDate;

	private List<ModelElement> modelElements;
	private List<User> users;
	private List<EClass> modelElementTypes;

	/**
	 * Constructor.
	 */
	public Query() {
		this.queryRangeType = QueryRangeType.VERSION;
	}

	/**
	 * @return the queryRangeType
	 */
	public QueryRangeType getQueryRangeType() {
		return queryRangeType;
	}

	/**
	 * @param queryRangeType the queryRangeType to set
	 */
	public void setQueryRangeType(QueryRangeType queryRangeType) {
		this.queryRangeType = queryRangeType;
	}

	/**
	 * @return the startVersion
	 */
	public int getStartVersion() {
		return startVersion;
	}

	/**
	 * @param startVersion the startVersion to set
	 */
	public void setStartVersion(int startVersion) {
		this.startVersion = startVersion;
	}

	/**
	 * @return the endVersion
	 */
	public int getEndVersion() {
		return endVersion;
	}

	/**
	 * @param endVersion the endVersion to set
	 */
	public void setEndVersion(int endVersion) {
		this.endVersion = endVersion;
	}

	/**
	 * @return the numOfDays
	 */
	public int getNumOfDays() {
		return numOfDays;
	}

	/**
	 * @param numOfDays the numOfDays to set
	 */
	public void setNumOfDays(int numOfDays) {
		this.numOfDays = numOfDays;
	}

	/**
	 * @return the startDate
	 */
	public Date getStartDate() {
		return startDate;
	}

	/**
	 * @param startDate the startDate to set
	 */
	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}

	/**
	 * @return the endDate
	 */
	public Date getEndDate() {
		return endDate;
	}

	/**
	 * @param endDate the endDate to set
	 */
	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}

	/**
	 * @return the modelElements
	 */
	public List<ModelElement> getModelElements() {
		return modelElements;
	}

	/**
	 * @param modelElements the modelElements to set
	 */
	public void setModelElements(List<ModelElement> modelElements) {
		this.modelElements = modelElements;
	}

	/**
	 * @return the users
	 */
	public List<User> getUsers() {
		return users;
	}

	/**
	 * @param users the users to set
	 */
	public void setUsers(List<User> users) {
		this.users = users;
	}

	/**
	 * @return the modelElementTypes
	 */
	public List<EClass> getModelElementTypes() {
		return modelElementTypes;
	}

	/**
	 * @param modelElementTypes the modelElementTypes to set
	 */
	public void setModelElementTypes(List<EClass> modelElementTypes) {
		this.modelElementTypes = modelElementTypes;
	}

	/**
	 * @return the description
	 */
	public String getDescription() {
		StringBuilder description = new StringBuilder();
		description.append("Query from ");

		switch (this.getQueryRangeType()) {
		case VERSION:
			description.append(getStartVersion() + " to " + getEndVersion());
			break;
		case NUMOFDAYS:
			description.append(getNDaysAgo() + " to " + getNow());
			break;
		case DATE:
			description.append(startDate + " to " + endDate);
			break;
		default:
			break;
		}

		if (modelElements != null && modelElements.size() != 0) {
			description.append(", filtered on elements");
		}
		if (users != null && users.size() != 0) {
			description.append(", users");
		}
		if (modelElementTypes != null && modelElementTypes.size() != 0) {
			description.append(", element types");
		}

		description.append(". Press refresh to be refreshed!");
		return description.toString();
	}

	private String getNDaysAgo() {
		Calendar calendar = Calendar.getInstance();
		calendar.add(Calendar.DAY_OF_MONTH, -numOfDays);
		return calendar.getTime().toString();
	}

	private String getNow() {
		return Calendar.getInstance().getTime().toString();
	}

}
