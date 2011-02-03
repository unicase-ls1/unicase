/**
 * <copyright> Copyright (c) 2008-2009 Jonas Helming, Maximilian Koegel. All rights reserved. This program and the
 * accompanying materials are made available under the terms of the Eclipse Public License v1.0 which accompanies this
 * distribution, and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>
 */
package org.unicase.xmi.commands;

import org.eclipse.core.expressions.PropertyTester;
import org.unicase.xmi.workspace.XmiUtil.PROJECT_STATUS;
import org.unicase.xmi.xmiworkspacestructure.XMIECPFileProject;
import org.unicase.xmi.xmiworkspacestructure.XMIECPProject;

/**
 * PropertyTester for checking whether the project status is "failed".
 * @author kraftm, maierma
 *
 */
public class ProjectStatusTester extends PropertyTester {
	
	/**
	 * Return true when the project is a XMIECPFilePRoject and the project's status is "failed" or "duplicated".
	 * {@inheritDoc}
	 */
	public boolean test(Object receiver, String property, Object[] args, Object expectedValue) {
		// cast the receiver to XMIECPProject
		if (receiver instanceof XMIECPProject){
			XMIECPFileProject project = (XMIECPFileProject) receiver;
			
			// if the status is failed or duplicated tell the menu to show the "resolve" entry
			if (project.getProjectStatus() == PROJECT_STATUS.FAILED ||
					project.getProjectStatus() == PROJECT_STATUS.DUPLICATED) {
				return true;
			}
		}
		
		return false;
	}
}
