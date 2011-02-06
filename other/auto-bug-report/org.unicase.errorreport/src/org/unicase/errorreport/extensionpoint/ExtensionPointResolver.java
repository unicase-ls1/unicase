package org.unicase.errorreport.extensionpoint;

import java.util.List;
import java.util.Map;

import org.eclipse.core.runtime.CoreException;
import org.unicase.errorreport.reporthandler.IReportHandler;

public class ExtensionPointResolver {
	
	 private static final String FILTERS_EXTENSION_POINT_ID = "org.unicase.errorreporting.filters";
	 private static final String REPORT_HANDLERS_EXTENSION_POINT_ID = "org.unicase.errorreporting.reportHandlers";
	 private static final String STATCK_TRACE_FILTERS_ATTRIBUTE_NAME = "StackTraceFilter";
	 private static final String SEVERITY_ATTRIBUTE_NAME = "Severity";

	private List<String> contributorIds;
	
	//maps contributor id to filters it defines. A contributor is a plugin extendin error reporting extension points.
	private Map<String, List<String>> filtersMap; 
	
	//maps contributor id to log severities they are interested to report.
	private Map<String, String> severitiesMap; 
	
	//if contributor hasn't define its own implemenatation for handling reports, it has specified an email to be used by default report handling.
	private Map<String, String> emailsMap; 
	
	//if contributor has defined its own handler, this map holds it. 
	private Map<String, List<IReportHandler>> handlersMap;
	

	
	
	public ExtensionPointResolver() {
		// IExtensionRegistry extensionRegistry =
		// Platform.getExtensionRegistry();
		// IConfigurationElement[] configElements =
		// extensionRegistry.getConfigurationElementsFor(FILTERS_EXTENSION_POINT_ID);
		//	
		// for(IConfigurationElement configElement : configElements){
		// System.out.println(configElement.getName() + " -- " +
		// configElement.getContributor().getName());
		// }
		
		initContributorIds();
		initFiltersMap();
		initSeveritiesMap();
		initEmailsMap();
		initReportHandlersMap();
	}
	
	private void initSeveritiesMap() {
		
	}

	private void initContributorIds() {
		
	}

	private void initFiltersMap() {
		
	}

	private void initEmailsMap() {
		
	}

	private void initReportHandlersMap() {
		
	}

	public List<String> getContributors() {
		return contributorIds;
	}

	public List<String> getFiltersForContributor(String contributor) {

		
		return filtersMap.get(contributor);
	}

	/**
	 * Severity is one of these Strings (Error, Warning, ErrorWarning, Info, All)
	 * @param contributor
	 * @return
	 */
	public String getSeverity(String contributor) {
		return severitiesMap.get(contributor);
	}

	/**
	 * If contributor plugin has defined a report handler, it will be instantiated and returned. Otherwise null is returned. 
	 * @param contributor
	 * @return specific report handler or null
	 * @throws CoreException
	 */
	public List<IReportHandler> getReportHandlers(String contributor)  {
		return handlersMap.get(contributor);
	}


	public String getEmail(String contributor) {
		return emailsMap.get(contributor);
	}

}
