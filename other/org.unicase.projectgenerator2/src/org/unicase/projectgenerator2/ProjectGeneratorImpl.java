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

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.EcorePackage;
import org.eclipse.emf.ecore.util.EcoreUtil;

public class ProjectGeneratorImpl implements IProjectGenerator {
	private EPackage rootPackage;
	private long seed;
	private long noOfExampleValues;
	private long hierarchyDepth;
	private EObject rootObject;
	private final Random random;
	private final Date date;
	private final StringBuffer string;
	private final Set<EClass> modelElementEClasses;
	private Map<EClass, List<EClass>> elementsToCreate;
	private Map<EClass, List<EObject>> generatedObjects;
	private Map<EClass, Integer> lastUsedIndex;
	private Map<EReference, List<EClass>> possibleReferenceClasses;
	
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
		rootObject = new ArrayList<EObject>(ProjectGeneratorUtil.getAllModelElementEClasses(rootPackage)).get(0);
		modelElementEClasses = ProjectGeneratorUtil.getAllModelElementEClasses(rootPackage);
		generatedObjects = new LinkedHashMap<EClass, List<EObject>>();
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
		generatedObjects = new LinkedHashMap<EClass, List<EObject>>();
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
		addGeneratedClassAndObject(parent);
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
					EObject newObject = null;
					try {
						newObject = EcoreUtil.create(currentChildClass);
					} catch(NullPointerException e) {
						EcoreUtil.create(currentChildClass);
					}
					setEObjectAttributes(newObject);
					if (reference.isMany()) {
							((EList<EObject>) currentParentObject.eGet(reference)).add(newObject);
					}
					else {
							currentParentObject.eSet(reference, newObject);
					}
					currentElementsInThisDepth++;
					i++;
					if(currentDepth < hierarchyDepth) {
						remainingObjects.add(newObject);
					}
					addGeneratedClassAndObject(newObject);
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
		if(reference.isChangeable() && !reference.isUnsettable()) 
			return true;
		return false;
	}
	
	/**
	 * Adds possible references (no containment/container-references) to a given EObject
	 * @param newObject the EObject to add references to
	 */
	private void addReferences(EObject newObject) {
		for(EReference reference : newObject.eClass().getEAllReferences()) {
			if(reference.isContainment() || reference.isContainer() || reference.isUnsettable() || reference.isVolatile() || reference.isTransient() || reference.isDerived() || !reference.isChangeable() || (!reference.isMany() && newObject.eIsSet(reference))) {
				continue;
			}
			List<EClass> possibleReferenceClasses = getPossibleReferenceClasses(reference); 
			boolean singleIsSet = false;
			for(EClass nextReferenceClass : possibleReferenceClasses) {
				if(singleIsSet)
					break;
				if(generatedObjects.containsKey(nextReferenceClass)) {
					List<EObject> possibleReferenceObjects = new ArrayList<EObject>(generatedObjects.get(nextReferenceClass)); 
					possibleReferenceObjects.remove(newObject);
					Collections.shuffle(possibleReferenceObjects, random);
					int size = possibleReferenceObjects.size();
					if(size > 0) {
						int index = 0;
						for(int i = 0; i < random.nextInt(3); i++) {
							EObject referencedObject = possibleReferenceObjects.get(index);
							if(reference.isMany()) {
								((EList<EObject>) newObject.eGet(reference)).add(referencedObject);
								index = (index+1) % size;
							} else {
								newObject.eSet(reference, referencedObject);
								singleIsSet = true;
								break;
							}
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
	 * Adds an EObject and its class (if necessary) to the specified lists for addReferences()
	 * @param newObject the EObject which should be added 
	 */
	private void addGeneratedClassAndObject(EObject newObject) {
		EClass eClass = newObject.eClass();
		if(generatedObjects.containsKey(eClass)) {
			generatedObjects.get(eClass).add(newObject);
		} else {
			List<EObject> newGeneratedObjectList = new ArrayList<EObject>();
			newGeneratedObjectList.add(newObject);
			generatedObjects.put(eClass, newGeneratedObjectList);
		}
	}

	/**
	 * Sets several attributes of a given EObject using random values
	 * @param newObject the EObject to set attributes for
	 */
	private void setEObjectAttributes(EObject newObject) {
		for(EAttribute attribute : newObject.eClass().getEAllAttributes()) {
			EClassifier attributeType = attribute.getEType();
			EcorePackage ecoreInstance = EcorePackage.eINSTANCE;
			if(!attribute.isChangeable() || attribute.isUnsettable() || attribute.isDerived() || attribute.isTransient() || attribute.isVolatile())
				continue;
			if (attributeType == ecoreInstance.getEBoolean() || attributeType == ecoreInstance.getEBooleanObject()) {
				if(attribute.isMany()) {
					((EList<Boolean>) newObject.eGet(attribute)).add(random.nextBoolean());
				} else {
					newObject.eSet(attribute, random.nextBoolean());
				}
			} else if (attributeType == ecoreInstance.getEByteArray()){
				byte[] bytes = new byte[random.nextInt(100)];
				random.nextBytes(bytes);
				if(attribute.isMany()) {
					((EList) newObject.eGet(attribute)).add(bytes);
				} else {
					newObject.eSet(attribute, bytes);
				}				
			} else if (attributeType == ecoreInstance.getEByte() || attributeType == ecoreInstance.getEByteObject()) {
				byte[] singleByte = new byte[1];
				random.nextBytes(singleByte);
				if(attribute.isMany()) {
					((EList<Byte>) newObject.eGet(attribute)).add(new Byte(singleByte[0]));
				} else {
					newObject.eSet(attribute, new Byte(singleByte[0]));
				}
			} else if (attributeType == ecoreInstance.getEChar() || attributeType == ecoreInstance.getECharacterObject()) {
				if(attribute.isMany()) {
					((EList<Character>) newObject.eGet(attribute)).add((char) (random.nextInt(94) + 33));
				} else {
					newObject.eSet(attribute, (char)(random.nextInt(94) + 33));
				}
			} else if(attributeType == ecoreInstance.getEString()) {
				string.delete(0, string.length());
				for(int i = -5; i<random.nextInt(10); i++) {
					string.append((char)(random.nextInt(94) + 33));
				}
				if(attribute.isMany()) {
					((EList<String>) newObject.eGet(attribute)).add(string.toString());
				} else {
					newObject.eSet(attribute, string.toString());
				}
			} else if (attributeType == ecoreInstance.getEDate()) {
				if(attribute.isMany()) {
					((EList<Date>) newObject.eGet(attribute)).add(date);
				} else {
					newObject.eSet(attribute, date);
				}
			} else if (attributeType == ecoreInstance.getEInt() || attributeType == ecoreInstance.getEIntegerObject()) {
				if(attribute.isMany()) {
					((EList<Integer>) newObject.eGet(attribute)).add(random.nextInt());
				} else {
					newObject.eSet(attribute, random.nextInt());
				}
			} else if (attributeType == ecoreInstance.getEDouble() || attributeType == ecoreInstance.getEDoubleObject()) {
				if(attribute.isMany()) {
					((EList<Double>) newObject.eGet(attribute)).add(random.nextDouble() * random.nextInt());
				} else {
					newObject.eSet(attribute, random.nextDouble() * random.nextInt());
				}
			} else if (attributeType == ecoreInstance.getEFloat() || attributeType == ecoreInstance.getEFloatObject()) {
				if(attribute.isMany()) {
					((EList<Float>) newObject.eGet(attribute)).add(random.nextFloat() * random.nextInt());
				} else {
					newObject.eSet(attribute, random.nextFloat() * random.nextInt());
				}
			} else if (attributeType == ecoreInstance.getELong() || attributeType == ecoreInstance.getELongObject()) {
				if(attribute.isMany()) {
					((EList<Long>) newObject.eGet(attribute)).add(random.nextLong());
				} else {
					newObject.eSet(attribute, random.nextLong());
				}
			} else if (attributeType == ecoreInstance.getEShort() || attributeType == ecoreInstance.getEShortObject()) {
				if(attribute.isMany()) {
					((EList<Short>) newObject.eGet(attribute)).add((short) random.nextInt());
				} else {
					newObject.eSet(attribute, (short) random.nextInt());
				}
			} else if (attributeType ==ecoreInstance.getEBigInteger()) {
				if(attribute.isMany()) {
					((EList<BigInteger>) newObject.eGet(attribute)).add(new BigInteger(20, random));
				} else {
					newObject.eSet(attribute, new BigInteger(20, random));
				}
			} else if (attributeType == ecoreInstance.getEBigDecimal()) {
				if(attribute.isMany()) {
					((EList<BigDecimal>) newObject.eGet(attribute)).add(new BigDecimal(random.nextDouble() * random.nextInt()));
				} else {
					newObject.eSet(attribute, new BigDecimal(random.nextDouble() * random.nextInt()));
				}
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
