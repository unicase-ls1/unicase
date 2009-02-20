/**
 * <copyright> Copyright (c) 2008 Jonas Helming, Maximilian Koegel. All rights reserved. This program and the
 * accompanying materials are made available under the terms of the Eclipse Public License v1.0 which accompanies this
 * distribution, and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>
 */
package org.unicase.ui.stem.views.statusview;

import java.net.URL;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

import org.eclipse.core.runtime.FileLocator;
import org.eclipse.core.runtime.Path;
import org.eclipse.core.runtime.Platform;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.impl.AdapterImpl;
import org.eclipse.emf.edit.ui.dnd.LocalTransfer;
import org.eclipse.jface.action.Action;
import org.eclipse.jface.action.IToolBarManager;
import org.eclipse.jface.layout.GridDataFactory;
import org.eclipse.jface.layout.GridLayoutFactory;
import org.eclipse.jface.resource.ImageDescriptor;
import org.eclipse.jface.viewers.TreeSelection;
import org.eclipse.swt.SWT;
import org.eclipse.swt.custom.CLabel;
import org.eclipse.swt.custom.SashForm;
import org.eclipse.swt.dnd.DND;
import org.eclipse.swt.dnd.DropTarget;
import org.eclipse.swt.dnd.DropTargetEvent;
import org.eclipse.swt.dnd.DropTargetListener;
import org.eclipse.swt.dnd.Transfer;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.graphics.Color;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.ProgressBar;
import org.eclipse.swt.widgets.TabFolder;
import org.eclipse.swt.widgets.TabItem;
import org.eclipse.swt.widgets.Widget;
import org.eclipse.ui.IActionBars;
import org.eclipse.ui.part.ViewPart;
import org.unicase.model.ModelElement;
import org.unicase.model.Project;
import org.unicase.model.task.WorkItem;
import org.unicase.model.task.util.MEState;
import org.unicase.model.task.util.TaxonomyAccess;
import org.unicase.model.util.ProjectChangeObserver;
import org.unicase.ui.common.MEClassLabelProvider;
import org.unicase.ui.common.util.ActionHelper;
import org.unicase.ui.stem.Activator;
import org.unicase.workspace.ProjectSpace;
import org.unicase.workspace.Workspace;
import org.unicase.workspace.WorkspaceManager;
import org.unicase.workspace.WorkspacePackage;
import org.unicase.workspace.util.EventUtil;

/**
 * . This view summarizes the the progress status of a model element according to its Openers, Annotations, and
 * corresponding Assignables. The view contains a top part showing name, description and project of input model element,
 * and a progress bar showing its overall progress. The bottom part of view contains two tabs showing Openers of the
 * input model element in flat and hierarchical views, and a tab showing users participating in this model element and
 * their Assignables regarding this model element. The input is set by drag and dropping a model element of top part of
 * the view.
 * 
 * @author Hodaie
 * @author Shterev
 */
public class StatusView extends ViewPart implements ProjectChangeObserver {

	private ModelElement input;
	// this must be disposed!
	private DropTarget dropTarget;
	private ProgressBar pbTasks;

	// used to get image of model element's class
	private MEClassLabelProvider labelProvider;

	private Label lblProjectName;
	private Composite topComposite;

	// composites shown on each tab
	private FlatTabComposite flatTabComposite;
	private HierarchyTabComposite hierarchyTabComposite;
	private UserTabComposite userTabComposite;
	private ActivityTabComposite activityTabComposite;
	private Label lblLatestDueDateName;
	private Composite dropComposite;
	private ProgressBar pbEstimate;
	private Label lblProgressName;
	private Label lblEstimateProgressName;
	private Composite descComposite;
	private Composite section;
	private CLabel lblName;
	private Composite progressComposite;
	private Composite sectionComposite;

