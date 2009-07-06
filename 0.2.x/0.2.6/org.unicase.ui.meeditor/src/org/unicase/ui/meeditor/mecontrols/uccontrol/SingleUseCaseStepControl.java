/**
 * <copyright> Copyright (c) 2008 Jonas Helming, Maximilian Koegel. All rights reserved. This program and the accompanying materials are made available under the terms of the Eclipse Public License v1.0 which accompanies this distribution, and is available at http://www.eclipse.org/legal/epl-v10.html
 * </copyright>
 *
 * $Id$
 */
package org.unicase.ui.meeditor.mecontrols.uccontrol;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.impl.AdapterImpl;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.edit.domain.EditingDomain;
import org.eclipse.emf.edit.provider.AdapterFactoryItemDelegator;
import org.eclipse.emf.edit.provider.ComposedAdapterFactory;
import org.eclipse.emf.edit.provider.IItemPropertyDescriptor;
import org.eclipse.emf.transaction.RecordingCommand;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.emf.transaction.util.TransactionUtil;
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
import org.unicase.model.Project;
import org.unicase.model.requirement.RequirementFactory;
import org.unicase.model.requirement.RequirementPackage;
import org.unicase.model.requirement.Step;
import org.unicase.model.requirement.UseCase;
import org.unicase.model.requirement.impl.RequirementFactoryImpl;
import org.unicase.ui.meeditor.ControlFactory;
import org.unicase.ui.meeditor.mecontrols.AbstractMEControl;
import org.unicase.ui.meeditor.mecontrols.MEControl;
import org.unicase.ui.meeditor.mecontrols.melinkcontrol.MEHyperLinkDeleteAdapter;

/**
 * class creates and controls a widget to display one single use case step. 
 * @author lars
 *
 */
public class SingleUseCaseStepControl extends AbstractMEControl{

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
	
	private MEControl textControlName;
	private MEControl textControlDescription;
	private Control cName;
	private Control cDescription;


	private Label includeTextLabel;
	private MEControl includeLinkControl;	
	private Control cIncludeLink;
	
	/**
	 * Public constructor.
	 * @param editingDomain the current editing Domain
	 * @param modelElement current ModelElement that is displayed
	 * @param toolkit used toolkit
	 * @param contextModelElement the 
	 * @param reference a specific reference
	 */
	public SingleUseCaseStepControl(EditingDomain editingDomain, EObject modelElement, FormToolkit toolkit, EObject contextModelElement, final EReference reference) {
		super(editingDomain, modelElement, toolkit);
		this.reference = reference;
		this.contextModelElement = contextModelElement;
		eAdapter = new AdapterImpl() {
			@Override
			public void notifyChanged(Notification msg) {
				if (msg.getFeature() != null 
						&& (msg.getFeatureID(Step.class) == RequirementPackage.STEP__INCLUDED_USE_CASE 
						|| msg.getFeatureID(Step.class) == RequirementPackage.STEP__INCLUDED_SYSTEM_FUNCTION)) {
					//buildStep();
					reLayout();
				}
				super.notifyChanged(msg);
			}
		};
		
		adapterFactoryItemDelegator = new AdapterFactoryItemDelegator(
				new ComposedAdapterFactory(
						ComposedAdapterFactory.Descriptor.Registry.INSTANCE));
		
		modelElement.eAdapters().add(eAdapter);
		
	}
	
	/**
	 * Method creates the specific widget and the containing elements.
	 * @param parent surrounding widget or container
	 * @param style represents the style that should be used
	 * @return the control representing an single use case step
	 * 
	 */
	public Control createControl(Composite parent, int style) {
		parentStyle = style;
		parentComposite = parent;
		
		if(((Step)getModelElement()).isUserStep()){
			backGroundColor = parent.getDisplay().getSystemColor(SWT.COLOR_INFO_BACKGROUND);
		} else {
			backGroundColor = parent.getDisplay().getSystemColor(SWT.COLOR_GRAY);
		}
		
		mainComposite = getToolkit().createComposite(parent);
		mainComposite.setLayout(new GridLayout(1,true));
		mainComposite.setLayoutData(new GridData(GridData.FILL_HORIZONTAL));
		mainComposite.setBackground(backGroundColor);	
		
		buttonComposite = getToolkit().createComposite(mainComposite);
		buttonComposite.setLayout(new GridLayout(3,true));	
		buttonComposite.setLayoutData(new GridData(GridData.FILL_HORIZONTAL));
		buttonComposite.setBackground(backGroundColor);
		
		buildButtons();
		
		textComposite = getToolkit().createComposite(mainComposite);
		textComposite.setLayout(new GridLayout(1,true));	
		textComposite.setLayoutData(new GridData(GridData.FILL_HORIZONTAL));
		textComposite.setBackground(backGroundColor);
		
		includeComposite = getToolkit().createComposite(mainComposite);
		includeComposite.setLayout(new GridLayout(2,false));
		includeComposite.setBackground(backGroundColor);		

		buildStep();	
		parentComposite.layout();
		
		return mainComposite;
	}
	
	private void reLayout(){
		parentComposite.layout();
	}
	
	private void buildStep() {
		
		buildTextFields();		
		buildIncludeSection();
		if(parentComposite != null) {
			parentComposite.layout();
		}
	}
	
