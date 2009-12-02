package org.unicase.ui.meeditor.mecontrols.melinkcontrol;

import java.util.ArrayList;
import java.util.HashMap;

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
			"org.unicase.ui.meeditor.melinkcontrol");

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
		Object feature = itemPropertyDescriptor.getFeature(contextModelElement);
		ArrayList<MELinkControl> candidates = controlRegistry.get(feature);
		if (candidates != null) {
			MELinkControl control = getBestCandidate(candidates, itemPropertyDescriptor, contextModelElement,
				contextModelElement);
			if (control != null) {
				return control;
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
