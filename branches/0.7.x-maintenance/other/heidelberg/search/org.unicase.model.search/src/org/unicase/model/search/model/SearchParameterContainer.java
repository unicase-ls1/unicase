package org.unicase.model.search.model;

import java.io.Serializable;
import java.util.List;

/**
 * A SearchParameterContainer can contains multiple search parameter objects.
 * @author Markus Fischer
 *
 */
public class SearchParameterContainer implements Serializable {

	public static final String FILE = "unicase_search_queries.data";
	
	private static final long serialVersionUID = 8728686835705568483L;
	
	private List<SearchParameter> parameters;
	
	/**
	 * Creates a new search parameter container and uses the given list.
	 * @param parameters list of search parameter
	 */
	public SearchParameterContainer(List<SearchParameter> parameters) {
		this.parameters = parameters;
	}

	/**
	 * @return the list of search parameter
	 */
	public List<SearchParameter> getParameters() {
		return parameters;
	}

	/**
	 * Sets a new list of search parameters.
	 * @param parameters the new list
	 */
	public void setParameters(List<SearchParameter> parameters) {
		this.parameters = parameters;
	}
	
}
