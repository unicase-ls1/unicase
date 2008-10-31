package org.unicase.test.tests.changetests.randomchange;

import java.util.List;

import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.transaction.RecordingCommand;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.unicase.model.ModelElement;
import org.unicase.workspace.WorkspaceManager;


public class DeleteTest extends RandomChangeTestCase {

	public DeleteTest(String testName, long randomSeed) {
		super(testName, randomSeed);

	}

	@Override
	public void runTest() {
		
		System.out.println("getting list of all model elements in project...");
		List<ModelElement> modelElements = getTestProject()
				.getAllModelElements();
		System.out.println(modelElements.size() + " MEs in project...");

		int numOfChanges = getRandom().nextInt(modelElements.size() / 32);
		//int numOfChanges = 1;
		TransactionalEditingDomain domain = TransactionalEditingDomain.Registry.INSTANCE
				.getEditingDomain("org.unicase.EditingDomain");

		System.out.println("starting deletion; " + numOfChanges + " MEs" );
		for (int i = 0; i < numOfChanges; i++) {
			final ModelElement me = modelElements.get(getRandom().nextInt(
					modelElements.size() - 1));
			
			domain.getCommandStack().execute(new RecordingCommand(domain) {

				@Override
				protected void doExecute() {
					System.out.println("deleting ME...");
					EcoreUtil.delete(me, true);
					//WorkspaceManager.getProjectSpace(getTestProject()).save();
					WorkspaceManager.getInstance().getCurrentWorkspace().getActiveProjectSpace().save();
				}

			});
		}
//		domain.getCommandStack().execute(new RecordingCommand(domain) {
//
//			@Override
//			protected void doExecute() {
//				
//				WorkspaceManager.getProjectSpace(getTestProject()).save();
//			}
//
//		});
		
		System.out.println(getTestName() + "; " + numOfChanges
				+ " deletions");

	}

}









////==========================================================
//
//
//public void runTest() {
//	
//	System.out.println("getting list of all model elements in project...");
//	List<ModelElement> modelElements = getTestProject()
//			.getAllModelElements();
//	System.out.println(modelElements.size() + " MEs in project...");
//
//	//int numOfChanges = getRandom().nextInt(modelElements.size() / 32);
//	int numOfChanges = 1;
//	TransactionalEditingDomain domain = TransactionalEditingDomain.Registry.INSTANCE
//			.getEditingDomain("org.unicase.EditingDomain");
//
//	System.out.println("starting deletion; " + numOfChanges + " MEs" );
//	for (int i = 0; i < numOfChanges; i++) {
//		final ModelElement me = modelElements.get(getRandom().nextInt(
//				modelElements.size() - 1));
//		
//		domain.getCommandStack().execute(new RecordingCommand(domain) {
//
//			@Override
//			protected void doExecute() {
//				//System.out.println("getting resource...");
//				//Resource resource = me.eResource();
//				System.out.println("deleting ME...");
//				EcoreUtil.delete(me, true);
//				//EcoreUtil.delete(me, true);
//				//System.out.println("rmoveing from resource contents...");
//				//resource.getContents().remove(me);
//				//MK: remove save here if save problems are all solved
////				try {
////					System.out.println("saving resource");
////					resource.save(Configuration.getResourceSaveOptions());
////				} catch (IOException e) {
////					// MK: insert proper exception handling
////					e.printStackTrace();
////				}
//			}
//
//		});
//	}
//
//	System.out.println(getTestName() + "; " + numOfChanges
//			+ " deletions");
//
//}

