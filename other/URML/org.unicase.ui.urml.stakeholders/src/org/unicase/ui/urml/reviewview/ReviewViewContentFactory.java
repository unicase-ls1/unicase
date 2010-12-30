/**
 * <copyright> Copyright (c) 2008-2009 Jonas Helming, Maximilian Koegel. All rights reserved. This program and the
 * accompanying materials are made available under the terms of the Eclipse Public License v1.0 which accompanies this
 * distribution, and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>
 */
package org.unicase.ui.urml.reviewview;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.eclipse.emf.edit.provider.AdapterFactoryItemDelegator;
import org.eclipse.emf.edit.provider.ComposedAdapterFactory;
import org.eclipse.emf.edit.provider.IItemPropertyDescriptor;
import org.eclipse.jface.layout.GridDataFactory;
import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Label;
import org.unicase.model.urml.UrmlModelElement;
import org.unicase.ui.unicasecommon.common.util.UnicaseActionHelper;

/**
 * Factory for generating the controller for the review view.
 * 
 * @author kterzieva
 */

public class ReviewViewContentFactory {

	private Composite editorComposite;
	private List<IDisposable> controls = new ArrayList<IDisposable>();
	private Set<String> shownProperties = new HashSet<String>();

	/**
	 * The constructor.
	 * 
	 * @param editorComposite the editor composite
	 */

	public ReviewViewContentFactory(Composite editorComposite) {
		this.editorComposite = editorComposite;
		
		shownProperties.addAll(Arrays.asList("Name","Description","Mitigated Dangers","Reviewed", "Mitigations"));
	}


	/**
	 * Creates the controllers which can show the properties of the urml element.
	 * 
	 * @param urmlElement the urml model element
	 */
	public void createElementContent(UrmlModelElement urmlElement) {
		while (!controls.isEmpty()) {
			IDisposable c = controls.get(controls.size() - 1);
			c.dispose();
			controls.remove(controls.size() - 1);
		}

		// ComposedAdapterFactory is used for providing different elements
		AdapterFactoryItemDelegator adapterFactoryItemDelegator = new AdapterFactoryItemDelegator(
			new ComposedAdapterFactory(ComposedAdapterFactory.Descriptor.Registry.INSTANCE));
		List<IItemPropertyDescriptor> propertyDescriptors = adapterFactoryItemDelegator
			.getPropertyDescriptors(urmlElement);
		DisplayControlFactory displayControlFactory = new DisplayControlFactory();
		for (IItemPropertyDescriptor itemPropertyDescriptor : propertyDescriptors) {
			
			if(!shownProperties.contains(itemPropertyDescriptor.getDisplayName(urmlElement))){
				continue;
			}
			AbstractControlBuilder abstractDisplayControl = displayControlFactory.createDisplayControl(
				itemPropertyDescriptor, urmlElement);
			if (abstractDisplayControl == null) {
				continue;
			}

			String labelText = itemPropertyDescriptor.getDisplayName(itemPropertyDescriptor);

			boolean showLabel = abstractDisplayControl.getShowLabel();
			
			if(showLabel){
				final Label label = new Label(editorComposite, SWT.NULL);
				GridData gridData = new GridData();
				label.setLayoutData(gridData);
				label.setText(labelText);
				controls.add(new IDisposable() {
					@Override
					public void dispose() {
						label.dispose();
					}
				});
				
			}

			Control c1 = abstractDisplayControl.createControl(editorComposite, itemPropertyDescriptor,
				UnicaseActionHelper.getContext(urmlElement), urmlElement);
			if(!showLabel){
				Object layoutData = c1.getLayoutData();
				if(layoutData == null || !(layoutData instanceof GridData)){
					GridDataFactory.fillDefaults().grab(true, false).span(2,1).applyTo(c1);
				} else {
					((GridData)layoutData).horizontalSpan = 2;
				}
			}
			controls.add(abstractDisplayControl);

		}

		editorComposite.layout();
		editorComposite.getParent().layout();
	}

}
