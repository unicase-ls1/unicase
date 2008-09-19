/**
 * <copyright> Copyright (c) 2008 Jonas Helming, Maximilian Koegel. All rights reserved. This program and the accompanying materials are made available under the terms of the Eclipse Public License v1.0 which accompanies this distribution, and is available at http://www.eclipse.org/legal/epl-v10.html
 * </copyright>
 *
 * $Id$
 */
package org.unicase.ui.meeditor.mecontrols.melinkcontrol;

import java.util.Collection;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.impl.AdapterImpl;
import org.eclipse.emf.common.util.BasicEList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.edit.domain.EditingDomain;
import org.eclipse.emf.edit.provider.ComposedAdapterFactory;
import org.eclipse.emf.edit.provider.IItemPropertyDescriptor;
import org.eclipse.emf.edit.ui.provider.AdapterFactoryLabelProvider;
import org.eclipse.emf.transaction.RecordingCommand;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.emf.transaction.util.TransactionUtil;
import org.eclipse.jface.layout.GridDataFactory;
import org.eclipse.jface.layout.GridLayoutFactory;
import org.eclipse.jface.window.Window;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.layout.FillLayout;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Label;
import org.eclipse.ui.dialogs.ElementListSelectionDialog;
import org.eclipse.ui.forms.widgets.FormToolkit;
import org.unicase.model.ModelElement;
import org.unicase.ui.meeditor.Activator;
import org.unicase.ui.meeditor.mecontrols.AbstractMEControl;

/**
 * GUI Control for the ME reference single links.
 * 
 * @author helming
 * 
 */
public class MESingleLinkControl extends AbstractMEControl {

	private Composite composite;

	private final EReference eReference;

	private Composite linkArea;

	private Composite parent;

	private int style;

	private MELinkControl meControl;

	private Label labelWidget;
	private AdapterImpl eAdapter;

	private IItemPropertyDescriptor itemPropertyDescriptor;

	/**
	 * Default constructor.
	 * 
	 * @param editingDomain
	 *            the editing domain
	 * @param modelElement
	 *            the ME
	 * @param toolkit
	 *            gui toolkit used for rendering
	 * @param reference
	 *            the reference link
	 */
	public MESingleLinkControl(EditingDomain editingDomain, EObject modelElement, FormToolkit toolkit, EReference reference, IItemPropertyDescriptor itemPropertyDescriptor) {
		super(editingDomain, modelElement, toolkit);
		this.eReference = reference;
		this.itemPropertyDescriptor = itemPropertyDescriptor;
		eAdapter = new AdapterImpl() {
			@Override
			public void notifyChanged(Notification msg) {
				if (msg.getFeature() != null && msg.getFeature().equals(eReference)) {
					updateLink();
				}
				super.notifyChanged(msg);
			}

		};
		modelElement.eAdapters().add(eAdapter);
	}

	/**
	 * {@inheritDoc}
	 */
	public Control createControl(final Composite parent, int style) {
		composite = getToolkit().createComposite(parent, style);
//		composite.setLayout(new GridLayout(3, false));
		GridLayoutFactory.fillDefaults().spacing(0, 0).numColumns(3).equalWidth(false).applyTo(composite);
		this.parent = parent;
		this.style = style;
		linkArea = getToolkit().createComposite(composite);
		linkArea.setLayout(new FillLayout());
		updateLink();
		
		final AddReferenceAction addAction = new AddReferenceAction((ModelElement)getModelElement(),eReference,itemPropertyDescriptor); 
		final NewReferenceAction newAction = new NewReferenceAction((ModelElement)getModelElement(),eReference,itemPropertyDescriptor); 
		
		Button selectButton = getToolkit().createButton(composite, "", SWT.PUSH);
		selectButton.setImage(addAction.getImageDescriptor().createImage());
		selectButton.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				addAction.run();
			}

		});
		Button newButton = getToolkit().createButton(composite, "", SWT.PUSH);
		newButton.setImage(newAction.getImageDescriptor().createImage());//Activator.getImageDescriptor("icons/link.png").createImage());
		newButton.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				newAction.run();
			}
		});
		
		return composite;
	}

	private void updateLink() {
		if (meControl != null) {
			meControl.dispose();
		}
		if (labelWidget != null) {
			labelWidget.dispose();
		}
		TransactionalEditingDomain domain = TransactionUtil.getEditingDomain(getModelElement());
		domain.getCommandStack().execute(new RecordingCommand(domain) {

			@Override
			protected void doExecute() {
				EObject opposite = (EObject) getModelElement().eGet(eReference);
				ModelElement me = (ModelElement) getModelElement();
				if (opposite != null) {
					meControl = new MELinkControl(getEditingDomain(), opposite, getToolkit(), me, eReference);
					meControl.createControl(linkArea, style);
				} else {
					labelWidget = getToolkit().createLabel(linkArea, "(Not Set)");
					labelWidget.setForeground(parent.getShell().getDisplay().getSystemColor(SWT.COLOR_GRAY));
				}
				composite.layout(true);

			}
		});
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void dispose() {
		getModelElement().eAdapters().remove(eAdapter);
	}
}
