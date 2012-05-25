package org.unicase.model.usecase.ui.controls;

import java.util.ArrayList;
import java.util.List;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.impl.AdapterImpl;
import org.unicase.model.UnicaseModelElement;
import org.unicase.model.usecase.ActorStep;
import org.unicase.model.usecase.Option;
import org.unicase.model.usecase.SystemStep;
import org.unicase.model.usecase.UseCase;
import org.unicase.model.usecase.UsecaseFactory;
import org.unicase.model.usecase.impl.UsecaseFactoryImpl;
import org.unicase.model.usecase.ui.controls.FlowOfEventsControl;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.edit.provider.AdapterFactoryItemDelegator;
import org.eclipse.emf.edit.provider.ComposedAdapterFactory;
import org.eclipse.emf.edit.provider.IItemPropertyDescriptor;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.DisposeEvent;
import org.eclipse.swt.events.DisposeListener;
import org.eclipse.swt.events.DragDetectEvent;
import org.eclipse.swt.events.DragDetectListener;
import org.eclipse.swt.events.MouseEvent;
import org.eclipse.swt.events.MouseListener;
import org.eclipse.swt.events.MouseTrackListener;
import org.eclipse.swt.graphics.Color;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.graphics.Point;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Text;
import org.eclipse.ui.ISharedImages;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.forms.events.HyperlinkEvent;
import org.eclipse.ui.forms.events.IHyperlinkListener;
import org.eclipse.ui.forms.widgets.ImageHyperlink;
import org.unicase.metamodel.ModelElement;
import org.unicase.ui.meeditor.ControlFactory;
import org.unicase.ui.meeditor.mecontrols.AbstractMEControl;
import org.unicase.workspace.util.UnicaseCommand;

/**
 * @author phil
 * @brief Renders a single actor step.
 */
public class ActorStepControl extends AbstractMEControl {

	/**
	 * Adapter added to each option, forwards change notification to use case, if included use case is changed
	 */
	private final class OptionAdapter extends AdapterImpl {
		@Override
		public void notifyChanged(Notification msg) {
			if (msg.getFeature() instanceof EReference
				&& ((EReference) msg.getFeature()).getName() == "includedUseCase")
				if (parentUseCase != null)
					parentUseCase.eNotify(msg);
		}
	}

	/**
	 * Listens to new option hyperlink
	 */
	private final class NewOptionHyperlink implements IHyperlinkListener {

		public void linkActivated(HyperlinkEvent e) {

			new UnicaseCommand() {
				@Override
				protected void doRun() {
					UsecaseFactory uFactory = UsecaseFactoryImpl.init();
					Option o = uFactory.createOption();
					parentUseCase.getProject().addModelElement(o);
					o.setName("New Option");
					o.setSourceStep((ActorStep) getModelElement());
					o.setTargetStep(null);
					EList<Option> optionList = ((ActorStep) getModelElement()).getOptions();
					optionList.add(o);

					OptionAdapter oAdapter = new OptionAdapter();
					o.eAdapters().add(oAdapter);
				}
			}.run();

			initOptions();
			sync();
		}

		public void linkEntered(HyperlinkEvent e) {
		}

		public void linkExited(HyperlinkEvent e) {
		}
	}

	/**
	 * Listens to delete option hyperlink
	 */
	private final class DeleteOptionHyperlink implements IHyperlinkListener {

		private final int position;

		private DeleteOptionHyperlink(int position) {
			this.position = position;
		}

		public void linkActivated(HyperlinkEvent e) {

			new UnicaseCommand() {
				@Override
				protected void doRun() {
					EList<Option> optionList = ((ActorStep) getModelElement()).getOptions();
					Option toBeRemoved;
					if (position < optionList.size()) {

						toBeRemoved = optionList.remove(position);
						toBeRemoved.delete();
					}
				}
			}.run();

			sync();
		}

		public void linkEntered(HyperlinkEvent e) {
		}

		public void linkExited(HyperlinkEvent e) {
		}
	}

	/**
	 * Listens to delete actor step hyperlink
	 */
	private final class DeleteActorStepHyperlink implements IHyperlinkListener {

		private int position;

		private DeleteActorStepHyperlink(int position) {
			this.position = position;
		}

