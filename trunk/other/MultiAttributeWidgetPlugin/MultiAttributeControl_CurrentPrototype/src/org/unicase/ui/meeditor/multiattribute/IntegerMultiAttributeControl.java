package org.unicase.ui.meeditor.multiattribute;

import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.util.EDataTypeEList;

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
		if (!isEditable) {
			f.widget.setEnabled(false);
		}
	}

	@Override
	protected void createSingleField() {
		IntegerAttributeControl f = new IntegerAttributeControl(this, dataManipulator);
		if (!isEditable) {
			f.widget.setEnabled(false);
		}
	}

	@Override
	public Object[] getAllStoredElements() {
		return dataManipulator.getAllStoredElements();
	}

}
