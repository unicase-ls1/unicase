package org.eclipse.emf.emfstore.client.ui.views.historybrowserview;

import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IConfigurationElement;
import org.eclipse.core.runtime.ISafeRunnable;
import org.eclipse.core.runtime.Platform;
import org.eclipse.core.runtime.SafeRunner;
import org.eclipse.emf.ecore.EObject;

public class HistoryCompare {

	// This is the ID of the extension point
	private final String HISTORY_COMPARE_ID = "org.eclipse.emf.emfstore.client.ui.views.historybrowsercomparator";

	public void handleRegisteredExtensions(final EObject e1, final EObject e2) {
		IConfigurationElement[] config = Platform.getExtensionRegistry()
				.getConfigurationElementsFor(HISTORY_COMPARE_ID);
		try {
			for (IConfigurationElement e : config) {
				final Object o = e.createExecutableExtension("class");
				if (o instanceof ICompare) {
					ISafeRunnable runnable = new ISafeRunnable() {
						// @Override
						public void handleException(Throwable exception) {
							System.out.println("Exception in client");
						}

						// @Override
						public void run() throws Exception {
							ICompare extension = (ICompare) o;

							extension.compare(e1, e2);
							extension.display();

						}
					};
					SafeRunner.run(runnable);
				}
			}
		} catch (CoreException ex) {
			System.out.println(ex.getMessage());
		}
	}
}
