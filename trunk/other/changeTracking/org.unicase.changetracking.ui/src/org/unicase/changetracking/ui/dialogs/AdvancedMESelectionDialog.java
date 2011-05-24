/**
 * <copyright> Copyright (c) 2008-2009 Jonas Helming, Maximilian Koegel. All rights reserved. This program and the
 * accompanying materials are made available under the terms of the Eclipse Public License v1.0 which accompanies this
 * distribution, and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>
 */
package org.unicase.changetracking.ui.dialogs;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.eclipse.core.runtime.NullProgressMonitor;
import org.eclipse.emf.common.util.BasicEList;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.jface.dialogs.IDialogConstants;
import org.eclipse.jface.dialogs.IDialogSettings;
import org.eclipse.jface.resource.CompositeImageDescriptor;
import org.eclipse.jface.viewers.ILabelProvider;
import org.eclipse.jface.viewers.ILabelProviderListener;
import org.eclipse.jface.viewers.LabelProvider;
import org.eclipse.jface.viewers.ViewerFilter;
import org.eclipse.jface.window.Window;
import org.eclipse.swt.SWT;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.graphics.ImageData;
import org.eclipse.swt.graphics.Point;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Combo;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Label;
import org.unicase.changetracking.common.ChangeTrackingUtil;
import org.unicase.changetracking.ui.Activator;
import org.unicase.metamodel.MetamodelFactory;
import org.unicase.metamodel.ModelElementId;
import org.unicase.metamodel.util.ModelUtil;
import org.unicase.model.UnicaseModelElement;
import org.unicase.model.organization.OrganizationFactory;
import org.unicase.model.organization.OrganizationPackage;
import org.unicase.model.organization.User;
import org.unicase.model.task.TaskPackage;
import org.unicase.model.task.WorkItem;
import org.unicase.ui.common.dialogs.ModelElementSelectionDialog;
import org.unicase.ui.common.util.CannotMatchUserInProjectException;
import org.unicase.ui.common.util.ComboView;
import org.unicase.ui.unicasecommon.common.util.OrgUnitHelper;
import org.unicase.workspace.ProjectSpace;
import org.unicase.workspace.Workspace;
import org.unicase.workspace.WorkspaceManager;
import org.unicase.workspace.util.NoCurrentUserException;
import org.unicase.workspace.util.UnicaseCommand;

/**
 * The attachee selection dialog allows to select a work item to attach a source
 * change to.
 * 
 * It allows to filter the shown work items by project and by user to whom they
 * are associated. It also allows to create a new action item on the fly.
 * 
 * @author jfinis
 * 
 */
public abstract class AdvancedMESelectionDialog extends ModelElementSelectionDialog {

	/**
	 * The image with which "create new xxx" entries are decorated.
	 */
	private static final ImageData DECORATION_IMAGE = Activator.getImageDescriptor("icons/cross8x8.png").getImageData();

	/**
	 * Set containing the model elements that represent creating a new work
	 * item.
	 */
	private Set<EObject> createElements = new HashSet<EObject>();

	/**
	 * The user selection combo box.
	 */
	private ComboView<User> userBar;

	/**
	 * The project selection combo box.
	 */
	private ComboView<ProjectSpace> projectBar;

	/**
	 * This variable is part of a hack which is used to inject new content
	 * during runtime into the dialog. This is needed when the project or user
	 * is changed. Basically, the super class does not allow to swap content.
	 * This moves around this limitation.
	 */
	private boolean isInRefreshMode;

	private boolean createUponClose;

	private ModelElementPlacementDialog placementDialog;

	/**
	 * Default constructor without any class bound, i.e. all model elements can
	 * be chosen.
	 */
	public AdvancedMESelectionDialog() {
		this(null,true);
	}

	/**
	 * Constructor with specific class bound, title, and message.
	 * 
	 * @param classBound only model elements which are subclasses of this class
	 *            are displayed. Use null for showing all elements.
	 * @param title dialog title
	 * @param message dialog message
	 * @param createUponClose whether a newly created element should be automatically
	 * 			created when the dialog is finished
	 */
	public AdvancedMESelectionDialog(EClass classBound, String title, String message, boolean createUponClose) {
		this(classBound, createUponClose);
		this.setTitle(title);
		this.setMessage(message);
	}

