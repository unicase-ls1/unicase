/**
 * <copyright> Copyright (c) 2008-2009 Jonas Helming, Maximilian Koegel. All rights reserved. This program and the
 * accompanying materials are made available under the terms of the Eclipse Public License v1.0 which accompanies this
 * distribution, and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>
 */
package org.unicase.changetracking.ui.dialogs;

import java.util.ArrayList;
import java.util.Collection;

import org.eclipse.emf.common.util.BasicEList;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EcoreFactory;
import org.eclipse.emf.edit.provider.ComposedAdapterFactory;
import org.eclipse.emf.edit.ui.provider.AdapterFactoryContentProvider;
import org.eclipse.emf.edit.ui.provider.AdapterFactoryLabelProvider;
import org.eclipse.jface.dialogs.TitleAreaDialog;
import org.eclipse.jface.layout.GridDataFactory;
import org.eclipse.jface.layout.GridLayoutFactory;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.ISelectionChangedListener;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.viewers.SelectionChangedEvent;
import org.eclipse.jface.viewers.TreeViewer;
import org.eclipse.jface.window.Window;
import org.eclipse.swt.SWT;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.graphics.Point;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Text;
import org.unicase.changetracking.common.ChangeTrackingUtil;
import org.unicase.changetracking.ui.Activator;
import org.unicase.changetracking.ui.ImageAndTextLabel;
import org.unicase.metamodel.Project;
import org.unicase.model.UnicaseModelElement;
import org.unicase.workspace.ProjectSpace;
import org.unicase.workspace.WorkspaceManager;

/**
 * Dialog which allows to choose a location in which a newly created model
 * element is to be stored.
 * 
 * The dialog checks that the new model element can actually be put in a
 * location. If not, then the dialog does not allow to choose this location.
 * 
 * In addition, the name for the newly created element can be set here.
 * 
 * @author jfinis
 * 
 */
public class ModelElementPlacementDialog extends TitleAreaDialog {

	private static final Image PAGE_IMAGE = Activator.getImageDescriptor("icons/wizard/select_model_location.png").createImage();
	private static final Image NO_IMAGE = Activator.getImageDescriptor("icons/empty.png").createImage();
	private static final Object[] EMPTY = new Object[0];

	private UnicaseModelElement modelElement;
	private ImageAndTextLabel currentSelectionLabel;
	private EObject selection;
	private boolean allowNameChoosing;
	private Text nameInput;
	private String nameText;
	private ProjectSpace[] projects;
	private String defaultName;

	/**
	 * Retrieves the default name for the model element.
	 * 
	 * @return model element default name
	 */
	public String getDefaultName() {
		return defaultName;
	}

	/**
	 * Sets the default name for the model element. The default name is placed
	 * in the name field when the dialog is opened.
	 * 
	 * @param defaultName default name for the newly created element
	 */
	public void setDefaultName(String defaultName) {
		this.defaultName = defaultName;
	}

	/**
	 * Constructor with explicitly specified project spaces to be shown.
	 * 
	 * @param parentShell parent shell
	 * @param projects project space in which the model element can be placed
	 *            in.
	 * @param modelElement the model element to be placed.
	 * @param allowNameChoosing whether name choosing should be allowed.
	 */
	public ModelElementPlacementDialog(Shell parentShell, ProjectSpace[] projects, UnicaseModelElement modelElement, boolean allowNameChoosing) {
		super(parentShell);
		this.projects = projects;
		setBlockOnOpen(true);
		setShellStyle(getShellStyle() | SWT.RESIZE);
		this.modelElement = modelElement;
		this.allowNameChoosing = allowNameChoosing;
		this.defaultName = "New " + modelElement.eClass().getName();
	}

