package org.unicase.test.tests.changetests;

import java.io.IOException;
import java.util.List;

import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.transaction.RecordingCommand;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.unicase.model.ModelElement;
import org.unicase.test.lib.TestCase;
import org.unicase.workspace.Configuration;

public class DeleteTest extends TestCase {

	public DeleteTest(String testName, long randomSeed) {
		super(testName, randomSeed);

	}

	public void runTest() {
		List<ModelElement> modelElements = getTestProject()
				.getAllModelElements();

		int numOfChanges = getRandom().nextInt(modelElements.size() / 4);
		TransactionalEditingDomain domain = TransactionalEditingDomain.Registry.INSTANCE
				.getEditingDomain("org.unicase.EditingDomain");

		for (int i = 0; i < numOfChanges; i++) {
			final ModelElement me = modelElements.get(getRandom().nextInt(
					modelElements.size() - 1));
			
			domain.getCommandStack().execute(new RecordingCommand(domain) {

				@Override
				protected void doExecute() {
					Resource resource = me.eResource();
					EcoreUtil.delete(me, true);
					resource.getContents().remove(me);
					//MK: remove save here if save problems are all solved
					try {
						resource.save(Configuration.getResourceSaveOptions());
					} catch (IOException e) {
						// MK: insert proper exception handling
						e.printStackTrace();
					}
				}

			});
		}

		System.out.println(this.toString() + "; " + numOfChanges
				+ " operations");

	}

}
