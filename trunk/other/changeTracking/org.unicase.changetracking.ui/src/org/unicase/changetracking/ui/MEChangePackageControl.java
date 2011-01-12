/**
 * <copyright> Copyright (c) 2008-2009 Jonas Helming, Maximilian Koegel. All rights reserved. This program and the
 * accompanying materials are made available under the terms of the Eclipse Public License v1.0 which accompanies this
 * distribution, and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>
 */
package org.unicase.changetracking.ui;
/**
 * accompanying materials are made available under the terms of the Eclipse Public License v1.0 which accompanies this
 * distribution, and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>
 */


import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.edit.provider.IItemPropertyDescriptor;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.swt.events.MouseAdapter;
import org.eclipse.swt.events.MouseEvent;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.forms.widgets.ImageHyperlink;
import org.unicase.changetracking.git.commands.GitApplyChangePackage;
import org.unicase.changetracking.git.exceptions.NoMatchingLocalRepositoryInWorkspace;
import org.unicase.model.attachment.PatchAttachment;
import org.unicase.model.changetracking.git.GitBranchChangePackage;
import org.unicase.ui.meeditor.mecontrols.AbstractMEControl;
import org.unicase.ui.meeditor.mecontrols.melinkcontrol.MELinkControl;


/**
 * This class extends simple LinkControl and adds a "apply patch"
 * button.
 * @author jfinis
 *
 */
public class MEChangePackageControl  extends MELinkControl {

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
		if (link instanceof GitBranchChangePackage) {
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
	 *@param style the style
	 */
	protected void createFindAction(int style) {
		ImageHyperlink applyLink = toolkit.createImageHyperlink(linkComposite, style);
		Image applyImage = null;

		applyImage = Activator.getImageDescriptor("icons/script_lightning.png")
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

		private EObject changePackage; 

		/**
		 * Default constructor.
		 * 
		 * @param link - link to the attached code location.
		 */
		public ApplyButtonListener (EObject link) {
			
			this.changePackage = link;
		}

		/**
		 * {@inheritDoc}
		 */
		@Override
		public void mouseUp(MouseEvent e) {
			try {
				new GitApplyChangePackage().applyChangePackage((GitBranchChangePackage) changePackage);
				MessageDialog.openInformation(
						PlatformUI.getWorkbench().
						getActiveWorkbenchWindow().getShell(),
						"Success!",
						"The change package was successfully applied onto your workspace.");
			} catch (NoMatchingLocalRepositoryInWorkspace e1) {
				errorMessage("No matching local repository was found in workspace. Make sure you have cloned the remote repository of this change package.");
			}
		}
		
		protected void errorMessage(String message){
			MessageDialog.openError(
					PlatformUI.getWorkbench().
					getActiveWorkbenchWindow().getShell(),
					"Error",
					message);
		}
	}

}

