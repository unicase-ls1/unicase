package org.unicase.changetracking.ui.releases;

import java.lang.reflect.InvocationTargetException;
import java.util.List;

import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.egit.ui.internal.EgitUiEditorUtils;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.jface.operation.IRunnableWithProgress;
import org.eclipse.jgit.lib.Ref;
import org.eclipse.jgit.lib.Repository;
import org.eclipse.jgit.revwalk.RevCommit;
import org.eclipse.jgit.transport.CredentialsProvider;
import org.eclipse.ui.PlatformUI;
import org.unicase.changetracking.git.SayYesCredentialsProvider;
import org.unicase.changetracking.git.Test;
import org.unicase.changetracking.git.commands.GitBuildReleaseCommand;
import org.unicase.changetracking.git.commands.GitCreateChangePackageCommand;
import org.unicase.changetracking.ui.UIUtil;
import org.unicase.metamodel.Project;
import org.unicase.metamodel.util.ModelUtil;
import org.unicase.model.UnicaseModelElement;
import org.unicase.model.changetracking.ChangeTrackingRelease;
import org.unicase.model.changetracking.git.GitRepository;
import org.unicase.model.task.WorkItem;
import org.unicase.workspace.util.UnicaseCommand;
import org.unicase.workspace.util.WorkspaceUtil;

public class BuildReleaseOperation implements IRunnableWithProgress{


	private ChangeTrackingRelease release;
	private Repository localRepo;
	private Ref baseBranch;
	private List<Ref> branchesToMerge;
	private String tagName;



	public BuildReleaseOperation(ChangeTrackingRelease release, Repository localRepo, Ref baseBranch, List<Ref> branchesToMerge, String tagName){
		this.release = release;
		this.localRepo = localRepo;
		this.baseBranch = baseBranch;
		this.branchesToMerge = branchesToMerge;
		this.tagName = tagName;
	}
	


	@Override
	public void run(IProgressMonitor monitor) {

		try{
			new GitBuildReleaseCommand(release, localRepo, baseBranch, branchesToMerge, tagName).run(monitor);
		} catch (Throwable t){
			ModelUtil.logException(t);
			return;
		}
		monitor.done();
	}

}
