/**
 * <copyright> Copyright (c) 2008-2009 Jonas Helming, Maximilian Koegel. All rights reserved. This program and the
 * accompanying materials are made available under the terms of the Eclipse Public License v1.0 which accompanies this
 * distribution, and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>
 */
package org.unicase.ui.urml.stakeholders.review;

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
import org.eclipse.emf.edit.provider.IItemPropertyDescriptor;
import org.unicase.model.urml.UrmlModelElement;

/**
 * Factory for generating {@link AbstractControlBuilder}'s according to a {@link IItemPropertyDescriptor}.
 * 
 * @author kterzieva
 */
public class DisplayControlFactory {
	private static final String EXTENSION_POINT_ID = "org.unicase.stakeholders.displaycontrols";

	private HashMap<Class<?>, ArrayList<AbstractControlBuilder>> controlRegistry;

	/**
	 * Default constructor.
	 */
	public DisplayControlFactory() {
		controlRegistry = new HashMap<Class<?>, ArrayList<AbstractControlBuilder>>();
		initializeReviewViewControls();
	}

	private void initializeReviewViewControls() {
		IConfigurationElement[] displayControls = Platform.getExtensionRegistry().getConfigurationElementsFor(
			EXTENSION_POINT_ID);
		ArrayList<IConfigurationElement> controls = new ArrayList<IConfigurationElement>();
		controls.addAll(Arrays.asList(displayControls));
		for (IConfigurationElement e : controls) {
			String type = e.getAttribute("type");
			try {
				Class<?> resolvedType = Class.forName(type);
				AbstractControlBuilder control = (AbstractControlBuilder) e.createExecutableExtension("class");
				boolean showLabel = Boolean.parseBoolean(e.getAttribute("showLabel"));
				control.setShowLabel(showLabel);
				ArrayList<AbstractControlBuilder> list = controlRegistry.get(resolvedType);
				if (list == null) {
					list = new ArrayList<AbstractControlBuilder>();
				}
				list.add(control);
				controlRegistry.put(resolvedType, list);

			} catch (ClassNotFoundException e1) {
				e1.printStackTrace();
				// WorkspaceUtil.logException("", e1);
			} catch (CoreException e2) {
				e2.printStackTrace();
				// WorkspaceUtil.logException("", e2);
			}
		}

	}

	/**
	 * Creates a {@link AbstractControlBuilder} according to the {@link IItemPropertyDescriptor}.
	 * 
	 * @param itemPropertyDescriptor the descriptor
	 * @param urmlElement the model element
	 * @return the {@link AbstractControlBuilder}
	 */

	public AbstractControlBuilder createDisplayControl(IItemPropertyDescriptor itemPropertyDescriptor,
		UrmlModelElement urmlElement) {
		Object feature = itemPropertyDescriptor.getFeature(urmlElement);
		if (feature instanceof EStructuralFeature) {
			// name feature, type string
			// instanceClass = string
			Class<?> featureClass = null;
			if (feature instanceof EAttribute) {
				featureClass = ((EAttribute) feature).getEAttributeType().getInstanceClass();
			} else if (feature instanceof EReference) {
				// featureClass = java.lang.String
				featureClass = ((EReference) feature).getEType().getInstanceClass();
			}
			
			Set<Class<?>> keySet = controlRegistry.keySet();
			ArrayList<AbstractControlBuilder> candidates = new ArrayList<AbstractControlBuilder>();
			for (Class<?> candidateClass : keySet) {
				if (featureClass.isPrimitive()) {
					try {
						Class<?> primitive = (Class<?>) candidateClass.getField("TYPE").get(null);
						if (primitive.equals(featureClass)) {
							candidates.addAll(controlRegistry.get(candidateClass));
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
				
				if (candidateClass.isAssignableFrom(featureClass)) {
					candidates.addAll(controlRegistry.get(candidateClass));
				}
			}
		
			AbstractControlBuilder bestCandidate = getBestCandidate(candidates, itemPropertyDescriptor, urmlElement);
			AbstractControlBuilder displayControl = null;
			if (bestCandidate == null) {
				return null;
			}
			try {
				// create new one, reflection for new
				displayControl = bestCandidate.getClass().newInstance();
				displayControl.setShowLabel(bestCandidate.getShowLabel());
			} catch (InstantiationException e) {
				// Do nothing
			} catch (IllegalAccessException e) {
				// Do nothing
			}
			return displayControl;
		}
		return null;
	}

	// candidates - list with the control candidates
	// itemPropertyDescriptor - one property like Name or Description
	// feature
	// modelElement

	private AbstractControlBuilder getBestCandidate(ArrayList<AbstractControlBuilder> candidates,
		IItemPropertyDescriptor itemPropertyDescriptor, UrmlModelElement urmlElement) {
		int bestValue = 0;
		AbstractControlBuilder bestCandidate = null;
		for (AbstractControlBuilder displayControl : candidates) {
			int newValue = displayControl.canRender(itemPropertyDescriptor, urmlElement);
			if (newValue > bestValue) {
				bestCandidate = displayControl;
				bestValue = newValue;
			}
		}
		return bestCandidate;
	}

}
