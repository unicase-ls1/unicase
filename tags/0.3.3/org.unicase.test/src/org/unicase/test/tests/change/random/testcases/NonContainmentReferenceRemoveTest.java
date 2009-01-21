package org.unicase.test.tests.change.random.testcases;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.emf.common.util.EList;
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





public class NonContainmentReferenceRemoveTest extends ChangePackageTest {

	private ModelElement me;
	private ModelElement meToRemove;
	private EReference refToChange;

	public NonContainmentReferenceRemoveTest(ProjectSpace testProjectSpace,
			String testName, TestProjectParmeters testProjParams) {
		super(testProjectSpace, testName, testProjParams);

	}

	@Override
	public void runTest() {

		TransactionalEditingDomain domain = TransactionalEditingDomain.Registry.INSTANCE
				.getEditingDomain("org.unicase.EditingDomain");
		domain.getCommandStack().execute(new RecordingCommand(domain) {

			@Override
			protected void doExecute() {
				doRemoveSimpleRef();
			}
		});

	}

	@SuppressWarnings("unchecked")
	private void doRemoveSimpleRef() {
		me = ChangeTestHelper.getRandomME(getTestProject());

		while (me.eCrossReferences().size() < 1) {
			me = ChangeTestHelper.getRandomME(getTestProject());
		}

		int size = me.eCrossReferences().size();
		int indexToRemove = (size == 1 ? 0 : getRandom().nextInt(size - 1));
		meToRemove = (ModelElement) me.eCrossReferences().get(indexToRemove);

		refToChange = findReference(me, meToRemove);


		Object object = me.eGet(refToChange);
		if (refToChange.isMany()) {
			EList<EObject> eList = (EList<EObject>) object;
			eList.remove(meToRemove);
		} else {
			me.eSet(refToChange, null);
		}

	}

	@SuppressWarnings("unchecked")
	private EReference findReference(ModelElement modelElement,
			ModelElement referencedME) {

		List<EReference> refsMatchingReferencedME = new ArrayList<EReference>();
		for (EReference ref : modelElement.eClass().getEAllReferences()) {
			if (!(ref.isContainer() || ref.isContainment())
					&& (ref.getEReferenceType().equals(referencedME.eClass()) || ref
							.getEReferenceType().isSuperTypeOf(
									referencedME.eClass()))) {
				refsMatchingReferencedME.add(ref);
			}
		}

		if (refsMatchingReferencedME.size() == 1) {
			return refsMatchingReferencedME.get(0);
		}

		for (EReference ref : refsMatchingReferencedME) {
			Object object = me.eGet(ref);
			if(object == null){
				continue;
			}
			if (ref.isMany()) {
				EList<EObject> eList = (EList<EObject>) object;
				if (eList.contains(referencedME)) {
					return ref;
				}
			} else {
				if (me.eGet(ref).equals(referencedME)) {
					return ref;
				}
			}
		}

		return null;

	}

	public int getExpectedNumOfChanges() {

		//a MultiRefOperation or a SingleRefOperation
		return 1;
	}

	@Override
	public boolean isSuccessful(ChangePackage changePackage) {

		// todo: test the operations too
		boolean ret = (changePackage.getOperations().size() == getExpectedNumOfChanges());
		return ret;
	}

}


