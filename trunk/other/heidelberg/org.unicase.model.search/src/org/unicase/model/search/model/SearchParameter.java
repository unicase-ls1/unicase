package org.unicase.model.search.model;

import java.util.ArrayList;
import java.util.Collection;

import org.eclipse.emf.ecore.EObject;

public class SearchParameter {
	
	public static final String ORDER_RELEVANCE = "relevance";
	public static final String ORDER_TYPE = "type (a-z)";
	public static final String ORDER_DATE_NEW = "date (new first)";
	public static final String ORDER_DATE_OLD = "date (old first)";
	
	private String searchTerm = null;
	private int maxResults;
	private Collection<Condition> searchConditions = null;
	private ArrayList<EObject> types = null;
	private String orderBy = null;
	
	
	public String getSearchTerm() {
		return searchTerm;
	}
	public void setSearchTerm(String searchTerm) {
		this.searchTerm = searchTerm;
	}
	public int getMaxResults() {
		return maxResults;
	}
	public void setMaxResults(int maxResults) {
		this.maxResults = maxResults;
	}
	public Collection<Condition> getSearchConditions() {
		return searchConditions;
	}
	public void setSearchConditions(Collection<Condition> searchConditions) {
		this.searchConditions = searchConditions;
	}
	public ArrayList<EObject> getTypes() {
		return types;
	}
	public void setTypes(ArrayList<EObject> types) {
		this.types = types;
	}
	public String getOrderBy() {
		return orderBy;
	}
	public void setOrderBy(String orderBy) {
		this.orderBy = orderBy;
	}
	
	
}
