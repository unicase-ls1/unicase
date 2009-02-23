/**
 * <copyright> Copyright (c) 2008 Jonas Helming, Maximilian Koegel. All rights reserved. This program and the
 * accompanying materials are made available under the terms of the Eclipse Public License v1.0 which accompanies this
 * distribution, and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>
 */
package org.unicase.docExport;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Enumeration;
import java.util.jar.JarEntry;
import java.util.jar.JarFile;

import org.eclipse.core.runtime.FileLocator;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Path;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.unicase.docExport.commands.ImportTemplate;
import org.unicase.docExport.commands.InvalidTemplateArchiveException;
import org.unicase.docExport.exceptions.TemplateNotFoundException;
import org.unicase.docExport.exceptions.TemplateSaveException;
import org.unicase.docExport.exceptions.TemplatesFileNotFoundException;
import org.unicase.docExport.exportModel.ExportModelPackage;
import org.unicase.docExport.exportModel.Template;
import org.unicase.docExport.exportModel.builders.DefaultDocumentTemplateBuilder;
import org.unicase.workspace.Configuration;
import org.unicase.workspace.util.WorkspaceUtil;

/**
 * This utility class handles the persistent templates. The template are stored in the plugin folder "templates". The
 * file extension should be ".template".
 * 
 * @author Sebastian Hoecht
 */
public final class TemplateRegistry {

	private static final String DEFAULT_TEMPLATE_TMP = "defaultTemplate.tmp";

	private static final String DEFAULT_TEMPLATES_FOLDER = "defaultTemplates";

	/**
	 * The template extension string. (".template")
	 */
	public static final String TEMPLATE_FILE_EXTENSION = ".template";

	/**
	 * this is the template which is used for exporting documents.
	 */
	private static Template template;
	private static ResourceSet resourceSet;

	private static final String DEFAULT_TEMPLATE_NAME = "default";
	private static final String UNICASE_FOLDER = Configuration.getWorkspaceDirectory();

	private static final String DOCUMENT_EXPORT_FOLDER = "docExport";
	private static final String TEMPLATES_FILE_NAME = "templates6";

	/**
	 * The folder where all templates should be saved.
	 */
	public static final String TEMPLATE_FOLDER = UNICASE_FOLDER + DOCUMENT_EXPORT_FOLDER + File.separatorChar;

	/**
	 * The folder where all logo images of the templates should be saved.
	 */
	public static final String TEMPLATE_IMAGE_FOLDER = TEMPLATE_FOLDER + "images" + File.separatorChar;

	private static final int ME_COUNT_DEFAULT = 0;

	/**
	 * This is a help variable which counts the number of ModelElements rendered. This is ONLY for benchmark purposes.
	 */
	private static int meCount = ME_COUNT_DEFAULT;

	/**
	 * This is a utility class. Therefore this class can't be instantiated.
	 */
	private TemplateRegistry() {
	};

	/**
	 * @return the global template which is used for rendering
	 */
	public static Template getTemplate() {
		if (template == null) {
			try {
				loadDefaultTemplate();
			} catch (TemplateSaveException e) {
				WorkspaceUtil.log("There is no Template to use, and a newly created template could" + " be saved.", e,
					IStatus.ERROR);
			}
		}
		return template;
	}

	/**
	 * @param template set the global template which is used for rendering
	 */
	public static void setTemplate(Template template) {
		TemplateRegistry.template = template;
	}

	private static void loadDefaultTemplatesFromZipFile() {

		try {
			URL templateFolderUrl = FileLocator.find(Activator.getDefault().getBundle(), new Path(
				DEFAULT_TEMPLATES_FOLDER + File.separatorChar), Collections.EMPTY_MAP);

			// loading the template in the developer version is easy
			if (Configuration.isDeveloperVersion()) {
				File templateFolder = new File(FileLocator.resolve(templateFolderUrl).getPath());
				File[] files = templateFolder.listFiles();
				for (int i = 0; i < files.length; i++) {
					Path path = new Path(files[i].getAbsolutePath());
					if (path.getFileExtension().equals("zip")) {
						ImportTemplate.importTemplate(files[i].getAbsolutePath(), true);
					}
				}
			} else {
				// loading the templates in the deployed version is very complicated, because you have to
				// list all files within the templates folder, which can't be done with File.list()
				// because This function doesn't work for jar files
				URL pluginJarFile = FileLocator.find(Activator.getDefault().getBundle(), new Path(""),
					Collections.EMPTY_MAP);

				String jarFilePath = FileLocator.resolve(pluginJarFile).getPath();

				// I couldn't find a function, which generates the correct path string.
				// so i take this one and manipulate it.
				// cut the last file separator and the "!"
				jarFilePath = jarFilePath.substring(0, jarFilePath.length() - 2);
				jarFilePath = jarFilePath.replace("file:", "");

				JarFile jarFile = new JarFile(jarFilePath);
				Enumeration<JarEntry> jarEnum = jarFile.entries();

				// walk through all entries in the jar file of the docExport bundle
				while (jarEnum.hasMoreElements()) {
					JarEntry jarEntry = jarEnum.nextElement();
					// filter the entries to the entries starting with the default templates folder
					if (jarEntry.getName().startsWith(DEFAULT_TEMPLATES_FOLDER)) {
						Path path = new Path(jarFilePath + File.separatorChar + jarEntry.getName());
						// make sure, that you don't try to import with a wrong file.
						if (path.getFileExtension() != null && path.getFileExtension().equals("zip")) {
							jarFile.getInputStream(jarEntry);
							InputStream fis = jarFile.getInputStream(jarEntry);
							FileOutputStream fos = new FileOutputStream(TEMPLATE_FOLDER + DEFAULT_TEMPLATE_TMP);
							readZipFile(fis, fos);
							ImportTemplate.importTemplate(TEMPLATE_FOLDER + DEFAULT_TEMPLATE_TMP, true);
						}
					}
				}
			}
		} catch (IOException e) {
			// no problem
			// if it doesn't work.. there is no imported default template.. bad luck then!
		} catch (InvalidTemplateArchiveException e) {
			// no problem
		} catch (TemplateSaveException e) {
			// no problem
		}
	}

