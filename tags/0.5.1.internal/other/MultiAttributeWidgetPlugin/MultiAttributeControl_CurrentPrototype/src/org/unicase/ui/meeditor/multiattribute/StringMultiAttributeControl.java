/**
 * <copyright> Copyright (c) 2008-2009 Jonas Helming, Maximilian Koegel. All rights reserved. This program and the
 * accompanying materials are made available under the terms of the Eclipse Public License v1.0 which accompanies this
 * distribution, and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>
 */
package org.unicase.ui.meeditor.multiattribute;

import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.util.EDataTypeEList;
import org.eclipse.swt.events.KeyEvent;
import org.eclipse.swt.events.KeyListener;

/**
 * String implementation of a MultiAttributeItem.
 * 
 * @author Christian Kroemer (christian.kroemer@z-corp-online.de)
 */
public class StringMultiAttributeControl extends MultiAttributeControl {

	// CONSTANTS
	private static final String EMPTY_VALUE = new String("");

	// essential references
	private MultiAttributeController<String> dataManipulator;
	private PersonalListener personalListener = new PersonalListener(); // see inner class

	/**
	 * {@inheritDoc}
	 */
	@SuppressWarnings("unchecked")
	@Override
	protected void createDataStructures(EStructuralFeature feature) {
		EDataTypeEList<String> storedValues = (EDataTypeEList<String>) getModelElement().eGet(feature);
		dataManipulator = new MultiAttributeController<String>(this, storedValues);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	protected void createSingleField(Object contentObj) {
		assert (contentObj instanceof String);
		String content = (String) contentObj;
		StringAttributeControl f = new StringAttributeControl(this, dataManipulator, content);
		f.getWidget().addKeyListener(personalListener);
		if (!isEditable()) {
			f.getWidget().setEditable(false);
		}
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	protected void createSingleField() {
		StringAttributeControl f = new StringAttributeControl(this, dataManipulator);
		f.getWidget().addKeyListener(personalListener);
		if (!isEditable()) {
			f.getWidget().setEditable(false);
		}
		setEmptyField(f.getWidget());
	}

	/**
	 * Implements specific listeners for this type's widget in general, no single-field-specific listener!
	 */
	private class PersonalListener implements KeyListener {

		public void keyPressed(KeyEvent e) {
			if (e.keyCode == 13) { // ENTER
				getEmptyField().setFocus();
			}
		}

		public void keyReleased(KeyEvent e) {
			// nothing
		}
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public Object[] getAllStoredElements() {
		return dataManipulator.getAllStoredElements();
	}

	/**
	 * @return the emptyValue
	 */
	public static String getEmptyValue() {
		return EMPTY_VALUE;
	}

}
