/**
 * <copyright> Copyright (c) 2008-2009 Jonas Helming, Maximilian Koegel. All rights reserved. This program and the
 * accompanying materials are made available under the terms of the Eclipse Public License v1.0 which accompanies this
 * distribution, and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>
 */
package org.unicase.docExport.exportModel.renderers.specialRenderers.impl;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.unicase.docExport.exportModel.Template;
import org.unicase.docExport.exportModel.renderers.elements.UCompositeSection;
import org.unicase.docExport.exportModel.renderers.elements.UTable;
import org.unicase.docExport.exportModel.renderers.impl.AttributeRendererImpl;
import org.unicase.docExport.exportModel.renderers.options.UBorderStyle;
import org.unicase.docExport.exportModel.renderers.specialRenderers.ClassAttributesRenderer;
import org.unicase.docExport.exportModel.renderers.specialRenderers.SpecialRenderersPackage;
import org.unicase.model.UnicaseModelElement;
import org.unicase.model.classes.Attribute;

/**
 * <!-- begin-user-doc --> An implementation of the model object '<em><b>Class Attributes Renderer</b></em>'. <!--
 * end-user-doc -->
 * <p>
 * </p>
 * 
 * @generated
 */
public class ClassAttributesRendererImpl extends AttributeRendererImpl implements ClassAttributesRenderer {
	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	protected ClassAttributesRendererImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return SpecialRenderersPackage.Literals.CLASS_ATTRIBUTES_RENDERER;
	}

	@SuppressWarnings("unchecked")
	public void render(EStructuralFeature feature, UnicaseModelElement modelElement, UCompositeSection parent,
		Template template) {

		EList<Attribute> attributes = (EList<Attribute>) modelElement.eGet(feature);

		UTable table = new UTable(1);
		table.getBoxModel().setMarginTop(10);
		table.getDefaultCellBoxModel().setBorderBottom(0.5);
		table.getDefaultCellBoxModel().setBorderStyle(UBorderStyle.DOTTED);
		for (Attribute attribute : attributes) {
			table.add(attribute.getLabel(), template.getLayoutOptions().getDefaultTextOption());
		}

		parent.add(table);
	}

} // ClassAttributesRendererImpl
