package org.unicase.urml.ui.hypergraph;

import java.util.HashMap;
import java.util.TreeSet;

import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.events.SelectionListener;
import org.eclipse.swt.widgets.Table;
import org.eclipse.swt.widgets.TableItem;
import org.eclipse.zest.core.viewers.GraphViewer;

public class GraphEReferenceFilter {
	public enum EdgeType {
		CHILD, PARENT, REFERENCE
	}

	private int depth;
	private TreeSet<EdgeType> references;
	private HashMap<EdgeType, TableItem> visible;
	private GraphViewer graph;

	public GraphEReferenceFilter(GraphViewer graph) {
		depth = 3;
		references = new TreeSet<EdgeType>();
		visible = new HashMap<EdgeType, TableItem>();
		references.add(EdgeType.CHILD);
		references.add(EdgeType.PARENT);
		references.add(EdgeType.REFERENCE);
		this.graph = graph;
	}

	public int getDepth() {
		return depth;
	}

	public void addTableItems(Table table) {
		for (EdgeType reference : references) {
			TableItem item = new TableItem(table, SWT.NONE);
			item.setText(reference.toString());
			item.setChecked(true);
			visible.put(reference, item);
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

	public boolean isVisible(EdgeType type) {
		TableItem result;
		if ((result = visible.get(type)) == null) {
			return false;
		}
		return result.getChecked();
	}
}
