package org.unicase.modelchanger;

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

import org.eclipse.emf.common.util.TreeIterator;
import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.EcorePackage;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.emf.edit.command.AddCommand;
import org.eclipse.emf.edit.command.DeleteCommand;
import org.eclipse.emf.edit.command.RemoveCommand;
import org.eclipse.emf.edit.command.SetCommand;
import org.eclipse.emf.edit.domain.AdapterFactoryEditingDomain;
import org.eclipse.emf.edit.domain.EditingDomain;

public class ModelChanger {

	final private Random random;
	final private StringBuffer string;
	final private Date date;
	final private Set<EObject> objectsToDelete;
	final private Map<EClass, Set<EObject>> allObjectsByEClass;
	final private Map<EReference, List<EClass>> possibleReferenceClasses;
	private EditingDomain domain;
	
	public ModelChanger(long seed, EObject rootObject) {
		random = new Random(seed);
		string = new StringBuffer();
		date = new Date();
		objectsToDelete = new LinkedHashSet<EObject>();
		allObjectsByEClass = new LinkedHashMap<EClass, Set<EObject>>();
		possibleReferenceClasses =  new LinkedHashMap<EReference, List<EClass>>();
		generateChanges(rootObject);
	}

	public ModelChanger(long seed, IStructuredSelection ssel) {
		random = new Random(seed);
		string = new StringBuffer();
		date = new Date();
		objectsToDelete = new LinkedHashSet<EObject>();
		allObjectsByEClass = new LinkedHashMap<EClass, Set<EObject>>();
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
		domain = AdapterFactoryEditingDomain.getEditingDomainFor(rootObject);
		List<EObject> allObjects = new ArrayList<EObject>();
		TreeIterator<EObject> allContents = rootObject.eAllContents();
		allObjects.add(rootObject);
		while(allContents.hasNext()) {
			allObjects.add(allContents.next());
		}
		for(EObject eObject : allObjects) {
			if(!objectsToDelete.contains(eObject)) {
				if(random.nextDouble() < 0.1 && !eObject.equals(rootObject)) {
					objectsToDelete.add(eObject);
					TreeIterator<EObject> childrenIterator = eObject.eAllContents();
					while(childrenIterator.hasNext()) {
						objectsToDelete.add(childrenIterator.next());
					}
					continue;
				}
				if(allObjectsByEClass.containsKey(eObject.eClass())) {
					allObjectsByEClass.get(eObject.eClass()).add(eObject);
				} else {
					Set<EObject> newSet = new LinkedHashSet<EObject>();
					newSet.add(eObject);
					allObjectsByEClass.put(eObject.eClass(), newSet);
				}
			}
		}
		for(EObject deletedObject : objectsToDelete) {
			if(allObjectsByEClass.containsKey(deletedObject.eClass()))
				allObjectsByEClass.get(deletedObject.eClass()).remove(deletedObject);
		}
		new DeleteCommand(domain, objectsToDelete).execute();
		for(EClass eClass : allObjectsByEClass.keySet()) {
			for(EObject eObject : allObjectsByEClass.get(eClass)) {
				changeEObjectAttributes(eObject);
				changeEObjectReferences(eObject);
			}
		}
		
	}
	
	private void changeEObjectReferences(EObject newObject) {
		for(EReference reference : newObject.eClass().getEAllReferences()) {
			if(reference.isContainment() || reference.isContainer() || reference.isVolatile() || reference.isTransient() || reference.isDerived() || !reference.isChangeable() || (!reference.isMany() && newObject.eIsSet(reference))) {
				continue;
			}
			if(reference.isMany()) {
				new RemoveCommand(domain, newObject, reference, (List)newObject.eGet(reference)).doExecute();
			}
			List<EClass> possibleReferenceClasses = getPossibleReferenceClasses(reference); 
			for(EClass nextReferenceClass : possibleReferenceClasses) {
				if(allObjectsByEClass.containsKey(nextReferenceClass)) {
					List<EObject> possibleReferenceObjects = new ArrayList<EObject>(allObjectsByEClass.get(nextReferenceClass)); 
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
			for(EClass eClass : allObjectsByEClass.keySet()) {
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
			try {
				if(attribute.isMany()) {
					new RemoveCommand(domain, newObject, attribute, (List) newObject.eGet(attribute)).doExecute();
				}
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
}
