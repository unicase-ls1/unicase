/**
 * <copyright> Copyright (c) 2008 Jonas Helming, Maximilian Koegel. All rights reserved. This program and the
 * accompanying materials are made available under the terms of the Eclipse Public License v1.0 which accompanies this
 * distribution, and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>
 */
package org.unicase.docExport.exportModel.renderers.specialRenderers.impl;

import java.util.Set;

import org.eclipse.emf.ecore.EClass;
import org.unicase.docExport.exportModel.renderers.elements.UCompositeSection;
import org.unicase.docExport.exportModel.renderers.elements.UList;
import org.unicase.docExport.exportModel.renderers.elements.UParagraph;
import org.unicase.docExport.exportModel.renderers.elements.USection;
import org.unicase.docExport.exportModel.renderers.impl.ModelElementRendererImpl;
import org.unicase.docExport.exportModel.renderers.options.OptionsFactory;
import org.unicase.docExport.exportModel.renderers.specialRenderers.MilestoneRenderer;
import org.unicase.docExport.exportModel.renderers.specialRenderers.SpecialRenderersPackage;
import org.unicase.model.ModelElement;
import org.unicase.model.task.util.OpeningLinkTaxonomy;
import org.unicase.workspace.util.WorkspaceUtil;

/**
 * <!-- begin-user-doc --> An implementation of the model object '<em><b>Milestone Renderer</b></em>'. <!-- end-user-doc
 * -->
 * <p>
 * </p>
 * 
 * @generated
 */
public class MilestoneRendererImpl extends ModelElementRendererImpl implements MilestoneRenderer {
	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	protected MilestoneRendererImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return SpecialRenderersPackage.Literals.MILESTONE_RENDERER;
	}

	// begin custom code
	@Override
	public void doRender(ModelElement modelElement, UCompositeSection parent) {
		OpeningLinkTaxonomy oLTaxonomy = new OpeningLinkTaxonomy();
		Set<ModelElement> test = oLTaxonomy.getLeafOpeners(modelElement);

		USection section = new USection(modelElement.getName(), getTemplate().getLayoutOptions().getSectionTextOption());
		UParagraph description = new UParagraph(WorkspaceUtil.cleanFormatedText(modelElement.getDescription()),
			getTemplate().getLayoutOptions().getDefaultTextOption());
		description.setIndentionLeft(1);

		parent.add(section);
		section.add(description);

		UList uList = new UList(OptionsFactory.eINSTANCE.createListOption());
		uList.setIndentionLeft(1);

		for (ModelElement me : test) {
			uList.add(me.getName());
		}

		section.add(uList);

	}
	// end custom code

} // MilestoneRendererImpl
