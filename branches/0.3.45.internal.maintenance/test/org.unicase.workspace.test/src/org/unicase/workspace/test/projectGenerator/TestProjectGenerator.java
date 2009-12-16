/**
 * <copyright> Copyright (c) 2008-2009 Jonas Helming, Maximilian Koegel. All rights reserved. This program and the
 * accompanying materials are made available under the terms of the Eclipse Public License v1.0 which accompanies this
 * distribution, and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>
 */
package org.unicase.workspace.test.projectGenerator;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Random;

import org.eclipse.emf.common.util.BasicEList;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EEnum;
import org.eclipse.emf.ecore.EEnumLiteral;
import org.eclipse.emf.ecore.EFactory;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.impl.ETypedElementImpl;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.unicase.metamodel.IdentifiableElement;
import org.unicase.metamodel.MetamodelFactory;
import org.unicase.metamodel.MetamodelPackage;
import org.unicase.metamodel.ModelElement;
import org.unicase.metamodel.Project;
import org.unicase.model.ModelPackage;
import org.unicase.model.UnicaseModelElement;
import org.unicase.model.diagram.DiagramPackage;
import org.unicase.model.diagram.DiagramType;
import org.unicase.model.diagram.MEDiagram;
import org.unicase.model.document.CompositeSection;
import org.unicase.model.document.DocumentPackage;
import org.unicase.model.document.LeafSection;
import org.unicase.model.document.Section;
import org.unicase.workspace.ProjectSpace;
import org.unicase.workspace.Workspace;
import org.unicase.workspace.WorkspaceFactory;
import org.unicase.workspace.impl.WorkspaceImpl;
import org.unicase.workspace.util.UnicaseCommand;

/**
 * @author Hodaie This class creates a test random model. The test takes parameters like minimum number of model
 *         elements, maximum number of references and structure of project (number of LeafSections and
 *         CompositeSections). It then creates the required number of elements, makes their references randomly, and
 *         distributes them randomly in project structure. Finally a random number of created MEs are open.
 */
public class TestProjectGenerator {

	private int numOfEachME;
	private int projectWidth;
	private int projectDepth;
	private int maxNumOfManyRefs;
	private int maxNumOfMEsInLeafSection;

	// the text attributes are created randomly from these words.
	private static final String[] WORDS = { "hello", "cat", "mouse", "sun", "moon", "network", "watch", "rain", "kid",
		"repair", "bug", "rainbow" };
	// maximum length of a text
	private static final int MAX_NUM_OF_WORDS = 5;

	private Project project;

	private Random random;
	// these two are just shortcuts in order to save typing
	private static final EClass MODELELEMENT_ECLASS = MetamodelPackage.eINSTANCE.getModelElement();
	private static final EClass SECTION_ECLASS = DocumentPackage.eINSTANCE.getSection();

	// maintain a list of instances of every class. This is to avoid
	// the project.getAllModelElementsByClass() calls which take too long to
	// return.
	private HashMap<EClass, List<EObject>> meInstancesByClass = new HashMap<EClass, List<EObject>>();
	private HashMap<EClass, List<EObject>> nonMEInstancesByClass = new HashMap<EClass, List<EObject>>();
	// keep a list of all classes that can be instantiated.
	private List<EClass> meNonAbstractClasses = new ArrayList<EClass>();
	private List<EClass> nonMEnonAbstractClasses = new ArrayList<EClass>();
	private MEDiagramElementsProvider diagramElementsProvider;

	/**
	 * Constructor: set test project parameters.
	 * 
	 * @param numOfEachME minimum number of each ME
	 * @param randomSeed random seed
	 * @param projWidth number of sub-Sections in each composite section
	 * @param projDepth number of levels in project structure
	 * @param maxNumOfManyRefs maximum number of references
	 * @param maxNumOfMEsInLeafSection max number of MEs to show on a LeafSection
	 */
	public TestProjectGenerator(int numOfEachME, long randomSeed, int projWidth, int projDepth, int maxNumOfManyRefs,
		int maxNumOfMEsInLeafSection) {

		this.numOfEachME = numOfEachME;
		this.projectWidth = projWidth;
		this.projectDepth = projDepth;
		this.maxNumOfManyRefs = maxNumOfManyRefs;
		this.maxNumOfMEsInLeafSection = maxNumOfMEsInLeafSection;

		random = new Random(randomSeed);
		initClassLists();

	}

