package org.unicase.model.search.model;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Observable;

import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.emf.common.util.BasicEList;
import org.eclipse.emf.common.util.ECollections;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.query.conditions.eobjects.ENot;
import org.eclipse.emf.query.conditions.eobjects.EObjectCondition;
import org.eclipse.emf.query.conditions.eobjects.EObjectInstanceCondition;
import org.eclipse.emf.query.conditions.eobjects.EObjectTypeRelationCondition;
import org.eclipse.emf.query.conditions.eobjects.structuralfeatures.EObjectAttributeValueCondition;
import org.eclipse.emf.query.conditions.eobjects.structuralfeatures.EObjectReferenceValueCondition;
import org.eclipse.emf.query.conditions.strings.StringAdapter;
import org.eclipse.emf.query.conditions.strings.StringRegularExpressionValue;
import org.eclipse.emf.query.conditions.strings.StringValue;
import org.eclipse.emf.query.statements.FROM;
import org.eclipse.emf.query.statements.SELECT;
import org.eclipse.emf.query.statements.WHERE;
import org.unicase.metamodel.Project;
import org.unicase.model.ModelFactory;
import org.unicase.model.ModelPackage;
import org.unicase.model.search.comparator.DateComparator;
import org.unicase.model.search.comparator.RelevanceComparator;
import org.unicase.model.search.comparator.TypeComparator;
import org.unicase.model.search.exceptions.SearchParameterException;
import org.unicase.model.search.exceptions.SearchParameterLoadException;
import org.unicase.model.search.exceptions.SearchParameterSaveException;
import org.unicase.workspace.Configuration;
import org.unicase.workspace.ProjectSpace;
import org.unicase.workspace.WorkspaceManager;

/**
 * The search model. Manages the selected project, the conditions 
 * and the search result. Also includes the search logic.
 * @author Markus Fischer
 *
 */
public class SearchModel extends Observable {

	private Project project = null;
	private ProjectSpace projectSpace = null;
	private Collection<EObject> searchResult = null;
	private SearchParameter searchParameter = null;
	
	
	public static final int UPDATE_PROJECT_SELECTION = 0;
	public static final int UPDATE_RESULTS = 1;
	public static final int UPDATE_RESULTS_RESET = 2;
	
	/**
	 * Default-Constructor.
	 */
	public SearchModel() {
		searchParameter = new SearchParameter();
		searchParameter.setSearchConditions(new ArrayList<Condition>());
	}

	/**
	 * @return true if a project is set, otherwise false.
	 */
	public boolean isProjectSet() {
		return this.project != null;
	}

	/**
	 * @return the current project space.
	 */
	public ProjectSpace getProjectSpace() {
		return projectSpace;
	}

	/**
	 * @return the current conditions.
	 */
	public List<Condition> getConditions() {
		return searchParameter.getSearchConditions();
	}
	
	/**
	 * Sets a new list of conditions.
	 * @param conditions the new list of conditions
	 */
	public void setConditions(List<Condition> conditions) {
		searchParameter.setSearchConditions(conditions);
	}
	
	/**
	 * Updates the project data.
	 */
	public void updateProjectData() {
		if (WorkspaceManager.getInstance().getCurrentWorkspace() != null) {
			this.projectSpace = WorkspaceManager.getInstance().getCurrentWorkspace().getActiveProjectSpace();
			if (this.projectSpace != null) {
				this.project = projectSpace.getProject();
			} else {
				this.project = null;
			}
		} else {
			this.projectSpace = null;
			this.project = null;
		}
		setChanged();
		notifyObservers(new Integer(UPDATE_PROJECT_SELECTION));
	}
	
