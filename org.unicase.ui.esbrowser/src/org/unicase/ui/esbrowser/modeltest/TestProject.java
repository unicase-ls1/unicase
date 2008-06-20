/**
 * <copyright> Copyright (c) 2008 Jonas Helming, Maximilian Kšgel. All rights reserved. This program and the accompanying materials are made available under the terms of the Eclipse Public License v1.0 which accompanies this distribution, and is available at http://www.eclipse.org/legal/epl-v10.html
 * </copyright>
 *
 * $Id$
 */
package org.unicase.ui.esbrowser.modeltest;

import java.util.ArrayList;
import java.util.Date;
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
import org.eclipse.emf.transaction.RecordingCommand;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.unicase.emfstore.esmodel.EsmodelFactory;
import org.unicase.emfstore.esmodel.changemanagment.ChangemanagmentFactory;
import org.unicase.emfstore.esmodel.changemanagment.PrimaryVersionSpec;
import org.unicase.model.ModelElement;
import org.unicase.model.ModelElementId;
import org.unicase.model.ModelFactory;
import org.unicase.model.ModelPackage;
import org.unicase.model.Project;
import org.unicase.model.document.CompositeSection;
import org.unicase.model.document.DocumentFactory;
import org.unicase.model.document.DocumentPackage;
import org.unicase.model.document.LeafSection;
import org.unicase.model.document.Section;
import org.unicase.model.task.TaskPackage;
import org.unicase.workspace.ProjectSpace;
import org.unicase.workspace.Workspace;
import org.unicase.workspace.WorkspaceFactory;
import org.unicase.workspace.WorkspaceManager;

public class TestProject {

	private static final String TRANSACTIONAL_EDITINGDOMAIN_ID = "org.unicase.EditingDomain";
	

	private int numOfEachME = 20;
	private int randomSeed = 3;
	private int projectWidth = 3;
	private int projectDepth = 3;
	private static final int MAX_NUM_OF_MANY_REFS = 6;
	private static final int MAX_NUM_OF_ELEMENTS_IN_LEAFSECTION = 25;
	private static final String[] WORDS = {"hello", "cat", "mouse", "sun", "moon", "network", "watch", "rain", "kid", "repair", "bug", "rainbow"};
	private static final int MAX_NUM_OF_WORDS = 50;
	
	private Random random = new Random(randomSeed);
	
	private Project project;
	private EList<EObject> nonMEInstances = new BasicEList<EObject>();
	
	
	//constructor: set test project parameters
	public TestProject(int numOfEachME, int randomSeed, int projWidth, int porjDepth){
		this.numOfEachME= numOfEachME;
		this.randomSeed= randomSeed;
		this.projectWidth = projWidth;
		this.projectDepth = porjDepth;

	}
	
	public  void createProject() {
		// 1.get workspace
		// 2.create new project
		// 3.create new projectSpace
		// 4.projectSpace.addProject(project)
		// 5.workspace.getProjectSpaces.add(projectSpace)

		final Workspace workspace = WorkspaceManager.getInstance()
				.getCurrentWorkspace();

		// ******************************
		createTestProject();
		// ******************************

		final ProjectSpace projectSpace = WorkspaceFactory.eINSTANCE
				.createProjectSpace();
		projectSpace.setProject(project);
		PrimaryVersionSpec primaryVersionSpec = ChangemanagmentFactory.eINSTANCE
				.createPrimaryVersionSpec();
		primaryVersionSpec.setIdentifier(999999);
		projectSpace.setBaseVersion(primaryVersionSpec);
		projectSpace.setLastUpdated(new Date());
		projectSpace.setProjectDescription("descriptopm");
		projectSpace.setProjectName("ModelTestProject");
		projectSpace.setProjectId(EsmodelFactory.eINSTANCE.createProjectId());

		TransactionalEditingDomain domain = TransactionalEditingDomain.Registry.INSTANCE
				.getEditingDomain(TRANSACTIONAL_EDITINGDOMAIN_ID);
		domain.getCommandStack().execute(new RecordingCommand(domain) {
			@Override
			protected void doExecute() {
				workspace.getProjectSpaces().add(projectSpace);
			}
		});

	}

