/**
 * <copyright> Copyright (c) 2008-2009 Jonas Helming, Maximilian Koegel. All rights reserved. This program and the
 * accompanying materials are made available under the terms of the Eclipse Public License v1.0 which accompanies this
 * distribution, and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>
 */
package org.unicase.ui.urml.reviewview;

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
 * Factory for generating {@link AbstractDisplayControl}'s according to a {@link IItemPropertyDescriptor}.
 * 
 * @author kterzieva
 */
public class DisplayControlFactory {
	private static final String EXTENSION_POINT_ID = "org.unicase.stakeholders.displaycontrols";

	// controlRegistry mapps key to values. Key are the classes, values are the controls
	private HashMap<Class<?>, ArrayList<AbstractDisplayControl>> controlRegistry;

	/**
	 * Default constructor.
	 */
	public DisplayControlFactory() {
		// warum ArrayList?
		controlRegistry = new HashMap<Class<?>, ArrayList<AbstractDisplayControl>>();
		initializeReviewViewControls();
	}

	private void initializeReviewViewControls() {
		// gib mir alle extension von dem extension point (org.unicase.ui.meeditor.attributecontrols)
		// array aus extension is IConfigurationElement[]
		IConfigurationElement[] displayControls = Platform.getExtensionRegistry().getConfigurationElementsFor(
			EXTENSION_POINT_ID);
		ArrayList<IConfigurationElement> controls = new ArrayList<IConfigurationElement>();
		controls.addAll(Arrays.asList(displayControls));
		// allControls.addAll(Arrays.asList(referencecontrols));
		// sortiert die types(String, int..) mit den registrierten Controller, die type als rückgabewert
		for (IConfigurationElement e : controls) {
			String type = e.getAttribute("type");
			try {
				// type = java.lang.Boolean, liefert die klasse Boolean zurück als "resolvedType"
				//
				Class<?> resolvedType = Class.forName(type);
				// new object (instance) von der Controlle.. bei uns SingeLineDispay
				AbstractDisplayControl control = (AbstractDisplayControl) e.createExecutableExtension("class");
				// zeigt an welcher Wert "show label" hat
				boolean showLabel = Boolean.parseBoolean(e.getAttribute("showLabel"));
				// kopiert den wert in die neue instance
				control.setShowLabel(showLabel);
				// gibt alle mit z.b String als resolvedType zurück, nur diese sind relevant
				// hier werden die SingleLineDipslay und MultiLineDisplay in der list enthalten
				ArrayList<AbstractDisplayControl> list = controlRegistry.get(resolvedType);
				if (list == null) {
					list = new ArrayList<AbstractDisplayControl>();
				}
				list.add(control);
				// alle Klassen, die der selben resolvedType haben werde in der
				// controlRegistry eingefügt
				controlRegistry.put(resolvedType, list);

			} catch (ClassNotFoundException e1) {
				e1.printStackTrace();
				//
				// WorkspaceUtil.logException("", e1);
			} catch (CoreException e2) {
				e2.printStackTrace();
				// WorkspaceUtil.logException("", e2);
			}
		}

	}

	/**
	 * Creates a {@link AbstractDisplayControl} according to the {@link IItemPropertyDescriptor}.
	 * 
	 * @param itemPropertyDescriptor the descriptor
	 * @param urmlElement the model element
	 * @return the {@link AbstractDisplayControl}
	 */

	public AbstractDisplayControl createDisplayControl(IItemPropertyDescriptor itemPropertyDescriptor,
		UrmlModelElement urmlElement) {
		Object feature = itemPropertyDescriptor.getFeature(urmlElement);
		if (feature instanceof EStructuralFeature) {
			// name is for example feature, type is string
			// instanceClass = string
			Class<?> featureClass = null;
			if (feature instanceof EAttribute) {
				featureClass = ((EAttribute) feature).getEAttributeType().getInstanceClass();
			} else if (feature instanceof EReference) {
				// featureClass = java.lang.String
				featureClass = ((EReference) feature).getEType().getInstanceClass();
			}

			// keySet beinhaltet alle Klassen
			Set<Class<?>> keySet = controlRegistry.keySet();
			ArrayList<AbstractDisplayControl> candidates = new ArrayList<AbstractDisplayControl>();
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
				// if candidateClass is superinterface or superclass of featureClass
				// zwei mal in die liste eintragen????
				if (candidateClass.isAssignableFrom(featureClass)) {
					// add alle Controller die instanceClass als resovedTyp haben
					candidates.addAll(controlRegistry.get(candidateClass));
				}
			}
			// best candidate should be shown with getShowLabel
			// candidats besteht aus alle Klassen die selben resovedType haben wie der Type von der feature
			// das angezeigt werden soll
			AbstractDisplayControl bestCandidate = getBestCandidate(candidates, itemPropertyDescriptor, urmlElement);
			AbstractDisplayControl displayControl = null;
			if (bestCandidate == null) {
				return null;
			}
			try {
				// create new one, reflection for new,
				displayControl = bestCandidate.getClass().newInstance();
				displayControl.setShowLabel(bestCandidate.getShowLabel());
			} catch (InstantiationException e) {
				// Do nothing
			} catch (IllegalAccessException e) {
				// Do nothing
			}
			return displayControl;

			// return createDisplayControl(itemPropertyDescriptor, feature, modelElement, context);
		}
		return null;
	}

	// candidates - list with the control candidates
	// itemPropertyDescriptor - one property like Name or Description
	// feature
	// modelElement

	private AbstractDisplayControl getBestCandidate(ArrayList<AbstractDisplayControl> candidates,
		IItemPropertyDescriptor itemPropertyDescriptor, UrmlModelElement urmlElement) {
		int bestValue = 0;
		AbstractDisplayControl bestCandidate = null;
		// geht die liste aus kandidaten durch und setzt den context??
		// ruft für jeden control dem seine canRender methode auf, das zurückgibt ob er für diesen
		// bestimmten properties geeignete anzeige-controle anbietet, höchste wert wird als gewählt
		for (AbstractDisplayControl displayControl : candidates) {
			// displayControl.setContext(context);
			// control mit höchste canRender-Methode wird ausgewählt
			int newValue = displayControl.canRender(itemPropertyDescriptor, urmlElement);
			if (newValue > bestValue) {
				bestCandidate = displayControl;
				bestValue = newValue;
			}
		}
		return bestCandidate;
	}

}
