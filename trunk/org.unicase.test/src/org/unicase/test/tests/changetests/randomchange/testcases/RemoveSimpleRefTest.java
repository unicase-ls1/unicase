package org.unicase.test.tests.changetests.randomchange.testcases;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.util.ECrossReferenceEList;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.transaction.RecordingCommand;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.unicase.emfstore.esmodel.versioning.ChangePackage;
import org.unicase.model.ModelElement;
import org.unicase.test.tests.changetests.ChangeTestHelper;
import org.unicase.test.tests.changetests.randomchange.IChangePackageTest;
import org.unicase.test.tests.changetests.randomchange.RandomChangeTestCase;
import org.unicase.ui.test.TestProjectParmeters;

public class RemoveSimpleRefTest extends RandomChangeTestCase implements
		IChangePackageTest {

	private static final int EXPECTED_NUM_OF_CHANGES = 1;
	private ChangePackage changePackage; 
	
	public RemoveSimpleRefTest(String testName,
			TestProjectParmeters testProjParams) {
		super(testName, testProjParams);

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

	private void doRemoveSimpleRef() {
		ModelElement me = ChangeTestHelper.getRandomME(getTestProject());
		Map.Entry<Object, Integer> meToRemove = getMEToRemove(me);
		while (meToRemove == null) {
			me = ChangeTestHelper.getRandomME(getTestProject());
			meToRemove = getMEToRemove(me);
		}

		EReference ref = (EReference)me.eClass().getEStructuralFeature( meToRemove.getValue().intValue());
		

		Object object = me.eGet(ref);
		if (ref.isMany()) {
			EList<EObject> eList = (EList<EObject>) object;
			eList.remove(meToRemove.getKey());
		} else {
			me.eSet(ref, null);
		}
		
		changePackage = getChangePackage(true);
	}

	private Map.Entry<Object, Integer> getMEToRemove(ModelElement me) {

		List<EReference> allNonContainmentRefs = new ArrayList<EReference>();
		for (EReference tmpRef : me.eClass().getEAllReferences()) {
			if (!tmpRef.isContainer() && !tmpRef.isContainment()) {
				allNonContainmentRefs.add(tmpRef);
			}
		}

		// a map of <eobject, featureId>
		Map<Object, Integer> referencedMEs = new HashMap<Object, Integer>();
		for (EReference ref : allNonContainmentRefs) {
			Object object = me.eGet(ref);
			if (ref.isMany()) {
				EList<EObject> eList = (EList<EObject>) object;
				for (Object obj : eList) {
					referencedMEs.put(obj, ref.getFeatureID());
				}

			} else {

				referencedMEs.put(me.eGet(ref), ref.getFeatureID());
			}

		}

		if (referencedMEs.size() == 0) {
			return null;
		}

		Object[] entries = referencedMEs.entrySet().toArray();
		int length = entries.length;
		int index = length == 1 ? 0 : getRandom().nextInt(length - 1);
		return (Map.Entry<Object, Integer>) entries[index];

	}

	public ChangePackage getChangePackage(boolean removeChanges) {

		if(changePackage == null){
			changePackage = ChangeTestHelper.getChangePackage(getTestProjectSpace()
				.getOperations(), true, removeChanges);
		}
		 return changePackage;
	}

	public int getExpectedNumOfChanges() {

		return EXPECTED_NUM_OF_CHANGES;
	}

	public boolean isSuccessful() {

		return changePackage.getOperations().size() == EXPECTED_NUM_OF_CHANGES;
	}

}
