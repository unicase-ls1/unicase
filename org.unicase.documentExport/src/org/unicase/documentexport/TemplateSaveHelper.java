package org.unicase.documentexport;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.URL;
import java.util.Collections;

import org.eclipse.core.runtime.FileLocator;
import org.eclipse.core.runtime.Path;
import org.unicase.documentexport.documentTemplate.DocumentTemplate;

public class TemplateSaveHelper {
	private static DocumentTemplate template = null;
	public static DocumentTemplate createdDefaultTemplate = null;
	
	public static int meCount = 0;
	
	public static DocumentTemplate getTemplate() {
		if (template == null)
			loadDefaultTemplate();
		if (template == null)
			template = createdDefaultTemplate;
		return template;
	}
	
	public static void setTemplate(DocumentTemplate template) {
		TemplateSaveHelper.template = template;
	}
	
	
	private static void loadDefaultTemplate() {
		TemplateSaveHelper.loadTemplate("default.template");
	}	
	
	public static DocumentTemplate loadTemplate(String fileName) {
		FileInputStream f_in;
		try {
			
			URL url2 = FileLocator.find(
					Activator.getDefault().getBundle(), 
					new Path("templates/"), 
					Collections.EMPTY_MAP
				);
			
			File f = new File(FileLocator.resolve(url2).getPath() + fileName);
			
			if (!f.exists())
				return null;
			
			
			URL url = FileLocator.find(
					Activator.getDefault().getBundle(), 
					new Path("templates/" + fileName), 
					Collections.EMPTY_MAP
				);
			
			
			f_in = new FileInputStream(FileLocator.resolve(url).getPath());

			// Read object using ObjectInputStream
			ObjectInputStream obj_in = new ObjectInputStream (f_in);
			
			// Read an object
			Object obj = obj_in.readObject();
			if (obj instanceof DocumentTemplate) {
				TemplateSaveHelper.template = (DocumentTemplate)obj;
//				System.out.println("Template " + fileName + "loaded");
				return (DocumentTemplate)obj;
			} else {
//				System.out.println("could not load template");
			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	
	
	public static void saveTemplate(DocumentTemplate template) {
		// Write to disk with FileOutputStream
		FileOutputStream f_out;
		try {
			
			URL url2 = FileLocator.find(
					Activator.getDefault().getBundle(), 
					new Path("templates/"), 
					Collections.EMPTY_MAP
				);
			
			File f = new File(FileLocator.resolve(url2).getPath() + template.name + ".template");
			
			f.createNewFile();
			
			URL url = FileLocator.find(
					Activator.getDefault().getBundle(), 
					new Path("templates/" + template.name + ".template"), 
					Collections.EMPTY_MAP
				);
			
			
			
			f_out = new 
				FileOutputStream(FileLocator.resolve(url).getPath());
			// Write object with ObjectOutputStream
			ObjectOutputStream obj_out = new
				ObjectOutputStream (f_out);

			// Write object out to disk
			obj_out.writeObject ( template );	
//			System.out.println("template " + template.name + " saved successfully");
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
