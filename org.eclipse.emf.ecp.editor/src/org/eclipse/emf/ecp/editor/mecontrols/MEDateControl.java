/*******************************************************************************
 * Copyright (c) 2008-2011 Chair for Applied Software Engineering, Technische Universitaet Muenchen. All rights
 * reserved. This program and the accompanying materials are made available under the terms of the Eclipse Public
 * License v1.0 which accompanies this distribution, and is available at http://www.eclipse.org/legal/epl-v10.html
 * Contributors:
 ******************************************************************************/
package org.eclipse.emf.ecp.editor.mecontrols;

import java.util.Date;

import org.eclipse.core.databinding.observable.Diffs;
import org.eclipse.core.databinding.observable.value.AbstractObservableValue;
import org.eclipse.core.databinding.observable.value.IObservableValue;
import org.eclipse.emf.databinding.EMFDataBindingContext;
import org.eclipse.emf.databinding.edit.EMFEditObservables;
import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecp.common.commands.ECPCommand;
import org.eclipse.emf.edit.provider.IItemPropertyDescriptor;
import org.eclipse.jface.layout.GridDataFactory;
import org.eclipse.jface.layout.GridLayoutFactory;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.ModifyEvent;
import org.eclipse.swt.events.ModifyListener;
import org.eclipse.swt.events.MouseAdapter;
import org.eclipse.swt.events.MouseEvent;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.nebula.widgets.cdatetime.CDT;
import org.eclipse.swt.nebula.widgets.cdatetime.CDateTime;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.ui.ISharedImages;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.forms.widgets.ImageHyperlink;

/**
 * Standard widgets to edit a date attribute.
 * 
 * @author shterev
 * @author Christian Kroemer (christian.kroemer@z-corp-online.de)
 */
public class MEDateControl extends AbstractMEControl {

	private EAttribute attribute;
	private Composite dateComposite;
	private CDateTime cDateWidget;
	private ImageHyperlink dateDeleteButton;

	private static final int PRIORITY = 1;

	/**
	 * {@inheritDoc}
	 */
	@Override
	public Control createControl(Composite parent, int style) {
		this.attribute = (EAttribute) getItemPropertyDescriptor().getFeature(getModelElement());
		dateComposite = getToolkit().createComposite(parent);
		GridLayoutFactory.fillDefaults().numColumns(2).spacing(2, 0).applyTo(dateComposite);
		GridDataFactory.fillDefaults().grab(true, false).applyTo(dateComposite);
		dateComposite.setBackgroundMode(SWT.INHERIT_FORCE);

		createDateWidget();

		// data binding
		IObservableValue model = EMFEditObservables.observeValue(getEditingDomain(), getModelElement(), attribute);
		EMFDataBindingContext dbc = new EMFDataBindingContext();
		dbc.bindValue(new CDateTimeObservableValue(cDateWidget), model, null, null);

		return dateComposite;
	}

	private CDateTime createDateWidget() {
		// The picker (CDT.DROP_DOWN) is deactivated on purpose
		cDateWidget = new CDateTime(dateComposite, CDT.BORDER);
		cDateWidget.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true));
		cDateWidget.setPattern("dd.MM.yyyy HH:mm");
		cDateWidget.setSelection(null);
		dateDeleteButton = new ImageHyperlink(dateComposite, SWT.TOP);
		dateDeleteButton.setImage(PlatformUI.getWorkbench().getSharedImages().getImage(ISharedImages.IMG_TOOL_DELETE));
		dateDeleteButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseUp(MouseEvent e) {
				new ECPCommand(getModelElement()) {

					@Override
					protected void doRun() {
						getModelElement().eSet(attribute, null);
					}
				}.run(true);
			}
		});
		return cDateWidget;
	}

	/**
	 * Remove adapter. {@inheritDoc}
	 */
	@Override
	public void dispose() {
		super.dispose();
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.emf.ecp.editor.mecontrols.AbstractMEControl#canRender(org.eclipse.emf.edit.provider.IItemPropertyDescriptor,
	 *      org.eclipse.emf.ecore.EObject)
	 */
	@Override
	public int canRender(IItemPropertyDescriptor itemPropertyDescriptor, EObject modelElement) {
		return PRIORITY;
	}

	/**
	 * Implements DataBinding feature for the Nebula CDateTime control.
	 * 
	 * @author Christian Kroemer (christian.kroemer@z-corp-online.de)
	 */
	private class CDateTimeObservableValue extends AbstractObservableValue {

		private Date date;
		private final CDateTime widget;
		private boolean currentlyUpdatingFlag;

		private ModifyListener widgetListener = new ModifyListener() {
			public void modifyText(ModifyEvent e) {
				if (!currentlyUpdatingFlag) {
					// change from widget not handled right now
					Date newDate = widget.getSelection();
					fireValueChange(Diffs.createValueDiff(date, newDate));
					date = newDate;
				}
			}
		};

		/**
		 * Constructor.
		 * 
		 * @param widget the control to observe
		 */
		public CDateTimeObservableValue(CDateTime widget) {
			this.widget = widget;
			date = widget.getSelection();
			this.widget.addModifyListener(widgetListener);
		}

		/**
		 * {@inheritDoc}
		 */
		@Override
		public synchronized void dispose() {
			widget.removeModifyListener(widgetListener);
			super.dispose();
		}

		/**
		 * {@inheritDoc}
		 */
		@Override
		protected Object doGetValue() {
			if (!widget.isDisposed()) {
				return widget.getSelection();
			}
			return null;
		}

		/**
		 * {@inheritDoc}
		 */
		@Override
		protected void doSetValue(Object value) {
			if (value == null) {
				widget.setSelection(null);
			} else if (value instanceof Date && !widget.isDisposed()) {
				Date oldDate;
				Date newDate;
				try {
					currentlyUpdatingFlag = true;
					oldDate = widget.getSelection();
					newDate = (Date) value;
					widget.setSelection(newDate);
					date = newDate;
					fireValueChange(Diffs.createValueDiff(oldDate, newDate));
				} finally {
					currentlyUpdatingFlag = false;
				}
			}
		}

		/**
		 * {@inheritDoc}
		 */
		public Object getValueType() {
			return Date.class;
		}

	}
}
