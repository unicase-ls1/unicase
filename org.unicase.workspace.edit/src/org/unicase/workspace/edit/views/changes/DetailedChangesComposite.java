package org.unicase.workspace.edit.views.changes;

import java.util.List;

import org.eclipse.jface.viewers.IContentProvider;
import org.eclipse.jface.viewers.TreeViewerColumn;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Composite;
import org.unicase.emfstore.esmodel.versioning.ChangePackage;

/**
 * Shows the operations in a change packages grouped by change package. 
 * @author Shterev
 *
 */
public class DetailedChangesComposite extends AbstractChangesComposite{
	
	private TreeViewerColumn meColumn;
	private TreeViewerColumn opColumn;


	/**
	 * Default constructor.
	 * @param parent @see {@link AbstractChangesComposite}
	 * @param style @see {@link AbstractChangesComposite}
	 * @param relatedElementsStyle @see {@link AbstractChangesComposite}
	 * @param changePackages @see {@link AbstractChangesComposite}
	 * @param checkable @see {@link AbstractChangesComposite}
	 */
	public DetailedChangesComposite(Composite parent, int style, int relatedElementsStyle, List<ChangePackage> changePackages, boolean checkable) {
		super(parent, style, relatedElementsStyle, changePackages, new DetailedChangesContentProvider(), checkable);
	}

	/**
	 * Default constructor.
	 * @param parent @see {@link AbstractChangesComposite}
	 * @param style @see {@link AbstractChangesComposite}
	 * @param relatedElementsStyle @see {@link AbstractChangesComposite}
	 * @param changePackages @see {@link AbstractChangesComposite}
	 */
	public DetailedChangesComposite(Composite parent, int style, int relatedElementsStyle, List<ChangePackage> changePackages) {
		super(parent, style, relatedElementsStyle, changePackages, new DetailedChangesContentProvider(), false);
	}
	

	/**
	 * {@inheritDoc}
	 */
	@Override
	protected void buildColumns(IContentProvider contentProvider) {
		super.buildColumns(contentProvider);

		// the main column
		meColumn = new TreeViewerColumn(getTreeViewer(), SWT.NONE);
		meColumn.getColumn().setWidth(300);
		meColumn.getColumn().setText("ModelElement");
		meColumn.setLabelProvider(new MENameLabelProvider(getEmfLabelProvider(),
				getVisualizationHelper()));

		opColumn = new TreeViewerColumn(getTreeViewer(), SWT.NONE);
		opColumn.getColumn().setWidth(300);
		opColumn.getColumn().setText("Operation");
		opColumn.getColumn().setWidth(getShell().getSize().x / 2);
		opColumn.setLabelProvider(new OperationsNameLabelProvider(getEmfLabelProvider(),
				getVisualizationHelper()));
		
		
	}

	/**
	 * @return the meColumn
	 */
	public TreeViewerColumn getMeColumn() {
		return meColumn;
	}

	/**
	 * @return the opColumn
	 */
	public TreeViewerColumn getOpColumn() {
		return opColumn;
	}

}
