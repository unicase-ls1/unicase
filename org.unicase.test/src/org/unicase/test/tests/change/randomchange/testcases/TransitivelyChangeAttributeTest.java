package org.unicase.test.tests.change.randomchange.testcases;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EEnum;
import org.eclipse.emf.ecore.EEnumLiteral;
import org.eclipse.emf.transaction.RecordingCommand;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.unicase.emfstore.esmodel.versioning.ChangePackage;
import org.unicase.model.ModelElement;
import org.unicase.model.ModelPackage;
import org.unicase.test.tests.change.ChangeTestHelper;
import org.unicase.test.tests.change.randomchange.IChangePackageTest;
import org.unicase.test.tests.change.randomchange.RandomChangeTestCase;
import org.unicase.ui.test.TestProjectParmeters;

/**
 * This is a ChangePackageTest. This test takes a random ME A. Change
 * A.someSimpleAttribute = a Change A.someSimpleAttribute = b Change
 * A.someSimpleAttribute = c The expected change package should contain only one
 * operation: value of A.someSimpleAttribute changed from a to c
 * 
 * 
 * @author Hodaie
 * 
 */
public class TransitivelyChangeAttributeTest extends RandomChangeTestCase
		implements IChangePackageTest {

	private static final int EXPECTED_NUM_OF_CHANGES = 1;
	private ModelElement me;

	public TransitivelyChangeAttributeTest(String testName,
			TestProjectParmeters testProjParams) {
		super(testName, testProjParams);

	}

	@Override
	public void runTest() {

		me = ChangeTestHelper.getRandomME(getTestProject());

		TransactionalEditingDomain domain = TransactionalEditingDomain.Registry.INSTANCE
				.getEditingDomain("org.unicase.EditingDomain");

		domain.getCommandStack().execute(new RecordingCommand(domain) {

			@Override
			protected void doExecute() {
				transChangeAttr();

			}

		});

	}

	protected void transChangeAttr() {
		// from unset or a to b
		EAttribute attribute = ChangeTestHelper.changeSimpleAttribute(me, null);

		// from b to c
		ChangeTestHelper.changeSimpleAttribute(me, attribute);
	}

	public int getExpectedNumOfChanges() {

		return EXPECTED_NUM_OF_CHANGES;
	}

	public boolean isSuccessful() {
		// todo: test operations
		// result must be an attribOp containing me with old of vlaue its attrib
		// = a or unset and new value = c
		return EXPECTED_NUM_OF_CHANGES == 1;
	}

	public ChangePackage getChangePackage(boolean removeChanges) {
		return ChangeTestHelper.getChangePackage(getTestProjectSpace()
				.getOperations(), true, removeChanges);

	}

}
