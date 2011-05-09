package org.unicase.model.search.helper;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.jface.viewers.CheckboxTreeViewer;
import org.unicase.metamodel.MetamodelPackage;

/**
 * Helper class for the tree featuring the model types.
 * @author Markus Fischer
 *
 */
public class TypeTreeHelper {

	private static TypeTreeHelper instance;
	
	private TypeTreeHelper() {
	}
	
	/**
	 * @return An instance of the helper.
	 */
	public static TypeTreeHelper getInstance() {
		if (instance == null) {
			instance = new TypeTreeHelper();
		}
		return instance;
	}
	
	/**
	 * Searches all available and non-abstract EClasses for a given EPackage
	 * and returns it.
	 * @param parent the parent EPackage
	 * @return all non-abstract EClasses of this package
	 */
	private Set<EClass> getEClassList(EPackage parent) {
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
	
	/**
	 * Checks or unchecks all subpackages of a given package.
	 * @param currentPackage the package which is checked/unchecked
	 * @param check if true => check, false => uncheck
	 * @param viewer the CheckboxTreeViewer
	 */
	public void checkSubPackages(EPackage currentPackage, boolean check, CheckboxTreeViewer viewer) {
		if (currentPackage.getESubpackages().size() > 0) {
			for (EPackage ePackage : currentPackage.getESubpackages()) {
				checkSubPackages(ePackage, check, viewer);
			}
		}
		viewer.setGrayChecked(currentPackage, false);
		viewer.setChecked(currentPackage, check);
	}
	
	/**
	 * Updates the tree for a given class and checks/unchecks or gray checks the 
	 * parent package.
	 * @param currentClass the update is done for this class
	 * @param viewer the CheckboxTreeViewer
	 */
	public void updateTreeClasses(EClass currentClass, CheckboxTreeViewer viewer) {
		EPackage parent = currentClass.getEPackage();
		Set<EClass> tmpList = getEClassList(parent);
			
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
			viewer.setChecked(parent, false);
			viewer.setGrayChecked(parent, true);
		}
	}
	
	/**
	 * Returns all currently selected types of the tree.
	 * @param viewer the CheckboxTreeViewer
	 * @return List of currently selected types
	 */
	public List<EClass> getSelectedTypes(CheckboxTreeViewer viewer) {
		Object[] checked = viewer.getCheckedElements();
		List<EClass> checkedTypes = new ArrayList<EClass>();
		for (int i = 0; i < checked.length; i++) {
			if (!(checked[i] instanceof EPackage)) {
				checkedTypes.add((EClass) checked[i]); 
			}
		}
		return checkedTypes;
	}
	
}
