package org.unicase.patchAttachment.adapter;

import java.util.HashMap;

import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IConfigurationElement;
import org.eclipse.core.runtime.Platform;
import org.eclipse.ui.WorkbenchException;
import org.eclipse.ui.statushandlers.WorkbenchErrorHandler;
import org.unicase.patchAttachment.exported.AbstractTeamAdapter;

/**
 *	This class registers all adapters that have been registered at the extension point for team adapters.
 *  It can then be used to get an adapter for a specific repository provider.
 *
 *	This class is a singleton.
 * @author jfinis
 *
 */
public class TeamAdapterRegistry {

	
	/**
	 *	The extension point id.
	 */
	private static final String EXTENSION_POINT_ID = "org.unicase.patchAttachment.teamAdapters";
	
	/**
	 * The singleton instance
	 */
	private static final TeamAdapterRegistry INSTANCE = new TeamAdapterRegistry();
	
	/**
	 * Mapping from repository provider id to team adapter
	 */
	private HashMap<String, AbstractTeamAdapter> registeredAdapters = new HashMap<String, AbstractTeamAdapter>();
	
	/**
	 * Singleton constructor.
	 */
	private TeamAdapterRegistry(){
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
	
	/**
	 * Gets the singleton instance
	 * @return the singleton
	 */
	public static TeamAdapterRegistry getInstance(){
		return INSTANCE;
	}

	/**
	 * Returns an adapter for a specific repository provider id or null
	 * if no adapter is registered for that id.
	 * @param id the repository provider id
	 * @return the team adapter associated to the id or null if none is registered
	 */
	public AbstractTeamAdapter getAdapter(String id) {
		return registeredAdapters.get(id);
	}
	

	
}
