package org.unicase.errorreport.extensionpoint;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IConfigurationElement;
import org.eclipse.core.runtime.IExtensionRegistry;
import org.eclipse.core.runtime.Platform;
import org.unicase.errorreport.reporthandler.DefaultReportHandler;
import org.unicase.errorreport.reporthandler.IReportHandler;

public class ExtensionPointResolver {

	private static final String FILTERS_EXTENSION_POINT_ID = "org.unicase.errorreporting.filters";
	private static final String REPORT_HANDLERS_EXTENSION_POINT_ID = "org.unicase.errorreporting.reportHandlers";

	private static final String STATCK_TRACE_FILTERS_ATTRIBUTE_NAME = "filter-value";
	private static final String SEVERITY_ATTRIBUTE_NAME = "severity-value";

	private static final String EMAIL_ATTRIBUTE_NAME = "email";
	private static final String CLASS_ATTRIBUTE_NAME = "class";

	private Set<String> contributorIds;

	// maps contributor id to filters it defines. A contributor is a plugin
	// extendin error reporting extension points.
	private Map<String, List<String>> filtersMap;

	// maps contributor id to log severities they are interested to report.
	private Map<String, String> severitiesMap;

	// if contributor hasn't define its own implemenatation for handling
	// reports, it has specified an email to be used by default report handling.
	private Map<String, String> emailsMap;

	// if contributor has defined its own handler, this map holds it.
	private Map<String, List<IReportHandler>> handlersMap;

	public ExtensionPointResolver() {

		contributorIds = new HashSet<String>();
		filtersMap = new HashMap<String, List<String>>();
		emailsMap = new HashMap<String, String>();
		severitiesMap = new HashMap<String, String>();
		handlersMap = new HashMap<String, List<IReportHandler>>();

		IExtensionRegistry extensionRegistry = Platform.getExtensionRegistry();
		IConfigurationElement[] configElements = extensionRegistry
				.getConfigurationElementsFor(FILTERS_EXTENSION_POINT_ID);

		for (IConfigurationElement configElement : configElements) {
			String contributor = configElement.getContributor().getName();
			System.out.println(configElement.getName() + " -- " + contributor);

			contributorIds.add(contributor);
			if (filtersMap.get(contributor) == null) {
				filtersMap.put(contributor, new ArrayList<String>());
			}

			String filterValue = configElement
					.getAttribute(STATCK_TRACE_FILTERS_ATTRIBUTE_NAME);
			if(filterValue != null && !filterValue.equals("") && !filterValue.equals("*")){
				System.out.println(filterValue);
				filtersMap.get(contributor).add(filterValue);
			}
			String severityValue = configElement.getAttribute(SEVERITY_ATTRIBUTE_NAME);
			if(severityValue != null && !severityValue.equals("")) {
				System.out.println(severityValue);
				severitiesMap.put(contributor, severityValue);
			}
		}

		configElements = extensionRegistry.getConfigurationElementsFor(REPORT_HANDLERS_EXTENSION_POINT_ID);
		for (IConfigurationElement configElement : configElements) {
			String contributer = configElement.getContributor().getName();
			System.out.println(configElement.getName() + " -- " + contributer);
			contributorIds.add(contributer);
			if (handlersMap.get(contributer) == null) {
				handlersMap.put(contributer, new ArrayList<IReportHandler>());
			}

			if(configElement.getAttribute(CLASS_ATTRIBUTE_NAME) != null){
				IReportHandler reportHandler = getReportHandler(configElement);
				if(reportHandler != null){
					handlersMap.get(contributer).add(reportHandler);
				}
				
			}else{
				emailsMap.put(contributer, configElement.getAttribute(EMAIL_ATTRIBUTE_NAME));
			}
		}

	}

	private IReportHandler getReportHandler(IConfigurationElement configElement) {
		try {
			return (IReportHandler) configElement
					.createExecutableExtension(CLASS_ATTRIBUTE_NAME); 
		} catch (CoreException e) {
			e.printStackTrace();
			return null;
		}
	}

	public Set<String> getContributors() {
		return contributorIds;
	}

	public List<String> getFiltersForContributor(String contributor) {

		return filtersMap.get(contributor);
	}

	/**
	 * Severity is one of these Strings (Error, Warning, ErrorWarning, Info,
	 * All)
	 * 
	 * @param contributor
	 * @return
	 */
	public String getSeverity(String contributor) {
		return severitiesMap.get(contributor);
	}

	/**
	 * If contributor plugin has defined a report handler, it will be
	 * instantiated and returned. Otherwise null is returned.
	 * 
	 * @param contributor
	 * @return specific report handler or null
	 * @throws CoreException
	 */
	public List<IReportHandler> getReportHandlers(String contributor) {
		List<IReportHandler> handlers = new ArrayList<IReportHandler>();
		handlers.addAll(handlersMap.get(contributor));
		if (emailsMap.get(contributor) != null) {
			handlers.add(new DefaultReportHandler(emailsMap.get(contributor)));
		}
		return handlers;
	}

	public String getEmail(String contributor) {
		return emailsMap.get(contributor);
	}

}
