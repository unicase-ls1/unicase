package org.unicase.ui.web;

import org.eclipse.rwt.graphics.Graphics;
import org.eclipse.swt.SWT;
import org.eclipse.swt.custom.CTabFolder;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.layout.FillLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.ui.part.ViewPart;
import org.unicase.ui.web.tabs.*;

/**
 * 
 * 
 * @author fxulusoy
 */
public class TabbedView extends ViewPart {

	public static final String ID = "org.unicase.ui.web.TabbedView";

	@Override
	public void createPartControl(Composite parent) {
		parent.setLayout(new FillLayout());
		int style = SWT.TOP | SWT.FLAT | SWT.BORDER;
		final CTabFolder topFolder = new CTabFolder(parent, style);
		topFolder.marginWidth = 8;
		topFolder.marginHeight = 8;
		ensureMinTabHeight(topFolder);

		final AbstractTab[] tabs = new AbstractTab[] { new TaskItemsTab(topFolder),
				new BugReportTab(topFolder), new ExampleTableTab(topFolder),
				new InputTab(topFolder) };

		tabs[0].createContent();
		topFolder.setSelection(0);
		topFolder.addSelectionListener(new SelectionAdapter() {
			public void widgetSelected(final SelectionEvent evt) {
				int index = topFolder.getSelectionIndex();
				tabs[index].createContent();
			}
		});
	}

	@Override
	public void setFocus() {
		// TODO Auto-generated method stub
	}

	/**
	 * 
	 * @param folder
	 */
	private static void ensureMinTabHeight(final CTabFolder folder) {
		int result = Graphics.getCharHeight(folder.getFont());
		if (result < 18) {
			folder.setTabHeight(18);
		}
	}

}
