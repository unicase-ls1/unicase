/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.unicase.documentexport.documentTemplate.renderers.specialRenderers.impl;

import java.util.Set;

import org.eclipse.emf.ecore.EClass;
import org.unicase.documentexport.documentTemplate.renderers.impl.ModelElementRendererImpl;
import org.unicase.documentexport.documentTemplate.renderers.options.OptionsFactory;
import org.unicase.documentexport.documentTemplate.renderers.specialRenderers.MilestoneRenderer;
import org.unicase.documentexport.documentTemplate.renderers.specialRenderers.SpecialRenderersPackage;
import org.unicase.documentexport.renderers.elements.UCompositeSection;
import org.unicase.documentexport.renderers.elements.UList;
import org.unicase.documentexport.renderers.elements.UParagraph;
import org.unicase.documentexport.renderers.elements.USection;
import org.unicase.model.ModelElement;
import org.unicase.model.task.util.OpeningLinkTaxonomy;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Milestone Renderer</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * </p>
 *
 * @generated
 */
public class MilestoneRendererImpl extends ModelElementRendererImpl implements MilestoneRenderer {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected MilestoneRendererImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return SpecialRenderersPackage.Literals.MILESTONE_RENDERER;
	}

	//begin custom code
	public void render(ModelElement modelElement, UCompositeSection parent) {
		OpeningLinkTaxonomy oLTaxonomy = new OpeningLinkTaxonomy();
		Set<ModelElement> test = oLTaxonomy.getLeafOpeners(modelElement);
		
		USection section = new USection(
				modelElement.getName(), 
				getTemplate().getLayoutOptions().getSectionTextOption()
			);
		UParagraph description = new UParagraph(
				modelElement.getDescriptionPlainText(),
				getTemplate().getLayoutOptions().getDefaultTextOption()
			);
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
	//end custom code

} //MilestoneRendererImpl
