/**
 * <copyright> Copyright (c) 2008-2009 Jonas Helming, Maximilian Koegel. All rights reserved. This program and the
 * accompanying materials are made available under the terms of the Eclipse Public License v1.0 which accompanies this
 * distribution, and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>
 */

package org.unicase.ui.refactoring.strategies.dialogs.util;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.emf.edit.domain.EditingDomain;
import org.eclipse.emf.edit.provider.AdapterFactoryItemDelegator;
import org.eclipse.emf.edit.provider.ComposedAdapterFactory;
import org.eclipse.emf.edit.ui.provider.AdapterFactoryLabelProvider;
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
import org.unicase.model.UnicaseModelElement;
import org.unicase.ui.meeditor.mecontrols.AbstractMEControl;
import org.unicase.ui.refactoring.Activator;
import org.unicase.ui.refactoring.strategies.dialogs.wizards.pages.util.controls.MERichTextControlWithoutToolbar;
import org.unicase.ui.unicasecommon.UnicaseActionHelper;
import org.unicase.workspace.WorkspaceManager;

/**
 * The refactoring dialog helper.
 * 
 * @author pfeifferc
 */
public class RefactoringDialogHelper {

	private List<Control> controls;

	private List<AbstractMEControl> abstractMEControls;

	/**
	 * The refactoring dialog helper.
	 */
	public RefactoringDialogHelper() {
		controls = new ArrayList<Control>();
		abstractMEControls = new ArrayList<AbstractMEControl>();
	}

