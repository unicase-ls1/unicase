/**
 * <copyright> Copyright (c) 2008 Jonas Helming, Maximilian Koegel. All rights reserved. This program and the
 * accompanying materials are made available under the terms of the Eclipse Public License v1.0 which accompanies this
 * distribution, and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>
 */
package org.unicase.ui.meeditor.mecontrols;

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
import org.eclipse.swt.widgets.Text;
import org.eclipse.ui.forms.widgets.FormToolkit;

/**
 * @author pfeifferc
 */
public class MEFileSizeControl extends AbstractMEControl {

	private EAttribute attribute;

	/**
	 * Default constructor.
	 * 
	 * @param attribute The mail attribute
	 * @param toolkit The swt toolkit
	 * @param modelElement The user
	 * @param editingDomain the edititng domain
	 */
	public MEFileSizeControl(EAttribute attribute, FormToolkit toolkit, EObject modelElement,
		EditingDomain editingDomain) {
		super(editingDomain, modelElement, toolkit);
		this.attribute = attribute;
	}

	/**
	 * {@inheritDoc}
	 */
	public Control createControl(Composite parent, int style) {
		Composite composite = getToolkit().createComposite(parent, style);
		GridLayout gridLayout = new GridLayout(1, false);
		composite.setLayout(gridLayout);
		GridDataFactory.fillDefaults().align(SWT.FILL, SWT.CENTER).grab(true, true).applyTo(composite);

		final Text fileSize = new Text(composite, SWT.RIGHT);
		IObservableValue model = EMFEditObservables.observeValue(getEditingDomain(), getModelElement(), attribute);
		EMFDataBindingContext dbc = new EMFDataBindingContext();
		UpdateValueStrategy strategy = new UpdateValueStrategy();
		strategy.setConverter(new FileSizeConverter());
		dbc.bindValue(SWTObservables.observeText(fileSize, SWT.FocusOut), model, null, strategy);

		fileSize.setEditable(false);
		fileSize.setBackground(Display.getCurrent().getSystemColor(SWT.COLOR_WHITE));
		GridDataFactory.fillDefaults().align(SWT.FILL, SWT.CENTER).grab(true, true).applyTo(fileSize);

		return parent;
	}

	/**
	 * @author pfeifferc
	 */
	private final class FileSizeConverter implements IConverter {
		public Object getToType() {
			return String.class;
		}

		public Object getFromType() {
			return double.class;
		}

		public Object convert(Object fromObject) {
			if (fromObject == null) {
				return fromObject;
			}
			double size = Integer.parseInt(fromObject.toString());
			DecimalFormat format = new DecimalFormat("#0.00");
			if (size < 1024) {
				return (int) size + " byte";
			}
			if (size < 1024 * 1024) {
				return format.format(size / 1024) + " kilobyte";
			}
			if (size < 1024 * 1024 * 1024) {
				return format.format(size / (1024 * 1024)) + " megabyte";
			}
			if (size < 1024 * 1024 * 1024 * 1024) {
				return format.format(size / (1024 * 1024 * 1024)) + " gigabyte";
			}
			return fromObject.toString();
		}
	}

}
