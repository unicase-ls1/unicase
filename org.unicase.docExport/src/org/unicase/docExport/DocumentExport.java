/**
 * <copyright> Copyright (c) 2009-2012 Chair of Applied Software Engineering, Technische Universität München (TUM).
 * All rights reserved. This program and the accompanying materials are made available under the terms of
 * the Eclipse Public License v1.0 which accompanies this distribution,
 * and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>
 */
package org.unicase.docExport;

import java.lang.reflect.InvocationTargetException;
import java.util.HashSet;

import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.jface.operation.IRunnableWithProgress;
import org.unicase.docExport.docWriter.DocWriter;
import org.unicase.docExport.exceptions.DocumentExportException;
import org.unicase.docExport.exportModel.Template;
import org.unicase.docExport.exportModel.renderers.DocumentRenderer;
import org.unicase.docExport.exportModel.renderers.elements.URootCompositeSection;
import org.unicase.metamodel.ModelElementId;
import org.unicase.metamodel.util.ModelUtil;
import org.unicase.model.UnicaseModelElement;

/**
 * This class wraps the document rendering (see package renderers) and document writing (see package docWriter) into an
 * class which can be used for progress bars.
 * 
 * @author Sebastian Hoecht
 */
public class DocumentExport implements IRunnableWithProgress {

	private UnicaseModelElement modelElement;
	private DocWriter docWriter;
	private Template template;
	private DocumentRenderer renderer;
	private String fileLocation;

	private static int recursionDepth = 10;
	private static boolean treatModelElementAsLeafSection;
	private static HashSet<String> renderedModelElements;
	private static HashSet<UnicaseModelElement> linkedModelElements;

	/**
	 * @param modelElement the ModelElement you want to export
	 * @param docWriter the docWriter used to write the document
	 * @param documentTemplate the template which defines how the modelElement is rendered
	 * @param renderer the DocumentRenderer which renders the modelElement using the template
	 */
	public DocumentExport(UnicaseModelElement modelElement, DocWriter docWriter, Template documentTemplate,
		DocumentRenderer renderer) {
		this.modelElement = modelElement;
		this.docWriter = docWriter;
		this.template = documentTemplate;
		this.renderer = renderer;

		renderedModelElements = new HashSet<String>();
		linkedModelElements = new HashSet<UnicaseModelElement>();
	}

	/**
	 * exports a the ModelElement to the file.
	 * 
	 * @param fileLocation the location where the modelElement shall be exported.
	 * @throws DocumentExportException when the export failed for any reason.
	 */
	public void export(String fileLocation) throws DocumentExportException {
		URootCompositeSection doc = renderer.render(modelElement, template);
		docWriter.export(fileLocation, doc);

	}

	/**
	 * {@inheritDoc}
	 */
	public void run(IProgressMonitor monitor) throws InvocationTargetException, InterruptedException {

		monitor.beginTask("Exporting Document", IProgressMonitor.UNKNOWN);
		try {
			export(this.fileLocation);
		} catch (DocumentExportException e) {
			throw new InvocationTargetException(e);
		}

		if (monitor.isCanceled()) {
			throw new InterruptedException("The export has been canceled");
		}

		monitor.done();
	}

	/**
	 * @param fileLocation the fileLocation to set
	 */
	public void setFileLocation(String fileLocation) {
		this.fileLocation = fileLocation;
	}

	/**
	 * If a ModelElement is linked in the Document, it should be added with this function. This is required for the
	 * appendix.
	 * 
	 * @param me The ModelElement to add
	 */
	public static void addLinkedModelElement(UnicaseModelElement me) {
		linkedModelElements.add(me);
	}

	/**
	 * @return a set of ModelElements which have been linked in the ongoing DocumentExport
	 */
	public static HashSet<UnicaseModelElement> getLinkedModelElements() {
		return linkedModelElements;
	}

	/**
	 * This function is required, to avoid recursive ModelElement rendering.
	 * 
	 * @param me the ModelElement which has been rendered to the Document
	 */
	public static void addRenderedModelElement(UnicaseModelElement me) {
		ModelElementId meId = ModelUtil.getProject(me).getModelElementId(me);
		renderedModelElements.add(meId.getId());
	}

	/**
	 * @param me the ModelElement which shall be tested, if it has already been rednered to the document
	 * @return true, if the ModelElement has been rendered yet
	 */
	public static boolean hasAlreadyBeenRendered(UnicaseModelElement me) {
		ModelElementId meId = ModelUtil.getProject(me).getModelElementId(me);
		return renderedModelElements.contains(meId.getId());
	}

	/**
	 * @see #hasAlreadyBeenRendered(ModelElement)
	 * @param modelElementId the ModelElementId of the modelElement which shall be checked for rendering
	 * @return true, if the ModelElement has been rendered yet
	 */
	public static boolean hasAlreadyBeenRendered(String modelElementId) {
		return renderedModelElements.contains(modelElementId);
	}

	/**
	 * Resets all HashSets. This function should be called before any document rendering is started.
	 */
	public static void initiateRenderedModelElements() {
		renderedModelElements = new HashSet<String>();
		linkedModelElements = new HashSet<UnicaseModelElement>();
	}

	/**
	 * @param recursionDepth the recursionDepth to set
	 */
	public static void setRecursionDepth(int recursionDepth) {
		DocumentExport.recursionDepth = recursionDepth;
	}

	/**
	 * @return the recursionDepth
	 */
	public static int getRecursionDepth() {
		return recursionDepth;
	}

	/**
	 * @param treatModelElementAsLeafSection the treatModelElementAsLeafSection to set
	 */
	public static void setTreatModelElementAsLeafSection(boolean treatModelElementAsLeafSection) {
		DocumentExport.treatModelElementAsLeafSection = treatModelElementAsLeafSection;
	}

	/**
	 * @return the treatModelElementAsLeafSection
	 */
	public static boolean isTreatModelElementAsLeafSection() {
		return treatModelElementAsLeafSection;
	}

}
