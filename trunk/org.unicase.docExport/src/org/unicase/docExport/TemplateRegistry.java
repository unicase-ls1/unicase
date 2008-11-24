package org.unicase.docExport;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import org.eclipse.core.runtime.IStatus;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.unicase.docExport.exceptions.TemplateNotFoundException;
import org.unicase.docExport.exceptions.TemplateSaveException;
import org.unicase.docExport.exceptions.TemplatesFileNotFoundException;
import org.unicase.docExport.exportModel.ExportModelPackage;
import org.unicase.docExport.exportModel.Template;
import org.unicase.docExport.exportModel.builders.DefaultDocumentTemplateBuilder;
import org.unicase.workspace.util.WorkspaceUtil;

/**
 * This utility class handles the persistent templates. The template are stored
 * in the plugin folder "templates". The file extension should be ".template".
 * 
 * @author Sebastian Höcht
 * 
 */
public final class TemplateRegistry {

	/**
	 * The template extension string. (".template")
	 */
	public static final String TEMPLATE_FILE_EXTENSION = ".template";

	/**
	 * this is the template which is used for exporting documents.
	 */
	private static Template template;

	private static final String DEFAULT_TEMPLATE_NAME = "default";
	private static final String UNICASE_FOLDER = ".unicase";
	private static final String DOCUMENT_EXPORT_FOLDER = "docExport2";
	private static final String TEMPLATES_FILE_NAME = "templates";
	
	private static final int ME_COUNT_DEFAULT = 0;

	/**
	 * This is a help variable which counts the number of ModelElements
	 * rendered. This is ONLY for benchmark purposes.
	 */
	private static int meCount = ME_COUNT_DEFAULT;

	/**
	 * This is a utility class. Therefore this class can't be instantiated.
	 */
	private TemplateRegistry() { };

	/**
	 * 
	 * @return the global template which is used for rendering
	 */
	public static Template getTemplate() {
		if (template == null) {
			try {
				loadDefaultTemplate();
			} catch (TemplateSaveException e) {
				WorkspaceUtil.log(
						"There is no Template to use, and a newly created template could" +
						" be saved.",
						e,
						IStatus.ERROR
				);			
			}
		}
		return template;
	}

	/**
	 * 
	 * @param template
	 *            set the global template which is used for rendering
	 */
	public static void setTemplate(Template template) {
		TemplateRegistry.template = template;
	}

	/**
	 * loads the default template from home folder. If this template
	 * doesn't exist, a new one will be created and saved.
	 * @throws TemplateSaveException 
	 */
	private static void loadDefaultTemplate() throws TemplateSaveException {
		try {
			template = loadTemplate(DEFAULT_TEMPLATE_NAME);
			WorkspaceUtil.log(
					"The template " + DEFAULT_TEMPLATE_NAME + " has been loaded successfully",
					new Exception(),
					IStatus.OK
			);					
		} catch (TemplateNotFoundException e) {
			WorkspaceUtil.log(
					"The template " + DEFAULT_TEMPLATE_NAME + " could not be found." +
							" Trying to load the templates files of the binary build.",
					new Exception(),
					IStatus.INFO
			);	
			
			
			
			template = createNewDefaultDocumentTemplate();
			saveTemplate(template);
			WorkspaceUtil.log(
					"A new default template has been created and saved successfully",
					new Exception(),
					IStatus.OK
			);	
		}
	}
	

	
	
	/**
	 * Loads a Template from the templates file.
	 * 
	 * @param templateName the name of the template which shall be loaded
	 * @return the Template which shall be loaded
	 * @throws TemplateNotFoundException -
	 */
	public static Template loadTemplate(String templateName) 
	throws TemplateNotFoundException {
		
		Resource resource;
		try {
			resource = getTemplatesResource();
			Template template = getTemplate(templateName, resource);
			if (template == null) {
				throw new TemplateNotFoundException(templateName);
			} else {
				return template;
			}
		} catch (IOException e) {
			throw new TemplateNotFoundException(templateName);
		} catch (TemplatesFileNotFoundException e) {
			throw new TemplateNotFoundException(templateName);
		}
	}
	
	/**
	 * Loads a persistent template from the plug-in folder. If the template
	 * doesn't exist, null will be returned and an error will be added to the
	 * eclipse error log.
	 * 
	 * @param templateName the name of the template which shall be loaded
	 * @param resource the resource of the EMF store object
	 * @return the loaded template
	 * @throws TemplatesFileNotFoundException -
	 */
	public static Template getTemplate(
			String templateName,
			Resource resource
	) 
	throws TemplatesFileNotFoundException {
		try {
			resource.load(resource.getResourceSet().getLoadOptions());
		} catch (IOException e) {
			WorkspaceUtil.log(
					"Fetching template " + templateName + " failed ",
					new TemplatesFileNotFoundException(),
					IStatus.WARNING
			);
			throw new TemplatesFileNotFoundException();
		}
		
		EList<EObject> contents = resource.getContents();
		for (EObject object : contents) {
			if (object instanceof Template) {
				Template templateObject = (Template) object;
				if (templateObject.getName().equals(templateName)) {
					return (Template) object;
				}
			}
		}
		
		return null;
	}

