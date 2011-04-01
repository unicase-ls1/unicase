/*******************************************************************************
 * Copyright (c) 2008-2011 Chair for Applied Software Engineering, Technische Universitaet Muenchen.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 ******************************************************************************/
package org.eclipse.emf.ecp.editor.mecontrols.melinkcontrol;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Set;

import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IConfigurationElement;
import org.eclipse.core.runtime.Platform;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecp.editor.Activator;
import org.eclipse.emf.ecp.model.ECPModelelementContext;
import org.eclipse.emf.edit.provider.IItemPropertyDescriptor;

public class MELinkControlFactory {
	private HashMap<Class<?>, ArrayList<MELinkControl>> controlRegistry;

	public MELinkControlFactory() {
		controlRegistry = new HashMap<Class<?>, ArrayList<MELinkControl>>();
		initializeMEControls();
	}

	private void initializeMEControls() {
		IConfigurationElement[] linkControls = Platform.getExtensionRegistry().getConfigurationElementsFor(
			"org.eclipse.emf.ecp.editor.melinkcontrols");

		for (IConfigurationElement e : linkControls) {
			String type = e.getAttribute("type");
			try {
				Class<?> resolvedType = Class.forName(type);
				MELinkControl control = (MELinkControl) e.createExecutableExtension("class");
				ArrayList<MELinkControl> list = controlRegistry.get(resolvedType);
				if (list == null) {
					list = new ArrayList<MELinkControl>();
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

	public MELinkControl createMELinkControl(IItemPropertyDescriptor itemPropertyDescriptor, final EObject link,
		EObject contextModelElement) {
		return createMELinkControl(itemPropertyDescriptor, link, contextModelElement, null);
	}

	public MELinkControl createMELinkControl(IItemPropertyDescriptor itemPropertyDescriptor, final EObject link,
		EObject contextModelElement, ECPModelelementContext context) {
		ArrayList<MELinkControl> candidates = new ArrayList<MELinkControl>();
		Set<Class<?>> keySet = controlRegistry.keySet();
		for (Class<?> clazz : keySet) {
			if (clazz.isAssignableFrom(link.getClass())) {
				candidates.addAll(controlRegistry.get(clazz));
			}
		}

		MELinkControl control = getBestCandidate(candidates, itemPropertyDescriptor, link, contextModelElement, context);
		if (control != null) {
			try {
				return control.getClass().newInstance();
			} catch (InstantiationException e) {
				// Do nothing
			} catch (IllegalAccessException e) {
				// Do nothing
			}
		}

		// Default case
		return new MELinkControl();
	}

	private MELinkControl getBestCandidate(ArrayList<MELinkControl> candidates,
		IItemPropertyDescriptor itemPropertyDescriptor, final EObject link, EObject contextModelElement,
		ECPModelelementContext context) {
		int bestValue = 0;
		MELinkControl bestCandidate = null;
		for (MELinkControl abstractMEControl : candidates) {
			abstractMEControl.setContext(context);
			int newValue = abstractMEControl.canRender(itemPropertyDescriptor, link, contextModelElement);
			if (newValue > bestValue) {
				bestCandidate = abstractMEControl;
				bestValue = newValue;
			}
		}
		return bestCandidate;
	}
}
