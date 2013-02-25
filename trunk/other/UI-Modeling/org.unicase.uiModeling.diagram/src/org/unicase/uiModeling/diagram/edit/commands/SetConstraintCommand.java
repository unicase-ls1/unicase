package org.unicase.uiModeling.diagram.edit.commands;

import org.eclipse.core.commands.ExecutionException;
import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.draw2d.geometry.Dimension;
import org.eclipse.draw2d.geometry.Point;
import org.eclipse.emf.transaction.util.TransactionUtil;
import org.eclipse.gmf.runtime.common.core.command.CommandResult;
import org.eclipse.gmf.runtime.diagram.core.util.ViewUtil;
import org.eclipse.gmf.runtime.emf.commands.core.command.AbstractTransactionalCommand;
import org.eclipse.gmf.runtime.notation.NotationPackage;
import org.eclipse.gmf.runtime.notation.View;

public class SetConstraintCommand extends AbstractTransactionalCommand {

	private View view;
	private Point location;
	private Dimension size;

	public SetConstraintCommand(View view, Point location, Dimension size) {
		super(TransactionUtil.getEditingDomain(view), "Set View Constraints", null);
		this.view = view;
		this.location = location;
		this.size = size;
	}

	@Override
	protected CommandResult doExecuteWithResult(IProgressMonitor monitor, IAdaptable info) throws ExecutionException {
		ViewUtil.setStructuralFeatureValue(view, NotationPackage.eINSTANCE.getLocation_X(), location.x);
		ViewUtil.setStructuralFeatureValue(view, NotationPackage.eINSTANCE.getLocation_Y(), location.y);
		ViewUtil.setStructuralFeatureValue(view, NotationPackage.eINSTANCE.getSize_Width(), size.width);
		ViewUtil.setStructuralFeatureValue(view, NotationPackage.eINSTANCE.getSize_Height(), size.height);

		return CommandResult.newOKCommandResult();
	}

}