	private Map<String, Image> images;
	private Workspace workspace;
	private AdapterImpl adapterImpl;
	private static final String DROP_COMPOSITE_BACKGROUND = "drop_composite_background";
	private static final String FLAT_TAB_IMAGE = "flat_tab_image";
	private static final String HIERARCHY_TAB_IMAGE = "hierarchy_tab_image";
	private static final String USER_TAB_IMAGE = "user_tab_image";
	private static final String ACTIVITY_TAB_IMAGE = "avtivity_tab_image";

	/**
	 * Constructor.
	 */
	public StatusView() {
		this.input = null;
		this.labelProvider = new MEClassLabelProvider();

		createImages();

		workspace = WorkspaceManager.getInstance().getCurrentWorkspace();
		if (workspace.getActiveProjectSpace() != null) {
			workspace.getActiveProjectSpace().getProject().addProjectChangeObserver(StatusView.this);
		}
		adapterImpl = new AdapterImpl() {
			@Override
			public void notifyChanged(Notification msg) {
				if ((msg.getFeatureID(Workspace.class)) == WorkspacePackage.WORKSPACE__ACTIVE_PROJECT_SPACE) {

					// remove old listeners
					Object oldValue = msg.getOldValue();
					if (oldValue instanceof ProjectSpace) {
						((ProjectSpace) oldValue).getProject().removeProjectChangeObserver(StatusView.this);
					}
					// add listener to get notified when work items get deleted/added/changed
					if (workspace.getActiveProjectSpace() != null) {
						workspace.getActiveProjectSpace().getProject().addProjectChangeObserver(StatusView.this);
					}
				}
			}
		};
		workspace.eAdapters().add(adapterImpl);

	}

