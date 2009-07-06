/**
 * <copyright> Copyright (c) 2008 Jonas Helming, Maximilian Koegel. All rights reserved. This program and the accompanying materials are made available under the terms of the Eclipse Public License v1.0 which accompanies this distribution, and is available at http://www.eclipse.org/legal/epl-v10.html
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
import org.eclipse.jface.layout.GridDataFactory;
import org.eclipse.jface.layout.GridLayoutFactory;
import org.eclipse.swt.SWT;
import org.eclipse.swt.custom.SashForm;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Label;
import org.eclipse.ui.AbstractSourceProvider;
import org.eclipse.ui.ISourceProvider;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.forms.IManagedForm;
import org.eclipse.ui.forms.editor.FormPage;
import org.eclipse.ui.forms.widgets.FormToolkit;
import org.eclipse.ui.forms.widgets.ScrolledForm;
import org.eclipse.ui.menus.IMenuService;
import org.eclipse.ui.services.IEvaluationService;
import org.unicase.model.ModelElement;
import org.unicase.model.rationale.Issue;
import org.unicase.ui.meeditor.mecontrols.AbstractMEControl;
import org.unicase.ui.meeditor.mecontrols.MEControl;
import org.unicase.ui.meeditor.mecontrols.METextControl;
import org.unicase.ui.meeditor.mecontrols.uccontrol.UseCaseStepsControl;

/**
 * The editor page for the {@link MEEditor}.
 * @author helming
 * @author shterev
 *
 */
public class MEEditorPage extends FormPage {

	private EditingDomain editingDomain;
	private ModelElement modelElement;
	private FormToolkit toolkit;
	private List<MEControl> meControls = new ArrayList<MEControl>();
	
	private static String activeModelelement = "activeModelelement";
	private ScrolledForm form;
	private List<IItemPropertyDescriptor> leftColumnAttributes = new ArrayList<IItemPropertyDescriptor>();
	private List<IItemPropertyDescriptor> rightColumnAttributes = new ArrayList<IItemPropertyDescriptor>();
	private Composite leftColumnComposite;
	private Composite rightColumnComposite;
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
		Composite body = form.getBody();
		body.setLayout(new GridLayout());
		SashForm globalSash = new SashForm(body, SWT.VERTICAL);
		GridDataFactory.fillDefaults().align(SWT.FILL, SWT.FILL).grab(true, true).applyTo(globalSash);
		toolkit.adapt(globalSash, true, true);

		SashForm topSash = new SashForm(globalSash, SWT.HORIZONTAL);
		GridDataFactory.fillDefaults().align(SWT.FILL, SWT.FILL).grab(true, true).applyTo(topSash);
		toolkit.adapt(topSash, true, true);
		topSash.setSashWidth(4);
		
		leftColumnComposite = toolkit.createComposite(topSash, SWT.NONE);
		GridLayoutFactory.fillDefaults().numColumns(1).equalWidth(false).extendedMargins(2, 5, 5, 5).applyTo(leftColumnComposite);
		GridDataFactory.fillDefaults().align(SWT.FILL, SWT.FILL).applyTo(leftColumnComposite);

		rightColumnComposite = toolkit.createComposite(topSash, SWT.NONE);
		GridLayoutFactory.fillDefaults().numColumns(1).equalWidth(false).extendedMargins(5, 2, 5, 5).applyTo(rightColumnComposite);
		GridDataFactory.fillDefaults().align(SWT.FILL, SWT.FILL).applyTo(rightColumnComposite);
		
		int[] topWeights = {50,50};
		topSash.setWeights(topWeights);
		
		bottom = toolkit.createComposite(globalSash);
		GridLayoutFactory.fillDefaults().numColumns(1).equalWidth(false).extendedMargins(5, 5, 5, 5).applyTo(bottom);
		GridDataFactory.fillDefaults().align(SWT.LEFT, SWT.TOP).grab(true, false).applyTo(bottom);

		// Layout form
		form.setText(modelElement.getName());
		form.setImage(new AdapterFactoryLabelProvider(
				new ComposedAdapterFactory(
						ComposedAdapterFactory.Descriptor.Registry.INSTANCE))
				.getImage(modelElement));