	/**
	 * Constructor.
	 * 
	 * @param params test parameters
	 */
	public TestProjectGenerator(TestProjectParmeters params) {
		this.numOfEachME = params.getNumOfEachME();
		this.projectWidth = params.getProjWidth();
		this.projectDepth = params.getProjDepth();
		this.maxNumOfManyRefs = params.getMaxNumOfManyRefs();
		this.maxNumOfMEsInLeafSection = params.getMaxNumOfMEsInLeafSection();

		random = new Random(params.getRandomSeed());
		initClassLists();
	}

	/**
	 * At the beginning, initialize a list of all non-Abstract, ME- and non-ME classes. this is done mainly for
	 * performance, to eliminate loop which went through model package.
	 */

	private void initClassLists() {
		getClasses(ModelPackage.eINSTANCE);

	}

	/**
	 * recursively go through model package and create a list of all non-Abstract classes (ME and non-ME) Attention: the
	 * Project class is excluded.
	 * 
	 * @param ePackage
	 */
	private void getClasses(EPackage ePackage) {

		for (EObject eObject : ePackage.eContents()) {
			if (eObject instanceof EClass) {
				EClass eClass = (EClass) eObject;
				if (MODELELEMENT_ECLASS.isSuperTypeOf(eClass)) {
					if (!(eClass.isAbstract() || eClass.isInterface() || eClass.equals(MetamodelPackage.eINSTANCE
						.getProject()))) {
						// this can be instantiated
						meNonAbstractClasses.add(eClass);
					}
				} else {
					if (!(eClass.isAbstract() || eClass.isInterface())) {
						// this can be instantiated
						nonMEnonAbstractClasses.add(eClass);
					}
				}
			} else if (eObject instanceof EPackage) {
				EPackage eSubPackage = (EPackage) eObject;
				getClasses(eSubPackage);
			}
		}
	}

	/**
	 * This creates the test project and adds it to workspace.
	 * 
	 * @param workspace Workspace to which the project will be added
	 * @param project Project to be added
	 */
	public void addProjectToWorkspace(final Workspace workspace, Project project) {
		final ProjectSpace projectSpace = WorkspaceFactory.eINSTANCE.createProjectSpace();
		projectSpace.setProject(project);

		projectSpace.setProjectDescription("Test project description");
		projectSpace.setProjectName("ModelTestProject");
		projectSpace.setLocalOperations(WorkspaceFactory.eINSTANCE.createOperationComposite());

		new UnicaseCommand() {

			@Override
			protected void doRun() {
				// FIXME: ugly code
				projectSpace.initResources(((WorkspaceImpl) workspace).getWorkspaceResourceSet());
				((WorkspaceImpl) workspace).addProjectSpace(projectSpace);
				workspace.save();
			}

		}.run();

	}

	/**
	 * Creates a test project.
	 * 
	 * @return a Project
	 */
	public Project generateProject() {
		// create a project
		this.project = MetamodelFactory.eINSTANCE.createProject();
		// create document structure in project
		int depth = projectDepth - 2;
		for (int i = 0; i < projectWidth; i++) {
			CompositeSection comp = (CompositeSection) createInstance(DocumentPackage.eINSTANCE.getCompositeSection(),
				false);
			createDocStructure(depth, comp);
			project.addModelElement(comp);
		}

		// create the minimum number of each EClass
		// initialize the simple attributes
		// add them to project (if instanceof model element)
		// and for performance reasons to hash-tables of ME- and non-MEInstances
		createMinimumNumOfInstances();

		// set references
		createReferences();

		// distribute some model elements on LeafSections
		EList<ModelElement> leafSections = project.getAllModelElementsbyClass(DocumentPackage.eINSTANCE
			.getLeafSection(), new BasicEList<ModelElement>());
		for (EObject ls : leafSections) {
			distributeMEsOnLeafSection((LeafSection) ls);
		}
		return project;

	}

