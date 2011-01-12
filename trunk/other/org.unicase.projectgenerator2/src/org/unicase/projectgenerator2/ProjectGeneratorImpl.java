package org.unicase.projectgenerator2;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.Set;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.EcorePackage;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.edit.command.AddCommand;
import org.eclipse.emf.edit.command.SetCommand;
import org.eclipse.emf.transaction.util.TransactionUtil;
import org.eclipse.emf.transaction.TransactionalEditingDomain;

public class ProjectGeneratorImpl implements IProjectGenerator {
	private EPackage rootPackage;
	private long seed;
	private long noOfExampleValues;
	private long hierarchyDepth;
	private EObject rootObject;
	private TransactionalEditingDomain domain;
	private final Random random;
	private final Date date;
	private final StringBuffer string;
	private final Set<EClass> modelElementEClasses;
	private Map<EClass, List<EClass>> elementsToCreate;
	private Map<EClass, Integer> lastUsedIndex;
	private Map<EReference, List<EClass>> possibleReferenceClasses;
	private Map<EClass, Set<EObject>> generatedObjects;
	
	public EObject getRootObject() {
		return rootObject;
	}
	
	public void setRootObject(EObject root) {
		rootObject = root;
	}

	public ProjectGeneratorImpl(EPackage rootPackage, long seed, long noOfExampleValues, long hierachyDepth) {
		this.rootPackage = rootPackage;
		this.seed = seed;
		this.noOfExampleValues = noOfExampleValues;
		this.hierarchyDepth = hierachyDepth;
		for(EClass eClass : ProjectGeneratorUtil.getAllModelElementEClasses(rootPackage)) {
			if(eClass.isAbstract() || eClass.isInterface())
				continue;
			EObject container = eClass.eContainer();
			if(container != null && container instanceof EPackage) {
				rootObject = eClass;
				break;
			}
		}
		modelElementEClasses = ProjectGeneratorUtil.getAllModelElementEClasses(rootPackage);
		elementsToCreate = new LinkedHashMap<EClass, List<EClass>>();
		lastUsedIndex = new LinkedHashMap<EClass, Integer>();
		possibleReferenceClasses = new LinkedHashMap<EReference, List<EClass>>();
		random = new Random(seed);
		date = new Date();
		string = new StringBuffer();
	}
	
	public ProjectGeneratorImpl(EPackage rootPackage, EObject rootObject, long seed, long noOfExampleValues, long hierachyDepth) {
		this.rootPackage = rootPackage;
		this.seed = seed;
		this.noOfExampleValues = noOfExampleValues;
		this.hierarchyDepth = hierachyDepth;
		this.rootObject = rootObject;
		modelElementEClasses = ProjectGeneratorUtil.getAllModelElementEClasses(rootPackage);
		elementsToCreate = new LinkedHashMap<EClass, List<EClass>>();
		lastUsedIndex = new LinkedHashMap<EClass, Integer>();
		possibleReferenceClasses = new LinkedHashMap<EReference, List<EClass>>();
		random = new Random();
		date = new Date();
		string = new StringBuffer();
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
		generateValues(rootObject);
		generatedObjects = ProjectGeneratorUtil.getAllGeneratedClassesAndObjects(rootObject);
		for(EClass eClass : generatedObjects.keySet()) {
			for(EObject generatedEObject : generatedObjects.get(eClass)) {
				addReferences(generatedEObject);			
			}
		}
	}

