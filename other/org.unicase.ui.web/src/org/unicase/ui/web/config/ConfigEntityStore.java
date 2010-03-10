package org.unicase.ui.web.config;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.Properties;

import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IConfigurationElement;
import org.eclipse.core.runtime.Platform;
import org.unicase.ui.web.views.ConfigurationTabView;


public class ConfigEntityStore {
	
	private static ConfigEntityStore instance = null;
	
	public static ConfigEntityStore getInstance() {
		if (instance == null) {
			instance = new ConfigEntityStore();
		}
		
		return instance;
	}
	
	private ConfigEntityStore() {
	
	}
	
	public static void saveSettings() {
		// Add views from the extension point
		IConfigurationElement[] configIn = Platform.getExtensionRegistry().getConfigurationElementsFor(
			"org.unicase.ui.web.config");
		
		AbstractConfigEntity configEntity;
		
		for (IConfigurationElement e : configIn) {
			
			String configEntityName = e.getAttribute("name");
			
			try {
				configEntity = (AbstractConfigEntity) e.createExecutableExtension("class");
				String filename = new File(System.getProperty("user.home")).getAbsolutePath() 
					+ File.separatorChar + configEntity.getId();
				saveEntity(configEntity, filename);
			} catch (CoreException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}		
	}

	public static void saveEntity(AbstractConfigEntity entity, String filename) {
//		String filePath = storeDirectory + File.pathSeparatorChar + entity.getId();
				
		OutputStream ostream;
		try {
			ostream = new FileOutputStream(filename, false);
			entity.getProperties().store(ostream, "Properties for entity " + entity.getId());
			ostream.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
    public AbstractConfigEntity loadObject(String filename) throws ClassNotFoundException, IOException {
    	AbstractConfigEntity entity = null;
    	Properties properties = new Properties();
    	properties.load(this.getClass().getClassLoader().getResourceAsStream(filename));

    	return entity;
    }
}
