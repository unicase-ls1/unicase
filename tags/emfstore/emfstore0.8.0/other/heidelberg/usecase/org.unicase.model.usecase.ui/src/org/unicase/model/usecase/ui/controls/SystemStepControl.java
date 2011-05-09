package org.unicase.model.usecase.ui.controls;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.impl.AdapterImpl;

import org.unicase.model.UnicaseModelElement;
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
import org.eclipse.swt.widgets.Label;
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
 * @brief Renders a single system step.
 */
public class SystemStepControl extends AbstractMEControl {

	/**
	 * Listens to delete system step hyperlink
	 */
	private final class DeleteSystemStepHyperlink implements IHyperlinkListener {

		private int position;

		private DeleteSystemStepHyperlink(int position) {
			this.position = position;
		}

		public void linkActivated(HyperlinkEvent e) {

			new UnicaseCommand() {
				@Override
				protected void doRun() {

					if (((SystemStep) getModelElement()).getIncludedSystemFunction() != null)
						((SystemStep) getModelElement()).setIncludedSystemFunction(null);

					for (int i = 0; i < parentUseCase.getSystemSteps().size(); i++) {
						if (parentUseCase.getSystemSteps().get(i).getLinkedStep() != null
							&& parentUseCase.getSystemSteps().get(i).getLinkedStep().equals(
								(UnicaseModelElement) getModelElement()))
							parentUseCase.getSystemSteps().get(i).setLinkedStep(null);
					}
					for (int i = 0; i < parentUseCase.getActorSteps().size(); i++) {
						for (int j = 0; j < parentUseCase.getActorSteps().get(i).getOptions().size(); j++) {
							if (parentUseCase.getActorSteps().get(i).getOptions().get(j).getTargetStep() != null
								&& parentUseCase.getActorSteps().get(i).getOptions().get(j).getTargetStep().equals(
									(UnicaseModelElement) getModelElement()))
								parentUseCase.getActorSteps().get(i).getOptions().get(j).setTargetStep(null);
						}
					}

					EList<SystemStep> systemStepList = parentUseCase.getSystemSteps();
					SystemStep toBeRemoved;
					if (position <= systemStepList.size()) {
						toBeRemoved = systemStepList.remove(position - 1);
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
	 * Listens to link system step hyperlink
	 */
	private final class LinkStepHyperlink implements IHyperlinkListener {

		public void linkActivated(HyperlinkEvent e) {
			parentControl.setLinkMode(true, true);
			parentControl.setSourceElement((UnicaseModelElement) getModelElement());
		}

		public void linkEntered(HyperlinkEvent e) {
		}

		public void linkExited(HyperlinkEvent e) {
		}
	}

	/**
	 * Listens to delete link hyperlink
	 */
	private final class UnlinkStepHyperlink implements IHyperlinkListener {

		public void linkActivated(HyperlinkEvent e) {

			new UnicaseCommand() {
				@Override
				protected void doRun() {
					((SystemStep) getModelElement()).setLinkedStep(null);
				}
			}.run();
			initControl();
			sync();
		}

		public void linkEntered(HyperlinkEvent e) {
		}

		public void linkExited(HyperlinkEvent e) {
		}
	}

	/**
	 * HyperLink listener class to add system step hyperlink. Modification of IHyperlinkListenerImplementation in
	 * UseCaseStepsControl.java in package org.unicase.ui.unicasecommon.meeditor.mecontrols.uccontrol due to authors
	 * lars & helming
	 */
	private final class NewSystemStepHyperlink implements IHyperlinkListener {
		private final int position;

		private NewSystemStepHyperlink(int position) {
			this.position = position;
		}

		public void linkActivated(HyperlinkEvent e) {
			new UnicaseCommand() {
				@Override
				protected void doRun() {
					UsecaseFactory uFactory = UsecaseFactoryImpl.init();
					SystemStep p = uFactory.createSystemStep();
					parentUseCase.getProject().addModelElement(p);
					p.setName("New System Step");
					EList<SystemStep> systemStepList = parentUseCase.getSystemSteps();
					if (position == -1) {
						systemStepList.add(p);
					} else {
						systemStepList.add(position, p);
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
	 * Detects mouse hover over this step. Indicates that this step is valid link target with a red border around this
	 * step
	 */
	private final class LinkByMouseListener implements MouseTrackListener {

		public void mouseEnter(MouseEvent e) {
			boolean eligibleTarget = parentControl.getLinkMode();
			if (eligibleTarget && parentControl.getSystemStepLinkSource())
				if (parentControl.getSourceElement().equals((UnicaseModelElement) getModelElement()))
					eligibleTarget = false;
			if (eligibleTarget)
				border.setBackground(signalColor1);
		}

		public void mouseExit(MouseEvent e) {
			border.setBackground(standardColor);
		}

		public void mouseHover(MouseEvent e) {
			// TODO Auto-generated method stub
		}
	}

	/**
	 * Listens to mouse click event to create a link ending at this step, if this step is a valid target
	 */
	private final class CreateLinkByMouseListener implements MouseListener {

		public void mouseDoubleClick(MouseEvent e) {
			// TODO Auto-generated method stub

		}

		public void mouseDown(MouseEvent e) {
			boolean eligibleTarget = parentControl.getLinkMode();
			if (parentControl.getSystemStepLinkSource())
				if (parentControl.getSourceElement().equals((UnicaseModelElement) getModelElement()))
					eligibleTarget = false;
			if (eligibleTarget) {
				if (parentControl.getSystemStepLinkSource()) {
					new UnicaseCommand() {
						@Override
						protected void doRun() {
							SystemStep toBeLinked = (SystemStep) parentControl.getSourceElement();
							toBeLinked.setLinkedStep((UnicaseModelElement) getModelElement());
						}
					}.run();
				} else {
					new UnicaseCommand() {
						@Override
						protected void doRun() {
							Option toBeLinked = parentControl.getSourceOption();
							toBeLinked.setTargetStep((UnicaseModelElement) getModelElement());
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
			parentControl.setDragMode(true, false, position);
		}
	}

	// icon image path
	private static final String PLUGIN_ID = "org.unicase.model.usecase.ui";
	private static final String LINK_ICON = "icons/linkOption.png";
	private static final String UNLINK_ICON = "icons/unlinkOption.png";
	private static final String ADDABOVE_ICON = "icons/addAbove.png";

	// context information
	private FlowOfEventsControl parentControl;
	private UseCase parentUseCase;
	private int style;
	private int position = 1;

	// composites forming the actor step
	private Composite border;
	private Composite mainComposite;
	private Composite topButtonPanel;
	private Composite topButtonDragArea;
	private Composite descriptionPanel;
	private Composite linkButtonPanel;
	private Composite exceptionPanel;
	private Composite linkSystemFunctionPanel;

	// other GUI Elements
	private ImageHyperlink deleteStep;
	private ImageHyperlink addStepAbove;
	private Text stepNumber;
	private AbstractMEControl descriptionAbstract;
	private Control description;
	private AbstractMEControl exceptionAbstract;
	private Control exception;
	private AbstractMEControl includedSystemFunctionAbstract;
	private Control includedSystemFunction;
	private ImageHyperlink linkStep;

	private AdapterImpl includeAdapter;

	private Color standardColor;
	private Color colorRed;
	private Color signalColor1;

	@Override
	public int canRender(IItemPropertyDescriptor itemPropertyDescriptor, ModelElement modelElement) {
		// Actor Step control shall only be called explicitly
		return DO_NOT_RENDER;
	}

	/**
	 * Renders actor step
	 */
	@Override
	protected Control createControl(Composite parent, int style) {

		this.style = style;

		border = getToolkit().createComposite(parent);
		standardColor = new Color(border.getDisplay().getCurrent(), 153, 204, 255);
		border.setBackground(standardColor);
		border.setLayout(new GridLayout(1, true));
		border.setLayoutData(new GridData(SWT.BEGINNING, SWT.TOP, false, true));
		border.addMouseTrackListener(new LinkByMouseListener());
		border.addMouseListener(new CreateLinkByMouseListener());

		mainComposite = getToolkit().createComposite(border);
		colorRed = new Color(mainComposite.getDisplay().getCurrent(), 255, 204, 204);
		signalColor1 = mainComposite.getDisplay().getSystemColor(SWT.COLOR_RED);
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

		descriptionPanel = getToolkit().createComposite(mainComposite);
		descriptionPanel.setBackground(standardColor);
		GridLayout grid_description = new GridLayout(2, false);
		GridData gridData_description = new GridData(320, 55);
		grid_description.horizontalSpacing = 0;
		grid_description.verticalSpacing = 0;
		grid_description.marginHeight = 0;
		grid_description.marginWidth = 0;
		gridData_description.verticalAlignment = SWT.TOP;
		descriptionPanel.setLayout(grid_description);
		descriptionPanel.setLayoutData(gridData_description);

		linkButtonPanel = getToolkit().createComposite(descriptionPanel);
		linkButtonPanel.setBackground(standardColor);
		GridLayout grid_linkButton = new GridLayout(1, false);
		grid_linkButton.horizontalSpacing = 0;
		grid_linkButton.verticalSpacing = 0;
		grid_linkButton.marginHeight = 0;
		grid_linkButton.marginWidth = 0;
		GridData gridData_linkButton = new GridData(30, 55);
		linkButtonPanel.setLayout(grid_linkButton);
		linkButtonPanel.setLayoutData(gridData_linkButton);

		exceptionPanel = getToolkit().createComposite(mainComposite);
		exceptionPanel.setBackground(standardColor);
		GridLayout grid_exception = new GridLayout(2, false);
		GridData gridData_exception = new GridData(300, 30);
		gridData_description.verticalAlignment = SWT.TOP;
		exceptionPanel.setLayout(grid_exception);
		exceptionPanel.setLayoutData(gridData_exception);
		exceptionPanel.setBounds(0, 0, 300, 30);
		exceptionPanel.layout();

		linkSystemFunctionPanel = getToolkit().createComposite(mainComposite);
		linkSystemFunctionPanel.setBackground(standardColor);
		linkSystemFunctionPanel.setLayout(new GridLayout(1, true));

		stepNumber = new Text(topButtonPanel, style);
		stepNumber.setEditable(false);
		topButtonDragArea = getToolkit().createComposite(topButtonPanel);
		topButtonDragArea.setLayout(new GridLayout());
		topButtonDragArea.setLayoutData(new GridData(230, 20));
		topButtonDragArea.setBackground(standardColor);
		topButtonDragArea.addDragDetectListener(new StepDragDetectListener());

		mainComposite.pack();
		mainComposite.layout(true);
		return border;
	}

	@Override
	public void dispose() {

		((SystemStep) getModelElement()).eAdapters().remove(includeAdapter);

		if (descriptionAbstract != null)
			descriptionAbstract.dispose();
		if (exceptionAbstract != null)
			exceptionAbstract.dispose();
		if (includedSystemFunctionAbstract != null)
			includedSystemFunctionAbstract.dispose();
		if (linkStep != null)
			linkStep.dispose();

		topButtonPanel.dispose();
		descriptionPanel.dispose();
		linkSystemFunctionPanel.dispose();
		mainComposite.dispose();

		super.dispose();
	}

	/**
	 * Sets context information for this system step
	 */
	public void setContext(UseCase parentUseCase, int position, FlowOfEventsControl parentControl) {
		this.parentUseCase = parentUseCase;
		this.position = position;
		this.parentControl = parentControl;
		final UseCase parentUseCase_f = parentUseCase;

		includeAdapter = new AdapterImpl() {
			@Override
			public void notifyChanged(Notification msg) {
				if (msg.getFeature() instanceof EReference
					&& ((EReference) msg.getFeature()).getName() == "includedSystemFunction" && msg.getEventType() == 1) {
					parentUseCase_f.eNotify(msg);
				}

			}
		};
		((SystemStep) getModelElement()).eAdapters().add(includeAdapter);

		initControl();
	}

	/**
	 * Initializes components of system step, once the context is set
	 */
	private void initControl() {

		AdapterFactoryItemDelegator adapterFactoryItemDelegator = new AdapterFactoryItemDelegator(
			new ComposedAdapterFactory(ComposedAdapterFactory.Descriptor.Registry.INSTANCE));
		ControlFactory controlFactory = new ControlFactory(getEditingDomain(), getToolkit());

		// create name field
		stepNumber.setText("# " + String.valueOf(position));

		if (addStepAbove != null)
			addStepAbove.dispose();
		addStepAbove = getToolkit().createImageHyperlink(topButtonPanel, style);
		addStepAbove.addHyperlinkListener(new NewSystemStepHyperlink(position - 1));
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

		if (deleteStep != null)
			deleteStep.dispose();
		deleteStep = getToolkit().createImageHyperlink(topButtonPanel, style);
		deleteStep.addHyperlinkListener(new DeleteSystemStepHyperlink(position));
		deleteStep.setImage(PlatformUI.getWorkbench().getSharedImages().getImage(ISharedImages.IMG_TOOL_DELETE));
		deleteStep.setBackground(standardColor);
		deleteStep.setToolTipText("Delete this step");

		topButtonPanel.layout();

		// create description field
		if (descriptionAbstract != null)
			descriptionAbstract.dispose();
		if (description != null)
			description.dispose();
		IItemPropertyDescriptor propertyDescriptor_description = adapterFactoryItemDelegator.getPropertyDescriptor(
			getModelElement(), "description");
		descriptionAbstract = controlFactory.createControl(propertyDescriptor_description, getModelElement());
		description = descriptionAbstract.createControl(descriptionPanel, style, propertyDescriptor_description,
			getModelElement(), getEditingDomain(), getToolkit());
		description.setLayoutData(new GridData(SWT.FILL, SWT.TOP, true, true));
		description.setBackground(standardColor);
		descriptionPanel.layout();

		if (linkStep != null)
			linkStep.dispose();
		linkStep = getToolkit().createImageHyperlink(linkButtonPanel, style);
		if (((SystemStep) getModelElement()).getLinkedStep() == null) {
			final Image linkOptionImage = org.unicase.ui.common.Activator.imageDescriptorFromPlugin(PLUGIN_ID,
				LINK_ICON).createImage();
			linkStep.setImage(linkOptionImage);
			linkStep.setBackground(standardColor);
			linkStep.addDisposeListener(new DisposeListener() {
				public void widgetDisposed(DisposeEvent e) {
					linkOptionImage.dispose();
				}
			});
			linkStep.addHyperlinkListener(new LinkStepHyperlink());
		} else {
			final Image linkOptionImage = org.unicase.ui.common.Activator.imageDescriptorFromPlugin(PLUGIN_ID,
				UNLINK_ICON).createImage();
			linkStep.setImage(linkOptionImage);
			linkStep.setBackground(standardColor);
			linkStep.addDisposeListener(new DisposeListener() {
				public void widgetDisposed(DisposeEvent e) {
					linkOptionImage.dispose();
				}
			});
			linkStep.addHyperlinkListener(new UnlinkStepHyperlink());
		}

		linkButtonPanel.layout();

		// create exception field
		if (exceptionAbstract != null)
			exceptionAbstract.dispose();
		Label exceptionLabel = getToolkit().createLabel(exceptionPanel, "Exception ");
		exceptionLabel.setBackground(standardColor);
		IItemPropertyDescriptor propertyDescriptor_exception = adapterFactoryItemDelegator.getPropertyDescriptor(
			getModelElement(), "exception");
		exceptionAbstract = controlFactory.createControl(propertyDescriptor_exception, getModelElement());
		exception = exceptionAbstract.createControl(exceptionPanel, style, propertyDescriptor_exception,
			getModelElement(), getEditingDomain(), getToolkit());
		exception.setBackground(colorRed);
		exception.setLayoutData(new GridData(SWT.FILL, SWT.TOP, true, true));

		exceptionPanel.layout();

		IItemPropertyDescriptor propertyDescriptor_systemFunction = adapterFactoryItemDelegator.getPropertyDescriptor(
			getModelElement(), "includedSystemFunction");

		if (includedSystemFunctionAbstract != null)
			includedSystemFunctionAbstract.dispose();

		includedSystemFunctionAbstract = controlFactory.createControl(propertyDescriptor_systemFunction,
			getModelElement());
		includedSystemFunction = includedSystemFunctionAbstract.createControl(linkSystemFunctionPanel, style,
			propertyDescriptor_systemFunction, getModelElement(), getEditingDomain(), getToolkit());
		includedSystemFunction.setBackground(standardColor);

		mainComposite.layout();
	}

	/**
	 * Determines the relative position of the whole System Step to the FlowOfEventsArea
	 */
	public Point getStepLocation() {
		Point location = new Point(0, 0);
		location = border.getLocation();
		return location;
	}

	/**
	 * Returns the location of the link Button needed by the Flow of Events Painter
	 */
	public Point getLinkButtonLocation() {
		Point location = new Point(0, 0);
		location = linkButtonPanel.getLocation();
		location.x += descriptionPanel.getLocation().x;
		location.y += descriptionPanel.getLocation().y;
		location.x += mainComposite.getLocation().x;
		location.y += mainComposite.getLocation().y;
		location.x += border.getLocation().x;
		location.y += border.getLocation().y;

		return location;
	}

	/**
	 * Sets a variable in the flow of events, forcing it to be redrawn
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