	private  void createTestProject() {

		// THIS WILL BE IMPLEMENTED!
		// 0.create document structure
		// 1.create raw instance of minimum number 
		//   1.1. all the simple attributes will be set
		//	 1.2. the created instances are added to project
		
		
		//(and distribute them randomly on LeafSections)
		// 2.initialize their references:
		// 2.1. take a random number for references.
		// 2.2. if project contains this number of instances of the 
		//      referenced type, pick'em randomly from project
		//		else create the lacking number of instances
		// 3.initialize simple attribute of all instances in project
		// Attention: distribution of elements on LeafSections
		//			  is done during their creation.
		
		
		this.project = ModelFactory.eINSTANCE.createProject();

		//create document structure
		int depth = projectDepth - 2;
		for (int i = 0; i < projectWidth; i++) {
			CompositeSection comp = (CompositeSection)createInstance(DocumentPackage.eINSTANCE.getCompositeSection());
			createDocStructure(depth, comp);
			project.addModelElement(comp);
		}
		
		//create the minimum number of each EClass in model package
		//initialize the simple attributes
		//add them to project (if instanceof model element) or to list of non-MEInstances
		createMinimumNumOfInstances();
		
		//set references
		createReferences();
		
		
		EList<EObject> list = project.getAllInstancesByClass(TaskPackage.eINSTANCE.getActionItem());
		EList<EObject> leafSections = project.getAllInstancesByClass(DocumentPackage.eINSTANCE.getLeafSection());
//		for (EObject ls : leafSections){
//			distributeMEsOnLeafSection2((LeafSection)ls);
//		}
		Object obj = new Object();

//		

	}
	
	
	private void distributeMEsOnLeafSection2(LeafSection ls) {
		int numOfRefs = MAX_NUM_OF_ELEMENTS_IN_LEAFSECTION;
		
		List<ModelElement> allMEs = new ArrayList<ModelElement>();
		List<ModelElement> freeMEs = new ArrayList<ModelElement>();
		
		allMEs = project.getAllModelElements();
		
		
		for (ModelElement me : allMEs){
			if (!(me instanceof Section)
			    && (me.eContainer() == null ||
				me.eContainer().equals(project))){
				
				freeMEs.add(me);
			}
		}
				
		List<ModelElement> referencedInstances = new ArrayList<ModelElement>();
		
//		if(freeMEs.size() < numOfRefs){
//			int lackingFreeInstances = numOfRefs - freeMEs.size();
//			for(int i = 0; i < lackingFreeInstances; i++){
//				 EObject obj;
//				while(!(( obj = createInstance(ModelPackage.eINSTANCE.getModelElement())) instanceof Section)){
//					freeMEs.add((ModelElement)obj);
//				}
//			}
//		}
			
		for(int i = 0 ; i < freeMEs.size(); i++){
			//pick a random instance from free instances
			int index = random.nextInt(freeMEs.size());
			ModelElement referencedInstance = freeMEs.get(index);
			referencedInstances.add(referencedInstance);
			freeMEs.remove(referencedInstance);
		}
		ls.getModelElements().addAll(referencedInstances);
		
		
	}

	//recursively create the subsections (Composite and LeafSections)
	//under a Composite section (based of projectWidth and projectDepth)
	private  void createDocStructure(int remainingDepth, CompositeSection comp) {

		if (remainingDepth > 0) {
			//create CompositeSections
			for (int i = 0; i < projectWidth; i++) {
					CompositeSection newComp = (CompositeSection)createInstance(DocumentPackage.eINSTANCE.getCompositeSection());
					comp.getSubsections().add(newComp);
					createDocStructure(--remainingDepth, newComp);
			}
		}else {
			//remainingDepth == 0; create LeafSections
			for (int i = 0; i < projectWidth; i++) {
				LeafSection ls = (LeafSection)createInstance(DocumentPackage.eINSTANCE.getLeafSection());
				comp.getSubsections().add(ls);
			}
		}
	}

	//create minimum number of instances of all EClasses 
	//contained in Model Package
	private  void createMinimumNumOfInstances() {
		initilizePackage(ModelPackage.eINSTANCE);
	}

	//this goes through EClasses contained in a package, 
	//and creates minimum number instances of these classes
	//for sub-packages also recursively
	private  void initilizePackage(EPackage ePackage) {
	
		for (EObject eObject : ePackage.eContents()) {
			if (eObject instanceof EClass) {
				EClass eClass = (EClass) eObject;
				if (!(eClass.isAbstract() || 
					  eClass.isInterface() || 
					  eClass.equals(ModelPackage.eINSTANCE.getProject()) ||
					  DocumentPackage.eINSTANCE.getSection().isSuperTypeOf(eClass) )) {
					
					createInstances(eClass);
					
				}
			} else if (eObject instanceof EPackage) {
				//the classes of Document package should not be instantiated 
				//again. They are in createDocStructure instantiated and added
				//to project.
				EPackage eSubPackage = (EPackage) eObject;
				if(!eSubPackage.equals(DocumentFactory.eINSTANCE.getDocumentPackage())){
					initilizePackage(eSubPackage);
				}
			}
		}
	}

