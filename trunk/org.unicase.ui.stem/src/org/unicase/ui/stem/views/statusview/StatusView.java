/**
 * <copyright> Copyright (c) 2008 Jonas Helming, Maximilian Koegel. All rights reserved. This program and the accompanying materials are made available under the terms of the Eclipse Public License v1.0 which accompanies this distribution, and is available at http://www.eclipse.org/legal/epl-v10.html
 * </copyright>
 *
 * $Id$
 */
package org.unicase.ui.stem.views.statusview;

import java.net.URL;
import java.util.Date;
import java.util.Iterator;
import java.util.Set;

import org.eclipse.core.runtime.FileLocator;
import org.eclipse.core.runtime.Path;
import org.eclipse.core.runtime.Platform;
import org.eclipse.emf.edit.ui.dnd.LocalTransfer;
import org.eclipse.jface.resource.ImageDescriptor;
import org.eclipse.jface.viewers.TreeSelection;
import org.eclipse.swt.SWT;
import org.eclipse.swt.custom.SashForm;
import org.eclipse.swt.dnd.DND;
import org.eclipse.swt.dnd.DropTarget;
import org.eclipse.swt.dnd.DropTargetEvent;
import org.eclipse.swt.dnd.DropTargetListener;
import org.eclipse.swt.dnd.Transfer;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.graphics.Font;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.ProgressBar;
import org.eclipse.swt.widgets.TabFolder;
import org.eclipse.swt.widgets.TabItem;
import org.eclipse.swt.widgets.Widget;
import org.eclipse.ui.part.ViewPart;
import org.unicase.model.ModelElement;
import org.unicase.model.task.ActionItem;
import org.unicase.model.task.util.MEState;
import org.unicase.model.task.util.TaxonomyAccess;
import org.unicase.ui.common.MEClassLabelProvider;
import org.unicase.ui.common.commands.ActionHelper;
import org.unicase.workspace.WorkspaceManager;
import org.unicase.workspace.util.EventUtil;

/**
 * . This view summarizes the the progress status of a model element according
 * to its Openers, Annotations, and corresponding Assignables. The view contains
 * a top part showing name, description and project of input model element, and
 * a progress bar showing its overall progress. The bottom part of view contains
 * two tabs showing Openers of the input model element in flat and hierarchical
 * views, and a tab showing users participating in this model element and their
 * Assignables regarding this model element. The input is set by drag and
 * dropping a model element of top part of the view.
 * 
 * @author Hodaie
 * 
 */
public class StatusView extends ViewPart {

	private ModelElement input;
	// this must be disposed!
	private DropTarget dropTarget;
	private ProgressBar pbTasks;

	// used to get image of model element's class
	private MEClassLabelProvider labelProvider;

	private Label lblImage;
	private Label lblName;
	private Label lblProjectName;
	private Composite topComposite;

	// composites shown on each tab
	private FlatTabComposite flatTabComposite;
	private HierarchyTabComposite hierarchyTabComposite;
	private UserTabComposite userTabComposite;
	private Label lblLatestDueDateName;
	private Composite leftComposite;
	private ProgressBar pbEstimate;
	private Label lblProgressName;
	private Label lblEstimateProgressName;

	/**
	 * . Constructor
	 */
	public StatusView() {
		this.input = null;
		this.labelProvider = new MEClassLabelProvider();
	}

	/**
	 * . {@inheritDoc}
	 * 
	 */
	@Override
	public void createPartControl(Composite parent) {

		SashForm sash = new SashForm(parent, SWT.VERTICAL);
		createTopComposite(sash);
		createTabs(sash);
		sash.setWeights(new int[] { 20, 80 });

	}

