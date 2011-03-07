package org.unicase.ui.urml.stakeholders.associationrules;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Set;
import java.util.Map.Entry;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.jface.viewers.ArrayContentProvider;
import org.eclipse.jface.viewers.CellLabelProvider;
import org.eclipse.jface.viewers.ColumnLabelProvider;
import org.eclipse.jface.viewers.TableViewer;
import org.eclipse.jface.viewers.TableViewerColumn;
import org.eclipse.jface.viewers.TableViewerRow;
import org.eclipse.jface.viewers.ViewerCell;
import org.eclipse.swt.SWT;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Table;
import org.eclipse.swt.widgets.TableColumn;
import org.eclipse.swt.widgets.TableItem;
import org.eclipse.ui.part.ViewPart;
import org.unicase.metamodel.util.ModelUtil;
import org.unicase.model.urml.UrmlModelElement;
import org.unicase.model.urml.UrmlPackage;
import org.unicase.ui.urml.stakeholders.stakeholdernavigation.Activator;

public class AssociationRulesView extends ViewPart {

	private TableViewer viewer;
	private static final Image CHECKED = Activator.getImageDescriptor("icons/checked.gif").createImage();
	private static final Image UNCHECKED = Activator.getImageDescriptor("icons/unchecked.gif").createImage();
	private static final Image CHECKEDDISABLED = Activator.getImageDescriptor("icons/checkedDisabled.gif").createImage();
	private List<String> liste = new ArrayList<String>();
	private ArrayList<EClass> sortedElementNames;
	private HashMap<EClass, ArrayList<EClass>> associationMap;
	private ArrayList<EClass> rowElementReferenceListe;

	@Override
	public void createPartControl(Composite parent) {
		viewer = new TableViewer(parent, SWT.MULTI | SWT.H_SCROLL | SWT.V_SCROLL | SWT.FULL_SELECTION | SWT.BORDER);
		HashMap<EClass, Integer> elementNumberMapping = createElementNumberMapping();
		// to each element his relation lest will be added and stored in datMap
		createAssociationMap(elementNumberMapping);
		// readFromDataMap(test);

		createColumns(parent, viewer);
		final Table table = viewer.getTable();
		table.setHeaderVisible(true);
		table.setLinesVisible(true);
		viewer.setInput(sortedElementNames);

		// Make the selection available to other views
		getSite().setSelectionProvider(viewer);
		// Set the sorter for the table

		layoutSetUp();

	}

	private void readFromDataMap(HashMap<EClass, ArrayList<String>> test) {
		// reads and set the appropriate cells in the table view
		// as start with some text

	}

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
			public int compare(EClass arg0, EClass arg1) {
				return arg0.getName().compareToIgnoreCase(arg1.getName());
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
			// associationMap.put(key, value)
			associationMap.put(eclass, associationList);
		}
		return associationMap;
	}

	// creates association list to specific eclass
	private ArrayList<EClass> createAssociationListToElement(EClass eclass,
		HashMap<EClass, Integer> elementNumberMapping) {
		ArrayList<EClass> result = new ArrayList<EClass>();

		// überprüfen wo eclass.string sich in einem hash set befindet
		// um die nummer rauszuchen
		// wenn man die nummer hat, mit switch bei value die richtige liste füllen
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
		// final HashMap<EClass, EClass> referenceElementMapping = new HashMap<EClass, EClass>();

		final TableViewerColumn viewerColumn = new TableViewerColumn(viewer, SWT.NONE);
		final TableColumn column = viewerColumn.getColumn();
		column.setText(columnClass.getName());
		column.setWidth(bound);
		column.setResizable(true);
		column.setMoveable(true);

		viewerColumn.setEditingSupport(new CheckboxEditingSupport(viewer, columnClass, this));

		viewerColumn.setLabelProvider(new ColumnLabelProvider() {


			@Override
			public String getText(Object element) {
				if (hasAssociation(columnClass, (EClass) element) || hasAssociation((EClass) element, columnClass)) {
					return null;
				} else {
					return null;
				}

			}

			@Override
			public Image getImage(Object element) {
				if (!hasAssociation(columnClass, (EClass) element) && !hasAssociation((EClass) element, columnClass)) {
					return UNCHECKED;
				}
				return CHECKEDDISABLED;
			}

			//
			// @Override
			// public void update(ViewerCell cell) {
			// // linkes Element
			// // rowElement = Danger
			// EClass rowElement = (EClass) cell.getElement();
			// // columnText = Actor
			// if (hasAssociation(columnClass, rowElement) || hasAssociation(rowElement, columnClass)) {
			// cell.setText("OK");
			// }
			// else{
			// cell.setText("no");
			// }
			//
			// }

		});

		return viewerColumn;

	}

	boolean hasAssociation(final EClass from, EClass to) {
		if (associationMap.containsKey(to)) {
			rowElementReferenceListe = associationMap.get(to);
			// rowElementReferenceListe = {"Actor", "Mitigation"}
		}
		// element in dem Map suchen und seine referenzliste zurückgeben
		if (rowElementReferenceListe != null) {
			// Reference Liste des linken Element
			for (EClass referenceElement : rowElementReferenceListe) {
				if (from.equals(referenceElement)) {
					return true;
				}

			}

		}
		return false;
	}

	//	
	// public boolean hasNoAssociation(final EClass from) {
	// int elementIndex = sortedElementNames.indexOf(from);
	//		
	// EClass tmp = sortedElementNames.get(0);
	// sortedElementNames.add(0, from);
	// sortedElementNames.add(elementIndex, tmp);
	// for(int i = 0; i < sortedElementNames.size(); i++){
	// for (int j = i+1; j < sortedElementNames.size(); j++){
	// return hasAssociation(sortedElementNames.get(i), sortedElementNames.get(j));
	// }
	// }
	// return false;
	// }

	@Override
	public void setFocus() {
		// TODO Auto-generated method stub

	}

}
