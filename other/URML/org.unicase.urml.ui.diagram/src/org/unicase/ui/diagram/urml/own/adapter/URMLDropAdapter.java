package org.unicase.ui.diagram.urml.own.adapter;

import java.util.List;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.swt.dnd.DropTargetEvent;
import org.unicase.metamodel.ModelElement;
import org.unicase.model.urml.URMLDiagram;
import org.unicase.model.urml.UrmlModelElement;
import org.unicase.model.urml.UrmlPackage;
import org.unicase.ui.common.dnd.MEDropAdapter;
import org.unicase.ui.unicasecommon.UnicaseActionHelper;
import org.unicase.workspace.util.UnicaseCommand;

public class URMLDropAdapter extends MEDropAdapter {
	@Override
	public EClass isDropAdapterfor() {
		return UrmlPackage.eINSTANCE.getURMLDiagram();
	}

	@Override
	public void drop(DropTargetEvent event, final ModelElement target, List<ModelElement> source) {
		final UrmlModelElement dropee = (UrmlModelElement) source.get(0);
		new UnicaseCommand() {
			@Override
			protected void doRun() {
				((URMLDiagram) target).getElements().add(dropee);
			}
		}.run();
		UnicaseActionHelper.openModelElement(target, this.getClass().getName());
	}
}
