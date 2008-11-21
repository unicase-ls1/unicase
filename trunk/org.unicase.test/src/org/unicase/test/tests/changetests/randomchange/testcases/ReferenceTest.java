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

/**
 * This is a compare test.
 * It takes a random model element from test project and changes one of its non-containment
 * references, applies this change to compare project. 
 * Test succeeds when both projects are identical, and fails otherwise.
 * 
 * @author Hodaie
 * 
 */
public class ReferenceTest extends RandomChangeTestCase  implements IChangePackageTest{

	private static final int EXPECTED_NUM_OF_CHANGES = 1;
	
	public ReferenceTest(String testName, long randomSeed) {
		super(testName, randomSeed);

	}

	@Override
	public void runTest() {

		int numOfChanges = getRandom().nextInt(40);
		List<ModelElement> modelElements = ChangeTestHelper.getRandomMEs(getTestProject(), numOfChanges, true);
		
		TransactionalEditingDomain domain = TransactionalEditingDomain.Registry.INSTANCE
				.getEditingDomain("org.unicase.EditingDomain");

		for (int i = 0; i < modelElements.size(); i++) {
			final ModelElement me = modelElements.get(i);
			final List<EReference> nonContainmentRefs = new ArrayList<EReference>();
			for (EReference ref : me.eClass().getEAllReferences()) {
				if (!(ref.isContainment() || ref.isContainer())) {
					nonContainmentRefs.add(ref);
				}
			}

			domain.getCommandStack().execute(new RecordingCommand(domain) {

				@Override
				protected void doExecute() {
					changeReference(me, nonContainmentRefs);
				}

			});
		}
		

		System.out.println(getTestName() + "; " + numOfChanges + " reference changes");

	}

	@SuppressWarnings("unchecked")
	private void changeReference(ModelElement me,
			List<EReference> nonContainmentRefs) {

		EReference ref = nonContainmentRefs.get(getRandom().nextInt(
				nonContainmentRefs.size() - 1));
		EClass refType = ref.getEReferenceType();
		List<ModelElement> refTypeMEs = getTestProject()
				.getAllModelElementsbyClass(refType,
						new BasicEList<ModelElement>());
		
		
		//to be sure
		refTypeMEs.remove(me);
		if (refTypeMEs.size() == 0) {
			return;
		}
		int size = refTypeMEs.size();
		ModelElement toBeReferencedME = refTypeMEs.get(size == 1 ? 0 : getRandom().nextInt(size - 1));
		
		Object object = me.eGet(ref);
		if(ref.isMany()){
			EList<EObject> eList = (EList<EObject>) object;
			if(eList == null){
				List<Object> list = new ArrayList<Object>();
				list.add(toBeReferencedME);
				me.eSet(ref, list);
			}else{
				eList.add(toBeReferencedME);
			}
		}else{
			me.eSet(ref, toBeReferencedME);
		}
		
	}

	public int getExpectedNumOfChanges() {
		
		return EXPECTED_NUM_OF_CHANGES;
	}

}
