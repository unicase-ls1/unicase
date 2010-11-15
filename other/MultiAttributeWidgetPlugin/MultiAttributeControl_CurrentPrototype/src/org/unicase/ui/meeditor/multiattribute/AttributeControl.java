/**
 * <copyright> Copyright (c) 2008-2009 Jonas Helming, Maximilian Koegel. All rights reserved. This program and the
 * accompanying materials are made available under the terms of the Eclipse Public License v1.0 which accompanies this
 * distribution, and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>
 */
package org.unicase.ui.meeditor.multiattribute;

import org.eclipse.jface.layout.GridDataFactory;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.ModifyEvent;
import org.eclipse.swt.events.ModifyListener;
import org.eclipse.swt.events.MouseEvent;
import org.eclipse.swt.events.MouseListener;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.ui.ISharedImages;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.forms.widgets.ImageHyperlink;

/**
 * Represents a general single field for a MultiAttributeItem.
 * 
 * @author Christian Kroemer (christian.kroemer@z-corp-online.de)
 */
abstract class AttributeControl implements ModifyListener, MouseListener {
	protected MultiAttributeControl parentItem;
	protected Composite fieldComposite;
	protected int index = -1; // -1 = value for "not stored yet" / empty control

	protected ImageHyperlink button;
	protected ImageHyperlink up;
	protected ImageHyperlink down;

	/**
	 * Initializes the delete button.
	 */
	protected void createDeleteButton() {
		button = new ImageHyperlink(fieldComposite, SWT.TOP);
		button.setImage(PlatformUI.getWorkbench().getSharedImages().getImage(ISharedImages.IMG_TOOL_DELETE));
		button.addMouseListener(this);
		fieldComposite.layout();
	}

	/**
	 * Initializes the add button.
	 */
	protected void createAddButton() {
		button = new ImageHyperlink(fieldComposite, SWT.TOP);
		button.setImage(PlatformUI.getWorkbench().getSharedImages().getImage(ISharedImages.IMG_OBJ_ADD));
		button.addMouseListener(this);
	}

	/**
	 * Initializes the up/down buttons.
	 */
	protected void createUpDownButtons() {
		// if invisible ones have been created
		if (up != null)
			up.dispose();
		up = new ImageHyperlink(fieldComposite, SWT.TOP);
		up.setImage(PlatformUI.getWorkbench().getSharedImages().getImage(ISharedImages.IMG_TOOL_BACK));
		up.addMouseListener(this);

		// if invisible ones have been created
		if (down != null)
			down.dispose();
		down = new ImageHyperlink(fieldComposite, SWT.TOP);
		down.setImage(PlatformUI.getWorkbench().getSharedImages().getImage(ISharedImages.IMG_TOOL_FORWARD));
		down.addMouseListener(this);
		fieldComposite.layout();
	}

	/**
	 * Initializes invisible up/down buttons (needed for the layout).
	 */
	protected void createInvisibleUpDownButtons() {
		up = new ImageHyperlink(fieldComposite, SWT.TOP);
		up.setImage(PlatformUI.getWorkbench().getSharedImages().getImage(ISharedImages.IMG_TOOL_BACK));
		up.addMouseListener(this);
		up.setVisible(false);

		down = new ImageHyperlink(fieldComposite, SWT.TOP);
		down.setImage(PlatformUI.getWorkbench().getSharedImages().getImage(ISharedImages.IMG_TOOL_FORWARD));
		down.addMouseListener(this);
		down.setVisible(false);
	}

	/**
	 * Creates the layout for one single field.
	 * 
	 * @return Returns the composite.
	 */
	protected void createCompositeLayout() {
		fieldComposite = parentItem.getToolkit().createComposite(parentItem.composite, parentItem.style);
		GridLayout fieldLayout = new GridLayout(4, false);
		fieldLayout.verticalSpacing = 0;
		fieldComposite.setLayout(fieldLayout);
		GridDataFactory.fillDefaults().align(SWT.FILL, SWT.CENTER).grab(true, true).applyTo(fieldComposite);
	}

	/**
	 * Swaps the position of two control elements. It can also be called for moving the first item forward or the last
	 * one backward, as nothing will change then (false will be returned).
	 * 
	 * @param index The index of the swap partner.
	 * @return Returns true if swap was successful, false otherwise (index didn't exist).
	 */
	protected abstract boolean swapThisControlWith(int index);

	public abstract void modifyText(ModifyEvent e); // still duplicated code, but better solution?!

	public void mouseDoubleClick(MouseEvent e) {
		// nothing
	}

	public void mouseDown(MouseEvent e) {
		// nothing
	}

	public abstract void mouseUp(MouseEvent e); // still duplicated code, but better solution?!
}