	/**
	 * Constructor with custom class bound.
	 * 
	 * @param classBound only model elements which are subclasses of this class
	 *            are displayed. Use null for showing all elements.
	 * @param createUponClose whether a newly created element should be automatically
	 * 			created when the dialog is finished
	 */
	public AdvancedMESelectionDialog(EClass classBound, boolean createUponClose) {
		super(false);
		this.createUponClose = createUponClose;
		setBlockOnOpen(true);

		// Create the "create new" entries
		Set<EClass> classes = ModelUtil.getSubclasses(TaskPackage.eINSTANCE.getWorkItem());
		for (EClass cls : classes) {

			// Only add class if it is in the list of elements to show
			String name = cls.getName();
			boolean allowed = false;
			Collection<String> allowedCreation = getAllowedClassesForCreation();
			if (allowedCreation != null) {
				for (String s : allowedCreation) {
					if (s.equals(name)) {
						allowed = true;
						break;
					}
				}
			} else {
				allowed = true;
			}
			if (!allowed) {
				continue;
			}

			// Create the itm and add it to the set
			EObject e = cls.getEPackage().getEFactoryInstance().create(cls);
			((WorkItem) e).setName("<< create new " + cls.getName() + " >>");
			createElements.add(e);
		}
	}

	/**
	 * Must be implemented by subclasses to return the classes allowed for
	 * creation. The dialog will contain a <<create new X>> element for each
	 * class X returned by this method. If the user selects one of them, a new
	 * model element of this type is created.
	 * 
	 * @return allowed classes for creation
	 */
	protected abstract Collection<String> getAllowedClassesForCreation();

	/**
	 * Must be implemented by subclasses to return the user based viewer filter.
	 * This filter must filter the content according to the selected user. The
	 * meaning of "filtering according to the selected user" must be chosen by
	 * the implementation. For example, a possible implementation could show
	 * only action items which have the user as assignee.
	 * 
	 * The dialog contains a user field where a user can be chosen. Once one is
	 * chosen, this method is called and the returned filter is used by the
	 * dialog.
	 * 
	 * @param user user for which to filter the content
	 * @return a filter
	 */
	protected abstract ViewerFilter getUserFilter(User user);

	/**
	 * Returns the selected model element rawly. Even if a <<create new X>>
	 * entry is chosen, this entry is returned instead of really creating a new
	 * class.
	 * 
	 * Thus, this method should be handled with care as its result could be a
	 * model element which does not really exist in the project. If you want to
	 * create a model element and return it if a <<create X>> entry is chosen,
	 * use getOrCreateSelectedModelElement instead.
	 * 
	 * @return the selected model element
	 */
	public UnicaseModelElement getSelectedModelElement() {
		return (UnicaseModelElement) getFirstResult();
	}
	
