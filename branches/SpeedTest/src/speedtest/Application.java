package speedtest;

import java.rmi.registry.Registry;
import java.util.Date;

import org.eclipse.equinox.app.IApplication;
import org.eclipse.equinox.app.IApplicationContext;
import org.unicase.emfstore.accesscontrol.AccessControlException;
import org.unicase.emfstore.esmodel.SessionId;
import org.unicase.emfstore.esmodel.changemanagment.ChangemanagmentFactory;
import org.unicase.emfstore.esmodel.changemanagment.LogMessage;
import org.unicase.emfstore.exceptions.ConnectionException;
import org.unicase.workspace.ServerInfo;
import org.unicase.workspace.WorkspaceFactory;
import org.unicase.workspace.WorkspaceManager;
import org.unicase.workspace.connectionmanager.ConnectionManager;

/**
 * This class controls all aspects of the application's execution
 */
public class Application implements IApplication {

	private ConnectionManager cm;
	
	private ServerInfo si;
	
	private long stopWatch;
	
	/* (non-Javadoc)
	 * @see org.eclipse.equinox.app.IApplication#start(org.eclipse.equinox.app.IApplicationContext)
	 */
	public Object start(IApplicationContext context) throws Exception {
		System.out.println("**** server perfomance test ****");
		init();
		
		//LOGIN
		StopWatch sw = new StopWatch("login",true);
		SessionId id = cm.logIn("", "", si);
		sw.stop();
		
		//GETPROJECTLIST
		StopWatch sw2 = new StopWatch("getProjectList x10",true);
		for(int j= 0; j < 10; j++) {
			for(int i= 0; i < 10; i++) {
				cm.getProjectList(id);
			}
			sw2.stopNgo();
		}
		
		//CREATEPROJECT
		
		LogMessage log = ChangemanagmentFactory.eINSTANCE.createLogMessage();
		log.setMessage("Test");
		log.setAuthor("blub");
		log.setDate(new Date());
		
		StopWatch sw3 = new StopWatch("createProject",true);
		for(int i = 0; i < 10; i++) {
			cm.createProject(id, "name", "description", log);
			sw3.stopNgo();
		}
		
		
		return null;
	}

	private void init() {
		cm = WorkspaceManager.getInstance().getConnectionManager();
		si = WorkspaceFactory.eINSTANCE.createServerInfo();
		si.setDisplayName("");
		si.setUrl("localhost");
		si.setPort(Registry.REGISTRY_PORT);
	}
	

	
	/* (non-Javadoc)
	 * @see org.eclipse.equinox.app.IApplication#stop()
	 */
	public void stop() {
		// nothing to do
	}
	
	private class StopWatch {
		
		private long timer;
		
		private String name;
		
		public StopWatch(String name, boolean start) {
			setName(name);
			if(start) start();
		}
		
		public void stopNgo() {
			stop();
			start();
		}

		public void start() {
			timer = System.nanoTime();
		}
		
		public void stop() {
			if(timer == 0) System.out.println("start first.");
			System.out.println("'"+name+"' took "+getTime()+" s");
			timer = 0;
		}
		
		private double getTime() {
			return Math.pow(10, -9)*((double)(System.nanoTime() - timer));
		}
		
		public void setName(String name) {
			this.name = name;
		}
	}

}