	/**
	 * Generates the amount of specified EObjects using a list-algorithm
	 * @param parent the parent EObject to start generating from
	 */
	private void generateValues(EObject parent) {
		if(parent == null)
			return;
		if(parent instanceof EClass) {
			parent = EcoreUtil.create((EClass) parent);
			setEObjectAttributes(parent);
		}
		domain = TransactionUtil.getEditingDomain(parent);
		List<EObject> remainingObjects = new ArrayList<EObject>();
		remainingObjects.add(parent);
		int currentDepth = 1;
		long maxElementsInThisDepth = noOfExampleValues;
		long currentElementsInThisDepth = 0;
		while(!remainingObjects.isEmpty()) {
			EObject currentParentObject = remainingObjects.remove(0);
			List<EClass> elementsToCreate = getElementsToCreate(currentParentObject.eClass());
			int index;
			if(lastUsedIndex.containsKey(currentParentObject.eClass())) {
				index = lastUsedIndex.get(currentParentObject.eClass());
			} else {
				index = 0;
			}
			int i = 0;
			Map<EReference, List<EObject>> objectsPerReference = new LinkedHashMap<EReference, List<EObject>>();
			while(i<noOfExampleValues && !elementsToCreate.isEmpty()) {
				index = (index + 1) % elementsToCreate.size();
				EClass currentChildClass = elementsToCreate.get(index);
				if(currentChildClass.isInterface() || currentChildClass.isAbstract()) {
					elementsToCreate.remove(currentChildClass);
					continue;
				}
				List<EReference> validReferences = new ArrayList<EReference>();
				for(EReference reference : ProjectGeneratorUtil.getAllPossibleContainingReferences(currentChildClass, currentParentObject.eClass())) {
					if(isValidReference(reference, currentParentObject))
						validReferences.add(reference);
				}
				if(validReferences.isEmpty())
					elementsToCreate.remove(currentChildClass);
				for(EReference reference : validReferences) {
					if(i>=noOfExampleValues)
						break;
					EObject newObject = EcoreUtil.create(currentChildClass);
					setEObjectAttributes(newObject);
					if (reference.isMany()) {
						if(objectsPerReference.containsKey(reference))
							objectsPerReference.get(reference).add(newObject);
						else {
							List<EObject> newReferenceList = new ArrayList<EObject>();
							newReferenceList.add(newObject);
							objectsPerReference.put(reference, newReferenceList);
						}
					}
					else {
						try {
							new SetCommand(domain, currentParentObject, reference, newObject).doExecute();
						} catch(Exception e){
						}
					}
					currentElementsInThisDepth++;
					i++;
					if(currentDepth < hierarchyDepth) {
						remainingObjects.add(newObject);
					}
				}
			}
			for(EReference reference : objectsPerReference.keySet()) {
				try {
					new AddCommand(domain, currentParentObject, reference, objectsPerReference.get(reference)).doExecute();
				} catch(Exception e) {
				}
			}
			lastUsedIndex.put(currentParentObject.eClass(), index);
			if(currentElementsInThisDepth >= maxElementsInThisDepth) {
				currentElementsInThisDepth = 0;
				maxElementsInThisDepth = (long) Math.pow(noOfExampleValues, ++currentDepth);
			}
		}
	}
	
	/**
	 * Returns whether the reference is valid for containment-purposes.
	 * 
	 * @param reference the reference to be tested
	 * @param currentParentObject the EObject for which the reference shall be tested
	 * @return true if the reference is valid, false if not 
	 */
	private boolean isValidReference(EReference reference, EObject currentParentObject) {
		if(!reference.isMany() && currentParentObject.eIsSet(reference))
			return false;
		if(reference.isChangeable()) {
			return true;
		}
		return false;
	}
	
	/**
	 * Adds possible references (no containment/container-references) to a given EObject
	 * @param newObject the EObject to add references to
	 */
	private void addReferences(EObject newObject) {
		for(EReference reference : newObject.eClass().getEAllReferences()) {
			if(reference.isContainment() || reference.isContainer() || reference.isVolatile() || reference.isTransient() || reference.isDerived() || !reference.isChangeable() || (!reference.isMany() && newObject.eIsSet(reference))) {
				continue;
			}
			List<EClass> possibleReferenceClasses = getPossibleReferenceClasses(reference); 
			for(EClass nextReferenceClass : possibleReferenceClasses) {
				if(generatedObjects.containsKey(nextReferenceClass)) {
					List<EObject> possibleReferenceObjects = new ArrayList<EObject>(generatedObjects.get(nextReferenceClass)); 
					possibleReferenceObjects.remove(newObject);
					Collections.shuffle(possibleReferenceObjects, random);
					if(!possibleReferenceObjects.isEmpty()) {
						int index = 0;
						try {
							if(reference.isMany()) {
								int maxObjects = random.nextInt(3) + 1;
								if(reference.isRequired()) maxObjects++;
								List<EObject> referencedObjects = new ArrayList<EObject>();
								for(int i = 0; i < maxObjects; i++) {
									referencedObjects.add(possibleReferenceObjects.get(index));
									if(++index==possibleReferenceObjects.size()) break;
								}
								new AddCommand(domain, newObject, reference, referencedObjects).doExecute();
							} else if (reference.isRequired() || random.nextBoolean()){
								EObject referencedObject = possibleReferenceObjects.get(index);
								new SetCommand(domain, newObject, reference, referencedObject).doExecute();
								break;
							} else break;
						} catch (Exception e) {
						}
					}
				}
			}
		}
	}