	//create the required number of instances of an EClass
	//initialize simple attributes
	//add them to project of list of non-ME instances
	private  void createInstances(EClass eClass) {
         if (eClass.equals(ModelPackage.eINSTANCE.getModelElementId())) {return;}
		// create the specified minimum number of instances of this EClass
		//initialize their simple attributes
		// add them to project, or list of non-ModelElement instances
		for(int i = 0; i < numOfEachME; i++){
		   EObject obj = eClass.getEPackage().getEFactoryInstance().create(eClass);
		   initializeSimpleAttributes(obj);
		   if (obj instanceof ModelElement){
			   ModelElement me = (ModelElement) obj;
			   ModelElementId  meId = ModelFactory.eINSTANCE.createModelElementId();
			   me.setIdentifier(meId);
			   project.addModelElement(me);
		   }else{
			   nonMEInstances.add(obj);
		   }
		}
	}

	
	private void createReferences() {
		for(ModelElement me : project.getAllModelElements()){
			initializeReferences(me);
		}
	}
	
	//this sets the references to other builds the associations
	private void initializeReferences(ModelElement me) {
						
		List<EReference> references = me.eClass().getEAllReferences();
		for(EReference ref : references){
			
			if(ref.isContainment())	{
				createContainmentRef(me, ref, ref.getLowerBound(), ref.getUpperBound());
			}else if(ref.isContainer()){
				//do nothing, the container references are automatically
				//set when the containment references are set.
				//i mean when you set a containment, it's opposite which is a 
				//container is also set.
				//createContainerRef(me, ref);
			}else{
				//reference is neither containment, nor container
				createNormalReference(me, ref,ref.getLowerBound(), ref.getUpperBound() );
			}
			
		}
		//check other cases 1.one-to-one, required; 2. one-to-one, not required; 
		//they are considered in createRefs methods. Using ref.upperBound and .lowerBound
	}


	private void createNormalReference(ModelElement me, EReference ref,
								int lowerBound, int upperBound) {
		
		List<EObject> instancesOfRefType = new ArrayList<EObject>();
		
		if(ModelPackage.eINSTANCE.getModelElement()
				.isSuperTypeOf(ref.getEReferenceType())){
			instancesOfRefType = project.getAllInstancesByClass(ref.getEReferenceType());
		}else{
			instancesOfRefType = getNonMEInstancesByClass(ref.getEReferenceType());
			
		}
		
		List<EObject> referencedInstances = new ArrayList<EObject>();
		
		int numOfRefs = MAX_NUM_OF_MANY_REFS;
		if (upperBound == ETypedElementImpl.UNBOUNDED_MULTIPLICITY ||
			upperBound >= MAX_NUM_OF_MANY_REFS){
		
			numOfRefs = lowerBound + random.nextInt(MAX_NUM_OF_MANY_REFS);
		}else{
			if(upperBound == ETypedElementImpl.UNSPECIFIED_MULTIPLICITY){
				numOfRefs = lowerBound;
			}else{
				numOfRefs = lowerBound + random.nextInt(upperBound);
			}
		}
		if (upperBound == lowerBound && lowerBound > 0){
			//this instance requires an exact number or references
			numOfRefs = lowerBound;
		}
		
		if(DocumentPackage.eINSTANCE.getSection().isSuperTypeOf(ref.getEReferenceType())){
			numOfRefs = project.getAllInstancesByClass(DocumentPackage.eINSTANCE.getSection()).size();
			
		}else if(instancesOfRefType.size() < numOfRefs){
			int lackingInstances = numOfRefs - instancesOfRefType.size();
			for(int i = 0; i < lackingInstances; i++){
				EObject newInstance = createInstance(ref.getEReferenceType());
				instancesOfRefType.add(newInstance);
				if(newInstance instanceof ModelElement){
					project.addModelElement((ModelElement)newInstance);
				}else{
					nonMEInstances.add(newInstance);
				}
			}
			
		}
		
		
			
		for(int i = 0 ; i < numOfRefs; i++){
			//pick random instance of ref's type
			
		    int index = random.nextInt(instancesOfRefType.size());
			EObject referencedInstance = instancesOfRefType.get(index);
			referencedInstances.add(referencedInstance);
			instancesOfRefType.remove(referencedInstance);
		}
		if(ref.isMany()){
			me.eSet(ref, referencedInstances);
		}else if (referencedInstances.size() != 0){
			me.eSet(ref, referencedInstances.get(0));
		}else{
			me.eSet(ref, null);
		}
	}

