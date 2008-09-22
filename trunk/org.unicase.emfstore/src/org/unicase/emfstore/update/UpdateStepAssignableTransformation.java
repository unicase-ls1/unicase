package org.unicase.emfstore.update;

import org.eclipse.emf.common.util.BasicEList;
import org.eclipse.emf.common.util.EList;
import org.unicase.emfstore.esmodel.ProjectHistory;
import org.unicase.emfstore.esmodel.versioning.Version;
import org.unicase.model.ModelElement;
import org.unicase.model.Project;
import org.unicase.model.bug.BugPackage;
import org.unicase.model.bug.BugReport;
import org.unicase.model.organization.OrgUnit;
import org.unicase.model.organization.User;
import org.unicase.model.rationale.Issue;
import org.unicase.model.rationale.RationalePackage;

public class UpdateStepAssignableTransformation extends UpdateStepImpl {

	protected org.osgi.framework.Version sourceVersion = new org.osgi.framework.Version("0.0.1");
	protected org.osgi.framework.Version targetVersion = new org.osgi.framework.Version("0.0.2");
	
	public String getTitle(){
		return "Assignable transformation";
	}
	
	public org.osgi.framework.Version getSourceVersion() {
		return sourceVersion;
	}

	public org.osgi.framework.Version getTargetVersion() {
		return targetVersion;
	}

	public int updateProjectHistory(ProjectHistory projectHistory) {
		
		int numberOfUpdatedItems = 0;
		EList<Version> versions = projectHistory.getVersions();
		
		for (Version version : versions) {
			Project projectState = version.getProjectState();
			
			EList<ModelElement> allBugReports = projectState.getAllModelElementsbyClass(BugPackage.eINSTANCE.getBugReport(),
					new BasicEList<ModelElement>());
			for (ModelElement modelElement : allBugReports) {
				if (modelElement instanceof BugReport) {
					OrgUnit assignedTo = ((BugReport) modelElement).getAssignedTo();
					if (assignedTo != null) {
						numberOfUpdatedItems++;
						((BugReport) modelElement).setAssignee(assignedTo);
						((BugReport) modelElement).setAssignedTo(null);
						System.out.println("Updated assignee of bug report \"" 
								+ modelElement.getName() 
								+ "\" to " 
								+ ((BugReport) modelElement).getAssignee().getName());
					}
				}
			}
			
			EList<ModelElement> allIssues = projectState.getAllModelElementsbyClass(RationalePackage.eINSTANCE.getIssue(), 
					new BasicEList<ModelElement>());
			for (ModelElement modelElement : allIssues) {
				if (modelElement instanceof Issue) {
					User facilitator = ((Issue) modelElement).getFacilitator();
					if (facilitator != null) {
						numberOfUpdatedItems++;
						((Issue) modelElement).setAssignee(facilitator);
						((Issue) modelElement).setFacilitator(null);
						System.out.println("Updated assignee of issue \"" 
								+ modelElement.getName()
								+ "\" to " 
								+ ((Issue) modelElement).getAssignee().getName());
					}
				}
			}	
		}
		
		return numberOfUpdatedItems;
	}

}