	/**
	 * Saves a template to the disc in the template folder of this plugin. The
	 * filename will be template.getName(). + ".template".
	 * 
	 * @param template
	 *            the template which shall be saved
	 * @throws TemplateSaveException -
	 */
	public static void saveTemplate(Template template) throws TemplateSaveException {
		
//		getStaticTemplatesResource();
		
		Resource resource;
		try {
			resource = getTemplatesResource();
		} catch (IOException e1) {
			throw new TemplateSaveException(e1);
		}
		
		Template oldTemplate;
		try {
			oldTemplate = getTemplate(template.getName(), resource);

			if (oldTemplate == null) {
				resource.getContents().add(template);
			} else {
				resource.getContents().remove(oldTemplate);
				resource.getContents().add(template);
				TemplateRegistry.setTemplate(template);
			}
			
			resource.save(null);
			WorkspaceUtil.log(
					"template " + template.getName() + " saved successfully",
					new Exception(),
					IStatus.OK
			);
			
		} catch (TemplatesFileNotFoundException e) {
			WorkspaceUtil.log(
					"this should never happen",
					e,
					IStatus.ERROR
			);
		} catch (IOException e) {
			throw new TemplateSaveException(e);
		}
	}

	/**
	 * 
	 * 
	 * @return a new DocumentTemplate
	 */
	public static Template createNewDefaultDocumentTemplate() {
		Template template = DefaultDocumentTemplateBuilder.build();
		template.setName(DEFAULT_TEMPLATE_NAME);

		return template;
	}

	/**
	 * @return an ArrayList of all templates which a stored in the template
	 *         folder
	 * @throws TemplateSaveException -
	 */
	public static ArrayList<Template> getAllTemplates() throws TemplateSaveException {
		ArrayList<Template> templates = new ArrayList<Template>();

		Resource resource;
		try {
			resource = getTemplatesResource();
		} catch (IOException e1) {
			throw new TemplateSaveException(e1);
		}
		
		try {
			resource.load(resource.getResourceSet().getLoadOptions());
		} catch (IOException e) {
			WorkspaceUtil.log(
					"Fetching template all templates failed",
					new TemplatesFileNotFoundException(),
					IStatus.WARNING
			);
			
			Template template = createNewDefaultDocumentTemplate();
			saveTemplate(template);
			resource.getContents().add(template);
		}
		
		EList<EObject> contents = resource.getContents();
		for (EObject object : contents) {
			if (ExportModelPackage.eINSTANCE.getTemplate().isInstance(object)) {
				Template templateObject = (Template) object;
				templates.add(templateObject);
			}
		}
		
		if (templates.size() < 1) {
			templates.add(getTemplate());
		}
		
		return templates;
	}


	/**
	 * @param meCount
	 *            the meCount to set
	 */
	public static void setMeCount(int meCount) {
		TemplateRegistry.meCount = meCount;
	}

	/**
	 * @return the meCount
	 */
	public static int getMeCount() {
		return meCount;
	}
	
	private static String getTemplatesPath() {
		//userhome folder
		StringBuffer sb = new StringBuffer();
		sb.append(System.getProperty("user.home"));
		sb.append(File.separatorChar);
	
		sb.append(UNICASE_FOLDER);
		sb.append(File.separatorChar);
		sb.append(DOCUMENT_EXPORT_FOLDER);
		sb.append(File.separatorChar);	
	
		String pathName = sb.toString() + TEMPLATES_FILE_NAME;
		return pathName;
	}
	
	private static Resource getTemplatesResource() throws IOException {		
		ResourceSet resourceSet = new ResourceSetImpl();
		URI fileURI = URI.createFileURI(getTemplatesPath());
		
		File templatesFile = new File(getTemplatesPath());
		if (!templatesFile.exists()) {
			try {
				Resource resource = resourceSet.createResource(fileURI);
				resource.save(null);
				return resource;
			} catch (IOException e) {
				WorkspaceUtil.log(
						"The templates file could not be saved after creating a new resource",
						new Exception(),
						IStatus.ERROR
				);
				throw new IOException();
			}
		} else {
			return resourceSet.getResource(fileURI, true);
		}
	}
	
//	private static Resource getStaticTemplatesResource() {
//		
//		URL test = FileLocator.find(
//				org.unicase.workspace.Activator.getDefault().getBundle(), 
//				new Path("../org.unicase.documentExport/templates/templates"), 
//				Collections.EMPTY_MAP
//			);
//		
////		try {
////			System.out.println("URL toFileUrl " + FileLocator.toFileURL(test).toExternalForm());
////			System.out.println("URL resolve " + FileLocator.resolve(test).toExternalForm());
////		} catch (IOException e1) {
////			// TODO Auto-generated catch block
////			e1.printStackTrace();
////		}
////		System.out.println("URI external form " + test.toExternalForm());
//		try {
//			System.out.println("URI test " + test.toURI());
//			
//			ResourceSet resourceSet = new ResourceSetImpl();
//			
////			URI fileURI = URI.cr
//			URI fileURI = URI.createPlatformPluginURI("org.unicase.documentexport/templates/templates", false);
////					(test.toURI().toString());
//			
//			File templatesFile = new File(getTemplatesPath());
//			if (!templatesFile.exists()) {
//				try {
//					Resource resource = resourceSet.createResource(fileURI);
//					resource.save(null);
//					return resource;
//				} catch (IOException e) {
//					WorkspaceUtil.log(
//							"The templates file could not be saved after creating a new resource",
//							new Exception(),
//							IStatus.ERROR
//					);
//				}
//			} else {
//				return resourceSet.getResource(fileURI, true);
//			}		
//			
//		} catch (URISyntaxException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		return null;
//	}
}