		public void linkActivated(HyperlinkEvent e) {

			new UnicaseCommand() {
				@Override
				protected void doRun() {
					// EList<Option> optionList = ((ActorStep)getModelElement()).getOptions();
					for (int i = 0; i < parentUseCase.getSystemSteps().size(); i++) {
						if (parentUseCase.getSystemSteps().get(i).getLinkedStep() != null
							&& parentUseCase.getSystemSteps().get(i).getLinkedStep().equals(
								(UnicaseModelElement) getModelElement()))
							parentUseCase.getSystemSteps().get(i).setLinkedStep(null);
					}
					for (int i = 0; i < parentUseCase.getActorSteps().size(); i++) {
						if (i != position - 1) {
							for (int j = 0; j < parentUseCase.getActorSteps().get(i).getOptions().size(); j++)

								if (parentUseCase.getActorSteps().get(i).getOptions().get(j).getTargetStep() != null
									&& parentUseCase.getActorSteps().get(i).getOptions().get(j).getTargetStep().equals(
										(UnicaseModelElement) getModelElement()))
									parentUseCase.getActorSteps().get(i).getOptions().get(j).setTargetStep(null);
						}
					}
					EList<ActorStep> actorStepList = parentUseCase.getActorSteps();
					ActorStep toBeRemoved;
					if (position <= actorStepList.size()) {
						toBeRemoved = actorStepList.remove(position - 1);
						toBeRemoved.delete();
					}

				}
			}.run();

		}

		public void linkEntered(HyperlinkEvent e) {
		}

		public void linkExited(HyperlinkEvent e) {
		}
	}

	/**
	 * Listens to 'link' hyperlink associated with each actor choice
	 */
	private final class LinkOptionHyperlink implements IHyperlinkListener {

		private Option sourceOption;

		private LinkOptionHyperlink(Option sourceOption) {
			this.sourceOption = sourceOption;
		}

		public void linkActivated(HyperlinkEvent e) {

			parentControl.setLinkMode(true, false);
			parentControl.setSourceOption(sourceOption);

		}

		public void linkEntered(HyperlinkEvent e) {
		}

		public void linkExited(HyperlinkEvent e) {
		}
	}

	/**
	 * Listens to hyperlink that deletes a link starting at this step
	 */
	private final class DeleteLinkOptionHyperlink implements IHyperlinkListener {

		private Option sourceOption;

		private DeleteLinkOptionHyperlink(Option sourceOption) {
			this.sourceOption = sourceOption;
		}

		public void linkActivated(HyperlinkEvent e) {

			new UnicaseCommand() {
				@Override
				protected void doRun() {
					sourceOption.setTargetStep(null);
				}
			}.run();
			sync();
		}

		public void linkEntered(HyperlinkEvent e) {
		}

		public void linkExited(HyperlinkEvent e) {
		}
	}

	/**
	 * HyperLink listener class to add actor step hyperlink. Modification of NewStepListener in UseCaseStepsControl.java
	 * in package org.unicase.ui.unicasecommon.meeditor.mecontrols.uccontrol due to authors lars & helming
	 */
	private final class NewActorStepHyperlink implements IHyperlinkListener {
		private final int position;

		private NewActorStepHyperlink(int position) {
			this.position = position;
		}

		public void linkActivated(HyperlinkEvent e) {
			new UnicaseCommand() {
				@Override
				protected void doRun() {
					UsecaseFactory uFactory = UsecaseFactoryImpl.init();
					ActorStep p = uFactory.createActorStep();
					parentUseCase.getProject().addModelElement(p);
					p.setName("New Actor Step");
					EList<ActorStep> actorStepList = parentUseCase.getActorSteps();
					if (position == -1) {
						actorStepList.add(p);
					} else {
						actorStepList.add(position, p);
					}
				}
			}.run();
		}

		public void linkEntered(HyperlinkEvent e) {
		}

		public void linkExited(HyperlinkEvent e) {
		}
	}

