package org.unicase.link.commands;

import org.unicase.emfstore.esmodel.ProjectInfo;
import org.unicase.emfstore.exceptions.EmfStoreException;
import org.unicase.workspace.ProjectSpace;
import org.unicase.workspace.Usersession;
import org.unicase.workspace.WorkspaceManager;
import org.unicase.workspace.ui.commands.ServerRequestCommandHandler;
import org.unicase.workspace.util.WorkspaceUtil;

public class CheckoutProjectHandler extends ServerRequestCommandHandler {

	private Usersession usersession;
	private ProjectInfo projectInfo;
	
	/**
	 * Default constructor.
	 */
	public CheckoutProjectHandler(Usersession userSession, 
			ProjectInfo projectInfo) {
		super();
		setTaskTitle("Checking out project...");
		this.projectInfo = projectInfo;
		usersession = userSession;
	}
	
	@Override
	protected Object run() throws EmfStoreException {
		ProjectSpace pSpace = usersession.checkout(projectInfo);
		WorkspaceUtil.logCheckout(pSpace, pSpace.getBaseVersion());
		// TODO: always returns null till now..
		return pSpace;
	}

}
