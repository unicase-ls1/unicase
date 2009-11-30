/**
 * <copyright> Copyright (c) 2008-2009 Jonas Helming, Maximilian Koegel. All rights reserved. This program and the
 * accompanying materials are made available under the terms of the Eclipse Public License v1.0 which accompanies this
 * distribution, and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>
 */
package org.unicase.ui.meeditor;

import java.util.Comparator;
import java.util.HashMap;
import java.util.PriorityQueue;

import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IConfigurationElement;
import org.eclipse.core.runtime.Platform;
import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.edit.domain.EditingDomain;
import org.eclipse.emf.edit.provider.IItemPropertyDescriptor;
import org.eclipse.ui.forms.widgets.FormToolkit;
import org.unicase.metamodel.ModelElement;
import org.unicase.ui.meeditor.mecontrols.AbstractMEControl;
import org.unicase.workspace.util.WorkspaceUtil;

/**
 * Factory for generating {@link AbstractMEControl}'s according to a {@link IItemPropertyDescriptor}.
 * 
 * @author shterev
 */
public class ControlFactory {
	private final ModelElement modelElement;
	private final EditingDomain editingDomain;
	private FormToolkit toolkit;
	private HashMap<Class<? extends Object>, PriorityQueue<AbstractMEControl>> controlRegistry;

	/**
	 * Compares two MEControls according to the priority they returned.
	 * 
	 * @author shterev
	 */
	private class ControlComparator implements Comparator<AbstractMEControl> {

		/**
		 * {@inheritDoc}
		 */
		public int compare(AbstractMEControl o1, AbstractMEControl o2) {
			Integer i1 = priorityRegistry.get(o1);
			Integer i2 = priorityRegistry.get(o2);
			if (i1 == null) {
				return -1;
			} else if (i2 == null) {
				return 1;
			} else {
				return i1.intValue() - i2.intValue();
			}
		}

	}

	private HashMap<AbstractMEControl, Integer> priorityRegistry;
	private ControlComparator controlComparator;

	/**
	 * Default constructor.
	 * 
	 * @param editingDomain the editing domain
	 * @param modelElement the model element
	 * @param toolkit the gui toolkit
	 */
	public ControlFactory(EditingDomain editingDomain, ModelElement modelElement, FormToolkit toolkit) {
		this.editingDomain = editingDomain;
		this.modelElement = modelElement;
		this.toolkit = toolkit;

		controlComparator = new ControlComparator();
		controlRegistry = new HashMap<Class<? extends Object>, PriorityQueue<AbstractMEControl>>();
		priorityRegistry = new HashMap<AbstractMEControl, Integer>();
	}

	private void addToControlRegistry(Class<? extends Object> clazz, AbstractMEControl control, int priority) {
		PriorityQueue<AbstractMEControl> priorityQueue = controlRegistry.get(clazz);
		if (priorityQueue == null) {
			priorityQueue = new PriorityQueue<AbstractMEControl>(10, controlComparator);
			controlRegistry.put(clazz, priorityQueue);
		}
		priorityQueue.add(control);
		priorityRegistry.put(control, priority);
	}

