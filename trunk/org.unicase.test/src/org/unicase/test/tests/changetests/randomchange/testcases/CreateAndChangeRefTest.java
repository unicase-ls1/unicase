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
import org.unicase.test.tests.changetests.randomchange.RandomChangeTestCase;

/**
 * 
 * This is a change package test. 
 * It creates randomly a ME A, changes one of its non-containment references.
 * The expected change package should contain two operations
 *   - a create operation: created A
 *   - a change operation: either A.ref changed to B or B.oppositeRef changed to A
 * 
 * @author Hodaie
 *
 */
public class CreateAndChangeRefTest extends RandomChangeTestCase {

	public CreateAndChangeRefTest(String testName, long randomSeed) {
		super(testName, randomSeed);
	
	}

	@Override
	public void runTest() {
		final ModelElement me = ChangeTestHelper.createRandomME();
		me.setName("newly created " + me.eClass().getName());
		
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
			if (!ref.isContainment()) {
				nonContainmentRefs.add(ref);
			}
		}
		
		EReference ref = nonContainmentRefs.get(getRandom().nextInt(
				nonContainmentRefs.size() - 1));
		EClass refType = ref.getEReferenceType();
		List<ModelElement> refTypeMEs = getTestProject()
				.getAllModelElementsbyClass(refType,
						new BasicEList<ModelElement>());
		
		ModelElement toBeReferencedME = refTypeMEs.get(getRandom().nextInt(refTypeMEs.size() - 1));
		
		Object object = me.eGet(ref);
		EList<EObject> eList = (EList<EObject>) object;
		eList.add(toBeReferencedME);

	}

	
}
