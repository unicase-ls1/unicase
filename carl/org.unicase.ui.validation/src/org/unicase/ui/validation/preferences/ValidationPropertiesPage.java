/**
 * <copyright> Copyright (c) 2008-2009 Jonas Helming, Maximilian Koegel. All rights reserved. This program and the
 * accompanying materials are made available under the terms of the Eclipse Public License v1.0 which accompanies this
 * distribution, and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>
 */

package org.unicase.ui.validation.preferences;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.StringTokenizer;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.edit.provider.ComposedAdapterFactory;
import org.eclipse.emf.edit.ui.provider.AdapterFactoryLabelProvider;
import org.eclipse.emf.validation.preferences.EMFModelValidationPreferences;
import org.eclipse.emf.validation.service.ConstraintRegistry;
import org.eclipse.emf.validation.service.IConstraintDescriptor;
import org.eclipse.jface.layout.GridDataFactory;
import org.eclipse.jface.layout.GridLayoutFactory;
import org.eclipse.jface.viewers.ArrayContentProvider;
import org.eclipse.jface.viewers.CheckStateChangedEvent;
import org.eclipse.jface.viewers.CheckboxTableViewer;
import org.eclipse.jface.viewers.ICheckStateListener;
import org.eclipse.jface.viewers.ICheckStateProvider;
import org.eclipse.jface.viewers.ISelectionChangedListener;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.viewers.LabelProvider;
import org.eclipse.jface.viewers.SelectionChangedEvent;
import org.eclipse.swt.SWT;
import org.eclipse.swt.custom.ScrolledComposite;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.graphics.Color;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.graphics.Point;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Combo;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.TabFolder;
import org.eclipse.swt.widgets.TabItem;
import org.eclipse.swt.widgets.Text;
import org.eclipse.ui.dialogs.PropertyPage;
import org.unicase.ui.common.util.PreferenceHelper;
import org.unicase.ui.common.validation.ValidationResultProviderRegistry;
import org.unicase.ui.common.validation.preferences.ValidationPreferenceConstants;
import org.unicase.ui.common.validation.providers.ValidationResultProvider;
import org.unicase.ui.validation.Activator;
import org.unicase.ui.validation.constraints.ConstraintHelper;

/**
 * A property page for the dashboard.
 * 
 * @author Shterev
 */
public class ValidationPropertiesPage extends PropertyPage {

	private Color blue;

	private List<EStructuralFeature> currentOrderedStructuralFeatures;

	private Composite configureRulesComposite;

	private Composite root;

	private Map<String, EClass> map;

	private Combo combo;

	private ScrolledComposite scrolledComposite;

