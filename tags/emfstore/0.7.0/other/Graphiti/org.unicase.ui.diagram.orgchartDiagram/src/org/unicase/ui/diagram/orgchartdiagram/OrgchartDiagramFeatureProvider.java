package org.unicase.ui.diagram.orgchartdiagram;

import org.eclipse.emf.ecore.EReference;
import org.eclipse.graphiti.dt.IDiagramTypeProvider;
import org.eclipse.graphiti.features.IAddFeature;
import org.eclipse.graphiti.features.ICreateConnectionFeature;
import org.eclipse.graphiti.features.ICreateFeature;
import org.eclipse.graphiti.features.IDirectEditingFeature;
import org.eclipse.graphiti.features.IUpdateFeature;
import org.eclipse.graphiti.features.context.IAddContext;
import org.eclipse.graphiti.features.context.IDirectEditingContext;
import org.eclipse.graphiti.features.context.IUpdateContext;
import org.eclipse.graphiti.mm.pictograms.ContainerShape;
import org.eclipse.graphiti.mm.pictograms.PictogramElement;
import org.eclipse.graphiti.ui.features.DefaultFeatureProvider;
import org.unicase.model.organization.OrgUnit;
import org.unicase.ui.diagram.orgchartdiagram.features.GroupCreateFeature;
import org.unicase.ui.diagram.orgchartdiagram.features.OrgUnitAddFeature;
import org.unicase.ui.diagram.orgchartdiagram.features.OrgUnitDirectEditingFeature;
import org.unicase.ui.diagram.orgchartdiagram.features.OrgunitsReferenceAddFeature;
import org.unicase.ui.diagram.orgchartdiagram.features.OrgunitsReferenceCreateFeature;
import org.unicase.ui.diagram.orgchartdiagram.features.UpdateOrgUnitFeature;
import org.unicase.ui.diagram.orgchartdiagram.features.UserCreateFeature;

public class OrgchartDiagramFeatureProvider extends DefaultFeatureProvider {

	public OrgchartDiagramFeatureProvider(
			IDiagramTypeProvider diagramTypeProvider) {
		super(diagramTypeProvider);
	}

	public IAddFeature getAddFeature(IAddContext context) {
		if (context.getNewObject() instanceof OrgUnit) {
			return new OrgUnitAddFeature(this);
		} else if (context.getNewObject() instanceof EReference) {
			return new OrgunitsReferenceAddFeature(this);
		}
		return super.getAddFeature(context);
	}

	@Override
	public ICreateConnectionFeature[] getCreateConnectionFeatures() {
		return new ICreateConnectionFeature[] { new OrgunitsReferenceCreateFeature(
				this) };

	}

	@Override
	public ICreateFeature[] getCreateFeatures() {
		return new ICreateFeature[] { new UserCreateFeature(this),
				new GroupCreateFeature(this) };

	}

	@Override
	public IDirectEditingFeature getDirectEditingFeature(
			IDirectEditingContext context) {
		PictogramElement pe = context.getPictogramElement();
		Object bo = getBusinessObjectForPictogramElement(pe);
		if (bo instanceof OrgUnit) {
			return new OrgUnitDirectEditingFeature(this);
		}
		return super.getDirectEditingFeature(context);
	}

	@Override
	public IUpdateFeature getUpdateFeature(IUpdateContext context) {
		PictogramElement pictogramElement = context.getPictogramElement();
		if (pictogramElement instanceof ContainerShape) {
			Object bo = getBusinessObjectForPictogramElement(pictogramElement);
			if (bo instanceof OrgUnit) {
				return new UpdateOrgUnitFeature(this);
			}

		}

		
		return super.getUpdateFeature(context);

	}

}