	private List<EClass> getPossibleReferenceClasses(EReference reference) {
		if(possibleReferenceClasses.containsKey(reference))
			return possibleReferenceClasses.get(reference);
		else {
			List<EClass> result = new ArrayList<EClass>();
			EClass referenceType = reference.getEReferenceType();
			result.add(referenceType);
			for(EClass eClass : generatedObjects.keySet()) {
				if(referenceType.isSuperTypeOf(eClass)) {
					result.add(eClass);
				}
			}
			possibleReferenceClasses.put(reference, result);
			return result;
		}
	}

	/**
	 * Sets several attributes of a given EObject using random values
	 * @param newObject the EObject to set attributes for
	 */
	private void setEObjectAttributes(EObject newObject) {
		for(EAttribute attribute : newObject.eClass().getEAllAttributes()) {
			try {
				EClassifier attributeType = attribute.getEType();
				EcorePackage ecoreInstance = EcorePackage.eINSTANCE;
				if(!attribute.isChangeable() || attribute.isDerived() || attribute.isTransient() || attribute.isVolatile())
					continue;
				if (attributeType == ecoreInstance.getEBoolean() || attributeType == ecoreInstance.getEBooleanObject()) {
					if(attribute.isMany()) {
						int maxObjects = random.nextInt(3) + 1;
						List<Boolean> newAttributes = new ArrayList<Boolean>();
						for(int i = 0; i < maxObjects; i++) {
							newAttributes.add(random.nextBoolean());
						}
						new AddCommand(domain, newObject, attribute, newAttributes).doExecute();
					} else {
						new SetCommand(domain, newObject, attribute, random.nextBoolean()).doExecute();
					}
				} else if (attributeType == ecoreInstance.getEByteArray()){
					if(attribute.isMany()) {
						int maxObjects = random.nextInt(3) + 1;
						for(int i = 0; i < maxObjects; i++) {
							byte[] bytes = new byte[random.nextInt(100)];
							random.nextBytes(bytes);
							new AddCommand(domain, newObject, attribute, bytes).doExecute();
						}
					} else {
						byte[] bytes = new byte[random.nextInt(100)];
						random.nextBytes(bytes);
						new SetCommand(domain, newObject, attribute, bytes).doExecute();
					}				
				} else if (attributeType == ecoreInstance.getEByte() || attributeType == ecoreInstance.getEByteObject()) {
					if(attribute.isMany()) {
						int maxObjects = random.nextInt(3) + 1;
						for(int i = 0; i < maxObjects; i++) {
							byte[] singleByte = new byte[1];
							random.nextBytes(singleByte);
							new AddCommand(domain, newObject, attribute, singleByte).doExecute();
						}
					} else {
						byte[] singleByte = new byte[1];
						random.nextBytes(singleByte);
						new SetCommand(domain, newObject, attribute, singleByte).doExecute();
					}
				} else if (attributeType == ecoreInstance.getEChar() || attributeType == ecoreInstance.getECharacterObject()) {
					if(attribute.isMany()) {
						int maxObjects = random.nextInt(3) + 1;
						List<Character> newAttributes = new ArrayList<Character>();
						for(int i = 0; i < maxObjects; i++) {
							newAttributes.add((char) (random.nextInt(94) + 33));
						}
						new AddCommand(domain, newObject, attribute, newAttributes).doExecute();
					} else {
						new SetCommand(domain, newObject, attribute, (char)(random.nextInt(94) + 33)).doExecute();
					}
				} else if(attributeType == ecoreInstance.getEString()) {
					if(attribute.isMany()) {
						int maxObjects = random.nextInt(3) + 1;
						List<String> newAttributes = new ArrayList<String>();
						for(int i = 0; i < maxObjects; i++) {
							string.delete(0, string.length());
							for(int j = -5; j<random.nextInt(10); j++) {
								string.append((char)(random.nextInt(94) + 33));
							}
							newAttributes.add(string.toString());
						}
						new AddCommand(domain, newObject, attribute, newAttributes).doExecute();
					} else {
						string.delete(0, string.length());
						for(int j = -5; j<random.nextInt(10); j++) {
							string.append((char)(random.nextInt(94) + 33));
						}
						new SetCommand(domain, newObject, attribute, string.toString()).doExecute();
					}
				} else if (attributeType == ecoreInstance.getEDate()) {
					if(attribute.isMany()) {
						int maxObjects = random.nextInt(3) + 1;
						List<Date> newAttributes = new ArrayList<Date>();
						for(int i = 0; i < maxObjects; i++) {
							newAttributes.add(date);
						}
						new AddCommand(domain, newObject, attribute, newAttributes).doExecute();
					} else {
						new SetCommand(domain, newObject, attribute, date).doExecute();
					}
				} else if (attributeType == ecoreInstance.getEInt() || attributeType == ecoreInstance.getEIntegerObject()) {
					if(attribute.isMany()) {
						int maxObjects = random.nextInt(3) + 1;
						List<Integer> newAttributes = new ArrayList<Integer>();
						for(int i = 0; i < maxObjects; i++) {
							newAttributes.add(random.nextInt());
						}
						new AddCommand(domain, newObject, attribute, newAttributes).doExecute();
					} else {
						new SetCommand(domain, newObject, attribute, random.nextInt()).doExecute();
					}
				} else if (attributeType == ecoreInstance.getEDouble() || attributeType == ecoreInstance.getEDoubleObject()) {
					if(attribute.isMany()) {
						int maxObjects = random.nextInt(3) + 1;
						List<Double> newAttributes = new ArrayList<Double>();
						for(int i = 0; i < maxObjects; i++) {
							newAttributes.add(random.nextDouble() * random.nextInt());
						}
						new AddCommand(domain, newObject, attribute, newAttributes).doExecute();
					} else {
						new SetCommand(domain, newObject, attribute, random.nextDouble() * random.nextInt()).doExecute();
					}
				} else if (attributeType == ecoreInstance.getEFloat() || attributeType == ecoreInstance.getEFloatObject()) {
					if(attribute.isMany()) {
						int maxObjects = random.nextInt(3) + 1;
						List<Float> newAttributes = new ArrayList<Float>();
						for(int i = 0; i < maxObjects; i++) {
							newAttributes.add(random.nextFloat() * random.nextInt());
						}
						new AddCommand(domain, newObject, attribute, newAttributes).doExecute();
					} else {
						new SetCommand(domain, newObject, attribute, random.nextFloat() * random.nextInt()).doExecute();
					}
				} else if (attributeType == ecoreInstance.getELong() || attributeType == ecoreInstance.getELongObject()) {
					if(attribute.isMany()) {
						int maxObjects = random.nextInt(3) + 1;
						List<Long> newAttributes = new ArrayList<Long>();
						for(int i = 0; i < maxObjects; i++) {
							newAttributes.add(random.nextLong());
						}
						new AddCommand(domain, newObject, attribute, newAttributes).doExecute();
					} else {
						new SetCommand(domain, newObject, attribute, random.nextLong()).doExecute();
					}
				} else if (attributeType == ecoreInstance.getEShort() || attributeType == ecoreInstance.getEShortObject()) {
					if(attribute.isMany()) {
						int maxObjects = random.nextInt(3) + 1;
						List<Short> newAttributes = new ArrayList<Short>();
						for(int i = 0; i < maxObjects; i++) {
							newAttributes.add((short) random.nextInt());
						}
						new AddCommand(domain, newObject, attribute, newAttributes).doExecute();
					} else {
						new SetCommand(domain, newObject, attribute, (short) random.nextInt()).doExecute();
					}
				} else if (attributeType ==ecoreInstance.getEBigInteger()) {
					if(attribute.isMany()) {
						int maxObjects = random.nextInt(3) + 1;
						List<BigInteger> newAttributes = new ArrayList<BigInteger>();
						for(int i = 0; i < maxObjects; i++) {
							newAttributes.add(new BigInteger(20, random));
						}
						new AddCommand(domain, newObject, attribute, newAttributes).doExecute();
					} else {
						new SetCommand(domain, newObject, attribute, new BigInteger(20, random)).doExecute();
					}
				} else if (attributeType == ecoreInstance.getEBigDecimal()) {
					if(attribute.isMany()) {
						int maxObjects = random.nextInt(3) + 1;
						List<BigDecimal> newAttributes = new ArrayList<BigDecimal>();
						for(int i = 0; i < maxObjects; i++) {
							newAttributes.add(new BigDecimal(random.nextDouble() * random.nextInt()));
						}
						new AddCommand(domain, newObject, attribute, newAttributes).doExecute();
					} else {
						new SetCommand(domain, newObject, attribute, new BigDecimal(random.nextDouble() * random.nextInt())).doExecute();
					}
				}
			} catch (Exception e) {
			}
		}
	}
	
	public List<EClass> getElementsToCreate(EClass eClass) {
		if(elementsToCreate.containsKey(eClass)) {
			return elementsToCreate.get(eClass);
		} else {
			List<EClass> result = new ArrayList<EClass>(ProjectGeneratorUtil.getAllEContainments(eClass));
			result.retainAll(modelElementEClasses);
			elementsToCreate.put(eClass, result);
			return result;
		}
	}
}
