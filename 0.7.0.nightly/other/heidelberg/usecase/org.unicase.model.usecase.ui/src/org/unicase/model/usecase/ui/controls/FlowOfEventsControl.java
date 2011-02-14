package org.unicase.model.usecase.ui.controls;

import org.eclipse.draw2d.ColorConstants;
import org.eclipse.swt.events.MouseEvent;
import org.eclipse.swt.events.MouseListener;
import org.eclipse.swt.events.PaintEvent;
import org.eclipse.swt.events.PaintListener;
import java.util.ArrayList;
import java.util.List;
import java.lang.Math;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.impl.AdapterImpl;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.edit.provider.AdapterFactoryItemDelegator;
import org.eclipse.emf.edit.provider.ComposedAdapterFactory;
import org.eclipse.emf.edit.provider.IItemPropertyDescriptor;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.swt.SWT;
import org.eclipse.swt.graphics.Color;
import org.eclipse.swt.graphics.Cursor;
import org.eclipse.swt.graphics.Device;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.graphics.Point;
import org.eclipse.swt.graphics.Rectangle;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.ui.forms.events.HyperlinkEvent;
import org.eclipse.ui.forms.events.IHyperlinkListener;
import org.eclipse.ui.forms.widgets.Hyperlink;
import org.eclipse.ui.forms.widgets.ScrolledForm;
import org.unicase.metamodel.ModelElement;
import org.unicase.ui.meeditor.mecontrols.AbstractMEControl;
import org.unicase.workspace.Configuration;
import org.unicase.workspace.util.UnicaseCommand;
import org.unicase.model.UnicaseModelElement;
import org.unicase.model.requirement.SystemFunction;
import org.unicase.model.usecase.ActorStep;
import org.unicase.model.usecase.Option;
import org.unicase.model.usecase.SystemStep;
import org.unicase.model.usecase.UseCase;
import org.unicase.model.usecase.UsecaseFactory;
import org.unicase.model.usecase.impl.UsecaseFactoryImpl;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;

/**
 * @author phil
 * @brief Provides a gui for editing the flow of events of an use case. This code is a modification and extension of
 *        UseCaseStepsControl in package org.unicase.ui.unicasecommon.meeditor.mecontrols.uccontrol.
 */
public class FlowOfEventsControl extends AbstractMEControl {

	// icon image path
	private static final String PLUGIN_ID = "org.unicase.model.usecase.ui";
	private static final String LINKCURSOR_ICON = "icons/linkCursor.png";

	// The main area which contains actor and system steps as well as the graphical links
	private Composite mainComposite;
	// The area where the actor steps, system steps and their links are drawn
	private Composite flowOfEventsArea;

	// Variables needed to synchronize changes in the flow of events with
	// the model element itself.(compare to private method synchronize())
	private IItemPropertyDescriptor descriptor;
	private AdapterImpl systemStepAdapter;

	// Hyperlinks to add actor or system Steps
	private Hyperlink addActorStep;
	private Hyperlink addSystemStep;

	// The use case itself
	private UseCase usecase;
	// Actor and system step controls
	private List<ActorStepControl> actorStepControls = new ArrayList<ActorStepControl>();
	private List<SystemStepControl> systemStepControls = new ArrayList<SystemStepControl>();

	// State variables needed for linking options
	private Option sourceOption;
	private boolean linkMode = false;
	private UnicaseModelElement sourceElement;
	private boolean linkFromSystemStep = false;

	// state variables for drag and drop
	private boolean dragMode = false;
	private boolean dragStep = false;
	private int dragPosition = 0;
	private List<Point> actorPositions = new ArrayList<Point>();
	private List<Point> systemPositions = new ArrayList<Point>();

	private Cursor standardCursor;
	private Cursor linkCursor;
	private Image linkCursorImage;

	private Color colorSignal3;

	private Composite parentComposite;
	private ScrolledForm parentForm;

