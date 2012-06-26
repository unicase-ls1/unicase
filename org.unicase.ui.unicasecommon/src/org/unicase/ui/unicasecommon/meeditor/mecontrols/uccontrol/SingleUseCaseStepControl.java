/**
 * <copyright> Copyright (c) 2009-2012 Chair of Applied Software Engineering, Technische Universität München (TUM).
 * All rights reserved. This program and the accompanying materials are made available under the terms of
 * the Eclipse Public License v1.0 which accompanies this distribution,
 * and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>
 */
package org.unicase.ui.unicasecommon.meeditor.mecontrols.uccontrol;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.impl.AdapterImpl;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecp.editor.ControlFactory;
import org.eclipse.emf.ecp.editor.mecontrols.AbstractMEControl;
import org.eclipse.emf.ecp.editor.mecontrols.melinkcontrol.MEHyperLinkDeleteAdapter;
import org.eclipse.emf.edit.domain.EditingDomain;
import org.eclipse.emf.edit.provider.AdapterFactoryItemDelegator;
import org.eclipse.emf.edit.provider.ComposedAdapterFactory;
import org.eclipse.emf.edit.provider.IItemPropertyDescriptor;
import org.eclipse.emf.emfstore.client.model.util.EMFStoreCommand;
import org.eclipse.emf.emfstore.common.model.Project;
import org.eclipse.emf.emfstore.common.model.util.ModelUtil;
import org.eclipse.jface.layout.GridDataFactory;
import org.eclipse.swt.SWT;
import org.eclipse.swt.graphics.Color;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Label;
import org.eclipse.ui.ISharedImages;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.forms.events.HyperlinkEvent;
import org.eclipse.ui.forms.events.IHyperlinkListener;
import org.eclipse.ui.forms.widgets.FormToolkit;
import org.eclipse.ui.forms.widgets.Hyperlink;
import org.eclipse.ui.forms.widgets.ImageHyperlink;
import org.unicase.model.requirement.RequirementFactory;
import org.unicase.model.requirement.RequirementPackage;
import org.unicase.model.requirement.Step;
import org.unicase.model.requirement.UseCase;
import org.unicase.model.requirement.impl.RequirementFactoryImpl;
import org.unicase.ui.unicasecommon.common.util.UnicaseActionHelper;
import org.unicase.ui.unicasecommon.meeditor.mecontrols.AbstractUnicaseMEControl;

/**
 * class creates and controls a widget to display one single use case step.
 * 
 * @author lars
 */
public class SingleUseCaseStepControl extends AbstractUnicaseMEControl {

	private EReference reference;
	private Composite parentComposite;
	private int parentStyle;
	private AdapterImpl eAdapter;

	private AdapterFactoryItemDelegator adapterFactoryItemDelegator;

	private EObject contextModelElement;

	private Color backGroundColor;

	private Composite mainComposite;

	private Composite buttonComposite;
	private Composite includeComposite;
	private Composite textComposite;

	private AbstractMEControl textControlName;
	private AbstractMEControl textControlDescription;
	private Control cName;
	private Control cDescription;

	private Label includeTextLabel;
	private AbstractMEControl includeLinkControl;
	private Control cIncludeLink;

	/**
	 * Public constructor.
	 * 
	 * @param editingDomain the current editing Domain
	 * @param modelElement current ModelElement that is displayed
	 * @param toolkit used toolkit
	 * @param contextModelElement the
	 * @param reference a specific reference
	 */
	public SingleUseCaseStepControl(EditingDomain editingDomain, EObject modelElement, FormToolkit toolkit,
		EObject contextModelElement, final EReference reference) {

		this.reference = reference;
		this.contextModelElement = contextModelElement;
		eAdapter = new AdapterImpl() {
			@Override
			public void notifyChanged(Notification msg) {
				if (msg.getFeature() != null
					&& (msg.getFeatureID(Step.class) == RequirementPackage.STEP__INCLUDED_USE_CASE || msg
						.getFeatureID(Step.class) == RequirementPackage.STEP__INCLUDED_SYSTEM_FUNCTION)) {
					// buildStep();
					reLayout();
				}
				super.notifyChanged(msg);
			}
		};

		adapterFactoryItemDelegator = new AdapterFactoryItemDelegator(new ComposedAdapterFactory(
			ComposedAdapterFactory.Descriptor.Registry.INSTANCE));

		modelElement.eAdapters().add(eAdapter);

	}

