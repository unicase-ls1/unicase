package org.unicase.ui.meeditor.multiattribute;

import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.util.EDataTypeEList;
import org.eclipse.jface.layout.GridDataFactory;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.KeyEvent;
import org.eclipse.swt.events.KeyListener;
import org.eclipse.swt.widgets.Control;
import org.eclipse.ui.ISharedImages;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.forms.widgets.ImageHyperlink;

/**
 * String implementation of a MultiAttributeItem.
 * 
 * @author Christian Kroemer (christian.kroemer@z-corp-online.de)
 *
 */
public class StringMultiAttributeControl extends MultiAttributeControl {

	// CONSTANTS
	protected static String EMPTY_VALUE = new String("");
	
	//essential references
	private MultiAttributeController<String> dataManipulator;
	protected Control emptyField; // or the bottom one if isFull() && isEditable()
	private PersonalListener personalListener = new PersonalListener(); // see inner class
	
	@Override
	protected void createDataStructures(EStructuralFeature feature) {
		EDataTypeEList<String> storedValues = (EDataTypeEList<String>) getModelElement().eGet(feature);
		dataManipulator = new MultiAttributeController<String>(this, storedValues);
	}

	@Override
	protected void createSingleField(Object contentObj) {
		assert(contentObj instanceof String);
		String content = (String) contentObj;
		StringAttributeControl f = new StringAttributeControl(this, dataManipulator, content);
		f.widget.addKeyListener(personalListener);
		if (!isEditable) {
			f.widget.setEditable(false);
		}
	}
	

	@Override
	protected void createSingleField() {
		StringAttributeControl f = new StringAttributeControl(this, dataManipulator);
		f.widget.addKeyListener(personalListener);
		if (!isEditable) {
			f.widget.setEditable(false);
		}
		emptyField = f.widget;
	}
	
	/**
	 * Implements specific listeners for this type's widget in general,
	 * no single field specific listener!
	 */
	private class PersonalListener implements KeyListener {

		@Override
		public void keyPressed(KeyEvent e) {
			if (e.keyCode == 13) { //ENTER
				emptyField.setFocus();
			}
		}

		@Override
		public void keyReleased(KeyEvent e) {
			// nothing
		}
	}

	@Override
	public Object[] getAllStoredElements() {
		return dataManipulator.getAllStoredElements();
	}

}
