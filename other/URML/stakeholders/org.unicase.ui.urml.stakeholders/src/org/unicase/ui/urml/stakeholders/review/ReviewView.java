/**
 * <copyright> Copyright (c) 2008-2009 Jonas Helming, Maximilian Koegel. All rights reserved. This program and the
 * accompanying materials are made available under the terms of the Eclipse Public License v1.0 which accompanies this
 * distribution, and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>
 */
package org.unicase.ui.urml.stakeholders.review;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Observable;
import java.util.Observer;
import java.util.Set;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.common.util.EMap;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.edit.provider.ComposedAdapterFactory;
import org.eclipse.emf.edit.ui.provider.AdapterFactoryLabelProvider;
import org.eclipse.jface.action.Action;
import org.eclipse.jface.action.IMenuManager;
import org.eclipse.jface.layout.GridLayoutFactory;
import org.eclipse.jface.viewers.ArrayContentProvider;
import org.eclipse.jface.viewers.CellLabelProvider;
import org.eclipse.jface.viewers.ILabelProvider;
import org.eclipse.jface.viewers.LabelProvider;
import org.eclipse.jface.viewers.TableViewer;
import org.eclipse.jface.viewers.TableViewerColumn;
import org.eclipse.jface.viewers.ViewerCell;
import org.eclipse.jface.viewers.ViewerFilter;
import org.eclipse.swt.SWT;
import org.eclipse.swt.custom.StackLayout;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.graphics.Rectangle;
import org.eclipse.swt.layout.FillLayout;
import org.eclipse.swt.layout.FormAttachment;
import org.eclipse.swt.layout.FormData;
import org.eclipse.swt.layout.FormLayout;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.layout.RowLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Event;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Listener;
import org.eclipse.swt.widgets.Sash;
import org.eclipse.ui.IActionBars;
import org.eclipse.ui.IWorkbenchPage;
import org.eclipse.ui.PartInitException;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.part.ViewPart;
import org.unicase.metamodel.Project;
import org.unicase.metamodel.util.ProjectChangeObserver;
import org.unicase.model.urml.StakeholderRole;
import org.unicase.model.urml.UrmlModelElement;
import org.unicase.ui.common.util.ComboView;
import org.unicase.ui.common.util.ComboView.IComboChangeListener;
import org.unicase.ui.unicasecommon.common.util.UnicaseActionHelper;
import org.unicase.ui.urml.stakeholders.Activator;
import org.unicase.ui.urml.stakeholders.ChangeObserverAdapter;
import org.unicase.ui.urml.stakeholders.StakeholderUtil;
import org.unicase.ui.urml.stakeholders.config.UrmlSettingsManager;
import org.unicase.ui.urml.stakeholders.filtering.ElementTypeFilter;
import org.unicase.ui.urml.stakeholders.filtering.ReviewStatusViewerFilter;

/**
 * The view for reviewing the urml model elements. 
 * It allows the creating of new references to a certain urml model element and the setting a model element as reviewed.
 * The type of model elements to be shown can be filtered. Moreover, the model elements can be filtered by their status.
 * @author kterzieva
 */

public class ReviewView extends ViewPart {

	private static final int WIDTH = 2000;
	private static final String NAVIGATION_VIEW_ID = "Stakeholders.view1";
	private TableViewer reviewElementsViewer;
	private ILabelProvider reviewViewLabelProvider;
	private TableViewerColumn viewerNameColumn;
	private Composite contentComposite;
	private Composite warningComposite;
	private Composite mainComposite;
	private Composite listComp;
	private Composite rightComposite, buttonComposite, editorComposite, navigatorComposite, referenceComposite;
	private Sash sash;
	private Button openModelElement, up, down;
	private ComboView<EClass> comboSelectBox;
	private ReviewViewElementContentFactory contentFactory;
	private ReviewController controller;
	private UrmlModelElement currentlyDisplayedElement;
	private StackLayout stackLayout;
	private Observer roleChangedObserver;
	private ProjectChangeObserver projectChangeObserver;
	private Project activeProject;
	private EClass currentlyShownType;

