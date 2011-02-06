package org.unicase.errorreport;

import org.eclipse.core.runtime.IConfigurationElement;
import org.eclipse.core.runtime.IExtensionRegistry;
import org.eclipse.core.runtime.Platform;
import org.eclipse.ui.IStartup;

public class Startup implements IStartup {

	private static final String FILTERS_EXTENSION_POINT_ID = "org.unicase.errorreporting.filters";
	private static final String STATCK_TRACE_FILTERS_ATTRIBUTE_NAME = "StackTraceFilter";
	private static final String SEVERITY_ATTRIBUTE_NAME = "Severity";
	
	@Override
	public void earlyStartup() {

		IExtensionRegistry extensionRegistry = Platform.getExtensionRegistry();
		IConfigurationElement[] configElements = extensionRegistry.getConfigurationElementsFor(FILTERS_EXTENSION_POINT_ID);
	
		
		
		for(IConfigurationElement configElement : configElements){
			System.out.println(configElement.getName() + " -- " + configElement.getContributor().getName());
			
			
			

		}
		
	}

}
