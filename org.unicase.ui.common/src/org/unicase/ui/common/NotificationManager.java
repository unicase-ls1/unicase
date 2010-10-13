/**
 * <copyright> Copyright (c) 2008-2009 Jonas Helming, Maximilian Koegel. All rights reserved. This program and the
 * accompanying materials are made available under the terms of the Eclipse Public License v1.0 which accompanies this
 * distribution, and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>
 */
package org.unicase.ui.common;

import java.util.ArrayList;
import java.util.Arrays;

import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IConfigurationElement;
import org.eclipse.core.runtime.Platform;
import org.eclipse.emf.ecore.EObject;

/**
 * Handles notifications to registered listeners.
 * 
 * @author helming
 */
public class NotificationManager implements ModelElementOpenListener, TraceListener {
	private static NotificationManager instance;
	private ArrayList<ModelElementOpenListener> openListeners = new ArrayList<ModelElementOpenListener>();
	private ArrayList<TraceListener> traceListeners = new ArrayList<TraceListener>();

	/**
	 * Default constructor.
	 */
	public NotificationManager() {
		IConfigurationElement[] modelelementOpenListener = Platform.getExtensionRegistry().getConfigurationElementsFor(
			"org.unicase.ui.common.modelelementopenlistener");
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
				traceListeners .add((TraceListener) e.createExecutableExtension("class"));
			} catch (CoreException e1) {
					Activator.getDefault().logException(e1);
			}
		}
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.unicase.ui.common.ModelElementOpenListener#onOpen(org.eclipse.emf.ecore.EObject, java.lang.String,
	 *      java.lang.String)
	 */
	public void onOpen(EObject opened, String sourceView, String openView) {
		for(ModelElementOpenListener listener: openListeners){
			listener.onOpen(opened, sourceView, openView);
		}

	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.unicase.ui.common.TraceListener#onTrace(org.eclipse.emf.ecore.EObject, org.eclipse.emf.ecore.EObject,
	 *      java.lang.String, java.lang.String)
	 */
	public void onTrace(EObject source, EObject target, String feature, String view) {
		for(TraceListener listener : traceListeners){
			listener.onTrace(source, target, feature, view);
		}

	}
	/**
	 * Singleton Pattern.
	 * @return the instance
	 */
	public static NotificationManager getInstance(){
		if (instance == null){
			instance= new NotificationManager();
		}
		return instance;
	}

}
