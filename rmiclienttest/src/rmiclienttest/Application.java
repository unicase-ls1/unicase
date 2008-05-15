package rmiclienttest;

import org.eclipse.equinox.app.IApplication;
import org.eclipse.equinox.app.IApplicationContext;
import org.unicase.esmodel.EsmodelFactory;
import org.unicase.esmodel.ProjectInfo;
import org.unicase.esmodel.changemanagment.ChangemanagmentFactory;
import org.unicase.model.CompositeSection;
import org.unicase.model.ModelElement;
import org.unicase.model.ModelFactory;
import org.unicase.model.Project;
import org.unicase.workspace.ProjectSpace;
import org.unicase.workspace.Workspace;
import org.unicase.workspace.WorkspaceFactory;
import org.unicase.workspace.WorkspaceManager;
import org.unicase.workspace.connectionmanager.ConnectionException;
import org.unicase.workspace.connectionmanager.RMIConnectionManagerImpl;

/**
 * This class controls all aspects of the application's execution
 */
public class Application implements IApplication {

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.eclipse.equinox.app.IApplication#start(org.eclipse.equinox.app.IApplicationContext)
	 */
	public Object start(IApplicationContext context) throws Exception {



		RMIConnectionManagerImpl cm = new RMIConnectionManagerImpl();
//		cm.logIn("da", "bla", WorkspaceFactory.eINSTANCE.createServerInfo());
//		cm.sendString("test");
//		Project pr = cm.getProject(EsmodelFactory.eINSTANCE.createSessionId(),
//				EsmodelFactory.eINSTANCE.createProjectId(),
//				ChangemanagmentFactory.eINSTANCE.createPrimaryVersionSpec());
//		System.out.println(pr.toString());
//		for(ModelElement me:pr.getModelElements()) {
//			System.out.println(me.toString());
//		}
		
		
		for(ProjectInfo pi : cm.getProjectList(EsmodelFactory.eINSTANCE.createSessionId())) {
			System.out.println(pi);
		}
		
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