	private void createTopComposite(SashForm sash) {
		topComposite = new Composite(sash, SWT.NONE);
		topComposite.setLayout(new GridLayout(2, true));
		topComposite
				.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true));

		leftComposite = new Composite(topComposite, SWT.NONE);
		leftComposite.setLayout(new GridLayout(2, false));
		GridData gridData = new GridData(SWT.FILL, SWT.TOP, true, false);
		leftComposite.setLayoutData(gridData);

		// image of model element's class
		lblImage = new Label(leftComposite, SWT.NONE);
		gridData = new GridData(SWT.BEGINNING, SWT.TOP, false, false);
		gridData.heightHint = 25;
		gridData.widthHint = 25;
		lblImage.setLayoutData(gridData);
		lblImage.setText("Drag a model element here");
		lblImage.setImage(labelProvider.getImage(input));

		// name of model element
		lblName = new Label(leftComposite, SWT.NONE);
		lblName.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false));
		lblName.setText("Drag a model element here");
		lblName.setFont(new Font(Display.getDefault(), "Tahoma", 10, SWT.BOLD));

		// project model element belongs to
		Label lblProject = new Label(leftComposite, SWT.NONE);
		lblProject.setLayoutData(new GridData(SWT.BEGINNING, SWT.TOP, false,
				false));
		lblProject.setText("Project:");
		lblProjectName = new Label(leftComposite, SWT.NONE);
		lblProjectName.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true,
				false));
		lblProjectName.setText("");

		// Last DueDate
		Label lbllastDueDate = new Label(leftComposite, SWT.NONE);
		lbllastDueDate.setLayoutData(new GridData(SWT.BEGINNING, SWT.TOP,
				false, false));
		lbllastDueDate.setText("Latest Due Date:");
		lblLatestDueDateName = new Label(leftComposite, SWT.NONE);
		lblLatestDueDateName.setLayoutData(new GridData(SWT.FILL, SWT.TOP,
				true, false));
		lblLatestDueDateName.setText("");

		// Right Composite
		Composite rightComposite = new Composite(topComposite, SWT.NONE);
		rightComposite.setLayout(new GridLayout(3, false));
		gridData = new GridData(SWT.FILL, SWT.TOP, true, false);
		rightComposite.setLayoutData(gridData);

		// progress bar for number
		Label lblProgress = new Label(rightComposite, SWT.NONE);
		lblProgress.setLayoutData(new GridData(SWT.BEGINNING, SWT.TOP, false,
				false));
		lblProgress.setText("Closed workitems:");
		lblProgressName = new Label(rightComposite, SWT.NONE);
		gridData = new GridData(SWT.FILL, SWT.TOP, false, false);
		lblProgressName.setLayoutData(gridData);
		lblProgressName.setText(0 + "/" + 0);

		pbTasks = new ProgressBar(rightComposite, SWT.HORIZONTAL);
		gridData = new GridData(SWT.BEGINNING, SWT.CENTER, true, false);
		pbTasks.setLayoutData(gridData);
		pbTasks.setMinimum(0);
		pbTasks.setMaximum(100);
		pbTasks.setSelection(0);

		// progress bar for estimate
		Label lblEstimateProgress = new Label(rightComposite, SWT.NONE);
		lblEstimateProgress.setLayoutData(new GridData(SWT.BEGINNING, SWT.TOP,
				false, false));
		lblEstimateProgress.setText("Closed estimate:");
		lblEstimateProgressName = new Label(rightComposite, SWT.None);
		lblEstimateProgressName.setLayoutData(new GridData(SWT.FILL, SWT.TOP,
				false, false));
		lblEstimateProgressName.setText("0/0");
		pbEstimate = new ProgressBar(rightComposite, SWT.HORIZONTAL);
		pbEstimate.setLayoutData(new GridData(SWT.BEGINNING, SWT.CENTER, true,
				false));
		pbEstimate.setMinimum(0);
		pbEstimate.setMaximum(100);
		pbEstimate.setSelection(0);

		addDNDSupport(topComposite);
		addDNDSupport(leftComposite);
		addDNDSupport(rightComposite);
		addDNDSupport(topComposite.getShell());
	}

	/**
	 * . Refresh top composite and tabs based on input.
	 * 
	 */
	private void refreshView() {
		if (input == null) {
			return;
		}
		// update attributes
		lblImage.setImage(labelProvider.getImage(input));
		lblName.setText(input.getName());
		lblProjectName.setText(WorkspaceManager.getProjectSpace(input)
				.getProjectName());

		// get number of all Openers for this model element
		// in a hierarchical manner
		Set<ModelElement> leafOpeners = TaxonomyAccess.getInstance()
				.getOpeningLinkTaxonomy().getLeafOpeners(input);
		int tasks = leafOpeners.size();
		int estimate = getEstimate(leafOpeners);
		int closedTasks = getClosedTasks(leafOpeners);
		int closedEstimate = getClosedEstimate(leafOpeners);

		lblProgressName.setText(closedTasks + "/" + tasks);
		lblEstimateProgressName.setText(closedEstimate + "/" + estimate);

		Date latestDueDate = getLatestDueDate(leafOpeners);
		if (latestDueDate != null) {
			lblLatestDueDateName.setText(latestDueDate.toString());
		}

		// if this model element has no set progress
		// based on its state
		if (tasks == 0) {
			pbTasks.setMaximum(10);
			if (input.getState().equals(MEState.CLOSED)) {
				pbTasks.setSelection(10);
				pbTasks.setToolTipText("100% done");
			} else {
				pbTasks.setSelection(0);
				pbTasks.setToolTipText("0% done");
			}
		} else {
			// set progress based of number of still open openers
			pbTasks.setMaximum(tasks);
			pbTasks.setSelection(closedTasks);
			int progress = (int) ((float) (closedTasks) / tasks * 100);
			pbTasks.setToolTipText(Integer.toString(progress) + "% done");
		}

		// set input for tabs
		flatTabComposite.setInput(input);
		hierarchyTabComposite.setInput(input);
		userTabComposite.setInput(input);

	}

	private int getClosedEstimate(Set<ModelElement> leafOpeners) {
		int estimate = 0;
		Iterator<ModelElement> iterator = leafOpeners.iterator();
		while (iterator.hasNext()) {
			ModelElement next = iterator.next();
			// JH: change to workItem
			if (next instanceof ActionItem) {
				if (next.getState().equals(MEState.CLOSED)) {
					estimate = estimate + ((ActionItem) next).getEstimate();
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

	private int getEstimate(Set<ModelElement> leafOpeners) {
		int estimate = 0;
		Iterator<ModelElement> iterator = leafOpeners.iterator();
		while (iterator.hasNext()) {
			ModelElement next = iterator.next();
			// JH: change to workItem
			if (next instanceof ActionItem) {
				estimate = estimate + ((ActionItem) next).getEstimate();
			}
		}
		return estimate;
	}

	private Date getLatestDueDate(Set<ModelElement> leafOpeners) {
		Date date = null;
		Iterator<ModelElement> iterator = leafOpeners.iterator();
		while (iterator.hasNext()) {
			ModelElement next = iterator.next();
			// JH: change to workItem
			if (next instanceof ActionItem) {
				Date dueDate = ((ActionItem) next).getDueDate();
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
	 * . Set input to the view. currently input is set using drag and drop on
	 * top composite. Later we implement a context menu command for it too.
	 * 
	 * @param me
	 *            input model element
	 */
	public void setInput(ModelElement me) {
		ModelElement newInput = me;
		if (newInput == null) {
			newInput = ActionHelper.getSelectedModelElement();
		}
		if (input == null) {
			input = newInput;
			refreshView();

		}
		if (newInput != null) {
			this.input = newInput;
			System.out.println(input.getName());
			// refresh attributes group and three different views
			refreshView();

		}

	}

	private void createTabs(SashForm sash) {
		TabFolder tabFolder = new TabFolder(sash, SWT.TOP);

		// flat tab
		URL url = FileLocator.find(Platform.getBundle("org.unicase.ui.stem"),
				new Path("icons/flatLayout.gif"), null);
		ImageDescriptor imageDescriptor = ImageDescriptor.createFromURL(url);
		TabItem flatTab = new TabItem(tabFolder, SWT.None);

		flatTab.setText("Flat view");
		flatTab.setImage(imageDescriptor.createImage());
		flatTabComposite = new FlatTabComposite(tabFolder, SWT.NONE);
		flatTab.setControl(flatTabComposite);

		// hierarchy tab
		url = FileLocator.find(Platform.getBundle("org.unicase.ui.stem"),
				new Path("icons/hierarchicalLayout.gif"), null);
		imageDescriptor = ImageDescriptor.createFromURL(url);
		TabItem hierarchyTab = new TabItem(tabFolder, SWT.None);
		hierarchyTab.setText("Hierachical view");
		hierarchyTab.setImage(imageDescriptor.createImage());
		hierarchyTabComposite = new HierarchyTabComposite(tabFolder, SWT.NONE);
		hierarchyTab.setControl(hierarchyTabComposite);

		// users tab
		url = FileLocator.find(Platform.getBundle("org.unicase.ui.stem"),
				new Path("icons/User.gif"), null);
		imageDescriptor = ImageDescriptor.createFromURL(url);
		TabItem userTab = new TabItem(tabFolder, SWT.None);
		userTab.setText("Users view");
		userTab.setImage(imageDescriptor.createImage());
		userTabComposite = new UserTabComposite(tabFolder, SWT.NONE);
		userTab.setControl(userTabComposite);

		tabFolder.addSelectionListener(new SelectionAdapter() {

		/**
		 * @author helming
		 */
			@Override
			public void widgetSelected(SelectionEvent e) {
				Widget item = e.item;
				TabItem tabItem = (TabItem) item;
				String text = tabItem.getText();
				EventUtil.logPresentationChangeEvent(
						"org.unicase.ui.treeview.views.StatusView", text);
				super.widgetSelected(e);
			}

		});
	}

	/**
	 * . Its not a real drag and drop operation. I use the drop event just to
	 * signal the end of a drag and drop operation and extract the target model
	 * element myself in refresh view.
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
		super.dispose();
	}

}
