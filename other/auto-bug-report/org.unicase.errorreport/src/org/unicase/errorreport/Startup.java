package org.unicase.errorreport;

import java.util.List;
import java.util.Set;

import org.eclipse.core.runtime.ILogListener;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Platform;
import org.eclipse.ui.IStartup;
import org.unicase.errorreport.extensionpoint.ExtensionPointResolver;
import org.unicase.errorreport.reporthandler.IReportHandler;

public class Startup implements IStartup {


	public void earlyStartup() {

		final ExtensionPointResolver resolver = new ExtensionPointResolver();
		// string list containing plugin id of plugins extending error reporting extension points.
		final Set<String> contributors = resolver.getContributors();
		System.out.println("************ contributors **********************");
		for(String contributor : contributors){
			System.out.println("contributor");
			System.out.println(contributor);
		}
		System.out.println("************ end contributors **********************");

		Platform.addLogListener(new ILogListener() {

			public void logging(IStatus status, String plugin) {
				for (String contributor : contributors) {
					// get filters
					List<String> filters = resolver
							.getFiltersForContributor(contributor);
					String severity = resolver.getSeverity(contributor);
					boolean reportThis = isReportable(status, filters, severity);
					if(reportThis){
						List<IReportHandler> reportHandlers = resolver.getReportHandlers(contributor);
						handleReport(reportHandlers, status);
						
					}
				}


			}
		});


	}

	/**
	 * 
	 * @param reportHandlers
	 * @param status
	 */
	protected void handleReport(List<IReportHandler> reportHandlers, IStatus status) {
		//simple implementation 
		for(IReportHandler reportHandler : reportHandlers){
			System.out.println("reportHandlers");
			reportHandler.handleReport(status);
		}
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
		
		return true;
	}

}
