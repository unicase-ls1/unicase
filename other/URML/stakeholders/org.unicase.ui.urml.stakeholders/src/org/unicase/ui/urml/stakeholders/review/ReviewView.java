/**
 * <copyright> Copyright (c) 2008-2009 Jonas Helming, Maximilian Koegel. All rights reserved. This program and the
 * accompanying materials are made available under the terms of the Eclipse Public License v1.0 which accompanies this
 * distribution, and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>
 */
package org.unicase.ui.urml.stakeholders.review;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.eclipse.emf.common.notify.Notification;
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
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.events.SelectionListener;
import org.eclipse.swt.graphics.Rectangle;
import org.eclipse.swt.layout.FormAttachment;
import org.eclipse.swt.layout.FormData;
import org.eclipse.swt.layout.FormLayout;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Event;
import org.eclipse.swt.widgets.Listener;
import org.eclipse.swt.widgets.Sash;
import org.eclipse.ui.IActionBars;
import org.eclipse.ui.part.ViewPart;
import org.unicase.ecp.model.NoWorkspaceException;
import org.unicase.metamodel.Project;
import org.unicase.metamodel.util.ModelElementChangeListener;
import org.unicase.metamodel.util.ModelUtil;
import org.unicase.model.urml.StakeholderRole;
import org.unicase.model.urml.UrmlModelElement;
import org.unicase.ui.common.util.ComboView;
import org.unicase.ui.common.util.ComboView.IComboChangeListener;
import org.unicase.ui.unicasecommon.common.util.UnicaseActionHelper;
import org.unicase.ui.urml.stakeholders.Activator;
import org.unicase.ui.urml.stakeholders.config.UrmlSettingsManager;
import org.unicase.ui.urml.stakeholders.filtering.ReviewedFilter;
import org.unicase.ui.urml.stakeholders.review.input.UrmlTreeHandler;

/**
 * The view for reviewing the requirements. It provides the creating of new danger/hazards
 * 
 * @author kterzieva
 */

public class ReviewView extends ViewPart {

	private TableViewer elementsViewer;
	private ReviewViewController listenerHandler;
	private ILabelProvider reviewViewLabelProvider;
	private TableViewerColumn viewerNameColumn;
	private Composite rightComposite, buttonComposite, editorComposite, navigatorComposite, referenceComposite;
	private Sash sash;
	private ReviewViewContentFactory contentFactory;
	private UrmlModelElement currentlyDisplayedElement;
	private Button openModelElement, up, down;
	private Composite comp;
	private ComboView<EClass> comboSelectBox;

	// private static final Image UNREVIEWED_ICON = Activator.getImageDescriptor("icons/open.png").createImage();
	// private static final Image REVIEWED_ICON = Activator.getImageDescriptor("icons/closed.gif").createImage();

	@Override
	public void dispose() {
		super.dispose();
		listenerHandler.dispose();
	}

	@Override
	public void createPartControl(final Composite parent) {

		// **** Creation of the UI Components ***
		createLeftSide(parent);
		// the sash (controller) is added to the main view
		sash = new Sash(parent, SWT.VERTICAL);
		createRightSide(parent);
		// Finally, after all UI components are created, set the global layout
		setupGlobalLayout(parent);

		// **** Create necessary fields ***
		contentFactory = new ReviewViewContentFactory(editorComposite);
		listenerHandler = new ReviewViewController(this, elementsViewer);

		// *** Setup listeners for the different buttons and other UI actions ***
		setupListeners();

		createShowReviewedElementsAction(elementsViewer.getInput());

		// Test code for filling the view with elements. To be replaced later

//		 try {
//		 if(StakeholderView.getActiveRole()!= null){
//		 setReviewViewInput(UrmlTreeHandler.getUrmlElementsfromProjects(UrmlTreeHandler.getTestProject()), null);
//		 }
//		 // indexHandler.setInput(UrmlTreeHandler.getRequirementsfromProjects(UrmlTreeHandler.getTestProject()));
//		 // later getStakeholderElementSet(stakeholder);
//		 } catch (NoWorkspaceException e1) {
//		 e1.printStackTrace();
//		 }
	}

	private void setReviewViewInput(Collection<UrmlModelElement> collection, EClass filterToClass) {
		// save the elements in a separate lists for index element mapping
		List<UrmlModelElement> curContent = listenerHandler.getCurContent();
		curContent.clear();
		for (UrmlModelElement e : collection) {
			if (filterToClass.isSuperTypeOf(e.eClass())) {
				curContent.add(e);
			}
		}
		elementsViewer.setInput(curContent);
		for (final UrmlModelElement urmlElement : collection) {
			ModelElementChangeListener listener = new ModelElementChangeListener() {

				@Override
				public void onRuntimeExceptionInListener(RuntimeException exception) {

				}

				@Override
				public void onChange(Notification notification) {
					Object notificationFeature = notification.getFeature();
					if (notification.getEventType() == Notification.RESOLVE) {
						return;
					}
					Object nameFeature = urmlElement.eClass().getEStructuralFeature("name");
					Object reviewedFeature = urmlElement.eClass().getEStructuralFeature("reviewed");
					if (notificationFeature.equals(nameFeature) || notificationFeature.equals(reviewedFeature)) {
						elementsViewer.refresh();
					} else {
						return;
					}
				}
			};
			listenerHandler.getListeners().put(listener, urmlElement);
			urmlElement.addModelElementChangeListener(listener);
		}
	}

