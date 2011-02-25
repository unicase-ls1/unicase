/**
 * <copyright> Copyright (c) 2008 Jonas Helming, Maximilian Koegel. All rights reserved. This program and the
 * accompanying materials are made available under the terms of the Eclipse Public License v1.0 which accompanies this
 * distribution, and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>
 */


package org.unicase.workspace.test;

/**
 * This is a list of template projects used for testing. RANDOM_nnK means a random generated project with nn thousand model elements.
 * Template test projects are located at a /TestProjects folder. 
 * 
 * 
 * @author hodaie
 *
 */
public enum TestProjectEnum {
	/**
	 * a random generated project (with about 6000 elements) with these parameter(10, 12345, 5, 3, 15, 20).
	 */
	RANDOM_6K("TestProjects/randomProject6"),
	
	/**
	 * a random generated project (with about 8000 elements) with these parameter(15, 12345, 5, 3, 15, 20).
	 */
	RANDOM_8K("TestProjects/randomProject8"),
	
	/**
	 *  a random generated project (with about 12000 elements) with these parameter(20, 12345, 5, 5, 10, 20).
	 */
	RANDOM_12K("TestProjects/randomProject12"),
	
	/**
	 * a random generated project (with about 14000 elements) with these parameter(30, 123, 5, 5, 10, 20).
	 */
	RANDOM_14K("TestProjects/randomProject14"),

	/**
	 * use a random generated project (with about 25000 elements) with these parameter(70, 123, 5, 5, 10, 20).
	 */
	RANDOM_25K("TestProjects/randomProject25"), 
	
	/**
	 * dolli2 project.
	 */
	DOLLI2("TestProjects/dolli2.ucp"),
	
	/**
	 *  use unicase project.
	 */
	UNICASE("TestProjects/unicase.ucp"), 
	
	/**
	 * no test project.
	 */
	NONE("");


	
	private String path = "TestProjects/unicase.ucp";

	private TestProjectEnum(String path){
		this.path = path;
	}

	

	/**
	 * @return test project path
	 * @return
	 */
	public String getPath() {
		return path;
	}
	

}
