package org.unicase.codetrace.ui;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.jface.window.Window;
import org.unicase.metamodel.ModelElement;
import org.unicase.metamodel.Project;
import org.unicase.metamodel.provider.ShortLabelProvider;
import org.unicase.model.UnicaseModelElement;
import org.unicase.workspace.ProjectSpace;
import org.unicase.workspace.WorkspaceManager;

public class AttachCodeLocation {

	private static Project getActiveProject() {
		final ProjectSpace ps = WorkspaceManager.getInstance()
				.getCurrentWorkspace().getActiveProjectSpace();
		if (ps.getProject() != null) {
			return ps.getProject();
		} else {
			System.out.println("Project was not found!");
			return null;
		}

	}

	public static UnicaseModelElement showUserDialog() {

		//ShortLabelProvider shortLabelProvider = new ShortLabelProvider();
		ChooseModelElementDialog cmed = new ChooseModelElementDialog(
				getActiveProject(), "Choose Model Element for code location!");
		if (cmed.open() == Window.OK) {
			Object[] result = cmed.getResult();

			if (result.length > 0) {
				for (Object o : result) {
					if (o instanceof UnicaseModelElement ) {
						return (UnicaseModelElement)o;
					}
				}
			}
		}
		
		return null;

	}
}