	 private static final Image UNREVIEWED_ICON = Activator.getImageDescriptor("icons/open.png").createImage();
	 private static final Image REVIEWED_ICON = Activator.getImageDescriptor("icons/closed.gif").createImage();

	@Override
	public void dispose() {
		super.dispose();
		controller.dispose();
		Activator.getRoleChangedPublisher().deleteObserver(roleChangedObserver);
		activeProject.removeProjectChangeObserver(projectChangeObserver);
	}

	@Override
	public void createPartControl( Composite parent) {
		activeProject = StakeholderUtil.getActiveProject();
		mainComposite = new Composite(parent, SWT.NONE);
		stackLayout = new StackLayout();
		mainComposite.setLayout(stackLayout);
		parent = new Composite(mainComposite, SWT.NONE);
		contentComposite = parent;    
		contentComposite.setLayout(new FillLayout(SWT.HORIZONTAL));
		createWarningComposite(mainComposite, stackLayout);
		// **** Creation of the UI Components ***
		createLeftSide(parent);
		// the sash (controller) is added to the main view
		sash = new Sash(parent, SWT.VERTICAL);
		createRightSide(parent);
		// Finally, after all UI components are created, set the global layout
		setupGlobalLayout(parent);

		// **** Create necessary fields ***
		contentFactory = new ReviewViewElementContentFactory(editorComposite);
		controller = new ReviewController(this, reviewElementsViewer);
		
		// *** Setup listeners for the different buttons and other UI actions
		setupListeners();
		createMenuActions();
		StakeholderRole role = UrmlSettingsManager.INSTANCE.getActiveRole();
		setInputFromRole(activeProject, role);	
	}

	private void createWarningComposite(Composite c, StackLayout layout) {
		RowLayout warningLayout = new RowLayout();
		warningLayout.center = true;
		warningLayout.type = SWT.VERTICAL;
		warningLayout.justify = true;
		warningComposite = new Composite(c, SWT.NONE); 
		Composite subComposite = new Composite(warningComposite, SWT.NONE);
		subComposite.setLayout(warningLayout);
		RowLayout outer = new RowLayout();
		outer.center = true;
		outer.justify = true;
		warningComposite.setLayout(outer);
		Label noRoleSet = new Label(subComposite, SWT.NONE);
		noRoleSet.setText("You must select a stakeholder role in the navigation view before you can start a review!");
		noRoleSet.setAlignment(SWT.CENTER);
		Button openNavigationView = new Button(subComposite, SWT.PUSH);
		openNavigationView.setText("Open navigation view");
		openNavigationView.addSelectionListener(new SelectionAdapter() {

			@Override
			public void widgetSelected(SelectionEvent e) {
				try {
					IWorkbenchPage page = PlatformUI.getWorkbench().getActiveWorkbenchWindow().getActivePage();
					 page.showView(NAVIGATION_VIEW_ID, null,
						IWorkbenchPage.VIEW_ACTIVATE);
				} catch (PartInitException e1) {
					e1.printStackTrace();
				}
			}
		});
		layout.topControl = warningComposite;
	}

	private void setReviewViewInput(Collection<UrmlModelElement> collection) {
		//After input has changed, no element is selected anymore.
		openElement(null);
		controller.setReviewViewInput(collection);
	}

	private void createMenuActions() {
		IActionBars bars = getViewSite().getActionBars();
		IMenuManager menuManager = bars.getMenuManager();
		final ViewerFilter filter = new ReviewStatusViewerFilter(true);
		final ViewerFilter filterUnreviewed = new ReviewStatusViewerFilter(
				false);

		Action showReviewed = new Action() {
			@Override
			public void run() {
				reviewElementsViewer.setFilters(new ViewerFilter[] { filter });
			}
		};

		showReviewed.setText("Show reviewed");
		showReviewed.setToolTipText("Shows the reviewed element.");
		showReviewed.setImageDescriptor(Activator
				.getImageDescriptor("icons/closed.gif"));
		menuManager.add(showReviewed);

		Action showUnreviewed = new Action() {

			@Override
			public void run() {
				reviewElementsViewer
						.setFilters(new ViewerFilter[] { filterUnreviewed });
			}
		};

		showUnreviewed.setText("Show unreviewed");
		showUnreviewed.setToolTipText("Shows only the unreviewed elements.");
		showUnreviewed.setImageDescriptor(Activator.getImageDescriptor("icons/open.png"));
		menuManager.add(showUnreviewed);

		Action showAll = new Action() {
			@Override
			public void run() {
				reviewElementsViewer.resetFilters();
			}
		};

		showAll.setText("Show all");
		showAll.setToolTipText("Show all element without filter settingss.");
		menuManager.add(showAll);
	}