	/*
	private void createContainerRef(ModelElement me, EReference ref) {
		
		List<EObject> instancesOfRefType = new ArrayList<EObject>();
		if(me instanceof Section && ref.getName().equals("leafSection")){
			return;
		}
		if(me instanceof Section && ref.getName().equals("parent")){
			return;
		}
		if(ModelPackage.eINSTANCE.getModelElement()
				.isSuperTypeOf(ref.getEReferenceType())){
			instancesOfRefType = project.getAllInstancesByClass(ref.getEReferenceType());
		}else{
			instancesOfRefType = getNonMEInstancesByClass(ref.getEReferenceType());
			
		}
		//a container reference cannot have upperBound > 1
		//pick randomly an instance from containers collectoin
		int index = random.nextInt(instancesOfRefType.size());
		int count = 0;
		while(me.equals(instancesOfRefType.get(index))){
			index = random.nextInt(instancesOfRefType.size());
			//I don't know why, but i got an endless loop!
			count ++;
			if (count > 100) {return;}
		}
		if( EcoreUtil.isAncestor(me, instancesOfRefType.get(index))){
			for(EObject obj : instancesOfRefType){
				if (!EcoreUtil.isAncestor(me, obj)){
					me.eSet(ref, obj);
					return;
				}
			}
		}else{
			me.eSet(ref, instancesOfRefType.get(index) );
		}
			
	}
	*/
	
	private void createContainmentRef(ModelElement me, EReference ref, int lowerBound,
										int upperBound) {
		
		if(ref.getEReferenceType().equals(ModelPackage.eINSTANCE.getModelElementId())){
			//for all created instances the model elment id is 
			//during creation set.
			return;
		}
		if(me instanceof Section && ref.getName().equals("subsections")) { 
			//subsections are set during building of document structure
			return;
		}
		
		if(me instanceof LeafSection && ref.getName().equals("modelElements")){
			distributeMEsOnLeafSection((LeafSection)me);
			return;
		}		
			
		List<EObject> allInstancesOfRefType = new ArrayList<EObject>();
		List<EObject> freeInstancesOfRefType = new ArrayList<EObject>();
		
		if(ModelPackage.eINSTANCE.getModelElement()
				.isSuperTypeOf(ref.getEReferenceType())){
			allInstancesOfRefType = project.getAllInstancesByClass(ref.getEReferenceType());
		}else{
			allInstancesOfRefType = getNonMEInstancesByClass(ref.getEReferenceType());
			
		}
		
		for (EObject obj : allInstancesOfRefType){
			if (obj.eContainer() == null ||
				 obj.eContainer().equals(project)){
				
				freeInstancesOfRefType.add(obj);
			}
		}
				
		List<EObject> referencedInstances = new ArrayList<EObject>();
		
		int numOfRefs = MAX_NUM_OF_MANY_REFS;
		if (upperBound == ETypedElementImpl.UNBOUNDED_MULTIPLICITY ||
			upperBound >= MAX_NUM_OF_MANY_REFS){
		
			numOfRefs = lowerBound + random.nextInt(MAX_NUM_OF_MANY_REFS);
		}else{
			if(upperBound == ETypedElementImpl.UNSPECIFIED_MULTIPLICITY){
				numOfRefs = lowerBound;
			}else{
				numOfRefs = lowerBound + random.nextInt(upperBound);
			}
		}
		
		if (upperBound == lowerBound && lowerBound > 0){
			//this instance requires an exact number or references
			numOfRefs = lowerBound;
		}
		
		if(freeInstancesOfRefType.size() < numOfRefs){
			int lackingFreeInstances = numOfRefs - freeInstancesOfRefType.size();
			for(int i = 0; i < lackingFreeInstances; i++){
				//for "modelElements" reference of LeafSection see checking above 
				freeInstancesOfRefType.add(createInstance(ref.getEReferenceType()));
			}
		}
			
		for(int i = 0 ; i < numOfRefs; i++){
			//pick random instance of ref's type from free instances
			int index = random.nextInt(freeInstancesOfRefType.size());
			EObject referencedInstance = freeInstancesOfRefType.get(index);
			referencedInstances.add(referencedInstance);
			freeInstancesOfRefType.remove(referencedInstance);
		}
		if(ref.isMany()){
			me.eSet(ref, referencedInstances);
		}else if (referencedInstances.size() != 0){
			me.eSet(ref, referencedInstances.get(0));
		}else{
			me.eSet(ref, null);
		}
		
		  				   
	}
		
