/**
 * <copyright> Copyright (c) 2008 Jonas Helming, Maximilian Koegel. All rights reserved. This program and the accompanying materials are made available under the terms of the Eclipse Public License v1.0 which accompanies this distribution, and is available at http://www.eclipse.org/legal/epl-v10.html
 * </copyright>
 *
 * $Id$
 */
package org.unicase.ui.meeditor;

import java.util.ArrayList;
import java.util.Collections;
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
import org.eclipse.ui.forms.widgets.TableWrapData;
import org.eclipse.ui.forms.widgets.TableWrapLayout;
import org.eclipse.ui.menus.IMenuService;
import org.eclipse.ui.services.IEvaluationService;
import org.unicase.model.ModelElement;
import org.unicase.ui.meeditor.mecontrols.MEControl;
import org.unicase.ui.meeditor.mecontrols.METextControl;
import org.unicase.ui.meeditor.mecontrols.uccontrol.UseCaseStepsControl;

/**
 * The editor page for the {@link MEEditor}.
 * @author helming
 *
 */
public class MEEditorPage extends FormPage {

	private EditingDomain editingDomain;
	private ModelElement modelElement;
	private Composite body;
	private FormToolkit toolkit;
	private List<MEControl> meControls = new ArrayList<MEControl>();
	
	private static String activeModelelement = "activeModelelement";
	private ScrolledForm form;
	private List<IItemPropertyDescriptor> simpleAttributes = new ArrayList<IItemPropertyDescriptor>();
	private List<IItemPropertyDescriptor> multiReferences = new ArrayList<IItemPropertyDescriptor>();
	private Composite left;
	private Composite right;
	private Composite bottom;

	/**
	 * Default constructor.
	 * @param editor the {@link MEEditor}
	 * @param id @see {@link FormPage#id}
	 * @param title the title
	 * @param editingDomain the editingDomain
	 * @param modelElement the modelElement
	 */
	public MEEditorPage(MEEditor editor, String id, String title,
			EditingDomain editingDomain, ModelElement modelElement) {
		super(editor, id, title);
		this.editingDomain = editingDomain;
		this.modelElement = modelElement;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	protected void createFormContent(IManagedForm managedForm) {
		super.createFormContent(managedForm);
		
		toolkit = this.getEditor().getToolkit();
		form = managedForm.getForm();
		toolkit.decorateFormHeading(form.getForm());
		body = form.getBody();
		TableWrapLayout tableLayout = new TableWrapLayout();
		tableLayout.numColumns = 2;
		tableLayout.makeColumnsEqualWidth = true;
		body.setLayout(tableLayout);

		TableWrapLayout columnLayout = new TableWrapLayout();
		columnLayout.numColumns = 1;
				
		left = toolkit.createComposite(body);
		left.setLayout(columnLayout);
		left.setLayoutData(new TableWrapData(TableWrapData.FILL_GRAB));

		right = toolkit.createComposite(body);
		right.setLayout(columnLayout);
		right.setLayoutData(new TableWrapData(TableWrapData.FILL_GRAB));

		bottom = toolkit.createComposite(body);
		bottom.setLayout(columnLayout);
		bottom.setLayoutData(new TableWrapData(TableWrapData.FILL_GRAB,TableWrapData.TOP,1,2));

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
		this.form.layout();
		this.form.pack();

	}

	private void createToolbar() {
		IMenuService menuService = (IMenuService) PlatformUI.getWorkbench()
				.getService(IMenuService.class);
		ISourceProvider sourceProvider = new AbstractSourceProvider() {
			public void dispose() {
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
		if (propertyDescriptors != null){
			for (IItemPropertyDescriptor itemPropertyDescriptor : propertyDescriptors) {
				if (itemPropertyDescriptor.isMany(modelElement)) {
					multiReferences.add(itemPropertyDescriptor);
				} else {
					simpleAttributes.add(itemPropertyDescriptor);
				}
			}
			Collections.reverse(multiReferences);
		}

	}

	private void createMultiReferences() {
		ControlFactory controlFactory = new ControlFactory(editingDomain,
				modelElement, this.getEditor().getToolkit());
		for (IItemPropertyDescriptor itemPropertyDescriptor : multiReferences) {
			MEControl meControl = controlFactory
					.createControl(itemPropertyDescriptor);
			if (meControl != null) {
				meControls.add(meControl);
				Control control;
				if(meControl instanceof UseCaseStepsControl){
					control = meControl.createControl(bottom, SWT.WRAP);
				}else{
					control = meControl.createControl(right, SWT.WRAP);
				}
				control.setLayoutData(new TableWrapData(TableWrapData.FILL_GRAB));
			}
		}

	}

	private void createSimpleAttributes() {

		Section attributeSection = toolkit.createSection(left,
				Section.TITLE_BAR | Section.TWISTIE
						| Section.EXPANDED);
		attributeSection.setText("Attributes");
		Composite attributeComposite = toolkit
				.createComposite(attributeSection);
		TableWrapLayout attributeLayout = new TableWrapLayout();
		attributeLayout.numColumns = 2;
		attributeComposite.setLayout(attributeLayout);
		attributeSection.setLayoutData(new TableWrapData(TableWrapData.FILL_GRAB));

		ControlFactory controlFactory = new ControlFactory(editingDomain,
				modelElement, this.getEditor().getToolkit());
		for (IItemPropertyDescriptor itemPropertyDescriptor : simpleAttributes) {
			toolkit.createLabel(attributeComposite, itemPropertyDescriptor
					.getDisplayName(modelElement));
			MEControl meControl = controlFactory
					.createControl(itemPropertyDescriptor);
			meControls.add(meControl);
			Control control = meControl.createControl(attributeComposite,
					SWT.WRAP);
			control.setLayoutData(new TableWrapData(TableWrapData.FILL_GRAB));
		}
		attributeSection.setClient(attributeComposite);

	}
	
	/**
	 * {@inheritDoc}
	 */
	@Override
	public void dispose(){
		for(MEControl control : meControls){
			control.dispose();
		}
		super.dispose();
	}

	/**.
	 * {@inheritDoc}
	 * This method is added to solve the focus bug of navigator.
	 * Every time that a ME is opened in editor, navigator has to lose focus
	 * so that its action contributions are set correctly for next time.
	 *  
	 */
	@Override
	public void setFocus() {
			super.setFocus();
			//set keyboard focus on the first Text control
			for(MEControl meControl : this.meControls){
				if(meControl instanceof METextControl){
					((METextControl)meControl).setFocus();
					break;
				}
			}
	}

	
}