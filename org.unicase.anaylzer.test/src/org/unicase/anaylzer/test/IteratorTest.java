/**
 * <copyright> Copyright (c) 2008 Jonas Helming, Maximilian Koegel. All rights reserved. This program and the accompanying materials are made available under the terms of the Eclipse Public License v1.0 which accompanies this distribution, and is available at http://www.eclipse.org/legal/epl-v10.html
 * </copyright>
 */

package org.unicase.anaylzer.test;

import static org.junit.Assert.assertTrue;

import org.junit.After;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.unicase.workspace.test.SetupHelper;
import org.unicase.workspace.test.TestProjectEnum;


public class IteratorTest {
	
	private static SetupHelper setupHelper;

	/**
	 * 
	 */
	@BeforeClass
	public static void init()  {
	  SetupHelper.startSever();
	  
	  setupHelper = new SetupHelper(TestProjectEnum.NONE);
	  SetupHelper.setupSeverSpace();
	  setupHelper.equals(null);
	  
	
	}

	/**
	 * 
	 */
	@Before
	public void setup() {
		// here the code that must be run before every test case

	}
	
	
	/**
	 * 
	 */
	@Test
	public void test1(){
		// do test
		
		//assertTrue(IntegrationTestHelper.areEqual(getTestProject(), getCompareProject(), "MultiReferenceMoveTest"));
		assertTrue(true);
	}
	
	
	/**
	 * 
	 */
	@Test
	public void test2(){
		
		
		
	}

	/**
	 * 
	 */
	@After
	public void cleanUp() {
		
		// here the code that must be run after every test case
	
	}

	
	

	


}
