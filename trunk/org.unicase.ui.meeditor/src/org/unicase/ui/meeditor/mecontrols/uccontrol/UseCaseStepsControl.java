/**
 * <copyright> Copyright (c) 2008 Jonas Helming, Maximilian Koegel. All rights reserved. This program and the accompanying materials are made available under the terms of the Eclipse Public License v1.0 which accompanies this distribution, and is available at http://www.eclipse.org/legal/epl-v10.html
 * </copyright>
 *
 * $Id$
 */
package org.unicase.ui.meeditor.mecontrols.uccontrol;

import java.util.ArrayList;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.impl.AdapterImpl;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.edit.domain.EditingDomain;
import org.eclipse.emf.edit.provider.IItemPropertyDescriptor;
import org.eclipse.emf.transaction.RecordingCommand;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.emf.transaction.util.TransactionUtil;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.ui.forms.events.HyperlinkEvent;
import org.eclipse.ui.forms.events.IHyperlinkListener;
import org.eclipse.ui.forms.widgets.FormToolkit;
import org.eclipse.ui.forms.widgets.Hyperlink;
import org.eclipse.ui.forms.widgets.Section;
import org.unicase.model.ModelElement;
import org.unicase.model.requirement.RequirementFactory;
import org.unicase.model.requirement.Step;
import org.unicase.model.requirement.UseCase;
import org.unicase.model.requirement.impl.RequirementFactoryImpl;
import org.unicase.ui.meeditor.mecontrols.AbstractMEControl;

/**
 * Class creates a widget that displays all use case steps of a use case.
 * @author lars
 *
 */
public class UseCaseStepsControl extends AbstractMEControl{
	
	private final EReference eReference;
	private final IItemPropertyDescriptor descriptor;
	private AdapterImpl eAdapter;
	
	private Composite mainComposite;
		
	private int parentStyle;
	private Section section;
	
	private Composite stepArea;
	
	
	
	private ArrayList<SingleUseCaseStepControl> stepControls = new ArrayList<SingleUseCaseStepControl>();

	/**
	 * public constructor.
	 * @param modelElement ModelElement that is shown
	 * @param reference specific reference
	 * @param toolkit the used toolkit
	 * @param editingDomain the specific editing Domain
	 * @param descriptor an ItemPropertyDescriptor for the modelElement
	 */
	public UseCaseStepsControl(EObject modelElement, EReference reference, FormToolkit toolkit, EditingDomain editingDomain,
			IItemPropertyDescriptor descriptor) {
		super(editingDomain, modelElement, toolkit);
		this.eReference = reference;
		this.descriptor = descriptor;
		
		eAdapter = new AdapterImpl() {
			@Override
			public void notifyChanged(Notification msg) {
				if (msg.getFeature() != null && msg.getFeature().equals(eReference)) {
					rebuildStepList();
				}
				super.notifyChanged(msg);
			}
		};
		modelElement.eAdapters().add(eAdapter);
	}

	/**
	 * Method creates the specific widget and the containing display elements.
	 * @param parent surrounding widget or container
	 * @param style represents the style that should be used
	 * @return the control containing all use case steps
	 * 
	 */
	public Control createControl(final Composite parent, final int style) {
		this.parentStyle = style;
		section = getToolkit().createSection(parent, Section.TITLE_BAR | Section.TWISTIE | Section.EXPANDED);
		section.setText(descriptor.getDisplayName(getModelElement()));		
		mainComposite = getToolkit().createComposite(section);
		mainComposite.setLayout( new GridLayout(1,true));
		mainComposite.setLayoutData(new GridData(GridData.FILL_HORIZONTAL));
		stepArea = getToolkit().createComposite(mainComposite);
		stepArea.setLayout( new GridLayout(2, true));
		GridData stepAreaGridData = new GridData(GridData.FILL_HORIZONTAL);		
		stepArea.setLayoutData(stepAreaGridData);
		
		
		rebuildStepList();
				
		section.setClient(mainComposite);
				
		return section;
	}
	