	private void createLeftSide(final Composite parent) {
		// the list viewer (controller) is added to the maim view (parent)
		listComp = new Composite(parent, SWT.NONE);
		listComp.setLayout(new GridLayout(1, false));

		reviewViewLabelProvider = new AdapterFactoryLabelProvider(
				new ComposedAdapterFactory(ComposedAdapterFactory.Descriptor.Registry.INSTANCE));

		comboSelectBox = new ComboView<EClass>(listComp, SWT.BEGINNING);
		comboSelectBox.setLabelProvider(new LabelProvider() {
			@Override
			public String getText(Object element) {
				EClass eclassName = (EClass) element;
				if(eclassName == null){
					return "";
				}
				return eclassName.getName();
			}
		});

		comboSelectBox.getControl().setLayoutData(
				new GridData(SWT.BEGINNING, SWT.BEGINNING, false, false));

		reviewElementsViewer = new TableViewer(listComp, SWT.FULL_SELECTION);
		reviewElementsViewer.setContentProvider(ArrayContentProvider
				.getInstance());

		reviewElementsViewer.getControl().setLayoutData(
				new GridData(SWT.BEGINNING, SWT.FILL, false, true));

		TableViewerColumn viewerReviewStatusColumn = new TableViewerColumn(
				reviewElementsViewer, SWT.NONE);
		viewerReviewStatusColumn.getColumn().setText("Test");
		viewerReviewStatusColumn.getColumn().setWidth(36);

		// LabelProvider für jede Spalte setzen
		viewerReviewStatusColumn.setLabelProvider(new CellLabelProvider() {
			public void update(ViewerCell cell) {
				 if (((UrmlModelElement)cell.getElement()).isReviewed()) {
					 cell.setImage(REVIEWED_ICON);
				 } else {
					 cell.setImage(UNREVIEWED_ICON);
				 }
			}
		});

		viewerNameColumn = new TableViewerColumn(reviewElementsViewer, SWT.NONE);
		viewerNameColumn.getColumn().setText("Test");
		viewerNameColumn.getColumn().setWidth(WIDTH);
		viewerNameColumn.setLabelProvider(new CellLabelProvider() {
			public void update(ViewerCell cell) {
				cell.setText(reviewViewLabelProvider.getText(cell.getElement()));
				cell.setImage(reviewViewLabelProvider.getImage(cell
						.getElement()));
			}
		});

	}

