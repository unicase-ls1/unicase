package org.unicase.workspace.edit.views.changes;

import java.util.List;

import org.eclipse.jface.viewers.ColumnViewerToolTipSupport;
import org.eclipse.jface.viewers.IContentProvider;
import org.eclipse.jface.viewers.TreeViewerColumn;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Composite;
import org.unicase.emfstore.esmodel.versioning.ChangePackage;

/**
 * Shows the operations in a change packages grouped by model elements. 
 * @author Shterev
 *
 */
public class CompactChangesComposite extends AbstractChangesComposite{

	/**
	 * Default constructor.
	 * @param parent @see {@link AbstractChangesComposite}
	 * @param style @see {@link AbstractChangesComposite}
	 * @param relatedElementsStyle @see {@link AbstractChangesComposite}
	 * @param changePackages @see {@link AbstractChangesComposite}
	 * @param checkable @see {@link AbstractChangesComposite}
	 */
	public CompactChangesComposite(Composite parent, int style, int relatedElementsStyle, List<ChangePackage> changePackages, boolean checkable) {
		super(parent, style, relatedElementsStyle, changePackages, new CompactChangesContentProvider(), checkable);
	}

	/**
	 * Default constructor.
	 * @param parent @see {@link AbstractChangesComposite}
	 * @param style @see {@link AbstractChangesComposite}
	 * @param relatedElementsStyle @see {@link AbstractChangesComposite}
	 * @param changePackages @see {@link AbstractChangesComposite}
	 */
	public CompactChangesComposite(Composite parent, int style, int relatedElementsStyle, List<ChangePackage> changePackages) {
		super(parent, style, relatedElementsStyle, changePackages, new CompactChangesContentProvider(), false);
	}
	
	/**
	 * {@inheritDoc}
	 */
	@Override
	protected void buildColumns(IContentProvider contentProvider) {
		
		getTreeViewer().setContentProvider(contentProvider);
		
		// the main column
		TreeViewerColumn column = new TreeViewerColumn(getTreeViewer(), SWT.NONE);
		column.getColumn().setWidth(300);
		column.getColumn().setText("ModelElement");
		column.setLabelProvider(new MENameLabelProvider(getEmfLabelProvider(),
				getVisualizationHelper()));
		
		ColumnViewerToolTipSupport.enableFor(getTreeViewer());
	}

}