	private Composite mainPanelComposite;
	private Composite sidePanelComposite;

	/**
	 * Paints links between steps
	 */
	private class FlowOfEventsPainter implements PaintListener {

		private List<List<Point>> actorOptionPositions = new ArrayList<List<Point>>();
		private List<Point> actorStepPositions = new ArrayList<Point>();
		private List<Point> systemOptionPositions = new ArrayList<Point>();
		private List<Point> systemStepPositions = new ArrayList<Point>();

		private int verticalOffset = 10;
		private int hShift = 15;
		private PaintEvent e;

		public void paintControl(PaintEvent e) {

			checkSize();

			this.e = e;

			actorOptionPositions.clear();
			actorStepPositions.clear();
			systemOptionPositions.clear();
			systemStepPositions.clear();

			// get positions of all Actor Steps and nested options
			for (int j = 0; j < actorStepControls.size(); j++) {
				List<Point> locations = new ArrayList<Point>();
				locations.clear();
				locations = actorStepControls.get(j).getOptionLocations();

				actorOptionPositions.add(j, locations);
				actorStepPositions.add(actorStepControls.get(j).getStepLocation());
			}

			// get positions of all System Steps and nested options
			for (int j = 0; j < systemStepControls.size(); j++) {
				List<Point> locations = new ArrayList<Point>();
				locations.clear();
				systemOptionPositions.add(systemStepControls.get(j).getLinkButtonLocation());
				systemStepPositions.add(systemStepControls.get(j).getStepLocation());
			}

			actorPositions.clear();
			actorPositions.addAll(actorStepPositions);
			systemPositions.clear();
			systemPositions.addAll(systemStepPositions);

			// Actor Steps
			for (int i = 0; i < ((UseCase) getModelElement()).getActorSteps().size(); i++) {
				for (int j = 0; j < ((UseCase) getModelElement()).getActorSteps().get(i).getOptions().size(); j++) {
					if (((UseCase) getModelElement()).getActorSteps().get(i).getOptions().get(j).getTargetStep() != null) {

						boolean actorActorLink = (ActorStep.class.isInstance(((UseCase) getModelElement())
							.getActorSteps().get(i).getOptions().get(j).getTargetStep()));
						int target;
						if (actorActorLink) {
							target = ((UseCase) getModelElement()).getActorSteps().indexOf(
								((UseCase) getModelElement()).getActorSteps().get(i).getOptions().get(j)
									.getTargetStep());
						} else {
							target = ((UseCase) getModelElement()).getSystemSteps().indexOf(
								((UseCase) getModelElement()).getActorSteps().get(i).getOptions().get(j)
									.getTargetStep());
						}

						if (actorActorLink) {
							if (i < actorOptionPositions.size() && j < actorOptionPositions.get(i).size()
								&& target < actorStepPositions.size() && target >= 0) {
								drawLink(actorOptionPositions.get(i).get(j), actorStepPositions.get(target), target,
									false);
							}
						} else {
							if (i < actorOptionPositions.size() && j < actorOptionPositions.get(i).size()
								&& target < systemStepPositions.size() && target >= 0) {
								drawLink(actorOptionPositions.get(i).get(j), systemStepPositions.get(target), target,
									true);
							}
						}
					}
				}
			}

			// System Steps
			for (int i = 0; i < ((UseCase) getModelElement()).getSystemSteps().size(); i++) {

				if (((UseCase) getModelElement()).getSystemSteps().get(i).getLinkedStep() != null) {

					boolean systemSystemLink = (SystemStep.class.isInstance(((UseCase) getModelElement())
						.getSystemSteps().get(i).getLinkedStep()));
					int target;
					if (systemSystemLink) {
						target = ((UseCase) getModelElement()).getSystemSteps().indexOf(
							((UseCase) getModelElement()).getSystemSteps().get(i).getLinkedStep());
					} else {
						target = ((UseCase) getModelElement()).getActorSteps().indexOf(
							((UseCase) getModelElement()).getSystemSteps().get(i).getLinkedStep());
					}

					if (systemSystemLink) {
						if (i < systemOptionPositions.size() && target < systemStepPositions.size() && target >= 0) {
							drawLink(systemOptionPositions.get(i), systemStepPositions.get(target), target, true);
						}
					} else {
						if (i < systemOptionPositions.size() && target < actorStepPositions.size() && target >= 0) {
							drawLink(systemOptionPositions.get(i), actorStepPositions.get(target), target, false);
						}
					}

				}
			}

		}