	private void createRightSide(Composite parent) {

		// new composite for the right site
		rightComposite = new Composite(parent, SWT.NONE);
		GridLayout gridLay = new GridLayout(1, false);
		rightComposite.setLayout(gridLay);

		navigatorComposite = new Composite(rightComposite, SWT.NONE);
		GridLayout navigatorLayout = new GridLayout(2, false);
		navigatorComposite.setLayout(navigatorLayout);

		GridData navigatorCompositeLayoutData = new GridData(SWT.FILL,
				SWT.DEFAULT, false, false);
		navigatorComposite.setLayoutData(navigatorCompositeLayoutData);
		navigatorComposite.setBackground(Display.getCurrent().getSystemColor(
				SWT.COLOR_WHITE));

		// Create button composite
		buttonComposite = new Composite(navigatorComposite, SWT.NONE);
		GridLayout buttonLayout = new GridLayout(2, true);
		buttonComposite.setLayout(buttonLayout);

		// defines where the composite is located and how it looks like
		// we use GridData because of the parent layout
		GridData buttonCompositeLayoutData = new GridData(SWT.FILL,
				SWT.DEFAULT, false, false);
		buttonComposite.setLayoutData(buttonCompositeLayoutData);
		buttonComposite.setBackground(Display.getCurrent().getSystemColor(
				SWT.COLOR_WHITE));

		// Create buttons
		up = new Button(buttonComposite, SWT.PUSH);
		down = new Button(buttonComposite, SWT.PUSH);
		openModelElement = new Button(navigatorComposite, SWT.PUSH);
		openModelElement.setEnabled(false);

		GridData data = new GridData(SWT.FILL, SWT.DEFAULT, false, true);
		up.setLayoutData(data);
		up.setText("Up");
		up.setAlignment(SWT.CENTER);

		GridData dataDown = new GridData(SWT.FILL, SWT.DEFAULT, false, true);
		down.setLayoutData(dataDown);
		down.setText("Down");
		down.setAlignment(SWT.CENTER);

		GridData dataOpen = new GridData(SWT.END, SWT.DEFAULT, true, true);
		openModelElement.setLayoutData(dataOpen);
		openModelElement.setText("Open in MEE");
		openModelElement.setAlignment(SWT.CENTER);

		// Create empty editor composite
		editorComposite = new Composite(rightComposite, SWT.NONE);

		// defines how the children of editorComposite will be located, data for
		// the children
		GridLayoutFactory.swtDefaults().numColumns(2).spacing(10, 20)
				.applyTo(editorComposite);

		// defines how the editorComposite is located within rightComposite,
		// data for parent
		GridData editorCompositeLayoutData = new GridData(SWT.FILL, SWT.FILL,
				true, false);
		editorComposite.setLayoutData(editorCompositeLayoutData);
		editorComposite.setBackground(Display.getCurrent().getSystemColor(
				SWT.COLOR_WHITE));
		editorComposite.getParent().setBackground(
				Display.getCurrent().getSystemColor(SWT.COLOR_WHITE));

		referenceComposite = new Composite(rightComposite, SWT.NONE);
		GridLayout dangerLayout = new GridLayout(1, true);
		referenceComposite.setLayout(dangerLayout);

		GridData dangerCompositeLayoutData = new GridData(SWT.BEGINNING,
				SWT.DEFAULT, true, false);
		referenceComposite.setLayoutData(dangerCompositeLayoutData);
		referenceComposite.setBackground(Display.getCurrent().getSystemColor(
				SWT.COLOR_WHITE));

	}

	private void setupGlobalLayout(final Composite parent) {
		final FormLayout form = new FormLayout();
		parent.setLayout(form);

		
		// edges position of the leftData-controller can be set using form
		// attachments
		FormData leftData = new FormData();
		leftData.left = new FormAttachment(0, 0);
		leftData.right = new FormAttachment(sash, 0);
		leftData.top = new FormAttachment(0, 0);
		leftData.bottom = new FormAttachment(100, 0);

		listComp.setLayoutData(leftData);

		final int limit = 150, percent = 50;
		final FormData sashData = new FormData();
		sashData.left = new FormAttachment(percent, 0);
		sashData.top = new FormAttachment(0, 0);
		sashData.bottom = new FormAttachment(100, 0);
		sash.setLayoutData(sashData);

		sash.addListener(SWT.Selection, new Listener() {
			public void handleEvent(Event e) {
				Rectangle sashRect = sash.getBounds();
				Rectangle shellRect = parent.getClientArea();
				int right = shellRect.width - sashRect.width - limit;
				e.x = Math.max(Math.min(e.x, right), limit);
				viewerNameColumn.getColumn().setWidth(e.x - 5);
				if (e.x != sashRect.x) {
					sashData.left = new FormAttachment(0, e.x);
					parent.layout();
				}
			}
		});

		FormData rightData = new FormData();
		rightData.left = new FormAttachment(sash, 0);
		rightData.right = new FormAttachment(100, 0);
		rightData.top = new FormAttachment(0, 0);
		rightData.bottom = new FormAttachment(100, 0);
		rightComposite.setLayoutData(rightData);
	}

