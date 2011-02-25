package org.unicase.emfstore.fixes;

import java.io.IOException;

import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.unicase.emfstore.esmodel.versioning.ChangePackage;
import org.unicase.emfstore.esmodel.versioning.Version;
import org.unicase.emfstore.esmodel.versioning.VersioningFactory;
import org.unicase.model.Project;

public class NullifyProjectTailFix extends CheckChanges {

	private Project state;

	private String last = null;

	@Override
	public void fix() {
		Version version = projectHistory.getVersions().get(1300);
		state = version.getProjectState();
		if (state != null) {
			state = (Project) EcoreUtil.copy(state);
		} else {
			System.out.println("no state");
			System.exit(0);
		}
		super.fix();
	}

	@Override
	public void callHook(Version version, Project state) {
		if (version(version) < 1300) {
			// if (version.getProjectState() != null) {
			// Resource resource = version.getProjectState().eResource();
			// resource.getContents().clear();
			// Project copy = (Project) EcoreUtil.copy(this.state);
			// resource.getContents().add(copy);
			// try {
			// resource.save(null);
			// } catch (IOException e) {
			// e.printStackTrace();
			// }
			// version.setProjectState(copy);
			// save(version);
			// System.out.println("changed ps in " + version(version));
			// }
			if (version.getChanges() != null) {
				Resource resource = version.getChanges().eResource();
				resource.getContents().clear();
				ChangePackage changePackage = VersioningFactory.eINSTANCE.createChangePackage();
				resource.getContents().add(changePackage);
				try {
					resource.save(null);
				} catch (IOException e) {
					e.printStackTrace();
				}
				version.setChanges(changePackage);
				save(version);
				System.out.println("changed cp in " + version(version));
			}
		}
	}

	@Override
	public boolean output() {
		return false;
	}

	@Override
	String getFixName() {
		return "Nullify project tail";
	}

}
