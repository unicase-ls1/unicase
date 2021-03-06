package org.unicase.ui.meeditor.mecontrols.melinkcontrol;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Set;

import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IConfigurationElement;
import org.eclipse.core.runtime.Platform;
import org.eclipse.emf.edit.provider.IItemPropertyDescriptor;
import org.unicase.metamodel.ModelElement;
import org.unicase.workspace.util.WorkspaceUtil;

public class MELinkControlFactory {
	private HashMap<Class<?>, ArrayList<MELinkControl>> controlRegistry;

	public MELinkControlFactory() {
		controlRegistry = new HashMap<Class<?>, ArrayList<MELinkControl>>();
		initializeMEControls();
	}

	private void initializeMEControls() {
		IConfigurationElement[] linkControls = Platform.getExtensionRegistry().getConfigurationElementsFor(
			"org.unicase.ui.meeditor.melinkcontrols");

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
				WorkspaceUtil.logException(e1.getMessage(), e1);
			} catch (CoreException e2) {
				WorkspaceUtil.logException(e2.getMessage(), e2);
			}
		}

	}

	public MELinkControl createMELinkControl(IItemPropertyDescriptor itemPropertyDescriptor, final ModelElement link,
		ModelElement contextModelElement) {
		ArrayList<MELinkControl> candidates = new ArrayList<MELinkControl>();
		Set<Class<?>> keySet = controlRegistry.keySet();
		for (Class<?> clazz : keySet) {
			if (clazz.isAssignableFrom(link.getClass())) {
				candidates.addAll(controlRegistry.get(clazz));
			}
		}

		MELinkControl control = getBestCandidate(candidates, itemPropertyDescriptor, link, contextModelElement);
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
		IItemPropertyDescriptor itemPropertyDescriptor, final ModelElement link, ModelElement contextModelElement) {
		int bestValue = 0;
		MELinkControl bestCandidate = null;
		for (MELinkControl abstractMEControl : candidates) {
			int newValue = abstractMEControl.canRender(itemPropertyDescriptor, link, contextModelElement);
			if (newValue > bestValue) {
				bestCandidate = abstractMEControl;
				bestValue = newValue;
			}
		}
		return bestCandidate;
	}
}