		private void drawLink(Point a, Point b, int target, boolean targetIsRight) {
			Point start = new Point(a.x, a.y);
			Point end = new Point(b.x, b.y);
			if (targetIsRight) {
				this.e.gc.setForeground(ColorConstants.blue);
			} else {
				this.e.gc.setForeground(ColorConstants.red);
			}

			this.e.gc.setLineWidth(1);

			if (targetIsRight) {
				this.e.gc.drawLine(start.x, start.y + verticalOffset, b.x - (target + 1) * hShift, start.y
					+ verticalOffset);
				this.e.gc.drawLine(b.x - (target + 1) * hShift, start.y + verticalOffset, b.x - (target + 1) * hShift,
					end.y + verticalOffset);
				this.e.gc.drawLine(b.x - (target + 1) * hShift, end.y + verticalOffset, end.x, end.y + verticalOffset);
			} else {
				this.e.gc.drawLine(start.x, start.y + verticalOffset, b.x + (target + 1) * hShift, start.y
					+ verticalOffset);
				this.e.gc.drawLine(b.x + (target + 1) * hShift, start.y + verticalOffset, b.x + (target + 1) * hShift,
					end.y + verticalOffset);
				this.e.gc.drawLine(b.x + (target + 1) * hShift, end.y + verticalOffset, end.x, end.y + verticalOffset);
			}

			drawArrow(end, 1, targetIsRight);

		}

		private void drawArrow(Point tip, int orientation, boolean targetIsRight) {

			if (!targetIsRight) {
				// pointing left
				tip.y += verticalOffset;
				this.e.gc.setLineWidth(1);
				this.e.gc.setForeground(ColorConstants.red);
				this.e.gc.setBackground(ColorConstants.red);
				this.e.gc.fillPolygon(new int[] { tip.x, tip.y, tip.x + 5, tip.y + 5, tip.x + 5, tip.y - 5 });
			} else {
				// pointing right
				tip.y += verticalOffset;
				this.e.gc.setLineWidth(1);
				this.e.gc.setForeground(ColorConstants.blue);
				this.e.gc.setBackground(ColorConstants.blue);
				this.e.gc.fillPolygon(new int[] { tip.x, tip.y, tip.x - 5, tip.y + 5, tip.x - 5, tip.y - 5 });
			}
		}
	}

	/**
	 * Listens to mouse behavior, needed get drag target position and reset link mode
	 */
	private final class EndLinkByMouseListener implements MouseListener {

		public void mouseDoubleClick(MouseEvent e) {
			setLinkMode(false, false);

		}

		public void mouseDown(MouseEvent e) {
			// TODO Auto-generated method stub

		}

		public void mouseUp(MouseEvent e) {
			if (dragMode) {
				dragMode = false;
				changeStepOrder(dragPosition, e.y, dragStep);
			}

		}

	}

