/**
 * <copyright> Copyright (c) 2009-2012 Chair of Applied Software Engineering, Technische Universit�t M�nchen (TUM).
 * All rights reserved. This program and the accompanying materials are made available under the terms of
 * the Eclipse Public License v1.0 which accompanies this distribution,
 * and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>
 */
package org.unicase.ui.unicasecommon.navigator.wizards;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.edit.provider.ComposedAdapterFactory;
import org.eclipse.emf.edit.ui.provider.AdapterFactoryContentProvider;
import org.eclipse.emf.emfstore.client.ESLocalProject;
import org.eclipse.emf.emfstore.internal.client.model.ESWorkspaceProviderImpl;
import org.eclipse.emf.emfstore.internal.common.model.ModelPackage;
import org.unicase.ui.unicasecommon.common.util.UnicaseUiUtil;

/**
 * @author Hodaie ContentProvider for TreeViewer which is shown on ModelTreePage
 */
public class ModelTreeContentProvider extends AdapterFactoryContentProvider {

	/**
	 * Constructor.
	 */
	public ModelTreeContentProvider() {
		super(new ComposedAdapterFactory(
				ComposedAdapterFactory.Descriptor.Registry.INSTANCE));

	}

	/**
	 * {@inheritDoc} Return an array of sub-packages of Model package.
	 */
	@Override
	public Object[] getElements(Object inputElement) {
		Object[] array = UnicaseUiUtil.getAllModelPackages().toArray();
		ArrayList<Object> result = new ArrayList<Object>(array.length);
		for (Object object : array) {
			if (object instanceof EPackage) {
				Object[] children = getChildren(object);
				// only add packages that actually have children
				if (children != null && children.length > 0) {
					result.add(object);
				}
			} else {
				result.add(object);
			}
		}
		return result.toArray();
	}

	/**
	 * {@inheritDoc} Shows the children only when argument is an EPackage. Also
	 * doesn't show the Children that are. abstract or not ModelElement.
	 */
	@Override
	public Object[] getChildren(Object object) {
		// show the children only when argument is an EPackage.
		// Also remove the Children that are abstract or not ModelElement.
		if (object instanceof EPackage) {
			// Check if it is Diagram Package for special view
			// if (((EPackage) object).getName().equals("diagram")) {
			// return getDiagramTypes();
			// }

			// remove classes that do not inherit ModelElement
			// or are abstract.
			Object[] children = removeNonModelElements(super
					.getChildren(object));

			ESLocalProject context = ESWorkspaceProviderImpl.getInstance()
					.getWorkspace().getLocalProject((EObject) object);
			if (context == null) {
				return children;
			}
			// removes all AssociationClassElements
			LinkedList<Object> result = new LinkedList<Object>();
			for (Object item : children) {
				result.add(item);
			}

			return result.toArray();

		} else {
			// for Children that are EClass, show nothing
			// Otherwise the EAttributes of EClass would be shown in tree
			return null;
		}

	}

	// private Object[] getDiagramTypes() {
	// Object[] ret = new Object[DiagramType.values().length];
	// int i = 0;
	// for (DiagramType diagramType : DiagramType.values()) {
	// MEDiagram createMEDiagram = DiagramFactory.eINSTANCE.createMEDiagram();
	// createMEDiagram.setType(diagramType);
	// // createMEDiagram.setName(diagramType.getLiteral());
	// ret[i] = createMEDiagram;
	// i++;
	// }
	//
	// return ret;
	// }

	/**
	 * Removes class that are abstract or do not inherit ModelElement form a
	 * list of EClass.
	 * 
	 * @param items
	 *            list of EClass
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
	 * @param object
	 *            EClass to be checked.
	 * @return
	 */
	private boolean isNonDomainElement(Object object) {

		return object instanceof EClass
				&& ModelPackage.eINSTANCE.getNonDomainElement().isSuperTypeOf(
						(EClass) object);
	}

	/**
	 * Checks if the argument inherits ME and is not abstract.
	 * 
	 * @param object
	 *            EClass to be checked.
	 * @return
	 */
	private boolean isModelElement(Object object) {
		// if argument is instance of EClass and
		// it inherits ModelElement and it is not abstract
		// return true
		// TODO: any additional criteria?
		return object instanceof EClass
		// && ((EClass)
		// object).getEAllSuperTypes().contains(MetamodelPackage.eINSTANCE.getModelElement())
				&& !((EClass) object).isAbstract();
	}

	/**
	 * {@inheritDoc} If argument is an EClass return false. This is to prevent
	 * showing of the plus sign beside an. EClass in TreeViewer
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
