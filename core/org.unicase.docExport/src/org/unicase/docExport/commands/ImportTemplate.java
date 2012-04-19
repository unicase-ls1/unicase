/**
 * <copyright> Copyright (c) 2009-2012 Chair of Applied Software Engineering, Technische Universität München (TUM).
* All rights reserved. This program and the accompanying materials are made available under the terms of
* the Eclipse Public License v1.0 which accompanies this distribution,
* and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>
 */
package org.unicase.docExport.commands;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;

import org.eclipse.core.commands.AbstractHandler;
import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.commands.ExecutionException;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.emf.ecp.common.util.PreferenceHelper;
import org.eclipse.emf.emfstore.client.model.util.WorkspaceUtil;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.FileDialog;
import org.eclipse.swt.widgets.MessageBox;
import org.eclipse.ui.PlatformUI;
import org.unicase.docExport.TemplateRegistry;
import org.unicase.docExport.exceptions.InvalidTemplateArchiveException;
import org.unicase.docExport.exceptions.TemplateImportException;
import org.unicase.docExport.exceptions.TemplateSaveException;
import org.unicase.docExport.exceptions.TemplatesFileNotFoundException;
import org.unicase.docExport.exportModel.Template;

/**
 * The handler for the import template command.
 * 
 * @author Sebastian Hoecht
 */
public class ImportTemplate extends AbstractHandler {

	private static final String IMPORT_TEMPLATE_PATH = "org.unicase.docExport.importTemplatePath";

	/**
	 * {@inheritDoc}
	 */
	public Object execute(ExecutionEvent event) throws ExecutionException {

		FileDialog fd = new FileDialog(PlatformUI.getWorkbench().getDisplay().getActiveShell(), SWT.OPEN);
		String initialPath = PreferenceHelper.getPreference(IMPORT_TEMPLATE_PATH, System.getProperty("user.home"));
		fd.setFilterPath(initialPath);
		fd.setText("Enter the filename, where you want to save the template");
		String filePath = fd.open();

		if (filePath != null) {
			PreferenceHelper.setPreference(IMPORT_TEMPLATE_PATH, new File(filePath).getParent());
			try {
				importTemplate(filePath, false);
			} catch (InvalidTemplateArchiveException e) {
				WorkspaceUtil.log("The template import failed", e, IStatus.ERROR);
			} catch (TemplateSaveException e) {
				WorkspaceUtil.log("The template import failed", e, IStatus.ERROR);
			}
		}

		return null;
	}

	/**
	 * Imports a Template stored in a zip file to the local folders of the client. The zip file contains a resource of
	 * the Template and an image file, if there is a logo stored in the Template.
	 * 
	 * @param zipFilePath the Path of the File which should contain an exported Template
	 * @param isDefaultTemplate if the template ist imported manually, it is not a default template and therefore, it
	 *            can be edited.
	 * @throws InvalidTemplateArchiveException The zipFile is missing some important files
	 * @throws TemplateSaveException The template which shall be imported could not be saved
	 */
	public static void importTemplate(String zipFilePath, boolean isDefaultTemplate)
		throws InvalidTemplateArchiveException, TemplateSaveException {
		InputStream theFile;
		try {
			theFile = new FileInputStream(zipFilePath);
			ZipInputStream stream = new ZipInputStream(theFile);

			try {
				// now iterate through each item in the stream. The get next
				// entry call will return a ZipEntry for each file in the
				// stream
				ZipEntry entry;
				Template template = null;
				while ((entry = stream.getNextEntry()) != null) {
					if (entry.getName().equals(ExportTemplate.TEMPLATE_RESOURCE_FILE_NAME)) {
						template = storeTemplate(entry, stream, isDefaultTemplate);
					} else if (entry.getName().equals(ExportTemplate.LOGO_FILE_NAME)) {
						storeImage(entry, stream, template);
					}
				}
			} catch (IOException e) {
				MessageBox finished = new MessageBox(PlatformUI.getWorkbench().getDisplay().getActiveShell(), SWT.OK
					| SWT.ICON_INFORMATION);
				finished.setText("Template import failed");
				finished.setMessage("The template file could not be accessed for any reason");
				finished.open();
			} catch (TemplateImportException e) {
				MessageBox finished = new MessageBox(PlatformUI.getWorkbench().getDisplay().getActiveShell(), SWT.OK
					| SWT.ICON_INFORMATION);
				finished.setText("Template import failed");
				finished.setMessage("The template import failed for some reason.");
				finished.open();
			} finally {
				try {
					stream.close();
				} catch (IOException e) {
					// nothing to do
				}
			}
		} catch (FileNotFoundException e1) {
			throw new InvalidTemplateArchiveException();
		}
	}

