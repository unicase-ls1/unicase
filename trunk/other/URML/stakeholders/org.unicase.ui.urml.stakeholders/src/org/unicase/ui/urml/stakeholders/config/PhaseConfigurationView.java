/**
 * <copyright> Copyright (c) 2008-2009 Jonas Helming, Maximilian Koegel. All rights reserved. This program and the
 * accompanying materials are made available under the terms of the Eclipse Public License v1.0 which accompanies this
 * distribution, and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>
 */

package org.unicase.ui.urml.stakeholders.config;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map.Entry;
import java.util.Set;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.util.BasicEList;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.common.util.EMap;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.jface.action.Action;
import org.eclipse.jface.action.ControlContribution;
import org.eclipse.jface.action.IMenuManager;
import org.eclipse.jface.action.IToolBarManager;
import org.eclipse.jface.action.Separator;
import org.eclipse.jface.layout.GridLayoutFactory;
import org.eclipse.jface.viewers.ArrayContentProvider;
import org.eclipse.jface.viewers.ColumnLabelProvider;
import org.eclipse.jface.viewers.TableViewer;
import org.eclipse.jface.viewers.TableViewerColumn;
import org.eclipse.swt.SWT;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Table;
import org.eclipse.swt.widgets.TableColumn;
import org.eclipse.swt.widgets.Text;
import org.eclipse.ui.IActionBars;
import org.eclipse.ui.part.ViewPart;
import org.unicase.ecp.model.NoWorkspaceException;
import org.unicase.metamodel.Project;
import org.unicase.metamodel.util.ModelElementChangeListener;
import org.unicase.metamodel.util.ModelUtil;
import org.unicase.model.urml.Phase;
import org.unicase.model.urml.UrmlPackage;
import org.unicase.ui.urml.stakeholders.Activator;
import org.unicase.ui.urml.stakeholders.review.input.UrmlTreeHandler;
import org.unicase.workspace.util.UnicaseCommand;

/**
 * This view shows the allowed model element associations related to the active stage. 
 * @author kterzieva
 *
 */
public class PhaseConfigurationView extends ViewPart {


	private TableViewer viewer;
	private static final Image UNCHECKED = Activator.getImageDescriptor("icons/unchecked.gif").createImage();
	private static final Image CHECKEDDISABLED = Activator.getImageDescriptor("icons/checkedDisabled.gif")
		.createImage();
	private static final Image CHECKED = Activator.getImageDescriptor("icons/checked.gif")
	.createImage();
	private ArrayList<EClass> sortedElementNames;
	private HashMap<EClass, ArrayList<EClass>> staticAssociationMap;
	private ArrayList<EClass> rowElementReferenceListe;
	private Project activeProject;
	private Text txtUser;

	
	@Override
	public void createPartControl(Composite parent) {
		viewer = new TableViewer(parent, SWT.MULTI | SWT.H_SCROLL | SWT.V_SCROLL | SWT.FULL_SELECTION | SWT.BORDER);
		HashMap<EClass, Integer> elementNumberMapping = createElementNumberMapping();
		try {
			activeProject = UrmlTreeHandler.getTestProject();
		} catch (NoWorkspaceException e) {
			e.printStackTrace();
		}
		// to each element his relation lest will be added and stored in datMap

		printPhase("START",UrmlSettingsManager.INSTANCE.getActivePhase());
		createAssociationMap(elementNumberMapping);
		createColumns(parent, viewer);
		final Table table = viewer.getTable();
		table.setHeaderVisible(true);
		table.setLinesVisible(true);
		viewer.setInput(sortedElementNames);

		// Make the selection available to other views
		getSite().setSelectionProvider(viewer);
		layoutSetUp();
		
		createDevelopmentPhaseItems();
		//toolbarManager.add(userTextToolbarContribution);

	}

	/**
	 * Test method.
	 * @param test
	 */
//	private void readFromDataMap(HashMap<EClass, ArrayList<String>> test) {
//		// reads and set the appropriate cells in the table view
//		// 
//
//	}


	private void layoutSetUp() {
		// Layout the viewer
		GridData gridData = new GridData();
		gridData.verticalAlignment = GridData.FILL;
		gridData.horizontalSpan = 2;
		gridData.grabExcessHorizontalSpace = true;
		gridData.grabExcessVerticalSpace = true;
		gridData.horizontalAlignment = GridData.FILL;
		viewer.getControl().setLayoutData(gridData);
	}

