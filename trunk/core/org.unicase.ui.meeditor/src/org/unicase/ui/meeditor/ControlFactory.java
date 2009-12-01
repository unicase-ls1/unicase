/**
 * <copyright> Copyright (c) 2008-2009 Jonas Helming, Maximilian Koegel. All rights reserved. This program and the
 * accompanying materials are made available under the terms of the Eclipse Public License v1.0 which accompanies this
 * distribution, and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>
 */
package org.unicase.ui.meeditor;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;

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
	private HashMap<Class<?>, ArrayList<AbstractMEControl>> controlRegistry;

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
			if (i1 == null && i2 != null) {
				return -1;
			} else if (i1 != null && i2 == null) {
				return 1;
			} else if (i1 == null && i2 == null) {
				return 0;
			} else {
				return i2.intValue() - i1.intValue();
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
	}

	private void addToControlRegistry(Class<?> clazz, AbstractMEControl control, int priority) {
		ArrayList<AbstractMEControl> priorityQueue = controlRegistry.get(clazz);
		if (priorityQueue == null) {
			priorityQueue = new ArrayList<AbstractMEControl>();
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
	public AbstractMEControl createControl(IItemPropertyDescriptor itemPropertyDescriptor) {
		controlComparator = new ControlComparator();
		controlRegistry = new HashMap<Class<?>, ArrayList<AbstractMEControl>>();
		priorityRegistry = new HashMap<AbstractMEControl, Integer>();

		EStructuralFeature feature = (EStructuralFeature) itemPropertyDescriptor.getFeature(modelElement);
		if (feature instanceof EAttribute) {
			return createAttribute(itemPropertyDescriptor, feature);
		}
		// else if (feature instanceof EReference) {
		// return createReferenceControl(itemPropertyDescriptor, feature);
		// }

		return null;
	}

	private AbstractMEControl createReferenceControl(IItemPropertyDescriptor itemPropertyDescriptor,
		EStructuralFeature feature) {
		Class<?> instanceClass = ((EReference) feature).getEReferenceType().getInstanceClass();
		IConfigurationElement[] config = Platform.getExtensionRegistry().getConfigurationElementsFor(
			"org.unicase.ui.meeditor.referencecontrols");
		for (IConfigurationElement e : config) {
			try {
				String type = e.getAttribute("type");
				Class<?> resolvedType = Class.forName(type);
				if (resolvedType.isAssignableFrom(instanceClass)) {
					AbstractMEControl newControl = (AbstractMEControl) e.createExecutableExtension("class");
					Boolean showLabel = new Boolean(e.getAttribute("showLabel"));
					newControl.setShowLabel(showLabel);
					int prio = newControl.init(itemPropertyDescriptor, modelElement, editingDomain, toolkit);
					addToControlRegistry(instanceClass, newControl, prio);
				}
			} catch (CoreException e1) {
				WorkspaceUtil.logException(e1.getMessage(), e1);
			} catch (ClassNotFoundException e1) {
				WorkspaceUtil.logException(e1.getMessage(), e1);
			}
		}
		ArrayList<AbstractMEControl> priorityQueue = controlRegistry.get(instanceClass);
		if (priorityQueue != null) {
			Collections.sort(priorityQueue, controlComparator);
			AbstractMEControl ret = priorityQueue.get(0);
			return ret;
		}
		return null;
	}

	private AbstractMEControl createAttribute(IItemPropertyDescriptor itemPropertyDescriptor, EStructuralFeature feature) {
		Class<?> instanceClass = ((EAttribute) feature).getEAttributeType().getInstanceClass();
		IConfigurationElement[] config = Platform.getExtensionRegistry().getConfigurationElementsFor(
			"org.unicase.ui.meeditor.attributecontrols");
		for (IConfigurationElement e : config) {
			try {
				String type = e.getAttribute("type");
				Class<?> resolvedType = Class.forName(type);
				if (resolvedType.getSimpleName().equalsIgnoreCase(instanceClass.getSimpleName())) {
					AbstractMEControl newControl = (AbstractMEControl) e.createExecutableExtension("class");
					Boolean showLabel = new Boolean(e.getAttribute("showLabel"));
					newControl.setShowLabel(showLabel);
					int prio = newControl.init(itemPropertyDescriptor, modelElement, editingDomain, toolkit);
					addToControlRegistry(instanceClass, newControl, prio);
				}
			} catch (CoreException e1) {
				WorkspaceUtil.logException(e1.getMessage(), e1);
			} catch (ClassNotFoundException e1) {
				WorkspaceUtil.logException(e1.getMessage(), e1);
			}
		}
		ArrayList<AbstractMEControl> priorityQueue = controlRegistry.get(instanceClass);
		if (priorityQueue != null) {
			Collections.sort(priorityQueue, controlComparator);
			AbstractMEControl ret = priorityQueue.get(0);
			return ret;
		}
		return null;
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