	/**
	 * Detects mouse hover over actor step in link mode and signals that this step is a valid target for an incoming
	 * link by a red frame around the step.
	 */
	private final class LinkByMouseListener implements MouseTrackListener {
		public void mouseEnter(MouseEvent e) {
			boolean eligibleTarget = parentControl.getLinkMode();
			if (eligibleTarget && !parentControl.getSystemStepLinkSource())
				if (parentControl.getSourceOption().getSourceStep().equals((UnicaseModelElement) getModelElement()))
					eligibleTarget = false;
			if (eligibleTarget)
				border.setBackground(signalColor1);
		}

		public void mouseExit(MouseEvent e) {
			if (border.getBackground() != standardColor)
				border.setBackground(standardColor);

		}

		public void mouseHover(MouseEvent e) {
			// TODO Auto-generated method stub

		}
	}

	/**
	 * Listens to mouse click events to create links
	 */
	private final class CreateLinkByMouseListener implements MouseListener {

		public void mouseDoubleClick(MouseEvent e) {
			// TODO Auto-generated method stub

		}

		public void mouseDown(MouseEvent e) {
			boolean eligibleTarget = parentControl.getLinkMode();
			if (eligibleTarget && !parentControl.getSystemStepLinkSource())
				if (parentControl.getSourceOption().getSourceStep().equals((UnicaseModelElement) getModelElement()))
					eligibleTarget = false;

			if (eligibleTarget) {
				if (!parentControl.getSystemStepLinkSource()) {
					new UnicaseCommand() {
						@Override
						protected void doRun() {
							Option toBeLinked = parentControl.getSourceOption();
							toBeLinked.setTargetStep((UnicaseModelElement) getModelElement());
						}
					}.run();
				} else {
					new UnicaseCommand() {
						@Override
						protected void doRun() {
							SystemStep toBeLinked = (SystemStep) parentControl.getSourceElement();
							toBeLinked.setLinkedStep((UnicaseModelElement) getModelElement());
						}
					}.run();

				}
				parentControl.setLinkMode(false, false);
			}
		}

		public void mouseUp(MouseEvent e) {
			// TODO Auto-generated method stub

		}

	}

	/**
	 * Listens to drag events (to change order of steps)
	 */
	private final class StepDragDetectListener implements DragDetectListener {

		public void dragDetected(DragDetectEvent e) {
			border.setBackground(signalColor1);
			parentControl.setDragMode(true, true, position);
			// parentComposite.setDragDetect(true);
		}

	}

	// icon image path
	private static final String PLUGIN_ID = "org.unicase.model.usecase.ui";
	private static final String ADD_ICON = "icons/add2.png";
	private static final String LINK_ICON = "icons/linkOption.png";
	private static final String UNLINK_ICON = "icons/unlinkOption.png";
	private static final String ADDABOVE_ICON = "icons/addAbove.png";

	// context information
	private FlowOfEventsControl parentControl;
	private UseCase parentUseCase;
	private Composite parentComposite;
	private int style;
	private int position = 1;

	// composites forming the actor step
	private Composite border;
	private Composite mainComposite;
	private Composite topButtonPanel;
	private Composite topButtonDragArea;
	private Composite optionsPanel;

	// options composite is refreshed on each change in options
	private Composite options;
	private List<Composite> optionComposites = new ArrayList<Composite>();
	private List<Point> locations = new ArrayList<Point>();
	private ImageHyperlink addOption;
	private NewOptionHyperlink optionHyperlinkListener;

	// other GUI Elements
	private ImageHyperlink addStepAbove;
	private ImageHyperlink deleteStep;
	private Text stepNumber;

	private List<AbstractMEControl> optionDescriptionsAbstract = new ArrayList<AbstractMEControl>();
	private List<Control> optionDescriptions = new ArrayList<Control>();
	private List<AbstractMEControl> optionUseCaseLinksAbstract = new ArrayList<AbstractMEControl>();
	private List<Control> optionUseCaseLinks = new ArrayList<Control>();

	private Color standardColor;
	private Color signalColor1;

	/**
	 * decline to render any control as actor step control should be called explicitly
	 */
	@Override
	public int canRender(IItemPropertyDescriptor itemPropertyDescriptor, ModelElement modelElement) {
		// Actor Step control shall only be called explicitly
		return DO_NOT_RENDER;
	}