	private HashMap<EClass, Integer> createElementNumberMapping() {
		HashMap<EClass, Integer> elementNumberMapping = new HashMap<EClass, Integer>();
		Set<EClass> subClasses = ModelUtil.getSubclasses(UrmlPackage.eINSTANCE.getUrmlModelElement());
		sortedElementNames = new ArrayList<EClass>();
		for (EClass eclass : subClasses) {
			sortedElementNames.add(eclass);
		}

		Collections.sort(sortedElementNames, new Comparator<EClass>() {

			@Override
			public int compare(EClass element, EClass elementTwo) {
				return element.getName().compareToIgnoreCase(elementTwo.getName());
			}

		});
		for (int i = 0; i < sortedElementNames.size(); i++) {
			elementNumberMapping.put(sortedElementNames.get(i), i);
		}
		return elementNumberMapping;
	}

	private HashMap<EClass, ArrayList<EClass>> createAssociationMap(HashMap<EClass, Integer> elementNumberMapping) {
		staticAssociationMap = new HashMap<EClass, ArrayList<EClass>>();
		for (EClass eclass : sortedElementNames) {
			ArrayList<EClass> associationList = createAssociationListToElement(eclass, elementNumberMapping);
			staticAssociationMap.put(eclass, associationList);
		}
		return staticAssociationMap;
	}

	// creates association list to specific eclass
	private ArrayList<EClass> createAssociationListToElement(EClass eclass,
		HashMap<EClass, Integer> elementNumberMapping) {
		ArrayList<EClass> result = new ArrayList<EClass>();

		if (elementNumberMapping.containsKey(eclass)) {
			EList<EReference> elementReferences = eclass.getEAllReferences();

			for (EReference eReference : elementReferences) {
				result.add(eReference.getEReferenceType());
			}
		}
		return result;
	}

	private void createColumns(final Composite parent, final TableViewer viewer) {

		// First column is for the first name
		TableViewerColumn col = new TableViewerColumn(viewer, SWT.NONE);
		TableColumn column = col.getColumn();
		column.setText("Model Element");
		column.setWidth(150);
		column.setResizable(true);
		column.setMoveable(true);
	
		col.setLabelProvider(new ColumnLabelProvider() {
			@Override
			public String getText(Object element) {
				return ((EClass) element).getName();
			}
		});

		for (int i = 0; i < sortedElementNames.size(); i++) {
			// for each subclass elements a column will be created
			col = createTableViewerColumn(sortedElementNames.get(i), 100);
		}
		viewer.setContentProvider(new ArrayContentProvider());
	}

	private TableViewerColumn createTableViewerColumn(final EClass columnClassName, int bound) {
		final TableViewerColumn viewerColumn = new TableViewerColumn(viewer, SWT.NONE);
		final TableColumn column = viewerColumn.getColumn();
		column.setText(columnClassName.getName());
		column.setWidth(bound);
		column.setResizable(true);
		column.setMoveable(true);

		
		viewerColumn.setEditingSupport(new PhaseConfigurationEditingSupport(this, viewer, columnClassName,sortedElementNames, viewerColumn));
		viewerColumn.setLabelProvider(new ColumnLabelProvider() {

			@Override
			public String getText(Object element) {
				return null;
			}

			@Override
			public Image getImage(Object element) {
				if (!hasStaticAssociation(columnClassName, (EClass) element) && !hasStaticAssociation((EClass) element, columnClassName)) {
			
					EMap<EClass, EList<EClass>> curAllowAss = UrmlSettingsManager.INSTANCE.getActivePhase().getAllowedAssociations();
					if(curAllowAss == null){
						return UNCHECKED;
					} else {
						EList<EClass> curValueList = curAllowAss.get(element);
						
						if(curValueList != null && curValueList.contains(columnClassName)){
							return CHECKED;
						}
					}
					
					return UNCHECKED;
				}
								
				return CHECKEDDISABLED;
			}

		});
	
		return viewerColumn;

	}
	private Action createSelectedPhaseAction(final Phase phase) {
		
		Action a = new Action() {
			@Override
			public void run() {
				txtUser.setText(phase.getName());

				printPhase("1",UrmlSettingsManager.INSTANCE.getActivePhase());
				setActivePhase(phase);
				printPhase("2",UrmlSettingsManager.INSTANCE.getActivePhase());
				viewer.refresh();

				printPhase("3",UrmlSettingsManager.INSTANCE.getActivePhase());
				
				//setze diese in dem view
				//aktualisiere das model
			}
		};
		return a;
	}
	
