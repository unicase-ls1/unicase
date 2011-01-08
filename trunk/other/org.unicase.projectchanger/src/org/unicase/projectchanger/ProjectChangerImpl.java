package org.unicase.projectchanger;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.Set;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.common.util.TreeIterator;
import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.EcorePackage;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.jface.viewers.IStructuredSelection;

public class ProjectChangerImpl {

	final private Random random;
	final private StringBuffer string;
	final private Date date;
	final private Set<EObject> deletedObjects;
	final private Map<EClass, Set<EObject>> modelElementsByEClass;
	final private Map<EReference, List<EClass>> possibleReferenceClasses;
	
	public ProjectChangerImpl(long seed, EObject rootObject) {
		random = new Random(seed);
		string = new StringBuffer();
		date = new Date();
		deletedObjects = new LinkedHashSet<EObject>();
		modelElementsByEClass = new LinkedHashMap<EClass, Set<EObject>>();
		possibleReferenceClasses =  new LinkedHashMap<EReference, List<EClass>>();
		generateChanges(rootObject);
	}

	public ProjectChangerImpl(long seed, IStructuredSelection ssel) {
		random = new Random(seed);
		string = new StringBuffer();
		date = new Date();
		deletedObjects = new LinkedHashSet<EObject>();
		modelElementsByEClass = new LinkedHashMap<EClass, Set<EObject>>();
		possibleReferenceClasses =  new LinkedHashMap<EReference, List<EClass>>();
		if(!ssel.isEmpty()) {
			Object firstSelectedElement;
			firstSelectedElement = ssel.getFirstElement();
			if(firstSelectedElement instanceof EObject) {
				generateChanges(((EObject) firstSelectedElement));
			} else {
				throw new IllegalArgumentException("Selected element is no EObject!");
			}
		} else {
			throw new IllegalArgumentException("No EObject selected!");
		}
	}

	private void generateChanges(EObject rootObject) {
		List<EObject> allObjects = new ArrayList<EObject>();
		TreeIterator<EObject> allContents = rootObject.eAllContents();
		while(allContents.hasNext()) {
			allObjects.add(allContents.next());
		}
		for(EObject eObject : allObjects) {
			if(!deletedObjects.contains(eObject)) {
				if(random.nextDouble() < 0.1 && !eObject.equals(rootObject)) {
					deletedObjects.add(eObject);
					TreeIterator<EObject> childrenIterator = eObject.eAllContents();
					while(childrenIterator.hasNext()) {
						EObject childObject = childrenIterator.next();
						deletedObjects.add(childObject);
						
					}
					EcoreUtil.delete(eObject, true);
					continue;
				}
				if(modelElementsByEClass.containsKey(eObject.eClass())) {
					modelElementsByEClass.get(eObject.eClass()).add(eObject);
				} else {
					Set<EObject> newSet = new LinkedHashSet<EObject>();
					newSet.add(eObject);
					modelElementsByEClass.put(eObject.eClass(), newSet);
				}
			}
		}
		for(EObject deletedObject : deletedObjects) {
			if(modelElementsByEClass.containsKey(deletedObject.eClass()))
				modelElementsByEClass.get(deletedObject.eClass()).remove(deletedObject);
		}
		for(EClass eClass : modelElementsByEClass.keySet()) {
			for(EObject eObject : modelElementsByEClass.get(eClass)) {
				changeEObjectAttributes(eObject);
				changeEObjectReferences(eObject);
			}
		}
		
	}
	
	private void changeEObjectReferences(EObject newObject) {
		for(EReference reference : newObject.eClass().getEAllReferences()) {
			if(reference.isContainment() || reference.isContainer() || reference.isUnsettable() || reference.isVolatile() || reference.isTransient() || reference.isDerived() || !reference.isChangeable()) {
				continue;
			}
			newObject.eUnset(reference);
			List<EClass> possibleReferenceClasses = getPossibleReferenceClasses(reference); 
			boolean singleIsSet = false;
			for(EClass nextReferenceClass : possibleReferenceClasses) {
				if(singleIsSet)
					break;
				if(modelElementsByEClass.containsKey(nextReferenceClass)) {
					List<EObject> possibleReferenceObjects = new ArrayList<EObject>(modelElementsByEClass.get(nextReferenceClass)); 
					possibleReferenceObjects.remove(newObject);
					Collections.shuffle(possibleReferenceObjects, random);
					int size = possibleReferenceObjects.size();
					if(size > 0) {
						int index = 0;
						for(int i = 0; i < random.nextInt(3); i++) {
							EObject referencedObject = possibleReferenceObjects.get(index);
							if(reference.isMany()) {
								((List<EObject>) newObject.eGet(reference)).add(referencedObject);
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
			for(EClass eClass : modelElementsByEClass.keySet()) {
				if(referenceType.isSuperTypeOf(eClass)) {
					result.add(eClass);
				}
			}
			possibleReferenceClasses.put(reference, result);
			return result;
		}
	}
	
	private void changeEObjectAttributes(EObject newObject) {
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
}
