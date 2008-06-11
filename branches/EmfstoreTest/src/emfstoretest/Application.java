package emfstoretest;

import java.rmi.registry.Registry;
import java.rmi.registry.RegistryHandler;
import java.util.Collections;
import java.util.Date;

import org.eclipse.emf.ecore.change.ChangeDescription;
import org.eclipse.emf.ecore.change.util.ChangeRecorder;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.equinox.app.IApplication;
import org.eclipse.equinox.app.IApplicationContext;
import org.unicase.emfstore.esmodel.EsmodelFactory;
import org.unicase.emfstore.esmodel.ProjectId;
import org.unicase.emfstore.esmodel.ProjectInfo;
import org.unicase.emfstore.esmodel.SessionId;
import org.unicase.emfstore.esmodel.changemanagment.ChangePackage;
import org.unicase.emfstore.esmodel.changemanagment.ChangemanagmentFactory;
import org.unicase.emfstore.esmodel.changemanagment.HistoryInfo;
import org.unicase.emfstore.esmodel.changemanagment.LogMessage;
import org.unicase.emfstore.esmodel.changemanagment.PrimaryVersionSpec;
import org.unicase.emfstore.exceptions.BaseVersionOutdatedException;
import org.unicase.model.ModelFactory;
import org.unicase.model.Project;
import org.unicase.model.component.Component;
import org.unicase.model.component.ComponentFactory;
import org.unicase.workspace.ServerInfo;
import org.unicase.workspace.Workspace;
import org.unicase.workspace.WorkspaceFactory;
import org.unicase.workspace.WorkspaceManager;
import org.unicase.workspace.connectionmanager.ConnectionManager;

/**
 * This class controls all aspects of the application's execution
 */
public class Application implements IApplication {

	private ChangeRecorder changeRecorder;

	/* (non-Javadoc)
	 * @see org.eclipse.equinox.app.IApplication#start(org.eclipse.equinox.app.IApplicationContext)
	 */
	public Object start(IApplicationContext context) throws Exception {
		System.out.println("Hello RCP World!");
		ConnectionManager cm = WorkspaceManager.getInstance().getConnectionManager();
		ServerInfo si = WorkspaceFactory.eINSTANCE.createServerInfo();
		si.setDisplayName("");
		si.setUrl("localhost");
		si.setPort(Registry.REGISTRY_PORT);
		
		SessionId id = cm.logIn("", "", si);
		System.out.println(id);
		
		for(ProjectInfo info: cm.getProjectList(id)) {
			System.out.println(info);
//			System.out.println(cm.resolveVersionSpec(id, info.getProjectId(), ChangemanagmentFactory.eINSTANCE.createHeadVersionSpec()));
//			System.out.println("::");
//			System.out.println(cm.getProject(id, info.getProjectId(), ChangemanagmentFactory.eINSTANCE.createHeadVersionSpec()));
//			PrimaryVersionSpec pri = ChangemanagmentFactory.eINSTANCE.createPrimaryVersionSpec();
//			pri.setIdentifier(0);
//			System.out.println("HistoryInfo");
//			for(HistoryInfo hi : cm.getHistoryInfo(id, info.getProjectId(), pri, ChangemanagmentFactory.eINSTANCE.createHeadVersionSpec())) {
//				System.out.println(hi);
//			}
//			for(ChangePackage cp : cm.getChanges(id, info.getProjectId(), pri, ChangemanagmentFactory.eINSTANCE.createHeadVersionSpec())) {
//				System.out.println(cp);
//			}
		}
		
		
		LogMessage log = ChangemanagmentFactory.eINSTANCE.createLogMessage();
		log.setMessage("Test");
		log.setAuthor("blub");
		log.setDate(new Date());
		
		ProjectInfo pinfo = cm.createProject(id, "name", "description", log);
		System.out.println("ProjectInfo: "+pinfo);
		
		Project project = cm.getProject(id, pinfo.getProjectId(), ChangemanagmentFactory.eINSTANCE.createHeadVersionSpec());
		System.out.println("Project: "+project);
		
		this.changeRecorder=new ChangeRecorder();
		changeRecorder.beginRecording(Collections.singleton(project));
	
		Component com = ComponentFactory.eINSTANCE.createComponent();
		com.setDescription("a component");
		com.setName("component");
		
		project.addModelElement(com);
		
		ChangePackage cpp = save();
		System.out.println("ChangePacke: "+cpp);
		
		PrimaryVersionSpec pri2 = cm.resolveVersionSpec(id, pinfo.getProjectId(), ChangemanagmentFactory.eINSTANCE.createHeadVersionSpec());
		
		PrimaryVersionSpec resolvedVersion = cm.resolveVersionSpec(id, pinfo.getProjectId(),ChangemanagmentFactory.eINSTANCE.createHeadVersionSpec());
		PrimaryVersionSpec pri = cm.createVersion(id, pinfo.getProjectId(), pri2, cpp, log);
		System.out.println("Primary: "+pri);
		
		return IApplication.EXIT_OK;
	}
	
	public ChangePackage save() {
		//FIXME MK this does not work forward change description is empty
		ChangeDescription changeDescription = this.changeRecorder.endRecording();
		if (changeDescription==null) {
			return null;
		}
		ChangeDescription backwardChangeDescription= (ChangeDescription)EcoreUtil.copy(changeDescription);
		changeDescription.applyAndReverse();
		ChangeDescription forwardChangeDescription=(ChangeDescription)EcoreUtil.copy(changeDescription);
		changeDescription.apply();
		ChangePackage changePackage = ChangemanagmentFactory.eINSTANCE.createChangePackage();
		changePackage.setBackwardDelta(backwardChangeDescription);
		changePackage.setFowardDelta(forwardChangeDescription);
		return changePackage;
	}

	/* (non-Javadoc)
	 * @see org.eclipse.equinox.app.IApplication#stop()
	 */
	public void stop() {
		// nothing to do
	}
}