	/**
	 * Performs the placement of the model element, if a <<create new X>> entry
	 * was chosen. If no such entry was chosen, the dialog was cancelled, or the
	 * placement has already been conducted, this method will do nothing.
	 */
	public void performPlacement() {
		//Abort if already placed or no create entry was selected
		if(placementDialog == null){
			return;
		}
		
		//Do the placement
		final UnicaseModelElement selectedElement = getSelectedModelElement();
		new UnicaseCommand() {
			@Override
			protected void doRun() {
				ChangeTrackingUtil.putInto(selectedElement, placementDialog.getSelection());
				selectedElement.setName(placementDialog.getSelectedName());
			}
		}.run();
		
		//Placement is no longer possible
		placementDialog = null;
		
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public boolean close() {
		
		final UnicaseModelElement selectedElement = getSelectedModelElement();
		if (getReturnCode() == Window.OK && elementIsCreateEntry(selectedElement)) {
			ModelElementPlacementDialog placementDialog = new ModelElementPlacementDialog(getShell(), getSelectedModelElement(), true);
			if (placementDialog.open() == Window.OK) {
				if(createUponClose){
					performPlacement();
				} else {
					//Save dialog, so the placement can be done later.
					this.placementDialog = placementDialog;
				}
			} else {
				setReturnCode(Window.CANCEL);
			}
		}
		return super.close();
	}

	/**
	 * Returns whether a model element is a "create new xxx" entry.
	 * 
	 * @param element element to test
	 * @return true, iff the model element is a "create new xxx" element.
	 */
	public boolean elementIsCreateEntry(Object element) {
		return createElements.contains(element);
	}

	/**
	 * Gets the currently selected project space.
	 * 
	 * @return the selected project space
	 */
	public ProjectSpace getSelectedProjectSpace() {
		return projectBar.getSelection();
	}

	/**
	 * Sets the margins of a layout to 0. Is needed to make the layout look
	 * good.
	 * 
	 * @param l
	 */
	private void removeMargin(GridLayout l) {
		l.marginHeight = 0;
		l.marginWidth = 0;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	protected ILabelProvider createLabelProvider() {
		ILabelProvider lp = super.createLabelProvider();
		return new AdvancedLabelProvider(lp);
	}

	/**
	 * Creates a composite with a specific layout. The layout gets its margins
	 * removed.
	 * 
	 * @param parent parent composite in which to add the newly created
	 *            composite.
	 * @param layout layout to use for the new composite
	 * @return
	 */
	private Composite createComposite(Composite parent, GridLayout layout) {
		Composite composite = new Composite(parent, SWT.NONE);
		composite.setLayout(layout);
		removeMargin(layout);
		return composite;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	protected Control createDialogArea(Composite parent) {

		// Main composite
		Composite composite = new Composite(parent, SWT.NONE);
		GridLayout layout = new GridLayout();
		layout.marginHeight = convertVerticalDLUsToPixels(IDialogConstants.VERTICAL_MARGIN);
		layout.marginWidth = convertHorizontalDLUsToPixels(IDialogConstants.HORIZONTAL_MARGIN);
		layout.verticalSpacing = 1;
		layout.horizontalSpacing = convertHorizontalDLUsToPixels(IDialogConstants.HORIZONTAL_SPACING);
		composite.setLayout(layout);
		composite.setLayoutData(new GridData(GridData.FILL_BOTH));

		// Sub composite
		Composite subComposite = createComposite(composite, new GridLayout(4, false));

		// Project selection combo box
		Label l = new Label(subComposite, SWT.NONE);
		l.setText("Select project:");
		l.setLayoutData(new GridData(SWT.LEFT));
		Combo combo = new Combo(subComposite, SWT.READ_ONLY);
		combo.setLayoutData(new GridData(SWT.LEFT));
		projectBar = new ComboView<ProjectSpace>(combo);
		projectBar.addSelectionChangedListener(new ComboView.IComboChangeListener<ProjectSpace>() {
			public void selectionChanged(ProjectSpace newSelection) {
				populateUserBar(newSelection, userBar.getSelection(), true);
			}
		});

		projectBar.setLabelProvider(new LabelProvider() {
			@Override
			public String getText(Object element) {
				return ((ProjectSpace) element).getProjectName();
			}
		});

		// User selection combo box
		l = new Label(subComposite, SWT.NONE);
		l.setText(" Select user:");
		l.setLayoutData(new GridData(SWT.LEFT));
		combo = new Combo(subComposite, SWT.READ_ONLY);
		combo.setLayoutData(new GridData(SWT.LEFT));
		userBar = new ComboView<User>(combo);
		userBar.addSelectionChangedListener(new ComboView.IComboChangeListener<User>() {
			public void selectionChanged(User newSelection) {
				populateEntries(projectBar.getSelection(), getSelectedUserOrNoUser(newSelection));
				doRefresh();
			}
		});
		userBar.setLabelProvider(new LabelProvider() {
			@Override
			public String getText(Object element) {
				return ((User) element).getName();
			}
		});

		// Create the rest of the dialog
		Composite dialogArea = (Composite) super.createDialogArea(composite);
		GridLayout dialogLayout = (GridLayout) dialogArea.getLayout();
		removeMargin(dialogLayout);

		return dialogArea;
	}

	/**
	 * Refreshes the set of model elements. Is called whenever the set of model
	 * elements to be displayed changes, i.e. when the project or user is
	 * switched. Uses a hack to replace the model elements...
	 */
	private void doRefresh() {
		isInRefreshMode = true;
		applyFilter();
		reloadCache(true, new NullProgressMonitor());
		refresh();
		isInRefreshMode = false;
	}

	/**
	 * Populates the set of model elements to be displayed.
	 * 
	 * @param projectSpace the project space for which to get the model elements
	 * @param user
	 */
	private void populateEntries(ProjectSpace projectSpace, User user) {
		ViewerFilter filter = user == null ? null : getUserFilter(user);
		List<WorkItem> projectItems = projectSpace.getProject().getAllModelElementsbyClass(TaskPackage.eINSTANCE.getWorkItem(), new BasicEList<WorkItem>(), true);

		BasicEList<EObject> elementsToShow = new BasicEList<EObject>();

		for (WorkItem elem : projectItems) {

			// Add only work items that pass the filter, if there is one
			if (filter == null || filter.select(null, null, elem)) {
				elementsToShow.add(elem);
			}
		}

		// Add the "create new" entries
		elementsToShow.addAll(createElements);

		setModelElements(elementsToShow);

	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	protected void storeDialog(IDialogSettings settings) {
		// Store super settings
		super.storeDialog(settings);

		// Store project and user
		settings.put("LAST_PROJECT", projectBar.getSelection().getIdentifier());

		User user = getSelectedUserOrNoUser(userBar.getSelection());
		if (user == null) {
			settings.put("LAST_USER", (String) null);
		} else {
			settings.put("LAST_USER", projectBar.getSelection().getProject().getModelElementId(user).getId());

		}
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	protected void restoreDialog(IDialogSettings settings) {
		super.restoreDialog(settings);

		// --- project ---
		String lastProj = settings.get("LAST_PROJECT");
		Workspace w = WorkspaceManager.getInstance().getCurrentWorkspace();

		ProjectSpace selectedProject = getDefaultProject();

		// Find the last project
		if (lastProj != null) {
			for (ProjectSpace ps : w.getProjectSpaces()) {
				if (lastProj.equals(ps.getIdentifier())) {
					selectedProject = ps;
				}
			}
		}

		populateProjectBar(selectedProject, false);

		// --- user ---
		User selectedUser = null;

		String lastUser = settings.get("LAST_USER");
		if (lastUser != null) {
			ModelElementId userId = MetamodelFactory.eINSTANCE.createModelElementId();
			userId.setId(lastUser);
			selectedUser = (User) selectedProject.getProject().getModelElement(userId);

		}

		populateUserBar(projectBar.getSelection(), selectedUser, false);

		populateEntries(projectBar.getSelection(), getSelectedUserOrNoUser(userBar.getSelection()));
	}

	/**
	 * Returns the input user, unless it is the [no user] user. If it is the [no
	 * user], null is returned.
	 */
	private User getSelectedUserOrNoUser(User user) {
		if (user == null || user.getName().equals("[no user]")) {
			return null;
		}
		return user;
	}

	/**
	 * Populates the combo box that displays the users.
	 * 
	 * @param selectedProject2 the selected project
	 * @param selectedUser2 the user to be selected
	 * @param fireChangeEvents if a change event should be fired
	 */
	private void populateUserBar(ProjectSpace selectedProject2, User selectedUser2, boolean fireChangeEvents) {
		// If no user is stated, we try the current user, if he is in the
		// selected project
		if (selectedUser2 == null) {
			try {
				selectedUser2 = OrgUnitHelper.getCurrentUser(WorkspaceManager.getInstance().getCurrentWorkspace());
			} catch (NoCurrentUserException e) {

			} catch (CannotMatchUserInProjectException e) {}
		}

		// Build list of users
		List<User> users = new ArrayList<User>();
		List<User> projectUsers = selectedProject2.getProject().getAllModelElementsbyClass(OrganizationPackage.eINSTANCE.getUser(), new BasicEList<User>());
		User noUser = OrganizationFactory.eINSTANCE.createUser();
		noUser.setName("[no user]");
		users.add(noUser);
		users.addAll(projectUsers);

		userBar.setInput(users, selectedUser2, fireChangeEvents);

	}

	/**
	 * Populates the project combo box.
	 * 
	 * @param selectedProject2 the project to select
	 * @param fireChangeEvents if a change event should be fired
	 */
	private void populateProjectBar(ProjectSpace selectedProject2, boolean fireChangeEvents) {
		Workspace w = WorkspaceManager.getInstance().getCurrentWorkspace();
		EList<ProjectSpace> spaces = w.getProjectSpaces();

		projectBar.setInput(spaces, selectedProject2, fireChangeEvents);
	}

	/**
	 * Returns a default project space. This is just the first project in the
	 * workspace.
	 * 
	 * @return the first project in the workspace.
	 */
	private ProjectSpace getDefaultProject() {
		Workspace w = WorkspaceManager.getInstance().getCurrentWorkspace();
		return w.getProjectSpaces().get(0);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	protected ItemsFilter createFilter() {
		return new AdvancedModelElementFilter();
	}

	/**
	 * Model element filter that differs from its super class by: -providing the
	 * "hack" that is used to refresh the content (i.e. change the model
	 * elements to be displayed) -showing all model elements if no pattern is
	 * chosen.
	 * 
	 * @author jfinis
	 * 
	 */
	protected class AdvancedModelElementFilter extends ModelElementFilter {

		/**
		 * Used for the hack. Besides that, same as super method. {@inheritDoc}
		 */
		@Override
		public boolean isSubFilter(ItemsFilter filter) {
			if (isInRefreshMode) {
				return false;
			}
			return super.isSubFilter(filter);
		}

		/**
		 * Used for the hack. Besides that, same as super method.
		 * 
		 * {@inheritDoc}
		 **/
		@Override
		public boolean equalsFilter(ItemsFilter filter) {
			if (isInRefreshMode) {
				return false;
			}
			return super.equalsFilter(filter);
		}

		/**
		 * Used to display all elements if no pattern is chosen. Besides that,
		 * same as super method.
		 * 
		 * {@inheritDoc}
		 */
		@Override
		public String getPattern() {
			String pattern = super.getPattern();
			if ("".equals(pattern)) {
				return "**";
			}
			return pattern;
		}

	}

	/**
	 * Label provider that forwards most calls to another label provider, but
	 * decorates "create new xxx" entries with a special image.
	 * 
	 * @author jfinis
	 */
	private final class AdvancedLabelProvider implements ILabelProvider {

		private ILabelProvider wrappedProvider;

		private AdvancedLabelProvider(ILabelProvider wrappedProvider) {
			this.wrappedProvider = wrappedProvider;

		}

		/**
		 * {@inheritDoc}
		 */
		public Image getImage(Object element) {
			Image img = wrappedProvider.getImage(element);

			if (elementIsCreateEntry(element)) {
				img = new Image(img.getDevice(), new DecorationImageDescriptor(img).getImageData());
			}
			return img;
		}

		/**
		 * {@inheritDoc}
		 */
		public String getText(Object element) {
			return wrappedProvider.getText(element);
		}

		/**
		 * {@inheritDoc}
		 */
		public void addListener(ILabelProviderListener listener) {
			wrappedProvider.addListener(listener);
		}

		/**
		 * {@inheritDoc}
		 */
		public void dispose() {
			wrappedProvider.dispose();
		}

		/**
		 * {@inheritDoc}
		 */
		public boolean isLabelProperty(Object element, String property) {
			return wrappedProvider.isLabelProperty(element, property);
		}

		/**
		 * {@inheritDoc}
		 */
		public void removeListener(ILabelProviderListener listener) {
			wrappedProvider.removeListener(listener);
		}

	}

	/**
	 * 
	 * Decorator that adds the decorating image to an image.
	 * 
	 * @author jfinis
	 * 
	 */
	private final class DecorationImageDescriptor extends CompositeImageDescriptor {

		private Image image;

		private DecorationImageDescriptor(Image image) {
			this.image = image;
		}

		/**
		 * {@inheritDoc}
		 */
		@Override
		protected void drawCompositeImage(int width, int height) {

			// Draw base image.
			drawImage(image.getImageData(), 0, 0);

			// Add decoration
			drawImage(DECORATION_IMAGE, 0, 0);
		}

		/**
		 * {@inheritDoc}
		 */
		@Override
		protected Point getSize() {
			return new Point(image.getBounds().width, image.getBounds().height);
		}

	}

}
