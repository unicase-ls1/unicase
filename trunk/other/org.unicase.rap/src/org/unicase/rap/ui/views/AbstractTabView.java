package org.unicase.rap.ui.views;

import org.eclipse.rwt.graphics.Graphics;
import org.eclipse.swt.SWT;
import org.eclipse.swt.custom.CTabFolder;
import org.eclipse.swt.layout.FillLayout;
import org.eclipse.swt.widgets.Composite;

/**
 * An project independent view with multiple tabs.
 * 
 * @author emueller
 *
 */
public abstract class AbstractTabView extends AbstractView {
	
	private CTabFolder tabFolder;
	
	/**
	 * Ensures minimum tab height.
	 * 
	 * @param folder
	 */
	protected static void ensureMinTabHeight(final CTabFolder folder) {
		int result = Graphics.getCharHeight(folder.getFont());
		if (result < 18) {
			folder.setTabHeight(18);
		}
	}

	/**
	 * Returns the tab folder of the view.
	 * @return the tab folder
	 */
	public CTabFolder getTabFolder() {
		return tabFolder;
	}
	
	@Override
	public void createPartControl(Composite parent) {
		parent.setLayout(new FillLayout());
		int style = SWT.TOP | SWT.FLAT | SWT.BORDER;
		
		tabFolder = new CTabFolder(parent, style);
		tabFolder.marginWidth = 8;
		tabFolder.marginHeight = 8;
		ensureMinTabHeight(getTabFolder());
		
		createTabs(parent);
	}

	
	protected abstract void createTabs(Composite parent);		
}
