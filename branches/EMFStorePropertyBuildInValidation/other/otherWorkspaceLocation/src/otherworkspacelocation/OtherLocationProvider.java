package otherworkspacelocation;

import java.io.File;

import org.unicase.emfstore.LocationProvider;
import org.unicase.workspace.util.DefaultWorkspaceLocationProvider;

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
