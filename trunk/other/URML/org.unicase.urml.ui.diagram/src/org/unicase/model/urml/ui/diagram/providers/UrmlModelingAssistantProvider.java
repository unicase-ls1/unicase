package org.unicase.model.urml.ui.diagram.providers;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;

import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.edit.ui.provider.AdapterFactoryLabelProvider;
import org.eclipse.gmf.runtime.diagram.ui.editparts.IGraphicalEditPart;
import org.eclipse.gmf.runtime.emf.type.core.ElementTypeRegistry;
import org.eclipse.gmf.runtime.emf.type.core.IElementType;
import org.eclipse.gmf.runtime.emf.ui.services.modelingassistant.ModelingAssistantProvider;
import org.eclipse.gmf.runtime.notation.Diagram;
import org.eclipse.jface.viewers.ILabelProvider;
import org.eclipse.jface.window.Window;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.ui.dialogs.ElementListSelectionDialog;
import org.unicase.model.urml.ui.diagram.edit.parts.ActorEditPart;
import org.unicase.model.urml.ui.diagram.edit.parts.DangerEditPart;
import org.unicase.model.urml.ui.diagram.edit.parts.FeatureEditPart;
import org.unicase.model.urml.ui.diagram.edit.parts.FunctionalRequirementEditPart;
import org.unicase.model.urml.ui.diagram.edit.parts.GoalEditPart;
import org.unicase.model.urml.ui.diagram.edit.parts.NonFunctionalRequirementEditPart;
import org.unicase.model.urml.ui.diagram.edit.parts.ProceduralMitigationEditPart;
import org.unicase.model.urml.ui.diagram.edit.parts.ProductEditPart;
import org.unicase.model.urml.ui.diagram.edit.parts.ServiceEditPart;
import org.unicase.model.urml.ui.diagram.edit.parts.StakeholderEditPart;
import org.unicase.model.urml.ui.diagram.edit.parts.URMLDiagramEditPart;
import org.unicase.model.urml.ui.diagram.edit.parts.VariationPointEditPart;
import org.unicase.model.urml.ui.diagram.edit.parts.VariationPointInstanceEditPart;
import org.unicase.model.urml.ui.diagram.part.Messages;
import org.unicase.model.urml.ui.diagram.part.UrmlDiagramEditorPlugin;

/**
 * @generated
 */
public class UrmlModelingAssistantProvider extends ModelingAssistantProvider {

	/**
	 * @generated
	 */
	public List getTypesForPopupBar(IAdaptable host) {
		IGraphicalEditPart editPart = (IGraphicalEditPart) host.getAdapter(IGraphicalEditPart.class);
		if (editPart instanceof URMLDiagramEditPart) {
			ArrayList types = new ArrayList(12);
			types.add(UrmlElementTypes.Stakeholder_2002);
			types.add(UrmlElementTypes.Goal_2001);
			types.add(UrmlElementTypes.FunctionalRequirement_2006);
			types.add(UrmlElementTypes.Feature_2012);
			types.add(UrmlElementTypes.Service_2007);
			types.add(UrmlElementTypes.NonFunctionalRequirement_2008);
			types.add(UrmlElementTypes.Danger_2009);
			types.add(UrmlElementTypes.Actor_2010);
			types.add(UrmlElementTypes.ProceduralMitigation_2011);
			types.add(UrmlElementTypes.VariationPoint_2013);
			types.add(UrmlElementTypes.VariationPointInstance_2014);
			types.add(UrmlElementTypes.Product_2015);
			return types;
		}
		return Collections.EMPTY_LIST;
	}

