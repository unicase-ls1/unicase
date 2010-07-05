package org.unicase.model.search.helper;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.jface.viewers.CheckboxTreeViewer;
import org.unicase.metamodel.MetamodelPackage;
import org.unicase.metamodel.util.ModelUtil;

public class TypeTreeHelper {

	private static TypeTreeHelper instance;
	
	private Set<EPackage> modelPackages;
	
	private TypeTreeHelper() {
		modelPackages = ModelUtil.getAllModelPackages();
		ArrayList<EPackage> toRemove = new ArrayList<EPackage>();
		
		// remove the modelPackages that don't have any selectable Modelelement
		for (EPackage ePackage : modelPackages) {
			EList<EClassifier> classifiers = ePackage.getEClassifiers();
			boolean foundElement = false;
			for (EClassifier eClassifier : classifiers) {
				if (eClassifier instanceof EClass) {
					EClass eClass = (EClass) eClassifier;
					if (MetamodelPackage.eINSTANCE.getModelElement().isSuperTypeOf(eClass)
						&& !MetamodelPackage.eINSTANCE.getNonDomainElement().isSuperTypeOf(eClass)
						&& !eClass.isAbstract()) {
						foundElement = true;
						break;
					}
				}
			}
			
			if (!foundElement) {
				toRemove.add(ePackage);
			}
		}
		modelPackages.removeAll(toRemove);
	}
	
	public static TypeTreeHelper getInstance() {
		if (instance == null) {
			instance = new TypeTreeHelper();
		}
		return instance;
	}
	
	public Set<EClass> getEClassList(EPackage parent) {
		Set<EClass> tmpList = new HashSet<EClass>();
		
		for (EClassifier classifier : parent.getEClassifiers()) {
			if (classifier instanceof EClass) {
				EClass subEClass = (EClass) classifier;
				if (MetamodelPackage.eINSTANCE.getModelElement().isSuperTypeOf(subEClass)
					&& !MetamodelPackage.eINSTANCE.getNonDomainElement().isSuperTypeOf(subEClass)
					&& !subEClass.isAbstract()) {
					tmpList.add(subEClass);
				}
			}
		}
		return tmpList;
	}
	
	public EList<EPackage> getESubPackages(EPackage parent) {
		EList<EPackage> subPackages = parent.getESubpackages();
		subPackages.retainAll(modelPackages);
		return subPackages;
	}
	
	public void checkSubPackages(EPackage currentPackage, boolean check, CheckboxTreeViewer viewer) {
		if (currentPackage.getESubpackages().size() > 0) {
			for (EPackage ePackage : currentPackage.getESubpackages()) {
				checkSubPackages(ePackage, check, viewer);
			}
		}
		viewer.setGrayChecked(currentPackage, false);
		viewer.setChecked(currentPackage, check);
	}
	
	public void updateTreePackages(EPackage currentPackage, CheckboxTreeViewer viewer) {
		while (currentPackage.getESuperPackage() != null) {
			EPackage superPackage = currentPackage.getESuperPackage();
			EList<EPackage> subPackages = TypeTreeHelper.getInstance().getESubPackages(superPackage);
			boolean allChecked = true;
			boolean allNotChecked = true;
			boolean grayed = false;
			for (EPackage ePackage : subPackages) {
				if (viewer.getChecked(ePackage)) {
					allNotChecked = false;
				} else {
					allChecked = false;
				}
				
				if (viewer.getGrayed(ePackage)) {
					grayed = true;
				}
			}
			
			if ((allChecked || allNotChecked) && !grayed) {
				if (viewer.getGrayed(superPackage)) {
					viewer.setGrayChecked(superPackage, false);
				}
				viewer.setChecked(superPackage, allChecked);
			} else if ((!allChecked && !allNotChecked) || grayed) {
				viewer.setGrayChecked(superPackage, true);
			}
			
			currentPackage = superPackage;
		}		
	}
	
	public void updateTreeClasses(EClass currentClass, CheckboxTreeViewer viewer) {
		EPackage parent = currentClass.getEPackage();
		Set<EClass> tmpList = TypeTreeHelper.getInstance().getEClassList(parent);
			
		boolean allChecked = true;
		boolean allNotChecked = true;
		
		for (EObject eObject : tmpList) {
			if (viewer.getChecked(eObject)) {
				allNotChecked = false;
			} else {
				allChecked = false;
			}
		}
			
		if (allChecked || allNotChecked) {
			if (viewer.getGrayed(parent)) {
				viewer.setGrayChecked(parent, false);
			}
			viewer.setChecked(parent, allChecked);
		} else if (!allChecked && !allNotChecked) {
			viewer.setGrayChecked(parent, true);
		}
	}
	
}
