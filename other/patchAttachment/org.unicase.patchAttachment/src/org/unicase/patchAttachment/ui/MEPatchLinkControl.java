package org.unicase.patchAttachment.ui;
/**
 * <copyright> Copyright (c) 2008-2009 Jonas Helming, Maximilian Koegel. All rights reserved. This program and the
 * accompanying materials are made available under the terms of the Eclipse Public License v1.0 which accompanies this
 * distribution, and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>
 */


import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.edit.provider.IItemPropertyDescriptor;
import org.eclipse.swt.events.MouseAdapter;
import org.eclipse.swt.events.MouseEvent;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.ui.forms.widgets.ImageHyperlink;
import org.unicase.model.patchAttachment.PatchAttachment;
import org.unicase.patchAttachment.commands.ApplyPatchCommand;
import org.unicase.ui.meeditor.mecontrols.melinkcontrol.MELinkControl;


/**
 * This class extends simple LinkControl and adds a "go to associated code location"
 * button.
 * @author jfinis
 *
 */
public class MEPatchLinkControl  extends MELinkControl {

	private static final String APPLIES_THIS_PATCH_ONTO_YOUR_WORKSPACE = "Applies this patch onto your workspace";

	/**
	 * This method checks the type of the link and makes the MEFindLocationControl only for
	 * the Code Locations available. 
	 * @param itemPropertyDescriptor - model element properties
	 * @param link - attached link
	 * @param contextModelElement - model element, which contains the link as attachment
	 * @return -1 if the link is not a code location 
	 */
	public int canRender(IItemPropertyDescriptor itemPropertyDescriptor, EObject link,
		EObject contextModelElement) {
		if (link instanceof PatchAttachment) {
			return PRIORITY;
		} else {
			return -1;
		}
	}

	private static final int PRIORITY = 2;

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

		findImage = org.unicase.patchAttachment.Activator.getImageDescriptor("icons/script_lightning.png")
		.createImage();
		findLink.setImage(findImage);
		findLink.setToolTipText(APPLIES_THIS_PATCH_ONTO_YOUR_WORKSPACE);

		findLink.addMouseListener(new FindButtonAdapter(link));
	}
	
	private class FindButtonAdapter  extends MouseAdapter {

		private EObject link; 

		/**
		 * Default constructor.
		 * 
		 * @param link - link to the attached code location.
		 */
		public FindButtonAdapter (EObject link) {
			
			this.link = link;
		}

		/**
		 * {@inheritDoc}
		 */
		@Override
		public void mouseUp(MouseEvent e) {
			new ApplyPatchCommand((PatchAttachment)link).execute();
		}
	}

}

