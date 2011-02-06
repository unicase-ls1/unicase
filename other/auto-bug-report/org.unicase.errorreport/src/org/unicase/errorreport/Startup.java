package org.unicase.errorreport;

import java.util.List;

import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.ILogListener;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Platform;
import org.eclipse.ui.IStartup;
import org.unicase.errorreport.extensionpoint.ExtensionPointResolver;
import org.unicase.errorreport.reporthandler.DefaultReportHandler;
import org.unicase.errorreport.reporthandler.IReportHandler;

public class Startup implements IStartup {


	@Override
	public void earlyStartup() {

		final ExtensionPointResolver resolver = new ExtensionPointResolver();
		// string list containing plugin id of plugins extending error reporting extension points.
		final List<String> contributors = resolver.getContributors();

		Platform.addLogListener(new ILogListener() {

			@Override
			public void logging(IStatus status, String plugin) {
				for (String contributor : contributors) {
					// get filters
					List<String> filters = resolver
							.getFiltersForContributor(contributor);
					String severity = resolver.getSeverity(contributor);
					boolean reportThis = isReportable(status, filters, severity);
					if(reportThis){
						IReportHandler reportHandler = null;
						try {
							reportHandler = resolver.getReportHandler(contributor);
							
						} catch (CoreException e) {
							e.printStackTrace();
						}
						if(reportHandler == null){
							String email = resolver.getEmail(contributor);
							reportHandler = new DefaultReportHandler(email);
						}
						
						handleReport(reportHandler, status);
						
					}
				}


			}
		});


	}

	/**
	 * 
	 * @param reportHandler
	 * @param status
	 */
	protected void handleReport(IReportHandler reportHandler, IStatus status) {
		//simple implementation 
		reportHandler.handleReport(status);
		
	}

	/**
	 * If status has an stack trace, it will be reported. Based on the given
	 * filters and severity decide if you want to report this status or not.
	 * 
	 * @param status
	 * @param filters
	 * @param severity
	 *            is one of (Error, Warning, ErrorWarning, Info, All)
	 * @return
	 */

	protected boolean isReportable(IStatus status, List<String> filters,
			String severity) {
		// TODO Auto-generated method stub
		return false;
	}

}
