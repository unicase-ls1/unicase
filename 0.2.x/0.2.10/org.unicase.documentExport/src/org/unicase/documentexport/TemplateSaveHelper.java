package org.unicase.documentexport;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.URL;
import java.util.ArrayList;
import java.util.Collections;

import org.eclipse.core.runtime.FileLocator;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Path;
import org.eclipse.core.runtime.Platform;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.unicase.documentexport.documentTemplate.DefaultDocumentTemplateBuilder;
import org.unicase.documentexport.documentTemplate.DocumentTemplate;
import org.unicase.model.ModelElement;
import org.unicase.model.ModelPackage;
import org.unicase.workspace.Workspace;
import org.unicase.workspace.util.WorkspaceUtil;

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
	
	
	public static ArrayList<TemplateDescriptor> getTemplatePaths() {
		ArrayList<TemplateDescriptor> ret = new ArrayList<TemplateDescriptor>();
		
		URL url = FileLocator.find(
			Activator.getDefault().getBundle(), 
			new Path("templates/"), 
			Collections.EMPTY_MAP
		);
			
		File f;
		try {
			f = new File(FileLocator.resolve(url).getPath());
			
			File[] files = f.listFiles();
			System.out.println("f: " + f);
			System.out.println("files[]: " + files);
			
			for (int i=0;i<files.length;i++) {
				if (files[i].isFile()) {
					TemplateDescriptor descriptor = new TemplateDescriptor();
					descriptor.setPath(files[i].getCanonicalPath());
					descriptor.setFileName(files[i].getName());
					
					ret.add(descriptor);
					WorkspaceUtil.log("available template: " + descriptor.getFileName(), new Exception(""), IStatus.INFO);
				}
			}			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return ret;
	}
	
	
	public static DocumentTemplate loadTemplate(String fileName) {
		//SH: fix this, only works for default template
		FileInputStream f_in;
		try {
			
			InputStream inputStream = TemplateSaveHelper.class.getResourceAsStream(fileName);
			
			if (inputStream==null) {
				WorkspaceUtil.log("The template " + fileName + "doesn't exist", null, IStatus.WARNING);
				return null;
			}
			
			// Read object using ObjectInputStream
			ObjectInputStream objIn = new ObjectInputStream (inputStream);
			
			// Read an object
			Object obj = objIn.readObject();
			if (obj instanceof DocumentTemplate) {
				TemplateSaveHelper.template = (DocumentTemplate)obj;
				WorkspaceUtil.logException("The template " + fileName + " has been loaded successfully", new Exception());
				return (DocumentTemplate)obj;
			} else {
				WorkspaceUtil.log("the loaded file is no DocumentTemplate (" + fileName + ")", new Exception(), IStatus.ERROR);
			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		WorkspaceUtil.log("a fatal error occured when loading a template (" + fileName + ")", new Exception(), IStatus.ERROR);
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
		
		WorkspaceUtil.logException("new default template has been created", new Exception());
		
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
