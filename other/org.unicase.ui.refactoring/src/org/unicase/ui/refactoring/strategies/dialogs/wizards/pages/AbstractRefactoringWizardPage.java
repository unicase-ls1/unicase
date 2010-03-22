/**
 * <copyright> Copyright (c) 2008-2009 Jonas Helming, Maximilian Koegel. All rights reserved. This program and the
 * accompanying materials are made available under the terms of the Eclipse Public License v1.0 which accompanies this
 * distribution, and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>
 */

package org.unicase.ui.refactoring.strategies.dialogs.wizards.pages;

import java.util.ArrayList;

import org.eclipse.emf.edit.domain.EditingDomain;
import org.eclipse.emf.edit.provider.AdapterFactoryItemDelegator;
import org.eclipse.emf.edit.provider.ComposedAdapterFactory;
import org.eclipse.jface.wizard.WizardPage;
import org.eclipse.swt.SWT;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Layout;
import org.eclipse.swt.widgets.Text;
import org.eclipse.ui.forms.widgets.FormToolkit;
import org.unicase.metamodel.ModelElement;
import org.unicase.ui.meeditor.mecontrols.AbstractMEControl;
import org.unicase.ui.refactoring.Activator;
import org.unicase.ui.refactoring.strategies.dialogs.wizards.AbstractRefactoringWizard;
import org.unicase.ui.refactoring.strategies.dialogs.wizards.pages.controls.MERichTextControlWithoutToolbar;
import org.unicase.workspace.WorkspaceManager;

/**
 * @author pfeifferc
 */
public abstract class AbstractRefactoringWizardPage extends WizardPage {

	private AbstractRefactoringWizard wizard;

	private ArrayList<Control> controls;

	private ArrayList<AbstractMEControl> abstractControls;

	/**
	 * The constructor.
	 * 
	 * @param pageName the
	 * @param wizard the
	 */
	protected AbstractRefactoringWizardPage(String pageName, AbstractRefactoringWizard wizard) {
		super(pageName);
		this.wizard = wizard;
		controls = new ArrayList<Control>();
		abstractControls = new ArrayList<AbstractMEControl>();
		setTitle("Violation of constraint rule " + pageName.replace("_", " "));
		setDescription("Please choose how to proceed with the refactoring");
	}