	/**
	 * recursively create the subsections (Composite and LeafSections) under a Composite section. (based on projectWidth
	 * and projectDepth)
	 */
	private void createDocStructure(int remainingDepth, CompositeSection comp) {

		if (remainingDepth > 0) {
			// create CompositeSections
			for (int i = 0; i < projectWidth; i++) {
				CompositeSection newComp = (CompositeSection) createInstance(DocumentPackage.eINSTANCE
					.getCompositeSection(), false);
				comp.getSubsections().add(newComp);
				createDocStructure(--remainingDepth, newComp);
			}
		} else {
			// remainingDepth == 0 now create LeafSections
			for (int i = 0; i < projectWidth; i++) {
				LeafSection ls = (LeafSection) createInstance(DocumentPackage.eINSTANCE.getLeafSection(), false);
				comp.getSubsections().add(ls);
			}
		}
	}

	/**
	 * create minimum number of instances of all EClasses contained in Model Package.
	 */
	private void createMinimumNumOfInstances() {
		List<EClass> allNonAbstractClasses = new ArrayList<EClass>();
		allNonAbstractClasses.addAll(meNonAbstractClasses);
		allNonAbstractClasses.addAll(nonMEnonAbstractClasses);
		for (EClass eClass : allNonAbstractClasses) {
			createInstances(eClass);
		}
	}

	/**
	 * create the required minimum number of instances of an EClass. initialize simple attributes add them to project.
	 */
	private void createInstances(EClass eClass) {
		// the model element IDs are set explicitly (in
		// initializeSimpleAttributes() method)
		// therefore we don't need to create instances of this class
		if (eClass.equals(MetamodelPackage.eINSTANCE.getModelElementId())) {
			return;
		}
		// the classes of Document package should not be instantiated
		// again. They have been instantiated in createDocStructure and added
		// to project.
		if (SECTION_ECLASS.isSuperTypeOf(eClass)) {
			return;
		}

		// do not create non domain elements
		if (MetamodelPackage.eINSTANCE.getNonDomainElement().isSuperTypeOf(eClass)) {
			return;
		}

		// create the specified minimum number of instances of this EClass
		for (int i = 0; i < numOfEachME; i++) {
			EObject obj = createInstance(eClass, false);
			if (obj instanceof ModelElement) {
				project.addModelElement((ModelElement) obj);
			}
		}
	}

	/**
	 * this adds an instance to (EClass, ItsInstances) hash-tables.
	 */
	private void keepTrackOf(EClass eClass, EObject instance) {
		if (MODELELEMENT_ECLASS.isSuperTypeOf(eClass)) {
			// if instance is a ModelElement, add it to model elements
			// hash-table
			if (meInstancesByClass.get(eClass) == null) {
				meInstancesByClass.put(eClass, new ArrayList<EObject>());
			}
			meInstancesByClass.get(eClass).add(instance);
		} else {
			// if instance is non-ModelElement, add it to non-MEs hash-table
			if (nonMEInstancesByClass.get(eClass) == null) {
				nonMEInstancesByClass.put(eClass, new ArrayList<EObject>());
			}
			nonMEInstancesByClass.get(eClass).add(instance);
		}

	}

	/**
	 * this goes through initial elements in project, and sets their references.
	 */
	private void createReferences() {
		// set references for the initial elements in project.
		// For elements that are created during setting references (e.g. because there is not ME of ref type anymore
		// unreferenced in project), it is not needed.
		List<EObject> allMEs = new ArrayList<EObject>();
		allMEs.addAll(getAllInstancesOf(MODELELEMENT_ECLASS));

		for (EObject me : allMEs) {
			initializeReferences((ModelElement) me);
		}
	}

