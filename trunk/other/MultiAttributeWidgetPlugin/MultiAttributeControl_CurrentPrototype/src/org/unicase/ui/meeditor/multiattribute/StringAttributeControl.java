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
import org.eclipse.swt.widgets.Text;

/**
 * Represents a single String field for a MultiAttributeItem.
 * 
 * @author Christian Kroemer (christian.kroemer@z-corp-online.de)
 */
class StringAttributeControl extends AttributeControl {
	private MultiAttributeController<String> dataManipulator;
	private Text widget;
	private String value;

	/**
	 * Constructor for control with content.
	 * 
	 * @param parentItem the corresponding StringMultiAttributeWidget
	 * @param dataManipulator a MultiAttributeController for this widget
	 * @param value the initial value for this control
	 */
	StringAttributeControl(MultiAttributeControl parentItem, MultiAttributeController<String> dataManipulator,
		String value) {
		this.setParentItem(parentItem);
		this.dataManipulator = dataManipulator;
		this.value = value;
		this.setIndex(parentItem.getControlList().size());
		parentItem.getControlList().add(this);

		// initializeFromInt
		createCompositeLayout();
		setWidget(parentItem.getToolkit().createText(getFieldComposite(), value, parentItem.getStyle() | SWT.SINGLE));
		getWidget().addModifyListener(this);
		createDeleteButton();
		createUpDownButtons();
		GridDataFactory.fillDefaults().align(SWT.FILL, SWT.CENTER).grab(true, true).applyTo(getWidget());
	}

	/**
	 * Constructor for control with no initial content.
	 * 
	 * @param parentItem the corresponding StringMultiAttributeWidget
	 * @param dataManipulator a MultiAttributeController for this widget
	 */
	StringAttributeControl(MultiAttributeControl parentItem, MultiAttributeController<String> dataManipulator) {
		this.setParentItem(parentItem);
		this.dataManipulator = dataManipulator;
		this.value = StringMultiAttributeControl.getEmptyValue();

		// initializeFromInt
		createCompositeLayout();
		setWidget(parentItem.getToolkit().createText(getFieldComposite(), value, parentItem.getStyle() | SWT.SINGLE));
		getWidget().addModifyListener(this);
		getWidget().setMessage("Add new element...");
		createAddButton();
		createInvisibleUpDownButtons();
		GridDataFactory.fillDefaults().align(SWT.FILL, SWT.CENTER).grab(true, true).applyTo(getWidget());
	}

	/**
	 * Hidden default constructor.
	 */
	@SuppressWarnings("unused")
	private StringAttributeControl() {
		// hide default constructor
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	protected boolean swapThisControlWith(int index) {
		if (index >= getParentItem().getControlList().size() || index < 0) {
			return false;
		}
		// create non-duplicate String
		String random = "";
		while (dataManipulator.contains(random)) {
			random = ((Double) Math.random()).toString();
		}
		// use it for swap
		String thisValue = value;
		String otherValue = ((StringAttributeControl) getParentItem().getControlList().get(index)).value;
		getWidget().setText(random);
		((StringAttributeControl) getParentItem().getControlList().get(index)).getWidget().setText(thisValue);
		getWidget().setText(otherValue);

		return true;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void modifyText(ModifyEvent e) { // still duplicated code, but better solution?!
		if (e.getSource().equals(getWidget())) {
			// first edit? --> new button
			if (getIndex() == -1) {
				getButton().dispose();
				getWidget().setMessage("");
				createDeleteButton();
				createUpDownButtons();
			}

			final String newValue = getWidget().getText();

			// handle duplicates
			if (!getParentItem().isAllowDuplicates()) {
				if (dataManipulator.contains(newValue)) {
					getWidget().setText("_" + newValue);
					return;
				}
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
						value = "_" + value;
					}
				}
				// end of duplicate handling
				// automatically added then (ModifyListener!)
				getWidget().setText(value);
				getButton().dispose();
				getWidget().setMessage("");
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
	public void setWidget(Text widget) {
		this.widget = widget;
	}

	/**
	 * @return the widget
	 */
	public Text getWidget() {
		return widget;
	}
}
