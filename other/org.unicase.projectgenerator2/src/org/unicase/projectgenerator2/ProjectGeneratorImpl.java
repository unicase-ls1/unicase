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
import org.eclipse.emf.edit.domain.AdapterFactoryEditingDomain;
import org.eclipse.emf.edit.domain.EditingDomain;
import org.unicase.projectgenerator2.util.ProjectGeneratorConfiguration;
import org.unicase.projectgenerator2.util.ProjectGeneratorUtil;

public class ProjectGeneratorImpl implements IProjectGenerator {
	private EObject rootObject;
	private int width;
	private int depth;
	private long seed;	
	private boolean ignoreAndLog;
	private EditingDomain domain;
	private Random random;
	private Date date;
	private StringBuffer string;
	private Set<EClass> modelElementEClasses;
	private Map<EClass, List<EClass>> elementsToCreate;
	private Map<EClass, Integer> lastUsedIndex;
	private Map<EReference, List<EClass>> possibleReferenceClasses;
	private Map<EClass, Set<EObject>> generatedObjects;
	private List<RuntimeException> exceptions;
	
	/* (non-Javadoc)
	 * @see org.unicase.projectgenerator2.IProjectGenerator#generateValues()
	 */
	public void generateModel(EPackage modelPackage, EObject rootObject) {
		generateModel(new ProjectGeneratorConfiguration(modelPackage, rootObject));
	}
	
	public void generateModel(ProjectGeneratorConfiguration config) {
		modelElementEClasses = ProjectGeneratorUtil.getAllModelElementEClasses(config.getModelPackage());
		rootObject = config.getRootObject();
		width = config.getWidth();
		depth = config.getDepth();
		seed = config.getSeed();
		ignoreAndLog = config.getIgnoreAndLog();
		random = new Random(seed);
		date = new Date();
		string = new StringBuffer();
		elementsToCreate = new LinkedHashMap<EClass, List<EClass>>();
		lastUsedIndex = new LinkedHashMap<EClass, Integer>();
		possibleReferenceClasses = new LinkedHashMap<EReference, List<EClass>>();
		generateModel(rootObject);
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
	private void generateModel(EObject parent) {
		if(parent == null)
			return;
		if(parent instanceof EClass) {
			EClass parentClass = (EClass) parent;
			if(parentClass.isInterface() || parentClass.isSuperTypeOf(parentClass))
				return;
			parent = EcoreUtil.create((EClass) parent);
			setEObjectAttributes(parent);
		}
		domain = AdapterFactoryEditingDomain.getEditingDomainFor(parent);
		List<EObject> remainingObjects = new ArrayList<EObject>();
		remainingObjects.add(parent);
		int currentDepth = 1;
		long maxElementsInThisDepth = width;
		long currentElementsInThisDepth = 0;
		while(!remainingObjects.isEmpty()) {
			EObject currentParentObject = remainingObjects.remove(0);
			List<EClass> elementsToCreate = getElementsToCreate(currentParentObject.eClass());
			Collections.shuffle(elementsToCreate, random);
			int index;
			if(lastUsedIndex.containsKey(currentParentObject.eClass())) {
				index = lastUsedIndex.get(currentParentObject.eClass());
			} else {
				index = 0;
			}
			int i = 0;
			Map<EReference, List<EObject>> objectsByReference = new LinkedHashMap<EReference, List<EObject>>();
			while(i<width && !elementsToCreate.isEmpty()) {
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
					if(i>=width)
						break;
					EObject newObject = EcoreUtil.create(currentChildClass);
					setEObjectAttributes(newObject);
					if (reference.isMany()) {
						if(objectsByReference.containsKey(reference))
							objectsByReference.get(reference).add(newObject);
						else {
							List<EObject> newReferenceList = new ArrayList<EObject>();
							newReferenceList.add(newObject);
							objectsByReference.put(reference, newReferenceList);
						}
					}
					else {
						try {
							new SetCommand(domain, currentParentObject, reference, newObject).doExecute();
						} catch(RuntimeException e){
							handle(e);
						}
					}
					currentElementsInThisDepth++;
					i++;
					if(currentDepth < depth) {
						remainingObjects.add(newObject);
					}
				}
			}
			for(EReference reference : objectsByReference.keySet()) {
				try {
					new AddCommand(domain, currentParentObject, reference, objectsByReference.get(reference)).doExecute();
				} catch(RuntimeException e) {
				}
			}
			lastUsedIndex.put(currentParentObject.eClass(), index);
			if(currentElementsInThisDepth >= maxElementsInThisDepth) {
				currentElementsInThisDepth = 0;
				maxElementsInThisDepth = (long) Math.pow(width, ++currentDepth);
			}
		}
	}
	
	private void handle(RuntimeException e) {
		if(ignoreAndLog)
			exceptions.add(e);
		else
			throw e;
	}
	
	public List<RuntimeException> getLog() {
		return exceptions;
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
						} catch (RuntimeException e) {
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
			} catch (RuntimeException e) {
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