	/**
	 * Creates actor step
	 */
	@Override
	protected Control createControl(Composite parent, int style) {

		this.style = style;
		parentComposite = parent;

		// add adapters to options
		for (Option o : ((ActorStep) getModelElement()).getOptions()) {
			boolean hasOptionAdapter = false;

			for (int i = 0; i < o.eAdapters().size(); i++) {
				if (OptionAdapter.class.isInstance(o.eAdapters().get(i)))
					hasOptionAdapter = true;
			}

			if (!hasOptionAdapter) {
				// System.out.println("Adapter added");
				OptionAdapter a = new OptionAdapter();
				o.eAdapters().add(a);
			}
		}

		border = getToolkit().createComposite(parent);
		standardColor = new Color(border.getDisplay().getCurrent(), 204, 255, 255);
		signalColor1 = border.getDisplay().getSystemColor(SWT.COLOR_RED);
		border.setBackground(standardColor);
		border.setLayout(new GridLayout(1, true));
		border.setLayoutData(new GridData(SWT.BEGINNING, SWT.TOP, false, true));
		border.addMouseTrackListener(new LinkByMouseListener());
		border.addMouseListener(new CreateLinkByMouseListener());

		mainComposite = getToolkit().createComposite(border);
		mainComposite.setBackground(standardColor);
		GridLayout grid_mainComposite = new GridLayout(1, true);
		grid_mainComposite.horizontalSpacing = 0;
		grid_mainComposite.verticalSpacing = 0;
		grid_mainComposite.marginHeight = 0;
		grid_mainComposite.marginWidth = 0;
		mainComposite.setLayout(grid_mainComposite);
		mainComposite.setLayoutData(new GridData(SWT.BEGINNING, SWT.TOP, false, true));

		topButtonPanel = getToolkit().createComposite(mainComposite);
		topButtonPanel.setBackground(standardColor);
		topButtonPanel.setLayout(new GridLayout(4, false));

		optionsPanel = getToolkit().createComposite(mainComposite);
		optionsPanel.setBackground(standardColor);
		optionsPanel.setLayout(new GridLayout(1, true));
		GridLayout grid_options = new GridLayout(1, true);
		GridData gridData_options = new GridData();
		grid_options.horizontalSpacing = 0;
		grid_options.marginHeight = 0;
		grid_options.marginWidth = 0;
		grid_options.verticalSpacing = 5;
		gridData_options.grabExcessVerticalSpace = true;
		gridData_options.grabExcessHorizontalSpace = true;
		optionsPanel.setLayout(grid_options);
		optionsPanel.setLayoutData(gridData_options);
		optionsPanel.setBackground(standardColor);

		addOption = null;
		optionHyperlinkListener = new NewOptionHyperlink();
		options = getToolkit().createComposite(optionsPanel);

		stepNumber = new Text(topButtonPanel, style);
		stepNumber.setEditable(false);

		topButtonDragArea = getToolkit().createComposite(topButtonPanel);
		topButtonDragArea.setLayout(new GridLayout());
		topButtonDragArea.setLayoutData(new GridData(230, 20));
		topButtonDragArea.setBackground(standardColor);
		topButtonDragArea.addDragDetectListener(new StepDragDetectListener());

		mainComposite.pack();
		mainComposite.layout(true);

		return mainComposite;
	}

	/**
	 * Deletes components of actor step control
	 */
	@Override
	public void dispose() {

		// removeOptionAdapters();

		for (int i = 0; i < optionDescriptionsAbstract.size(); i++)
			if (optionDescriptionsAbstract.get(i) != null)
				optionDescriptionsAbstract.get(i).dispose();
		for (int i = 0; i < optionDescriptions.size(); i++)
			if (optionDescriptions.get(i) != null)
				optionDescriptions.get(i).dispose();
		for (int i = 0; i < optionUseCaseLinksAbstract.size(); i++)
			if (optionUseCaseLinksAbstract.get(i) != null)
				optionUseCaseLinksAbstract.get(i).dispose();
		for (int i = 0; i < optionUseCaseLinks.size(); i++)
			if (optionUseCaseLinks.get(i) != null)
				optionUseCaseLinks.get(i).dispose();

		topButtonDragArea.dispose();
		topButtonPanel.dispose();
		optionsPanel.dispose();
		mainComposite.dispose();

		super.dispose();
	}