	/**
	 * Creates a {@link AbstractMEControl} according to the {@link IItemPropertyDescriptor}.
	 * 
	 * @param itemPropertyDescriptor the descriptor
	 * @return the {@link AbstractMEControl}
	 */
	@SuppressWarnings("unchecked")
	public AbstractMEControl createControl(IItemPropertyDescriptor itemPropertyDescriptor) {

		EStructuralFeature feature = (EStructuralFeature) itemPropertyDescriptor.getFeature(modelElement);
		if (feature instanceof EAttribute) {
			Class<?> instanceClass = ((EAttribute) feature).getEAttributeType().getInstanceClass();
			IConfigurationElement[] config = Platform.getExtensionRegistry().getConfigurationElementsFor(
				"org.unicase.ui.meeditor.attributecontrols");
			for (IConfigurationElement e : config) {
				try {
					String type = e.getAttribute("type");
					Class<?> resolvedType = Class.forName(type);
					if (resolvedType.getSimpleName().equalsIgnoreCase(instanceClass.getSimpleName())) {
						AbstractMEControl newControl = (AbstractMEControl) e.createExecutableExtension("class");
						int prio = newControl.init(itemPropertyDescriptor, modelElement, editingDomain, toolkit);
						addToControlRegistry(instanceClass, newControl, prio);
					} else {
						controlRegistry.put(instanceClass, new PriorityQueue<AbstractMEControl>());
					}
				} catch (CoreException e1) {
					WorkspaceUtil.logException(e1.getMessage(), e1);
				} catch (ClassNotFoundException e1) {
					WorkspaceUtil.logException(e1.getMessage(), e1);
				}
			}
			AbstractMEControl ret = controlRegistry.get(instanceClass).peek();
			controlRegistry.clear();
			priorityRegistry.clear();
			return ret;
		} else if (feature instanceof EReference) {
			Class<?> instanceClass = ((EReference) feature).getEReferenceType().getInstanceClass();
			IConfigurationElement[] config = Platform.getExtensionRegistry().getConfigurationElementsFor(
				"org.unicase.ui.meeditor.referencecontrols");
			for (IConfigurationElement e : config) {
				try {
					Class<? extends ModelElement> type = (Class<? extends ModelElement>) e
						.createExecutableExtension("type");
					if (type.equals(instanceClass)) {
						AbstractMEControl newControl = (AbstractMEControl) e.createExecutableExtension("class");
						int prio = newControl.init(itemPropertyDescriptor, modelElement, editingDomain, toolkit);
						addToControlRegistry(instanceClass, newControl, prio);
					} else {
						controlRegistry.put(instanceClass, new PriorityQueue<AbstractMEControl>());
					}
				} catch (CoreException e1) {
					WorkspaceUtil.logException(e1.getMessage(), e1);
				}
			}
			controlRegistry.put(instanceClass, new PriorityQueue<AbstractMEControl>());
			AbstractMEControl ret = controlRegistry.get(instanceClass).peek();
			controlRegistry.clear();
			priorityRegistry.clear();
			return ret;
		}

		return null;
		// TODO: Add other types
	}
	// private AbstractMEControl createAttributeControl(IItemPropertyDescriptor itemPropertyDescriptor,
	// EStructuralFeature
	// feature) {
	// if (feature.getName().equalsIgnoreCase("fileName")) {
	// return createMEFileChooserControl((EAttribute) feature);
	// }
	// if (feature.getName().equalsIgnoreCase("fileSize")) {
	// return createMEFileSizeControl((EAttribute) feature);
	// }
	// if (feature.getName().equalsIgnoreCase("email")) {
	// return createMEEmailControl((EAttribute) feature);
	//
	// }
	// if (feature.getName().equalsIgnoreCase("url")) {
	// return createMEURLControl();
	// }
	// if (itemPropertyDescriptor.isMultiLine(modelElement)) {
	// return createMERichTextControl((EAttribute) feature);
	// }
	// return createGenericAttributeControl(itemPropertyDescriptor, feature);
	// }
	//
	// private AbstractMEControl createGenericAttributeControl(IItemPropertyDescriptor itemPropertyDescriptor,
	// EStructuralFeature feature) {
	// if (feature.getEType().getInstanceClass().equals(boolean.class)) {
	// return createMEBoolControl((EAttribute) feature);
	// }
	// if (feature.getEType().getInstanceClass().equals(int.class)) {
	// return createMEIntControl((EAttribute) feature);
	// }
	// if (feature.getEType().getInstanceClass().equals(Date.class)) {
	// return createMEDateControl((EAttribute) feature);
	// }
	// if (feature.getEType() instanceof EEnum) {
	// return createMEEnumControl((EAttribute) feature);
	// }
	// return createMETextControl((EAttribute) feature, itemPropertyDescriptor);
	// }

	/**
	 * Create Control for AssessmentMatrix.
	 * 
	 * @param modelElement the model element
	 * @param toolkit the tool kit
	 * @param editingDomain the editing domain
	 * @return a AbstractMEControl
	 */
	// public static AbstractMEControl createMEIssueAssessmentMatrixControl(Issue modelElement, FormToolkit toolkit,
	// EditingDomain editingDomain) {
	//
	// return new AssessmentMatrixControl(modelElement, toolkit, editingDomain);
	// }
}