	private void distributeMEsOnLeafSection(LeafSection ls){
		int numOfRefs = MAX_NUM_OF_ELEMENTS_IN_LEAFSECTION;
		
		List<ModelElement> allMEs = new ArrayList<ModelElement>();
		List<ModelElement> freeMEs = new ArrayList<ModelElement>();
		
		allMEs = project.getAllModelElements();
		
		
		for (ModelElement me : allMEs){
			if (!(me instanceof Section)
			    && (me.eContainer() == null ||
				me.eContainer().equals(project))){
				
				freeMEs.add(me);
			}
		}
				
		List<ModelElement> referencedInstances = new ArrayList<ModelElement>();
		
		if(freeMEs.size() < numOfRefs){
			int lackingFreeInstances = numOfRefs - freeMEs.size();
			for(int i = 0; i < lackingFreeInstances; i++){
				EObject obj;
				while(!(( obj = createInstance(ModelPackage.eINSTANCE.getModelElement())) instanceof Section)){
					freeMEs.add((ModelElement)obj);
				}
			}
		}
			
		for(int i = 0 ; i < numOfRefs; i++){
			//pick a random instance from free instances
			int index = random.nextInt(freeMEs.size());
			ModelElement referencedInstance = freeMEs.get(index);
			referencedInstances.add(referencedInstance);
			freeMEs.remove(referencedInstance);
		}
		ls.getModelElements().addAll(referencedInstances);
		
	}


	private List<EObject> getNonMEInstancesByClass(EClass instanceClass) {
		
		List<EObject> result = new ArrayList<EObject>();
		for(EObject obj : nonMEInstances){
			if(instanceClass.isInstance(obj)){
				result.add(obj);
			}
		}
		return result;
	}

	//this creates an instance of given class, and initializes
	//its simple attributes.
	//this method will be called when an object needs an instance for it's containment
	//reference
	private EObject createInstance(EClass instanceClass){
		EObject obj = null;
		if(!(instanceClass.isAbstract() || instanceClass.isInterface())){
		  obj = instanceClass.getEPackage().getEFactoryInstance().create(instanceClass);
		  if(!ModelPackage.eINSTANCE.getModelElement()
				  .isSuperTypeOf(instanceClass)){
			  nonMEInstances.add(obj);
		  }
		}else{
			//if instanceClass is abstract, find one of its subclasses in this package
			//if instanceClass is model element, return some instance of model element
			//sub classes
			List<EClass> subClazz = getNonAbstractSubClassOf(instanceClass);
			int index = random.nextInt(subClazz.size());
			EClass subClass = subClazz.get(index);
			EPackage ePackage = subClass.getEPackage();
			EFactory factory = ePackage.getEFactoryInstance();
			obj = factory.create(subClass);

		}
		if (obj != null){
			initializeSimpleAttributes(obj);
		}
		
	  return obj;
	}
	
	
	//the simplest of all....
	private void initializeSimpleAttributes(EObject instance){
		
		for (EAttribute attribute : instance.eClass().getEAllAttributes()) {
		
			if (attribute.getEType().getInstanceClass().equals(String.class)) {
				if (instance instanceof  ModelElement &&
					attribute.getName().equalsIgnoreCase("name")){
					
					((ModelElement)instance)
					     .setName(instance.eClass()
					    		 .getName() + ":" + random.nextInt(20000) );
				}else {
					// create a random text
					instance.eSet(attribute, getRandomText(instance.eClass().getName()));
				}
				
			}
			if (attribute.getEType().getInstanceClass().equals(boolean.class)) {
				instance.eSet(attribute,getRandomBoolan());
			}
			if (attribute.getEType().getInstanceClass().equals(int.class)) {
				instance.eSet(attribute, random.nextInt());
			}
			if (attribute.getEType().getInstanceClass().equals(Date.class)) {
				instance.eSet(attribute, getRandomDate());
			}
			if (attribute.getEType().getInstanceClass().equals(EEnum.class)) {
				EEnum en = (EEnum) attribute;
				int index = random.nextInt(en.getELiterals().size());
				EEnumLiteral value = en.getELiterals().get(index);
				instance.eSet(attribute, value);
			}
			

		}
	}

	
	private List<EClass> getNonAbstractSubClassOf(EClass superClass){
		List<EClass> result = new ArrayList<EClass>();
		List<EObject> todo = new ArrayList<EObject>();
		todo.addAll(ModelPackage.eINSTANCE.eContents());
		
		while(!todo.isEmpty() ){
			Object obj = todo.iterator().next();
			if (obj instanceof EClass ){
				EClass subClass = (EClass) obj;
				if(superClass.isSuperTypeOf(subClass) &&
				   !(subClass.isAbstract() || subClass.isInterface())){
				
					result.add(subClass);
				}
			}else if(obj instanceof EPackage){
				todo.addAll(((EPackage) obj).eContents());
			}
		    todo.remove(obj);
		}
		
		
		return result;
		
	}
	
	
	