	private EClass currentEClass;;

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.jface.preference.PreferencePage#doComputeSize()
	 */
	@Override
	protected Point doComputeSize() {
		return new Point(540, 650);
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.jface.preference.PreferencePage#performOk()
	 */
	@Override
	public boolean performOk() {
		ValidationResultProviderRegistry.getInstance().reinitAll();
		return true;
	}

	/**
	 * The model element label provider.
	 */
	@SuppressWarnings("unused")
	private AdapterFactoryLabelProvider labelProvider;

	private Set<String> constraintsSet;

	private String constraintIDs;

	private Combo constraintsCombo;

	private Text cData;

	private Text classText;

	private Text message;

	private Text id;

	private Combo severityCombo;

	/**
	 * {@inheritDoc}
	 */
	@Override
	protected Control createContents(Composite parent) {

		GridLayoutFactory.fillDefaults().applyTo(parent);
		noDefaultAndApplyButton();

		labelProvider = new AdapterFactoryLabelProvider(new ComposedAdapterFactory(
			ComposedAdapterFactory.Descriptor.Registry.INSTANCE));

		TabFolder folder = new TabFolder(parent, SWT.TOP);

		TabItem generalValidation = new TabItem(folder, SWT.NONE);
		generalValidation.setControl(createGeneralValidationControl(folder));
		generalValidation.setText("General validation");

		TabItem constraints = new TabItem(folder, SWT.NONE);
		constraints.setControl(createConstraintControl(folder));
		constraints.setText("Constraints");

		TabItem dynamicValidation = new TabItem(folder, SWT.NONE);
		dynamicValidation.setControl(createDynamicConstraintControl(folder));
		dynamicValidation.setText("Dynamic field constraints");

		TabItem dynamicOCLValidation = new TabItem(folder, SWT.NONE);
		dynamicOCLValidation.setControl(createOCLConstraintControl(folder));
		dynamicOCLValidation.setText("Dynamic OCL constraints");

		return folder;
	}

	/**
	 * Creates the live validation folder control.
	 * 
	 * @param folder the
	 * @return the control
	 */
	private Control createGeneralValidationControl(TabFolder folder) {
		final Composite root = new Composite(folder, SWT.NONE);
		GridLayoutFactory.fillDefaults().margins(5, 5).applyTo(root);

		// ENTRY
		Composite activeValidationComposite = new Composite(root, SWT.NONE);
		GridLayoutFactory.fillDefaults().numColumns(1).applyTo(activeValidationComposite);
		// EXPLANATION
		createExplanationLabel(activeValidationComposite,
			"Activate or deactivate the validation in general. It might be beneficial to turn off the validation in case "
				+ "of problems with the validation or extreme performance hits.");
		// SELECTION
		Composite activeValidationSelectionComposite = new Composite(activeValidationComposite, SWT.NONE);
		GridLayoutFactory.fillDefaults().numColumns(2).applyTo(activeValidationSelectionComposite);
		final Button activeValidationButton = new Button(activeValidationSelectionComposite, SWT.CHECK);
		activeValidationButton.setSelection(PreferenceHelper.getPreference(
			ValidationPreferenceConstants.VALIDATION_ENABLED, "true").equals("true"));
		activeValidationButton.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				PreferenceHelper.setPreference(ValidationPreferenceConstants.VALIDATION_ENABLED, Boolean
					.toString(activeValidationButton.getSelection()));
			}
		});
		new Label(activeValidationSelectionComposite, SWT.NONE).setText("Validation active");
		// ENTRY
		Composite activeLiveValidationComposite = new Composite(root, SWT.NONE);
		GridLayoutFactory.fillDefaults().numColumns(1).applyTo(activeLiveValidationComposite);
		// EXPLANATION
		createExplanationLabel(activeLiveValidationComposite,
			"Activate or deactivate the live validation, which decorates elements in the navigator with a "
				+ "small icon and in the editor with a red label that shows if the element has violations or not.");
		// SELECTION
		Composite activeLiveValidationSelectionComposite = new Composite(activeLiveValidationComposite, SWT.NONE);
		GridLayoutFactory.fillDefaults().numColumns(2).applyTo(activeLiveValidationSelectionComposite);
		final Button activeLiveValidationButton = new Button(activeLiveValidationSelectionComposite, SWT.CHECK);
		activeLiveValidationButton.setSelection(PreferenceHelper.getPreference(
			ValidationPreferenceConstants.LIVE_VALIDATION_ENABLED, "true").equals("true"));
		activeLiveValidationButton.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				PreferenceHelper.setPreference(ValidationPreferenceConstants.LIVE_VALIDATION_ENABLED, new Boolean(
					activeLiveValidationButton.getSelection()).toString());
			}
		});
		new Label(activeLiveValidationSelectionComposite, SWT.NONE).setText("Live validation active");

		// ENTRY
		Composite batchOrFlatValidationComposite = new Composite(root, SWT.NONE);
		GridLayoutFactory.fillDefaults().numColumns(1).applyTo(batchOrFlatValidationComposite);
		// EXPLANATION
		createExplanationLabel(batchOrFlatValidationComposite,
			"The validate command of the navigator context menu can either show only the violations "
				+ "for the element selected, or also for all the contained elements. Please choose a preference.");
		// SELECTION
		Composite batchOrFlatValidationSelectionComposite = new Composite(batchOrFlatValidationComposite, SWT.NONE);
		GridLayoutFactory.fillDefaults().numColumns(1).applyTo(batchOrFlatValidationSelectionComposite);
		final Combo batchOrFlatValidationCombo = new Combo(batchOrFlatValidationSelectionComposite, SWT.READ_ONLY
			| SWT.DROP_DOWN);
		batchOrFlatValidationCombo.setItems(new String[] { "FLAT", "RECURSIVE" });
		boolean flatOrRecursive = PreferenceHelper.getPreference(ValidationPreferenceConstants.VALIDATION_VIEW_FLAT,
			"false").equals("false");
		batchOrFlatValidationCombo.select(flatOrRecursive ? 1 : 0);
		batchOrFlatValidationCombo.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				PreferenceHelper.setPreference(ValidationPreferenceConstants.VALIDATION_VIEW_FLAT, new Boolean(
					batchOrFlatValidationCombo.getSelectionIndex() == 0).toString());
			}
		});

		return root;
	}

	/**
	 * Creates the validation constraints folder control.
	 * 
	 * @param folder the
	 * @return the control
	 */
	private Control createConstraintControl(TabFolder folder) {
		final Composite root = new Composite(folder, SWT.NONE);
		GridLayoutFactory.fillDefaults().margins(5, 5).applyTo(root);

		// ENTRY
		Composite activeValidationComposite = new Composite(root, SWT.NONE);
		GridLayoutFactory.fillDefaults().numColumns(1).applyTo(activeValidationComposite);
		// EXPLANATION
		createExplanationLabel(activeValidationComposite,
			"The validation framework uses constraints to evaluate the state of model elements. "
				+ "You may enable and disable constraints as you wish. Beware that the disabled constraints "
				+ "will not be used in batch and live validation runs.");
		// SELECTION
		Composite activeValidationSelectionComposite = new Composite(activeValidationComposite, SWT.NONE);
		GridLayoutFactory.fillDefaults().numColumns(1).applyTo(activeValidationSelectionComposite);
		createConstraintsTable(activeValidationSelectionComposite);

		return root;
	}

	private void createConstraintsTable(final Composite root) {
		final CheckboxTableViewer constraintsTable = CheckboxTableViewer.newCheckList(root, SWT.RESIZE | SWT.SINGLE
			| SWT.V_SCROLL | SWT.H_SCROLL | SWT.BORDER);
		GridDataFactory.fillDefaults().hint(500, 500).applyTo(constraintsTable.getControl());
		ArrayList<IConstraintDescriptor> constraintDescriptors = new ArrayList<IConstraintDescriptor>(
			ConstraintRegistry.getInstance().getAllDescriptors());
		Collections.sort(constraintDescriptors, new Comparator<IConstraintDescriptor>() {

			public int compare(IConstraintDescriptor o1, IConstraintDescriptor o2) {
				return o1.getName().compareTo(o2.getName());
			}
		});
		constraintsTable.setContentProvider(new ArrayContentProvider());
		constraintsTable.setLabelProvider(new LabelProvider() {

			@Override
			public String getText(Object element) {
				return ((IConstraintDescriptor) element).getName();
			}

			@Override
			public Image getImage(Object element) {
				IConstraintDescriptor constraintDescriptor = (IConstraintDescriptor) element;
				int status = constraintDescriptor.getSeverity().toIStatusSeverity();
				Image image = ConstraintHelper.getInstance().getImageForSeverity(status);
				if (image != null) {
					return image;
				}
				return super.getImage(element);
			}
		});
		constraintsTable.setInput(constraintDescriptors);
		constraintsTable.setCheckStateProvider(new ICheckStateProvider() {

			public boolean isGrayed(Object element) {
				return false;
			}

			public boolean isChecked(Object element) {
				IConstraintDescriptor constraintDescriptor = (IConstraintDescriptor) element;
				return Boolean.parseBoolean(PreferenceHelper.getPreference(
					ValidationPreferenceConstants.VALIDATION_CONSTRAINT_PREFIX + constraintDescriptor.getId()
						+ ".enabled", "true"));
			}
		});

		constraintsTable.addCheckStateListener(new ICheckStateListener() {

			public void checkStateChanged(CheckStateChangedEvent event) {
				IConstraintDescriptor constraintDescriptor = (IConstraintDescriptor) event.getElement();
				PreferenceHelper.setPreference(ValidationPreferenceConstants.VALIDATION_CONSTRAINT_PREFIX
					+ constraintDescriptor.getId() + ".enabled", Boolean.toString(event.getChecked()));
				EMFModelValidationPreferences.setConstraintDisabled(constraintDescriptor.getId(), !event.getChecked());
			}
		});

		final Label hint = createExplanationLabel(root, "Hint: Select an item to view its description");
		GridDataFactory.fillDefaults().hint(500, 30).applyTo(hint);

		constraintsTable.addSelectionChangedListener(new ISelectionChangedListener() {

			public void selectionChanged(SelectionChangedEvent event) {
				Object object = ((IStructuredSelection) event.getSelection()).getFirstElement();
				if (object instanceof IConstraintDescriptor) {
					IConstraintDescriptor constraintDescriptor = (IConstraintDescriptor) object;
					String description = constraintDescriptor.getDescription();
					if (description == null) {
						description = "This constraint has no description.";
					}
					hint.setText(description);
					root.layout();
				} else {
					hint.setText("Hint: Select an item to view its description.");
					root.layout();
				}
			}
		});
	}

	/**
	 * Creates the batch validation folder control.
	 * 
	 * @param folder the {@link TabFolder}
	 * @return the resulting {@link Control}
	 */
	private Control createDynamicConstraintControl(TabFolder folder) {
		// the parent composite
		final Composite root = new Composite(folder, SWT.NONE);
		this.root = root;
		GridLayoutFactory.fillDefaults().margins(5, 5).applyTo(root);

		// create hint
		createExplanationLabel(root,
			"The dynamic field rules allow specifying which fields, also called features, of a model element should be set, "
				+ "and which may not be set.");

		// The composite for choosing among the model EClasses
		Composite chooseEClassComposite = new Composite(root, SWT.NONE);
		GridDataFactory.fillDefaults().hint(500, SWT.DEFAULT).applyTo(chooseEClassComposite);
		chooseEClassComposite.setLayout(new GridLayout(3, false));
		//
		new Label(chooseEClassComposite, SWT.NONE).setImage(Activator.getImageDescriptor("icons/arrow_right.png")
			.createImage());
		// text for choose EClass
		new Label(chooseEClassComposite, SWT.SINGLE).setText("Please choose a model element:");
		// Create combo list for all EClasses
		this.combo = createComboForAllEClasses(chooseEClassComposite);
		scrolledComposite = new ScrolledComposite(root, SWT.BORDER | SWT.V_SCROLL);
		GridDataFactory.fillDefaults().hint(500, 500).applyTo(scrolledComposite);
		scrolledComposite.setLayout(new GridLayout(1, true));
		// set scrolled composite properties
		scrolledComposite.setExpandHorizontal(true);
		scrolledComposite.setExpandVertical(true);
		scrolledComposite.setAlwaysShowScrollBars(true);
		createFeatureConfigComposite();
		return root;
	}

	private void createFeatureConfigComposite() {
		configureRulesComposite = new Composite(scrolledComposite, SWT.NONE);
		configureRulesComposite.setLayout(new GridLayout(1, false));
		GridDataFactory.fillDefaults().grab(true, false).applyTo(configureRulesComposite);
		// add the rule configuration elements to the composite
		getAllFeatures();
		int i = 0;
		blue = new Color(getShell().getDisplay(), 216, 216, 249);
		if (currentOrderedStructuralFeatures != null && !currentOrderedStructuralFeatures.isEmpty()) {
			for (final EStructuralFeature structuralFeature : currentOrderedStructuralFeatures) {
				Composite configureRuleComposite = new Composite(configureRulesComposite, SWT.NONE);
				configureRuleComposite.setLayout(new GridLayout(3, false));
				Color color = null;
				if (i++ % 2 != 0) {
					color = blue;
					configureRuleComposite.setBackground(color);
				}
				createIconLabel(configureRuleComposite, structuralFeature, color);
				createLabel(configureRuleComposite, structuralFeature, color);
				// createReasonTextField(configureRulesComposite);
				final Combo combo = createSeverityChoiceCombo(configureRuleComposite, structuralFeature, color);
				String className = currentEClass.getInstanceTypeName();
				String feature = structuralFeature.getName();
				String key = (className + "." + feature).toLowerCase();
				String selection = PreferenceHelper.getPreference(key, "IGNORE");
				if (selection.equalsIgnoreCase("IGNORE")) {
					combo.select(0);
				} else if (selection.equalsIgnoreCase("INFO")) {
					combo.select(1);
				} else if (selection.equalsIgnoreCase("WARNING")) {
					combo.select(2);
				} else if (selection.equalsIgnoreCase("ERROR")) {
					combo.select(3);
				}
				combo.addSelectionListener(new SelectionAdapter() {

					/**
					 * {@inheritDoc}
					 * 
					 * @see org.eclipse.swt.events.SelectionAdapter#widgetSelected(org.eclipse.swt.events.SelectionEvent)
					 */
					@Override
					public void widgetSelected(SelectionEvent e) {
						String className = currentEClass.getInstanceTypeName();
						String feature = structuralFeature.getName();
						String key = (className + "." + feature).toLowerCase();
						String selection = combo.getItem(combo.getSelectionIndex());
						PreferenceHelper.setPreference(key, selection.toLowerCase());
					}

				});
				GridDataFactory.fillDefaults().grab(true, false).applyTo(configureRuleComposite);
			}
		}
		scrolledComposite.setMinSize(configureRulesComposite.computeSize(SWT.DEFAULT, SWT.DEFAULT));
		scrolledComposite.setContent(configureRulesComposite);
		// set scrolled composite content
		scrolledComposite.layout();
		configureRulesComposite.layout();
		root.layout();
	}

	private Label createIconLabel(Composite parent, EStructuralFeature feature, Color backgroundColor) {
		Image image = null;
		if (feature instanceof EReference) {
			image = Activator.getImageDescriptor("icons/link.png").createImage();
		} else {
			image = Activator.getImageDescriptor("icons/textfield.png").createImage();
		}
		Label label = new Label(parent, SWT.NONE);
		label.setImage(image);
		if (backgroundColor != null) {
			label.setBackground(backgroundColor);
		}
		return label;
	}

	private Text createLabel(Composite parent, EStructuralFeature feature, Color backgroundColor) {
		Text text = new Text(parent, SWT.NONE);
		text.setText(feature.getName());
		text.setBackground(backgroundColor);
		return text;
	}

	private Combo createSeverityChoiceCombo(Composite parent, EStructuralFeature structuralFeature,
		Color backgroundColor) {
		Combo combo;
		combo = new Combo(parent, SWT.DROP_DOWN | SWT.READ_ONLY);
		combo.setLayout(new GridLayout());
		combo.setLayoutData(new GridData(SWT.END, SWT.TOP, true, true));
		combo.setItems(new String[] { "IGNORE", "INFO", "WARNING", "ERROR" });
		combo.select(0);
		// combo.setBackground(backgroundColor);
		return combo;
	}

	private void getAllFeatures() {
		if (currentOrderedStructuralFeatures == null) {
			currentOrderedStructuralFeatures = new ArrayList<EStructuralFeature>();
		} else {
			currentOrderedStructuralFeatures.clear();
		}
		currentEClass = map.get(combo.getItem(combo.getSelectionIndex()));
		if (currentEClass == null) {
			return;
		}
		EList<EStructuralFeature> structuralFeatures = currentEClass.getEAllStructuralFeatures();
		for (EStructuralFeature feature : structuralFeatures) {
			currentOrderedStructuralFeatures.add(feature);
		}
		Collections.sort(currentOrderedStructuralFeatures, new Comparator<EStructuralFeature>() {
			public int compare(EStructuralFeature o1, EStructuralFeature o2) {
				return o1.getName().compareTo(o2.getName());
			}
		});
	}

	/**
	 * Creates a {@link Combo} for the features of the model elements.
	 * 
	 * @param features the composite to put the {@link Combo} on
	 * @return the {@link Combo}
	 */
	private Combo createComboForAllEClasses(Composite features) {
		Combo combo = new Combo(features, SWT.DROP_DOWN | SWT.READ_ONLY);
		Set<EClass> allModelElementEClasses = ValidationResultProvider.getAllModelElementEClasses();
		map = new HashMap<String, EClass>();
		String[] modelElementNames = new String[allModelElementEClasses.size()];
		int i = 0;
		for (EClass eClass : allModelElementEClasses) {
			modelElementNames[i++] = eClass.getName();
			map.put(eClass.getName(), eClass);
		}
		Arrays.sort(modelElementNames);
		combo.setItems(modelElementNames);
		combo.select(0);
		combo.addSelectionListener(new SelectionAdapter() {

			/**
			 * {@inheritDoc}
			 * 
			 * @see org.eclipse.swt.events.SelectionAdapter#widgetSelected(org.eclipse.swt.events.SelectionEvent)
			 */
			@Override
			public void widgetSelected(SelectionEvent e) {
				createFeatureConfigComposite();
			}

		});
		return combo;
	}

	/**
	 * Creates the batch validation folder control.
	 * 
	 * @param folder the {@link TabFolder}
	 * @return the resulting {@link Control}
	 */
	private Control createOCLConstraintControl(TabFolder folder) {
		// the parent composite
		final Composite root = new Composite(folder, SWT.NONE);
		GridLayoutFactory.fillDefaults().margins(5, 5).applyTo(root);

		// list of OCL constraints
		createExplanationLabel(root, "Please choose among the already existing constraints (or create a new one):");
		constraintsCombo = new Combo(root, SWT.READ_ONLY | SWT.DROP_DOWN);
		GridDataFactory.fillDefaults().grab(true, false).applyTo(constraintsCombo);
		setConstraints();

		// define the OCL constraint
		Composite dynamicOCLComposite = new Composite(root, SWT.NONE);
		GridDataFactory.fillDefaults().hint(500, 520).applyTo(dynamicOCLComposite);
		GridLayoutFactory.fillDefaults().numColumns(1).applyTo(dynamicOCLComposite);

		createExplanationLabel(dynamicOCLComposite,
			"The Object Constraint Language (OCL) makes it possible to define constraints "
				+ "based on XML. If you wish to enter your own OCL constraints, please do so below.");

		// start tag of constraint XML
		Label startTag = new Label(dynamicOCLComposite, SWT.NONE);
		startTag.setText("<constraint");

		// attributes of start tag
		Composite tagAttributes = new Composite(dynamicOCLComposite, SWT.NONE);
		GridLayoutFactory.fillDefaults().margins(10, 0).numColumns(2).applyTo(tagAttributes);
		GridDataFactory.fillDefaults().grab(true, true).applyTo(tagAttributes);

		// lang definition
		Label lang = new Label(tagAttributes, SWT.NONE);
		lang.setText("lang=");
		Label langText = new Label(tagAttributes, SWT.NONE);
		langText.setText("\"OCL\"");

		// severity definition
		Label severityLine = new Label(tagAttributes, SWT.NONE);
		severityLine.setText("severity=");
		severityCombo = new Combo(tagAttributes, SWT.DROP_DOWN | SWT.READ_ONLY);
		severityCombo.setItems(new String[] { "INFO", "WARNING", "ERROR" });

		// mode definition
		Label modeLine = new Label(tagAttributes, SWT.NONE);
		modeLine.setText("mode=");
		Label modeLineText = new Label(tagAttributes, SWT.NONE);
		modeLineText.setText("\"BATCH\"");

		// id definition
		Label idLine = new Label(tagAttributes, SWT.NONE);
		idLine.setText("id=");
		Composite iDComposite = new Composite(tagAttributes, SWT.NONE);
		GridDataFactory.fillDefaults().grab(true, false).applyTo(iDComposite);
		GridLayoutFactory.fillDefaults().numColumns(2).margins(0, 0).applyTo(iDComposite);
		new Label(iDComposite, SWT.NONE).setText("org.unicase.validation.");
		id = new Text(iDComposite, SWT.SINGLE | SWT.BORDER);
		id.setLayoutData(new GridData(SWT.FILL, SWT.TOP, true, false));

		// message tag
		Label messageStart = new Label(tagAttributes, SWT.NONE);
		GridDataFactory.fillDefaults().span(2, 1).applyTo(messageStart);
		messageStart.setText("<message>");
		Composite messageTag = new Composite(tagAttributes, SWT.NONE);
		GridDataFactory.fillDefaults().span(2, 1).grab(true, true).applyTo(messageTag);
		GridLayoutFactory.fillDefaults().numColumns(2).applyTo(messageTag);
		new Label(messageTag, SWT.NONE);
		message = new Text(messageTag, SWT.MULTI | SWT.BORDER | SWT.V_SCROLL);
		GridDataFactory.fillDefaults().grab(true, true).applyTo(message);
		Label messageEnd = new Label(tagAttributes, SWT.NONE);
		GridDataFactory.fillDefaults().span(2, 1).applyTo(messageEnd);
		messageEnd.setText("</message>");

		// target tag
		Label targetStart = new Label(tagAttributes, SWT.NONE);
		GridDataFactory.fillDefaults().span(2, 1).applyTo(targetStart);
		targetStart.setText("<target");
		Composite targetTag = new Composite(tagAttributes, SWT.NONE);
		GridDataFactory.fillDefaults().span(2, 1).grab(true, false).applyTo(targetTag);
		GridLayoutFactory.fillDefaults().numColumns(3).applyTo(targetTag);
		new Label(targetTag, SWT.NONE);
		Label classLine = new Label(targetTag, SWT.NONE);
		classLine.setText("class=");
		classText = new Text(targetTag, SWT.SINGLE | SWT.BORDER);
		GridDataFactory.fillDefaults().grab(true, false).applyTo(classText);
		Label targetEnd = new Label(tagAttributes, SWT.NONE);
		GridDataFactory.fillDefaults().span(2, 1).applyTo(targetEnd);
		targetEnd.setText(">");

		// cData tag
		Label cDataStart = new Label(tagAttributes, SWT.NONE);
		GridDataFactory.fillDefaults().span(2, 1).applyTo(cDataStart);
		cDataStart.setText("<![CDATA[");
		Composite cDataTag = new Composite(tagAttributes, SWT.NONE);
		GridDataFactory.fillDefaults().grab(true, true).span(2, 1).applyTo(cDataTag);
		GridLayoutFactory.fillDefaults().numColumns(2).applyTo(cDataTag);
		new Label(cDataTag, SWT.NONE);
		cData = new Text(cDataTag, SWT.MULTI | SWT.BORDER);
		GridDataFactory.fillDefaults().grab(true, true).applyTo(cData);
		Label cDataEnd = new Label(tagAttributes, SWT.NONE);
		GridDataFactory.fillDefaults().span(2, 1).applyTo(cDataEnd);
		cDataEnd.setText("]]>");

		// end tag of constraint
		Label lastLine = new Label(dynamicOCLComposite, SWT.NONE);
		lastLine.setText(">");
		lastLine.setLayoutData(new GridData(SWT.FILL, SWT.TOP, true, false));

		modifyButtons(root);
		setDefaults();

		return root;
	}

	private void modifyButtons(final Composite root) {
		// add and remove button
		Composite editConstraint = new Composite(root, SWT.NONE);
		GridLayoutFactory.fillDefaults().numColumns(3).applyTo(editConstraint);
		Button add = new Button(editConstraint, SWT.NONE);
		add.setText("Delete this constraint");
		add.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				updateConstraintIDs(constraintsSet);
			}

			private void updateConstraintIDs(Set<String> constraintsSet) {
				if (constraintsSet == null) {
					setConstraints();
				}
				constraintsSet.remove(ValidationPreferenceConstants.VALIDATION_OCL_CONSTRAINT_PREFIX + id.getText());
				constraintsSet.clear();
				StringBuilder stringBuilder = new StringBuilder();
				for (String constraintID : constraintsSet) {
					stringBuilder.append(constraintID);
					stringBuilder.append(",");
				}
				PreferenceHelper.setPreference(ValidationPreferenceConstants.VALIDATION_OCL_CONSTRAINT_IDS,
					stringBuilder.toString());
				setConstraints();
			}
		});
		Button delete = new Button(editConstraint, SWT.NONE);
		delete.setText("Add this constraint");
		delete.addSelectionListener(new AddConstraintAdapter(id, classText, severityCombo, message, cData));
		Button defaults = new Button(editConstraint, SWT.NONE);
		defaults.setText("Set default values");
		defaults.addSelectionListener(new SelectionAdapter() {

			@Override
			public void widgetSelected(SelectionEvent e) {
				setDefaults();
			}
		});
		// add selection adapter
		constraintsCombo.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				String item = constraintsCombo.getItem(constraintsCombo.getSelectionIndex());
				String constraint = extractConstraint(item).replaceAll("\n", "").replaceAll("\r", "");
				if (!constraint.equals("")) {
					String severity = constraint.replaceFirst(".*severity=\"", "").replaceFirst("\".*", "");
					if (severity.equals("INFO")) {
						severityCombo.select(0);
					}
					if (severity.equals("WARNING")) {
						severityCombo.select(1);
					}
					if (severity.equals("ERROR")) {
						severityCombo.select(2);
					}
					message.setText(constraint.replaceFirst(".*<message>", "").replaceFirst("</message>.*", ""));
					classText.setText(constraint.replaceFirst(".*class=\"", "").replaceFirst("\">.*", ""));
					id.setText(item.replace("org.unicase.validation.constraint.ocl.", ""));
				}
			}
		});
	}

	private void setDefaults() {
		message
			.setText("{0} is used to reference the target, so a description might be:\n" + "\"{0} has no assignee\"");
		cData.setText("Enter constraint code (OCL) here");
		classText.setText("Please enter the target class simple name, such as \"Writer\"");
		id.setText("yourOCLConstraint");
		severityCombo.select(0);
	}

	private String extractConstraint(String key) {
		String constraint = PreferenceHelper.getPreference(key, "");
		return constraint;
	}

	private Set<String> setConstraints() {
		constraintIDs = PreferenceHelper.getPreference(ValidationPreferenceConstants.VALIDATION_OCL_CONSTRAINT_IDS, "");
		StringTokenizer stringTokenizer = new StringTokenizer(constraintIDs, ",");
		constraintsSet = new HashSet<String>();
		if (stringTokenizer.countTokens() > 0) {
			String[] constraints = new String[stringTokenizer.countTokens()];
			int i = 0;
			while (stringTokenizer.hasMoreElements()) {
				String nextToken = stringTokenizer.nextToken();
				constraints[i++] = nextToken;
				constraintsSet.add(nextToken);
			}
			constraintsCombo.setItems(constraints);
		}
		return constraintsSet;
	}

	/**
	 * @author pfeifferc
	 */
	private final class AddConstraintAdapter extends SelectionAdapter {

		private final Text id;
		private final Text classText;
		private final Combo severityCombo;
		private final Text message;
		private final Text cData;
		private StringBuilder stringBuilder;
		private String ocl;

		private AddConstraintAdapter(Text id, Text classText, Combo severityCombo, Text message, Text cData) {
			this.id = id;
			this.classText = classText;
			this.severityCombo = severityCombo;
			this.message = message;
			this.cData = cData;
		}

		@Override
		public void widgetSelected(SelectionEvent e) {
			stringBuilder = new StringBuilder();
			stringBuilder.append("<constraint ");
			stringBuilder.append("lang=\"OCL\" ");
			stringBuilder.append("severity=\"");
			stringBuilder.append(severityCombo.getItem(severityCombo.getSelectionIndex()));
			stringBuilder.append("\" ");
			stringBuilder.append("mode=\"BATCH\" ");
			stringBuilder.append("id=\"");
			stringBuilder.append("org.unicase.validation.constraint.ocl.");
			stringBuilder.append(id.getText().replace(",", "."));
			stringBuilder.append("\" ");
			stringBuilder.append("statusCode=\"1\">\n");
			stringBuilder.append("<message>");
			stringBuilder.append(message.getText());
			stringBuilder.append("</message>");
			stringBuilder.append("<target ");
			stringBuilder.append("class=\"");
			stringBuilder.append(classText.getText());
			stringBuilder.append("\">");
			stringBuilder.append("<![CDATA[");
			stringBuilder.append(cData.getText());
			stringBuilder.append("]]>");
			stringBuilder.append(">");
			ocl = stringBuilder.toString();
			if (!constraintsSet.contains("org.unicase.validation.constraint.ocl." + id.getText())) {
				updateConstraintIDs();
			}
			updateConstraint();
			setConstraints();
		}

		private void updateConstraint() {
			String constraintId = ValidationPreferenceConstants.VALIDATION_OCL_CONSTRAINT_PREFIX + id.getText();
			PreferenceHelper.setPreference(constraintId, ocl);
		}

		private void updateConstraintIDs() {
			PreferenceHelper.setPreference(ValidationPreferenceConstants.VALIDATION_OCL_CONSTRAINT_IDS, constraintIDs
				+ "," + ValidationPreferenceConstants.VALIDATION_OCL_CONSTRAINT_PREFIX + id.getText());
		}
	}

	// HELPER METHODS

	private Label createExplanationLabel(Composite activeValidationComposite, String text) {
		Label constraintsExplanationLabel = new Label(activeValidationComposite, SWT.WRAP);
		GridDataFactory.fillDefaults().hint(500, SWT.DEFAULT).applyTo(constraintsExplanationLabel);
		constraintsExplanationLabel.setText(text);
		return constraintsExplanationLabel;
	}
}
