package org.unicase.test.tests.change.random.testcases;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
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
 * This test takes a random ME A; Takes randomly one of its containment references contRef; Creates a model element of
 * corresponding type; adds newly created ME to A.contRef; extracts changes on test project and applies them on compare
 * project; Test succeeds when test and compare projects are identical.
 * 
 * @author Hodaie
 */
public class ContainmentReferenceAddNewTest extends ChangePackageTest {

	private ModelElement me;
	private EReference refToChange;
	private EObject newInstance;

	public ContainmentReferenceAddNewTest(ProjectSpace testProjectSpace, String testName,
		TestProjectParmeters testProjParams) {
		super(testProjectSpace, testName, testProjParams);

	}

	@Override
	public void runTest() {

		TransactionalEditingDomain domain = TransactionalEditingDomain.Registry.INSTANCE
			.getEditingDomain("org.unicase.EditingDomain");
		domain.getCommandStack().execute(new RecordingCommand(domain) {

			@Override
			protected void doExecute() {
				doAddTest();
			}

		});

	}

	@SuppressWarnings("unchecked")
	private void doAddTest() {

		me = ChangeTestHelper.getRandomME(getTestProject());
		refToChange = ChangeTestHelper.getRandomContainmentRef(me);

		while (refToChange == null) {
			me = ChangeTestHelper.getRandomME(getTestProject());
			refToChange = ChangeTestHelper.getRandomContainmentRef(me);
		}

		EClass refType = refToChange.getEReferenceType();

		newInstance = ChangeTestHelper.createInstance(refType);

		if (newInstance == null) {
			throw new IllegalStateException("could not create a model element of specified type.");
		}

		Object object = me.eGet(refToChange);
		if (refToChange.isMany()) {
			EList<EObject> eList = (EList<EObject>) object;

			if (eList == null) {
				throw new IllegalStateException("Null list return for feature " + refToChange.getName() + " on "
					+ me.getName());

			} else {
				eList.add(newInstance);
			}

		} else {
			me.eSet(refToChange, newInstance);
		}

	}

	public int getExpectedNumOfChanges() {
		// 1. a CreateDeleteOp for new ME
		// 2. a MultiRefOp for parent.
		return 2;
	}

	@Override
	public boolean isSuccessful(ChangePackage changePackage) {
		// temp impl
		return changePackage.getOperations().size() == getExpectedNumOfChanges();
	}
}