	private static void readZipFile(InputStream fis, FileOutputStream fos) {
		try {
			byte[] buf = new byte[1024];
			int i = 0;
			while ((i = fis.read(buf)) != -1) {
				fos.write(buf, 0, i);
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			if (fis != null) {
				try {
					fis.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			try {
				fos.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

	/**
	 * loads the default template from the home folder. If this template doesn't exist, a new one will be created and
	 * saved.
	 * 
	 * @throws TemplateSaveException
	 */
	private static void loadDefaultTemplate() throws TemplateSaveException {
		try {
			template = loadTemplate(DEFAULT_TEMPLATE_NAME);
			WorkspaceUtil.log("The template " + DEFAULT_TEMPLATE_NAME + " has been loaded successfully",
				new Exception(), IStatus.OK);
		} catch (TemplateNotFoundException e) {
			WorkspaceUtil.log("The template " + DEFAULT_TEMPLATE_NAME + " could not be found."
				+ " Trying to load the templates files of the binary build.", new Exception(), IStatus.INFO);

			template = createNewDefaultDocumentTemplate();
			saveTemplate(template);
			WorkspaceUtil.log("A new default template has been created and saved successfully", new Exception(),
				IStatus.OK);
		}
	}

	/**
	 * Loads a Template from the templates file.
	 * 
	 * @param templateName the name of the template which shall be loaded
	 * @return the Template which shall be loaded
	 * @throws TemplateNotFoundException -
	 */
	public static Template loadTemplate(String templateName) throws TemplateNotFoundException {

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
	 * Loads a persistent template from the plug-in folder. If the template doesn't exist, null will be returned and an
	 * error will be added to the eclipse error log.
	 * 
	 * @param templateName the name of the template which shall be loaded
	 * @param resource the resource of the EMF store object
	 * @return the loaded template
	 * @throws TemplatesFileNotFoundException -
	 */
	public static Template getTemplate(String templateName, Resource resource) throws TemplatesFileNotFoundException {
		try {
			resource.load(resource.getResourceSet().getLoadOptions());
		} catch (IOException e) {
			WorkspaceUtil.log("Fetching template " + templateName + " failed ", new TemplatesFileNotFoundException(),
				IStatus.WARNING);
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
	 * Saves a template to the disc in the template folder of this plugin. The filename will be template.getName(). +
	 * ".template".
	 * 
	 * @param template the template which shall be saved
	 * @throws TemplateSaveException -
	 */
	public static void saveTemplate(Template template) throws TemplateSaveException {
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
			// WorkspaceUtil.log("template " + template.getName() + " saved successfully", new Exception(), IStatus.OK);

		} catch (TemplatesFileNotFoundException e) {
			WorkspaceUtil.log("this should never happen", e, IStatus.ERROR);
		} catch (IOException e) {
			throw new TemplateSaveException(e);
		}
	}

	/**
	 * @return a new DocumentTemplate
	 */
	public static Template createNewDefaultDocumentTemplate() {
		Template template = DefaultDocumentTemplateBuilder.build();
		template.setName(DEFAULT_TEMPLATE_NAME);

		return template;
	}

	/**
	 * @return an ArrayList of all templates which a stored in the template folder
	 * @throws TemplateSaveException -
	 */
	public static ArrayList<Template> getAllTemplates() throws TemplateSaveException {
		loadDefaultTemplatesFromZipFile();

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
			WorkspaceUtil.log("Fetching all templates failed", new TemplatesFileNotFoundException(), IStatus.WARNING);

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
	 * @param meCount the meCount to set
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
		String pathName = TEMPLATE_FOLDER + TEMPLATES_FILE_NAME;
		return pathName;
	}

	/**
	 * @return the static resource containing all templates
	 * @throws IOException .
	 */
	public static Resource getTemplatesResource() throws IOException {
		if (resourceSet == null) {
			resourceSet = new ResourceSetImpl();
		}
		URI fileURI = URI.createFileURI(getTemplatesPath());

		File templatesFile = new File(getTemplatesPath());
		if (!templatesFile.exists()) {
			try {
				Resource resource = resourceSet.createResource(fileURI);
				resource.save(null);
				return resource;
			} catch (IOException e) {
				WorkspaceUtil.log("The templates file could not be saved after creating a new resource",
					new Exception(), IStatus.ERROR);
				throw new IOException();
			}
		} else {
			return resourceSet.getResource(fileURI, true);
		}
	}
}
