package org.unicase.test.tests.change.random.testcases;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.transaction.RecordingCommand;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.unicase.emfstore.esmodel.versioning.ChangePackage;
import org.unicase.model.ModelElement;
import org.unicase.model.Project;
import org.unicase.test.tests.change.ChangeTestHelper;
import org.unicase.test.tests.change.random.ChangePackageTest;
import org.unicase.ui.test.TestProjectParmeters;
import org.unicase.workspace.ProjectSpace;

public class ContainmentReferenceMoveTest extends ChangePackageTest {

	private ModelElement me;
	private EReference refToChange;
	private ModelElement meToMove;
	private Object oldParent;

	// private Object oldValueOfRef;

	public ContainmentReferenceMoveTest(ProjectSpace testProjectSpace, String testName,
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
				doMoveTest();
			}
		});

	}

	@SuppressWarnings("unchecked")
	private void doMoveTest() {

		oldParent = null;
		// oldValueOfRef = null;

		me = ChangeTestHelper.getRandomME(getTestProject());
		refToChange = ChangeTestHelper.getRandomContainmentRef(me);

		while (refToChange == null) {
			me = ChangeTestHelper.getRandomME(getTestProject());
			refToChange = ChangeTestHelper.getRandomContainmentRef(me);
		}

		meToMove = ChangeTestHelper.getRandomMEofType(getTestProject(), refToChange.getEReferenceType());
		while (meToMove.equals(me) || EcoreUtil.isAncestor(meToMove, me)) {
			meToMove = ChangeTestHelper.getRandomMEofType(getTestProject(), refToChange.getEReferenceType());
		}

		oldParent = meToMove.eContainer();
		// oldValueOfRef = me.eGet(refToChange);

		Object object = me.eGet(refToChange);

		if (refToChange.isMany()) {
			EList<EObject> eList = (EList<EObject>) object;
			if (eList == null) {
				throw new IllegalStateException("Null list return for feature " + refToChange.getName() + " on "
					+ me.getName());
			} else {
				eList.add(meToMove);
			}
		} else {
			me.eSet(refToChange, meToMove);
		}

		Object obj = new Object();
		obj.toString();

	}

	public int getExpectedNumOfChanges() {

		// a MultiRefOperation for removing the meToMove from its former parent,
		// a MultiRefOperation for adding the meToMove to its new parent (me)
		if (me.equals(oldParent)) {
			// notification is touch, there will be no operation created
			return 0;
		}

		if (oldParent instanceof Project) {
			return 1;
		}

		return 2;

	}

	@Override
	public boolean isSuccessful(ChangePackage changePackage) {
		// temp impl
		boolean ret = (changePackage.getOperations().size() == getExpectedNumOfChanges());
		return ret;
	}

}
