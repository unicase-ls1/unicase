/**
 * <copyright> Copyright (c) 2008-2009 Jonas Helming, Maximilian Koegel. All rights reserved. This program and the
 * accompanying materials are made available under the terms of the Eclipse Public License v1.0 which accompanies this
 * distribution, and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>
 */

package org.unicase.ui.urml.stakeholders.associationrules;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Set;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.jface.action.Action;
import org.eclipse.jface.action.IMenuManager;
import org.eclipse.jface.viewers.ArrayContentProvider;
import org.eclipse.jface.viewers.ColumnLabelProvider;
import org.eclipse.jface.viewers.TableViewer;
import org.eclipse.jface.viewers.TableViewerColumn;
import org.eclipse.swt.SWT;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Table;
import org.eclipse.swt.widgets.TableColumn;
import org.eclipse.ui.IActionBars;
import org.eclipse.ui.part.ViewPart;
import org.unicase.metamodel.util.ModelUtil;
import org.unicase.model.urml.UrmlPackage;
import org.unicase.ui.urml.stakeholders.stakeholdernavigation.Activator;

/**
 * 
 * @author kterzieva
 *
 */
public class AssociationRulesView extends ViewPart {

	private static final String SYSTEM_DESIGN = "System Design";
	private static final String ANALYSE = "Analyse";
	private static final String REQUIREMENTS_ELICITATION = "RequirementElicitation";
	private TableViewer viewer;
	private static final Image UNCHECKED = Activator.getImageDescriptor("icons/unchecked.gif").createImage();
	private static final Image CHECKEDDISABLED = Activator.getImageDescriptor("icons/checkedDisabled.gif")
		.createImage();
	private ArrayList<EClass> sortedElementNames;
	private HashMap<EClass, ArrayList<EClass>> associationMap;
	private ArrayList<EClass> rowElementReferenceListe;

	
	@Override
	public void createPartControl(Composite parent) {
		viewer = new TableViewer(parent, SWT.MULTI | SWT.H_SCROLL | SWT.V_SCROLL | SWT.FULL_SELECTION | SWT.BORDER);
		HashMap<EClass, Integer> elementNumberMapping = createElementNumberMapping();
		// to each element his relation lest will be added and stored in datMap
		createAssociationMap(elementNumberMapping);
		createColumns(parent, viewer);
		final Table table = viewer.getTable();
		table.setHeaderVisible(true);
		table.setLinesVisible(true);
		viewer.setInput(sortedElementNames);

		// Make the selection available to other views
		getSite().setSelectionProvider(viewer);
		layoutSetUp();
		createDevelopmantStageItems();

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
		associationMap = new HashMap<EClass, ArrayList<EClass>>();
		for (EClass eclass : sortedElementNames) {
			ArrayList<EClass> associationList = createAssociationListToElement(eclass, elementNumberMapping);
			associationMap.put(eclass, associationList);
		}
		return associationMap;
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

	private TableViewerColumn createTableViewerColumn(final EClass columnClass, int bound) {
		final TableViewerColumn viewerColumn = new TableViewerColumn(viewer, SWT.NONE);
		final TableColumn column = viewerColumn.getColumn();
		column.setText(columnClass.getName());
		column.setWidth(bound);
		column.setResizable(true);
		column.setMoveable(true);

		
		viewerColumn.setEditingSupport(new CheckboxEditingSupport(this, viewer, columnClass, sortedElementNames, viewerColumn));
		viewerColumn.setLabelProvider(new ColumnLabelProvider() {

			@Override
			public String getText(Object element) {
				return null;
			}

			@Override
			public Image getImage(Object element) {
				if (!hasAssociation(columnClass, (EClass) element) && !hasAssociation((EClass) element, columnClass)) {
					return UNCHECKED;
				}
				return CHECKEDDISABLED;
			}

		});
		
//		viewerColumn.getColumn().addSelectionListener(new SelectionListener() {
//			
//			@Override
//			public void widgetSelected(SelectionEvent e) {
//				System.out.println("Cell Test");
//				
//			}
//			
//			@Override
//			public void widgetDefaultSelected(SelectionEvent e) {
//				// TODO Auto-generated method stub
//				
//			}
//		});

		return viewerColumn;

	}

	private void createDevelopmantStageItems() {
		IActionBars bars = getViewSite().getActionBars();
		IMenuManager menuManager = bars.getMenuManager();

		Action reqElicitation = new Action() {
			@Override
			public void run() {
			}
		};

		actionSetUp(menuManager, reqElicitation, REQUIREMENTS_ELICITATION, "Test");

		Action analyse = new Action() {
			@Override
			public void run() {
			}
		};
		actionSetUp(menuManager, analyse, ANALYSE, "Test");

		Action systemDesing = new Action() {
			@Override
			public void run() {
			}
		};

		actionSetUp(menuManager, systemDesing, SYSTEM_DESIGN, "Test");

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
	boolean hasAssociation(final EClass from, EClass to) {
		//search element in the map and gets its reference list
		if (associationMap.containsKey(to)) {
			rowElementReferenceListe = associationMap.get(to);
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

	@Override
	public void setFocus() {

	}

}
