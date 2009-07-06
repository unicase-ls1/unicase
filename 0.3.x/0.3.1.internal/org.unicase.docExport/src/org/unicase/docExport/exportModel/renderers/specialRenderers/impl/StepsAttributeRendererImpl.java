/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.unicase.docExport.exportModel.renderers.specialRenderers.impl;

import java.awt.Color;
import java.util.ArrayList;

import org.eclipse.core.runtime.IStatus;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.unicase.docExport.exportModel.Template;
import org.unicase.docExport.exportModel.renderers.elements.UCompositeSection;
import org.unicase.docExport.exportModel.renderers.elements.UParagraph;
import org.unicase.docExport.exportModel.renderers.elements.UTableCell;
import org.unicase.docExport.exportModel.renderers.elements.UTable;
import org.unicase.docExport.exportModel.renderers.impl.AttributeRendererImpl;
import org.unicase.docExport.exportModel.renderers.options.UBorderStyle;
import org.unicase.docExport.exportModel.renderers.specialRenderers.SpecialRenderersPackage;
import org.unicase.docExport.exportModel.renderers.specialRenderers.StepsAttributeRenderer;
import org.unicase.model.ModelElement;
import org.unicase.model.requirement.RequirementPackage;
import org.unicase.model.requirement.Step;
import org.unicase.workspace.util.WorkspaceUtil;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Steps Attribute Renderer</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * </p>
 *
 * @generated
 */
public class StepsAttributeRendererImpl extends AttributeRendererImpl implements StepsAttributeRenderer {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected StepsAttributeRendererImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return SpecialRenderersPackage.Literals.STEPS_ATTRIBUTE_RENDERER;
	}

	//begin custom code
	@SuppressWarnings("unchecked")
	public void render(
			EStructuralFeature feature, 
			ModelElement modelElement,
			UCompositeSection section, 
			Template template) {

		Object object = modelElement.eGet(feature);
		
		if (!feature.getEGenericType().getEClassifier().getName().equals(RequirementPackage.eINSTANCE.getStep().getName())
				|| !(object instanceof EList)
		) {
			WorkspaceUtil.log(
					"This Attribute renderer can only render a set of Steps.", 
					new Exception(), 
					IStatus.ERROR
				);
			return;
		}

		
		EList<Step> steps = (EList<Step>) modelElement.eGet(feature);
		
		UTable table = new UTable(2);
		table.getBoxModel().setMarginTop(10);
		table.getBoxModel().setMarginBottom(10);
		UTableCell actorSteps = new UTableCell("Actor steps", template.getLayoutOptions().getDefaultTextOption());
		actorSteps.getBoxModel().setBackgroundColor(new Color(230, 230, 230));
		actorSteps.getBoxModel().setBorderStyle(UBorderStyle.SOLID);
		actorSteps.getBoxModel().setBorderBottom(0.5);
		UTableCell systemSteps = new UTableCell("System steps", template.getLayoutOptions().getDefaultTextOption());
		systemSteps.getBoxModel().setBackgroundColor(new Color(230, 230, 230));
		systemSteps.getBoxModel().setBorderStyle(UBorderStyle.SOLID);
		systemSteps.getBoxModel().setBorderBottom(0.5);
		table.addCell(actorSteps);
		table.addCell(systemSteps);
		
		
		for (Step step : steps) {
			UTableCell userCol = new UTableCell("");
			userCol.getBoxModel().setBorderStyle(UBorderStyle.DASHED);
			userCol.getBoxModel().setBorderBottom(0.5);
			
			UTableCell systemCol = new UTableCell("");
			systemCol.getBoxModel().setBorderStyle(UBorderStyle.DASHED);
			systemCol.getBoxModel().setBorderBottom(0.5);
			
			table.addCell(userCol);
			table.addCell(systemCol);
			
			if (step.isUserStep()) {
				userCol.setContent(new UParagraph(WorkspaceUtil.cleanFormatedText(step.getDescription()),  template.getLayoutOptions().getDefaultTextOption()));
				
			} else {
				systemCol.setContent(new UParagraph(WorkspaceUtil.cleanFormatedText(step.getDescription()),  template.getLayoutOptions().getDefaultTextOption()));
			}
		}
		
		ArrayList<UTableCell> entries = table.getEntries();
		
		//remove border line of last row
		entries.get(entries.size()-1).getBoxModel().setBorderBottom(0);
		entries.get(entries.size()-2).getBoxModel().setBorderBottom(0);
		
		section.add(table);
	}
	//end custom code
	
} //StepsAttributeRendererImpl
