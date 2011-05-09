package org.unicase.changetracking.commands;

import org.unicase.model.changetracking.Stream;

public abstract class CreateStreamCommand extends ChangeTrackingCommand {

	public abstract Stream getCreatedStream();
}
