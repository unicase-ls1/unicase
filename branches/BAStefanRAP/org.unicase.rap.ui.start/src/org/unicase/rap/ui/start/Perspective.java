package org.unicase.rap.ui.start;

import org.eclipse.ui.IPageLayout;
import org.eclipse.ui.IPerspectiveFactory;

public class Perspective implements IPerspectiveFactory {

	public void createInitialLayout(IPageLayout layout) {
		layout.addView("org.unicase.ui.navigator.viewer",
			IPageLayout.LEFT,
			1.0f, IPageLayout.ID_EDITOR_AREA);
		layout.addView("org.unicase.ui.repository.views.RepositoryView",
				IPageLayout.BOTTOM,
				0.5f, IPageLayout.ID_PROBLEM_VIEW);
		layout.addView("org.unicase.workspace.ui.views.historybrowserview.HistoryBrowserView",
				IPageLayout.BOTTOM,
				0.5f, IPageLayout.ID_PROBLEM_VIEW);
	}
}
