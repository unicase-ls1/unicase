package org.unicase.workspace.ui.util;

import java.util.ArrayList;
import java.util.Arrays;

import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IConfigurationElement;
import org.eclipse.core.runtime.Platform;

import com.sun.management.jmx.TraceListener;

public class ExtensionHelper {

	public ExtensionHelper() {
		IConfigurationElement[] modelelementOpenListener = Platform.getExtensionRegistry().getConfigurationElementsFor(
			"org.unicase.workspace.ui.modelelementopenlistener");
		IConfigurationElement[] traceListener = Platform.getExtensionRegistry().getConfigurationElementsFor(
			"org.unicase.ui.common.tracelistener");
		ArrayList<IConfigurationElement> openList = new ArrayList<IConfigurationElement>();
		ArrayList<IConfigurationElement> traceList = new ArrayList<IConfigurationElement>();
		openList.addAll(Arrays.asList(modelelementOpenListener));
		traceList.addAll(Arrays.asList(traceListener));
		for (IConfigurationElement e : openList) {
			try {
				openListeners.add((ModelElementOpenListener) e.createExecutableExtension("class"));
			} catch (CoreException e1) {
				Activator.getDefault().logException(e1);
			}
		}
		for (IConfigurationElement e : traceList) {
			try {
				traceListeners.add((TraceListener) e.createExecutableExtension("class"));
			} catch (CoreException e1) {
				Activator.getDefault().logException(e1);
			}
		}
	}
}