	private void createShowReviewedElementsAction(Object input) {
		IActionBars bars = getViewSite().getActionBars();
		IMenuManager menuManager = bars.getMenuManager();
		createReviewedFilter(menuManager);

	}

	private void createReviewedFilter(IMenuManager menuManager) {
		final ViewerFilter filter = new ReviewedFilter(true);
		final ViewerFilter filterUnreviewed = new ReviewedFilter(false);

		Action showReviewed = new Action() {
			@Override
			public void run() {
				elementsViewer.setFilters(new ViewerFilter[] { filter });
			}
		};

		showReviewed.setText("Show reviewed");
		showReviewed.setToolTipText("Shows the reviewed element.");
		showReviewed.setImageDescriptor(Activator.getImageDescriptor("icons/closed.gif"));
		menuManager.add(showReviewed);

		Action showUnreviewed = new Action() {

			@Override
			public void run() {
				elementsViewer.setFilters(new ViewerFilter[] { filterUnreviewed });
			}
		};

		showUnreviewed.setText("Show unreviewed");
		showUnreviewed.setToolTipText("Shows only the unreviewed elements.");
		showUnreviewed.setImageDescriptor(Activator.getImageDescriptor("icons/open.png"));
		menuManager.add(showUnreviewed);

		Action showAll = new Action() {
			@Override
			public void run() {
				elementsViewer.resetFilters();
			}
		};

		showAll.setText("Show all");
		showAll.setToolTipText("Show all element without filter settingss.");
		// showAll.setImageDescriptor(Activator.getImageDescriptor("icons/closed.gif"));
		menuManager.add(showAll);
	}

