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
	protected MultiAttributeController<String> dataManipulator;
	protected Text widget;
	protected String value;

	/**
	 * Constructor for control with content.
	 * 
	 * @param parentItem The corresponding StringMultiAttributeWidget.
	 * @param dataManipulator A MultiAttributeController for this widget.
	 * @param value The initial value for this control.
	 */
	StringAttributeControl(MultiAttributeControl parentItem, MultiAttributeController<String> dataManipulator,
		String value) {
		this.parentItem = parentItem;
		this.dataManipulator = dataManipulator;
		this.value = value;
		this.index = parentItem.controlList.size();
		parentItem.controlList.add(this);

		// initializeFromInt
		createCompositeLayout();
		widget = parentItem.getToolkit().createText(fieldComposite, value, parentItem.style | SWT.SINGLE);
		widget.addModifyListener(this);
		createDeleteButton();
		createUpDownButtons();
		GridDataFactory.fillDefaults().align(SWT.FILL, SWT.CENTER).grab(true, true).applyTo(widget);
	}

	/**
	 * Constructor for control with no initial content.
	 * 
	 * @param parentItem The corresponding StringMultiAttributeWidget.
	 * @param dataManipulator A MultiAttributeController for this widget.
	 */
	StringAttributeControl(MultiAttributeControl parentItem, MultiAttributeController<String> dataManipulator) {
		this.parentItem = parentItem;
		this.dataManipulator = dataManipulator;
		this.value = StringMultiAttributeControl.EMPTY_VALUE;

		// initializeFromInt
		createCompositeLayout();
		widget = parentItem.getToolkit().createText(fieldComposite, value, parentItem.style | SWT.SINGLE);
		widget.addModifyListener(this);
		widget.setMessage("Add new element...");
		createAddButton();
		createInvisibleUpDownButtons();
		GridDataFactory.fillDefaults().align(SWT.FILL, SWT.CENTER).grab(true, true).applyTo(widget);
	}

	/**
	 * Hidden default constructor.
	 */
	private StringAttributeControl() {
		// hide default constructor
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	protected boolean swapThisControlWith(int index) {
		if (index >= parentItem.controlList.size() || index < 0) {
			return false;
		}
		// create non-duplicate String
		String random = "";
		while (dataManipulator.contains(random)) {
			random = ((Double) Math.random()).toString();
		}
		// use it for swap
		String thisValue = value;
		String otherValue = ((StringAttributeControl) parentItem.controlList.get(index)).value;
		widget.setText(random);
		((StringAttributeControl) parentItem.controlList.get(index)).widget.setText(thisValue);
		widget.setText(otherValue);

		return true;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void modifyText(ModifyEvent e) { // still duplicated code, but better solution?!
		if (e.getSource().equals(widget)) {
			// first edit? --> new button
			if (index == -1) {
				button.dispose();
				widget.setMessage("");
				createDeleteButton();
				createUpDownButtons();
			}

			final String newValue = widget.getText();

			// handle duplicates
			if (!parentItem.allowDuplicates) {
				if (dataManipulator.contains(newValue)) {
					widget.setText("_" + newValue);
					return;
				}
			}
			// end of duplicate handling

			if (index != -1) {
				// was a regular entry before
				dataManipulator.replaceElementAt(index, newValue);
				value = newValue;
			} else {
				// was a dummy entry before
				this.index = parentItem.controlList.size();
				parentItem.controlList.add(this);
				dataManipulator.add(newValue);
				value = newValue;
				button.setVisible(true);
				if (!parentItem.isFull()) {
					parentItem.createSingleField();
				}
				fieldComposite.layout();
			}

			parentItem.refreshWidget();
		}
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void mouseUp(MouseEvent e) { // still duplicated code, but better solution?!
		if (e.getSource().equals(button)) {
			if (index == -1) {
				// add instead of delete

				// duplicate handling
				if (!parentItem.allowDuplicates) {
					while (dataManipulator.contains(value)) {
						value = "_" + value;
					}
				}
				// end of duplicate handling
				// automatically added then (ModifyListener!)
				widget.setText(value);
				button.dispose();
				widget.setMessage("");
				createDeleteButton();
				createUpDownButtons();
			} else {
				// delete
				// one will be deleted --> new empty one
				if (parentItem.isFull()) {
					parentItem.createSingleField();
				}
				dataManipulator.removeElementAt(index);
				// accordingly change all other indexes
				for (int i = index + 1; i < parentItem.controlList.size(); i++) {
					parentItem.controlList.get(i).index--;
				}
				parentItem.controlList.remove(index);

				fieldComposite.dispose();

			}
		}

		if (e.getSource().equals(up)) {
			swapThisControlWith(index - 1);
		}

		if (e.getSource().equals(down)) {
			swapThisControlWith(index + 1);
		}

		parentItem.refreshWidget();
	}
}