	/**
	 * this sets the references according their type.
	 */
	private void initializeReferences(ModelElement me) {

		List<EReference> references = me.eClass().getEAllReferences();
		for (EReference ref : references) {
			// model element ids are set explicitly
			if (ref.getName().equals("identifier")) {
				continue;
			}

			if (ref.isContainment()) {
				createContainmentRef(me, ref, ref.getLowerBound(), ref.getUpperBound());
			} else if (ref.isContainer()) {
				// do nothing, the container references are automatically
				// set when the containment references are set.
				// i mean when you set a containment, it's opposite which is a
				// container is also set.
			} else {

				// reference is neither containment, nor container
				createNormalReference(me, ref, ref.getLowerBound(), ref.getUpperBound());
			}

		}
		// check other cases 1.one-to-one, required; 2. one-to-one, not
		// required;
		// they are considered in createRefs methods. Using ref.upperBound and
		// .lowerBound
	}

	/**
	 * this sets normal (non containment)references for an instance.
	 * 
	 * @param me
	 * @param ref
	 * @param lowerBound
	 * @param upperBound
	 */
	@SuppressWarnings("unchecked")
	private void createNormalReference(ModelElement me, EReference ref, int lowerBound, int upperBound) {
		// create a list of all instances of reference type
		// and get a random number for number of references
		List<EObject> instancesOfRefType = new ArrayList<EObject>();
		int numOfRefs;
		if (me instanceof MEDiagram && ref.equals(DiagramPackage.eINSTANCE.getMEDiagram_Elements())) {
			diagramElementsProvider = new MEDiagramElementsProvider(project);
			MEDiagram diagram = (MEDiagram) me;
			DiagramType diagramType = diagram.getType();
			instancesOfRefType.addAll(diagramElementsProvider.getMatchingElements(diagramType));
			numOfRefs = diagramElementsProvider.getRandomNumOfDiagramElements(diagramType);
		} else {
			instancesOfRefType.addAll(getAllInstancesOf(ref.getEReferenceType()));
			numOfRefs = getNumOfRefs(ref, lowerBound, upperBound);
		}

		// check not to self-reference
		if (instancesOfRefType.contains(me)) {
			instancesOfRefType.remove(me);
		}

		// if there are not enough instances of this type in project,
		// (instancesOfRefType.size() < numOfRefs)
		// create the lacking instances.
		// keep in mind that if reference is a Section,
		// instancesOfRefType.size()
		// is always greater equal numOfRefs (this is a special case handled in
		// getNumOfRefs())
		if (instancesOfRefType.size() < numOfRefs) {
			int lackingInstances = numOfRefs - instancesOfRefType.size();
			boolean noSection = true;
			for (int i = 0; i < lackingInstances; i++) {
				// 1.we don't want to create Sections!!
				// 2.createInstance() adds also the newly created instances to
				// tracking hash-tables
				EObject newInstance = createInstance(ref.getEReferenceType(), noSection);
				instancesOfRefType.add(newInstance);
				// if it's a ModelElement, add it to project too
				if (newInstance instanceof ModelElement) {
					project.addModelElement((ModelElement) newInstance);
				}
			}

		}

		List<EObject> referencedInstances = new ArrayList<EObject>();
		for (int i = 0; i < numOfRefs; i++) {
			// pick random instance of ref's type
			int index = random.nextInt(instancesOfRefType.size());
			EObject referencedInstance = instancesOfRefType.get(index);
			referencedInstances.add(referencedInstance);
			// remove the referenced instance, so that it's
			// not incidentally referenced again.
			instancesOfRefType.remove(referencedInstance);
		}
		if (ref.isMany()) {
			List<Object> list = (List<Object>) me.eGet(ref);
			list.addAll(referencedInstances);
		} else if (referencedInstances.size() != 0) {
			me.eSet(ref, referencedInstances.get(0));
		} else {
			// me.eSet(ref, null);
		}

	}

