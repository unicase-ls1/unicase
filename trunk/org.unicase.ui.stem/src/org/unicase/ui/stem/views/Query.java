package org.unicase.ui.stem.views;

import java.util.Calendar;
import java.util.Date;
import java.util.List;

import org.eclipse.emf.ecore.EClass;
import org.unicase.emfstore.esmodel.accesscontrol.ACUser;
import org.unicase.model.ModelElement;

public class Query {
	
	public enum QueryRangeType{VERSION, NUMOFDAYS, DATE };
	
	private QueryRangeType queryRangeType; 
	
	private int startVersion = 0;
	private int endVersion = 0;
	
	private int numOfDays = 0;
	
	private Date startDate = null;
	private Date endDate = null;
	
	private List<ModelElement> modelElements = null;
	private List<ACUser> users = null;
	private List<EClass> modelElementTypes = null;
	
	
	public Query(){
		this.queryRangeType = QueryRangeType.VERSION;
	}
	
	
	public void setStartVersion(int startVersion) {
		this.startVersion = startVersion;
	}
	
	
	public int getStartVersion() {
		return startVersion;
	}
	
	
	public void setEndVersion(int endVersion) {
		this.endVersion = endVersion;
	}
	
	
	public int getEndVersion() {
		return endVersion;
	}
	
	
	public void setNumOfDays(int numOfDays) {
		this.numOfDays = numOfDays;
	}
	
	
	public int getNumOfDays() {
		return numOfDays;
	}
	
	
	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}
	
	
	public Date getStartDate() {
		return startDate;
	}
	
	
	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}
	
	
	public Date getEndDate() {
		return endDate;
	}
	
	
	public void setModelElements(List<ModelElement> elements) {
		this.modelElements = elements;
	}
	
	
	public List<ModelElement> getModelElements() {
		return modelElements;
	}
	
	
	public void setUsers(List<ACUser> users) {
		this.users = users;
	}
	
	
	public List<ACUser> getUsers() {
		return users;
	}
	
	
	public void setModelElementTypes(List<EClass> modelElementTypes) {
		this.modelElementTypes = modelElementTypes;
	}
	
	
	public List<EClass> getModelElementTypes() {
		return modelElementTypes;
	}


	public void setQueryRangeType(QueryRangeType queryRangeType) {
		this.queryRangeType = queryRangeType;
	}


	public QueryRangeType getQueryRangeType() {
		return queryRangeType;
	}
	

	public String getDescription(){
		StringBuilder description = new StringBuilder();
		description.append("Query from ");
		
		
		switch(this.getQueryRangeType()){
		case VERSION:
			description.append(getStartVersion() + " to " + getEndVersion());
			break;
		case NUMOFDAYS:
			description.append( getNDaysAgo() + " to " + getNow() );
			break;
		case DATE:
			description.append(startDate  + " to " + endDate);
		}
		
		if(modelElements != null && modelElements.size() != 0){
			description.append(", filtered on elements");
		}
		if(users != null && users.size() != 0){
			description.append(", users");
		}
		if(modelElementTypes != null && modelElementTypes.size() != 0){
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
