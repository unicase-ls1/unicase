/**
 * <copyright> Copyright (c) 2008-2009 Jonas Helming, Maximilian Koegel. All rights reserved. This program and the
 * accompanying materials are made available under the terms of the Eclipse Public License v1.0 which accompanies this
 * distribution, and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>
 */
package org.unicase.ui.navigator.handler;

import org.eclipse.core.commands.AbstractHandler;
import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.commands.ExecutionException;
import org.eclipse.core.commands.IHandler;
import org.eclipse.emf.ecore.EClass;
import org.unicase.metamodel.ModelElement;

/**
 * @author Hodaie This is the handler for createME command (org.unicase.ui.navigator.createME). This command is just a
 *         command definition with a parameter. This command is not shown itself in the context menu. In
 *         DynamicMECreationCommands class the actually required command to create a Model element are created and
 *         assigned the ID of this generic createME command. When the user selects one of these commands this handler is
 *         executed. The generic createME command gets an EClass as parameter, and the handler creates a ModelElement of
 *         this EClass, adds it to the selected LeafSection and opens it for editing.
 */
public class CreateMEHandler extends AbstractHandler implements IHandler {

	/**
	 * The Id for EClass parameter to command. A model element of this EClass type is created in this handler.
	 */
	public static final String COMMAND_ECLASS_PARAM = "org.unicase.ui.navigator.eClassParameter";

	/**
	 * The Id for DiagramType parameter to command. A diagram of this type is created in the handler.
	 */
	public static final String COMMAND_DIAGRAMTYPE_PARAM = "org.unicase.ui.navigator.diagramTypeParameter";

	/**
	 * . ({@inheritDoc})
	 */
	public Object execute(ExecutionEvent event) throws ExecutionException {

		// get the command parameter (EClass)
		Object o = event.getObjectParameterForExecution(COMMAND_ECLASS_PARAM);
		if (o instanceof EClass) {
			EClass newMEType = (EClass) o;
			@SuppressWarnings("unused")
			final ModelElement newMEInstance;
			// create a new model element from this EClass
			newMEInstance = (ModelElement) newMEType.getEPackage().getEFactoryInstance().create(newMEType);

		}

		// TODO: add this newly created model element somewhere

		return null;

	}

}
