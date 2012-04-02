/**
 * <copyright> Copyright (c) 2009-2012 Chair of Applied Software Engineering, Technische Universität München (TUM).
* All rights reserved. This program and the accompanying materials are made available under the terms of
* the Eclipse Public License v1.0 which accompanies this distribution,
* and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>
 */
package org.unicase.changetracking.ui.widgets;

/**
 * accompanying materials are made available under the terms of the Eclipse Public License v1.0 which accompanies this
 * distribution, and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>
 */

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecp.editor.mecontrols.AbstractMEControl;
import org.eclipse.emf.edit.provider.IItemPropertyDescriptor;
import org.eclipse.swt.events.MouseAdapter;
import org.eclipse.swt.events.MouseEvent;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.ui.forms.widgets.ImageHyperlink;
import org.unicase.changetracking.ui.Activator;
import org.unicase.changetracking.ui.handlers.ApplyChangePackageHandler;
import org.unicase.model.changetracking.ChangePackage;
import org.unicase.model.changetracking.git.GitBranchChangePackage;

/**
 * This MEEditor control extends simple LinkControl and adds an "apply patch"
 * button.
 * 
 * @author jfinis
 * 
 */
public class MEChangePackageControl extends org.eclipse.emf.ecp.editor.mecontrols.melinkcontrol.MELinkControl {

	private static final String APPLIES_THIS_PATCH_ONTO_YOUR_WORKSPACE = "Applies this patch onto your workspace";

	/**
	 * This method checks the type of the link and makes the
	 * MEFindLocationControl only for the PatchAttachment available.
	 * 
	 * @param itemPropertyDescriptor - model element properties
	 * @param link - attached link
	 * @param contextModelElement - model element, which contains the link as
	 *            attachment
	 * @return -1 if the link is not a code location
	 */
	public int canRender(IItemPropertyDescriptor itemPropertyDescriptor, EObject link, EObject contextModelElement) {
		if (link instanceof ChangePackage) {
			return PRIORITY;
		} else {
			return AbstractMEControl.DO_NOT_RENDER;
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
	 * 
	 * @param style the style
	 */
	protected void createFindAction(int style) {
		ImageHyperlink applyLink = toolkit.createImageHyperlink(linkComposite, style);
		Image applyImage = null;

		applyImage = Activator.getImageDescriptor("icons/apply_package.gif").createImage();
		applyLink.setImage(applyImage);
		applyLink.setToolTipText(APPLIES_THIS_PATCH_ONTO_YOUR_WORKSPACE);

		applyLink.addMouseListener(new ApplyButtonListener(link));
	}

	/**
	 * Listener which handles pushing the apply patch button.
	 * 
	 * @author jfinis
	 * 
	 */
	private class ApplyButtonListener extends MouseAdapter {

		private EObject changePackage;

		/**
		 * Default constructor.
		 * 
		 * @param link - link to the attached code location.
		 */
		public ApplyButtonListener(EObject link) {

			this.changePackage = link;
		}

		/**
		 * {@inheritDoc}
		 */
		@Override
		public void mouseUp(MouseEvent e) {
			new ApplyChangePackageHandler().applyChangePackage((GitBranchChangePackage) changePackage);
		}

	}

}
