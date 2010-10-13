package org.unicase.rap.ui.start;

import org.eclipse.ui.IPageLayout;
import org.eclipse.ui.IPerspectiveFactory;

public class Perspective implements IPerspectiveFactory {

	public void createInitialLayout(IPageLayout layout) {
		layout.addView("org.unicase.ui.navigator.viewer",
			IPageLayout.TOP,
			1.0f, IPageLayout.ID_EDITOR_AREA);
	}
}
