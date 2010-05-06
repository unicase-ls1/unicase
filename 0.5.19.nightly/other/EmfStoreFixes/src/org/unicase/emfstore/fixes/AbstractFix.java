package org.unicase.emfstore.fixes;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.unicase.emfstore.ServerConfiguration;
import org.unicase.emfstore.connection.rmi.SerializationUtil;
import org.unicase.emfstore.esmodel.ProjectHistory;
import org.unicase.emfstore.esmodel.ProjectId;
import org.unicase.emfstore.esmodel.versioning.ChangePackage;
import org.unicase.emfstore.esmodel.versioning.PrimaryVersionSpec;
import org.unicase.emfstore.esmodel.versioning.Version;
import org.unicase.emfstore.esmodel.versioning.operations.AbstractOperation;
import org.unicase.emfstore.exceptions.FatalEmfStoreException;
import org.unicase.emfstore.exceptions.RMISerializationException;
import org.unicase.model.ModelElementId;
import org.unicase.model.ModelFactory;
import org.unicase.model.Project;

public abstract class AbstractFix {

	protected ProjectHistory projectHistory;

	abstract String getFixName();

	public void runFix(ProjectHistory projectHistory) {
		this.projectHistory = projectHistory;
		try {
			fix();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	abstract void fix() throws Exception;

	protected void save(EObject object) {
		try {
			if (object != null) {
				object.eResource().save(null);
			}
			// BEGIN SUPRESS CATCH EXCEPTION
		} catch (Exception e) {
			e.printStackTrace();
			System.exit(0);
		}
		// END SUPRESS CATCH EXCEPTION
	}

	protected ModelElementId createMEID(String str) {
		ModelElementId modelElementId = ModelFactory.eINSTANCE.createModelElementId();
		modelElementId.setId(str);
		return modelElementId;
	}

	protected int version(Version version) {
		if (version != null) {
			return version.getPrimarySpec().getIdentifier();
		}
		return 0;
	}

	protected List<Version> getVersionsWithProjectState() {
		List<Version> result = new ArrayList<Version>();
		for (Version version : projectHistory.getVersions()) {
			if (version.getProjectState() != null) {
				result.add(version);
			}
		}
		return result;
	}

	public static int[] linearCompare(Project projectA, Project projectB) {
		int[] result = new int[5];
		int ARE_EQUAL = 0;
		int DIFFRENCE_POSITION = 1;
		int CHARACTER = 2;
		int LINE_NUM = 3;
		int COL_NUM = 4;
		result[ARE_EQUAL] = 1;
		String stringA = "";
		String stringB = "";

		try {
			stringA = SerializationUtil.eObjectToString(projectA);
			stringB = SerializationUtil.eObjectToString(projectB);
		} catch (RMISerializationException e) {
			e.printStackTrace();
		}

		int length = Math.min(stringA.length(), stringB.length());
		for (int index = 0; index < length; index++) {
			if (stringA.charAt(index) != stringB.charAt(index)) {
				result[ARE_EQUAL] = 0;
				result[DIFFRENCE_POSITION] = index;
				result[CHARACTER] = stringA.charAt(index);
				int lineNum = getLineNum(stringA, index);
				result[LINE_NUM] = lineNum;
				result[COL_NUM] = getColNum(stringA, index);
				break;
			}
		}
		return result;
	}

	private static int getColNum(String stringA, int index) {
		int lineNum = 1;
		int pos = index;
		int j = 0;
		for (int i = 0; i < index; i++) {
			j++;
			if (stringA.charAt(i) == '\n') {
				lineNum++;
				pos -= j;
				j = 0;
			}
		}
		return pos;
	}

	private static int getLineNum(String stringA, int index) {
		int lineNum = 1;
		for (int i = 0; i < index; i++) {
			if (stringA.charAt(i) == '\n') {
				lineNum++;
			}
		}
		return lineNum;
	}

	protected boolean between(Version version, int after, int before) {
		return (version.getPrimarySpec().getIdentifier() >= after && version.getPrimarySpec().getIdentifier() <= before);
	}

	protected boolean containedInChangePackage(ChangePackage changePackage, String serializedOperation) {
		for (AbstractOperation ao : changePackage.getOperations()) {
			if (serializeOperation(ao).equals(serializedOperation)) {
				return true;
			}
		}
		return false;
	}

	protected String serializeOperation(AbstractOperation ao) {
		String result = "";
		try {
			result = SerializationUtil.eObjectToString(ao);
		} catch (RMISerializationException e) {
			e.printStackTrace();
		}
		return result;
	}

	public String getProjectFolder(ProjectId projectId) {
		return ServerConfiguration.getServerHome() + ServerConfiguration.FILE_PREFIX_PROJECTFOLDER + projectId.getId()
			+ File.separatorChar;
	}

	public void createResourceForProject(Project project, PrimaryVersionSpec versionId, ProjectId projectId)
		throws FatalEmfStoreException {
		String filename = getProjectFolder(projectId) + getProjectFile(versionId.getIdentifier());
		saveInResource(project, filename);
	}

	public void createResourceForChangePackage(ChangePackage changePackage, PrimaryVersionSpec versionId,
		ProjectId projectId) throws FatalEmfStoreException {
		String filename = getProjectFolder(projectId) + getChangePackageFile(versionId.getIdentifier());
		saveInResource(changePackage, filename);
	}

	public String getProjectFile(int versionNumber) {
		return ServerConfiguration.FILE_PREFIX_PROJECTSTATE + versionNumber
			+ ServerConfiguration.FILE_EXTENSION_PROJECTSTATE;
	}

	public String getChangePackageFile(int versionNumber) {
		return ServerConfiguration.FILE_PREFIX_CHANGEPACKAGE + versionNumber
			+ ServerConfiguration.FILE_EXTENSION_CHANGEPACKAGE;
	}

	public void saveInResource(EObject obj, String fileName) throws FatalEmfStoreException {
		Resource resource = projectHistory.eResource().getResourceSet().createResource(URI.createFileURI(fileName));
		resource.getContents().add(obj);
		save(obj);
	}
}