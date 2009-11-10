/**
 * <copyright> Copyright (c) 2008-2009 Jonas Helming, Maximilian Koegel. All rights reserved. This program and the
 * accompanying materials are made available under the terms of the Eclipse Public License v1.0 which accompanies this
 * distribution, and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>
 */
package org.unicase.ui.meeditor.mecontrols;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.impl.AdapterImpl;
import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.edit.domain.EditingDomain;
import org.eclipse.emf.transaction.RecordingCommand;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.emf.transaction.util.TransactionUtil;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.FocusAdapter;
import org.eclipse.swt.events.FocusEvent;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.ui.forms.widgets.FormToolkit;

/**
 * The Rich Text Editor MEControl.
 * 
 * @author shterev
 */
public class RTEditor extends AbstractMEControl {

	private Composite composite;
	private UnicaseRichTextViewer richTextViewer;
	private EAttribute attribute;
	private AdapterImpl eAdapter;

	/**
	 * Default constructor.
	 * 
	 * @param feature the feature
	 * @param editingDomain the editingDomain
	 * @param modelElement the modelElement
	 * @param toolkit the toolkit
	 */
	public RTEditor(EAttribute feature, EditingDomain editingDomain, EObject modelElement, FormToolkit toolkit) {
		super(editingDomain, modelElement, toolkit);
		this.attribute = feature;
		eAdapter = new AdapterImpl() {
			@Override
			public void notifyChanged(Notification msg) {
				if (msg.getFeature() != null && msg.getFeature().equals(RTEditor.this.attribute)) {
					load();
				}
				super.notifyChanged(msg);
			}
		};
		getModelElement().eAdapters().add(eAdapter);
	}

	/**
	 * {@inheritDoc}
	 */
	public Control createControl(Composite parent, int style) {

		composite = getToolkit().createComposite(parent, style);
		composite.setBackgroundMode(SWT.INHERIT_FORCE);
		composite.setLayout(new GridLayout(1, true));

		richTextViewer = new UnicaseRichTextViewer(composite, SWT.BORDER);

		richTextViewer.getTextWidget().addFocusListener(new FocusAdapter() {

			@Override
			public void focusLost(FocusEvent e) {
				save();
				super.focusLost(e);
			}

		});

		load();

		GridData gridData = new GridData(GridData.FILL_BOTH);
		gridData.horizontalSpan = 1;
		gridData.minimumWidth = 100;
		gridData.minimumHeight = 200;
		richTextViewer.getControl().setLayoutData(gridData);

		composite.pack();

		return composite;
	}

	private void load() {

		String content = (String) getModelElement().eGet(attribute);
		if (content != null) {
			richTextViewer.setHTML(content);
		}
	}

	private void save() {
		final String value = richTextViewer.getContentsHTML();
		TransactionalEditingDomain domain = TransactionUtil.getEditingDomain(getModelElement());
		domain.getCommandStack().execute(new RecordingCommand(domain) {
			@Override
			protected void doExecute() {
				getModelElement().eSet(attribute, value);
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
