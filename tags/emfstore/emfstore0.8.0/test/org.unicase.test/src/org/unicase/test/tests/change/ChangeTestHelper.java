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
import org.unicase.metamodel.MetamodelPackage;
import org.unicase.metamodel.ModelElement;
import org.unicase.metamodel.Project;
import org.unicase.metamodel.util.ModelUtil;
import org.unicase.metamodel.util.SerializationException;
import org.unicase.model.UnicaseModelElement;
import org.unicase.workspace.Configuration;
import org.unicase.workspace.ProjectSpace;
import org.unicase.workspace.WorkspaceFactory;
import org.unicase.workspace.impl.ProjectSpaceImpl;

public final class ChangeTestHelper {

	private static TransactionalEditingDomain domain;
	private static String TEMP_PATH = Configuration.getWorkspaceDirectory() + File.separator + "tmp";

	private static Random random;
	private static EList<ModelElement> allMEsInProject;

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

			new File(TEMP_PATH).mkdir();
		}

		return projectSpace;

	}

	/**
	 * Creates a change package from given operations.
	 * 
	 * @param operations list of operations. This can be obtained by calling ProjectSpace.getOperations() method.
	 * @param cannonize if operations will be cannonized.
	 * @param clearOperations if operations must be cleared from project space. This is used when running more than one
	 *            change package test after each other and we don't want operation from one change package test to be
	 *            accumulated in operations of change package test run after that.
	 * @return
	 */
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

	/**
	 * This method compares two projects using {@link ModelUtil#areEqual(Project, Project)}. You can also use
	 * linearCompare(project, project) to identify the position in which the project differ.
	 * 
	 * @param testSpace
	 * @param compareSpace
	 * @return if objects are equal
	 */
	public static boolean compare(ProjectSpace testSpace, ProjectSpace compareSpace) {

		// extract changes from testSpace and apply them to compareSpace
		prepareCompare(testSpace, compareSpace, false);

		System.out.println("comparing...");
		return ModelUtil.areEqual(testSpace.getProject(), compareSpace.getProject());
	}

	/**
	 * Extracts changes form test project and applies them to compare project. Extracted ChangePackage is also written
	 * to disk (to TMP_PATH/changePackage.txt file) for further investigations.
	 * 
	 * @param testSpace project space to extract operations from
	 * @param compareSpace project space to apply extracted operations to
	 * @param accumulative if operations must remain in test project space after extracting them
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
		Resource resource = reseourceSet.createResource(URI.createFileURI(TEMP_PATH + File.separator
			+ "changePackage.txt"));
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

	/**
	 * Uses linearCompare(projectA, projectB) method to compare projects contained in given project spaces. The result
	 * is an array of integers with following elements: index 0 (ARE_EQUAL) 0 if files are not equal and 1 otherwise;
	 * index 1 (DIFFRENCE_POSITION) index of differing character; index 2 (CHARACTER) the differing character; index 3
	 * (LINE_NUM) line number of first differing character; index 4 (COL_NUM) column number of first differing
	 * character. If any exceptions is thrown, all indices in result array will be -1.
	 * 
	 * @param testSpace
	 * @param compareSpace
	 * @return if projects inside these project spaces are equal or not, and if they are not equal the location of
	 *         differing character in their serialized string
	 */
	public static int[] linearCompare(ProjectSpace testSpace, ProjectSpace compareSpace) {

		prepareCompare(testSpace, compareSpace, false);
		System.out.println("linear comparing...");
		return linearCompare(testSpace.getProject(), compareSpace.getProject());

	}

	/**
	 * Returns editing domain.
	 * 
	 * @return editing domain
	 */
	public static TransactionalEditingDomain getDomain() {

		if (domain == null) {
			domain = TransactionalEditingDomain.Registry.INSTANCE.getEditingDomain("org.unicase.EditingDomain");

		}
		return domain;
	}

	/**
	 * Returns a serialized string for this object. It also saves serialized string to disk (in TMP_PATH) under given
	 * name.
	 * 
	 * @param object object
	 * @param name name to save string representation of object
	 * @return serialized string representation of this object
	 * @throws SerializationException
	 */
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
		File file = new File(TEMP_PATH + File.separator + name + ".txt");
		try {
			if (!file.exists()) {

				new File(TEMP_PATH).mkdir();
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

	/**
	 * This method compare two projects with each other. It first converts projects in string and finds location of
	 * first character in which these strings differ. The result is an array of integers with following elements: index
	 * 0 (ARE_EQUAL) 0 if files are not equal and 1 otherwise; index 1 (DIFFRENCE_POSITION) index of differing
	 * character; index 2 (CHARACTER) the differing character; index 3 (LINE_NUM) line number of first differing
	 * character; index 4 (COL_NUM) column number of first differing character. If any exceptions is thrown, all indices
	 * in result array will be -1.
	 * 
	 * @param projectA project A
	 * @param projectB project B
	 * @return if projects are equal or not, and if they are not equal the location of differing character in their
	 *         serialized string
	 */
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

	/**
	 * Finds column number of given index inside a multi-line string.
	 * 
	 * @param stringA string
	 * @param index index
	 * @return
	 */
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

	/**
	 * Finds line number of a given index inside a multi-line string.
	 * 
	 * @param stringA
	 * @param index
	 * @return
	 */
	private static int getLineNum(String stringA, int index) {
		int lineNum = 1;
		for (int i = 0; i < index; i++) {
			if (stringA.charAt(i) == '\n') {
				lineNum++;
			}
		}
		return lineNum;
	}

	/**
	 * Returns a list of randomly selected MEs
	 * 
	 * @param project project from which to select MEs
	 * @param num how many MEs to select
	 * @param unique if they must be unique
	 * @return
	 */
	public static List<UnicaseModelElement> getRandomMEs(Project project, int num, boolean unique) {

		List<UnicaseModelElement> result = new ArrayList<UnicaseModelElement>();
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
				final UnicaseModelElement me = (UnicaseModelElement) allMEsInProject.get(getRandom().nextInt(
					numOfMEs - 1));
				if (!result.contains(me)) {
					result.add(me);
				}

			} while (result.size() < num);

		} else {
			for (int i = 0; i < num; i++) {
				final UnicaseModelElement me = (UnicaseModelElement) allMEsInProject.get(getRandom().nextInt(
					numOfMEs - 1));
				result.add(me);
			}

		}
		return result;
	}

	/**
	 * Returns a randomly selected ME form this project.
	 * 
	 * @param project project
	 * @return randomly selected ME
	 */
	public static UnicaseModelElement getRandomME(Project project) {
		List<UnicaseModelElement> modelElements = getRandomMEs(project, 1, false);
		return modelElements.get(0);
	}

	/**
	 * Returns a randomly selected ME of given type from this project. If there is no ME of this type in project null is
	 * returned.
	 * 
	 * @param project project
	 * @param type model element type
	 * @return ME or null if there is no ME of this type in project
	 */
	public static UnicaseModelElement getRandomMEofType(Project project, EClass type) {

		List<UnicaseModelElement> refTypeMEs = project.getAllModelElementsbyClass(type,
			new BasicEList<UnicaseModelElement>());

		int size = refTypeMEs.size();
		if (size == 0) {
			return null;
			// throw new IllegalStateException("There is no ME of this type in Project: " + type.getName());
		}

		UnicaseModelElement me = refTypeMEs.get(getRandomPosition(size));
		return me;
	}

	/**
	 * Creates an instance of model element with a randomly selected model element type.
	 * 
	 * @return ME
	 */
	public static UnicaseModelElement createRandomME() {
		List<EClass> eClazz = new ArrayList<EClass>(ModelUtil.getSubclasses(MetamodelPackage.eINSTANCE
			.getModelElement()));
		EClass eClass = eClazz.get(getRandom().nextInt(eClazz.size() - 1));
		UnicaseModelElement me = (UnicaseModelElement) eClass.getEPackage().getEFactoryInstance().create(eClass);

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
			List<EClass> eClazz = new ArrayList<EClass>(ModelUtil.getSubclasses(refType));
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
	public static void changeAttribute(UnicaseModelElement me, EAttribute attribute) {

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

	/**
	 * Returns a random position in a list. If list size is 0, 0 is returned.
	 * 
	 * @param listSize list size
	 * @return random index
	 */
	public static int getRandomPosition(int listSize) {

		int position;
		if (listSize == 0) {
			position = 0;
		} else {
			position = getRandom().nextInt(listSize);
		}
		return position;
	}

	/**
	 * Sets random generator for this class.
	 * 
	 * @param random random
	 */
	public static void setRandom(Random random) {
		ChangeTestHelper.random = random;
	}

	/**
	 * Returns random generator of this ChangeTestHelper.
	 * 
	 * @return random
	 */
	public static Random getRandom() {
		return random;
	}

	/**
	 * get a random date.
	 * 
	 * @return ranodm date
	 */
	private static Date getRandomDate() {
		return new Date();
	}

	/**
	 * Returns randomly one of attributes of this ME. The returned attribute is changeable, is not
	 * MODEL_ELEMENT_IDENTIFIER, and is not transient.
	 * 
	 * @param me ME
	 * @return a random selected attribute
	 */
	public static EAttribute getRandomAttribute(UnicaseModelElement me) {
		EAttribute attribute = null;
		List<EAttribute> attributes = new ArrayList<EAttribute>();
		for (EAttribute tmpAttr : me.eClass().getEAllAttributes()) {
			if (tmpAttr.isChangeable() && tmpAttr.getFeatureID() != MetamodelPackage.MODEL_ELEMENT__IDENTIFIER
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

	/**
	 * Returns a randomly selected non-containment reference of this ME. It is changeable, and not transient.
	 * 
	 * @param me ME
	 * @return randomly selected changeable non-transient non-containment reference of this ME
	 */
	public static EReference getRandomNonContainmentRef(UnicaseModelElement me) {
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

	/**
	 * Returns a randomly selected containment reference of this ME. It is changeable and not transient.
	 * 
	 * @param me ME
	 * @return a randomly selected containment reference of this ME. It is changeable and not transient
	 */
	public static EReference getRandomContainmentRef(UnicaseModelElement me) {
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
	public static UnicaseModelElement changeNonContainementRef(UnicaseModelElement me, EReference ref, Project project) {

		EClass refType = ref.getEReferenceType();
		List<UnicaseModelElement> refTypeMEs = project.getAllModelElementsbyClass(refType,
			new BasicEList<UnicaseModelElement>());

		if (refTypeMEs.contains(me)) {
			refTypeMEs.remove(me);
		}

		UnicaseModelElement toBeReferencedME = refTypeMEs.get(getRandomPosition(refTypeMEs.size()));

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
	 * Adds the given model element to this non-containment reference of given ME. If reference is not many, the given
	 * model element replaces the previous value of this reference.
	 * 
	 * @param me me model element to change its reference
	 * @param ref non-containment reference
	 * @param toBeReferencedME model element to reference
	 */
	@SuppressWarnings("unchecked")
	public static void changeNonContainmentRef(UnicaseModelElement me, EReference ref,
		UnicaseModelElement toBeReferencedME) {
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
	 * Changes the index of a value in a multi-valued EAtrribute of this ME
	 * 
	 * @param me ME model element to change
	 * @param attribute an attribute with multiple values (isMany = true)
	 */
	public static void moveMultiAttributeValue(UnicaseModelElement me, EAttribute attribute) {
		if (!attribute.isMany()) {
			throw new IllegalArgumentException("Given attribute must be multiple valued (isMany = true)");
		}

		Object object = me.eGet(attribute);
		EList<?> eList = (EList<?>) object;
		int position1 = getRandomPosition(eList.size());
		int position2 = getRandomPosition(eList.size());
		Collections.swap(eList, position1, position2);

	}

	/**
	 * Changes index of a reference in a many EReference of given ME.
	 * 
	 * @param me ME
	 * @param ref EReference to change
	 */
	@SuppressWarnings("unchecked")
	public static void moveMultiReferenceValue(UnicaseModelElement me, EReference ref) {
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
