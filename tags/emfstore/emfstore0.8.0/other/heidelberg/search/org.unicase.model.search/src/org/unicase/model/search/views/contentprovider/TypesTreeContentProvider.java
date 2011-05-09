package org.unicase.model.search.views.contentprovider;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.edit.provider.ComposedAdapterFactory;
import org.eclipse.emf.edit.ui.provider.AdapterFactoryContentProvider;
import org.unicase.metamodel.MetamodelPackage;
import org.unicase.metamodel.util.ModelUtil;
import org.unicase.metamodel.util.ModelUtil2;
import org.unicase.model.search.comparator.EPackageNameComparator;

/**
 * Content provider for the types tree, also sorts the types.
 * @author Markus Fischer
 *
 */
public class TypesTreeContentProvider extends AdapterFactoryContentProvider {

	
	private HashMap<String, EPackage> packages = new HashMap<String, EPackage>();
	private HashMap<String, EClass> modelElementClasses;
	
	/**
	 * Creates a new content provider.
	 */
	public TypesTreeContentProvider() {
		super(new ComposedAdapterFactory(ComposedAdapterFactory.Descriptor.Registry.INSTANCE));
		Set<EClass> eClasses = ModelUtil2.getAllModelElementEClasses();
		
		modelElementClasses = new HashMap<String, EClass>();
		for (EClass eClass : eClasses) {
			if (!isNonDomainElement(eClass) && !eClass.isAbstract()) {
				modelElementClasses.put(eClass.getEPackage().getName() + eClass.getName(), eClass);
			}
		}
		extractRootPackages(modelElementClasses);
	}
	
	/**
	 * {@inheritDoc} Return an array of sub-packages of Model package.
	 */
	@Override
	public Object[] getElements(Object inputElement) {
		List<EPackage> list = new ArrayList<EPackage>(packages.values());
		Collections.sort(list, new EPackageNameComparator());
		return list.toArray();
	}
	
	/**
	 * {@inheritDoc} Shows the children only when argument is an EPackage. Also doesn't show the Children that are.
	 * abstract or not ModelElement.
	 */
	@Override
	public Object[] getChildren(Object object) {
		// show the children only when argument is an EPackage.
		// Also remove the Children that are abstract or not ModelElement.
		if (object instanceof EPackage) {

			// remove classes that do not inherit ModelElement
			// or are abstract.
			Object[] children = super.getChildren(object);
			List<Object> ret = new ArrayList<Object>();
			for (int i = 0; i < children.length; i++) {
				Object child = children[i];
				if (child instanceof EPackage && (packages.containsValue(child))) {
					ret.add(child);
				}
				if (child instanceof EClass && modelElementClasses.containsValue(child)) {
					ret.add(child);
				}
			}
			return ret.toArray();

		} else {
			// for Children that are EClass, show nothing
			// Otherwise the EAttributes of EClass would be shown in tree
			return null;
		}

	}
	
	/**
	 * @return Set containing all packages
	 */
	public Set<EPackage> getPackagesSet() {
		return new HashSet<EPackage>(packages.values());
	}

	/**
	 * @return HashMap<String, EClass> which contains all types
	 */
	public HashMap<String, EClass> getClassesMap() {
		return modelElementClasses;
	}
	
	
	/**
	 * Checks if the argument is a NonDomainElement.
	 * 
	 * @param object EClass to be checked.
	 * @return
	 */
	private boolean isNonDomainElement(Object object) {
		return object instanceof EClass
			&& MetamodelPackage.eINSTANCE.getNonDomainElement().isSuperTypeOf((EClass) object);
	}
	
	/**
	 * Extracts all root packages of the types.
	 * @param eClasses HashMap containing the types
	 */
	private void extractRootPackages(HashMap<String, EClass> eClasses) {
		for (EClass eClass : eClasses.values()) {
			EPackage ePackage = eClass.getEPackage();
			if (!packages.containsKey(ePackage.getName())) {
				packages.put(ePackage.getName(), ePackage);
			}
		}
	}
}
