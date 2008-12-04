package org.unicase.test.tests.change.random.testcases;

import java.util.List;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.common.util.TreeIterator;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.transaction.RecordingCommand;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.unicase.emfstore.esmodel.versioning.ChangePackage;
import org.unicase.model.ModelElement;
import org.unicase.test.tests.change.ChangeTestHelper;
import org.unicase.test.tests.change.random.IChangePackageTest;
import org.unicase.test.tests.change.random.RandomChangeTestCase;
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
public class RemoveContainmentTest extends RandomChangeTestCase implements
		IChangePackageTest {

	
	private ModelElement meToRemove;
	private ModelElement me;
	private ChangePackage changePackage;

	public RemoveContainmentTest(String testName, TestProjectParmeters testProjParams) {
		super(testName, testProjParams);


	}

	@Override
	public void runTest() {

		TransactionalEditingDomain domain = TransactionalEditingDomain.Registry.INSTANCE
				.getEditingDomain("org.unicase.EditingDomain");
		domain.getCommandStack().execute(new RecordingCommand(domain) {

			@Override
			protected void doExecute() {
				doRemoveContainment();
			}
		});

	}
	
	
	private void doRemoveContainment() {
		me = ChangeTestHelper
				.getRandomME(getTestProject());
		meToRemove = getMEToRemove(me);
		while (meToRemove == null) {
			me = ChangeTestHelper.getRandomME(getTestProject());
			meToRemove = getMEToRemove(me);
		}

		EReference ref = (EReference) meToRemove.eContainingFeature();
		
		//we can also use this
		EcoreUtil.remove(me, ref, meToRemove);

//		Object object = me.eGet(ref);
//		if (ref.isMany()) {
//			EList<EObject> eList = (EList<EObject>) object;
//			eList.remove(meToRemove);
//		} else {
//			me.eSet(ref, null);
//		}
		
		changePackage = getChangePackage(true);
	}
	
	

	private ModelElement getMEToRemove(ModelElement me) {
		// 1. check if it has me.containments.size() != 0
		// 2. select a random containment ref
		// 3. see if ref contains an element
		// 4. if ref has a list of objects select one of them in random
		// 5. if ref has only one object (ref is not many) return it.
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

		//a multiRefOp for container, 
		//a deleteOp for meToRemove
		//+ multiRefOp for meToRemove.crossrefs.size()
		//+ deleteOp for meToRemove.contents().size()
		//+ multiRefOp for each(content in contents) content.crossref.size()
		
		int numOfOps = 1 + 1 + meToRemove.eCrossReferences().size();
		for(TreeIterator<EObject> iter = meToRemove.eAllContents(); iter.hasNext(); ){
			numOfOps ++;
			numOfOps += iter.next().eCrossReferences().size();
			
		}
		return numOfOps;
	}

	public boolean isSuccessful() {
		
		//todo: test the operations too
		return changePackage.getOperations().size() == getExpectedNumOfChanges();
		 
	}
	
	
	public ChangePackage getChangePackage(boolean removeChanges) {
		if(changePackage == null){
			changePackage = ChangeTestHelper.getChangePackage(getTestProjectSpace()
				.getOperations(), true, removeChanges);
		}
		return changePackage;

	}

}
