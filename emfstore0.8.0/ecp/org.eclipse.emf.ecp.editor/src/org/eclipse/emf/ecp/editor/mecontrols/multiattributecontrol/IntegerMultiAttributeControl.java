/*******************************************************************************
 * Copyright (c) 2008-2011 Chair for Applied Software Engineering,
 * Technische Universitaet Muenchen.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 ******************************************************************************/
package org.eclipse.emf.ecp.editor.mecontrols.multiattributecontrol;

import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.util.EDataTypeEList;
import org.eclipse.swt.events.KeyEvent;
import org.eclipse.swt.events.KeyListener;

/**
 * Integer implementation of a MultiAttributeItem.
 * 
 * @author Christian Kroemer (christian.kroemer@z-corp-online.de)
 */
public class IntegerMultiAttributeControl extends MultiAttributeControl {

	// CONSTANTS
	private static final int EMPTY_VALUE = new Integer(0);

	// essential references
	private MultiAttributeController<Integer> dataManipulator;
	private PersonalListener personalListener = new PersonalListener(); // see inner class

	/**
	 * {@inheritDoc}
	 */
	@SuppressWarnings("unchecked")
	@Override
	protected void createDataStructures(EStructuralFeature feature) {
		EDataTypeEList<Integer> storedValues = (EDataTypeEList<Integer>) getModelElement().eGet(feature);
		dataManipulator = new MultiAttributeController<Integer>(this, storedValues);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	protected void createSingleField(Object contentObj) {
		assert (contentObj instanceof Integer);
		int content = (Integer) contentObj;
		IntegerAttributeControl f = new IntegerAttributeControl(this, dataManipulator, content);
		f.getWidget().addKeyListener(personalListener);
		if (!isEditable()) {
			f.getWidget().setEnabled(false);
		}
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	protected void createSingleField() {
		IntegerAttributeControl f = new IntegerAttributeControl(this, dataManipulator);
		f.getWidget().addKeyListener(personalListener);
		if (!isEditable()) {
			f.getWidget().setEnabled(false);
		}
		setEmptyField(f.getWidget());
	}

	/**
	 * Implements specific listeners for this type's widget in general, no single-field-specific listener!
	 */
	private class PersonalListener implements KeyListener {

		public void keyPressed(KeyEvent e) {
			if (e.keyCode == 13) { // ENTER
				getEmptyField().forceFocus();
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
	 * @return the EMPTY_VALUE
	 */
	public static int getEmptyValue() {
		return EMPTY_VALUE;
	}

}
