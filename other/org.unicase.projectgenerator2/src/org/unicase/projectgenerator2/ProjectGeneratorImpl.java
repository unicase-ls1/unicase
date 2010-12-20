package org.unicase.projectgenerator2;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Random;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.EcorePackage;

public class ProjectGeneratorImpl implements IProjectGenerator {
	private EPackage rootPackage;
	private long seed;
	private long noOfExampleValues;
	private long hierarchyDepth;
	private EObject rootObject;
	private final Random random;
	private final Date date;
	private List<List<EObject>> generatedObjects;
	private List<EClass> alreadyGeneratedClasses;
	
	
	public EObject getRootObject() {
		return rootObject;
	}
	
	public void setRootObject(EObject root) {
		rootObject = root;
	}

	protected ProjectGeneratorImpl(EPackage rootPackage, long seed, long noOfExampleValues, long hierachyDepth) {
		this.rootPackage = rootPackage;
		this.seed = seed;
		this.noOfExampleValues = noOfExampleValues;
		this.hierarchyDepth = hierachyDepth;
		rootObject = null;
		alreadyGeneratedClasses = new ArrayList<EClass>();
		generatedObjects = new ArrayList<List<EObject>>();
		random = new Random(seed);
		date = new Date();
	}
	
	protected ProjectGeneratorImpl(EPackage rootPackage, String rootObject, long seed, long noOfExampleValues, long hierachyDepth) {
		this.rootPackage = rootPackage;
		this.seed = seed;
		this.noOfExampleValues = noOfExampleValues;
		this.hierarchyDepth = hierachyDepth;
		this.rootObject = ProjectGeneratorUtil.createEObject(ProjectGeneratorUtil.getModelElementEClasses(rootPackage, rootObject));
		alreadyGeneratedClasses = new ArrayList<EClass>();
		generatedObjects = new ArrayList<List<EObject>>();
		random = new Random();
		date = new Date();
	}
	
	/* (non-Javadoc)
	 * @see org.unicase.projectgenerator2.IProjectGenerator#getRootPackage()
	 */
	public EPackage getRootPackage() {
		return rootPackage;
	}
	/* (non-Javadoc)
	 * @see org.unicase.projectgenerator2.IProjectGenerator#setRootPackage(org.eclipse.emf.ecore.EPackage)
	 */
	public void setRootPackage(EPackage rootPackage) {
		this.rootPackage = rootPackage;
	}
	/* (non-Javadoc)
	 * @see org.unicase.projectgenerator2.IProjectGenerator#getSeed()
	 */
	public long getSeed() {
		return seed;
	}
	/* (non-Javadoc)
	 * @see org.unicase.projectgenerator2.IProjectGenerator#setSeed(long)
	 */
	public void setSeed(long seed) {
		this.seed = seed;
		random.setSeed(seed);
	}
	/* (non-Javadoc)
	 * @see org.unicase.projectgenerator2.IProjectGenerator#getNoOfExampleValues()
	 */
	public long getNoOfExampleValues() {
		return noOfExampleValues;
	}
	/* (non-Javadoc)
	 * @see org.unicase.projectgenerator2.IProjectGenerator#setNoOfExampleValues(long)
	 */
	public void setNoOfExampleValues(long noOfExampleValues) {
		this.noOfExampleValues = noOfExampleValues;
	}
	/* (non-Javadoc)
	 * @see org.unicase.projectgenerator2.IProjectGenerator#getHierachyDepth()
	 */
	public long getHierachyDepth() {
		return hierarchyDepth;
	}
	/* (non-Javadoc)
	 * @see org.unicase.projectgenerator2.IProjectGenerator#setHierachyDepth(long)
	 */
	public void setHierachyDepth(long hierachyDepth) {
		this.hierarchyDepth = hierachyDepth;
	}
	
	/* (non-Javadoc)
	 * @see org.unicase.projectgenerator2.IProjectGenerator#generateValues()
	 */
	public void generateValues() {
		generateValuesList(rootObject);
		for(List<EObject> eObjectsByClass : generatedObjects) {
			for(EObject eObject : eObjectsByClass) {
				addReferences(eObject);
			}
		}
	}
	
//	private void generateChildren(EObject parent, long currentDepth) {
//		List<EClass> elementsToCreate = new ArrayList<EClass>(ProjectGeneratorUtil.getAllEContainments(parent.eClass()));
//		int size = elementsToCreate.size();
//		int index = 0;
//		if(currentDepth < hierarchyDepth && size > 0) {
//			for(int i = 0; i < noOfExampleValues; i++) {
//				EClass currentChildClass = elementsToCreate.get(index);
//				if(currentChildClass.isInterface() || currentChildClass.isAbstract()) {
//					elementsToCreate.remove(index);
//					i--;
//					continue;
//				}
//				index = (index+1) % size;
//				EObject newObject = currentChildClass.getEPackage().getEFactoryInstance().create(currentChildClass);
//				setEObjectAttributes(newObject);
//				EReference reference = ProjectGeneratorUtil.getPossibleContainingReference(newObject, parent);
//				if (parent.eGet(reference) instanceof List) {
//					((List<EObject>) parent.eGet(reference)).add(newObject);
//				}
//				else {
//					parent.eSet(reference, newObject);
//				}
//				generateChildren(newObject, (currentDepth+1));
//			}
//		} 
//	}
	
