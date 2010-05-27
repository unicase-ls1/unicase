/**
 * <copyright> Copyright (c) 2008-2009 Jonas Helming, Maximilian Koegel. All rights reserved. This program and the
 * accompanying materials are made available under the terms of the Eclipse Public License v1.0 which accompanies this
 * distribution, and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>
 */
package org.unicase.ui.meeditor;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Set;

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

/**
 * Factory for generating {@link AbstractMEControl}'s according to a {@link IItemPropertyDescriptor}.
 * 
 * @author shterev
 */
public class ControlFactory {
	private HashMap<Class<?>, ArrayList<AbstractMEControl>> controlRegistry;

	/**
	 * Default constructor.
	 * 
	 * @param editingDomain the editing domain
	 * @param toolkit the gui toolkit
	 */
	public ControlFactory(EditingDomain editingDomain, FormToolkit toolkit) {
		controlRegistry = new HashMap<Class<?>, ArrayList<AbstractMEControl>>();
		initializeMEControls();
	}

	private void initializeMEControls() {
		IConfigurationElement[] attributecontrols = Platform.getExtensionRegistry().getConfigurationElementsFor(
			"org.unicase.ui.meeditor.attributecontrols");
		IConfigurationElement[] referencecontrols = Platform.getExtensionRegistry().getConfigurationElementsFor(
			"org.unicase.ui.meeditor.referencecontrols");
		ArrayList<IConfigurationElement> allControls = new ArrayList<IConfigurationElement>();
		allControls.addAll(Arrays.asList(attributecontrols));
		allControls.addAll(Arrays.asList(referencecontrols));
		for (IConfigurationElement e : allControls) {
			String type = e.getAttribute("type");
			try {
				Class<?> resolvedType = Class.forName(type);
				AbstractMEControl control = (AbstractMEControl) e.createExecutableExtension("class");
				boolean showLabel = Boolean.parseBoolean(e.getAttribute("showLabel"));
				control.setShowLabel(showLabel);
				ArrayList<AbstractMEControl> list = controlRegistry.get(resolvedType);
				if (list == null) {
					list = new ArrayList<AbstractMEControl>();
				}
				list.add(control);
				controlRegistry.put(resolvedType, list);

			} catch (ClassNotFoundException e1) {
				Activator.logException(e1);
			} catch (CoreException e2) {
				Activator.logException(e2);
			}
		}

	}

	/**
	 * Creates a {@link AbstractMEControl} according to the {@link IItemPropertyDescriptor}.
	 * 
	 * @param itemPropertyDescriptor the descriptor
	 * @param modelElement model element
	 * @return the {@link AbstractMEControl}
	 */
	public AbstractMEControl createControl(IItemPropertyDescriptor itemPropertyDescriptor, ModelElement modelElement) {

		EStructuralFeature feature = (EStructuralFeature) itemPropertyDescriptor.getFeature(modelElement);
		if (feature instanceof EAttribute) {
			return createAttribute(itemPropertyDescriptor, feature, modelElement);
		} else if (feature instanceof EReference) {
			return createReferenceControl(itemPropertyDescriptor, (EReference) feature, modelElement);
		}

		return null;
	}

	private AbstractMEControl createReferenceControl(IItemPropertyDescriptor itemPropertyDescriptor,
		EReference feature, ModelElement modelElement) {
		Class<?> instanceClass = feature.getEType().getInstanceClass();
		Set<Class<?>> keySet = controlRegistry.keySet();
		ArrayList<AbstractMEControl> candidates = new ArrayList<AbstractMEControl>();
		for (Class<?> clazz : keySet) {
			if (clazz.isAssignableFrom(instanceClass)) {
				candidates.addAll(controlRegistry.get(clazz));
			}
		}
		AbstractMEControl control = getBestCandidate(candidates, itemPropertyDescriptor, feature, modelElement);
		AbstractMEControl ret = null;
		if (control == null) {
			return null;
		}
		try {
			ret = control.getClass().newInstance();
			ret.setShowLabel(control.getShowLabel());
		} catch (InstantiationException e) {
			// Do nothing
		} catch (IllegalAccessException e) {
			// Do nothing
		}
		return ret;
	}

	private AbstractMEControl createAttribute(IItemPropertyDescriptor itemPropertyDescriptor,
		EStructuralFeature feature, ModelElement modelElement) {
		Class<?> instanceClass = ((EAttribute) feature).getEAttributeType().getInstanceClass();
		// Test which controls have a fitting type
		// TODO: could be chached?
		Set<Class<?>> keySet = controlRegistry.keySet();
		ArrayList<AbstractMEControl> candidates = new ArrayList<AbstractMEControl>();
		for (Class<?> clazz : keySet) {
			if (instanceClass.isPrimitive()) {
				try {
					Class<?> primitive = (Class<?>) clazz.getField("TYPE").get(null);
					if (primitive.equals(instanceClass)) {
						candidates.addAll(controlRegistry.get(clazz));
					}

				} catch (IllegalArgumentException e) {
					// Do nothing
				} catch (SecurityException e) {
					// Do nothing
				} catch (IllegalAccessException e) {
					// Do nothing
				} catch (NoSuchFieldException e) {
					// Do nothing
				}
			}
			if (clazz.isAssignableFrom(instanceClass)) {
				candidates.addAll(controlRegistry.get(clazz));
			}
		}
		AbstractMEControl control = getBestCandidate(candidates, itemPropertyDescriptor, feature, modelElement);
		AbstractMEControl ret = null;
		if (control == null) {
			return null;
		}
		try {
			ret = control.getClass().newInstance();
			ret.setShowLabel(control.getShowLabel());
		} catch (InstantiationException e) {
			// Do nothing
		} catch (IllegalAccessException e) {
			// Do nothing
		}
		return ret;

	}

	private AbstractMEControl getBestCandidate(ArrayList<AbstractMEControl> candidates,
		IItemPropertyDescriptor itemPropertyDescriptor, EStructuralFeature feature, ModelElement modelElement) {
		int bestValue = 0;
		AbstractMEControl bestCandidate = null;
		for (AbstractMEControl abstractMEControl : candidates) {

			int newValue = abstractMEControl.canRender(itemPropertyDescriptor, modelElement);
			if (newValue > bestValue) {
				bestCandidate = abstractMEControl;
				bestValue = newValue;
			}
		}
		return bestCandidate;
	}

}
