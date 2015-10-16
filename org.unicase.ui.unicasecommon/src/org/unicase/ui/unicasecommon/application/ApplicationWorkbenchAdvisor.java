package org.unicase.ui.unicasecommon.application;

import java.util.HashSet;
import java.util.Set;

import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.ui.activities.IActivityManager;
import org.eclipse.ui.activities.IWorkbenchActivitySupport;
import org.eclipse.ui.application.IWorkbenchConfigurer;
import org.eclipse.ui.application.IWorkbenchWindowConfigurer;
import org.eclipse.ui.application.WorkbenchAdvisor;
import org.eclipse.ui.application.WorkbenchWindowAdvisor;
import org.eclipse.ui.internal.ide.model.WorkbenchAdapterBuilder;
import org.unicase.ui.unicasecommon.common.UnicasePerspective;

public class ApplicationWorkbenchAdvisor extends WorkbenchAdvisor {

	/** {@inheritDoc} */
	@Override
	public WorkbenchWindowAdvisor createWorkbenchWindowAdvisor(IWorkbenchWindowConfigurer configurer) {
		return new ApplicationWorkbenchWindowAdvisor(configurer);
	}

	/** {@inheritDoc} */
	@Override
	public String getInitialWindowPerspectiveId() {
		return UnicasePerspective.UNICASE_PERSPECTIVE_ID;
	}

	/** {@inheritDoc} */
	@Override
	public void initialize(IWorkbenchConfigurer configurer) {
		configurer.setSaveAndRestore(true);
		declareWorkbenchImages();

		final IWorkbenchActivitySupport activitySupport = configurer.getWorkbench().getActivitySupport();
		final IActivityManager activityManager = activitySupport.getActivityManager();

		final Set<String> enabledActivities = new HashSet<String>();
		final String id = "org.eclipse.emf.ecp.application.e3.enablement"; //$NON-NLS-1$
		if (activityManager.getActivity(id).isDefined()) {
			enabledActivities.add(id);
		}

		activitySupport.setEnabledActivityIds(enabledActivities);
	}

	@Override
	public IAdaptable getDefaultPageInput() {
		return new NavigatorRoot();
	}

	@Override
	public void preStartup() {
		WorkbenchAdapterBuilder.registerAdapters();
	}

	private void declareWorkbenchImages() {

	}
}
