package org.unicase.ui.web.entities.store;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.Properties;

import org.unicase.ui.entities.AbstractEntity;

public class EntityFileStore {
	
	public EntityFileStore() {
	
	}

	public static void saveEntity(AbstractEntity entity, String filename) {
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
	
    public AbstractEntity loadObject(String filename) throws ClassNotFoundException, IOException {
    	AbstractEntity entity = null;
    	Properties properties = new Properties();
    	properties.load(this.getClass().getClassLoader().getResourceAsStream(filename));

    	return entity;
    }
}
