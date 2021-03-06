/**
 * <copyright> Copyright (c) 2008-2009 Jonas Helming, Maximilian Koegel. All rights reserved. This program and the
 * accompanying materials are made available under the terms of the Eclipse Public License v1.0 which accompanies this
 * distribution, and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>
 */

package org.unicase.projectgenerator;

import org.eclipse.core.commands.AbstractHandler;
import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.commands.ExecutionException;
import org.eclipse.core.commands.IHandler;
import org.eclipse.emf.ecore.EObject;
import org.unicase.metamodel.util.ModelUtil;
import org.unicase.model.document.CompositeSection;
import org.unicase.model.document.DocumentFactory;
import org.unicase.model.document.LeafSection;
import org.unicase.model.task.ActionItem;
import org.unicase.model.task.Milestone;
import org.unicase.model.task.TaskFactory;
import org.unicase.model.task.WorkPackage;
import org.unicase.ui.util.ActionHelper;
import org.unicase.workspace.ProjectSpace;
import org.unicase.workspace.util.UnicaseCommand;

public class BigProjectHandler extends AbstractHandler implements IHandler {

	public Object execute(ExecutionEvent event) throws ExecutionException {
		EObject modelElement = ActionHelper.getSelectedModelelement();
		final ProjectSpace projectSpace = (ProjectSpace) ModelUtil.getParent(ProjectSpace.class, modelElement);

		new UnicaseCommand() {
			@Override
			protected void doRun() {
				for (int i = 0; i < 100; i++) {
					CompositeSection createCompositeSection = DocumentFactory.eINSTANCE.createCompositeSection();
					projectSpace.getProject().addModelElement(createCompositeSection);

					for (int p = 0; p < 5; p++) {
						LeafSection createLeafSection = DocumentFactory.eINSTANCE.createLeafSection();
						createCompositeSection.getSubsections().add(createLeafSection);
						for (int q = 0; q < 3; q++) {
							LeafSection createLeafSectionLevel3 = DocumentFactory.eINSTANCE.createLeafSection();
							createLeafSection.getModelElements().add(createLeafSectionLevel3);
							ActionItem createActionItem = TaskFactory.eINSTANCE.createActionItem();
							createLeafSectionLevel3.getModelElements().add(createActionItem);
						}
					}

					LeafSection createLeafSection2 = DocumentFactory.eINSTANCE.createLeafSection();
					createCompositeSection.getSubsections().add(createLeafSection2);

					for (int j = 0; j < 5; j++) {
						ActionItem createActionItem = TaskFactory.eINSTANCE.createActionItem();
						createLeafSection2.getModelElements().add(createActionItem);
					}
					for (int m = 0; m < 5; m++) {
						WorkPackage createWorkPackage = TaskFactory.eINSTANCE.createWorkPackage();
						createLeafSection2.getModelElements().add(createWorkPackage);
					}

					for (int n = 0; n < 5; n++) {
						Milestone createMilestone = TaskFactory.eINSTANCE.createMilestone();
						createLeafSection2.getModelElements().add(createMilestone);
					}
				}
			}

		}.run(false);
		return null;
	}
}