	private void setupListeners() {

		roleChangedObserver = new Observer() {
			@Override
			public void update(Observable o, Object role) {
				setInputFromRole(StakeholderUtil.getActiveProject(),
						(StakeholderRole) role);
			}
		};
		Activator.getRoleChangedPublisher().addObserver(roleChangedObserver);
		controller.addOpenListener(reviewElementsViewer);
		up.addSelectionListener(controller.createUpDownListener(true));
		down.addSelectionListener(controller.createUpDownListener(false));
		openModelElement.addSelectionListener(new SelectionAdapter() {

			@Override
			public void widgetSelected(SelectionEvent e) {
				UnicaseActionHelper.openModelElement(currentlyDisplayedElement,
						this.getClass().getName());
			}
		});

		comboSelectBox.addSelectionChangedListener(new IComboChangeListener<EClass>() {

					@Override
					public void selectionChanged(EClass newSelection) {
						showElementsOfType(newSelection);
					}
				});
		
		//Observer which reacts to deleted and added model elements by
		//refreshing the input if necessary
		projectChangeObserver = new ChangeObserverAdapter(){
			public void modelElementAdded(Project project, EObject modelElement) {
				if(currentlyShownType != null && currentlyShownType.isInstance(modelElement)){
					refreshInput();
				}
			}
			
			public void modelElementRemoved(Project project, EObject modelElement) {
				if(currentlyShownType != null && currentlyShownType.isInstance(modelElement)){
					refreshInput();
				}
			}
		};
		activeProject.addProjectChangeObserver(projectChangeObserver);
		
	}
	
	private void refreshInput(){
		ElementTypeFilter typeFilter = new ElementTypeFilter(
				currentlyShownType);
		Collection<UrmlModelElement> filteredElements = typeFilter.filter(StakeholderUtil
				.getUrmlElementsfromProjects(StakeholderUtil
						.getActiveProject()));
		setReviewViewInput(filteredElements);
	}
	
	private void showElementsOfType(EClass newSelection) {
		currentlyShownType = newSelection;
		refreshInput();
	}

	/**
	 * Open a model element in the review view and show set of its properties.
	 * @param urmlElement the urml element
	 */

	public void openElement(UrmlModelElement urmlElement) {
		this.currentlyDisplayedElement = urmlElement;
		openModelElement.setEnabled(urmlElement != null);
		contentFactory.createElementContent(urmlElement,
				UrmlSettingsManager.INSTANCE.getActiveRole());
	}

	@Override
	public void setFocus() {

	}

	/**
	 * Show only the reviewed elements using an appropriate filter.
	 * @param reviewed defines which elements should be shown. If it is false only
	 * the unreviewed elements will be shown.
	 */
	public void showOnlyReviewedElements(boolean reviewed) {
		ReviewStatusViewerFilter filter = new ReviewStatusViewerFilter(reviewed);
		reviewElementsViewer.setFilters(new ViewerFilter[] { filter });
	}

	/**
	 * Sets the input (set of model elements) to the review view depending on the role and the project.
	 * @param activeProject the project
	 * @param role the role review set defines which elements should be shown
	 */
	public void setInputFromRole(Project activeProject, StakeholderRole role) {
		if (role != null) {
			EMap<EClass, EList<EStructuralFeature>> reviewSetOfActiveRole = role.getReviewSet();
			Set<EClass> types = reviewSetOfActiveRole.keySet();
			comboSelectBox.setInput(types);
			stackLayout.topControl = contentComposite;
			comboSelectBox.getControl().pack();
			mainComposite.layout();
			EClass selection = comboSelectBox.getSelection();
			if (selection != null) {
				showElementsOfType(selection);
			}
		} else {
			comboSelectBox.setInput(new ArrayList<EClass>(0));
			stackLayout.topControl = warningComposite;
			comboSelectBox.getControl().pack();
			mainComposite.layout();
		}
	}
}
