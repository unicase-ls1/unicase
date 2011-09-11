/**
 * <copyright> Copyright (c) 2008-2009 Jonas Helming, Maximilian Koegel. All rights reserved. This program and the
 * accompanying materials are made available under the terms of the Eclipse Public License v1.0 which accompanies this
 * distribution, and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>
 */
package org.unicase.ui.urml.stakeholders.review.input;

import org.eclipse.jface.viewers.TreeNode;
import org.unicase.ecp.model.NoWorkspaceException;

/**
 * Test tree for the input.
 * @author kterzieva
 * 
 */
public final class TestTree {

	
	private TestTree(){
		
	}
	/**
	 * Creates the test tree.
	 * @return test tree
	 * @throws NoWorkspaceException .
	 */
	public static TreeNode[] createTestTree() throws NoWorkspaceException{		
		return UrmlTreeHandler.createTree(UrmlTreeHandler.getRequirementsFromProject(UrmlTreeHandler.getTestProject()));
	}
	
	/**
	 * The main method.
	 * @param args the arguments
	 * @throws NoWorkspaceException .
	 */
//	public static void main(String[] args) throws NoWorkspaceException {
//		System.out.println(createTestTree());
//	}

}
