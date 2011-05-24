package org.unicase.changetracking.test.commands;

import org.eclipse.core.commands.ExecutionEvent;
import org.unicase.changetracking.test.cases.PushTest;
import org.unicase.changetracking.test.cases.SelectivePullTest;
import org.unicase.changetracking.ui.commands.ChangeTrackingCommandHandler;

public class TestCommand extends ChangeTrackingCommandHandler{

	@Override
	protected void doExecute(ExecutionEvent event) {
		try {
			new SelectivePullTest().test();
			//new PushTest().test();
		} catch (Exception e) {
			e.printStackTrace();
			abortCausedByException(e);
		}
	}

}
