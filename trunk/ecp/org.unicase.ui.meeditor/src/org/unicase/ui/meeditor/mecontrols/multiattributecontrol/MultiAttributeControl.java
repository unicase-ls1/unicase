/*******************************************************************************
 * Copyright (c) 2008-2011 Chair for Applied Software Engineering, Technische Universitaet Muenchen.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 ******************************************************************************/
package org.unicase.ui.meeditor.mecontrols.multiattributecontrol;

import java.util.ArrayList;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.ETypedElement;
import org.eclipse.emf.edit.provider.IItemPropertyDescriptor;
import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.ui.forms.widgets.Form;
import org.unicase.ui.meeditor.mecontrols.AbstractMEControl;

/**
 * Represents a multi-attribute-item for the editor of an EMFCP model element.
 * <p>
 * FEATURES:
 * <p>
 * * Changes are applied whenever a field is modified, then: immediate storage of any change in the model data and
 * immediate redrawing of the widget (always n+1 fields for n entries so a new one can be added easily)
 * <p>
 * * Limited to $upperBound$ entries if it is != -1.
 * <p>
 * * Non-changeable attributes are handled correctly.
 * <p>
 * * When a duplicate is entered (and forbidden), this is also handled in the GUI.
 * <p>
 * Note that some of the features have to be implemented in a concrete class. See description of abstract methods for
 * further information.
 * 
 * @author Christian Kroemer (christian.kroemer@z-corp-online.de)
 */
public abstract class MultiAttributeControl extends AbstractMEControl {
	// CONSTANTS
	private static final int PRIORITY = 2;

	// state attributes
	private int style;
	private int upperBound;
	private boolean isEditable;
	private boolean allowDuplicates;
	private ArrayList<AttributeControl> controlList = new ArrayList<AttributeControl>();

	// essential references
	private Composite composite;
	private GridLayout gridLayout;
	private Control emptyField; // or the bottom one if isFull() && isEditable()

	/**
	 * {@inheritDoc}
	 */
	@Override
	public int canRender(IItemPropertyDescriptor itemPropertyDescriptor, EObject modelElement) {
		Object feature = itemPropertyDescriptor.getFeature(modelElement);

		if (feature instanceof ETypedElement) {
			ETypedElement attr = (ETypedElement) feature;
			upperBound = attr.getUpperBound();
			if (upperBound == -1 || upperBound > 1) {
				return PRIORITY;
			} else {
				return DO_NOT_RENDER;
			}
		}
		return DO_NOT_RENDER;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public Control createControl(Composite parent, int style) {
		final EStructuralFeature feature = (EStructuralFeature) getItemPropertyDescriptor().getFeature(
			getModelElement());
		createDataStructures(feature);

		// set state
		this.setStyle(style);
		setEditable(getItemPropertyDescriptor().canSetProperty(getModelElement()));
		setAllowDuplicates(!feature.isUnique());

		// create composite structure
		setComposite(getToolkit().createComposite(parent, style | SWT.BORDER));
		configureGridLayout();
		getComposite().setLayout(gridLayout);

		// re-set upper bound... needed because canRender() was called in an other instance
		upperBound = feature.getUpperBound();

		initializeWidget();
		return getComposite();
	}

	/**
	 * Creates the lists for stored values and fields needed.
	 * 
	 * @param feature reference to the feature of this model element
	 */
	protected abstract void createDataStructures(EStructuralFeature feature);

	/**
	 * Configures the GridLayout.
	 */
	private void configureGridLayout() {
		gridLayout = new GridLayout(1, true);
		gridLayout.verticalSpacing = 0;
	}

	/**
	 * Creates, draws and fills all fields needed to display the attribute's data.
	 */
	protected void initializeWidget() {
		for (Object i : getAllStoredElements()) {
			createSingleField(i);
		}
		if (!isFull() && isEditable()) {
			createSingleField();
		}
		// make sure it is drawn correctly
		refreshWidget();
	}

	/**
	 * Resets the widget.
	 */
	protected void reInitializeWidget() {
		// remove empty control (not in controlList!)
		if (!isFull()) {
			emptyField.getParent().dispose();
		}
		// remove all other controls
		while (!controlList.isEmpty()) {
			controlList.get(0).dispose();
			controlList.remove(0);
		}
		initializeWidget();
	}

	/**
	 * Redraws the widget with correct layout.
	 */
	protected void refreshWidget() {
		Composite tmp = getComposite();
		while (!(tmp instanceof Form)) {
			// loop until the composite for the whole editor window is reached (doesn't work for less calls)
			tmp.layout(); // are all layout calls necessary?
			tmp = tmp.getParent();
		}
	}

	/**
	 * Checks if this widget is full.
	 * 
	 * @return true if full, false otherwise
	 */
	protected boolean isFull() {
		return ((getControlList().size() >= upperBound) && upperBound != -1);
	}

	/**
	 * Creates one new field within the widget.
	 * <p>
	 * Implement a widget that can display a single attribute of this type and make sure it features suitable Listeners
	 * (immediately store data and always call refreshWidget() after changes; also make sure there is always a new empty
	 * field if the upper bound isn't reached when the former empty field is filled with data; handle duplicates). Deny
	 * editing of field if the attribute is non-changeable.
	 * <p>
	 * Call this method without any parameter for an empty field!
	 * 
	 * @param content the data to be displayed in the new field; make sure it is the right type and cast it accordingly
	 *            in your implementation
	 */
	protected abstract void createSingleField(Object content);

	/**
	 * Creates one new empty field within the widget. See description of createSingleField(Object content) for further
	 * information on implementation details.
	 */
	protected abstract void createSingleField();

	/**
	 * Returns all elements of this attribute as Object array. Needed for some superclass methods.
	 * 
	 * @return the array
	 */
	public abstract Object[] getAllStoredElements();

	/**
	 * @param controlList the controlList to set
	 */
	public void setControlList(ArrayList<AttributeControl> controlList) {
		this.controlList = controlList;
	}

	/**
	 * @return the controlList
	 */
	public ArrayList<AttributeControl> getControlList() {
		return controlList;
	}

	/**
	 * @param style the style to set
	 */
	public void setStyle(int style) {
		this.style = style;
	}

	/**
	 * @return the style
	 */
	public int getStyle() {
		return style;
	}

	/**
	 * @param allowDuplicates the allowDuplicates to set
	 */
	public void setAllowDuplicates(boolean allowDuplicates) {
		this.allowDuplicates = allowDuplicates;
	}

	/**
	 * @return the allowDuplicates
	 */
	public boolean isAllowDuplicates() {
		return allowDuplicates;
	}

	/**
	 * @param composite the composite to set
	 */
	public void setComposite(Composite composite) {
		this.composite = composite;
	}

	/**
	 * @return the composite
	 */
	public Composite getComposite() {
		return composite;
	}

	/**
	 * @param isEditable the isEditable to set
	 */
	public void setEditable(boolean isEditable) {
		this.isEditable = isEditable;
	}

	/**
	 * @return the isEditable
	 */
	public boolean isEditable() {
		return isEditable;
	}

	/**
	 * @param emptyField the emptyField to set
	 */
	public void setEmptyField(Control emptyField) {
		this.emptyField = emptyField;
	}

	/**
	 * @return the emptyField
	 */
	public Control getEmptyField() {
		return emptyField;
	}

}
