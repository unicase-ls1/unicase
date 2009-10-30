/**
 * <copyright> Copyright (c) 2008-2009 Jonas Helming, Maximilian Koegel. All rights reserved. This program and the
 * accompanying materials are made available under the terms of the Eclipse Public License v1.0 which accompanies this
 * distribution, and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>
 */
package org.unicase.workspace.ui.views.changes;

import java.util.List;

import org.eclipse.jface.viewers.ColumnLabelProvider;
import org.eclipse.jface.viewers.ColumnViewerToolTipSupport;
import org.eclipse.jface.viewers.IContentProvider;
import org.eclipse.jface.viewers.TreeViewerColumn;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Composite;
import org.unicase.emfstore.esmodel.versioning.ChangePackage;
import org.unicase.emfstore.esmodel.versioning.LogMessage;

/**
 * Shows the operations in a change packages grouped by model elements.
 * 
 * @author Shterev
 */
public class CompactChangesComposite extends AbstractChangesComposite {

	private TreeViewerColumn meColumn;
	private TreeViewerColumn opColumn;

	/**
	 * Default constructor. {@inheritDoc}
	 * 
	 * @param parent
	 * @see {@link AbstractChangesComposite}
	 * @param style
	 * @see {@link AbstractChangesComposite}
	 * @param relatedElementsStyle
	 * @see {@link AbstractChangesComposite}
	 * @param changePackages
	 * @see {@link AbstractChangesComposite}
	 * @param checkable
	 * @see {@link AbstractChangesComposite}
	 */
	public CompactChangesComposite(Composite parent, int style,
			int relatedElementsStyle, List<ChangePackage> changePackages,
			boolean checkable) {
		super(parent, style, relatedElementsStyle, changePackages,
				new CompactChangesContentProvider(), checkable);
	}

	/**
	 * Default constructor. {@inheritDoc}
	 * 
	 * @param parent
	 * @see {@link AbstractChangesComposite}
	 * @param style
	 * @see {@link AbstractChangesComposite}
	 * @param relatedElementsStyle
	 * @see {@link AbstractChangesComposite}
	 * @param changePackages
	 * @see {@link AbstractChangesComposite}
	 */
	public CompactChangesComposite(Composite parent, int style,
			int relatedElementsStyle, List<ChangePackage> changePackages) {
		super(parent, style, relatedElementsStyle, changePackages,
				new CompactChangesContentProvider(), false);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	protected void buildColumns(IContentProvider contentProvider) {

		getTreeViewer().setContentProvider(contentProvider);

		meColumn = new TreeViewerColumn(getTreeViewer(), SWT.NONE);
		meColumn.getColumn().setWidth(300);
		meColumn.getColumn().setText("ModelElement");
		meColumn.setLabelProvider(new MENameLabelProvider(
				getEmfLabelProvider(), getVisualizationHelper()));

		opColumn = new TreeViewerColumn(getTreeViewer(), SWT.NONE);
		opColumn.getColumn().setWidth(300);
		opColumn.getColumn().setText("");
		opColumn.getColumn().setWidth(getShell().getSize().x / 2);
		opColumn.setLabelProvider(new ColumnLabelProvider() {
			@Override
			public String getText(Object element) {
				if (element instanceof ChangePackage) {
					ChangePackage cp = (ChangePackage) element;
					LogMessage logMessage = cp.getLogMessage();
					if (logMessage != null) {
						StringBuffer log = new StringBuffer();
						log.append("Log message: ");
						log.append(" \'");
						log.append(logMessage.getMessage());
						log.append("\' ");
						return log.toString();
					}
				}
				return "";
			}
		});

		ColumnViewerToolTipSupport.enableFor(getTreeViewer());
	}

	/**
	 * @return the meColumn
	 */
	public TreeViewerColumn getMeColumn() {
		return meColumn;
	}

}
