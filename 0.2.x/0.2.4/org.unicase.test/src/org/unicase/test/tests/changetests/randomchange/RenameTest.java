package org.unicase.test.tests.changetests.randomchange;

import java.util.List;

import org.unicase.model.ModelElement;

public class RenameTest extends RandomChangeTestCase {

	
	public RenameTest(String testName, long randomSeed) {
		super(testName, randomSeed);
		
	}

	@Override
	public void runTest() {
		List<ModelElement> modelElements = getTestProject()
				.getAllModelElements();
		System.out.println(modelElements.size() + " MEs");
		int numOfChanges = getRandom().nextInt(modelElements.size() / 8);
//		TransactionalEditingDomain domain = TransactionalEditingDomain.Registry.INSTANCE
//				.getEditingDomain("org.unicase.EditingDomain");
//		System.out.println(numOfChanges + " renames");
//		for (int i = 0; i < numOfChanges; i++) {
//			final ModelElement me = modelElements.get(getRandom().nextInt(modelElements
//					.size() - 1));
//			final String oldName = me.getName();
//			domain.getCommandStack().execute(new RecordingCommand(domain){
//
//				@Override
//				protected void doExecute() {
//					me.setName("Changed-" + oldName);				
//				}
//				
//			});
//		}
		
		System.out.println(RenameTest.class.getSimpleName() + "; " + numOfChanges + " renames");
	}

}
