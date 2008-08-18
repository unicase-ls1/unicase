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
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.edit.domain.EditingDomain;
import org.eclipse.emf.edit.provider.AdapterFactoryItemDelegator;
import org.eclipse.emf.edit.provider.ComposedAdapterFactory;
import org.eclipse.emf.edit.provider.IItemPropertyDescriptor;
import org.eclipse.emf.edit.ui.provider.AdapterFactoryLabelProvider;
import org.eclipse.emf.transaction.RecordingCommand;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.emf.transaction.util.TransactionUtil;
import org.eclipse.jface.viewers.ILabelProvider;
import org.eclipse.jface.viewers.CellEditor.LayoutData;
import org.eclipse.jface.window.Window;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.graphics.Color;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Label;
import org.eclipse.ui.ISharedImages;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.dialogs.ElementListSelectionDialog;
import org.eclipse.ui.forms.events.HyperlinkEvent;
import org.eclipse.ui.forms.events.IHyperlinkListener;
import org.eclipse.ui.forms.widgets.FormToolkit;
import org.eclipse.ui.forms.widgets.Hyperlink;
import org.eclipse.ui.forms.widgets.ImageHyperlink;
import org.unicase.model.ModelElement;
import org.unicase.model.Project;
import org.unicase.model.requirement.RequirementFactory;
import org.unicase.model.requirement.Step;
import org.unicase.model.requirement.UseCase;
import org.unicase.model.requirement.impl.RequirementFactoryImpl;
import org.unicase.ui.meeditor.ControlFactory;
import org.unicase.ui.meeditor.mecontrols.AbstractMEControl;
import org.unicase.ui.meeditor.mecontrols.MEControl;
import org.unicase.ui.meeditor.mecontrols.melinkcontrol.MEHyperLinkAdapter;
import org.unicase.ui.meeditor.mecontrols.melinkcontrol.MEHyperLinkDeleteAdapter;
import org.unicase.ui.meeditor.mecontrols.melinkcontrol.MELinkControl;
import org.unicase.ui.meeditor.mecontrols.melinkcontrol.MESingleLinkControl;

public class SingleUseCaseStepControl extends AbstractMEControl{

	private Step currentStep;
	private EReference reference;
	
	private Composite mainComposite;
	
	private AdapterImpl eAdapter;
	
	private int parentStyle;
	
	
	private AdapterFactoryItemDelegator adapterFactoryItemDelegator;
	
	
	private EObject contextModelElement;
	
	private Color backGroundColor;
	
	private ArrayList<Control> allDisplayElements = new ArrayList<Control>();  
	
	private Composite buttonComposite;
	private Composite includeComposite;
	private Composite textComposite;
	
	private Hyperlink includeHyperLink;
	private Label includeTextLabel;
	private Button includeSelectButton;
	
	private MELinkControl meControl;
	
	public SingleUseCaseStepControl(EditingDomain editingDomain, EObject modelElement, FormToolkit toolkit, EObject contextModelElement, final EReference reference) {
		super(editingDomain, modelElement, toolkit);
		this.currentStep = (Step) modelElement;
		this.reference = reference;
		this.contextModelElement = contextModelElement;
		eAdapter = new AdapterImpl() {
			@Override
			public void notifyChanged(Notification msg) {
				if (msg.getFeature() != null && msg.getFeature().equals(reference)) {
					buildStep();
				}
				super.notifyChanged(msg);
			}
		};
		
		adapterFactoryItemDelegator = new AdapterFactoryItemDelegator(
				new ComposedAdapterFactory(
						ComposedAdapterFactory.Descriptor.Registry.INSTANCE));
		
		modelElement.eAdapters().add(eAdapter);
		
	}