	/**
	 * @param parent composite
	 * @return composite
	 */
	public Composite createBodyComposite(Composite parent) {
		Composite composite = new Composite(parent, SWT.NONE);
		composite.setLayout(new GridLayout(1, false));
		composite.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true));
		addControl(composite);
		return composite;
	}

	private void addControl(Control control) {
		setDebugColor(control);
		controls.add(control);
	}

	/**
	 * @param parent the
	 * @param unicaseModelElement the
	 * @return composite
	 */
	public Composite createModelElementInformationComposite(Composite parent, UnicaseModelElement unicaseModelElement) {
		// create composite to put other widgets on
		Composite composite = createComposite(parent, SWT.TOP, new GridLayout(2, false), new GridData(SWT.FILL,
				SWT.TOP, true, false));
		// create model element icon
		createIconLabel(composite, getLabelProvider().getImage(
				unicaseModelElement));
		// create affected model element text
		createText(composite, "Affected model element: " + getLabelProvider().getText(unicaseModelElement),
				true);
		// create creator icon
		createIconLabel(composite, "filtertouser.png");
		// create affected model element creator text
		createText(composite, "Creator: " + unicaseModelElement.getCreator(), true);
		// create date icon
		createIconLabel(composite, "date.png");
		// create affected model element created text
		createText(composite, "Created: "
				+ unicaseModelElement.getCreationDate().toString(), true);
		return composite;
	}

	/**
	 * @param parent the
	 * @param unicaseModelElement the
	 */
	public void createModelElementInformationWithDescriptionComposite(Composite parent, UnicaseModelElement unicaseModelElement) {
		// create model element information composite without description
		Composite composite = createModelElementInformationComposite(parent, unicaseModelElement);
		// create date icon
		createIconLabel(composite, "pencil.png");
		// create affected model element description
		createText(composite, "Description: "+ unicaseModelElement.getDescriptionPlainText(), true);
	}

	/**
	 * @param parent the
	 * @param swt parameters
	 * @param layout the
	 * @param layoutData the
	 * @return the composite
	 */
	public Composite createComposite(Composite parent, int swt, Layout layout, Object layoutData) {
		Composite composite = new Composite(parent, swt);
		composite.setLayout(layout);
		composite.setLayoutData(layoutData);
		addControl(composite);
		return composite;
	}

	/**
	 * @param parent the
	 * @param information text
	 * @param fileName the
	 * @return the composite
	 */
	public Composite createExplanatoryTextComposite(Composite parent, String information, String fileName) {
		Composite composite = createComposite(parent, SWT.NONE, new GridLayout(2, false), new GridData(SWT.FILL,
				SWT.TOP, true, false));
		createIconLabel(composite, fileName);
		Text text = new Text(composite, SWT.MULTI | SWT.WRAP);
		text.setText(information);
		text.setLayoutData(new GridData(SWT.NONE, SWT.TOP, true, true));
		text.setEditable(false);
		addControl(text);
		return composite;
	}

	/**
	 * @param composite the
	 * @param name text
	 * @return the text
	 */
	public Text createText(Composite composite, String name) {
		return createText(composite, name, false);
	}

	/**
	 * 
	 * @param parent the
	 * @return label
	 */
	public Label createSeparator(Composite parent) {
		Label label = new Label(parent, SWT.SEPARATOR | SWT.HORIZONTAL);
		label.setLayoutData(new GridData(SWT.FILL, SWT.TOP, true, false));
		return label;
	}

	/**
	 * @param composite the
	 * @param name text
	 * @param grabHorizontal if
	 * @return the text
	 */
	public Text createText(Composite composite, String name, boolean grabHorizontal) {
		Text text = new Text(composite, SWT.WRAP | SWT.MULTI);
		text.setText(name);
		text.setLayoutData(new GridData(SWT.BEGINNING, SWT.TOP, grabHorizontal, false));
		text.setEditable(false);
		addControl(text);
		return text;
	}

	/**
	 * @param parent the
	 * @param fileName the
	 * @return the icon label
	 */
	public Label createIconLabel(Composite parent, String fileName) {
		return createIconLabel(parent, getImageForFileName(fileName));
	}

	/**
	 * @param parent the
	 * @param image the
	 * @return the icon label
	 */
	public Label createIconLabel(Composite parent, Image image) {
		Label label = new Label(parent, SWT.NONE);
		label.setImage(image);
		setIconLabelData(label);
		addControl(label);
		return label;
	}

	/**
	 * @param control the
	 * @param parent the
	 * @param modelElement the
	 * @param feature the
	 * @return the control
	 */
	public Control createMEControl(AbstractMEControl control, Composite parent, ModelElement modelElement,
			String feature) {
		Control modelElementControl = control.createControl(parent, SWT.FILL, new AdapterFactoryItemDelegator(
				new ComposedAdapterFactory(ComposedAdapterFactory.Descriptor.Registry.INSTANCE)).getPropertyDescriptor(
						modelElement, feature), modelElement, UnicaseActionHelper.getContext(modelElement), new FormToolkit(Display.getCurrent()));
		GridData gridData = new GridData(SWT.FILL, SWT.TOP, true, false);
		if (control instanceof MERichTextControlWithoutToolbar) {
			gridData.heightHint = 120;
		}
		modelElementControl.setLayoutData(gridData);
		abstractMEControls.add(control);
		controls.add(modelElementControl);
		return modelElementControl;
	}

	/**
	 * @param parent the
	 * @return the label
	 */
	public Label createIconLabel(Composite parent) {
		Label label = new Label(parent, SWT.NONE);
		setIconLabelData(label);
		addControl(label);
		return label;
	}

	private void setIconLabelData(Label label) {
		GridData gridData = new GridData(SWT.BEGINNING, SWT.TOP, false, false);
		gridData.widthHint = 20;
		gridData.heightHint = 16;
		label.setLayoutData(gridData);
	}

	/**
	 * @param fileName the
	 * @return the image
	 */
	public Image getImageForFileName(String fileName) {
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
	public boolean canFinish() {
		return false;
	}

	/**
	 * Debug method.
	 * 
	 * @param control the
	 */
	private void setDebugColor(Control control) {
		control.setBackground(Display.getDefault().getSystemColor(SWT.COLOR_WIDGET_BACKGROUND));
	}

	/**
	 * @return the editing domain
	 */
	public EditingDomain getEditingDomain() {
		return WorkspaceManager.getInstance().getCurrentWorkspace().getEditingDomain();
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.jface.dialogs.DialogPage#dispose()
	 */
	public void dispose() {
		disposeMEControls();
		disposeControls();
	}

	/**
	 * Dispose the ME controls.
	 */
	public void disposeMEControls() {
		for(AbstractMEControl abstractMEControl : abstractMEControls) {
			abstractMEControl.dispose();
		}
	}

	/**
	 * @return the provider
	 */
	public static AdapterFactoryLabelProvider getLabelProvider() {
		AdapterFactoryLabelProvider provider = new AdapterFactoryLabelProvider(new ComposedAdapterFactory(
				ComposedAdapterFactory.Descriptor.Registry.INSTANCE));
		return provider;
	}

	private void disposeControls() {
		for (Control control : controls) {
			if (!control.isDisposed()) {
				control.dispose();
			}
		}
	}
}
