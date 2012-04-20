/**
 * <copyright> Copyright (c) 2009-2012 Chair of Applied Software Engineering, Technische Universität München (TUM).
 * All rights reserved. This program and the accompanying materials are made available under the terms of
 * the Eclipse Public License v1.0 which accompanies this distribution,
 * and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>
 */
package org.unicase.docExport.exportModel.renderers.specialRenderers.impl;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.Collections;

import org.eclipse.core.runtime.FileLocator;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Path;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.emfstore.client.model.util.WorkspaceUtil;
import org.unicase.docExport.Activator;
import org.unicase.docExport.TemplateRegistry;
import org.unicase.docExport.exportModel.renderers.AttributeRenderer;
import org.unicase.docExport.exportModel.renderers.elements.UCompositeSection;
import org.unicase.docExport.exportModel.renderers.elements.UImage;
import org.unicase.docExport.exportModel.renderers.elements.UParagraph;
import org.unicase.docExport.exportModel.renderers.elements.USection;
import org.unicase.docExport.exportModel.renderers.elements.UTable;
import org.unicase.docExport.exportModel.renderers.impl.ModelElementRendererImpl;
import org.unicase.docExport.exportModel.renderers.specialRenderers.ClassRenderer;
import org.unicase.docExport.exportModel.renderers.specialRenderers.SpecialRenderersPackage;
import org.unicase.model.UnicaseModelElement;
import org.unicase.model.classes.Association;

/**
 * <!-- begin-user-doc --> An implementation of the model object '<em><b>Class Renderer</b></em>'. <!-- end-user-doc -->
 * <p>
 * </p>
 * 
 * @generated
 */
public class ClassRendererImpl extends ModelElementRendererImpl implements ClassRenderer {

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	protected ClassRendererImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return SpecialRenderersPackage.Literals.CLASS_RENDERER;
	}

	@SuppressWarnings("unchecked")
	@Override
	protected void doRender(EObject eObject, UCompositeSection section) {

		UnicaseModelElement modelElement = (UnicaseModelElement) eObject;

		// Render title and description
		USection modelElementSection = new USection();
		section.add(modelElementSection);
		renderTitleAndDescription(modelElement, modelElementSection, false);

		AttributeRenderer methodsRenderer = getAttributeRendererNotNull(getFeature("methods", modelElement));
		AttributeRenderer attributesRenderer = getAttributeRendererNotNull(getFeature("attributes", modelElement));

		methodsRenderer.render(getFeature("methods", modelElement), modelElement, modelElementSection, template);
		attributesRenderer.render(getFeature("attributes", modelElement), modelElement, modelElementSection, template);

		Object attributeValue = modelElement.eGet(getFeature("incomingAssociations", modelElement));
		EList<Association> incomingAssociations = (EList<Association>) attributeValue;

		attributeValue = modelElement.eGet(getFeature("outgoingAssociations", modelElement));
		EList<Association> outgoingAssociations = (EList<Association>) attributeValue;

		for (Association association : incomingAssociations) {
			renderAssociation(modelElementSection, association, true);
		}

		for (Association association : outgoingAssociations) {
			renderAssociation(modelElementSection, association, false);
		}

	}

	private void renderAssociation(UCompositeSection parent, Association association, boolean incoming) {

		if (association.getSource() == null || association.getTarget() == null) {
			return;
		}

		UTable table = new UTable(4);

		table.setColumnsWidths(new float[] { 3, 10, 7, 100 });

		if (incoming) {
			table.add(association.getTargetMultiplicity());
		} else {
			table.add(association.getSourceMultiplicity());
		}

		UParagraph imageCell = new UParagraph("");
		table.add(imageCell);

		renderAssociationImage(imageCell, association, incoming);

		if (incoming) {
			table.add(association.getSourceMultiplicity());
			table.add(association.getSource().getName());
		} else {
			table.add(association.getTargetMultiplicity());
			table.add(association.getTarget().getName());
		}

		parent.add(table);
	}

	private void renderAssociationImage(UCompositeSection parent, Association association, boolean incoming) {

		URL templateImageFolder = FileLocator.find(Activator.getDefault().getBundle(), new Path(
			TemplateRegistry.DOCEXPORT_IMAGES + File.separatorChar), Collections.EMPTY_MAP);

		UImage image;

		String inv = "";
		if (incoming) {
			inv = "_INV";
		}

		File imageFile;

		try {
			imageFile = new File(FileLocator.resolve(templateImageFolder).getPath() + association.getType().getName()
				+ inv + ".gif");
			image = new UImage(new Path(imageFile.getAbsolutePath()));
			image.setWidth(40);
			parent.add(image);
		} catch (IOException e) {
			WorkspaceUtil.log("An image of an association is missing", e, IStatus.WARNING);
		}

	}

} // ClassRendererImpl
