/**
 * <copyright> Copyright (c) 2008-2009 Jonas Helming, Maximilian Koegel. All rights reserved. This program and the
 * accompanying materials are made available under the terms of the Eclipse Public License v1.0 which accompanies this
 * distribution, and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>
 */
package org.unicase.ui.meeditor;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.edit.provider.AdapterFactoryItemDelegator;
import org.eclipse.emf.edit.provider.ComposedAdapterFactory;
import org.eclipse.emf.edit.provider.IItemPropertyDescriptor;
import org.eclipse.emf.edit.ui.provider.AdapterFactoryLabelProvider;
import org.eclipse.emf.validation.model.IConstraintStatus;
import org.eclipse.jface.action.Action;
import org.eclipse.jface.action.ContributionManager;
import org.eclipse.jface.layout.GridDataFactory;
import org.eclipse.jface.layout.GridLayoutFactory;
import org.eclipse.swt.SWT;
import org.eclipse.swt.SWTException;
import org.eclipse.swt.custom.SashForm;
import org.eclipse.swt.custom.StyleRange;
import org.eclipse.swt.custom.StyledText;
import org.eclipse.swt.graphics.Color;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Display;
import org.eclipse.ui.AbstractSourceProvider;
import org.eclipse.ui.ISourceProvider;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.forms.IManagedForm;
import org.eclipse.ui.forms.editor.FormPage;
import org.eclipse.ui.forms.widgets.FormToolkit;
import org.eclipse.ui.forms.widgets.ScrolledForm;
import org.eclipse.ui.menus.IMenuService;
import org.eclipse.ui.services.IEvaluationService;
import org.unicase.ui.common.ModelElementContext;
import org.unicase.ui.common.commands.DeleteModelElementCommand;
import org.unicase.ui.common.util.PreferenceHelper;
import org.unicase.ui.common.util.ShortLabelProvider;
import org.unicase.ui.common.validation.ValidationResultProviderRegistry;
import org.unicase.ui.common.validation.listeners.ValidationListener;
import org.unicase.ui.common.validation.providers.ValidationResultProvider;
import org.unicase.ui.meeditor.mecontrols.AbstractMEControl;
import org.unicase.ui.meeditor.mecontrols.FeatureHintTooltipSupport;
import org.unicase.ui.meeditor.mecontrols.METextControl;

/**
 * The editor page for the {@link MEEditor}.
 * 
 * @author helming
 * @author shterev
 * @author naughton
 */
public class MEEditorPage extends FormPage implements ValidationListener {

	/**
	 * Violation color red.
	 */
	public static final Color VIOLATION_RED = new Color(Display.getCurrent(), 255, 0, 0);

	private EObject modelElement;
	private FormToolkit toolkit;
	private List<AbstractMEControl> meControls = new ArrayList<AbstractMEControl>();

	private static String activeModelelement = "activeModelelement";
	private ScrolledForm form;
	private List<IItemPropertyDescriptor> leftColumnAttributes = new ArrayList<IItemPropertyDescriptor>();
	private List<IItemPropertyDescriptor> rightColumnAttributes = new ArrayList<IItemPropertyDescriptor>();
	private List<IItemPropertyDescriptor> bottomAttributes = new ArrayList<IItemPropertyDescriptor>();
	private Composite leftColumnComposite;
	private Composite rightColumnComposite;
	private Composite bottomComposite;
	private final ModelElementContext modelElementContext;

	/**
	 * Default constructor.
	 * 
	 * @param editor the {@link MEEditor}
	 * @param id the {@link FormPage#id}
	 * @param title the title
	 * @param modelElement the modelElement
	 * @param modelElementContext the {@link ModelElementContext}
	 */
	public MEEditorPage(MEEditor editor, String id, String title, ModelElementContext modelElementContext,
		EObject modelElement) {
		super(editor, id, title);
		this.modelElementContext = modelElementContext;
		this.modelElement = modelElement;
		labels = new HashSet<StyledText>();
		validationResultProvider = ValidationResultProviderRegistry.getInstance().getValidationResultProvider(
			modelElement);
		if (validationResultProvider != null) {
			validationResultProvider.registerListener(modelElement, this);
		}
	}