	/**
	 * Store a template saved in a zip file into the templates resource.
	 * 
	 * @throws TemplateImportException
	 */
	private static Template storeTemplate(ZipEntry entry, ZipInputStream stream, boolean isDefaultTemplate)
		throws TemplateImportException {
		String outPath;
		File tmpTemplateFile;
		try {
			tmpTemplateFile = File.createTempFile("templateImport", ".template");
			outPath = tmpTemplateFile.getAbsolutePath();

			writeZipData(outPath, stream);

			Template template = getTemplate(tmpTemplateFile.getAbsolutePath());
			if (isDefaultTemplate) {
				template.setDefaultTemplate(true);
			} else {
				template.setDefaultTemplate(false);
			}
			TemplateRegistry.saveTemplate(template);
			return template;
		} catch (IOException e) {
			throw new TemplateImportException(e);
		} catch (InvalidTemplateArchiveException e) {
			throw new TemplateImportException(e);
		} catch (TemplatesFileNotFoundException e) {
			throw new TemplateImportException(e);
		}
	}

	private static void storeImage(ZipEntry entry, ZipInputStream stream, Template template)
		throws TemplateImportException, IOException {
		String outPath;
		File tmpTemplateFile;

		File imageFolder = new File(TemplateRegistry.TEMPLATE_IMAGE_FOLDER);
		imageFolder.mkdirs();
		tmpTemplateFile = File.createTempFile("templateLogoImport", ".tmp");
		outPath = tmpTemplateFile.getAbsolutePath();

		writeZipData(outPath, stream);
		tmpTemplateFile.renameTo(new File(TemplateRegistry.TEMPLATE_IMAGE_FOLDER
			+ template.getLayoutOptions().getLogoImage()));

	}

	private static void writeZipData(String outPath, ZipInputStream stream) throws TemplateImportException {
		// create a buffer to improve copy performance later.
		byte[] buffer = new byte[1024];

		FileOutputStream output = null;
		try {
			try {
				output = new FileOutputStream(outPath);
				int len = 0;
				while ((len = stream.read(buffer)) > 0) {
					output.write(buffer, 0, len);
				}
			} catch (FileNotFoundException e) {
				throw new TemplateImportException(e);
			} catch (IOException e) {
				throw new TemplateImportException(e);
			}

		} finally {
			// we must always close the output file
			if (output != null) {
				try {
					output.close();
				} catch (IOException e) {
					// nothing to do.
				}
			}
		}
	}

	/**
	 * Returns the template from a EMF XML resource file.
	 */
	private static Template getTemplate(String resourceFile) throws InvalidTemplateArchiveException {
		ResourceSet resourceSet = new ResourceSetImpl();
		URI fileURI = URI.createFileURI(resourceFile);

		Resource templateResource = resourceSet.getResource(fileURI, true);

		try {
			templateResource.load(templateResource.getResourceSet().getLoadOptions());
		} catch (IOException e) {
			WorkspaceUtil.log("Importing Template failed", new TemplatesFileNotFoundException(e), IStatus.WARNING);
			throw new InvalidTemplateArchiveException();
		}

		EList<EObject> contents = templateResource.getContents();
		for (EObject object : contents) {
			if (object instanceof Template) {
				return (Template) object;
			}
		}

		throw new InvalidTemplateArchiveException();
	}
}
