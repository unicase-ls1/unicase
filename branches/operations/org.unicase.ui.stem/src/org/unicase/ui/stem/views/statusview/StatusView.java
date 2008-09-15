/**
 * <copyright> Copyright (c) 2008 Jonas Helming, Maximilian Koegel. All rights reserved. This program and the accompanying materials are made available under the terms of the Eclipse Public License v1.0 which accompanies this distribution, and is available at http://www.eclipse.org/legal/epl-v10.html
 * </copyright>
 *
 * $Id$
 */
package org.unicase.ui.stem.views.statusview;

import java.net.URL;
import java.util.HashSet;
import java.util.Set;

import org.eclipse.core.runtime.FileLocator;
import org.eclipse.core.runtime.Path;
import org.eclipse.core.runtime.Platform;
import org.eclipse.emf.edit.ui.dnd.LocalTransfer;
import org.eclipse.jface.resource.ImageDescriptor;
import org.eclipse.swt.SWT;
import org.eclipse.swt.custom.SashForm;
import org.eclipse.swt.dnd.DND;
import org.eclipse.swt.dnd.DropTarget;
import org.eclipse.swt.dnd.DropTargetEvent;
import org.eclipse.swt.dnd.DropTargetListener;
import org.eclipse.swt.dnd.Transfer;
import org.eclipse.swt.graphics.Font;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.ProgressBar;
import org.eclipse.swt.widgets.TabFolder;
import org.eclipse.swt.widgets.TabItem;
import org.eclipse.swt.widgets.Text;
import org.eclipse.ui.part.ViewPart;
import org.unicase.model.ModelElement;
import org.unicase.model.task.util.MEState;
import org.unicase.model.task.util.TaxonomyAccess;
import org.unicase.ui.common.MEClassLabelProvider;
import org.unicase.ui.common.commands.ActionHelper;
import org.unicase.workspace.WorkspaceManager;

/**.
 * This view summarizes the the progress status of a model element
 * according to its Openers, Annotations, and corresponding Assignables.
 * The view contains a top part showing name, description and project of 
 * input model element, and a progress bar showing its overall progress.
 * The bottom part of view contains two tabs showing Openers of the input
 * model element in flat and hierarchical views, and a tab showing users
 * participating in this model element and their Assignables regarding this
 * model element.
 * The input is set by drag and dropping a model element of top part of the 
 * view.
 * 
 * @author Hodaie
 *
 */
public class StatusView extends ViewPart { 

	private ModelElement input;
	//this must be disposed!
	private DropTarget dropTarget;
	private ProgressBar pb;
	
	//used to get image of model element's class
	private MEClassLabelProvider labelProvider;

	private Label lblImage;
	private Label lblName;
	private Text txtDescription;
	private Label lblProjectName;
	private Composite topComposite;

	//composites shown on each tab
	private FlatTabComposite flatTabComposite;
	private HierarchyTabComposite hierarchyTabComposite;
	private UserTabComposite userTabComposite;

	/**.
	 * Constructor
	 */
	public StatusView() {
		this.input = null;
		this.labelProvider = new MEClassLabelProvider();
	}

	/**.
	 * {@inheritDoc}
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
		topComposite.setLayout(new GridLayout(3, false));
		topComposite.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true));

		//image of model element's class
		lblImage = new Label(topComposite, SWT.NONE);
		GridData gridData = new GridData(SWT.BEGINNING, SWT.TOP, false, false);
		gridData.heightHint = 25;
		gridData.widthHint = 25;
		lblImage.setLayoutData(gridData);
		lblImage.setText("");
		lblImage.setImage(labelProvider.getImage(input));

		//name of model element
		lblName = new Label(topComposite, SWT.NONE);
		lblName.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false, 2, 1));
		lblName.setText("Drag a model element here");
		lblName.setFont(new Font(Display.getDefault(), "Tahoma", 8, SWT.BOLD));

		Label filler = new Label(topComposite, SWT.NONE);
		filler.setLayoutData(new GridData(SWT.BEGINNING, SWT.TOP, false, false));
		
		//project model element belongs to
		Label lblProject = new Label(topComposite, SWT.NONE);
		lblProject.setLayoutData(new GridData(SWT.BEGINNING, SWT.TOP, false, false));
		lblProject.setText("Project:");
		lblProjectName = new Label(topComposite, SWT.NONE);
		lblProjectName.setLayoutData(new GridData(SWT.FILL, SWT.TOP, false, false));
		lblProjectName.setText("");
		

		Label filler1 = new Label(topComposite, SWT.NONE);
		filler1.setLayoutData(new GridData(SWT.BEGINNING, SWT.TOP, false, false));
		
		//description of model element
		Label lblDescription = new Label(topComposite, SWT.NONE);
		lblDescription.setLayoutData(new GridData(SWT.BEGINNING, SWT.TOP, false, false));
		lblDescription.setText("Description:");
		txtDescription = new Text(topComposite, SWT.MULTI | SWT.WRAP | SWT.V_SCROLL | SWT.BORDER);
		txtDescription.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true,	true));
		txtDescription.setText("");
		txtDescription.setEditable(false);

		Label filler2 = new Label(topComposite, SWT.NONE);
		filler2.setLayoutData(new GridData(SWT.BEGINNING, SWT.TOP, false, false));

		//progress bar
		Label lblProgress = new Label(topComposite, SWT.NONE);
		lblProgress.setLayoutData(new GridData(SWT.BEGINNING, SWT.TOP, false, false));
		lblProgress.setText("Progress:");
		pb = new ProgressBar(topComposite, SWT.HORIZONTAL);
		pb.setLayoutData(new GridData(SWT.BEGINNING, SWT.CENTER, true, false));
		pb.setMinimum(0);
		pb.setMaximum(100);
		pb.setSelection(0);

		addDNDSupport(topComposite);
	}

	/**.
	 * Refresh top composite and tabs based on input.
	 * 
	 */
	private void refreshView() {
		if (input == null) {
			return;
		}
		//update attributes
		lblImage.setImage(labelProvider.getImage(input));
		lblName.setText(input.getName());
		String description = input.getDescription() == null ? "" :	input.getDescription();
		txtDescription.setText(description);
		lblProjectName.setText(WorkspaceManager.getProjectSpace(input).getProjectName());

		//get number of all Openers for this model element 
		//in a hierarchical manner
		int maximum = TaxonomyAccess.getInstance().getOpeningLinkTaxonomy()
				.getOpenersRecursive(input).size();

		//if this model element has no set progress
		//based on its state
		if (maximum == 0) {
			pb.setMaximum(10);
			if (input.getState().equals(MEState.CLOSED)) {
				pb.setSelection(10);
				pb.setToolTipText("100% done");
			} else {
				pb.setSelection(0);
				pb.setToolTipText("0% done");
			}
		} else {
			//set progress based of number of still open openers
			pb.setMaximum(maximum);
			int stillOpens = getStillOpenOpeners(input).size();
			pb.setSelection(maximum - stillOpens);
			int progress = (int) ((float) (maximum - stillOpens) / maximum * 100);
			pb.setToolTipText(Integer.toString(progress) + "% done");
		}

		//set input for tabs
		flatTabComposite.setInput(input);
		hierarchyTabComposite.setInput(input);
		userTabComposite.setInput(input);

	}