	/**
	 * @param parent the
	 * @see org.eclipse.jface.dialogs.IDialogPage#createControl(org.eclipse.swt.widgets.Composite)
	 */
	public void createControl(Composite parent) {
		parent.getShell().setSize(600, 650);
		parent.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true));
	}

	/**
	 * @return the wizard
	 */
	protected AbstractRefactoringWizard getRefactoringWizard() {
		return wizard;
	}

	/**
	 * @param parent composite
	 * @return composite
	 */
	protected Composite createBodyComposite(Composite parent) {
		Composite composite = new Composite(parent, SWT.NONE);
		composite.setLayout(new GridLayout(1, false));
		composite.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true));
		controls.add(composite);
		return composite;
	}

	/**
	 * @param parent the
	 */
	protected void createModelElementInformationComposite(Composite parent) {
		// create composite to put other widgets on
		Composite composite = createComposite(parent, SWT.TOP, new GridLayout(2, false), new GridData(SWT.FILL,
			SWT.TOP, true, false));
		// create action item icon
		createIconLabel(composite, getRefactoringWizard().getLabelProvider().getImage(
			getRefactoringWizard().getInvalidModelElement()));
		// create affected action item text
		createText(composite, "Affected model element: " + getRefactoringWizard().getInvalidModelElement().getName(),
			true);
		// create action item icon
		createIconLabel(composite, "filtertouser.png");
		// create affected action item text
		createText(composite, "Creator: " + getRefactoringWizard().getInvalidModelElement().getCreator(), true);
		// create date icon
		createIconLabel(composite, "date.png");
		// create affected action item text
		createText(composite, "Created: "
			+ getRefactoringWizard().getInvalidModelElement().getCreationDate().toString(), true);
	}

	/**
	 * @param parent the
	 * @param swt parameters
	 * @param layout the
	 * @param layoutData the
	 * @return the composite
	 */
	protected Composite createComposite(Composite parent, int swt, Layout layout, Object layoutData) {
		Composite composite = new Composite(parent, swt);
		composite.setLayout(layout);
		composite.setLayoutData(layoutData);
		controls.add(composite);
		setDebugColor(composite);
		return composite;
	}

	/**
	 * @param parent the
	 * @param information text
	 * @param fileName the
	 * @return the composite
	 */
	protected Composite createExplanatoryTextComposite(Composite parent, String information, String fileName) {
		Composite composite = createComposite(parent, SWT.NONE, new GridLayout(2, false), new GridData(SWT.FILL,
			SWT.TOP, true, false));
		createIconLabel(composite, fileName);
		Text text = new Text(composite, SWT.MULTI | SWT.WRAP);
		text.setText(information);
		text.setLayoutData(new GridData(SWT.NONE, SWT.TOP, true, true));
		text.setEditable(false);
		controls.add(text);
		return composite;
	}

	/**
	 * @param composite the
	 * @param name text
	 * @return the text
	 */
	protected Text createText(Composite composite, String name) {
		return createText(composite, name, false);
	}

	/**
	 * @param composite the
	 * @param name text
	 * @param grabHorizontal if
	 * @return the text
	 */
	protected Text createText(Composite composite, String name, boolean grabHorizontal) {
		Text text = new Text(composite, SWT.WRAP | SWT.MULTI);
		text.setText(name);
		text.setLayoutData(new GridData(SWT.BEGINNING, SWT.TOP, grabHorizontal, false));
		text.setEditable(false);
		controls.add(text);
		return text;
	}

	/**
	 * @param parent the
	 * @param fileName the
	 * @return the icon label
	 */
	protected Label createIconLabel(Composite parent, String fileName) {
		return createIconLabel(parent, getImageForFileName(fileName));
	}

	/**
	 * @param parent the
	 * @param image the
	 * @return the icon label
	 */
	protected Label createIconLabel(Composite parent, Image image) {
		Label label = new Label(parent, SWT.NONE);
		label.setImage(image);
		GridData gridData = new GridData(SWT.BEGINNING, SWT.TOP, false, false);
		gridData.widthHint = 20;
		gridData.heightHint = 16;
		label.setLayoutData(gridData);
		controls.add(label);
		return label;
	}

	/**
	 * @param control the
	 * @param parent the
	 * @param modelElement the
	 * @param feature the
	 * @return the control
	 */
	protected Control createMEControl(AbstractMEControl control, Composite parent, ModelElement modelElement,
		String feature) {
		Control modelElementControl = control.createControl(parent, SWT.FILL, new AdapterFactoryItemDelegator(
			new ComposedAdapterFactory(ComposedAdapterFactory.Descriptor.Registry.INSTANCE)).getPropertyDescriptor(
			modelElement, feature), modelElement, getEditingDomain(), new FormToolkit(Display.getCurrent()));
		GridData gridData = new GridData(SWT.FILL, SWT.TOP, true, false);
		if (control instanceof MERichTextControlWithoutToolbar) {
			gridData.heightHint = 120;
		}
		modelElementControl.setLayoutData(gridData);
		abstractControls.add(control);
		controls.add(modelElementControl);
		return modelElementControl;
	}

	/**
	 * @param fileName the
	 * @return the image
	 */
	protected Image getImageForFileName(String fileName) {
		return Activator.getImageDescriptor("icons/" + fileName).createImage();
	}

	/**
	 * To be called when the page is selected.
	 */
	public void pageSelected() {
		// nothing to do here
	}

	/**
	 * @return can finish
	 */
	protected boolean canFinish() {
		return false;
	}

	/**
	 * Debug method.
	 * 
	 * @param control the
	 */
	protected void setDebugColor(Control control) {
		control.setBackground(Display.getCurrent().getSystemColor(SWT.COLOR_CYAN));
	}

	/**
	 * @return the editing domain
	 */
	protected EditingDomain getEditingDomain() {
		return WorkspaceManager.getInstance().getCurrentWorkspace().getEditingDomain();
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.jface.dialogs.DialogPage#dispose()
	 */
	@Override
	public void dispose() {
		for (AbstractMEControl control : abstractControls) {
			control.dispose();
		}
		for (Control control : controls) {
			if (!control.isDisposed()) {
				control.dispose();
			}
		}
		super.dispose();
	}
}
