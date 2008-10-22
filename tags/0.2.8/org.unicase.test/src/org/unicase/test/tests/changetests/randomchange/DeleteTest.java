package org.unicase.test.tests.changetests.randomchange;


public class DeleteTest extends RandomChangeTestCase {

	public DeleteTest(String testName, long randomSeed) {
		super(testName, randomSeed);

	}

	@Override
	public void runTest() {
		
//		System.out.println("getting list of all model elements in project...");
//		List<ModelElement> modelElements = getTestProject()
//				.getAllModelElements();
//		System.out.println(modelElements.size() + " MEs in project...");
//
//		int numOfChanges = getRandom().nextInt(modelElements.size() / 8);
//		TransactionalEditingDomain domain = TransactionalEditingDomain.Registry.INSTANCE
//				.getEditingDomain("org.unicase.EditingDomain");
//
//		System.out.println("starting deletion; " + numOfChanges + " MEs" );
//		for (int i = 0; i < numOfChanges; i++) {
//			final ModelElement me = modelElements.get(getRandom().nextInt(
//					modelElements.size() - 1));
//			
//			domain.getCommandStack().execute(new RecordingCommand(domain) {
//
//				@Override
//				protected void doExecute() {
//					//System.out.println("getting resource...");
//					//Resource resource = me.eResource();
//					System.out.println("deleting ME...");
//					EcoreUtil.delete(me);
//					//EcoreUtil.delete(me, true);
//					//System.out.println("rmoveing from resource contents...");
//					//resource.getContents().remove(me);
//					//MK: remove save here if save problems are all solved
////					try {
////						System.out.println("saving resource");
////						resource.save(Configuration.getResourceSaveOptions());
////					} catch (IOException e) {
////						// MK: insert proper exception handling
////						e.printStackTrace();
////					}
//				}
//
//			});
//		}
//
//		System.out.println(this.toString() + "; " + numOfChanges
//				+ " deletions");

	}

}
