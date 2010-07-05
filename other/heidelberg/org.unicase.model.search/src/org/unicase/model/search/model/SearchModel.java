package org.unicase.model.search.model;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.Observable;

import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.emf.common.util.BasicEList;
import org.eclipse.emf.common.util.ECollections;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.impl.EClassImpl;
import org.eclipse.emf.query.conditions.eobjects.EObjectCondition;
import org.eclipse.emf.query.conditions.eobjects.EObjectTypeRelationCondition;
import org.eclipse.emf.query.conditions.eobjects.structuralfeatures.EObjectAttributeValueCondition;
import org.eclipse.emf.query.conditions.strings.StringAdapter;
import org.eclipse.emf.query.conditions.strings.StringRegularExpressionValue;
import org.eclipse.emf.query.statements.FROM;
import org.eclipse.emf.query.statements.SELECT;
import org.eclipse.emf.query.statements.WHERE;
import org.unicase.metamodel.ModelElement;
import org.unicase.metamodel.Project;
import org.unicase.model.ModelPackage;
import org.unicase.model.impl.ModelPackageImpl;
import org.unicase.model.search.comparator.DateComparator;
import org.unicase.workspace.ProjectSpace;
import org.unicase.workspace.WorkspaceManager;

public class SearchModel extends Observable {

	private Project project = null;
	private ProjectSpace projectSpace = null;
	private Collection<EClass> types = null;
	private ArrayList<Condition> conditions = null; 
	private Collection<EObject> searchResult = null;
	
	
	public final int UPDATE_PROJECT_SELECTION = 0;
	public final int UPDATE_RESULTS = 1;
	public final int UPDATE_RESULTS_RESET = 2;
	
	public SearchModel() {
		// demo data
		conditions = new ArrayList<Condition>();
	}

	public boolean isProjectSet() {
		return this.project != null;
	}

	public Project getProject() {
		return project;
	}
	
	public Collection<ModelElement> getModelTypes() {
		return project.getAllModelElements();
	}

	public Object[] getTypes() {
		if (types != null) {
			return types.toArray();
		}
		return new Object[]{};
	}
	
	public void setTypes(Collection<EClass> types) {
		this.types = types;
	}

	public ProjectSpace getProjectSpace() {
		return projectSpace;
	}

	public ArrayList<Condition> getConditions() {
		return conditions;
	}
	
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
	
	public Collection<EObject> performQuery(SearchParameter params, IProgressMonitor monitor) {
		StringRegularExpressionValue searchTerm = new StringRegularExpressionValue(params.getSearchTerm(), false, StringAdapter.DEFAULT);
		ModelPackage modelPackage = ModelPackageImpl.init();
		EAttribute nameAttribute = modelPackage.getUnicaseModelElement_Name();
		EObjectCondition conditionName = new EObjectAttributeValueCondition(nameAttribute, searchTerm);
		
		EAttribute descriptionAttribute = modelPackage.getUnicaseModelElement_Description();
		EObjectCondition conditionDescription = new EObjectAttributeValueCondition(descriptionAttribute, searchTerm);
		
		EObjectCondition condition = conditionName.OR(conditionDescription);
		
		// types
		if (params.getTypes() != null && params.getTypes().size() > 0) {
			//first
			EClassImpl eFirst = (EClassImpl) params.getTypes().get(0);
			EObjectCondition typeCondition = new EObjectTypeRelationCondition(eFirst);
		
			if (params.getTypes().size() > 1) {
				for (int i = 1; i < params.getTypes().size(); i++) {
					EClassImpl eTmp = (EClassImpl) params.getTypes().get(i);
					EObjectCondition tmpCondition = new EObjectTypeRelationCondition(eTmp);
					typeCondition = typeCondition.OR(tmpCondition);
				}
			}
			
			condition = condition.AND(typeCondition);
		}
		
		FROM from = new FROM(project.eResource().getContents());
		WHERE where = new WHERE(condition);
		
		SELECT statement = new SELECT(SELECT.UNBOUNDED, true, from, where, monitor);
		
		Collection<EObject> result = statement.execute();
		// for sorting
		EList<EObject> list = new BasicEList<EObject>(result);
		
		// TODO: relevance, type sorting?
		if (params.getOrderBy().equals(SearchParameter.ORDER_DATE_NEW) || 
			params.getOrderBy().equals(SearchParameter.ORDER_DATE_OLD)) {
			Comparator<EObject> cmp = new DateComparator();
			ECollections.sort(list, cmp);
			
			if (params.getOrderBy().equals(SearchParameter.ORDER_DATE_NEW)) {
				ECollections.reverse(list);
			}
		} else if (params.getOrderBy().equals(SearchParameter.ORDER_TYPE)) {
			// UI Problems...
//			ECollections.sort(list, new TypeComparator());
		}
		
		return list;
		
	}

	public Collection<EObject> getSearchResult() {
		return searchResult;
	}

	public void setSearchResult(Collection<EObject> searchResult) {
		this.searchResult = searchResult;
		setChanged();
		notifyObservers(new Integer(UPDATE_RESULTS));
	}
	
	public void resetSearchResult() {
		this.searchResult = Collections.emptyList();
		setChanged();
		notifyObservers(new Integer(UPDATE_RESULTS_RESET));
	}
	
}
