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
import java.util.Map.Entry;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EPackage.Registry;
import org.eclipse.emf.edit.provider.ComposedAdapterFactory;
import org.eclipse.emf.edit.ui.provider.AdapterFactoryContentProvider;
import org.unicase.metamodel.MetamodelPackage;

/**
 * @author Hodaie ContentProvider for TreeViewer which is shown on ModelTreePage
 */
public class ModelTreeContentProvider extends AdapterFactoryContentProvider {

	private final EClass selected;

	/**
	 * Constructor.
	 * 
	 * @param selected
	 */
	public ModelTreeContentProvider(EClass selected) {
		super(new ComposedAdapterFactory(ComposedAdapterFactory.Descriptor.Registry.INSTANCE));
		this.selected = selected;

	}

	/**
	 * {@inheritDoc} Return an array of sub-packages of Model package.
	 */
	@Override
	public Object[] getElements(Object inputElement) {
		// TODO: Make better
		Set<EPackage> result = new HashSet<EPackage>();
		Registry registry = EPackage.Registry.INSTANCE;
		Set<Entry<String, Object>> entrySet = registry.entrySet();
		for (Entry<String, Object> entry : entrySet) {
			if (entry.getKey().contains("library")) {
				EPackage model = EPackage.Registry.INSTANCE.getEPackage(entry.getKey());

				result.add(model);
			}
		}
		return result.toArray();
		// return ModelUtil.getAllModelPackages().toArray();
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
			// TODO: reactivate
			// removeNonModelElements(super.getChildren(object));
			return children;

		} else {
			// for Children that are EClass, show nothing
			// Otherwise the EAttributes of EClass would be shown in tree
			return null;
		}

	}

	/**
	 * Removes class that are abstract or do not inherit ModelElement form a list of EClass.
	 * 
	 * @param items list of EClass
	 * @return
	 */
	private Object[] removeNonModelElements(Object[] items) {
		List<EClass> modelElements = new ArrayList<EClass>();
		for (int i = 0; i < items.length; i++) {
			if (isModelElement(items[i]) && !isNonDomainElement(items[i])) {
				modelElements.add((EClass) items[i]);
			}
		}

		return modelElements.toArray();
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
	 * Checks if the argument inherits ME and is not abstract.
	 * 
	 * @param object EClass to be checked.
	 * @return
	 */
	private boolean isModelElement(Object object) {
		// if argument is instance of EClass and
		// it inherits ModelElement and it is not abstract
		// return true
		return object instanceof EClass
			&& ((EClass) object).getEAllSuperTypes().contains(MetamodelPackage.eINSTANCE.getModelElement())
			&& !((EClass) object).isAbstract();
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
			return super.hasChildren(object);
		}

	}

}
