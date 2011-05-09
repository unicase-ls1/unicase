package org.unicase.ui.diagram.orgchartdiagram;

import org.eclipse.graphiti.dt.AbstractDiagramTypeProvider;

public class OrgchartDiagramTypeProvider extends AbstractDiagramTypeProvider {

	public OrgchartDiagramTypeProvider() {
		super();
		setFeatureProvider(new OrgchartDiagramFeatureProvider(this));
	}

}
