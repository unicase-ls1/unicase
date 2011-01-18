package org.unicase.xmi.commands;

import org.eclipse.core.expressions.PropertyTester;
import org.unicase.ecp.model.workSpaceModel.ECPProject;
import org.unicase.xmi.workspace.XmiUtil.PROJECT_STATUS;
import org.unicase.xmi.xmiworkspacestructure.XMIECPFileProject;
import org.unicase.xmi.xmiworkspacestructure.XMIECPProject;

public class ProjectStatusTester extends PropertyTester {
	
	/**
	 * Return true when the project is a XMIECPFilePRoject and the project's status is "failed".
	 */
	public boolean test(Object receiver, String property, Object[] args, Object expectedValue) {
		
		if (receiver instanceof XMIECPProject){
			XMIECPFileProject project = (XMIECPFileProject) receiver;
			
			if (project.getProjectStatus() == PROJECT_STATUS.FAILED){
				return true;
			}
		}
		
		return false;
	}
}