	/**
	 * this sets containment references for an instance consider that containment reference of an object, is at the same
	 * time container reference of the opposite object.
	 */
	@SuppressWarnings("unchecked")
	private void createContainmentRef(ModelElement me, EReference ref, int lowerBound, int upperBound) {
		// check special cases
		if (checkSpecialCase(me, ref)) {
			return;
		}

		// get a list of all instances of ref type
		// these can be potentially used for this containment
		List<EObject> allInstancesOfRefType = new ArrayList<EObject>();
		allInstancesOfRefType.addAll(getAllInstancesOf(ref.getEReferenceType()));

		// create a list of instances that actually can be used for this
		// containment
		// these are instances that 1)are not contained in some other object,
		// 2)are not ancestor of this element, and 3)not the element itself
		List<EObject> freeInstancesOfRefType = new ArrayList<EObject>();
		for (EObject obj : allInstancesOfRefType) {
			boolean isValid = ((obj.eContainer() == null || obj.eContainer().equals(project))
				&& !EcoreUtil.isAncestor(obj, me) && !obj.equals(me));
			if (isValid) {
				freeInstancesOfRefType.add(obj);
			}
		}

		// get a random number of references, (if ref is Section, this number is
		// maximum how many Sections are in project)
		int numOfRefs = getNumOfRefs(ref, lowerBound, upperBound);
		// check if we need to create new instances
		if (freeInstancesOfRefType.size() < numOfRefs) {
			int lackingFreeInstances = numOfRefs - freeInstancesOfRefType.size();
			boolean noSection = true;
			for (int i = 0; i < lackingFreeInstances; i++) {
				// for "modelElements" reference of LeafSection see checking
				// above
				// have in mind that we don't want to create new Sections!
				freeInstancesOfRefType.add(createInstance(ref.getEReferenceType(), noSection));
			}
		}

		List<EObject> referencedInstances = new ArrayList<EObject>();
		for (int i = 0; i < numOfRefs; i++) {
			// pick random instance from free instances
			int index = random.nextInt(freeInstancesOfRefType.size());
			EObject referencedInstance = freeInstancesOfRefType.get(index);
			referencedInstances.add(referencedInstance);
			freeInstancesOfRefType.remove(referencedInstance);
		}
		if (ref.isMany()) {
			List<Object> list = (List<Object>) me.eGet(ref);
			list.addAll(referencedInstances);
		} else if (referencedInstances.size() != 0) {
			me.eSet(ref, referencedInstances.get(0));
		} else {
			me.eSet(ref, null);
		}

	}

	/**
	 * this checks ME and Ref against some special cases.
	 */
	private boolean checkSpecialCase(ModelElement me, EReference ref) {
		boolean result = false;
		if (ref.getEReferenceType().equals(MetamodelPackage.eINSTANCE.getModelElementId())) {
			// for all instances the model element id is set
			// during creation in createInstances method
			result = true;
		}
		if (me instanceof Section && ref.getName().equals("subsections")) {
			// subsections are set during building of document structure
			result = true;
		}
		if (me instanceof LeafSection && ref.getName().equals("modelElements")) {
			// distribution of model elements among leaf sections occurs
			// in the last step in createTestProject method
			// distributeMEsOnLeafSection((LeafSection)me);
			result = true;
		}
		if (SECTION_ECLASS.isSuperTypeOf(ref.getEReferenceType())) {
			// we don't want to break apart the document structure.
			// a containment reference whose target is Section is not
			// considered.
			result = true;
		}
		if (me instanceof MEDiagram && ref.equals(DiagramPackage.eINSTANCE.getMEDiagram_NewElements())) {
			result = true;
		}
		return result;

	}

