package otherworkspacelocation;

import java.io.File;

import org.eclipse.emf.emfstore.client.model.util.DefaultWorkspaceLocationProvider;
import org.eclipse.emf.emfstore.server.LocationProvider;

public class OtherLocationProvider extends DefaultWorkspaceLocationProvider implements LocationProvider {

	private String path;

	public OtherLocationProvider() {
		path = getUserHome() + ".unicase" + File.separator + "other";
	}

	@Override
	public String getWorkspaceDirectory() {
		return path;
	}

	@Override
	public String getBackupDirectory() {
		return path + File.separator + "backup";
	}

}