	private void generateValuesList(EObject parent) {
		addGeneratedClassAndObject(parent.eClass(), parent);
		List<EObject> remainingObjects = new ArrayList<EObject>();
		remainingObjects.add(parent);
		int currentDepth = 1;
		long elementsInThisDepth = noOfExampleValues;
		int count = 0;
		while(!remainingObjects.isEmpty()) {
			EObject currentParentObject = remainingObjects.remove(0);
			List<EClass> elementsToCreate = new ArrayList<EClass>(ProjectGeneratorUtil.getAllEContainments(currentParentObject.eClass()));
			int size = elementsToCreate.size();
			int index = 0;
			if(size > 0) {
				for(int i=0; i<noOfExampleValues; i++) {
					EClass currentChildClass = elementsToCreate.get(index);
					if(currentChildClass.isInterface() || currentChildClass.isAbstract()) {
						i--;
						continue;
					}
					index = (index + 1) % size;
					EObject newObject = currentChildClass.getEPackage().getEFactoryInstance().create(currentChildClass);
					setEObjectAttributes(newObject, count++);
					for(EReference reference : ProjectGeneratorUtil.getAllPossibleContainingReferences(newObject, currentParentObject)) {
						if(reference.isChangeable() && !reference.isUnsettable()) {
							if (currentParentObject.eGet(reference) instanceof List) {
								((List<EObject>) currentParentObject.eGet(reference)).add(newObject);
							}
							else {
								currentParentObject.eSet(reference, newObject);
							}
							break;
						}
					}
					if(currentDepth < hierarchyDepth) {
						remainingObjects.add(newObject);
					}
					addGeneratedClassAndObject(currentChildClass, newObject);
				}
			}
			if(count >= elementsInThisDepth) {
				count = 0;
				elementsInThisDepth = (long) Math.pow(noOfExampleValues, ++currentDepth);
			}
			
		}
	}

	private void addReferences(EObject newObject) {
		for(EReference reference : newObject.eClass().getEAllReferences()) {
			if(reference.isContainment() || reference.isContainer() || reference.isUnsettable() || !reference.isChangeable()) {
				continue;
			}
			List<EClass> possibleReferenceClasses = new ArrayList<EClass>();
			possibleReferenceClasses.add(reference.getEReferenceType());
			for(EClass eClass : alreadyGeneratedClasses) {
				if(reference.getEReferenceType().isSuperTypeOf(eClass)) {
					possibleReferenceClasses.add(eClass);
				}
			}
			for(EClass nextReferenceClass : possibleReferenceClasses) {
				int index = alreadyGeneratedClasses.indexOf(nextReferenceClass);
				if(index >=0) {
					List<EObject> possibleReferenceObjects = generatedObjects.get(index);
					int size = possibleReferenceObjects.size();
					int randomIndex = random.nextInt(size) ; 
					for(int i = (randomIndex + 1) % size; i != randomIndex; i=(i+1)%size) {
						EObject referencedObject = possibleReferenceObjects.get(i);
						if(referencedObject == newObject)
							continue;
						if(newObject.eGet(reference) instanceof List) {
							((List<EObject>) newObject.eGet(reference)).add(referencedObject);
						} else {
							newObject.eSet(reference, referencedObject);
							break;
						}
					}
				}
			}
		}
	}

	private void addGeneratedClassAndObject(EClass eClass, EObject newObject) {
		int index = alreadyGeneratedClasses.indexOf(eClass);
		if(index > 0) {
			generatedObjects.get(index).add(newObject);
		} else {
			alreadyGeneratedClasses.add(eClass);
			List<EObject> newGeneratedObjectList = new ArrayList<EObject>();
			newGeneratedObjectList.add(newObject);
			generatedObjects.add(newGeneratedObjectList);
		}
	}

	private void setEObjectAttributes(EObject newObject, int count) {
		for(EAttribute attribute : ProjectGeneratorUtil.getEAttributes(newObject.eClass())) {
			EClassifier attributeType = attribute.getEType();
			EcorePackage ecoreInstance = EcorePackage.eINSTANCE;
			if(!attribute.isChangeable())
				continue;
			if(attributeType == ecoreInstance.getEString()) {
				newObject.eSet(attribute, "Generated " + count);
			} else if (attributeType == ecoreInstance.getEBoolean() || attributeType == ecoreInstance.getEBooleanObject()) {
				newObject.eSet(attribute, random.nextBoolean());
			} else if (attributeType ==ecoreInstance.getEBigInteger()) {
				newObject.eSet(attribute, new BigInteger(20, random));
			} else if (attributeType == ecoreInstance.getEChar() || attributeType == ecoreInstance.getECharacterObject()) {
				newObject.eSet(attribute, 'a');
			} else if (attributeType == ecoreInstance.getEInt() || attributeType == ecoreInstance.getEIntegerObject()) {
				newObject.eSet(attribute, random.nextInt(Integer.parseInt(Long.toString(seed))));
			} else if (attributeType == ecoreInstance.getEDate()) {
				newObject.eSet(attribute, date);
			} else if (attributeType == ecoreInstance.getEDouble() || attributeType == ecoreInstance.getEDoubleObject()) {
				newObject.eSet(attribute, random.nextDouble());
			} else if (attributeType == ecoreInstance.getEFloat() || attributeType == ecoreInstance.getEFloatObject()) {
				newObject.eSet(attribute, random.nextFloat());
			} else if (attributeType == ecoreInstance.getELong() || attributeType == ecoreInstance.getELongObject()) {
				newObject.eSet(attribute, random.nextLong());
			} else if (attributeType == ecoreInstance.getEShort() || attributeType == ecoreInstance.getEShortObject()) {
				newObject.eSet(attribute, 5);
			}
				
		}
	}
}