	/**
	 * Performs the search for the given search parameter. The search is performed 
	 * with the data of the currently selected project.
	 * @param params the search parameter
	 * @param monitor IProgessMonitor object for UI
	 * @return EList<EObject> with search results
	 */
	public Collection<EObject> performQuery(SearchParameter params, IProgressMonitor monitor) {
		searchParameter = params;
		EObjectCondition condition = null;
		ModelPackage modelPackage = ModelFactory.eINSTANCE.getModelPackage();
		EAttribute nameAttribute = modelPackage.getUnicaseModelElement_Name();
		if (!params.isConditionsOnly()) {
			StringRegularExpressionValue searchTerm = new StringRegularExpressionValue(params.getSearchTerm(), false, StringAdapter.DEFAULT);
			
			EObjectCondition conditionName = new EObjectAttributeValueCondition(nameAttribute, searchTerm);
			
			EAttribute descriptionAttribute = modelPackage.getUnicaseModelElement_Description();
			EObjectCondition conditionDescription = new EObjectAttributeValueCondition(descriptionAttribute, searchTerm);
			
			condition = conditionName.OR(conditionDescription);
			
			// types
			if (params.getTypes() != null && params.getTypes().size() > 0) {
				//first
				EClass eFirst = params.getTypes().get(0);
				EObjectCondition tmpCondition = new EObjectTypeRelationCondition(eFirst);
			
				if (params.getTypes().size() > 1) {
					for (int i = 1; i < params.getTypes().size(); i++) {
						EClass eTmp = params.getTypes().get(i);
						tmpCondition = tmpCondition.OR(new EObjectTypeRelationCondition(eTmp));
					}
				}
				
				condition = condition.AND(tmpCondition);
			}
		}
		
		// conditions
		EObjectCondition contextCondition = null;
		EObjectCondition attributeValueCondition = null;
		EObjectCondition specialCondition = null;
		String connectorCondition = null;
		for (Condition c : params.getSearchConditions()) {
			EReference ref = c.getReference();
			EClass type = ref.getEContainingClass();
			contextCondition = new EObjectTypeRelationCondition(type);
			
			if (c.getOperator().equals(Condition.OPERATOR_IS_NULL)) {
				attributeValueCondition = EObjectInstanceCondition.IS_NULL;
			} else if (c.getOperator().equals(Condition.OPERATOR_NOT_NULL)) {
				attributeValueCondition = new ENot(EObjectInstanceCondition.IS_NULL);
			} else {
				attributeValueCondition = new EObjectAttributeValueCondition(nameAttribute, 
					new StringValue(c.getValue()));
				if (c.getOperator().equals(Condition.OPERATOR_NOT_EQUAL)) {
					attributeValueCondition = new ENot(attributeValueCondition);
				}
			}
			
			EObjectCondition newCondition = new EObjectReferenceValueCondition(contextCondition, ref, attributeValueCondition);
			if (specialCondition == null) {
				connectorCondition = c.getCondition();
				specialCondition = newCondition;
			} else {
				if (c.getCondition().equals(Condition.CONDITION_AND)) {
					specialCondition = specialCondition.AND(newCondition);
				} else if (c.getCondition().equals(Condition.CONDITION_OR)) {
					specialCondition = specialCondition.OR(newCondition);
				}
			}
		}
		
		if (specialCondition != null) {
			if (condition != null) {
				if (connectorCondition.equals(Condition.CONDITION_AND)) {
					condition = condition.AND(specialCondition);
				} else if (connectorCondition.equals(Condition.CONDITION_OR)) {
					condition = condition.OR(specialCondition);
				}
			} else {
				condition = specialCondition;
			}
		}
		
		FROM from = new FROM(project.eResource().getContents());
		WHERE where = new WHERE(condition);
		
		SELECT statement = new SELECT(SELECT.UNBOUNDED, true, from, where, monitor);
		
		Collection<EObject> result = statement.execute();
		
		if (params.isConditionsOnly() && params.getOrderBy().equals(SearchParameter.ORDER_RELEVANCE)) {
			// no sorting here
			return result;
		} else {
			return orderBy(params.getOrderBy(), result, params.getSearchTerm());
		}
	}
	
	/**
	 * Orders a list of EObject by the method specified in the orderBy parameter.
	 * Possible methods are given in the SearchParameter class.
	 * @param orderBy final value of SearchParameter class
	 * @param result the unsorted search result
	 * @param searchTerm the search term, only needed for relevance sorting
	 * @return
	 */
	public EList<EObject> orderBy(String orderBy, Collection<EObject> result, String searchTerm) {
		EList<EObject> list = new BasicEList<EObject>(result);
		if (orderBy.equals(SearchParameter.ORDER_DATE_NEW) || 
			orderBy.equals(SearchParameter.ORDER_DATE_OLD)) {
			Comparator<EObject> cmp = new DateComparator();
			ECollections.sort(list, cmp);
			
			if (orderBy.equals(SearchParameter.ORDER_DATE_NEW)) {
				ECollections.reverse(list);
			}
		} else if (orderBy.equals(SearchParameter.ORDER_TYPE)) {
			ECollections.sort(list, new TypeComparator());
		} else if (orderBy.equals(SearchParameter.ORDER_RELEVANCE)) {
			ECollections.sort(list, new RelevanceComparator(searchTerm));
		}
		return list;
	}
	
