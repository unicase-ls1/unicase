/**
 * <copyright> Copyright (c) 2009-2012 Chair of Applied Software Engineering, Technische Universität München (TUM).
 * All rights reserved. This program and the accompanying materials are made available under the terms of
 * the Eclipse Public License v1.0 which accompanies this distribution,
 * and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>
 */
package org.unicase.docExport.editors.options;

import java.util.List;

import org.eclipse.emf.common.util.Enumerator;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Combo;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Label;

/**
 * @author Sebastian Hoecht
 */
public final class TOptionHelper {

	private TOptionHelper() {
	}

	/**
	 * A helper function which creates a labeled SWT Combobox out of a List.
	 * 
	 * @param parent the SWT parent object
	 * @param labelName the label for the combo box
	 * @param values the values of the enumerator
	 * @param defaultValue the default value of the option
	 * @return a new SWT Combo box
	 */
	public static Combo createComboBox(Composite parent, String labelName, List<? extends Enumerator> values,
		int defaultValue) {

		new Label(parent, SWT.LEFT).setText(labelName);
		Combo combo = new Combo(parent, SWT.READ_ONLY);

		for (Enumerator value : values) {
			combo.add(value.getLiteral(), value.getValue());
		}
		combo.select(defaultValue);

		return combo;

	}

	/**
	 * A helper function which creates a labeled SWT Checkbox ith a defaultValue.
	 * 
	 * @param parent the SWT parent object
	 * @param text the label
	 * @param value default value
	 * @return the created SWT Button
	 */
	public static Button createBooleanCheckbox(Composite parent, String text, boolean value) {
		new Label(parent, SWT.LEFT).setText(text);
		Button button = new Button(parent, SWT.CHECK);
		button.setSelection(value);
		return button;
	}
}
