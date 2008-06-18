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

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.transaction.RecordingCommand;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.unicase.emfstore.esmodel.EsmodelFactory;
import org.unicase.emfstore.esmodel.changemanagment.ChangemanagmentFactory;
import org.unicase.emfstore.esmodel.changemanagment.PrimaryVersionSpec;
import org.unicase.model.ModelElement;
import org.unicase.model.ModelFactory;
import org.unicase.model.ModelPackage;
import org.unicase.model.Project;
import org.unicase.model.document.CompositeSection;
import org.unicase.model.document.DocumentFactory;
import org.unicase.model.document.LeafSection;
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
	private int numOfLeafSections;
	private static final int MAX_NUM_OF_MANY_REFS = 6;
	private static final String[] WORDS = {"hello", "cat", "mouse", "sun", "moon", "network", "watch", "rain", "kid", "repair", "bug", "rainbow"};
	private static final int MAX_NUM_OF_WORDS = 200;
	
	private Random random = new Random(randomSeed);
	
	private Project project;
	private ArrayList<LeafSection> leafSections = new ArrayList<LeafSection>();
	private ArrayList<EObject> nonMEInstances = new ArrayList<EObject>();
	
	
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
		// 1.create raw instance of minimum number (and distribute them randomly on LeafSections)
		// 2.initialize their references:
		// 2.1. take a random number for references.
		// 2.2. if project contains this number of instances of the 
		//      referenced type, pick'em randomly from project
		//		else create the lacking number of instances
		// 3.initialize simple attribute of all instances in project
		// Attention: distribution of elements on LeafSections
		//			  is done during their creation.
		
		
		
		
		//instantiate project
		this.project = ModelFactory.eINSTANCE.createProject();
		numOfLeafSections = (int)Math.pow(projectWidth, projectDepth);
		
		//create document structure
		int depth = projectDepth - 2;
		for (int i = 0; i < projectWidth; i++) {
			CompositeSection comp = DocumentFactory.eINSTANCE.createCompositeSection();
			createDocStructure(depth, comp);
			project.addModelElement(comp);
		}
		//FIXME:
		//leafSections = (ArrayList<ModelElement>)project.getElementsByClass(LeafSection.class);
		//			  I need a list of LeafSections in the project, 
		//			  to distribute the elements in them.
		//???????     project.getModelElements() returns only 
		//????????    the MEs which are directly added to project.
		//			  in this case, it would return me only 4 CompositeSections
		//			  and not their contents.
		//			  Accordingly project.getElementsByClass(LeafSection.Class)
		//			  returns null, because there's no LeafSection directly
		//			  added to project.
		
		//create raw instances of all calsses contained in Model package
		createRawInstances();
		
		//set references
		
		//FIXME: this dose'nt function, because project.getModelElements()
		//does not returen all the MEs contained in the project
		//for(ModelElement me : project.getModelElements()){
		//	initializeReferences(me);
		//}
		//Alternative
		for(LeafSection ls : leafSections){
			//for(ModelElement me : ls.getModelElements()){
			//	initializeReferences(me);
			//}
			
			//FIXME: the ConccourentModificationExecption by iterator.
			//		 in the out commented code above, I get this exception.
			//		 but I cannot determine who else changes list of ME in a
			//		 LeafSection.
			for(int i = 0; i < ls.getModelElements().size(); i ++){
				initializeReferences(ls.getModelElements().get(i));
			}
		}
			
		
		//set simple attributes
		//why set simple attributes after setting references? 
		//because setting references may create new uninitialized MEs in project.		
		//FIXME: 
		//  	settin attributes after setting references doese'nt funtion
		//		correctly, i.e. all the elements in project do not become
		// 		initialized (with their simple atts).
		//		This is because Containment. The referenced objects, 
		//		cannot be seen any more in list of LeafSection.ModelElements
		//		or something else is the reason?????
		for(LeafSection ls : leafSections){
			for(ModelElement me : ls.getModelElements()){
				initializeSimpleAttributes(me);
			}
		}
	}
	
	
	//recursively create the subsections (Composite and LeafSections)
	//under a Composite section (based of projectWidth and projectDepth)
	private  void createDocStructure(int remainingDepth, CompositeSection comp) {

		if (remainingDepth > 0) {
			//create CompositeSections
			for (int i = 0; i < projectWidth; i++) {
					CompositeSection newComp = DocumentFactory.eINSTANCE.createCompositeSection();
					//QUESTION:
					// project.getModelElements() returns only the MEs, 
					// which are directly added to project.modelElements collection.
					
					// IS IT CORRECT????? 
					//FIXME: even though it were correct, it does'nt function
					project.addModelElement(newComp);
										
					comp.getSubsections().add(newComp );
					createDocStructure(--remainingDepth, newComp);
			}
		}else {
			//remainingDepth == 0; create LeafSections
			for (int i = 0; i < projectWidth; i++) {
				LeafSection ls = DocumentFactory.eINSTANCE.createLeafSection();
				
				//IS IT CORRECT????? 
				project.addModelElement(ls);
				//i have to do it, because i need a list of all 
				//LeafSections in the project and 
				leafSections.add(ls);
				comp.getSubsections().add(ls);
			}
		}
	}

	//create minimum number of raw instances of all EClasses 
	//contained in Model Package
	private  void createRawInstances() {
		initilizePackage(ModelPackage.eINSTANCE);
	}

	//this goes through EClasses contained in a package, 
	//and creates raw instances of these classes
	//for sub-packages also recursively
	private  void initilizePackage(EPackage ePackage) {
	
		for (EObject eObject : ePackage.eContents()) {
			if (eObject instanceof EClass) {
				EClass eClass = (EClass) eObject;
				if (!(eClass.isAbstract() || 
					  eClass.isInterface() || 
					  eClass.equals(ModelPackage.eINSTANCE.getProject()))) {
					
					createRawInstances(eClass);
					
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

	//create the minimum number of raw instances of an EClass
	private  void createRawInstances(EClass eClass) {

		// create the specified minimum number of raw instances of this EClass
		// add them to project.
	
		int index;
		for(int i = 0; i < numOfEachME; i++){
			EObject obj = eClass.getEPackage().getEFactoryInstance().create(eClass);
		   if (obj instanceof ModelElement){
			   ModelElement me = (ModelElement) obj;
			   //FIXME: does not function!!!
			   //project.addModelElement(me);
			   index = random.nextInt(numOfLeafSections);
			   leafSections.get(index).getModelElements().add(me);
		   }else{
			   //FIXME:
			   //project.addModelElement(obj);
			   nonMEInstances.add(obj);
		   }
			
			
		}
		
	}

	
	//this sets the references to other types
	private void initializeReferences(ModelElement me) {
		//* For references that are 0..*, the number of references is
		//  determined by a random number.
		//  if project contains this number of target type, 
		//  then they are picked randomly. Otherwise the lacking instances 
		//  are instantiated and initialized (only references that are 
		//  one to one and not nullable) and added to project.
		//* For references that are 0..1, a random boolean determines if 
		//  the reference should be set. If it is to be set, then a random 
		//  instance is picked from instances of target type in project.
		//* For references that are 1..1, a random instance of the target
		//  type is picked from existing instances in the project.
				
		List<EReference> references = me.eClass().getEAllReferences();
		for(EReference ref : references){
			if (!ref.isRequired() && ref.isMany()){
				//set a random number of this ref
				List<EObject> allInstancesOfRefType = new ArrayList<EObject>();
				if(ref.getEReferenceType().isAbstract() || ref.getEReferenceType().isInterface()){
					allInstancesOfRefType = getElementsOfSubClassesOfType(ref.getEReferenceType());
				}else{
					allInstancesOfRefType = getElementsOfType(ref.getEReferenceType());
				}
				
				List<EObject> referencedInstances = new ArrayList<EObject>();
				int numOfRefs = random.nextInt(MAX_NUM_OF_MANY_REFS);
				//here must be checked if minimum number of each ME
				//in the project is greater or equal max_num_of_many_refs.
				//if not, the lacking instances should be created and added
				//to project
				for(int i = 0 ; i < numOfRefs; i++){
					//pick random instance of ref's type
				    //FIXME: allInstanceOrRefType list has sometimes size == 0
					//       although there are at least the minimum number of 
					//		 instances in project!!
					if (allInstancesOfRefType.size() != 0) {
				    	int index = random.nextInt(allInstancesOfRefType.size());
						EObject referencedInstance = allInstancesOfRefType.get(index);
						referencedInstances.add(referencedInstance);
				   }
					
				}
				
				me.eSet(ref, referencedInstances);
			}
		}
		//check other cases 1.one-to-one, required; 2. one-to-one, not required; 
	}


	//returns all instances of this type in the project. 
	private List<EObject> getElementsOfType(EClass referenceType) {
		List<EObject> ret = new ArrayList<EObject>();
		
		if (referenceType.getEAllSuperTypes().contains(ModelPackage.eINSTANCE.getModelElement())){
			for(LeafSection ls : leafSections){
				for(ModelElement me : ls.getModelElements()){
					if (me.eClass().equals(referenceType)){
						ret.add(me);
					}
				}
			}
			return ret;
		}else {
			for(EObject obj : nonMEInstances){
				if (obj.eClass().equals(referenceType)){
					ret.add(obj);
				}
			}
		
		return ret;
		}
		
		
	}
	
	//returns all instances of subclasses of this type
	//this will be called when the type itself is abstract (e.g. ModelElement or WorkItem)
	private List<EObject> getElementsOfSubClassesOfType(EClass referenceType){
		List<EObject> ret = new ArrayList<EObject>();
		
		if (referenceType.equals(ModelPackage.eINSTANCE.getModelElement())
		   || referenceType.getEAllSuperTypes().contains(ModelPackage.eINSTANCE.getModelElement())){
			for(LeafSection ls : leafSections){
				for(ModelElement me : ls.getModelElements()){
					//if (me.eClass().equals(referenceType)){
					if (referenceType.isInstance(me)){
						ret.add(me);
					}
				}
			}
			return ret;
		}else {
			for(EObject obj : nonMEInstances){
				if (obj.eClass().getEAllSuperTypes().contains(referenceType)){
					ret.add(obj);
				}
			}
		
		return ret;
		}
		
	}

	//the simplest of all....
	private void initializeSimpleAttributes(ModelElement me){
		
		for (EAttribute attribute : me.eClass().getEAllAttributes()) {
		
			if (attribute.getEType().getInstanceClass().equals(String.class)) {
				if (attribute.getName().equalsIgnoreCase("name")){
					me.setName(me.eClass().getName() + ":" + random.nextInt(20000) );
				}else {
					// create a random text
					me.eSet(attribute, getRandomText(me.eClass().getName()));
				}
				
			}
			if (attribute.getEType().getInstanceClass().equals(boolean.class)) {
				// create a random boolean
			}
			if (attribute.getEType().getInstanceClass().equals(int.class)) {
				// create a random integer
			}
			if (attribute.getEType().getInstanceClass().equals(Date.class)) {
				// create a random date (starting with 19??)
			}

		}
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

}

