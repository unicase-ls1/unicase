package org.unicase.rap.config;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.Properties;

import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IConfigurationElement;
import org.eclipse.core.runtime.Platform;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.impl.EClassImpl;
import org.unicase.metamodel.Project;
import org.unicase.metamodel.util.ModelUtil;
import org.unicase.metamodel.util.SerializationException;
import org.unicase.workspace.ProjectSpace;
import org.unicase.workspace.WorkspaceManager;
import org.unicase.workspace.util.WorkspaceUtil;

import config.ConfigEntity;
import edu.tum.cs.cope.migration.Model;


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
	
	/**
	 * TODO: currently settings are saved into the user's home directory
	 */
//	public static void saveSettings() {
//		// Add views from the extension point
//		IConfigurationElement[] configIn = Platform.getExtensionRegistry().getConfigurationElementsFor(
//			"org.unicase.ui.web.config");
//		
//		ConfigEntity configEntity;
//		
//		for (IConfigurationElement e : configIn) {
//			
//			String configEntityName = e.getAttribute("name");
//			
//			try {
//				configEntity = (ConfigEntity) e.createExecutableExtension("class");
//				String filename = new File(System.getProperty("user.home")).getAbsolutePath() 
//					+ File.separatorChar + configEntity.getClass().getSimpleName()
//					+ configEntity.getIdentifier();
//				saveEntity(configEntity, filename);
//			} catch (CoreException e1) {
//				// TODO Auto-generated catch block
//				e1.printStackTrace();
//			}
//		}		
//	}
	
	public static void loadSettings() {
		
	}

	public static void saveEntity(ConfigEntity entity) {
		
		String filePath = System.getProperty("user.home") + File.separatorChar + 
			(entity.getAssociatedProjectIdentifier() == null ? "" : entity.getAssociatedProjectIdentifier()) + 
					"." + entity.getClass().getCanonicalName();
						
		try {
			ModelUtil.saveObjectToResource(entity, URI.createFileURI(filePath));
			System.out.println(ModelUtil.eObjectToString(entity));
//			ModelUtil.stringToEObject(object)
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SerializationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
				
		/*OutputStream ostream;
		try {
			ostream = new FileOutputStream(filename, false);
			entity.getProperties().store(ostream, "Properties for entity " + entity.getIdentifier());
			ostream.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}*/
	}
	
	public static ConfigEntity loadConigEntity(String configFilename,
			EClass eClass) {
	
//		/Users/emueller/org.eclipse.emf.ecore.impl.EClassImpl
		// TODO: check whether filepath really exists
		
		String filename = System.getProperty("user.home") + File.separatorChar + configFilename;
		
		File f = new File(filename);
		if (!f.exists()) {
			return null;
		}

		try {
			ConfigEntity cfgEntity = ModelUtil.loadEObjectFromResource(eClass , URI.createFileURI(filename));
			return cfgEntity;
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return null;
	}
	
    public static ConfigEntity loadObject(String filename) throws ClassNotFoundException, IOException {
    	ConfigEntity entity = null;
    	Properties properties = new Properties();
        FileInputStream fis = new FileInputStream(filename);
    	properties.load(fis);

    	return entity;
    }
}
