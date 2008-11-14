package org.unicase.test.tests.changetests.randomchange.testcases;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.emf.common.util.BasicEList;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.transaction.RecordingCommand;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.unicase.model.ModelElement;
import org.unicase.test.tests.changetests.ChangeTestHelper;
import org.unicase.test.tests.changetests.randomchange.RandomChangeTestCase;


/**
 * 
 * This is change package test.
 * It does the following: 
 * creates randomly a ME A in test project,
 * changes randomly one of its simple attributes attr
 * 
 * The expected change package should contain only one operation:
 *  -create operation: created A 
 *   (note that A.attr should be set)
 *   
 * @author Hodaie
 *
 */

public class CreateAndChangeAttributeTest extends RandomChangeTestCase {

	public CreateAndChangeAttributeTest(String testName, long randomSeed) {
		super(testName, randomSeed);
		
	}

	

}
