package org.eclipse.emf.emfstore.client.model;

import java.util.Date;
import java.util.List;

import org.eclipse.emf.emfstore.common.model.IdentifiableElement;
import org.eclipse.emf.emfstore.common.model.Project;
import org.eclipse.emf.emfstore.server.model.ProjectId;
import org.eclipse.emf.emfstore.server.model.versioning.PrimaryVersionSpec;
import org.eclipse.emf.emfstore.server.model.versioning.operations.AbstractOperation;

public interface ProjectSpaceData extends IdentifiableElement {

	PrimaryVersionSpec getBaseVersion();
	
	Date getLastUpdated();
	
	List<String> getOldLogMessages();
	
	String getProjectDescription();
	
	ProjectId getProjectId();
	
	String getProjectName();
	
	Usersession getUsersession();
	
	boolean isDirty();
	
	boolean isLoaded();
	
	void load();
	
	Project getProject();
	
	List<AbstractOperation> getOperations();
	
	void setProjectDescription(String newProjectDescription);
	
	void setProjectName(String newProjectName);

}
