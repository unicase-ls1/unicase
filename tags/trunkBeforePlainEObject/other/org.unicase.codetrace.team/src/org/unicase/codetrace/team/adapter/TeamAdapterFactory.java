package org.unicase.codetrace.team.adapter;

import java.util.HashMap;

import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IConfigurationElement;
import org.eclipse.core.runtime.Platform;
import org.eclipse.ui.WorkbenchException;
import org.eclipse.ui.statushandlers.WorkbenchErrorHandler;
import org.unicase.codetrace.team.exported.AbstractTeamAdapter;

public class TeamAdapterFactory {

	private static final String EXTENSION_POINT_ID = "org.unicase.codetrace.teamAdapters";
	private static final TeamAdapterFactory INSTANCE = new TeamAdapterFactory();
	
	private HashMap<String, AbstractTeamAdapter> registeredAdapters = new HashMap<String, AbstractTeamAdapter>();
	
	private TeamAdapterFactory(){
		//Register and create all adapters from the extensions
		IConfigurationElement[] config = Platform.getExtensionRegistry().getConfigurationElementsFor(EXTENSION_POINT_ID);
		try{
			for(IConfigurationElement e: config){
				final Object o = e.createExecutableExtension("class");
				if(o instanceof AbstractTeamAdapter){
					final String id = e.getAttribute("repoProviderId");
					registeredAdapters.put(id, (AbstractTeamAdapter) o);
				}
			}
		} catch(CoreException e){
			//TODO exception logging
			e.printStackTrace();
		}
	}
	
	public static TeamAdapterFactory getInstance(){
		return INSTANCE;
	}

	public AbstractTeamAdapter getAdapter(String id) {
		return registeredAdapters.get(id);
	}
	

	
}
