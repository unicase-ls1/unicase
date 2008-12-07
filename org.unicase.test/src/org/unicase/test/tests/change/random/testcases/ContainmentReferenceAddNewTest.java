package org.unicase.test.tests.change.random.testcases;

import java.util.List;

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
 * 
 * This test takes a random ME A; Takes randomly one of its containment
 * references contRef; Creates a model element of corresponding type; adds newly
 * created ME to A.contRef; extracts changes on test project and applies them on
 * compare project; Test succeeds when test and compare projects are identical.
 * 
 * 
 * 
 * @author Hodaie
 * 
 */
public class ContainmentReferenceAddNewTest extends ChangePackageTest {

	private static final int EXPECTED_NUM_OF_CHANGES = 2;

	public ContainmentReferenceAddNewTest(ProjectSpace testProjectSpace, String testName, TestProjectParmeters testProjParams) {
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

		ModelElement me = ChangeTestHelper.getRandomME(getTestProject());
		List<EReference> containments = me.eClass().getEAllContainments();

		while (containments.size() == 0) {
			me = ChangeTestHelper.getRandomME(getTestProject());
			containments = me.eClass().getEAllContainments();
		}

		int size = containments.size();
		EReference ref = containments.get(size == 1 ? 0 : getRandom().nextInt(
				size - 1));
		EClass refType = ref.getEReferenceType();

		ModelElement newInstance = ChangeTestHelper.createInstance(refType);

		if (newInstance == null) {
			return;
		}

		Object object = me.eGet(ref);
		if (ref.isMany()) {
			EList<EObject> eList = (EList<EObject>) object;
			if (eList == null) {
				throw new IllegalStateException("Null list return for feature "
						+ ref.getName() + " on " + me.getName());
			} else {
				eList.add(newInstance);
			}
		} else {
			me.eSet(ref, newInstance);
		}
	}

	public int getExpectedNumOfChanges() {
		return EXPECTED_NUM_OF_CHANGES;
	}

	@Override
	public boolean isSuccessful(ChangePackage changePackage) {
		// temp impl
		return getChangePackage(true).getOperations().size() == EXPECTED_NUM_OF_CHANGES;
	}
}
