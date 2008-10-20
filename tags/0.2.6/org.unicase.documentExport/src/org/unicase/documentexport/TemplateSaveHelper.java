package org.unicase.documentexport;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.URL;
import java.util.ArrayList;
import java.util.Collections;

import org.eclipse.core.runtime.FileLocator;
import org.eclipse.core.runtime.Path;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.unicase.documentexport.documentTemplate.DefaultDocumentTemplateBuilder;
import org.unicase.documentexport.documentTemplate.DocumentTemplate;
import org.unicase.model.ModelElement;
import org.unicase.model.ModelPackage;

public class TemplateSaveHelper {
	private static DocumentTemplate template = null;
	public static DocumentTemplate createdDefaultTemplate = null;
	
	public static ArrayList<EClass> modelElementTypes = new ArrayList<EClass>();
	
	public static int meCount = 0;
	
	public static DocumentTemplate getTemplate() {
		if (template == null)
			loadDefaultTemplate();
		return template;
	}
	
	public static void setTemplate(DocumentTemplate template) {
		TemplateSaveHelper.template = template;
	}
	
	
	private static void loadDefaultTemplate() {
		TemplateSaveHelper.loadTemplate("default.template");
		if (template == null) {
			template = createNewDefaultDocumentTemplate();
		}
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
				return (DocumentTemplate)obj;
			} else {
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
			ObjectOutputStream obj_out = new
				ObjectOutputStream (f_out);

			// Write object out to disk
			obj_out.writeObject ( template );	
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public static DocumentTemplate createNewDefaultDocumentTemplate()  {
		
		
		getModelElements(ModelPackage.eINSTANCE);
		

		DefaultDocumentTemplateBuilder builder = new DefaultDocumentTemplateBuilder();
		
		builder.setModelElementTypes(modelElementTypes);
		
		DocumentTemplate template = builder.build();
		TemplateSaveHelper.createdDefaultTemplate = template;

		template.name = "default";
		saveTemplate(template);
		
		return template;
	}
	
	private static void getModelElements(EObject object) {
		
		if (object instanceof EClass) {
			EClass eClass = (EClass) object;
			EObject me;
			if (!(eClass.isAbstract() || eClass.isInterface())) {
				me = eClass.getEPackage().getEFactoryInstance().create(eClass);
				if (me instanceof ModelElement)
					modelElementTypes.add((EClass) object);
			}
		}
		
		if (object instanceof EPackage) {
			for (EObject obj : ((EPackage)object).eContents()) {
				getModelElements(obj);
			}
		}
	}
	
	public static EClass getEClassOfClass(Class<ModelElement> clazz) {
		modelElementTypes = new ArrayList<EClass>();
		getModelElements(ModelPackage.eINSTANCE);
		
		for (EClass eClass : modelElementTypes) {
			if (eClass.getInstanceClass().equals(clazz)) {
				return eClass;
			}
		}
		return null;
	}
}
