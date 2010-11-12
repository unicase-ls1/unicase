package org.unicase.ui.meeditor.multiattribute;

import org.eclipse.jface.layout.GridDataFactory;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.ModifyEvent;
import org.eclipse.swt.events.MouseEvent;
import org.eclipse.swt.widgets.Spinner;
import org.eclipse.swt.widgets.Text;

/**
 * Represents a single String field for a MultiAttributeItem.
 * 
 * @author Christian Kroemer (christian.kroemer@z-corp-online.de)
 *
 */
class StringAttributeControl extends AttributeControl {
	protected MultiAttributeController<String> dataManipulator;
	protected Text widget;
	protected String value;
	
	StringAttributeControl(MultiAttributeControl parentItem, MultiAttributeController<String> dataManipulator, String value) {
		this.parentItem = parentItem;
		this.dataManipulator = dataManipulator;
		this.value = value;
		emptyField = false;
		
		// initializeFromInt
		createCompositeLayout();
		widget = parentItem.getToolkit().createText(fieldComposite, value, parentItem.style | SWT.SINGLE);
		widget.addModifyListener(this);
		createDeleteButton();
		GridDataFactory.fillDefaults().align(SWT.FILL, SWT.CENTER).grab(true,true).applyTo(widget);
	}
	
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
		GridDataFactory.fillDefaults().align(SWT.FILL, SWT.CENTER).grab(true,true).applyTo(widget);
	}
	
	private StringAttributeControl() {
		// hide default constructor
	}
	
	@Override
	public void modifyText(ModifyEvent e) {  // still duplicated code, but better solution?!
		if (e.getSource().equals(widget)) {
			// first edit? --> new button
			if (emptyField) {
				button.dispose();
				widget.setMessage("");
				createDeleteButton();
			}
			
			final String newValue = widget.getText();
			
			// handle duplicates
			if (dataManipulator.contains(newValue)) {
				widget.setText("_"+newValue);
				return;
			}
			
			if (!emptyField) {
				// was a regular entry before
				dataManipulator.replace(value, newValue);
				value = newValue;
			}
			else {
				// was a dummy entry before
				emptyField = false;
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

	@Override
	public void mouseUp(MouseEvent e) { // still duplicated code, but better solution?!
		if (e.getSource().equals(button)) {
			if (emptyField) {
				// add instead of delete
				// duplicate handling
				while (dataManipulator.contains(value)) {
					value = "_"+value;
				}
				widget.setText(value);
				// duplicate handling till here
				dataManipulator.add(value);
				emptyField = false;
				button.dispose();
				widget.setMessage("");
				createDeleteButton();
			}
			else {
				// delete
				// one will be deleted --> new empty one
				if (parentItem.isFull()) {
					parentItem.createSingleField();
				}
				dataManipulator.remove(value);
				
				fieldComposite.dispose();
				
			}
		}
		
		parentItem.refreshWidget();
	}
}
