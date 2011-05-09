package org.unicase.model.search.comparator;

import java.util.Comparator;

import org.eclipse.emf.ecore.EPackage;

/**
 * Compares the name attribute of two EPackages.
 * @author Markus Fischer
 *
 */
public class EPackageNameComparator implements Comparator<EPackage> {

	@Override
	public int compare(EPackage arg0, EPackage arg1) {
		String name1 = arg0.getName();
		String name2 = arg1.getName();
		
		return name1.compareTo(name2);
	}

}