	/**
	 * Method creates the specific widget and the containing elements.
	 * 
	 * @param parent surrounding widget or container
	 * @param style represents the style that should be used
	 * @return the control representing an single use case step
	 */
	@Override
	public Control createControl(Composite parent, int style) {
		parentStyle = style;
		parentComposite = parent;

		if (((Step) getModelElement()).isUserStep()) {
			backGroundColor = parent.getDisplay().getSystemColor(SWT.COLOR_INFO_BACKGROUND);
		} else {
			backGroundColor = parent.getDisplay().getSystemColor(SWT.COLOR_GRAY);
		}

		mainComposite = getToolkit().createComposite(parent);
		mainComposite.setLayout(new GridLayout(1, true));
		GridDataFactory.fillDefaults().align(SWT.FILL, SWT.BEGINNING).grab(true, false).applyTo(mainComposite);
		mainComposite.setBackground(backGroundColor);

		buttonComposite = getToolkit().createComposite(mainComposite);
		buttonComposite.setLayout(new GridLayout(3, true));
		GridDataFactory.fillDefaults().align(SWT.FILL, SWT.BEGINNING).grab(true, false).applyTo(buttonComposite);
		buttonComposite.setBackground(backGroundColor);

		buildButtons();

		textComposite = getToolkit().createComposite(mainComposite);
		textComposite.setLayout(new GridLayout(1, true));
		GridDataFactory.fillDefaults().align(SWT.FILL, SWT.BEGINNING).grab(true, false).applyTo(textComposite);
		textComposite.setBackground(backGroundColor);

		includeComposite = getToolkit().createComposite(mainComposite);
		includeComposite.setLayout(new GridLayout(2, false));
		includeComposite.setBackground(backGroundColor);

		buildStep();
		parentComposite.layout();

		return mainComposite;
	}

	private void reLayout() {
		parentComposite.layout();
	}

	private void buildStep() {

		buildTextFields();
		buildIncludeSection();
		if (parentComposite != null) {
			parentComposite.layout();
		}
	}

	/**
	 * creates the 'insert system step', 'insert actor step' and 'delete' button on the top of every step.
	 * 
	 * @param position
	 * @param parent
	 * @return
	 */
	private void buildButtons() {

		final int position = getStepPosition();

		// TODO LB Layout is not correct
		GridData gdActorLink = new GridData(GridData.FILL_HORIZONTAL);
		gdActorLink.grabExcessHorizontalSpace = true;
		gdActorLink.horizontalAlignment = GridData.HORIZONTAL_ALIGN_BEGINNING;
		gdActorLink.horizontalSpan = 1;

		Hyperlink addActorStepLink = getToolkit().createHyperlink(buttonComposite, "Insert Actor Step", parentStyle);
		addActorStepLink.setBackground(backGroundColor);
		addActorStepLink.addHyperlinkListener(new IHyperlinkListener() {
			public void linkActivated(HyperlinkEvent e) {
				createNewStep(position, true);
			}

			public void linkEntered(HyperlinkEvent e) {
			}

			public void linkExited(HyperlinkEvent e) {
			}

		});

		addActorStepLink.setLayoutData(gdActorLink);

		GridData gdSystemLink = new GridData(GridData.FILL_HORIZONTAL);
		gdSystemLink.horizontalAlignment = GridData.HORIZONTAL_ALIGN_CENTER;
		gdSystemLink.grabExcessHorizontalSpace = true;
		gdSystemLink.horizontalSpan = 1;

		Hyperlink addSystemStepLink = getToolkit().createHyperlink(buttonComposite, "Insert System Step", parentStyle);
		addSystemStepLink.setBackground(backGroundColor);
		addSystemStepLink.addHyperlinkListener(new IHyperlinkListener() {

			public void linkActivated(HyperlinkEvent e) {
				createNewStep(position, false);
			}

			public void linkEntered(HyperlinkEvent e) {
			}

			public void linkExited(HyperlinkEvent e) {
			}

		});
		addSystemStepLink.setLayoutData(gdSystemLink);

		GridData gdDeleteLink = new GridData(GridData.FILL_HORIZONTAL);
		gdDeleteLink.horizontalAlignment = GridData.HORIZONTAL_ALIGN_END;
		gdDeleteLink.grabExcessHorizontalSpace = true;
		gdDeleteLink.horizontalSpan = 1;

		ImageHyperlink deleteLink = getToolkit().createImageHyperlink(buttonComposite, parentStyle);
		deleteLink.setBackground(backGroundColor);
		deleteLink.setImage(PlatformUI.getWorkbench().getSharedImages().getImage(ISharedImages.IMG_TOOL_DELETE));
		deleteLink.addMouseListener(new MEHyperLinkDeleteAdapter(contextModelElement, reference, getModelElement(),
			UnicaseActionHelper.getContext(getModelElement())));
		deleteLink.setLayoutData(gdDeleteLink);
	}

