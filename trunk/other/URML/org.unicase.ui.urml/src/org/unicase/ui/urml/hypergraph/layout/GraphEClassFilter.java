package org.unicase.ui.urml.hypergraph.layout;

import java.util.Collection;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.TreeSet;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.jface.viewers.ILabelProvider;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.events.SelectionListener;
import org.eclipse.swt.widgets.Table;
import org.eclipse.swt.widgets.TableItem;
import org.eclipse.zest.core.viewers.GraphViewer;
import org.unicase.ui.common.MEClassLabelProvider;
import org.unicase.ui.navigator.workSpaceModel.ECPProject;
import org.unicase.workspace.ProjectSpace;

/**
 * Simple class to filter class types.
 * 
 * @author Michael Haeger
 */
public class GraphEClassFilter {
	private TreeSet<EClass> classes;
	private HashMap<EClass, TableItem> visible;
	private ILabelProvider labelProvider;
	private GraphViewer graph;

	private GraphEClassFilter(GraphViewer graph) {
		classes = new TreeSet<EClass>(new Comparator<EClass>() {
			public int compare(EClass o1, EClass o2) {
				return o1.getName().compareTo(o2.getName());
			}
		});
		visible = new HashMap<EClass, TableItem>();
		labelProvider = new MEClassLabelProvider();
		this.graph = graph;
	}

	/**
	 * Creates a filter with the given classes.
	 * 
	 * @param classes Filter classes
	 * @param graph Graph to update
	 */
	public GraphEClassFilter(Collection<? extends EClass> classes, GraphViewer graph) {
		this(graph);
		this.classes.addAll(classes);
	}

	/**
	 * Creates a filter with the classes extracted from the given projects.
	 * 
	 * @param projects Projects to extract filter classes
	 * @param graph Graph to update
	 */
	public GraphEClassFilter(List<? extends ECPProject> projects, GraphViewer graph) {
		this(graph);
		EClass projectEClass = null;
		for (ECPProject project : projects) {
			classes.addAll(project.getMetaModelElementContext().getAllModelElementEClasses());
			if (projectEClass == null) {
				// manually collect the class information for project class
				projectEClass = ((ProjectSpace) project.getRootObject()).getProject().eClass();
			}
		}
		if (projectEClass != null) {
			classes.add(projectEClass);
		}
	}

	/**
	 * Add all filter options to the given table and register a selection listener.
	 * 
	 * @param table Table to add items
	 */
	public void addTableItems(Table table) {
		for (EClass eClass : classes) {
			TableItem item = new TableItem(table, SWT.NONE);
			item.setText(labelProvider.getText(eClass));
			item.setImage(labelProvider.getImage(eClass));
			item.setChecked(true);
			visible.put(eClass, item);
		}
		table.addSelectionListener(new SelectionListener() {
			public void widgetSelected(SelectionEvent e) {
				if (e.detail == SWT.CHECK) {
					graph.setInput(graph.getInput());
				}
			}

			public void widgetDefaultSelected(SelectionEvent e) {
			}
		});
	}

	public boolean isVisible(EObject obj) {
		return isVisible(obj.eClass());
	}

	public boolean isVisible(EClass eClass) {
		TableItem result;
		if ((result = visible.get(eClass)) == null) {
			return false;
		}
		return result.getChecked();
	}
}