	/**.
	 * Set input to the view. currently input is set using drag and drop on top composite. 
	 * Later we implement a context menu command for it too.
	 * 
	 * @param me input model element
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

		//flat tab
		URL url = FileLocator.find(Platform.getBundle("org.unicase.ui.stem"),
				new Path("icons/flatLayout.gif"), null);
		ImageDescriptor imageDescriptor = ImageDescriptor.createFromURL(url);
		TabItem flatTab = new TabItem(tabFolder, SWT.None);
		flatTab.setText("Flat view");
		flatTab.setImage(imageDescriptor.createImage());
		flatTabComposite = new FlatTabComposite(tabFolder, SWT.NONE);
		flatTab.setControl(flatTabComposite);

		//hierarchy tab
		url = FileLocator.find(Platform.getBundle("org.unicase.ui.stem"),
				new Path("icons/hierarchicalLayout.gif"), null);
		imageDescriptor = ImageDescriptor.createFromURL(url);
		TabItem hierarchyTab = new TabItem(tabFolder, SWT.None);
		hierarchyTab.setText("Hierachical view");
		hierarchyTab.setImage(imageDescriptor.createImage());
		hierarchyTabComposite = new HierarchyTabComposite(tabFolder, SWT.NONE);
		hierarchyTab.setControl(hierarchyTabComposite);

		//users tab
		url = FileLocator.find(Platform.getBundle("org.unicase.ui.stem"),
				new Path("icons/User.gif"), null);
		imageDescriptor = ImageDescriptor.createFromURL(url);
		TabItem userTab = new TabItem(tabFolder, SWT.None);
		userTab.setText("Users");
		userTab.setImage(imageDescriptor.createImage());
		userTabComposite = new UserTabComposite(tabFolder, SWT.NONE);
		userTab.setControl(userTabComposite);

	}

	/**.
	 * Its not a real drag and drop operation. I use the drop event
	 * just to signal the end of a drag and drop operation and 
	 * extract the target model element myself in refresh view.
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
				setInput(null);
			}
			public void dragLeave(DropTargetEvent event) {	}
			public void dragOperationChanged(DropTargetEvent event) {	}
			public void dragOver(DropTargetEvent event) {	}
			public void dropAccept(DropTargetEvent event) { 	}
		});

	}

	/**
	 * This goes (hierarchically) through list of all opener of this ME and 
	 * returns a list of those openers whose state is not closed.
	 * 
	 * @param me input model element
	 * @return
	 */
	private Set<ModelElement> getStillOpenOpeners(ModelElement me) {
		Set<ModelElement> result = new HashSet<ModelElement>();
		Set<ModelElement> openers = TaxonomyAccess.getInstance()
				.getOpeningLinkTaxonomy().getOpenersRecursive(input);
		for (ModelElement opener : openers) {
			if (opener.getState().equals(MEState.OPEN)
					|| opener.getState().equals(MEState.BLOCKED)) {

				result.add(opener);
			}
		}

		return result;
	}

	/**.
	 * {@inheritDoc}
	 */
	@Override
	public void setFocus() {

	}

	/**.
	 * {@inheritDoc}
	 */
	@Override
	public void dispose() {
		dropTarget.dispose();
		super.dispose();
	}

}