	// returns a random number for number of references
	private int getNumOfRefs(EReference ref, int lowerBound, int upperBound) {
		int numOfRefs = maxNumOfManyRefs;

		if (upperBound == lowerBound && lowerBound > 0) {
			// this instance requires an exact number or references
			numOfRefs = lowerBound;

		} else if (upperBound == ETypedElementImpl.UNBOUNDED_MULTIPLICITY || upperBound >= maxNumOfManyRefs) {
			// return a random number (minimum lowerBound, and maximum
			// maxNumOfManyRefs)
			if (maxNumOfManyRefs > lowerBound) {
				numOfRefs = lowerBound + random.nextInt(maxNumOfManyRefs - lowerBound);
			} else {
				numOfRefs = lowerBound;
			}

		} else {
			if (upperBound == ETypedElementImpl.UNSPECIFIED_MULTIPLICITY) {
				numOfRefs = lowerBound;
			} else {
				// in this case upperBound is less than maxNumOfRefs
				numOfRefs = lowerBound + random.nextInt(upperBound - lowerBound);
			}
		}

		if (SECTION_ECLASS.isSuperTypeOf(ref.getEReferenceType())) {
			if (ref.getEReferenceType().equals(DocumentPackage.eINSTANCE.getCompositeSection())
				|| ref.getEReferenceType().equals(DocumentPackage.eINSTANCE.getLeafSection())) {
				// if ref type is CompositeSection or LeafSection
				numOfRefs = random.nextInt(meInstancesByClass.get(ref.getEReferenceType()).size());
			} else {
				// it need just a section, whatever.
				numOfRefs = random.nextInt(getAllInstancesOf(SECTION_ECLASS).size());
			}
		}
		return numOfRefs;
	}

	/**
	 * this returns all instances of an EClass in the project. EClass can be abstract.
	 */
	private List<EObject> getAllInstancesOf(EClass type) {
		List<EObject> result;
		HashMap<EClass, List<EObject>> map;
		// if EClass is a ModelElement sub-class, look in MEs hash-table
		if (MODELELEMENT_ECLASS.isSuperTypeOf(type)) {
			map = meInstancesByClass;
		} else {
			map = nonMEInstancesByClass;
		}

		if (type.isAbstract() || type.isInterface()) {
			result = new ArrayList<EObject>();
			Iterator<EClass> iterator = map.keySet().iterator();
			while (iterator.hasNext()) {
				EClass eClass = iterator.next();
				if (type.isSuperTypeOf(eClass)) {
					result.addAll(map.get(eClass));
				}

			}
		} else {
			result = map.get(type);
		}
		if (result == null) {
			// don't return null.
			// in some cases there's no instance of this type in the project at
			// all
			// for example instance of GMF Diagram class
			result = new ArrayList<EObject>();
		}
		return result;
	}

	/**
	 * after all instances are created and references are set distribute some instances which are not contained in some
	 * other, on leaf sections.
	 */
	private void distributeMEsOnLeafSection(LeafSection ls) {

		int numOfRefs = random.nextInt(maxNumOfMEsInLeafSection);
		// get a list of all MEs in project
		List<EObject> allMEs = new ArrayList<EObject>();
		allMEs.addAll(getAllInstancesOf(MODELELEMENT_ECLASS));

		// get a list of MEs that are not contained in some other,
		// therefore can be contained in a LeafSection
		List<EObject> freeMEs = new ArrayList<EObject>();
		for (EObject me : allMEs) {
			// be careful about Sections. We don't want to break the document
			// structure, also CompositeSection is not allowed to be in a
			// LeafSection
			if (!(me instanceof Section) && (me.eContainer() == null || me.eContainer().equals(project))) {

				freeMEs.add(me);
			}
		}

		List<UnicaseModelElement> referencedInstances = new ArrayList<UnicaseModelElement>();
		if (freeMEs.size() < numOfRefs) {
			int lackingFreeInstances = numOfRefs - freeMEs.size();
			for (int i = 0; i < lackingFreeInstances; i++) {
				// if required, create new instances, but take care not to
				// create Sections
				freeMEs.add(createInstance(MetamodelPackage.eINSTANCE.getModelElement(), true));

			}
		}

		for (int i = 0; i < numOfRefs; i++) {
			// pick a random instance from free instances
			int index = random.nextInt(freeMEs.size());
			EObject referencedInstance = freeMEs.get(index);
			referencedInstances.add((UnicaseModelElement) referencedInstance);
			freeMEs.remove(referencedInstance);
		}
		ls.getModelElements().addAll(referencedInstances);

	}

