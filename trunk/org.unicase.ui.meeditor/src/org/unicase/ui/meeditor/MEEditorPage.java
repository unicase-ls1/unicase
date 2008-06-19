/**
 * <copyright> Copyright (c) 2008 Jonas Helming, Maximilian Kšgel. All rights reserved. This program and the accompanying materials are made available under the terms of the Eclipse Public License v1.0 which accompanies this distribution, and is available at http://www.eclipse.org/legal/epl-v10.html
 * </copyright>
 *
 * $Id$
 */
package org.unicase.ui.meeditor;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.eclipse.emf.edit.domain.EditingDomain;
import org.eclipse.emf.edit.provider.AdapterFactoryItemDelegator;
import org.eclipse.emf.edit.provider.ComposedAdapterFactory;
import org.eclipse.emf.edit.provider.IItemPropertyDescriptor;
import org.eclipse.emf.edit.ui.provider.AdapterFactoryLabelProvider;
import org.eclipse.jface.action.ContributionManager;
import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.ui.AbstractSourceProvider;
import org.eclipse.ui.ISourceProvider;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.forms.IManagedForm;
import org.eclipse.ui.forms.editor.FormPage;
import org.eclipse.ui.forms.widgets.FormToolkit;
import org.eclipse.ui.forms.widgets.ScrolledForm;
import org.eclipse.ui.forms.widgets.Section;
import org.eclipse.ui.menus.IMenuService;
import org.eclipse.ui.services.IEvaluationService;
import org.unicase.model.ModelElement;
import org.unicase.model.edit.uihint.UIHintAdapter;
import org.unicase.model.edit.uihint.UIHintAdapterImpl;
import org.unicase.ui.meeditor.mecontrols.MEControl;

public class MEEditorPage extends FormPage {

	EditingDomain editingDomain;
	ModelElement modelElement;
	Composite body;
	FormToolkit toolkit;
	List<MEControl> meControls = new ArrayList<MEControl>();
	UIHintAdapter uiHintAdapter;
	static String activeModelelement = "activeModelelement";
	private ScrolledForm form;
	private List<IItemPropertyDescriptor> simpleAttributes = new ArrayList<IItemPropertyDescriptor>();
	private List<IItemPropertyDescriptor> multiReferences = new ArrayList<IItemPropertyDescriptor>();

	public MEEditorPage(MEEditor editor, String id, String title,
			EditingDomain editingDomain, ModelElement modelElement) {
		super(editor, id, title);
		this.editingDomain = editingDomain;
		this.modelElement = modelElement;
		uiHintAdapter = new UIHintAdapterImpl();
	}

	@Override
	protected void createFormContent(IManagedForm managedForm) {
		super.createFormContent(managedForm);
		toolkit = this.getEditor().getToolkit();
		form = managedForm.getForm();
		body = form.getBody();
		body.setLayout(new GridLayout());

		// Layout form
		form.setText(modelElement.getName());
		form.setImage(new AdapterFactoryLabelProvider(
				new ComposedAdapterFactory(
						ComposedAdapterFactory.Descriptor.Registry.INSTANCE))
				.getImage(modelElement));

		// Sort and order attributes

		sortAndOrderAttributes();

		// Create attributes
		createSimpleAttributes();

		// Create Sections for every Reference
		createMultiReferences();

		createToolbar();

	}

	private void createToolbar() {
		IMenuService menuService = (IMenuService) PlatformUI.getWorkbench()
				.getService(IMenuService.class);
		ISourceProvider sourceProvider = new AbstractSourceProvider() {

			public void dispose() {
				// TODO Auto-generated method stub

			}

			@SuppressWarnings("unchecked")
			public Map getCurrentState() {
				HashMap<Object, Object> map = new HashMap<Object, Object>();
				map.put(activeModelelement, modelElement);
				return map;
			}

			public String[] getProvidedSourceNames() {
				String[] namens = new String[1];
				namens[0] = activeModelelement;
				return namens;
			}

		};

		IEvaluationService service = (IEvaluationService) PlatformUI
				.getWorkbench().getService(IEvaluationService.class);
		service.addSourceProvider(sourceProvider);
		menuService.populateContributionManager((ContributionManager) form
				.getToolBarManager(),
				"toolbar:org.unicase.ui.meeditor.MEEditorPage");
		form.getToolBarManager().update(true);
	}

	private void sortAndOrderAttributes() {

		AdapterFactoryItemDelegator adapterFactoryItemDelegator = new AdapterFactoryItemDelegator(
				new ComposedAdapterFactory(
						ComposedAdapterFactory.Descriptor.Registry.INSTANCE));

		List<IItemPropertyDescriptor> propertyDescriptors = adapterFactoryItemDelegator
				.getPropertyDescriptors(modelElement);
		for (IItemPropertyDescriptor itemPropertyDescriptor : propertyDescriptors) {
			if (itemPropertyDescriptor.isMany(modelElement)) {
				multiReferences.add(itemPropertyDescriptor);
			} else {
				simpleAttributes.add(itemPropertyDescriptor);
			}
		}

	}

	private void createMultiReferences() {
		ControlFactory controlFactory = new ControlFactory(editingDomain,
				modelElement, this.getEditor().getToolkit());
		for (IItemPropertyDescriptor itemPropertyDescriptor : multiReferences) {
			MEControl meControl = controlFactory
					.createControl(itemPropertyDescriptor);
			if (meControl != null) {
				Control control = meControl.createControl(body, SWT.WRAP);
				control.setLayoutData(new GridData(GridData.FILL_HORIZONTAL));
			}
		}

	}

	private void createSimpleAttributes() {

		Section attributeSection = toolkit.createSection(body,
				Section.DESCRIPTION | Section.TITLE_BAR | Section.TWISTIE
						| Section.EXPANDED);
		attributeSection.setText("Attributes");
		Composite attributeComposite = toolkit
				.createComposite(attributeSection);
		GridLayout attributeLayout = new GridLayout();
		attributeLayout.numColumns = 2;
		attributeComposite.setLayout(attributeLayout);
		attributeSection.setLayoutData(new GridData(GridData.FILL_HORIZONTAL));

		ControlFactory controlFactory = new ControlFactory(editingDomain,
				modelElement, this.getEditor().getToolkit());
		for (IItemPropertyDescriptor itemPropertyDescriptor : simpleAttributes) {
			toolkit.createLabel(attributeComposite, itemPropertyDescriptor
					.getDisplayName(modelElement));
			MEControl meControl = controlFactory
					.createControl(itemPropertyDescriptor);
			Control control = meControl.createControl(attributeComposite,
					SWT.WRAP);
			control.setLayoutData(new GridData(GridData.FILL_HORIZONTAL));
		}
		attributeSection.setClient(attributeComposite);

	}

}