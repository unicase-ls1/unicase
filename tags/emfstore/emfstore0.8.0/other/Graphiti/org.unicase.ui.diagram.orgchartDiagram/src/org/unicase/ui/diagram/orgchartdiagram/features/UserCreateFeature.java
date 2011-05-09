package org.unicase.ui.diagram.orgchartdiagram.features;

import org.eclipse.graphiti.features.IFeatureProvider;
import org.eclipse.graphiti.features.context.ICreateContext;
import org.eclipse.graphiti.features.impl.AbstractCreateFeature;
import org.eclipse.graphiti.mm.pictograms.Diagram;
import org.unicase.model.organization.OrganizationFactory;
import org.unicase.model.organization.User;
import org.unicase.workspace.WorkspaceManager;
import org.unicase.workspace.util.UnicaseCommand;

public class UserCreateFeature extends AbstractCreateFeature {

	public UserCreateFeature(IFeatureProvider fp) {
		super(fp, "User", "Create User");
	}

	public boolean canCreate(ICreateContext context) {
		return context.getTargetContainer() instanceof Diagram;
	}

	public Object[] create(ICreateContext context) {
		// create user
		final User newUser = OrganizationFactory.eINSTANCE.createUser();
		// Add model element to resource.
		// We add the model element to the resource of the diagram for
		// simplicity's sake. Normally, a customer would use its own
		// model persistence layer for storing the business model separately.
		new UnicaseCommand() {
			
			@Override
			protected void doRun() {
				WorkspaceManager.getInstance().getCurrentWorkspace().getActiveProjectSpace().getProject().addModelElement(newUser);
			}
		}.run();

		// do the add
		addGraphicalRepresentation(context, newUser);
		// activate direct editing after object creation
		getFeatureProvider().getDirectEditingInfo().setActive(true);
		// return newly created business object(s)
		return new Object[] { newUser };
	}

}
