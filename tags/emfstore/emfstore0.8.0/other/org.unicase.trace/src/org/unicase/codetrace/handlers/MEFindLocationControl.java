/**
 * <copyright> Copyright (c) 2008-2009 Jonas Helming, Maximilian Koegel. All rights reserved. This program and the
 * accompanying materials are made available under the terms of the Eclipse Public License v1.0 which accompanies this
 * distribution, and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>
 */

package org.unicase.codetrace.handlers;

import org.eclipse.emf.edit.provider.IItemPropertyDescriptor;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.ui.forms.widgets.ImageHyperlink;
import org.unicase.metamodel.ModelElement;
import org.unicase.metamodel.util.ModelElementChangeListener;
import org.unicase.model.trace.CodeLocation;
import org.unicase.ui.meeditor.mecontrols.melinkcontrol.MELinkControl;


/**
 * This class extends simple LinkControl. 
 * @author snogina
 *
 */
public class MEFindLocationControl  extends MELinkControl {

	/**
	 * This method checks the type of the link and makes the MEFindLocationControl only for
	 * the Code Locations available. 
	 * @param itemPropertyDescriptor - model element properties
	 * @param link - attached link
	 * @param contextModelElement - model element, which contains the link as attachment
	 * @return -1 if the link is not a code location 
	 */
	@Override
	public int canRender(IItemPropertyDescriptor itemPropertyDescriptor, ModelElement link,
		ModelElement contextModelElement) {
		if (link instanceof CodeLocation) {
			return PRIORITY;
		} else {
			return -1;
		}
	}


	private static final int PRIORITY = 2;
	private ModelElementChangeListener listener;

	/**
	 * {@inheritDoc}
	 */
	@Override
	protected Control createControl(Composite parent, int style) {

		linkComposite = toolkit.createComposite(parent, style);
		linkComposite.setLayout(new GridLayout(4, false));
		createHyperlink(parent, style);
		createFindAction(style);
		createDeleteAction(style);
		return linkComposite;
	}
	/**
	 * Creates the image for the control and assigns the MouseListener to it.
	 *@param style the style
	 */
	protected void createFindAction(int style) {
		ImageHyperlink findLink = toolkit.createImageHyperlink(linkComposite, style);
		Image findImage = null;

		findImage = org.unicase.ui.meeditor.Activator.getImageDescriptor("icons/page_go.png")
		.createImage();
		findLink.setImage(findImage);

		findLink.addMouseListener(new MEFindCodeLocationAdapter(link));
	}

	
	/**
	 * Disposes the Composite of this {@link MEURLLinkControl}.
	 */
	@Override
	public void dispose() {
		super.dispose();
		link.removeModelElementChangeListener(listener);

	}

}