	/**
	 * Sets context information for the actor step
	 */
	public void setContext(UseCase parentUseCase, int position, FlowOfEventsControl parentControl) {
		this.parentUseCase = parentUseCase;
		this.position = position;
		this.parentControl = parentControl;
		initControl();
	}

	/**
	 * Initializes components of the actor step, once the context is set
	 */
	private void initControl() {

		// create first actor choice if there is none
		if (((ActorStep) getModelElement()).getOptions().size() == 0) {
			new UnicaseCommand() {
				@Override
				protected void doRun() {
					UsecaseFactory uFactory = UsecaseFactoryImpl.init();
					Option o = uFactory.createOption();
					parentUseCase.getProject().addModelElement(o);
					o.setName("New Option");
					o.setSourceStep((ActorStep) getModelElement());
					o.setTargetStep(null);

					OptionAdapter a = new OptionAdapter();
					o.eAdapters().add(a);

					EList<Option> optionList = ((ActorStep) getModelElement()).getOptions();
					optionList.add(o);
				}
			}.run();
		}

		// create name field
		stepNumber.setText("# " + String.valueOf(position));

		if (addStepAbove != null)
			addStepAbove.dispose();
		addStepAbove = getToolkit().createImageHyperlink(topButtonPanel, style);
		addStepAbove.addHyperlinkListener(new NewActorStepHyperlink(position - 1));
		addStepAbove.setBackground(standardColor);
		final Image AddStepAboveImage = org.unicase.ui.common.Activator.imageDescriptorFromPlugin(PLUGIN_ID,
			ADDABOVE_ICON).createImage();
		addStepAbove.setImage(AddStepAboveImage);
		addStepAbove.setBackground(standardColor);
		addStepAbove.addDisposeListener(new DisposeListener() {
			public void widgetDisposed(DisposeEvent e) {
				AddStepAboveImage.dispose();
			}
		});
		addStepAbove.setToolTipText("Add step above");

		deleteStep = getToolkit().createImageHyperlink(topButtonPanel, style);
		deleteStep.addHyperlinkListener(new DeleteActorStepHyperlink(position));
		deleteStep.setImage(PlatformUI.getWorkbench().getSharedImages().getImage(ISharedImages.IMG_TOOL_DELETE));
		deleteStep.setBackground(standardColor);
		deleteStep.setToolTipText("Delete this step");

		topButtonPanel.layout();

		initOptions();
		mainComposite.layout();
	}

