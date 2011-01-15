package org.unicase.xmi.commands;

import org.eclipse.core.expressions.PropertyTester;
import org.unicase.ecp.model.workSpaceModel.ECPProject;
import org.unicase.xmi.workspace.XmiUtil.PROJECT_STATUS;
import org.unicase.xmi.xmiworkspacestructure.XMIECPFileProject;

public class ProjectStatusTester extends PropertyTester{
	
	public boolean test(Object receiver, String property, Object[] args, Object expectedValue) {
		if (receiver instanceof ECPProject && expectedValue instanceof PROJECT_STATUS){
			XMIECPFileProject project = (XMIECPFileProject) receiver;
			if (project.getProjectStatus() == PROJECT_STATUS.FAILED){
				return true;
			}
		}
		return true;
	}
}
