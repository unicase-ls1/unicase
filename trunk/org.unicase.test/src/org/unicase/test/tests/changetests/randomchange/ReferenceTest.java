package org.unicase.test.tests.changetests.randomchange;

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

/**
 * takes a random model element and changes one of its non-containment
 * references
 * 
 * @author Hodaie
 * 
 */
public class ReferenceTest extends RandomChangeTestCase {

	public ReferenceTest(String testName, long randomSeed) {
		super(testName, randomSeed);

	}

	@Override
	public void runTest() {

		System.out.println("getting list of all model elements in project...");
		List<ModelElement> modelElements = getTestProject()
				.getAllModelElements();
		System.out.println(modelElements.size() + " MEs in project...");

		int numOfChanges = getRandom().nextInt(modelElements.size() / 8);
		// int numOfChanges = 1;
		TransactionalEditingDomain domain = TransactionalEditingDomain.Registry.INSTANCE
				.getEditingDomain("org.unicase.EditingDomain");

		for (int i = 0; i < numOfChanges; i++) {
			final ModelElement me = modelElements.get(getRandom().nextInt(
					modelElements.size() - 1));
			final List<EReference> nonContainmentRefs = new ArrayList<EReference>();
			for (EReference ref : me.eClass().getEAllReferences()) {
				if (!ref.isContainment()) {
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

	private void changeReference(ModelElement me,
			List<EReference> nonContainmentRefs) {

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
