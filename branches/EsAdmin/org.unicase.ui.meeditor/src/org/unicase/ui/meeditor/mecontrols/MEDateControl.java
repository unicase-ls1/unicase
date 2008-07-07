/**
 * <copyright> Copyright (c) 2008 Jonas Helming, Maximilian Koegel. All rights reserved. This program and the accompanying materials are made available under the terms of the Eclipse Public License v1.0 which accompanies this distribution, and is available at http://www.eclipse.org/legal/epl-v10.html
 * </copyright>
 *
 * $Id$
 */
package org.unicase.ui.meeditor.mecontrols;

import java.util.Date;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.edit.domain.EditingDomain;
import org.eclipse.emf.transaction.RecordingCommand;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.emf.transaction.util.TransactionUtil;
import org.eclipse.nebula.widgets.cdatetime.CDT;
import org.eclipse.nebula.widgets.cdatetime.CDateTime;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.events.SelectionListener;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.ui.forms.widgets.FormToolkit;

/**
 * Standard widgets to edit a date attribute.
 * 
 * @author shterev
 */
public class MEDateControl extends AbstractMEControl implements MEControl, SelectionListener {

	private EAttribute attribute;
	private CDateTime widget;

	/**
	 * default constructor.
	 * 
	 * @param attribute
	 *            the date attribute
	 * @param toolkit
	 *            see {@link AbstractMEControl}
	 * @param modelElement
	 *            see {@link AbstractMEControl}
	 * @param editingDomain
	 *            see {@link AbstractMEControl}
	 */
	public MEDateControl(EAttribute attribute, FormToolkit toolkit, EObject modelElement, EditingDomain editingDomain) {
		super(editingDomain, modelElement, toolkit);
		this.attribute = attribute;
		// modelElement.eAdapters().add(new AdapterImpl() {
		// @Override
		// public void notifyChanged(Notification msg) {
		// if (msg.getFeature().equals(MEDateControl.this.attribute)) {
		// update();
		// System.out.println(msg.getNewValue());
		// }
		// super.notifyChanged(msg);
		// }
		//
		// });
	}

	/**
	 * {@inheritDoc}
	 */
	public Control createControl(Composite parent, int style) {
		Composite composite = toolkit.createComposite(parent);
		composite.setLayout(new GridLayout(2, false));

		widget = new CDateTime(composite, CDT.BORDER | CDT.DROP_DOWN | CDT.COMPACT);
		widget.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true));
		widget.setFormat(CDT.DATE_MEDIUM);
		widget.addSelectionListener(this);
		update();
		return composite;

	}

	/**
	 * {@inheritDoc}
	 */
	public void widgetSelected(SelectionEvent e) {
		// nothing to do here
	}

	/**
	 * {@inheritDoc}
	 */
	public void widgetDefaultSelected(SelectionEvent e) {
		TransactionalEditingDomain domain = TransactionUtil.getEditingDomain(modelElement);
		domain.getCommandStack().execute(new RecordingCommand(domain) {
			@Override
			protected void doExecute() {
				modelElement.eSet(attribute, widget.getSelection());
			}
		});
	}

	private void update() {
		TransactionalEditingDomain domain = TransactionUtil.getEditingDomain(modelElement);
		domain.getCommandStack().execute(new RecordingCommand(domain) {
			@Override
			protected void doExecute() {
				Date newDate = (Date) modelElement.eGet(attribute);
				if (newDate != null) {
					widget.setSelection(newDate);
				}
			}
		});
	}

}