	/**
	 * This creates an instance of given class, initializes its simple attributes, and adds it to hash-tables keeping
	 * track of instances. In some situations (such as distributeMEsOnLeafSection()) we don't want a Section to be
	 * created. noSection parameter takes care of it.
	 * 
	 * @param eClass
	 * @param noSection
	 * @return
	 */
	private EObject createInstance(EClass eClass, boolean noSection) {
		EObject obj = null;

		if (!(eClass.isAbstract() || eClass.isInterface())) {
			obj = eClass.getEPackage().getEFactoryInstance().create(eClass);

		} else if (eClass.equals(MODELELEMENT_ECLASS)) {
			// special case; we need just some ModelElement, whatever.
			// for performance reason, this case is implemented in its own
			// method. Otherwise it could be handled with next the case
			obj = createSomeModelElment(noSection);
		} else {

			// if instanceClass is abstract, find one of its non abstract
			// subclasses,
			// pick one them randomly and instantiate it
			List<EClass> subClazz = getNonAbstractSubClassesOf(eClass);
			int index = random.nextInt(subClazz.size());
			EClass subClass = subClazz.get(index);
			EPackage ePackage = subClass.getEPackage();
			EFactory factory = ePackage.getEFactoryInstance();
			obj = factory.create(subClass);

		}
		if (obj != null) {
			initializeSimpleAttributes(obj);
			keepTrackOf(eClass, obj);
		}

		return obj;
	}

	/**
	 * special case for createInstance(). it works faster
	 */
	private EObject createSomeModelElment(boolean noSection) {
		EObject me;
		int index = random.nextInt(meNonAbstractClasses.size());
		EClass eClass = meNonAbstractClasses.get(index);

		// if noSection and eClass is a Section, pick another Class
		while (noSection && SECTION_ECLASS.isSuperTypeOf(eClass)) {
			index = random.nextInt(meNonAbstractClasses.size());
			eClass = meNonAbstractClasses.get(index);
		}

		me = eClass.getEPackage().getEFactoryInstance().create(eClass);
		return me;
	}

	/**
	 * Initialize simple attributes.
	 * 
	 * @param instance
	 */
	// BEGIN COMPLEX CODE
	private void initializeSimpleAttributes(EObject instance) {

		for (EAttribute attribute : instance.eClass().getEAllAttributes()) {

			if (attribute.getEType().getInstanceClass().equals(String.class) && attribute.isChangeable()) {
				if (instance instanceof ModelElement && attribute.getName().equalsIgnoreCase("name")) {
					// special case for name attribute of model elements
					UnicaseModelElement modelElement = (UnicaseModelElement) instance;
					modelElement.setName(instance.eClass().getName() + ":" + random.nextInt(20000));
					continue;
				} else if (instance instanceof IdentifiableElement
					&& attribute.getName().equalsIgnoreCase("identifier")) {
					// special case for identifier attribute
					// do nothing
					continue;
				} else if (instance instanceof MEDiagram
					&& attribute.equals(DiagramPackage.eINSTANCE.getMEDiagram_DiagramLayout())) {
					continue;
				}

				// in any other case create a random text
				// FIXME ZH, JH: description is not shown. StackOverflow, NullPointer
				instance.eSet(attribute, getRandomText(instance.eClass().getName()));
				// getRandomText("some text");
				continue;
			}

			if (attribute.getEType().getInstanceClass().equals(boolean.class)) {
				instance.eSet(attribute, getRandomBoolan());
				continue;
			}
			if (attribute.getEType().getInstanceClass().equals(int.class)) {
				instance.eSet(attribute, random.nextInt());
				continue;
			}
			if (attribute.getEType().getInstanceClass().equals(Date.class)) {
				instance.eSet(attribute, getRandomDate());
				continue;
			}
			if (attribute.getEType() instanceof EEnum) {
				if (attribute.equals(DiagramPackage.eINSTANCE.getMEDiagram_Type())) {
					DiagramType diagramType = getRandomDiagramType();
					instance.eSet(attribute, diagramType);
					continue;
				}
				EEnum en = (EEnum) attribute.getEType();
				int numOfLiterals = en.getELiterals().size();
				int index = numOfLiterals == 1 ? 0 : random.nextInt(numOfLiterals - 1);
				EEnumLiteral value = en.getELiterals().get(index);
				instance.eSet(attribute, value.getInstance());

				continue;
			}

		}
	}

