/**
 * <copyright> Copyright (c) 2008 Jonas Helming, Maximilian Koegel. All rights reserved. This program and the
 * accompanying materials are made available under the terms of the Eclipse Public License v1.0 which accompanies this
 * distribution, and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>
 */
package org.unicase.ui.tableview;

import org.eclipse.swt.widgets.Composite;
import org.eclipse.ui.part.ViewPart;

/**
 * A specialized UnicaseTableView to display all Attributes of model element.
 * 
 * @author Abdelhamid Barzali.
 */
public class UnicaseTableView extends ViewPart {

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.ui.part.WorkbenchPart#createPartControl(org.eclipse.swt.widgets.Composite)
	 */
	@Override
	public void createPartControl(Composite parent) {

	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.ui.part.WorkbenchPart#setFocus()
	 */
	@Override
	public void setFocus() {

	}

	// private TableViewer tableViewer;
	// private ILabelProvider labelProvider;
	// private IMenuManager mgr;
	// private AdapterFactoryItemDelegator adapterFactoryItemDelegator;
	// private Action removecolumnsaction;
	// private ArrayList<Action> actionlist;
	// private Separator actionseparator;
	//
	// /**
	// * the Constructor.
	// */
	// public UnicaseTableView() {
	// setAdapterFactoryItemDelegator(new AdapterFactoryItemDelegator(new ComposedAdapterFactory(
	// ComposedAdapterFactory.Descriptor.Registry.INSTANCE)));
	//
	// setActionlist(new ArrayList<Action>());
	// setLabelProvider(new MEClassLabelProvider());
	//
	// setActionseparator(new Separator());
	//
	// getActionseparator().setId("actionseperator"); // set the ID needed for not delete removecolumnsaction .// see
	// // also removeActions().
	// }
	//
	// /**
	// * @return ILabelProvider.
	// */
	// public ILabelProvider getLabelProvider() {
	// return labelProvider;
	// }
	//
	// /**
	// * @param labelProvider ILabelProvider.
	// */
	// public void setLabelProvider(ILabelProvider labelProvider) {
	// this.labelProvider = labelProvider;
	// }
	//
	// /**
	// * Method is responsible to create all UnicaseTableView widgets .
	// *
	// * @param parent the Composite for widgets .
	// * @see org.eclipse.ui.part.WorkbenchPart#createPartControl(org.eclipse.swt.widgets.Composite)
	// */
	// @Override
	// public void createPartControl(Composite parent) {
	//
	// getSite().getPage().getWorkbenchWindow().getSelectionService().addSelectionListener(this);
	// setTableViewer(new TableViewer(parent, SWT.FULL_SELECTION | SWT.MULTI | SWT.BORDER));
	// getTableViewer().setContentProvider(new TableViewAdapterFactContentProvider());
	// // create Menu actions.
	// createMenuActions();
	//
	// getSite().setSelectionProvider(getTableViewer());
	// getTableViewer().addSelectionChangedListener(this);
	// // Registers a pop-up menu with the default id for extension.
	// // The default id is defined as the part id.
	// MenuManager menuMgr = new MenuManager();
	// getSite().registerContextMenu(menuMgr, getTableViewer());
	// Control control = getTableViewer().getControl();
	// if (control != null) {
	// Menu menu = menuMgr.createContextMenu(control);
	// control.setMenu(menu);
	// }
	// ActionHelper.createKeyHookDCAction(getTableViewer(), UnicaseTableView.class.getName());
	//
	// }
	//
	// /**
	// * @return ArrayList of {@link Action}s .
	// */
	// public ArrayList<Action> getActionlist() {
	// return actionlist;
	// }
	//
	// /**
	// * @param actionlist ArrayList of ContextMenu {@link Action}s
	// */
	// public void setActionlist(ArrayList<Action> actionlist) {
	// this.actionlist = actionlist;
	// }
	//
	// /**
	// * This returns TableViewer of UnicaseTableView.
	// *
	// * @return TableViewer of UnicaseTableView.
	// */
	// public TableViewer getTableViewer() {
	// return tableViewer;
	// }
	//
	// /**
	// * @param tableViewer TableViewer .
	// */
	// public void setTableViewer(TableViewer tableViewer) {
	// this.tableViewer = tableViewer;
	// }
	//
	// /**
	// * @see org.eclipse.ui.part.WorkbenchPart#setFocus()
	// */
	// @Override
	// public void setFocus() {
	// Control control = getTableViewer().getControl();
	// if (control != null) {
	// if (!control.isFocusControl()) {
	// control.setFocus();
	// UnicaseTableViewUtil.updateSLManager(getTableViewer(), null);
	// }
	//
	// }
	//
	// }
	//
	// /**
	// * create menu actions.
	// */
	// private void createMenuActions() {
	//
	// IActionBars bars = getViewSite().getActionBars();
	// IToolBarManager menuManager = bars.getToolBarManager();
	// setMenuManager(bars.getMenuManager());
	// setRemovecolumnsaction(createClearColumnsAction(getTableViewer(), getActionlist()));
	// getMenuManger().add(getRemovecolumnsaction());
	//
	// getMenuManger().add(getActionseparator());
	// menuManager.add(UnicaseTableViewUtil.createRefreshAction(getTableViewer()));
	// menuManager.add(createMEFilterAction());
	//
	// }
	//
	// /**
	// * @return {@link Separator}.
	// */
	// public Separator getActionseparator() {
	// return actionseparator;
	// }
	//
	// /**
	// * @param actionseparator {@link Separator}.
	// */
	// public void setActionseparator(Separator actionseparator) {
	// this.actionseparator = actionseparator;
	// }
	//
	// /**
	// * @return Action.
	// */
	// private Action getRemovecolumnsaction() {
	// return removecolumnsaction;
	// }
	//
	// /**
	// * @param removecolumnsaction Action.
	// */
	// private void setRemovecolumnsaction(Action removecolumnsaction) {
	// this.removecolumnsaction = removecolumnsaction;
	// }
	//
	// /**
	// * @return {@link IMenuManager}.
	// */
	// private IMenuManager getMenuManger() {
	// return mgr;
	// }
	//
	// /**
	// * @param mgr {@link IMenuManager}.
	// */
	//
	// private void setMenuManager(IMenuManager mgr) {
	// this.mgr = mgr;
	// }
	//
	// /**
	// * @return AdapterFactoryItemDelegator
	// */
	// private AdapterFactoryItemDelegator getAdapterFactoryItemDelegator() {
	// return adapterFactoryItemDelegator;
	// }
	//
	// /**
	// * @param adapterFactoryItemDelegator AdapterFactoryItemDelegator.
	// */
	// private void setAdapterFactoryItemDelegator(AdapterFactoryItemDelegator adapterFactoryItemDelegator) {
	// this.adapterFactoryItemDelegator = adapterFactoryItemDelegator;
	// }
	//
	// /**
	// * @return instance of Class ModelelmentsFilterAction.
	// */
	// private Action createMEFilterAction() {
	// return new ModelelmentsFilterAction("filter");
	// }
	//
	// /**
	// *
	// */
	// private void removeActions() {
	//
	// IContributionItem[] items = getMenuManger().getItems();
	// for (IContributionItem contributionItem : items) {
	// if (!contributionItem.getId().equals(getRemovecolumnsaction().getId())
	// && !contributionItem.getId().equals(getActionseparator().getId())) {
	//
	// getMenuManger().remove(contributionItem);
	//
	// }
	// }
	//
	// }
	//
	// /**
	// * Adds an action as a contribution item to {@link MenuManager}.
	// *
	// * @param modelElement {@link ModelElement}.
	// */
	// private void createGenericContextMenu(ModelElement modelElement) {
	// // Removes all of the elements from this list.
	// getActionlist().clear();
	// // remove Actions.
	// removeActions();
	//
	// Table table = getTableViewer().getTable();
	// SetColumnAction action = null;
	// String itemstr = "";
	//
	// for (final IItemPropertyDescriptor propertydescriptor : getPropertyDescriptors(modelElement)) {
	//
	// if (!propertydescriptor.isMany(modelElement)) {
	//
	// action = new SetColumnAction(getTableViewer(), modelElement, propertydescriptor);
	//
	// getActionlist().add(action);
	// itemstr = propertydescriptor.getDisplayName(action);
	// if (table != null) {
	// TableColumn[] columns = table.getColumns();
	// for (TableColumn column : columns) {
	// if (column.getText() == itemstr || column.getText().equals(itemstr)) {
	// action.setChecked(true);
	// }
	// }
	//
	// }
	// getMenuManger().add(action);
	// }
	// }
	// }
	//
	// /**
	// * @param tableViewer {@link TableViewer}.
	// * @param actions List.
	// * @return {@link Action}.
	// */
	// public Action createClearColumnsAction(final TableViewer tableViewer, final List<Action> actions) {
	//
	// final Action removecolumnsaction = new Action("remove Columns") {
	// @Override
	// public void run() {
	// for (Action action : actions) {
	// if (action.getId().equals("Name")) {
	// action.setChecked(true);
	// } else {
	// action.setChecked(false);
	// }
	//
	// }
	// // clear all Columns.
	// UnicaseTableViewUtil.removeColumns(tableViewer);
	//
	// }
	// };
	// // set the ID needed for not delete removecolumnsaction .
	// // see also removeActions()
	// removecolumnsaction.setId("remove Columns");
	// removecolumnsaction.setToolTipText("remove Columns");
	// removecolumnsaction.setImageDescriptor(Activator.getImageDescriptor("/icons/delete.gif"));
	// return removecolumnsaction;
	//
	// }
	//
	// /**
	// * This method takes a ModelElement and initializes the the first three columns (TableViewer's header row) with
	// * names of its ( first three) attributes .
	// *
	// * @param modelElement {@link ModelElement}.
	// */
	// private void setStandartColumns(ModelElement modelElement) {
	// int columncounter = 0;
	//
	// UnicaseTableViewUtil.removeColumns(getTableViewer());
	//
	// // getMenuManger().update();
	// Table table = getTableViewer().getTable();
	//
	// // Clears all the items in the TableViewer.
	// TableColumn[] colmns = null;
	// if (table != null) {
	// colmns = table.getColumns();
	// for (TableColumn tableColumn : colmns) {
	// tableColumn.dispose();
	// }
	// table.clearAll();
	// table.removeAll();
	// }
	// List<IItemPropertyDescriptor> propertyDescriptors = getPropertyDescriptors(modelElement);
	// String displaynam = "";
	// ColumnLabelProvider attributeLabelProvider = null;
	// ViewerComparator comp = null;
	//
	// for (IItemPropertyDescriptor propertyDescriptor : propertyDescriptors) {
	// displaynam = propertyDescriptor.getDisplayName(modelElement);
	//
	// if (!propertyDescriptor.isMany(modelElement)) {
	//
	// EStructuralFeature estructuralfeature = (EStructuralFeature) propertyDescriptor
	//
	// .getFeature(modelElement);
	//
	// if (estructuralfeature.getEType().getInstanceClass().equals(boolean.class)) {
	// estructuralfeature = TaskPackage.Literals.CHECKABLE__CHECKED;
	// }
	//
	// if (estructuralfeature.getEType().equals(EcorePackage.Literals.EDATE)) {
	// attributeLabelProvider = new DateColumnLabelProvider(estructuralfeature);
	// }
	//
	// else if (displaynam.equalsIgnoreCase("status")) {
	// attributeLabelProvider = new StatusLabelProvider();
	// } else {
	// attributeLabelProvider = new MEAttributeLabelProvider(propertyDescriptor, estructuralfeature);
	//
	// }
	//
	// TableViewerColumn column = new TableViewerColumn(getTableViewer(), SWT.CENTER);
	// column.getColumn().setText(displaynam);
	// column.getColumn().setWidth(100 + displaynam.length() * 10);
	// column.getColumn().setMoveable(true);
	// column.getColumn().setResizable(true);
	//
	// column.getColumn().setAlignment(SWT.CENTER);
	// column.setLabelProvider(attributeLabelProvider);
	//
	// if (displaynam.equalsIgnoreCase("status")) {
	// comp = new StatusSorter(getTableViewer(), column, attributeLabelProvider);
	//
	// } else {
	// comp = new TableViewerColumnSorter(getTableViewer(), column, attributeLabelProvider);
	// }
	//
	// column.getViewer().setComparator(comp);
	// columncounter++;
	//
	// }
	// // create just three columns. (the Remainder per ContextMenu).
	// if (columncounter > 3) {
	// break;
	// }
	//
	// }
	//
	// getTableViewer().getTable().setLinesVisible(true);
	// getTableViewer().getTable().setHeaderVisible(true);
	//
	// }
	//
	// /**
	// * This does the same thing as IPropertySource.getPropertyDescriptors.
	// *
	// * @param modelElement {@link ModelElement}.
	// * @return List of IItemPropertyDescriptors.
	// */
	// private List<IItemPropertyDescriptor> getPropertyDescriptors(Object modelElement) {
	// List<IItemPropertyDescriptor> propertyDescriptors = getAdapterFactoryItemDelegator().getPropertyDescriptors(
	// modelElement);
	// return propertyDescriptors;
	// }
	//
	// /**
	// * needed to update the status line manager and selected {@link ModelElement}.
	// *
	// * @param event the Event.
	// * @see
	// org.eclipse.jface.viewers.ISelectionChangedListener#selectionChanged(org.eclipse.jface.viewers.SelectionChangedEvent)
	// */
	// public void selectionChanged(SelectionChangedEvent event) {
	// Object selectedobj = event.getSelection();
	//
	// if (selectedobj instanceof StructuredSelection) {
	// IStructuredSelection selection = (IStructuredSelection) selectedobj;
	// Object selctedme = selection.getFirstElement();
	// if (selctedme instanceof ModelElement) {
	//
	// ModelElement model = (ModelElement) selctedme;
	// Image icon = getLabelProvider().getImage(model);
	// UnicaseTableViewUtil.updateSLManager(getTableViewer(), icon);
	// }
	// }
	//
	// }
	//
	// /**
	// * . Extract the selected {@link Project} in navigator .
	// *
	// * @param part the IWorkbenchPart.
	// * @param selection ISelection.
	// * @see
	// org.eclipse.ui.ISelectionListener#selectionChanged(org.eclipse.ui.IWorkbenchPart,org.eclipse.jface.viewers.ISelection)
	// */
	// public void selectionChanged(IWorkbenchPart part, ISelection selection) {
	//
	// if (selection.isEmpty()) {
	// Table table = getTableViewer().getTable();
	// if (table != null) {
	// getTableViewer().getTable().deselectAll();
	// }
	//
	// return;
	// }
	// if (!part.getSite().getId().equals("org.unicase.ui.navigator.viewer")) {
	//
	// return;
	// }
	// checkCurrentProject(selection);
	// }
	//
	// /**
	// * @param selection {@link ISelection}.
	// */
	// private void checkCurrentProject(ISelection selection) {
	//
	// if (selection instanceof StructuredSelection) {
	//
	// IStructuredSelection istructed = (IStructuredSelection) selection;
	// Object selectedobj = istructed.getFirstElement();
	// Project project = null;
	// if (selectedobj instanceof ProjectSpace) {
	// checkProject(selectedobj);
	// } else if (selectedobj instanceof ModelElement) {
	// checkMeProject(selectedobj, project);
	// }
	// }
	//
	// }
	//
	// /**
	// * @param selectedobj Object.
	// * @param project Project.
	// */
	// private void checkMeProject(Object selectedobj, Project project) {
	// ModelElement mee = (ModelElement) selectedobj;
	// Project meproject = mee.getProject();
	// if (meproject != null && UnicaseTableViewUtil.getAllProjectMEs() != null) {
	// if (meproject != project || !meproject.equals(project)) {
	// if (getTableViewer().getTable().getColumnCount() > 0) {
	// getTableViewer().setInput(UnicaseTableViewUtil.getAllProjectMEs());
	// }
	// }
	// }
	// }
	//
	// /**
	// * check the value of the 'Active Project Space' .
	// *
	// * @param selectedobj Object.
	// */
	// private void checkProject(Object selectedobj) {
	// Project project;
	// ProjectSpace projectspace = (ProjectSpace) selectedobj;
	// project = projectspace.getProject();
	//
	// if (project != null && UnicaseTableViewUtil.getAllProjectMEs() != null) {
	// if (getTableViewer().getTable().getColumnCount() > 0) {
	// getTableViewer().setInput(UnicaseTableViewUtil.getAllProjectMEs());
	// getTableViewer().refresh();
	// }
	//
	// }
	// }
	//
	// /**
	// * @see org.eclipse.ui.part.WorkbenchPart#dispose()
	// */
	// @Override
	// public void dispose() {
	// // Removes the given selection listener.
	// getSite().getWorkbenchWindow().getSelectionService().removeSelectionListener(this);
	// if (getTableViewer() != null) {
	// getTableViewer().removeSelectionChangedListener(this);
	// Control control = getTableViewer().getControl();
	// if (control != null && !control.isDisposed()) {
	// control.dispose();
	// }
	// // Disposes of this content provider.
	// // This is called by the viewer when it is disposed.
	// IContentProvider contentProvider = getTableViewer().getContentProvider();
	// if (contentProvider != null) {
	//
	// contentProvider.dispose();
	// }
	// }
	// // Disposes of this label provider.
	// if (getLabelProvider() != null) {
	// getLabelProvider().dispose();
	// }
	// getActionlist().clear();
	// // Disposes of this contribution item.
	// if (!getMenuManger().equals(null)) {
	// getMenuManger().removeAll();
	// getMenuManger().dispose();
	//
	// }
	//
	// super.dispose();
	//
	// }
	//
	// /**
	// * this {@link Action} shows Dialog to select elements out of a list of elements. Returns the first Object of all
	// * non-abstract, non-interface subclasses of the given input. Looks in whole graph starting from the root package
	// -
	// * i.e. ModelPackage. Returns null if no element has been selected.
	// *
	// * @author abdelhamidbarzali .
	// */
	// public class ModelelmentsFilterAction extends Action {
	//
	// /**
	// * the Constructor.
	// */
	// public ModelelmentsFilterAction() {
	// super();
	// }
	//
	// /**
	// * the Constructor.
	// *
	// * @param filteraction String .
	// */
	// public ModelelmentsFilterAction(String filteraction) {
	// super(filteraction);
	// setHoverImageDescriptor(Activator.getImageDescriptor("/icons/filter.png"));
	// setToolTipText("filter model elements");
	// }
	//
	// /**
	// * @see org.eclipse.jface.action.Action#run()
	// */
	// @Override
	// public void run() {
	//
	// EClass model = UnicaseTableViewUtil.showAllMEsTypeDialog(getShell(), ModelUtil
	// .getSubclasses(ModelPackage.eINSTANCE.getModelElement()), getLabelProvider());
	//
	// if (model == null || model.equals(null)) {
	//
	// return;
	// }
	// // Discards this viewer's filters and triggers
	// // refiltering and resorting of the elements.
	// getTableViewer().resetFilters();
	//
	// // Adds the given filter to this viewer.
	// getTableViewer().addFilter(new UnicaseViewerFilter(model));
	//
	// EPackage ePackage = model.getEPackage();
	// ModelElement me = (ModelElement) ePackage.getEFactoryInstance().create(model);
	//
	// setStandartColumns(me);
	//
	// createGenericContextMenu(me);
	// ModelElement[] projectmes = UnicaseTableViewUtil.getAllProjectMEs();
	// // if (projectmes != null) {
	// getTableViewer().setInput(projectmes);
	//
	// // }
	// getTableViewer().refresh();
	// UnicaseTableViewUtil.updateSLManager(getTableViewer(), getLabelProvider().getImage(me));
	// UnicaseTableViewUtil.resizeColumns(getTableViewer());
	//
	// }
	//
	// /**
	// * @return {@link Shell}.
	// */
	// private Shell getShell() {
	// return PlatformUI.getWorkbench().getActiveWorkbenchWindow().getShell();
	// }
	//
	// }

}