		// Sort and order attributes
		sortAndOrderAttributes();
		// Create attributes
		createAttributes(leftColumnComposite,leftColumnAttributes);
		createAttributes(rightColumnComposite,rightColumnAttributes);
		// Create special ME Control
		createSpecificMEControls();
		createToolbar();
		form.pack();
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
//			DO NOT REMOVE 
//			
//			final HashMap<IItemPropertyDescriptor,Double> map = new HashMap<IItemPropertyDescriptor, Double>();
//			IAttributePriorityDescriptor priorityDescriptor = new AnnotationPriorityDescriptor();
//			for (IItemPropertyDescriptor itemPropertyDescriptor : propertyDescriptors) {
//				map.put(itemPropertyDescriptor,priorityDescriptor.getPriority(itemPropertyDescriptor, modelElement));
//			}
//			Collections.sort(propertyDescriptors, new Comparator<IItemPropertyDescriptor>(){
//				public int compare(IItemPropertyDescriptor o1,
//						IItemPropertyDescriptor o2) {
//					return Double.compare(map.get(o1), map.get(o2));
//				}
//			});
//			int length = propertyDescriptors.size();
//			for(int i=0; i<length/2; i++){
//				leftColumnAttributes.add(propertyDescriptors.get(i));
//			}
//			for(int i=length/2; i<length; i++){
//				rightColumnAttributes.add(propertyDescriptors.get(i));
//			}
			for(IItemPropertyDescriptor pd : propertyDescriptors){
				if(!pd.isMany(modelElement)){
					leftColumnAttributes.add(pd);
				}else{
					rightColumnAttributes.add(pd);
				}	
			}
			
		}

	}

	private void createAttributes(Composite column, List<IItemPropertyDescriptor> attributes) {
		Composite attributeComposite = toolkit.createComposite(column);
		GridLayoutFactory.fillDefaults().numColumns(2).applyTo(attributeComposite);
		GridDataFactory.fillDefaults().grab(true, true).align(SWT.FILL, SWT.BEGINNING).applyTo(attributeComposite);
		
		ControlFactory controlFactory = new ControlFactory(editingDomain, modelElement, this.getEditor().getToolkit());
		
		for (IItemPropertyDescriptor itemPropertyDescriptor : attributes) {
			MEControl meControl = controlFactory.createControl(itemPropertyDescriptor);
			if(meControl==null){
				continue;
			}
			meControls.add(meControl);
			Control control;
			if(!itemPropertyDescriptor.isMany(modelElement)){
				Label label = toolkit.createLabel(attributeComposite, itemPropertyDescriptor.getDisplayName(modelElement));
				control = meControl.createControl(attributeComposite, SWT.WRAP);
				GridDataFactory.fillDefaults().align(SWT.LEFT, SWT.CENTER).applyTo(label);
				GridDataFactory.fillDefaults().grab(true, false).align(SWT.FILL, SWT.BEGINNING).applyTo(control);
				if(meControl instanceof AbstractMEControl){
					((AbstractMEControl)meControl).applyCustomLayoutData();
				}
			}else{
				if(meControl instanceof UseCaseStepsControl){
					control = meControl.createControl(bottom, SWT.WRAP);
				}else{
					control = meControl.createControl(attributeComposite, SWT.WRAP);
				}
				GridDataFactory.fillDefaults().span(2,1).grab(true, false).align(SWT.FILL, SWT.BEGINNING).applyTo(control);
			}
		}

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
	
	private void createSpecificMEControls() {
		if(this.modelElement instanceof Issue) {
			MEControl meControl = ControlFactory.createMEIssueAssessmentMatrixControl((Issue)this.modelElement, toolkit, editingDomain);
			if (meControl != null) {
				meControls.add(meControl);
				Control control;
				control = meControl.createControl(bottom, SWT.WRAP);				
//				control.setLayoutData(new TableWrapData(TableWrapData.FILL_GRAB));
				GridDataFactory.fillDefaults().grab(true, true).align(SWT.FILL, SWT.FILL).applyTo(control);
			}
		}
		
	}

	
}