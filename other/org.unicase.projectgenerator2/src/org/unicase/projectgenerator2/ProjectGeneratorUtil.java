package org.unicase.projectgenerator2;

import java.util.HashSet;
import java.util.Set;
import java.util.Map.Entry;

import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EPackage.Registry;
import org.unicase.metamodel.MetamodelPackage;

public class ProjectGeneratorUtil {

	public static Set<EPackage> getAllModelPackages() {
		Set<EPackage> result = new HashSet<EPackage>();
		Registry registry = EPackage.Registry.INSTANCE;

		for (Entry<String, Object> entry : registry.entrySet()) {
			try {
				System.out.println(entry.getKey());
				EPackage model = EPackage.Registry.INSTANCE.getEPackage(entry.getKey());
				result.add(model);
			}
			// BEGIN SUPRESS CATCH EXCEPTION
			catch (RuntimeException exception) {
				// END SUPRESS CATCH EXCEPTION
				//logException("Failed to load model package " + entry.getKey(), exception);
			}
		}
		return result;
	}
}
