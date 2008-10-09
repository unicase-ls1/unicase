package org.unicase.test.tests.changetests.randomChange;

import java.util.List;

import org.eclipse.emf.transaction.RecordingCommand;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.unicase.model.ModelElement;
import org.unicase.test.lib.TestCase;

public class RenameTest extends TestCase {

	public RenameTest(String testName, long randomSeed) {
		super(testName, randomSeed);
		
	}

	@Override
	public void runTest() {
		List<ModelElement> modelElements = getTestProject()
				.getAllModelElements();
		
		int numOfChanges = getRandom().nextInt(modelElements.size() / 4);
		TransactionalEditingDomain domain = TransactionalEditingDomain.Registry.INSTANCE
				.getEditingDomain("org.unicase.EditingDomain");
		
		for (int i = 0; i < numOfChanges; i++) {
			final ModelElement me = modelElements.get(getRandom().nextInt(modelElements
					.size() - 1));
			final String oldName = me.getName();
			domain.getCommandStack().execute(new RecordingCommand(domain){

				@Override
				protected void doExecute() {
					me.setName("Changed-" + oldName);				
				}
				
			});
		}
		
		System.out.println(RenameTest.class.getSimpleName() + "; " + numOfChanges + " renames");
	}

}
