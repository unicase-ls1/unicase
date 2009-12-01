/**
 * <copyright> Copyright (c) 2008-2009 Jonas Helming, Maximilian Koegel. All rights reserved. This program and the
 * accompanying materials are made available under the terms of the Eclipse Public License v1.0 which accompanies this
 * distribution, and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>
 */
package org.unicase.ui.unicasecommon.meeditor.mecontrols;

import java.text.DecimalFormat;

import org.eclipse.core.databinding.UpdateValueStrategy;
import org.eclipse.core.databinding.conversion.IConverter;
import org.eclipse.core.databinding.observable.value.IObservableValue;
import org.eclipse.emf.databinding.EMFDataBindingContext;
import org.eclipse.emf.databinding.edit.EMFEditObservables;
import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.edit.domain.EditingDomain;
import org.eclipse.jface.databinding.swt.SWTObservables;
import org.eclipse.jface.layout.GridDataFactory;
import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Label;
import org.eclipse.ui.forms.widgets.FormToolkit;
import org.unicase.ui.meeditor.mecontrols.AbstractMEControl;

/**
 * This class is responsible for displaying the file size of the FileAttachment file size attribute value.
 * 
 * @author pfeifferc
 */
public class MEFileSizeControl extends AbstractMEControl {

	private EAttribute attribute;

	/**
	 * Default constructor.
	 * 
	 * @param attribute attribute
	 * @param toolkit The SWT toolkit
	 * @param modelElement the file attachment
	 * @param editingDomain the Editing Domain
	 */
	public MEFileSizeControl(EAttribute attribute, FormToolkit toolkit, EObject modelElement,
		EditingDomain editingDomain) {

		this.attribute = attribute;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public Control createControl(Composite parent, int style) {
		Composite composite = getToolkit().createComposite(parent, style);
		GridLayout gridLayout = new GridLayout(1, false);
		composite.setLayout(gridLayout);
		GridDataFactory.fillDefaults().align(SWT.FILL, SWT.CENTER).grab(true, true).applyTo(composite);

		final Label fileSize = new Label(composite, SWT.RIGHT);

		// bind the fileName widget to the correspondent file attachment attribute value
		IObservableValue model = EMFEditObservables.observeValue(getEditingDomain(), getModelElement(), attribute);
		EMFDataBindingContext dbc = new EMFDataBindingContext();
		UpdateValueStrategy strategy = new UpdateValueStrategy();
		// the converter sees to that the file size is displayed according to its magnitude
		strategy.setConverter(new FileSizeConverter());
		dbc.bindValue(SWTObservables.observeText(fileSize), model, null, strategy);

		fileSize.setBackground(Display.getCurrent().getSystemColor(SWT.COLOR_WHITE));
		GridDataFactory.fillDefaults().align(SWT.FILL, SWT.CENTER).grab(true, true).applyTo(fileSize);

		return parent;
	}

	/**
	 * Converts the file size to be shown according to magnitude.
	 * 
	 * @author pfeifferc
	 */
	private final class FileSizeConverter implements IConverter {

		/**
		 * {@inheritDoc}
		 */
		public Object getToType() {
			return String.class;
		}

		/**
		 * {@inheritDoc}
		 */
		public Object getFromType() {
			return double.class;
		}

		/**
		 * {@inheritDoc}
		 */
		public Object convert(Object fromObject) {
			double size = Integer.parseInt(fromObject.toString());
			String[] magnitude = { " byte", " Kilobyte", " Megabyte", " Gigabyte", " Terabyte", " petabyte" };
			DecimalFormat format = new DecimalFormat("#0.00");
			if (size < 1024) {
				return (int) size + magnitude[0];
			}
			for (int i = 1; i < 6; i++) {
				if (size < Math.pow(1024, i + 1)) {
					return format.format(size / Math.pow(1024, i)) + magnitude[i];
				}
			}
			return "infinite";
		}
	}

}