	public Control createControl(Composite parent, int style) {
		parentStyle = style;
		
		if(currentStep.isUserStep()){
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
		
		textComposite = getToolkit().createComposite(mainComposite);
		textComposite.setLayout(new GridLayout(1,true));	
		textComposite.setLayoutData(new GridData(GridData.FILL_HORIZONTAL));
		textComposite.setBackground(backGroundColor);
		
		includeComposite = getToolkit().createComposite(mainComposite);
		includeComposite.setLayout(new GridLayout(3,false));
		includeComposite.setBackground(backGroundColor);		

		buildStep();	
		
		return mainComposite;
	}
	
	private void buildStep() {
		for (Control c : allDisplayElements) {
			c.dispose();
		}
		allDisplayElements.clear();
		
		buildButtons();
		buildTextFields();		
		
		buildIncludeSection();
	}
	
	/**
	 * creates the 'insert system step', 'insert actor step' and 'delete' button on the top of every step.
	 * @param position
	 * @param parent
	 * @return
	 */
	private void buildButtons() {
		
		final int position = getStepPosition();
				
		//TODO Layout is not correct
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
		deleteLink.addHyperlinkListener(new MEHyperLinkDeleteAdapter(contextModelElement, reference, currentStep));
		deleteLink.setLayoutData(gdDeleteLink);
	}
	
	private void buildTextFields(){
		
		ControlFactory cFactory = new ControlFactory(getEditingDomain(), currentStep, getToolkit());
		IItemPropertyDescriptor pDescriptorName = adapterFactoryItemDelegator.getPropertyDescriptor(currentStep, "name");
		MEControl textControlName = cFactory.createControl(pDescriptorName);
		Control c = textControlName.createControl(textComposite, parentStyle);
		c.setLayoutData(new GridData(GridData.FILL_HORIZONTAL));
		allDisplayElements.add(c);
		
		IItemPropertyDescriptor pDescriptorDescription = adapterFactoryItemDelegator.getPropertyDescriptor(currentStep, "description");				
		MEControl textControlDescription = cFactory.createControl(pDescriptorDescription);				
		c = textControlDescription.createControl(textComposite, parentStyle);
		c.setLayoutData(new GridData(GridData.FILL_HORIZONTAL));
		allDisplayElements.add(c);
		
		
	}
	
	/**
	 * creates the panel for including the system function or use case in a step.
	 * @param parent
	 * @return
	 */
	private void buildIncludeSection() {
		
		
		if(includeHyperLink != null) {
			includeHyperLink.dispose();
		}
		
		if(includeSelectButton != null) {
			includeSelectButton.dispose();
		}
		
		if(includeTextLabel != null) {
			includeTextLabel.dispose();
		}
		
		final IItemPropertyDescriptor pDescriptorIncluded;
		final EReference ref;
		if( currentStep.isUserStep()) {
			//TODO getting the right descriptor is currently hard coded. Maybe should be changed.
			pDescriptorIncluded = adapterFactoryItemDelegator.getPropertyDescriptor(currentStep, "includedUseCase");
			includeTextLabel = getToolkit().createLabel(includeComposite, "Include Use Case: ");
			includeTextLabel.setBackground(backGroundColor);
			
		} else {
			//TODO getting the right descriptor is currently hard coded. Maybe should be changed.
			pDescriptorIncluded = adapterFactoryItemDelegator.getPropertyDescriptor(currentStep, "includedSystemFunction");
			includeTextLabel = getToolkit().createLabel(includeComposite, "Include System Function: ");
			includeTextLabel.setBackground(backGroundColor);
		}
		ref = (EReference) pDescriptorIncluded.getFeature(currentStep);
		
		includeSelectButton = getToolkit().createButton(includeComposite, "Select", SWT.PUSH);
		includeSelectButton.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				TransactionalEditingDomain domain = TransactionUtil.getEditingDomain(currentStep);
				domain.getCommandStack().execute(new RecordingCommand(domain) {
					@Override
					protected void doExecute() {
						EClass clazz = ref.getEReferenceType();
						ElementListSelectionDialog dlg = new ElementListSelectionDialog(includeComposite.getShell(), new AdapterFactoryLabelProvider(new ComposedAdapterFactory(
								ComposedAdapterFactory.Descriptor.Registry.INSTANCE)));
						Collection<ModelElement> allElements = ((ModelElement) currentStep).getProject().getAllModelElementsbyClass(clazz, new BasicEList<ModelElement>());
						allElements.remove(contextModelElement);
						Object object = currentStep.eGet(ref);
						if (object instanceof EObject) {
							allElements.remove(object);
						}						
						dlg.setElements(allElements.toArray());						
						dlg.setTitle("Select Element");
						dlg.setBlockOnOpen(true);
						if (dlg.open() == Window.OK) {
							Object result = dlg.getFirstResult();
							if (result instanceof EObject) {
								EObject eObject = (EObject) result;
								currentStep.eSet(ref, eObject);
							}
						}
					}
				});				
			}
		});
		
		EObject opposite = (EObject) getModelElement().eGet(ref);
		if(opposite != null){
			ILabelProvider labelProvider = new AdapterFactoryLabelProvider(
			new ComposedAdapterFactory(ComposedAdapterFactory.Descriptor.Registry.INSTANCE));
			includeHyperLink = getToolkit().createHyperlink(includeComposite, labelProvider.getText(opposite), parentStyle);
			IHyperlinkListener listener = new MEHyperLinkAdapter((ModelElement) opposite);
			includeHyperLink.addHyperlinkListener(listener);			
			includeHyperLink.setBackground(backGroundColor);
		} 			
		
		
		includeComposite.setVisible(false);
		includeComposite.setVisible(true);
		includeComposite.pack();
	}
	
	private void createNewStep(final int position, final boolean isActorStep){
		TransactionalEditingDomain domain = TransactionUtil.getEditingDomain(currentStep);
		domain.getCommandStack().execute(new RecordingCommand(domain) {
			@Override
			protected void doExecute() {
				RequirementFactory rFactory = RequirementFactoryImpl.init();
				
				Step p = rFactory.createStep();
				p.setName("New Actor Step");
				p.setUserStep(isActorStep);
				UseCase uc = (UseCase) contextModelElement;
				EList<Step> allSteps = uc.getUseCaseSteps();
				
				if(position == -1) {
					//Add step at the end of the line
					allSteps.add(p);
				} else {
					//Add step the selected position
					allSteps.add(position, p);
				}				
				Project project = uc.getProject();
				project.addModelElement(p);
			}
			
		});
	}
	
	@Override
	public void dispose(){
		for (Control c : allDisplayElements) {
			c.dispose();
		}
		allDisplayElements.clear();
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
			if(step.equals(this.currentStep)) {
				return counter;
			}
			counter++;
		}
		return -1;
	}


}