	/**
	 * Checks the collected search parameters. 
	 * @param params the search parameter object
	 * @throws SearchParameterException If something is wrong
	 */
	public void checkSearchParameter(SearchParameter params) throws SearchParameterException {
		if (params.getTypes().size() == 0) {
			throw new SearchParameterException("No Element Type selected!");
		}
		
		if (!params.isConditionsOnly() && (params.getSearchTerm() == null || params.getSearchTerm().length() == 0)) {
			throw new SearchParameterException("No search term defined!");
		}
		
		if (params.isConditionsOnly() && params.getSearchConditions().size() == 0) {
			throw new SearchParameterException("There are no conditions!");
		}
		
		for (Condition condition : params.getSearchConditions()) {
			checkSearchCondition(condition);
		}
	}
	
	/**
	 * Checks a search condition.
	 * 
	 * @param condition the search condition to check
	 * @throws SearchParameterException if no field is selected, no value set (operator equal/not equal) 
	 * or value is set (operator value set/no value set)
	 */
	public void checkSearchCondition(Condition condition) throws SearchParameterException {
		if (condition.getField() == null || condition.getField().length() == 0) {
			throw new SearchParameterException("There is at least one condition without a valid field selection.");
		} else if ((condition.getOperator().equals(Condition.OPERATOR_EQUAL) || condition.getOperator().equals(
			Condition.OPERATOR_NOT_EQUAL))
			&& condition.getValue().length() == 0) {
			throw new SearchParameterException("There is at least one condition without a valid value.");
		} else if ((condition.getOperator().equals(Condition.OPERATOR_IS_NULL) || condition.getOperator().equals(
			Condition.OPERATOR_NOT_NULL))
			&& condition.getValue().length() != 0) {
			throw new SearchParameterException("A value for a condition can only be set if the operator is \""
				+ Condition.OPERATOR_EQUAL + "\" or \"" + Condition.OPERATOR_NOT_EQUAL + "\".");
		}
	}
	
	/**
	 * Loads the persisted search parameters.
	 * @throws SearchParameterLoadException If error occurs loading parameters or if there are no parameters
	 * @return a search parameter container that contains all persisted parameters.
	 */
	public SearchParameterContainer loadQueryData() throws SearchParameterLoadException {
		SearchParameterContainer container = null;
		try {
			String dir = Configuration.getWorkspaceDirectory();
			File file = new File(dir + SearchParameterContainer.FILE);
			if (file.exists()) {
				ObjectInputStream objIn = new ObjectInputStream(new FileInputStream(file));
				container = (SearchParameterContainer) objIn.readObject();
				objIn.close();
				if (container.getParameters().size() == 0) {
					throw new SearchParameterLoadException("There are no saved queries yet.");
				}
			} else {
				container = new SearchParameterContainer(new ArrayList<SearchParameter>());
			}
		} catch (SearchParameterLoadException ex) {
			throw ex;
		} catch (Exception ex) {
			throw new SearchParameterLoadException("There was an unexpected error. Could'nt load existing queries.");
		}
		return container;
	}
	
	/**
	 * Persists the given search parameter container.
	 * @param container the container to persist.
	 * @throws SearchParameterSaveException If problem occurs saving the file
	 */
	public void saveQueryData(SearchParameterContainer container) throws SearchParameterSaveException {
		try {
			String dir = Configuration.getWorkspaceDirectory();
			File file = new File(dir + SearchParameterContainer.FILE);
			if (!file.exists()) {
				file.createNewFile();
			}
			ObjectOutputStream objOut = new ObjectOutputStream(new FileOutputStream(file));
			objOut.writeObject(container);
			objOut.close();
		} catch (Exception ex) {
			throw new SearchParameterSaveException(
				"There was an unexpected error. The Query could not be saved. Message was: " + ex.getMessage());
		}
	}

	/**
	 * @return the last search result
	 */
	public Collection<EObject> getSearchResult() {
		return searchResult;
	}

	/**
	 * Sets a new search result.
	 * @param searchResult the new search result
	 */
	public void setSearchResult(Collection<EObject> searchResult) {
		this.searchResult = searchResult;
		setChanged();
		notifyObservers(new Integer(UPDATE_RESULTS));
	}
	
	/**
	 * Resets the search result.
	 */
	public void resetSearchResult() {
		this.searchResult = Collections.emptyList();
		setChanged();
		notifyObservers(new Integer(UPDATE_RESULTS_RESET));
	}
	
	public void updatePager() {
		setChanged();
		notifyObservers(new Integer(UPDATE_RESULTS));
	}

	/**
	 * @return the searchParameter
	 */
	public SearchParameter getSearchParameter() {
		return searchParameter;
	}
	
}