	private void createDevelopmentPhaseItems() {
		IActionBars bars = getViewSite().getActionBars();
		IMenuManager menuManager = bars.getMenuManager();
		IToolBarManager toolbarManager = bars.getToolBarManager();
		Collection<EObject> defaultPhases = activeProject.getAllModelElementsbyClass(UrmlPackage.eINSTANCE
				.getPhase(), new BasicEList<EObject>());
			for (final EObject obj : defaultPhases) {
				final Phase p = ((Phase)obj);
				printPhase("XXX", p);
				((Phase)obj).addModelElementChangeListener(new ModelElementChangeListener() {
					
					@Override
					public void onRuntimeExceptionInListener(RuntimeException exception) {
						// TODO Auto-generated method stub
						
					}
					
					@Override
					public void onChange(Notification notification) {
						System.out.println(p.getName());
						System.out.println(notification.getFeature());
						System.out.println(notification.getOldValue() + ", " + notification.getNewValue());
					}
				});
				final Phase phase = (Phase) obj;
				Action a = createSelectedPhaseAction(phase);
				a.setText(phase.getName());
				actionSetUp(menuManager, a , phase.getName(), "Test");
				
			}
		menuManager.add(new Separator());	

		Action editPhase = new Action() {
			@Override
			public void run() {
				// set the associationView view and model
			}
		};
		
		 ControlContribution userTextToolbarContribution = new ControlContribution("userTextl") {

				

				@Override
				protected Control createControl(Composite parent) {
					Composite composite = new Composite(parent, SWT.NONE);
					GridLayoutFactory.fillDefaults().margins(1, 0).spacing(0, 0).applyTo(composite);
					txtUser = new Text(composite, SWT.NONE);
					GridData layoutData = new GridData(SWT.FILL, SWT.CENTER, true, true);
					layoutData.widthHint = 100;
					txtUser.setLayoutData(layoutData);
					txtUser.setEditable(false);
					
					txtUser.setText(UrmlSettingsManager.INSTANCE.getActivePhase().getName());
				
					return composite;
				}

			};
		actionSetUp(menuManager, editPhase, "Edit Phase", "Test");
		toolbarManager.add(userTextToolbarContribution);

	}

	/**
	 * Actions attributes settings.
	 * @param menuManager the menu manager
	 * @param actionName the name of the action
	 * @param text the displayed text of the action
	 * @param toolTipText .
	 */
	public void actionSetUp(IMenuManager menuManager, Action actionName, String text, String toolTipText) {
		actionName.setText(text);
		actionName.setToolTipText(toolTipText);
		menuManager.add(actionName);
	}

	/**
	 * Checks if association between two elements exists.
	 * @param from first element
	 * @param to second element
	 * @return whether association exists
	 */
	boolean hasStaticAssociation(final EClass from, EClass to) {
		//search element in the map and gets its reference list
		if (staticAssociationMap.containsKey(to)) {
			rowElementReferenceListe = staticAssociationMap.get(to);
		}
		if (rowElementReferenceListe != null) {
			//checks if the first element is in the reference list of the second element
			for (EClass referenceElement : rowElementReferenceListe) {
				if (from.equals(referenceElement)) {
					return true;
				}
			}
		}
		return false;
	}
	
	public void printPhase (String prefix, Phase p){
		System.err.println(prefix);
		System.err.println(p.getName());
		EMap<EClass, EList<EClass>> ass = p.getAllowedAssociations();
		
		
		for(Entry<EClass, EList<EClass>> e : ass){
		//	PhaseSetEntryImpl i = (PhaseSetEntryImpl) e;			
			String name = e.getKey() == null ?"null": e.getKey().getName();
			System.err.print(name + " -> ");
			EList<EClass> vlas = e.getValue();
			System.err.println("{");
			for(EClass e2 : vlas){
				System.err.println(e2.getName() + " ");
			}
			System.err.println("}");
		}
	}
	
	public void setActivePhase(final Phase phase) {
		new UnicaseCommand() {
			@Override
			protected void doRun() {
				UrmlSettingsManager.INSTANCE.setActivePhase(phase);
			//	projectSettings.setActivePhase(phase);
			}
		}.run();
	}

	@Override
	public void setFocus() {

	}

}
