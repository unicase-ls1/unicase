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
		this.index = parentItem.controlList.size();
		parentItem.controlList.add(this);
		//emptyField = false;
		
		// initializeFromInt
		createCompositeLayout();
		widget = parentItem.getToolkit().createText(fieldComposite, value, parentItem.style | SWT.SINGLE);
		widget.addModifyListener(this);
		createDeleteButton();
		createUpDownButtons();
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
		createInvisibleUpDownButtons();
		GridDataFactory.fillDefaults().align(SWT.FILL, SWT.CENTER).grab(true,true).applyTo(widget);
	}
	
	private StringAttributeControl() {
		// hide default constructor
	}
	
	@Override
	public void modifyText(ModifyEvent e) {  // still duplicated code, but better solution?!
		if (e.getSource().equals(widget)) {
			// first edit? --> new button
			if (index==-1) {
				button.dispose();
				widget.setMessage("");
				createDeleteButton();
				createUpDownButtons();
			}
			
			final String newValue = widget.getText();
			
			// handle duplicates
			if (!parentItem.allowDuplicates) {
				if (dataManipulator.contains(newValue)) {
					widget.setText("_"+newValue);
					return;
				}
			}
			// end of duplicate handling
			
			if (index!=-1) {
				// was a regular entry before
				dataManipulator.replaceElementAt(index, newValue);
				value = newValue;
			}
			else {
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

	@Override
	public void mouseUp(MouseEvent e) { // still duplicated code, but better solution?!
		if (e.getSource().equals(button)) {
			if (index==-1) {
				// add instead of delete
				
				// duplicate handling
				boolean autoAdd = false;
				if (!parentItem.allowDuplicates) {
					while (dataManipulator.contains(value)) {
						value = "_"+value;
					}
					// automatically added then (ModifyListener!)
					autoAdd = true;		
					widget.setText(value);
				}
				// end of duplicate handling
				if (!autoAdd) {
					dataManipulator.add(value);
					this.index = parentItem.controlList.size();
					parentItem.controlList.add(this);					
				}
				button.dispose();
				widget.setMessage("");
				createDeleteButton();
				createUpDownButtons();
			}
			else {
				// delete
				// one will be deleted --> new empty one
				if (parentItem.isFull()) {
					parentItem.createSingleField();
				}
				dataManipulator.removeElementAt(index);
				// accordingly change all other indexes
				for (int i=index+1; i<parentItem.controlList.size(); i++) {
					parentItem.controlList.get(i).index--;
				}
				parentItem.controlList.remove(index);
				
				fieldComposite.dispose();
				
			}
		}
		
		parentItem.refreshWidget();
	}
}