	/**
	 * Default constructor.
	 * 
	 * @param editor the {@link MEEditor}
	 * @param id the {@link FormPage#id}
	 * @param title the title
	 * @param modelElement the modelElement
	 *@param problemFeatures the problemFeature
	 *@param modelElementContext the {@link ModelElementContext}
	 */
	public MEEditorPage(MEEditor editor, String id, String title, ModelElementContext modelElementContext,
		EObject modelElement, List<EStructuralFeature> problemFeatures) {
		this(editor, id, title, modelElementContext, modelElement);
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
		Composite topComposite = toolkit.createComposite(body);
		topComposite.setLayout(new GridLayout());
		GridDataFactory.fillDefaults().align(SWT.FILL, SWT.FILL).grab(true, true).applyTo(topComposite);

		SashForm topSash = new SashForm(topComposite, SWT.HORIZONTAL);
		GridDataFactory.fillDefaults().align(SWT.FILL, SWT.FILL).grab(true, true).applyTo(topSash);
		toolkit.adapt(topSash, true, true);
		topSash.setSashWidth(4);

		leftColumnComposite = toolkit.createComposite(topSash, SWT.NONE);
		GridLayoutFactory.fillDefaults().numColumns(1).equalWidth(false).extendedMargins(2, 5, 5, 5).applyTo(
			leftColumnComposite);
		GridDataFactory.fillDefaults().align(SWT.FILL, SWT.FILL).applyTo(leftColumnComposite);

		rightColumnComposite = toolkit.createComposite(topSash, SWT.NONE);
		GridLayoutFactory.fillDefaults().numColumns(1).equalWidth(false).extendedMargins(5, 2, 5, 5).applyTo(
			rightColumnComposite);
		GridDataFactory.fillDefaults().align(SWT.FILL, SWT.FILL).applyTo(rightColumnComposite);

		int[] topWeights = { 50, 50 };
		topSash.setWeights(topWeights);

		bottomComposite = toolkit.createComposite(topComposite);
		GridLayoutFactory.fillDefaults().numColumns(1).equalWidth(false).extendedMargins(0, 0, 0, 0).applyTo(
			bottomComposite);
		GridDataFactory.fillDefaults().align(SWT.FILL, SWT.FILL).grab(true, true).applyTo(bottomComposite);
		// updateSectionTitle();
		form.setImage(new AdapterFactoryLabelProvider(new ComposedAdapterFactory(
			ComposedAdapterFactory.Descriptor.Registry.INSTANCE)).getImage(modelElement));
		// Sort and order attributes
		sortAndOrderAttributes();
		// Create attributes
		createAttributes(leftColumnComposite, leftColumnAttributes);
		createAttributes(rightColumnComposite, rightColumnAttributes);
		createAttributes(bottomComposite, bottomAttributes);
		// Create special ME Control
		// createSpecificMEControls();
		createToolbar();
		form.pack();
		updateSectionTitle();
	}

	/**
	 * Updates the name of the section.
	 */
	public void updateSectionTitle() {
		// Layout form
		ShortLabelProvider shortLabelProvider = new ShortLabelProvider();
		String name = shortLabelProvider.getText(modelElement);

		name += " [" + modelElement.eClass().getName() + "]";
		try {
			form.setText(name);
		} catch (SWTException e) {
			// Catch in case editor is closed directly after change
		}
	}

