package org.unicase.test.servertests;

import org.unicase.emfstore.esmodel.ClientVersionInfo;
import org.unicase.emfstore.esmodel.EsmodelFactory;
import org.unicase.workspace.ServerInfo;
import org.unicase.workspace.WorkspaceFactory;

public class ServerTestUtil {

	public static ClientVersionInfo createClientVersionInfo() {
		ClientVersionInfo clientVersionInfo = EsmodelFactory.eINSTANCE.createClientVersionInfo();
		clientVersionInfo.setName("unicase.org eclipse client");
		clientVersionInfo.setVersion("0.3.18.qualifier");
		return clientVersionInfo;
	}

	public static ServerInfo createServerInfo() {
		ServerInfo serverInfo = WorkspaceFactory.eINSTANCE.createServerInfo();
		serverInfo.setPort(1099);
		serverInfo.setUrl("localhost");
		return serverInfo;
	}

}