	private void createImages() {
		images = new HashMap<String, Image>();

		images.put(DROP_COMPOSITE_BACKGROUND, Activator.getImageDescriptor("icons/dropBox.png").createImage());

		URL url = FileLocator.find(Platform.getBundle("org.unicase.ui.stem"), new Path("icons/flatLayout.gif"), null);
		ImageDescriptor imageDescriptor = ImageDescriptor.createFromURL(url);
		images.put(FLAT_TAB_IMAGE, imageDescriptor.createImage());

		url = FileLocator.find(Platform.getBundle("org.unicase.ui.stem"), new Path("icons/hierarchicalLayout.gif"),
			null);
		imageDescriptor = ImageDescriptor.createFromURL(url);
		images.put(HIERARCHY_TAB_IMAGE, imageDescriptor.createImage());

		url = FileLocator.find(Platform.getBundle("org.unicase.ui.stem"), new Path("icons/User.gif"), null);
		imageDescriptor = ImageDescriptor.createFromURL(url);
		images.put(USER_TAB_IMAGE, imageDescriptor.createImage());

		url = FileLocator.find(Platform.getBundle("org.unicase.ui.stem"), new Path("icons/ganttChart.png"), null);
		imageDescriptor = ImageDescriptor.createFromURL(url);
		images.put(ACTIVITY_TAB_IMAGE, imageDescriptor.createImage());

	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void createPartControl(Composite parent) {

		SashForm sash = new SashForm(parent, SWT.VERTICAL);
		createTopComposite(sash);
		createTabs(sash);
		sash.setWeights(new int[] { 20, 80 });
		IActionBars bars = getViewSite().getActionBars();
		IToolBarManager menuManager = bars.getToolBarManager();
		Action refresh = new Action() {
			@Override
			public void run() {
				setInput(input);
			}

		};
		refresh.setImageDescriptor(Activator.getImageDescriptor("/icons/refresh.png"));
		refresh.setToolTipText("Refresh");
		menuManager.add(refresh);

	}

	private void createTopComposite(SashForm sash) {
		topComposite = new Composite(sash, SWT.NONE);
		GridLayoutFactory.fillDefaults().numColumns(2).equalWidth(false).applyTo(topComposite);
		GridDataFactory.fillDefaults().align(SWT.FILL, SWT.FILL).grab(true, true).applyTo(topComposite);

		dropComposite = new Composite(topComposite, SWT.NONE);
		dropComposite.setBackground(Display.getCurrent().getSystemColor(SWT.COLOR_WIDGET_BACKGROUND));
		GridLayoutFactory.fillDefaults().numColumns(1).equalWidth(false).applyTo(dropComposite);
		GridDataFactory.fillDefaults().align(SWT.BEGINNING, SWT.CENTER).grab(false, false).hint(80, 80).indent(5, 0)
			.applyTo(dropComposite);
		dropComposite.setBackgroundImage(images.get(DROP_COMPOSITE_BACKGROUND));

		section = new Composite(topComposite, SWT.NONE);
		GridDataFactory.fillDefaults().align(SWT.FILL, SWT.FILL).grab(true, true).applyTo(section);
		GridLayoutFactory.fillDefaults().numColumns(1).equalWidth(false).applyTo(section);

		// name of model element
		lblName = new CLabel(section, SWT.SHADOW_NONE);
		GridDataFactory.fillDefaults().align(SWT.FILL, SWT.BEGINNING).grab(false, false).applyTo(lblName);
		if (input != null) {
			lblName.setImage(labelProvider.getImage(input));
		}
		lblName.setText("Drag a model element in the drop box to the left");
		Color bgColor = Display.getCurrent().getSystemColor(SWT.COLOR_TITLE_BACKGROUND_GRADIENT);
		Color bgColor2 = Display.getCurrent().getSystemColor(SWT.COLOR_WIDGET_BACKGROUND);
		lblName.setBackground(new Color[] { bgColor, bgColor2 }, new int[] { 100 }, true);

		sectionComposite = new Composite(section, SWT.NONE);
		GridLayoutFactory.fillDefaults().numColumns(2).equalWidth(false).applyTo(sectionComposite);
		GridDataFactory.fillDefaults().align(SWT.FILL, SWT.FILL).grab(true, true).applyTo(sectionComposite);

		descComposite = new Composite(sectionComposite, SWT.NONE);
		GridLayoutFactory.fillDefaults().numColumns(2).equalWidth(false).applyTo(descComposite);
		GridDataFactory.fillDefaults().align(SWT.FILL, SWT.BEGINNING).grab(true, false).applyTo(descComposite);

		// project model element belongs to
		Label lblProject = new Label(descComposite, SWT.NONE);
		GridDataFactory.fillDefaults().align(SWT.FILL, SWT.BEGINNING).grab(false, false).applyTo(lblProject);
		lblProject.setText("Project:");
		lblProjectName = new Label(descComposite, SWT.NONE);
		GridDataFactory.fillDefaults().align(SWT.FILL, SWT.BEGINNING).grab(false, false).applyTo(lblProjectName);
		lblProjectName.setText("");

		// Last DueDate
		Label lbllastDueDate = new Label(descComposite, SWT.NONE);
		GridDataFactory.fillDefaults().align(SWT.FILL, SWT.BEGINNING).grab(false, false).applyTo(lbllastDueDate);
		lbllastDueDate.setText("Latest Due Date:");
		lblLatestDueDateName = new Label(descComposite, SWT.NONE);
		GridDataFactory.fillDefaults().align(SWT.FILL, SWT.BEGINNING).grab(false, false).applyTo(lblLatestDueDateName);
		lblLatestDueDateName.setText("");

		// Right Composite
		progressComposite = new Composite(sectionComposite, SWT.NONE);
		GridLayoutFactory.fillDefaults().numColumns(3).equalWidth(false).applyTo(progressComposite);
		GridDataFactory.fillDefaults().align(SWT.BEGINNING, SWT.BEGINNING).grab(false, false)
			.applyTo(progressComposite);

		// progress bar for number
		Label lblProgress = new Label(progressComposite, SWT.NONE);
		GridDataFactory.fillDefaults().align(SWT.BEGINNING, SWT.BEGINNING).grab(false, false).applyTo(lblProgress);
		lblProgress.setText("Closed workitems:");

		pbTasks = new ProgressBar(progressComposite, SWT.HORIZONTAL);
		GridDataFactory.fillDefaults().align(SWT.FILL, SWT.BEGINNING).grab(true, false).applyTo(pbTasks);
		pbTasks.setMinimum(0);
		pbTasks.setMaximum(100);
		pbTasks.setSelection(0);

		lblProgressName = new Label(progressComposite, SWT.NONE);
		GridDataFactory.fillDefaults().align(SWT.FILL, SWT.BEGINNING).grab(true, false).applyTo(lblProgressName);
		lblProgressName.setText(0 + "/" + 0);

		// progress bar for estimate
		Label lblEstimateProgress = new Label(progressComposite, SWT.NONE);
		GridDataFactory.fillDefaults().align(SWT.FILL, SWT.BEGINNING).grab(true, false).applyTo(lblEstimateProgress);
		lblEstimateProgress.setText("Closed estimate:");
		pbEstimate = new ProgressBar(progressComposite, SWT.HORIZONTAL);
		GridDataFactory.fillDefaults().align(SWT.FILL, SWT.BEGINNING).grab(true, false).applyTo(pbEstimate);
		pbEstimate.setMinimum(0);
		pbEstimate.setMaximum(100);
		pbEstimate.setSelection(0);

		lblEstimateProgressName = new Label(progressComposite, SWT.None);
		GridDataFactory.fillDefaults().align(SWT.FILL, SWT.BEGINNING).grab(true, false)
			.applyTo(lblEstimateProgressName);
		lblEstimateProgressName.setText("0/0");

		addDNDSupport(dropComposite);
	}

	/**
	 * Refresh top composite and tabs based on input.
	 */
	public void refreshView() {
		if (input == null) {
			return;
		}
		// update attributes
		lblName.setImage(labelProvider.getImage(input));
		lblName.setText(input.getName());

		lblProjectName.setText(WorkspaceManager.getProjectSpace(input).getProjectName());
		lblProjectName.pack(true);

		// get number of all Openers for this model element
		// in a hierarchical manner
		Set<ModelElement> leafOpeners = TaxonomyAccess.getInstance().getOpeningLinkTaxonomy().getLeafOpeners(input);
		int tasks = leafOpeners.size();
		int estimate = TaxonomyAccess.getInstance().getOpeningLinkTaxonomy().getEstimate(input);
		int closedTasks = getClosedTasks(leafOpeners);
		int closedEstimate = getClosedEstimate(leafOpeners);

		lblProgressName.setText(closedTasks + "/" + tasks);
		lblEstimateProgressName.setText(closedEstimate + "/" + estimate);
		lblProgressName.pack(true);
		lblEstimateProgressName.pack(true);
		sectionComposite.layout(true);

		Date latestDueDate = getLatestDueDate(leafOpeners);
		if (latestDueDate != null) {
			lblLatestDueDateName.setText(latestDueDate.toString());
			lblLatestDueDateName.pack(true);
		}

		// if this model element has no set progress
		// based on its state
		if (tasks == 0) {
			pbTasks.setMaximum(10);
			pbEstimate.setMaximum(10);
			if (input.getState().equals(MEState.CLOSED)) {
				pbTasks.setSelection(10);
				pbEstimate.setSelection(10);
				pbTasks.setToolTipText("100% done");
				pbEstimate.setToolTipText("100% done");
			} else {
				pbEstimate.setSelection(0);
				pbTasks.setSelection(0);
				pbTasks.setToolTipText("0% done");
				pbEstimate.setToolTipText("0% done");
			}
		} else {
			// set progress based of number of still open openers
			pbTasks.setMaximum(tasks);
			pbEstimate.setMaximum(estimate);
			pbTasks.setSelection(closedTasks);
			pbEstimate.setSelection(closedEstimate);
			int estimateprogress = (int) ((float) (closedEstimate) / estimate * 100);
			int progress = (int) ((float) (closedTasks) / tasks * 100);
			pbTasks.setToolTipText(Integer.toString(progress) + "% done");
			pbEstimate.setToolTipText(Integer.toString(estimateprogress) + "% done");
		}

		// set input for tabs
		flatTabComposite.setInput(input, this);
		hierarchyTabComposite.setInput(input);
		userTabComposite.setInput(input, this);
		activityTabComposite.setInput(input);

	}

	private int getClosedEstimate(Set<ModelElement> leafOpeners) {
		int estimate = 0;
		Iterator<ModelElement> iterator = leafOpeners.iterator();
		while (iterator.hasNext()) {
			ModelElement next = iterator.next();
			if (next instanceof WorkItem) {
				if (next.getState().equals(MEState.CLOSED)) {
					estimate = estimate + ((WorkItem) next).getEstimate();
				}
			}
		}
		return estimate;
	}

	private int getClosedTasks(Set<ModelElement> leafOpeners) {
		int openTasks = 0;
		Iterator<ModelElement> iterator = leafOpeners.iterator();
		while (iterator.hasNext()) {
			ModelElement next = iterator.next();
			// JH: change to workItem
			if (next.getState().equals(MEState.CLOSED)) {
				openTasks++;
			}
		}
		return openTasks;
	}

	private Date getLatestDueDate(Set<ModelElement> leafOpeners) {
		Date date = null;
		Iterator<ModelElement> iterator = leafOpeners.iterator();
		while (iterator.hasNext()) {
			ModelElement next = iterator.next();
			if (next instanceof WorkItem) {
				Date dueDate = ((WorkItem) next).getDueDate();
				if (dueDate == null) {
					continue;
				}
				if (date == null) {
					date = dueDate;
				} else if (date.compareTo(dueDate) == 2) {
					date = dueDate;
				}
			}
		}
		return date;
	}

	/**
	 * Set input to the view. currently input is set using drag and drop on top composite. Later we implement a context
	 * menu command for it too.
	 * 
	 * @param me input model element
	 */
	public void setInput(ModelElement me) {
		ModelElement newInput = me;
		if (newInput == null) {
			newInput = ActionHelper.getSelectedModelElement();
		}
		if (input == null || newInput != null) {
			input = newInput;
		}
		topComposite.setFocus();
		refreshView();

	}

	private void createTabs(SashForm sash) {
		TabFolder tabFolder = new TabFolder(sash, SWT.TOP);

		// flat tab
		TabItem flatTab = new TabItem(tabFolder, SWT.None);

		flatTab.setText("Flat view");
		flatTab.setImage(images.get(FLAT_TAB_IMAGE));
		flatTabComposite = new FlatTabComposite(tabFolder, SWT.NONE);
		flatTab.setControl(flatTabComposite);

		// hierarchy tab
		TabItem hierarchyTab = new TabItem(tabFolder, SWT.None);
		hierarchyTab.setText("Hierachical view");
		hierarchyTab.setImage(images.get(HIERARCHY_TAB_IMAGE));
		hierarchyTabComposite = new HierarchyTabComposite(tabFolder, SWT.NONE);
		hierarchyTab.setControl(hierarchyTabComposite);

		// users tab
		TabItem userTab = new TabItem(tabFolder, SWT.None);
		userTab.setText("Users view");
		userTab.setImage(images.get(USER_TAB_IMAGE));
		userTabComposite = new UserTabComposite(tabFolder, SWT.NONE);
		userTab.setControl(userTabComposite);

		// activity tab
		TabItem activityTab = new TabItem(tabFolder, SWT.None);
		activityTab.setText("Activity view");
		activityTab.setImage(images.get(ACTIVITY_TAB_IMAGE));
		activityTabComposite = new ActivityTabComposite(tabFolder, SWT.NONE);
		activityTab.setControl(activityTabComposite);

		tabFolder.addSelectionListener(new SelectionAdapter() {

			/**
			 * @author helming
			 */
			@Override
			public void widgetSelected(SelectionEvent e) {
				Widget item = e.item;
				TabItem tabItem = (TabItem) item;
				String text = tabItem.getText();
				EventUtil.logPresentationChangeEvent("org.unicase.ui.treeview.views.StatusView", text);
				super.widgetSelected(e);
			}

		});
	}

	/**
	 * . Its not a real drag and drop operation. I use the drop event just to signal the end of a drag and drop
	 * operation and extract the target model element myself in refresh view.
	 * 
	 * @param composite
	 */
	private void addDNDSupport(Composite composite) {
		dropTarget = new DropTarget(composite, DND.DROP_COPY);
		Transfer[] transfers = new Transfer[] { LocalTransfer.getInstance() };
		dropTarget.setTransfer(transfers);
		dropTarget.addDropListener(new DropTargetListener() {

			public void dragEnter(DropTargetEvent event) {
				event.detail = DND.DROP_COPY;
			}

			public void drop(DropTargetEvent event) {
				TreeSelection selection = (TreeSelection) event.data;
				ModelElement me = (ModelElement) selection.getFirstElement();
				setInput(me);
			}

			public void dragLeave(DropTargetEvent event) {
			}

			public void dragOperationChanged(DropTargetEvent event) {
			}

			public void dragOver(DropTargetEvent event) {
			}

			public void dropAccept(DropTargetEvent event) {
			}
		});

	}

	/**
	 * . {@inheritDoc}
	 */
	@Override
	public void setFocus() {
		EventUtil.logFocusEvent("org.unicase.ui.treeview.views.StatusView");
	}

	/**
	 * . {@inheritDoc}
	 */
	@Override
	public void dispose() {
		dropTarget.dispose();
		userTabComposite.dispose();
		activityTabComposite.dispose();
		flatTabComposite.dispose();
		hierarchyTabComposite.dispose();

		images.get(DROP_COMPOSITE_BACKGROUND).dispose();
		images.get(FLAT_TAB_IMAGE).dispose();
		images.get(HIERARCHY_TAB_IMAGE).dispose();
		images.get(USER_TAB_IMAGE).dispose();
		images.get(ACTIVITY_TAB_IMAGE);

		images.clear();

		workspace.eAdapters().remove(adapterImpl);

		if (workspace.getActiveProjectSpace() != null && workspace.getActiveProjectSpace().getProject() != null) {
			workspace.getActiveProjectSpace().getProject().removeProjectChangeObserver(StatusView.this);

		}

		super.dispose();
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.unicase.model.util.ProjectChangeObserver#modelElementAdded(org.unicase.model.Project,
	 *      org.unicase.model.ModelElement)
	 */
	public void modelElementAdded(Project project, ModelElement modelElement) {
		refreshView();

	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.unicase.model.util.ProjectChangeObserver#modelElementDeleteCompleted(org.unicase.model.ModelElement)
	 */
	public void modelElementDeleteCompleted(ModelElement modelElement) {
		// nothing to do

	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.unicase.model.util.ProjectChangeObserver#modelElementDeleteStarted(org.unicase.model.ModelElement)
	 */
	public void modelElementDeleteStarted(ModelElement modelElement) {
		// nothing to do

	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.unicase.model.util.ProjectChangeObserver#modelElementRemoved(org.unicase.model.Project,
	 *      org.unicase.model.ModelElement)
	 */
	public void modelElementRemoved(Project project, ModelElement modelElement) {
		refreshView();

	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.unicase.model.util.ProjectChangeObserver#notify(org.eclipse.emf.common.notify.Notification,
	 *      org.unicase.model.Project, org.unicase.model.ModelElement)
	 */
	public void notify(Notification notification, Project project, ModelElement modelElement) {
		refreshView();

	}

}
