package testrunner;

import org.eclipse.equinox.app.IApplication;
import org.eclipse.equinox.app.IApplicationContext;
import org.unicase.metamodel.Project;
import org.unicase.workspace.ProjectSpace;
import org.unicase.workspace.Workspace;
import org.unicase.workspace.WorkspaceManager;
import org.unicase.workspace.util.UnicaseCommand;

import testModel.TestModelFactory;
import testModel.TestModelPackage;
import testModel.TestProject;

/**
 * This class controls all aspects of the application's execution
 */
public class Application implements IApplication {

	/*
	 * (non-Javadoc)
	 * 
	 * @seeorg.eclipse.equinox.app.IApplication#start(org.eclipse.equinox.app.
	 * IApplicationContext)
	 */
	public Object start(IApplicationContext context) throws Exception {
		System.out.println("Hello RCP World!");

		final Workspace workspace = WorkspaceManager.getInstance()
				.getCurrentWorkspace();

		new UnicaseCommand() {
			
			@Override
			protected void doRun() {
				
				ProjectSpace space = workspace.createLocalProject("testProject", "TestProject");
				
				Project project = space.getProject();
				
				TestProject test = TestModelFactory.eINSTANCE.createTestProject();
				project.getModelElements().add(test);
				
				String a = "dupp";
				
				test.getValues().add(a);
//				test.getValues().add("jupp");
//				test.getValues().add("jupp");
//				test.getValues().add("jupp");
//				test.getValues().remove(a);
				
				test.getValues().set(0, "JUPP");
				
				System.out.println(test.getValues());
			}
		}.run();

		return IApplication.EXIT_OK;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.eclipse.equinox.app.IApplication#stop()
	 */
	public void stop() {
		// nothing to do
	}
}
