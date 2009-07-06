package org.unicase.test.tests.change.random.testcases;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.transaction.RecordingCommand;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.unicase.emfstore.esmodel.versioning.ChangePackage;
import org.unicase.model.ModelElement;
import org.unicase.test.tests.change.ChangeTestHelper;
import org.unicase.test.tests.change.random.ChangePackageTest;
import org.unicase.ui.test.TestProjectParmeters;
import org.unicase.workspace.ProjectSpace;

/**
 * This tests AttributeOperation. This is a ChangePackageTest. This test takes a random ME A. Change
 * A.someSimpleAttribute = a Change A.someSimpleAttribute = b Change A.someSimpleAttribute = c The expected change
 * package should contain only one operation: value of A.someSimpleAttribute changed from a to c
 * 
 * @author Hodaie
 */
public class AttributeTransitiveChangeTest extends ChangePackageTest {

	private ModelElement me;
	private EAttribute attributeToChange;
	private Object firstValue;
	private Object secondValue;
	private Object thirdValue;

	public AttributeTransitiveChangeTest(ProjectSpace testProjectSpace, String testName,
		TestProjectParmeters testProjParams) {
		super(testProjectSpace, testName, testProjParams);

	}

	@Override
	public void runTest() {

		me = ChangeTestHelper.getRandomME(getTestProject());
		attributeToChange = ChangeTestHelper.getRandomAttribute(me);

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
		firstValue = me.eGet(attributeToChange);
		ChangeTestHelper.changeAttribute(me, attributeToChange);

		secondValue = me.eGet(attributeToChange);

		// from b to c
		ChangeTestHelper.changeAttribute(me, attributeToChange);
		thirdValue = me.eGet(attributeToChange);
	}

	public int getExpectedNumOfChanges() {

		if (firstValue == null) {
			return 1;
		}
		if (firstValue.equals(secondValue) && secondValue.equals(thirdValue)) {
			return 0;
		}
		return 1;
	}

	@Override
	public boolean isSuccessful(ChangePackage changePackage) {
		// todo: test operations
		// result must be an attribOp containing me with old of vlaue its attrib
		// = a or unset and new value = c
		return changePackage.getOperations().size() == getExpectedNumOfChanges();
	}

}