	/**
	 * Initializes and updates options
	 */
	private void initOptions() {

		for (int i = 0; i < optionDescriptionsAbstract.size(); i++)
			if (optionDescriptionsAbstract.get(i) != null)
				optionDescriptionsAbstract.get(i).dispose();
		for (int i = 0; i < optionDescriptions.size(); i++)
			if (optionDescriptions.get(i) != null)
				optionDescriptions.get(i).dispose();
		for (int i = 0; i < optionUseCaseLinksAbstract.size(); i++)
			if (optionUseCaseLinksAbstract.get(i) != null)
				optionUseCaseLinksAbstract.get(i).dispose();
		for (int i = 0; i < optionUseCaseLinks.size(); i++)
			if (optionUseCaseLinks.get(i) != null)
				optionUseCaseLinks.get(i).dispose();
		if (options != null)
			options.dispose();
		if (addOption != null) {
			addOption.removeHyperlinkListener(optionHyperlinkListener);
			addOption.dispose();
		}
		if (optionComposites != null)
			optionComposites.clear();

		if (((ActorStep) getModelElement()).getOptions().size() >= 1) {
			options = getToolkit().createComposite(optionsPanel);
			GridLayout grid_options = new GridLayout(1, true);
			GridData gridData_options = new GridData(SWT.FILL, SWT.BEGINNING, true, true);
			grid_options.horizontalSpacing = 0;
			grid_options.marginHeight = 0;
			grid_options.marginWidth = 0;
			grid_options.verticalSpacing = 0;
			gridData_options.grabExcessVerticalSpace = true;
			gridData_options.grabExcessHorizontalSpace = true;
			options.setLayout(grid_options);
			options.setLayoutData(gridData_options);
		}

		AdapterFactoryItemDelegator adapterFactoryItemDelegator = new AdapterFactoryItemDelegator(
			new ComposedAdapterFactory(ComposedAdapterFactory.Descriptor.Registry.INSTANCE));
		ControlFactory controlFactory = new ControlFactory(getEditingDomain(), getToolkit());

		for (int i = 0; i < ((ActorStep) getModelElement()).getOptions().size(); i++) {

			Option currentOption = ((ActorStep) getModelElement()).getOptions().get(i);
			Composite option1 = getToolkit().createComposite(options);
			GridLayout grid_option = new GridLayout(2, false);
			grid_option.horizontalSpacing = 0;
			grid_option.marginLeft = 0;
			grid_option.marginWidth = 0;
			grid_option.marginHeight = 2;
			GridData gridData_option = new GridData(SWT.FILL, SWT.BEGINNING, true, true);
			gridData_option.grabExcessHorizontalSpace = true;
			option1.setLayout(grid_option);
			option1.setLayoutData(gridData_option);
			option1.setBackground(standardColor);

			Composite optionDescriptionComposite = getToolkit().createComposite(option1);
			GridLayout grid_optionDescriptionComposite = new GridLayout();
			grid_optionDescriptionComposite.marginHeight = 0;
			GridData gridData_optionDescription = new GridData(300, 55);
			gridData_optionDescription.grabExcessHorizontalSpace = true;
			optionDescriptionComposite.setLayout(grid_optionDescriptionComposite);
			optionDescriptionComposite.setLayoutData(gridData_optionDescription);

			optionDescriptionComposite.setBackground(standardColor);

			Composite optionButtonComposite = getToolkit().createComposite(option1);
			GridLayout grid_deleteOptionComposite = new GridLayout();
			grid_deleteOptionComposite.marginHeight = 0;
			grid_deleteOptionComposite.marginWidth = 0;
			grid_deleteOptionComposite.horizontalSpacing = 0;
			grid_deleteOptionComposite.verticalSpacing = 0;
			optionButtonComposite.setLayout(grid_deleteOptionComposite);
			optionButtonComposite.setBackground(signalColor1);

			Composite linkUseCaseComposite = getToolkit().createComposite(option1);
			GridLayout grid_linkUseCaseComposite = new GridLayout();
			grid_linkUseCaseComposite.marginHeight = 0;
			grid_linkUseCaseComposite.marginWidth = 0;
			grid_linkUseCaseComposite.horizontalSpacing = 0;
			grid_linkUseCaseComposite.verticalSpacing = 0;
			linkUseCaseComposite.setLayout(grid_linkUseCaseComposite);
			linkUseCaseComposite.setBackground(standardColor);

			if (currentOption.getTargetStep() == null) {
				ImageHyperlink linkOption = getToolkit().createImageHyperlink(optionButtonComposite, style);
				linkOption.addHyperlinkListener(new LinkOptionHyperlink(currentOption));
				final Image linkOptionImage = org.unicase.ui.common.Activator.imageDescriptorFromPlugin(PLUGIN_ID,
					LINK_ICON).createImage();
				linkOption.setImage(linkOptionImage);
				linkOption.setBackground(standardColor);
				linkOption.addDisposeListener(new DisposeListener() {
					public void widgetDisposed(DisposeEvent e) {
						linkOptionImage.dispose();
					}
				});
			} else {
				ImageHyperlink unlinkOption = getToolkit().createImageHyperlink(optionButtonComposite, style);
				unlinkOption.addHyperlinkListener(new DeleteLinkOptionHyperlink(currentOption));
				final Image linkOptionImage = org.unicase.ui.common.Activator.imageDescriptorFromPlugin(PLUGIN_ID,
					UNLINK_ICON).createImage();
				unlinkOption.setImage(linkOptionImage);
				unlinkOption.setBackground(standardColor);
				unlinkOption.addDisposeListener(new DisposeListener() {
					public void widgetDisposed(DisposeEvent e) {
						linkOptionImage.dispose();
					}
				});

			}

			if (i > 0 || ((ActorStep) getModelElement()).getOptions().size() > 1) {
				// create delete Option Hyperlink
				ImageHyperlink deleteOption = getToolkit().createImageHyperlink(optionButtonComposite, style);
				deleteOption.addHyperlinkListener(new DeleteOptionHyperlink(i));
				deleteOption.setImage(PlatformUI.getWorkbench().getSharedImages().getImage(
					ISharedImages.IMG_TOOL_DELETE));
				deleteOption.setBackground(standardColor);
			}

			// create description field of option
			IItemPropertyDescriptor propertyDescriptor_option = adapterFactoryItemDelegator.getPropertyDescriptor(
				currentOption, "description");
			AbstractMEControl optionDescriptionAbstract = controlFactory.createControl(propertyDescriptor_option,
				currentOption);
			Control optionDescription = optionDescriptionAbstract.createControl(optionDescriptionComposite, style,
				propertyDescriptor_option, currentOption, getEditingDomain(), getToolkit());
			// optionDescription.setLayoutData(new GridData(SWT.FILL,SWT.TOP,true,true));
			optionDescription.setBackground(standardColor);
			optionDescription.setLayoutData(new GridData(SWT.FILL, SWT.TOP, true, true));

			optionDescriptionComposite.layout();

			optionDescriptionsAbstract.add(optionDescriptionAbstract);
			optionDescriptions.add(optionDescription);

			// create link use case control
			IItemPropertyDescriptor propertyDescriptor_linkUseCase = adapterFactoryItemDelegator.getPropertyDescriptor(
				currentOption, "includedUseCase");
			AbstractMEControl linkUseCaseAbstract = controlFactory.createControl(propertyDescriptor_linkUseCase,
				currentOption);
			Control linkUseCase = linkUseCaseAbstract.createControl(linkUseCaseComposite, style,
				propertyDescriptor_linkUseCase, currentOption, getEditingDomain(), getToolkit());

			linkUseCase.setBackground(standardColor);

			optionUseCaseLinksAbstract.add(linkUseCaseAbstract);
			optionUseCaseLinks.add(linkUseCase);

			option1.layout();
			optionComposites.add(optionButtonComposite);

		}

		if (((ActorStep) getModelElement()).getOptions().size() >= 1) {
			options.pack(true);
		}

		addOption = getToolkit().createImageHyperlink(optionsPanel, style);
		addOption.addHyperlinkListener(optionHyperlinkListener);

		final Image addOptionImage = org.unicase.ui.common.Activator.imageDescriptorFromPlugin(PLUGIN_ID, ADD_ICON)
			.createImage();
		addOption.setImage(addOptionImage);
		addOption.setBackground(standardColor);
		addOption.setToolTipText("Add Actor Choice");
		addOption.addDisposeListener(new DisposeListener() {
			public void widgetDisposed(DisposeEvent e) {
				addOptionImage.dispose();
			}
		});

		// optionsPanel.pack(true);
		optionsPanel.layout();

		// mainComposite.pack(true);
		mainComposite.layout();

		// parentComposite.pack(true);
		parentComposite.layout();
		parentControl.checkSize();

	}