	private void buildTextFields() {
		if (textControlName != null) {
			textControlName.dispose();
		}

		if (cName != null) {
			cName.dispose();
		}

		if (textControlDescription != null) {
			textControlDescription.dispose();
		}

		if (cDescription != null) {
			cDescription.dispose();
		}

		ControlFactory cFactory = new ControlFactory();
		IItemPropertyDescriptor pDescriptorName = adapterFactoryItemDelegator.getPropertyDescriptor(getModelElement(),
			"name");
		textControlName = cFactory.createControl(pDescriptorName, getModelElement());
		cName = textControlName.createControl(textComposite, parentStyle, pDescriptorName, getModelElement(),
			UnicaseActionHelper.getContext(getModelElement()), getToolkit());
		GridDataFactory.fillDefaults().align(SWT.FILL, SWT.TOP).hint(250, 16).grab(true, false).applyTo(cName);

		IItemPropertyDescriptor pDescriptorDescription = adapterFactoryItemDelegator.getPropertyDescriptor(
			getModelElement(), "description");
		textControlDescription = cFactory.createControl(pDescriptorDescription, getModelElement());

		cDescription = textControlDescription.createControl(textComposite, parentStyle, pDescriptorDescription,
			getModelElement(), UnicaseActionHelper.getContext(getModelElement()), getToolkit());
		GridDataFactory.fillDefaults().align(SWT.FILL, SWT.TOP).hint(250, 150).grab(true, false).applyTo(cDescription);

		cDescription.setBackground(mainComposite.getBackground());
		textComposite.layout();

	}

	/**
	 * creates the panel for including the system function or use case in a step.
	 * 
	 * @param parent
	 * @return
	 */
	private void buildIncludeSection() {
		if (includeTextLabel != null) {
			includeTextLabel.dispose();
		}

		if (cIncludeLink != null) {
			cIncludeLink.dispose();
		}

		if (includeLinkControl != null) {
			includeLinkControl.dispose();
		}

		final IItemPropertyDescriptor pDescriptorIncluded;
		ControlFactory cFactory = new ControlFactory();

		if (((Step) getModelElement()).isUserStep()) {
			// TODO getting the right descriptor is currently hard coded. Maybe should be changed.
			pDescriptorIncluded = adapterFactoryItemDelegator.getPropertyDescriptor(getModelElement(),
				"includedUseCase");
			includeTextLabel = getToolkit().createLabel(includeComposite, "Include Use Case: ");
			includeTextLabel.setBackground(backGroundColor);

		} else {
			// TODO getting the right descriptor is currently hard coded. Maybe should be changed.
			pDescriptorIncluded = adapterFactoryItemDelegator.getPropertyDescriptor(getModelElement(),
				"includedSystemFunction");
			includeTextLabel = getToolkit().createLabel(includeComposite, "Include System Function: ");
			includeTextLabel.setBackground(backGroundColor);
		}

		includeLinkControl = cFactory.createControl(pDescriptorIncluded, getModelElement());
		cIncludeLink = includeLinkControl.createControl(includeComposite, parentStyle, pDescriptorIncluded,
			getModelElement(), UnicaseActionHelper.getContext(getModelElement()), getToolkit());
		cIncludeLink.setBackground(mainComposite.getBackground());

		includeComposite.layout();
	}

	private void createNewStep(final int position, final boolean isActorStep) {
		new EMFStoreCommand() {
			@Override
			protected void doRun() {
				RequirementFactory rFactory = RequirementFactoryImpl.init();
				Step p = rFactory.createStep();
				UseCase uc = (UseCase) contextModelElement;
				Project project = ModelUtil.getProject(uc);
				project.addModelElement(p);
				if (isActorStep) {
					p.setName("New Actor Step");
				} else {
					p.setName("New System Step");
				}
				p.setUserStep(isActorStep);
				EList<Step> allSteps = uc.getUseCaseSteps();
				if (position == -1) {
					// Add step at the end of the line
					allSteps.add(p);
				} else {
					// Add step the selected position
					allSteps.add(position, p);
				}
			}
		}.run();
	}

	/**
	 * Method closes all containing Widgets and removes the the adapter.
	 */
	@Override
	public void dispose() {
		if (includeLinkControl != null) {
			includeLinkControl.dispose();
		}

		if (textControlDescription != null) {
			textControlDescription.dispose();
		}

		if (textControlName != null) {
			textControlName.dispose();
		}

		getModelElement().eAdapters().remove(eAdapter);
		super.dispose();
	}

	/**
	 * computes the current position in list of the displayed step.
	 * 
	 * @return
	 */
	private int getStepPosition() {
		UseCase uc = (UseCase) contextModelElement;
		EList<Step> allSteps = uc.getUseCaseSteps();
		int counter = 0;
		for (Step step : allSteps) {
			if (step.equals(getModelElement())) {
				return counter;
			}
			counter++;
		}
		return -1;
	}

	/**
	 * sets the focus to the corresponding step.
	 */
	public void setFocus() {
		if (cName != null) {
			cName.setFocus();
		}

	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public int canRender(IItemPropertyDescriptor itemPropertyDescriptor, EObject modelElement) {
		// TODO Auto-generated method stub
		return 0;
	}

}
