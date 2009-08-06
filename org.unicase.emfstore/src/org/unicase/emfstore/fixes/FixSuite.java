package org.unicase.emfstore.fixes;

import java.util.ArrayList;
import java.util.List;

import org.unicase.emfstore.esmodel.ProjectHistory;
import org.unicase.emfstore.esmodel.ServerSpace;

public class FixSuite {

	private ServerSpace serverSpace;

	List<AbstractFix> fixes;

	public FixSuite(ServerSpace serverSpace) {
		this.serverSpace = serverSpace;
		fixes = new ArrayList<AbstractFix>();

		// fixes.add(new LogmessageFix());
		// fixes.add(new FalseDeleteFix());
		// fixes.add(new EndDateToDueDateFix());
		// fixes.add(new MeetingCreationFix());
		// fixes.add(new ManualDeleteFix());
		// fixes.add(new AddChangeOperationFix());
		// fixes.add(new ConvertNewOperation());
		// fixes.add(new FindChanges());
		// fixes.add(new CopyProjectTest());
		// fixes.add(new DuplicateUseCaseFix());
		// fixes.add(new CheckCommentsFix());
		fixes.add(new CheckChanges());
		// fixes.add(new NullifyProjectTailFix());
		// fixes.add(new VersionConnectionFix());
	}

	public void fix(String projectId) {
		System.out.println("\n PROJECT FIXING for project: " + projectId + " \n");
		for (ProjectHistory history : serverSpace.getProjects()) {
			if (history.getProjectId().getId().equals(projectId)) {
				fix(history);
				break;
			}
		}
	}

	private void fix(ProjectHistory history) {
		for (AbstractFix fix : fixes) {
			System.out.println("Running fix: " + fix.getFixName());
			fix.runFix(history);
			System.out.println("");
		}
		System.out.println("EXIT AFTER FIXING");
		System.exit(0);
	}
}
