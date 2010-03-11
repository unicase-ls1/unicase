/**
 * <copyright> Copyright (c) 2008-2009 Jonas Helming, Maximilian Koegel. All rights reserved. This program and the
 * accompanying materials are made available under the terms of the Eclipse Public License v1.0 which accompanies this
 * distribution, and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>
 */
package org.unicase.ui.navigator.wizards;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.edit.provider.ComposedAdapterFactory;
import org.eclipse.emf.edit.ui.provider.AdapterFactoryContentProvider;
import org.unicase.metamodel.MetamodelPackage;
import org.unicase.metamodel.util.ModelUtil;
import org.unicase.workspace.WorkspacePackage;

/**
 * @author Hodaie ContentProvider for TreeViewer which is shown on ModelTreePage
 */
public class ModelTreeContentProvider extends AdapterFactoryContentProvider {

	private final EClass selected;
	private Set<EPackage> packages = new HashSet<EPackage>();
	private HashSet<EClass> modelElementClasses;
	private Set<EPackage> rootPackages;

	/**
	 * Constructor.
	 * 
	 * @param selected the selected model element.
	 */
	public ModelTreeContentProvider(EClass selected) {
		super(new ComposedAdapterFactory(ComposedAdapterFactory.Descriptor.Registry.INSTANCE));
		this.selected = selected;
		Set<EClass> eClasses = ModelUtil.getAllModelElementEClasses();
		modelElementClasses = new HashSet<EClass>();
		rootPackages = new HashSet<EPackage>();
		for (EClass eClass : eClasses) {
			if (!isNonDomainElement(eClass) && !eClass.isAbstract()) {
				modelElementClasses.add(eClass);
			}
		}
		if (!(selected.equals(WorkspacePackage.eINSTANCE.getProjectSpace()))) {
			Set<EClass> allEContainments = ModelUtil.getAllEContainments(selected);
			modelElementClasses.retainAll(allEContainments);
		}
		sortPackages(modelElementClasses);

	}

	private void sortPackages(Set<EClass> eClasses) {
		for (EClass eClass : eClasses) {
			EPackage ePackage = eClass.getEPackage();
			packages.add(ePackage);

		}
		for (EPackage ePackage : packages) {
			packages.contains(ePackage.getESuperPackage());
			rootPackages.add(ePackage);
		}

	}

	/**
	 * {@inheritDoc} Return an array of sub-packages of Model package.
	 */
	@Override
	public Object[] getElements(Object inputElement) {
		return rootPackages.toArray();

		// // return ModelUtil.getAllModelPackages().toArray();
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
				if (child instanceof EPackage && (packages.contains(child))) {
					ret.add(child);
				}
				if (child instanceof EClass && modelElementClasses.contains(child)) {
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
	 * {@inheritDoc} If argument is an EClass return false. This is to prevent showing of the plus sign beside an.
	 * EClass in TreeViewer
	 */
	@Override
	public boolean hasChildren(Object object) {
		// to remove the plus signs that are shown
		// beside EClasses in the tree.
		if (object instanceof EClass) {
			return false;
		} else {
			Object[] children = getChildren(object);
			if (children != null) {
				return children.length > 0;
			} else {
				return false;
			}
		}

	}

}
