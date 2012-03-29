/**
 * <copyright> Copyright (c) 2009-2012 Chair of Applied Software Engineering, Technische Universität München (TUM).
* All rights reserved. This program and the accompanying materials are made available under the terms of
* the Eclipse Public License v1.0 which accompanies this distribution,
* and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>
 */
package org.unicase.docExport.commands;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

import org.eclipse.core.commands.AbstractHandler;
import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.commands.ExecutionException;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.emf.emfstore.client.model.util.WorkspaceUtil;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.handlers.HandlerUtil;
import org.unicase.docExport.TemplateRegistry;
import org.unicase.docExport.exportModel.Template;

/**
 * The handler for the export template command.
 * 
 * @author Sebastian Hoecht
 */
public class ExportTemplate extends AbstractHandler {

	/**
	 * The filename of the logo in the zip file.
	 */
	public static final String LOGO_FILE_NAME = "logo";

	/**
	 * the filename of the resource where the template is stored.
	 */
	public static final String TEMPLATE_RESOURCE_FILE_NAME = "templateResource";

	/**
	 * {@inheritDoc}
	 */
	public Object execute(ExecutionEvent event) throws ExecutionException {

		ISelection sel = HandlerUtil.getCurrentSelection(event);
		if (!(sel instanceof IStructuredSelection)) {
			return null;
		}
		IStructuredSelection ssel = (IStructuredSelection) sel;
		if (ssel.isEmpty()) {
			return null;
		}

		Object o = ssel.getFirstElement();
		if (!(o instanceof Template)) {
			return null;
		}

		Template template = (Template) o;

		ExportTemplateDialog dialog;
		dialog = new ExportTemplateDialog(PlatformUI.getWorkbench().getDisplay().getActiveShell(), template);
		dialog.open();

		return null;
	}

	private static File createTemplateFile(Template template) throws IOException {
		ResourceSet resourceSet = new ResourceSetImpl();

		final File tmpTemplateFile = File.createTempFile(template.getName(), ".template");
		URI fileURI = URI.createFileURI(tmpTemplateFile.getAbsolutePath());

		try {
			Resource resource = resourceSet.createResource(fileURI);
			resource.getContents().add(template);
			resource.save(null);
		} catch (IOException e) {
			WorkspaceUtil.log("couldn't save the template temporarily for template export handling", new Exception(),
				IStatus.WARNING);
			throw new IOException();
		}
		return tmpTemplateFile;
	}

	/**
	 * Export a template to a file.
	 * 
	 * @param template the template which shall be exported to a file
	 * @param filePath the location where the template shall be saved
	 * @throws IOException shit happens...
	 */
	public static void exportTemplate(Template template, String filePath) throws IOException {
		File resource = createTemplateFile(template);
		saveZipFile(filePath, resource.getAbsolutePath(), template.getLayoutOptions().getLogoImage());
	}

	private static void saveZipFile(String zipFilePath, String templateResourcePath, String logoImagePath)
		throws IOException {
		String[] filePaths = new String[] { templateResourcePath, logoImagePath };

		// Create a buffer for reading the files
		byte[] buf = new byte[1024];

		// Create the ZIP file
		ZipOutputStream out = new ZipOutputStream(new FileOutputStream(zipFilePath + ".zip"));

		// Compress the files
		for (int i = 0; i < filePaths.length; i++) {
			String filePath;
			if (i == 1) {
				// image
				filePath = TemplateRegistry.TEMPLATE_IMAGE_FOLDER + filePaths[i];
			} else {
				filePath = filePaths[i];
			}

			if (filePath == null || !new File(filePath).exists()) {
				// no image - do nothing
			} else {
				FileInputStream in = new FileInputStream(filePath);

				if (i == 0) {
					out.putNextEntry(new ZipEntry(TEMPLATE_RESOURCE_FILE_NAME));
				} else {
					out.putNextEntry(new ZipEntry(LOGO_FILE_NAME));
				}

				// Transfer bytes from the file to the ZIP file
				int len;
				while ((len = in.read(buf)) > 0) {
					out.write(buf, 0, len);
				}

				// Complete the entry
				out.closeEntry();
				in.close();
			}
		}

		// Complete the ZIP file
		out.close();
	}

}
