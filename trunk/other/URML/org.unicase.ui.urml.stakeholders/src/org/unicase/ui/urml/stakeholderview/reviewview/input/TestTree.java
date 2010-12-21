/**
 * <copyright> Copyright (c) 2008-2009 Jonas Helming, Maximilian Koegel. All rights reserved. This program and the
 * accompanying materials are made available under the terms of the Eclipse Public License v1.0 which accompanies this
 * distribution, and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>
 */
package org.unicase.ui.urml.stakeholderview.reviewview.input;

import org.eclipse.jface.viewers.TreeNode;
import org.unicase.ecp.model.NoWorkspaceException;

public class TestTree {

	public static TreeNode[] createTestTree() throws NoWorkspaceException{
//		TreeNode t1 = new TreeNode("Vater");
//		TreeNode t2 = new TreeNode("Kind1");
//		TreeNode t3 = new TreeNode("Kind2");
//		
//		t1.setChildren(new TreeNode[]{t2,t3});
//		t2.setParent(t1);
//		t3.setParent(t1);
//		return new TreeNode[]{t1};
		
		return UrmlTreeHandler.createTree(UrmlTreeHandler.getRequirementsAndGoalsfromProject(UrmlTreeHandler.getTestProject()));
	}
	public static void main(String[] args) throws NoWorkspaceException {
		System.out.println(createTestTree());
	}

}