	private String getRandomText(String start){
		int length = random.nextInt(MAX_NUM_OF_WORDS);
		StringBuffer buffer = new StringBuffer(start);
		for (int i = 0; i < length; i++){
			int index = random.nextInt(WORDS.length);
			buffer.append(" " + WORDS[index]);
		}
		
		return buffer.toString();
	}
	
	private boolean getRandomBoolan(){
		
		return random.nextBoolean();
	}
	
	private Date getRandomDate(){
		return  new Date();
	}
}

//container, containment, isMany, one-to-one, required










//private  void createTestProject() {
//
//	// THIS WILL BE IMPLEMENTED!
//	// 0.create document structure
//	// 1.create raw instance of minimum number (and distribute them randomly on LeafSections)
//	// 2.initialize their references:
//	// 2.1. take a random number for references.
//	// 2.2. if project contains this number of instances of the 
//	//      referenced type, pick'em randomly from project
//	//		else create the lacking number of instances
//	// 3.initialize simple attribute of all instances in project
//	// Attention: distribution of elements on LeafSections
//	//			  is done during their creation.
//	
//	
//	
//	
//	//instantiate project
//	this.project = ModelFactory.eINSTANCE.createProject();
//		
//	//create document structure
//	int depth = projectDepth - 2;
//	for (int i = 0; i < projectWidth; i++) {
//		CompositeSection comp = DocumentFactory.eINSTANCE.createCompositeSection();
//		createDocStructure(depth, comp);
//		project.addModelElement(comp);
//	}
//	//
//	//leafSections = (ArrayList<ModelElement>)project.getElementsByClass(LeafSection.class);
//	//			  I need a list of LeafSections in the project, 
//	//			  to distribute the elements in them.
//	//???????     project.getModelElements() returns only 
//	//???????     the MEs which are directly added to project.
//	//			  in this case, it would return me only 4 CompositeSections
//	//			  and not their contents.
//	//			  Accordingly project.getElementsByClass(LeafSection.Class)
//	//			  returns null, because there's no LeafSection directly
//	//			  added to project.
//	
//	//create raw instances of all classes contained in Model package
//	createRawInstances();
//	
//	//set references
//	
//	
//	//does not returen all the MEs contained in the project
//	//for(ModelElement me : project.getModelElements()){
//	//	initializeReferences(me);
//	//}
//	//Alternative
//	for(LeafSection ls : leafSections){
//		//for(ModelElement me : ls.getModelElements()){
//		//	initializeReferences(me);
//		//}
//		
//	
//		//		 in the out commented code above, I get this exception.
//		//		 but I cannot determine who else changes list of ME in a
//		//		 LeafSection.
//		for(int i = 0; i < ls.getModelElements().size(); i ++){
//			initializeReferences(ls.getModelElements().get(i));
//		}
//	}
//		
//	
//	//set simple attributes
//	//why set simple attributes after setting references? 
//	//because setting references may create new uninitialized MEs in project.		
//	// 
//	//  	settin attributes after setting references doese'nt funtion
//	//		correctly, i.e. all the elements in project do not become
//	// 		initialized (with their simple atts).
//	//		This is because Containment. The referenced objects, 
//	//		cannot be seen any more in list of LeafSection.ModelElements
//	//		or something else is the reason?????
//	for(LeafSection ls : leafSections){
//		for(ModelElement me : ls.getModelElements()){
//			initializeSimpleAttributes(me);
//		}
//	}
//}
//
//
////recursively create the subsections (Composite and LeafSections)
////under a Composite section (based of projectWidth and projectDepth)
//private  void createDocStructure(int remainingDepth, CompositeSection comp) {
//
//	if (remainingDepth > 0) {
//		//create CompositeSections
//		for (int i = 0; i < projectWidth; i++) {
//				CompositeSection newComp = DocumentFactory.eINSTANCE.createCompositeSection();
//				//QUESTION:
//				// project.getModelElements() returns only the MEs, 
//				// which are directly added to project.modelElements collection.
//				
//				// IS IT CORRECT????? 
//				project.addModelElement(newComp);
//									
//				comp.getSubsections().add(newComp );
//				createDocStructure(--remainingDepth, newComp);
//		}
//	}else {
//		//remainingDepth == 0; create LeafSections
//		for (int i = 0; i < projectWidth; i++) {
//			LeafSection ls = DocumentFactory.eINSTANCE.createLeafSection();
//			
//			//IS IT CORRECT????? 
//			project.addModelElement(ls);
//			//i have to do it, because i need a list of all 
//			//LeafSections in the project and 
//			leafSections.add(ls);
//			comp.getSubsections().add(ls);
//		}
//	}
//}
//
////create minimum number of raw instances of all EClasses 
////contained in Model Package
//private  void createRawInstances() {
//	initilizePackage(ModelPackage.eINSTANCE);
//}
//
////this goes through EClasses contained in a package, 
////and creates raw instances of these classes
////for sub-packages also recursively
//private  void initilizePackage(EPackage ePackage) {
//
//	for (EObject eObject : ePackage.eContents()) {
//		if (eObject instanceof EClass) {
//			EClass eClass = (EClass) eObject;
//			if (!(eClass.isAbstract() || 
//				  eClass.isInterface() || 
//				  eClass.equals(ModelPackage.eINSTANCE.getProject()))) {
//				
//				createRawInstances(eClass);
//				
//			}
//		} else if (eObject instanceof EPackage) {
//			//the classes of Document package should not be instantiated 
//			//again. They are in createDocStructure instantiated and added
//			//to project.
//			EPackage eSubPackage = (EPackage) eObject;
//			if(!eSubPackage.equals(DocumentFactory.eINSTANCE.getDocumentPackage())){
//				initilizePackage(eSubPackage);
//			}
//		}
//	}
//}
//
////create the minimum number of raw instances of an EClass
//private  void createRawInstances(EClass eClass) {
//
//	// create the specified minimum number of raw instances of this EClass
//	// add them to project.
//
//	int index;
//	for(int i = 0; i < numOfEachME; i++){
//		EObject obj = eClass.getEPackage().getEFactoryInstance().create(eClass);
//	   if (obj instanceof ModelElement){
//		   ModelElement me = (ModelElement) obj;
//		   //
//		   //project.addModelElement(me);
//		   index = random.nextInt(numOfLeafSections);
//		   leafSections.get(index).getModelElements().add(me);
//	   }else{
//		   
//		   //project.addModelElement(obj);
//		   nonMEInstances.add(obj);
//	   }
//		
//		
//	}
//	
//}
//
//
////this sets the references to other types
//private void initializeReferences(ModelElement me) {
//	//* For references that are 0..*, the number of references is
//	//  determined by a random number.
//	//  if project contains this number of target type, 
//	//  then they are picked randomly. Otherwise the lacking instances 
//	//  are instantiated and initialized (only references that are 
//	//  one to one and not nullable) and added to project.
//	//* For references that are 0..1, a random boolean determines if 
//	//  the reference should be set. If it is to be set, then a random 
//	//  instance is picked from instances of target type in project.
//	//* For references that are 1..1, a random instance of the target
//	//  type is picked from existing instances in the project.
//			
//	List<EReference> references = me.eClass().getEAllReferences();
//	for(EReference ref : references){
//		
//		if (!ref.isRequired() && ref.isMany()){
//			//set a random number of this ref
//			List<EObject> allInstancesOfRefType = new ArrayList<EObject>();
//			if(ref.getEReferenceType().isAbstract() || ref.getEReferenceType().isInterface()){
//				allInstancesOfRefType = getElementsOfSubClassesOfType(ref.getEReferenceType());
//			}else{
//				allInstancesOfRefType = getElementsOfType(ref.getEReferenceType());
//			}
//			
//			List<EObject> referencedInstances = new ArrayList<EObject>();
//			int numOfRefs = random.nextInt(MAX_NUM_OF_MANY_REFS);
//			//here must be checked if minimum number of each ME
//			//in the project is greater or equal max_num_of_many_refs.
//			//if not, the lacking instances should be created and added
//			//to project
//			for(int i = 0 ; i < numOfRefs; i++){
//				//pick random instance of ref's type
//			    //
//				//       although there are at least the minimum number of 
//				//		 instances in project!!
//				if (allInstancesOfRefType.size() != 0) {
//			    	int index = random.nextInt(allInstancesOfRefType.size());
//					EObject referencedInstance = allInstancesOfRefType.get(index);
//					
//					referencedInstances.add(referencedInstance);
//			   }
//			   
////				if (ref.isContainment() &&
////					!referencedInstance.eContainer().equals(project)){
////					
////				}
//			}
//			
//			me.eSet(ref, referencedInstances);
//		}
//	}
//	//check other cases 1.one-to-one, required; 2. one-to-one, not required; 
//}
//
//
////returns all instances of this type in the project. 
//private List<EObject> getElementsOfType(EClass referenceType) {
//	List<EObject> ret = new ArrayList<EObject>();
//	
//	if (referenceType.getEAllSuperTypes().contains(ModelPackage.eINSTANCE.getModelElement())){
//		for(LeafSection ls : leafSections){
//			for(ModelElement me : ls.getModelElements()){
//				if (me.eClass().equals(referenceType)){
//					ret.add(me);
//				}
//			}
//		}
//		return ret;
//	}else {
//		for(EObject obj : nonMEInstances){
//			if (obj.eClass().equals(referenceType)){
//				ret.add(obj);
//			}
//		}
//	
//	return ret;
//	}
//	
//	
//}
//
////returns all instances of subclasses of this type
////this will be called when the type itself is abstract (e.g. ModelElement or WorkItem)
//private List<EObject> getElementsOfSubClassesOfType(EClass referenceType){
//	List<EObject> ret = new ArrayList<EObject>();
//	
//	if (referenceType.equals(ModelPackage.eINSTANCE.getModelElement())
//	   || referenceType.getEAllSuperTypes().contains(ModelPackage.eINSTANCE.getModelElement())){
//		for(LeafSection ls : leafSections){
//			for(ModelElement me : ls.getModelElements()){
//				//if (me.eClass().equals(referenceType)){
//				if (referenceType.isInstance(me)){
//					ret.add(me);
//				}
//			}
//		}
//		return ret;
//	}else {
//		for(EObject obj : nonMEInstances){
//			if (obj.eClass().getEAllSuperTypes().contains(referenceType)){
//				ret.add(obj);
//			}
//		}
//	
//	return ret;
//	}
//	
//}
//
////the simplest of all....
//private void initializeSimpleAttributes(ModelElement me){
//	
//	for (EAttribute attribute : me.eClass().getEAllAttributes()) {
//	
//		if (attribute.getEType().getInstanceClass().equals(String.class)) {
//			if (attribute.getName().equalsIgnoreCase("name")){
//				me.setName(me.eClass().getName() + ":" + random.nextInt(20000) );
//			}else {
//				// create a random text
//				me.eSet(attribute, getRandomText(me.eClass().getName()));
//			}
//			
//		}
//		if (attribute.getEType().getInstanceClass().equals(boolean.class)) {
//			me.eSet(attribute,getRandomBoolan());
//		}
//		if (attribute.getEType().getInstanceClass().equals(int.class)) {
//			me.eSet(attribute, random.nextInt());
//		}
//		if (attribute.getEType().getInstanceClass().equals(Date.class)) {
//			me.eSet(attribute, getRandomDate());
//		}
//
//	}
//}
//
//
//private String getRandomText(String start){
//	int length = random.nextInt(MAX_NUM_OF_WORDS);
//	StringBuffer buffer = new StringBuffer(start);
//	for (int i = 0; i < length; i++){
//		int index = random.nextInt(WORDS.length);
//		buffer.append(" " + WORDS[index]);
//	}
//	
//	return buffer.toString();
//}
//
//private boolean getRandomBoolan(){
//	
//	return random.nextBoolean();
//}
//
//private Date getRandomDate(){
//	return  new Date();
//}
//}
