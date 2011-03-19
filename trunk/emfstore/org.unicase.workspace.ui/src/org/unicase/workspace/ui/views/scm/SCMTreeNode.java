/**
 * <copyright> Copyright (c) 2008-2009 Jonas Helming, Maximilian Koegel. All rights reserved. This program and the
 * accompanying materials are made available under the terms of the Eclipse Public License v1.0 which accompanies this
 * distribution, and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>
 */
package org.unicase.workspace.ui.views.scm;

import org.eclipse.emf.emfstore.client.ProjectSpace;
import org.eclipse.jface.viewers.TreeNode;

/**
 * A TreeNode class which also contains a reference to the ProjectSpace.
 * 
 * @author shterev
 */
public class SCMTreeNode extends TreeNode {

	private ProjectSpace projectSpace;

	/**
	 * Default Constructor.
	 * 
	 * @param value the contained object
	 */
	public SCMTreeNode(Object value) {
		super(value);
	}

	/**
	 * @param projectSpace the projectSpace to set
	 */
	public void setProjectSpace(ProjectSpace projectSpace) {
		this.projectSpace = projectSpace;
	}

	/**
	 * @return the projectSpace
	 */
	public ProjectSpace getProjectSpace() {
		return projectSpace;
	}

}
