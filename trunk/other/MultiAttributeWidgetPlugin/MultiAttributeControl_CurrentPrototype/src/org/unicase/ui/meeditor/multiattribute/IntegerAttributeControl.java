/**
 * <copyright> Copyright (c) 2008-2009 Jonas Helming, Maximilian Koegel. All rights reserved. This program and the
 * accompanying materials are made available under the terms of the Eclipse Public License v1.0 which accompanies this
 * distribution, and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>
 */
package org.unicase.ui.meeditor.multiattribute;

import org.eclipse.jface.layout.GridDataFactory;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.ModifyEvent;
import org.eclipse.swt.events.MouseEvent;
import org.eclipse.swt.graphics.Color;
import org.eclipse.swt.widgets.Spinner;

/**
 * Represents a single Integer field for a MultiAttributeItem.
 * 
 * @author Christian Kroemer (christian.kroemer@z-corp-online.de)
 */
class IntegerAttributeControl extends AttributeControl {

	// CONSTANTS
	private static final int SIZE_LIMIT = 10000000;

	// state and references
	private MultiAttributeController<Integer> dataManipulator;
	private Spinner widget;
	private Integer value;

	/**
	 * Constructor for control with content.
	 * 
	 * @param parentItem the corresponding IntegerMultiAttributeWidget
	 * @param dataManipulator a MultiAttributeController for this widget
	 * @param value the initial value for this control
	 */
	IntegerAttributeControl(MultiAttributeControl parentItem, MultiAttributeController<Integer> dataManipulator,
		int value) {
		this.setParentItem(parentItem);
		this.dataManipulator = dataManipulator;
		this.value = value;
		this.setIndex(parentItem.getControlList().size());
		parentItem.getControlList().add(this);

		// initialize
		createCompositeLayout();
		setWidget(new Spinner(getFieldComposite(), parentItem.getStyle() | SWT.SINGLE));
		getWidget().setValues(value, -SIZE_LIMIT, SIZE_LIMIT, 0, 1, 1);
		getWidget().addModifyListener(this);
		createDeleteButton();
		createUpDownButtons();
		GridDataFactory.fillDefaults().align(SWT.FILL, SWT.CENTER).grab(true, true).applyTo(getWidget());
	}

	/**
	 * Constructor for control with no initial content.
	 * 
	 * @param parentItem the corresponding IntegerMultiAttributeWidget
	 * @param dataManipulator a MultiAttributeController for this widget
	 */
	IntegerAttributeControl(MultiAttributeControl parentItem, MultiAttributeController<Integer> dataManipulator) {
		this.setParentItem(parentItem);
		this.dataManipulator = dataManipulator;
		this.value = IntegerMultiAttributeControl.getEmptyValue();

		// initialize
		createCompositeLayout();
		setWidget(new Spinner(getFieldComposite(), parentItem.getStyle() | SWT.SINGLE));
		getWidget().setValues(value, -SIZE_LIMIT, SIZE_LIMIT, 0, 1, 1);
		getWidget().addModifyListener(this);
		getWidget().setForeground(new Color(getWidget().getDisplay(), 100, 100, 100));
		createAddButton();
		createInvisibleUpDownButtons();
		GridDataFactory.fillDefaults().align(SWT.FILL, SWT.CENTER).grab(true, true).applyTo(getWidget());
	}

	/**
	 * Hidden default constructor.
	 */
	@SuppressWarnings("unused")
	private IntegerAttributeControl() {
		// nothing
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	protected boolean swapThisControlWith(int index) {
		if (index >= getParentItem().getControlList().size() || index < 0) {
			return false;
		}
		// create non-duplicate Integer
		int random = 0;
		while (dataManipulator.contains(random)) {
			random = ((int) (Math.random() * 10000));
		}
		// use it for swap
		int thisValue = value;
		int otherValue = ((IntegerAttributeControl) getParentItem().getControlList().get(index)).value;
		getWidget().setSelection(random);
		((IntegerAttributeControl) getParentItem().getControlList().get(index)).getWidget().setSelection(thisValue);
		getWidget().setSelection(otherValue);

		return true;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void modifyText(ModifyEvent e) { // still duplicated code, but better solution?!
		if (e.getSource().equals(getWidget())) {
			// first edit? --> layout changes
			if (getIndex() == -1) {
				getWidget().setForeground(new Color(getWidget().getDisplay(), 0, 0, 0));
				getButton().dispose();
				createDeleteButton();
				createUpDownButtons();
			}

			final int newValue = getWidget().getSelection();

			// jump over duplicates
			if (!getParentItem().isAllowDuplicates() && dataManipulator.contains(newValue)) {
				if (newValue > value) {
					getWidget().setSelection(newValue + 1);
				} else {
					getWidget().setSelection(newValue - 1);
				}
				return;
			}
			// end of duplicate handling

			if (getIndex() != -1) {
				// was a regular entry before
				dataManipulator.replaceElementAt(getIndex(), newValue);
				value = newValue;
			} else {
				// was a dummy entry before
				this.setIndex(getParentItem().getControlList().size());
				getParentItem().getControlList().add(this);
				dataManipulator.add(newValue);
				value = newValue;
				getButton().setVisible(true);
				if (!getParentItem().isFull()) {
					getParentItem().createSingleField();
				}
				getFieldComposite().layout();
			}

			getParentItem().refreshWidget();
		}
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void mouseUp(MouseEvent e) { // still duplicated code, but better solution?!
		if (e.getSource().equals(getButton())) {
			if (getIndex() == -1) {
				// add instead of delete

				// duplicate handling
				if (!getParentItem().isAllowDuplicates()) {
					while (dataManipulator.contains(value)) {
						value++;
					}
				}
				// end of duplicate handling
				// automatically added then (ModifyListener!)
				getWidget().setSelection(value);
				getWidget().setForeground(new Color(getWidget().getDisplay(), 0, 0, 0));
				getButton().dispose();
				createDeleteButton();
				createUpDownButtons();
			} else {
				// delete
				// one will be deleted --> new empty one
				if (getParentItem().isFull()) {
					getParentItem().createSingleField();
				}
				dataManipulator.removeElementAt(getIndex());
				// accordingly change all other indexes
				for (int i = getIndex() + 1; i < getParentItem().getControlList().size(); i++) {
					AttributeControl c = getParentItem().getControlList().get(i);
					c.setIndex(c.getIndex() - 1);
				}
				getParentItem().getControlList().remove(getIndex());

				getFieldComposite().dispose();

			}
		}

		if (e.getSource().equals(getUp())) {
			swapThisControlWith(getIndex() - 1);
		}

		if (e.getSource().equals(getDown())) {
			swapThisControlWith(getIndex() + 1);
		}

		getParentItem().refreshWidget();
	}

	/**
	 * @param widget the widget to set
	 */
	public void setWidget(Spinner widget) {
		this.widget = widget;
	}

	/**
	 * @return the widget
	 */
	public Spinner getWidget() {
		return widget;
	}
}
