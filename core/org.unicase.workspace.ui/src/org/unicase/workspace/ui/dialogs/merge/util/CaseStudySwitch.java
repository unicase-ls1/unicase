package org.unicase.workspace.ui.dialogs.merge.util;

import java.util.List;

import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.swt.widgets.Display;
import org.unicase.emfstore.esmodel.versioning.ChangePackage;
import org.unicase.emfstore.esmodel.versioning.operations.AbstractOperation;
import org.unicase.emfstore.esmodel.versioning.operations.CompositeOperation;

public class CaseStudySwitch {

	public void flattenChangePackages(ChangePackage myChangePackage,
			List<ChangePackage> theirChangePackages) {
		boolean openQuestion = MessageDialog
				.openQuestion(Display.getCurrent().getActiveShell(),
						"Remove CompositeOperations?",
						"Do you want to remove the composite operations for testing purposes?");

		if (!openQuestion) {
			return;
		}

		if (myChangePackage != null) {
			flattenComposites(myChangePackage.getOperations());
		}
		for (ChangePackage cp : theirChangePackages) {
			flattenComposites(cp.getOperations());
		}
	}

	private void flattenComposites(List<AbstractOperation> operations) {
		for (int i = 0; i < operations.size(); i++) {
			AbstractOperation abstractOperation = operations.get(i);
			if (DecisionUtil.isComposite(abstractOperation)) {
				operations.remove(i);
				CompositeOperation composite = (CompositeOperation) abstractOperation;
				operations.addAll(i, composite.getSubOperations());
				// for (AbstractOperation subOp : composite.getSubOperations())
				// {
				// }
			}
		}
	}

}
