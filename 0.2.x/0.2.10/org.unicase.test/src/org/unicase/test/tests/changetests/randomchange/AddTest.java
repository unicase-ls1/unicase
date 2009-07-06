package org.unicase.test.tests.changetests.randomchange;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.emf.common.util.BasicEList;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.transaction.RecordingCommand;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.unicase.model.ModelElement;

public class AddTest extends RandomChangeTestCase {

	private int totalOps;

	public AddTest(String testName, long randomSeed) {
		super(testName, randomSeed);

	}

	@Override
	public void runTest() {

		System.out.println("getting list of all model elements in project...");
		final List<ModelElement> modelElements = getTestProject()
				.getAllModelElements();
		System.out.println(modelElements.size() + " MEs in project...");

		int numOfChanges = getRandom().nextInt(modelElements.size() / 10);

		TransactionalEditingDomain domain = TransactionalEditingDomain.Registry.INSTANCE
				.getEditingDomain("org.unicase.EditingDomain");

		 runSimpleTest(modelElements, numOfChanges, domain);
		// runFullRandomTest(modelElements, numOfChanges, domain);

	}

	private void runSimpleTest(final List<ModelElement> modelElements,
			int numOfChanges, TransactionalEditingDomain domain) {

		for (int i = 0; i < numOfChanges; i++) {

			domain.getCommandStack().execute(new RecordingCommand(domain) {

				@Override
				protected void doExecute() {
					ModelElement me = modelElements.get(getRandom().nextInt(
							modelElements.size() - 1));

					List<EReference> containments = me.eClass()
							.getEAllContainments();
					if (containments.size() == 0) {
						return;
					}
					EReference ref = containments.get(0);
					EClass refType = ref.getEReferenceType();

					ModelElement newInstance = createInstance(refType);

					if (newInstance == null) {
						return;
					}

					Object object = me.eGet(ref);
					EList<EObject> eList = (EList<EObject>) object;
					eList.add(newInstance);
					totalOps++;

				}

			});
		}

		System.out.println(getTestName() + "; " + totalOps + " adds");

	}

	private void runFullRandomTest(final List<ModelElement> modelElements,
			int numOfChanges, TransactionalEditingDomain domain) {

		for (int i = 0; i < numOfChanges; i++) {

			domain.getCommandStack().execute(new RecordingCommand(domain) {

				@Override
				protected void doExecute() {
					final ModelElement me = modelElements.get(getRandom()
							.nextInt(modelElements.size() - 1));

					List<EReference> containments = me.eClass()
							.getEAllContainments();
					if (containments.size() == 0) {
						return;
					}
					final EReference ref = containments
							.get(containments.size() == 1 ? 0 : getRandom()
									.nextInt(containments.size() - 1));
					EClass refType = ref.getEReferenceType();

					ModelElement newInstance = createInstance(refType);

					if (newInstance == null) {
						return;
					}

					Object object = me.eGet(ref);
					EList<EObject> eList = (EList<EObject>) object;
					eList.add(newInstance);
					totalOps++;

				}

			});
		}

		System.out.println(getTestName() + "; " + totalOps + " adds");

	}

	protected ModelElement createInstance(EClass refType) {

		ModelElement me;

		EPackage ePackage = refType.getEPackage();
		me = (ModelElement) ePackage.getEFactoryInstance().create(refType);

		return me;

	}

}
