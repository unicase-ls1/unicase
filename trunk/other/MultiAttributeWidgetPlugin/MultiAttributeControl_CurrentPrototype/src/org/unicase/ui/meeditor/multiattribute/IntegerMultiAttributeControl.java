package org.unicase.ui.meeditor.multiattribute;

import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.util.EDataTypeEList;
import org.eclipse.swt.events.KeyEvent;
import org.eclipse.swt.events.KeyListener;

/**
 * Integer implementation of a MultiAttributeItem.
 * 
 * @author Christian Kroemer (christian.kroemer@z-corp-online.de)
 *
 */
public class IntegerMultiAttributeControl extends MultiAttributeControl {

	// CONSTANTS
	protected static int EMPTY_VALUE = new Integer(0);
	//private static int SIZE_LIMIT = 10000000;
	
	// essential references
	private MultiAttributeController<Integer> dataManipulator;
	private PersonalListener personalListener = new PersonalListener(); // see inner class

	@Override
	protected void createDataStructures(EStructuralFeature feature) {
		EDataTypeEList<Integer> storedValues = (EDataTypeEList<Integer>) getModelElement().eGet(feature);
		dataManipulator = new MultiAttributeController<Integer>(this, storedValues);
	}

	@Override
	protected void createSingleField(Object contentObj) {
		assert(contentObj instanceof Integer);
		int content = (Integer) contentObj;
		IntegerAttributeControl f = new IntegerAttributeControl(this, dataManipulator, content);
		f.widget.addKeyListener(personalListener);
		if (!isEditable) {
			f.widget.setEnabled(false);
		}
	}

	@Override
	protected void createSingleField() {
		IntegerAttributeControl f = new IntegerAttributeControl(this, dataManipulator);
		f.widget.addKeyListener(personalListener);
		if (!isEditable) {
			f.widget.setEnabled(false);
		}
		emptyField = f.widget;
	}
	
	/**
	 * Implements specific listeners for this type's widget in general,
	 * no single-field-specific listener!
	 */
	private class PersonalListener implements KeyListener {

		@Override
		public void keyPressed(KeyEvent e) {
			if (e.keyCode == 13) { //ENTER
				emptyField.forceFocus();
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
