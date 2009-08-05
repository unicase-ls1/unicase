/** * <copyright> Copyright (c) 2008-2009 Jonas Helming, Maximilian Koegel. All rights reserved. This program and the * accompanying materials are made available under the terms of the Eclipse Public License v1.0 which accompanies this * distribution, and is available at http://www.eclipse.org/legal/epl-v10.html </copyright> */package org.unicase.workspace.ui.views.emfstorebrowser.views;import java.util.ArrayList;import java.util.Collection;import java.util.Collections;import org.eclipse.emf.edit.provider.ComposedAdapterFactory;import org.eclipse.emf.edit.ui.provider.AdapterFactoryLabelProvider;import org.eclipse.jface.dialogs.MessageDialog;import org.eclipse.jface.layout.GridDataFactory;import org.eclipse.jface.layout.GridLayoutFactory;import org.eclipse.swt.SWT;import org.eclipse.swt.SWTError;import org.eclipse.swt.browser.Browser;import org.eclipse.swt.browser.ProgressEvent;import org.eclipse.swt.browser.ProgressListener;import org.eclipse.swt.events.DisposeEvent;import org.eclipse.swt.events.DisposeListener;import org.eclipse.swt.events.SelectionAdapter;import org.eclipse.swt.events.SelectionEvent;import org.eclipse.swt.graphics.Image;import org.eclipse.swt.graphics.ImageData;import org.eclipse.swt.graphics.Point;import org.eclipse.swt.graphics.Rectangle;import org.eclipse.swt.graphics.Region;import org.eclipse.swt.widgets.Button;import org.eclipse.swt.widgets.Composite;import org.eclipse.swt.widgets.Display;import org.eclipse.swt.widgets.Event;import org.eclipse.swt.widgets.Listener;import org.eclipse.swt.widgets.ProgressBar;import org.eclipse.swt.widgets.Shell;import org.unicase.model.ModelElement;import org.unicase.model.activity.ActivityFactory;import org.unicase.model.bug.BugFactory;import org.unicase.model.bug.BugReport;import org.unicase.model.bug.Severity;import org.unicase.model.classes.ClassesFactory;import org.unicase.model.meeting.MeetingFactory;import org.unicase.model.organization.OrganizationFactory;import org.unicase.model.organization.User;import org.unicase.model.rationale.RationaleFactory;import org.unicase.model.requirement.RequirementFactory;import org.unicase.model.task.TaskFactory;import org.unicase.workspace.Configuration;import org.unicase.workspace.Workspace;import org.unicase.workspace.WorkspaceManager;import org.unicase.workspace.exceptions.CannotMatchUserInProjectException;import org.unicase.workspace.ui.Activator;import org.unicase.workspace.util.NoCurrentUserException;import org.unicase.workspace.util.OrgUnitHelper;/** * @author wesendon * @author shterevg */public class NewRepositoryWizardPageTwentyThree {	private Shell shell;	private Display display;	private Image backgroundImage;	private Image emptyImage;	private ArrayList<ModelElement> meList;	private AdapterFactoryLabelProvider adapterFactoryLabelProvider;	private MemoryButton firstButton;	private MemoryButton secondButton;	private int counter;	private ArrayList<MemoryButton> buttons;	/**	 * .	 * 	 * @param shell2 .	 */	@SuppressWarnings("static-access")	public NewRepositoryWizardPageTwentyThree(Shell shell2) {		adapterFactoryLabelProvider = new AdapterFactoryLabelProvider(new ComposedAdapterFactory(			ComposedAdapterFactory.Descriptor.Registry.INSTANCE));		shell = new Shell(shell2, SWT.NO_TRIM | SWT.ON_TOP);		display = Display.getCurrent();		backgroundImage = Activator.getDefault().getImageDescriptor("icons/tticon2.png").createImage();		emptyImage = Activator.getDefault().getImageDescriptor("icons/empty.png").createImage();		// define a region that looks like a key hole		Region region = new Region();		region = createRegion(display, backgroundImage);		shell.setBackgroundImage(backgroundImage);		shell.setRegion(region);		shell.setSize(backgroundImage.getBounds().width, backgroundImage.getBounds().height);		// add ability to move shell around		Listener l = new MouseMovementListener(display);		shell.addListener(SWT.MouseDown, l);		shell.addListener(SWT.MouseUp, l);		shell.addListener(SWT.MouseMove, l);		shell.setBackgroundMode(SWT.INHERIT_FORCE);		initMEList();		init();		shell.open();		shell.setActive();		shell.addDisposeListener(new DisposeListener() {			public void widgetDisposed(DisposeEvent e) {				backgroundImage.dispose();				emptyImage.dispose();			}		});	}	@SuppressWarnings("unchecked")	private void initMEList() {		meList = new ArrayList<ModelElement>();		meList.add(TaskFactory.eINSTANCE.createActionItem());		meList.add(TaskFactory.eINSTANCE.createMilestone());		meList.add(TaskFactory.eINSTANCE.createWorkPackage());		meList.add(RationaleFactory.eINSTANCE.createComment());		meList.add(RationaleFactory.eINSTANCE.createIssue());		meList.add(RationaleFactory.eINSTANCE.createProposal());		meList.add(RationaleFactory.eINSTANCE.createSolution());		meList.add(BugFactory.eINSTANCE.createBugReport());		BugReport newBR = BugFactory.eINSTANCE.createBugReport();		newBR.setSeverity(Severity.TRIVIAL);		meList.add(newBR);		meList.add(OrganizationFactory.eINSTANCE.createUser());		meList.add(OrganizationFactory.eINSTANCE.createGroup());		meList.add(MeetingFactory.eINSTANCE.createMeeting());		meList.add(RequirementFactory.eINSTANCE.createFunctionalRequirement());		meList.add(RequirementFactory.eINSTANCE.createNonFunctionalRequirement());		meList.add(RequirementFactory.eINSTANCE.createActor());		meList.add(ActivityFactory.eINSTANCE.createFork());		meList.add(ActivityFactory.eINSTANCE.createBranch());		meList.add(ClassesFactory.eINSTANCE.createMethod());		meList.addAll((Collection<? extends ModelElement>) meList.clone());		Collections.shuffle(meList);	}	/**	 * .	 */	public void init() {		Composite root = new Composite(shell, SWT.NONE);		root.setLocation(110, 70);		root.setSize(265, 210);		GridLayoutFactory.fillDefaults().spacing(0, 0).margins(0, 0).numColumns(6).applyTo(root);		buttons = new ArrayList<MemoryButton>();		for (int i = 0; i < 36; i++) {			MemoryButton memoryButton = new MemoryButton(meList.get(i), root);			buttons.add(memoryButton);			GridDataFactory.fillDefaults().indent(0, 0).grab(true, true).applyTo(memoryButton.getButton());		}		root.layout();		// add ability to close shell		Button close = new Button(shell, SWT.PUSH);		close.setText("Close");		close.setLocation(410, 110);		close.addListener(SWT.Selection, new Listener() {			public void handleEvent(Event e) {				shell.dispose();			}		});		close.pack();		Button scores = new Button(shell, SWT.PUSH);		scores.setText("Hi-Scores");		scores.setLocation(390, 138);		scores.addListener(SWT.Selection, new Listener() {			public void handleEvent(Event e) {				openHighscores();			}		});		scores.pack();	}	private Region createRegion(Display display, Image image) {		Region region = new Region(display);		ImageData data = image.getImageData();		byte[] alpha = data.alphaData;		Rectangle pixel = new Rectangle(0, 0, 1, 1);		for (int i = 0; i < alpha.length; i++) {			int value = alpha[i] & 0xFF;			if (value > 50) {				int y = i / data.width;				int x = i - (y * data.width);				pixel.x = x;				pixel.y = y;				region.add(pixel);			}		}		return region;	}	/**	 * .	 * 	 * @author wesendon	 * @author shterevg	 */	private final class MemoryButton {		private final ModelElement modelElement;		private boolean open;		private boolean solved;		private Button button;		public MemoryButton(ModelElement id, Composite parent) {			button = new Button(parent, SWT.PUSH | SWT.FLAT);			button.setImage(emptyImage);			button.addSelectionListener(new GameLogic());			open = false;			solved = false;			this.modelElement = id;		}		public ModelElement getModelElement() {			return modelElement;		}		public void swap() {			if (solved) {				return;			}			open = !open;			button.setImage((open) ? adapterFactoryLabelProvider.getImage(modelElement) : emptyImage);		}		public Button getButton() {			return button;		}		/**		 * @author shterevg		 * @author wesendon		 */		private final class GameLogic extends SelectionAdapter {			@Override			public void widgetSelected(SelectionEvent e) {				if (solved || open) {					return;				}				if (firstButton == null) {					firstButton = MemoryButton.this;					firstButton.swap();				} else if (secondButton == null) {					counter++;					secondButton = MemoryButton.this;					secondButton.swap();					if (firstButton.getModelElement().eClass().equals(secondButton.getModelElement().eClass())) {						firstButton.solved = true;						secondButton.solved = true;						for (MemoryButton b : buttons) {							if (!b.solved) {								return;							}						}						if (MessageDialog.openQuestion(shell, "Congratulations!", "You solved the game in " + counter							+ " steps! Do you want to submit your score to the highscore board?")) {							try {								Workspace currentWorkspace = WorkspaceManager.getInstance().getCurrentWorkspace();								User currentUser = OrgUnitHelper.getCurrentUser(currentWorkspace);								StringBuilder builder = new StringBuilder();								builder.append("http://unicase.serval-on.de/index.php?user=");								builder.append(currentUser.getName());								builder.append("&score=");								builder.append((counter * 23));								builder.append("&clientversion=");								builder.append(Configuration.getClientVersion().getVersion());								openHighscores(builder.toString());							} catch (NoCurrentUserException e1) {								MessageDialog.openError(shell, "Error", "Could not determine the current user.");							} catch (CannotMatchUserInProjectException e1) {								MessageDialog.openError(shell, "Error", "Could not determine the current user.");							}						}						shell.dispose();					}				} else if (!MemoryButton.this.equals(firstButton) && !MemoryButton.this.equals(secondButton)) {					firstButton.swap();					secondButton.swap();					swap();					firstButton = MemoryButton.this;					secondButton = null;				}			}		}	}	private void openHighscores() {		openHighscores("http://unicase.serval-on.de/");	}	private void openHighscores(String url) {		if (url == null) {			return;		}		if (!MessageDialog.openConfirm(shell, "External website",			"You are about to open an external website. Do you want to proceed?")) {			return;		}		final Shell scoreShell = new Shell(shell);		scoreShell.setText("Unicase memory: Hi-score board");		scoreShell.setActive();		GridLayoutFactory.fillDefaults().applyTo(scoreShell);		final Browser browser;		try {			browser = new Browser(scoreShell, SWT.NONE);		} catch (SWTError e) {			System.out.println("Could not instantiate Browser: " + e.getMessage());			display.dispose();			return;		}		GridDataFactory.fillDefaults().grab(true, true).applyTo(browser);		final ProgressBar progressBar = new ProgressBar(scoreShell, SWT.NONE);		GridDataFactory.fillDefaults().grab(true, false).applyTo(progressBar);		browser.addProgressListener(new ProgressListener() {			public void changed(ProgressEvent event) {				if (event.total == 0) {					return;				}				int ratio = event.current * 100 / event.total;				progressBar.setSelection(ratio);			}			public void completed(ProgressEvent event) {				progressBar.setSelection(0);			}		});		scoreShell.open();		browser.setUrl(url);	}	/**	 * .	 * 	 * @author wesendon	 */	private final class MouseMovementListener implements Listener {		private final Display display;		private Point origin;		private MouseMovementListener(Display display) {			this.display = display;		}		public void handleEvent(Event e) {			if (e.type == SWT.MouseDown) {				origin = new Point(e.x, e.y);			} else if (e.type == SWT.MouseUp) {				origin = null;			} else if (e.type == SWT.MouseMove) {				if (origin != null) {					Point p = display.map(shell, null, e.x, e.y);					shell.setLocation(p.x - origin.x, p.y - origin.y);				}			}		}	}}