	/**
	 * Changes the step order in a drag event
	 * 
	 * @param currentPosition position of the step to be moved (in the list)
	 * @param desiredPosition y-position of the mouse pointer (in pixels)
	 * @param step true if step to be moved is actor step
	 */
	private void changeStepOrder(int currentPosition, int desiredPosition, boolean step) {
		if ((step && (currentPosition <= ((UseCase) getModelElement()).getActorSteps().size()))
			|| (!step && (currentPosition <= ((UseCase) getModelElement()).getSystemSteps().size())))
			// actor step
			if (step && currentPosition <= actorPositions.size()) { // actor step
				int desiredY = desiredPosition;
				int dist = 1000;
				int index = 0;
				for (int i = 0; i < actorPositions.size(); i++)
					if (dist >= Math.abs(actorPositions.get(i).y - desiredY)) {
						dist = Math.abs(actorPositions.get(i).y - desiredY);
						index = i;
					}
				final int dest = index;
				final int current = currentPosition - 1;
				if (dest < ((UseCase) getModelElement()).getActorSteps().size()) {
					new UnicaseCommand() {
						@Override
						protected void doRun() {
							((UseCase) getModelElement()).getActorSteps().move(dest, current);
						}
					}.run();
				}
			} else {
				int desiredY = desiredPosition;
				int dist = 1000;
				int index = 0;
				for (int i = 0; i < systemPositions.size(); i++)
					if (dist >= Math.abs(systemPositions.get(i).y - desiredY)) {
						dist = Math.abs(systemPositions.get(i).y - desiredY);
						index = i;
					}
				final int dest = index;
				final int current = currentPosition - 1;
				if (dest < ((UseCase) getModelElement()).getSystemSteps().size()) {
					new UnicaseCommand() {
						@Override
						protected void doRun() {
							((UseCase) getModelElement()).getSystemSteps().move(dest, current);
						}
					}.run();
				}
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
					UseCase uc = (UseCase) getModelElement();
					uc.getProject().addModelElement(p);
					p.setName("New System Step");
					EList<SystemStep> systemStepList = uc.getSystemSteps();
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
					UseCase uc = (UseCase) getModelElement();
					uc.getProject().addModelElement(p);
					p.setName("New Actor Step");
					EList<ActorStep> actorStepList = uc.getActorSteps();
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

	@Override
	public int canRender(IItemPropertyDescriptor itemPropertyDescriptor, ModelElement modelElement) {
		// FlowOfEventsControl shall only be called explicitly, so don't render
		// when called via extension point
		return DO_NOT_RENDER;
	}

	/**
	 * Creates the main widget
	 */
	@Override
	protected Control createControl(Composite parent, int style) {

		this.parentComposite = parent;
		mainComposite = getToolkit().createComposite(parent);
		colorSignal3 = mainComposite.getDisplay().getSystemColor(SWT.COLOR_GRAY);

		// mainComposite.setBackground(bg2);

		GridLayout grid_mainComposite = new GridLayout();
		grid_mainComposite.numColumns = 2;

		mainPanelComposite = getToolkit().createComposite(mainComposite);
		mainPanelComposite.setLayout(new GridLayout());
		// mainPanelComposite.setBackground(colorSignal3);
		mainPanelComposite.setBounds(0, 0, 900, 400);

		sidePanelComposite = getToolkit().createComposite(mainComposite);
		sidePanelComposite.setLayout(new GridLayout(1, false));
		sidePanelComposite.setBackground(colorSignal3);
		sidePanelComposite.setBounds(900, 0, 300, 550);

		usecase = (UseCase) getModelElement();
		descriptor = getItemPropertyDescriptor();

		// Updates flow of events control if a system step is removed.
		systemStepAdapter = new AdapterImpl() {
			@Override
			public void notifyChanged(Notification msg) {

				if (msg.getPosition() != -1 || msg.getNewStringValue() == "syncX")
					updateFlowOfEvents();

				if (msg.getFeature() instanceof EReference
					&& ((EReference) msg.getFeature()).getName() == "includedUseCase") {
					updateFlowOfEvents();
					List<UseCase> usecasesFE = new ArrayList<UseCase>();
					usecasesFE.clear();
					for (int i = 0; i < usecase.getActorSteps().size(); i++)
						for (int j = 0; j < usecase.getActorSteps().get(i).getOptions().size(); j++)
							if (usecase.getActorSteps().get(i).getOptions().get(j).getIncludedUseCase() != null)
								usecasesFE.add(usecase.getActorSteps().get(i).getOptions().get(j).getIncludedUseCase());
					if (msg.getNewValue() == null) {
						if (usecase.getUseCases().contains(msg.getOldValue())
							&& !usecasesFE.contains(msg.getOldValue())) {
							final Object o = msg.getOldValue();
							new UnicaseCommand() {
								@Override
								protected void doRun() {
									usecase.getUseCases().remove((UseCase) o);
								}
							}.run();
						}
					} else {
						if (!usecase.getUseCases().contains(msg.getNewValue())) {
							final Object o = msg.getNewValue();
							new UnicaseCommand() {
								@Override
								protected void doRun() {
									usecase.getUseCases().add((UseCase) o);
								}
							}.run();
						}
					}
				}
				if (msg.getFeature() instanceof EReference
					&& ((EReference) msg.getFeature()).getName() == "includedSystemFunction") {
					// System.out.println(msg);
					updateFlowOfEvents();
					List<SystemFunction> systemFunctionsFE = new ArrayList<SystemFunction>();
					systemFunctionsFE.clear();
					for (int i = 0; i < usecase.getSystemSteps().size(); i++)
						if (usecase.getSystemSteps().get(i).getIncludedSystemFunction() != null)
							systemFunctionsFE.add(usecase.getSystemSteps().get(i).getIncludedSystemFunction());
					if (msg.getNewValue() == null) {
						if (usecase.getSystemFunctions().contains(msg.getOldValue())
							&& !systemFunctionsFE.contains(msg.getOldValue())) {
							final Object o = msg.getOldValue();
							new UnicaseCommand() {
								@Override
								protected void doRun() {
									usecase.getSystemFunctions().remove((SystemFunction) o);
								}
							}.run();
						}
					} else {
						if (!usecase.getSystemFunctions().contains(msg.getNewValue())) {
							final Object o = msg.getNewValue();
							new UnicaseCommand() {
								@Override
								protected void doRun() {
									usecase.getSystemFunctions().add((SystemFunction) o);
								}
							}.run();
						}
					}

				}
			}

		};
		((UseCase) getModelElement()).eAdapters().add(systemStepAdapter);

		// initialize control elements, flowOfEventsArea and hyperlinks
		actorStepControls.clear();
		systemStepControls.clear();
		flowOfEventsArea = getToolkit().createComposite(mainPanelComposite);
		addActorStep = getToolkit().createHyperlink(flowOfEventsArea, "Create Actor Step", SWT.BEGINNING);
		addSystemStep = getToolkit().createHyperlink(flowOfEventsArea, "Create System Step", SWT.BEGINNING);

		// create side panel
		AdapterFactoryItemDelegator adapterFactoryItemDelegator = new AdapterFactoryItemDelegator(
			new ComposedAdapterFactory(ComposedAdapterFactory.Descriptor.Registry.INSTANCE));
		IItemPropertyDescriptor propertyDescriptor = adapterFactoryItemDelegator.getPropertyDescriptor(
			(UseCase) getModelElement(), "actorSteps");
		TransactionalEditingDomain domain = Configuration.getEditingDomain();
		SidePanelControl sidePanelCon = new SidePanelControl();
		Control sidePanel = sidePanelCon.createControl(sidePanelComposite, SWT.WRAP, propertyDescriptor,
			(UseCase) getModelElement(), domain, getToolkit());
		sidePanel.setBounds(5, 5, 290, 540);

		updateFlowOfEvents();

		return mainComposite;
	}

	@Override
	public void dispose() {

		((UseCase) getModelElement()).eAdapters().remove(systemStepAdapter);

		disposeSteps();

		if (!addActorStep.isDisposed())
			addActorStep.dispose();
		if (!addSystemStep.isDisposed())
			addSystemStep.dispose();
		if (!flowOfEventsArea.isDisposed())
			flowOfEventsArea.dispose();
		if (!mainPanelComposite.isDisposed())
			mainPanelComposite.dispose();
		if (!sidePanelComposite.isDisposed())
			sidePanelComposite.dispose();
		if (!mainComposite.isDisposed())
			mainComposite.dispose();

		super.dispose();
	}

	/**
	 * Redraws the flow of events, if there are any changes in the actor steps, system steps or the links between them
	 */
	public void updateFlowOfEvents() {
		// remove current flowOfEventsArea and the contained controls if they exist
		if (actorStepControls.size() >= 1) {
			for (int i = 0; i < actorStepControls.size(); i++)
				actorStepControls.get(i).dispose();
			actorStepControls.clear();
		}
		actorStepControls.clear();
		if (systemStepControls.size() >= 1) {
			for (int i = 0; i < systemStepControls.size(); i++)
				systemStepControls.get(i).dispose();
			systemStepControls.clear();
		}
		systemStepControls.clear();

		addActorStep.dispose();
		addSystemStep.dispose();
		if (!flowOfEventsArea.isDisposed())
			flowOfEventsArea.dispose();

		// build the new flowOfEventsArea
		flowOfEventsArea = getToolkit().createComposite(mainPanelComposite);
		GridLayout gridLayout = new GridLayout(2, true);
		gridLayout.horizontalSpacing = 200;
		gridLayout.verticalSpacing = 15;
		flowOfEventsArea.setLayout(gridLayout);
		GridData grid2 = new GridData(GridData.FILL_HORIZONTAL);
		grid2.grabExcessHorizontalSpace = true;
		flowOfEventsArea.setLayoutData(grid2);

		boolean actorHyperlinkDrawn = false;
		boolean systemHyperlinkDrawn = false;

		UseCase u = (UseCase) getModelElement();
		int actorSteps = u.getActorSteps().size();
		int systemSteps = u.getSystemSteps().size();
		int rows = Math.max(actorSteps, systemSteps);

		// fill flowOfEvents Area horizontally
		for (int i = 0; i <= rows; i++) {
			// left side (actor steps)
			if (i >= actorSteps && actorHyperlinkDrawn) {
				Control empty = getToolkit().createComposite(flowOfEventsArea);
				empty.getSize();
			}
			if (i >= actorSteps && !actorHyperlinkDrawn) {
				addActorStep = getToolkit().createHyperlink(flowOfEventsArea, "Create Actor Step", SWT.BEGINNING);
				addActorStep.addHyperlinkListener(new NewActorStepHyperlink(-1));
				actorHyperlinkDrawn = true;
			}
			if (i < actorSteps) {
				ActorStepControl actorStepControl = new ActorStepControl();
				actorStepControl.createControl(flowOfEventsArea, SWT.WRAP, descriptor, ((UseCase) getModelElement())
					.getActorSteps().get(i), getEditingDomain(), getToolkit());
				actorStepControl.setContext((UseCase) getModelElement(), i + 1, this);
				actorStepControls.add(actorStepControl);
			}
			// right side (system steps)
			if (i >= systemSteps && systemHyperlinkDrawn) {
				Control empty = getToolkit().createComposite(flowOfEventsArea);
				empty.getSize();
			}
			if (i >= systemSteps && !systemHyperlinkDrawn) {
				addSystemStep = getToolkit().createHyperlink(flowOfEventsArea, "Create System Step", SWT.BEGINNING);
				addSystemStep.addHyperlinkListener(new NewSystemStepHyperlink(-1));
				systemHyperlinkDrawn = true;
			}
			if (i < systemSteps) {
				SystemStepControl systemStepControl = new SystemStepControl();
				systemStepControl.createControl(flowOfEventsArea, SWT.WRAP, descriptor, ((UseCase) getModelElement())
					.getSystemSteps().get(i), getEditingDomain(), getToolkit());
				systemStepControl.setContext((UseCase) getModelElement(), i + 1, this);
				systemStepControls.add(systemStepControl);
			}
		}

		FlowOfEventsPainter paintListener = new FlowOfEventsPainter();
		flowOfEventsArea.removePaintListener(paintListener);
		flowOfEventsArea.addPaintListener(paintListener);

		redrawLinks();

		flowOfEventsArea.addMouseListener(new EndLinkByMouseListener());

		mainPanelComposite.layout(true);
		mainComposite.layout(true);

	}

	private void redrawLinks() {
		// Draw the links between steps
		flowOfEventsArea.redraw();
	}

	/**
	 * Sets the control into link mode
	 * 
	 * @param mode true if steps are to be linked
	 * @param systemStepIsSource true if the link starts at a system step
	 */
	public void setLinkMode(boolean mode, boolean systemStepIsSource) {
		this.linkMode = mode;
		this.linkFromSystemStep = systemStepIsSource;
		if (linkMode) {
			if (standardCursor != null)
				standardCursor.dispose();
			standardCursor = flowOfEventsArea.getCursor();

			Device device = flowOfEventsArea.getDisplay();

			if (linkCursor != null)
				linkCursor.dispose();
			if (linkCursorImage != null)
				linkCursorImage.dispose();
			linkCursorImage = org.unicase.ui.common.Activator.imageDescriptorFromPlugin(PLUGIN_ID, LINKCURSOR_ICON)
				.createImage();
			if (device != null)
				linkCursor = new Cursor(device, linkCursorImage.getImageData(), 0, 0);
			flowOfEventsArea.setCursor(linkCursor);
		} else {
			if (linkCursor != null)
				linkCursor.dispose();
			if (linkCursorImage != null)
				linkCursorImage.dispose();
			updateFlowOfEvents();
		}
	}

	/**
	 * Sets the control into drag mode
	 * 
	 * @param mode true if drag mode requested
	 * @param actorStep true if the step to be moved is an actor step
	 * @param position the position of the step to be moved
	 */
	public void setDragMode(boolean mode, boolean actorStep, int position) {
		this.dragMode = mode;
		this.dragStep = actorStep;
		this.dragPosition = position;
	}

	public void setSourceOption(Option source) {
		this.sourceOption = source;
	}

	public void setSourceElement(UnicaseModelElement source) {
		this.sourceElement = source;
	}

	public boolean getLinkMode() {
		return linkMode;
	}

	public boolean getSystemStepLinkSource() {
		return linkFromSystemStep;
	}

	public Option getSourceOption() {
		return sourceOption;
	}

	public UnicaseModelElement getSourceElement() {
		return sourceElement;
	}

	/**
	 * Resize flow of events area if too many steps are contained in it
	 */
	public void checkSize() {
		if (flowOfEventsArea.getBounds().height >= mainPanelComposite.getBounds().height) {
			Rectangle r = mainPanelComposite.getBounds();
			r.height = flowOfEventsArea.getBounds().height + 50;
			mainPanelComposite.setBounds(r);
			if (mainPanelComposite.getBounds().height >= parentComposite.getBounds().height) {
				Rectangle r2 = parentComposite.getBounds();
				r2.height = mainPanelComposite.getBounds().height + 50;
				parentComposite.setBounds(r2);
				parentComposite.layout(true);
				parentForm.reflow(true);
			}
		}
	}

	public void setContext(ScrolledForm form) {
		this.parentForm = form;
	}

	/**
	 * Delete all actor and system step controls
	 */
	private void disposeSteps() {
		if (actorStepControls.size() >= 1) {
			for (int i = 0; i < actorStepControls.size(); i++)
				actorStepControls.get(i).dispose();
			actorStepControls.clear();
		}
		actorStepControls.clear();
		if (systemStepControls.size() >= 1) {
			for (int i = 0; i < systemStepControls.size(); i++)
				systemStepControls.get(i).dispose();
			systemStepControls.clear();
		}
		systemStepControls.clear();
	}
}