	/**
	 * creates the 'insert system step', 'insert actor step' and 'delete' button on the top of every step.
	 * @param position
	 * @param parent
	 * @return
	 */
	private void buildButtons() {
		
		final int position = getStepPosition();
				
		//TODO LB Layout is not correct
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

			public void linkEntered(HyperlinkEvent e) {}

			public void linkExited(HyperlinkEvent e) {}
			
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
				
			public void linkEntered(HyperlinkEvent e) {}

			public void linkExited(HyperlinkEvent e) {}
		
		
		});
		addSystemStepLink.setLayoutData(gdSystemLink);
		
		GridData gdDeleteLink = new GridData(GridData.FILL_HORIZONTAL);
		gdDeleteLink.horizontalAlignment = GridData.HORIZONTAL_ALIGN_END;
		gdDeleteLink.grabExcessHorizontalSpace = true;
		gdDeleteLink.horizontalSpan = 1;
		
		ImageHyperlink deleteLink = getToolkit().createImageHyperlink(buttonComposite, parentStyle);
		deleteLink.setBackground(backGroundColor);
		deleteLink.setImage(PlatformUI.getWorkbench().getSharedImages().getImage(ISharedImages.IMG_TOOL_DELETE));
		deleteLink.addHyperlinkListener(new MEHyperLinkDeleteAdapter(contextModelElement, reference, getModelElement()));
		deleteLink.setLayoutData(gdDeleteLink);
	}
	
	private void buildTextFields(){
		if(textControlName != null) {
			textControlName.dispose();
		}
		
		if(cName != null) {
			cName.dispose();
		}
		
		if(textControlDescription != null) {
			textControlDescription.dispose();
		}
		
		if(cDescription != null) {
			cDescription.dispose();
		}
		
		ControlFactory cFactory = new ControlFactory(getEditingDomain(), getModelElement(), getToolkit());
		IItemPropertyDescriptor pDescriptorName = adapterFactoryItemDelegator.getPropertyDescriptor(getModelElement(), "name");
		textControlName = cFactory.createControl(pDescriptorName);
		cName = textControlName.createControl(textComposite, parentStyle);
		cName.setLayoutData(new GridData(GridData.FILL_HORIZONTAL));
		
		IItemPropertyDescriptor pDescriptorDescription = adapterFactoryItemDelegator.getPropertyDescriptor(getModelElement(), "description");				
		textControlDescription = cFactory.createControl(pDescriptorDescription);				
		cDescription = textControlDescription.createControl(textComposite, parentStyle);
		cDescription.setLayoutData(new GridData(GridData.FILL_HORIZONTAL));
				
		textComposite.layout();
		
		
	}
	
	/**
	 * creates the panel for including the system function or use case in a step.
	 * @param parent
	 * @return
	 */
	private void buildIncludeSection() {
		if(includeTextLabel != null) {
			includeTextLabel.dispose();
		}
		
		if(cIncludeLink != null) {
			cIncludeLink.dispose();
		}
		
		if(includeLinkControl != null) {
			includeLinkControl.dispose();
		}
		
		final IItemPropertyDescriptor pDescriptorIncluded;		
		ControlFactory cFactory = new ControlFactory(getEditingDomain(), getModelElement(), getToolkit());
		
		if( ((Step)getModelElement()).isUserStep()) {
			//TODO getting the right descriptor is currently hard coded. Maybe should be changed.
			pDescriptorIncluded = adapterFactoryItemDelegator.getPropertyDescriptor(getModelElement(), "includedUseCase");
			includeTextLabel = getToolkit().createLabel(includeComposite, "Include Use Case: ");
			includeTextLabel.setBackground(backGroundColor);
						
		} else {
			//TODO getting the right descriptor is currently hard coded. Maybe should be changed.
			pDescriptorIncluded = adapterFactoryItemDelegator.getPropertyDescriptor(getModelElement(), "includedSystemFunction");
			includeTextLabel = getToolkit().createLabel(includeComposite, "Include System Function: ");
			includeTextLabel.setBackground(backGroundColor);
		}
		
		includeLinkControl = cFactory.createControl(pDescriptorIncluded);
		cIncludeLink = includeLinkControl.createControl(includeComposite, parentStyle);
		
		includeComposite.layout();
	}
	
	private void createNewStep(final int position, final boolean isActorStep){
		TransactionalEditingDomain domain = TransactionUtil.getEditingDomain(getModelElement());
		domain.getCommandStack().execute(new RecordingCommand(domain) {
			@Override
			protected void doExecute() {
				RequirementFactory rFactory = RequirementFactoryImpl.init();				
				Step p = rFactory.createStep();
				UseCase uc = (UseCase) contextModelElement;
				Project project = uc.getProject();
				project.addModelElement(p);
				p.setName("New Actor Step");
				p.setUserStep(isActorStep);
				EList<Step> allSteps = uc.getUseCaseSteps();
				if(position == -1) {
					//Add step at the end of the line
					allSteps.add(p);
				} else {
					//Add step the selected position
					allSteps.add(position, p);
				}				
			}
		});
	}
	
	/**
	 * Method closes all containing Widgets and removes the the adapter.
	 */
	@Override
	public void dispose(){		
		if(includeLinkControl != null) {
			includeLinkControl.dispose();
		}
		
		if(textControlDescription != null) {
			textControlDescription.dispose();
		}
		
		if( textControlName != null) {
			textControlName.dispose();
		}
		
		getModelElement().eAdapters().remove(eAdapter);
		super.dispose();
	}
	
	/**
	 * computes the current position in list of the displayed step.
	 * @return
	 */
	private int getStepPosition(){
		UseCase uc = (UseCase) contextModelElement;
		EList<Step> allSteps = uc.getUseCaseSteps();
		int counter = 0;
		for(Step step : allSteps) {
			if(step.equals(getModelElement())) {
				return counter;
			}
			counter++;
		}
		return -1;
	}


}