	/**
	 * @generated
	 */
	public List getRelTypesOnSource(IAdaptable source) {
		IGraphicalEditPart sourceEditPart = (IGraphicalEditPart) source.getAdapter(IGraphicalEditPart.class);
		if (sourceEditPart instanceof StakeholderEditPart) {
			return ((StakeholderEditPart) sourceEditPart).getMARelTypesOnSource();
		}
		if (sourceEditPart instanceof GoalEditPart) {
			return ((GoalEditPart) sourceEditPart).getMARelTypesOnSource();
		}
		if (sourceEditPart instanceof FunctionalRequirementEditPart) {
			return ((FunctionalRequirementEditPart) sourceEditPart).getMARelTypesOnSource();
		}
		if (sourceEditPart instanceof FeatureEditPart) {
			return ((FeatureEditPart) sourceEditPart).getMARelTypesOnSource();
		}
		if (sourceEditPart instanceof ServiceEditPart) {
			return ((ServiceEditPart) sourceEditPart).getMARelTypesOnSource();
		}
		if (sourceEditPart instanceof NonFunctionalRequirementEditPart) {
			return ((NonFunctionalRequirementEditPart) sourceEditPart).getMARelTypesOnSource();
		}
		if (sourceEditPart instanceof DangerEditPart) {
			return ((DangerEditPart) sourceEditPart).getMARelTypesOnSource();
		}
		if (sourceEditPart instanceof ActorEditPart) {
			return ((ActorEditPart) sourceEditPart).getMARelTypesOnSource();
		}
		if (sourceEditPart instanceof ProceduralMitigationEditPart) {
			return ((ProceduralMitigationEditPart) sourceEditPart).getMARelTypesOnSource();
		}
		if (sourceEditPart instanceof VariationPointEditPart) {
			return ((VariationPointEditPart) sourceEditPart).getMARelTypesOnSource();
		}
		if (sourceEditPart instanceof VariationPointInstanceEditPart) {
			return ((VariationPointInstanceEditPart) sourceEditPart).getMARelTypesOnSource();
		}
		if (sourceEditPart instanceof ProductEditPart) {
			return ((ProductEditPart) sourceEditPart).getMARelTypesOnSource();
		}
		return Collections.EMPTY_LIST;
	}

	/**
	 * @generated
	 */
	public List getRelTypesOnTarget(IAdaptable target) {
		IGraphicalEditPart targetEditPart = (IGraphicalEditPart) target.getAdapter(IGraphicalEditPart.class);
		if (targetEditPart instanceof GoalEditPart) {
			return ((GoalEditPart) targetEditPart).getMARelTypesOnTarget();
		}
		if (targetEditPart instanceof FunctionalRequirementEditPart) {
			return ((FunctionalRequirementEditPart) targetEditPart).getMARelTypesOnTarget();
		}
		if (targetEditPart instanceof FeatureEditPart) {
			return ((FeatureEditPart) targetEditPart).getMARelTypesOnTarget();
		}
		if (targetEditPart instanceof ServiceEditPart) {
			return ((ServiceEditPart) targetEditPart).getMARelTypesOnTarget();
		}
		if (targetEditPart instanceof NonFunctionalRequirementEditPart) {
			return ((NonFunctionalRequirementEditPart) targetEditPart).getMARelTypesOnTarget();
		}
		if (targetEditPart instanceof DangerEditPart) {
			return ((DangerEditPart) targetEditPart).getMARelTypesOnTarget();
		}
		if (targetEditPart instanceof ActorEditPart) {
			return ((ActorEditPart) targetEditPart).getMARelTypesOnTarget();
		}
		if (targetEditPart instanceof VariationPointEditPart) {
			return ((VariationPointEditPart) targetEditPart).getMARelTypesOnTarget();
		}
		if (targetEditPart instanceof VariationPointInstanceEditPart) {
			return ((VariationPointInstanceEditPart) targetEditPart).getMARelTypesOnTarget();
		}
		return Collections.EMPTY_LIST;
	}