	@SuppressWarnings("unchecked")
	private void rebuildStepList() {
		stepArea.dispose();
		for(SingleUseCaseStepControl step : stepControls){
			step.dispose();
		}
		
		
		stepArea = getToolkit().createComposite(mainComposite);
		stepArea.setLayout( new GridLayout(2, true));
		GridData stepAreaGridData = new GridData(GridData.FILL_HORIZONTAL);		
		stepArea.setLayoutData(stepAreaGridData);
		
		for(SingleUseCaseStepControl step : stepControls){
			step.dispose();
		}
		stepControls.clear();
		
		Object objectList = getModelElement().eGet(eReference);
		if (objectList instanceof EList) {
			EList<EObject> eList = (EList<EObject>) objectList;
			int currentPosition = 0;
			for (EObject object : eList) {
				if (object instanceof ModelElement) {
					
					Step me = (Step) object;
					GridData gdEmtpy = new GridData(GridData.FILL_HORIZONTAL);
					gdEmtpy.verticalIndent = 0;
					
					GridData gdUserStep = new GridData(GridData.FILL_HORIZONTAL);
					gdUserStep.verticalIndent = 0;							
					SingleUseCaseStepControl stepControl = new SingleUseCaseStepControl(getEditingDomain(), me, getToolkit(), getModelElement(), eReference);
					
					if(me.isUserStep()){	
						Control c = stepControl.createControl(stepArea, parentStyle);								
						c.setLayoutData(gdUserStep);
						Control empty2 = getToolkit().createComposite(stepArea, parentStyle);						
						empty2.setLayoutData(gdEmtpy);								
					} else {
						Control empty2 = getToolkit().createComposite(stepArea, parentStyle);						
						empty2.setLayoutData(gdEmtpy);
						Control c = stepControl.createControl(stepArea, parentStyle);								
						c.setLayoutData(gdUserStep);
					}
					stepControls.add(stepControl);
				}
				currentPosition++;
			}
		}
		
		GridData gdButtonPanel = new GridData(GridData.FILL_HORIZONTAL);
		gdButtonPanel.verticalIndent = 0;
		gdButtonPanel.horizontalSpan = 2;
		createAddStepButtons(-1, stepArea).setLayoutData(gdButtonPanel);
		mainComposite.layout(true);
		section.setExpanded(false);
		section.setExpanded(true);
		
	}
	
	/**
	 * {@inheritDoc}
	 */
	@Override
	public void dispose(){
		for(SingleUseCaseStepControl step : stepControls){
			step.dispose();
		}
		stepControls.clear();
		getModelElement().eAdapters().remove(eAdapter);
	}
	
	private Composite createAddStepButtons(final int position, Composite parent){
		Composite buttonControl = getToolkit().createComposite(parent);
		buttonControl.setLayout(new GridLayout(2,false));
		buttonControl.setLayoutData(new GridData(GridData.FILL_HORIZONTAL));
		
		
		GridData gdActorLink = new GridData(GridData.FILL_HORIZONTAL);
		gdActorLink.horizontalAlignment = GridData.HORIZONTAL_ALIGN_CENTER;
		gdActorLink.horizontalSpan = 1;
		
		Hyperlink addActorStepLink = getToolkit().createHyperlink(buttonControl, "Insert Actor Step", GridData.HORIZONTAL_ALIGN_BEGINNING);
		addActorStepLink.addHyperlinkListener(new IHyperlinkListener() {
			public void linkActivated(HyperlinkEvent e) {
				TransactionalEditingDomain domain = TransactionUtil.getEditingDomain(getModelElement());
				domain.getCommandStack().execute(new RecordingCommand(domain) {
				protected void doExecute() {
						RequirementFactory rFactory = RequirementFactoryImpl.init();						
						Step p = rFactory.createStep();
						p.setName("New Actor Step");
						p.setUserStep(true);
						UseCase uc = (UseCase) getModelElement();
						EList<Step> allSteps = uc.getUseCaseSteps();
						uc.getProject().addModelElement(p);
						if(position == -1) {allSteps.add(p);} 
						else {allSteps.add(position, p);}
					}
				});
			}
			public void linkEntered(HyperlinkEvent e) {	}
			public void linkExited(HyperlinkEvent e) {	}
		});
		
		addActorStepLink.setLayoutData(gdActorLink);
		
		GridData gdSystemLink = new GridData(GridData.FILL_HORIZONTAL);
		gdSystemLink.horizontalAlignment = GridData.HORIZONTAL_ALIGN_CENTER;
		gdSystemLink.horizontalSpan = 1;
		
		Hyperlink addSystemStepLink = getToolkit().createHyperlink(buttonControl, "Insert System Step", GridData.HORIZONTAL_ALIGN_END);
		addSystemStepLink.addHyperlinkListener(new IHyperlinkListener() {
			public void linkActivated(HyperlinkEvent e) {
				TransactionalEditingDomain domain = TransactionUtil.getEditingDomain(getModelElement());
				domain.getCommandStack().execute(new RecordingCommand(domain) {
					protected void doExecute() {
						RequirementFactory rFactory = RequirementFactoryImpl.init();
						Step p = rFactory.createStep();
						UseCase uc = (UseCase) getModelElement();			
						uc.getProject().addModelElement(p);
						p.setName("New System Step");
						p.setUserStep(false);
						EList<Step> allSteps = uc.getUseCaseSteps();
						if(position == -1) {allSteps.add(p);} 
						else {allSteps.add(position, p);}
					}
				});
			}
			public void linkEntered(HyperlinkEvent e) {}
			public void linkExited(HyperlinkEvent e) {}
		});
		addSystemStepLink.setLayoutData(gdSystemLink);
		
		return buttonControl;
	}


}
