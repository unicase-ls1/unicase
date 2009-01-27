/**
 * <copyright> Copyright (c) 2008 Jonas Helming, Maximilian Koegel. All rights reserved. This program and the
 * accompanying materials are made available under the terms of the Eclipse Public License v1.0 which accompanies this
 * distribution, and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>
 */
package org.unicase.docExport.handlers;

import org.eclipse.jface.dialogs.IMessageProvider;
import org.eclipse.jface.dialogs.TitleAreaDialog;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Combo;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Shell;
import org.unicase.docExport.exportModel.Template;
import org.unicase.docExport.exportModel.builders.DefaultModelElementRendererBuilder;
import org.unicase.docExport.exportModel.renderers.specialRenderers.SpecialRenderersFactory;
import org.unicase.model.meeting.MeetingPackage;

/**
 * @author Sebastian Hoecht
 */
public class SelectRendererDialog extends TitleAreaDialog {

	private String propertyEClass;
	private Template template;
	private Combo combo;

	/**
	 * the constructor.
	 * 
	 * @param parentShell the parent shell object
	 * @param template the template to save
	 */
	public SelectRendererDialog(Shell parentShell, Template template) {
		super(parentShell);
		setHelpAvailable(false);
		setTitle("Enter the name of the new Template");
		this.template = template;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	protected Control createDialogArea(Composite parent) {
		// return super.createDialogArea(parent);
		GridLayout layout = new GridLayout();
		layout.numColumns = 1;
		parent.setLayout(layout);

		combo = new Combo(parent, SWT.READ_ONLY);
		combo.add("DefaultModelElementRenderer", 0);
		combo.add("MeetingRenderer", 1);

		return parent;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	protected Control createContents(Composite parent) {
		Control contents = super.createContents(parent);
		// Set the title
		setTitle("This is my first own dialog");
		// Set the message
		setMessage("This is a TitleAreaDialog", IMessageProvider.INFORMATION);
		return contents;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	protected void createButtonsForButtonBar(Composite parent) {
		((GridLayout) parent.getLayout()).numColumns++;
		Button button = new Button(parent, SWT.PUSH);
		button.setText("OK");
		button.addSelectionListener(new SelectionAdapter() {

			@Override
			public void widgetSelected(SelectionEvent e) {
				if (combo.getSelectionIndex() == 1) {
					template.setModelElementRenderer(propertyEClass, SpecialRenderersFactory.eINSTANCE
						.createMeetingRenderer(template));
				} else {
					template.setModelElementRenderer(propertyEClass, DefaultModelElementRendererBuilder.build(
						MeetingPackage.eINSTANCE.getMeeting(), template));
				}
				close();
			}
		});

		Button button2 = new Button(parent, SWT.PUSH);
		button2.setText("Cancel");
		button2.addSelectionListener(new SelectionAdapter() {

			@Override
			public void widgetSelected(SelectionEvent e) {
				close();
			}
		});
	}

	/**
	 * @return the template
	 */
	public Template getTemplate() {
		return template;
	}

	/**
	 * @param propertyEClass the propertyEClass to set
	 */
	public void setPropertyEClass(String propertyEClass) {
		this.propertyEClass = propertyEClass;
	}

	/**
	 * @return the propertyEClass
	 */
	public String getPropertyEClass() {
		return propertyEClass;
	}

}