	/**
	 * Determines the relative location of an option to the FlowOfEventsArea
	 */
	public List<Point> getOptionLocations() {
		locations.clear();
		for (int i = 0; i < optionComposites.size(); i++) {
			Composite option = optionComposites.get(i);
			Point location = new Point(0, 0);

			location = border.getLocation();
			location.y += mainComposite.getLocation().y;
			location.x += mainComposite.getLocation().x;
			location.y += optionsPanel.getLocation().y;
			location.x += optionsPanel.getLocation().x;
			location.y += options.getLocation().y;
			location.x += options.getLocation().x;
			location.y += option.getParent().getLocation().y;
			location.x += option.getParent().getLocation().x;
			location.y += option.getLocation().y;
			location.x += option.getLocation().x;
			locations.add(location);
		}

		return locations;
	}

	/**
	 * Determines the relative position of the whole Actor Step to the FlowOfEventsArea
	 */
	public Point getStepLocation() {
		Point location = new Point(0, 0);
		location = border.getLocation();
		location.x += border.getBounds().width;
		return location;
	}

	/**
	 * Sets a variable in the use case, thereby forcing it to be updated
	 */
	private void sync() {
		new UnicaseCommand() {
			@Override
			protected void doRun() {
				parentUseCase.setSync("syncX");
			}
		}.run();
	}
}