	// END COMPLEX CODE

	/**
	 * @return
	 */
	private DiagramType getRandomDiagramType() {
		int value = random.nextInt(10);
		switch (value) {
		case 0:
			return DiagramType.ACTIVITY_DIAGRAM;
		case 1:
			return DiagramType.STATE_DIAGRAM;
		case 2:
		case 3:
		case 4:
			return DiagramType.USECASE_DIAGRAM;
		case 5:
		case 6:
		case 7:
		case 8:
		case 9:
			return DiagramType.CLASS_DIAGRAM;
		default:
			return DiagramType.CLASS_DIAGRAM;
		}
	}

	// returns non-abstract sub-Classes of an abstract super-class
	private List<EClass> getNonAbstractSubClassesOf(EClass superClass) {
		List<EClass> result = new ArrayList<EClass>();
		List<EClass> todo;
		// check whether it's a ME or non-ME
		if (MODELELEMENT_ECLASS.isSuperTypeOf(superClass)) {
			todo = meNonAbstractClasses;
		} else {
			todo = nonMEnonAbstractClasses;
		}

		for (EClass eClass : todo) {
			if (superClass.isSuperTypeOf(eClass)) {
				result.add(eClass);
			}
		}

		return result;

	}

	private String getRandomText(String start) {
		int length = random.nextInt(MAX_NUM_OF_WORDS);
		StringBuffer buffer = new StringBuffer(start);
		for (int i = 0; i < length; i++) {
			int index = random.nextInt(WORDS.length);
			buffer.append(" " + WORDS[index]);
		}

		return buffer.toString();
	}

	private boolean getRandomBoolan() {

		return random.nextBoolean();
	}

	private Date getRandomDate() {
		return new Date();
	}

	// /**
	// * . Opens some model elements randomly.
	// *
	// * @param count number of model elements to be opened.
	// */
	// public void openSomeModelElements(int count) {
	// List<EObject> modelElements = new ArrayList<EObject>();
	// modelElements.addAll(getAllInstancesOf(MODELELEMENT_ECLASS));
	// int index;
	// for (int i = 0; i < count; i++) {
	// index = random.nextInt(modelElements.size());
	// EObject me = modelElements.get(index);
	// openME((ModelElement) me);
	// modelElements.remove(index);
	// }
	// }

	// private void openME(ModelElement me) {
	// MEEditorInput input = new MEEditorInput(me);
	// try {
	// PlatformUI.getWorkbench().getActiveWorkbenchWindow().getActivePage().openEditor(input, MEEditor.ID, true);
	// } catch (PartInitException e) {
	// // ZH: exception handling
	// e.printStackTrace();
	// }
	//
	// }

	/**
	 * Return the number of Model Elements that have been generated.
	 * 
	 * @return total count of model elements
	 */
	public int getMECount() {
		int totalCount = 0;
		for (EClass currentClass : meInstancesByClass.keySet()) {
			totalCount += meInstancesByClass.get(currentClass).size();
		}
		return totalCount;
	}

	/**
	 * . Generates a test project and adds it to workspace.
	 * 
	 * @param currentWorkspace Workspace
	 */
	public void generateProjectIntoWorkspace(final Workspace currentWorkspace) {
		Project generatedProject = generateProject();
		addProjectToWorkspace(currentWorkspace, generatedProject);
	}

}