	/**
	 * @generated
	 */
	public List getRelTypesOnSourceAndTarget(IAdaptable source, IAdaptable target) {
		IGraphicalEditPart sourceEditPart = (IGraphicalEditPart) source.getAdapter(IGraphicalEditPart.class);
		IGraphicalEditPart targetEditPart = (IGraphicalEditPart) target.getAdapter(IGraphicalEditPart.class);
		if (sourceEditPart instanceof StakeholderEditPart) {
			return ((StakeholderEditPart) sourceEditPart).getMARelTypesOnSourceAndTarget(targetEditPart);
		}
		if (sourceEditPart instanceof GoalEditPart) {
			return ((GoalEditPart) sourceEditPart).getMARelTypesOnSourceAndTarget(targetEditPart);
		}
		if (sourceEditPart instanceof FunctionalRequirementEditPart) {
			return ((FunctionalRequirementEditPart) sourceEditPart).getMARelTypesOnSourceAndTarget(targetEditPart);
		}
		if (sourceEditPart instanceof FeatureEditPart) {
			return ((FeatureEditPart) sourceEditPart).getMARelTypesOnSourceAndTarget(targetEditPart);
		}
		if (sourceEditPart instanceof ServiceEditPart) {
			return ((ServiceEditPart) sourceEditPart).getMARelTypesOnSourceAndTarget(targetEditPart);
		}
		if (sourceEditPart instanceof NonFunctionalRequirementEditPart) {
			return ((NonFunctionalRequirementEditPart) sourceEditPart).getMARelTypesOnSourceAndTarget(targetEditPart);
		}
		if (sourceEditPart instanceof DangerEditPart) {
			return ((DangerEditPart) sourceEditPart).getMARelTypesOnSourceAndTarget(targetEditPart);
		}
		if (sourceEditPart instanceof ActorEditPart) {
			return ((ActorEditPart) sourceEditPart).getMARelTypesOnSourceAndTarget(targetEditPart);
		}
		if (sourceEditPart instanceof ProceduralMitigationEditPart) {
			return ((ProceduralMitigationEditPart) sourceEditPart).getMARelTypesOnSourceAndTarget(targetEditPart);
		}
		if (sourceEditPart instanceof VariationPointEditPart) {
			return ((VariationPointEditPart) sourceEditPart).getMARelTypesOnSourceAndTarget(targetEditPart);
		}
		if (sourceEditPart instanceof VariationPointInstanceEditPart) {
			return ((VariationPointInstanceEditPart) sourceEditPart).getMARelTypesOnSourceAndTarget(targetEditPart);
		}
		if (sourceEditPart instanceof ProductEditPart) {
			return ((ProductEditPart) sourceEditPart).getMARelTypesOnSourceAndTarget(targetEditPart);
		}
		return Collections.EMPTY_LIST;
	}

	/**
	 * @generated
	 */
	public List getTypesForSource(IAdaptable target, IElementType relationshipType) {
		IGraphicalEditPart targetEditPart = (IGraphicalEditPart) target.getAdapter(IGraphicalEditPart.class);
		if (targetEditPart instanceof GoalEditPart) {
			return ((GoalEditPart) targetEditPart).getMATypesForSource(relationshipType);
		}
		if (targetEditPart instanceof FunctionalRequirementEditPart) {
			return ((FunctionalRequirementEditPart) targetEditPart).getMATypesForSource(relationshipType);
		}
		if (targetEditPart instanceof FeatureEditPart) {
			return ((FeatureEditPart) targetEditPart).getMATypesForSource(relationshipType);
		}
		if (targetEditPart instanceof ServiceEditPart) {
			return ((ServiceEditPart) targetEditPart).getMATypesForSource(relationshipType);
		}
		if (targetEditPart instanceof NonFunctionalRequirementEditPart) {
			return ((NonFunctionalRequirementEditPart) targetEditPart).getMATypesForSource(relationshipType);
		}
		if (targetEditPart instanceof DangerEditPart) {
			return ((DangerEditPart) targetEditPart).getMATypesForSource(relationshipType);
		}
		if (targetEditPart instanceof ActorEditPart) {
			return ((ActorEditPart) targetEditPart).getMATypesForSource(relationshipType);
		}
		if (targetEditPart instanceof VariationPointEditPart) {
			return ((VariationPointEditPart) targetEditPart).getMATypesForSource(relationshipType);
		}
		if (targetEditPart instanceof VariationPointInstanceEditPart) {
			return ((VariationPointInstanceEditPart) targetEditPart).getMATypesForSource(relationshipType);
		}
		return Collections.EMPTY_LIST;
	}

