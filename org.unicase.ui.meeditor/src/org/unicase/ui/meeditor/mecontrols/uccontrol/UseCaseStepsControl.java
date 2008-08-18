package org.unicase.ui.meeditor.mecontrols.uccontrol;

import java.util.ArrayList;
import java.util.Collection;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.impl.AdapterImpl;
import org.eclipse.emf.common.util.BasicEList;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.edit.domain.EditingDomain;
import org.eclipse.emf.edit.provider.ComposedAdapterFactory;
import org.eclipse.emf.edit.provider.IItemPropertyDescriptor;
import org.eclipse.emf.edit.ui.provider.AdapterFactoryLabelProvider;
import org.eclipse.emf.transaction.RecordingCommand;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.emf.transaction.util.TransactionUtil;
import org.eclipse.jface.window.Window;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.ui.ISharedImages;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.dialogs.ElementListSelectionDialog;
import org.eclipse.ui.forms.events.HyperlinkEvent;
import org.eclipse.ui.forms.events.IHyperlinkListener;
import org.eclipse.ui.forms.widgets.FormToolkit;
import org.eclipse.ui.forms.widgets.Hyperlink;
import org.eclipse.ui.forms.widgets.ImageHyperlink;
import org.eclipse.ui.forms.widgets.Section;
import org.unicase.model.ModelElement;
import org.unicase.model.requirement.RequirementFactory;
import org.unicase.model.requirement.Step;
import org.unicase.model.requirement.UseCase;
import org.unicase.model.requirement.impl.RequirementFactoryImpl;
import org.unicase.model.requirement.impl.StepImpl;
import org.unicase.ui.meeditor.mecontrols.AbstractMEControl;
import org.unicase.ui.meeditor.mecontrols.melinkcontrol.MEHyperLinkDeleteAdapter;
import org.unicase.ui.meeditor.mecontrols.melinkcontrol.MELinkControl;
import org.unicase.workspace.WorkspaceManager;

public class UseCaseStepsControl extends AbstractMEControl{
	
	private final EReference eReference;
	private final IItemPropertyDescriptor descriptor;
	private AdapterImpl eAdapter;
	
	private Composite mainComposite;
	
	private Composite parentComposite;
	private int parentStyle;
	private Section section;
	
	private Composite stepArea;
	
	
	
	private ArrayList<SingleUseCaseStepControl> stepControls = new ArrayList<SingleUseCaseStepControl>();

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

	public Control createControl(final Composite parent, final int style) {
		this.parentComposite = parent;
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
	
	private void rebuildStepList() {
		stepArea.dispose();
		stepArea = getToolkit().createComposite(mainComposite);
		stepArea.setLayout( new GridLayout(2, true));
		GridData stepAreaGridData = new GridData(GridData.FILL_HORIZONTAL);		
		stepArea.setLayoutData(stepAreaGridData);
		
		for(SingleUseCaseStepControl step : stepControls){
			step.dispose();
		}
		stepControls.clear();
		
		TransactionalEditingDomain domain = WorkspaceManager.getInstance().getCurrentWorkspace().getEditingDomain();
		domain.getCommandStack().execute(new RecordingCommand(domain) {
			@SuppressWarnings("unchecked")
			@Override
			protected void doExecute() {
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
			}
		});
		
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
					@SuppressWarnings("unchecked")
					@Override
					protected void doExecute() {
						RequirementFactory rFactory = RequirementFactoryImpl.init();						
						Step p = rFactory.createStep();
						p.setName("New Actor Step");
						p.setUserStep(true);
						UseCase uc = (UseCase) getModelElement();
						EList<Step> allSteps = uc.getUseCaseSteps();
						
						if(position == -1) {
							//Add step at the end of the line
							allSteps.add(p);
						} else {
							//Add step the selected position
							allSteps.add(position, p);
						}
						uc.getProject().addModelElement(p);
					}
				});
				
			}

			public void linkEntered(HyperlinkEvent e) {
				// TODO Auto-generated method stub
				
			}

			public void linkExited(HyperlinkEvent e) {
				// TODO Auto-generated method stub
				
			}
			
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
					@SuppressWarnings("unchecked")
					@Override
					protected void doExecute() {
						RequirementFactory rFactory = RequirementFactoryImpl.init();
						Step p = rFactory.createStep();
						p.setName("New System Step");
						p.setUserStep(false);
						UseCase uc = (UseCase) getModelElement();						
						EList<Step> allSteps = uc.getUseCaseSteps();
						if(position == -1) {
							allSteps.add(p);
						} else {
							allSteps.add(position, p);
						}
						uc.getProject().addModelElement(p);
					}
				});
			}
				
			public void linkEntered(HyperlinkEvent e) {
				// TODO Auto-generated method stub
				
			}

			public void linkExited(HyperlinkEvent e) {
				// TODO Auto-generated method stub
				
			}
		
		
		});
		addSystemStepLink.setLayoutData(gdSystemLink);
		
		return buttonControl;
	}


}
