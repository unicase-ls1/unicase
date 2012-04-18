/**
 * <copyright> Copyright (c) 2009-2012 Chair of Applied Software Engineering, Technische Universität München (TUM).
 * All rights reserved. This program and the accompanying materials are made available under the terms of
 * the Eclipse Public License v1.0 which accompanies this distribution,
 * and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>
 */
package org.unicase.ui.unicasecommon.diagram.util;

import java.util.Collection;
import java.util.Set;

import org.eclipse.gef.EditPart;
import org.eclipse.gef.commands.Command;
import org.eclipse.gef.commands.CompoundCommand;
import org.eclipse.gef.commands.UnexecutableCommand;
import org.eclipse.gmf.runtime.diagram.ui.internal.commands.ToggleCanonicalModeCommand;

/**
 * @author schroech Utility class for common operations on GEF commands.
 */
@SuppressWarnings("restriction")
public final class CommandUtility {

	private CommandUtility() {
	}

	/**
	 * Adds a {@link Collection} of {@link Command}s to a {@link CompoundCommand}.
	 * 
	 * @param cc The {@link CompoundCommand} to which the {@link Command}s should be added
	 * @param commands The {@link Command}s which should be added
	 */
	public static void addCommands(CompoundCommand cc, Collection<Command> commands) {
		for (Command command : commands) {
			cc.add(command);
		}
	}

	/**
	 * Returns the simplest form of this Command that is equivalent. If the input {@link CompoundCommand} does not
	 * contain any commands, returns null instead of {@link UnexecutableCommand}.
	 * 
	 * @param cc The {@link CompoundCommand} to unwrap
	 * @return The simplest equivalent form of the input command
	 */
	public static Command safeUnwrap(CompoundCommand cc) {
		Command unwrappedCommand = cc.unwrap();
		if (unwrappedCommand != UnexecutableCommand.INSTANCE) {
			return unwrappedCommand;
		} else {
			return null;
		}
	}

	/**
	 * @param command The {@link Command} which should be wrapped in ToggleCanonicalModeCommands
	 * @param editParts The {@link EditPart}s whose CanonicalEditPolicies should be disabled
	 * @return A compound command containing the toggle commands and the input command
	 */
	public static Command wrapInToggleCanonicalModeCommands(Command command, Set<? extends EditPart> editParts) {
		CompoundCommand wrappingCompoundCommand = new CompoundCommand("");
		CompoundCommand enableCommands = new CompoundCommand("Disable canonical mode");
		CompoundCommand disableCommands = new CompoundCommand("Disable canonical mode");

		for (EditPart editPart : editParts) {
			ToggleCanonicalModeCommand disableCanonicalAssociation = new ToggleCanonicalModeCommand(editPart, false);
			disableCommands.add(disableCanonicalAssociation);

			ToggleCanonicalModeCommand enableCanonicalAssociation = ToggleCanonicalModeCommand
				.getToggleCanonicalModeCommand(disableCanonicalAssociation, true);
			enableCommands.add(enableCanonicalAssociation);
		}

		wrappingCompoundCommand.add(disableCommands.unwrap());
		wrappingCompoundCommand.add(command);
		wrappingCompoundCommand.add(enableCommands.unwrap());

		return wrappingCompoundCommand.unwrap();
	}

	/**
	 * @param command The command to be stripped
	 * @return The stripped command
	 */
	public static Command stripToggleCanonicalModeCommands(Command command) {
		if (command instanceof ToggleCanonicalModeCommand) {
			return null;
		}

		if (command instanceof CompoundCommand) {
			CompoundCommand compoundCommand = new CompoundCommand(command.getLabel());
			Object[] commands = ((CompoundCommand) command).getChildren();
			for (Object currentCommand : commands) {
				if (currentCommand instanceof Command) {
					Command strippedCommand = stripToggleCanonicalModeCommands((Command) currentCommand);
					compoundCommand.add(strippedCommand);
				}
			}
			return CommandUtility.safeUnwrap(compoundCommand);
		}

		return command;
	}
}