	private void createToolbar() {
		IMenuService menuService = (IMenuService) PlatformUI.getWorkbench().getService(IMenuService.class);
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

		IEvaluationService service = (IEvaluationService) PlatformUI.getWorkbench()
			.getService(IEvaluationService.class);
		service.addSourceProvider(sourceProvider);
		form.getToolBarManager().add(new Action("", Activator.getImageDescriptor("icons/delete.gif")) {

			@Override
			public void run() {
				new DeleteModelElementCommand(modelElement, modelElementContext).run();
			}
		});
		menuService.populateContributionManager((ContributionManager) form.getToolBarManager(),
			"toolbar:org.unicase.ui.meeditor.MEEditorPage");
		form.getToolBarManager().update(true);
	}

	private void sortAndOrderAttributes() {

		AdapterFactoryItemDelegator adapterFactoryItemDelegator = new AdapterFactoryItemDelegator(
			new ComposedAdapterFactory(ComposedAdapterFactory.Descriptor.Registry.INSTANCE));

		List<IItemPropertyDescriptor> propertyDescriptors = adapterFactoryItemDelegator
			.getPropertyDescriptors(modelElement);
		if (propertyDescriptors != null) {
			AnnotationPositionDescriptor positionDescriptor = new AnnotationPositionDescriptor();
			for (IItemPropertyDescriptor itemPropertyDescriptor : propertyDescriptors) {
				String value = positionDescriptor.getValue(itemPropertyDescriptor, modelElement);
				if (value.equals("left")) {
					leftColumnAttributes.add(itemPropertyDescriptor);
				} else if (value.equals("right")) {
					rightColumnAttributes.add(itemPropertyDescriptor);
				} else if (value.equals("bottom")) {
					bottomAttributes.add(itemPropertyDescriptor);
				}
			}

			final HashMap<IItemPropertyDescriptor, Double> priorityMap = new HashMap<IItemPropertyDescriptor, Double>();
			AnnotationPriorityDescriptor priorityDescriptor = new AnnotationPriorityDescriptor();
			for (IItemPropertyDescriptor itemPropertyDescriptor : propertyDescriptors) {
				priorityMap.put(itemPropertyDescriptor, priorityDescriptor.getValue(itemPropertyDescriptor,
					modelElement));
			}

			Comparator<IItemPropertyDescriptor> comparator = new Comparator<IItemPropertyDescriptor>() {
				public int compare(IItemPropertyDescriptor o1, IItemPropertyDescriptor o2) {
					return Double.compare(priorityMap.get(o1), priorityMap.get(o2));
				}
			};
			Collections.sort(leftColumnAttributes, comparator);
			Collections.sort(rightColumnAttributes, comparator);
			Collections.sort(bottomAttributes, comparator);

		}

	}

	private Set<StyledText> labels;

	private ValidationResultProvider validationResultProvider;