	private void createLeftSide(final Composite parent) {
		// the list viewer (controller) is added to the maim view (parent)

		comp = new Composite(parent, SWT.NONE);
		comp.setLayout(new GridLayout(1, false));

		reviewViewLabelProvider = new AdapterFactoryLabelProvider(new ComposedAdapterFactory(
			ComposedAdapterFactory.Descriptor.Registry.INSTANCE));

		comboSelectBox = new ComboView<EClass>(comp, SWT.BEGINNING);
		comboSelectBox.setLabelProvider(new LabelProvider() {
			@Override
			public String getText(Object element) {
				EClass eclassName = (EClass) element;
				return eclassName.getName();
			}
		});

		// FIXME Review view must work, even if no role is chosen
		EMap<EClass, EList<EStructuralFeature>> reviewSetOfActiveRole = UrmlSettingsManager.INSTANCE.getActiveRole().getReviewSet();

		comboSelectBox.setInput(reviewSetOfActiveRole.keySet());

		elementsViewer = new TableViewer(comp, SWT.FULL_SELECTION);
		elementsViewer.setContentProvider(ArrayContentProvider.getInstance());

		elementsViewer.getControl().setLayoutData(new GridData(SWT.BEGINNING, SWT.FILL, false, true));
		// elementsViewer.setLabelProvider(reviewViewLabelProvider);

		TableViewerColumn viewerReviewStatusColumn = new TableViewerColumn(elementsViewer, SWT.NONE);
		viewerReviewStatusColumn.getColumn().setText("Test");
		viewerReviewStatusColumn.getColumn().setWidth(36);

		// LabelProvider für jede Spalte setzen
		viewerReviewStatusColumn.setLabelProvider(new CellLabelProvider() {
			public void update(ViewerCell cell) {
				// if (test.isReviewed()) {
				// cell.setImage(REVIEWED_ICON);
				// } else {
				// cell.setImage(UNREVIEWED_ICON);
				// }
			}
		});

		viewerNameColumn = new TableViewerColumn(elementsViewer, SWT.NONE);
		viewerNameColumn.getColumn().setText("Test");
		viewerNameColumn.getColumn().setWidth(2000);
		// LabelProvider für jede Spalte setzen
		viewerNameColumn.setLabelProvider(new CellLabelProvider() {
			public void update(ViewerCell cell) {
				cell.setText(reviewViewLabelProvider.getText(cell.getElement()));
				cell.setImage(reviewViewLabelProvider.getImage(cell.getElement()));
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

		GridData navigatorCompositeLayoutData = new GridData(SWT.FILL, SWT.DEFAULT, false, false);
		navigatorComposite.setLayoutData(navigatorCompositeLayoutData);
		navigatorComposite.setBackground(Display.getCurrent().getSystemColor(SWT.COLOR_WHITE));

		// Create button composite
		buttonComposite = new Composite(navigatorComposite, SWT.NONE);
		GridLayout buttonLayout = new GridLayout(2, true);
		buttonComposite.setLayout(buttonLayout);

		// defines where the composite is located and how it looks like
		// we use GridData because of the parent layout
		GridData buttonCompositeLayoutData = new GridData(SWT.FILL, SWT.DEFAULT, false, false);
		buttonComposite.setLayoutData(buttonCompositeLayoutData);
		buttonComposite.setBackground(Display.getCurrent().getSystemColor(SWT.COLOR_WHITE));

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

		// defines how the children of editorComposite will be located, data for the children
		GridLayoutFactory.swtDefaults().numColumns(2).spacing(10, 20).applyTo(editorComposite);

		// defines how the editorComposite is located within rightComposite, data for parent
		GridData editorCompositeLayoutData = new GridData(SWT.FILL, SWT.FILL, true, false);
		editorComposite.setLayoutData(editorCompositeLayoutData);
		editorComposite.setBackground(Display.getCurrent().getSystemColor(SWT.COLOR_WHITE));
		editorComposite.getParent().setBackground(Display.getCurrent().getSystemColor(SWT.COLOR_WHITE));

		referenceComposite = new Composite(rightComposite, SWT.NONE);
		GridLayout dangerLayout = new GridLayout(1, true);
		referenceComposite.setLayout(dangerLayout);

		GridData dangerCompositeLayoutData = new GridData(SWT.BEGINNING, SWT.DEFAULT, true, false);
		referenceComposite.setLayoutData(dangerCompositeLayoutData);
		referenceComposite.setBackground(Display.getCurrent().getSystemColor(SWT.COLOR_WHITE));

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

		comp.setLayoutData(leftData);

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

		listenerHandler.createOpenListener(elementsViewer);
		up.addSelectionListener(listenerHandler.createUpDownListener(true));
		down.addSelectionListener(listenerHandler.createUpDownListener(false));

		openModelElement.addSelectionListener(new SelectionListener() {

			@Override
			public void widgetSelected(SelectionEvent e) {
				UnicaseActionHelper.openModelElement(currentlyDisplayedElement, this.getClass().getName());
			}

			@Override
			public void widgetDefaultSelected(SelectionEvent e) {

			}
		});

		comboSelectBox.addSelectionChangedListener(new IComboChangeListener<EClass>() {

			@Override
			public void selectionChanged(EClass newSelection) {
				try {
					setReviewViewInput(UrmlTreeHandler.getUrmlElementsfromProjects(UrmlTreeHandler.getTestProject()),
						newSelection);
				} catch (NoWorkspaceException e) {

					ModelUtil.logException(e);

				}

			}
		});
	}

	/**
	 * Open a model element in the review view.
	 * 
	 * @param urmlElement the urml element
	 */

	public void openElement(UrmlModelElement urmlElement) {
		this.currentlyDisplayedElement = urmlElement;
		openModelElement.setEnabled(true);
		contentFactory.createElementContent(urmlElement, UrmlSettingsManager.INSTANCE.getActiveRole());
	}

	@Override
	public void setFocus() {

	}

	/**
	 * Show only the reviewed elements using an appropriate filter.
	 * 
	 * @param reviewed defines which elements should be shown. If it is false only the unreviewed elements will be
	 *            shown.
	 */
	public void showOnlyReviewedElements(boolean reviewed) {
		ReviewedFilter filter = new ReviewedFilter(reviewed);
		elementsViewer.setFilters(new ViewerFilter[] { filter });
	}

	/**
	 * Sets the input to the review view depending on the role and the project.
	 * 
	 * @param activeProject the project
	 * @param role the role review set defines which elements should be shown
	 */
	public void setInputFromRole(Project activeProject, StakeholderRole role) {
//		Collection<UrmlModelElement> result = new ArrayList<UrmlModelElement>();
//		if (role == null) {
//			setReviewViewInput(result);
//		}
//
//		Set<EObject> modelElementSet = activeProject.getAllModelElements();
//
//		// Set<EClass> reviewClassNames = new HashSet<EClass>();
//		// for(Entry<EClass, EList<EStructuralFeature>> entry : role.getReviewSet()){
//		// reviewClassNames.add(entry.getKey());
//		// }
//		EMap<EClass, EList<EStructuralFeature>> reviewSet = role.getReviewSet();
//		for (EObject e : modelElementSet) {
//			if (e instanceof UrmlModelElement) {
//				// (((UrmlModelElement) e).eClass().getName()))
//				if (reviewSet.containsKey(e.eClass())) {
//					result.add((UrmlModelElement) e);
//				}
//			}
//		}
//		setReviewViewInput(result);
	}

	/**
	 * Test.
	 * 
	 */
	public void clearInputFromRole() {
		Collection<UrmlModelElement> result = new ArrayList<UrmlModelElement>();
		setReviewViewInput(result, null);

	}

}
