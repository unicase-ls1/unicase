package org.unicase.model.search.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import org.eclipse.emf.ecore.EClass;

/**
 * Contains several search parameters.
 * @author Markus Fischer
 *
 */
public class SearchParameter implements Serializable {
	
	private static final long serialVersionUID = -371727963603790285L;
	
	public static final String ORDER_RELEVANCE = "relevance";
	public static final String ORDER_TYPE = "type (a-z)";
	public static final String ORDER_DATE_NEW = "date (new first)";
	public static final String ORDER_DATE_OLD = "date (old first)";
	
	private String description = null;
	private String searchTerm = null;
	private int maxResults;
	private List<Condition> searchConditions = null;
	private String orderBy = null;
	private transient List<EClass> types = null;
	private List<String> stringTypes = null;
	private boolean conditionsOnly = false;
	
	/**
	 * @return the description
	 */
	public String getDescription() {
		return description;
	}
	
	/**
	 * Sets a new description.
	 * @param description the new description.
	 */
	public void setDescription(String description) {
		this.description = description;
	}
	
	/**
	 * @return the search term
	 */
	public String getSearchTerm() {
		return searchTerm;
	}
	
	/**
	 * Sets a new search term.
	 * @param searchTerm the new search term
	 */
	public void setSearchTerm(String searchTerm) {
		this.searchTerm = searchTerm;
	}
	
	/**
	 * @return the max results per page
	 */
	public int getMaxResults() {
		return maxResults;
	}
	
	/**
	 * Sets a new max results per page value.
	 * @param maxResults the new value
	 */
	public void setMaxResults(int maxResults) {
		this.maxResults = maxResults;
	}
	
	/**
	 * @return the list of search conditions
	 */
	public List<Condition> getSearchConditions() {
		return searchConditions;
	}
	
	/**
	 * Sets a new list of search conditions.
	 * @param searchConditions the new list
	 */
	public void setSearchConditions(List<Condition> searchConditions) {
		this.searchConditions = searchConditions;
	}
	
	/**
	 * @return the order by value
	 */
	public String getOrderBy() {
		return orderBy;
	}
	
	/**
	 * Sets a new order by value.
	 * @param orderBy the new order by value.
	 */
	public void setOrderBy(String orderBy) {
		this.orderBy = orderBy;
	}
	
	/**
	 * @return the list of selected types.
	 */
	public List<EClass> getTypes() {
		return types;
	}
	
	/**
	 * Sets a new list of selected types and updates the string type list.
	 * @param types the new list of types
	 */
	public void setTypes(List<EClass> types) {
		this.types = types;
		this.stringTypes = getStringTypesFromEClasses();
	}
	
	/**
	 * @return the string representation of the currently selected types
	 */
	public List<String> getStringTypes() {
		return this.stringTypes;
	}
	
	/**
	 * Sets a new string representation of the currently selected types
	 * @param stringTypes the new list
	 */
	public void setStringTypes(List<String> stringTypes) {
		this.stringTypes = stringTypes;
	}
	
	/**
	 * Creates a string list out of the selected types.
	 * @return List of strings
	 */
	private List<String> getStringTypesFromEClasses() {
		if (types == null) {
			return null;
		}
		List<String> stringTypes = new ArrayList<String>();
		for (EClass eClass : types) {
			stringTypes.add(eClass.getEPackage().getName() + eClass.getName());
		}
		return stringTypes;
	}
	
	/**
	 * @return true if only conditions relevant, otherwise false
	 */
	public boolean isConditionsOnly() {
		return conditionsOnly;
	}
	
	/**
	 * Sets the new flag for conditions only
	 * @param conditionsOnly 
	 */
	public void setConditionsOnly(boolean conditionsOnly) {
		this.conditionsOnly = conditionsOnly;
	}
	
}
