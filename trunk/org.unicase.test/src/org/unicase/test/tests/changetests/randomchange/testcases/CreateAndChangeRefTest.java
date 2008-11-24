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
import org.unicase.test.tests.changetests.randomchange.IChangePackageTest;
import org.unicase.test.tests.changetests.randomchange.RandomChangeTestCase;
import org.unicase.ui.test.TestProjectParmeters;

/**
 * 
 * This is a change package test. It creates randomly a ME A, changes one of its
 * non-containment references. The expected change package should contain two
 * operations - a create operation: created A - a change operation: either A.ref
 * changed to B or B.oppositeRef changed to A
 * 
 * @author Hodaie
 * 
 */
public class CreateAndChangeRefTest extends RandomChangeTestCase implements
		IChangePackageTest {

	private static final int EXPECTED_NUM_OF_CHANGES = 2;

	public CreateAndChangeRefTest(String testName, TestProjectParmeters testProjParams) {
		super(testName, testProjParams);

	}

	@Override
	public void runTest() {
		final ModelElement me = ChangeTestHelper.createRandomME();
		// me.setName("newly created " + me.eClass().getName());

		TransactionalEditingDomain domain = TransactionalEditingDomain.Registry.INSTANCE
				.getEditingDomain("org.unicase.EditingDomain");

		domain.getCommandStack().execute(new RecordingCommand(domain) {

			@Override
			protected void doExecute() {
				getTestProject().getModelElements().add(me);
				changeSimpleRef(me);
			}

		});

	}

	private void changeSimpleRef(ModelElement me) {

		List<EReference> nonContainmentRefs = new ArrayList<EReference>();
		for (EReference ref : me.eClass().getEAllReferences()) {
			if (!ref.isContainment() && !ref.isContainer()) {
				nonContainmentRefs.add(ref);
			}
		}

		EReference ref = nonContainmentRefs.get(getRandom().nextInt(
				nonContainmentRefs.size() - 1));
		EClass refType = ref.getEReferenceType();
		List<ModelElement> refTypeMEs = getTestProject()
				.getAllModelElementsbyClass(refType,
						new BasicEList<ModelElement>());

		if (refTypeMEs.contains(me)) {
			refTypeMEs.remove(me);
		}

		ModelElement toBeReferencedME = refTypeMEs.get(getRandom().nextInt(
				refTypeMEs.size() - 1));

		Object object = me.eGet(ref);
		if (ref.isMany()) {
			EList<EObject> eList = (EList<EObject>) object;
			if (eList == null) {
				throw new IllegalStateException("Null list return for feature "
						+ ref.getName() + " on " + me.getName());
			} else {
				eList.add(toBeReferencedME);
			}
		} else {
			me.eSet(ref, toBeReferencedME);
		}

	}

	public int getExpectedNumOfChanges() {
		return EXPECTED_NUM_OF_CHANGES;
	}

}
