package org.unicase.util;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.Map.Entry;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.EcorePackage;
import org.eclipse.emf.ecore.EPackage.Registry;

public class UnicaseUtil {
	
	private static Set<EClass> modelElementEClasses;

	/**
	 * @param newMEInstance {@link EObject} the new modelElement instance.
	 * @return EReference the Container
	 * @param parent The EObject to get containment references from
	 */
	public static EReference getPossibleContainingReference(final EObject newMEInstance, EObject parent) {
		// the value of the 'EAll Containments' reference list.
		List<EReference> eallcontainments = parent.eClass().getEAllContainments();
		EReference reference = null;
		for (EReference containmentitem : eallcontainments) {

			EClass eReferenceType = containmentitem.getEReferenceType();
			if (eReferenceType.equals(newMEInstance)) {
				reference = containmentitem;

				break;
			} else if (eReferenceType.equals(EcorePackage.eINSTANCE.getEObject())
				|| eReferenceType.isSuperTypeOf(newMEInstance.eClass())) {
				reference = containmentitem;
				break;
			}
		}
		return reference;
	}
	
	/**
	 * Gives all eClasses which can be contained in a given eClass.
	 * 
	 * @param eClass the EClass
	 * @return all Classes which can be contained
	 */
	public static Set<EClass> getAllEContainments(EClass eClass) {
		List<EReference> containments = eClass.getEAllContainments();
		Set<EClass> eClazz = new HashSet<EClass>();
		for (EReference ref : containments) {
			EClass eReferenceType = ref.getEReferenceType();
			eClazz.addAll(getAllSubEClasses(eReferenceType));
		}
		return eClazz;
	}
	
	/**
	 * Retrieve all EClasses from the Ecore package registry that are subclasses of the given EClass. Does not include
	 * abstract classes or interfaces.
	 * 
	 * @param eClass the superClass of the subClasses to retrieve
	 * @return a set of EClasses
	 */
	public static Set<EClass> getAllSubEClasses(EClass eClass) {
		Set<EClass> allEClasses = getAllModelElementEClasses();
		if (EcorePackage.eINSTANCE.getEObject().equals(eClass)) {
			return allEClasses;
		}
		Set<EClass> result = new HashSet<EClass>();
		for (EClass subClass : allEClasses) {
			boolean isSuperTypeOf = eClass.isSuperTypeOf(subClass)
				|| eClass.equals(EcorePackage.eINSTANCE.getEObject());
			if (isSuperTypeOf && (!subClass.isAbstract()) && (!subClass.isInterface())) {
				result.add(subClass);
			}
		}
		return result;
	}
	
	/**
	 * Retrieve all EClasses from the Ecore package registry that are model element subclasses.
	 * 
	 * @return a set of EClasses
	 */
	public static Set<EClass> getAllModelElementEClasses() {
		if (modelElementEClasses != null) {
			return new HashSet<EClass>(modelElementEClasses);
		}
		Set<EClass> result = new HashSet<EClass>();
		Registry registry = EPackage.Registry.INSTANCE;

		for (Entry<String, Object> entry : new HashSet<Entry<String, Object>>(registry.entrySet())) {
			try {
				EPackage ePackage = EPackage.Registry.INSTANCE.getEPackage(entry.getKey());
				result.addAll(getAllModelElementEClasses(ePackage));
			}
			// BEGIN SUPRESS CATCH EXCEPTION
			catch (RuntimeException exception) {
				// TODO: ChainSaw
				// END SUPRESS CATCH EXCEPTION
//				logException("Failed to load model package " + entry.getKey(), exception);
			}

		}
		modelElementEClasses = result;
		return result;
	}
	
	/**
	 * Retrieve all EClasses from the Ecore package that are model element subclasses.
	 * 
	 * @param ePackage the package to get the classes from
	 * @return a set of EClasses
	 */
	private static Set<EClass> getAllModelElementEClasses(EPackage ePackage) {
		Set<EClass> result = new HashSet<EClass>();
		for (EPackage subPackage : ePackage.getESubpackages()) {
			result.addAll(getAllModelElementEClasses(subPackage));
		}
		for (EClassifier classifier : ePackage.getEClassifiers()) {
			if (classifier instanceof EClass) {
				EClass subEClass = (EClass) classifier;
				result.add(subEClass);
			}
		}
		return result;
	}
		
	/**
	 * Get the EContainer that contains the given model element and whose EContainer is null.
	 * 
	 * @param parent the Class of the parent
	 * @param child the model element whose container should get returned
	 * @return the container
	 */
	public static EObject getParent(Class<? extends EObject> parent, EObject child) {
		Set<EObject> seenModelElements = new HashSet<EObject>();
		seenModelElements.add(child);
		return getParent(parent, child, seenModelElements);
	}

	private static EObject getParent(Class<? extends EObject> parent, EObject child, Set<EObject> seenModelElements) {
		if (child == null) {
			return null;
		}

		if (seenModelElements.contains(child.eContainer())) {
			throw new IllegalStateException("ModelElement is in a containment cycle");
		}

		if (parent.isInstance(child)) {
			return child;
		} else {
			seenModelElements.add(child);
			return getParent(parent, child.eContainer(), seenModelElements);
		}
	}

	
}
