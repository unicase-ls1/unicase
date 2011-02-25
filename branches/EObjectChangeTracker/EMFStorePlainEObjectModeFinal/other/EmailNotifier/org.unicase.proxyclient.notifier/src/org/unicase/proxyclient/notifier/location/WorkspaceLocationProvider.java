package org.unicase.proxyclient.notifier.location;

import org.unicase.workspace.Configuration;

/**
 * @author Adrian Staudt <staudta@in.tum.de>
 */
public class WorkspaceLocationProvider implements org.unicase.workspace.util.WorkspaceLocationProvider {

	public String getWorkspaceDirectory() {
		String userHomeLocation = Configuration.getUserHome();
		String npcHomeLocation = userHomeLocation +".unicase.notifier.dev";
		
		return npcHomeLocation;
	}

}
