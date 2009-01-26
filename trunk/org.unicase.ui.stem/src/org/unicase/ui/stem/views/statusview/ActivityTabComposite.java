package org.unicase.ui.stem.views.statusview;

import org.eclipse.jface.viewers.DoubleClickEvent;
import org.eclipse.jface.viewers.IDoubleClickListener;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.viewers.TreeViewer;
import org.eclipse.jface.viewers.ViewerComparator;
import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;
import org.unicase.model.ModelElement;
import org.unicase.ui.common.util.ActionHelper;
import org.unicase.ui.stem.views.TaskTableUtil;

/**
 * Composite to show the activity views.
 * 
 * @author helming
 */
public class ActivityTabComposite extends Composite {

	private TreeViewer treeViewer;

	/**
	 * default constructor.
	 * 
	 * @param parent the parent composite
	 * @param style the swt style
	 */
	public ActivityTabComposite(Composite parent, int style) {
		super(parent, style);
		this.setLayout(new GridLayout());
		createTree();
	}

	private void createTree() {
		treeViewer = new TreeViewer(this, SWT.BORDER);
		treeViewer.getTree().setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true));

		ActivityTabContentProvider contentProvider = new ActivityTabContentProvider();
		treeViewer.setContentProvider(contentProvider);
		treeViewer.setLabelProvider(new ActivityTabLabelProvider());
		treeViewer.setComparator(new ViewerComparator());
		TaskTableUtil.addColumns(treeViewer);

		treeViewer.addDoubleClickListener(new IDoubleClickListener() {

			public void doubleClick(DoubleClickEvent event) {
				IStructuredSelection sel = (IStructuredSelection) event.getSelection();
				if (sel.getFirstElement() instanceof ModelElement) {
					ActionHelper
						.openModelElement((ModelElement) sel.getFirstElement(), treeViewer.getClass().getName());
				}
			}

		});
	}

	/**
	 * . set input to TreeViewer
	 * 
	 * @param me input model element
	 */
	public void setInput(ModelElement me) {
		// this.input = me;
		treeViewer.setInput(me);

	}

}
