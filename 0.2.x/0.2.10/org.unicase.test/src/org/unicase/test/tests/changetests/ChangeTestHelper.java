package org.unicase.test.tests.changetests;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Date;
import java.util.List;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.transaction.RecordingCommand;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.unicase.emfstore.esmodel.EsmodelFactory;
import org.unicase.emfstore.esmodel.ProjectId;
import org.unicase.emfstore.esmodel.versioning.ChangePackage;
import org.unicase.emfstore.esmodel.versioning.PrimaryVersionSpec;
import org.unicase.emfstore.esmodel.versioning.VersioningFactory;
import org.unicase.emfstore.esmodel.versioning.operations.AbstractOperation;
import org.unicase.model.Project;
import org.unicase.model.util.ModelUtil;
import org.unicase.model.util.SerializationException;
import org.unicase.workspace.Configuration;
import org.unicase.workspace.ProjectSpace;
import org.unicase.workspace.WorkspaceFactory;
import org.unicase.workspace.impl.ProjectSpaceImpl;

public class ChangeTestHelper {

	private static TransactionalEditingDomain domain;
	private static String TEMP_PATH = Configuration.getWorkspaceDirectory()
			+ "\\tmp\\";

	public static ProjectSpace createEmptyProjectSpace(String name) {

		ProjectSpace projectSpace = WorkspaceFactory.eINSTANCE
				.createProjectSpace();
		ProjectId projectId = EsmodelFactory.eINSTANCE.createProjectId();
		projectId.setId(name);
		projectSpace.setIdentifier(name);
		projectSpace.setProjectId(projectId);
		projectSpace.setProjectName(name);
		projectSpace.setProjectDescription("description");
		PrimaryVersionSpec versionSpec = VersioningFactory.eINSTANCE
				.createPrimaryVersionSpec();
		versionSpec.setIdentifier(0);
		projectSpace.setBaseVersion(versionSpec);
		projectSpace.setLastUpdated(new Date());
		projectSpace.setUsersession(null);
		// projectSpace.setProject(ModelFactory.eINSTANCE.createProject());
		projectSpace.setResourceCount(0);

		File file = new File(TEMP_PATH);
		if (!file.exists()) {

			new File(Configuration.getWorkspaceDirectory() + "\\tmp\\")
					.mkdir();
		}

		return projectSpace;

	}

	public static ChangePackage getChangePackage(
			final List<AbstractOperation> operations, final boolean cannonize) {

		final ChangePackage changePackage = VersioningFactory.eINSTANCE
				.createChangePackage();
		getDomain().getCommandStack().execute(
				new RecordingCommand(getDomain()) {

					@Override
					protected void doExecute() {
						changePackage.getOperations().addAll(operations);
						if (cannonize) {
							changePackage.cannonize();
						}
					}

				});
		return changePackage;
	}

	public static boolean compare(ProjectSpace testSpace,
			ProjectSpace compareSpace) {

		prepareCompare(testSpace, compareSpace);

		System.out.println("comparing...");
		return ModelUtil.areEqual(testSpace.getProject(), compareSpace
				.getProject());
	}

	/**
	 * Extracts changes form test project and applys them to compare project.
	 * 
	 * @param testSpace
	 * @param compareSpace
	 */
	private static void prepareCompare(final ProjectSpace testSpace,
			final ProjectSpace compareSpace) {
		System.out.println("extracting operations from test project...");
		List<AbstractOperation> operations = testSpace
				.getOperations();
		System.out.println(operations.size() + " operatoins");
		final ChangePackage changePackage = getChangePackage(operations, true);
		
		//save change package for later reference
		//the saved change package will be overwritten every time a test succeeds.
		EObject copyChangePackage = EcoreUtil.copy(changePackage);
		ResourceSet reseourceSet = new ResourceSetImpl();
		Resource resource = reseourceSet.createResource(URI.createFileURI(TEMP_PATH + "changePackage.txt"));
		resource.getContents().add(copyChangePackage);
		try {
			resource.save(null);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		//apply changes to compare project
		getDomain().getCommandStack().execute(new RecordingCommand(getDomain()) {
			@Override
			protected void doExecute() {
				System.out.println("applying changes to compareSpace...");
				((ProjectSpaceImpl)compareSpace).stopChangeRecording();
				changePackage.apply(compareSpace.getProject());
				//compareSpace.save();
			}
		});
	}

	public static int[] linearCompare(ProjectSpace testSpace,
			ProjectSpace compareSpace) {

		prepareCompare(testSpace, compareSpace);
		System.out.println("linear comparing...");
		return linearCompare(testSpace.getProject(), compareSpace.getProject());

	}

	public static TransactionalEditingDomain getDomain() {

		if (domain == null) {
			domain = TransactionalEditingDomain.Registry.INSTANCE
					.getEditingDomain("org.unicase.EditingDomain");

		}
		return domain;
	}

	public static String eObjectToString(EObject object, String name)
			throws SerializationException {
		if (object == null) {
			return null;
		}
		Resource res = (new ResourceSetImpl()).createResource(URI
				.createURI("virtualUnicaseUri"));
		ByteArrayOutputStream out = new ByteArrayOutputStream();
		res.getContents().add(EcoreUtil.copy(object));
		try {
			res.save(out, null);
		} catch (IOException e) {
			throw new SerializationException(e);
		}
		File file = new File(TEMP_PATH  + name + ".txt");
		try {
			if (!file.exists()) {

				new File(Configuration.getWorkspaceDirectory() + "\\tmp\\")
						.mkdir();
			}

			FileOutputStream fos;
			fos = new FileOutputStream(file);
			fos.write(out.toByteArray());
			fos.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return out.toString();
	}

	public static int[] linearCompare(Project projectA, Project projectB) {
		int[] result = new int[5];
		int ARE_EQUAL = 0;
		int DIFFRENCE_POSITION = 1;
		int CHARACTER = 2;
		int LINE_NUM = 3;
		int COL_NUM = 4;
		result[ARE_EQUAL] = 1;
		String stringA;
		String stringB;

		try {

			stringA = eObjectToString(projectA, "testProj");
			stringB = eObjectToString(projectB, "compareProj");

		} catch (SerializationException e) {
			for (int i = 0; i < 5; i++) {
				result[i] = -1;
			}
			return result;
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

}
