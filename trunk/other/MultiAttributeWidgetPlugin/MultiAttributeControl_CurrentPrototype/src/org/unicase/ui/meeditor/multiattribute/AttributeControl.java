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
import org.eclipse.swt.graphics.Image;
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
	private MultiAttributeControl parentItem;
	private Composite fieldComposite;
	private int index = -1; // -1 = value for "not stored yet" / empty control

	private ImageHyperlink button;
	private ImageHyperlink up;
	private ImageHyperlink down;

	/**
	 * Disposes the control represented by this object.
	 */
	public void dispose() {
		fieldComposite.dispose();
	}

	/**
	 * Initializes the delete button.
	 */
	protected void createDeleteButton() {
		setButton(new ImageHyperlink(getFieldComposite(), SWT.TOP));
		getButton().setImage(PlatformUI.getWorkbench().getSharedImages().getImage(ISharedImages.IMG_TOOL_DELETE));
		getButton().addMouseListener(this);
		getFieldComposite().layout();
	}

	/**
	 * Initializes the add button.
	 */
	protected void createAddButton() {
		setButton(new ImageHyperlink(getFieldComposite(), SWT.TOP));
		getButton().setImage(PlatformUI.getWorkbench().getSharedImages().getImage(ISharedImages.IMG_OBJ_ADD));
		getButton().addMouseListener(this);
	}

	/**
	 * Initializes the up/down buttons.
	 */
	protected void createUpDownButtons() {
		Image up = Activator.getImageDescriptor("icons/arrow_up.png").createImage();
		Image down = Activator.getImageDescriptor("icons/arrow_down.png").createImage();

		// if invisible ones have been created
		if (getUp() != null) {
			getUp().dispose();
		}
		setUp(new ImageHyperlink(getFieldComposite(), SWT.TOP));
		getUp().setImage(up);
		getUp().addMouseListener(this);

		// if invisible ones have been created
		if (getDown() != null) {
			getDown().dispose();
		}
		setDown(new ImageHyperlink(getFieldComposite(), SWT.TOP));
		getDown().setImage(down);
		getDown().addMouseListener(this);
		getFieldComposite().layout();
	}

	/**
	 * Initializes invisible up/down buttons (needed for the layout).
	 */
	protected void createInvisibleUpDownButtons() {
		setUp(new ImageHyperlink(getFieldComposite(), SWT.TOP));
		getUp().setImage(PlatformUI.getWorkbench().getSharedImages().getImage(ISharedImages.IMG_TOOL_BACK));
		getUp().addMouseListener(this);
		getUp().setVisible(false);

		setDown(new ImageHyperlink(getFieldComposite(), SWT.TOP));
		getDown().setImage(PlatformUI.getWorkbench().getSharedImages().getImage(ISharedImages.IMG_TOOL_FORWARD));
		getDown().addMouseListener(this);
		getDown().setVisible(false);
	}

	/**
	 * Creates the layout for one single field.
	 */
	protected void createCompositeLayout() {
		setFieldComposite(getParentItem().getToolkit().createComposite(getParentItem().getComposite(),
			getParentItem().getStyle()));
		GridLayout fieldLayout = new GridLayout(4, false);
		fieldLayout.verticalSpacing = 0;
		getFieldComposite().setLayout(fieldLayout);
		GridDataFactory.fillDefaults().align(SWT.FILL, SWT.CENTER).grab(true, true).applyTo(getFieldComposite());
	}

	/**
	 * Swaps the position of two control elements. It can also be called for moving the first item forward or the last
	 * one backward, as nothing will change then (false will be returned).
	 * 
	 * @param index the index of the swap partner
	 * @return true if swap was successful, false otherwise (index didn't exist)
	 */
	protected abstract boolean swapThisControlWith(int index);

	/**
	 * {@inheritDoc}
	 */
	public abstract void modifyText(ModifyEvent e);

	/**
	 * {@inheritDoc}
	 */
	public void mouseDoubleClick(MouseEvent e) {
		// nothing
	}

	/**
	 * {@inheritDoc}
	 */
	public void mouseDown(MouseEvent e) {
		// nothing
	}

	/**
	 * {@inheritDoc}
	 */
	public abstract void mouseUp(MouseEvent e);

	/**
	 * @param parentItem the parentItem to set
	 */
	public void setParentItem(MultiAttributeControl parentItem) {
		this.parentItem = parentItem;
	}

	/**
	 * @return the parentItem
	 */
	public MultiAttributeControl getParentItem() {
		return parentItem;
	}

	/**
	 * @param index the index to set
	 */
	public void setIndex(int index) {
		this.index = index;
	}

	/**
	 * @return the index
	 */
	public int getIndex() {
		return index;
	}

	/**
	 * @param fieldComposite the fieldComposite to set
	 */
	public void setFieldComposite(Composite fieldComposite) {
		this.fieldComposite = fieldComposite;
	}

	/**
	 * @return the fieldComposite
	 */
	public Composite getFieldComposite() {
		return fieldComposite;
	}

	/**
	 * @param button the button to set
	 */
	public void setButton(ImageHyperlink button) {
		this.button = button;
	}

	/**
	 * @return the button
	 */
	public ImageHyperlink getButton() {
		return button;
	}

	/**
	 * @param up the up to set
	 */
	public void setUp(ImageHyperlink up) {
		this.up = up;
	}

	/**
	 * @return the up
	 */
	public ImageHyperlink getUp() {
		return up;
	}

	/**
	 * @param down the down to set
	 */
	public void setDown(ImageHyperlink down) {
		this.down = down;
	}

	/**
	 * @return the down
	 */
	public ImageHyperlink getDown() {
		return down;
	}
}
