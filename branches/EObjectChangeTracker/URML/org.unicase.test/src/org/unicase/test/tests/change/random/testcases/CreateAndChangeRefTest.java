package org.unicase.test.tests.change.random.testcases;

import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.transaction.RecordingCommand;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.unicase.emfstore.esmodel.versioning.ChangePackage;
import org.unicase.model.ModelElement;
import org.unicase.test.tests.change.ChangeTestHelper;
import org.unicase.test.tests.change.random.ChangePackageTest;
import org.unicase.ui.test.TestProjectParmeters;
import org.unicase.workspace.ProjectSpace;

/**
 * This is a change package test. It creates randomly a ME A, changes one of its non-containment references. The
 * expected change package should contain two operations - a create operation: created A - a change operation: either
 * A.ref changed to B or B.oppositeRef changed to A
 * 
 * @author Hodaie
 */
public class CreateAndChangeRefTest extends ChangePackageTest {

	private ModelElement me;
	private EReference refToChange;
	private ModelElement meToReference;
	private Object oldValueOfOppositeRef;

	public CreateAndChangeRefTest(ProjectSpace testProjectSpace, String testName, TestProjectParmeters testProjParams) {
		super(testProjectSpace, testName, testProjParams);

	}

	@Override
	public void runTest() {
		me = ChangeTestHelper.createRandomME();
		refToChange = ChangeTestHelper.getRandomNonContainmentRef(me);

		while (refToChange == null) {
			me = ChangeTestHelper.createRandomME();
			refToChange = ChangeTestHelper.getRandomNonContainmentRef(me);
		}

		meToReference = ChangeTestHelper.getRandomMEofType(getTestProject(), refToChange.getEReferenceType());
		if (meToReference == null) {
			return;
		}
		// make a copy of old value of opposite reference for later inspection
		// (see getExpectedNumOfChanges())
		if (refToChange.getEOpposite() != null && refToChange.getEOpposite().getUpperBound() == 1
			&& refToChange.isMany()) {

			oldValueOfOppositeRef = meToReference.eGet(refToChange.getEOpposite());
		}

		TransactionalEditingDomain domain = TransactionalEditingDomain.Registry.INSTANCE
			.getEditingDomain("org.unicase.EditingDomain");

		domain.getCommandStack().execute(new RecordingCommand(domain) {

			@Override
			protected void doExecute() {

				doAddAndChangeRef();

			}

		});

	}

	protected void doAddAndChangeRef() {

		getTestProject().getModelElements().add(me);
		ChangeTestHelper.changeNonContainmentRef(me, refToChange, meToReference);

	}

	public int getExpectedNumOfChanges() {
		// a CreateDeleteOperation
		// and a MultiReferenceOpertaion
		// if refToChange or its opposite has upper bound 1 then additionally a
		// SimpleRefOp
		int numOfOps = 2;

		if (refToChange.getEOpposite() != null && refToChange.getEOpposite().getUpperBound() == 1) {
			// why don't we test refToChange.getUpperBound() == 1 ?
			// because even if refToChange for newly created model element has
			// upper bound 1,
			// its initial value is null! and therefore we do not expect a
			// SingleRefOp for it to be created.
			if (refToChange.isMany() && oldValueOfOppositeRef != null) {
				// why do we check this?
				// because if both refToChange and its opposite have upper bound
				// 1, then there is just one SingleRefOp to create. Hence number
				// of operations is just 2.

				numOfOps = 3;
			}

		}

		return numOfOps;

	}

	@Override
	public boolean isSuccessful(ChangePackage changePackage) {
		// temp impl
		boolean ret = (changePackage.getOperations().size() == getExpectedNumOfChanges());
		return ret;

	}

}
