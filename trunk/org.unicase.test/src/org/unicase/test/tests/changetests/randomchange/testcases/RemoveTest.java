package org.unicase.test.tests.changetests.randomchange.testcases;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.emf.common.util.BasicEList;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.transaction.RecordingCommand;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.unicase.model.ModelElement;
import org.unicase.test.tests.changetests.ChangeTestHelper;
import org.unicase.test.tests.changetests.randomchange.IChangePackageTest;
import org.unicase.test.tests.changetests.randomchange.RandomChangeTestCase;
import org.unicase.ui.test.TestProjectParmeters;

/**
 * 
 * This is change package test. It does the following: takes randomly a ME A
 * from test project, takes randomly one of its containment features, remove
 * randomly one of the contained MEs B from this feature.
 * 
 * The expected change package should contain two operations: - change
 * operation: changed A.contRef - delete operation: deleted B
 * 
 * @author Hodaie
 * 
 */
public class RemoveTest extends RandomChangeTestCase implements
		IChangePackageTest {

	private static final int EXPECTED_NUM_OF_CHANGES = 2;

	public RemoveTest(String testName, TestProjectParmeters testProjParams) {
		super(testName, testProjParams);


	}

	@Override
	public void runTest() {

		TransactionalEditingDomain domain = TransactionalEditingDomain.Registry.INSTANCE
				.getEditingDomain("org.unicase.EditingDomain");
		domain.getCommandStack().execute(new RecordingCommand(domain) {

			@Override
			protected void doExecute() {
				doRemove();
			}
		});

	}
	
	
	private void doRemove() {
		ModelElement me = ChangeTestHelper
				.getRandomME(getTestProject());
		ModelElement meToRemove = getMEToRemove(me);
		while (meToRemove == null) {
			me = ChangeTestHelper.getRandomME(getTestProject());
			meToRemove = getMEToRemove(me);
		}

		EReference ref = (EReference) meToRemove.eContainingFeature();

		Object object = me.eGet(ref);
		if (ref.isMany()) {
			EList<EObject> eList = (EList<EObject>) object;
			eList.remove(meToRemove);
		} else {
			me.eUnset(ref);
		}
	}
	
	

	private ModelElement getMEToRemove(ModelElement me) {
		// 1. check if it has me.containments.size() != 0
		// 2. select a random containment ref
		// 3. see if ref contains an element
		// 4. if ref has a list of objects select one of them in random
		// 5. if ref has only one object (ref is not many) return it.
		ModelElement meToRemove = null;
		List<EReference> containments = me.eClass().getEAllContainments();
		if(containments.size() == 0){
			return null;
		}
		
		int size = containments.size();
		EReference containment = containments.get(size == 1 ? 0 : getRandom().nextInt(size - 1));
		Object object = me.eGet(containment);
		if(object == null){
			return null;
		}
		if(containment.isMany()){
			EList<EObject> eList = (EList<EObject>) object;
			if(eList.size() == 0){
				return null;
			}else{
				int sz = eList.size();
				meToRemove = (ModelElement) eList.get(sz == 1 ? 0 : getRandom().nextInt(sz - 1));
			}
		}else{
			meToRemove = (ModelElement) object;
		}
			
			
		return meToRemove;
	}

	
	
	public int getExpectedNumOfChanges() {

		return EXPECTED_NUM_OF_CHANGES;
	}

}
