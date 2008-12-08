package org.unicase.test.tests.change;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Random;

import org.eclipse.emf.common.util.BasicEList;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EEnum;
import org.eclipse.emf.ecore.EEnumLiteral;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;
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
import org.unicase.model.ModelElement;
import org.unicase.model.ModelPackage;
import org.unicase.model.Project;
import org.unicase.model.util.ModelUtil;
import org.unicase.model.util.SerializationException;
import org.unicase.workspace.Configuration;
import org.unicase.workspace.ProjectSpace;
import org.unicase.workspace.WorkspaceFactory;
import org.unicase.workspace.impl.ProjectSpaceImpl;

public final class ChangeTestHelper {

	private static TransactionalEditingDomain domain;
	private static String TEMP_PATH = Configuration.getWorkspaceDirectory()
			+ "\\tmp\\";

	private static Random random;
	private static List<ModelElement> allMEsInProject;

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

			new File(Configuration.getWorkspaceDirectory() + "\\tmp\\").mkdir();
		}

		return projectSpace;

	}

	public static ChangePackage getChangePackage(
			final List<AbstractOperation> operations, final boolean cannonize,
			final boolean clearOperations) {

		final ChangePackage changePackage = VersioningFactory.eINSTANCE
				.createChangePackage();
		getDomain().getCommandStack().execute(
				new RecordingCommand(getDomain()) {

					@Override
					protected void doExecute() {
						for (AbstractOperation op : operations) {
							changePackage.getOperations().add(
									(AbstractOperation) EcoreUtil.copy(op));

						}
						if (clearOperations) {
							operations.clear();
						}

						if (cannonize) {
							changePackage.cannonize();
						}
					}

				});
		return changePackage;
	}

	public static boolean compare(ProjectSpace testSpace,
			ProjectSpace compareSpace) {

		prepareCompare(testSpace, compareSpace, false);

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
			final ProjectSpace compareSpace, final boolean accumulative) {
		System.out.println("extracting operations from test project...");

		List<AbstractOperation> operations = testSpace.getOperations();
		System.out.println(operations.size() + " operatoins");
		final ChangePackage changePackage = getChangePackage(operations, true,
				false);

		// Save change package for later reference to disk.
		// The saved change package will be overwritten every time a test
		// succeeds.
		EObject copyChangePackage = EcoreUtil.copy(changePackage);
		ResourceSet reseourceSet = new ResourceSetImpl();
		Resource resource = reseourceSet.createResource(URI
				.createFileURI(TEMP_PATH + "changePackage.txt"));
		resource.getContents().add(copyChangePackage);
		try {
			resource.save(null);
		} catch (IOException e) {

			e.printStackTrace();
		}

		// apply changes to compare project
		getDomain().getCommandStack().execute(
				new RecordingCommand(getDomain()) {
					@Override
					protected void doExecute() {
						System.out
								.println("applying changes to compareSpace...");
						((ProjectSpaceImpl) compareSpace).stopChangeRecording();
						changePackage.apply(compareSpace.getProject());
						if (!accumulative) {
							testSpace.getOperations().clear();
						}
					}
				});
	}

	public static int[] linearCompare(ProjectSpace testSpace,
			ProjectSpace compareSpace) {

		prepareCompare(testSpace, compareSpace, false);
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
		File file = new File(TEMP_PATH + name + ".txt");
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

	public static List<ModelElement> getRandomMEs(Project project, int num,
			boolean unique) {

		List<ModelElement> result = new ArrayList<ModelElement>();
		if (allMEsInProject == null) {
			System.out
					.println("getting list of all model elements in project...");
			allMEsInProject = project.getAllModelElements();
			System.out.println(allMEsInProject.size() + " MEs in project...");
		}

		int numOfMEs = allMEsInProject.size();
		if (num > numOfMEs) {
			throw new IllegalArgumentException(
					"Number of random MEs to return is greater than total number of MEs in project.");
		}

		if (unique) {
			do {
				final ModelElement me = allMEsInProject.get(getRandom()
						.nextInt(numOfMEs - 1));
				if (!result.contains(me)) {
					result.add(me);
				}

			} while (result.size() < num);

		} else {
			for (int i = 0; i < num; i++) {
				final ModelElement me = allMEsInProject.get(getRandom()
						.nextInt(numOfMEs - 1));
				result.add(me);
			}

		}
		return result;
	}

	public static ModelElement getRandomME(Project project) {
		List<ModelElement> modelElements = getRandomMEs(project, 1, false);
		return modelElements.get(0);
	}

	public static ModelElement createRandomME() {
		List<EClass> eClazz = ModelUtil.getSubclasses(ModelPackage.eINSTANCE
				.getModelElement());
		EClass eClass = eClazz.get(getRandom().nextInt(eClazz.size() - 1));
		ModelElement me = (ModelElement) eClass.getEPackage()
				.getEFactoryInstance().create(eClass);

		return me;
	}

	public static EObject createInstance(EClass refType) {

		EObject ret = null;

		if (refType.isAbstract() || refType.isInterface()) {
			List<EClass> eClazz = ModelUtil.getSubclasses(refType, refType.getEPackage());
			int index = eClazz.size() == 1 ? 0 : getRandom().nextInt(
					eClazz.size());
			refType = eClazz.get(index);
		}

		ret = refType.getEPackage().getEFactoryInstance().create(
				refType);
		

		return ret;

	}

	@SuppressWarnings("unchecked")
	public static void changeSimpleAttribute(ModelElement me,
			EAttribute attribute) {
	
		if (attribute.getEType().getInstanceClass().equals(String.class)) {
			if (attribute.isMany()) {
				Object object = me.eGet(attribute);
				EList<String> eList = (EList<String>) object;
				eList.add("new entry for" + attribute.getName());

			} else {
				String oldValue = (String) me.eGet(attribute);
				String newValue = "changed-" + oldValue;
				me.eSet(attribute, newValue);
			}

		} else if (attribute.getEType().getInstanceClass()
				.equals(boolean.class)) {
			if (attribute.isMany()) {
				Object object = me.eGet(attribute);
				EList<Boolean> eList = (EList<Boolean>) object;
				eList.add(getRandom().nextBoolean());
			} else {
				me.eSet(attribute, !((Boolean) me.eGet(attribute)));
			}

		} else if (attribute.getEType().getInstanceClass().equals(int.class)) {
			if (attribute.isMany()) {
				Object object = me.eGet(attribute);
				EList<Integer> eList = (EList<Integer>) object;
				eList.add(getRandom().nextInt());
			} else {
				me.eSet(attribute, getRandom().nextInt());
			}

		} else if (attribute.getEType().getInstanceClass().equals(Date.class)) {
			if (attribute.isMany()) {
				Object object = me.eGet(attribute);
				EList<Date> eList = (EList<Date>) object;
				eList.add(getRandomDate());
			} else {
				me.eSet(attribute, getRandomDate());
			}

		}
		if (attribute.getEType() instanceof EEnum) {
			EEnum en = (EEnum) attribute.getEType();
			int numOfLiterals = en.getELiterals().size();
			int index = numOfLiterals == 1 ? 0 : getRandom().nextInt(
					numOfLiterals - 1);
			EEnumLiteral value = en.getELiterals().get(index);
			me.eSet(attribute, value.getInstance());
		}

	}

	public static void setRandom(Random random) {
		ChangeTestHelper.random = random;
	}

	public static Random getRandom() {
		return random;
	}

	private static Date getRandomDate() {
		return new Date();
	}

	public static EAttribute getRandomAttribute(ModelElement me) {
		EAttribute attribute = null;
		List<EAttribute> attributes = new ArrayList<EAttribute>();
		for (EAttribute tmpAttr : me.eClass().getEAllAttributes()) {
			if (tmpAttr.isChangeable()
					&& tmpAttr.getFeatureID() != ModelPackage.MODEL_ELEMENT__IDENTIFIER
					&& !tmpAttr.isTransient()) {
				attributes.add(tmpAttr);
			}
		}

		
		int size = attributes.size();
		if(size != 0){
			 attribute = attributes.get(size == 1 ? 0 : getRandom()
				.nextInt(size - 1));

		}
		
		return attribute;

	}

	public static EReference getRandomNonContainmentRef(ModelElement me) {
		EReference nonContainmentRef = null;
		List<EReference> nonContainmentRefs = new ArrayList<EReference>();
		for (EReference ref : me.eClass().getEAllReferences()) {
			if (!ref.isContainment() && !ref.isContainer() && ref.isChangeable() && !ref.isTransient()) {
				nonContainmentRefs.add(ref);
			}
		}

		int size = nonContainmentRefs.size();
		if (size != 0) {
			nonContainmentRef = nonContainmentRefs.get(size == 1 ? 0 : getRandom()
					.nextInt(size - 1));
		}
		
		return nonContainmentRef;

	}

	public static EReference getRandomContainmentRef(ModelElement me) {
		EReference containmentRef = null;
		List<EReference> containments = new ArrayList<EReference>();
		for (EReference ref : me.eClass().getEAllContainments()) {
			if (ref.isChangeable() && !ref.isTransient()) {
				containments.add(ref);
			}
		}
		int size = containments.size();
		if (size != 0) {
			containmentRef = containments.get(size == 1 ? 0 : getRandom()
					.nextInt(size - 1));
		}

		return containmentRef;
	}

	@SuppressWarnings("unchecked")
	public static void changeSimpleRef(ModelElement me, EReference ref, Project project) {

		EClass refType = ref.getEReferenceType();
		List<ModelElement> refTypeMEs = project.getAllModelElementsbyClass(
				refType, new BasicEList<ModelElement>());

		if (refTypeMEs.contains(me)) {
			refTypeMEs.remove(me);
		}

		ModelElement toBeReferencedME = refTypeMEs.get(getRandom().nextInt(
				refTypeMEs.size() - 1));

		Object object = me.eGet(ref);
		if (ref.isMany()) {
			EList<EObject> eList = (EList<EObject>) object;
			if (eList == null) {
				throw new IllegalStateException("Null list return for feature "
						+ ref.getName() + " on " + me.getName());
			} else {
				eList.add(toBeReferencedME);
			}
		} else {
			me.eSet(ref, toBeReferencedME);
		}

	}

}
