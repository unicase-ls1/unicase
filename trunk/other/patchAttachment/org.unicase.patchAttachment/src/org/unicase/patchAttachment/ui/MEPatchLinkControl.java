/**
 * <copyright> Copyright (c) 2008-2009 Jonas Helming, Maximilian Koegel. All rights reserved. This program and the
 * accompanying materials are made available under the terms of the Eclipse Public License v1.0 which accompanies this
 * distribution, and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>
 */
package org.unicase.patchAttachment.ui;
/**
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
 * This class extends simple LinkControl and adds a "apply patch"
 * button.
 * @author jfinis
 *
 */
public class MEPatchLinkControl  extends MELinkControl {

	private static final String APPLIES_THIS_PATCH_ONTO_YOUR_WORKSPACE = "Applies this patch onto your workspace";

	/**
	 * This method checks the type of the link and makes the MEFindLocationControl only for
	 * the PatchAttachment available. 
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
		ImageHyperlink applyLink = toolkit.createImageHyperlink(linkComposite, style);
		Image applyImage = null;

		applyImage = org.unicase.patchAttachment.Activator.getImageDescriptor("icons/script_lightning.png")
		.createImage();
		applyLink.setImage(applyImage);
		applyLink.setToolTipText(APPLIES_THIS_PATCH_ONTO_YOUR_WORKSPACE);

		applyLink.addMouseListener(new ApplyButtonListener(link));
	}
	
	/**
	 * Listener which handles pushing the apply patch button.
	 * @author jfinis
	 *
	 */
	private class ApplyButtonListener  extends MouseAdapter {

		private EObject patch; 

		/**
		 * Default constructor.
		 * 
		 * @param link - link to the attached code location.
		 */
		public ApplyButtonListener (EObject link) {
			
			this.patch = link;
		}

		/**
		 * {@inheritDoc}
		 */
		@Override
		public void mouseUp(MouseEvent e) {
			new ApplyPatchCommand((PatchAttachment)patch).execute();
		}
	}

}

