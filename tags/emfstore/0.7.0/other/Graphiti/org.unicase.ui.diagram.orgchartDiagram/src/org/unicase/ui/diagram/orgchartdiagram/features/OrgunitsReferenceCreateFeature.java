package org.unicase.ui.diagram.orgchartdiagram.features;

import org.eclipse.emf.ecore.EReference;
import org.eclipse.graphiti.features.context.ICreateConnectionContext;
import org.eclipse.graphiti.features.context.impl.AddConnectionContext;
import org.eclipse.graphiti.features.impl.AbstractCreateConnectionFeature;
import org.eclipse.graphiti.mm.pictograms.Anchor;
import org.eclipse.graphiti.mm.pictograms.Connection;
import org.unicase.model.organization.Group;
import org.unicase.model.organization.OrgUnit;
import org.unicase.model.organization.OrganizationPackage;
import org.unicase.ui.diagram.orgchartdiagram.OrgchartDiagramFeatureProvider;
import org.unicase.workspace.util.UnicaseCommand;

public class OrgunitsReferenceCreateFeature extends
		AbstractCreateConnectionFeature {

	

	public OrgunitsReferenceCreateFeature(OrgchartDiagramFeatureProvider fp) {
		super(fp, "GroupOrgunits", "Create group orgunits reference");
	}

	public boolean canCreate(ICreateConnectionContext context) {
		// return true if both anchors belong to an EClass
		// and those EClasses are not identical
		OrgUnit source = getOrgUnit(context.getSourceAnchor());
		OrgUnit target = getOrgUnit(context.getTargetAnchor());
		if (source != null && target != null && source != target && source instanceof Group) {
			return true;
		}
		return false;

	}

	public boolean canStartConnection(ICreateConnectionContext context) {
		// return true if start anchor belongs to a EClass
		if (getOrgUnit(context.getSourceAnchor()) instanceof Group) {
			return true;
		}
		return false;
	}

	public Connection create(ICreateConnectionContext context) {
		Connection newConnection = null;
		// get EClasses which should be connected
		OrgUnit source = getOrgUnit(context.getSourceAnchor());
		OrgUnit target = getOrgUnit(context.getTargetAnchor());
		if (source != null && target != null && source instanceof Group) {
			// create new business object
			EReference eReference = createEReference(source, target);
			// add connection for business object
			AddConnectionContext addContext = new AddConnectionContext(context.getSourceAnchor(), context.getTargetAnchor());
			addContext.setNewObject(eReference);
			newConnection = (Connection) getFeatureProvider().addIfPossible(addContext);
		}
		return newConnection;
	}

	/**
	 * 
	 * Returns the EClass belonging to the anchor, or null if not available.
	 */

	private OrgUnit getOrgUnit(Anchor anchor) {
		if (anchor != null) {
			Object object = getBusinessObjectForPictogramElement(anchor.getParent());
			if (object instanceof OrgUnit) {
				return (OrgUnit) object;
			}
		}
		return null;
	}

	/**
	 * 
	 * Creates a EReference between two EClasses.
	 */
	private EReference createEReference(OrgUnit source, final OrgUnit target) {
		final Group group = (Group)source;
		new UnicaseCommand() {
			
			@Override
			protected void doRun() {
				group.getOrgUnits().add(target);
			}
		}.run();

		return OrganizationPackage.eINSTANCE.getGroup_OrgUnits();

	}


}