	/**
	 * Constructor which shows all project spaces in the current workspace, thus
	 * allowing to place the model element in any of the projects.
	 * 
	 * @param parentShell parent shell
	 * @param modelElement model element to be placed
	 * @param allowNameChoosing whether name choosing should be allowed.
	 */
	public ModelElementPlacementDialog(Shell parentShell, UnicaseModelElement modelElement, boolean allowNameChoosing) {
		this(parentShell, WorkspaceManager.getInstance().getCurrentWorkspace().getProjectSpaces().toArray(new ProjectSpace[0]), modelElement, allowNameChoosing);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	protected Point getInitialSize() {
		Point size = super.getInitialSize();
		if (size.y < 500) {
			size.y = 500;
		}
		return size;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	protected Control createDialogArea(Composite parent) {

		if (allowNameChoosing) {
			setTitle("Select Name and Location");
			setMessage("Select a name and location for the newly created " + modelElement.eClass().getName());
		} else {
			setTitle("Select Location");
			setMessage("Select location for the newly created " + modelElement.eClass().getName());
		}
		setTitleImage(PAGE_IMAGE);

		Composite outerWrap = (Composite) super.createDialogArea(parent);
		Composite wrap = createContentComposite(outerWrap, false, false);
		GridLayoutFactory.swtDefaults().numColumns(2).applyTo(wrap);
		AdapterFactoryLabelProvider labelProvider = new AdapterFactoryLabelProvider(new ComposedAdapterFactory(ComposedAdapterFactory.Descriptor.Registry.INSTANCE));

		if (allowNameChoosing) {
			ImageAndTextLabel nameLabel = new ImageAndTextLabel(wrap, SWT.NONE);
			nameLabel.setContent(labelProvider.getImage(modelElement), "Name:");
			nameInput = new Text(wrap, SWT.BORDER);
			GridDataFactory.fillDefaults().grab(true, false).applyTo(nameInput);
			nameInput.setText(defaultName);

			wrap = createContentComposite(outerWrap, true, true);
			GridLayoutFactory.swtDefaults().numColumns(2).applyTo(wrap);
		}

		Label location = new Label(wrap, SWT.NONE);
		location.setText("Select location");
		GridDataFactory.swtDefaults().span(2, 1).applyTo(location);
		TreeViewer viewer = new TreeViewer(wrap);
		GridDataFactory.swtDefaults().grab(true, true).span(2, 1).align(SWT.FILL, SWT.FILL).applyTo(viewer.getControl());

		viewer.setLabelProvider(labelProvider);
		viewer.setContentProvider(new ContentProvider());

		viewer.addSelectionChangedListener(new ISelectionChangedListener() {

			public void selectionChanged(SelectionChangedEvent event) {
				updateSelection(event.getSelection());
			}

		});
		viewer.setInput(projects);

		currentSelectionLabel = new ImageAndTextLabel(wrap, SWT.NONE, labelProvider);
		GridDataFactory.swtDefaults().align(SWT.FILL, SWT.FILL).grab(true, false).span(2, 1).applyTo(currentSelectionLabel);
		currentSelectionLabel.setContent(NO_IMAGE, "");

		Label titleBarSeparator = new Label(outerWrap, SWT.HORIZONTAL | SWT.SEPARATOR);
		titleBarSeparator.setLayoutData(new GridData(GridData.FILL_HORIZONTAL));

		return wrap;
	}

	private Composite createContentComposite(Composite outerWrap, boolean addSeperatorBefore, boolean grabVSpace) {
		if (addSeperatorBefore) {
			Label titleBarSeparator = new Label(outerWrap, SWT.HORIZONTAL | SWT.SEPARATOR);
			titleBarSeparator.setLayoutData(new GridData(GridData.FILL_HORIZONTAL));
		}
		Composite wrap = new Composite(outerWrap, SWT.NONE);
		GridDataFactory.fillDefaults().grab(true, grabVSpace).applyTo(wrap);
		return wrap;
	}

	@Override
	protected Control createButtonBar(Composite parent) {
		Control bar = super.createButtonBar(parent);
		getButton(Window.OK).setEnabled(false);
		return bar;
	}

	private void updateSelection(ISelection selection) {
		if (selection instanceof IStructuredSelection) {
			Object elem = ((IStructuredSelection) selection).getFirstElement();
			if (elem == null) {
				getButton(Window.OK).setEnabled(false);
				return;
			}
			EObject obj = (EObject) elem;
			this.selection = obj;
			currentSelectionLabel.setInput(obj);
			if (ChangeTrackingUtil.getPossibleContainingReference(modelElement, obj) == null) {
				setErrorMessage("The model element cannot be placed here.");
				getButton(Window.OK).setEnabled(false);

			} else {
				setErrorMessage(null);
				getButton(Window.OK).setEnabled(true);
			}
		}
	}

	@Override
	public boolean close() {
		// Save text so we can use it even after the widget is disposed
		this.nameText = nameInput.getText();
		return super.close();
	}

	/**
	 * Returns the model element into which the user decided to place the newly
	 * created element.
	 * 
	 * @return target model element for the placeent.
	 */
	public EObject getSelection() {
		return selection;
	}

	/**
	 * Returns the selected name. If name selection was disabled, this is equal
	 * to the previously set default name.
	 * 
	 * @return name for the newly created element.
	 */
	public String getSelectedName() {
		return nameText;
	}

	/**
	 * Content provider for displaying an array of project spaces and their
	 * contained projects.
	 * 
	 * @author jfinis
	 * 
	 */
	private static class ContentProvider extends AdapterFactoryContentProvider {

		public ContentProvider() {
			super(new ComposedAdapterFactory(ComposedAdapterFactory.Descriptor.Registry.INSTANCE));
		}

		/**
		 * {@inheritDoc}
		 * 
		 * @see org.unicase.ui.navigator.ContentProvider#getChildren(org.unicase.workspace.ProjectSpace)
		 */
		@Override
		public Object[] getElements(Object rootObject) {
			ProjectSpace[] projectSpaces;
			if (rootObject instanceof ProjectSpace[]) {
				projectSpaces = (ProjectSpace[]) rootObject;
			} else {
				return EMPTY;
			}
			return projectSpaces;
		}

		@Override
		public Object[] getChildren(Object object) {
			if (object instanceof ProjectSpace) {
				ProjectSpace projectSpace = (ProjectSpace) object;
				final Project project = projectSpace.getProject();
				if (project == null) {
					return EMPTY;
				}

				Collection<EObject> ret = new ArrayList<EObject>();
				EList<EObject> modelElements = project.getModelElementsByClass(EcoreFactory.eINSTANCE.createEObject().eClass(), new BasicEList<EObject>());
				// ugly hack to avoid dependency to model
				for (EObject modelElement : modelElements) {
					EObject econtainer = modelElement.eContainer();
					if ((econtainer instanceof Project) && modelElement.eClass().getName().equals("CompositeSection")) {
						ret.add(modelElement);
					}
				}
				ret.add(project);

				return ret.toArray();

			}
			return super.getChildren(object);
		}
	}
}