	private void createAttributes(Composite column, List<IItemPropertyDescriptor> attributes) {
		Composite attributeComposite = toolkit.createComposite(column);
		GridLayoutFactory.fillDefaults().numColumns(2).applyTo(attributeComposite);
		GridDataFactory.fillDefaults().grab(true, true).align(SWT.FILL, SWT.BEGINNING).indent(10, 0).applyTo(
			attributeComposite);

		ControlFactory controlFactory = new ControlFactory();
		for (IItemPropertyDescriptor itemPropertyDescriptor : attributes) {
			AbstractMEControl meControl = controlFactory.createControl(itemPropertyDescriptor, modelElement);
			if (meControl == null) {
				continue;
			}
			meControls.add(meControl);
			Control control;
			EStructuralFeature structuralFeature = (EStructuralFeature) itemPropertyDescriptor.getFeature(modelElement);
			boolean featureInvalid = false;
			if (validationResultProvider != null) {
				featureInvalid = validationResultProvider.isEStructuralFeatureInvalid(modelElement, structuralFeature);
			}
			if (meControl.getShowLabel()) {
				String text = itemPropertyDescriptor.getDisplayName(modelElement);
				StyledText styledText = new StyledText(attributeComposite, SWT.BOLD);
				styledText.setText(text);
				styledText.setData(structuralFeature);
				styledText.setStyleRange(createStyleRange(text.length(), featureInvalid));
				styledText.setEditable(false);
				labels.add(styledText);
				FeatureHintTooltipSupport.enableFor(styledText, itemPropertyDescriptor, modelElement);
				control = meControl.createControl(attributeComposite, SWT.WRAP, itemPropertyDescriptor, modelElement,
					modelElementContext, toolkit);
				GridDataFactory.fillDefaults().align(SWT.LEFT, SWT.CENTER).applyTo(styledText);
				GridDataFactory.fillDefaults().grab(true, false).align(SWT.FILL, SWT.BEGINNING).indent(10, 0).applyTo(
					control);
				meControl.applyCustomLayoutData();
			} else {
				control = meControl.createControl(attributeComposite, SWT.WRAP, itemPropertyDescriptor, modelElement,
					modelElementContext, toolkit);
				control.setData(modelElement);
				FeatureHintTooltipSupport.enableFor(control, itemPropertyDescriptor, modelElement);
				GridDataFactory.fillDefaults().span(3, 1).grab(true, true).align(SWT.FILL, SWT.BEGINNING).indent(10, 0)
					.applyTo(control);
				meControl.validate(featureInvalid);
			}
		}
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void dispose() {
		if (validationResultProvider != null) {
			validationResultProvider.unregisterListener(modelElement, this);
		}
		for (AbstractMEControl control : meControls) {
			control.dispose();
		}
		super.dispose();
	}

	/**
	 * {@inheritDoc} This method is added to solve the focus bug of navigator. Every time that a ME is opened in editor,
	 * navigator has to lose focus so that its action contributions are set correctly for next time.
	 */
	@Override
	public void setFocus() {
		super.setFocus();
		// set keyboard focus on the first Text control
		for (AbstractMEControl meControl : this.meControls) {
			if (meControl instanceof METextControl) {
				((METextControl) meControl).setFocus();
				break;
			}
		}
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.unicase.ui.common.validation.listeners.ValidationListener#objectValidated(org.eclipse.emf.validation.model.IConstraintStatus)
	 */
	public void objectValidated(EObject project, EObject target, Set<IConstraintStatus> constraintStati) {
		for (StyledText styledText : labels) {
			EStructuralFeature structuralFeature = (EStructuralFeature) styledText.getData();
			styledText.setStyleRange(createStyleRange(styledText.getText().length(), validationResultProvider
				.isEStructuralFeatureInvalid(modelElement, structuralFeature)));
		}
		for (AbstractMEControl abstractMEControl : meControls) {
			EStructuralFeature structuralFeature = (EStructuralFeature) abstractMEControl.getItemPropertyDescriptor()
				.getFeature(modelElement);
			abstractMEControl.validate(validationResultProvider.isEStructuralFeatureInvalid(modelElement,
				structuralFeature));
		}
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.unicase.ui.common.validation.listeners.ValidationListener#rootRemoved(org.eclipse.emf.ecore.EObject)
	 */
	public void rootRemoved(EObject rootElement) {
		for (StyledText styledText : labels) {
			styledText.setStyleRange(createStyleRange(styledText.getText().length(), false));
		}
		for (AbstractMEControl abstractMEControl : meControls) {
			abstractMEControl.validate(false);
		}
	}

	private StyleRange createStyleRange(int textLength, boolean isProblemFeature) {
		StyleRange styleRange = new StyleRange();
		styleRange.start = 0;
		styleRange.length = textLength;
		styleRange.fontStyle = SWT.BOLD;
		if (isProblemFeature
			&& PreferenceHelper.getPreference("org.unicase.validation.live.enabled", "true").equals("true")) {
			styleRange.foreground = VIOLATION_RED;
		} else {
			styleRange.foreground = Display.getCurrent().getSystemColor(SWT.COLOR_BLACK);
		}
		return styleRange;
	}
}