package org.unicase.test.tests.change;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
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
	private static String TEMP_PATH = Configuration.getWorkspaceDirectory() + "\\tmp\\";

	private static Random random;
	private static List<ModelElement> allMEsInProject;

	public static ProjectSpace createEmptyProjectSpace(String name) {

		ProjectSpace projectSpace = WorkspaceFactory.eINSTANCE.createProjectSpace();
		ProjectId projectId = EsmodelFactory.eINSTANCE.createProjectId();
		projectId.setId(name);
		projectSpace.setIdentifier(name);
		projectSpace.setProjectId(projectId);
		projectSpace.setProjectName(name);
		projectSpace.setProjectDescription("description");
		PrimaryVersionSpec versionSpec = VersioningFactory.eINSTANCE.createPrimaryVersionSpec();
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

	public static ChangePackage getChangePackage(final List<AbstractOperation> operations, final boolean cannonize,
		final boolean clearOperations) {

		final ChangePackage changePackage = VersioningFactory.eINSTANCE.createChangePackage();
		getDomain().getCommandStack().execute(new RecordingCommand(getDomain()) {

			@Override
			protected void doExecute() {
				for (AbstractOperation op : operations) {
					changePackage.getOperations().add((AbstractOperation) EcoreUtil.copy(op));

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

	public static boolean compare(ProjectSpace testSpace, ProjectSpace compareSpace) {

		prepareCompare(testSpace, compareSpace, false);

		System.out.println("comparing...");
		return ModelUtil.areEqual(testSpace.getProject(), compareSpace.getProject());
	}

	/**
	 * Extracts changes form test project and applys them to compare project.
	 * 
	 * @param testSpace
	 * @param compareSpace
	 */
	private static void prepareCompare(final ProjectSpace testSpace, final ProjectSpace compareSpace,
		final boolean accumulative) {
		System.out.println("extracting operations from test project...");

		List<AbstractOperation> operations = testSpace.getOperations();
		System.out.println(operations.size() + " operatoins");
		final ChangePackage changePackage = getChangePackage(operations, true, false);

		// Save change package for later reference to disk.
		// The saved change package will be overwritten every time a test
		// succeeds.
		EObject copyChangePackage = EcoreUtil.copy(changePackage);
		ResourceSet reseourceSet = new ResourceSetImpl();
		Resource resource = reseourceSet.createResource(URI.createFileURI(TEMP_PATH + "changePackage.txt"));
		resource.getContents().add(copyChangePackage);
		try {
			resource.save(null);
		} catch (IOException e) {

			e.printStackTrace();
		}

		// apply changes to compare project
		getDomain().getCommandStack().execute(new RecordingCommand(getDomain()) {
			@Override
			protected void doExecute() {
				System.out.println("applying changes to compareSpace...");
				((ProjectSpaceImpl) compareSpace).stopChangeRecording();
				changePackage.apply(compareSpace.getProject());
				if (!accumulative) {
					testSpace.getOperations().clear();
				}
			}
		});
	}

	public static int[] linearCompare(ProjectSpace testSpace, ProjectSpace compareSpace) {

		prepareCompare(testSpace, compareSpace, false);
		System.out.println("linear comparing...");
		return linearCompare(testSpace.getProject(), compareSpace.getProject());

	}

	public static TransactionalEditingDomain getDomain() {

		if (domain == null) {
			domain = TransactionalEditingDomain.Registry.INSTANCE.getEditingDomain("org.unicase.EditingDomain");

		}
		return domain;
	}

	public static String eObjectToString(EObject object, String name) throws SerializationException {
		if (object == null) {
			return null;
		}
		Resource res = (new ResourceSetImpl()).createResource(URI.createURI("virtualUnicaseUri"));
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

				new File(Configuration.getWorkspaceDirectory() + "\\tmp\\").mkdir();
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

	public static List<ModelElement> getRandomMEs(Project project, int num, boolean unique) {

		List<ModelElement> result = new ArrayList<ModelElement>();
		if (allMEsInProject == null) {
			System.out.println("getting list of all model elements in project...");
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
				final ModelElement me = allMEsInProject.get(getRandom().nextInt(numOfMEs - 1));
				if (!result.contains(me)) {
					result.add(me);
				}

			} while (result.size() < num);

		} else {
			for (int i = 0; i < num; i++) {
				final ModelElement me = allMEsInProject.get(getRandom().nextInt(numOfMEs - 1));
				result.add(me);
			}

		}
		return result;
	}

	public static ModelElement getRandomME(Project project) {
		List<ModelElement> modelElements = getRandomMEs(project, 1, false);
		return modelElements.get(0);
	}

	public static ModelElement getRandomMEofType(Project project, EClass type) {

		List<ModelElement> refTypeMEs = project.getAllModelElementsbyClass(type, new BasicEList<ModelElement>());

		int size = refTypeMEs.size();
		if (size == 0) {
			return null;
			// throw new IllegalStateException("There is no ME of this type in Project: " + type.getName());
		}

		ModelElement me = refTypeMEs.get(getRandomPosition(size));
		return me;
	}

	public static ModelElement createRandomME() {
		List<EClass> eClazz = ModelUtil.getSubclasses(ModelPackage.eINSTANCE.getModelElement());
		EClass eClass = eClazz.get(getRandom().nextInt(eClazz.size() - 1));
		ModelElement me = (ModelElement) eClass.getEPackage().getEFactoryInstance().create(eClass);

		return me;
	}

	/**
	 * This creates a mew model element of given type. If type is abstract or interface a randomly selected sub-type of
	 * it will be instantiated.
	 * 
	 * @param refType EReference type
	 * @return a new model element instance of refType
	 */
	public static EObject createInstance(EClass refType) {

		EObject ret = null;

		if (refType.isAbstract() || refType.isInterface()) {
			List<EClass> eClazz = ModelUtil.getSubclasses(refType, refType.getEPackage());
			int index = getRandomPosition(eClazz.size());
			refType = eClazz.get(index);
		}

		ret = refType.getEPackage().getEFactoryInstance().create(refType);

		return ret;

	}

	/**
	 * This changes the given attribute on given ME. If attribute isMany then a new entry of attribute type will be
	 * added to a random position of its list. Also if attribute is an Enum, then a new value from this enumeration will
	 * be set for it. Note that new values are all selected randomly (except for strings).
	 * 
	 * @param me
	 * @param attribute
	 */
	@SuppressWarnings("unchecked")
	public static void changeAttribute(ModelElement me, EAttribute attribute) {

		if (attribute.getEType().getInstanceClass().equals(String.class)) {
			if (attribute.isMany()) {
				Object object = me.eGet(attribute);
				EList<String> eList = (EList<String>) object;
				int position = getRandomPosition(eList.size());
				eList.add(position, "new entry for" + attribute.getName());

			} else {
				String oldValue = (String) me.eGet(attribute);
				String newValue = "changed-" + oldValue;
				me.eSet(attribute, newValue);
			}

		} else if (attribute.getEType().getInstanceClass().equals(boolean.class)) {
			if (attribute.isMany()) {
				Object object = me.eGet(attribute);
				EList<Boolean> eList = (EList<Boolean>) object;
				int position = getRandomPosition(eList.size());
				eList.add(position, getRandom().nextBoolean());
			} else {
				me.eSet(attribute, !((Boolean) me.eGet(attribute)));
			}

		} else if (attribute.getEType().getInstanceClass().equals(int.class)) {
			if (attribute.isMany()) {
				Object object = me.eGet(attribute);
				EList<Integer> eList = (EList<Integer>) object;
				int position = getRandomPosition(eList.size());
				eList.add(position, getRandom().nextInt());
			} else {
				me.eSet(attribute, getRandom().nextInt());
			}

		} else if (attribute.getEType().getInstanceClass().equals(Date.class)) {
			if (attribute.isMany()) {
				Object object = me.eGet(attribute);
				EList<Date> eList = (EList<Date>) object;
				int position = getRandomPosition(eList.size());
				eList.add(position, getRandomDate());
			} else {
				me.eSet(attribute, getRandomDate());
			}

		}
		if (attribute.getEType() instanceof EEnum) {
			EEnum en = (EEnum) attribute.getEType();
			int numOfLiterals = en.getELiterals().size();
			int index = getRandomPosition(numOfLiterals);
			EEnumLiteral value = en.getELiterals().get(index);
			me.eSet(attribute, value.getInstance());
		}

	}

	public static int getRandomPosition(int listSize) {

		int position;
		if (listSize == 0) {
			position = 0;
		} else if (listSize == 1) {
			position = getRandom().nextInt(1);
		} else {
			position = getRandom().nextInt(listSize - 1);
		}
		return position;
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
			if (tmpAttr.isChangeable() && tmpAttr.getFeatureID() != ModelPackage.MODEL_ELEMENT__IDENTIFIER
				&& !tmpAttr.isTransient()) {
				attributes.add(tmpAttr);
			}
		}

		int size = attributes.size();
		if (size != 0) {
			attribute = attributes.get(getRandomPosition(size));

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
			nonContainmentRef = nonContainmentRefs.get(getRandomPosition(size));
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
			containmentRef = containments.get(getRandomPosition(size));
		}

		return containmentRef;
	}

	/**
	 * This method takes a model element and a non-containment reference. It gathers all model elements in project which
	 * have the type of that reference. Takes one of these in random, and adds it to reference list of input model
	 * element (in a random position if ref is many).
	 * 
	 * @param me the input model element
	 * @param ref the non-containment reference to change
	 * @param project the project
	 * @return model element which is added to this reference
	 */
	@SuppressWarnings("unchecked")
	public static ModelElement changeNonContainementRef(ModelElement me, EReference ref, Project project) {

		EClass refType = ref.getEReferenceType();
		List<ModelElement> refTypeMEs = project.getAllModelElementsbyClass(refType, new BasicEList<ModelElement>());

		if (refTypeMEs.contains(me)) {
			refTypeMEs.remove(me);
		}

		ModelElement toBeReferencedME = refTypeMEs.get(getRandomPosition(refTypeMEs.size()));

		Object object = me.eGet(ref);
		if (ref.isMany()) {
			EList<EObject> eList = (EList<EObject>) object;
			if (eList == null) {
				throw new IllegalStateException("Null list return for feature " + ref.getName() + " on " + me.getName());
			} else {
				int position = getRandomPosition(eList.size());
				eList.add(position, toBeReferencedME);
			}
		} else {
			me.eSet(ref, toBeReferencedME);
		}

		return toBeReferencedME;

	}

	/**
	 * @param me me
	 * @param ref ref
	 * @param toBeReferencedME
	 */
	@SuppressWarnings("unchecked")
	public static void changeNonContainmentRef(ModelElement me, EReference ref, ModelElement toBeReferencedME) {
		Object object = me.eGet(ref);
		if (ref.isMany()) {
			EList<EObject> eList = (EList<EObject>) object;
			if (eList == null) {
				throw new IllegalStateException("Null list return for feature " + ref.getName() + " on " + me.getName());
			} else {
				int position = getRandomPosition(eList.size());
				eList.add(position, toBeReferencedME);
			}
		} else {
			me.eSet(ref, toBeReferencedME);
		}

	}

	/**
	 * @param me ME
	 * @param attribute an attribute with multiple values (isMany = true)
	 */
	public static void moveMultiAttributeValue(ModelElement me, EAttribute attribute) {
		if (!attribute.isMany()) {
			throw new IllegalArgumentException("Given attribute must be multiple valued (isMany = true)");
		}

		Object object = me.eGet(attribute);
		EList<?> eList = (EList<?>) object;
		int position1 = getRandomPosition(eList.size());
		int position2 = getRandomPosition(eList.size());
		Collections.swap(eList, position1, position2);

	}

	@SuppressWarnings("unchecked")
	public static void moveMultiReferenceValue(ModelElement me, EReference ref) {
		if (!ref.isMany()) {
			throw new IllegalArgumentException("Given reference must be multiple valued (isMany = true)");
		}
		Object object = me.eGet(ref);
		EList<EObject> eList = (EList<EObject>) object;
		if (eList == null) {
			throw new IllegalStateException("Null list return for feature " + ref.getName() + " on " + me.getName());
		} else {
			int position1 = getRandomPosition(eList.size());
			int position2 = getRandomPosition(eList.size());
			Collections.swap(eList, position1, position2);
		}

	}
}
