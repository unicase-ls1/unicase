/**
 * <copyright> Copyright (c) 2008-2009 Jonas Helming, Maximilian Koegel. All rights reserved. This program and the
 * accompanying materials are made available under the terms of the Eclipse Public License v1.0 which accompanies this
 * distribution, and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>
 */
package org.unicase.ui.urml.reviewview;

import java.util.ArrayList;
import java.util.List;
import org.eclipse.emf.edit.provider.AdapterFactoryItemDelegator;
import org.eclipse.emf.edit.provider.ComposedAdapterFactory;
import org.eclipse.emf.edit.provider.IItemPropertyDescriptor;
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

	// private TableViewerColumn viewerNameColumn;
	private Composite editorComposite;
	private Control c;
	private List<Control> controls = new ArrayList<Control>();

	/**
	 * The constructor.
	 * 
	 * @param editorComposite the editor composite
	 */

	public ReviewViewContentFactory(Composite editorComposite) {
		this.editorComposite = editorComposite;
	}

	/**
	 * Creates the controllers which can show the properties of the urml element.
	 * 
	 * @param urmlElement the urml model element
	 */
	public void createElementContent(UrmlModelElement urmlElement) {
		while (!controls.isEmpty()) {
			c = controls.get(controls.size() - 1);
			c.dispose();
			controls.remove(controls.size() - 1);
		}

		// ComposedAdapterFactory is used for providing different elements
		AdapterFactoryItemDelegator adapterFactoryItemDelegator = new AdapterFactoryItemDelegator(
			new ComposedAdapterFactory(ComposedAdapterFactory.Descriptor.Registry.INSTANCE));

		// TODO 2 filter to element properties
		// properties descriptor contains all the properties of the elements
		List<IItemPropertyDescriptor> propertyDescriptors = adapterFactoryItemDelegator
			.getPropertyDescriptors(urmlElement);

		DisplayControlFactory displayControlFactory = new DisplayControlFactory();

		for (IItemPropertyDescriptor itemPropertyDescriptor : propertyDescriptors) {
			// TODO abfrage ob im set drin ist
			// create an abstract display, SingleControl or MultiLineControl
			AbstractDisplayControl abstractDisplayControl = displayControlFactory.createDisplayControl(
				itemPropertyDescriptor, urmlElement);
			if (abstractDisplayControl == null) {
				continue;
			}

			String labelText = itemPropertyDescriptor.getDisplayName(itemPropertyDescriptor);

			// TODO use sets for the specific element
			if (labelText.equals("Terminal") || labelText.equals("Creator")) {
				continue;
			}

			Label label = new Label(editorComposite, SWT.NULL);
			GridData gridData = new GridData();
			// gridData.verticalSpan = 3;
			label.setLayoutData(gridData);
			label.setText(labelText);
			controls.add(label);

			Control c1 = abstractDisplayControl.createControl(editorComposite, itemPropertyDescriptor,
				UnicaseActionHelper.getContext(urmlElement), urmlElement);
			controls.add(c1);

		}

		editorComposite.layout();
		editorComposite.getParent().layout();
	}

}