	/**
	 * @generated
	 */
	public List getTypesForTarget(IAdaptable source, IElementType relationshipType) {
		IGraphicalEditPart sourceEditPart = (IGraphicalEditPart) source.getAdapter(IGraphicalEditPart.class);
		if (sourceEditPart instanceof StakeholderEditPart) {
			return ((StakeholderEditPart) sourceEditPart).getMATypesForTarget(relationshipType);
		}
		if (sourceEditPart instanceof GoalEditPart) {
			return ((GoalEditPart) sourceEditPart).getMATypesForTarget(relationshipType);
		}
		if (sourceEditPart instanceof FunctionalRequirementEditPart) {
			return ((FunctionalRequirementEditPart) sourceEditPart).getMATypesForTarget(relationshipType);
		}
		if (sourceEditPart instanceof FeatureEditPart) {
			return ((FeatureEditPart) sourceEditPart).getMATypesForTarget(relationshipType);
		}
		if (sourceEditPart instanceof ServiceEditPart) {
			return ((ServiceEditPart) sourceEditPart).getMATypesForTarget(relationshipType);
		}
		if (sourceEditPart instanceof NonFunctionalRequirementEditPart) {
			return ((NonFunctionalRequirementEditPart) sourceEditPart).getMATypesForTarget(relationshipType);
		}
		if (sourceEditPart instanceof DangerEditPart) {
			return ((DangerEditPart) sourceEditPart).getMATypesForTarget(relationshipType);
		}
		if (sourceEditPart instanceof ActorEditPart) {
			return ((ActorEditPart) sourceEditPart).getMATypesForTarget(relationshipType);
		}
		if (sourceEditPart instanceof ProceduralMitigationEditPart) {
			return ((ProceduralMitigationEditPart) sourceEditPart).getMATypesForTarget(relationshipType);
		}
		if (sourceEditPart instanceof VariationPointEditPart) {
			return ((VariationPointEditPart) sourceEditPart).getMATypesForTarget(relationshipType);
		}
		if (sourceEditPart instanceof VariationPointInstanceEditPart) {
			return ((VariationPointInstanceEditPart) sourceEditPart).getMATypesForTarget(relationshipType);
		}
		if (sourceEditPart instanceof ProductEditPart) {
			return ((ProductEditPart) sourceEditPart).getMATypesForTarget(relationshipType);
		}
		return Collections.EMPTY_LIST;
	}

	/**
	 * @generated
	 */
	public EObject selectExistingElementForSource(IAdaptable target, IElementType relationshipType) {
		return selectExistingElement(target, getTypesForSource(target, relationshipType));
	}

	/**
	 * @generated
	 */
	public EObject selectExistingElementForTarget(IAdaptable source, IElementType relationshipType) {
		return selectExistingElement(source, getTypesForTarget(source, relationshipType));
	}

	/**
	 * @generated
	 */
	protected EObject selectExistingElement(IAdaptable host, Collection types) {
		if (types.isEmpty()) {
			return null;
		}
		IGraphicalEditPart editPart = (IGraphicalEditPart) host.getAdapter(IGraphicalEditPart.class);
		if (editPart == null) {
			return null;
		}
		Diagram diagram = (Diagram) editPart.getRoot().getContents().getModel();
		Collection elements = new HashSet();
		for (Iterator it = diagram.getElement().eAllContents(); it.hasNext();) {
			EObject element = (EObject) it.next();
			if (isApplicableElement(element, types)) {
				elements.add(element);
			}
		}
		if (elements.isEmpty()) {
			return null;
		}
		return selectElement((EObject[]) elements.toArray(new EObject[elements.size()]));
	}

	/**
	 * @generated
	 */
	protected boolean isApplicableElement(EObject element, Collection types) {
		IElementType type = ElementTypeRegistry.getInstance().getElementType(element);
		return types.contains(type);
	}

	/**
	 * @generated
	 */
	protected EObject selectElement(EObject[] elements) {
		Shell shell = Display.getCurrent().getActiveShell();
		ILabelProvider labelProvider = new AdapterFactoryLabelProvider(UrmlDiagramEditorPlugin.getInstance()
			.getItemProvidersAdapterFactory());
		ElementListSelectionDialog dialog = new ElementListSelectionDialog(shell, labelProvider);
		dialog.setMessage(Messages.UrmlModelingAssistantProviderMessage);
		dialog.setTitle(Messages.UrmlModelingAssistantProviderTitle);
		dialog.setMultipleSelection(false);
		dialog.setElements(elements);
		EObject selected = null;
		if (dialog.open() == Window.OK) {
			selected = (EObject) dialog.getFirstResult();
		}
		return selected;
	}
}
